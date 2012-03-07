
structure Desugar : sig
   val run:
      SpecAbstractTree.specification ->
         DesugaredTree.IRSpec.t CompilationMonad.t
end = struct

   structure CM = CompilationMonad
   structure DT = DesugaredTree
   structure AT = SpecAbstractTree

   open CM
   infix >>=

   fun all s = 
      SplitDeclarations.run s >>=
      DesugarGuards.run >>=
      InlineDecodePatterns.run >>=
      Detokenize.run >>=
      Retokenize.run >>=
      DesugarToplevel.run

   fun dumpPre (os, (_, spec)) = AT.PP.prettyTo (os, spec)
   fun dumpPost (os, spec) = DT.PP.prettyTo (os, spec)
   fun pass (s, spec) = CM.run s (all spec)

   val desugar =
      BasicControl.mkKeepPass
         {passName="desugarDecodeDeclarations",
          registry=DesugarControl.registry,
          pass=pass,
          preExt="ast",
          preOutput=dumpPre,
          postExt="ast",
          postOutput=dumpPost}

   fun run spec =
      getState >>= (fn s =>
      return (desugar (s, spec)))
end
