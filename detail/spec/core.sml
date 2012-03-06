
structure Core = struct
   
   type sym = SymbolTable.symid
   structure Pattern = struct
      datatype t =
         BIT of string
       | INT of IntInf.int
       | CON of sym * t option
       | ID of sym
       | WILD
   end

   structure Exp = struct
      datatype t =
         LET of decl list * t
       | REC of decl list * t
       | IF of t * t * t
       | CASE of t * (Pattern.t * t) list
       | APP of t * t
       | RECORD of (sym * t) list
       | UPDATE of (sym * t) list
       | SELECT of sym
       | SEQ of seq list
       | LIT of lit
       | CON of sym
       | ID of sym

      and seq =
         ACTION of t
       | BIND of sym * t

      withtype decl = sym * sym list * t
      and lit = SpecAbstractTree.lit
   end

   structure PP = struct
      open Layout Pretty Exp Pattern
      fun var sym = SpecAbstractTree.PP.var_use sym
      fun con sym = SpecAbstractTree.PP.con_use sym
      fun fld sym = SpecAbstractTree.PP.field_use sym

      fun layout exp =
         case exp of
            LET (ds, e) =>
               align 
                  [align [str "let", indent 3 (decls ds)],
                   align [str "in", indent 3 (layout e)]]
          | REC (ds, e) =>
               align 
                  [align [str "let", indent 3 (recdecls ds)],
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
          | APP (e1, e2) => seq [layout e1, space, layout e2]
          | RECORD fs => record (map field fs)
          | UPDATE fs => seq [str "@", record (map field fs)]
          | SELECT f => seq [str "$", fld f]
          | SEQ ss =>
               align
                  [str "do",
                   indent 3 (alignPrefix (map seqexp ss, ";"))]
          | LIT l => SpecAbstractTree.PP.lit l
          | CON c => seq [str "`", con c]
          | ID id => var id
      and field (s, e) =
         (FieldInfo.getString (!SymbolTables.varTable, s), layout e)
      and casee (p, e) = seq [pat p, space, str ":", space, layout e]
      and cases cs =
         align
            [indent 3 (casee (hd cs)),
             indent 1 (alignPrefix (map casee (tl cs), "| "))]
      and decls ds = align (map decl ds)
      and decl (n, args, exp) =
         def (seq (str "val"::space::(map var (n::args))),
              layout exp)
      and recdecls ds = align (map recdecl ds)
      and recdecl (n, args, exp) =
         def (seq (str "rec"::space::(map var (n::args))),
              layout exp)
      and seqexp s =
         case s of
            ACTION e => layout e
          | BIND (n, e) => seq [var n, space, str "<-", space, layout e]
      and def (intro, body) =
         align [seq [intro, space, str "="], indent 3 body]
      and pat p =
         case p of
            BIT s => str s
          | INT i => int i
          | CON (c, SOME p) => seq [str "`", con c, space, pat p]
          | CON (c, NONE) => seq [str "`", con c]
          | ID id => var id
          | WILD => str "_"
   end
end
