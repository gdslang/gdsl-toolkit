val revision/generalize-immediate i = 
   case i of
      IMM16 x: asm-bounded (asm-boundary-sz 16) (asm-imm (zx x))
   end
