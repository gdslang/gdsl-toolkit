structure Environment : sig
   type environment

   structure SpanMap : ORD_MAP where type Key.ord_key = Error.span

   val primitiveEnvironment : (SymbolTable.symid *
                               Types.texp *
                               (BooleanDomain.bfun -> BooleanDomain.bfun) *
                               (Types.texp option)) list *
                               SizeConstraint.size_constraint list ->
                               environment
   
   (*add a group of bindings to the current environment, each element in a
   binding is identified by its symbol, the flag is true if the symbol
   is a decoder function*)
   val pushGroup : (VarInfo.symid * bool) list * environment ->
                  environment
   (*remove a binding group from the stack; the flag is true if the outermost
   scope should be kept, the result is a list of error messages about
   ambiguous type variables*)
   val popGroup : environment * bool ->
                  (Error.span * string) list * environment
   
   (*ask for all the symbols in the binding group*)
   val getGroupSyms : environment -> VarInfo.symid list
   
   val pushTop : environment -> environment
   
   (*pushes the given type onto the stack*)
   val pushType : Types.texp * environment -> environment

   (* push the width of a decode onto the stack*)
   val pushWidth : VarInfo.symid * environment -> environment

   (* For a function from a type containing several type variables to an
   algebraic data type, generate implications from the arguments of the
   algebraic data type to the argument of this function. *)
   val genConstructorFlow : (bool * environment) -> environment
   
   datatype push_mode =
      LetMono
    | LetForw
    | Normal

    (*given an occurrence of a symbol at a position, push its type onto the
    stack; arguments are the symbol to look up, the position it occurred at,
    wheather functions are represented as sets of types and a
    tag indicating if this usage should be recorded (LetForw), if a
    non-instantiated type should be pushed (LetMono), or if the
    argument is to be instantiated/used normally.
    The tag determines if a let-bound variable is instantiated, its usage recorded
    or if a lambda-bound variable should be an element of a set of types:
                     let-bound         lambda-bound
                   inst    record            set
      LetMono        no       no                n/a
      LetForw        yes      yes               n/a
      Normal         yes      no                yes  
    *)
   val pushSymbol : VarInfo.symid * Error.span * bool * push_mode * environment -> environment

   (*search in the current stack for the symbol and, if unsuccessful, in the
   nested definitions and push all nested groups onto the stack, returns the
   new stack and the number of nested groups that had to be pushed*)
   val pushNested : VarInfo.symid * environment -> (int * environment)

   (*pops the nested groups that were pushed by pushNested*)
   val popNested : int * environment -> environment

   (*obtain a fresh temporary symbol*)
   val acquireTempSymbol : environment -> VarInfo.symid * environment
   val releaseTempSymbol : VarInfo.symid * environment -> environment
   
   val getUsages : VarInfo.symid * environment -> Error.span list
   
   val getContextOfUsage : VarInfo.symid * Error.span * environment ->
                           VarInfo.symid

   val getCtxt : environment -> VarInfo.symid list

      (*stack: [...,t] -> [...] and type of f for call-site s is set to t*)
   val popToUsage : VarInfo.symid * Error.span * environment -> environment

   (*stack: [...] -> [...,t] where t is type of usage of f at call-site s*)
   val pushUsage : VarInfo.symid * Error.span * environment -> environment
   
   (*stack: [...] -> [..., x:a], 'a' fresh; primed version also returns 'a'*)
   val pushLambdaVar' : VarInfo.symid * environment -> (Types.texp * environment)
   val pushLambdaVar : VarInfo.symid * environment -> environment
   
   (*stack: [..., t0, t1, ... tn] -> [..., {f1:t1, ... fn:tn, t0:...}]*)
   val reduceToRecord : (BooleanDomain.bvar * FieldInfo.symid) list *
                        environment -> environment

   (*stack: [..., tn, ..., t2, t1, t0] -> [..., SUM (tn,..t0)]*)
   val reduceToSum : int * environment -> environment

   (*stack: [..., t] -> [..., |t|]*)
   val constToVec : environment -> environment

   (*stack: [...,(a1,..an) -> r,t1,t2,...,tn] -> [...,(a1,..an) -> r,{t1},{t2},...,{tn}]
      if ai is a set *)
   val expandArguments : environment * int -> environment

   (*stack: [...,t1,t2,...,tn] -> [...,(t1, ... t n-1) -> tn]*)
   val reduceToFunction : environment * int -> environment
   
   (*stack: [...,t1 -> t2] -> [...t2]*)
   val reduceToResult : environment -> environment
   
   (*stack: [...,S |1| <i => o>] -> [...,S r <i => o>] *)
   val reduceGuardToAction : environment -> environment

   (*stack: [..., tn, ..., t2, t1, t0] -> [..., t0]*)
   val return : int * environment -> environment

   val popKappa : environment -> environment

   (*stack: [..., t2, t1], meet t1=t2 for types and flow *)
   val equateKappas : environment -> environment

   (*stack: [..., t2, t1], meet t1=t2 for types and t2=>t1 for flow*)
   val equateKappasFlow : environment -> environment

   (*stack: [..., t2, t1] -> [..., t1, t2] *)
   val flipKappas : environment -> environment

   (*stack: [..., t1, t2], compute mgu(t1,t2) and return the set
     of substitutions for t1; this set is empty if t1 is smaller
     (more specific) than t2; when testing for stability t1 is
     the usage site and t2 the fresh function instance *)
   val subsetKappas : environment -> (TVar.tvar * Types.texp) list

   (*stack: [...,t] -> [...] and type of function f is set to t*)
   val popToFunction : VarInfo.symid * environment -> environment

   (*push the name of the function into the current context (the context
   determines in which function calls to unknown functions are recorded)*)
   val enterFunction : VarInfo.symid * environment -> environment

   (*pop the last function from the current context*)
   val leaveFunction : VarInfo.symid * environment -> environment
   
   (*mark the given symbol and its local definitions as stable which means
   that any uses of them will use the inferred type rather than leaving a hole*)
   val markAsStable : VarInfo.symid * environment -> environment

   val clearUses : VarInfo.symid * environment -> environment

    (*apply the Boolean function*)
   val meetBoolean : (BooleanDomain.bfun -> BooleanDomain.bfun) *
         environment -> environment

   val reduceFlow :  environment -> environment

   val cleanEnvironment : environment -> environment

   val meetSizeConstraint : (SizeConstraint.size_constraint_set ->
                             SizeConstraint.size_constraint_set) *
                             environment -> environment

   (*return all function symbols in binding groups that would have to be
   re-checked if any type variable in the current kappa change*)
   val affectedFunctions : environment -> SymSet.set

   val garbageCollect : environment -> environment
   
   val dumpTypeTableSI : environment * TVar.varmap -> string * TVar.varmap
   val toString : environment -> string
   val toStringSI : environment * TVar.varmap -> string * TVar.varmap
   val topToString : environment -> string
   val topToStringSI : environment * TVar.varmap -> string * TVar.varmap
   val kappaToString : environment -> string
   (*show the nth kappa on the stack, if second arg is non-zero, then only show the nth argument of the function*)
   val kappaToStringSI : (int * int) * environment * TVar.varmap -> string * TVar.varmap
   val funTypeToStringSI  : environment * VarInfo.symid * TVar.varmap ->
                            string * TVar.varmap
   val finalize : unit -> unit
