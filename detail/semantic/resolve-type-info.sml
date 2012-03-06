structure ResolveTypeInfo : sig

  type synonym_map = Types.texp SymMap.map
  type datatype_map = Types.typedescr SymMap.map
  type constructor_map = TypeInfo.symid SymMap.map
  
  type type_info = {
      tsynDefs: synonym_map,
      typeDefs: datatype_map,
      conParents: constructor_map
   }

   val resolveTypeInfoPass: (Error.err_stream * SpecAbstractTree.specification) -> type_info
   val run: SpecAbstractTree.specification -> type_info CompilationMonad.t
         
end = struct

  infix >>= >>

  type synonym_map = Types.texp SymMap.map
  type datatype_map = Types.typedescr SymMap.map
  type constructor_map = TypeInfo.symid SymMap.map

  type type_info = {
      tsynDefs: synonym_map,
      typeDefs: datatype_map,
      conParents: constructor_map
   }
  (*val resolveTypeInfoPass:
      (Error.err_stream * SpecParseTree.specification) ->
         {syn: map,
          dty: int SymMap.map,
          con: TypeInfo.symid SymMap.map
         }*)

  structure AST = SpecAbstractTree
  structure S = SymMap
  structure D = SymMap
  structure C = SymMap
  structure T = Types
  structure BD = BooleanDomain
  
  fun resolveTypeInfoPass (errStrm, ast) = let
    val vars = !SymbolTables.varTable
    val cons = !SymbolTables.conTable
    val types = !SymbolTables.typeTable
    val fields = !SymbolTables.fieldTable
    val synTable = ref (S.empty : synonym_map)
    val dtyTable = ref (D.empty : datatype_map)
    val conTable = ref (C.empty : constructor_map)
  
    fun convMark conv {span, tree} = {span=span, tree=conv span tree}
    fun vDecl (s, AST.MARKdecl { span, tree }) = vDecl (span, tree)
      | vDecl (s, AST.TYPEdecl (v,t)) =
          (synTable := S.insert (!synTable, v, vType (s,t)))
      | vDecl (s, AST.DATATYPEdecl (d,l)) =
          let val typevars = [] in
            (dtyTable := D.insert (!dtyTable, d,
              { tdVars = typevars, tdCons = vCondecl (s,d,l) }))
          end
      | vDecl (s, _) = ()
    and vType (s, AST.MARKty { span, tree }) = vType (span,tree)
      | vType (s, AST.BITty i) = T.VEC (T.CONST i)
      | vType (s, AST.NAMEDty n) =
         (case S.find (!synTable, n) of
              (SOME t) => T.SYN (n, t)
            | NONE => T.ALG (n, [])
         )
      | vType (s, AST.RECty l) =
         T.RECORD (Types.freshTVar (), BD.freshBVar (), List.map (vField s) l)
    and vField s (n, ty) =
         T.RField {name = n, fty = vType (s, ty), exists = BD.freshBVar ()}
    and vCondecl (s,d, []) = SymMap.empty : Types.condescr
      | vCondecl (s,d, AST.MARKcondecl { span, tree }::l) = vCondecl (s,d,tree::l)
      | vCondecl (s,d, AST.CONdecl (c, arg)::l) =
          (case C.find (!conTable, c) of
            SOME d => Error.errorAt (errStrm, s,
                      ["constructor ", Atom.toString(ConInfo.getAtom(cons,c)),
                       " already used in ", Atom.toString(TypeInfo.getAtom(types,d))])
          | NONE => (conTable := C.insert (!conTable, c, d))
          ; D.insert (vCondecl (s,d,l), c,
                      case arg of NONE => NONE | SOME t => SOME (vType (s, t))
                     )
          )
    val { span = s, tree = declList } = ast
  in (List.map (fn d => vDecl (s,d)) declList;
      { tsynDefs = !synTable, typeDefs = !dtyTable, conParents = !conTable } : type_info)
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