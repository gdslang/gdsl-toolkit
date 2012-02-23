structure Environment : sig
   type environment
   
   val primitiveEnvironment : (SymbolTable.symid * Types.texp) list -> environment
   
   val pushMono : SymbolTable.symid * Types.texp * environment -> environment
   val pushPoly : SymbolTable.symid list * environment -> environment
   (*val pushKappa : Types.texp * environment -> environment
   val popBinding : environment -> environment
   val popKappa : environment -> (Types.texp * environment)
   val pushId : SymbolTable.symid * environment -> environment
   
   val applyToAllTypes : (Types.texp -> Types.texp * environment) -> environment*)
   
end = struct
   structure ST = SymbolTable
   structure BD = BooleanDomain
   open Types

   exception InferenceBug

   datatype binding
      = KAPPA of {
         ty : texp
      } | MONO of {
         name : ST.symid,
         ty : texp
      } | POLY of {
         name : ST.symid,
         ty : texp option,
         refs : (ST.symid * Error.span * texp) list
      } list
   
   type scope = {
      bindInfo : binding,
      typeVars : TVar.set
   }

   type environment = scope list * BD.bfun

   fun primitiveEnvironment l = ([{
      bindInfo = POLY (List.map (fn (s,t) => {name = s, ty = SOME t, refs = []}) l),
      typeVars = List.foldl texpVarset TVar.empty (List.map (fn (s,t) => t) l)
   }], BD.empty)
      
   fun pushMono (sym, t, (scs, bFun)) = case scs of
         [] => raise InferenceBug
       | ((sc as {bindInfo = _, typeVars = tv}) :: scs) =>
         ({ bindInfo = MONO {name = sym, ty = t},
            typeVars = texpVarset (t,tv)
         } :: sc :: scs, bFun)
   fun pushPoly (syms, (scs, bFun)) = case scs of
         [] => raise InferenceBug
       | ((sc as {bindInfo = _, typeVars = tv}) :: scs) =>
         ({ bindInfo = POLY (List.map (fn s => {name = s, ty = NONE, refs = []}) syms),
            typeVars = tv
         } :: (sc :: scs), bFun)

   (*val pushKappa t bs = KAPPA {ty = t} :: bs
   val popBinding (b :: bs) = bs
     | popBinding [] = raise InferenceBug
   val popKappa (KAPPA {ty = t} :: bs) = (t, bs)
     | popKappa [] = raise InferenceBug

   val pushId (sym, bs) = raise InferenceBug

   val applyToAllTypes (): (Types.texp -> Types.texp, bindings) -> bindings*)
end