
structure CodegenPasses : sig
   val run:
      Imp.Spec.t ->
         Layout.layout CompilationMonad.t
end = struct

   structure CM = CompilationMonad
   open CM
   infix >>=
   infix >>

   fun all imp =
      (*JS0.run cps >>*)
      (*ClosurePasses.run cps >>=
      C.run*)
      C1.run imp

   fun dumpPre (os, (_, spec)) = Pretty.prettyTo (os, Imp.PP.spec spec)
   fun dumpPost (os, t) = Pretty.prettyTo (os, t)
   fun pass (s, spec) = CM.run s (all spec)

   val passes =
      BasicControl.mkKeepPass
         {passName="codegen",
          registry=ClosureControl.registry,
          pass=pass,
          preExt="imp",
          preOutput=dumpPre,
          postExt="c",
          postOutput=dumpPost}

   fun run spec =
      getState >>= (fn s =>
      return (passes (s, spec)))
end
