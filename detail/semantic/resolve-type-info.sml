
structure ResolveTypeInfo : sig

   type synonym_map = Types.texp SymMap.map
   type datatype_map = Types.typedescr SymMap.map
   type constructor_map = TypeInfo.symid SymMap.map
  
   type type_info =
      {tsynDefs: synonym_map,
       typeDefs: datatype_map,
       conParents: constructor_map}

   val resolveTypeInfoPass: (Error.err_stream * SpecAbstractTree.specification) -> type_info
   val run: SpecAbstractTree.specification -> type_info CompilationMonad.t
end = struct

   structure AST = SpecAbstractTree
   structure S = SymMap
   structure D = SymMap
   structure C = SymMap
   structure V = SymMap
   structure T = Types
   structure BD = BooleanDomain

   infix >>= >>

   type synonym_map = Types.texp SymMap.map
   type datatype_map = Types.typedescr SymMap.map
   type constructor_map = TypeInfo.symid SymMap.map

   type type_info =
      {tsynDefs: synonym_map,
       typeDefs: datatype_map,
       conParents: constructor_map}

   fun typeInfoToString ({tsynDefs,typeDefs = tdm,conParents = cm} : type_info) =
      let
         fun showTd (d, {tdVars = varMap, tdCons = cons}) =
            let
               val dStr = TypeInfo.getString (!SymbolTables.typeTable, d)
               val (args,_,si) = List.foldl (fn ((v,tVar),(str,sep,si)) =>
                  let
                     val vStr = TypeInfo.getString (!SymbolTables.typeTable,v)
                     val (tStr, si) = T.showTypeSI (T.VAR tVar, si)
                  in
                     (vStr ^ "=" ^ tStr ^ sep ^ str, ",", si)
                  end) ("", "", TVar.emptyShowInfo) (V.listItemsi varMap)
               fun conInfo ((c,tOpt),(sep,si,str)) = 
                  let
                     val cStr = ConInfo.getString (!SymbolTables.conTable, c)
                     val (tStr,si) = case tOpt of
                           NONE => ("",si)
                         | SOME t => T.showTypeSI (t,si)
                  in
                     ("\n  | ", si, str ^ sep ^
                     cStr ^ (if isSome tOpt then " of " else "") ^ tStr)
                  end
               val (_,_,consStr) = List.foldl conInfo ("\n  = ",si,"")
                                    (SymMap.listItemsi cons)
            in
               "type " ^ dStr ^ "[" ^ args ^ "]" ^ consStr
            end
      in
         List.foldl (fn ((td,str)) => str ^ showTd td ^ "\n")
            "" (D.listItemsi tdm)
      end

   fun resolveTypeInfoPass (errStrm, ast) = let
      val vars = !SymbolTables.varTable
      val cons = !SymbolTables.conTable
      val types = !SymbolTables.typeTable
      val fields = !SymbolTables.fieldTable
      val synTable = ref (
         (List.foldl
            (fn ({name,ty,flow},t) => S.insert (t,TypeInfo.lookup(types,Atom.atom(name)),ty))
            S.empty
            Primitives.primitiveTypes
         ) : synonym_map)
      val dtyTable = ref (D.empty : datatype_map)
      val conTable = ref (C.empty : constructor_map)

      fun convMark conv {span, tree} = {span=span, tree=conv span tree}
    
      fun fwdDecl (s, d) =
         case d of
            AST.MARKdecl {span, tree} => fwdDecl (span, tree)
          | AST.DATATYPEdecl (d, tvars, l) =>
            let
               fun addTVar (tv, varMap) = case V.find (varMap,tv) of
                    NONE => V.insert (varMap, tv, (T.freshTVar (), BD.freshBVar ()))
                  | SOME _ => varMap
               val varMap = List.foldl addTVar (case D.find (!dtyTable,d) of
                    NONE => V.empty
                  | SOME {tdVars=varMap, tdCons} => varMap) tvars
            in
               (dtyTable := D.insert (!dtyTable, d,
                                     {tdVars=varMap, tdCons=C.empty}))
            end
          | _ => ()
      
      fun vDecl (s, d) =
         case d of
            AST.MARKdecl {span, tree} => vDecl (span, tree)
          | AST.TYPEdecl (v, t) =>
            synTable := S.insert (!synTable, v, vType V.empty (s,t))
          | AST.DATATYPEdecl (d, tvars, l) =>
            (case D.lookup (!dtyTable,d) of
               {tdVars=tvs, tdCons=cons} =>
                     (dtyTable := D.insert (!dtyTable, d,
                        {tdVars = tvs, tdCons = vCondecl cons (s,d,tvs,l)}))
            )
          | _ => ()

      and vType tvs (s, t) =
         case t of
            AST.MARKty {span, tree} => vType tvs (span,tree)
          | AST.BITty i => T.VEC (T.CONST (IntInf.toInt i))
          | AST.NAMEDty (n, args) =>
               (case S.find (!synTable, n) of
                  SOME t => T.SYN (n, t)
                | NONE => (case D.find (!dtyTable, n) of
                     SOME {tdVars=varMap,tdCons=_} =>
                        let
                           val argMap =
                              List.foldl SymMap.insert' SymMap.empty args
                           fun findType v = case SymMap.find (argMap,v) of
                                SOME t => vType tvs (s, t)
                              | NONE => case V.find (tvs,v) of
                                   SOME varPair => T.VAR varPair
                                 | NONE => (Error.errorAt
                                    (errStrm, s,
                                     ["unknown type variable ",
                                      TypeInfo.getString (types, v),
                                      " in argument "]); T.UNIT)
                        in
                           T.ALG (n, List.map findType (V.listKeys varMap))
                        end
                   | NONE => (case V.find (tvs,n) of
                        SOME varPair => T.VAR varPair
                      | NONE => (Error.errorAt
                           (errStrm, s,
                            ["type synonym or data type ",
                             TypeInfo.getString (types, n),
                             " not declared "]); T.UNIT))))
          | AST.RECORDty l =>
               T.RECORD
                  (Types.freshTVar (), BD.freshBVar (),
                  List.foldl Substitutions.insertField []
                     (List.map (vField s tvs) l))

      and vField s tvs (n, ty) =
         T.RField {name=n, fty=vType tvs (s, ty), exists=BD.freshBVar ()}

      and vCondecl sm (s,d,tvs,l) = List.foldl (fn ((c, arg), sm) =>
            (case C.find (!conTable, c) of
               SOME d =>
                  Error.errorAt
                     (errStrm, s,
                      ["constructor ",
                       Atom.toString (ConInfo.getAtom (cons,c)),
                       " already used in ",
                       Atom.toString (TypeInfo.getAtom (types,d))])
             | NONE =>
                  (conTable := C.insert (!conTable, c, d))
            ;D.insert (sm, c, Option.map (fn t => vType tvs (s, t)) arg))
         ) sm l

       val declList = ast
       val s = SymbolTable.noSpan

   in
      (app (fn d => fwdDecl (s,d)) declList
      ;app (fn d => vDecl (s,d)) declList
      ;{tsynDefs= !synTable, typeDefs= !dtyTable, conParents= !conTable} : type_info
      )
   end

   val resolveTypeInfoPass =
      BasicControl.mkKeepPass
         {passName="resolveTypeInfoPass",
          registry=BasicControl.topRegistry,
          pass=resolveTypeInfoPass,
          preExt="ast",
          preOutput=fn (os,(err,t)) => AST.PP.prettyTo(os, t),
          postExt="decl",
          postOutput=fn (os,ti) => TextIO.output (os,typeInfoToString ti)}

   fun run spec = let
      open CompilationMonad
   in
      getErrorStream >>= (fn errs =>
      return (resolveTypeInfoPass (errs, spec)))
   end
end
