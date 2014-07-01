val asm-pretty ai = ai.mnemonic +++ show/flags ai.flags -++ show/opnds ai.opnds

val show/flags flags = case flags of
   CONDITION c: ".<=" +++ show/opnd c +++ "=>"
 | SFLAGS s: from-string-lit s
 | NOFLAGS: ""
end

val show/opnds opnds = case opnds of
   OPNDS_NIL: ""
 | OPNDS_CONS c: show/opnd c.hd +++ (case c.tl of OPNDS_NIL: "" | _: " " +++ show/opnds c.tl end)
end

val show/opnd opnd = case opnd of
   LSO l: show/lso l
 | RSO r: show/rso r
 | CATEGORY c: from-string-lit c.category +++ ":" +++ show/opnd c.opnd
end

val show/immediate i = case i.signedness of
   UNSIGNED: show-int (imm-as-uint i.immediate)
 | SIGNED: show-int (imm-as-int i.immediate)
 | UNSPEC: show-int (imm-as-uint i.immediate) #Todo: show as hex string
end

val show/rso r = case r of
   FLO l: show/lso l
 | IMM i: show/immediate i
 | SUM s: "(" +++ show/rso s.lhs -++ "+" -++ show/rso s.rhs +++ ")"
 | SCALE s: show-int s.factor +++ "*" +++ show/rso s.rhs
 | REL a: "(?+ " -++ show/rso a +++ ")"
end

val show/lso l = case l of
   REGISTER r: show/register r
 | MEMORY m: show/memory m
 | POST_OP po: "(" +++ show/lso po.lso +++ " [" +++ show/lso po.lso +++ " := " +++ show/rso po.expr +++ "])"
 | PRE_OP pr: "([" +++ show/lso pr.lso +++ " := " +++ show/rso pr.expr +++ "] " +++ show/lso pr.lso +++ ")"
end

val show/register r = case r of
   REGISTER_NAME n: from-string-lit n
 | REGISTER_SO r: from-string-lit r.mnemonic +++ (if (r.offset === 0) == '0' then
     "." +++ show-int r.offset
   else
     ""
   ) +++ "/" +++ show-int r.size
end

val show/memory m = "*" +++ show/opnd m.pointer
