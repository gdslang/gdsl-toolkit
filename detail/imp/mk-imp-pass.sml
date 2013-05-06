
signature IMPCORE = sig

   val run: Imp.imp -> Imp.imp
   val name: string

end

functor MkIMPPass (Core: IMPCORE) = struct

   structure CM = CompilationMonad

   fun dumpPre (os, imp) =
      Pretty.prettyTo (os, Imp.PP.imp imp)
   fun dumpPost (os, t) = let
      open Layout Pretty
      fun prettyPass imp = 
         align
            [seq [str "imp.", str Core.name],
             Imp.PP.imp imp]
   in
     Pretty.prettyTo (os, prettyPass t)
   end

   fun runPass t = Core.run t

   val pass =
      BasicControl.mkKeepPass
         {passName=Core.name,
          registry=ImpControl.registry,
          pass=runPass,
          preExt="imp",
          preOutput=dumpPre,
          postExt="imp",
          postOutput=dumpPost}

   fun run spec = CM.return (Spec.upd pass spec)
   
end
