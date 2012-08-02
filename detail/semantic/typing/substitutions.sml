structure Substitutions : sig

   exception UnificationFailure of string

   exception SubstitutionBug

   val insertField : Types.rfield * Types.rfield list -> Types.rfield list
   
   type Substs

   val emptySubsts : Substs

   val substsFilter : Substs * TVar.set -> Substs
   
   val applySubstsToVarset : Substs * TVar.set -> TVar.set
   
   val isEmpty : Substs -> bool

   val showSubstsSI : Substs * TVar.varmap -> string * TVar.varmap
   
   type expand_info
   
   val showExpandInfoSI : expand_info * TVar.varmap ->
                          string * TVar.varmap
   val emptyExpandInfo : expand_info

   val applyExpandInfo : expand_info -> BooleanDomain.bfun -> BooleanDomain.bfun

   val expandInfoGetBVars : expand_info * BooleanDomain.bvarset ->
                                    BooleanDomain.bvarset
   
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
      | WITH_FIELD of (rfield list * tvar * BD.bvar)
   
   type Subst = tvar * SubstTarget
   
   fun mkSubst arg = arg

   datatype Substs = Substs of Subst list

   fun substsFilter (Substs ss, set) =
     Substs (List.filter (fn (v,_) => TVar.member (set,v)) ss)

   fun applySubstsToVarset (Substs ss, set) =
      let
         fun getTargetVars (WITH_TYPE t, set) = texpVarset (t,set)
           | getTargetVars (WITH_FIELD (fs,var,_), set) =
            List.foldl
               (fn (RField {name = n, fty = t, exists = b},set) =>
                  texpVarset (t,set))
               (TVar.add (var,set)) fs
      in
         List.foldl (fn ((v, st),set) =>
                     if TVar.member (set,v)
                        then getTargetVars (st,TVar.del (v,set))
                        else set) set ss
      end

   fun isEmpty (Substs ss) = List.null ss

   val a = freshTVar ()
   val b = freshTVar ()
   val c = freshTVar ()
   val d = freshTVar ()
   val e = freshTVar ()

   fun genTypes () = let
      val (t, f1) = SymbolTable.create(!SymbolTables.fieldTable, Atom.atom "f1", SymbolTable.noSpan)
      val (t, f2) = SymbolTable.create(t,  Atom.atom "f2", SymbolTable.noSpan)
      val t1 = FUN([VAR (a,BD.freshBVar ())], RECORD (b, BD.freshBVar (), [RField { name=f1, fty = VEC (VAR (e,BD.freshBVar ())), exists = BD.freshBVar ()},
      RField { name=f2, fty = VEC (VAR (e,BD.freshBVar ())), exists = BD.freshBVar ()}]))
      val t2 = FUN([RECORD (c, BD.freshBVar (), [RField { name=f1, fty = VEC (VAR (d,BD.freshBVar ())), exists = BD.freshBVar ()}])], VAR (a,BD.freshBVar ()))
   in (SymbolTables.fieldTable := t; (f1,f2,t1,t2)) end
      
   fun showSubstTargetSI (WITH_TYPE t, si) = showTypeSI (t, si)
     | showSubstTargetSI (WITH_FIELD (fs,vNew,bNew), si) =
         let
            val (vNewStr, si) = TVar.varToString (vNew, si)
            val bNewStr = BD.showVar bNew
            fun genfStr (RField {name = n, fty = t, exists = b}, (str, si)) =
               let
                  val (tStr, si) = showTypeSI (t, si)
                  val fStr = BD.showVar b
                  val name = SymbolTable.getString(!SymbolTables.fieldTable, n)
               in
                  (str ^ name ^ fStr ^ ": " ^ tStr ^ ", ", si)
               end
            val (fsStr, si) = List.foldl genfStr ("", si) fs
         in
            (fsStr ^ vNewStr ^ bNewStr ^ ": ...", si)
         end

   fun showSubstSI ((v,st), si) =
      let
         val (vStr, si) = TVar.varToString (v, si)
         val (stStr, si) = showSubstTargetSI (st, si)
      in
         (vStr ^ "/" ^ stStr, si)
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

   type expand_detail = { substVars : SubstTarget,
                          instInfo : (BD.bvar * SubstTarget) list }   

   type expand_info = expand_detail TVMap.map

   fun showExpandInfoSI (ei, si) =
      let
         val siRef = ref si
         fun showVar tv =
            let
               val (vStr, si) = TVar.varToString (tv, !siRef)
               val _ = siRef := si
            in
               vStr
            end
         fun showSubstTarget st =
            let
               val (stStr, si) = showSubstTargetSI (st, !siRef)
               val _ = siRef := si
            in
               stStr
            end
         fun showAll (tv,{substVars = st, instInfo = stList }) =
             showVar tv ^ "\t" ^ showSubstTarget st ^
            List.foldl (fn ((bv,st),str) => str ^ "\n" ^ 
                        BD.showVar bv ^ ":\t" ^ showSubstTarget st)
               "" stList
      in
         (List.foldl (fn (e,str) => str ^ showAll e ^ "\n") "" (TVMap.listItemsi ei)
         , !siRef)
      end

   val emptyExpandInfo = TVMap.empty : expand_info

   fun addToExpandInfo (tvar, bvar, target, ei) =
      let
         val detail = case TVMap.find (ei, tvar) of
              SOME detail => detail
            | NONE => {substVars = target,
                       instInfo = []}
         
         fun genTargetInstance (WITH_TYPE t) = WITH_TYPE (setFlagsToTop t)
           | genTargetInstance (WITH_FIELD (fs,var,bvar)) =
               WITH_FIELD (List.map setFlagsToTopF fs, var, BD.freshBVar ())
         val newTargetRef = ref target
         fun updateII ((v,tgt) :: vts) =
            if BD.eq(v,bvar) then (newTargetRef := tgt; (v,tgt) :: vts) else
            (v,tgt) :: updateII vts
           | updateII [] = (newTargetRef := genTargetInstance target
                           ; [(bvar, !newTargetRef)])
         val { substVars = sVs, instInfo = ii } = detail
         val newDetail = { substVars = sVs, instInfo = updateII ii }
      in
         (!newTargetRef, TVMap.insert (ei, tvar, newDetail))
      end

   fun applyExpandInfo ei bFun =
      let
         fun aEI ({substVars = sVs, instInfo = infos}, bFun) =
            let
               (*val bFun = List.foldl
                     (fn ((_,inst), bFun) =>
                        BD.expand (List.map #2 (getTargetVars sVs), List.map (fn (_,v) => (false,v))
                                        inst, bFun)
                     ) bFun infos*)
               fun shave (info as ((_ :: _) :: _)) =
                     SOME (List.map List.hd info, List.map List.tl info)
                 | shave ([] :: _) = NONE
                 | shave _ = raise SubstitutionBug
               val (tvarInfo, insts) = ListPair.unzip infos
               fun expandTVar (insts,bFun) = case shave insts of
                    NONE => bFun
                  | SOME (inst, insts) =>
                     expandTVar (insts, BD.expand (tvarInfo, inst, bFun))
               fun getTargetVars (WITH_TYPE t) = texpBVarset (op ::) (t,[])
                 | getTargetVars (WITH_FIELD (fs,var,bvar)) =
                  List.foldl
                     (fn (RField {name = n, fty = t, exists = b},bs) =>
                        texpBVarset (op ::) (t,(false,b)::bs))
                     [(false,bvar)] fs
            in
               expandTVar (List.map getTargetVars insts, bFun)
            end
      in
         List.foldl aEI bFun (TVMap.listItems ei)
      end

   fun expandInfoGetBVars (ei, set) =
      let
         val texpBVarset = texpBVarset (fn ((_,v),vs) => BD.addToSet (v,vs))
         fun getBVars (WITH_TYPE t, set) = texpBVarset (t, set)
           | getBVars (WITH_FIELD (fs,_,bvar), set) =
               List.foldl (fn (RField {name, fty = t, exists = b}, set) =>
                  texpBVarset (t, BD.addToSet (b,set))) 
                  (BD.addToSet (bvar, set)) fs
         fun getBVarsInfo ({substVars = sVs, instInfo = infos}, set) =
            List.foldl
               (fn ((bVar,st),set) => getBVars (st, BD.addToSet (bVar,set)))
               set infos
      in
         List.foldl getBVarsInfo set (TVMap.listItems ei)
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

   fun applySubstToExp (subst as (v, target)) (exp, ei) = let
      val eiRef = ref (ei : expand_info)
      fun aS (FUN (f1, f2)) = FUN (List.map aS f1, aS f2)
        | aS (SYN (syn, t)) = SYN (syn, aS t)
        | aS (ZENO) = ZENO
        | aS (FLOAT) = FLOAT
        | aS (STRING) = STRING
        | aS (UNIT) = UNIT
        | aS (VEC t) = VEC (aS t)
        | aS (CONST c) = CONST c
        | aS (ALG (ty, l)) = ALG (ty, List.map aS l)
        | aS (RECORD (var, b, fs)) =
         let
            val (fs, ei) = applySubstToRFields subst (fs, !eiRef)
         in
            if TVar.eq (var, v) then
              case addToExpandInfo (var, b, target, ei) of
                 (target,ei) => (eiRef := ei; case target of
                      WITH_FIELD (newFs, newVar, newBVar) =>
                       RECORD (newVar, newBVar, List.foldl insertField fs newFs)
                    | WITH_TYPE _ => raise SubstitutionBug
                 )
            else 
               (eiRef := ei; RECORD (var, b, fs))
         end
        | aS (MONAD (r,f,t)) = MONAD (aS r,aS f,aS t)
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

   (*any substitution that is being added must not mention any variable that
   already exists in the domain of the current set of substitutions; if this
   holds, the resulting substitutions remain fully applied*)
   fun addSubst subst (Substs l) =
      let
         fun doSubst (v2, WITH_TYPE t2) =
            let
               val (t2, ei) = applySubstToExp subst (t2, emptyExpandInfo)
            in
               occursCheck (v2, WITH_TYPE t2)
            end
           | doSubst (v2, WITH_FIELD (fs, v3, bv3)) =
            let
               val t2 = RECORD (v3,bv3,fs)
               val (t2,ei) = applySubstToExp subst (t2, emptyExpandInfo)
               val RECORD (v3,bv3,fs) = t2
            in
               occursCheck (v2, WITH_FIELD (fs, v3, bv3))
            end
         
         and occursCheck (v2, WITH_TYPE (t2 as (VAR _))) = (v2, WITH_TYPE t2)
            (* the previous case ensures that we don't get annoying error
            messages like a/a is an infinite substitution *)
           | occursCheck (v2, WITH_TYPE t2) =
            if TVar.member(texpVarset (t2, TVar.empty),v2) then
               let
                  val (vStr,si) = TVar.varToString (v2,TVar.emptyShowInfo)
                  val (tStr,si) = showTypeSI (t2,si)
               in
                  raise UnificationFailure ("infinite type " ^ vStr ^ " = " ^ tStr)
               end
            else (v2, WITH_TYPE t2)
           | occursCheck (v2, WITH_FIELD (fs, v3, bv3)) =
            if TVar.member(texpVarset (RECORD (v3,bv3,fs), TVar.empty),v2) then
               let
                  val (vStr,si) = TVar.varToString (v2,TVar.emptyShowInfo)
                  val (tStr,si) = showTypeSI (RECORD (v3,bv3,fs),si)
               in
                  raise UnificationFailure ("infinite record " ^ vStr ^ " = " ^ tStr)
               end
            else (v2, WITH_FIELD (fs, v3, bv3))

         (*val (v,repl) = subst
         val (vStr,si) = TVar.varToString (v,TVar.emptyShowInfo)
         val (tStr,si) = case repl of
              WITH_TYPE t2 => showTypeSI (t2,si)
            | WITH_FIELD (fs, v3, bv3) => showTypeSI (
                        RECORD (v3,bv3,fs),si)
         val (sStr,si) = showSubstsSI (Substs l, si)
         val _ = TextIO.print ("adding " ^ vStr ^ "/" ^ tStr ^ " to " ^ sStr ^ "\n")*)
                  
         val substIsIdentity = (case subst of
               (tv, WITH_TYPE (VAR (tv',_))) => TVar.eq (tv,tv')
             | (tv, WITH_FIELD (_,tv',_)) => TVar.eq (tv,tv')
             | _ => false
            )
      in
         if substIsIdentity then Substs l else
            Substs (occursCheck subst::List.map doSubst l)
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
                  (sCons,
                   List.foldl (fn ((v,c), substs) =>
                     addSubst (v,WITH_TYPE (CONST c)) substs
                     ) substs is)
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
         val repl = List.map (fn v => (v, TVar.freshTVar ()))
                        (TVar.listItems toReplace)
         val affectedSCons = SC.filter (toReplace, sCons)
         val newSCons = List.foldl
               (fn ((v1,v2),sCons) => SC.rename (v1,v2,sCons))
               affectedSCons repl
         val mergedSCons = SC.merge (newSCons, sCons)
         val tNew = replaceTVars (t, repl)
         val tNew = setFlagsToTop tNew
         val bvs1 = texpBVarset (fn ((_,v),vs) => v :: vs) (t, [])
         val bvs2 = texpBVarset (fn ((_,v),vs) => (false,v) :: vs) (tNew, [])
         val bFunNew = BD.expand (bvs1,bvs2,bFun)

         (*val (tStr, si) = showTypeSI (t, TVar.emptyShowInfo)
         val (tNewStr, si) = showTypeSI (tNew, si)
         val (sStr, si) = TVar.setToString (vs, si)
         val (vStr, si) = TVar.setToString (texpVarset (t, TVar.empty), si)
         val (suStr, si) = showSubstsSI (substs, si)
         val (scStr1,si) = SC.toStringSI (sCons, NONE, si)
         val (scStr2,si) = SC.toStringSI (mergedSCons, NONE, si)
         val _ = TextIO.print ("instantiating " ^ tStr ^ " using " ^ suStr ^ " to " ^ tNewStr ^ (*", extending " ^ scStr1 ^ " to " ^ scStr2 ^*) ", old bFun: " ^ BD.showBFun bFun ^ ", new bFun: " ^ BD.showBFun bFunNew ^ "\n")*)
      in
         (tNew, bFunNew, mergedSCons)
      end

   fun mgu (FUN (f1, f2), FUN (g1, g2), s) = if List.length f1<>List.length g1
      then raise UnificationFailure (
            "function with different number of arguments (" ^
            Int.toString (List.length f1) ^ " and " ^
            Int.toString (List.length g1) ^ ")"
         )
      else mgu (f2, g2, ListPair.foldlEq mgu s (f1,g1))
     | mgu (SYN (_, t1), t2, s) = mgu (t1, t2, s)
     | mgu (t1, SYN (_, t2), s) = mgu (t1, t2, s)
     | mgu (ZENO, ZENO, s) = s
     | mgu (FLOAT, FLOAT, s) = s
     | mgu (STRING, STRING, s) = s
     | mgu (UNIT, UNIT, s) = s
     | mgu (VEC t1, VEC t2, s) = mgu (t1, t2, s)
     | mgu (CONST c1, CONST c2, s) =
        if c1=c2 then s else raise UnificationFailure (
         "incompatible bit vectors sizes (" ^ Int.toString c1 ^ " and " ^
         Int.toString c2 ^ ")")
     | mgu (RECORD (v1,b1,l1), RECORD (v2,b2,l2), s) =
      let
         fun applySubsts (v, b, fs) = (case findSubstForVar (v, s) of
              NONE => (v,b,fs)
            | SOME (WITH_FIELD (fs',v',b')) => (v', b', List.foldl insertField fs fs')
            | _ => raise SubstitutionBug
         )
         val (v1,b1,l1) = applySubsts (v1,b1,l1)
         val (v2,b2,l2) = applySubsts (v2,b2,l2)

         fun unify (v1, v2, [], [], s) =
            addSubst (v2, WITH_FIELD ([], v1, b1)) s
           | unify (v1, v2, (f1 as RField e1) :: fs1,
                    (f2 as RField e2) :: fs2, s) =
            (case compare_rfield (f1,f2) of
               EQUAL =>
               let
                  val s = mgu (#fty e1, #fty e2, s)
                in
                  unify (v1, v2, fs1, fs2, s)
               end
             | LESS =>
               let
                  val newVar = freshTVar ()
                  val newBVar = BD.freshBVar ()
                  val (f1,ei) = applySubstsToRField s (f1,emptyExpandInfo)
                  val s = addSubst (v2, WITH_FIELD ([f1], newVar, newBVar)) s
               in
                  unify (v1, newVar, fs1, f2 :: fs2, s)
               end
             | GREATER =>
               let
                  val newVar = freshTVar ()
                  val newBVar = BD.freshBVar ()
                  val (f2,ei) = applySubstsToRField s (f2,emptyExpandInfo)
                  val s = addSubst (v1, WITH_FIELD ([f2], newVar, newBVar)) s
               in
                  unify (newVar, v2, f1 :: fs1, fs2, s)
               end
            )
           | unify (v1, v2, f1 :: fs1, [], s) =
            let
               val newVar = freshTVar ()
               val newBVar = BD.freshBVar ()
               val (f1,ei) = applySubstsToRField s (f1,emptyExpandInfo)
               val s = addSubst (v2, WITH_FIELD ([f1], newVar, newBVar)) s
            in
               unify (v1, newVar, fs1, [], s)
            end
           | unify (v1, v2, [], f2 :: fs2, s) =
            let
               val newVar = freshTVar ()
               val newBVar = BD.freshBVar ()
               val (f2,ei) = applySubstsToRField s (f2,emptyExpandInfo)
               val s = addSubst (v1, WITH_FIELD ([f2], newVar, newBVar)) s
            in
               unify (newVar, v2, [], fs2, s)
            end
      in
         unify (v1,v2,l1,l2,s)
      end
     | mgu (MONAD (r1,f1,t1), MONAD (r2,f2,t2), s) =
         mgu (r1, r2, mgu (f1, f2, mgu (t1, t2, s)))
     | mgu (ALG (ty1, l1), ALG (ty2, l2), s) =
      let 
         fun incompat () = raise UnificationFailure (
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
         (case findSubstForVar (v,s) of
              NONE => 
               let
                 val (e, ei) = applySubstsToExp s (e, emptyExpandInfo)
                 val s = addSubst (v,WITH_TYPE e) s
               in
                  s
               end
            | SOME (WITH_TYPE t) => mgu (e, t, s)
            | _ => raise SubstitutionBug
         )
     | mgu (VAR (v,b), e, s) =
         (case findSubstForVar (v,s) of
              NONE =>
               let
                 val (e, ei) = applySubstsToExp s (e, emptyExpandInfo)
                 val s = addSubst (v,WITH_TYPE e) s
               in
                  s
               end
            | SOME (WITH_TYPE t) => mgu (t, e, s)
            | _ => raise SubstitutionBug
         )
      | mgu (t1,t2,s) =
      let fun descr (FUN _) = "a function type"
            | descr (ZENO) = "int"
            | descr (FLOAT) = "float"
            | descr (STRING) = "string"
            | descr (UNIT) = "()"
            | descr (VEC (CONST c)) = "a vector of " ^ 
                                      Int.toString c ^ " bits"
            | descr (VEC _) = "a bit vector"
            | descr (ALG (ty, _)) = "type " ^
               SymbolTable.getString(!SymbolTables.typeTable, ty)
            | descr (RECORD (_,_,fs)) = "a record {" ^
               List.foldl (fn (RField {name = n, ...},str) =>
                  SymbolTable.getString(!SymbolTables.fieldTable, n) ^
                  ", " ^ str) "..." fs ^ "}"
            | descr (MONAD _) = "an action"
            | descr _ = "something that shouldn't be here"
      in
         raise UnificationFailure ("cannot match " ^ descr t1 ^
                                   " against " ^ descr t2)
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
