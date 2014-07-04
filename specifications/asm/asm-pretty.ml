export = asm-pretty{mnemonic, opnds, annotations}

val asm-pretty ai = (from-string-lit ai.mnemonic) +++ show/asm-annotations ai.annotations -++ show/asm-opnds " " ai.opnds

val show/asm-opnds dlim opnds = case opnds of
   ASM_OPNDS_NIL: ""
 | ASM_OPNDS_CONS c: show/asm-opnd c.hd +++ (case c.tl of ASM_OPNDS_NIL: "" | _: dlim +++ show/asm-opnds dlim c.tl end)
end

val show/asm-opnd opnd = case opnd of
   ASM_REGISTER r: from-string-lit r
 | ASM_MEMORY m: show/asm-memory m
 | ASM_IMM i: show-int i #Todo: show as hex string
 | ASM_POST_OP po: "(" +++ show/asm-opnd po.opnd +++ " [" +++ show/asm-opnd po.opnd +++ " := " +++ show/asm-opnd po.expr +++ "])"
 | ASM_PRE_OP pr: "([" +++ show/asm-opnd pr.opnd +++ " := " +++ show/asm-opnd pr.expr +++ "] " +++ show/asm-opnd pr.opnd +++ ")"
 | ASM_REL a: "(?+ " -++ show/asm-opnd a +++ ")"
 | ASM_ANNOTATED a: show/asm-annotation a.ann +++ ":" +++ show/asm-opnd a.opnd
 | ASM_SUM s: "(" +++ show/asm-opnd s.lhs -++ "+" -++ show/asm-opnd s.rhs +++ ")"
 | ASM_SCALE s: show-int s.factor +++ "*" +++ show/asm-opnd s.rhs
 | ASM_BOUNDED b: show/asm-opnd b.opnd +++ show/asm-boundary b.boundary
 | ASM_SIGN s: show/asm-signedness s.signedness +++ "(" +++ show/asm-opnd s.opnd +++ ")"
end

val show/asm-signedness s = case s of
   ASM_SIGNED: "SIGNED"
 | ASM_UNSIGNED: "UNSIGNED"
end

val show/asm-boundary b = case b of
   ASM_BOUNDARY_SZ s: "/" +++ show-int s
 | ASM_BOUNDARY_SZ_O szo: (if (szo.offset === 0) == '0' then
     "." +++ show-int szo.offset
   else
     ""
   ) +++ "/" +++ show-int szo.size
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

val show/asm-memory m = "*(" +++ show/asm-opnd m +++ ")"
