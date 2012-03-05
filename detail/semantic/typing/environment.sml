structure Environment : sig
   type environment

   datatype symbol_type =
        VALUE of {symType : Types.texp}
      | DECODE of {symType : Types.texp, width : Types.texp}

   val primitiveEnvironment : (SymbolTable.symid * Types.texp *
                               (Types.texp option)) list -> environment
   
   val pushSingle : VarInfo.symid * Types.texp * environment -> environment
   
   (*add a group of bindings to the current environment, each element in a
   binding is identified by its symbol, the flag is true if the symbol
   is a decoder function*)
   val pushGroup : (VarInfo.symid * bool) list * environment ->
                  environment
   val popGroup : environment -> 
                  (VarInfo.symid * symbol_type) list * environment
   val pushTop : environment -> environment
   
   (*pushes the given type onto the stack, if the flag is true, type variables
   are renamed*)
   val pushType : bool * Types.texp * environment -> environment


   (*given an occurrence of a symbol at a position, push its type onto the
   stack and return if an instance of this type must be used*)
   val pushSymbol : VarInfo.symid * Error.span * environment -> environment
   
   val getUsages : VarInfo.symid * environment -> Error.span list
   
   (*stack: [...,t] -> [...] and type of f for call-site s is set to t*)
   val popToUsage : VarInfo.symid * Error.span * environment -> environment

   (*stack: [...] -> [...,t] where t is type of usage of f at call-site s*)
   val pushUsage : VarInfo.symid * Error.span * environment -> environment
   
   (*stack: [...] -> [..., x:a], a fresh*)
   val pushLambdaVar' : VarInfo.symid * environment -> (Types.texp * environment)
   val pushLambdaVar : VarInfo.symid * environment -> environment
   
   (*stack: [..., t0, t1, ... tn] -> [..., {f1:t1, ... fn:tn, t0:...}]*)
   val reduceToRecord : (BooleanDomain.bvar * FieldInfo.symid) list *
                        environment -> environment

   (*stack: [...,t1,t2] -> [...,t1 -> t2]*)
   val reduceToFunction : environment -> environment
   
   (*stack: [...,t1 -> t2] -> [...t2]*)
   val reduceToResult : environment -> environment

   (*stack: [..., tn, ..., t2, t1, t0] -> [..., t0]*)
   val return : int * environment -> environment

   val popKappa : environment -> environment

   (*stack: [...,t] -> [...] and type of function f is set to t*)
   val popToFunction : VarInfo.symid * environment -> environment

   (*the type of function f is unset*)
   val clearFunction : VarInfo.symid * environment -> environment
  
   val meet : environment * environment -> environment

   val subseteq : environment * environment -> bool
   
   val toString : environment -> string
   val topToString : environment -> string
   val kappaToStringSI : environment * TVar.varmap -> string * TVar.varmap
   
