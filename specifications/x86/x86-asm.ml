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
 | REG r: generalize-register r
 | MEM m: generalize-memory m
 | X86_SUM s: asm-sum (generalize-opnd s.a) (generalize-opnd s.b)
 | X86_SCALE s: asm-scale (zx s.imm) (generalize-opnd s.opnd)
end

val generalize-register r = let
  val rs = semantic-register-of r
in
  asm-bounded (asm-boundary-sz-o rs.size rs.offset) (asm-reg (string-from-rope-lit (pretty-arch-id rs.id)))
end

val generalize-memory m =
  asm-bounded (asm-boundary-sz m.sz)
    (asm-mem ((generalize-segment-override m.segment)
      (asm-bounded (asm-boundary-sz m.psz)
        (generalize-opnd m.opnd)
)))

val generalize-segment-override so = case so of
   SEG_NONE: let val f o = o in f end
 | SEG_OVERRIDE o: let
     val f o = (asm-annotation (asm-ann-opnd "segment" generalize-register so.register) o)
   in f end
end


# asm-ropnd (asm-rimm (asm-int (I1 '1')))

val foooooo = 0
