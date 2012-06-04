
structure Aux = struct
   val function = Atom.atom "f"
   val continuation = Atom.atom "k"
   val variable = Atom.atom "x"

   val variables = SymbolTables.varTable

   fun fresh variable = let
      val (tab, sym) =
         VarInfo.fresh (!variables, variable)
   in
      sym before SymbolTables.varTable := tab
   end

   fun atomOf x = VarInfo.getAtom (!variables, x)
   fun get s = VarInfo.lookup (!variables, Atom.atom s)
   fun failWithSymbol msg sym =
      msg ^ ": " ^ Layout.tostring (CPS.PP.var sym)
      
end

structure CheckDefUse = struct
   structure Set = SymSet
   open CPS.Exp
   infix ++
   type t = Set.set

   val census = ref Set.empty : t ref

   fun def x =
      if Set.member (!census, x)
         then raise Fail
               (Aux.failWithSymbol "checkDefUse.duplicateDefiniton" x)
      else census := Set.add (!census, x)

   fun use x = ()

   fun visitTerm n cps =
      case cps of
         LETVAL (x, v, t) => (def x; visitCVal n v; visitTerm n t)
       | LETREC (ds, t) => (app (visitDecl n) ds; visitTerm n t)
       | LETPRJ (x, _, y, t) => (def x; use y; visitTerm n t)
       | LETUPD (x, y, fs, t) =>
            (def x
            ;use y
            ;app (visitField n) fs
            ;visitTerm n t)
       | LETCONT (ds, t) => (app (visitCont n) ds; visitTerm n t)
       | APP (x, k, ys) =>
            (use x
            ;use k
            ;app use ys)
       | CC (k, xs) => (use k; app use xs)
       | CASE (x, ks) => (use x; app (visitMatch n) ks)

   and visitMatch n (_, (k, xs)) = (use k; app use xs)

   and visitField n (_, v) = use v

   and visitDecl n (f, k, xs, t) =
      (def f
      ;def k
      ;app def xs
      ;visitTerm n t)

   and visitCont n (k, xs, t) =
      (def k
      ;app def xs
      ;visitTerm n t)

   and visitCVal n cval = 
      case cval of
         FN (k, xs, t) => (def k; app def xs; visitTerm n t)
       | PRI (f, xs) => (use f; app use xs)
       | INJ (_, x) => use x
       | REC fs => app (visitField n) fs
       | _ => () 
         
   fun run t =
      let
         val _ = census := Set.empty
      in
         visitTerm 1 t
        ;census := Set.empty
      end
   val run = fn t =>
      run t
         handle (Fail s) => print ("Fail [" ^ s ^ "]\n")
end

structure Census = struct
   open CPS.Exp
   infix ++
   type t = {esc:int,app:int} SymMap.map 

   val census = ref SymMap.empty : t ref

   fun count s x =
      case SymMap.find (!census, x) of
         NONE => s {esc= ~1,app= ~1}
       | SOME i => s i

   fun count0 s x =
      case SymMap.find (!census, x) of
         NONE => s {esc=0,app=0}
       | SOME i => s i

   fun countAll x =
      let
         val {esc,app} = count (fn i=>i) x
      in
         esc+app
      end

   fun copy {src, dst} = 
      case SymMap.find (!census, src) of
         SOME i => census := SymMap.insert (!census, dst, i)
       | _ => ()

   fun def x =
      case SymMap.find (!census, x) of
         NONE => census := SymMap.insert (!census, x, {esc=0,app=0})
       | _ => ()

   fun update f x =
      case SymMap.find (!census, x) of
         NONE => census := SymMap.insert (!census, x, f {esc=0,app=0})
       | SOME m => census := SymMap.insert (!census, x, f m)

   fun E n {esc,app} = {esc=esc+n,app=app}
   fun A n {esc,app} = {esc=esc,app=app+n}
   fun {esc=n,app=m} ++ {esc=_,app=q} = {esc=n,app=m+q-1}

   fun remove x =
      if SymMap.inDomain (!census, x)
         then #1 (SymMap.remove (!census, x))
      else !census

   fun extendApp x y =
      case SymMap.find (!census, y) of
         NONE => census := remove x
       | SOME n =>
            census :=
               (case SymMap.find (!census, x) of
                  NONE => !census
                | SOME m => SymMap.insert (!census, x, m++n))

   fun extendAppAll sigma xs ys =
      app (fn (y, x) => extendApp y x)
          (ListPair.zip (xs, ys))

   val remove = fn x => census := remove x
   fun removeAll xs = app remove xs

   fun visitTerm n cps =
      case cps of
         LETVAL (x, v, t) => (def x; visitCVal n v; visitTerm n t)
       | LETREC (ds, t) => (app (visitDecl n) ds; visitTerm n t)
       | LETPRJ (x, _, y, t) => (def x; update (E n) y; visitTerm n t)
       | LETUPD (x, y, fs, t) =>
            (def x
            ;update (E n) y
            ;app (visitField n) fs
            ;visitTerm n t)
       | LETCONT (ds, t) => (app (visitCont n) ds; visitTerm n t)
       | APP (x, k, ys) =>
            (update (A n) x
            ;update (E n) k
            ;app (update (E n)) ys)
       | CC (k, xs) => (update (A n) k; app (update (E n)) xs)
       | CASE (x, ks) => (update (E n) x; app (visitMatch n) ks)

   and visitMatch n (_, (k, xs)) = (update (A n) k; app (update (E n)) xs)

   and visitField n (_, v) = update (E n) v

   and visitDecl n (f, k, xs, t) =
      (def f
      ;def k
      ;app def xs
      ;visitTerm n t)

   and visitCont n (k, xs, t) =
      (def k
      ;app def xs
      ;visitTerm n t)

   and visitCVal n cval = 
      case cval of
         FN (k, xs, t) => (def k; app def xs; visitTerm n t)
       | PRI (f, xs) => (update (A n) f; app (update (E n)) xs)
       | INJ (_, x) => update (E n) x
       | REC fs => app (visitField n) fs
       | _ => () 
         
   fun layout () =
      Pretty.symmap
         {key=CPS.PP.var,
          item=fn {esc,app} =>
            Layout.record [("esc",Pretty.I esc),("app",Pretty.I app)]}
         (!census)

   fun run t =
      let
         val _ = census := SymMap.empty
      in
         visitTerm 1 t
      end
end

