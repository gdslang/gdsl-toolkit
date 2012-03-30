
structure Aux = struct
   val function = Atom.atom "f"
   val continuation = Atom.atom "k"

   fun fresh variable = let
      val (tab, sym) =
         VarInfo.fresh (!SymbolTables.varTable, variable)
   in
      sym before SymbolTables.varTable := tab
   end
end

structure Census = struct
   open CPS.Exp

   type t = int SymMap.map 

   fun count census x =
      case SymMap.find (census, x) of
         NONE => 0
       | SOME i => i

   fun census n cps = let
      val map = ref SymMap.empty

      fun touch x =
         case SymMap.find (!map, x) of
            NONE => map := SymMap.insert (!map, x, 0)
          | _ => ()

      fun update n x = let
         val () = touch x
      in
         map :=
            SymMap.unionWith
               op+
               (SymMap.singleton (x, n), !map)
      end

      fun censusTerm n cps =
         case cps of
            LETVAL (x, v, t) => (touch x; censusCVal n v; censusTerm n t)
          | LETREC (ds, t) => (app (censusDecl n) ds; censusTerm n t)
          | LETPRJ (x, _, y, t) => (touch x; update n y; censusTerm n t)
          | LETUPD (x, y, fs, t) =>
               (touch x
               ;update n y
               ;app (censusField n) fs
               ;censusTerm n t)
          | LETCC (ds, t) => (app (censusCCDecl n) ds; censusTerm n t)
          | APP (x, k, ys) =>
               (update n x
               ;update n k
               ;app (update n) ys)
          | CC (k, xs) => (update n k; app (update n) xs)
          | CASE (x, ks) => (update n x; StringMap.appi (censusMatch n) ks)

      and censusMatch n (_, k) = update n k

      and censusField n (_, v) = update n v

      and censusDecl n (f, k, xs, t) =
         (touch f
         ;touch k
         ;app touch xs
         ;censusTerm n t)

      and censusCCDecl n (k, xs, t) =
         (touch k
         ;app touch xs
         ;censusTerm n t)

      and censusCVal n cval = 
         case cval of
            FN (k, xs, t) => (touch k; app touch xs; censusTerm n t)
          | INJ (_, x) => update n x
          | REC fs => app (censusField n) fs
          | _ => () 
         
   in
      censusTerm n cps 
     ;!map
   end

   val run = census 1
end

structure Env = struct
   type t = CPS.Exp.term SymMap.map

   val empty = SymMap.empty
   fun add env x t = SymMap.insert (env, x, t)
   fun addRec env xs = 
      foldl
         (fn ((f, _, _, t), env) =>
            add env f t)
         env xs
   fun lookup env x = SymMap.find (env, x)

end

structure Subst = struct
   type t = Core.sym SymMap.map

   val empty = SymMap.empty
   fun apply sigma x =
      case SymMap.find (sigma, x) of
         NONE => x
       | SOME y => y
   fun extend sigma x y = SymMap.insert (sigma, y, x)
   fun extends sigma xs ys =
      foldl
         (fn ((y, x), sigma) =>
            extend sigma y x)
         sigma (ListPair.zip (xs, ys))
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
           | LETCC (ds, t) =>
               let
                  val env = visitConts (ds, env)
                  val env = visitTerm (t, env)
               in
                  env
               end
           | LETVAL (x, v, t) => unuse (visitCVal (v, visitTerm (t, env))) x 
           | CASE (x, ks) => unuse (visitCases (ks, env)) x


      and visitCases (ks, env) = 
         StringMap.foldl (fn (k, env) => use env k) env ks

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
      let
         val () = print "rec-start\n"
         val () = recs := #2 (visitTerm (cps, empty))
         val () = print "rec-end\n"
         val () =
            Set.app
               (fn x =>
                  print
                     (VarInfo.getString (!SymbolTables.varTable, x) ^ "\n"))
               (!recs)
      in
         ()
      end
   end
end

