
structure FromCPS : sig
   val run:
      CPS.Spec.t ->
         Closure.Spec.t CompilationMonad.t
end = struct

   structure CM = CompilationMonad
   structure FV = FreeVars
   structure FI = FunInfo
   structure Map = SymMap
   structure Set = SymSet
   structure Clos = Closure.Stmt

   val closure = Atom.atom "env"
   val label = Atom.atom "lab"
   val fresh = Aux.fresh

   local open CPS.Exp in

   fun conv spec = let
     
      val bindings = ref Map.empty
      val escapingvariants = ref Map.empty

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

      fun bindFastFun (f, k, xs, body) =
         bindings :=
            Map.insert
               (!bindings,
                f,
                Closure.Fun.FASTFUN
                  {f=f,
                   k=k,
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

      fun bindFastCont (k, xs, body) =
         bindings :=
            Map.insert
               (!bindings,
                k,
                Closure.Fun.FASTCONT
                  {k=k,
                   xs=xs,
                   body=body})

      fun bindEscaping f fesc =
         escapingvariants := Map.insert (!escapingvariants, f, fesc)

      val toStr = Layout.tostring o CPS.PP.var

      fun escapingVariantOf f = 
         case Map.find (!escapingvariants, f) of
            NONE => 
               raise Fail ("closureConversion.escapingVariantOf: " ^ toStr f)
          | SOME f' => f'

      fun boundFn f = FI.member f

      fun mapi f xs = 
         let
            fun lp (x::xs, i, acc) = lp (xs, i + 1, f (x, i)::acc)
              | lp ([], _, acc) = rev acc
         in
            lp (xs, 0, [])
         end

      fun checkArity f =
         case FI.find (fn x => x) f of
            NONE => ()
          | SOME (FI.F (_,_,[x],_)) => ()
          | SOME (FI.C (_,[x],_)) => ()
          | _ =>
               let
                  val f = Layout.tostring (CPS.PP.var f)
               in
                  raise Fail ("closureConversion.arity: " ^ f)
               end

      (* Assuming the corresponding function `f` is not part of `xs` *)
      fun unfoldEnv xs env {stmts, flow} =
         {stmts=mapi (fn (x, i) => Clos.LETREF (x, env, i+1)) xs@stmts,
          flow=flow}

      val escapes = boundFn
      val isBound = boundFn

      fun free sigma f = 
         List.filter
            (not o boundFn)
            ((Set.listItems (FV.get f)))
      fun freeUse sigma f =
         List.filter
            (not o boundFn)
            (Subst.applyAll sigma (Set.listItems (FV.get f)))
  
      fun convEscaping () =
         let
            fun mkEscapingVariant f =
               case f of
                  FI.F (f,k,xs,body) =>
                     if Census.count#esc f = 0 then () else
                     let
                        val fs = freeUse Subst.empty f
                        val f' = Subst.copyWithSuffix "esc" f
                        val k' = Subst.copy k
                        val fs' = Subst.copyAll fs
                        val xs' = Subst.copyAll xs
                        val env = fresh closure
                        val body =
                           unfoldEnv
                              fs'
                              env
                              {stmts=[],
                               flow=Clos.FASTAPP {f=f,k=k',xs=fs'@xs'}}
                     in
                        bindEscaping f f'
                       ;bindFun (f', env, k', xs', Clos.BLOCK body)
                     end
                | FI.C (k,xs,body) =>
                     if Census.count#esc k = 0 then () else
                     let
                        val fs = freeUse Subst.empty k
                        val k' = Subst.copyWithSuffix "esc" k
                        val fs' = Subst.copyAll fs
                        val xs' = Subst.copyAll xs
                        val env = fresh closure
                        val body =
                           unfoldEnv
                              fs'
                              env
                              {stmts=[],
                               flow=Clos.FASTCC {k=k,xs=fs'@xs'}}
                     in
                        bindEscaping k k'
                       ;bindCont (k', env, xs', Clos.BLOCK body)
                     end
         in
            FI.app mkEscapingVariant
         end

      fun convTerm sigma cps = 
         case cps of
            LETVAL (f, FN (k, xs, K), L) =>
               let
                  val () =
                     convFun sigma f K
                        (fn {fs, body} =>
                           bindFastFun (f, k, fs@xs, Clos.BLOCK body))
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
                        val fs = freeUse sigma f
                        val k' = ref k
                        val xs' = ref xs
                        val stmts = 
                           use sigma k (fn k =>
                              useAll sigma xs (fn xs =>
                                 (k' := k; xs' := xs; [])))
                     in
                        {stmts=stmts,
                         flow=Clos.FASTAPP {f=f, k= !k', xs=fs @ !xs'}}
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
                        val fs = freeUse sigma k
                        val xs' = ref xs
                        val stmts =
                           useAll sigma xs (fn xs => (xs' := xs;[]))
                     in
                        {stmts=stmts,
                         flow=Clos.FASTCC {k=k, xs=fs @ !xs'}}
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
            (fn {fs, body} =>
               bindFastCont (k, fs@xs, Clos.BLOCK body))

      and convRecs sigma ds = app (convRec sigma) ds
      and convRec sigma (f, k, xs, body) =
         convFun sigma f body
            (fn {fs, body} =>
               bindFastFun (f, k, fs@xs, Clos.BLOCK body))

      and buildEnv sigma f =
         let
            val fs = freeUse sigma f
            val f' = fresh label
            val env = fresh closure
            val stmts =
               [Clos.LETVAL (f', Clos.LAB f),
                Clos.LETENV (env, f'::fs)]
         in
            {label=f', env=env, body=stmts}
         end

      and convFun sigma f body k =
         let
            val fs = free sigma f
            val ys = Subst.copyAll fs
            val sigma = Subst.extendAll sigma ys fs
            val body = convTerm sigma body
         in
            k {fs=ys, body=body}
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
          | FN _ => raise Fail "closureConversion.bug"

      and useAll sigma xs k =
         let
            val xs = Subst.applyAll sigma xs
            fun lp (xs, lets, ys) =
               case xs of
                  x::xs =>
                     if escapes x
                        then
                           let
                              (* val _ = checkArity x *)
                              val fs = freeUse sigma x
                              val x = escapingVariantOf x
                              val l = fresh label
                              val closure = fresh closure
                           in
                              lp (xs,
                                  Clos.LETENV (closure, l::fs)::
                                  Clos.LETVAL (l, Clos.LAB x)::
                                  lets,
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
                     (* val _ = checkArity x *)
                     val fs = freeUse sigma x
                     val x = escapingVariantOf x
                     val l = fresh label
                     val closure = fresh closure
                  in
                     Clos.LETVAL (l, Clos.LAB x)::
                     Clos.LETENV (closure, l::fs)::
                     k closure
                  end
            else k x
         end
               
   in
      Spec.upd
         (fn cps =>
            (FV.run cps
            ;FI.run cps
            ;Census.run cps
            (* ;FV.dump() *)
            (* ;FI.dump() *)
            ;convEscaping()
            ;ignore(convTerm Subst.empty cps)
            ;Map.listItems (!bindings))) spec : Closure.Spec.t
   end


   end (* end local *)

   fun dumpPre (os, spec) = Pretty.prettyTo (os, CPS.PP.spec spec)
   fun dumpPost (os, spec) =
      Pretty.prettyTo
         (os,
          Layout.align
            [Closure.PP.spec spec,
             Layout.seq [Layout.str "freevars=", FV.layout()]]) 

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
