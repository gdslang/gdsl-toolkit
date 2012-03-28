
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
          | APP (x, k, y) =>
               (update n x
               ;update n k
               ;update n y)
          | CC (k, x) => (update n k; update n x)
          | CASE (x, ks) => (update n x; StringMap.appi (censusMatch n) ks)

      and censusMatch n (_, k) = update n k

      and censusField n (_, v) = update n v

      and censusDecl n (f, k, xs, t) =
         (touch f
         ;touch k
         ;app touch xs
         ;censusTerm n t)

      and censusCCDecl n (k, x, t) =
         (touch k
         ;touch x
         ;censusTerm n t)

      and censusCVal n cval = 
         case cval of
            FN (k, x, t) => (touch k; touch x; censusTerm n t)
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
end

structure BetaFunLin = struct
   open CPS.Exp
   structure Map = SymMap

   val clicks = ref 0
   fun click () = clicks := !clicks + 1
   fun reset () = clicks := 0

   fun hasAppSite f cps = let
      fun visitor (cps, seed) =
         case cps of
            APP (g, _, _) => seed orelse SymbolTable.eq_symid (f, g)
          | _ => false
   in
      CPS.Fold.run
         {visitterm=visitor,
          visitcval=fn _ => false} false cps
   end

   fun simplify census env sigma t =
      case t of
         LETVAL (f, FN (k, x, K), L) =>
            let
               val env' = Map.insert (env, f, (k, x, K))
            in
               if Census.count census f = 1
                  andalso hasAppSite f L
                  then (click (); simplify census env' sigma L)
               else
                  LETVAL
                     (f,
                      FN (k, x, simplify census env sigma K),
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
      | CC (k, x) =>
         CC (Subst.apply sigma k, Subst.apply sigma x)
      | CASE (x, cs) =>
         CASE
            (Subst.apply sigma x,
             StringMap.map (fn k => Subst.apply sigma k) cs)
      | APP (f, k, x) =>
         case Map.find (env, f) of
            NONE =>
               APP
                  (Subst.apply sigma f,
                   Subst.apply sigma k,
                   Subst.apply sigma x)
          | SOME (j, y, K) =>
               let
                  val sigma = Subst.extend sigma j k
                  val sigma = Subst.extend sigma y x
               in
                  simplify census env sigma K
               end
   
   and simplifyRec census env sigma (f, k, xs, t) =
      (f, k, xs, simplify census env sigma t)
   
   and simplifyVal census env sigma v =
      case v of
         FN (k, x, t) => FN (k, x, simplify census env sigma t)
       | INJ (t, x) => INJ (t, Subst.apply sigma x)
       | REC fs => REC (map (fn (f, x) => (f, Subst.apply sigma x)) fs)
       | otherwise => otherwise
  
   val name = "betaFunLin"
   fun run t =
      let
         val () = reset ()
         val t' = simplify (Census.run t) Map.empty Subst.empty t
      in
         (t', !clicks)
      end
end
