val revision/traverse f insn = 
   case insn of
      ADDI x: f "ADDI" (TERNOP_LRR x)
    | ALNV-PS x: f "ALNV.PS" (QUADOP_LRRR x)
    | LWL x: f "LWL" (BINOP_LR x)
    | LWLE x: f "LWLE" (BINOP_LR x)
    | LWR x: f "LWR" (BINOP_LR x)
    | LWRE x: f "LWRE" (BINOP_LR x)
    | LWXC1 x: f "LWXC1" (BINOP_LR x)
   end
