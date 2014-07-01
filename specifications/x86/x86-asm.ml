#export = generalize{length, insn}
#
#val generalize insn = asm-insn insn.length (string-from-rope-lit (pretty-mnemonic insn)) (generalize-ua (uarity-of insn.insn))
#  
#val generalize-ua ua = case ua of
#   UA0: asm-opnds-none
# | UA1 u: asm-opnds-one (generalize-lval u.opnd1)
# | UA2 u: asm-opnds-more (generalize-lval u.opnd1) (asm-opnds-one (generalize-lval u.opnd2))
# | UA3 u: asm-opnds-more (generalize-lval u.opnd1) (asm-opnds-more (generalize-lval u.opnd2) (asm-opnds-one (generalize-lval u.opnd3)))
# | UA4 u: asm-opnds-more (generalize-lval u.opnd1) (asm-opnds-more (generalize-lval u.opnd2) (asm-opnds-more (generalize-lval u.opnd3) (asm-opnds-one (generalize-lval u.opnd4))))
## | UAF u: asm-opnds-one (asm-copnd (string-from-rope-lit "flow") (asm-ropnd (asm-rel (generalize-rval u.opnd1))))
#end
#
#val generalize-rval opnd = case opnd of
#   IMM8 i: asm-rimm (asm-imm (I8 i.imm))
# | IMM16 i: asm-rimm (asm-imm (I16 i.imm))
# | IMM32 i: asm-rimm (asm-imm (I32 i.imm))
# | IMM64 i: asm-rimm (asm-imm (I64 i.imm))
# | X86_SUM s: asm-rsum (generalize-rval s.a) (generalize-rval s.b)
# | X86_SCALE s: asm-rscale (zx s.imm) (generalize-rval s.opnd)
# | _: asm-froml (generalize-lval opnd)
#end
#
#val generalize-lval opnd = case opnd of
#   REG r: let
#     val rs = semantic-register-of r
#   in
#     asm-lreg (asm-register-so (string-from-rope-lit (pretty-arch-id rs.id)) rs.size rs.offset)
#   end
#end
#
#val generalize-lop opnd = asm-lopnd (generalize-lval opnd)

# asm-ropnd (asm-rimm (asm-int (I1 '1')))

val foooooo = 0
