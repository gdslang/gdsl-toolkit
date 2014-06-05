# vim:ts=3:sw=3:expandtab

export = pretty

val pretty i = show/instruction i

val -++ a b = a +++ " " +++ b

val show/leftop opnd = 
   case opnd of
      GPR r: show/register r
    | FPR r: show/register r
   end

val show/rightop opnd = 
   case opnd of
      LEFTOP l: show/leftop l
    | IMM imm: show/immediate imm
   end

val show/immediate imm =
   case imm of
      IMM5 x: show-int (zx x)
    | IMM16 x: show-int (zx x)
    | OFFSET9 x: show-int (zx x)
    | OFFSET16 x: show-int (zx x)
    | FMT3 x: show-int (zx x)
    | FMT5 x: show-int (zx x)
    | SEL x: show-int (zx x)
    | IMPL x: show-int (zx x)
    | CODE10 x: show-int (zx x)
    | CODE19 x: show-int (zx x)
    | CODE20 x: show-int (zx x)
    | STYPE x: show-int (zx x)
    | POSSIZE x: show-int (zx x)
    | SIZE x: show-int (zx x)
    | POS x: show-int (zx x)
    | HINT x: show-int (zx x)
    | INSTRINDEX x: show-int (zx x)
    | COFUN x: show-int (zx x)
    | CC x: show-int (zx x)
    | COND x: show-int (zx x)
    | OP x: show-int (zx x)
  end

val show/register r =
   case r of
      ZERO: "zero"
    | AT: "at"
    | V0: "v0"
    | V1: "v1"
    | A0: "a0"
    | A1: "a1"
    | A2: "a2"
    | A3: "a3"
    | A4: "a4"
    | A5: "a5"
    | A6: "a6"
    | A7: "a7"
    | T4: "t4"
    | T5: "t5"
    | T6: "t6"
    | T7: "t7"
    | S0: "s0"
    | S1: "s1"
    | S2: "s2"
    | S3: "s3"
    | S4: "s4"
    | S5: "s5"
    | S6: "s6"
    | S7: "s7"
    | T8: "t8"
    | T9: "t9"
    | K0: "k0"
    | K1: "k1"
    | GP: "gp"
    | SP: "sp"
    | S8: "s8"
    | RA: "ra"
    | HI: "hi"
    | LO: "lo"
    | PC: "pc"
    | F x: "f" +++ show-int x
    | FIR: "fir"
    | FCCR: "fccr"
    | FEXR: "fexr"
    | FENR: "fenr"
    | FCSR: "fcsr"
   end


# -> script from here

val show/unop-src x = show/rightop x.source
val show/unop x = show/leftop x.destination
val show/binop-src x = show/rightop x.source1 +++ ", " +++ show/rightop x.source2
val show/binop x = show/leftop x.destination +++ ", " +++ show/rightop x.source
val show/ternop-src x = show/rightop x.source1 +++ ", " +++ show/rightop x.source2 +++ ", " +++ show/rightop x.source3
val show/ternop x = show/leftop x.destination +++ ", " +++ show/rightop x.source1 +++ ", " +++ show/rightop x.source2
val show/quadop x = show/leftop x.destination +++ ", " +++ show/rightop x.source1 +++ ", " +++ show/rightop x.source2 +++ ", " +++ show/rightop x.source3
val show/quinop-src x = show/rightop x.source1 +++ ", " +++ show/rightop x.source2 +++ ", " +++ show/rightop x.source3 +++ ", " +++ show/rightop x.source4 +++ ", " +++ show/rightop x.source5
val show/quinop x = show/leftop x.destination +++ ", " +++ show/rightop x.source1 +++ ", " +++ show/rightop x.source2 +++ ", " +++ show/rightop x.source3 +++ ", " +++ show/rightop x.source4


