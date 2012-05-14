
structure Core = struct
   
   type sym = SymbolTable.symid

   structure Lit : sig
      datatype lit = datatype SpecAbstractTree.lit
      type t = lit
   end = struct
      open SpecAbstractTree
      type t = lit
   end

   structure Pat = struct
      datatype t =
         BIT of string
       | INT of IntInf.int
       | CON of sym * t option
       | ID of sym
       | WILD
   end

   structure Exp = struct
      datatype t =
         LETVAL of sym * t * t
       | LETREC of decl list * t
       | IF of t * t * t
       | CASE of t * (Pat.t * t) list
       | APP of t * t
       | PRI of sym * sym list
       | FN of sym * t
       | RECORD of (sym * t) list
       | UPDATE of (sym * t) list
       | SELECT of sym
       | SEQ of seq list
       | LIT of Lit.t
       | CON of sym
       | ID of sym

      and seq =
         ACTION of t
       | BIND of sym * t

      withtype decl = sym * sym list * t
   end

   structure Spec = struct
      open Spec
      type t = Exp.decl list Spec.t
   end

   structure PP = struct
      open Layout Pretty Exp Pat
      fun var sym = SpecAbstractTree.PP.var_use sym
      fun con sym = SpecAbstractTree.PP.con_use sym
      fun fld sym = SpecAbstractTree.PP.field_use sym
      val is = seq [space, str "=", space]
      val inn = seq [space, str "in"]
      fun vars xs = seq [lp, seq (separate (map var xs, ",")), rp]
      fun layout exp = let open Exp in
         case exp of
            LETVAL (n, e, body) =>
               align
                  [seq [str "letval", space, var n, is, layout e, inn],
                   indent 3 (layout body)]
          | LETREC (ds, e) =>
               align 
                  [align [str "letrec", indent 3 (recdecls ds)],
                   align [str "in", indent 3 (layout e)]]
          | IF (iff, thenn, elsee) =>
               align
                  [align
                     [seq [str "if", space, layout iff],
                      indent 3 (align [str "then", indent 3 (layout thenn)])],
                   align [str "else", indent 3 (layout elsee)]]
          | CASE (e, cs) =>
               align
                  [seq [str "case", space, layout e, space, str "of"],
                   cases cs]
          | FN (n, e) =>
               align
                  [seq [str "\\", var n, str "."],
                   indent 3 (layout e)]
          | APP (e1, FN (n, e2)) =>
               align
                  [seq [layout e1, space, str "\\", var n, str "."],
                   indent 3 (layout e2)]
          | APP (e1, e2) => seq [layout e1, space, layout e2]
          | PRI (f, xs) => seq [var f, vars xs]
          | RECORD fs => record (map field fs)
          | UPDATE fs => seq [str "@", record (map field fs)]
          | SELECT f => seq [str "$", fld f]
          | SEQ ss =>
               align 
                  [align
                     [str "do",
                      indent 3 (align (separateRight (map seqexp ss, ";")))],
                   str "end"]
          | LIT l => SpecAbstractTree.PP.lit l
          | CON c => seq [str "`", con c]
          | ID id => var id
      end
      and field (s, e) =
         (FieldInfo.getString (!SymbolTables.fieldTable, s), layout e)
      and casee (p, e) =
         align
            [seq [pat p, space, str ":"],
             indent 3 (layout e)]
      and cases cs =
         case cs of [] => str "<empty>" | cs =>
            indent 3 (alignPrefix (map casee cs, "| "))
      and recdecls ds = align (map recdecl ds)
      and recdecl (n, args, exp) =
         def (seq [str "val", space, seq (separate (map var (n::args), " "))],
              layout exp)
      and seqexp s =
         case s of
            ACTION e => layout e
          | BIND (n, e) => seq [var n, space, str "<-", space, layout e]
      and def (intro, body) =
         align [seq [intro, space, str "="], indent 3 body]
      and pat p =
         case p of
            BIT s => seq [str "'", str s, str "'"]
          | INT i => int i
          | CON (c, SOME p) => seq [str "`", con c, space, pat p]
          | CON (c, NONE) => seq [str "`", con c]
          | ID id => var id
          | WILD => str "_"
      val spec = Spec.PP.spec recdecls
   end
end
