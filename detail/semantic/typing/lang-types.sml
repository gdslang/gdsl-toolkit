structure Types = struct

   exception UnificationFailure of string

   exception SubstitutionBug
   
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

   type typedescr = { tdVars : tvar list,
                     tdCons : condescr }

   datatype SubstTarget
      = WITH_TYPE of texp
      | WITH_FIELD of (rfield list * tvar)
   
   type Subst = tvar * SubstTarget
   
   fun mkSubst arg = arg

   datatype Substs = Substs of Subst list

   fun substsDom (Substs ss) =
         List.foldl (fn ((v,_), set) => TVar.add (v,set)) TVar.empty ss

   val a = freshTVar ()
   val b = freshTVar ()
   val c = freshTVar ()
   val d = freshTVar ()
   val e = freshTVar ()

   fun genTypes () = let
      val (t, f1) = SymbolTable.create(!SymbolTables.fieldTable, Atom.atom "f1", SymbolTable.noSpan)
      val (t, f2) = SymbolTable.create(t,  Atom.atom "f2", SymbolTable.noSpan)
      val t1 = FUN(VAR (a,BD.freshBVar ()), RECORD (b, BD.freshBVar (), [RField { name=f1, fty = VEC (VAR (e,BD.freshBVar ())), exists = BD.freshBVar ()},
      RField { name=f2, fty = VEC (VAR (e,BD.freshBVar ())), exists = BD.freshBVar ()}]))
      val t2 = FUN(RECORD (c, BD.freshBVar (), [RField { name=f1, fty = VEC (VAR (d,BD.freshBVar ())), exists = BD.freshBVar ()}]), VAR (a,BD.freshBVar ()))
   in (SymbolTables.fieldTable := t; (f1,f2,t1,t2)) end
      
   fun showTypeSI (ty, showInfo) = let
    val siTab = ref showInfo
    fun comma [] = ""
      | comma [v] = v
      | comma (v :: vs) = v ^ ", " ^ comma vs
    fun br (curPrec, existsPrec,str) =
      if curPrec>existsPrec then "(" ^ str ^ ")" else str
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
      | sT (p, RECORD (v,b,l)) = "{" ^ List.foldl (op ^) "" (List.map sTF l) ^
                                   showVar v ^ BD.showVar b ^ ": ...}"
      | sT (p, MONAD t) = br (p, p_tyn, "S " ^ sT (p_tyn+1, t))
      | sT (p, VAR (v,b)) = showVar v ^ BD.showVar b
   and showVar var = let 
         val (str, newSiTab) = TVar.varToString (var, !siTab)
      in
         (siTab := newSiTab; str)
      end
    and sTF (RField {name = n, fty = t, exists = b}) =
            SymbolTable.getString(!SymbolTables.fieldTable, n) ^
            BD.showVar b  ^ ": " ^ sT (0, t) ^ ", "
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

   fun showSubstSI ((v, WITH_TYPE t), si) =
         let
            val (vStr, si) = TVar.varToString (v, si)
            val (tStr, si) = showTypeSI (t, si)
         in
            (vStr ^ "/" ^ tStr, si)
         end
     | showSubstSI ((v, WITH_FIELD (fs,vNew)), si) =
         let
            val (vStr, si) = TVar.varToString (v, si)
            val (vNewStr, si) = TVar.varToString (vNew, si)
            fun genfStr (RField {name = n, fty = t, exists = b}, (str, si)) =
               let
                  val (tstr, si) = showTypeSI (t, si)
                  val name = SymbolTable.getString(!SymbolTables.fieldTable, n)
               in
                  (str ^ name ^ ": " ^ tstr ^ ", ", si)
               end
            val (fsStr, si) = List.foldl genfStr ("", si) fs
         in
            (vStr ^ "/" ^ fsStr ^ vNewStr ^ ": ...", si)
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

   fun insertField (f, []) = [f]
     | insertField (f1, f2 :: l) = (case compare_rfield (f1,f2) of
          GREATER => f1 :: f2 :: l
        | LESS => f2 :: insertField (f1, l)
        | EQUAL => (
            (*TextIO.print (showTypes [("trying to insert ",e), (" into ",(RECORD (var,l)))]);*)
            raise SubstitutionBug))

   fun applySubstToExp (subst as (v, target), exp) = let
      fun aS (FUN (f1, f2)) = FUN (aS f1, aS f2)
        | aS (SYN (syn, t)) = SYN (syn, aS t)
        | aS (ZENO) = ZENO
        | aS (FLOAT) = FLOAT
        | aS (UNIT) = UNIT
        | aS (VEC t) = VEC (aS t)
        | aS (CONST c) = CONST c
        | aS (ALG (ty, l)) = ALG (ty, List.map aS l)
        | aS (RECORD (var, b, fs)) =
           if TVar.eq (var, v) then
              case target of
                   WITH_FIELD (newFs, newVar) =>
                    RECORD (newVar, b, List.foldl insertField fs newFs)
                 | WITH_TYPE _ => raise SubstitutionBug
           else RECORD (var, b, List.map (applySubstToRField  subst) fs)
        | aS (MONAD t) = MONAD (aS t)
        | aS (VAR (var,b)) = if TVar.eq (var, v) then
              case target of
                 WITH_TYPE t => t
               | WITH_FIELD _ => raise SubstitutionBug
           else VAR (var,b)
      in
         aS exp
      end
   and applySubstToRField subst (RField {name = n, fty = t, exists = b}) =
         RField {name = n, fty = applySubstToExp (subst,t), exists = b}

   fun applySubstsToExp (Substs l) exp =
        List.foldl applySubstToExp exp l  

   fun applySubstsToRField (Substs l) fs =
        List.foldl (fn (s,f) => applySubstToRField s f) fs l  

   fun addSubst (subst as (v, WITH_TYPE t)) (Substs l) =
      let
         fun tSubst (v2, WITH_TYPE t2) =
            (v2, WITH_TYPE (applySubstToExp (subst, t2)))
           | tSubst (v2, WITH_FIELD (fs, v3)) =
            (v2, WITH_FIELD (List.map (applySubstToRField subst) fs, v3))
      in
         Substs (subst::List.map tSubst l)
      end
     | addSubst (subst as (v1, WITH_FIELD (fs1,newVar))) (Substs l) =
      let
         fun fSubst ((s as (_,WITH_TYPE _)) :: ss) = s::fSubst ss
           | fSubst ((s as (v,WITH_FIELD (fs2,v2))) :: ss) =
               if TVar.eq(v1,v2) then
                  (v,WITH_FIELD (List.foldl insertField fs1 fs2, newVar)):: ss
               else s :: fSubst ss
           | fSubst [] = [subst]
      in
         Substs (fSubst l)
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
     | setFlagsToTop (MONAD t) = MONAD (setFlagsToTop t)
     | setFlagsToTop (VAR (var,b)) = VAR (var, BD.freshBVar ())
   and
     setFlagsToTopF (RField {name = n, fty = t, exists = _}) =
        RField {name = n, fty =  setFlagsToTop t, exists = BD.freshBVar ()}
        
   fun mgu (FUN (f1, f2), FUN (g1, g2), s) =
      let
         val s = mgu (f1, g1, s)
      in
         mgu (applySubstsToExp s f2, applySubstsToExp s g2, s)
      end
    | mgu (SYN (_, t1), t2, s) = mgu (t1, t2, s)
    | mgu (t1, SYN (_, t2), s) = mgu (t1, t2, s)
    | mgu (ZENO, ZENO, s) = s
    | mgu (FLOAT, FLOAT, s) = s
    | mgu (UNIT, UNIT, s) = s
    | mgu (VEC t1, VEC t2, s) = mgu (t1, t2, s)
    | mgu (CONST c1, CONST c2, s) =
        if c1=c2 then s else raise UnificationFailure (
         "incompatible bit vectors sizes (" ^ IntInf.toString c1 ^ " and " ^
         IntInf.toString c2 ^ ")")
    | mgu (RECORD (v1,b1,l1), RECORD (v2,b2,l2), s) =
      let
         fun unify (v1, v2, [], [], s) = if TVar.eq (v1,v2) then s else
               addSubst (v1, WITH_FIELD ([],v2)) s
           | unify (v1, v2, (f1 as RField e1) :: fs1,
                    (f2 as RField e2) :: fs2, s) =
               (case compare_rfield (f1,f2) of
                  EQUAL =>
                  let
                     val s = mgu (#fty e1, #fty e2, s)
                   in
                     unify (v1, v2, List.map (applySubstsToRField s) fs1,
                                    List.map (applySubstsToRField s) fs2, s)
                  end
                | LESS => let
                     val newVar = freshTVar ()
                  in unify (v1, newVar, fs1, f2 :: fs2,
                            addSubst (v2, WITH_FIELD ([f1], newVar)) s)
                  end
                | GREATER => let
                     val newVar = freshTVar ()
                  in unify (newVar, v2, f1 :: fs1, fs2,
                            addSubst (v1, WITH_FIELD ([f2], newVar)) s)
                  end)
           | unify (v1, v2, f1 :: fs1, [], s) = let
                     val newVar = freshTVar ()
                  in unify (v1, newVar, fs1, [],
                            addSubst (v2, WITH_FIELD ([f1], newVar)) s)
                  end
           | unify (v1, v2, [], f2 :: fs2, s) = let
                     val newVar = freshTVar ()
                  in unify (newVar, v2, [], fs2,
                            addSubst (v1, WITH_FIELD ([f2], newVar)) s)
                  end
      in
         unify (v1,v2,l1,l2,s)
      end
    | mgu (ALG (ty1, l1), ALG (ty2, l2), s) =
      let fun incompat () = raise UnificationFailure (
            "cannot match constructor " ^
            SymbolTable.getString(!SymbolTables.typeTable, ty1) ^
            " with " ^
            SymbolTable.getString(!SymbolTables.typeTable, ty2))
      in case SymbolTable.compare_symid (ty1, ty2) of
        LESS => incompat ()
      | GREATER => incompat ()
      | EQAL =>
         let
            fun mguList (e1::e1s, e2::e2s, s) = let
                  val s  = mgu (e1, e2, s)
               in
                  mguList (List.map (applySubstsToExp s) e1s,
                           List.map (applySubstsToExp s) e2s, s)
               end
              | mguList ([], [], s) = s
                  (*this actually can't happen unless a data constructor is
                  re-defined with a different number of arguments*)
              | mguList _ = raise UnificationFailure ("constructor " ^
                  SymbolTable.getString(!SymbolTables.typeTable, ty1) ^
                  " is used with varying number of arguments")
         in
            mguList (l1, l2, s)
         end
      end
    | mgu (VAR (v,b), e, s) =
      let
         val newSubst = (v,WITH_TYPE (applySubstsToExp s e))
      in   
        addSubst newSubst s
      end
    | mgu (e, VAR (v,b), s) =
      let
         val newSubst = (v,WITH_TYPE (applySubstsToExp s e))
      in   
        addSubst newSubst s
      end

    | mgu (t1,t2,s) =
      let fun descr (FUN _) = "a function type"
            | descr (ZENO) = "int"
            | descr (FLOAT) = "float"
            | descr (UNIT) = "()"
            | descr (VEC (CONST c)) = "a vector of " ^ IntInf.toString c ^ " bits"
            | descr (VEC _) = "a bit vector"
            | descr (ALG (ty, _)) = "a constructor " ^
               SymbolTable.getString(!SymbolTables.typeTable, ty)
            | descr (RECORD _) = "a record"
            | descr (MONAD _) = "an action"
            | descr _ = "something that shouldn't be here"
      in
         raise UnificationFailure ("cannot match " ^ descr t1 ^ " against " ^
                                   descr t2)
      end
                                       
    fun dbgMgu (t1, t2) =
      let
         val (t1Str, si) = showTypeSI (t1, TVar.emptyShowInfo)
         val (t2Str, si) = showTypeSI (t2, si)
         val substs = mgu (t1,t2,emptySubsts)
         val (sStr, si) = showSubstsSI (substs, si)
      in
         ("unifying t1=" ^ t1Str ^ "\nwith     t2=" ^ t2Str ^ "\n" ^ sStr)
      end
end