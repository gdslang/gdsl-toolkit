export = translate


val sem-foo = return void


# -> script from here

val semantics i =
   case i of
      ABS-fmt x: sem-foo
    | ADD x: sem-foo
    | ADD-fmt x: sem-foo
    | ADDI x: sem-foo
    | ADDIU x: sem-foo
    | ADDU x: sem-foo
    | ALNV-PS x: sem-foo
    | AND x: sem-foo
    | ANDI x: sem-foo
    | BC1F x: sem-foo
    | BC1FL x: sem-foo
    | BC1T x: sem-foo
    | BC1TL x: sem-foo
    | BC2F x: sem-foo
    | BC2FL x: sem-foo
    | BC2T x: sem-foo
    | BC2TL x: sem-foo
    | BEQ x: sem-foo
    | BEQL x: sem-foo
    | BGEZ x: sem-foo
    | BGEZAL x: sem-foo
    | BGEZALL x: sem-foo
    | BGEZL x: sem-foo
    | BGTZ x: sem-foo
    | BGTZL x: sem-foo
    | BLEZ x: sem-foo
    | BLEZL x: sem-foo
    | BLTZ x: sem-foo
    | BLTZAL x: sem-foo
    | BLTZALL x: sem-foo
    | BLTZL x: sem-foo
    | BNE x: sem-foo
    | BNEL x: sem-foo
    | BREAK x: sem-foo
    | C-cond-fmt x: sem-foo
    | CACHE x: sem-foo
    | CACHEE x: sem-foo
    | CEIL-L-fmt x: sem-foo
    | CEIL-W-fmt x: sem-foo
    | CFC1 x: sem-foo
    | CFC2 x: sem-foo
    | CLO x: sem-foo
    | CLZ x: sem-foo
    | COP2 x: sem-foo
    | CTC1 x: sem-foo
    | CTC2 x: sem-foo
    | CVT-D-fmt x: sem-foo
    | CVT-L-fmt x: sem-foo
    | CVT-PS-S x: sem-foo
    | CVT-S-fmt x: sem-foo
    | CVT-S-PL x: sem-foo
    | CVT-W-fmt x: sem-foo
    | DERET: sem-foo
    | DI x: sem-foo
    | DIV x: sem-foo
    | DIV-fmt x: sem-foo
    | DIVU x: sem-foo
    | EI x: sem-foo
    | ERET: sem-foo
    | EXT x: sem-foo
    | FLOOR-L-fmt x: sem-foo
    | FLOOR-W-fmt x: sem-foo
    | INS x: sem-foo
    | J x: sem-foo
    | JAL x: sem-foo
    | JALR x: sem-foo
    | JALX x: sem-foo
    | JR x: sem-foo
    | LB x: sem-foo
    | LBE x: sem-foo
    | LBU x: sem-foo
    | LBUE x: sem-foo
    | LDC1 x: sem-foo
    | LDC2 x: sem-foo
    | LDXC1 x: sem-foo
    | LH x: sem-foo
    | LHE x: sem-foo
    | LHU x: sem-foo
    | LHUE x: sem-foo
    | LL x: sem-foo
    | LLE x: sem-foo
    | LUI x: sem-foo
    | LUXC1 x: sem-foo
    | LW x: sem-foo
    | LWC1 x: sem-foo
    | LWC2 x: sem-foo
    | LWE x: sem-foo
    | LWL x: sem-foo
    | LWLE x: sem-foo
    | LWR x: sem-foo
    | LWRE x: sem-foo
    | LWXC1 x: sem-foo
    | MADD x: sem-foo
    | MADD-fmt x: sem-foo
    | MADDU x: sem-foo
    | MFC0 x: sem-foo
    | MFC1 x: sem-foo
    | MFC2 x: sem-foo
    | MFHC1 x: sem-foo
    | MFHC2 x: sem-foo
    | MFHI x: sem-foo
    | MFLO x: sem-foo
    | MOV-fmt x: sem-foo
    | MOVF x: sem-foo
    | MOVF-fmt x: sem-foo
    | MOVN x: sem-foo
    | MOVN-fmt x: sem-foo
    | MOVT x: sem-foo
    | MOVT-fmt x: sem-foo
    | MOVZ x: sem-foo
    | MOVZ-fmt x: sem-foo
    | MSUB x: sem-foo
    | MSUB-fmt x: sem-foo
    | MSUBU x: sem-foo
    | MTC0 x: sem-foo
    | MTC1 x: sem-foo
    | MTC2 x: sem-foo
    | MTHC1 x: sem-foo
    | MTHC2 x: sem-foo
    | MTHI x: sem-foo
    | MTLO x: sem-foo
    | MUL x: sem-foo
    | MUL-fmt x: sem-foo
    | MULT x: sem-foo
    | MULTU x: sem-foo
    | NEG-fmt x: sem-foo
    | NMADD-fmt x: sem-foo
    | NMSUB-fmt x: sem-foo
    | NOR x: sem-foo
    | OR x: sem-foo
    | ORI x: sem-foo
    | PLL-PS x: sem-foo
    | PLU-PS x: sem-foo
    | PREF x: sem-foo
    | PREFE x: sem-foo
    | PREFX x: sem-foo
    | PUL-PS x: sem-foo
    | PUU-PS x: sem-foo
    | RDHWR x: sem-foo
    | RDPGPR x: sem-foo
    | RECIP-fmt x: sem-foo
    | ROTR x: sem-foo
    | ROTRV x: sem-foo
    | ROUND-L-fmt x: sem-foo
    | ROUND-W-fmt x: sem-foo
    | RSQRT-fmt x: sem-foo
    | SB x: sem-foo
    | SBE x: sem-foo
    | SC x: sem-foo
    | SCE x: sem-foo
    | SDBBP x: sem-foo
    | SDC1 x: sem-foo
    | SDC2 x: sem-foo
    | SDXC1 x: sem-foo
    | SEB x: sem-foo
    | SEH x: sem-foo
    | SH x: sem-foo
    | SHE x: sem-foo
    | SLL x: sem-foo
    | SLLV x: sem-foo
    | SLT x: sem-foo
    | SLTI x: sem-foo
    | SLTIU x: sem-foo
    | SLTU x: sem-foo
    | SQRT-fmt x: sem-foo
    | SRA x: sem-foo
    | SRAV x: sem-foo
    | SRL x: sem-foo
    | SRLV x: sem-foo
    | SUB x: sem-foo
    | SUB-fmt x: sem-foo
    | SUBU x: sem-foo
    | SUXC1 x: sem-foo
    | SW x: sem-foo
    | SWC1 x: sem-foo
    | SWC2 x: sem-foo
    | SWE x: sem-foo
    | SWL x: sem-foo
    | SWLE x: sem-foo
    | SWR x: sem-foo
    | SWRE x: sem-foo
    | SWXC1 x: sem-foo
    | SYNC x: sem-foo
    | SYNCI x: sem-foo
    | SYSCALL x: sem-foo
    | TEQ x: sem-foo
    | TEQI x: sem-foo
    | TGE x: sem-foo
    | TGEI x: sem-foo
    | TGEIU x: sem-foo
    | TGEU x: sem-foo
    | TLBINV: sem-foo
    | TLBINVF: sem-foo
    | TLBP: sem-foo
    | TLBR: sem-foo
    | TLBWI: sem-foo
    | TLBWR: sem-foo
    | TLT x: sem-foo
    | TLTI x: sem-foo
    | TLTIU x: sem-foo
    | TLTU x: sem-foo
    | TNE x: sem-foo
    | TNEI x: sem-foo
    | TRUNC-L-fmt x: sem-foo
    | TRUNC-W-fmt x: sem-foo
    | WAIT x: sem-foo
    | WRPGPR x: sem-foo
    | WSBH x: sem-foo
    | XOR x: sem-foo
    | XORI x: sem-foo
   end

# <- script until here

val translate-mips insn = semantics insn

val translate insn = do
  update@{stack=SEM_NIL,tmp=0,lab=0};
  
  translate-mips insn;
  
  stack <- query $stack;
  return (rreil-stmts-rev stack)
end

val translate-block-single insn = do
   ic <- query $ins_count;
   update@{tmp=0,ins_count=ic+1};
   
   translate-mips insn
end

val relative-next stmts = let
  val is_sem_ip x = case x of
     Sem_PC: '1'
   | _: '0'
  end
in
  relative-next-generic is_sem_ip stmts
end