end = struct
   structure ST = SymbolTable
   structure BD = BooleanDomain
   structure SC = SizeConstraint
   structure TT = TypeTable
   structure SpanMap = SpanMap
   open Types
   open Substitutions

   type kappa = ST.symid

   (*restrict which symbols toString prints*)
   val debugSymbol : int option = NONE (*SOME 911*)

   (*any error that is not due to unification*)
   exception InferenceBug
   
   datatype binding
      = KAPPA of {
         kappa : kappa
      } | SINGLE of {
         name : ST.symid
      } | GROUP of {
         name : ST.symid,
         (* true if the type of this function is stable,
            false if a usage has to be recorded so that stability can be checked later*)
         ty : bool,
         (*this is SOME k if this is a decode function with pattern width tt(k)*)
         width : kappa option,
         (*for each location that name is used, track the kappa symbol that holds the instantiated
           type of name and the context, that is, the symid of the function in which name is mentioned *)
         uses : (kappa * ST.symid) SpanMap.map,
         (*a tree of nested binding groups*)
         nested : binding list
      } list
   
   datatype bind_info
      = SIMPLE
      | COMPOUND of { ty : bool, width : kappa option,
                      uses : (kappa * ST.symid) SpanMap.map,
                      nested : binding list }

   structure Scope : sig
      type scopes = binding list
      type constraints

      type environment = scopes * constraints

      val acquireKappa : environment -> VarInfo.symid * environment
      val releaseKappa : VarInfo.symid * environment -> environment
      
      val acquireUsageSymbol : VarInfo.symid * Error.span * environment ->
                               VarInfo.symid * environment

      val getCurFun : environment -> VarInfo.symid
      val setCtxt : VarInfo.symid list -> environment -> environment
      val getCtxt : environment -> VarInfo.symid list
      
      val getTypeTable : environment -> TypeTable.table
      val setTypeTable : TypeTable.table -> environment -> environment
      val initial : binding * SC.size_constraint_set * TypeTable.table -> environment
      val wrap : binding * environment -> environment
      val unwrap : environment -> (binding * environment)
      val lookup : ST.symid * environment -> bind_info
      val restrictToInScope : ST.symid * SymSet.set * environment -> SymSet.set 
      val update : ST.symid  *
                   (bind_info * constraints -> bind_info * constraints) *
                   environment-> environment
      val sane : environment -> unit
      val cleanEnvironment : environment -> environment
      val toString : binding * TT.table * TVar.varmap -> string * TVar.varmap
   end = struct
      type scopes = binding list

      type constraints = {
         context : VarInfo.symid list,
         typeTable : TT.table
      }

      type environment = scopes * constraints

      fun acquireKappa (scs,{ context = ctxt, typeTable = ti }) = 
         (TT.acquireKappa ti, (scs,{ context = ctxt, typeTable = ti }))
      fun releaseKappa (k,(scs,{ context = ctxt, typeTable = ti })) =
         (TT.releaseKappa (k,ti); (scs, { context = ctxt, typeTable = ti }))

      fun acquireUsageSymbol (sym,span,env) =
         let
            val st = !SymbolTables.varTable
            val symStr = ST.getString(st, sym)
            val atom = Atom.atom (symStr ^ "@" ^ ST.spanToString span)
            val (st, usageSym) = case ST.find (st, atom) of
                  SOME usageSym => (st, usageSym)
                | NONE => ST.fresh (st,atom)
            val _ = SymbolTables.varTable := st
         in
            (usageSym,env)
         end

      fun getCurFun (scs,{ context = ctxt, typeTable }) =
         case ctxt of
              (curFun :: _) => curFun
            | [] => raise InferenceBug
      fun setCtxt ctxt (scs,{ context = _, typeTable = tt }) =
         (scs,{ context = ctxt, typeTable = tt })
      fun getCtxt (_,{ context = ctxt, typeTable }) = ctxt

      fun getTypeTable (_,{ context, typeTable = tt }) = tt
      fun setTypeTable tt (scs,{ context = ctxt, typeTable = _ }) =
         (scs,{ context = ctxt, typeTable = tt })

      fun initial (b, scs, tt) =
         ([b], {
            context = [],
            typeTable = TT.modifySizes (fn scs' => SC.merge (scs,scs'), tt)
          })
      fun wrap (b, (scs, state)) = (b::scs,state)
      fun unwrap (bi :: scs, state) = (bi, (scs, state))
        | unwrap ([], state) = raise InferenceBug

      fun lookup (sym, (scs, cons) : environment) =
         let    
            fun l [] =
                  (TextIO.print ("urk, tried to lookup non-existent symbol " ^ Int.toString (SymbolTable.toInt sym) ^ ": " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ "\n")
                  ;raise InferenceBug)
              | l (KAPPA {kappa}::scs) = l scs
              | l (SINGLE {name}::scs) =
                  if ST.eq_symid (sym,name) then SIMPLE else l scs
              | l (GROUP bs::scs) =
                  let
                     fun lG [] = l scs
                       | lG ({name, ty, width, uses, nested}::bs) =
                           if ST.eq_symid (sym,name) then
                              COMPOUND { ty = ty, width = width, uses = uses, nested = nested }
                           else lG bs
                  in
                     lG bs                     
                  end
      
         in
            l scs
         end

      fun restrictToInScope (sym, ss, (scs, cons) : environment) =
         let
            fun restrict (ss, scs) =
               if SymSet.isEmpty ss then SymSet.empty else
               (*(TextIO.print ("restrictToInScope: current args of " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ " are" ^ SymSet.foldl (fn (sym,str) => SymbolTable.getString(!SymbolTables.varTable, sym) ^ str) "" ss ^ "\n");*)
               case scs of
                    [] => 
                     (TextIO.print ("restrictToInScope: non-existent symbol " ^ Int.toString (SymbolTable.toInt sym) ^ ": " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ "\n")
                     ;raise InferenceBug)
                  | KAPPA {kappa}::scs => restrict (if SymSet.member (ss,kappa) then SymSet.delete (ss,kappa) else ss, scs)
                  | SINGLE {name}::scs => restrict (if SymSet.member (ss,name) then SymSet.delete (ss,name) else ss, scs)
                  | GROUP bs::scs =>
                     let
                        fun rmUses (sm,ss) =
                           SpanMap.foldl (fn ((kappa,ctxt),ss) =>
                              if SymSet.member (ss,kappa) then SymSet.delete (ss,kappa) else ss)
                              ss sm
                        fun r ss [] = restrict (ss,scs)
                          | r ss ((b as {name, ty, width, uses, nested})::bs) =
                          let
                             fun rmGroup ({name, ty, width, uses, nested},ss) =
                                let
                                   val ss = rmUses (uses,ss)
                                   val ss = foldl rmNested ss nested
                                in 
                                   if SymSet.member (ss,name) then SymSet.delete (ss,name) else ss
                                end
                             and rmNested (GROUP bs,ss) = foldl rmGroup ss bs
                               | rmNested (_, ss) = raise InferenceBug

                             val ss = rmUses (uses,ss)
                             val ss = foldl rmNested ss nested
                          in
                             if ST.eq_symid (sym,name) then ss else r ss bs
                          end
                     in
                        r ss bs
                     end
               (*)*)
         in
            restrict (ss,scs)
         end

      fun update (sym, action, env) =
         let
            fun tryUpdate (KAPPA _, cons) = NONE
              | tryUpdate (SINGLE {name}, cons) =
                if ST.eq_symid (sym,name) then
                  let
                     val (SIMPLE, cons) = action (SIMPLE, cons)
                  in
                     SOME (SINGLE {name = name}, cons)
                  end
                else NONE
              | tryUpdate (GROUP bs, cons) =
               let fun upd (otherBs, []) = NONE
                     | upd (otherBs, (b as {name, ty, width, uses, nested})::bs) =
                        if ST.eq_symid (sym,name) then
                           let val (COMPOUND { ty = ty, width = width,
                                               uses = uses, nested = nested}, cons) =
                                   action (COMPOUND { ty = ty, width = width,
                                                      uses = uses, nested = nested}, cons)
                           in
                              SOME (GROUP (List.revAppend (otherBs,
                                          {name = name, ty = ty,
                                           width = width, uses = uses,
                                           nested = nested} :: bs))
                                   ,cons)
                           end
                        else upd (b::otherBs, bs)
               in
                  upd ([],bs)
               end
            fun unravel (bs, ([],_)) = raise InferenceBug
              | unravel (bs, env) = case unwrap env of
               (b, env as (scs, cons)) =>
                  (case tryUpdate (b, cons) of
                       NONE => unravel (b::bs, env)
                     | SOME (b,cons) => List.foldl wrap (scs, cons) (b::bs) )
         in
            unravel ([], env)
         end

      fun showVarsVer (typeVars,boolVars,ver,si) =
         let
            val (vsStr, si) = TVar.setToString (typeVars,si)
            val bsStr = BD.setToString boolVars
         in
            ("ver=" ^ Int.toString(ver) ^
             ", bvars = " ^ bsStr ^  ", vars=" ^ vsStr ^ "\n", si)
         end

      and toString (KAPPA {kappa}, tt, si) =
            let
               val ty = TT.peekSymbol (kappa,tt)
               val (tStr, si) = showTypeSI (ty,si)
               val vs = texpBVarset (fn ((_,v),vs) => BD.addToSet (v,vs)) (ty,BD.emptySet)
               val bStr = if concisePrint then "" else
                           ", flow:" ^ BD.showBFunPart (vs, TT.getFlow tt)
               val vs = texpVarset (ty,TVar.empty)
               val (sStr,si) = SC.toStringSI (TT.getSizes tt,SOME vs,si)
            in
               case debugSymbol of
                  (SOME _) => ("",si)
                | NONE => (ST.getString(!SymbolTables.varTable, kappa) ^ ": " ^ tStr ^ bStr ^ sStr, si)
            end
        | toString (SINGLE {name}, tt, si) =
            let
               val ty = TT.peekSymbol (name,tt)
               val (tStr, si) = showTypeSI (ty,si)
               val vs = texpBVarset (fn ((_,v),vs) => BD.addToSet (v,vs)) (ty,BD.emptySet)
               val bStr = if concisePrint then "" else
                           ", flow:" ^ BD.showBFunPart (vs, TT.getFlow tt)
               val vs = texpVarset (ty,TVar.empty)
               val (sStr,si) = SC.toStringSI (TT.getSizes tt,SOME vs,si)
               val visible = case debugSymbol of
                     NONE => true
                   | (SOME sid) => sid=SymbolTable.toInt name
            in
               if visible then
                  ("SYMBOL " ^ ST.getString(!SymbolTables.varTable, name) ^
                  " : " ^ tStr ^ bStr ^ sStr, si)
               else
                  ("",si)
            end
        | toString (GROUP bs, tt, si) =
            let
               fun prTyOpt (NONE, str, si) = ("", si)
                 | prTyOpt (SOME kappa, str, si) = let
                    val ty = TT.peekSymbol (kappa,tt)
                    val (tStr, si) = showTypeSI (ty, si)
                 in
                     (str ^ tStr, si)
                 end
               fun prBTyOpt (false, sym, str, si) = ("", si)
                 | prBTyOpt (true, sym, str, si) = let
                    val ty = TT.peekSymbol (sym,tt)
                    val (tStr, si) = showTypeSI (ty, si)
                    val vs = texpBVarset (fn ((_,v),vs) => BD.addToSet (v,vs)) (ty,BD.emptySet)
                    val bStr = if concisePrint then "" else
                                ", flow:" ^ BD.showBFunPart (vs, TT.getFlow tt)
                    val vs = texpVarset (ty,TVar.empty)
                    val (sStr,si) = SC.toStringSI (TT.getSizes tt,SOME vs,si)
                 in
                     (str ^ tStr ^ bStr ^ sStr, si)
                 end
               fun printU ((span, (useSym,ctxt)), (str, sep, si)) =
                  let
                     val ty = TT.peekSymbol (useSym,tt)
                     val (tStr, si) = showTypeSI (ty, si)
                  in
                     (str ^
                      sep ^ ST.getString(!SymbolTables.varTable, useSym) ^
                      ":" ^ tStr ^ " in " ^ ST.getString(!SymbolTables.varTable, ctxt)
                     ,"\nuse as ", si)
                  end
               fun printB ({name,ty,width,uses,nested}, (str, si)) =
                  let
                     val visible = case debugSymbol of
                           NONE => true
                         | (SOME sid) => sid=SymbolTable.toInt name
                     val (tStr, si) = prBTyOpt (ty, name, " : ", si)
                     val (wStr, si) = prTyOpt (width, ", width = ", si)
                     val (uStr, _, si) = 
                           List.foldl printU ("", "\nuse at ", si)
                                      (SpanMap.listItemsi uses)
                     fun showBindInfosSI n (b :: bs,si) =
                        let
                           val (bStr, si) = toString (b,tt,si)
                           fun spaces n = if n<=0 then "" else "  " ^ spaces (n-1)
                           val sStr = spaces n
                           val (bsStr, si) = showBindInfosSI (n+1) (bs, si)
                           val fs1 = Substring.fields (fn c => c= #"\n") (Substring.full bStr)
                           val fs2 = Substring.fields (fn c => c= #"\n") (Substring.full bsStr)
                        in
                           (List.foldl
                              (fn (f,str) => str ^ sStr ^ Substring.string f ^ "\n")
                              "\n" (fs1 @ fs2),
                            si)
                        end
                       | showBindInfosSI n ([], si) = ("", si)
                     val (nStr, si) = showBindInfosSI 1 (nested,si)
                  in
                    if not visible then (str, si) else
                    (str ^
                     "\n  " ^ ST.getString(!SymbolTables.varTable, name) ^
                     tStr ^ wStr ^ nStr ^ uStr
                    ,si)
                  end
                val (bsStr, si) = List.foldr printB ("", si) bs
            in
               ("GROUP" ^ bsStr, si)
            end

      fun sane ([], cons) = raise InferenceBug
        | sane (KAPPA _ :: scs, cons) = sane (scs, cons)
        | sane (SINGLE _ :: scs, cons) = sane (scs, cons)
        | sane (GROUP bs :: scs, cons) =
         let
            val tt = #typeTable (cons : constraints)
            fun checkNoIntersect (s,vs) {name=sym, ty, width, uses, nested} =
               let
                  val otherVars = texpVarset (TT.peekSymbol (sym,tt), TVar.empty)
                  val inBoth = TVar.intersection (vs,otherVars)
               in
                  if TVar.isEmpty inBoth then () else
                     (TextIO.print ("tyVars " ^ #1 (TVar.setToString (inBoth,TVar.emptyShowInfo)) ^ " in symbol " ^ ST.getString(!SymbolTables.varTable, s) ^ " also occur in symbol " ^ ST.getString(!SymbolTables.varTable, sym) ^ "\n" ^ #1 (toString (GROUP bs,tt,TVar.emptyShowInfo)) );
                      raise InferenceBug)
               end
               
            fun check (prevBs, []) = ()
              | check (prevBs, (b as {name=sym, ty, width, uses, nested}) :: nextBs) =
               let
                  val tyVars = texpVarset (TT.peekSymbol (sym,tt), TVar.empty)
                  val _ = app (checkNoIntersect (sym,tyVars)) (prevBs @ nextBs)
               in
                  check (b :: prevBs, nextBs)
               end
         in
            (check ([], bs); sane (scs, cons))
         end
      
      fun cleanEnvironment (bs, { context = ctxt, typeTable = tt }) =
         let                             
            val _ = TT.killKappas tt
         in
            (bs, { context = ctxt, typeTable = tt })
         end
               
   end
   
   type environment = Scope.environment

   fun dumpTypeTableSI (env,si) = TT.dumpTableSI (Scope.getTypeTable env, si)
   
   fun toStringSI (env,si) = 
      let
         val tt = Scope.getTypeTable env
         (*val (ttStr, si) = TypeTable.toStringSI (fn _ => true, tt, si)*)
         fun showCons (s, (str, si)) =
            let
               val (bStr, si) = Scope.toString (s, tt, si)
            in
               (bStr ^ "\n" ^ str, si)
            end
         val (sStr, si) = SC.toStringSI (TypeTable.getSizes tt, NONE, si)
         val (envConsStr, si) = List.foldr showCons ("", si) (#1 env)
         fun showCtxt [] = "top level"
           | showCtxt [f] = ST.getString(!SymbolTables.varTable, f)
           | showCtxt (f::fs) = showCtxt [f] ^ ";" ^ showCtxt fs
      in
         ("environment at " ^ showCtxt (Scope.getCtxt env) ^
          "\n" ^ envConsStr ^ sStr ^ "\n", si)
      end

   fun toString env =
      let
         val (str, _) = toStringSI (env,TVar.emptyShowInfo)
      in
         str
      end
   
   fun topToStringSI ((scs, state), si) =
        toStringSI (((List.rev (List.drop (List.rev scs, 
         Int.min (List.length scs-1,2)))), state), si)

   fun topToString env =
      let
         val (str, _) = topToStringSI (env,TVar.emptyShowInfo)
      in
         str
      end

   fun kappaToStringSI ((kappaNo, argSel), env, si) =
      let
         fun getKappa (n,env) = case Scope.unwrap env of
              (KAPPA {kappa = k}, env) => if n<=1 then k else getKappa (n-1,env)
            | _ => raise InferenceBug
         val k = getKappa (kappaNo,env)
         val tt = Scope.getTypeTable env
         val ty = TT.peekSymbol (k,tt)
         val ty = if argSel<=0 then ty else case ty of
            FUN (tys,_) => List.nth (tys,argSel-1)
          | _ => ty
         val (tStr, si) = showTypeSI (ty,si)
      in
         (tStr ^ "\n", si)
      end

   fun funTypeToStringSI (env, f, si) =
      let
         val tt = Scope.getTypeTable env
         val ty = TT.peekSymbol (f,tt)
      in
         showTypeSI (ty, si)
      end

   fun kappaToString env =
      let
         val (str, _) = kappaToStringSI ((1,0), env,TVar.emptyShowInfo)
      in
         str
      end

   fun genSizeSymbol baseSym =
      let
         val st = !SymbolTables.varTable
         val symStr = ST.getString(st, baseSym)
         val atom = Atom.atom (symStr ^ " size")
         val (st, sizeSym) = case ST.find (st, atom) of
               SOME sizeSym => (st, sizeSym)
             | NONE => SymbolTable.fresh (st,atom)
         val _ = SymbolTables.varTable := st
      in
         sizeSym
      end

   fun primitiveEnvironment (l,scs) =
      let
         val tt = TT.emptyTable ()
         fun addInfo (s,t,bFunGen,ow) =
            let
               val _ = TT.addSymbol (s,t,tt)
               val _ = TT.modifyFlow (bFunGen,tt)
               val width = case ow of
                     NONE => NONE
                   | SOME ty =>
                     let
                        val ss = genSizeSymbol s
                        val _ = TT.addSymbol (ss,ty,tt)
                     in
                        SOME ss
                     end
            in
               {  name = s, ty = true,
                  width = width, uses = SpanMap.empty, nested = []}
            end
         val bs = List.map addInfo l
      in
         Scope.initial (GROUP bs, scs, tt)
      end

   fun pushGroup (syms, env) =
      let
         val tt = Scope.getTypeTable env
         fun genGroup [] = []
           | genGroup ((sym,dec) :: syms) =
               let
                  (*val _ = TextIO.print ("pushGroup: symbol " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ "\n")*)
                  val _ = TT.addSymbol (sym,VAR (TVar.freshTVar (), BD.freshBVar ()), tt)
                  val w = if not dec then NONE else
                     let
                        val sizeSym = genSizeSymbol sym
                        val _ = TT.addSymbol (sizeSym,VAR (TVar.freshTVar (), BD.freshBVar ()), tt)
                     in
                        SOME sizeSym
                     end
                  val res = { name = sym, ty = false, width = w,
                              uses = SpanMap.empty, nested = []}
               in
                  res :: genGroup syms
               end
         val bs = genGroup syms
      in                                                                    
        Scope.wrap (GROUP bs, env)
      end                                    

   fun popGroup (env, true) = 
     (case Scope.unwrap env of
        (KAPPA {kappa=k}, env) =>
         let
           val (badUses, env) = popGroup (env, false)
         in
            (badUses, Scope.wrap (KAPPA {kappa=k}, env))
         end
       | _ => raise InferenceBug)
     | popGroup (env, false) = 
      case Scope.unwrap env of
        (GROUP bs, env) =>
         let
            (*val remVars = Scope.getVars env
            val (scs, state) = env
            (*figure out if there are any function usages that have unresolved
            type variables that relate to sizes*)
            val curVars = SC.getVarset (Scope.getSize state)
            val unbounded = TVar.difference (curVars,remVars)
            (*val _ = TextIO.print ("unbounded vars: " ^ #1 (TVar.setToString (unbounded,TVar.emptyShowInfo)) ^ "\n")*)
            val siRef = ref TVar.emptyShowInfo
            fun showUse (n, (ctxt,t)) =
               let
                  val nStr = SymbolTable.getString(!SymbolTables.varTable, n)
                  val (tStr, si) = showTypeSI (t, !siRef)
                  val vs = texpVarset (t,TVar.empty)
                  val (cStr, si) = SC.toStringSI (Scope.getSize state, SOME vs, si)
               in
                  (siRef := si
                  ; nStr ^ " : call to " ^ tStr ^ " has ambiguous vector sizes" ^
                     (if String.size cStr=0 then "" else " where " ^ cStr))
               end
            fun remBoundVars ({name,ty,width,uses,nested=ns},vs) =
                  List.foldl remBoundVars 
                     (TVar.difference (vs, texpVarset (t,TVar.empty)))
                     (List.concat (List.map (fn g => case g of
                          GROUP bs => bs
                        | _ => raise InferenceBug) ns))
              | remBoundVars (_,vs) = vs
            val unbounded = List.foldl remBoundVars unbounded bs
            (*TODO: we should also descend into the nested definitions,
            since the letrec expression cannot report ambigueties since
            when letrec groups are popped, the fixpoint has not been
            calculated yet*)
            val badSizes = List.concat (
               List.map (fn {name = n,ty,width,uses = us,nested} =>
                  List.map (fn (sp,t) => (sp, showUse (n, t))) (
                     SpanMap.listItemsi (
                        SpanMap.filter (fn (_,t) =>
                           not (TVar.isEmpty (TVar.intersection
                              (texpVarset (t,TVar.empty), unbounded)))
                           ) us))) bs)
            (*project out variables from the size and Boolean domains that are
            no longer needed*)
            val sCons = SC.filter (remVars, Scope.getSize state)
            val env = (scs, Scope.setSize sCons state)*)
            
            (*in case we are inside a function, store this group in the nested
            field of the function entry*)
            fun action group (COMPOUND {ty, width, uses, nested},cons) =
               (COMPOUND {ty = ty, width = width,
                uses = uses, nested = group :: nested}, cons)
              | action ns _ = raise InferenceBug
            (*val _ = if not (List.null (Scope.getCtxt env)) then
                    TextIO.print ("popGroup, updating " ^ SymbolTable.getString(!SymbolTables.varTable, Scope.getCurFun state) ^
                              " to contain group " ^ List.foldl (fn ({name, ty, width, uses, nested},acc) => SymbolTable.getString(!SymbolTables.varTable, name) ^ ", " ^ acc) "" bs ^ "\n" ^ topToString env)
                    else ()*)
         in
            ([],if List.null (Scope.getCtxt env) then
               env
            else
               Scope.update (Scope.getCurFun env, action (GROUP bs), env)
            )
         end
      | _ => raise InferenceBug

   fun getGroupSyms env =
     case Scope.unwrap env of
        (GROUP bs, env) => List.map #name bs
      | _ => raise InferenceBug

   fun pushTop env =
      let
         val tt = Scope.getTypeTable env
         val (k,env) = Scope.acquireKappa env
         val _ = TT.addSymbol (k,VAR (TVar.freshTVar (), BD.freshBVar ()), tt)
      in
         Scope.wrap (KAPPA {kappa = k}, env)
      end

   fun pushType (t, env) =
      let
         val (k,env) = Scope.acquireKappa env
         val _ = TT.addSymbol (k,t,Scope.getTypeTable env)
      in
         Scope.wrap (KAPPA {kappa = k}, env)
      end

   fun pushWidth (sym, env) =
      let
         val tt = Scope.getTypeTable env
         val sizeSym = case Scope.lookup (sym,env) of
                (COMPOUND {ty, width = SOME sizeSym, uses, nested}) => sizeSym
              | _ => raise (UnificationFailure (Clash, SymbolTable.getString(!SymbolTables.varTable, sym) ^
                             " is not a decoder"))
         val (k,env) = Scope.acquireKappa env
         val _ = TT.addSymbol (k,VAR (TVar.freshTVar (), BD.freshBVar ()),tt)
         val _ = TT.equateSymbols (k,sizeSym,tt)
      in
         Scope.wrap (KAPPA {kappa = k}, env)
      end

   fun garbageCollect env =
      let
         val tt = Scope.getTypeTable env
         val tt = TT.garbageCollect tt
      in
         Scope.setTypeTable tt env
      end

   exception LookupNeedsToAddUse

   fun affectedFunctions env =
      let
         val tt = Scope.getTypeTable env
         val kappa = case Scope.unwrap env of
                  (KAPPA {kappa}, env) => kappa
                | _ => raise InferenceBug
         val tVars = texpVarset (TT.peekSymbol (kappa,tt), TVar.empty)
         fun deleteSym (ss,s) =
            if SymSet.member (ss,s) then SymSet.delete (ss,s) else ss
            
         fun aF (ss, affected, ([], _)) = (ss, affected)
           | aF (ss, affected, env) = if SymSet.isEmpty affected then
               (ss, affected) else aFB (ss, affected) (Scope.unwrap env)
         and aFB (ss, affected) (GROUP l,env) =
            let
               fun aFL (ss, affected, []) = aF (ss, affected, env)
                 | aFL (ss, affected, {name = n, ty, width, uses = us, nested = ns} :: l) =
                     List.foldl (fn (b,acc) => aFB acc (b,env))
                     (if List.all (fn (kappa,_) => not (SymSet.member (affected,kappa)))
                           (SpanMap.listItems us)
                     then aFL (ss, affected, l)
                     else aFL (SymSet.add' (n, ss), SymSet.difference (affected,
                        SymSet.fromList (map #2 (SpanMap.listItems us))), l)
                     ) ns
            in
               aFL (ss, affected, l)
            end
           | aFB (ss, affected) (KAPPA {kappa}, env) =
               aF (ss, deleteSym (affected,kappa), env)
           | aFB (ss, affected) (SINGLE {name}, env) =
               aF (ss, deleteSym (affected,name), env)
         (*val _ = TextIO.print ("affected vars: " ^ #1 (TVar.setToString (tVars,TVar.emptyShowInfo)) ^ "\n")*)
         val affected = TT.symbolsWithVars (tVars, Scope.getTypeTable env) : SymSet.set
         (*val _ = TextIO.print ("affected syms: " ^ SymSet.foldl (fn (sym,str) => SymbolTable.getString(!SymbolTables.varTable, sym) ^ " " ^ str) "" affected ^ "\n")*)
         val (ss, _) = aF (SymSet.empty, affected, env)
      in
         ss
      end

   fun flowError (bVars, fOpt, env) =
      let
         val tt = Scope.getTypeTable env
         val fStr = case TT.affectedField (bVars, tt) of
                 NONE => "some field"
               | SOME f => "field " ^
                  SymbolTable.getString(!SymbolTables.fieldTable, f)
         val fStr = if Types.concisePrint then fStr else
                    fStr ^ " with flow " ^ BD.showBFunPart (bVars, TT.getFlow (Scope.getTypeTable env))
      in
         raise UnificationFailure (Clash, fStr ^ " may not be present")
      end

   fun meetBoolean (update, env) =
      (TT.modifyFlow (update, Scope.getTypeTable env); env)
         handle (BD.Unsatisfiable bVars) => flowError (bVars, NONE, env)

   fun reduceFlow env = env

   fun cleanEnvironment env = Scope.cleanEnvironment env
   
   exception Unimplemented
   fun meetSizeConstraint (update, (scs, state)) = raise Unimplemented
(* 
      (scs, Scope.setSize (update (Scope.getSize state)) state)
*)
   fun genConstructorFlow (contra, env) =
      case Scope.unwrap env of
        (KAPPA {kappa=k}, _) =>
         let
            val tt = Scope.getTypeTable env
            val (t,vs) = case TT.peekSymbol (k,tt) of
               FUN ([t], ALG (_,vs)) => (t,vs)
             | _ => raise InferenceBug
               
            val dtVars = List.map (fn v => case v of
                             VAR p => p
                           | _ => raise InferenceBug) vs
            val _ = TT.modifyFlow (fn bFun => texpConstructorFlow dtVars contra t bFun, tt)
         in
            env
         end
      | _ => raise InferenceBug

   datatype push_mode =
      LetMono
    | LetForw
    | Normal

   fun pushSymbol (sym, span, useSets, pm, env) =
      (
      if SOME (SymbolTable.toInt sym)=debugSymbol then
         TextIO.print ("pushSymbol debug symbol:\n" ^ toString env) else ();
      case Scope.lookup (sym,env) of
          (SIMPLE) =>
           let
              val (k,env) = Scope.acquireKappa env
              val tt = Scope.getTypeTable env
              val _ = TT.addSymbol (k, VAR (TVar.freshTVar (), BD.freshBVar ()), tt)
              val _ = TT.equateSymbolsFlow (k,sym,tt)
              val env = Scope.wrap (KAPPA {kappa = k}, env)
           in
              env
           end
        | (COMPOUND {ty = isStable, width = w, uses, nested}) =>
         let
            val (k,env) = Scope.acquireKappa env
            val tt = Scope.getTypeTable env
            val _ = case pm of
               LetMono =>
               let
                  val _ = TT.addSymbol (k, VAR (TVar.freshTVar (), BD.freshBVar ()), tt)
                  val _ = TT.equateSymbolsFlow (k,sym,tt)
               in
                  ()
               end
             | _ =>
               let
                  val sharingSyms = TT.getSharingSyms (sym,tt)
                  val inScope = Scope.restrictToInScope (sym,sharingSyms,env)
                  val args = SymSet.difference (sharingSyms,inScope)
                  val _ = TT.instantiateSymbol (sym,args,k,tt)
                  (*val _ = if SOME (SymbolTable.toInt sym)=SOME 191 then
                     TextIO.print ("pushSymbol: instantiate " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ " to " ^ SymbolTable.getString(!SymbolTables.varTable, k) ^ ", sharing syms" ^ SymSet.foldl (fn (sym,str) => str ^ " " ^ SymbolTable.getString(!SymbolTables.varTable, sym)) "" sharingSyms ^ ", of which" ^ SymSet.foldl (fn (sym,str) => str ^ " " ^ SymbolTable.getString(!SymbolTables.varTable, sym)) "" inScope ^ " are in scope\n")
                        (*TextIO.print ("after instantiation:\n" ^ #1 (TT.toStringSI ([sym,k],[],tt,TVar.emptyShowInfo)) ^ "\n") else ()*)
                     else ()*)
               in
                  ()
               end
            (*we need to record the usage sites of all functions (primitives,
            really) that have explicit size constraints in order to be able
            to later generate error messages for ambiguous uses of these
            functions*)
            fun action kUsage (COMPOUND {ty, width, uses, nested},cons) =
               let
                  val uses = SpanMap.insert (uses, span, (kUsage, Scope.getCurFun env))
               in
                  (COMPOUND { ty = ty, width = width,
                              uses = uses, nested = nested}, cons)
               end
              | action kUsage _ = raise InferenceBug
            val recordUsage = case pm of LetForw => not isStable | _ => false
            val env =
               if recordUsage then
                  let
                     val (kUsage,env) = Scope.acquireUsageSymbol (sym,span,env)
                     val _ = TT.addSymbol (kUsage, VAR (TVar.freshTVar (), BD.freshBVar ()), tt)
                     val _ = TT.equateSymbols (k,kUsage,tt)
                  in
                     Scope.update (sym, action kUsage, env)
                  end
               else env
         in
            Scope.wrap (KAPPA {kappa = k}, env)
         end
      )
    
   fun acquireTempSymbol env = Scope.acquireKappa env
   fun releaseTempSymbol kEnv = Scope.releaseKappa kEnv

   fun getUsages (sym, env) =
      case Scope.lookup (sym, env) of
           (SIMPLE) => []
         | (COMPOUND {ty, width, uses = us, nested}) => SpanMap.listKeys us

   fun getContextOfUsage (sym, span, env) =
      case Scope.lookup (sym, env) of
           (SIMPLE) => raise InferenceBug
         | (COMPOUND {ty, width, uses = us, nested}) => 
           #2 (SpanMap.lookup (us, span))

   fun pushUsage (sym, span, env) =
      case Scope.lookup (sym, env) of
           (SIMPLE) => raise InferenceBug
         | (COMPOUND {ty, width, uses = us, nested}) =>
            let
               val (kUsage, fid) = SpanMap.lookup (us, span)
               val tt = Scope.getTypeTable env
               val (k,env) = Scope.acquireKappa env
               val _ = TT.addSymbol (k, VAR (TVar.freshTVar (), BD.freshBVar ()), tt)
               val _ = TT.equateSymbols (k, kUsage, tt)
            in
               Scope.wrap (KAPPA {kappa = k}, env)
            end

   fun getCtxt env = Scope.getCtxt env

   fun popToUsage (sym, span, env) =
         let
            val tt = Scope.getTypeTable env
            val (tUse,env) = case Scope.unwrap env of
                     (KAPPA {kappa}, env) => (TT.getSymbol (kappa,tt), Scope.releaseKappa (kappa,env))
                   | _ => raise InferenceBug
            val env = case Scope.lookup (sym, env) of
                  (COMPOUND {ty, width, uses = us, nested}) =>
                     (case SpanMap.find (us,span) of
                       NONE => raise InferenceBug
                     | SOME (kappaTy, fid) =>
                        (TT.delSymbol (kappaTy,tt);
                         TT.addSymbol (kappaTy,tUse,tt);
                        env)
                     )
                   | _ => raise InferenceBug
         in
            env
         end

   fun pushLambdaVar' (sym, env) =
      let
         val t = VAR (TVar.freshTVar (), BD.freshBVar ())
         val _ = TypeTable.addSymbol (sym, t, Scope.getTypeTable env)
      in
         (t, Scope.wrap (SINGLE {name = sym}, env))
      end

   fun pushLambdaVar (sym, env) =
      let
         val t = VAR (TVar.freshTVar (), BD.freshBVar ())
         val _ = TypeTable.addSymbol (sym, t, Scope.getTypeTable env)
      in
         Scope.wrap (SINGLE {name = sym}, env)
      end

   fun reduceToRecord (bns, env) =
      let
         val tt = Scope.getTypeTable env
         fun genFields (fs, [], env) = (case Scope.unwrap env of
                 (KAPPA {kappa = k}, env) =>
                  let
                     val ty = TT.getSymbol (k,tt)
                     val (tv,bv) = case ty of
                           VAR vars => vars
                         | _ => raise InferenceBug
                     val _ = TT.addSymbol (k, RECORD (tv, bv, fs), tt)
                  in
                     Scope.wrap (KAPPA {kappa = k}, env)
                  end
               | _ => raise InferenceBug
            )
           | genFields (fs, (bVar, fName) :: bns, env) =
               (case Scope.unwrap env of
                    (KAPPA {kappa = k}, env) =>
                        genFields (insertField (
                           RField { name = fName,
                                    fty = TT.getSymbol (k,tt),
                                    exists = bVar},
                           fs), bns, Scope.releaseKappa (k,env))
                  | _ => raise InferenceBug)
      in
         genFields ([], bns, env)
      end

   fun reduceToSum (n, env) =
      let
         val tt = Scope.getTypeTable env
         fun getKappa env = case Scope.unwrap env of
                    (KAPPA {kappa}, env) => (TT.getSymbol (kappa,tt),Scope.releaseKappa (kappa,env))
                  | _ => raise InferenceBug
         fun setKappa (ty,env) =
            let
               val (kappa,env) = Scope.acquireKappa env
               val _ = TT.addSymbol (kappa,ty,tt)
            in
               Scope.wrap (KAPPA {kappa=kappa}, env)
            end
         fun rTS (n, vars, const, env) = if n>0 then
               case getKappa env of
                    (CONST c, env) => rTS (n-1, vars, c+const, env)
                  | (VAR (v,_), env) => rTS (n-1, v::vars, const, env)
                  | _ => raise InferenceBug
            else case vars of
                 [] => setKappa (CONST const, env)
               | vs =>
                  let
                     val v = TVar.freshTVar ()
                     val scs = SC.fromList [SC.equality (v, vs, const)]
                     val env = meetSizeConstraint
                                 (fn scs' => SC.merge (scs,scs'), env)
                     (*val (scsStr,si) = SC.toStringSI (scs, NONE, TVar.emptyShowInfo)
                     val (eStr, si) = topToStringSI (env, si)
                     val _ = TextIO.print ("reduceToSum: " ^ scsStr ^ ", resulting in\n" ^ eStr ^ "\n")*)
                  in
                     setKappa (VAR (v, BD.freshBVar ()), env)
                  end
      in
         rTS (n, [], 0, env)
      end

   fun constToVec env =
      let
         val tt = Scope.getTypeTable env
         val (kappa,env) =  case Scope.unwrap env of
              (KAPPA {kappa}, env) => (kappa,env)
            | _ => raise InferenceBug
         val ty = TT.getSymbol (kappa,tt)
         val _ = TT.addSymbol (kappa,VEC ty,tt)
      in
        Scope.wrap (KAPPA {kappa=kappa}, env)
      end 

   fun expandArguments (env,nArgs) = if nArgs=0 then env else
      let
         val tt = Scope.getTypeTable env
         fun getArgs (tys,n,env) = if n=0 then (tys,env) else
            case Scope.unwrap env of
                 (KAPPA {kappa}, env) => getArgs (kappa :: tys,n-1,env)
               | (SINGLE {name}, env) => getArgs (name :: tys,n-1,env)
               | _ => raise InferenceBug
         val (tArgs,envTmp) = getArgs ([],nArgs,env)
         val (tFun, _) = case Scope.unwrap envTmp of
                             (KAPPA {kappa}, env) => (kappa,env)
                           | (SINGLE {name}, env) => (name,env)
                           | _ => raise InferenceBug
         val labels = TT.getSetLabels (tFun, tt)
         fun expandSym (tySym,[],env) =
               (TT.delSymbol (tySym,tt)
               ;TT.addSymbol (tySym,SET (VAR (TVar.freshTVar (),BD.freshBVar ()),[]),tt)
               ;env)
           | expandSym (tySym,(use :: uses),env) =
            let                                          
               fun addKappas ([], env) = ([], env)
                 | addKappas (use :: uses, env) =
                  let
                     val (useKappas,env) = addKappas (uses, env)
                     val (kappa,env) = Scope.acquireKappa env
                  in
                     ((use,kappa) :: useKappas, env)
                  end
               val (useKappas,env) = addKappas (uses,env)
               val _ = List.app (fn (_,kappa) => TT.instantiateSymbol (tySym,SymSet.empty,kappa,tt)) useKappas
               val useTypes = List.map (fn (use,kappa) => (use,TT.getSymbol (kappa,tt))) ((use,tySym) :: useKappas)
               val _ = TT.addSymbol (tySym, SET (VAR (TVar.freshTVar (),BD.freshBVar ()), useTypes),tt)
               val env = List.foldl (fn ((use,kappa),env) => Scope.releaseKappa (kappa,env)) env useKappas
            in
               env
            end
         fun instantiateArg (tySym,NONE,env) = env
           | instantiateArg (tySym,SOME labels,env) = expandSym (tySym,labels,env)
            
      in
         if List.null labels then env else
         if List.length labels=nArgs then
            ListPair.foldlEq instantiateArg env (tArgs, labels)
         else raise
            (UnificationFailure (Clash, "function is applied to incorrect number of arguments"))
      end

   fun reduceToFunction (env,nArgs) = if nArgs=0 then env else
      let
         val tt = Scope.getTypeTable env
         val (tRes, env) = case Scope.unwrap env of
                             (KAPPA {kappa}, env) => (kappa,Scope.releaseKappa (kappa,env))
                           | (SINGLE {name}, env) => (name,env)
                           | _ => raise InferenceBug
         fun getArgs (tys,n,env) = if n=0 then (tys,env) else
            case Scope.unwrap env of
                 (KAPPA {kappa}, env) => getArgs (kappa :: tys,n-1,Scope.releaseKappa (kappa,env))
               | (SINGLE {name}, env) => getArgs (name :: tys,n-1,env)
               | _ => raise InferenceBug
         val (tArgs,env) = getArgs ([],nArgs,env)
         val (k,env) = Scope.acquireKappa env
         val _ = TT.reduceToFunction (k, tArgs, tRes, tt)
      in
         Scope.wrap (KAPPA {kappa=k}, env)
      end

   fun reduceToResult env =
     case Scope.unwrap env of
           (KAPPA {kappa}, env) =>
            let
               val tt = Scope.getTypeTable env
               val ty = TT.getSymbol (kappa,tt)
               val (t1,t2) = case ty of
                     FUN (t1,t2) => (t1,t2)
                   | _ => raise InferenceBug
               val _ = TT.addSymbol (kappa,t2,tt)
               val tt = List.foldl TT.removeConstraints tt t1
            in
               Scope.wrap (KAPPA {kappa=kappa}, env)
            end
         | _ => raise InferenceBug

   fun reduceGuardToAction env =
      case Scope.unwrap env of
         (KAPPA {kappa}, env) =>
          let
             val tt = Scope.getTypeTable env
             val ty = TT.getSymbol (kappa,tt)
             val (inp, out) = case ty of
                   MONAD (VEC (CONST 1), inp, out) => (inp, out)
                 | _ => raise InferenceBug
             val _ = TT.addSymbol (kappa,MONAD (freshVar (), inp, out),tt)
          in
             Scope.wrap (KAPPA {kappa=kappa}, env)
          end
       | _ => raise InferenceBug
   
   fun return (n,env) =  
      let
         val (t, env) = Scope.unwrap env
         fun popN (n,env) = if n<=0 then env else
            let
               val (b, env) = Scope.unwrap env
               val tt = Scope.getTypeTable env
               val env = case b of
                  KAPPA {kappa} => (TT.delSymbol (kappa,tt); Scope.releaseKappa (kappa,env))
                | SINGLE {name} => (TT.delSymbol (name,tt); env)
                | _ => raise InferenceBug
            in
               popN (n-1, env)
            end
      in
         Scope.wrap (t, popN (n,env))
      end

   fun popKappa env =
      case Scope.unwrap env of
        (KAPPA {kappa}, env) =>
         let
            val tt = Scope.getTypeTable env
            val _ = TT.delSymbol (kappa,tt)
            val env = Scope.releaseKappa (kappa,env)
         in
            env
         end
      | _ => raise InferenceBug

   fun equateKappasGeneric (env,directed) =
      let
         fun getKappaTypes env =
            case Scope.unwrap env of
              (KAPPA {kappa=t1}, env) => (case Scope.unwrap env of
                 (KAPPA {kappa=t2}, env) => (t2,t1)
               | (SINGLE {name=t2}, env) => (t2,t1)
               | _ => raise InferenceBug) 
            | _ => raise InferenceBug

         (* generate flow between kappas *)
         val (t1,t2) = getKappaTypes env
         val tt = Scope.getTypeTable env
         val _ = (if directed then
               TT.equateSymbolsFlow (t1,t2,tt)
             else
               TT.equateSymbols (t1,t2,tt)
            ) handle (BD.Unsatisfiable bVar) =>
               flowError (bVar, NONE, env)
                   (*| (NotFound) =>
               (TextIO.print (#1 (TT.dumpTableSI (tt,TVar.emptyShowInfo))); raise InferenceBug)*)
      in
         env
      end

   fun equateKappas env = equateKappasGeneric (env,false) 
   fun equateKappasFlow env = equateKappasGeneric (env,true)

   fun flipKappas env =
         case Scope.unwrap env of
              (KAPPA {kappa=t1}, env) => (case Scope.unwrap env of
                 (KAPPA {kappa=t2}, env) => Scope.wrap (KAPPA {kappa=t2},Scope.wrap (KAPPA {kappa=t1},env))
               | _ => raise InferenceBug) 
            | _ => raise InferenceBug

   fun subsetKappas env =
      let
         fun getKappaTypes env =
            case Scope.unwrap env of
              (KAPPA {kappa=t2}, env) => (case Scope.unwrap env of
                 (KAPPA {kappa=t1}, env) => (t1,t2)
               | (SINGLE {name=t1}, env) => (t1,t2)
               | _ => raise InferenceBug) 
            | _ => raise InferenceBug

         val (k1,k2) = getKappaTypes env
         val tt = Scope.getTypeTable env
         val substs = TT.subsetSymbols (k1,k2,tt)

         (*val t1 = TT.peekSymbol (k1,tt)
         val t2 = TT.peekSymbol (k2,tt)
         val (t1Str,si) = showTypeSI (t1,TVar.emptyShowInfo)
         val (t2Str,si) = showTypeSI (t2,si)
         val (sStr,si) = foldl (fn ((v,ty),(sStr,si)) =>
               let
                  val (vStr,si) = TVar.varToString (v,si)
                  val (tyStr,si) = showTypeSI (ty,si)
               in
                  ("[" ^ vStr ^ " / " ^ tyStr ^ "]" ^ sStr, si)
               end
             ) ("", si) substs
         val _ = TextIO.print ("subsetKappas: " ^ t1Str ^ " <= " ^ t2Str ^ " gives " ^ sStr ^ "\n")*)
      in
         substs
      end

   fun popToFunction (sym, env) = 
      let
         fun setType kappa (COMPOUND {ty, width, uses, nested}, cons) =
            let
               val tt = Scope.getTypeTable env
               val _ = TypeTable.delSymbol (sym,tt)
               val ty = TypeTable.getSymbol (kappa,tt)
               val _ = TypeTable.addSymbol (sym, ty, tt)
            in
               (COMPOUND {ty = false, width = width, uses = uses, nested = nested},
                cons)
            end
           | setType kappa _ = (TextIO.print ("popToFunction " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ ":\n" ^ toString env); raise InferenceBug)
      in
         case Scope.unwrap env of
              (KAPPA {kappa}, env) => Scope.update (sym, setType kappa, Scope.releaseKappa (kappa,env))
            | _ => raise InferenceBug
      end

   fun enterFunction (sym, env) = 
      Scope.setCtxt (sym :: Scope.getCtxt env) env

   fun leaveFunction (sym, env) = 
      case Scope.getCtxt env of
           (fid :: fids) =>
            if SymbolTable.eq_symid(fid,sym) then Scope.setCtxt fids env
            else raise InferenceBug
         | [] => raise InferenceBug

   fun inScope (sym,([],_)) = false
     | inScope (sym,env) =
      case Scope.unwrap env of
        (GROUP bs,env) =>
         if List.exists (fn {name, ty, width, uses, nested} =>
                           SymbolTable.eq_symid (sym,name)) bs then true
         else inScope (sym,env)
      | (_,env) => inScope (sym,env)

   fun pushNested (sym, env) =
      if inScope (sym,env) then (0,env) else
      let
         val (sc,_) = Scope.unwrap env
         fun findSymInGroups (n, ns, env) =
            List.foldl
               (fn (g,res) => case res of
                    SOME r => SOME r
                  | NONE => findSymInGroup (n+1,g,Scope.wrap (g, env))
               ) NONE ns
         and findSymInGroup (n,GROUP bs,env) =
            (case List.find (fn {name, ty, width, uses, nested} =>
                              SymbolTable.eq_symid (sym,name)) bs of
               SOME {name, ty, width, uses, nested} =>
                  SOME (n, env)
             | NONE =>
               List.foldl (fn ({name, ty, width, uses, nested=ns},res) =>
                  case res of
                     SOME r => SOME r
                   | NONE => findSymInGroups (n, ns, env)
               ) NONE bs
            )
           | findSymInGroup (n,_,env) = raise InferenceBug
      in
         case findSymInGroup (0, sc, env) of
              NONE => (0,env)
            | SOME r => r
      end

   fun popNested (n, env) = if n<=0 then env else
      case Scope.unwrap env of
        (GROUP bs, env) => (case Scope.unwrap env of
             (GROUP bsPrev, env) =>
               let
                  fun replGroup (GROUP bs' :: gs) =
                     if List.all (fn (b,b') =>
                           SymbolTable.eq_symid (#name b, #name b'))
                        (ListPair.zip (bs,bs'))
                     then GROUP bs :: gs else GROUP bs' :: replGroup gs
                    | replGroup [] = []
                    | replGroup _ = raise InferenceBug
                  
                  fun replBs ({name, ty, width, uses, nested}) =
                     {name = name, ty = ty, width = width,
                      uses = uses, nested = replGroup nested}
                  val bsPrev = List.map replBs bsPrev
                  val env = Scope.wrap (GROUP bsPrev,env)
               in
                  popNested (n-1,env)
               end
            | _ => raise InferenceBug
          )
      | (_, env) => raise InferenceBug


   fun markAsStable (sym, env) =
      let
         val tt = Scope.getTypeTable env
         fun markNested {name,ty,width,uses,nested} =
            {name=name,ty=true,width=width,uses=uses,nested=map markBinding nested}
         and markBinding (GROUP bs) = GROUP (map markNested bs)
           | markBinding other = other 
         
         fun setStable (COMPOUND {ty, width, uses, nested}, cons) =
               (COMPOUND {ty = true, width = width, uses = uses, nested = map markBinding nested}, cons)
           | setStable _ = (TextIO.print ("markAsStable " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ ":\n" ^ toString env); raise InferenceBug)
      in
         Scope.update (sym, setStable, env)
      end                                                         

   fun clearUses (sym, env) =
      let
         (*val _ = if List.null scsBad then () else
            raise S.UnificationFailure (S.Clash,
                        "ambiguous vectors size " ^ #1 (SC.toStringSI (!scRef,SOME (!unusedTVars),TVar.emptyShowInfo)) ^ 
                        " when removing " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ " : " ^ "\n")*)
         val tt = Scope.getTypeTable env
         fun killNested {name,ty,width,uses,nested} =
            (TT.delSymbol (name,tt);
             SpanMap.app (fn (kappa,ctxt) => (TT.delSymbol (kappa,tt); ())) uses;
             List.app killBinding nested
            )
         and killBinding (GROUP bs) = List.app killNested bs
           | killBinding other = raise InferenceBug
         
         fun setStable (COMPOUND {ty, width, uses, nested}, cons) =
            (SpanMap.app (fn (kappa,ctxt) => (TT.delSymbol (kappa,tt); ())) uses;
             List.app killBinding nested;
             (COMPOUND {ty=true,width=width,uses=SpanMap.empty,nested=[]}, cons)
            )
           | setStable _ = (TextIO.print ("markAsStable " ^ SymbolTable.getString(!SymbolTables.varTable, sym) ^ ":\n" ^ toString env); raise InferenceBug)
      in
         Scope.update (sym, setStable, env)
      end                                                         
   
   fun finalize _ = ()
   
end
