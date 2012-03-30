structure Types = struct

   structure BD = BooleanDomain

   type tvar = TVar.tvar
   type varset = TVar.set
   val freshTVar = TVar.freshTVar

   val concisePrint = true

   datatype texp =
      (* a function *)
      FUN of (texp * texp)
      (* a type synoym with its expanded type *)
    | SYN of (TypeInfo.symid * texp)
      (* an whole number *)
    | ZENO
      (* a floating point number *)
    | FLOAT
      (* a value containing no information *)
    | UNIT
      (* a bit vector of a fixed size *)
    | VEC of texp
      (* a Herbrand constant, can only occur as the argument of VEC *)
    | CONST of int
      (* an algebraic data type with a list of type arguments *)
    | ALG of (TypeInfo.symid * texp list)
      (* a record *)
    | RECORD of (TVar.tvar * BD.bvar * rfield list)
      (* the state monad: return value, input state, output state *)
    | MONAD of texp * texp * texp
      (* a type variable *)
    | VAR of TVar.tvar * BD.bvar
 
   and rfield = RField of {
      name : FieldInfo.symid,
      fty : texp,
      exists : BooleanDomain.bvar
   }

   fun texpVarset (e, vs) = let
      fun tV (FUN (f1, f2), vs) = tV (f2, tV (f1, vs))
        | tV (SYN (syn, t), vs) = tV (t, vs)
        | tV (ZENO, vs) = vs
        | tV (FLOAT, vs) = vs
        | tV (UNIT, vs) = vs
        | tV (VEC t, vs) = tV (t, vs)
        | tV (CONST c, vs) = vs
        | tV (ALG (ty, l), vs) = List.foldl tV vs l
        | tV (RECORD (v,_,l), vs) = List.foldl tVF (TVar.add (v,vs)) l
        | tV (MONAD (r,f,t), vs) = tV (r, tV (f, tV (t, vs)))
        | tV (VAR (v,_), vs) = TVar.add (v,vs)
      and tVF (RField {name = n, fty = t, exists = b}, vs) = tV (t,vs)
      in (tV (e, vs))
   end

   fun texpBVarset cons (e, bs) = let
      fun tV co (FUN (f1, f2), bs) = tV co (f2, tV (not co) (f1, bs))
        | tV co (SYN (syn, t), bs) = tV co (t, bs)
        | tV co (ZENO, bs) = bs
        | tV co (FLOAT, bs) = bs
        | tV co (UNIT, bs) = bs
        | tV co (VEC t, bs) = tV co (t, bs)
        | tV co (CONST c, bs) = bs
        | tV co (ALG (ty, l), bs) = List.foldl (tV co) bs l
        | tV co (RECORD (_,b,l), bs) =
         List.foldl (tVF co) (cons ((co,b),bs)) l
        | tV co (MONAD (r,f,t), bs) = tV co (r, tV (not co) (f, tV co (t, bs)))
        | tV co (VAR (_,v), bs) = cons ((co,v),bs)
      and tVF co (RField {name = n, fty = t, exists = b}, bs) =
         tV co (t, cons ((co,b),bs))
      in (tV false (e, bs))
   end

   fun fieldBVarsets (e, pn) = let
      fun tV pn (FUN (f1, f2)) = tV (tV pn f2) f1
        | tV pn (SYN (syn, t)) = tV pn t
        | tV pn (ZENO) = pn
        | tV pn (FLOAT) = pn
        | tV pn (UNIT) = pn
        | tV pn (VEC t) = tV pn t
        | tV pn (CONST c) = pn
        | tV pn (ALG (ty, l)) = List.foldl (fn (t,pn) => tV pn t) pn l
        | tV (p,n) (RECORD (_,b,l)) = 
            List.foldl (fn (f,pn) => tVF pn f) (p, BD.addToSet (b,n)) l
        | tV pn (MONAD (r,f,t)) = tV (tV (tV pn r) f) t
        | tV (p,n) (VAR (_,b)) = (p, BD.addToSet(b,n))
      and tVF (p,n) (RField {name, fty = t, exists = b}) =
         tV (BD.addToSet (b,p), n) t
      in (tV pn e)
   end

   fun fieldOfBVar (v, e) = let
      fun takeIfSome (t,fo) = case ff t of SOME f => SOME f | NONE => fo
      and ff (FUN (f1, f2)) = takeIfSome (f1, ff f2)
        | ff (SYN (syn, t)) = ff t
        | ff (ZENO) = NONE
        | ff (FLOAT) = NONE
        | ff (UNIT) = NONE
        | ff (VEC t) = ff t
        | ff (CONST c) = NONE
        | ff (ALG (ty, l)) = List.foldl takeIfSome NONE l
        | ff (RECORD (_,b,l)) = (case List.mapPartial ffF l of
              (f :: _) => SOME f
            | [] => NONE)
        | ff (MONAD (r,f,t)) = takeIfSome (r, (takeIfSome (f,ff t)))
        | ff (VAR (b,_)) = NONE
      and ffF (RField {name = n, fty = t, exists = b}) =
         if BD.eq(v,b) then SOME n else ff t
      in ff e
   end

   fun setFlagsToTop (FUN (f1, f2)) = FUN (setFlagsToTop f1, setFlagsToTop f2)
     | setFlagsToTop (SYN (syn, t)) = SYN (syn, setFlagsToTop t)
     | setFlagsToTop (ZENO) = ZENO
     | setFlagsToTop (FLOAT) = FLOAT
     | setFlagsToTop (UNIT) = UNIT
     | setFlagsToTop (VEC t) = VEC (setFlagsToTop t)
     | setFlagsToTop (CONST c) = CONST c
     | setFlagsToTop (ALG (ty, l)) = ALG (ty, List.map setFlagsToTop l)
     | setFlagsToTop (RECORD (var, b, l)) =
         RECORD (var, BD.freshBVar (), List.map setFlagsToTopF l)
     | setFlagsToTop (MONAD (r,f,t)) =
         MONAD (setFlagsToTop r, setFlagsToTop f, setFlagsToTop t)
     | setFlagsToTop (VAR (var,b)) = VAR (var, BD.freshBVar ())
   and
     setFlagsToTopF (RField {name = n, fty = t, exists = _}) =
        RField {name = n, fty = setFlagsToTop t, exists = BD.freshBVar ()}

   fun compare_rfield (RField f1, RField f2) =
     SymbolTable.compare_symid (#name f1, #name f2)

   type condescr = texp option SymMap.map

   type typedescr = { tdVars : (tvar * BD.bvar) list,
                     tdCons : condescr }

   fun showTypeSI (ty, showInfo) = let
    val siTab = ref showInfo
    fun sep s [] = ""
      | sep s [v] = v
      | sep s (v :: vs) = v ^ s ^ sep s vs
    fun br (curPrec, existsPrec,str) =
      if curPrec>existsPrec then "(" ^ str ^ ")" else str
    val p_app = 9
    val p_tyn = 10
    fun sT (p, FUN (f1, f2)) =
          br (p, p_app, sT (p_app+1, f1) ^ " -> " ^ sT (p_app, f2))
      | sT (p, SYN (syn, t)) = 
          br (p, p_tyn, SymbolTable.getString(!SymbolTables.typeTable, syn))
      | sT (p, ZENO) = "int"
      | sT (p, FLOAT) = "float"
      | sT (p, UNIT) = "()"
      | sT (p, VEC t) = "[" ^ sT (0, t) ^ "]"
      | sT (p, CONST c) = Int.toString(c)
      | sT (p, ALG (ty, l)) = let
          val conStr = SymbolTable.getString(!SymbolTables.typeTable, ty)
          in if List.null l then conStr else br (p, p_tyn,
            List.foldl (fn (s1,s2) => s1 ^ " " ^ s2) conStr (
              List.map (fn e => sT (p_tyn+1, e)) l))
          end
      | sT (p, RECORD (v,b,l)) = "{" ^ List.foldl (op ^) "" (List.map sTF l) ^
                                   showVar v ^ 
                                   (if concisePrint then "" else BD.showVar b)
                                   ^ ":...}"
      | sT (p, MONAD (r,f,t)) = br (p, p_tyn, "S " ^ sT (p_tyn+1, r))
      | sT (p, VAR (v,b)) = showVar v ^ 
            (if concisePrint then "" else BD.showVar b)
   and showVar var = let 
         val (str, newSiTab) = TVar.varToString (var, !siTab)
      in
         (siTab := newSiTab; str)
      end
    and sTF (RField {name = n, fty = t, exists = b}) =
            SymbolTable.getString(!SymbolTables.fieldTable, n) ^
            (if concisePrint then "" else BD.showVar b)  ^
            ": " ^ sT (0, t) ^ ", "
    in (sT (0, ty), !siTab) 
   end

   fun showType ty =
      let val (str,_) = showTypeSI (ty, TVar.emptyShowInfo) in str end

   fun showTypes l = let
         fun sT (si, []) = ""
           | sT (si, (str, t) :: l) = (case showTypeSI (t, si) of
                  (tStr, si) => str ^ tStr ^ sT (si, l)
              )
         in
           sT (TVar.emptyShowInfo, l)
         end

end