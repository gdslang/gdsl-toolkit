structure Substitutions : sig

   exception UnificationFailure of string

   exception SubstitutionBug

   val insertField : Types.rfield * Types.rfield list -> Types.rfield list
   
   type Substs

   val emptySubsts : Substs

   val substsFilter : Substs * TVar.set -> Substs
   
   val isEmpty : Substs -> bool

   val showSubstsSI : Substs * TVar.varmap -> string * TVar.varmap
   
   (*raise an exception if the type contains a record with a nested field name*)
   val checkFieldRecursion : Types.texp -> unit
   
   type expand_info
   
   val emptyExpandInfo : expand_info
   val applyExpandInfo : expand_info -> BooleanDomain.bfun -> BooleanDomain.bfun

   val applySizeConstraints : SizeConstraint.size_constraint_set * Substs ->
                              SizeConstraint.size_constraint_set * Substs

   val applySubstsToExp : Substs -> Types.texp * expand_info ->
                          Types.texp * expand_info

   (*create a fresh type by instantiating the variables in the given type,
   plus those in the third set (meant to expand the decode width variables)
   but without those variable in the first set*)
   val instantiateType : TVar.set * Types.texp * TVar.set *
      BooleanDomain.bfun * SizeConstraint.size_constraint_set ->
      Types.texp * BooleanDomain.bfun * SizeConstraint.size_constraint_set

   val mgu : Types.texp * Types.texp * Substs -> Substs

