
structure FromCPS : sig
   val run:
      CPS.Spec.t ->
         Closure.Spec.t CompilationMonad.t
end = struct

   structure CM = CompilationMonad
   structure FV = FreeVars
   structure Map = SymMap
   structure Set = SymSet
   structure Clos = Closure.Stmt

   val variable = Atom.atom "x"
   val function = Atom.atom "f"
   val closure = Atom.atom "closure"
   val fresh = Aux.fresh

   local open CPS.Exp in

   fun conv spec = let
      
      val bindings = ref Map.empty

      fun bindFun (f, closure, k, xs, body) =
         bindings :=
            Map.insert
               (!bindings,
                f,
                Closure.Fun.FUN
                  {f=f,
                   k=k,
                   closure=closure,
                   xs=xs,
                   body=body})

      fun bindCont (k, closure, xs, body) =
         bindings :=
            Map.insert
               (!bindings,
                k,
                Closure.Fun.CONT
                  {k=k,
                   closure=closure,
                   xs=xs,
                   body=body})

      fun mapi f xs = 
         let
            fun lp (x::xs, i, acc) = lp (xs, i + 1, f (x, i)::acc)
              | lp ([], _, acc) = rev acc
         in
            lp (xs, 0, [])
         end

      fun unfoldEnv xs env {stmts, flow} =
         {stmts=mapi (fn (x, i) => Clos.LETREF (x, env, i)) xs@stmts,
          flow=flow}

      fun convTerm sigma cps = 
         case cps of
            LETVAL (x, FN (k, xs, K), L) =>
               let
                  val env = fresh closure
                  val fs = Set.listItems (FV.get x)
                  val fs = Subst.applyAll sigma fs
                  val ys = Subst.copyAll fs
                  val sigma' = Subst.extendAll sigma ys fs
                  val K = convTerm sigma' K
                  val K = unfoldEnv ys env K
                  val _ = bindFun (x, env, k, xs, Closure.Block.BLOCK K)

                  val clos = fresh closure
                  val sigma = Subst.extend sigma clos x
                  val {stmts, flow} = convTerm sigma L
               in
                  {stmts=Clos.LETENV (clos, x::fs)::stmts,
                   flow=flow}
               end
              

      and convCVal sigma v =
         case v of
            v => []
               
   in
      Spec.upd
         (fn cps =>
            (FV.run cps
            ;FV.dump()
            ;Map.listItems (!bindings))) spec : Closure.Spec.t
   end


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
