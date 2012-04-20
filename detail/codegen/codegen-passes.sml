
structure CodegenPasses : sig
   val run:
      Closure.Spec.t ->
         Layout.layout CompilationMonad.t
end = struct

   structure CM = CompilationMonad
   open CM
   infix >>=

   fun all s = C.run s

   fun dumpPre (os, (_, spec)) = Pretty.prettyTo (os, Closure.PP.spec spec)
   fun dumpPost (os, t) = Pretty.prettyTo (os, t)
   fun pass (s, spec) = CM.run s (all spec)

   val passes =
      BasicControl.mkKeepPass
         {passName="codegen",
          registry=ClosureControl.registry,
          pass=pass,
          preExt="clos",
          preOutput=dumpPre,
          postExt="c",
          postOutput=dumpPost}

   fun run spec =
      getState >>= (fn s =>
      return (passes (s, spec)))
end
