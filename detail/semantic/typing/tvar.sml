structure TVar : sig

   (*creation of type variables*)
   type tvar
   val freshTVar : unit -> tvar

   val eq : (tvar * tvar) -> bool

   (*displaying type variables*)
   type varmap
   val emptyShowInfo : varmap
   val varToString : (tvar * varmap) -> (string * varmap)

   (*sets of type variables*)
   type set

   val empty : set
   val singleton : tvar -> set
   val fromList : tvar list -> set
   val add : (tvar * set) -> set
   val union : (set * set) -> set
   val intersection : (set * set) -> set
   val difference : (set * set) -> set
   val isEmpty : set -> bool

end = struct

   datatype tvar = TVAR of int

   fun eq (TVAR v1, TVAR v2) = v1=v2

   val tvarGenerator = ref 0

   fun freshTVar () = let
     val v = !tvarGenerator
   in
     (tvarGenerator := v+1; TVAR v)
   end

   structure VarMap = IntRedBlackMap
   type varmap = string VarMap.map
   val emptyShowInfo = VarMap.empty
   fun name idx = (if idx>25 then name (Int.div (idx,26)-1) else "") ^
        Char.toString (Char.chr (Char.ord #"a"+Int.mod (idx,26)))

   fun varToString (TVAR var, tab) = case VarMap.find (tab, var) of
          SOME str => (str, tab)
        | NONE => let
             val str = name (VarMap.numItems(tab))
          in
             (str, VarMap.insert(tab, var, str))
          end

   type set = IntListSet.set

   val empty = IntListSet.empty
   fun singleton (TVAR v) = IntListSet.singleton v
   fun fromList l = IntListSet.fromList (List.map (fn (TVAR v) => v) l)
   fun add (TVAR v, l) = IntListSet.add' (v, l)
   val union = IntListSet.union
   val intersection = IntListSet.intersection
   val difference = IntListSet.difference
   val isEmpty = IntListSet.isEmpty
end
