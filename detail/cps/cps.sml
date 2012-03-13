(**
 * ## CPS style intermediate representation
 *
 * see:
 *   - Compiling with Continuations, Continued
 *       Andrew Kennedy
 *)
structure CPS = struct

   type tag = Core.sym
   type field = Core.sym

   structure Var = struct
      type v = SymbolTable.symid
      type c = SymbolTable.symid
   end

   structure Exp = struct
      datatype term =
         LETVAL of Var.v * Var.c * term
       | LETREC of recdecl list * term
       | LETPRJ of Var.v * field * Var.v * term
       | LETCC of ccdecl list * term
       | APP of Var.v * Var.c * Var.v
       | CC of Var.c * Var.v
       | CASE of Var.v * Var.c list

      and cval =
         FN of Var.c * Var.v * term
       | INJ of tag * Var.c
       | INT of IntInf.int
       | FLT of FloatLit.float
       | STR of string
       | NIL
      
      withtype recdecl = Var.v * Var.c * Var.v list * term
      and ccdecl = Var.c * Var.v * term
      type t = term
   end
end
