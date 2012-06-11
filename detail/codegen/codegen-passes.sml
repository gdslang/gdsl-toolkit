
structure CodegenPasses : sig
   val run:
      CPS.Spec.t ->
         Layout.layout CompilationMonad.t
end = struct

   structure CM = CompilationMonad
   open CM
   infix >>=
   infix >>

   fun all cps =
      JS0.run cps >>
      ClosurePasses.run cps >>=
      C.run

   fun dumpPre (os, (_, spec)) = Pretty.prettyTo (os, CPS.PP.spec spec)
   fun dumpPost (os, t) = Pretty.prettyTo (os, t)
   fun pass (s, spec) = CM.run s (all spec)

   val passes =
      BasicControl.mkKeepPass
         {passName="codegen",
          registry=ClosureControl.registry,
          pass=pass,
          preExt="cps",
          preOutput=dumpPre,
          postExt="c",
          postOutput=dumpPost}

   fun run spec =
      getState >>= (fn s =>
      return (passes (s, spec)))
end
