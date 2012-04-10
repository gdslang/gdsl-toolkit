
structure FromCPS : sig
   val run:
      CPS.Spec.t ->
         Closure.Spec.t CompilationMonad.t
end = struct

   structure CM = CompilationMonad
   structure FV = FreeVars

   val variable = Atom.atom "x"
   val function = Atom.atom "f"
   val closure = Atom.atom "c"

   local open CPS.Exp in

   fun conv spec =
      Spec.upd
         (fn cps =>
            (FV.run cps; FV.dump(); [])) spec : Closure.Spec.t

   end (* end local *)

   fun dumpPre (os, spec) = Pretty.prettyTo (os, CPS.PP.spec spec)
   fun dumpPost (os, spec) = Pretty.prettyTo (os, Closure.PP.spec spec) 

   val conv =
      BasicControl.mkKeepPass
         {passName="flatClosureConversion",
          registry=ClosureControl.registry,
          pass=conv,
          preExt="clos",
          preOutput=dumpPre,
          postExt="clos",
          postOutput=dumpPost}

   fun run spec = CM.return (conv spec)
end
