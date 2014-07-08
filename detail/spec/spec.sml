
structure Spec = struct
   type sym = SymbolTable.symid
   type exp = SpecAbstractTree.exp
   type ty = SpecAbstractTree.ty

   datatype 'a t = IN of
      {exports: (sym list * ty) SymMap.map,
       typealias: (sym * ty) list,
       datatypes: (sym * (sym * ty option) list) list,
       constructors: (sym * ty option) SymMap.map,
       declarations: 'a}

   fun get s (IN t) = s t
   fun upd f (IN t) =
      IN {exports= #exports t,
          typealias= #typealias t,
          datatypes= #datatypes t,
          constructors= #constructors t,
          declarations= f (#declarations t)}

   structure PP = struct
      open Layout Pretty
      val dots = str ".."
      fun i x = str (Int.toString x)
      val is = seq [space, str "=", space]
      fun spec pA t =
         align
            [seq [str "export: ", is, i (SymMap.numItems (get #exports t))],
             seq [str "typealiases: ", is, i (length (get #typealias t))],
             seq [str "datatypes: ", is, i (length (get #datatypes t))],
             seq [str "constructors: ", is, i (SymMap.numItems (get #constructors t))],
             seq [str "declarations", is],
             pA (get#declarations t)]

      fun anySpec t = spec (fn _ => dots) t
   end
end
