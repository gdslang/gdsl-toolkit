
structure Closure = struct

   type tag = CPS.tag
   type field = CPS.field

   structure Var = struct
      open CPS.Var
      type k = SymbolTable.symid
   end

   structure Stmt = struct
      datatype term =
         APP of
            {f: Var.v,
             k: Var.c,
             closure: Var.k,
             xs: Var.v list}
       | CC of
            {k: Var.c,
             closure: Var.k,
             xs: Var.v list}
       | CASE of Var.v * Var.c StringMap.map 

      and stmt = 
         LETVAL of Var.v * cval
       | LETPRJ of Var.v * field * Var.v
       | LETUPD of Var.v * Var.v * (field * Var.v) list
       | LETREF of Var.v * Var.k * int
       | LETENV of Var.k * Var.v list

      and cval = 
         PRI of Var.v * Var.v list
       | INJ of tag * Var.v
       | REC of (field * Var.v) list
       | INT of IntInf.int
       | FLT of FloatLit.float
       | STR of string
       | VEC of string
       | UNT
   end

   structure Block = struct
      datatype t =
         BLOCK of
            {stmts: Stmt.stmt list,
             flow: Stmt.term}

      fun get s (BLOCK ?) = s ?
   end

   structure Fun = struct
      datatype t = 
         FUN of
            {f: Var.v,
             k: Var.c,
             closure: Var.k,
             xs: Var.v list,
             body: Block.t}
       | CONT of
            {k: Var.c,
             closure: Var.k,
             xs: Var.v list,
             body: Block.t}
   end

   structure Spec = struct
      open CPS.Spec
      type t = Fun.t list Spec.t
   end

   structure PP = struct
      open Layout Pretty
      fun spec s = str "<.closure.>"
   end
end
