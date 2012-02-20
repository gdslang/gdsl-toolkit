structure ResolveSymbols : sig

   (* annotate AST with symbol identifiers, return false if there were errors *)
   val resolveSymbolPass: (Error.err_stream * SpecParseTree.specification) -> SpecAbstractTree.specification
   val resolveSymbols: SpecParseTree.specification -> SpecAbstractTree.specification
   val run: SpecParseTree.specification -> SpecAbstractTree.specification CompilationMonad.t

   val test: string -> unit
   val startScope : unit -> unit
end = struct

  structure PT = SpecParseTree
  structure AST = SpecAbstractTree
  structure VI = VarInfo
  structure FI = FieldInfo
  structure CI = ConInfo
  structure TI = TypeInfo
  structure ST = SymbolTables

  exception NotImplemented

   infix >>= >>

  fun resolveErr errStrm (pos, msg) = Error.errorAt(errStrm, (pos, pos), msg)

  val parseErr = Error.parseError SpecTokens.toString

  fun convMark conv {span, tree} = {span=span, tree=conv span tree}

  fun startScope () = ST.varTable := VI.push (!ST.varTable)
  fun endScope () = ST.varTable := VI.pop (!ST.varTable)


  fun resolveSymbolPass (errStrm, ast) = let

    fun newSym (table, create, lookup, str) (span, atom) =
      let val (newTable, id) = create (!table, atom, span)
      in (table := newTable; id) end
      handle SymbolAlreadyDefined =>
        (Error.errorAt
           (errStrm,
            span,
            ["duplicate ", str, " declaration ",
             Atom.toString(atom)])
        ; lookup (!table, atom))

    val newVar = newSym (ST.varTable, VI.create, VI.lookup, "variable")
    val newLetVar = newVar
    val newCon = newSym (ST.conTable, CI.create, CI.lookup, "constructor")
    val newType = newSym (ST.typeTable, TI.create, TI.lookup, "type")
    val newTSyn = newSym (ST.typeTable, TI.create, TI.lookup, "type synonym")
    fun newField (span, atom) =
      let val (newTable, id) = FI.create (!ST.fieldTable, atom, span)
      in (ST.fieldTable := newTable; id) end
      handle SymbolAlreadyDefined => FI.lookup (!ST.fieldTable, atom)

    fun useSym (table, create, find, str) (_,{ tree=atom, span}) =
      case find (!table, atom)
        of (SOME id) => id
        | NONE => (Error.errorAt
             (errStrm,
              span,
              [str, " '", Atom.toString(atom), "' is not defined "]);
           let val (newTable, id) = create (!table, atom, span)
           in (table := newTable; id) end)

    val useVar = useSym (ST.varTable, VI.create, VI.find, "variable")
    val useCon = useSym (ST.conTable, CI.create, CI.find, "constructor")
    val useType = useSym (ST.typeTable, TI.create, TI.find, "type")

    fun useField (_, { tree=atom, span}) =
      let val (newTable, id) = FI.create (!ST.fieldTable, atom, span)
      in (ST.fieldTable := newTable; id) end
      handle SymbolAlreadyDefined => FI.lookup (!ST.fieldTable, atom)

    (* define a first traversal that registers all let rec bindings *)
    fun regDecl _ (PT.MARKdecl { span = s, tree = m }) = regDecl s m
      | regDecl s (PT.DECODEdecl dd) = regDecodedecl s dd
      | regDecl s (PT.VALUEdecl vd) = regValuedecl s vd
      | regDecl s _ = ()
    and regDecodedecl _ (PT.MARKdecodedecl { span = s, tree = m }) =
          regDecodedecl s m
      | regDecodedecl s (PT.NAMEDdecodedecl (v, l, e)) =
          (case VI.find (!ST.varTable, v) of (SOME _) => ()
                                           | (NONE) => (newLetVar (s,v); ()))
      | regDecodedecl s (PT.DECODEdecodedecl (l,e)) =
          let val v = Atom.atom "decode" in
          case VI.find (!ST.varTable, v) of (SOME _) => ()
                                          | NONE => (newLetVar (s,v); ()) end
      | regDecodedecl s (PT.GUARDEDdecodedecl (pl, el)) =
          let val v = Atom.atom "decode" in
          case VI.find (!ST.varTable, v) of (SOME _) => ()
                                         | NONE => (newLetVar (s,v); ()) end
    and regValuedecl _ (PT.MARKvaluedecl { span = s, tree = m }) =
          regValuedecl s m
      | regValuedecl s (PT.LETRECvaluedecl (v,l,e)) =
          (case VI.find (!ST.varTable, v) of (SOME _) => ()
                                           | NONE => (newLetVar (s,v); ()))
      | regValuedecl s _ = ()

    (* define a second traversal that is a full translation of the tree *)
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
        (VI.lookup (!ST.varTable, v), List.map (convDecodepat s) l, convExp s e)
      | convDecodedecl s (PT.DECODEdecodedecl (l,e)) = AST.DECODEdecodedecl
        (List.map (convDecodepat s) l, convExp s e)
      | convDecodedecl s (PT.GUARDEDdecodedecl (pl, el)) =
        AST.GUARDEDdecodedecl (List.map (convDecodepat s) pl,
         List.map (fn (e1,e2) => (convExp s e1, convExp s e2)) el)
    and convValuedecl s (PT.MARKvaluedecl m) =
        AST.MARKvaluedecl (convMark convValuedecl m)
      | convValuedecl s (PT.LETvaluedecl (v,l,e)) = AST.LETvaluedecl
        let val _ = startScope ()
            (*val _ = TextIO.print ("before vars e1 of " ^ Atom.toString v ^ ":\n" ^ SymbolTable.toString(!ST.varTable) ^ "\n");*)
            val l = List.map (fn v => newVar (s,v)) l
            (*val _ = TextIO.print ("before e1 of " ^ Atom.toString v ^ ":\n" ^ SymbolTable.toString(!ST.varTable) ^ "\n");*)
            val e = convExp s e
            (*val _ = TextIO.print ("after e1 of " ^ Atom.toString v ^ ":\n" ^ SymbolTable.toString(!ST.varTable) ^ "\n");*)
            val _ = endScope ()
            val id = newLetVar (s,v)
        in (id, l, e) end
      | convValuedecl s (PT.LETRECvaluedecl (v,l,e)) = AST.LETRECvaluedecl
        let val id = VI.lookup (!ST.varTable, v)
            val _ = startScope ()
            (*val _ = TextIO.print ("before vars e1 of " ^ Atom.toString v ^ ":\n" ^ SymbolTable.toString(!ST.varTable) ^ "\n");*)
            val l = List.map (fn v => newVar (s,v)) l
            (*val _ = TextIO.print ("before e1 of " ^ Atom.toString v ^ ":\n" ^ SymbolTable.toString(!ST.varTable) ^ "\n");*)
            val e = convExp s e
            (*val _ = TextIO.print ("after e1 of " ^ Atom.toString v ^ ":\n" ^ SymbolTable.toString(!ST.varTable) ^ "\n");*)
            val _ = endScope ()
        in (id, l, e) end
    and convCondecl s (PT.MARKcondecl m) =
        AST.MARKcondecl (convMark convCondecl m)
      | convCondecl s (PT.CONdecl (c,to)) = AST.CONdecl
        (newCon (s,c), case to of NONE => NONE | SOME t => SOME (convTy s t))
    and convTy s (PT.MARKty m) = AST.MARKty (convMark convTy m)
      | convTy s (PT.BITty i) = AST.BITty i
      | convTy s (PT.NAMEDty n) = AST.NAMEDty (useType (s,n))
      | convTy s (PT.RECty l) = AST.RECty
        (List.map (fn (f,t) => (newField (s,f), convTy s t)) l)
    and convExp s (PT.MARKexp m) = AST.MARKexp (convMark convExp m)
      | convExp s (PT.LETexp (l,e)) = AST.LETexp (let
          val _ = startScope ()
          val _ = List.map (regValuedecl s) l
          val l = List.map (convValuedecl s) l
          (*val _ = TextIO.print ("before e2:\n" ^ SymbolTable.toString(!ST.varTable) ^ "\n");*)
          val r = convExp s e
          val _ = endScope ()
          (*val _ = TextIO.print ("after e2:\n" ^ SymbolTable.toString(!ST.varTable) ^ "\n");*)
        in (l,r) end)
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
      | convExp s (PT.CONexp c) = AST.CONexp (useCon (s,c))
      | convExp s (PT.FNexp (v, e)) = AST.FNexp (newVar (s,v), convExp s e)
    and convSeqexp s (PT.MARKseqexp m) = AST.MARKseqexp (convMark convSeqexp m)
      | convSeqexp s (PT.ACTIONseqexp e) = AST.ACTIONseqexp (convExp s e)
      | convSeqexp s (PT.BINDseqexp (v,e)) = AST.BINDseqexp
          (newVar (s,v), convExp s e)
    and convDecodepat s (PT.MARKdecodepat m) =
        AST.MARKdecodepat (convMark convDecodepat m)
      | convDecodepat s (PT.TOKENdecodepat t) =
        AST.TOKENdecodepat (convTokpat s t)
      | convDecodepat s (PT.BITdecodepat l) =
        AST.BITdecodepat (List.map (convBitpat s) l)
    and convBitpat s (PT.MARKbitpat m) =
        AST.MARKbitpat (convMark convBitpat m)
      | convBitpat s (PT.BITSTRbitpat str) = AST.BITSTRbitpat str
      | convBitpat s (PT.NAMEDbitpat v) = AST.NAMEDbitpat (useVar (s,v))
      | convBitpat s (PT.BITVECbitpat (var,size)) = AST.BITVECbitpat
        (newVar (s,var), size)
    and convTokpat s (PT.MARKtokpat m) =
        AST.MARKtokpat (convMark convTokpat m)
      | convTokpat s (PT.TOKtokpat i) = AST.TOKtokpat i
      | convTokpat s (PT.NAMEDtokpat v) = AST.NAMEDtokpat (useVar (s,v))
    and convMatch s (PT.MARKmatch m) =
        AST.MARKmatch (convMark convMatch m)
      | convMatch s (PT.CASEmatch (p,e)) =
        AST.CASEmatch (convPat s p, convExp s e)
    and convPat s (PT.MARKpat m) =
        AST.MARKpat (convMark convPat m)
      | convPat s (PT.BITpat str) = AST.BITpat str
      | convPat s (PT.LITpat lit) = AST.LITpat (convLit s lit)
      | convPat s (PT.IDpat v) = AST.IDpat (newVar (s,v))
      | convPat s (PT.WILDpat) = AST.WILDpat
    and convLit s (PT.INTlit i) = AST.INTlit i
      | convLit s (PT.FLTlit f) = AST.FLTlit f
      | convLit s (PT.STRlit str) = AST.STRlit str

   in (ST.varTable := VarInfo.empty;
       ST.conTable := ConInfo.empty;
       ST.typeTable := TypeInfo.empty;
       ST.fieldTable := FieldInfo.empty;
       convMark (fn s => List.map (regDecl s)) ast;
       convMark (fn s => List.map (convDecl s)) ast)
   end

   fun resolveSymbols ast = let
      val ers = Error.mkErrStream "<no file>"
   in
     resolveSymbolPass (ers, ast)
       before
         Error.report (TextIO.stdErr, ers)
   end

   fun run spec = let
      open CompilationMonad
   in
      getErrorStream >>= (fn errs =>
      return (resolveSymbolPass (errs, spec)))
   end

   fun test fp = let
     val ers = Error.mkErrStream fp
   in case Parser.parse fp of
       SOME ast => (AST.PP.pretty (resolveSymbolPass (ers, ast)); TextIO.print "\n")
                  before
                    Error.report (TextIO.stdErr, ers)
     | NONE => Error.report (TextIO.stdErr, ers)
   end

end
