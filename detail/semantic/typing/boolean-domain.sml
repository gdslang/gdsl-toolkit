structure BooleanDomain : sig

   (*creation of Boolean variables*)
   type bvar
   val freshBVar : unit -> bvar

   val eq : (bvar * bvar) -> bool
   
   type bfun
   
   val empty : bfun

   val showVar : bvar -> string
   
   exception Unsatisfiable
   
   val meetVarEqualsVar : bfun * bvar * bvar -> bfun

   val meetVarEqualsConst : bfun * bvar * bool -> bfun

   val eliminate : bfun * bvar list -> bfun

   val expand : bfun * bvar list -> bfun * bvar list
   
   val meet : bfun * bfun -> bfun
   
end = struct

   datatype bvar = BVAR of int

   fun eq (BVAR v1, BVAR v2) = v1=v2

   val bvarGenerator = ref 0

   fun freshBVar () = let
     val v = !bvarGenerator
   in
     (bvarGenerator := v+1; BVAR v)
   end

   type bfun = unit
   
   val empty = ()

   fun showVar (BVAR i) = "." ^ Int.toString i

   fun introVar f = (f, BVAR 0)
   
   fun introConst (f,c) = (f, BVAR 0)
   
   exception Unsatisfiable
   
   fun meetVarEqualsVar (f, v1, v2) = f

   fun meetVarEqualsConst (f, v, c) = f

   fun eliminate (f,l) = f

   fun expand (f, l) = (f, l)
   
   fun meet (f1, f2) = f1
   
end