val show/instruction i =
   case i of
      ABS-fmt x: "ABS-fmt" -++ show/ternop x
    | ADD x: "ADD" -++ show/ternop x
    | ADD-fmt x: "ADD-fmt" -++ show/quadop x
    | ADDI x: "ADDI" -++ show/ternop x
    | ADDIU x: "ADDIU" -++ show/ternop x
    | ADDU x: "ADDU" -++ show/ternop x
    | ALNV-PS x: "ALNV-PS" -++ show/quadop x
    | AND x: "AND" -++ show/ternop x
    | ANDI x: "ANDI" -++ show/ternop x
    | BC1F x: "BC1F" -++ show/binop-src x
    | BC1FL x: "BC1FL" -++ show/binop-src x
    | BC1T x: "BC1T" -++ show/binop-src x
    | BC1TL x: "BC1TL" -++ show/binop-src x
    | BC2F x: "BC2F" -++ show/binop-src x
    | BC2FL x: "BC2FL" -++ show/binop-src x
    | BC2T x: "BC2T" -++ show/binop-src x
    | BC2TL x: "BC2TL" -++ show/binop-src x
    | BEQ x: "BEQ" -++ show/ternop-src x
    | BEQL x: "BEQL" -++ show/ternop-src x
    | BGEZ x: "BGEZ" -++ show/binop-src x
    | BGEZAL x: "BGEZAL" -++ show/binop-src x
    | BGEZALL x: "BGEZALL" -++ show/binop-src x
    | BGEZL x: "BGEZL" -++ show/binop-src x
    | BGTZ x: "BGTZ" -++ show/binop-src x
    | BGTZL x: "BGTZL" -++ show/binop-src x
    | BLEZ x: "BLEZ" -++ show/binop-src x
    | BLEZL x: "BLEZL" -++ show/binop-src x
    | BLTZ x: "BLTZ" -++ show/binop-src x
    | BLTZAL x: "BLTZAL" -++ show/binop-src x
    | BLTZALL x: "BLTZALL" -++ show/binop-src x
    | BLTZL x: "BLTZL" -++ show/binop-src x
    | BNE x: "BNE" -++ show/ternop-src x
    | BNEL x: "BNEL" -++ show/ternop-src x
    | BREAK x: "BREAK" -++ show/unop-src x
    | C-cond-fmt x: "C-cond-fmt" -++ show/quinop-src x
    | CACHE x: "CACHE" -++ show/ternop-src x
    | CACHEE x: "CACHEE" -++ show/ternop-src x
    | CEIL-L-fmt x: "CEIL-L-fmt" -++ show/ternop x
    | CEIL-W-fmt x: "CEIL-W-fmt" -++ show/ternop x
    | CFC1 x: "CFC1" -++ show/binop x
    | CFC2 x: "CFC2" -++ show/binop x
    | CLO x: "CLO" -++ show/ternop x
    | CLZ x: "CLZ" -++ show/ternop x
    | COP2 x: "COP2" -++ show/unop-src x
    | CTC1 x: "CTC1" -++ show/binop x
    | CTC2 x: "CTC2" -++ show/binop-src x
    | CVT-D-fmt x: "CVT-D-fmt" -++ show/ternop x
    | CVT-L-fmt x: "CVT-L-fmt" -++ show/ternop x
    | CVT-PS-S x: "CVT-PS-S" -++ show/ternop x
    | CVT-S-fmt x: "CVT-S-fmt" -++ show/ternop x
    | CVT-S-PL x: "CVT-S-PL" -++ show/binop x
    | CVT-W-fmt x: "CVT-W-fmt" -++ show/ternop x
    | DERET: "DERET"
    | DI x: "DI" -++ show/unop x
    | DIV x: "DIV" -++ show/binop-src x
    | DIV-fmt x: "DIV-fmt" -++ show/quadop x
    | DIVU x: "DIVU" -++ show/binop-src x
    | EI x: "EI" -++ show/unop x
    | ERET: "ERET"
    | EXT x: "EXT" -++ show/quadop x
    | FLOOR-L-fmt x: "FLOOR-L-fmt" -++ show/ternop x
    | FLOOR-W-fmt x: "FLOOR-W-fmt" -++ show/ternop x
    | INS x: "INS" -++ show/quadop x
    | J x: "J" -++ show/unop-src x
    | JAL x: "JAL" -++ show/unop-src x
    | JALR x: "JALR" -++ show/ternop x
    | JALX x: "JALX" -++ show/unop-src x
    | JR x: "JR" -++ show/binop-src x
    | LB x: "LB" -++ show/ternop x
    | LBE x: "LBE" -++ show/ternop x
    | LBU x: "LBU" -++ show/ternop x
    | LBUE x: "LBUE" -++ show/ternop x
    | LDC1 x: "LDC1" -++ show/ternop x
    | LDC2 x: "LDC2" -++ show/ternop-src x
    | LDXC1 x: "LDXC1" -++ show/ternop x
    | LH x: "LH" -++ show/ternop x
    | LHE x: "LHE" -++ show/ternop x
    | LHU x: "LHU" -++ show/ternop x
    | LHUE x: "LHUE" -++ show/ternop x
    | LL x: "LL" -++ show/ternop x
    | LLE x: "LLE" -++ show/ternop x
    | LUI x: "LUI" -++ show/binop x
    | LUXC1 x: "LUXC1" -++ show/ternop x
    | LW x: "LW" -++ show/ternop x
    | LWC1 x: "LWC1" -++ show/ternop x
    | LWC2 x: "LWC2" -++ show/ternop-src x
    | LWE x: "LWE" -++ show/ternop x
    | LWL x: "LWL" -++ show/ternop x
    | LWLE x: "LWLE" -++ show/ternop x
    | LWR x: "LWR" -++ show/ternop x
    | LWRE x: "LWRE" -++ show/ternop x
    | LWXC1 x: "LWXC1" -++ show/ternop x
    | MADD x: "MADD" -++ show/binop-src x
    | MADD-fmt x: "MADD-fmt" -++ show/quinop x
    | MADDU x: "MADDU" -++ show/binop-src x
    | MFC0 x: "MFC0" -++ show/ternop x
    | MFC1 x: "MFC1" -++ show/binop x
    | MFC2 x: "MFC2" -++ show/binop x
    | MFHC1 x: "MFHC1" -++ show/binop x
    | MFHC2 x: "MFHC2" -++ show/binop x
    | MFHI x: "MFHI" -++ show/unop x
    | MFLO x: "MFLO" -++ show/unop x
    | MOV-fmt x: "MOV-fmt" -++ show/ternop x
    | MOVF x: "MOVF" -++ show/ternop x
    | MOVF-fmt x: "MOVF-fmt" -++ show/quadop x
    | MOVN x: "MOVN" -++ show/ternop x
    | MOVN-fmt x: "MOVN-fmt" -++ show/quadop x
    | MOVT x: "MOVT" -++ show/ternop x
    | MOVT-fmt x: "MOVT-fmt" -++ show/quadop x
    | MOVZ x: "MOVZ" -++ show/ternop x
    | MOVZ-fmt x: "MOVZ-fmt" -++ show/quadop x
    | MSUB x: "MSUB" -++ show/binop-src x
    | MSUB-fmt x: "MSUB-fmt" -++ show/quinop x
    | MSUBU x: "MSUBU" -++ show/binop-src x
    | MTC0 x: "MTC0" -++ show/ternop-src x
    | MTC1 x: "MTC1" -++ show/binop x
    | MTC2 x: "MTC2" -++ show/binop-src x
    | MTHC1 x: "MTHC1" -++ show/binop x
    | MTHC2 x: "MTHC2" -++ show/binop-src x
    | MTHI x: "MTHI" -++ show/unop-src x
    | MTLO x: "MTLO" -++ show/unop-src x
    | MUL x: "MUL" -++ show/ternop x
    | MUL-fmt x: "MUL-fmt" -++ show/quadop x
    | MULT x: "MULT" -++ show/binop-src x
    | MULTU x: "MULTU" -++ show/binop-src x
    | NEG-fmt x: "NEG-fmt" -++ show/ternop x
    | NMADD-fmt x: "NMADD-fmt" -++ show/quinop x
    | NMSUB-fmt x: "NMSUB-fmt" -++ show/quinop x
    | NOR x: "NOR" -++ show/ternop x
    | OR x: "OR" -++ show/ternop x
    | ORI x: "ORI" -++ show/ternop x
    | PLL-PS x: "PLL-PS" -++ show/ternop x
    | PLU-PS x: "PLU-PS" -++ show/ternop x
    | PREF x: "PREF" -++ show/ternop-src x
    | PREFE x: "PREFE" -++ show/ternop-src x
    | PREFX x: "PREFX" -++ show/ternop-src x
    | PUL-PS x: "PUL-PS" -++ show/ternop x
    | PUU-PS x: "PUU-PS" -++ show/ternop x
    | RDHWR x: "RDHWR" -++ show/binop x
    | RDPGPR x: "RDPGPR" -++ show/binop x
    | RECIP-fmt x: "RECIP-fmt" -++ show/ternop x
    | ROTR x: "ROTR" -++ show/ternop x
    | ROTRV x: "ROTRV" -++ show/ternop x
    | ROUND-L-fmt x: "ROUND-L-fmt" -++ show/ternop x
    | ROUND-W-fmt x: "ROUND-W-fmt" -++ show/ternop x
    | RSQRT-fmt x: "RSQRT-fmt" -++ show/ternop x
    | SB x: "SB" -++ show/ternop-src x
    | SBE x: "SBE" -++ show/ternop-src x
    | SC x: "SC" -++ show/ternop x
    | SCE x: "SCE" -++ show/ternop x
    | SDBBP x: "SDBBP" -++ show/unop-src x
    | SDC1 x: "SDC1" -++ show/ternop-src x
    | SDC2 x: "SDC2" -++ show/ternop-src x
    | SDXC1 x: "SDXC1" -++ show/ternop-src x
    | SEB x: "SEB" -++ show/binop x
    | SEH x: "SEH" -++ show/binop x
    | SH x: "SH" -++ show/ternop-src x
    | SHE x: "SHE" -++ show/ternop-src x
    | SLL x: "SLL" -++ show/ternop x
    | SLLV x: "SLLV" -++ show/ternop x
    | SLT x: "SLT" -++ show/ternop x
    | SLTI x: "SLTI" -++ show/ternop x
    | SLTIU x: "SLTIU" -++ show/ternop x
    | SLTU x: "SLTU" -++ show/ternop x
    | SQRT-fmt x: "SQRT-fmt" -++ show/ternop x
    | SRA x: "SRA" -++ show/ternop x
    | SRAV x: "SRAV" -++ show/ternop x
    | SRL x: "SRL" -++ show/ternop x
    | SRLV x: "SRLV" -++ show/ternop x
    | SUB x: "SUB" -++ show/ternop x
    | SUB-fmt x: "SUB-fmt" -++ show/quadop x
    | SUBU x: "SUBU" -++ show/ternop x
    | SUXC1 x: "SUXC1" -++ show/ternop-src x
    | SW x: "SW" -++ show/ternop-src x
    | SWC1 x: "SWC1" -++ show/ternop-src x
    | SWC2 x: "SWC2" -++ show/ternop-src x
    | SWE x: "SWE" -++ show/ternop-src x
    | SWL x: "SWL" -++ show/ternop-src x
    | SWLE x: "SWLE" -++ show/ternop-src x
    | SWR x: "SWR" -++ show/ternop-src x
    | SWRE x: "SWRE" -++ show/ternop-src x
    | SWXC1 x: "SWXC1" -++ show/ternop-src x
    | SYNC x: "SYNC" -++ show/unop-src x
    | SYNCI x: "SYNCI" -++ show/binop-src x
    | SYSCALL x: "SYSCALL" -++ show/unop-src x
    | TEQ x: "TEQ" -++ show/ternop-src x
    | TEQI x: "TEQI" -++ show/binop-src x
    | TGE x: "TGE" -++ show/ternop-src x
    | TGEI x: "TGEI" -++ show/binop-src x
    | TGEIU x: "TGEIU" -++ show/binop-src x
    | TGEU x: "TGEU" -++ show/ternop-src x
    | TLBINV: "TLBINV"
    | TLBINVF: "TLBINVF"
    | TLBP: "TLBP"
    | TLBR: "TLBR"
    | TLBWI: "TLBWI"
    | TLBWR: "TLBWR"
    | TLT x: "TLT" -++ show/ternop-src x
    | TLTI x: "TLTI" -++ show/binop-src x
    | TLTIU x: "TLTIU" -++ show/binop-src x
    | TLTU x: "TLTU" -++ show/ternop-src x
    | TNE x: "TNE" -++ show/ternop-src x
    | TNEI x: "TNEI" -++ show/binop-src x
    | TRUNC-L-fmt x: "TRUNC-L-fmt" -++ show/ternop x
    | TRUNC-W-fmt x: "TRUNC-W-fmt" -++ show/ternop x
    | WAIT x: "WAIT" -++ show/unop-src x
    | WRPGPR x: "WRPGPR" -++ show/binop-src x
    | WSBH x: "WSBH" -++ show/binop x
    | XOR x: "XOR" -++ show/ternop x
    | XORI x: "XORI" -++ show/ternop x
   end

# <- script until here

