export = generalize{length, insn}

val generalize insn = asm-insn insn.length (string-from-rope-lit (pretty-mnemonic insn)) (generalize-ua (uarity-of insn.insn))
  
val generalize-ua ua = case ua of
   UA0: asm-opnds-none
 | UA1 u: asm-opnds-one (generalize-opnd u.opnd1)
 | UA2 u: asm-opnds-more (generalize-opnd u.opnd1) (asm-opnds-one (generalize-opnd u.opnd2))
 | UA3 u: asm-opnds-more (generalize-opnd u.opnd1) (asm-opnds-more (generalize-opnd u.opnd2) (asm-opnds-one (generalize-opnd u.opnd3)))
 | UA4 u: asm-opnds-more (generalize-opnd u.opnd1) (asm-opnds-more (generalize-opnd u.opnd2) (asm-opnds-more (generalize-opnd u.opnd3) (asm-opnds-one (generalize-opnd u.opnd4))))
# | UAF u: asm-opnds-one (asm-copnd (string-from-rope-lit "flow") (asm-ropnd (asm-rel (generalize-opnd u.opnd1))))
end


val generalize-opnd opnd = case opnd of
   IMM8 i: asm-imm (asm-immediate-unk (zx i.imm) 8)
 | IMM16 i: asm-imm (asm-immediate-unk (zx i.imm) 16)
 | IMM32 i: asm-imm (asm-immediate-unk (zx i.imm) 32)
 | IMM64 i: asm-imm (asm-immediate-unk (zx i.imm) 64)
 | REG r: let
     val rs = semantic-register-of r
   in
     asm-reg (asm-register-so (string-from-rope-lit (pretty-arch-id rs.id)) rs.size rs.offset)
   end
# | MEM m: 
 | X86_SUM s: asm-sum (generalize-opnd s.a) (generalize-opnd s.b)
 | X86_SCALE s: asm-scale (zx s.imm) (generalize-opnd s.opnd)
end

# asm-ropnd (asm-rimm (asm-int (I1 '1')))

val foooooo = 0
