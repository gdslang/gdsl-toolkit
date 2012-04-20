
structure BetaFunPass = MkCPSPass (BetaFun)
structure BetaContPass = MkCPSPass (BetaCont)
structure BetaContFunPass = MkCPSPass (BetaContFun)
structure BetaPairPass = MkCPSPass (BetaPair)
structure HoistFunPass = MkCPSPass (HoistFun)
structure DeadValPass = MkCPSPass (DeadVal)

structure CPSPasses : sig
   val run:
      Core.Spec.t ->
         CPS.Spec.t CompilationMonad.t
end = struct

   structure CM = CompilationMonad

   open CM
   infix >>=
   infix >>+

   fun a >>+ b =
      a >>= (fn (cps, clicksOfA) =>
      b cps >>= (fn (cps, clicksOfB) =>
      return (cps, clicksOfA + clicksOfB)))

   fun fix pass cps = 
      pass cps >>= (fn (cps, clicks) =>
      if clicks = 0
         then return cps
      else fix pass cps)

   fun allBeta cps =
      BetaFunPass.run cps >>=
      BetaContPass.run >>=
      BetaPairPass.run >>=
      HoistFunPass.run >>= 
      DeadValPass.run

   fun allBetaCounting cps =
      BetaContFunPass.runCounting cps >>+
      (* BetaContPass.runCounting cps >>+
      BetaFunPass.runCounting >>+ *)
      BetaPairPass.runCounting >>+ 
      HoistFunPass.runCounting >>+
      DeadValPass.runCounting

   fun allBetaFixpoint cps = fix allBetaCounting cps

   fun all s = 
      FromCore.run s >>=
      allBetaFixpoint

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