end = struct
   structure ST = SymbolTable
   structure BD = BooleanDomain
   open Types
   open Substitutions

   (*any error that is not due to unification*)
   exception InferenceBug
   
   fun compare_span ((p1s,p1e), (p2s,p2e)) =
      (case Int.compare (Position.toInt p1s,
                         Position.toInt p2s) of
           EQUAL => Int.compare (Position.toInt p1e,
                                 Position.toInt p2e)
         | res => res)

   structure Uses = ListMapFn (struct
         type ord_key = Error.span
         val compare = compare_span
      end)           

   datatype bind_info
      = SIMPLE of { ty : texp }
      | COMPOUND of { ty : texp option, width : texp option,
                     uses : texp Uses.map }

   datatype binding
      = KAPPA of {
         ty : texp
      } | SINGLE of {
         name : ST.symid,
         ty : texp
      } | GROUP of {
         name : ST.symid,
         (*the type of this function, NONE if not yet known*)
         ty : texp option,
         (*this is SOME (CONST w) if this is a decode function with pattern width w*)
         width : texp option,
         uses : texp Uses.map
      } list
   
   datatype symbol_type =
        VALUE of {symType : Types.texp}
      | DECODE of {symType : Types.texp, width : Types.texp}

   (*a scope contains one of the bindings above and some additional
   information that make substitution and join cheaper*)
   structure Scope : sig
      type scope
      type environment = scope list * BD.bfun
      val initial : binding -> environment
      val wrap : (binding * environment) -> environment
      val unwrap : environment -> (binding * environment)
      val unwrapDifferent : environment * environment ->
            (binding * binding) option * environment * environment
      val hasVars : environment * TVar.set -> bool
      val lookup : ST.symid * environment -> TVar.set * bind_info
      val update : ST.symid  *
                   (bind_info * BD.bfun -> bind_info * BD.bfun) *
                   environment-> environment
      val toString : scope * TVar.varmap -> string * TVar.varmap
   end = struct
      type scope = {
         bindInfo : binding,
         typeVars : TVar.set,
         version : int
      }
      type environment = scope list * BD.bfun
   
      val verCounter = ref 1
      fun nextVersion () =  let
           val v = !verCounter
         in
           (verCounter := v+1; v)
         end             

      fun prevTVars [] = TVar.empty
        | prevTVars ({bindInfo, typeVars = tv, version}::_) = tv

      fun varsOfBinding (KAPPA {ty=t},set) = texpVarset (t,set)
        | varsOfBinding (SINGLE {name, ty=t},set) = texpVarset (t,set)
        | varsOfBinding (GROUP bs,set) = let
           fun vsOpt (SOME t,set) = texpVarset (t,set)
             | vsOpt (NONE,set) = set
           fun getUsesVars ((_,t),set) = texpVarset (t,set)
           fun getBindVars ({name, ty=t, width=w, uses},set) =
               List.foldl
                  texpVarset
                  (vsOpt (t, vsOpt (w,set)))
                  (Uses.listItems uses)
        in
           List.foldl getBindVars set bs
        end
      fun initial b =
         ([{
            bindInfo = b,
            typeVars = varsOfBinding (b,TVar.empty),
            version = 0
          }],BD.empty)
      fun wrap (b, (scs, bFun)) =
         ({
            bindInfo = b,
            typeVars = varsOfBinding (b,prevTVars scs),
            version = nextVersion ()
         }::scs,bFun)
      fun unwrap ({bindInfo = bi, typeVars, version} :: scs, bFun) =
            (bi, (scs, bFun))
        | unwrap ([], bFun) = raise InferenceBug
      fun unwrapDifferent
            ((all1 as ({bindInfo = bi1, typeVars = _, version = v1 : int}::scs1,
             bFun1))
            ,(all2 as ({bindInfo = bi2, typeVars = _, version = v2 : int}::scs2,
             bFun2))) =
            if v1=v2 then (NONE, all1, all2)
            else (SOME (bi1,bi2),(scs1,bFun1),(scs2,bFun2))
        | unwrapDifferent (all1 as ([], _), all2 as ([], _)) =
            (NONE, all1, all2)
        | unwrapDifferent (_, _) = raise InferenceBug
      
      fun hasVars (({bindInfo, typeVars = tv, version}::_,_),set) =
            not (TVar.isEmpty (TVar.intersection (tv, set)))
        | hasVars (([],_),_) = false

      fun lookup (sym, (scs, bFun)) =
         let
            fun getEnv ({bindInfo, typeVars = tv, version}::scs) = tv
              | getEnv [] = TVar.empty
            fun l [] = raise InferenceBug
              | l ({bindInfo = KAPPA _, typeVars, version}::scs) = l scs
              | l ({bindInfo = SINGLE {name, ty}, typeVars, version}::scs) =
                  if ST.eq_symid (sym,name) then
                     (getEnv scs, SIMPLE { ty = ty})
                  else l scs
              | l ({bindInfo = GROUP bs, typeVars, version}::scs) =
                  let fun lG [] = l scs
                        | lG ({name, ty, width, uses}::bs) =
                           if ST.eq_symid (sym,name) then
                              (getEnv scs,
                              COMPOUND { ty = ty, width = width, uses = uses })
                           else lG bs
                  in
                     lG bs
                  end
         in
            l scs
         end

      fun update (sym, action, env) =
         let
            fun tryUpdate (KAPPA _, bFun) = NONE
              | tryUpdate (SINGLE {name, ty}, bFun) =
                if ST.eq_symid (sym,name) then
                  let
                     val (SIMPLE {ty}, bFun) = action (SIMPLE {ty = ty}, bFun)
                  in
                     SOME (SINGLE {name = name, ty = ty}, bFun)
                  end
                else NONE
              | tryUpdate (GROUP bs, bFun) =
               let fun upd (otherBs, []) = NONE
                     | upd (otherBs, (b as {name, ty, width, uses})::bs) =
                        if ST.eq_symid (sym,name) then
                           let val (COMPOUND { ty = ty, width = width,
                                               uses = uses }, bFun) =
                                   action (COMPOUND { ty = ty, width = width,
                                                      uses = uses }, bFun)
                           in
                              SOME (GROUP (List.revAppend (otherBs,
                                          {name = name, ty = ty,
                                          width = width, uses = uses} :: bs))
                                   ,bFun)
                           end
                        else upd (b::otherBs, bs)
               in
                  upd ([],bs)
               end
            fun unravel (bs, env) = case unwrap env of
               (b, env as (scs, bFun)) =>
                  (case tryUpdate (b, bFun) of
                       NONE => unravel (b::bs, env)
                     | SOME (b,bFun) => List.foldl wrap (scs, bFun) (b::bs) )
         in
            unravel ([], env)
         end
      fun showVarsVer (typeVars,ver,si) =
         let
            val (vsStr, si) = TVar.setToString (typeVars,si)
         in
            (", ver=" ^ Int.toString(ver) ^ ", vars=" ^ vsStr, si)
         end

      fun toString ({bindInfo = KAPPA {ty}, typeVars, version}, si) =
            let
               val (scStr, si) = showVarsVer (typeVars, version, si)
               val (tStr, si) = showTypeSI (ty,si)
            in
               ("KAPPA : " ^ tStr ^ scStr, si)
            end
        | toString ({bindInfo = SINGLE {name, ty}, typeVars, version}, si) =
            let
               val (scStr, si) = showVarsVer (typeVars, version, si)
               val (tStr, si) = showTypeSI (ty,si)
            in
               (ST.getString(!SymbolTables.varTable, name) ^
                " : " ^ tStr ^ scStr, si)
            end
        | toString ({bindInfo = GROUP bs, typeVars, version}, si) =
            let
               val (scStr, si) = showVarsVer (typeVars, version, si)
               fun prTyOpt (NONE, str, si) = ("", si)
                 | prTyOpt (SOME t, str, si) = let
                    val (tStr, si) = showTypeSI (t, si)
                 in
                     (str ^ tStr, si)
                 end
               fun printU (((p1,p2), t), (str, sep, si)) =
                  let
                     val (tStr, si) = showTypeSI (t, si)
                  in
                     (str ^
                      sep ^ Int.toString(Position.toInt p1) ^
                      "-" ^ Int.toString(Position.toInt p2) ^
                      ":" ^ tStr
                     ,", ", si)
                  end
               fun printB ({name,ty,width,uses}, (str, si)) =
                  let
                     val (tStr, si) = prTyOpt (ty, " : ", si)
                     val (wStr, si) = prTyOpt (width, ", width = ", si)
                     val (uStr, _, si) = 
                           List.foldl printU ("", "\n    uses: ", si)
                                      (Uses.listItemsi uses)
                  in
                    (str ^
                     "\n  " ^ ST.getString(!SymbolTables.varTable, name) ^
                     tStr ^ wStr ^ uStr
                    ,si)
                  end
                val (bsStr, si) = List.foldr printB ("", si) bs
            in
               ("binding group" ^ scStr ^ bsStr, si)
            end
               
   end
   
   type environment = Scope.environment

   fun primitiveEnvironment l = Scope.initial
      (GROUP (List.map (fn (s,t,ow) => {name = s, ty = SOME t,
                                        width = ow, uses = Uses.empty}) l))
   
   fun pushSingle (sym, t, env) = Scope.wrap (SINGLE {name = sym, ty = t},env)
   

   structure SISet = RedBlackSetFn (
      struct
         type ord_key = SymbolTable.symid
         val compare = SymbolTable.compare_symid
      end)           
   fun pushGroup (syms, env) = 
      let
         val (funs, nonFuns) = List.partition (fn (s,dec) => not dec) syms
         val funDefs = List.map
            (fn (s,_) => {name = s, ty = NONE, width = NONE, uses = Uses.empty})
            funs
         val nonFunSyms =
            SISet.listItems (SISet.fromList (List.map (fn (s,_) => s) nonFuns))
         val nonFunDefs = List.map
            (fn s => {name = s, ty = NONE, width =
              SOME (VAR (TVar.freshTVar (), BD.freshBVar ())),
              uses = Uses.empty}) nonFunSyms
      in                                                                    
         Scope.wrap (GROUP (funDefs @ nonFunDefs), env)
      end                                    

   fun popGroup env = case Scope.unwrap env of
        (GROUP bs, env) =>
         (List.map (fn {name = n, ty = t, width = w, uses = _} =>
            case (t,w) of
                 (SOME t, NONE) => (n, VALUE {symType = t})
               | (SOME t, SOME w) => (n, DECODE {symType = t, width = w})
               | _ => raise InferenceBug
            ) bs, env)
      | _ => raise InferenceBug

   fun pushTop env = 
      let
         val a = TVar.freshTVar ()
         val b = BD.freshBVar ()
      in
         Scope.wrap (KAPPA {ty = VAR (a,b)}, env)
      end

   fun pushType (true, t, (scs, bFun)) =
      let
         val (t,bFun) = instantiateType (TVar.empty,t,bFun)
      in
         Scope.wrap (KAPPA {ty = t}, (scs, bFun))
      end
     | pushType (false, t, env) = Scope.wrap (KAPPA {ty = t}, env)

   exception LookupNeedsToAddUse

   fun eq_span ((p1s,p1e), (p2s,p2e)) =
      Position.toInt p1s=Position.toInt p2s andalso
      Position.toInt p1e=Position.toInt p2e

   fun toStringSI ((scs, bFun),si) = 
      let
         fun show (s, (str, si)) =
            let
               val (bStr, si) = Scope.toString (s, si)
            in
               (bStr ^ "\n" ^ str, si)
            end
      in
         List.foldr show ("", si) scs
      end

   fun toString env =
      let
         val (str, _) = toStringSI (env,TVar.emptyShowInfo)
      in
         str
      end
   
   fun topToString (s :: scs, bFun) = toString ([s], bFun)
     | topToString ([], bFun) = ""

   fun kappaToStringSI (env, si) = (case Scope.unwrap env of
        (KAPPA {ty = t}, _) => showTypeSI (t,si)
      | _ => raise InferenceBug
   )

   fun pushSymbol (sym, span, env) =
      (case Scope.lookup (sym,env) of
          (_, SIMPLE {ty = t}) => Scope.wrap (KAPPA {ty = t}, env)
        | (tvs, COMPOUND {ty = SOME t, width, uses}) =>
         let
            val (scs,bFun) = env
            val (t,bFun) = instantiateType (tvs, t, bFun)
         in
            Scope.wrap (KAPPA {ty = t}, (scs,bFun))
         end
        | (_, COMPOUND {ty = NONE, width, uses}) =>
          (case Uses.find (uses, span) of
               SOME t => Scope.wrap (KAPPA {ty = t}, env)
             | NONE =>
             let
                val res = VAR (TVar.freshTVar (),BD.freshBVar ())
                fun action (COMPOUND {ty, width, uses},bFun) =
                     (COMPOUND {ty = ty, width = width,
                      uses = Uses.insert (uses, span, res)}, bFun)
                  | action _ = raise InferenceBug
                val env = Scope.update (sym, action, env)
             in
                Scope.wrap (KAPPA {ty = res}, env)
             end
          )
      )

   fun getUsages (sym, env) = (case Scope.lookup (sym, env) of
           (_, SIMPLE {ty}) => []
         | (_, COMPOUND {ty, width, uses = us}) => Uses.listKeys us
         )

   fun pushUsage (sym, span, env) = (case Scope.lookup (sym, env) of
           (_, SIMPLE {ty}) => raise InferenceBug
         | (_, COMPOUND {ty, width, uses = us}) =>
            Scope.wrap (KAPPA {ty = Uses.lookup (us, span)}, env)
         )

   fun popToUsage (sym, span, env) = (case Scope.unwrap env of
        (KAPPA {ty = tUse}, env) =>
         let
            fun setUsage (COMPOUND {ty, width, uses = us}, bFun) =
                  (COMPOUND {ty = ty, width = width,
                             uses = Uses.insert (us,span,tUse)}, bFun)
              | setUsage _ = raise InferenceBug
         in
            Scope.update (sym, setUsage, env)
         end
     | _ => raise InferenceBug)

   fun pushLambdaVar' (sym, env) =
      let
         val t = VAR (TVar.freshTVar (), BD.freshBVar ())
      in
         (t, Scope.wrap (SINGLE {name = sym, ty = t}, env))
      end

   fun pushLambdaVar (sym, env) =
      let
         val t = VAR (TVar.freshTVar (), BD.freshBVar ())
      in
         Scope.wrap (SINGLE {name = sym, ty = t}, env)
      end

   fun reduceToRecord (bns, env) =
      let
         fun genFields (fs, [], env) = (case Scope.unwrap env of
                 (KAPPA {ty=VAR (tv,bv)}, env) =>
                  Scope.wrap (KAPPA {ty = RECORD (tv, bv, fs)}, env)
               | _ => raise InferenceBug
            )
           | genFields (fs, (bVar, fName) :: bns, env) =
               (case Scope.unwrap env of
                    (KAPPA {ty=t}, env) =>
                        genFields (insertField (
                           RField { name = fName, fty = t, exists = bVar},
                           fs), bns, env)
                  | _ => raise InferenceBug)
      in
         genFields ([], bns, env)
      end

   fun reduceToFunction env =
      let
         val (t2, env) = case Scope.unwrap env of
                             (KAPPA {ty = t}, env) => (t,env)
                           | (SINGLE {name, ty = t}, env) => (t,env)
                           | _ => raise InferenceBug
         val (t1, env) = case Scope.unwrap env of
                             (KAPPA {ty = t}, env) => (t,env)
                           | (SINGLE {name, ty = t}, env) => (t,env)
                           | _ => raise InferenceBug
      in
         Scope.wrap (KAPPA {ty = FUN (t1,t2)}, env)
      end

   fun reduceToResult env = case Scope.unwrap env of
           (KAPPA {ty = FUN (t1,t2)}, env) =>
            Scope.wrap (KAPPA {ty = t2}, env)
         | _ => raise InferenceBug

   fun applySubsts (substs, (scs, bFun)) =
      let
         val sVars = substsDom substs
         fun substBinding (KAPPA {ty=t}, ei) =
            (case applySubstsToExp substs (t,ei) of (t,ei) =>
               (checkFieldRecursion t; (KAPPA {ty = t}, ei)))
           | substBinding (SINGLE {name = n, ty = t}, ei) =
            (case applySubstsToExp substs (t,ei) of (t,ei) =>
               (checkFieldRecursion t; (SINGLE {name = n, ty = t}, ei)))
           | substBinding (GROUP bs, ei) =
               let
                  val eiRef = ref ei
                  fun optSubst (SOME t) =
                     (case applySubstsToExp substs (t,!eiRef) of (t,ei) =>
                        (checkFieldRecursion t; eiRef := ei; SOME t))
                    | optSubst NONE = NONE
                  fun usesSubst t =
                     (case applySubstsToExp substs (t,!eiRef) of (t,ei) =>
                        (checkFieldRecursion t; eiRef := ei; t))
                  fun substB {name = n, ty = t, width = w, uses = us} =
                     {name = n, ty = optSubst t, width = optSubst w,
                      uses = Uses.map usesSubst us}
               in
                  (GROUP (List.map substB bs), !eiRef)
               end
         fun doSubst (scs, ei) =
            if Scope.hasVars ((scs, BD.empty),sVars) then
               let
                  val (b, (scs,_)) = Scope.unwrap (scs, BD.empty)
                  val (b, ei) = substBinding (b, ei)
               in
                  Scope.wrap (b, doSubst (scs, ei))
               end
            else (scs, finalizeExpandInfo ei)
      in
         doSubst (scs, createExpandInfo bFun)
      end

   fun reduceUnify env = 
      let
         val (t2, env) = case Scope.unwrap env of
                             (KAPPA {ty = t}, env) => (t,env)
                           | (SINGLE {name, ty = t}, env) => (t,env)
                           | _ => raise InferenceBug
         val (t1, env) = case Scope.unwrap env of
                             (KAPPA {ty = t}, env) => (t,env)
                           | (SINGLE {name, ty = t}, env) => (t,env)
                           | _ => raise InferenceBug
         val substs = mgu(t1,t2,emptySubsts)
      in
         applySubsts(substs, env)
      end

   fun return (n,env) =
      let
         val (t, env) = Scope.unwrap env
         fun popN (n,env) = if n<=0 then env else
            let
               val (_, env) = Scope.unwrap env
            in
               popN (n-1, env)
            end
      in
         Scope.wrap (t, popN (n,env))
      end
      

   fun popKappa env = case Scope.unwrap env of
        (KAPPA {ty}, env) => env
      | _ => raise InferenceBug

   fun popToFunction (sym, env) =
      let
         fun setType t (COMPOUND {ty = NONE, width, uses}, bFun) =
               (COMPOUND {ty = SOME t, width = width, uses = uses}, bFun)
           | setType t _ = raise InferenceBug
      in
         case Scope.unwrap env of
              (KAPPA {ty=t}, env) => Scope.update (sym, setType t, env)
            | _ => raise InferenceBug
      end

   fun clearFunction (sym, env) =
      let
         fun resetType (COMPOUND {ty = SOME _, width, uses}, bFun) =
               (COMPOUND {ty = NONE, width = width, uses = uses}, bFun)
           | resetType _ = raise InferenceBug
      in
         Scope.update (sym, resetType, env)
      end

   fun unify (env1, env2, substs) =
      (case Scope.unwrapDifferent (env1, env2) of
           (SOME (KAPPA {ty = ty1}, KAPPA {ty = ty2}), env1, env2) =>
               unify (env1, env2, mgu(ty1, ty2, substs))
         | (SOME (SINGLE {name = _, ty = ty1},
                  SINGLE {name = _, ty = ty2}), env1, env2) =>
               unify (env1, env2, mgu(ty1, ty2, substs))
         | (SOME (GROUP bs1, GROUP bs2), env1, env2) =>
            let
               fun mguOpt (SOME t1, SOME t2, s) = mgu (t1, t2, s)
                 | mguOpt (NONE, NONE, s) = s
                 | mguOpt (_, _, _) = raise InferenceBug
               fun mguUses ((s1,t1) :: us1, (s2,t2) :: us2, s) =
                  (case compare_span (s1,s2) of
                       EQUAL => mguUses (us1, us2, mgu (t1,t2,s))
                     | LESS => mguUses (us1, (s2,t2) :: us2, s)
                     | GREATER => mguUses ((s1,t1) :: us1, us2, s)
                  )
                  | mguUses (_, _, s) = s
               fun uB (({name = n1, ty = t1, width = w1, uses = u1},
                        {name = n2, ty = t2, width = w2, uses = u2}), s) =
                  if not (ST.eq_symid (n1,n2)) then raise InferenceBug else
                  mguUses (Uses.listItemsi u1, Uses.listItemsi u2,
                           mguOpt (t1, t2, mguOpt (w1, w2, s)))
               (*val _ = if List.length bs1=List.length bs2 then () else
                     TextIO.print ("*************** mgu of\n" ^ topToString (Scope.wrap (GROUP bs1,env1)) ^ "\ndoes not match\n" ^ topToString (Scope.wrap (GROUP bs2,env2)))*)
               val substs = List.foldl uB substs (ListPair.zipEq (bs1,bs2))
            in
               unify (env1, env2, substs)
            end      
         | (NONE, env1, env2) => substs
         | (SOME _, _, _) => raise InferenceBug
      )

   fun mergeUses (env1,env2) =
      (case Scope.unwrapDifferent (env1, env2) of
           (SOME (KAPPA {ty = t1}, KAPPA {ty = t2}), env1, env2) =>
               Scope.wrap (KAPPA {ty = t1}, mergeUses (env1, env2))
         | (SOME (SINGLE {name = n1, ty = t1},
                  SINGLE {name = _, ty = _}), env1, env2) =>
               Scope.wrap (SINGLE {name = n1, ty = t1}, mergeUses (env1, env2))
         | (SOME (GROUP bs1, GROUP bs2), env1, env2) =>
            let
               fun mergeOpt (SOME t1, SOME t2) = SOME t1
                 | mergeOpt (NONE, NONE) = NONE
                 | mergeOpt (_, _) = raise InferenceBug
               fun mB ({name = n1, ty = t1, width = w1, uses = u1},
                       {name = n2, ty = t2, width = w2, uses = u2}) =
                  if not (ST.eq_symid (n1,n2)) then raise InferenceBug else
                  {name = n1, ty = mergeOpt (t1,t2), width = mergeOpt (w1,w2),
                   uses = Uses.unionWith (fn (x,y) => x) (u1,u2) }
               (*val _ = if List.length u1=List.length u2 then () else
                     TextIO.print ("*************** mergeUses of\n" ^ topToString (Scope.wrap (GROUP bs1,env1)) ^ "\ndoes not match\n" ^ topToString (Scope.wrap (GROUP bs2,env2)))*)
               val bs = List.map mB (ListPair.zipEq (bs1,bs2))
            in
               Scope.wrap (GROUP bs, mergeUses (env1,env2))
            end      
         | (NONE, env1, env2) => env1
         | (SOME _, _, _) => raise InferenceBug
      )
   
   fun meet (env1, env2) =
      let
         (*val _ = TextIO.print ("unifying " ^ toString(env1) ^ " and " ^ toString(env2) ^ "\n")*)
         val substs = unify (env1, env2, emptySubsts)
               handle ListPair.UnequalLengths =>
                 (TextIO.print ("+++++ bad: unifying\n" ^ toString(env1) ^ "+++++ and\n" ^ toString(env2) ^ "\n"); raise InferenceBug)
         val env = mergeUses (env1, env2)
         (*val _ = TextIO.print ("***** after adjusting uses:\n" ^ toString(env) ^ "\n")*)
         (*val (eStr,si) = toStringSI (env2, TVar.emptyShowInfo)
         val (sStr,_) = showSubstsSI (substs,si)
         val _ = TextIO.print ("applying substitution " ^ sStr ^ " to\n" ^ eStr)*)
      in
         applySubsts (substs, env)
      end

   fun subseteq (env1, env2) =
      let
         val substs = unify (env1, env2, emptySubsts)
         val vs = substsDom substs
         val si = TVar.emptyShowInfo
         val (e1Str, si) = toStringSI (env1, si)
         val (e2Str, si) = toStringSI (env2, si)
         val (sStr, si) = showSubstsSI (substs, si)
         val _ = TextIO.print ("+++++ substitution " ^ sStr ^ " indicates " ^
                  (if Scope.hasVars (env1, vs) then "not" else "") ^
                  " stable in env1:\n" ^ e1Str ^ "and env2:\n" ^ e2Str)
      in
         not (Scope.hasVars (env1, vs))
      end

end