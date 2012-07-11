structure TVar : sig

   (*creation of type variables*)
   type tvar
   val freshTVar : unit -> tvar

   val eq : (tvar * tvar) -> bool
   val compare : tvar * tvar -> order

   (*displaying type variables*)
   type varmap
   val emptyShowInfo : varmap
   val varToString : (tvar * varmap) -> (string * varmap)

   (*sets of type variables*)
   type set

   val empty : set
   val singleton : tvar -> set
   val fromList : tvar list -> set
   val listItems : set -> tvar list
   val add : tvar * set -> set
   val union : set * set -> set
   val intersection : set * set -> set
   val difference : set * set -> set
   val member : set * tvar -> bool
   val isEmpty : set -> bool
   val setToString : set * varmap -> (string * varmap)

end = struct

   datatype tvar = TVAR of int

   fun eq (TVAR v1, TVAR v2) = v1=v2
   fun compare (TVAR v1, TVAR v2) = Int.compare (v1,v2)

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

   fun varToString (TVAR var, tab) = (*(name var, tab)*) case VarMap.find (tab, var) of
                                        SOME str => (str, tab)
                                      | NONE => let
                                           val str = name (VarMap.numItems(tab))
                                        in
                                           (str, VarMap.insert(tab, var, str))
                                        end

   structure IntSet = SplaySetFn(struct
      type ord_key = int
      val compare = Int.compare
   end)           

   type set = IntSet.set

   val empty = IntSet.empty
   fun singleton (TVAR v) = IntSet.singleton v
   fun fromList l = IntSet.fromList (List.map (fn (TVAR v) => v) l)
   fun listItems vs = List.map (fn v => (TVAR v)) (IntSet.listItems vs)
   fun add (TVAR v, l) = IntSet.add' (v, l)
   val union = IntSet.union
   val intersection = IntSet.intersection
   val difference = IntSet.difference
   fun member (l,TVAR v) = IntSet.member (l,v)
   val isEmpty = IntSet.isEmpty
   fun setToString (set, si) =
      let
         fun show (v, (str, sep, si)) =
            let
               val (vStr, si) = varToString (TVAR v,si)
            in
               (str ^ sep ^ vStr, ", ", si)
            end
         val (res, _, si) =
            List.foldl show ("", "{", si) (IntSet.listItems set)
      in
         (res  ^ "}", si)
      end                               
end
