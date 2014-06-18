structure EnvironmentProfiling : sig
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
   algoebraic data type, generate implications from the arguments of the
   algebraic data type to the argument of this function. *)
   val genConstructorFlow : (bool * environment) -> environment
   
   type push_mode = Environment.push_mode

    (*given an occurrence of a symbol at a position, push its type onto the
    stack*)
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
   
   (*stack: [...,t1,t2,...,tn] -> [...,(t1, ... t n-1) -> tn]*)
   val reduceToFunction : environment * int -> environment
   
   (*stack: [...,t1 -> t2] -> [...t2]*)
   val reduceToResult : environment -> environment

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

   val forceNoInputs : VarInfo.symid * VarInfo.symid list *
                     environment -> VarInfo.symid list

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
   structure Profile = MLton.Profile
   structure E = Environment
   structure SpanMap = SpanMap
   
   type environment = E.environment
   
   fun wrap (f, d) x =
      Profile.withData (d, fn () => f x)
   
   val otherData = Profile.Data.malloc ()
   val equateData = Profile.Data.malloc ()
   val gcData = Profile.Data.malloc ()
   val reduceData = Profile.Data.malloc ()
   val pushData = Profile.Data.malloc ()
   val popData = Profile.Data.malloc ()
   val stringData = Profile.Data.malloc ()
   
   fun finalize _ =
      let
         fun dump (d,f) = (Profile.Data.write (d,"prof-" ^ f ^ ".out"); Profile.Data.free d)
         val _ = List.app dump [
            (otherData,"other"),
            (equateData,"equate"),
            (gcData,"gc"),
            (reduceData,"reduce"),
            (pushData,"push"),
            (popData,"pop"),
            (stringData,"string")
            ]
      in
         ()
      end
   
   val primitiveEnvironment = wrap (E.primitiveEnvironment, otherData)
   val pushGroup = wrap (E.pushGroup, pushData)
   val popGroup = wrap (E.popGroup, popData)
   val getGroupSyms = wrap (E.getGroupSyms, otherData)
   val pushTop = wrap (E.pushTop, pushData)
   val pushType = wrap (E.pushType, pushData)
   val pushWidth = wrap (E.pushWidth, pushData)
   val genConstructorFlow = wrap (E.genConstructorFlow, otherData)
   type push_mode = Environment.push_mode
   val pushSymbol = wrap (E.pushSymbol, pushData)
   val pushNested = wrap (E.pushNested, pushData)
   val popNested = wrap (E.popNested, popData)
   val acquireTempSymbol = wrap (E.acquireTempSymbol, otherData)
   val releaseTempSymbol = wrap (E.releaseTempSymbol, otherData)
   val getUsages = wrap (E.getUsages, otherData)
   val getContextOfUsage = wrap (E.getContextOfUsage, otherData)
   val getCtxt = wrap (E.getCtxt, otherData)
   val popToUsage = wrap (E.popToUsage, popData)
   val pushUsage = wrap (E.pushUsage, otherData)
   val pushLambdaVar' = wrap (E.pushLambdaVar', otherData)
   val pushLambdaVar = wrap (E.pushLambdaVar, otherData)
   val reduceToRecord = wrap (E.reduceToRecord, reduceData)
   val reduceToSum = wrap (E.reduceToSum, reduceData)
   val reduceToFunction = wrap (E.reduceToFunction, reduceData)
   val reduceToResult = wrap (E.reduceToResult, reduceData)
   val return = wrap (E.return, otherData)
   val popKappa = wrap (E.popKappa, popData)
   val equateKappas = wrap (E.equateKappas, equateData)
   val equateKappasFlow  = wrap (E.equateKappasFlow, equateData)
   val flipKappas = wrap (E.flipKappas, otherData)
   val subsetKappas = wrap (E.subsetKappas, otherData)
   val popToFunction = wrap (E.popToFunction, otherData)
   val enterFunction = wrap (E.enterFunction, otherData)
   val leaveFunction = wrap (E.leaveFunction, otherData)
   val markAsStable = wrap (E.markAsStable, otherData)
   val clearUses = wrap (E.clearUses, otherData)
   val forceNoInputs = wrap (E.forceNoInputs, otherData)
   val meetBoolean = wrap (E.meetBoolean, otherData)
   val reduceFlow = wrap (E.reduceFlow, otherData)
   val cleanEnvironment = wrap (E.cleanEnvironment, otherData)
   val meetSizeConstraint = wrap (E.meetSizeConstraint, otherData)
   val affectedFunctions = wrap (E.affectedFunctions, otherData)
   val garbageCollect = wrap (E.garbageCollect, gcData)
   val dumpTypeTableSI = wrap (E.dumpTypeTableSI, equateData)
   val toString = wrap (E.toString, equateData)
   val toStringSI = wrap (E.toStringSI, equateData)
   val topToString = wrap (E.topToString, equateData)
   val topToStringSI = wrap (E.topToStringSI, equateData)
   val kappaToString = wrap (E.kappaToString, equateData)
   val kappaToStringSI = wrap (E.kappaToStringSI, equateData)
   val funTypeToStringSI = wrap (E.funTypeToStringSI, equateData)
   
end