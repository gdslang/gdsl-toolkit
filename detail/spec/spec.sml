
structure Spec = struct
   type sym = SymbolTable.symid
   type exp = SpecAbstractTree.exp
   type ty = SpecAbstractTree.ty
   datatype 'a t = IN of
      {granularity: IntInf.int,
       state: (sym * ty * exp) list,
       typealias: (sym * ty) list,
       datatypes: (sym * (sym * ty option) list) list,
       declarations: 'a}

   fun get s (IN t) = s t
   fun upd f (IN t) =
      IN {granularity= #granularity t,
          state= #state t,
          typealias= #typealias t,
          datatypes= #datatypes t,
          declarations= f (#declarations t)}

   structure PP = struct
      open Layout Pretty
      val dots = str "<..>"
      fun t pA t =
         record
            [("granularity", int (get#granularity t)),
             ("state", dots),
             ("typealias", dots),
             ("datatypes", dots),
             ("declarations", pA (get#declarations t))]
         
      fun prettyTo pA (os, spec) = Pretty.prettyTo (os, t pA spec) 
      fun prettyDecls (values, decodes) = let
         open Layout Pretty
         val vs = list (map SpecAbstractTree.PP.valuedecl values)
         val ds = list (map SpecAbstractTree.PP.decodedecl decodes)
      in
         list [vs, ds]
      end
   end
end
