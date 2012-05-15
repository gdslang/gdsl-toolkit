
structure DesugarDecode = struct
   structure VS = VectorSlice
   structure CM = CompilationMonad
   structure DT = DesugaredTree
   structure Set = IntRedBlackSet
   structure Pat = DesugaredTree.Pat

   open DT 

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
   val unconsume = Atom.atom "unconsume"
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

   fun unconsumeTok () = let
      val unconsume =
         Exp.ID
            (VarInfo.lookup
               (!SymbolTables.varTable, unconsume))
   in
      Exp.ACTION unconsume
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

   fun isWildcardPattern p = String.size p = 0

   fun layoutDecls (decls: (Pat.t list VS.slice * Exp.t) VS.slice) = let
      open Layout Pretty
      fun pats ps = vector (VS.map (fn ps => list (map DT.PP.pat ps)) ps)
   in
      align
         [str "decls:", 
          vector (VS.map
            (fn pse =>
               tuple2 (pats, DT.PP.exp) pse) decls),
          str " "]
   end

   fun desugar ds = let
      fun lp (ds, acc) =
         case ds of
            [] => rev acc
          | (toks, e)::ds => lp (ds, (toVec toks, e)::acc)
   in
      desugarCases (toVec (lp (ds, [])))
   end

   and desugarCases (decls: (Pat.t list VS.slice * Exp.t) VS.slice) = let
      fun grabExp () = 
         if VS.length decls <> 1 
            then raise CM.CompilationError
         else #2 (VS.sub (decls, 0))
      fun isEmpty (vs, _) = VS.length vs = 0
      val bottom = VS.all isEmpty decls
   in
      if bottom
         then grabExp ()
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
      (* val () = Pretty.prettyTo (TextIO.stdOut, layoutDecls decls) *)
      val equiv = buildEquivClass decls
      
      fun genBindSlices indices = let
         open DT.Pat
         fun grabSlices (i, acc) = let
            val (toks, e) = VS.sub (decls, i)
            fun grab (pats, offs, acc) =
               case pats of
                  [] => acc
                | pat::ps =>
                     case pat of
                        VEC _ => grab (ps, offs + size pat, acc)
                      | BND (n, _) =>
                           grab
                              (ps,
                               offs + size pat,
                               Exp.BIND
                                 (n, sliceExp (tok, offs, size pat))::acc)
         in
            if VS.length toks = 0
               then acc
            else grab (rev (VS.sub (toks, 0)), 0, acc)
         end
      in
         rev (Set.foldl grabSlices [] indices)
      end

      fun stepDown indices wildcard = let
         fun nextIdx (i, acc) = let
            val (toks, e) = VS.sub (decls, i)
            val e =
               if wildcard
                  then
                     Exp.SEQ
                        [unconsumeTok (),
                         Exp.ACTION e]
               else e
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
         (Core.Pat.BIT pat, stepDown indices (isWildcardPattern pat))::pats
   in
      StringMap.foldli buildMatch [] equiv
   end
end

structure DesugarDecodeSyntax : sig
   val run:
      DesugaredTree.spec ->
         Core.Spec.t CompilationMonad.t
end = struct

   structure CM = CompilationMonad
   structure DT = DesugaredTree

   fun desugar ds =
      List.map
         (fn (n, ds) =>
             (n, [], DesugarDecode.desugar ds))
         (SymMap.listItemsi ds)

   fun dumpPre (os, spec) = Pretty.prettyTo (os, DT.PP.spec spec)
   fun dumpPost (os, spec) = Pretty.prettyTo (os, Core.PP.spec spec)

   fun pass t =
      Spec.upd
         (fn (vs, ds) =>
            let
               val vss = desugar ds
            in
               vs@vss
            end) t
      
   val pass =
      BasicControl.mkKeepPass
         {passName="desugarDecodeSyntax",
          registry=DesugarControl.registry,
          pass=pass,
          preExt="ast",
          preOutput=dumpPre,
          postExt="ast",
          postOutput=dumpPost}

   fun run spec = CM.return (pass spec)
end
