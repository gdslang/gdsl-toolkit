export generalize : (insndata) -> asm-insn

val generalize insn = let
  val recordify mnemonic ua = {mnemonic=mnemonic, ua=ua}
  val traversed = traverse recordify insn.insn
in
  asm-insn insn.length (string-from-rope traversed.mnemonic) (generalize-ua traversed.ua)
end

val generalize-ua ua = case ua of
   UA0: asm-opnds-none
 | UA1 u: asm-opnds-one (generalize-opnd u.operand)
 | UA2 u: asm-opnds-more (generalize-opnd u.first) (asm-opnds-one (generalize-opnd u.second))
 | UA3 u: asm-opnds-more (generalize-opnd u.first) (asm-opnds-more (generalize-opnd u.second) (asm-opnds-one (generalize-opnd u.third)))
end

val generalize-opnd opnd = let
  val generalize-register r = asm-reg (string-from-rope (show/register r))
in case opnd of
   REG r: generalize-register r
 | REGHL rhl: asm-composite (asm-opnds-more (generalize-register rhl.regh) (asm-opnds-one (generalize-register rhl.regl)))
 | REGIHL rhl: asm-composite (asm-opnds-more (generalize-register rhl.regi) (asm-opnds-more (generalize-register rhl.reghl.regh) (asm-opnds-one (generalize-register rhl.reghl.regl))))
 | IOREG r: generalize-register r
 | IMM i: generalize-immediate i
 | OPSE opse: generalize-opse opse
 | OPDI opdi: asm-sum (generalize-opnd opdi.op) (generalize-immediate opdi.imm)
end end

val generalize-immediate i = let
   val inner i sz = asm-bounded (asm-boundary-sz sz) (asm-imm (zx i))
in case i of
   IMM3 i: inner i 3
 | IMM4 i: inner i 4
 | IMM6 i: inner i 6
 | IMM7 i: inner i 7
 | IMM8 i: inner i 8
 | IMM12 i: inner i 12
 | IMM16 i: inner i 16
 | IMM22 i: inner i 22
 | IMMi i: (asm-imm i)
end end

val generalize-opse opse = case opse.se of
   NONE: generalize-opnd opse.op
 | INCR i: let
     val opnd = generalize-opnd opse.op
   in
     asm-po (asm-sum opnd (asm-imm i)) opnd
   end
 | DECR: let
     val opnd = generalize-opnd opse.op
   in
     asm-po (asm-sum opnd (asm-imm 1)) opnd
   end
end
