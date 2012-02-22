structure TypeInference : sig
   type bindings
   
   val empty : bindings
   
   val pushMono : SymbolTable.symid * Types.texp * bindings -> bindings
   val pushPoly : SymbolTable.symid list * bindings -> bindings
   val pushKappa : Types.texp * bindings -> bindings
   val popBinding : bindings -> bindings
   val popKappa : bindings -> (Types.texp, bindings)
   val pushId : SymbolTable.symid * bindings -> bindings
   
   val applyToAllTypes : (Types.texp -> Types.texp, bindings) -> bindings
   
end = struct
   structure ST = SymbolTable
   structure BD = BooleanDomain
   open Types

   exception InferenceBug
   
   type bindings = ((scope * varset) list * BD.bfun)

   val empty = ([] * BD.empty)
   datatype scope
      = KAPPA of {
         ty : texp
      } | MONO of {
         name : ST.symid,
         ty : texp
      } | POLY of {
         name : ST.symid,
         ty : texp option,
         refs : (ST.symid * texp)
      } list
   
   val pushMono sym t ((sc, vs) :: bs) = (MONO {name = sym, ty = t}, vs) :: (sc, vs) :: bs
   val pushPoly syms bs =
      POLY (List.map (fn s => {name = n, ty = NONE, refs = []}) syms) :: bs
   val pushKappa t bs = KAPPA {ty = t} :: bs
   val popBinding (b :: bs) = bs
     | popBinding [] = raise InferenceBug
   val popKappa (KAPPA {ty = t} :: bs) = (t, bs)
     | popKappa [] = raise InferenceBug

   val pushId (sym, bs) = raise InferenceBug

   val applyToAllTypes (): (Types.texp -> Types.texp, bindings) -> bindings
end