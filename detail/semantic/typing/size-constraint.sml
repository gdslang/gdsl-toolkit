structure SizeConstraint : sig
   type size_constraint
   
   type size_constraint_set
   
   val constant : int -> size_constraint_set
   
end = struct

   type size_constraint = {
      pos : TVar.tvar list,
      neg : TVar.tvar list,
      const : int
   }

   fun compare_list (v1 :: vs1, v2 :: vs2) =
      (case compare_tvar (v1,v2) of
           EQUAL => compare_list (vs1,vs2)
         | other => other)
     | compare_list ([], vs2) = LESS
     | compare_list (vs1, []) = GREATER
        
   fun compare_size_constraint
      ({pos = p1, neg = n1, const = c1}
      ,{pos = p2, neg = n2, const = c2}) =
      case compare_int (List.length p1, List.length p2) =>
           EQUAL => (case compare_int (List.length n1, List.length n2) =>
              EQUAL => (case compare_list (p1,p2) of
                 EQUAL => (case compare_list (n1,n2) of
                    EQUAL => case compare_int (c1,c2)
                  | other => other)
               | other => other)
            | other => other)
         | other => other
   
   structure SizeConstraintSet = RedBlackSetFn (
      struct
         type ord_key = size_constraint
         val compare = compare_size_constraint
      end)
      
   type size_constraint_set = SizeConstraintSet.set

   
end