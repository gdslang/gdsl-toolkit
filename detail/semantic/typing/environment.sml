structure Environment : sig
   type environment
   
   val primitiveEnvironment : (SymbolTable.symid * Types.texp *
                               (Types.texp option)) list -> environment
   
   val pushSingle : VarInfo.symid * Types.texp * environment -> environment
   
   (*add a group of bindings to the current environment, each element in a
   binding is identified by its symbol, the flag is true if the symbol
   is a decoder function*)
   val pushGroup : (VarInfo.symid * bool) list * environment ->
                  environment
   val pushTop : environment -> environment
   val pushRecord : FieldInfo.symid list * environment -> environment
   val pushSymbol : VarInfo.symid * Error.span * environment -> environment
   
   val popToFunction : VarInfo.symid * environment -> bool * environment
   
   (*val reduceFunction : envionrment -> environment*)
   
   val meet : environment * environment -> environment
   
   (*val pushKappa : Types.texp * environment -> environment
   val popBinding : environment -> environment
   val popKappa : environment -> (Types.texp * environment)
   val pushId : SymbolTable.symid * environment -> environment
   
   val applyToAllTypes : (Types.texp -> Types.texp * environment) -> environment*)
   
end = struct
   structure ST = SymbolTable
   structure BD = BooleanDomain
   open Types

   (*any error that is not due to unification*)
   exception InferenceBug

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
         uses : (Error.span * texp) list
      } list
   
   type scope = {
      bindInfo : binding,
      typeVars : TVar.set
   }

   
   type environment = scope list * BD.bfun

   fun primitiveEnvironment l = ([{
      bindInfo = GROUP (List.map (fn (s,t,ow) => {name = s, ty = SOME t,
                                                  width = ow, uses = []}) l),
      typeVars = TVar.union
         (List.foldl (fn ((s,t,ow), set) => texpVarset (t,set)) TVar.empty l
         ,List.foldl (fn ((s,t,ow), set) => case ow of
              SOME w => texpVarset (w,set)
            | NONE => set) TVar.empty l
         )
   }], BD.empty)
   
   fun prevTVars [] = raise InferenceBug
     | prevTVars ({bindInfo = _, typeVars = tv}::_) = tv

   fun pushSingle (sym, t, (scs, bFun)) =
         ({ bindInfo = SINGLE {name = sym, ty = t},
           typeVars = texpVarset (t,prevTVars scs)} :: scs, bFun)

   structure SISet = RedBlackSetFn (
      struct
         type ord_key = SymbolTable.symid
         val compare = SymbolTable.compare_symid
      end)           
   fun pushGroup (syms, (scs, bFun)) = 
      let
         val (funs, nonFuns) = List.partition (fn (s,dec) => not dec) syms
         val funDefs = List.map
            (fn (s,_) => {name = s, ty = NONE, width = NONE, uses = []}) funs
         val nonFunSyms =
            SISet.listItems (SISet.fromList (List.map (fn (s,_) => s) funs))
         val nonFunDefs = List.map
            (fn s => {name = s, ty = NONE, width =
              SOME (VAR (TVar.freshTVar (), BD.freshBVar ())),
              uses = []}) nonFunSyms
         val tvs = TVar.fromList
            (List.map (fn {width = w, ...} => case w of
               SOME (VAR (v,_)) => v
             | _ => raise InferenceBug) nonFunDefs)
      in                                                                    
         ({bindInfo = GROUP (funDefs @ nonFunDefs),
           typeVars = TVar.union (tvs,prevTVars scs)} :: scs, bFun)
      end                                    

   fun pushTop (scs, bFun) = case scs of
        [] => raise InferenceBug
      | {bindInfo = _, typeVars = tv} :: _ =>
      let
         val a = TVar.freshTVar ()
         val b = BD.freshBVar ()
      in
         ({bindInfo = KAPPA {ty = VAR (a,b)}, typeVars = TVar.add(a,tv)} :: scs,
         bFun)
      end
   fun pushRecord (fs, (scs, bFun)) = case scs of
        [] => raise InferenceBug
      | {bindInfo = _, typeVars = tv} :: _ =>
      let
         val m = TVar.freshTVar ()
         val tv = TVar.add (m,tv)
         fun genFields (out, [], bFun) = (out, bFun)
           | genFields (out, fid :: fids, bFun) =
            let
               val a = TVar.freshTVar ()
               val b = BD.freshBVar ()
               val b' = BD.freshBVar ()
               val newField = RField { name = fid, fty = VAR (a,b'), exists = b}
               val bFun = BD.meetVarEqualsConst (bFun, b, true)
               fun addField [] = [newField]
                 | addField (f :: fd) = (case compare_rfield (newField, f) of
                      EQUAL => raise InferenceBug
                    | LESS => newField :: f :: fd
                    | GREATER => f :: addField fd)
            in
               genFields (addField out, fids, bFun)
            end
         val b = BD.freshBVar ()
         val (fields, bFun) = genFields ([], fs, bFun)
      in
         ({bindInfo = KAPPA {ty = RECORD (m, b, fields)}, typeVars = tv} :: scs,
         bFun)
      end

   exception LookupNeedsToAddUse

   fun eq_span ((p1s,p1e), (p2s,p2e)) =
    Position.toInt p1s=Position.toInt p2s andalso
    Position.toInt p1e=Position.toInt p2e

   fun pushSymbol (sym, span, (scs, bFun)) =
      let
         fun lookup [] = raise InferenceBug
           | lookup ({bindInfo = KAPPA _, typeVars =_}::scs) = lookup scs
           | lookup ({bindInfo = SINGLE {name, ty}, typeVars =_}::scs) =
              if ST.eq_symid (sym,name) then ty else lookup scs
           | lookup ({bindInfo = GROUP bs, typeVars =_}::scs) =
               let fun lG [] = lookup scs
                     | lG ({name, ty, width=_, uses}::bs) =
                        if ST.eq_symid (sym,name) then
                           case ty of SOME ty => ty
                                    | NONE => raise LookupNeedsToAddUse
                        else lG bs
               in
                  lG bs
               end
         val (scs, sType) = (scs, lookup scs) handle LookupNeedsToAddUse =>
            let
               val var = TVar.freshTVar ()
               val b = BD.freshBVar ()
               val res = VAR (var,b)
               fun fixUses [] = raise InferenceBug
                 | fixUses ((b as {name = n, ty = t, width = w, uses = us})::bs) =
                     if ST.eq_symid (sym,n) then
                        {name = n, ty = t, width = w, uses = (span,res)::us }::bs
                     else b::fixUses bs
               fun rebuild [] = raise InferenceBug
                 | rebuild ({bindInfo = GROUP bs, typeVars = tv}::scs) =
                     if List.exists (fn {name,...} => ST.eq_symid (sym,name)) bs
                     then {bindInfo = GROUP (fixUses bs),
                           typeVars = TVar.add(var,tv)}::scs
                     else {bindInfo = GROUP bs,
                           typeVars = TVar.add(var,tv)}::rebuild scs
                 | rebuild ({bindInfo = other, typeVars = tv}::scs) =
                     {bindInfo = other,
                      typeVars = TVar.add(var,tv)}::rebuild scs
            in
               (rebuild scs, res)
            end
      in 
         ({bindInfo = KAPPA {ty = sType}, typeVars = prevTVars scs} :: scs, bFun)
      end

   fun popToFunction (sym, (scs, bFun)) =
      let
         val (scs, bs, t) = (case scs of
              ({bindInfo = KAPPA {ty =t}, typeVars=_} ::
               (scs as {bindInfo = GROUP bs, typeVars} :: _)) => (scs, bs, t)
            | _ => raise InferenceBug)
         val typeOpt = 
            case List.filter (fn {name,...} => ST.eq_symid (sym,name)) bs of
                 [{name, ty, width, uses}] => ty
               | _ => raise InferenceBug
      in
         (true, (scs, bFun))
      end

   fun meet ((scs1, bFun1), (scs2, bFun2)) = (scs2, bFun2)

   (*val pushKappa t bs = KAPPA {ty = t} :: bs
   val popBinding (b :: bs) = bs
     | popBinding [] = raise InferenceBug
   val popKappa (KAPPA {ty = t} :: bs) = (t, bs)
     | popKappa [] = raise InferenceBug

   val pushId (sym, bs) = raise InferenceBug

   val applyToAllTypes (): (Types.texp -> Types.texp, bindings) -> bindings*)
end