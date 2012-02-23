structure BooleanDomain : sig

   type bvar
   
   val invalidBVar : bvar
   
   type bfun
   
   val empty : bfun

   (*introduce a variable that is unbounded*)
   val introVar : bfun -> bfun * bvar
   
   (*introduce a variable that is constant*)
   val introConst : bfun * bool -> bfun * bvar
   
   exception Unsatisfiable
   
   val intersectVar : bfun * bvar * bvar -> bfun

   val intersectConst : bfun * bvar * bool -> bfun

   val eliminate : bfun * bvar list -> bfun

   val expand : bfun * bvar list -> bfun * bvar list
   
   val meet : bfun * bfun -> bfun
   
end = struct

   datatype bVar = BVAR of int

   type bvar = bVar
   
   val invalidBVar = BVAR 0

   type bfun = unit
   
   val empty = ()

   fun introVar f = (f, BVAR 0)
   
   fun introConst (f,c) = (f, BVAR 0)
   
   exception Unsatisfiable
   
   fun intersectVar (f, v1, v2) = f

   fun intersectConst (f, v, c) = f

   fun eliminate (f,l) = f

   fun expand (f, l) = (f, l)
   
   fun meet (f1, f2) = f1
   
end