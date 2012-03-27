
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
       constructors: (sym * ty option) SymMap.map,
       declarations: 'a}

   fun get s (IN t) = s t
   fun upd f (IN t) =
      IN {granularity= #granularity t,
          exports= #exports t,
          state= #state t,
          typealias= #typealias t,
          datatypes= #datatypes t,
          constructors= #constructors t,
          declarations= f (#declarations t)}

   structure PP = struct
      open Layout Pretty
      val dots = str ".."
      val is = seq [space, str "=", space]
      fun spec pA t =
         align
            [seq [str "granularity", is, int (get#granularity t)],
             seq [str "export", is, dots],
             seq [str "state", is, dots],
             seq [str "typealiases", is, dots],
             seq [str "datatypes", is, dots],
             seq [str "constructors", is, dots],
             seq [str "declarations", is],
             pA (get#declarations t)]

      fun anySpec t = spec (fn _ => dots) t
   end
end
