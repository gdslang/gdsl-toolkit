structure Types = struct

   structure BD = BooleanDomain

   type tvar = TVar.tvar
   type varset = TVar.set
   val freshTVar = TVar.freshTVar

   val concisePrint = true

   type size_constraint = { pos : TVar.tvar list, neg : TVar.tvar list, const : int}

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
      (*(* a list of size constraints, can only occur as the arg of VEC *)
    | SUM of size_constraint list*)
      (* an algebraic data type with a list of type arguments *)
    | ALG of (TypeInfo.symid * texp list)
      (* a record *)
    | RECORD of (TVar.tvar * BD.bvar * rfield list)
      (* the state monad *)
    | MONAD of texp
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
        (*| tV (SUM l) = List.foldl*)
        | tV (ALG (ty, l), vs) = List.foldl tV vs l
        | tV (RECORD (v,_,l), vs) = List.foldl tVF (TVar.add (v,vs)) l
        | tV (MONAD t, vs) = tV (t, vs)
        | tV (VAR (v,_), vs) = TVar.add (v,vs)
      and tVF (RField {name = n, fty = t, exists = b}, vs) = tV (t,vs)
      in (tV (e, vs))
   end
   
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
      (*| sT (p, SUM l) = sep "," (List.map (fn {pos,neg,const} =>
         let
            val posStr = sep "+" (List.map showVar pos)
            val negStr = sep "-" (List.map showVar neg)
         in
            if String.size posStr=0 then Int.toString(const) ^ "=" ^ negStr
            else
            if String.size negStr=0 then posStr ^ "=" ^ Int.toString(~const)
            else
               posStr ^ (if const>=0 then "+" else "") ^ Int.toString(const) ^ 
               "=" ^ negStr
         end) l)*)
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
      | sT (p, MONAD t) = br (p, p_tyn, "S " ^ sT (p_tyn+1, t))
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