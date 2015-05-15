val revision/generalize-immediate i = 
   case 0 of
      1: asm-bounded (asm-boundary-sz 1) (asm-imm 1)
   end
