
structure Retokenize : sig
   val run:
      DesugaredTree.spec ->
         DesugaredTree.spec CompilationMonad.t
end = struct

   structure CM = CompilationMonad
   structure DT = DesugaredTree

   fun retokenize ds = List.mapPartial retok ds

   and retok (ps, granularity, e) =
      if granularity=0 then NONE else SOME
         (retokPats granularity ps, granularity, e)

   and retokPats granularity pats = let
      fun lp ([], len, [], pats) = rev pats
        | lp ([p]::ps, len, tok, pats) =
         let
            val sz = DT.size p
            val newLen = sz + len
            val newTok = p::tok 
         in
            if newLen=granularity then lp (ps, 0, [], (rev newTok)::pats) else
            if newLen<granularity then lp (ps, newLen, newTok, pats)
            else raise CM.CompilationError
         end
        | lp (ps, len, tok, pats) = (TextIO.print ("retokPats: cannot handle " ^ Layout.tostring (Layout.list (map DT.PP.tokpat pats)) ^ ", granularity " ^ Int.toString granularity ^ ", #tok " ^ Int.toString (List.length tok) ^ "\n") ; raise CM.CompilationError)
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
