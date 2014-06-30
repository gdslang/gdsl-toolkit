val asm-pretty ai = ai.mnemonic +++ show/flags ai.flags -++ show/opnds ai.opnds

val show/flags flags = case flags of
   CONDITION c: ".<=" +++ show/opnd c +++ "=>"
 | SFLAGS s: from-string-lit s
end

val show/opnds opnds = case opnds of
   OPNDS_NIL: ""
 | OPNDS_CONS c: show/opnd c.hd +++ (case c.tl of OPNDS_NIL: "" | _: " " +++ show/opnds c.tl end)
end

val show/opnd opnd = case opnd of
   LSO l: show/lso l
 | ASO a: show/aso a
 | CATEGORY c: from-string-lit c.category +++ ":" +++ show/opnd c.opnd
end

val show/immediate i = case i.signedness of
   UNSIGNED: show-int (imm-as-uint i.immediate)
 | SIGNED: show-int (imm-as-int i.immediate)
 | UNSPEC: show-int (imm-as-uint i.immediate) #Todo: show as hex string
end

val show/aso a = case a of
   FLO l: show/lso l
 | IMM i: show/immediate i
 | SUM s: "(" +++ show/aso s.lhs -++ "+" -++ show/aso s.rhs +++ ")"
 | SCALE s: show-int s.factor +++ "*" +++ show/aso s.rhs
 | REL a: "(?+ " -++ show/aso a +++ ")"
end

val show/lso l = case l of
   REGISTER r: show/register r
 | MEMORY m: show/memory m
 | POST_OP po: "(" +++ show/lso po.lso +++ " [" +++ show/lso po.lso +++ " := " +++ show/aso po.expr +++ "])"
 | PRE_OP pr: "([" +++ show/lso pr.lso +++ " := " +++ show/aso pr.expr +++ "] " +++ show/lso pr.lso +++ ")"
end

val show/register r = from-string-lit r.mnemonic +++ (if r.offset > 0 then #Todo: not > 0 but != 0 - operator?
    "." +++ show-int r.offset
  else
    ""
  ) +++ "/" +++ show-int r.size

val show/memory m = ""
