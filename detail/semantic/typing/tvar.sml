structure TVar : sig

   (*creation of type variables*)
   type tvar
   val freshTVar : unit -> tvar

   val eq : (tvar * tvar) -> bool
   val compare : tvar * tvar -> order

   val hash : tvar -> word
   val toIdx : tvar -> int
   val fromIdx : int -> tvar
   val set : Word.word -> unit
   val get : unit -> Word.word
   
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
   val del : tvar * set -> set
   val union : set * set -> set
   val intersection : set * set -> set
   val difference : set * set -> set
   val member : set * tvar -> bool
   val isEmpty : set -> bool
   val app : (tvar -> unit) -> set -> unit
   val setToString : set * varmap -> (string * varmap)

end = struct

   val explicitPrint : bool = true
   
   datatype tvar = TVAR of int

   fun eq (TVAR v1, TVAR v2) = v1=v2
   fun compare (TVAR v1, TVAR v2) = Int.compare (v1,v2)

   fun hash (TVAR v) = Word.fromInt v
   fun toIdx (TVAR v) = v
   fun fromIdx v = (TVAR v)

   val tvarGenerator = ref (Word.fromInt 0)
   fun get () = !tvarGenerator
   fun set n = (tvarGenerator := n; ())

   fun freshTVar () = let
     val v = !tvarGenerator
   in
     (tvarGenerator := v + Word.fromInt 1; TVAR (Word.toIntX v))
   end

   structure VarMap = IntRedBlackMap
   type varmap = string VarMap.map
   val emptyShowInfo = VarMap.empty
   fun name idx = (if idx>25 then name (Int.div (idx,26)-1) else "") ^
        Char.toString (Char.chr (Char.ord #"a"+Int.mod (idx,26)))

   fun varToString (TVAR var, tab) =
      if explicitPrint then
         (name var, tab)
      else case VarMap.find (tab, var) of
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
   fun del (TVAR v, l) = if IntSet.member (l,v) then IntSet.delete (l, v) else l
   val union = IntSet.union
   val intersection = IntSet.intersection
   val difference = IntSet.difference
   fun member (l,TVAR v) = IntSet.member (l,v)
   val isEmpty = IntSet.isEmpty
   fun app f = IntSet.app (fn v => f (TVAR v))
   fun setToString (set, si) =
      let
         fun show (v, (str, sep, si)) =
            let
               val (vStr, si) = varToString (TVAR v,si)
            in
               (str ^ sep ^ vStr, ", ", si)
            end
         val (res, _, si) =
            List.foldl show ("", "", si) (IntSet.listItems set)
      in
         ("{" ^ res  ^ "}", si)
      end                               
end
