val revision/generalize-immediate i = let
   val inner i sz = asm-bounded (asm-boundary-sz sz) (asm-imm (zx i))
in case i of
   IMM21 i: inner i 21
 | IMM32 i: inner i 32
 | BP i: inner i 2
 | OFFSET23 i: inner i 23
 | OFFSET28 i: inner i 28
 | C2CONDITION i: inner i 5
end end

