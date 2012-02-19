structure Types = struct
  
  datatype bitIdx = BitIdx of int
  
  val badBitIdx = BitIdx (~1)
  
  datatype tVar = TVar of int
  
  fun tVarEq (TVar v1, TVar v2) = v1=v2
  fun tVarIfEq (var1, var2, t, e) = if tVarEq (var1, var2) then t else e
  
  val tVarGenerator = ref 0
  
  fun freshTVar () =
    let val v = !tVarGenerator in (tVarGenerator := v+1; TVar v) end

  datatype tExp =
      (* a function *)
      TExpFun of (tExp * tExp)
      (* a type synoym with its expanded type *)
    | TExpSyn of (TypeInfo.symid * tExp)
      (* an whole number *)
    | TExpZeno
      (* a floating point number *)
    | TExpFloat
      (* a bit vector of a fixed size *)
    | TExpVec of tExp
      (* a Herbrand constant, can only occur as the argument of tExpVec *)
    | TExpConst of IntInf.int
      (* an algebraic data type with a list of type arguments *)
    | TExpAlg of (TypeInfo.symid * tExp list)
      (* a record *)
    | TExpRec of (rField) list
      (* the state monad *)
    | TExpMonad of tExp
      (* a type variable *)
    | TExpVar of tVar
    
  and rField = RField of {
    fieldName : FieldInfo.symid,
    fieldType : tExp
  }

    
  type condescr = tExp option SymMap.map
  
  type typedescr = { tdVars : tVar list,
                     tdCons : condescr }

  type Subst = tVar * tExp
  
  fun applySubstToExp ((v,e), exp) = let
    fun aS (TExpFun (f1, f2)) = TExpFun (aS f1, aS f2)
      | aS (TExpSyn (syn, t)) = TExpSyn (syn, aS t)
      | aS (TExpZeno) = TExpZeno
      | aS (TExpFloat) = TExpFloat
      | aS (TExpVec t) = TExpVec (aS t)
      | aS (TExpConst c) = TExpConst c
      | aS (TExpAlg (ty, l)) = TExpAlg (ty, List.map aS l)
      | aS (TExpRec l) = TExpRec (List.map aSF l)
      | aS (TExpMonad t) = TExpMonad (aS t)
      | aS (TExpVar var) = tVarIfEq (var, v, e, TExpVar var)
    and aSF (RField { fieldName = n, fieldType = t }) =
            RField { fieldName = n, fieldType =  aS t }
    in aS exp end                                          
  
  datatype Substs = Substs of Subst list

  val emptySubsts = Substs []
  fun applySubstsToExp (Substs l) exp =
        List.foldl applySubstToExp exp l  
  fun applySubstToSubst subst (v2, e2) = (v2, applySubstToExp (subst, e2))
  fun addSubst subst (Substs l) =
        Substs (subst::List.map (applySubstToSubst subst) l)
        

  exception UnificationFailure

  fun mgu (TExpFun (f1, f2), TExpFun (g1, g2), s) =
       mgu (f1, g1, mgu (f2, g2, s))
    | mgu (TExpSyn (_, t1), t2, s) = mgu (t1, t2, s)
    | mgu (t1, TExpSyn (_, t2), s) = mgu (t1, t2, s)
    | mgu (TExpZeno, TExpZeno, s) = s
    | mgu (TExpFloat, TExpFloat, s) = s
    | mgu (TExpVec t1, TExpVec t2, s) = mgu (t1, t2, s)
    | mgu (TExpConst c1, TExpConst c2, s) =
        if c1=c2 then s else raise UnificationFailure
    | mgu (TExpAlg (ty1, l1), TExpAlg (ty2, l2), s) =
      (case SymbolTable.compare_symid (ty1, ty2) of
        LESS => raise UnificationFailure
      | GREATER => raise UnificationFailure
      | EQAL => let
          fun recUni (e1::e1s, e2::e2s, s) =
                recUni (e1s, e2s, mgu (e1, e2, s))
            | recUni ([], [], s) = s
            | recUni _ = raise UnificationFailure
          in recUni (l1, l2, s) end)
    | mgu (TExpVar v, e, s) = addSubst (v, applySubstsToExp s e) s
    | mgu (e, TExpVar v, s) = addSubst (v, applySubstsToExp s e) s
    | mgu (_,_,s) = raise UnificationFailure
                                          
  structure VarMap = IntRedBlackMap
  val emptyShowInfo = VarMap.empty
  fun name idx = (if idx>25 then name (Int.div (idx,26)-1) else "") ^
        Char.toString (Char.chr (Char.ord #"a"+Int.mod (idx,26)))
  
  fun showTypeTable (ty, showInfo) = let
    val siTab = ref showInfo
    fun comma [] = ""
      | comma [v] = v
      | comma (v :: vs) = v ^ ", " ^ comma vs
    fun br (curPrec, neededPrec,str) =
      if curPrec>neededPrec then "(" ^ str ^ ")" else str
    val p_app = 10
    val p_tyn =  9
    fun sT (p, TExpFun (f1, f2)) =
          br (p, p_app, sT (p_app+1, f1) ^ " -> " ^ sT (p_app, f2))
      | sT (p, TExpSyn (syn, t)) = 
          br (p, p_tyn, SymbolTable.getString(!SymbolTables.typeTable, syn))
      | sT (p, TExpZeno) = "int"
      | sT (p, TExpFloat) = "float"
      | sT (p, TExpVec t) = "[" ^ sT (0, t) ^ "]"
      | sT (p, TExpConst c) = IntInf.toString(c)
      | sT (p, TExpAlg (ty, l)) = let
          val conStr = SymbolTable.getString(!SymbolTables.typeTable, ty)
          in if List.null l then conStr else br (p, p_tyn,
            List.foldl (fn (s1,s2) => s1 ^ " " ^ s2) conStr (
              List.map (fn e => sT (p_tyn+1, e)) l))
          end
      | sT (p, TExpRec l) = "{" ^ comma (List.map sTF l) ^ "}"
      | sT (p, TExpMonad t) = br (p, p_tyn, "S " ^ sT (p_tyn+1, t))
      | sT (p, TExpVar (TVar var)) = (case VarMap.find (!siTab, var) of
          SOME str => str
        | NONE => let val str = name (VarMap.numItems(!siTab)) in
                  (siTab := VarMap.insert(!siTab, var, str); str)
        end)
    and sTF (RField { fieldName = n, fieldType = t }) =
            SymbolTable.getString(!SymbolTables.fieldTable, n) ^ sT (0, t)
    in (sT (0, ty), !siTab) 
   end

   fun showType ty =
    let val (str,_) = showTypeTable (ty, emptyShowInfo) in str end

end