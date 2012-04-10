
structure ClosurePasses : sig
   val run:
      CPS.Spec.t ->
         Closure.Spec.t CompilationMonad.t
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

   fun all s = FromCPS.run s

   fun dumpPre (os, (_, spec)) = Pretty.prettyTo (os, CPS.PP.spec spec)
   fun dumpPost (os, spec) = Pretty.prettyTo (os, Closure.PP.spec spec)
   fun pass (s, spec) = CM.run s (all spec)

   val passes =
      BasicControl.mkKeepPass
         {passName="closureConversion",
          registry=ClosureControl.registry,
          pass=pass,
          preExt="cps",
          preOutput=dumpPre,
          postExt="clos",
          postOutput=dumpPost}

   fun run spec =
      getState >>= (fn s =>
      return (passes (s, spec)))
end
