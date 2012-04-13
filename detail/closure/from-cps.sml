
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

      (* Assuming the corresponding function `f` is not part of `xs` *)
      fun unfoldEnv xs env {stmts, flow} =
         {stmts=mapi (fn (x, i) => Clos.LETREF (x, env, i+1)) xs@stmts,
          flow=flow}

      fun escapes f = Map.inDomain (!bindings, f)
      val isBound = escapes

      fun free sigma f = (* Subst.applyAll sigma *) (Set.listItems (FV.get f))
      fun freeUse sigma f = Subst.applyAll sigma (Set.listItems (FV.get f))
   
      fun convTerm sigma cps = 
         case cps of
            LETVAL (f, FN (k, xs, K), L) =>
               let
                  val () =
                     convFun sigma f K
                        (fn {env, body} =>
                           bindFun (f, env, k, xs, Clos.BLOCK body))
                  val {stmts, flow} = convTerm sigma L
               in
                  {stmts=stmts,
                   flow=flow}
               end
          | LETVAL (x, v, body) =>
               let
                  val {stmts, flow} = convTerm sigma body
               in
                  {flow=flow,
                   stmts=convCVal sigma x v@stmts}
               end
          | LETREC (ds, body) =>
               let
                  val _ = convRecs sigma ds
                  val body = convTerm sigma body
               in
                  body
               end
          | LETCONT (ds, body) =>
               let
                  val _ = convConts sigma ds
                  val body = convTerm sigma body
               in
                  body
               end
          | LETPRJ (y, f, x, body) =>
               let
                  val x = Subst.apply sigma x
                  val {stmts, flow} = convTerm sigma body
               in
                  {flow=flow,
                   stmts=Clos.LETPRJ (y, f, x)::stmts}
               end
          | LETUPD (y, x, ds, body) =>
               let
                  val x = Subst.apply sigma x
                  val fs = map #1 ds
                  val xs = map #2 ds
                  val env =
                     useAll sigma xs
                        (fn xs =>
                           [Clos.LETUPD (y, x, ListPair.zip (fs, xs))])
                  val {stmts, flow} = convTerm sigma body
               in
                  {flow=flow,
                   stmts=env@stmts}
               end
          | APP (f, k, xs) =>
               if isBound f
                  then
                     let   
                        val f = Subst.apply sigma f
                        val {env, body} = buildEnv sigma f
                        val k' = ref k
                        val xs' = ref xs
                        val stmts = 
                           use sigma k (fn k =>
                              useAll sigma xs (fn xs =>
                                 (k' := k; xs' := xs; body)))
                     in
                        {stmts=stmts,
                         flow=Clos.APP {f=f, closure=env, k= !k', xs= !xs'}}
                     end               
               else
                  let
                     val f = Subst.apply sigma f
                     val k' = ref k
                     val xs' = ref xs
                     val f' = Subst.copy f
                     val stmts =
                        use sigma k (fn k =>
                           useAll sigma xs (fn xs =>
                              (k' := k
                              ;xs' := xs
                              ;[Clos.LETREF (f', f, 0)])))
                     in
                        {stmts=stmts,
                         flow=Clos.APP {f=f', closure=f, k= !k', xs= !xs'}}
                     end
          | CC (k, xs) =>
               if isBound k
                  then
                     let
                        val k = Subst.apply sigma k
                        val {env, body} = buildEnv sigma k
                        val xs' = ref xs
                        val stmts =
                           useAll sigma xs (fn xs =>
                              (xs' := xs
                              ;body))
                     in
                        {stmts=stmts,
                         flow=Clos.CC {k=k, closure=env, xs= !xs'}}
                     end
               else
                  let
                     val k = Subst.apply sigma k
                     val k' = Subst.copy k
                     val xs' = ref xs
                     val stmts =
                        useAll sigma xs (fn xs =>
                           (xs' := xs
                           ;[Clos.LETREF (k', k, 0)]))
                  in
                     {stmts=stmts,
                      flow=Clos.CC {k=k', closure=k, xs= !xs'}}
                  end
          | CASE (x, ks) =>
               {stmts=[],
                flow=Clos.CASE (Subst.apply sigma x, convCases sigma ks)}

      and convCases sigma ks = map (fn (tag, c) => (tag, convCase sigma c)) ks
      and convCase sigma (k, xs) = Clos.BLOCK (convTerm sigma (CC (k, xs)))

      and convConts sigma ds = app (convCont sigma) ds
      and convCont sigma (k, xs, body) =
         convFun sigma k body
            (fn {env, body} =>
               bindCont (k, env, xs, Clos.BLOCK body))

      and convRecs sigma ds = app (convRec sigma) ds
      and convRec sigma (f, k, xs, body) =
         convFun sigma f body
            (fn {env, body} =>
               bindFun (f, env, k, xs, Clos.BLOCK body))

      and buildEnv sigma f =
         let
            val fs = freeUse sigma f
            val env = fresh closure
            val stmts = Clos.LETENV (env, f::fs)
         in
            {env=env, body=[stmts]}
         end

      and convFun sigma f body k =
         let
            val fs = free sigma f
            val ys = Subst.copyAll fs
            val sigma = Subst.extendAll sigma ys fs
            val body = convTerm sigma body
            val env = fresh closure
         in
            k {env=env, body=unfoldEnv ys env body}
         end

      and convCVal sigma x v =
         case v of
            PRI (f, xs) =>
               useAll sigma xs
                  (fn xs =>
                     [Clos.LETVAL (x, Clos.PRI (f, xs))])
          | INJ (tag, y) =>
               use sigma y
                  (fn y =>
                     [Clos.LETVAL (x, Clos.INJ (tag, y))])
          | REC ds =>
               let
                  val fs = map #1 ds
                  val xs = map #2 ds
               in
                  useAll sigma xs
                     (fn xs =>
                        [Clos.LETVAL (x, Clos.REC (ListPair.zip (fs, xs)))])
               end
          | INT i => [Clos.LETVAL (x, Clos.INT i)]
          | FLT f => [Clos.LETVAL (x, Clos.FLT f)]
          | STR s => [Clos.LETVAL (x, Clos.STR s)]
          | VEC v => [Clos.LETVAL (x, Clos.VEC v)]
          | UNT => [Clos.LETVAL (x, Clos.UNT)]
          | FN _ => raise CM.CompilationError

      and useAll sigma xs k =
         let
            val xs = Subst.applyAll sigma xs
            fun lp (xs, lets, ys) =
               case xs of
                  x::xs =>
                     if escapes x
                        then
                           let
                              val fs = freeUse sigma x
                              val closure = fresh closure
                           in
                              lp (xs,
                                  Clos.LETENV
                                    (closure, x::fs)::lets,
                                  closure::ys)
                           end
                     else lp (xs, lets, x::ys)
                | [] => rev lets@k (rev ys)
         in
            lp (xs, [], [])
         end

      and use sigma x k =
         let
            val x = Subst.apply sigma x
         in
            if escapes x
               then
                  let
                     val fs = freeUse sigma x
                     val closure = fresh closure
                  in
                     Clos.LETENV (closure, x::fs)::k closure
                  end
            else k x
         end
               
   in
      Spec.upd
         (fn cps =>
            (FV.run cps
            ;FV.dump()
            ;ignore(convTerm Subst.empty cps)
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
          preExt="cps",
          preOutput=dumpPre,
          postExt="clos",
          postOutput=dumpPost}

   fun run spec = CM.return (conv spec)
end