structure BetaFun = struct
   open CPS.Exp
   structure Map = SymMap

   val clicks = ref 0
   fun click () = clicks := !clicks + 1
   fun reset () = clicks := 0

   fun simplify census env sigma t =
      case t of
         LETVAL (f, FN (k, xs, K), L) =>
            let
               val env' = Map.insert (env, f, (k, xs, K))
            in
               LETVAL
                  (f,
                   FN (k, xs, simplify census env sigma K),
                   simplify census env' sigma L)
            end
      | LETVAL (x, v, L) =>
         LETVAL
            (x,
             simplifyVal census env sigma v,
             simplify census env sigma L)
      | LETREC (ds, t) =>
         LETREC
            (map (simplifyRec census env sigma) ds,
             simplify census env sigma t)
      | LETPRJ (x, f, y, t) =>
         LETPRJ
            (x,
             f,
             Subst.apply sigma y,
             simplify census env sigma t)
      | LETUPD (x, y, fs, t) =>
         LETUPD
            (x,
             Subst.apply sigma y,
             map (fn (f, z) => (f, Subst.apply sigma z)) fs,
             simplify census env sigma t)
      | LETCC (cs, t) =>
         LETCC
            (map (fn (k, x, t) => (k, x, simplify census env sigma t)) cs,
             simplify census env sigma t)
      | CC (k, xs) =>
         CC (Subst.apply sigma k, map (Subst.apply sigma) xs)
      | CASE (x, cs) =>
         CASE
            (Subst.apply sigma x,
             StringMap.map (fn k => Subst.apply sigma k) cs)
      | APP (f, j, ys) =>
         let
            val f = Subst.apply sigma f
            val j = Subst.apply sigma j
            val ys = map (Subst.apply sigma) ys
         in
            case Map.find (env, f) of
               NONE => APP (f, j, ys)
             | SOME (k, xs, K) =>
                  if length xs > length ys
                     then 
                        let
                           val () = click ()
                           val ly = length ys
                           val lx = length xs
                           val f' = Aux.fresh Aux.function
                           val applied = List.take(xs, ly)
                           val missing = List.drop(xs, ly)
                           val sigma = Subst.extends sigma ys applied
                        in
                           LETVAL
                              (f',
                               FN (k, missing, simplify census env sigma K),
                               CC (j, [f']))
                        end
                  else if length xs = length ys
                     then
                        let
                           val sigma = Subst.extend sigma j k
                           val sigma = Subst.extends sigma ys xs
                        in
                           simplify census env sigma K
                        end
                  else APP (f, j, ys)
         end
   
   and simplifyRec census env sigma (f, k, xs, t) =
      (f, k, xs, simplify census env sigma t)
   
   and simplifyVal census env sigma v =
      case v of
         FN (k, x, t) => FN (k, x, simplify census env sigma t)
       | INJ (t, x) => INJ (t, Subst.apply sigma x)
       | REC fs => REC (map (fn (f, x) => (f, Subst.apply sigma x)) fs)
       | otherwise => otherwise
  
   val name = "betaFun"
   fun run t =
      let
         val () = reset ()
         val t' = simplify (Census.run t) Map.empty Subst.empty t
      in
         (t', !clicks)
      end
end

structure BetaRec = struct
   open CPS.Exp
   structure Map = SymMap

   val clicks = ref 0
   fun click () = clicks := !clicks + 1
   val recs = ref SymSet.empty
   fun reset () = (clicks := 0; recs := SymSet.empty)

   fun simplify census env sigma t =
      case t of
        LETVAL (x, v, L) =>
         LETVAL
            (x,
             simplifyVal census env sigma v,
             simplify census env sigma L)
      | LETREC (ds, L) =>
         let
            val env' = 
               foldl
                  (fn ((f, k, xs, K), env) =>
                     Map.insert (env, f, (k, xs, K))) env ds
         in
            LETREC
               (map (simplifyRec census env' sigma) ds,
                simplify census env' sigma L)
         end
      | LETPRJ (x, f, y, t) =>
         LETPRJ
            (x,
             f,
             Subst.apply sigma y,
             simplify census env sigma t)
      | LETUPD (x, y, fs, t) =>
         LETUPD
            (x,
             Subst.apply sigma y,
             map (fn (f, z) => (f, Subst.apply sigma z)) fs,
             simplify census env sigma t)
      | LETCC (cs, t) =>
         LETCC
            (map (fn (k, x, t) => (k, x, simplify census env sigma t)) cs,
             simplify census env sigma t)
      | CC (k, xs) =>
         CC (Subst.apply sigma k, map (Subst.apply sigma) xs)
      | CASE (x, cs) =>
         CASE
            (Subst.apply sigma x,
             StringMap.map (fn k => Subst.apply sigma k) cs)
      | APP (f, j, ys) =>
         let
            val f = Subst.apply sigma f
            val j = Subst.apply sigma j
            val ys = map (Subst.apply sigma) ys
         in
            case Map.find (env, f) of
               NONE => APP (f, j, ys)
             | SOME (k, xs, K) =>
                  if Rec.isRec f then APP (f, j, ys)
                  else if length xs > length ys
                     then
                        let
                           val () = click ()
                           val ly = length ys
                           val lx = length xs
                           val f' = Aux.fresh Aux.function
                           val applied = List.take(xs, ly)
                           val missing = List.drop(xs, ly)
                           val sigma = Subst.extends sigma ys applied
                        in
                           LETVAL
                              (f',
                               FN (k, missing, simplify census env sigma K),
                               CC (j, [f']))
                        end
                  else if length xs = length ys
                     then 
                        let
                           val sigma = Subst.extend sigma j k
                           val sigma = Subst.extends sigma ys xs
                        in
                           (click (); simplify census env sigma K)
                        end
                  else APP (f, j, ys)
         end
   
   and simplifyRec census env sigma (f, k, xs, t) =
      (f, k, xs, simplify census env sigma t)
   
   and simplifyVal census env sigma v =
      case v of
         FN (k, x, t) => FN (k, x, simplify census env sigma t)
       | INJ (t, x) => INJ (t, Subst.apply sigma x)
       | REC fs => REC (map (fn (f, x) => (f, Subst.apply sigma x)) fs)
       | otherwise => otherwise
  
   val name = "betaRec"
   fun run t =
      let
         val () = reset ()
         val () = Rec.run t
         val t' = simplify (Census.run t) Map.empty Subst.empty t
      in
         (t', !clicks)
      end
end

structure BetaCont = struct
   open CPS.Exp
   structure Map = SymMap

   val clicks = ref 0
   fun click () = clicks := !clicks + 1
   val recs = ref SymSet.empty
   fun reset () = (clicks := 0; recs := SymSet.empty)

   fun simplify census env sigma t =
      case t of
        LETVAL (x, v, L) =>
         LETVAL
            (x,
             simplifyVal census env sigma v,
             simplify census env sigma L)
      | LETREC (ds, t) =>
         LETREC
            (map (simplifyRec census env sigma) ds,
             simplify census env sigma t)
      | LETPRJ (x, f, y, t) =>
         LETPRJ
            (x,
             f,
             Subst.apply sigma y,
             simplify census env sigma t)
      | LETUPD (x, y, fs, t) =>
         LETUPD
            (x,
             Subst.apply sigma y,
             map (fn (f, z) => (f, Subst.apply sigma z)) fs,
             simplify census env sigma t)
      | CASE (x, cs) =>
         CASE
            (Subst.apply sigma x,
             StringMap.map (fn k => Subst.apply sigma k) cs)
      | APP (f, j, ys) =>
         let
            val f = Subst.apply sigma f
            val j = Subst.apply sigma j
            val ys = map (Subst.apply sigma) ys
         in
            APP (f, j, ys)
         end
      | LETCC (cs, t) =>
         let
            (* update environment with potentially recursive continuations *)
            val env' = 
               foldl
                  (fn ((k, xs, K), env) => Map.insert (env, k, (xs, K)))
                  env cs
         in
            LETCC
               (map
                  (fn (k, xs, t) =>
                     (k, xs, simplify census env' sigma t)) cs,
                simplify census env' sigma t)
         end
      | CC (k, ys) =>
         let
            val k = Subst.apply sigma k
            val ys = map (Subst.apply sigma) ys
         in
            if Rec.isRec k
               then CC (k, ys)
            else
               case Map.find (env, k) of
                  NONE => CC (k, ys)
                | SOME (xs, K) =>
                     if length xs <> length ys
                        then CC (k, ys)
                     else
                        let
                           val () = click()
                           val sigma = Subst.extends sigma ys xs
                        in
                           simplify census env sigma K
                        end
         end
   
   and simplifyRec census env sigma (f, k, xs, t) =
      (f, k, xs, simplify census env sigma t)
   
   and simplifyVal census env sigma v =
      case v of
         FN (k, x, t) => FN (k, x, simplify census env sigma t)
       | INJ (t, x) => INJ (t, Subst.apply sigma x)
       | REC fs => REC (map (fn (f, x) => (f, Subst.apply sigma x)) fs)
       | otherwise => otherwise
  
   val name = "betaCont"
   fun run t =
      let
         val () = reset ()
         val () = Rec.run t
         val t' = simplify (Census.run t) Map.empty Subst.empty t
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

   fun simplify census t =
      case t of
        LETVAL (x, v, K) =>
         if Census.count census x = 0
            then (click(); simplify census K)
         else
            LETVAL
               (x,
                simplifyVal census v,
                simplify census K)
      | LETREC (ds, K) =>
         (case simplifyRecs census ds of
            [] => (click(); simplify census K)
          | ds => LETREC (ds, simplify census K))
      | LETPRJ (x, f, y, K) =>
         if Census.count census x = 0
            then (click(); simplify census K)
         else
            LETPRJ
               (x,
                f,
                y,
                simplify census K)
      | LETUPD (x, y, fs, K) =>
         if Census.count census x = 0
            then (click(); simplify census K)
         else
            LETUPD
               (x,
                y,
                fs,
                simplify census K)
      | LETCC (cs, K) =>
         (case simplifyCCs census cs of
            [] => (click(); simplify census K)
          | cs => LETCC (cs, simplify census K))
      | otherwise => otherwise
   
   and simplifyRecs census ds =
      let
         val ds =
            List.filter
               (fn (f, _, _, _) =>
                  let
                     val notDead = Census.count census f <> 0
                  in
                     if notDead
                        then true
                     else (click(); false)
                  end) ds
      in
         map (fn (f, k, xs, t) => (f, k, xs, simplify census t)) ds
      end
  
   and simplifyCCs census ds =
      let
         val ds =
            List.filter
               (fn (k, _, _) =>
                  let
                     val notDead = Census.count census k <> 0
                  in
                     if notDead
                        then true
                     else (click(); false)
                  end) ds
      in
         map (fn (k, xs, t) => (k, xs, simplify census t)) ds
      end

   and simplifyVal census v =
      case v of
         FN (k, x, t) => FN (k, x, simplify census t)
       | otherwise => otherwise
  
   val name = "deadVal"
   fun run t =
      let
         val () = reset ()
         val t' = simplify (Census.run t) t
      in
         (t', !clicks)
      end
end
