
structure DesugarDecodeDeclarations = struct
   structure VS = VectorSlice
   structure CM = CompilationMonad
   structure DT = DesugaredTree
   structure Set = IntRedBlackSet

   open DT DT.Decode

   fun insert (map, k, i) = let
      val s =
         case StringMap.find (map, k) of
            NONE => Set.singleton i
          | SOME s => Set.add (s, i)
   in
      StringMap.insert (map, k, s)
   end

   val tok = Atom.atom "tok"
   val consume = Atom.atom "consume"
   val slice = Atom.atom "slice"

   fun freshTok () = let
      val (tab, sym) =
         VarInfo.fresh (!SymbolTables.varTable, tok)
   in
      sym before SymbolTables.varTable := tab
   end

   fun consumeTok () = let
      val tok = freshTok ()
      val consume =
         Exp.ID
            (VarInfo.lookup
               (!SymbolTables.varTable, consume))
   in
      (tok, Exp.BIND (tok, consume))
   end

   fun sliceExp (tok, offs, sz) = let
      open Exp
      fun INT i = LIT (SpecAbstractTree.INTlit (IntInf.fromInt i))
      val slice =
         ID
            (VarInfo.lookup
               (!SymbolTables.varTable, slice))
   in
      APP
         (APP
            (APP (slice, ID tok),
             INT offs),
          INT sz) 
   end

   fun buildEquivClass decls = let
      fun buildEquiv (i, (toks, _), map) =
         insert
            (map,
             if VS.length toks = 0
               then "" (* as placeholder for the real wildcard pattern "_" *)
             else toWildcardPattern (VS.sub (toks, 0)),
             i)
   in
      VS.foldli buildEquiv StringMap.empty decls
   end

   fun desugarCases (decls: (DecodePattern.t list VS.slice * guarded) VS.slice) = let
      fun grabExp () = #2 (VS.sub (decls, 0))
      val bottom = 
         VS.length decls = 1 andalso
            let
               val (toks, _) = VS.sub (decls, 0)
            in
               VS.length toks = 0
            end
   in
      if bottom
         then desugarGuarded (grabExp ())
      else
         let
            val (tok, bindTok) = consumeTok ()
         in
            Exp.SEQ
               [bindTok,
                Exp.ACTION
                  (Exp.CASE
                     (Exp.ID tok, desugarMatches tok decls))]
         end
   end

   and desugarMatches tok decls = let
      val equiv = buildEquivClass decls
      
      fun genBindSlices indices = let
         open DecodePattern
         fun grabSlices (i, acc) = let
            val (toks, e) = VS.sub (decls, i)
            fun grab (pats, offs, acc) =
               case pats of
                  [] => acc
                | pat::ps =>
                     case pat of
                        BITSTR _ => grab (ps, offs + size pat, acc)
                      | BIND (n, i) =>
                           grab
                              (ps,
                               offs + size pat,
                               Exp.BIND
                                 (n, sliceExp (tok, offs, i))::acc)
         in
            if VS.length toks = 0
               then acc
            else grab (VS.sub (toks, 0), 0, acc)
         end
      in
         rev (Set.foldl grabSlices [] indices)
      end

      fun stepDown indices = let
         fun nextIdx (i, acc) = let
            val (toks, e) = VS.sub (decls, i)
         in
            if VS.length toks = 0
               then (toVec [], e)::acc
            else (VS.subslice (toks, 1, NONE), e)::acc
         end
         val decls = toVec (rev (Set.foldl nextIdx [] indices))
         val slices = genBindSlices indices
      in
         if null slices
            then desugarCases decls
         else Exp.SEQ (slices @ [Exp.ACTION (desugarCases decls)])
      end

      fun buildMatch (pat, indices, pats) =
         (Pat.BIT pat, stepDown indices)::pats
   in
      StringMap.foldli buildMatch [] equiv
   end

   and desugarGuarded guarded =
      case guarded of
         Sum.INL e => e
       | Sum.INR es => (* TODO: translate guards *) #2 (hd es)
end

structure DesugarToplevel : sig
   val run:
      DesugaredTree.IRSpec.t ->
         DesugaredTree.IRSpec.t CompilationMonad.t
end = struct

   structure VS = VectorSlice
   structure CM = CompilationMonad
   structure DT = DesugaredTree
   structure Set = IntRedBlackSet

   open DT

   val decode = Atom.atom "decode"
   fun decodeFn () = (VarInfo.lookup (!SymbolTables.varTable, decode))

   val desugar = DesugarDecodeDeclarations.desugarCases o grabToplevel

   fun dumpPre (os, spec) = DT.PP.prettyTo (os, spec) 
   fun dumpPost (os, spec) = DT.PP.prettyTo (os, spec) 
   fun pass t =
      Spec.upd
         (fn (vs, ds) =>
            let
               val e = desugar ds
               val d = decodeFn ()
            in
               (vs@[Decl.REC (d, [], e)], ds)
            end) t
      
   val pass =
      BasicControl.mkKeepPass
         {passName="desugarToplevelDecodeDeclarations",
          registry=DesugarControl.registry,
          pass=pass,
          preExt="ast",
          preOutput=dumpPre,
          postExt="ast",
          postOutput=dumpPost}

   fun run spec = let
      open CompilationMonad
      infix >>=
   in
      return (pass spec)
   end
end
