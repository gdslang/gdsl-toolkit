val revision/generalize-immediate i = let
   val inner i sz = asm-bounded (asm-boundary-sz sz) (asm-imm (zx i))
in case i of
   IMM21 i: inner i 21
 | BP i: inner i 2
end end

