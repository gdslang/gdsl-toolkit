structure Environment : sig
   type environment

   structure SpanMap : ORD_MAP where type Key.ord_key = Error.span

   structure SymbolSet : ORD_SET where type Key.ord_key = SymbolTable.symid
   
   datatype symbol_type =
        VALUE of {symType : Types.texp, symFlow : BooleanDomain.bfun}
      | DECODE of {symType : Types.texp, symFlow : BooleanDomain.bfun,
                   width : Types.texp}

   val primitiveEnvironment : (SymbolTable.symid *
                               Types.texp *
                               (BooleanDomain.bfun -> BooleanDomain.bfun) *
                               (Types.texp option)) list *
                               SizeConstraint.size_constraint list ->
                               environment
   
   val pushSingle : VarInfo.symid * Types.texp * environment -> environment
   
   (*add a group of bindings to the current environment, each element in a
   binding is identified by its symbol, the flag is true if the symbol
   is a decoder function*)
   val pushGroup : (VarInfo.symid * bool) list * environment ->
                  environment
   (*remove a binding group from the stack; the flag is true if the outermost
   scope should be kept, the result is a list of error messages about
   ambiguous type variables and a list with types of the symbols in this
   group*)
   val popGroup : environment * bool ->
                  (Error.span * string) list * environment
   val pushTop : environment -> environment
   
   (*pushes the given type onto the stack, if the flag is true, type variables
   are renamed*)
   val pushType : bool * Types.texp * environment -> environment

   val pushMonadType : Types.texp * environment -> environment
   
   (* push the width of a decode onto the stack*)
   val pushWidth : VarInfo.symid * environment -> environment

   (*given an occurrence of a symbol at a position, push its type onto the
   stack and return if an instance of this type must be used; arguments are
   the symbol to look up, the position it occurred and a list of symbols that
   denote the current context/function (the latter is ignored if the symbol
   already has a type) *)
   val pushSymbol : VarInfo.symid * Error.span * VarInfo.symid list *
                    environment -> environment

   val getUsages : VarInfo.symid * environment -> Error.span list
   
   (*stack: [...,t] -> [...] and type of f for call-site s is set to t*)
   val popToUsage : VarInfo.symid * Error.span * environment -> environment

   (*stack: [...] -> [...,t] where t is type of usage of f at call-site s*)
   val pushUsage : VarInfo.symid * Error.span *
                   (VarInfo.symid * symbol_type) list * environment -> environment
   
   (*stack: [...] -> [..., x:a], 'a' fresh; primed version also returns 'a'*)
   val pushLambdaVar' : VarInfo.symid * environment -> (Types.texp * environment)
   val pushLambdaVar : VarInfo.symid * environment -> environment
   
   (*stack: [..., t0, t1, ... tn] -> [..., {f1:t1, ... fn:tn, t0:...}]*)
   val reduceToRecord : (BooleanDomain.bvar * FieldInfo.symid) list *
                        environment -> environment

   (*stack: [..., tn, ..., t2, t1, t0] -> [..., SUM (tn,..t0)]*)
   val reduceToSum : int * environment -> environment
   
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
   
   (*push a function type if it is set, otherwise push top*)
   val pushFunctionOrTop : VarInfo.symid * environment -> environment
   
   (*apply the Boolean function*)
   val meetBoolean : (BooleanDomain.bfun -> BooleanDomain.bfun) *
                     environment -> environment

   val meetSizeConstraint : (SizeConstraint.size_constraint_set ->
                             SizeConstraint.size_constraint_set) *
                             environment -> environment

   val meetFlow : environment * environment -> environment
   val meet : environment * environment -> environment

   (*returns the set of substitutions for the first environment, this is empty
   if the the first environment is more specific (smaller) than the second*)
   val subseteq : environment * environment -> Substitutions.Substs

   (*query all function symbols in binding groups that would be modified by
   the given substitutions*)
   val affectedFunctions : Substitutions.Substs * environment -> SymbolSet.set

   val getFunctionInfo : VarInfo.symid * environment -> symbol_type

   val toString : environment -> string
   val toStringSI : environment * TVar.varmap -> string * TVar.varmap
   val topToString : environment -> string
   val topToStringSI : environment * TVar.varmap -> string * TVar.varmap
   val kappaToStringSI : environment * TVar.varmap -> string * TVar.varmap
   val funTypeToStringSI  : environment * VarInfo.symid * TVar.varmap ->
                            string * TVar.varmap
