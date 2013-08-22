
(*structure BetaContFunPass = MkCPSPass (BetaContFun)
structure BetaContFunShrinkPass = MkCPSPass (BetaContFunShrink)
structure BetaContractPass = MkCPSPass (BetaContract)
structure BetaPairPass = MkCPSPass (BetaPair)
structure HoistFunPass = MkCPSPass (HoistFun)
structure DeadValPass = MkCPSPass (DeadVal)*)

(*structure TransCallsPass = MkIMPPass (TransCalls)*)
structure PatchFunctionCallsPass = MkIMPPass (PatchFunctionCalls)
structure ActionReducePass = MkIMPPass (ActionReduce)
structure ActionVarReductionPass = MkIMPPass (ActionVarReduction)
structure ActionClosuresPass = MkIMPPass (ActionClosures)
structure SimplifyPass = MkIMPPass (Simplify)
structure TypeRefinementPass = MkIMPPass (TypeRefinement)
structure SwitchReducePass = MkIMPPass (SwitchReduce)
structure DeadSymbolPass = MkIMPPass (DeadSymbol)

structure ImpPasses : sig
   val run:
      Core.Spec.t ->
         Imp.Spec.t CompilationMonad.t
end = struct

   structure CM = CompilationMonad

   open CM
   infix >>=

   fun all s = 
      ImpFromCore.run s >>=
      PatchFunctionCallsPass.run >>=
      SimplifyPass.run >>=
      ActionReducePass.run >>=
      SimplifyPass.run >>=
      SwitchReducePass.run >>=
      SimplifyPass.run >>=
      ActionClosuresPass.run >>=
      SimplifyPass.run >>=
      TypeRefinementPass.run >>=
      SimplifyPass.run >>=
      DeadSymbolPass.run


   fun dumpPre (os, (_, spec)) = Pretty.prettyTo (os, Core.PP.spec spec)
   fun dumpPost (os, spec) = Pretty.prettyTo (os, Imp.PP.spec spec)
   fun pass (s, spec) = CM.run s (all spec)

   val passes =
      BasicControl.mkKeepPass
         {passName="imp",
          registry=ImpControl.registry,
          pass=pass,
          preExt="ast",
          preOutput=dumpPre,
          postExt="imp",
          postOutput=dumpPost}

   fun run spec =
      getState >>= (fn s =>
      return (passes (s, spec)))
end
