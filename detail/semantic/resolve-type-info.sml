
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
    
      fun vDecl (s, d) =
         case d of
            AST.MARKdecl {span, tree} => vDecl (span, tree)
          | AST.TYPEdecl (v, t) => synTable := S.insert (!synTable, v, vType (s,t))
          | AST.DATATYPEdecl (d,l) =>
               (dtyTable :=
                  D.insert
                     (!dtyTable,
                      d,
                      {tdVars=[], tdCons=vCondecl (s,d,l)}))
          | _ => ()

      and vType (s, t) =
         case t of
            AST.MARKty {span, tree} => vType (span,tree)
          | AST.BITty i => T.VEC (T.CONST (IntInf.toInt i))
          | AST.NAMEDty n =>
               (case S.find (!synTable, n) of
                  SOME t => T.SYN (n, T.setFlagsToTop t)
                | NONE => T.ALG (n, []))
          | AST.RECORDty l =>
               T.RECORD
                  (Types.freshTVar (), BD.freshBVar (),
                  List.foldl Substitutions.insertField []
                     (List.map (vField s) l))

      and vField s (n, ty) =
         T.RField {name=n, fty=vType (s, ty), exists=BD.freshBVar ()}

      and vCondecl (s,d,l) =
         case l of
            [] => SymMap.empty : Types.condescr
          | (c, arg)::l =>
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
                     ;D.insert
                        (vCondecl (s,d,l),
                         c,
                         Option.map (fn t => vType (s, t)) arg))

       val {span=s, tree=declList} = ast

   in
      (app (fn d => vDecl (s,d)) declList
      ;{tsynDefs= !synTable, typeDefs= !dtyTable, conParents= !conTable} : type_info)
   end

   val resolveTypeInfoPass =
      BasicControl.mkTracePassSimple
         {passName="resolveTypeInfoPass",
          pass=resolveTypeInfoPass}

   fun run spec = let
      open CompilationMonad
   in
      getErrorStream >>= (fn errs =>
      return (resolveTypeInfoPass (errs, spec)))
   end
end
