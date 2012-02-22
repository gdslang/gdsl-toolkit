structure Types = struct

   structure BD = BooleanDomain

   type tvar = TVar.tvar
   type varset = TVar.set
   val freshTVar = TVar.freshTVar
   
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
    | CONST of IntInf.int
      (* an algebraic data type with a list of type arguments *)
    | ALG of (TypeInfo.symid * texp list)
      (* a record *)
    | RECORD of (TVar.tvar * rfield list)
      (* the state monad *)
    | MONAD of texp
      (* a type variable *)
    | VAR of TVar.tvar
 
   and rfield = RField of {
    name : FieldInfo.symid,
    fty : texp,
    needed : BooleanDomain.bvar
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
        | tV (RECORD (v,l), vs) = List.foldl tVF (TVar.add (v,vs)) l
        | tV (MONAD t, vs) = tV (t, vs)
        | tV (VAR v, vs) = TVar.add (v,vs)
      and tVF (RField {name = n, fty = t, needed = b}, vs) = tV (t,vs)
      in (tV (e, vs))
   end
   
   fun compare_rfield (RField f1, RField f2) =
     SymbolTable.compare_symid (#name f1, #name f2)

   type condescr = texp option SymMap.map

   type typedescr = { tdVars : tvar list,
                     tdCons : condescr }

   type Subst = tvar * texp
   fun mkSubst arg = arg

   datatype Substs = Substs of Subst list


   val a = freshTVar ()
   val b = freshTVar ()
   val c = freshTVar ()
   val d = freshTVar ()
   val e = freshTVar ()

   fun genTypes () = let
      val (t, f1) = SymbolTable.create(!SymbolTables.fieldTable, Atom.atom "f1", SymbolTable.noSpan)
      val (t, f2) = SymbolTable.create(t,  Atom.atom "f2", SymbolTable.noSpan)
      val t1 = FUN(VAR a, RECORD (b, [RField { name=f1, fty = VEC (VAR e), needed = BD.invalidBVar},
      RField { name=f2, fty = VEC (VAR e), needed = BD.invalidBVar}]))
      val t2 = FUN(RECORD (c, [RField { name=f1, fty = VEC (VAR d), needed = BD.invalidBVar}]), VAR a)
   in (SymbolTables.fieldTable := t; (f1,f2,t1,t2)) end
      
   fun showTypeSI (ty, showInfo) = let
    val siTab = ref showInfo
    fun comma [] = ""
      | comma [v] = v
      | comma (v :: vs) = v ^ ", " ^ comma vs
    fun br (curPrec, neededPrec,str) =
      if curPrec>neededPrec then "(" ^ str ^ ")" else str
    val p_app = 10
    val p_tyn =  9
    fun sT (p, FUN (f1, f2)) =
          br (p, p_app, sT (p_app+1, f1) ^ " -> " ^ sT (p_app, f2))
      | sT (p, SYN (syn, t)) = 
          br (p, p_tyn, SymbolTable.getString(!SymbolTables.typeTable, syn))
      | sT (p, ZENO) = "int"
      | sT (p, FLOAT) = "float"
      | sT (p, UNIT) = "()"
      | sT (p, VEC t) = "[" ^ sT (0, t) ^ "]"
      | sT (p, CONST c) = IntInf.toString(c)
      | sT (p, ALG (ty, l)) = let
          val conStr = SymbolTable.getString(!SymbolTables.typeTable, ty)
          in if List.null l then conStr else br (p, p_tyn,
            List.foldl (fn (s1,s2) => s1 ^ " " ^ s2) conStr (
              List.map (fn e => sT (p_tyn+1, e)) l))
          end
      | sT (p, RECORD (v,l)) = "{" ^ List.foldl (op ^) "" (List.map sTF l) ^
                                   showVar v ^ ": ...}"
      | sT (p, MONAD t) = br (p, p_tyn, "S " ^ sT (p_tyn+1, t))
      | sT (p, VAR v) = showVar v
   and showVar var = let 
         val (str, newSiTab) = TVar.varToString (var, !siTab)
      in
         (siTab := newSiTab; str)
      end
    and sTF (RField {name = n, fty = t, needed = b}) =
            SymbolTable.getString(!SymbolTables.fieldTable, n) ^ ": " ^ 
            sT (0, t) ^ ", "
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

   fun showSubstSI ((v, t), showInfo) = let
      val (vStr, showInfo) = TVar.varToString (v, showInfo)
      val (tStr, showInfo) = showTypeSI (t, showInfo)
   in
      (vStr ^ "/" ^ tStr, showInfo)
   end

   fun showSubst subst =
      let val (str, _) = showSubstSI (subst, TVar.emptyShowInfo) in str end
   
   fun showSubstsSI (Substs l, si) = let
         fun pr (s, (res, sep, si)) = let
               val (str, si) = showSubstSI (s, si)
            in
               (res ^ sep ^ str, ", ", si)
            end
         val (res, _, si) = List.foldl pr ("", "[", si) l
      in
         (res ^ "]", si)
      end

   val emptySubsts = Substs []

   fun applySubstToExp ((v,e), exp) = let
    fun aS (FUN (f1, f2)) = FUN (aS f1, aS f2)
      | aS (SYN (syn, t)) = SYN (syn, aS t)
      | aS (ZENO) = ZENO
      | aS (FLOAT) = FLOAT
      | aS (UNIT) = UNIT
      | aS (VEC t) = VEC (aS t)
      | aS (CONST c) = CONST c
      | aS (ALG (ty, l)) = ALG (ty, List.map aS l)
      | aS (RECORD (var, l)) = RECORD (var, List.map aSF l)
      | aS (MONAD t) = MONAD (aS t)
      | aS (VAR var) = if TVar.eq (var, v) then e else VAR var
    and
      aSF (RField {name = n, fty = t, needed = b}) =
         RField {name = n, fty =  aS t, needed = b}
    in aS exp end                                          

   fun applySubstsToExp (Substs l) exp =
        List.foldl applySubstToExp exp l  

   fun applySubstToSubst subst (v2, e2) = (v2, applySubstToExp (subst, e2))

   fun addSubst subst (Substs l) =
         Substs (subst::List.map (applySubstToSubst subst) l)


   datatype record_ext
      = HOLE of tvar
         (* extension of a record *)
      | FIELD of (rfield * record_ext)

   datatype RESubsts = RESubsts of (tvar * record_ext) list
   
   val emptyRESubsts = RESubsts []
   
   fun getHoleVar (FIELD (_, re)) = getHoleVar re
     | getHoleVar (HOLE v) = v

   fun addRESubst (v,re) (substs, RESubsts l) =
      let
         fun addField (FIELD (v,re)) = FIELD (v, addField re)
           | addField (HOLE _) = re
         fun aS ([]) = [(v,re)]
           | aS ((var, re) :: l) =
               if TVar.eq(v,getHoleVar re) then (var, addField re) :: l else
               (var, re) :: aS l
      in
         (substs, RESubsts (aS l))
      end


   fun showRecordExtSI (HOLE v, si) =
         let
            val (vStr, si) = TVar.varToString (v, si)
         in
            (vStr ^ ": ...", si)
         end
     | showRecordExtSI (FIELD (RField {name = n, fty = t, needed = b}, re), si) =
         let
            val (tstr, si) = showTypeSI (t, si)
            val name = SymbolTable.getString(!SymbolTables.fieldTable, n)
            val (rem, si) = showRecordExtSI (re, si)
         in
            (name ^ ": " ^ tstr ^ ", " ^ rem, si)
         end
   
   fun showRESubstsSI (RESubsts l, si) =
      let
         fun pr ((v,s), (res, sep, si)) = let
               val (vStr, si) = TVar.varToString (v, si)
               val (str, si) = showRecordExtSI (s, si)
            in
               (res ^ sep ^ vStr ^ "/" ^ str, ", ", si)
            end
         val (res, _, si) = List.foldl pr ("", "[", si) l
      in
         (res ^ "]", si)
      end

   fun showBothSubstsSI (substs, reSubsts, si) =
      let val (sStr, si) = showSubstsSI (substs, si)
          val (reStr, si) = showRESubstsSI (reSubsts, si)
      in
         (sStr ^ "\n" ^ reStr, si)
      end

   fun clearBits exp = let
    fun cB (FUN (f1, f2)) = FUN (cB f1, cB f2)
      | cB (SYN (syn, t)) = SYN (syn, cB t)
      | cB (ZENO) = ZENO
      | cB (FLOAT) = FLOAT
      | cB (UNIT) = UNIT
      | cB (VEC t) = VEC (cB t)
      | cB (CONST c) = CONST c
      | cB (ALG (ty, l)) = ALG (ty, List.map cB l)
      | cB (RECORD (var, l)) = RECORD (var, List.map cBF l)
      | cB (MONAD t) = MONAD (cB t)
      | cB (VAR var) = VAR var
    and
      cBF (RField {name = n, fty = t, needed = _}) =
         RField {name = n, fty =  cB t, needed = BD.invalidBVar}
    in cB exp end                                          
        
   (*some code broke the invariant that each record extensions is non-circular*)
   exception EquivalenceClassError
   
   fun applyRESubstsToExp (RESubsts substs) exp = let
      fun aS (FUN (f1, f2)) = FUN (aS f1, aS f2)
        | aS (SYN (syn, t)) = SYN (syn, aS t)
        | aS (ZENO) = ZENO
        | aS (FLOAT) = FLOAT
        | aS (UNIT) = UNIT
        | aS (VEC t) = VEC (aS t)
        | aS (CONST c) = CONST c
        | aS (ALG (ty, l)) = ALG (ty, List.map aS l)
        | aS (RECORD (var, l)) = 
             let
                fun lookup (var, (v,re) :: l) =
                      if TVar.eq (var,v) then SOME re else lookup (var, l)
                  | lookup (var, []) = NONE
                fun insertField (f, []) = [f]
                  | insertField (f1, f2 :: l) = (case compare_rfield (f1,f2) of
                       GREATER => f1 :: f2 :: l
                     | LESS => f2 :: insertField (f1, l)
                     | EQUAL => (
                        (*TextIO.print (showTypes [("trying to insert ",e), (" into ",(RECORD (var,l)))]);*)
                        raise EquivalenceClassError))
                fun addField (HOLE var, l) = (var, List.map aSF l)
                  | addField (FIELD (f, re), l) = addField (re, insertField (f,l))
             in
                case lookup (var, substs) of
                     NONE => RECORD (var, List.map aSF l)
                   | SOME re => RECORD (addField (re, l))
             end
        | aS (MONAD t) = MONAD (aS t)
        | aS (VAR var) = VAR var
      and
         aSF (RField {name = n, fty = t, needed = b}) =
            RField {name = n, fty =  aS t, needed = b}
      in aS exp end                                          
   
   fun applySubstsToRField s (RField {name = n, fty = t, needed = b}) =
            RField {name = n, fty = applySubstsToExp s t, needed = b}

   fun applySubstsToRE substs (HOLE v) = (HOLE v)
     | applySubstsToRE substs (FIELD (rf, re)) =
         FIELD (applySubstsToRField substs rf, applySubstsToRE substs re)

   fun applySubstToRESubsts subst (RESubsts l) = RESubsts
      (List.map (fn (v,re) => (v, applySubstsToRE (Substs [subst]) re)) l)

   fun applyBothSubsts (substs, reSubsts) exp =
         applySubstsToExp substs (applyRESubstsToExp reSubsts exp)

   fun applyBothSubstsToRField s (RField {name = n, fty = t, needed = b}) =
            RField {name = n, fty = applyBothSubsts s t, needed = b}

   exception UnificationFailure

   fun mgu (FUN (f1, f2), FUN (g1, g2), s) =
      let
         val (s as (sE,_)) = mgu (f2, g2, s)
      in
         mgu (applySubstsToExp sE f1, applySubstsToExp sE g1, s)
      end
    | mgu (SYN (_, t1), t2, s) = mgu (t1, t2, s)
    | mgu (t1, SYN (_, t2), s) = mgu (t1, t2, s)
    | mgu (ZENO, ZENO, s) = s
    | mgu (FLOAT, FLOAT, s) = s
    | mgu (UNIT, UNIT, s) = s
    | mgu (VEC t1, VEC t2, s) = mgu (t1, t2, s)
    | mgu (CONST c1, CONST c2, s) =
        if c1=c2 then s else raise UnificationFailure
    | mgu (RECORD (v1,l1), RECORD (v2,l2), s) =
      let
         fun unify (v1, v2, [], [], s) = 
               if TVar.eq (v1,v2) then s else addRESubst (v1, HOLE v2) s
           | unify (v1, v2, (f1 as RField e1) :: fs1,
                    (f2 as RField e2) :: fs2, s) =
               (case compare_rfield (f1,f2) of
                  EQUAL =>
                  let
                     val s as (sE, sRE) = mgu (#fty e1, #fty e2, s)
                   in
                     unify (v1, v2, List.map (applySubstsToRField sE) fs1,
                                    List.map (applySubstsToRField sE) fs2, s)
                  end
                | LESS => let
                     val newVar = freshTVar ()
                  in unify (v1, newVar, fs1, f2 :: fs2,
                            addRESubst (v2, FIELD (reset f1, HOLE newVar)) s)
                  end
                | GREATER => let
                     val newVar = freshTVar ()
                  in unify (newVar, v2, f1 :: fs1, fs2,
                            addRESubst (v1, FIELD (reset f2, HOLE newVar)) s)
                  end)
           | unify (v1, v2, f1 :: fs1, [], s) = let
                     val newVar = freshTVar ()
                  in unify (v1, newVar, fs1, [],
                            addRESubst (v2, FIELD (reset f1, HOLE newVar)) s)
                  end
           | unify (v1, v2, [], f2 :: fs2, s) = let
                     val newVar = freshTVar ()
                  in unify (newVar, v2, [], fs2,
                            addRESubst (v1, FIELD (reset f2, HOLE newVar)) s)
                  end
         and reset (RField {name = n, fty = t, needed = _}) =
               RField {name = n, fty = clearBits t, needed = BD.invalidBVar}
      in
         unify (v1,v2,l1,l2,s)
      end
    | mgu (ALG (ty1, l1), ALG (ty2, l2), s) =
      (case SymbolTable.compare_symid (ty1, ty2) of
        LESS => raise UnificationFailure
      | GREATER => raise UnificationFailure
      | EQAL => let
          fun mguList (e1::e1s, e2::e2s, s) = let
                  val s as (sE,_) = mgu (e1, e2, s)
                  val aSE = applySubstsToExp sE
                in
                   mguList (List.map aSE e1s, List.map aSE e2s, s)
                end
            | mguList ([], [], s) = s
            | mguList _ = raise UnificationFailure
          in mguList (l1, l2, s) end)
    | mgu (VAR v, e, (sE, sRE)) =
      let
         val newSubst = (v,applySubstsToExp sE e)
      in   
        (addSubst newSubst sE, applySubstToRESubsts newSubst sRE)
      end
    | mgu (e, VAR v, (sE, sRE)) =
      let
         val newSubst = (v,applySubstsToExp sE (clearBits e))
      in   
        (addSubst newSubst sE, applySubstToRESubsts newSubst sRE)
      end

    | mgu (_,_,s) = raise UnificationFailure
                                       
    fun dbgMgu (t1, t2) =
      let
         val (t1Str, si) = showTypeSI (t1, TVar.emptyShowInfo)
         val (t2Str, si) = showTypeSI (t2, si)
         val (substs, substsRE) = mgu (t1,t2,(emptySubsts, emptyRESubsts))
         val (sStr, si) = showBothSubstsSI (substs, substsRE, si)
      in
         ("unifying t1=" ^ t1Str ^ "\nwith     t2=" ^ t2Str ^ "\n" ^ sStr)
      end
end