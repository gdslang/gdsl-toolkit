
structure Aux = struct
   val function = Atom.atom "f"
   val continuation = Atom.atom "k"

   val variables = SymbolTables.varTable

   fun fresh variable = let
      val (tab, sym) =
         VarInfo.fresh (!variables, variable)
   in
      sym before SymbolTables.varTable := tab
   end

   fun atomOf x = VarInfo.getAtom (!variables, x)
end

structure Census = struct
   open CPS.Exp

   type t = int SymMap.map 

   val census = ref SymMap.empty : t ref

   fun count x =
      case SymMap.find (!census, x) of
         NONE => 0
       | SOME i => i

   fun visit n cps = let
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

      fun visitTerm n cps =
         case cps of
            LETVAL (x, v, t) => (touch x; visitCVal n v; visitTerm n t)
          | LETREC (ds, t) => (app (visitDecl n) ds; visitTerm n t)
          | LETPRJ (x, _, y, t) => (touch x; update n y; visitTerm n t)
          | LETUPD (x, y, fs, t) =>
               (touch x
               ;update n y
               ;app (visitField n) fs
               ;visitTerm n t)
          | LETCONT (ds, t) => (app (visitCCDecl n) ds; visitTerm n t)
          | APP (x, k, ys) =>
               (update n x
               ;update n k
               ;app (update n) ys)
          | CC (k, xs) => (update n k; app (update n) xs)
          | CASE (x, ks) => (update n x; StringMap.appi (visitMatch n) ks)

      and visitMatch n (_, k) = update n k

      and visitField n (_, v) = update n v

      and visitDecl n (f, k, xs, t) =
         (touch f
         ;touch k
         ;app touch xs
         ;visitTerm n t)

      and visitCCDecl n (k, xs, t) =
         (touch k
         ;app touch xs
         ;visitTerm n t)

      and visitCVal n cval = 
         case cval of
            FN (k, xs, t) => (touch k; app touch xs; visitTerm n t)
          | INJ (_, x) => update n x
          | REC fs => app (visitField n) fs
          | _ => () 
         
   in
      visitTerm n cps 
     ;census := !map
     ;!census
   end

   val run = visit 1
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
   fun applyAll sigma xs = map (apply sigma) xs
   fun extend sigma x y = SymMap.insert (sigma, y, x)
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

   fun copyAll xs = map copy xs

   local open CPS.Exp in
   
   fun rename sigma cps =
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
               val fs'= map (fn (f, x) => (f, apply sigma y)) fs
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
       | CASE (x, ks) => CASE (apply sigma x, StringMap.map (apply sigma) ks)

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
   structure Set = SymSet

   val clicks = ref 0
   val inlined = ref Set.empty
   fun click () = clicks := !clicks + 1
   fun reset () = (clicks := 0; inlined := Set.empty)

   fun markInlined f = inlined := Set.add (!inlined, f)
   fun usedLinearly f =
      Census.count f = 1
      andalso Set.member (!inlined, f)

   fun simplify env sigma t =
      case t of
         LETVAL (f, FN (k, xs, K), L) =>
            let
               val K = simplify env sigma K
               val env' = Map.insert (env, f, (k, xs, K))
               val L = simplify env' sigma L
            in
               if usedLinearly f
                  then L
               else LETVAL (f, FN (k, xs, K), L)
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
         CC (Subst.apply sigma k, map (Subst.apply sigma) xs)
      | CASE (x, cs) =>
         CASE
            (Subst.apply sigma x,
             StringMap.map (fn k => Subst.apply sigma k) cs)
      | APP (f, j, ys) =>
         let
            val f = Subst.apply sigma f
            val j = Subst.apply sigma j
            val ys = Subst.applyAll sigma ys
         in
            case Map.find (env, f) of
               NONE => APP (f, j, ys)
             | SOME (k, xs, K) =>
                  if length xs > length ys
                     then 
                        let
                           val _ = click()
                           val _ = markInlined f
                           val ly = length ys
                           val lx = length xs
                           val f' = Aux.fresh Aux.function
                           val applied = List.take(xs, ly)
                           val missing = List.drop(xs, ly)
                           val sigma = Subst.extendAll sigma ys applied
                           val K = 
                              if Census.count f <> 1
                                 then simplify env sigma (Subst.rename sigma K)
                              else simplify env sigma K

                        in
                           LETVAL (f', FN (k, missing, K), CC (j, [f']))
                        end
                  else if length xs = length ys
                     then
                        let
                           val _ = click()
                           val _ = markInlined f
                           val sigma = Subst.extend sigma j k
                           val sigma = Subst.extendAll sigma ys xs
                        in
                           if Census.count f <> 1
                              then simplify env sigma (Subst.rename sigma K)
                           else simplify env sigma K
                        end
                  else APP (f, j, ys)
         end
   
   and simplifyRec env sigma (f, k, xs, t) =
      (f, k, xs, simplify env sigma t)
   
   and simplifyVal env sigma v =
      case v of
         FN (k, x, t) => FN (k, x, simplify env sigma t)
       | INJ (t, x) => INJ (t, Subst.apply sigma x)
       | REC fs => REC (map (fn (f, x) => (f, Subst.apply sigma x)) fs)
       | otherwise => otherwise
  
   val name = "betaFun"
   fun run t =
      let
         val () = reset ()
         val _ = Census.run t
         val t' = simplify Map.empty Subst.empty t
      in
         (t', !clicks)
      end
end

structure BetaRec = struct
   open CPS.Exp
   structure Map = SymMap
   structure Set = SymSet

   val clicks = ref 0
   val inlined = ref Set.empty
   fun click () = clicks := !clicks + 1
   fun reset () = (clicks := 0; inlined := Set.empty)

   fun markInlined f = inlined := Set.add (!inlined, f)
   fun usedLinearly f =
      Census.count f = 1
      andalso Set.member (!inlined, f)

   fun simplify env sigma t =
      case t of
        LETVAL (x, v, L) =>
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
      | LETCONT (cs, t) =>
         LETCONT
            (map (fn (k, x, t) => (k, x, simplify env sigma t)) cs,
             simplify env sigma t)
      | CC (k, xs) =>
         CC (Subst.apply sigma k, Subst.applyAll sigma xs)
      | CASE (x, cs) =>
         CASE
            (Subst.apply sigma x,
             StringMap.map (fn k => Subst.apply sigma k) cs)
      | LETREC (ds, L) =>
         let
            val env' = 
               foldl
                  (fn ((f, k, xs, K), env) =>
                     Map.insert (env, f, (k, xs, K))) env ds
            val env' =
               foldl
                  (fn ((f, k, xs, K), env) =>
                     Map.insert
                        (env,
                         f,
                         (k, xs, simplify env' sigma K))) env ds 
            val L = simplify env' sigma L
         in
            case List.filter (fn (f, _, _, _) => not (usedLinearly f)) ds of
               [] => L
             | ds => 
                  LETREC
                     (map (fn (f, k, xs, _) =>
                        (f, k, xs, #3 (Map.lookup (env', f)))) ds,
                      L)
         end
      | APP (f, j, ys) =>
         let
            val f = Subst.apply sigma f
            val j = Subst.apply sigma j
            val ys = Subst.applyAll sigma ys
         in
            case Map.find (env, f) of
               NONE => APP (f, j, ys)
             | SOME (k, xs, K) =>
                  if Rec.isRec f then APP (f, j, ys)
                  else if length xs > length ys
                     then
                        let
                           val _ = click()
                           val _ = markInlined f
                           val ly = length ys
                           val lx = length xs
                           val f' = Aux.fresh Aux.function
                           val applied = List.take(xs, ly)
                           val missing = List.drop(xs, ly)
                           val sigma = Subst.extendAll sigma ys applied
                           val K = 
                              if Census.count f <> 1
                                 then simplify env sigma (Subst.rename sigma K)
                              else simplify env sigma K
                        in
                           LETVAL (f', FN (k, missing, K), CC (j, [f']))
                        end
                  else if length xs = length ys
                     then 
                        let
                           val _ = click()
                           val _ = markInlined f
                           val sigma = Subst.extend sigma j k
                           val sigma = Subst.extendAll sigma ys xs
                           val K = 
                              if Census.count f <> 1
                                 then simplify env sigma (Subst.rename sigma K)
                              else simplify env sigma K
                        in
                           simplify env sigma K
                        end
                  else APP (f, j, ys)
         end
   
   and simplifyVal env sigma v =
      case v of
         FN (k, x, t) => FN (k, x, simplify env sigma t)
       | INJ (t, x) => INJ (t, Subst.apply sigma x)
       | REC fs => REC (map (fn (f, x) => (f, Subst.apply sigma x)) fs)
       | otherwise => otherwise
  
   val name = "betaRec"
   fun run t =
      let
         val _ = reset ()
         val _ = Rec.run t
         val _ = Census.run t
         val t' = simplify Map.empty Subst.empty t
      in
         (t', !clicks)
      end
end

structure BetaCont = struct
   open CPS.Exp
   structure Map = SymMap
   structure Set = SymSet

   val clicks = ref 0
   val inlined = ref Set.empty
   fun click () = clicks := !clicks + 1
   fun reset () = (clicks := 0; inlined := Set.empty)

   fun markInlined f = inlined := Set.add (!inlined, f)
   fun usedLinearly f =
      Census.count f = 1
      andalso Set.member (!inlined, f)

   fun simplify env sigma t =
      case t of
        LETVAL (x, v, L) =>
         LETVAL
            (x,
             simplifyVal env sigma v,
             simplify env sigma L)
      | LETREC (ds, t) =>
         LETREC
            (map (simplifyRec env sigma) ds,
             simplify env sigma t)
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
             StringMap.map (fn k => Subst.apply sigma k) cs)
      | APP (f, j, ys) =>
         let
            val f = Subst.apply sigma f
            val j = Subst.apply sigma j
            val ys = Subst.applyAll sigma ys
         in
            APP (f, j, ys)
         end
      | LETCONT (cs, K) =>
         let
            (* update environment with potentially recursive continuations *)
            val env' = 
               foldl
                  (fn ((k, xs, K), env) =>
                     Map.insert (env, k, (xs, K))) env cs
            val env' =
               foldl
                  (fn ((k, xs, K), env') =>
                     Map.insert
                        (env',
                         k,
                         (xs, simplify env' sigma K))) env' cs
            val cs = 
               map
                  (fn (k, xs, _) =>
                     (k, xs, #2 (Map.lookup (env', k)))) cs

            val K = simplify env' sigma K
         in
            case List.filter (fn (k, _, _) => not (usedLinearly k)) cs of
               [] => K
             | cs => LETCONT (cs, K)
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
                           val _ = click()
                           val _ = markInlined k
                           val sigma = Subst.extendAll sigma ys xs
                           val K =
                              if Census.count k <> 1
                                 then simplify env sigma (Subst.rename sigma K)
                              else simplify env sigma K
                        in
                           K
                        end
         end
   
   and simplifyRec env sigma (f, k, xs, t) =
      (f, k, xs, simplify env sigma t)
   
   and simplifyVal env sigma v =
      case v of
         FN (k, x, t) => FN (k, x, simplify env sigma t)
       | INJ (t, x) => INJ (t, Subst.apply sigma x)
       | REC fs => REC (map (fn (f, x) => (f, Subst.apply sigma x)) fs)
       | otherwise => otherwise
  
   val name = "betaCont"
   fun run t =
      let
         val _ = reset ()
         val _ = Rec.run t
         val _ = Census.run t
         val t' = simplify Map.empty Subst.empty t
      in
         (t', !clicks)
      end
end

structure BetaPair = struct
   open CPS.Exp
   structure CM = CompilationMonad
   structure Map = SymMap
   structure Set = SymSet

   val clicks = ref 0
   val inlined = ref Set.empty
   fun click () = clicks := !clicks + 1
   fun reset () = (clicks := 0; inlined := Set.empty)

   fun markInlined f = inlined := Set.add (!inlined, f)
   fun usedLinearly f =
      Census.count f = 1
      andalso Set.member (!inlined, f)

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
                StringMap.map (fn k => Subst.apply sigma k) cs)
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
       | REC _ => raise CM.CompilationError
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

structure DeadVal = struct
   open CPS.Exp
   structure Map = SymMap

   val clicks = ref 0
   fun click () = clicks := !clicks + 1
   fun reset () = clicks := 0

   fun simplify t =
      case t of
        LETVAL (x, v, K) =>
         if Census.count x = 0
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
         if Census.count x = 0
            then (click(); simplify K)
         else
            LETPRJ
               (x,
                f,
                y,
                simplify K)
      | LETUPD (x, y, fs, K) =>
         if Census.count x = 0
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
                     val notDead = Census.count f <> 0
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
                     val notDead = Census.count k <> 0
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
