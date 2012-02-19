structure ResolveTypeInfo : sig

  type SynonymMap = Types.tExp SymMap.map
  type DatatypeMap = Types.typedescr SymMap.map
  type ConstructorMap = TypeInfo.symid SymMap.map
  
  val resolveTypeInfo : (Error.err_stream *
        {ast: SpecAbstractTree.specification,
         vars: VarInfo.table,
         cons: ConInfo.table,
         types: TypeInfo.table,
         fields: FieldInfo.table }) ->

        {ast: SpecAbstractTree.specification,
         vars: VarInfo.table,
         cons: ConInfo.table,
         types: TypeInfo.table,
         fields: FieldInfo.table,
         tsynDefs: SynonymMap,
         typeDefs: DatatypeMap,
         conParents: ConstructorMap }
         
end = struct
  
  type SynonymMap = Types.tExp SymMap.map
  type DatatypeMap = Types.typedescr SymMap.map
  type ConstructorMap = TypeInfo.symid SymMap.map

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
  
  fun resolveTypeInfo (errStrm, {ast, vars, cons, types, fields}) = let
    val synTable = ref (S.empty : SynonymMap)
    val dtyTable = ref (D.empty : DatatypeMap)
    val conTable = ref (C.empty : ConstructorMap)
  
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
      | vType (s, AST.BITty i) = T.TExpVec (T.TExpConst i)
      | vType (s, AST.NAMEDty n) =
          T.TExpSyn (n, S.lookup (!synTable, n))
      | vType (s, AST.RECty l) = T.TExpRec (List.map (vField s) l)
    and vField s (n, ty) = T.RField { fieldName = n, fieldType = vType (s, ty) }
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
      { ast = ast, vars = vars, cons = cons, types = types, fields = fields,
        tsynDefs = !synTable, typeDefs = !dtyTable, conParents = !conTable })
  end
end