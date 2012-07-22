structure Types = struct

   structure BD = BooleanDomain

   type tvar = TVar.tvar
   type varset = TVar.set
   val freshTVar = TVar.freshTVar

   val concisePrint = true

   datatype texp =
      (* a function taking at least one argument *)
      FUN of (texp list * texp)
      (* a type synoym with its expanded type *)
    | SYN of (TypeInfo.symid * texp)
      (* an whole number *)
    | ZENO
      (* a floating point number *)
    | FLOAT
      (* a character sequence *)
    | STRING
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

   exception LangTypesBug
              
   fun newFlow (VAR (a,_)) = VAR (a, BD.freshBVar ())
     | newFlow _ = raise LangTypesBug
   fun freshVar () = VAR (freshTVar (), BD.freshBVar ())
   fun bvar (VAR (v,b)) = b
     | bvar _ = raise LangTypesBug
   fun tvar (VAR (v,b)) = v
     | tvar _ = raise LangTypesBug      

   fun texpVarset (e, vs) = let
      fun tV (FUN (f1, f2), vs) = tV (f2, List.foldl tV vs f1)
        | tV (SYN (syn, t), vs) = tV (t, vs)
        | tV (ZENO, vs) = vs
        | tV (FLOAT, vs) = vs
        | tV (STRING, vs) = vs
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

   (*gather Boolean flags, the collection function is generic and is passed a
   bool that is true if the flag is in a contra-variant position*)
   fun texpBVarset cons (e, bs) = let
      fun tV co (FUN (f1, f2), bs) = tV co (f2, List.foldl (tV (not co)) bs f1)
        | tV co (SYN (syn, t), bs) = tV co (t, bs)
        | tV co (ZENO, bs) = bs
        | tV co (FLOAT, bs) = bs
        | tV co (STRING, bs) = bs
        | tV co (UNIT, bs) = bs
        | tV co (VEC t, bs) = tV co (t, bs)
        | tV co (CONST c, bs) = bs
        | tV co (ALG (ty, l), bs) = List.foldl (tV co) bs l
        | tV co (RECORD (v,b,l), bs) =
            cons ((co,b), List.foldl (tVF co) bs l)
        | tV co (MONAD (r,f,t), bs) =
         tV co (r, tV (not co) (f, tV co (t, bs)))
        | tV co (VAR (v,b), bs) = cons ((co,b),bs)
      and tVF co (RField {name = n, fty = t, exists = b}, bs) =
         cons ((co,b), tV co (t, bs))
      in (tV false (e, bs))
   end

   (* Generate a Boolean function that describes the flow between the type
   variables of an algebraic data type, e.g. tree[a.1], and its constructors,
   e.g. Node {l.4:tree[a.2], key.5:int, r.6:tree[a.3], b.7}. When the Boolean
   flag is False, the generated flow is 1->2 and 1->3 for turning an
   expression to a datatype. If the flag is True, the flow is revered, which
   is used when dissecting a data type. In every case, record fields are all
   required and no other fields are allowed, e.g. 4 and 5 and 6 and not 7. *)
   fun texpConstructorFlow vars co e = let
      fun tCF co (FUN (f1, f2), bFun) = tCF co (f2, List.foldl (tCF (not co)) bFun f1)
        | tCF co (SYN (syn, t), bFun) = tCF co (t, bFun)
        | tCF co (ZENO, bFun) = bFun
        | tCF co (FLOAT, bFun) = bFun
        | tCF co (STRING, bFun) = bFun
        | tCF co (UNIT, bFun) = bFun
        | tCF co (VEC t, bFun) = tCF co (t, bFun)
        | tCF co (CONST c, bFun) = bFun
        | tCF co (ALG (ty, l), bFun) = List.foldl (tCF co) bFun l
        | tCF co (RECORD (v,b,l), bFun) =
            BD.meetVarZero b (List.foldl (tCFF co) bFun l)
        | tCF co (MONAD (r,f,t), bFun) =
         tCF co (r, tCF (not co) (f, tCF co (t, bFun)))
        | tCF co (VAR (v,b), bFun) =
            case List.find (fn (var,_) => TVar.eq(var,v)) vars of
                 NONE => raise LangTypesBug
               | SOME (_,bVar) => if co
                  then BD.meetVarImpliesVar (b,bVar) bFun
                  else BD.meetVarImpliesVar (bVar,b) bFun
      and tCFF co (RField {name = n, fty = t, exists = b}, bFun) =
        BD.meetVarOne b (tCF co (t, bFun))
      in (tCF co (e, BD.empty))
   end                   

   fun fieldOfBVar (v, e) = let
      fun takeIfSome (t,fo) = case ff t of SOME f => SOME f | NONE => fo
      and ff (FUN (f1, f2)) = takeIfSome (f2,
            case List.mapPartial ff f1 of
               (f :: _) => SOME f
             | [] => NONE)
        | ff (SYN (syn, t)) = ff t
        | ff (ZENO) = NONE
        | ff (FLOAT) = NONE
        | ff (STRING) = NONE
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

   fun setFlagsToTop (FUN (f1, f2)) = FUN (List.map setFlagsToTop f1, setFlagsToTop f2)
     | setFlagsToTop (SYN (syn, t)) = SYN (syn, setFlagsToTop t)
     | setFlagsToTop (ZENO) = ZENO
     | setFlagsToTop (FLOAT) = FLOAT
     | setFlagsToTop (STRING) = STRING
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

   fun replaceTVars (e, vs) = let
      fun chg v = case List.find (fn (v1,_) => TVar.eq(v,v1)) vs of
           NONE => v
         | SOME (v1,v2) => v2
      fun repl (FUN (f1, f2)) = FUN (List.map repl f1, repl f2)
        | repl (SYN (syn, t)) = SYN (syn, repl t)
        | repl (ZENO) = ZENO
        | repl (FLOAT) = FLOAT
        | repl (STRING) = STRING
        | repl (UNIT) = UNIT
        | repl (VEC t) = VEC (repl t)
        | repl (CONST c) = CONST c
        | repl (ALG (ty, l)) = ALG (ty, List.map repl l)
        | repl (RECORD (v,bv,l)) = RECORD (chg v, bv, List.map replF l)
        | repl (MONAD (r,f,t)) = MONAD (repl r, repl f, repl t)
        | repl (VAR (v,bv)) = VAR (chg v,bv)
      and replF (RField {name = n, fty = t, exists = b}) =
         RField {name = n, fty = repl t, exists = b}
      in repl e
   end

   fun replaceBVars (e, vs) = let
      fun chg v = case List.find (fn (v1,_) => BD.eq(v,v1)) vs of
           NONE => v
         | SOME (v1,v2) => v2
      fun repl (FUN (f1, f2)) = FUN (List.map repl f1, repl f2)
        | repl (SYN (syn, t)) = SYN (syn, repl t)
        | repl (ZENO) = ZENO
        | repl (FLOAT) = FLOAT
        | repl (STRING) = STRING
        | repl (UNIT) = UNIT
        | repl (VEC t) = VEC (repl t)
        | repl (CONST c) = CONST c
        | repl (ALG (ty, l)) = ALG (ty, List.map repl l)
        | repl (RECORD (v,bv,l)) = RECORD (v, chg bv, List.map replF l)
        | repl (MONAD (r,f,t)) = MONAD (repl r, repl f, repl t)
        | repl (VAR (v,bv)) = VAR (v,chg bv)
      and replF (RField {name = n, fty = t, exists = b}) =
         RField {name = n, fty = repl t, exists = chg b}
      in repl e
   end

   fun compare_rfield (RField f1, RField f2) =
     SymbolTable.compare_symid (#name f1, #name f2)

   type condescr = texp option SymMap.map

   type typedescr = { tdVars : (TVar.tvar * BD.bvar) SymMap.map,
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
    fun sT (p, FUN ([f1], f2)) =
          br (p, p_app, sT (p_app+1, f1) ^ " -> " ^ sT (p_app, f2))
      | sT (p, FUN (f1, f2)) =
          br (p, p_app, "(" ^ sep ", " (List.map (fn f => sT (0, f)) f1) ^
                        ") -> " ^ sT (p_app, f2))
      | sT (p, SYN (syn, t)) = 
          br (p, p_tyn, SymbolTable.getString(!SymbolTables.typeTable, syn))
      | sT (p, ZENO) = "int"
      | sT (p, FLOAT) = "float"
      | sT (p, STRING) = "string"
      | sT (p, UNIT) = "()"
      | sT (p, VEC t) = "|" ^ sT (0, t) ^ "|"
      | sT (p, CONST c) = Int.toString(c)
      | sT (p, ALG (ty, l)) = let
          val conStr = SymbolTable.getString(!SymbolTables.typeTable, ty)
          in if List.null l then conStr else conStr ^ "[" ^ #2 (
             List.foldl (fn (t,(sep,str)) => (",",sT (0, t) ^ sep ^ str))
               ("","") l
            ) ^ "]"
          end
      | sT (p, RECORD (v,b,l)) = "{" ^ List.foldl (op ^) "" (List.map sTF l) ^
                                   showVar v ^ 
                                   (if concisePrint then "" else BD.showVar b)
                                   ^ ":...}"
      | sT (p, MONAD (r,f,t)) = br (p, p_tyn, "S " ^ sT (p_tyn+1, r)) ^
         " <" ^ sT (p_app+1, f) ^ " => " ^ sT (p_app, t) ^ ">"
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
