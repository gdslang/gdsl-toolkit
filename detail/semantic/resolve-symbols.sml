
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

      (*check if a field name is used several time in record constructions or
      record updates*)
      fun checkDupFields span fs =
         let
            fun gather ((f,_),set) = 
               if SymSet.member (set,f) then
               (Error.errorAt
                  (errStrm,
                   span,
                   ["field ", FI.getString (!ST.fieldTable, f),
                    " cannot be updated more than once"]); set)
               else
                  SymSet.add (set,f)
         in
            (List.foldl gather SymSet.empty fs; fs)
         end

      (* define a first traversal that registers:
       *   - type synonyms
       *   - datatype declarations including constructors
       *   - toplevel val bindings
       *   - bitpat var binding per decoder
       *)
      fun regDecl s decl =
         case decl of
            PT.MARKdecl {span, tree} => regDecl span tree
          | PT.DECODEdecl (n, pats, _) => regDec s n
          | PT.LETRECdecl (n, _, _) => ignore (newVar (s,n))
          | PT.DATATYPEdecl (n, ds) => (regTy s n; app (regCon s) ds)
          | PT.TYPEdecl (n, _) => regTy s n 
          | _ => ()

      and regTy s n =
         case TI.find (!ST.typeTable, n) of
            NONE => ignore (newType (s, n))
          | _ => ()

      and regCon s (c, _) = ignore (newCon (s, c))

      and regDec s n =
         case VI.find (!ST.varTable, n) of
            NONE => ignore (newVar (s, n))
          | _ => ()
      
      (* define a second traversal that is a full translation of the tree *)
      fun convDecl s d =
         case d of
            PT.MARKdecl m => AST.MARKdecl (convMark convDecl m)
          | PT.EXPORTdecl es => AST.EXPORTdecl (map (fn v => useVar (s, v)) es)
          | PT.GRANULARITYdecl i => AST.GRANULARITYdecl i
          | PT.TYPEdecl (tb, t) =>
               AST.TYPEdecl (useType (s,{span=s, tree=tb}), convTy s t)
          | PT.DATATYPEdecl (tb, l) =>
               AST.DATATYPEdecl
                  (useType (s, {span=s, tree=tb}), List.map (convCondecl s) l)
          | PT.DECODEdecl dd => AST.DECODEdecl (convDecodeDecl s dd)
          | PT.LETRECdecl vd => AST.LETRECdecl (convLetrecDecl s vd)

      and convDecodeDecl s d =
         case d of
            (v, ps, Sum.INL e) =>
               let
                  val vSym = VI.lookup (!ST.varTable, v)
                  val _ = startScope ()

                  val res =
                     (vSym,
                      List.map (convDecodepat s) ps,
                      Sum.INL (convExp s e))
                  val _ = endScope ()
               in
                  res
               end
         | (v, ps, Sum.INR es) =>
               let
                  val vSym = VI.lookup (!ST.varTable, v)
                  val _ = startScope ()
                  val res =
                     (vSym,
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
         (useCon (s, {span=s, tree=c}), case to of NONE => NONE | SOME t => SOME (convTy s t))

      and convTy s t =
         case t of
            PT.MARKty m => AST.MARKty (convMark convTy m)
          | PT.BITty i => AST.BITty i
          | PT.NAMEDty n => AST.NAMEDty (useType (s,n))
          | PT.RECORDty fs =>
               AST.RECORDty (checkDupFields s
                  (List.map (fn (f,t) => (newField (s,f), convTy s t)) fs))

      and convExp s e =
         case e of
            PT.MARKexp m => AST.MARKexp (convMark convExp m)
          | PT.LETRECexp (l, e) =>
               let
                  val _ = startScope ()
                  val _ = List.map (fn (n,_,_) => newVar (s,n)) l
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
                  (convExp s e1, convInfixop s opid, convExp s e2)
          | PT.APPLYexp (e1,es) =>
               AST.APPLYexp (convExp s e1, map (convExp s) es)
          | PT.RECORDexp l =>
               AST.RECORDexp (checkDupFields s
                  (List.map (fn (f,e) => (newField (s,f), convExp s e)) l))
          | PT.SELECTexp f => AST.SELECTexp (useField (s,f))
          | PT.UPDATEexp fs =>
               AST.UPDATEexp (checkDupFields s
                  (List.map (fn (f,eOpt) => (newField (s,f),
                     case eOpt of
                        SOME e => SOME (convExp s e)
                      | NONE => NONE)) fs))
          | PT.LITexp lit => AST.LITexp (convLit s lit)
          | PT.SEQexp l => AST.SEQexp (convSeqexp s l)
          | PT.IDexp v => AST.IDexp (useVar (s,v))
          | PT.CONexp c => AST.CONexp (useCon (s,c))
          | PT.FNexp (vs, e) =>
            AST.FNexp (List.map (fn v => newVar (s,v)) vs, convExp s e)

      and convInfixop s e =
         case e of
            PT.MARKinfixop m => AST.MARKinfixop (convMark convInfixop m)
          | PT.OPinfixop opid => AST.OPinfixop (useVar (s,{span=s, tree=opid}))

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
          | PT.BITVECbitpat (v,p) => AST.BITVECbitpat (newVar (s,v), p)

      and convTokpat s p =
         case p of
            PT.MARKtokpat m => AST.MARKtokpat (convMark convTokpat m)
          | PT.TOKtokpat i => AST.TOKtokpat i
          | PT.NAMEDtokpat v => AST.NAMEDtokpat (useVar (s,v))
      
      and convMatch s (p, e) =
         let
            val _ = startScope ()
            val p = convPat s p
            val e = convExp s e
            val _ = endScope ()
         in
            (p,e)
         end
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
      ;List.map (regDecl SymbolTable.noSpan) ast
      (*;TextIO.print (smapToString (!specDec))*)
      ;List.map (convDecl SymbolTable.noSpan) ast)
   end

   val resolveSymbolPass =
      BasicControl.mkKeepPass
         {passName="resolveSymbols",
          registry=BasicControl.topRegistry,
          pass=resolveSymbolPass,
          preExt="ast",
          preOutput=fn (os,(err,t)) => PT.PP.prettyTo(os, t),
          postExt="ast",
          postOutput=AST.PP.prettyTo}

   fun run spec = let
      open CompilationMonad
   in
      getErrorStream >>= (fn errs =>
      return (resolveSymbolPass (errs, spec)))
   end
end
