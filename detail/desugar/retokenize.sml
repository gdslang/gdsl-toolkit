
structure Retokenize : sig
   val run:
      DesugaredTree.spec ->
         DesugaredTree.spec CompilationMonad.t
end = struct

   structure CM = CompilationMonad
   structure DT = DesugaredTree

   fun retokenize ds = List.mapPartial retok ds

   and retok (ps, granularity, e) =
      case retokPats granularity ps of SOME ps => SOME (ps,granularity,e) | _ => NONE

   and retokPats granularity pats = let
      fun lp (p, len, tok, pats) =
         case p of
            [] =>
               if len <> 0 orelse List.length tok <> 0
                  then
                     (* some sub-byte decoders need to be discarded, but there might be some
										    that are discarded for the wrong reasons *)
                     ((*print "Retokenize: skipping decoder that reads less than a token\n";*)
                     NONE) 
               else SOME (rev pats) 
          | p::ps =>
               (case p of
                  [p] =>
                     let
                        val sz = DT.size p
                     in
                        if (sz + len) mod granularity = 0
                           then lp (ps, 0, [], (rev (p::tok))::pats)
                        else lp (ps, sz + len, p::tok, pats)
                     end
                | _ => raise CM.CompilationError)
   in
      lp (pats, 0, [], [])
   end

   fun dump (os, spec) = Pretty.prettyTo (os, DT.PP.spec spec)

   fun pass spec =
      Spec.upd
         (fn (vs, ds) =>
            (vs,
             SymMap.filter (not o null)
               (SymMap.map retokenize ds)))
         spec

   val pass =
      BasicControl.mkKeepPass
         {passName="retokenize",
          registry=DesugarControl.registry,
          pass=pass,
          preExt="ast",
          preOutput=dump,
          postExt="ast",
          postOutput=dump}

   fun run spec = CM.return (pass spec)
end
