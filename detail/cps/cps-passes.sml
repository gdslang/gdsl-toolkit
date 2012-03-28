
structure BetaFunLinPass = MkCPSPass (BetaFunLin)

structure CPSPasses : sig
   val run:
      Core.Spec.t ->
         CPS.Spec.t CompilationMonad.t
end = struct

   structure CM = CompilationMonad

   open CM
   infix >>=

   fun all s = 
      FromCore.run s >>=
      BetaFunLinPass.run

   fun dumpPre (os, (_, spec)) = Pretty.prettyTo (os, Core.PP.spec spec)
   fun dumpPost (os, spec) = Pretty.prettyTo (os, CPS.PP.spec spec)
   fun pass (s, spec) = CM.run s (all spec)

   val passes =
      BasicControl.mkKeepPass
         {passName="cps",
          registry=CPSControl.registry,
          pass=pass,
          preExt="ast",
          preOutput=dumpPre,
          postExt="ast",
          postOutput=dumpPost}

   fun run spec =
      getState >>= (fn s =>
      return (passes (s, spec)))
end
