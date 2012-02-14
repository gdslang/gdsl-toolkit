structure SymbolTable : sig

  (* annotate AST with symbol identifiers, return false if there were errors *)
  val resolveSymbolPass : (Error.err_stream * SpecParseTree.specification) ->
                          { ast : SpecAbstractTree.specification,
                            vars : VarInfo.Table,
                            cons : ConInfo.Table,
                            types : TypeInfo.Table }
  val resolveSymbols : SpecParseTree.specification ->
                          { ast : SpecAbstractTree.specification,
                            vars : VarInfo.Table,
                            cons : ConInfo.Table,
                            types : TypeInfo.Table }

end = struct

  fun resolveErr errStrm (pos, msg) = Error.errorAt(errStrm, (pos, pos), msg)

  val parseErr = Error.parseError SpecTokens.toString

  structure PT = SpecParseTree
  structure AST = SpecAbstractTree
  structure VT = VarInfo
  structure CT = ConInfo
  structure TT = TypeInfo

  fun convMark conv { span, tree } = { span = span, tree = conv span tree }

  exception NotImplemented
  
  fun resolveSymbolPass (errStrm, ast) = let
    val varTable = ref VarInfo.empty
    val conTable = ref ConInfo.empty
    val typeTable = ref TypeInfo.empty
    fun newVar (span, atom) = let
        val (newTable, id) = VT.create (!varTable, atom, span)
      in (varTable := newTable; id) end
      handle SymbolAlreadyDefined =>
      (Error.errorAt (errStrm, span, ["duplicate variable ", Atom.toString(atom)]); VT.badSymId)
    fun convDecl s (PT.MARKdecl m) = AST.MARKdecl (convMark convDecl m)
      | convDecl s (PT.INCLUDEdecl str) = AST.INCLUDEdecl str
      | convDecl s (PT.GRANULARITYdecl i) = AST.GRANULARITYdecl i
      | convDecl s (PT.STATEdecl l) = AST.STATEdecl
        (List.map (fn (v,t,e) => (newVar (s,v), convType s t, convExpr s e)) l)
    and convType _ = raise NotImplemented
    and convExpr _ = raise NotImplemented
  in
    { ast = convMark (fn s => List.map (convDecl s)) ast,
      vars = !varTable,
      cons = !conTable,
      types = !typeTable }
  end

  fun resolveSymbols ast = let
    val ers = Error.mkErrStream "(no file)"
  in
    resolveSymbolPass (ers, ast)
       before
          (Error.report (TextIO.stdErr, ers))
  end
end
