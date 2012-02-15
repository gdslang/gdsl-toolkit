structure SymbolTable : sig

   (* annotate AST with symbol identifiers, return false if there were errors *)
   val resolveSymbolPass:
      (Error.err_stream * SpecParseTree.specification) ->
         {ast: SpecAbstractTree.specification,
          vars: VarInfo.table,
          cons: ConInfo.table,
          types: TypeInfo.table,
          tsyns: TSynInfo.table,
          fields: FieldInfo.table}

   val resolveSymbols:
      SpecParseTree.specification ->
         {ast: SpecAbstractTree.specification,
          vars: VarInfo.table,
          cons: ConInfo.table,
          types: TypeInfo.table,
          tsyns: TSynInfo.table,
          fields: FieldInfo.table}

end = struct

  structure PT = SpecParseTree
  structure AST = SpecAbstractTree
  structure VI = VarInfo
  structure FI = FieldInfo
  structure CI = ConInfo
  structure TI = TypeInfo
  structure SI = TSynInfo

  exception NotImplemented

  fun resolveErr errStrm (pos, msg) = Error.errorAt(errStrm, (pos, pos), msg)

  val parseErr = Error.parseError SpecTokens.toString

  fun convMark conv {span, tree} = {span=span, tree=conv span tree}

  fun resolveSymbolPass (errStrm, ast) = let
    val varTable = ref VarInfo.empty
    val conTable = ref ConInfo.empty
    val typeTable = ref TypeInfo.empty
    val tSynTable = ref TSynInfo.empty
    val fieldTable = ref FieldInfo.empty
    
    fun newSym (table, create, lookup, str) (span, atom) =
      let val (newTable, id) = create (!table, atom, span)
      in (table := newTable; id) end
      handle SymbolAlreadyDefined =>
        (Error.errorAt
           (errStrm,
            span,
            ["duplicate " ^ str ^ " declaration ",
             Atom.toString(atom)])
        ; let val (SOME id) = lookup (!table, atom) in id end)

    val newVar = newSym (varTable, VI.create, VI.lookup, "variable")
    val newCon = newSym (conTable, CI.create, CI.lookup, "constructor")
    val newType = newSym (typeTable, TI.create, TI.lookup, "type")
    val newTSyn = newSym (tSynTable, SI.create, SI.lookup, "type synonym")
    fun newField (span, atom) =
      let val (newTable, id) = FI.create (!fieldTable, atom, span)
      in (fieldTable := newTable; id) end
      handle SymbolAlreadyDefined =>
        let val (SOME id) = FI.lookup (!fieldTable, atom) in id end

    fun useSym (table, badSymId, lookup, str) (_,{ tree=atom, span}) =
      case lookup (!table, atom)
        of (SOME id) => id
        | NONE => (Error.errorAt
             (errStrm,
              span,
              ["the " ^ str ^ Atom.toString(atom) ^ " is not defined "]);
           badSymId)
    val useVar = useSym (varTable, VI.badSymId, VI.lookup, "variable")
    val useCon = useSym (conTable, CI.badSymId, CI.lookup, "constructor")
    val useType = useSym (typeTable, TI.badSymId, TI.lookup, "type")
    val useTSyn = useSym (tSynTable, SI.badSymId, SI.lookup, "type synonym")
    fun useField (_, { tree=atom, span}) =
      let val (newTable, id) = FI.create (!fieldTable, atom, span)
      in (fieldTable := newTable; id) end
      handle SymbolAlreadyDefined =>
        let val (SOME id) = FI.lookup (!fieldTable, atom) in id end

    fun convDecl s (PT.MARKdecl m) = AST.MARKdecl (convMark convDecl m)
      | convDecl s (PT.INCLUDEdecl str) = AST.INCLUDEdecl str
      | convDecl s (PT.GRANULARITYdecl i) = AST.GRANULARITYdecl i
      | convDecl s (PT.STATEdecl l) = AST.STATEdecl
        (List.map (fn (v,t,e) => (newVar (s,v), convTy s t, convExp s e)) l)
      | convDecl s (PT.TYPEdecl (tb,t)) =
        AST.TYPEdecl (newTSyn (s,tb), convTy s t)
      | convDecl s (PT.DATATYPEdecl (tb, l)) = AST.DATATYPEdecl
        (newType (s,tb), List.map (convCondecl s) l)
      | convDecl s (PT.DECODEdecl dd) = AST.DECODEdecl (convDecodedecl s dd) 
      | convDecl s (PT.VALUEdecl vd) = AST.VALUEdecl (convValuedecl s vd)
    and convDecodedecl s (PT.MARKdecodedecl m) =
          AST.MARKdecodedecl (convMark convDecodedecl m)
      | convDecodedecl s (PT.NAMEDdecodedecl (v, l, e)) = AST.NAMEDdecodedecl
        (newVar (s,v), List.map (convDecodepat s) l, convExp s e)
      | convDecodedecl s (PT.DECODEdecodedecl (l,e)) = AST.DECODEdecodedecl
        (List.map (convDecodepat s) l, convExp s e)
      | convDecodedecl s (PT.GUARDEDdecodedecl (pl, el)) =
        AST.GUARDEDdecodedecl (List.map (convDecodepat s) pl,
         List.map (fn (e1,e2) => (convExp s e1, convExp s e2)) el)
    and convValuedecl s (PT.MARKvaluedecl m) =
        AST.MARKvaluedecl (convMark convValuedecl m)
    and convTy s (PT.MARKty m) = AST.MARKty (convMark convTy m)
      | convTy s (PT.BITty i) = AST.BITty i
      | convTy s (PT.NAMEDty n) = AST.NAMEDty (useTSyn (s,n))
      | convTy s (PT.RECty l) = AST.RECty
        (List.map (fn (f,t) => (newField (s,f), convTy s t)) l)
    and convExp s (PT.MARKexp m) = AST.MARKexp (convMark convExp m)
      | convExp s (PT.LETexp (l,e)) = AST.LETexp
          (List.map (convValuedecl s) l, convExp s e)
      | convExp s (PT.IFexp (e1,e2,e3)) = AST.IFexp
          (convExp s e1, convExp s e2, convExp s e3)
      | convExp s (PT.CASEexp (e,l)) = AST.CASEexp
          (convExp s e, List.map (convMatch s) l)
      | convExp s (PT.ANDALSOexp (e1,e2)) = AST.ANDALSOexp
          (convExp s e1, convExp s e2)
      | convExp s (PT.ORELSEexp (e1,e2)) = AST.ORELSEexp
          (convExp s e1, convExp s e2)
      | convExp s (PT.BINARYexp (e1, opid,e2)) = AST.BINARYexp
          (convExp s e1, useVar (s,{ span = s, tree = opid }), convExp s e2)
      | convExp s (PT.APPLYexp (e1,e2)) = AST.APPLYexp
          (convExp s e1, convExp s e2)
      | convExp s (PT.RECORDexp l) = AST.RECORDexp
          (List.map (fn (f,e) => (newField (s,f), convExp s e)) l)
      | convExp s (PT.SELECTexp (e,f)) = AST.SELECTexp
          (convExp s e, useField (s,f))
      | convExp s (PT.LITexp lit) = AST.LITexp (convLit s lit)
      | convExp s (PT.SEQexp l) = AST.SEQexp (List.map (convSeqexp s) l)
      | convExp s (PT.IDexp v) = AST.IDexp (useVar (s,v))
      | convExp s (PT.FNexp l) = AST.FNexp
          (List.map (fn (v,e) => (newVar (s,v), convExp s e)) l)
    and convSeqexp s (PT.MARKseqexp m) =
        AST.MARKseqexp (convMark convSeqexp m)
    and convCondecl s (PT.MARKcondecl m) =
        AST.MARKcondecl (convMark convCondecl m)
    and convDecodepat s (PT.MARKdecodepat m) =
        AST.MARKdecodepat (convMark convDecodepat m)
    and convMatch s (PT.MARKmatch m) =
        AST.MARKmatch (convMark convMatch m)
    and convLit s (PT.INTlit i) = AST.INTlit i
      | convLit s (PT.FLTlit f) = AST.FLTlit f
      | convLit s (PT.STRlit str) = AST.STRlit str
   in
      {ast= convMark (fn s => List.map (convDecl s)) ast,
       vars= !varTable,
       cons= !conTable,
       types= !typeTable,
       tsyns= !tSynTable,
       fields= !fieldTable}
   end

   fun resolveSymbols ast = let
      val ers = Error.mkErrStream "<no file>"
   in
      resolveSymbolPass (ers, ast)
         before
            Error.report (TextIO.stdErr, ers)
   end
end
