val revision/traverse f insn = 
   case insn of
      ADDIUPC x: f "ADDIUPC" (BINOP_LR x)
    | ALIGN x: f "ALIGN" (QUADOP_LRRR x)
   end