end = struct

   open Types
   structure SC = SizeConstraint

   exception UnificationFailure of string

   exception SubstitutionBug
   
   datatype SubstTarget
      = WITH_TYPE of texp
      | WITH_FIELD of (rfield list * tvar)
   
   type Subst = tvar * SubstTarget
   
   fun mkSubst arg = arg

   datatype Substs = Substs of Subst list

   fun substsFilter (Substs ss, set) =
     Substs (List.filter (fn (v,_) => TVar.member (set,v)) ss)

   fun isEmpty (Substs ss) = List.null ss

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
   
   fun showSubstsSI (Substs l, si) =
      let
         fun pr (s, (res, sep, si)) =
            let
               val (str, si) = showSubstSI (s, si)
            in
               (res ^ sep ^ str, ", ", si)
            end
         val (res, _, si) = List.foldl pr ("[", "", si) l
      in
         (res ^ "]", si)
      end

   val emptySubsts = Substs []

   structure TVMap = RedBlackMapFn (
      struct
         type ord_key = TVar.tvar
         val compare = TVar.compare
      end)

   type expand_detail = { substVars : BD.bvar list,
                          instInfo : (BD.bvar * (bool * BD.bvar) list) list }   

   type expand_info = expand_detail TVMap.map

   val emptyExpandInfo = TVMap.empty : expand_info

   fun addToExpandInfo (tvar, bvar, target, ei) =
      let
         fun getTargetVars (WITH_TYPE t) = texpBVarset (op ::) (t,[])
           | getTargetVars (WITH_FIELD (fs,var)) =
            List.foldl
               (fn (RField {name = n, fty = t, exists = b},bs) =>
                  texpBVarset (op ::) (t,(false,b)::bs))
               [] fs
         val detail = case TVMap.find (ei, tvar) of
              SOME detail => detail
            | NONE => {substVars = List.map #2 (getTargetVars target),
                       instInfo = []}
         fun genTargetInstance (WITH_TYPE t) = WITH_TYPE (setFlagsToTop t)
           | genTargetInstance (WITH_FIELD (fs,var)) =
               WITH_FIELD (List.map setFlagsToTopF fs, var)
         val newTarget = genTargetInstance target
         val newDetail = case detail of { substVars = sVs, instInfo = ii } =>
               {substVars = sVs,
                instInfo = (bvar, getTargetVars newTarget) :: ii}
      in
         (newTarget, TVMap.insert (ei, tvar, newDetail))
      end

   fun applyExpandInfo ei bFun =
      let
         fun aEI ({substVars = sVs, instInfo = infos}, bFun) =
            let
               val bFun = List.foldl
                     (fn ((_,inst), bFun) =>
                        BD.expand (sVs, List.map (fn (_,v) => (false,v))
                                        inst, bFun)
                     ) bFun infos
               fun shave (info as ((_ :: _) :: _)) =
                     SOME (List.map List.hd info, List.map List.tl info)
                 | shave ([] :: _) = NONE
                 | shave _ = raise SubstitutionBug
               val (tvarInfo, insts) = ListPair.unzip infos
               fun expandTVar (insts,bFun) = case shave insts of
                    NONE => bFun
                  | SOME (inst, insts) =>
                     expandTVar (insts, BD.expand (tvarInfo, inst, bFun))
            in
               expandTVar (insts, bFun)
            end
      in
         List.foldl aEI bFun (TVMap.listItems ei)
      end

   fun insertField (f, []) = [f]
     | insertField (f1, f2 :: l) = (case compare_rfield (f1,f2) of
          LESS => f1 :: f2 :: l
        | GREATER => f2 :: insertField (f1, l)
        | EQUAL => (*(TextIO.print ("inserting same field " ^ SymbolTable.getString(!SymbolTables.fieldTable, case f1 of RField {name=n,fty,exists} => n) ^
                    " into " ^ showType (RECORD (TVar.freshTVar (),BooleanDomain.freshBVar (), f2 :: l)));*)
            raise SubstitutionBug)

   structure SISet = RedBlackSetFn (
      struct
         type ord_key = SymbolTable.symid
         val compare = SymbolTable.compare_symid
      end)

   fun checkFieldRecursion t =
      let
         fun cFR (FUN (f1, f2)) = SISet.union (cFR f1, cFR f2)
           | cFR (SYN (syn, t)) = cFR t
           | cFR (ZENO) = SISet.empty
           | cFR (FLOAT) = SISet.empty
           | cFR (UNIT) = SISet.empty
           | cFR (VEC t) = cFR t
           | cFR (CONST c) = SISet.empty
           | cFR (ALG (ty, l)) = List.foldl SISet.union SISet.empty
                                 (List.map cFR l)
           | cFR (RECORD (_, _, fs)) =
               let
                  fun chkField (RField { name = n, fty = t, exists = _}) =
                     case cFR t of set =>
                     if SISet.member (set, n) then
                        raise UnificationFailure ("infinite field nesting " ^
                           SymbolTable.getString(!SymbolTables.fieldTable, n) ^
                           " : " ^ showType t)
                     else SISet.add (set, n)
               in
                  List.foldl SISet.union SISet.empty (List.map chkField fs)
               end
           | cFR (MONAD t) = cFR t
           | cFR (VAR _) = SISet.empty
         val s = cFR t
         (*fun showSyms [] = ""
           | showSyms (s :: ss) = SymbolTable.getString(!SymbolTables.fieldTable, s) ^ " " ^ showSyms ss
         val _ = TextIO.print ("===== checkFieldRecursion on " ^ showType t ^
                               ": " ^ showSyms (SISet.listItems s) ^ "\n")*)
      in
         ()
      end

   fun applySubstToExp (subst as (v, target)) (exp, ei) = let
      val eiRef = ref (ei : expand_info)
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
              case addToExpandInfo (var, b, target, !eiRef) of
                 (target,ei) => (eiRef := ei; case target of
                      WITH_FIELD (newFs, newVar) =>
                       RECORD (newVar, b, List.foldl insertField fs newFs)
                    | WITH_TYPE (VAR (v,b)) => RECORD (v, b, fs)
                    | WITH_TYPE _ => raise SubstitutionBug
                 )
            else let
               val (fs, ei) = applySubstToRFields subst (fs, !eiRef)
            in
               (eiRef := ei; RECORD (var, b, fs))
            end
        | aS (MONAD t) = MONAD (aS t)
        | aS (VAR (var,b)) = if TVar.eq (var, v) then
              case addToExpandInfo (var, b, target, !eiRef) of
                   (WITH_TYPE t,ei) => (eiRef := ei; t)
                 | (WITH_FIELD _,ei) => raise SubstitutionBug
           else VAR (var,b)
      in
         (aS exp, !eiRef)
      end
   and applySubstToRField subst
      (RField {name = n, fty = t, exists = b}, ei) =
      let
         val (t,ei) = applySubstToExp subst (t,ei)
      in
         (RField {name = n, fty = t, exists = b}, ei)
      end

   and applySubstsToExp (Substs ss) (exp, ei) =
        List.foldl (fn (s,exp_ei) => applySubstToExp s exp_ei) (exp,ei) ss 

   and applySubstsToRField (Substs ss) (f, ei) =
        List.foldl (fn (s,f_ei) => applySubstToRField s f_ei) (f, ei) ss  

   and applySubstToRFields s (fs, ei) =
      let
         fun app ([], ei) = ([], ei)
           | app (f::fs, ei) =
            let
               val (f, ei) = applySubstToRField s (f,ei)
               val (fs, ei) = app (fs, ei)
            in
               (f::fs, ei)
            end
      in
         app (fs, ei)
      end

   fun addSubst (subst as (v, WITH_TYPE t)) (Substs l) =
      let
         fun tSubst (v2, WITH_TYPE t2) =
            let
               val (t, _) = applySubstToExp subst (t2, emptyExpandInfo)
               val vs = texpVarset (t, TVar.empty)
               (*val (vStr,si) = TVar.varToString (v2,TVar.emptyShowInfo)
               val (vsStr, si) = TVar.setToString(vs, si)
               val (tStr, si) = showTypeSI (t, si)
               val _ = TextIO.print ("subst " ^ vStr ^ "/" ^ tStr ^ " has vars " ^ vStr ^ "\n")*)
            in
               if List.exists (fn v => TVar.eq(v,v2)) (TVar.listItems vs) then
                  let
                     val (vStr,si) = TVar.varToString (v2,TVar.emptyShowInfo)
                     val (tStr,si) = showTypeSI (t,si)
                  in
                     raise UnificationFailure ("infinite type " ^ vStr ^ " = " ^ tStr)
                  end
               else
                  (v2, WITH_TYPE t)
            end
           | tSubst (v2, WITH_FIELD (fs, v3)) =
            (v2, WITH_FIELD (List.map (fn f =>
               case applySubstToRField subst (f,emptyExpandInfo) of
                  (f,_) => f) fs, v3))
         (*val (vStr,si) = TVar.varToString (v,TVar.emptyShowInfo)
         val (tStr,si) = showTypeSI (t,si)
         val (sStr,si) = showSubstsSI (Substs l, si)
         val (rStr,_ ) = showSubstsSI (Substs (subst::List.map tSubst l),si)
         val _ = TextIO.print ("adding " ^ vStr ^ "/" ^ tStr ^ " to " ^ sStr ^
                  " yielding " ^ rStr ^ "\n")*)
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

   fun findSubstForVar (v, Substs l) =
      let
         fun lookup [] = NONE
           | lookup ((v',r) :: l) =
               if TVar.eq (v,v') then SOME r else lookup l
      in
         lookup l
      end

   fun applySizeConstraints (sCons, substs) =
      let
         val vs = SC.getVarset sCons
         val (Substs ss) = substsFilter (substs, vs)
         fun updateSubsts ((v,WITH_TYPE (CONST c)), (sCons, substs)) =
            (case SC.add (SC.equality (v,[],c), sCons) of
                SC.RESULT (is,sCons) =>
                  (sCons, List.foldl (fn ((v,c), substs) =>
                     addSubst (v,WITH_TYPE (CONST c)) substs) substs is)
               | SC.UNSATISFIABLE => raise UnificationFailure
                  "size constraints over vectors are unsatisfiable"
               | SC.FRACTIONAL => raise UnificationFailure
                  "solution to size constraint is not integral"
               | SC.NEGATIVE => raise UnificationFailure
                  "constraint implies that vector has non-positive size"
            )
           | updateSubsts ((v1,WITH_TYPE (VAR (v2,_))), (sCons, substs)) =
               (SC.rename (v1,v2,sCons), substs)
           | updateSubsts _ = raise SubstitutionBug
      in
         List.foldl updateSubsts (sCons, substs) ss
      end

   fun instantiateType (vs,t,extraTVars,bFun,sCons) =
      let
         val toReplace = TVar.difference (texpVarset (t, extraTVars), vs)
         val substs = Substs (
               List.map (fn v => (v,
                 WITH_TYPE (VAR (TVar.freshTVar (), BD.freshBVar ())))
               ) (TVar.listItems toReplace))
         val newSCons = SC.filter (toReplace, sCons)
         val (newSCons, substs) = applySizeConstraints (newSCons, substs)
         val mergedSCons = SC.merge (newSCons, sCons)
         (*val (tStr, si) = showTypeSI (t, TVar.emptyShowInfo)
         val (sStr, si) = TVar.setToString (vs, si)
         val (vStr, si) = TVar.setToString (texpVarset (t, TVar.empty), si)
         val (suStr, si) = showSubstsSI (substs, si)
         val (scStr1,si) = SC.toStringSI (sCons, NONE, si)
         val (scStr2,si) = SC.toStringSI (mergedSCons, NONE, si)
         val _ = TextIO.print ("instantiating " ^ tStr ^ " using " ^ suStr ^ ", extending " ^ scStr1 ^ " to " ^ scStr2 ^ "\n")*)
         val (t,ei) = applySubstsToExp substs (t, emptyExpandInfo)
      in
         (t, applyExpandInfo ei bFun, mergedSCons)
      end

   fun mgu (FUN (f1, f2), FUN (g1, g2), s) = mgu (f2, g2, mgu (f1, g1, s))
    | mgu (SYN (_, t1), t2, s) = mgu (t1, t2, s)
    | mgu (t1, SYN (_, t2), s) = mgu (t1, t2, s)
    | mgu (ZENO, ZENO, s) = s
    | mgu (FLOAT, FLOAT, s) = s
    | mgu (UNIT, UNIT, s) = s
    | mgu (VEC t1, VEC t2, s) = mgu (t1, t2, s)
    | mgu (CONST c1, CONST c2, s) =
        if c1=c2 then s else raise UnificationFailure (
         "incompatible bit vectors sizes (" ^ Int.toString c1 ^ " and " ^
         Int.toString c2 ^ ")")
    | mgu (RECORD (v1,b1,l1), RECORD (v2,b2,l2), s) =
      let
         fun unify (v1, v2, [], [], s) = if TVar.eq (v1,v2) then s else
               addSubst (v2, WITH_FIELD ([],v1)) s
           | unify (v1, v2, (f1 as RField e1) :: fs1,
                    (f2 as RField e2) :: fs2, s) =
               (case compare_rfield (f1,f2) of
                  EQUAL =>
                  let
                     val s = mgu (#fty e1, #fty e2, s)
                   in
                     unify (v1, v2, fs1, fs2, s)
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
                  end
               )
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
         fun applySubsts (v, fs) = (case findSubstForVar (v, s) of
              NONE => (v,fs)
            | SOME (WITH_FIELD (fs',v')) => (v', List.foldl insertField fs fs')
            | _ => raise SubstitutionBug
         )
         val (v1,l1) = applySubsts (v1,l1)
         val (v2,l2) = applySubsts (v2,l2)
      in
         unify (v1,v2,l1,l2,s)
      end
    | mgu (MONAD ty1, MONAD ty2, s) = mgu (ty1, ty2, s)
    | mgu (ALG (ty1, l1), ALG (ty2, l2), s) =
      let fun incompat () = raise UnificationFailure (
            "cannot match constructor " ^
            SymbolTable.getString(!SymbolTables.typeTable, ty1) ^
            " with " ^
            SymbolTable.getString(!SymbolTables.typeTable, ty2))
      in case SymbolTable.compare_symid (ty1, ty2) of
        LESS => incompat ()
      | GREATER => incompat ()
      | EQAL => List.foldl (fn ((e1,e2),s) => mgu (e1,e2,s)) s
                  (ListPair.zipEq (l1,l2))
      end
      (*mgu is right-biased in that mgu(a,b) always creates b/a which means
      that the resulting substitution never modifies the lhs if that is
      avoidable*)
    | mgu (e, VAR (v,b), s) =
      let
         fun unifyVars (v,b,e,s) =
               case findSubstForVar (v,s) of
                    NONE => 
                     let
                       val (e, _) = applySubstsToExp s (e, emptyExpandInfo)
                     in
                        addSubst (v,WITH_TYPE e) s
                     end
                  | SOME (WITH_TYPE t) => mgu (e, t, s)
                  | _ => raise SubstitutionBug
      in
        case e of
           VAR (v',b') => if TVar.eq (v',v) then s else unifyVars (v,b,e,s)
         | _ => unifyVars (v,b,e,s)
      end
    | mgu (VAR (v,b), e, s) =
         (case findSubstForVar (v,s) of
              NONE =>
               let
                 val (e, _) = applySubstsToExp s (e, emptyExpandInfo)
               in
                  addSubst (v,WITH_TYPE e) s
               end
            | SOME (WITH_TYPE t) => mgu (e, t, s)
            | _ => raise SubstitutionBug
         )
    | mgu (t1,t2,s) =
      let fun descr (FUN _) = "a function type"
            | descr (ZENO) = "int"
            | descr (FLOAT) = "float"
            | descr (UNIT) = "()"
            | descr (VEC (CONST c)) = "a vector of " ^ Int.toString c ^ " bits"
            | descr (VEC _) = "a bit vector"
            | descr (ALG (ty, _)) = "type " ^
               SymbolTable.getString(!SymbolTables.typeTable, ty)
            | descr (RECORD _) = "a record"
            | descr (MONAD _) = "an action"
            | descr _ = "something that shouldn't be here"
      in
         raise UnificationFailure ("cannot match " ^ descr t1 ^ " against " ^
                                   descr t2)
      end
                                       
   and unifyVars (v,b,e,s) =
      case findSubstForVar (v,s) of
           NONE => addSubst (v,WITH_TYPE e) s
         | SOME (WITH_TYPE t) => mgu (t, e, s)
         | _ => raise SubstitutionBug

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
