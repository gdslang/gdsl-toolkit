
structure Spec = struct
   type sym = SymbolTable.symid
   type exp = SpecAbstractTree.exp
   type ty = SpecAbstractTree.ty
   datatype 'a t = IN of
      {granularity: IntInf.int,
       exports: sym list,
       state: (sym * ty * exp) list,
       typealias: (sym * ty) list,
       datatypes: (sym * (sym * ty option) list) list,
       declarations: 'a}

   fun get s (IN t) = s t
   fun upd f (IN t) =
      IN {granularity= #granularity t,
          exports= #exports t,
          state= #state t,
          typealias= #typealias t,
          datatypes= #datatypes t,
          declarations= f (#declarations t)}

   structure PP = struct
      open Layout Pretty
      val dots = str "<..>"
      fun spec pA t =
         record
            [("granularity", int (get#granularity t)),
             ("exports", dots),
             ("state", dots),
             ("typealias", dots),
             ("datatypes", dots),
             ("declarations", pA (get#declarations t))]
      fun anySpec t = spec (fn _ => dots) t
   end
end
