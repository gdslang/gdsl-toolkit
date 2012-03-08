
(**
 * ## Resolve Symbols
 *
 * Annotate AST with symbol identifiers.
 *)
structure ResolveSymbols : sig
   val run:
      SpecParseTree.specification ->
         SpecAbstractTree.specification CompilationMonad.t
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

      fun newSym (table, create, lookup, str) (span, atom) = let
         val (newTable, id) = create (!table, atom, span)
      in
         (table := newTable; id)
      end
         handle SymbolAlreadyDefined =>
            (Error.errorAt
               (errStrm,
                span,
                ["duplicate ", str, " declaration ", Atom.toString(atom)])
            ;lookup (!table, atom))

      val newVar = newSym (ST.varTable, VI.create, VI.lookup, "variable")
      val newLetVar = newVar
      val newCon = newSym (ST.conTable, CI.create, CI.lookup, "constructor")
      val newType = newSym (ST.typeTable, TI.create, TI.lookup, "type")
      val newTSyn = newSym (ST.typeTable, TI.create, TI.lookup, "type synonym")

      fun newField (span, atom) = let
         val (newTable, id) = FI.create (!ST.fieldTable, atom, span)
      in
         (ST.fieldTable := newTable; id)
      end
         handle SymbolAlreadyDefined =>
            FI.lookup (!ST.fieldTable, atom)

      fun useSym (table, create, find, str) (_, {tree=atom, span}) =
         case find (!table, atom) of
            SOME id => id
          | NONE =>
               (Error.errorAt
                  (errStrm,
                   span,
                   [str, " '", Atom.toString(atom), "' is not defined "])
               ;let
                  val (newTable, id) = create (!table, atom, span)
                in
                  (table := newTable; id)
                end)

      val useVar = useSym (ST.varTable, VI.create, VI.find, "variable")
      val useCon = useSym (ST.conTable, CI.create, CI.find, "constructor")
      val useType = useSym (ST.typeTable, TI.create, TI.find, "type")

      fun useField (_, {tree=atom, span}) = let
         val (newTable, id) = FI.create (!ST.fieldTable, atom, span)
      in
         (ST.fieldTable := newTable; id)
      end
         handle SymbolAlreadyDefined =>
            FI.lookup (!ST.fieldTable, atom)

      (* define a first traversal that registers all let rec bindings *)

      fun regDecl s decl =
         case decl of
            PT.MARKdecl {span, tree} => regDecl span tree
          | PT.EXPORTdecl es => app (fn e => regVar s (#tree e)) es
          | PT.DECODEdecl d => regDecodeDecl s d
          | PT.LETRECdecl d => regLetrecDecl s d
          | _ => ()

      and regVar s n =
         case VI.find (!ST.varTable, n) of
            NONE => (newLetVar (s, n); ())
          | _ => ()

      and regDecodeDecl s d =
         case d of
            (n, _, _) => regVar s n

      and regLetrecDecl s d =
         case d of
            (n, _, _) => regVar s n

      (* define a second traversal that is a full translation of the tree *)
      fun convDecl s d =
         case d of
            PT.MARKdecl m => AST.MARKdecl (convMark convDecl m)
          | PT.INCLUDEdecl str => AST.INCLUDEdecl str
          | PT.EXPORTdecl es => AST.EXPORTdecl (map (fn v => useVar (s, v)) es)
          | PT.GRANULARITYdecl i => AST.GRANULARITYdecl i
          | PT.STATEdecl l =>
               AST.STATEdecl
                  (List.map
                     (fn (v,t,e) => (newVar (s,v), convTy s t, convExp s e)) l)
          | PT.TYPEdecl (tb, t) =>
               AST.TYPEdecl (newTSyn (s,tb), convTy s t)
          | PT.DATATYPEdecl (tb, l) =>
               AST.DATATYPEdecl
                  (newType (s, tb), List.map (convCondecl s) l)
          | PT.DECODEdecl dd => AST.DECODEdecl (convDecodeDecl s dd)
          | PT.LETRECdecl vd => AST.LETRECdecl (convLetrecDecl s vd)

      and convDecodeDecl s d =
         case d of
            (v, ps, Sum.INL e) =>
               let
                  val _ = startScope ()
                  val res =
                     (VI.lookup (!ST.varTable, v),
                      List.map (convDecodepat s) ps,
                      Sum.INL (convExp s e))
                  val _ = endScope ()
               in
                  res
               end
         | (v, ps, Sum.INR es) =>
               let
                  val _ = startScope ()
                  val res =
                     (VI.lookup (!ST.varTable, v),
                      List.map (convDecodepat s) ps,
                      Sum.INR
                        (List.map
                           (fn (e1, e2) => (convExp s e1, convExp s e2))
                           es))
                  val _ = endScope ()
               in
                  res
               end

      and convLetrecDecl s (v, l, e) = let
         val id = VI.lookup (!ST.varTable, v)
         val _ = startScope ()
         val l = List.map (fn v => newVar (s,v)) l
         val e = convExp s e
         val _ = endScope ()
      in
         (id, l, e)
      end

      and convCondecl s (c, to) =
         (newCon (s, c), case to of NONE => NONE | SOME t => SOME (convTy s t))

      and convTy s t =
         case t of
            PT.MARKty m => AST.MARKty (convMark convTy m)
          | PT.BITty i => AST.BITty i
          | PT.NAMEDty n => AST.NAMEDty (useType (s,n))
          | PT.RECORDty fs =>
               AST.RECORDty
                  (List.map (fn (f,t) => (newField (s,f), convTy s t)) fs)

      and convExp s e =
         case e of
            PT.MARKexp m => AST.MARKexp (convMark convExp m)
          | PT.LETRECexp (l, e) =>
               let
                  val _ = startScope ()
                  val _ = List.map (regLetrecDecl s) l
                  val l = List.map (convLetrecDecl s) l
                  val r = convExp s e
                  val _ = endScope ()
               in
                  AST.LETRECexp (l, r)
               end
          | PT.IFexp (iff, thenn, elsee) =>
               AST.IFexp (convExp s iff, convExp s thenn, convExp s elsee)
          | PT.CASEexp (e, l) =>
               AST.CASEexp (convExp s e, List.map (convMatch s) l)
          | PT.BINARYexp (e1, opid, e2) =>
               AST.BINARYexp
                  (convExp s e1, useVar (s,{span=s, tree=opid}), convExp s e2)
          | PT.APPLYexp (e1,e2) =>
               AST.APPLYexp (convExp s e1, convExp s e2)
          | PT.RECORDexp l =>
               AST.RECORDexp
                  (List.map (fn (f,e) => (newField (s,f), convExp s e)) l)
          | PT.SELECTexp f => AST.SELECTexp (useField (s,f))
          | PT.UPDATEexp fs =>
               AST.UPDATEexp
                  (List.map (fn (f,e) => (newField (s,f), convExp s e)) fs)
          | PT.LITexp lit => AST.LITexp (convLit s lit)
          | PT.SEQexp l => AST.SEQexp (convSeqexp s l)
          | PT.IDexp v => AST.IDexp (useVar (s,v))
          | PT.CONexp c => AST.CONexp (useCon (s,c))
          | PT.FNexp (v, e) => AST.FNexp (newVar (s,v), convExp s e)

      and convSeqexp s ss =
         case ss of
            [] => []
         | PT.MARKseqexp {span, tree}::l => convSeqexp span (tree :: l)
         | PT.ACTIONseqexp e::l => AST.ACTIONseqexp (convExp s e) :: convSeqexp s l
         | PT.BINDseqexp (v, e)::l =>
               let
                  val rhs = convExp s e
                  val _ = startScope ()
                  val lhs = newVar (s,v)
                  val rem = convSeqexp s l
                  val _ = endScope ()
               in
                  AST.BINDseqexp (lhs, rhs) :: rem
               end

      and convDecodepat s p =
         case p of
            PT.MARKdecodepat m => AST.MARKdecodepat (convMark convDecodepat m)
          | PT.TOKENdecodepat t => AST.TOKENdecodepat (convTokpat s t)
          | PT.BITdecodepat l => AST.BITdecodepat (List.map (convBitpat s) l)

      and convBitpat s p =
         case p of
            PT.MARKbitpat m => AST.MARKbitpat (convMark convBitpat m)
          | PT.BITSTRbitpat str => AST.BITSTRbitpat str
          | PT.NAMEDbitpat v => AST.NAMEDbitpat (useVar (s,v))
          | PT.BITVECbitpat (var,size) => AST.BITVECbitpat (newVar (s,var), size)

      and convTokpat s p =
         case p of
            PT.MARKtokpat m => AST.MARKtokpat (convMark convTokpat m)
          | PT.TOKtokpat i => AST.TOKtokpat i
          | PT.NAMEDtokpat v => AST.NAMEDtokpat (useVar (s,v))

      and convMatch s (p, e) = (convPat s p, convExp s e)

      and convPat s p = 
         case p of
            PT.MARKpat m => AST.MARKpat (convMark convPat m)
          | PT.LITpat lit => AST.LITpat (convLit s lit)
          | PT.IDpat v => AST.IDpat (newVar (s,v))
          | PT.CONpat (c, SOME p) => AST.CONpat (useCon (s,c), SOME (convPat s p))
          | PT.CONpat (c, NONE) => AST.CONpat (useCon (s,c), NONE)
          | PT.WILDpat => AST.WILDpat

      and convLit s l =
         case l of
            PT.INTlit i => AST.INTlit i
          | PT.FLTlit f => AST.FLTlit f
          | PT.STRlit str => AST.STRlit str
          | PT.VEClit str => AST.VEClit str

   in
      (Primitives.registerPrimitives ()
      ;convMark (fn s => List.map (regDecl s)) ast
      ;convMark (fn s => List.map (convDecl s)) ast)
   end

   val resolveSymbolPass =
      BasicControl.mkTracePassSimple
         {passName="resolveSymbols",
          pass=resolveSymbolPass}

   fun run spec = let
      open CompilationMonad
   in
      getErrorStream >>= (fn errs =>
      return (resolveSymbolPass (errs, spec)))
   end
end