end = struct
   structure ST = SymbolTable
   structure BD = BooleanDomain
   structure SC = SizeConstraint
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

   structure SpanMap = ListMapFn (struct
         type ord_key = Error.span
         val compare = compare_span
      end)           

   datatype bind_info
      = SIMPLE of { ty : texp }
      | COMPOUND of { ty : (texp * BD.bfun) option, width : texp option,
                     uses : (ST.symid list * texp) SpanMap.map }

   datatype binding
      = KAPPA of {
         ty : texp
      } | SINGLE of {
         name : ST.symid,
         ty : texp
      } | GROUP of {
         name : ST.symid,
         (*the type of this function, NONE if not yet known*)
         ty : (texp * BD.bfun) option,
         (*this is SOME (CONST w) if this is a decode function with pattern width w*)
         width : texp option,
         uses : (ST.symid list * texp) SpanMap.map
      } list
   
   datatype symbol_type =
        VALUE of {symType : Types.texp, symFlow : BooleanDomain.bfun}
      | DECODE of {symType : Types.texp, symFlow : BooleanDomain.bfun,
                   width : Types.texp}

   (*a scope contains one of the bindings above and some additional
   information that make substitution and join cheaper*)
   structure Scope : sig
      type scope
      type constraints = BD.bfun * SC.size_constraint_set
      type environment = scope list * constraints ref
      val initial : binding * SC.size_constraint_set -> environment
      val wrap : binding * environment -> environment
      val unwrap : environment -> (binding * environment)
      val unwrapDifferent : environment * environment ->
            (binding * binding) option * environment * environment
      val getVars : environment -> TVar.set
      val getBVarsUses : ST.symid * BD.bvarset * environment -> BD.bvarset
      val getMonoBVars : environment -> BD.bvarset
      val lookup : ST.symid * environment -> TVar.set * bind_info
      val update : ST.symid  *
                   (bind_info * constraints ref -> bind_info * constraints ref) *
                   environment-> environment
      val toString : scope * TVar.varmap -> string * TVar.varmap
   end = struct
      type scope = {
         bindInfo : binding,
         typeVars : TVar.set,
         version : int
      }
      type constraints = BD.bfun * SC.size_constraint_set
      type environment = scope list * constraints ref
   
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
           fun bvsOpt (SOME (t,_),set) = texpVarset (t,set)
             | bvsOpt (NONE,set) = set
           fun getUsesVars ((_,t),set) = texpVarset (t,set)
           fun getBindVars ({name, ty=t, width=w, uses},set) =
               List.foldl
                  getUsesVars
                  (bvsOpt (t, vsOpt (w,set)))
                  (SpanMap.listItems uses)
        in
           List.foldl getBindVars set bs
        end
      
      fun initial (b, scs) =
         ([{
            bindInfo = b,
            typeVars = varsOfBinding (b,TVar.empty),
            version = 0
          }],ref (BD.empty, scs))
      fun wrap (b, (scs, consRef)) =
         ({
            bindInfo = b,
            typeVars = varsOfBinding (b,prevTVars scs),
            version = nextVersion ()
         }::scs,consRef)
      fun unwrap ({bindInfo = bi, typeVars, version} :: scs, consRef) =
            (bi, (scs, consRef))
        | unwrap ([], consRef) = raise InferenceBug
      fun unwrapDifferent
            ((all1 as ({bindInfo = bi1, typeVars = _, version = v1 : int}::scs1,
             consRef1))
            ,(all2 as ({bindInfo = bi2, typeVars = _, version = v2 : int}::scs2,
             consRef2))) =
            if v1=v2 then (NONE, all1, all2)
            else (SOME (bi1,bi2),(scs1,consRef1),(scs2,consRef2))
        | unwrapDifferent (all1 as ([], _), all2 as ([], _)) =
            (NONE, all1, all2)
        | unwrapDifferent (_, _) = raise InferenceBug
      
      fun getVars ({bindInfo, typeVars = tv, version}::_,_) = tv
        | getVars ([],_) = TVar.empty

      fun getBVarsUses (sym, vs, (scs,_)) =
         let
            fun getUsesVars ((ctxt,t),set) =
               if List.exists (fn x => ST.eq_symid (sym,x)) ctxt then
                  texpBVarset (fn ((_,v),vs) => BD.addToSet (v,vs)) (t,set)
               else
                  set
            fun getBindVars ({name, ty, width, uses},set) =
               List.foldl getUsesVars set (SpanMap.listItems uses)
            fun getGroupVars ({bindInfo = bi, typeVars, version},set) =
               case bi of
                    KAPPA {ty} => set
                  | SINGLE {name, ty} => set
                  | GROUP bs => List.foldl getBindVars set bs
         in
            List.foldl getGroupVars vs scs
         end

      fun getMonoBVars (bis,_) = List.foldl
        (fn ({bindInfo = bi, typeVars, version},set) => 
         case bi of
              KAPPA { ty = t } =>
               texpBVarset (fn ((_,v),vs) => BD.addToSet (v,vs)) (t,set)
            | SINGLE { ty = t,... } =>
               texpBVarset (fn ((_,v),vs) => BD.addToSet (v,vs)) (t,set)
            | GROUP _ => set)
        BD.emptySet bis

      fun lookup (sym, (scs, consRef)) =
         let
            fun getEnv ({bindInfo, typeVars = tv, version}::_) = tv
              | getEnv [] = TVar.empty
            fun l [] = (TextIO.print ("urk, tried to lookup non-exitent symbol " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ "\n")
                       ;raise InferenceBug)
              | l ({bindInfo = KAPPA _, typeVars, version}::scs) = l scs
              | l ({bindInfo = SINGLE {name, ty}, typeVars, version}::scs) =
                  if ST.eq_symid (sym,name) then
                     (getEnv scs, SIMPLE { ty = ty})
                  else l scs
              | l ({bindInfo = GROUP bs, typeVars, version}::scs) =
                  let fun lG other [] = l scs
                        | lG other ((b as {name, ty, width, uses})::bs) =
                           if ST.eq_symid (sym,name) then
                              (varsOfBinding (GROUP (other @ bs), getEnv scs),
                              COMPOUND { ty = ty, width = width, uses = uses })
                           else lG (b :: other) bs
                  in
                     lG [] bs
                  end
         in
            l scs
         end

      fun update (sym, action, env) =
         let
            fun tryUpdate (KAPPA _, consRef) = NONE
              | tryUpdate (SINGLE {name, ty}, consRef) =
                if ST.eq_symid (sym,name) then
                  let
                     val (SIMPLE {ty}, consRef) = action (SIMPLE {ty = ty}, consRef)
                  in
                     SOME (SINGLE {name = name, ty = ty}, consRef)
                  end
                else NONE
              | tryUpdate (GROUP bs, consRef) =
               let fun upd (otherBs, []) = NONE
                     | upd (otherBs, (b as {name, ty, width, uses})::bs) =
                        if ST.eq_symid (sym,name) then
                           let val (COMPOUND { ty = ty, width = width,
                                               uses = uses }, consRef) =
                                   action (COMPOUND { ty = ty, width = width,
                                                      uses = uses }, consRef)
                           in
                              SOME (GROUP (List.revAppend (otherBs,
                                          {name = name, ty = ty,
                                          width = width, uses = uses} :: bs))
                                   ,consRef)
                           end
                        else upd (b::otherBs, bs)
               in
                  upd ([],bs)
               end
            fun unravel (bs, env) = case unwrap env of
               (b, env as (scs, consRef)) =>
                  (case tryUpdate (b, consRef) of
                       NONE => unravel (b::bs, env)
                     | SOME (b,consRef) => List.foldl wrap (scs, consRef) (b::bs) )
         in
            unravel ([], env)
         end
      fun showVarsVer (typeVars,ver,si) =
         let
            val (vsStr, si) = TVar.setToString (typeVars,si)
         in
            (", ver=" ^ Int.toString(ver) (*^ ", vars=" ^ vsStr*), si)
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
               ("SYMBOL " ^ ST.getString(!SymbolTables.varTable, name) ^
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
               fun prBTyOpt (NONE, str, si) = ("", si)
                 | prBTyOpt (SOME (t,bFun), str, si) = let
                    val (tStr, si) = showTypeSI (t, si)
                 in
                     (str ^ tStr ^ ", flow:" ^ BD.showBFun bFun, si)
                 end
               fun printU (((p1,p2), (ctxt, t)), (str, sep, si)) =
                  let
                     val (tStr, si) = showTypeSI (t, si)
                     fun showSym (s,(sep,str)) = (",", str ^ sep ^
                           ST.getString(!SymbolTables.varTable, s))
                  in
                     (str ^
                      sep ^ Int.toString(Position.toInt p1) ^
                      "-" ^ Int.toString(Position.toInt p2) ^
                      "@" ^ #2 (List.foldl showSym ("","") ctxt) ^
                      ":" ^ tStr
                     ,", ", si)
                  end
               fun printB ({name,ty,width,uses}, (str, si)) =
                  let
                     val (tStr, si) = prBTyOpt (ty, " : ", si)
                     val (wStr, si) = prTyOpt (width, ", width = ", si)
                     val (uStr, _, si) = 
                           List.foldl printU ("", "\n  uses: ", si)
                                      (SpanMap.listItemsi uses)
                  in
                    (str ^
                     "\n  " ^ ST.getString(!SymbolTables.varTable, name) ^
                     tStr ^ wStr ^ uStr
                    ,si)
                  end
                val (bsStr, si) = List.foldr printB ("", si) bs
            in
               ("GROUP" ^ scStr ^ bsStr, si)
            end
               
   end
   
   type environment = Scope.environment

   fun primitiveEnvironment (l,scs) = Scope.initial
      (GROUP (List.map (fn (s,t,bFunGen,ow) =>
         {name = s, ty = SOME (t,bFunGen BD.empty),
          width = ow, uses = SpanMap.empty}) l),
       scs)
   
   fun pushSingle (sym, t, env) = Scope.wrap (SINGLE {name = sym, ty = t},env)
   
   structure SymbolSet = RedBlackSetFn (
      struct
         type ord_key = SymbolTable.symid
         val compare = SymbolTable.compare_symid
      end)
          
   fun pushGroup (syms, env) = 
      let
         val (funs, nonFuns) = List.partition (fn (s,dec) => not dec) syms
         val funDefs = List.map
            (fn (s,_) => {name = s, ty = NONE, width = NONE, uses = SpanMap.empty})
            funs
         val nonFunSyms =
            SymbolSet.listItems (SymbolSet.fromList (List.map (fn (s,_) => s) nonFuns))
         val nonFunDefs = List.map
            (fn s => {name = s, ty = NONE, width =
              SOME (VAR (TVar.freshTVar (), BD.freshBVar ())),
              uses = SpanMap.empty}) nonFunSyms
      in                                                                    
         Scope.wrap (GROUP (funDefs @ nonFunDefs), env)
      end                                    

   fun popGroup (env, true) = (case Scope.unwrap env of
        (KAPPA {ty=t}, env) =>
         let
           val (badUses, env) = popGroup (env, false)
         in
            (badUses, Scope.wrap (KAPPA {ty=t}, env))
         end
       | _ => raise InferenceBug)
     | popGroup (env, false) = case Scope.unwrap env of
        (GROUP bs, env) =>
         let
            val remVars = Scope.getVars env
            val (_, consRef) = env
            val (bFun, sCons) = !consRef
            (*figure out if there are any function usages that have unresolved
            type variables that relate to sizes*)
            val curVars = SC.getVarset sCons
            val unbounded = TVar.difference (curVars,remVars)
            (*val _ = TextIO.print ("unbounded vars: " ^ #1 (TVar.setToString (unbounded,TVar.emptyShowInfo)) ^ "\n")*)
            val siRef = ref TVar.emptyShowInfo
            fun showUse (n, (ctxt,t)) =
               let
                  val nStr = SymbolTable.getString(!SymbolTables.varTable, n)
                  val (tStr, si) = showTypeSI (t, !siRef)
                  val vs = texpVarset (t,TVar.empty)
                  val (cStr, si) = SC.toStringSI (sCons, SOME vs, si)
               in
                  (siRef := si
                  ; nStr ^ " : " ^ tStr ^ " has ambiguous vector sizes" ^
                     (if String.size cStr=0 then "" else " where " ^ cStr))
               end
            val unbounded = List.foldl (fn
                  ({name,ty=SOME (t,_),width,uses},vs) =>
                     TVar.difference (vs, texpVarset (t,TVar.empty))
                  | _ => raise InferenceBug)
                  unbounded bs
            val badSizes = List.concat (
               List.map (fn {name = n,ty,width,uses = us} =>
                  List.map (fn (sp,t) => (sp, showUse (n, t))) (
                     SpanMap.listItemsi (
                        SpanMap.filter (fn (_,t) =>
                           not (TVar.isEmpty (TVar.intersection
                              (texpVarset (t,TVar.empty), unbounded)))
                           ) us))) bs)
            (*project out variables from the size and Boolean domains that are
            no longer needed*)
            val sCons = SC.filter (remVars, sCons)
            val _ = consRef := (bFun, sCons)
         in
            (badSizes, env)
         end
      | _ => raise InferenceBug

   fun pushTop env = 
      let
         val a = TVar.freshTVar ()
         val b = BD.freshBVar ()
      in
         Scope.wrap (KAPPA {ty = VAR (a,b)}, env)
      end

   fun pushType (true, t, (scs, consRef)) =
      let
         val (bFun, sCons) = !consRef
         val (t,bFun,sCons) =
            instantiateType (TVar.empty,t,TVar.empty,bFun,sCons)
      in
         (consRef := (bFun,sCons); Scope.wrap (KAPPA {ty = t}, (scs, consRef)))
      end
     | pushType (false, t, env) = Scope.wrap (KAPPA {ty = t}, env)

   fun pushMonadType (t, (scs, consRef)) =
      let
         val (bFun, sCons) = !consRef
         val tvar = TVar.freshTVar ()
         val fromBVar = BD.freshBVar ()
         val toBVar = BD.freshBVar ()
         val fromVar = VAR (tvar, fromBVar)
         val toVar = VAR (tvar, toBVar)
         val bFun = BD.meetVarImpliesVar (fromBVar, toBVar) bFun
         val (t,bFun,sCons) =
            instantiateType (texpVarset(t,TVar.empty),t,TVar.empty,bFun,sCons)
         val _ = consRef := (bFun,sCons)
      in
         Scope.wrap (KAPPA {ty = MONAD (t, fromVar, toVar)}, (scs, consRef))
      end

   fun pushWidth (sym, env) =
      (case Scope.lookup (sym,env) of
          (_, COMPOUND {ty, width = SOME t, uses}) =>
            Scope.wrap (KAPPA {ty = t}, env)
        | _ => raise (UnificationFailure (
            SymbolTable.getString(!SymbolTables.varTable, sym) ^
            " is not a decoder"))
      )

   exception LookupNeedsToAddUse

   fun eq_span ((p1s,p1e), (p2s,p2e)) =
      Position.toInt p1s=Position.toInt p2s andalso
      Position.toInt p1e=Position.toInt p2e

   fun toStringSI ((scs, consRef),si) = 
      let
         val (bFun, sCons) = !consRef
         fun showCons (s, (str, si)) =
            let
               val (bStr, si) = Scope.toString (s, si)
            in
               (bStr ^ "\n" ^ str, si)
            end
         val (sStr, si) = SC.toStringSI (sCons, NONE, si)
         val (envConsStr, si) =
            List.foldr showCons ("sizes: " ^ sStr ^ "\n", si) scs
      in
         (envConsStr ^ BD.showBFun bFun ^ "\n", si)
      end

   fun toString env =
      let
         val (str, _) = toStringSI (env,TVar.emptyShowInfo)
      in
         str
      end
   
   fun topToStringSI (env, si) =
      let
         fun tts acc (sc :: scs, consRef) =
            (case Scope.unwrap (sc :: scs, consRef) of
                 (GROUP _, (_, consRef)) => toStringSI ((acc @ [sc], consRef), si)
               | (_, env) => tts (acc @ [sc]) env) 
           | tts acc ([], consRef) = toStringSI ((acc, consRef), si)
      in
         tts [] env
      end

   fun topToString env =
      let
         val (str, _) = topToStringSI (env,TVar.emptyShowInfo)
      in
         str
      end

   fun kappaToStringSI (env, si) = (case Scope.unwrap env of
        (KAPPA {ty = t}, _) =>
         let
            val (tStr, si) = showTypeSI (t,si)
         in
            (tStr ^ "\n", si)
         end
      | _ => raise InferenceBug
   )

   fun funTypeToStringSI (env, f, si) = (case Scope.lookup (f,env) of
        (_, COMPOUND { ty = SOME (t,_), width, uses }) => showTypeSI (t,si)
      | _ => raise InferenceBug
   )

   fun reduceBooleanFormula (sym,t,setType,reduceToMono,env) =
      let
         (*we need to restrict the size of the Boolean formula in two
         ways: first, for the function we need all Boolean variables
         in its type, all lambda- and kappa-bound types in the
         environment as well as all the uses of other functions that
         occur in it; secondly, the analysis must continue with a
         Boolean formula that contians the Boolean variables of all
         lambda- and kappa-bound types in the environment. Since the
         latter is usually an empty environment (namely for all
         top-level functions), we first calculate the set of Boolean
         variables in kappa- and lambda-bound types and use that for
         the Boolean formula of the function; then we project onto
         the variables in kappa- and lambda-bound types*)
         val monoBVars = Scope.getMonoBVars env
         val funBVars = Scope.getBVarsUses (sym, monoBVars, env)
         val funBVars = texpBVarset (fn ((_,v),vs) => BD.addToSet (v,vs)) (t, funBVars)
         val (_, consRef) = env
         val (bFunOrig, sCons) = !consRef
         val bFun = BD.projectOnto (funBVars,bFunOrig)
         val env = Scope.update (sym, setType (t,bFun), env)
         val bFun = if reduceToMono then BD.projectOnto (monoBVars,bFun)
                    else bFunOrig
         val _ = consRef := (bFun, sCons)
         (*val _ = TextIO.print ("*** popToFunction " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ ", containing bVars " ^ BD.setToString funBVars ^ ", mono bVars " ^ BD.setToString monoBVars ^ ":\nbefore " ^ BD.showBFun bFunOrig ^ "\nafter " ^ BD.showBFun bFun ^ "\nenvironment:\n" ^ topToString env)*)
      in
         env
      end

   fun affectedFunctions (substs, env) =
      let
         fun aF (ss, substs, ([], _)) = ss
           | aF (ss, substs, env) = if isEmpty substs then ss else
             case Scope.unwrap env of
              (KAPPA {ty}, env) =>
              aF (ss, substsFilter (substs, Scope.getVars env), env)
            | (SINGLE {name = n, ty = t}, env) =>
              aF (ss, substsFilter (substs, Scope.getVars env), env)
            | (GROUP l, env) =>
            let
               fun aFL (ss, []) =
                   aF (ss, substsFilter (substs, Scope.getVars env), env)
                 | aFL (ss, {name, ty = NONE, width, uses} :: l) = aFL (ss, l)
                 | aFL (ss, {name = n, ty = SOME (t,_), width, uses} :: l) =
                     if isEmpty (substsFilter (substs,
                        texpVarset (t,TVar.empty)))
                     then aFL (ss, l)
                     else aFL (SymbolSet.add' (n, ss), l)
            in
               aFL (ss, l)
            end
      in
         aF (SymbolSet.empty, substs, env)
      end

   fun affectedField (bVar, env) =
      let
         fun aF (_, SOME f) = SOME f
           | aF (([],_), NONE) = NONE
           | aF (env, NONE) = case Scope.unwrap env of
              (KAPPA {ty = t}, env) => aF (env, fieldOfBVar (bVar, t))
            | (SINGLE {name, ty = t}, env) => aF (env, fieldOfBVar (bVar, t))
            | (GROUP l, env) =>
            let
               fun findField ((_,t), SOME f) = SOME f
                 | findField ((_,t), NONE) = fieldOfBVar (bVar, t)
               fun aFL {name, ty = tOpt, width, uses} =
                  List.foldl findField
                     (case tOpt of
                          NONE => NONE
                        | SOME (t,_) => fieldOfBVar (bVar, t))
                     (SpanMap.listItems uses)
            in
               aF (env, case List.mapPartial aFL l of
                       [] => NONE
                     | (f :: _) => SOME f)
            end
      in
         aF (env, NONE)
      end

   fun flowError (bVar, fOpt, envs) =
      let
         val fOpt = List.foldl (fn (env,res) => case res of
                       SOME f => SOME f
                     | NONE => affectedField (bVar, env)) fOpt envs
         val fStr = case fOpt of
                 NONE => "some other field with var " ^ BD.showVar bVar
               | SOME f => "field " ^
                  SymbolTable.getString(!SymbolTables.fieldTable, f)
      in
         raise UnificationFailure (fStr ^ " cannot flow here")
      end

   fun meetBoolean (update, env as (scs, consRef)) =
      let
         val (bFun, sCons) = !consRef
         val bFun = update bFun
            handle (BD.Unsatisfiable bVar) => flowError (bVar, NONE, [env])
         val _ = consRef := (bFun, sCons)
      in
         env
      end

   fun meetSizeConstraint (update, (scs, consRef)) =
      let
         val (bFun, sCons) = !consRef
         val sCons = update sCons
      in
         (scs, (consRef := (bFun, sCons); consRef))
      end

   fun pushSymbol (sym, span, ctxt, env) =
      (case Scope.lookup (sym,env) of
          (_, SIMPLE {ty = t}) =>
         let
            val tNew = setFlagsToTop t
            val env = Scope.wrap (KAPPA {ty = tNew}, env)
            val l1 = texpBVarset (op ::) (t, [])
            val l2 = texpBVarset (op ::) (tNew, [])
            fun genImpl ((contra1,f1),(contra2,f2),bf) =
               if contra1<>contra2 then raise InferenceBug else
               if contra1 then
                  BD.meetVarImpliesVar (f2,f1) bf
               else
                  BD.meetVarImpliesVar (f1,f2) bf
         in
            meetBoolean (fn bFun => ListPair.foldlEq genImpl bFun (l2, l1), env)
         end
        | (tvs, COMPOUND {ty = SOME (t,bFunFun), width = w, uses}) =>
         let
            val (scs,consRef) = env
            val (bFun, sCons) = !consRef
            val bFun = BD.meet (bFunFun, bFun)
            val decVars = case w of
                 SOME t => texpVarset (t,TVar.empty)
               | NONE => TVar.empty
            val (t,bFun,sCons) = instantiateType (tvs, t, decVars, bFun, sCons)
            val _ = consRef := (bFun,sCons)
            val env = (scs,consRef)
            (*we need to record the usage sites of all functions (primitives,
            really) that have explicity size constraints in order to be able
            to later generate error messages for ambiguous uses of these
            functions*)
            fun action (COMPOUND {ty, width, uses},consRef) =
               (COMPOUND {ty = ty, width = width,
                uses = SpanMap.insert (uses, span, (ctxt, t))}, consRef)
              | action _ = raise InferenceBug
            val env =
               if TVar.isEmpty (TVar.intersection (decVars, SC.getVarset sCons))
               then env
               else Scope.update (sym, action, env)
         in
            Scope.wrap (KAPPA {ty = t}, env)
         end
        | (_, COMPOUND {ty = NONE, width, uses}) =>
          (case SpanMap.find (uses, span) of
               SOME (_,t) => Scope.wrap (KAPPA {ty = t}, env)
             | NONE =>
             let
                val res = VAR (TVar.freshTVar (),BD.freshBVar ())
                fun action (COMPOUND {ty, width, uses},consRef) =
                     (COMPOUND {ty = ty, width = width,
                      uses = SpanMap.insert (uses, span, (ctxt,res))}, consRef)
                  | action _ = raise InferenceBug
                val env = Scope.update (sym, action, env)
             in
                Scope.wrap (KAPPA {ty = res}, env)
             end
          )
      )

   fun getUsages (sym, env) = (case Scope.lookup (sym, env) of
           (_, SIMPLE {ty}) => []
         | (_, COMPOUND {ty, width, uses = us}) => SpanMap.listKeys us
         )

   fun pushUsage (sym, span, funList, env) = (case Scope.lookup (sym, env) of
           (_, SIMPLE {ty}) => raise InferenceBug
         | (_, COMPOUND {ty, width, uses = us}) =>
            let
               val (fs, t) = SpanMap.lookup (us, span)
               fun gatherBFun (f,bFun) =
                  case List.find (fn (f',_) => ST.eq_symid (f,f')) funList of
                       SOME (_, VALUE { symFlow = bFun', ... }) =>
                        BD.meet (bFun',bFun)
                     | SOME (_, DECODE { symFlow = bFun', ... }) =>
                        BD.meet (bFun',bFun)
                     | NONE => bFun
               fun addUsageBFun bFun = List.foldl gatherBFun bFun fs
               val env = meetBoolean (addUsageBFun, env)
            in
               Scope.wrap (KAPPA {ty = t}, env)
            end
         )

   fun popToUsage (sym, span, env) = (case Scope.unwrap env of
        (KAPPA {ty = tUse}, env) =>
         let
            val changedFuns = ref ([] : ST.symid list)
            fun setUsage (COMPOUND {ty, width, uses = us}, consRef) =
               (case SpanMap.find (us,span) of
                    NONE => raise InferenceBug
                  | SOME (ctxt, _) =>
                     (changedFuns := ctxt
                     ; (COMPOUND {ty = ty, width = width,
                        uses = SpanMap.insert (us,span,(ctxt,tUse))}, consRef)
                     )
               )
              | setUsage _ = raise InferenceBug
            val env = Scope.update (sym, setUsage, env)
            val changedFuns = case Scope.unwrap env of
                 (GROUP bs, _) => List.filter
                  (fn f =>
                     List.exists (fn {name=n, ty, width, uses} =>
                        ST.eq_symid (f,n)) bs)
                     (!changedFuns)
               | _ => []
            fun setType t (COMPOUND {ty = _, width, uses}, consRef) =
                  (COMPOUND {ty = SOME t, width = width, uses = uses},
                   consRef)
              | setType t _ = raise InferenceBug
            fun project ([], env) = env
              | project (f :: fs, env) = case Scope.lookup (f,env) of
                 (_, COMPOUND { ty = SOME (t,_), width, uses}) =>
                  project (fs,
                     reduceBooleanFormula (f,t,setType,List.null fs,env))
               | _ => raise InferenceBug
         in
            project (changedFuns, env)
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

   fun reduceToSum (n, env) =
      let
         fun rTS (n, vars, const, env) = if n>0 then
               case Scope.unwrap env of
                    (KAPPA {ty = CONST c}, env) => rTS (n-1, vars, c+const, env)
                  | (KAPPA {ty = VAR (v,_)}, env) => rTS (n-1, v::vars, const, env)
                  | _ => raise InferenceBug
            else case vars of
                 [] => Scope.wrap (KAPPA {ty = CONST const}, env)
               | [v] => Scope.wrap (KAPPA {ty = VAR (v, BD.freshBVar ())}, env)
               | _ => raise Substitutions.UnificationFailure
                  ("connot deal with numeric constraint")
      in
         rTS (n, [], 0, env)
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

   fun applySubsts (substs, ei, env) =
      let
         fun substBinding (KAPPA {ty=t}, ei, substs) =
            (case applySubstsToExp substs (t,ei) of (t,ei) =>
               (KAPPA {ty = t}, ei))
           | substBinding (SINGLE {name = n, ty = t}, ei, substs) =
            (case applySubstsToExp substs (t,ei) of (t,ei) =>
               (SINGLE {name = n, ty = t}, ei))
           | substBinding (GROUP bs, ei, substs) =
               let
                  val eiRef = ref ei
                  fun optSubst (SOME t) =
                     (case applySubstsToExp substs (t,!eiRef) of (t,ei) =>
                        (eiRef := ei; SOME t))
                    | optSubst NONE = NONE
                  fun optBSubst (SOME (t,bFun)) =
                     (case applySubstsToExp substs (t,!eiRef) of (t,ei) =>
                        (eiRef := ei; SOME (t,bFun)))
                    | optBSubst NONE = NONE
                  fun usesSubst (ctxt,t) =
                     (case applySubstsToExp substs (t,!eiRef) of (t,ei) =>
                        (eiRef := ei; (ctxt,t)))
                  fun substB {name = n, ty = t, width = w, uses = us} =
                     {name = n, ty = optBSubst t, width = optSubst w,
                      uses = SpanMap.map usesSubst us}
               in
                  (GROUP (List.map substB bs), !eiRef)
               end
         val substs = substsFilter (substs, Scope.getVars env)
      in
         if isEmpty substs then (ei, 0, env) else
            let
               (*val (sStr, si) = showSubstsSI (substs, TVar.emptyShowInfo)
               val (eStr, si) = topToStringSI (env, si)
               val _ = TextIO.print ("applySubst " ^ sStr ^ " to\n" ^ eStr)*)
               val (b, env) = Scope.unwrap env
               val (b, ei) = substBinding (b, ei, substs)
               val (ei, n, env) = applySubsts (substs, ei, env)
            in
               (ei, n+1, Scope.wrap (b, env))
            end
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
         fun setType t (COMPOUND {ty = NONE, width, uses}, consRef) =
               (COMPOUND {ty = SOME t, width = width, uses = uses},
                consRef)
           | setType t _ = (TextIO.print ("popToFunction " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ ":\n" ^ toString env); raise InferenceBug)
      in
         case Scope.unwrap env of
              (KAPPA {ty=t}, env) => reduceBooleanFormula (sym,t,setType,true,env)
            | _ => raise InferenceBug
      end

   fun clearFunction (sym, env) =
      let
         fun resetType (COMPOUND {ty = SOME _, width, uses}, consRef) =
               (COMPOUND {ty = NONE, width = width, uses = uses}, consRef)
           | resetType _ = raise InferenceBug
      in
         Scope.update (sym, resetType, env)
      end

   fun pushFunctionOrTop (sym, env) =
      let
         val tyRef = ref UNIT
         fun setType (COMPOUND {ty = SOME (t,_), width, uses}, consRef) =
               (tyRef := t
               ;(COMPOUND {ty = NONE, width = width, uses = uses}, consRef))
           | setType (COMPOUND {ty = NONE, width, uses}, consRef) =
               (tyRef := VAR (TVar.freshTVar (), BD.freshBVar ())
               ;(COMPOUND {ty = NONE, width = width, uses = uses}, consRef))
           | setType _ = raise InferenceBug
         val env = Scope.update (sym, setType, env)
      in
         Scope.wrap (KAPPA {ty = !tyRef}, env)
      end

   fun unify (env1, env2, (substs, ei)) =
      (case Scope.unwrapDifferent (env1, env2) of
           (SOME (KAPPA {ty = ty1}, KAPPA {ty = ty2}), env1, env2) =>
               unify (env1, env2, mgu(ty1, ty2, substs, ei))
         | (SOME (SINGLE {name = _, ty = ty1},
                  SINGLE {name = _, ty = ty2}), env1, env2) =>
               unify (env1, env2, mgu(ty1, ty2, substs, ei))
         | (SOME (GROUP bs1, GROUP bs2), env1, env2) =>
            let
               fun mguOpt (SOME t1, SOME t2, (s,ei)) = mgu (t1,t2,s,ei)
                 | mguOpt (NONE, NONE, sEi) = sEi
                 | mguOpt (_, _, _) = raise InferenceBug
               fun mguBOpt (SOME (t1,_), SOME (t2,_), (s,ei)) = mgu (t1,t2,s,ei)
                 | mguBOpt (NONE, NONE, sEi) = sEi
                 | mguBOpt (_, _, _) = raise InferenceBug
               fun mguUses ((s1,(ctxt1,t1)) :: us1, (s2,(ctxt2,t2)) :: us2, (s,ei)) =
                  (case compare_span (s1,s2) of
                       EQUAL => mguUses (us1, us2, mgu (t1,t2,s,ei))
                     | LESS => mguUses (us1, (s2,(ctxt2,t2)) :: us2, (s,ei))
                     | GREATER => mguUses ((s1,(ctxt1,t1)) :: us1, us2, (s,ei))
                  )
                  | mguUses (_, _, sEi) = sEi
               fun uB (({name = n1, ty = t1, width = w1, uses = u1},
                        {name = n2, ty = t2, width = w2, uses = u2}), sEi) =
                  if not (ST.eq_symid (n1,n2)) then raise InferenceBug else
                  mguUses (SpanMap.listItemsi u1, SpanMap.listItemsi u2,
                           mguBOpt (t1, t2, mguOpt (w1, w2, sEi)))
               (*val _ = if List.length bs1=List.length bs2 then () else
                     TextIO.print ("*************** mgu of\n" ^ topToString (Scope.wrap (GROUP bs1,env1)) ^ "\ndoes not match\n" ^ topToString (Scope.wrap (GROUP bs2,env2)))*)
               val (substs, ei) = List.foldl uB (substs, ei)
                                    (ListPair.zipEq (bs1,bs2))
            in
               unify (env1, env2, (substs, ei))
            end      
         | (NONE, env1, env2) => (substs, ei)
         | (SOME _, _, _) => raise InferenceBug
      )

   fun mergeUses (env1,env2) =
      (case Scope.unwrapDifferent (env1, env2) of
           (SOME (KAPPA {ty = t1}, KAPPA {ty = t2}), env1, env2) =>
            (case mergeUses (env1, env2) of (env1, env2) =>
               (Scope.wrap (KAPPA {ty = t1}, env1),
                Scope.wrap (KAPPA {ty = t2}, env2))
            )
         | (SOME (SINGLE {name = n1, ty = t1},
                  SINGLE {name = n2, ty = t2}), env1, env2) =>
            if not (ST.eq_symid (n1,n2)) then raise InferenceBug else
            (case mergeUses (env1, env2) of (env1, env2) =>
               (Scope.wrap (SINGLE {name = n1, ty = t1}, env1),
                Scope.wrap (SINGLE {name = n2, ty = t2}, env2))
            )
         | (SOME (GROUP bs1, GROUP bs2), env1, env2) =>
            let
               fun mergeOpt (SOME t1, SOME t2) = SOME t1
                 | mergeOpt (NONE, NONE) = NONE
                 | mergeOpt (_, _) = raise InferenceBug
               fun mB ({name = n1, ty = t1, width = w1, uses = u1},
                       {name = n2, ty = t2, width = w2, uses = u2}) =
                  if not (ST.eq_symid (n1,n2)) then raise InferenceBug else
                  ({name = n1, ty = mergeOpt (t1,t2),
                    width = mergeOpt (w1,w2),
                    uses = SpanMap.unionWith (fn (x,y) => x) (u1,u2)},
                   {name = n2, ty = mergeOpt (t2,t1),
                    width = mergeOpt (w2,w1),
                    uses = SpanMap.unionWith (fn (x,y) => x) (u2,u1)})
               (*val _ = if List.length bs1=List.length bs2 then () else
                     TextIO.print ("*************** mergeUses of\n" ^ topToString (Scope.wrap (GROUP bs1,env1)) ^ "\ndoes not match\n" ^ topToString (Scope.wrap (GROUP bs2,env2)))*)
               val (bs1,bs2) = ListPair.unzip
                                 (List.map mB (ListPair.zipEq (bs1,bs2)))
            in
               (case mergeUses (env1, env2) of (env1, env2) =>
                  (Scope.wrap (GROUP bs1, env1),
                   Scope.wrap (GROUP bs2, env2))
               )
            end      
         | (NONE, env1, env2) => (env1, env2)
         | (SOME _, _, _) => raise InferenceBug
      )

   fun genFlow (bFun, n, directed, env1, env2) =
      let
         fun genImpl (contra,f1,f2,bFun) =
            if contra then
               BD.meetVarImpliesVar (f2,f1) bFun
            else
               BD.meetVarImpliesVar (f1,f2) bFun
         fun genInfo ((contra1,f1), (contra2,f2),bFun) =
            if contra1<>contra2 then (TextIO.print ("cannot gen flow from\n" ^ topToString env1 ^ "to\n" ^ topToString env2); raise InferenceBug) else
            if BD.eq(f1,f2) then bFun else
            if directed then genImpl (contra1,f1,f2,bFun) else
               BD.meetEqual (f1,f2,bFun)
         fun flowForType (t1,t2,bFun) =
            let
               val l1 = texpBVarset (op ::) (t1, [])
               val l2 = texpBVarset (op ::) (t2, [])
               (*val _ = if List.length l1=List.length l2 then () else
                     TextIO.print ("*************** genFlow of\n" ^ topToString env1 ^ "\ndoes not match\n" ^ topToString env2)*)
               val bFun = ListPair.foldlEq genInfo bFun (l1, l2)
                     handle (BD.Unsatisfiable bVar) =>
                        flowError (bVar, affectedField (bVar, env1), [env1,env2])

               val bStr = BD.showBFun (ListPair.foldlEq genInfo BD.empty (l1, l2))
               val (tStr1, si) = showTypeSI (t1, TVar.emptyShowInfo)
               val (tStr2, si) = showTypeSI (t2, si)
               val _ = TextIO.print ("genFlow: " ^ tStr1 ^ "\nto     : " ^ tStr2 ^
                                     "\ngiving new flow " ^ bStr ^ "\n") 
            in
               bFun
            end
      in
         if n<=0 then bFun else case (Scope.unwrap env1, Scope.unwrap env2) of
             ((KAPPA {ty=t1}, env1), (KAPPA {ty=t2}, env2)) =>
               genFlow (flowForType (t1,t2,bFun), n-1, false, env1, env2)
           | ((SINGLE {ty=t1, name = n1}, env1), (SINGLE {ty=t2, name = n2}, env2)) =>
               genFlow (flowForType (t1,t2,bFun), n-1, false, env1, env2)
           | ((GROUP bs1, env1), (GROUP bs2, env2)) =>
               let
                  fun flowOpt (SOME t1,SOME t2,bFun) = flowForType (t1,t2,bFun)
                    | flowOpt (NONE,NONE,bFun) = bFun
                    | flowOpt _ = raise InferenceBug
                  fun bflowOpt (SOME (t1,_),SOME (t2,_),bFun) = flowForType (t1,t2,bFun)
                    | bflowOpt (NONE,NONE,bFun) = bFun
                    | bflowOpt _ = raise InferenceBug
                  fun genUsesFlow ((_,t1),(_,t2),bFun) = flowForType (t1,t2,bFun)
                  fun genBindFlow ({name = n1, ty=t1, width=w1, uses = us1},
                                   {name = n2, ty=t2, width=w2, uses = us2},bFun) =
                     ListPair.foldl
                        genUsesFlow
                        (bflowOpt (t1,t2, flowOpt (w1,w2,bFun)))
                        (SpanMap.listItems us1,SpanMap.listItems us2)
               in
                 ListPair.foldl genBindFlow bFun (bs1,bs2)
               end
           | _ => raise InferenceBug
      end

   fun meetGeneral (env1, env2, directed) =
      let
         (*val _ = TextIO.print ("unifying " ^ toString(env1) ^ " and " ^ toString(env2) ^ "\n")*)
         val (substs, ei) = unify (env1, env2, (emptySubsts, emptyExpandInfo))
               (*handle ListPair.UnequalLengths =>
                 (TextIO.print ("+++++ bad: unifying\n" ^ toString(env1) ^ "+++++ and\n" ^ toString(env2) ^ "\n"); raise InferenceBug)*)
         val (_, consRef) = env2
         val (bFun, sCons) = !consRef
         val (sCons, substs) = applySizeConstraints (sCons, substs)
         val bFun = applyExpandInfo ei bFun
            handle (BD.Unsatisfiable bVar) =>
               flowError (bVar, NONE, [env1,env2])
         val _ = consRef := (bFun, sCons)
         val (env1,env2) = mergeUses (env1, env2)
         
         val (eStr, si) = topToStringSI (env1,TVar.emptyShowInfo)
         val (e1Str,si) = kappaToStringSI (env1, si)
         val (e2Str,si) = kappaToStringSI (env2, si)
         val (e0Str,si) = showExpandInfoSI (ei, si)
         val (sStr,si) = showSubstsSI (substs,si)
         val _ = TextIO.print ("*** after meet, second environment:\n" ^ eStr ^ "expand info due to unification:\n" ^ e0Str)

         val (ei, n1, envSame1) = applySubsts (substs, emptyExpandInfo, env1)
         val (ei, n2, envSame2) = applySubsts (substs, ei, env2)
         val n = Int.max (n1,n2)
         val (_, consRef) = envSame2
         val (bFun, sCons) = !consRef
         val bFun = genFlow (bFun, n, directed, envSame1, envSame2)
            handle (BD.Unsatisfiable bVar) =>
               flowError (bVar, NONE, [envSame1,envSame2])
         val bFun = applyExpandInfo ei bFun
            handle (BD.Unsatisfiable bVar) =>
               flowError (bVar, NONE, [envSame1,envSame2])
         val _ = consRef := (bFun, sCons)

         val (eSame1Str,si) = kappaToStringSI (envSame1, si)
         val (eSame2Str,si) = kappaToStringSI (envSame2, si)
         val (eStr, si) = showExpandInfoSI (ei,si)
         val _ = TextIO.print ("applying substitution " ^ sStr ^ " to\n" ^ e1Str ^ "and\n" ^ e2Str ^ 
                  "resulting in\n" ^ eSame1Str ^ "and\n" ^ eSame2Str ^ "thereby expanding\n" ^ eStr)
      in
         envSame1
      end

   fun meetFlow (env1,env2) = meetGeneral (env1,env2,true)

   fun meet (env1,env2) = meetGeneral (env1,env2,false)
   
   fun subseteq (env1, env2) =
      let
         val (substs,_) = unify (env1, env2, (emptySubsts, emptyExpandInfo))
         (*val si = TVar.emptyShowInfo
         val (e1Str, si) = toStringSI (env1, si)
         val (e2Str, si) = toStringSI (env2, si)
         val (sStr, si) = showSubstsSI (substs, si)*)
         val substs = substsFilter (substs, Scope.getVars env1)
         (*val _ = TextIO.print ("+++++ substitution " ^ sStr ^ " indicates" ^
                  (if isEmpty substs then "" else " not") ^
                  " stable in env1:\n" ^ e1Str ^ "and env2:\n" ^ e2Str)*)
      in
         substs
      end

   fun getFunctionInfo (s,env) =
      case Scope.lookup (s,env) of
           (_, COMPOUND {ty = SOME (t,bFun), width = NONE, uses}) =>
            VALUE {symType = t, symFlow = bFun}
         | (_, COMPOUND {ty = SOME (t,bFun), width = SOME w, uses}) =>
            DECODE {symType = t, width = w, symFlow = bFun}
         | _ => raise InferenceBug

end