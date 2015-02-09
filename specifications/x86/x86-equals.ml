val equals-opnd oa ob = case oa of
   IMM8 ia: case ob of IMM8 ib: ia.address === ib.address and ia.imm == ib.imm | _: '0' end
 | IMM16 ia: case ob of IMM16 ib: ia.address === ib.address and ia.imm == ib.imm | _: '0' end
 | IMM32 ia: case ob of IMM32 ib: ia.address === ib.address and ia.imm == ib.imm | _: '0' end
 | IMM64 ia: case ob of IMM64 ib: ia.address === ib.address and ia.imm == ib.imm | _: '0' end
 | REG ra: case ob of REG rb: equals-register ra rb | _: '0' end
 | MEM ma: case ob of MEM mb: equals-mem ma mb | _: '0' end
 | X86_SUM sa: case ob of X86_SUM sb: (equals-opnd sa.a sb.a) and (equals-opnd
   sa.b sb.b) | _: '0' end
 | X86_SCALE sa: case ob of X86_SCALE sb: (sa.imm == sb.imm) and (equals-opnd
   sa.opnd sb.opnd) | _: '0' end
end

val equals-register ra rb = (index ra) === (index rb)

val equals-mem ma mb =
  (ma.sz === mb.sz) and
  (ma.psz === mb.psz) and
  (equals-seg-over ma.segment mb.segment) and
  (equals-opnd ma.opnd mb.opnd)

val equals-seg-over sa sb = case sa of
   SEG_NONE: case sb of SEG_NONE: '1' | _: '0' end
 | SEG_OVERRIDE ra: case sb of SEG_OVERRIDE rb: equals-register ra rb | _: '0'
   end
end

val zero-opnd opnd = case opnd of
   IMM8 i: (zx i.imm) === 0
 | IMM16 i: (zx i.imm) === 0
 | IMM32 i: (zx i.imm) === 0
 | IMM64 i: (zx i.imm) === 0
 | REG r: '0'
 | MEM m: '0'
 | X86_SUM s: (zero-opnd s.a) and (zero-opnd s.b)
 | X86_SCALE s: ((zx s.imm) === 0) and (zero-opnd s.opnd)
end