(* Currently `FreeVars` is br0k3n considering mutually recursive functions *)
structure FreeVars = struct
   structure Map = SymMap
   structure Set = SymSet
   type t = Set.set Map.map

   val freevars = ref Map.empty : t ref
   fun reset () = freevars := Map.empty
   fun set f xs =
      if Set.isEmpty xs
         then ()
      else freevars := Map.insert (!freevars, f, xs)
   fun get f =
      case Map.find (!freevars, f) of
         NONE => Set.empty
       | SOME xs => xs

   fun merge a b = Set.union (a, b)
   fun def env x = Set.delete (env, x) handle NotFound => env
   fun use env x = merge (Set.add (env, x)) (get x)
   fun useAll env xs = foldl (fn (x, env) => use env x) env xs
   fun defAll env xs = foldl (fn (x, env) => def env x) env xs
   fun defAllWith f env xs = foldl (fn (x, env) => def env (f x)) env xs

   fun run cps = let
      open CPS.Exp
      fun visitTerm (env, cps) = 
         case cps of
            LETVAL (x, v as (FN _), body) =>
               let
                  val env' = visitCVal (env, v)
                  val _ = set x env'
                  val env = visitTerm (env, body)
                  val env = def env x
               in
                  env
               end
          | LETVAL (x, v, body) =>
               let
                  val env = visitTerm (env, body)
                  val env = visitCVal (env, v)
                  val env = def env x
               in
                  env
               end
          | LETREC (ds, body) =>
               let
                  (* PERF *)
                  fun merge' () =
                     app
                        (fn (f, k, xs, body) =>
                           let
                              val env = visitTerm (env, body)
                              (* val env = def env f *)
                              val env = def env k
                              val env = defAll env xs
                              val env = defAllWith #1 env ds 
                           in
                              set f env
                           end) ds
                  val _ = merge'()
                  val _ = merge'()
                  val env = visitTerm (env, body)
                  val env =
                     foldl
                        (fn ((f, _, _, _), env) =>
                           merge (get f) env) env ds
                  val env = defAllWith #1 env ds
               in
                  env
               end
          | LETCONT (ds, body) =>
               let
                  (* PERF *)
                  fun merge' () =
                     app
                        (fn (k, xs, body) =>
                           let
                              val env = visitTerm (env, body)
                              (* val env = def env k *)
                              val env = defAll env xs
                              val env = defAllWith #1 env ds 
                           in
                              set k env
                           end) ds
                  val _ = merge'()
                  val _ = merge'()
                  val env = visitTerm (env, body)
                  val env =
                     foldl
                        (fn ((k, _, _), env) =>
                           merge (get k) env) env ds
                  val env = defAllWith #1 env ds
               in
                  env
               end
          | LETPRJ (y, _, x, body) =>
               let
                  val env = visitTerm (env, body)
                  val env = use env x
                  val env = def env y
               in
                  env
               end
          | LETUPD (y, x, fs, body) =>
               let
                  val env = visitTerm (env, body)
                  val env = use env x
                  val env = useAll env (map #2 fs)
                  val env = def env y
               in
                  env
               end
          | APP (f, k, xs) =>
               let
                  val env = use env f
                  val env = use env k
                  val env = useAll env xs
               in
                  env
               end
          | CC (k, xs) =>
               let
                  val env = use env k
                  val env = useAll env xs
               in
                  env
               end
          | CASE (x, ks) =>
               let
                  val env = use env x
                  val env =
                     foldl
                        (fn ((_,(k,xs)), env) =>
                           let
                              val env = use env k
                              val env = useAll env xs
                           in
                              env
                           end) env ks
               in
                  env
               end

      and visitCVal (env, cval) =
         case cval of
            FN (k, xs, body) =>
               let
                  val env = visitTerm (env, body)
                  val env = def env k
                  val env = defAll env xs
               in
                  env
               end
          | PRI (_, xs) => useAll env xs
          | INJ (_, x) => use env x
          | REC fs => useAll env (map #2 fs)
          | _ => env
   in
      (reset();visitTerm (Set.empty, cps))
   end
  
   fun layout () =
      Pretty.symmap
         {key=CPS.PP.var,
          item=Pretty.symset CPS.PP.var} (!freevars)
      
   fun dump () = Pretty.prettyTo(TextIO.stdOut, layout())
end

structure Subst = struct
   type t = Core.sym SymMap.map

   val empty = SymMap.empty
   fun apply sigma x =
      case SymMap.find (sigma, x) of
         NONE => x
       | SOME y => y
   fun applyAll sigma xs = map (apply sigma) xs
   fun extend sigma x y =
      SymMap.insert (sigma, y, x)
   fun extendAll sigma xs ys =
      foldl
         (fn ((y, x), sigma) =>
            extend sigma y x)
         sigma (ListPair.zip (xs, ys))

   fun copy x =
      let
         val name = Aux.atomOf x
         val x' = Aux.fresh name
      in
         x'
      end

   fun copyWithSuffix s x =
      let
         val name = Aux.atomOf x
         val name = Atom.toString name
         val x' = Aux.fresh (Atom.atom (name ^ "#" ^ s))
      in
         x'
      end

   fun copyAll xs = map copy xs

   fun renameAll sigma xs =
      let
         val ys = copyAll xs
         val sigma = extendAll sigma ys xs
      in
         (sigma, ys)
      end

   fun renameOne sigma x =
      let
         val y = copy x
         val sigma = extend sigma y x
      in
         (sigma, y)
      end

   local open CPS.Exp in
  
   fun renameTerm cps = rename empty cps
   and rename sigma cps =
      case cps of
         LETVAL (x, v, t) =>
            let
               val x' = copy x
               val sigma = extend sigma x' x
            in
               LETVAL (x', renameCVal sigma v, rename sigma t)
            end
       | LETREC (ds, t) =>
            let
               val (sigma, ds) = renameRecs sigma ds
            in
               LETREC (ds, rename sigma t) 
            end 
       | LETPRJ (x, f, y, t) =>
            let
               val x' = copy x
               val y' = apply sigma y
               val sigma = extend sigma x' x
            in
               LETPRJ (x', f, y', rename sigma t)
            end
       | LETUPD (x, y, fs, t) =>
            let
               val x' = copy x
               val y' = apply sigma y
               val fs'= map (fn (f, x) => (f, apply sigma x)) fs
               val sigma = extend sigma x' x
            in
               LETUPD (x', y', fs', rename sigma t)
            end
       | LETCONT (ds, t) =>
            let
               val (sigma, ds) = renameConts sigma ds
            in
               LETCONT (ds, rename sigma t)
            end
       | APP (f, k, xs) =>
            APP
               (apply sigma f,
                apply sigma k,
                applyAll sigma xs)
       | CC (k, xs) => CC (apply sigma k, applyAll sigma xs)
       | CASE (x, ks) =>
            CASE
               (apply sigma x,
                map
                  (fn (tags, (k, xs)) =>
                     (tags, (apply sigma k, applyAll sigma xs))) ks)

   and renameRecs sigma ds =
      let
         val sigma = foldl renameRec sigma ds
      in
         (sigma,
          map
            (fn (f, k, xs, t) =>
               (apply sigma f,
                apply sigma k,
                applyAll sigma xs,
                rename sigma t)) ds)
      end
   
   and renameRec ((f, k, xs, _), sigma) =
      let
         val f' = copy f
         val k' = copy k
         val xs' = copyAll xs
         val sigma = extend sigma f' f
         val sigma = extend sigma k' k
         val sigma = extendAll sigma xs' xs
      in
         sigma
      end
  
   and renameConts sigma ds = 
      let
         val sigma = foldl renameCont sigma ds
      in
         (sigma,
          map
            (fn (k, xs, t) =>
               (apply sigma k,
                applyAll sigma xs,
                rename sigma t)) ds)
      end

   and renameCont ((k, xs, t), sigma) =
      let
         val k' = copy k
         val xs' = copyAll xs
         val sigma = extend sigma k' k
         val sigma = extendAll sigma xs' xs
      in
         sigma
      end

   and renameCVal sigma v =
      case v of
         FN (k, xs, t) =>
            let
               val k' = copy k
               val xs' = copyAll xs
               val sigma = extend sigma k' k
               val sigma = extendAll sigma xs' xs
            in
               FN (k', xs', rename sigma t)
            end
       | PRI (f, xs) => PRI (apply sigma f, applyAll sigma xs)
       | INJ (c, x) => INJ (c, apply sigma x)
       | REC fs => REC (map (fn (f, x) => (f, apply sigma x)) fs)
       | otherwise => otherwise

   end (* local *)

(*
   val rename = fn sigma => fn cps =>
      let
         val cps' = rename sigma cps
      in
         (print"\nin:\n";
          Pretty.prettyTo(TextIO.stdOut, CPS.PP.term cps);
          print"\nout:\n";
          Pretty.prettyTo(TextIO.stdOut, CPS.PP.term cps');
          cps')
      end
      *)
end

structure Rec = struct
   structure Map = SymMap
   structure Set = SymSet
   open CPS.Exp
   type t = SymSet.set

   val clicks = Stats.newCounter "cps.rec.clicks"
   fun click () = Stats.tick clicks
   val recs = ref Set.empty

   fun use (env, recs) x = (Set.add (env, x), recs)
   fun uses (env, recs) xs =
      (foldl (fn (x, env) => Set.add (env, x)) env xs, recs)
   fun recuse (env, recs) f = (env, Set.add (recs, f))
   fun unuse (env, recs) x = (Set.delete (env, x) handle NotFound => env, recs)
   fun unuses (env, recs) xs =
      (foldl
         (fn (x, env) =>
            Set.delete (env, x) handle NotFound => env) env xs, recs)
   val empty = (Set.empty, Set.empty)
   fun merge ((env1, recs1), (env2, recs2)) =
      (Set.union (env1, env2), Set.union (recs1, recs2))
   fun isRec f = Set.member (!recs, f)
   
   fun run cps = let
      fun visitTerm (cps, env) = 
         case cps of
             APP (f, k, xs) =>
               let 
                  val env = use env f
                  val env = use env k
                  val env = uses env xs
               in
                  env
               end
           | CC (j, xs) =>
               let
                  val env = use env j
                  val env = uses env xs
               in
                  env
               end
           | LETPRJ (y, _, x, t) => unuse (use (visitTerm (t, env)) x) y
           | LETUPD (y, x, fs, t) =>
               let
                  val env = visitTerm (t, env)
                  val env = use env x
                  val env = uses env (map #2 fs)
               in
                  unuse env y
               end
           | LETREC (ds, t) =>
               let
                  val env = visitRecs (ds, env)
                  val env = visitTerm (t, env)
               in
                  env
               end
           | LETCONT (ds, t) =>
               let
                  val env = visitConts (ds, env)
                  val env = visitTerm (t, env)
               in
                  env
               end
           | LETVAL (x, v, t) => unuse (visitCVal (v, visitTerm (t, env))) x 
           | CASE (x, ks) =>
               let
                  val env = use env x
                  val env = visitCases (ks, env)
               in
                  env
               end

      and visitCases (ks, env) = 
         foldl
            (fn ((_,(k,xs)), env) =>
               let
                  val env = use env k
                  val env = uses env xs
               in
                  env
               end) env ks

      and printUses uses =
         let
            open Layout Pretty
            fun sym s = str (VarInfo.getString (!SymbolTables.varTable, s))
            fun set (s, _) =
               list (List.map sym (Set.listItems s))
            fun binding (f, s) = seq [sym f, str " = ", set s] 
         in
            prettyTo (TextIO.stdOut,
               seq [list (map binding (Map.listItemsi uses)), str "\n"])
         end

      and visitRecs (ds, env) =
         let
            val uses =
               foldl
                  (fn ((f, k, xs, t), uses) =>
                     let
                        val env = visitTerm (t, unuse env f)
                        val env = unuse env k
                        val env = unuses env xs
                     in
                        Map.insert (uses, f, env)
                     end) Map.empty ds

            val transitiveUses =
               Map.mapi
                  (fn (f, (site, _)) =>
                     Set.foldl
                        (fn (g, closure) =>
                           case Map.find (uses, g) of
                              NONE => closure
                            | SOME (uses, _) => Set.union (closure, uses))
                         site site) uses
            
            fun isRec f =
               case Map.find (transitiveUses, f) of
                  SOME uses => Set.member (uses, f)
                | _ => false

            val env =
               Map.foldli
                  (fn (f, uses, env) =>
                     let
                        val env = merge (uses, env)
                     in
                        if isRec f
                           then recuse env f
                        else env
                     end) empty uses 
         in
            env
         end

      and visitConts (ds, env) =
         let
            val uses =
               foldl
                  (fn ((k, xs, t), uses) =>
                     let
                        val env = visitTerm (t, unuse env k)
                        val env = unuses env xs
                     in
                        Map.insert (uses, k, env)
                     end) Map.empty ds

            val transitiveUses =
               Map.mapi
                  (fn (f, (site, _)) =>
                     Set.foldl
                        (fn (g, closure) =>
                           case Map.find (uses, g) of
                              NONE => closure
                            | SOME (uses, _) => Set.union (closure, uses))
                         site site) uses

            val env =
               Map.foldli
                  (fn (f, uses, env) =>
                     let
                        val env = merge (uses, env)
                     in
                        if isRec f
                           then recuse env f
                        else env
                     end) empty uses 
         in
            env
         end

      and visitCVal (cv, env) =
         case cv of
            INJ (_, x) => use env x
          | REC fs => uses env (map #2 fs)
          | PRI (f, xs) => uses env (f::xs)
          | FN (k, xs, t) =>
             let
                val env = visitTerm (t, env)
                val env = unuse env k
                val env = unuses env xs
             in
                env
             end
          | _ => env
   in
      recs := #2 (visitTerm (cps, empty))
   end
   fun layout() = Pretty.symset CPS.PP.var (!recs) 
end

structure FunInfo = struct
   structure Map = SymMap
   open CPS CPS.Exp
   datatype t =
      F of Var.v * Var.c * Var.v list * term
    | C of Var.c * Var.v list * term

   val env = ref Map.empty : t SymMap.map ref
   fun reset () = env := Map.empty
   fun bindFun (f, (k, xs, K)) =
      env := Map.insert (!env, f, F (f, k, xs, K))
   fun bindCont (k, (xs, K)) =
      env := Map.insert (!env, k, C (k, xs, K))
   fun lookup s f = s (Map.lookup (!env, f))
   fun find s f = Option.map s (Map.find (!env, f))
   fun getFun (F x) = x
     | getFun _ = raise Match
   fun getCont (C x) = x
     | getCont _ = raise Match

   fun member k = Map.inDomain (!env, k)

   val lookupFun = lookup getFun
   val lookupCont = lookup getCont
   val findFun = find getFun
   val findCont = find getCont

   fun visitTerm t =
      case t of
         LETVAL (f, FN (k, xs, K), L) =>
            (visitTerm K
            ;bindFun (f, (k, xs, K))
            ;visitTerm L)
       | LETVAL (x, v, L) => visitTerm L
       | LETPRJ (_, _, _, body) => visitTerm body
       | LETUPD (_, _, _, body) => visitTerm body
       | LETCONT (cs, body) =>
            (app (fn (k, xs, K) =>
               (visitTerm K
               ;bindCont (k, (xs, K)))) cs
            ;visitTerm body)
       | LETREC (ds, body) =>
            (app (fn (f, k, xs, K) =>
               (visitTerm K
               ;bindFun (f, (k, xs, K)))) ds
            ;visitTerm body)
       | _ => ()
   fun run t = (reset();visitTerm t)

   fun app f = Map.app f (!env)

   fun dump () =
      Pretty.prettyTo
         (TextIO.stdOut,
          Pretty.symmap
            {key=CPS.PP.var,
             item=fn _ => Pretty.empty} (!env))
end

structure Cost = struct
   open CPS CPS.Exp
   structure FI = FunInfo
   structure Set = SymSet
   
   val env = ref Set.empty
   val allwaysInline = ref Set.empty
   val neverInline = ref Set.empty
   fun reset () =
      (env:=Set.empty
      ;allwaysInline:=Set.fromList (map Aux.get
         [">>",
          "return",
          ">>=",
          "consume",
          "unconsume",
          "slice",
          "update",
          "raise",
          "query",
          "and",
          "==",
          "not",
          "^",
          "arity0",
          "unop",
          "binop",
          "ternop",
          "quaternop"])
       ;neverInline:=Set.fromList (map Aux.get []))

   val allwaysInline = fn f => Set.member (!allwaysInline, f)

   fun isInliningCandidate t =
      let
         fun CASES f {cases,conts,recs,apps,ccs} = 
            {cases=f cases,conts=conts,recs=recs,apps=apps,ccs=ccs}
         fun CONTS f {cases,conts,recs,apps,ccs} = 
            {cases=cases,conts=f conts,recs=recs,apps=apps,ccs=ccs}
         fun RECS f {cases,conts,recs,apps,ccs} = 
            {cases=cases,conts=conts,recs=f recs,apps=apps,ccs=ccs}
         fun APPS f {cases,conts,recs,apps,ccs} = 
            {cases=cases,conts=conts,recs=recs,apps=f apps,ccs=ccs}
         fun CCS f {cases,conts,recs,apps,ccs} = 
            {cases=cases,conts=conts,recs=recs,apps=apps,ccs=f ccs}
         fun inc t f n = f (fn m => n+m) t
         fun lp (t, n) =
            case t of
               LETVAL (_, FN (k, xs, K), L) => lp (K, lp (L, n))
             | LETVAL (_, PRI _, body) => lp (body, n)
             | LETVAL (_, _, body) => lp (body, n)
             | LETPRJ (_, _, _, body) => lp (body, n)
             | LETUPD (_, _, _, body) => lp (body, n)
             | LETCONT (cs, body) =>
               foldl
                  (fn ((_, _, body), n) =>
                     lp (body, n)) (lp (body, inc n CONTS (length cs))) cs
             | LETREC (ds, body) =>
               foldl
                  (fn ((_, _, _, body), n) =>
                     lp (body, n)) (lp (body, inc n RECS (length ds))) ds
             | CASE (_, cs) => inc n CASES (length cs)
             | APP _ => inc n APPS 1
             | CC _ => inc n CCS 1
         val ZERO = {cases=0,conts=0,recs=0,apps=0,ccs=0}
         val {cases,recs,...} = lp (t, ZERO)
      in
         cases <= 2 andalso recs = 0
      end
   fun mark () =
      FI.app
         (fn FI.F (f, k, xs, body) =>
               if isInliningCandidate body
                  then env := Set.add (!env, f)
               else ()
           | FI.C (k, xs, body) =>
               if isInliningCandidate body
                  then env := Set.add (!env, k)
               else ())
   fun inlineCandidate f = not (Set.member (!neverInline, f)) andalso Set.member (!env, f)
   fun run () = (reset();mark()) 
end

structure BetaPair :> sig
   val name: string
   val run: CPS.Exp.t -> CPS.Exp.t * int
end = struct
   open CPS.Exp
   structure CM = CompilationMonad
   structure Map = SymMap
   structure Set = SymSet

   val clicks = ref 0
   fun click () = clicks := !clicks + 1
   fun reset () = clicks := 0

   val eq = SymbolTable.eq_symid
   
   fun updateEnv env x fs = 
      let
         fun insertField ((f, x), env) = Map.insert (env, f, x)
         fun insertAll env fs = foldl insertField env fs
      in
         case Map.find (env, x) of
            NONE => insertAll Map.empty fs
          | SOME fss => insertAll fss fs
      end

   fun simplify env sigma t =
      case t of
         LETVAL (y, REC fs, L) =>
            let
               val y = Subst.apply sigma y
               val fs = map (fn (f, x) => (f, Subst.apply sigma x)) fs
               val env' =
                  Map.insert
                     (env,
                      y,
                      foldl
                        (fn ((f, x), fs) =>
                           Map.insert (fs, f, x)) Map.empty fs)
            in
               LETVAL (y, REC fs, simplify env' sigma L)
            end
       | LETVAL (x, v, L) =>
            LETVAL
               (x,
                simplifyVal env sigma v,
                simplify env sigma L)
       | LETREC (ds, t) =>
            LETREC
               (map (simplifyRec env sigma) ds,
                simplify env sigma t)
       | LETPRJ (y, f, x, K) =>
            let
               val x = Subst.apply sigma x
               val env' = Map.insert (env, x, updateEnv env x [(f, y)])
            in
               case Map.find (env, x) of
                  NONE => LETPRJ (y, f, x, simplify env' sigma K)
                | SOME fs =>
                     (case Map.find (fs, f) of
                        NONE => LETPRJ (y, f, x, simplify env' sigma K)
                      | SOME x =>
                           let
                              val sigma = Subst.extend sigma x y
                           in
                              click(); simplify env sigma K
                           end)
            end
       | LETUPD (x, y, fs, K) =>
            let
               val y = Subst.apply sigma y
               val fs = map (fn (f, x) => (f, Subst.apply sigma x)) fs
               val env' =
                  Map.insert
                     (env,
                      x,
                      updateEnv env y fs)
            in
               LETUPD (x, y, fs, simplify env' sigma K)
            end
       | LETCONT (cs, t) =>
            LETCONT
               (map (fn (k, x, t) => (k, x, simplify env sigma t)) cs,
                simplify env sigma t)
       | CC (k, xs) =>
            CC (Subst.apply sigma k, Subst.applyAll sigma xs)
       | CASE (x, cs) =>
            CASE
               (Subst.apply sigma x,
                map
                  (fn (tags,(k,xs)) =>
                     (tags,(Subst.apply sigma k, Subst.applyAll sigma xs))) cs)
       | APP (f, j, ys) =>
            let
               val f = Subst.apply sigma f
               val j = Subst.apply sigma j
               val ys = Subst.applyAll sigma ys
            in
               APP (f, j, ys)
            end
   
   and simplifyRec env sigma (f, k, xs, t) =
      (f, k, xs, simplify env sigma t)
   
   and simplifyVal env sigma v =
      case v of
         FN (k, x, t) => FN (k, x, simplify env sigma t)
       | INJ (t, x) => INJ (t, Subst.apply sigma x)
       | PRI (f, xs) => PRI (Subst.apply sigma f, Subst.applyAll sigma xs)
       | REC _ => raise Fail "betaPair.bug"
       | otherwise => otherwise
  
   val name = "betaPair"
   fun run t =
      let
         val () = reset ()
         val _ = Census.run t
         val t' = simplify Map.empty Subst.empty t
      in
         (t', !clicks)
      end
end

structure HoistFun = struct
   open CPS.Exp
   structure Map = SymMap
   structure Set = SymSet

   val clicks = ref 0
   fun click () = clicks := !clicks + 1
   fun reset () = clicks := 0

   fun simplify env sigma t =
      case t of
         LETVAL (f, FN (k, xs, K), L) =>
            LETVAL
               (f,
                FN (k, xs, simplify env sigma K),
                simplify env sigma L)
       | LETVAL (x, v, K) =>
            (case simplify env sigma K of
               K as LETVAL (f, FN (k, xs, L), M as CC (_,[g])) => 
                  if not (VarInfo.eq_symid (g, f))
                     then LETVAL (x, v, K)
                  else 
                     (click();
                      LETVAL
                        (f,
                         FN
                           (k,
                            xs,
                            LETVAL (x, simplifyVal env sigma v, L)),
                         M))
             | K => LETVAL (x, v, K))
       | LETREC (ds, L) =>
            LETREC
               (simplifyRecs env sigma ds,
                simplify env sigma L)
       | LETPRJ (x, f, y, t) =>
            LETPRJ
               (x,
                f,
                Subst.apply sigma y,
                simplify env sigma t)
       | LETUPD (x, y, fs, t) =>
            LETUPD
               (x,
                Subst.apply sigma y,
                map (fn (f, z) => (f, Subst.apply sigma z)) fs,
                simplify env sigma t)
       | LETCONT (cs, t) =>
            LETCONT
               (map (fn (k, x, t) => (k, x, simplify env sigma t)) cs,
                simplify env sigma t)
       | CC (k, xs) =>
            CC (Subst.apply sigma k, Subst.applyAll sigma xs)
       | CASE (x, cs) =>
            CASE
               (Subst.apply sigma x,
                map
                  (fn (tags,(k,xs)) =>
                     (tags,(Subst.apply sigma k, Subst.applyAll sigma xs))) cs)
       | APP (f, j, ys) =>
            let
               val f = Subst.apply sigma f
               val j = Subst.apply sigma j
               val ys = Subst.applyAll sigma ys
            in
               APP (f, j, ys)
            end

   and simplifyRecs env sigma ds = map (simplifyRec env sigma) ds
  
   and simplifyRec env sigma (f, k, [], K) =
      (case simplify env sigma K of
         K as LETVAL (g, FN (l, [x], L), M) =>
            (case M of
               CC (j, [h]) =>
                  if VarInfo.eq_symid (j, k)
                     andalso VarInfo.eq_symid (g, h)
                     then (click(); (f, l, [x], L))
                  else (f, k, [], K)
             | _ => (f, k, [], K))
       | K => (f, k, [], K))
     | simplifyRec env sigma (f, k, xs, K) = (f, k, xs, simplify env sigma K)

   and simplifyVal env sigma v =
      case v of
         FN (k, x, t) => FN (k, x, simplify env sigma t)
       | INJ (t, x) => INJ (t, Subst.apply sigma x)
       | REC fs => REC (map (fn (f, x) => (f, Subst.apply sigma x)) fs)
       | PRI (f, xs) => PRI (Subst.apply sigma f, Subst.applyAll sigma xs)
       | otherwise => otherwise
  
   val name = "hoistFun"
   fun run t =
      let
         val _ = reset ()
         val t' = simplify Map.empty Subst.empty t
      in
         (t', !clicks)
      end
end

structure DeadVal = struct
   open CPS.Exp
   structure Map = SymMap

   val clicks = ref 0
   fun click () = clicks := !clicks + 1
   fun reset () = clicks := 0

   fun simplify t =
      case t of
        LETVAL (x, v, K) =>
         if Census.countAll x = 0
            then (click(); simplify K)
         else
            LETVAL
               (x,
                simplifyVal v,
                simplify K)
      | LETREC (ds, K) =>
         (case simplifyRecs ds of
            [] => (click(); simplify K)
          | ds => LETREC (ds, simplify K))
      | LETPRJ (x, f, y, K) =>
         if Census.countAll x = 0
            then (click(); simplify K)
         else
            LETPRJ
               (x,
                f,
                y,
                simplify K)
      | LETUPD (x, y, fs, K) =>
         if Census.countAll x = 0
            then (click(); simplify K)
         else
            LETUPD
               (x,
                y,
                fs,
                simplify K)
      | LETCONT (cs, K) =>
         (case simplifyCCs cs of
            [] => (click(); simplify K)
          | cs => LETCONT (cs, simplify K))
      | otherwise => otherwise
   
   and simplifyRecs ds =
      let
         val ds =
            List.filter
               (fn (f, _, _, _) =>
                  let
                     val notDead = Census.countAll f <> 0
                  in
                     if notDead
                        then true
                     else (click(); false)
                  end) ds
      in
         map (fn (f, k, xs, t) => (f, k, xs, simplify t)) ds
      end
  
   and simplifyCCs ds =
      let
         val ds =
            List.filter
               (fn (k, _, _) =>
                  let
                     val notDead = Census.countAll k <> 0
                  in
                     if notDead
                        then true
                     else (click(); false)
                  end) ds
      in
         map (fn (k, xs, t) => (k, xs, simplify t)) ds
      end

   and simplifyVal v =
      case v of
         FN (k, x, t) => FN (k, x, simplify t)
       | otherwise => otherwise
  
   val name = "deadVal"
   fun run t =
      let
         val () = reset ()
         val _ = Census.run t
         val t' = simplify t
      in
         (t', !clicks)
      end
end

structure BetaContFun = struct
   structure FI = FunInfo
   structure Map = SymMap
   structure Set = SymSet
   open CPS CPS.Exp

   val clicks = ref 0
   val inlined = ref Map.empty : int Map.map ref
   fun click () = clicks := !clicks + 1
   fun reset () = (clicks := 0; inlined := Map.empty)

   fun count0 x =
      case Map.find (!inlined, x) of
         NONE => 0
       | SOME n => n

   fun markInlined f =
      inlined := Map.insert(!inlined, f, count0 f + 1)

   fun isInliningCandidate f body =
      not (Rec.isRec f) andalso
         (Cost.allwaysInline f orelse
          (Census.count#app f > 1 andalso Cost.inlineCandidate f))

   fun isInliningCandidateCont k body =
      not (Rec.isRec k) andalso
         (Census.count#app k > 1 (* andalso Cost.inlineCandidate k*))

   datatype t =
      F of Var.c * Var.v list * term
    | C of Var.v list * term

   fun insertFun (env, f, body) = Map.insert (env, f, F body)
   fun insertCont (env, k, body) = Map.insert (env, k, C body)

   fun lookup s (env, f) = s (Map.lookup (env, f))
   fun find s (env, f) = Option.map s (Map.find (env, f))

   fun getFun (F x) = x
     | getFun _ = raise Match
   fun getCont (C x) = x
     | getCont _ = raise Match

   val lookupFun = lookup getFun
   val lookupCont = lookup getCont
   val findFun = find getFun
   val findCont = find getCont

   fun simplify env sigma t =
      case t of
         LETVAL (f, FN (k, xs, K), L) =>
            let
               val K = simplify env sigma K
               val env' = insertFun (env, f, (k, xs, K))
               val L = simplify env' sigma L
            in
               LETVAL (f, FN (k, xs, K), L)
            end
      | LETVAL (x, v, L) =>
        LETVAL
            (x,
             simplifyVal env sigma v,
             simplify env sigma L)
      | LETPRJ (x, f, y, t) =>
         LETPRJ
            (x,
             f,
             Subst.apply sigma y,
             simplify env sigma t)
      | LETUPD (x, y, fs, t) =>
         LETUPD
            (x,
             Subst.apply sigma y,
             map (fn (f, z) => (f, Subst.apply sigma z)) fs,
             simplify env sigma t)
      | CASE (x, cs) =>
         CASE
            (Subst.apply sigma x,
             map
               (fn (tags,(k,xs)) =>
                  (tags,(Subst.apply sigma k, Subst.applyAll sigma xs))) cs)
      | LETREC (ds, L) =>
         let
            val env' = 
               foldl
                  (fn ((f, k, xs, K), env) =>
                     insertFun (env, f, (k, xs, K))) env ds
            val L = simplify env' sigma L
         in
            LETREC
               (map (fn (f, k, xs, K) =>
                  (f, k, xs, simplify env' sigma K)) ds,
                L)
         end
      | LETCONT (cs, L) =>
         let
            val env' = 
               foldl
                  (fn ((k, xs, K), env) =>
                     insertCont (env, k, (xs, K))) env cs
            val L = simplify env' sigma L
         in
             LETCONT
               (map (fn (k, xs, K) =>
                  (k, xs, simplify env' sigma K)) cs,
                L)
         end
      | CC (k, ys) =>
         let
            val k = Subst.apply sigma k
            val ys = Subst.applyAll sigma ys
         in
            case findCont (env, k) of
               NONE => CC (k, ys)
             | SOME (xs, K) =>
                  if length xs <> length ys
                     then (* CC (k, ys) *) raise Fail "betaContFun.CC"
                  else if not (isInliningCandidateCont k K)
                     then CC (k, ys)
                  else
                     let
                        val _ = click()
                        val _ = markInlined k
                        val sigma = Subst.extendAll sigma ys xs
                        val _ = Census.removeAll ys
                        val K = Subst.renameTerm (simplify env sigma K)
                     in
                        K
                     end
         end
      | APP (f, j, ys) =>
         let
            val f = Subst.apply sigma f
            val j = Subst.apply sigma j
            val ys = Subst.applyAll sigma ys
         in
            case findFun (env, f) of
               NONE => APP (f, j, ys)
             | SOME (k, xs, K) =>
                  if length xs > length ys
                     then raise Fail (Aux.failWithSymbol "betaContFun.partialapplication" f)
                  else if length xs < length ys
                     then APP (f, j, ys)
                  else if length xs = length ys andalso isInliningCandidate f K
                     then 
                        let
                           val _ = click()
                           val _ = markInlined f
                           val sigma = Subst.extend sigma j k
                           val sigma = Subst.extendAll sigma ys xs
                           val _ = Census.remove j
                           val _ = Census.removeAll ys
                           val K = Subst.renameTerm (simplify env sigma K)
                        in
                           K
                        end
                  else APP (f, j, ys)
         end
   
   and simplifyVal env sigma v =
      case v of
         FN (k, x, t) => FN (k, x, simplify env sigma t)
       | INJ (t, x) => INJ (t, Subst.apply sigma x)
       | REC fs => REC (map (fn (f, x) => (f, Subst.apply sigma x)) fs)
       | PRI (f, xs) => PRI (Subst.apply sigma f, Subst.applyAll sigma xs)
       | otherwise => otherwise
  
   val name = "betaContFun"
   fun run t =
      let
         val _ = reset ()
         val _ = Rec.run t
         val _ = FI.run t
         val _ = Census.run t
         val _ = Cost.run()
         val t' = simplify Map.empty Subst.empty t
      in
         (t', !clicks)
      end
end

structure BetaContFunShrink = struct
   structure FI = FunInfo
   structure Map = SymMap
   structure Set = SymSet
   open CPS CPS.Exp

   val clicks = ref 0
   val inlined = ref Map.empty : int Map.map ref
   fun click () = clicks := !clicks + 1
   fun reset () = (clicks := 0; inlined := Map.empty)

   fun count0 x =
      case Map.find (!inlined, x) of
         NONE => 0
       | SOME n => n

   fun markInlined f =
      inlined := Map.insert(!inlined, f, count0 f + 1)

   fun gotInlined f =
      case Map.find (!inlined, f) of
         NONE => false
       | SOME i => i > 0

   fun inliningCandidate f =
      not (Rec.isRec f)
      andalso Census.count#app f = 1
      andalso Census.count#esc f = 0

   datatype t =
      F of Var.c * Var.v list * term
    | C of Var.v list * term

   fun insertFun (env, f, body) = Map.insert (env, f, F body)
   fun insertCont (env, k, body) = Map.insert (env, k, C body)

   fun lookup s (env, f) = s (Map.lookup (env, f))
   fun find s (env, f) = Option.map s (Map.find (env, f))

   fun getFun (F x) = x
     | getFun _ = raise Match
   fun getCont (C x) = x
     | getCont _ = raise Match

   val lookupFun = lookup getFun
   val lookupCont = lookup getCont
   val findFun = find getFun
   val findCont = find getCont

   fun simplify env sigma t =
      case t of
         LETVAL (f, FN (k, xs, K), L) =>
            let
               val env' = insertFun (env, f, (k, xs, K))
            in
               if Census.count#app f = 1 andalso Census.count#esc f = 0
                  then
                     let
                        val L = simplify env' sigma L
                     in
                        if gotInlined f
                           then L
                        else if Census.count#app k = 0
                                    andalso Census.count#esc k = 0
                           then (Census.visitTerm ~1 K; L)
                        else
                           LETVAL (f, FN (k, xs, simplify env sigma K), L)
                     end
               else
                  LETVAL (f, FN (k, xs, simplify env sigma K),
                     simplify env' sigma L)
            end
      | LETVAL (x, v, L) =>
        LETVAL
            (x,
             simplifyVal env sigma v,
             simplify env sigma L)
      | LETPRJ (x, f, y, t) =>
         LETPRJ
            (x,
             f,
             Subst.apply sigma y,
             simplify env sigma t)
      | LETUPD (x, y, fs, t) =>
         LETUPD
            (x,
             Subst.apply sigma y,
             map (fn (f, z) => (f, Subst.apply sigma z)) fs,
             simplify env sigma t)
      | CASE (x, cs) =>
         CASE
            (Subst.apply sigma x,
             map
               (fn (tags,(k,xs)) =>
                  (tags,(Subst.apply sigma k, Subst.applyAll sigma xs))) cs)
      | LETREC (ds, L) =>
         let
            val env' = 
               foldl
                  (fn ((f, k, xs, K), env) =>
                     insertFun (env, f, (k, xs, K))) env ds
            
            val L = simplify env' sigma L

            fun simplify0 (f, k, xs, K) = (f, k, xs, simplify env' sigma K)
            fun filter (f, k, xs, K) =
               if gotInlined f
                  then NONE
               else if Census.count#app f = 0
                        andalso Census.count#esc f = 0
                  then (Census.visitTerm ~1 K; NONE)
               else SOME (f, k, xs, K)
         in
            case List.mapPartial filter (List.map simplify0 ds) of
               [] => L
             | ds => LETREC (ds, L) 
         end
      | LETCONT ([(k, xs, K)], L) =>
            let
               val env' = insertCont (env, k, (xs, K))
            in
               if Census.count#app k = 1 andalso Census.count#esc k = 0
                  then
                     let
                        val L = simplify env' sigma L
                     in
                        if gotInlined k
                           then L
                        else if Census.count#app k = 0
                                    andalso Census.count#esc k = 0
                           then (Census.visitTerm ~1 K; L)
                        else
                           LETCONT ([(k, xs, simplify env' sigma K)], L)
                     end
               else
                  LETCONT ([(k, xs, simplify env' sigma K)],
                     simplify env' sigma L)
            end
      | LETCONT (ds, L) =>
            let
               val env' = 
                  foldl
                     (fn ((k, xs, K), env) =>
                        insertCont (env, k, (xs, K))) env ds
            
               val L = simplify env' sigma L

               fun simplify0 (k, xs, K) = (k, xs, simplify env' sigma K)
               fun filter (k, xs, K) =
                  if gotInlined k
                     then NONE
                  else if Census.count#app k = 0
                           andalso Census.count#esc k = 0
                     then (Census.visitTerm ~1 K; NONE)
                  else SOME (k, xs, K)
            in
               case List.mapPartial filter (List.map simplify0 ds) of
                  [] => L
                | ds => LETCONT (ds, L) 
            end
      | CC (k, ys) =>
         let
            val k = Subst.apply sigma k
            val ys = Subst.applyAll sigma ys
         in
            case findCont (env, k) of
               NONE => CC (k, ys)
             | SOME (xs, K) =>
                  if length xs <> length ys
                     then (* CC (k, ys) *) raise Fail "betaContFunShrink.arity"
                  else if not (inliningCandidate k)
                     then CC (k, ys)
                  else
                     let
                        val _ = click()
                        val _ = markInlined k
                        val sigma = Subst.extendAll sigma ys xs
                        val _ = Census.update (Census.A ~1) k
                        val _ = Census.extendAppAll ys xs
                        val K = simplify env sigma K
                     in
                        K
                     end
         end
      | APP (f, j, ys) =>
         let
            val f = Subst.apply sigma f
            val j = Subst.apply sigma j
            val ys = Subst.applyAll sigma ys
         in
            case findFun (env, f) of
               NONE => APP (f, j, ys)
             | SOME (k, xs, K) =>
                  if length xs = length ys andalso (inliningCandidate f)
                     then 
                        let
                           val _ = click()
                           val _ = markInlined f
                           val sigma = Subst.extend sigma j k
                           val sigma = Subst.extendAll sigma ys xs
                           val _ = Census.update (Census.A ~1) f
                           val _ = Census.extendApp j k
                           val _ = Census.extendAppAll ys xs
                           val K = simplify env sigma K
                        in
                           K
                        end
                  else APP (f, j, ys)
         end
   
   and simplifyVal env sigma v =
      case v of
         FN (k, x, t) => FN (k, x, simplify env sigma t)
       | INJ (t, x) => INJ (t, Subst.apply sigma x)
       | REC fs => REC (map (fn (f, x) => (f, Subst.apply sigma x)) fs)
       | PRI (f, xs) => PRI (Subst.apply sigma f, Subst.applyAll sigma xs)
       | otherwise => otherwise
  
   val name = "betaContFunShrink"
   fun run t =
      let
         val _ = reset ()
         val _ = Rec.run t
         val _ = FI.run t
         val _ = Census.run t
         val _ = Cost.run()
         val t' = simplify Map.empty Subst.empty t
         val _ =
            Map.appi (fn (f, n) =>
               if n <> 1
                  then raise Fail
                     (Aux.failWithSymbol
                        "betaContFunShrink.bug.inlinedMoreThanOnce" f)
               else ())
               (!inlined)
      in
         (t', !clicks)
      end
   fun fix t = 
      let
         fun lp (t, acc) =
            let
               val (t, clicks) = run t
               val _ = CheckDefUse.run t
            in
               if clicks = 0
                  then (t, acc)
               else lp (t, clicks+acc)
            end
      in
         lp (t, 0)
      end
   val run = fix
end

structure BetaContract = struct
   structure FI = FunInfo
   structure Map = SymMap
   structure Set = SymSet
   open CPS CPS.Exp

   structure Avail = struct
      datatype t = datatype cval
      type ord_key = t
      fun toInt v =
         case v of
            FN _ => 0
          | PRI _ => 1
          | INJ _ => 2
          | REC _ => 3
          | INT _ => 4
          | FLT _ => 5
          | STR _ => 6
          | VEC _ => 7
          | UNT => 8

      fun compareSym (a, b) = SymbolTable.compare_symid (a, b)
      fun compare2 ((a, b), (c, d)) =
         case compareSym (a, c) of
            EQUAL => compareSym (b, d)
          | cmp => cmp
      fun compareMany (xs, ys) =
         case (xs, ys) of
            ([], []) => EQUAL
          | ([], _) => LESS
          | (_, []) => GREATER
          | (x::xs, y::ys) =>
               case compareSym (x, y) of
                  EQUAL => compareMany (xs, ys)
                | cmp => cmp
      fun comparePayload (a, b) =
         case (a, b) of
            (PRI (a,xs), PRI (b,ys)) =>
               (case compareSym (a, b) of
                  EQUAL => compareMany (xs, ys)
                | cmp => cmp)
          | (INT a, INT b) => IntInf.compare (a, b)
          | (STR a, STR b) => String.compare (a, b)
          | (VEC a, VEC b) => String.compare (a, b)
          | (INJ a, INJ b) => compare2 (a, b)
          | (UNT, UNT) => EQUAL
          | _ => LESS
      fun compare (a, b) = 
         case Int.compare (toInt a, toInt b) of
            EQUAL => comparePayload (a, b)
          | cmp => cmp
   end
   structure Map = RedBlackMapFn(Avail)

   val clicks = ref 0
   fun click () = clicks := !clicks + 1
   fun reset () = clicks := 0

   val empty = Map.empty
   fun bind (env, v, x) = Map.insert (env, v, x)
   fun lookup (env, v) = Map.find (env, v) 

   fun simplify env sigma t =
      case t of
         LETVAL (x, v, L) =>
            let
               val v = simplifyVal env sigma v
            in
               case lookup (env, v) of
                  NONE => 
                     LETVAL (x, v,
                        simplify (bind (env,v,x)) sigma L)
                | SOME y =>
                     (click()
                     ;simplify env (Subst.extend sigma y x) L)
            end
       | LETPRJ (x, f, y, t) =>
            LETPRJ
               (x,
                f,
                Subst.apply sigma y,
                simplify env sigma t)
       | LETUPD (x, y, fs, t) =>
            LETUPD
               (x,
                Subst.apply sigma y,
                map (fn (f, z) => (f, Subst.apply sigma z)) fs,
                simplify env sigma t)
       | CASE (x, cs) =>
            let
               val x = Subst.apply sigma x
               val cs =
                  map (fn (tags,(k,xs)) =>
                     (tags,(Subst.apply sigma k, Subst.applyAll sigma xs))) cs
               fun matchh tag =
                  case lookup (env, VEC (Word.toString tag)) of
                     NONE => false
                   | SOME y => SymbolTable.eq_symid (x, y)
               fun boundTag (tags, _) = List.exists matchh tags
            in
               case List.find boundTag cs of
                  NONE => CASE (x, cs)
                | SOME (_,(k,xs)) => (click();CC (k, xs))
            end
       | LETREC (ds, L) =>
            let
               fun visit (f, k, xs, K) =
                  (f, k, xs, simplify empty sigma K)
            in
               LETREC (map visit ds, simplify env sigma L) 
            end
       | LETCONT (ds, L) =>
            let
               fun visit (k, xs, K) =
                  (k, xs, simplify empty sigma K)
            in
               LETCONT (map visit ds, simplify env sigma L) 
            end
       | CC (k, ys) =>
            let
               val k = Subst.apply sigma k
               val ys = Subst.applyAll sigma ys
            in
               CC (k, ys)
            end
       | APP (f, j, ys) =>
            let
               val f = Subst.apply sigma f
               val j = Subst.apply sigma j
               val ys = Subst.applyAll sigma ys
            in
               APP (f, j, ys)
            end
   
   and simplifyVal env sigma v =
      case v of
         FN (k, x, t) => FN (k, x, simplify empty sigma t)
       | INJ (t, x) => INJ (t, Subst.apply sigma x)
       | REC fs => REC (map (fn (f, x) => (f, Subst.apply sigma x)) fs)
       | PRI (f, xs) => PRI (Subst.apply sigma f, Subst.applyAll sigma xs)
       | otherwise => otherwise
  
   val name = "betaContract"
   fun run t =
      let
         val _ = reset ()
         val t' = simplify empty Subst.empty t
      in
         (t', !clicks)
      end
end
