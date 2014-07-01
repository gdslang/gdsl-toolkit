export = asm-pretty{mnemonic, opnds, annotataons}

val asm-pretty ai = ai.mnemonic +++ show/asm-annotations ai.annotataons -++ show/asm-opnds " " ai.opnds

val show/asm-opnds dlim opnds = case opnds of
   ASM_OPNDS_NIL: ""
 | ASM_OPNDS_CONS c: show/asm-opnd c.hd +++ (case c.tl of ASM_OPNDS_NIL: "" | _: dlim +++ show/asm-opnds dlim c.tl end)
end

val show/asm-opnd opnd = case opnd of
   ASM_REGISTER r: show/asm-register r
 | ASM_MEMORY m: show/asm-memory m
 | ASM_IMM i: show/asm-immediate i
 | ASM_POST_OP po: "(" +++ show/asm-opnd po.opnd +++ " [" +++ show/asm-opnd po.opnd +++ " := " +++ show/asm-opnd po.expr +++ "])"
 | ASM_PRE_OP pr: "([" +++ show/asm-opnd pr.opnd +++ " := " +++ show/asm-opnd pr.expr +++ "] " +++ show/asm-opnd pr.opnd +++ ")"
 | ASM_REL a: "(?+ " -++ show/asm-opnd a +++ ")"
 | ASM_ANNOTATION a: show/asm-annotation a
 | ASM_SUM s: "(" +++ show/asm-opnd s.lhs -++ "+" -++ show/asm-opnd s.rhs +++ ")"
 | ASM_SCALE s: show-int s.factor +++ "*" +++ show/asm-opnd s.rhs
end

val show/asm-register r = case r of
   ASM_REGISTER_NAME n: from-string-lit n
 | ASM_REGISTER_SO r: from-string-lit r.mnemonic +++ (if (r.offset === 0) == '0' then
     "." +++ show-int r.offset
   else
     ""
   ) +++ "/" +++ show-int r.size
end

val show/asm-annotations anns = case anns of
   ASM_ANNS_NIL: ""
 | ASM_ANNS_CONS c: "{" +++ show/asm-annotation c.hd +++ (case c.tl of ASM_ANNS_NIL: "" | _: ", " +++ show/asm-annotations c.tl end) +++ "}"
end

val show/asm-annotation a = case a of
   ASM_ANN_STRING s: from-string-lit s
 | ASM_ANN_FUNCTION f: (from-string-lit f.name) +++ "(" +++ show/asm-opnds ", " f.args +++ ")"
 | ASM_ANN_OPND o: (from-string-lit o.name) +++ ":" -++ show/asm-opnd o.opnd
end

val show/asm-immediate i = case i of
   ASM_IMMEDIATE v: show-int v
 | ASM_UNKNOWN_SIGNEDNESS us: show-int us.value +++ "/" +++ show-int us.size #Todo: show as hex string
end

val show/asm-memory m = "*" +++ show/asm-opnd m.pointer
