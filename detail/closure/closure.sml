
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
      open Layout Pretty Stmt
      val var = CPS.PP.var
      val vars = CPS.PP.vars
      val con = CPS.PP.con
      val fld = CPS.PP.fld
      val updFld = CPS.PP.updFld
      val is = seq [space, str "=", space]

      fun block (Block.BLOCK {stmts, flow}) =
         align (map stmt stmts@[term flow])

      and term t =
         case t of
            APP {f, k, closure, xs=[x]} =>
               seq [var f, space, var closure, space, var k, space, var x]
          | APP {f, k, closure, xs} =>
               seq
                  [var f, space, var closure, space, var k,
                   listex "(" ")" "," (map var xs)]
          | CC {k, closure, xs=[x]} =>
               seq [var k, space, var closure, space, var x]
          | CC {k, closure, xs} => 
               seq
                  [var k, space, var closure,
                   listex "(" ")" "," (map var xs)]
          | CASE (x, ks) =>
               align
                  [seq [str "case", space, var x, space, str "of"],
                   CPS.PP.cases (StringMap.listItems ks)]

      and stmt s =
         case s of
            LETVAL (x, v) => seq [str "letval", space, var x, is, cval v]
          | LETPRJ (y, f, x) =>
               seq
                  [str "letval", space, var y, is,
                   str "$", fld f, space, var x]
          | LETUPD (y, x, fs) =>
               seq
                  [str "letval", space, var x, is, var y,
                   str "@", listex "{" "}" "," (map updFld fs)]
          | LETREF (x, env, i) =>
               seq
                  [str "letval", space, var x, is, var env,
                   str "[", str (Int.toString i), str "]"]
          | LETENV (env, xs) =>
               seq [str "letval", space, var env, is, list (map var xs)]

      and cval v =
         case v of
            PRI (f, xs) =>
               seq
                  [var f,
                   seq
                     [str "(",
                      seq (separate (map var xs, ",")),
                      str ")"]]
          | INJ (tag, v) => seq [con tag, space, var v]
          | INT i => int i
          | FLT f => str (FloatLit.toString f)
          | STR s => str s
          | VEC s => seq [str "'", str s, str "'"]
          | REC fs =>
                  listex "{" "}" ","
                     (map
                        (fn (f, v) =>
                           seq [fld f, is, var v]) fs)
          | UNT => str "{}"

      fun functions fs = align (map function fs)
      and function f =
         case f of
            Fun.FUN {f, k, closure, xs, body} =>
               align
                  [seq
                     [str "val", space, var f, space,
                      var closure, space,
                      var k, space, vars xs, is],
                   indent 3 (block body)]
          | Fun.CONT {k, closure, xs, body} =>
               align
                  [seq
                     [str "val", space, var k, space,
                      var closure, space, vars xs, is],
                   indent 3 (block body)]

      val spec = Spec.PP.spec functions
   end
end
