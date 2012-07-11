
signature CPSCORE = sig

   val run: CPS.Exp.term -> (CPS.Exp.term * int)
   val name: string

end

functor MkCPSPass (Core: CPSCORE) = struct

   structure CM = CompilationMonad

   val dumpFreeVars = ref false
   val clicks = Stats.newCounter ("cps." ^ Core.name ^ ".clicks")

   val dumpFreeVars = fn cps =>
      if !dumpFreeVars
         then
            let
               open Layout Pretty
            in
               FreeVars.run cps
              ;align [str "freevars=",indent 2 (FreeVars.layout())]
            end
      else Layout.str""

   fun dumpPre (os, cps) =
      Pretty.prettyTo (os, Layout.align [CPS.PP.term cps,dumpFreeVars cps])
   fun dumpPost (os, t) = let
      open Layout Pretty
      fun prettyPass (cps, clicks) = 
         align
            [seq
               [str "cps.", str Core.name, str ".clicks", str "=",
                str (Int.toString clicks)],
             CPS.PP.term cps,
             align [str "census=", indent 2 (Census.layout())],
             dumpFreeVars cps]
   in
     Pretty.prettyTo (os, prettyPass t)
   end

   fun runPass t = (CheckDefUse.run t; Core.run t)

   val pass =
      BasicControl.mkKeepPass
         {passName=Core.name,
          registry=CPSControl.registry,
          pass=runPass,
          preExt="cps",
          preOutput=dumpPre,
          postExt="cps",
          postOutput=dumpPost}

   fun run spec =
      CM.return
         (Spec.upd
            (fn cps =>
               let
                  val (cps, cnt) = pass cps
                  val () = Stats.bump (clicks, cnt)
               in
                  cps
               end) spec)
   
   fun runCounting spec =
      let
         val (cps, cnt) = pass (Spec.get#declarations spec)
         val () = Stats.bump (clicks, cnt)
         (* val () = print (Int.toString cnt ^ "\n") *)
      in
         CM.return
            (Spec.upd (fn _ => cps) spec, cnt)
      end
end
