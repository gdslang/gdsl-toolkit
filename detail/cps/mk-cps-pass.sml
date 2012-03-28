
signature CPSCORE = sig

   val run: CPS.Exp.term -> (CPS.Exp.term * int)
   val name: string

end

functor MkCPSPass (Core: CPSCORE) = struct

   structure CM = CompilationMonad

   fun dumpPre (os, cps) = Pretty.prettyTo (os, CPS.PP.term cps)
   fun dumpPost (os, t) = let
      open Layout Pretty
      fun prettyPass (cps, clicks) = 
         align
            [seq
               [str "cps.", str Core.name, str ".clicks", str "=",
                str (Int.toString clicks)],
             CPS.PP.term cps]
   in
      Pretty.prettyTo (os, prettyPass t)
   end

   val pass =
      BasicControl.mkKeepPass
         {passName=Core.name,
          registry=CPSControl.registry,
          pass=Core.run,
          preExt="ast",
          preOutput=dumpPre,
          postExt="ast",
          postOutput=dumpPost}

   fun run spec = CM.return (Spec.upd (#1 o pass) spec)

end
