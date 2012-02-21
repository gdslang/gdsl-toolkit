structure Types = struct

   datatype tvar = TVAR of int

   structure BD = BooleanDomain
   
   fun tvarEq (TVAR v1, TVAR v2) = v1=v2

   val tvarGenerator = ref 0

   fun freshTVar () = let
     val v = !tvarGenerator
   in
     (tvarGenerator := v+1; TVAR v)
   end

   structure VarSet = struct
      type set = IntListSet.set
   
      val empty = IntListSet.empty
      fun add (TVAR v, l) = IntListSet.add' (v, l)
      val union = IntListSet.union
      val intersection = IntListSet.intersection
      val difference = IntListSet.difference
      val isEmpty = IntListSet.isEmpty
   end
   type varset = VarSet.set
   
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
      (* extension of a record, can only apply to the special tvar of record *)
    | FIELD of (texp * rfield)
      (* an algebraic data type with a list of type arguments *)
    | ALG of (TypeInfo.symid * texp list)
      (* a record *)
    | RECORD of (tvar * rfield list)
      (* the state monad *)
    | MONAD of texp
      (* a type variable *)
    | VAR of tvar
 
   and rfield = RField of {
    name : FieldInfo.symid,
    fty : texp,
    needed : BD.bvar
   }

   fun texpVarset e = let
      fun tV (FUN (f1, f2), vs) = tV (f2, tV (f1, vs))
        | tV (SYN (syn, t), vs) = tV (t, vs)
        | tV (ZENO, vs) = vs
        | tV (FLOAT, vs) = vs
        | tV (UNIT, vs) = vs
        | tV (VEC t, vs) = tV (t, vs)
        | tV (CONST c, vs) = vs
        | tV (ALG (ty, l), vs) = List.foldl tV vs l
        | tV (RECORD (v,l), vs) = List.foldl tVF (VarSet.add (v,vs)) l
        | tV (MONAD t, vs) = tV (t, vs)
        | tV (VAR v, vs) = VarSet.add (v,vs)
      and tVF (RField {name = n, fty = t, needed = b}, vs) = tV (t,vs)
      in (tV (e, VarSet.empty))
   end
   
   fun compare_rfield (RField f1, RField f2) =
     SymbolTable.compare_symid (#name f1, #name f2)

   type condescr = texp option SymMap.map

   type typedescr = { tdVars : tvar list,
                     tdCons : condescr }

   type Subst = tvar * texp
   fun mkSubst arg = arg

   (* thrown if two field substitutions are to be unified or if a field should
   be added to a record that already has it, both of which indicates a bug *)
   exception EquivalenceClassError

   datatype Substs = Substs of Subst list

   structure VarMap = IntRedBlackMap
   val emptyShowInfo = VarMap.empty
   fun name idx = (if idx>25 then name (Int.div (idx,26)-1) else "") ^
        Char.toString (Char.chr (Char.ord #"a"+Int.mod (idx,26)))

   fun varToString (TVAR var, tab) = case VarMap.find (tab, var) of
          SOME str => (str, tab)
        | NONE => let
             val str = name (VarMap.numItems(tab))
          in
             (str, VarMap.insert(tab, var, str))
          end

   val a = freshTVar ()
   val b = freshTVar ()
   val c = freshTVar ()
   val d = freshTVar ()

   fun genTypes () = let
      val (t, f1) = SymbolTable.create(!SymbolTables.fieldTable, Atom.atom "f1", SymbolTable.noSpan)
      val (t, f2) = SymbolTable.create(t,  Atom.atom "f2", SymbolTable.noSpan)
      val t1 = FUN(VAR a, RECORD (b, [RField { name=f2, fty = FLOAT, needed = BD.invalidBVar}]))
      val t2 = FUN(RECORD (c, [RField { name=f1, fty = ZENO, needed = BD.invalidBVar}]), VAR a)
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
      | sT (p, FIELD (VAR v,f)) = sTF f ^ showVar v ^ ": ..."
      | sT (p, FIELD (e,f)) = sTF f ^ ", " ^ sT (p,e)
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
         val (str, newSiTab) = varToString (var, !siTab)
      in
         (siTab := newSiTab; str)
      end
    and sTF (RField {name = n, fty = t, needed = b}) =
            SymbolTable.getString(!SymbolTables.fieldTable, n) ^ ": " ^ 
            sT (0, t) ^ ", "
    in (sT (0, ty), !siTab) 
   end

   fun showType ty =
      let val (str,_) = showTypeSI (ty, emptyShowInfo) in str end

   fun showTypes l = let
         fun sT (si, []) = ""
           | sT (si, (str, t) :: l) = (case showTypeSI (t, si) of
                  (tStr, si) => str ^ tStr ^ sT (si, l)
              )
         in
           sT (emptyShowInfo, l)
         end

   fun showSubstSI ((v, t), showInfo) = let
      val (vStr, showInfo) = varToString (v, showInfo)
      val (tStr, showInfo) = showTypeSI (t, showInfo)
   in
      (vStr ^ "/" ^ tStr, showInfo)
   end

   fun showSubst subst =
      let val (str, _) = showSubstSI (subst, emptyShowInfo) in str end
   
   fun showSubsts (Substs l) = let
         fun pr (s, (res, sep, si)) = let
               val (str, si) = showSubstSI (s, si)
            in
               (res ^ sep ^ str, ", ", si)
            end
         val (res, _, si) = List.foldl pr ("", "", emptyShowInfo) l
      in
         "[" ^ res ^ "]"
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
      | aS (FIELD (e, f)) = FIELD (aS e, aSF f)
      | aS (ALG (ty, l)) = ALG (ty, List.map aS l)
      | aS (RECORD (var, l)) = if tvarEq (var, v) then
            let
               fun insertField (f, []) = [f]
                 | insertField (f1, f2 :: l) = (case compare_rfield (f1,f2) of
                      GREATER => f1 :: f2 :: l
                    | LESS => f2 :: insertField (f1, l)
                    | EQUAL => (
                       (*TextIO.print (showTypes [("trying to insert ",e), (" into ",(RECORD (var,l)))]);*)
                       raise EquivalenceClassError))
               fun addField (VAR var, l) = (var, l)
                 | addField (FIELD (e, f), l) = addField (e, insertField (f,l))
                 | addField _ = raise EquivalenceClassError
            in
               RECORD (addField (e, l))
            end
         else RECORD (var, List.map aSF l)
      | aS (MONAD t) = MONAD (aS t)
      | aS (VAR var) = if tvarEq (var, v) then e else VAR var
    and
      aSF (RField {name = n, fty = t, needed = b}) =
         RField {name = n, fty =  aS t, needed = b}
    in aS exp end                                          

   fun applySubstsToExp (Substs l) exp =
        List.foldl applySubstToExp exp l  

   fun applySubstToSubst subst (v2, e2) = (v2, applySubstToExp (subst, e2))

   fun addSubst (v,e) (substs as Substs l) =
      let
         (*val _ = TextIO.print ("adding subst: " ^ showSubst (v,e) ^ "\n")*)
         val subst = (v,applySubstsToExp substs e)
      in
         Substs (subst::List.map (applySubstToSubst subst) l)
      end


   exception UnificationFailure


   fun mgu (FUN (f1, f2), FUN (g1, g2), s) =
      let
         val s = mgu (f2, g2, s)
      in
         mgu (applySubstsToExp s f1, applySubstsToExp s g1, s)
      end
    | mgu (SYN (_, t1), t2, s) = mgu (t1, t2, s)
    | mgu (t1, SYN (_, t2), s) = mgu (t1, t2, s)
    | mgu (ZENO, ZENO, s) = s
    | mgu (FLOAT, FLOAT, s) = s
    | mgu (UNIT, UNIT, s) = s
    | mgu (VEC t1, VEC t2, s) = mgu (t1, t2, s)
    | mgu (CONST c1, CONST c2, s) =
        if c1=c2 then s else raise UnificationFailure
    | mgu (FIELD _, FIELD _, s) = raise EquivalenceClassError
    | mgu (RECORD (v1,l1), RECORD (v2,l2), s) =
      let
         fun unify (v1, v2, [], [], s) = s
           | unify (v1, v2, (f1 as RField e1) :: fs1,
                    (f2 as RField e2) :: fs2, s) =
               (case compare_rfield (f1,f2) of
                  EQUAL =>
                  let
                     val s = mgu (#fty e1, #fty e2, s)
                     fun aSF (RField {name = n, fty = t, needed = b}) =
                              RField {name = n, fty = applySubstsToExp s t,
                              needed = b}
                  in
                     unify (v1, v2, List.map aSF fs1, List.map aSF fs2, s)
                  end
                | LESS => let
                     val newVar = freshTVar ()
                  in unify (v1, newVar, fs1, f2 :: fs2,
                            addSubst (v2, FIELD (VAR newVar, reset f1)) s)
                  end
                | GREATER => let
                     val newVar = freshTVar ()
                  in unify (newVar, v2, f1 :: fs1, fs2,
                            addSubst (v1, FIELD (VAR newVar, reset f2)) s)
                  end)
           | unify (v1, v2, f1 :: fs1, [], s) = let
                     val newVar = freshTVar ()
                  in unify (v1, newVar, fs1, [],
                            addSubst (v2, FIELD (VAR newVar, reset f1)) s)
                  end
           | unify (v1, v2, [], f2 :: fs2, s) = let
                     val newVar = freshTVar ()
                  in unify (newVar, v2, [], fs2,
                            addSubst (v1, FIELD (VAR newVar, reset f2)) s)
                  end
         and reset (RField {name = n, fty = t, needed = _}) =
               RField {name = n, fty = t, needed = BD.invalidBVar}
      in
         unify (v1,v2,l1,l2,s)
      end
    | mgu (ALG (ty1, l1), ALG (ty2, l2), s) =
      (case SymbolTable.compare_symid (ty1, ty2) of
        LESS => raise UnificationFailure
      | GREATER => raise UnificationFailure
      | EQAL => let
          fun mguList (e1::e1s, e2::e2s, s) = let
                  val s = mgu (e1, e2, s)
                in
                   mguList (List.map (applySubstsToExp s) e1s,
                            List.map (applySubstsToExp s) e2s,
                            s)
                end
            | mguList ([], [], s) = s
            | mguList _ = raise UnificationFailure
          in mguList (l1, l2, s) end)
    | mgu (VAR v, e, s) = addSubst (v,e) s
    | mgu (e, VAR v, s) = addSubst (v,e) s
    | mgu (_,_,s) = raise UnificationFailure
                                       

end