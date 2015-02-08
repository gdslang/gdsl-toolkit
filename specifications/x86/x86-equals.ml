val equals-opnd oa ob = case oa of
   IMM8 ia: case ob of IMM8 ib: ia.address === ib.address and ia.imm == ib.imm | _: '0' end
 | IMM16 ia: case ob of IMM16 ib: ia.address === ib.address and ia.imm == ib.imm | _: '0' end
 | IMM32 ia: case ob of IMM32 ib: ia.address === ib.address and ia.imm == ib.imm | _: '0' end
 | IMM64 ia: case ob of IMM64 ib: ia.address === ib.address and ia.imm == ib.imm | _: '0' end
 | REG ra: case ob of REG rb: (index ra) === (index rb) | _: '0' end
 | MEM ma: case ob of MEM mb: (ma.sz === mb.sz) and (ma.psz === mb.psz) and
     (equals-opnd ma.opnd mb.opnd) | _: '0' end #todo: seg_override
 | _: '0'
# | X86_SUM s: ...
# | X86_SCALE s: ...
end
