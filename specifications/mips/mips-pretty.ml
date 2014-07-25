# vim:ts=3:sw=3:expandtab

export = pretty pretty-operand pretty-mnemonic operands

val pretty i = show/instruction i

val -++ a b = a +++ " " +++ b

val show/lvalue opnd = 
   case opnd of
      GPR r: show/register r
    | FPR r: show/register r
   end

val show/rvalue opnd = 
   case opnd of
      LVALUE l: show/lvalue l
    | IMM imm: show/immediate imm
   end

val show/immediate imm =
   case imm of
      IMM5 x: show-int (zx x)
    | IMM16 x: show-int (zx x)
    | OFFSET9 x: show-int (zx x)
    | OFFSET16 x: show-int (zx x)
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

val show/format format = 
   case format of
      S : ".S"
    | D : ".D"
    | W : ".W"
    | L : ".L"
    | PS : ".PS"
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
    | T0: "t0"
    | T1: "t1"
    | T2: "t2"
    | T3: "t3"
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

val show/instruction i = let
  val insn_cl = classify i
in
 show/mnemonic i -++ show/operands insn_cl
end

val pretty-mnemonic i = show/mnemonic i


# -> sftl

val show/unop-src x = show/rvalue x.source
val show/unop x = show/lvalue x.destination
val show/binop-src x = show/rvalue x.source1 +++ ", " +++ show/rvalue x.source2
val show/binop-fmt x = show/lvalue x.destination +++ ", " +++ show/rvalue x.source
val show/binop x = show/lvalue x.destination +++ ", " +++ show/rvalue x.source
val show/ternop-src x = show/rvalue x.source1 +++ ", " +++ show/rvalue x.source2 +++ ", " +++ show/rvalue x.source3
val show/ternop x = show/lvalue x.destination +++ ", " +++ show/rvalue x.source1 +++ ", " +++ show/rvalue x.source2
val show/ternop-fmt x = show/lvalue x.destination +++ ", " +++ show/rvalue x.source1 +++ ", " +++ show/rvalue x.source2
val show/quadop x = show/lvalue x.destination +++ ", " +++ show/rvalue x.source1 +++ ", " +++ show/rvalue x.source2 +++ ", " +++ show/rvalue x.source3
val show/quadop-fmt x = show/lvalue x.destination +++ ", " +++ show/rvalue x.source1 +++ ", " +++ show/rvalue x.source2 +++ ", " +++ show/rvalue x.source3
val show/quadop-fmt-src x = show/rvalue x.source1 +++ ", " +++ show/rvalue x.source2 +++ ", " +++ show/rvalue x.source3 +++ ", " +++ show/rvalue x.source4


val show/operands insn_cl = 
   case insn_cl of
      NULLOP: ""
    | UNOP_SRC x: show/unop-src x
    | UNOP x: show/unop x
    | BINOP_SRC x: show/binop-src x
    | BINOP_FMT x: show/binop-fmt x
    | BINOP x: show/binop x
    | TERNOP_SRC x: show/ternop-src x
    | TERNOP x: show/ternop x
    | TERNOP_FMT x: show/ternop-fmt x
    | QUADOP x: show/quadop x
    | QUADOP_FMT x: show/quadop-fmt x
    | QUADOP_FMT_SRC x: show/quadop-fmt-src x
   end


type insn_cl = 
   NULLOP
 | UNOP_SRC of unop-src
 | UNOP of unop
 | BINOP_SRC of binop-src
 | BINOP_FMT of binop-fmt
 | BINOP of binop
 | TERNOP_SRC of ternop-src
 | TERNOP of ternop
 | TERNOP_FMT of ternop-fmt
 | QUADOP of quadop
 | QUADOP_FMT of quadop-fmt
 | QUADOP_FMT_SRC of quadop-fmt-src


val pretty-operand insn i =
   case insn of
      UNOP_SRC x:
         case i of
            0: show/rvalue x.source
         end
    | UNOP x:
         case i of
            0: show/lvalue x.destination
         end
    | BINOP_SRC x:
         case i of
            0: show/rvalue x.source1
          | 1: show/rvalue x.source2
         end
    | BINOP_FMT x:
         case i of
            0: show/lvalue x.destination
          | 1: show/rvalue x.source
         end
    | BINOP x:
         case i of
            0: show/lvalue x.destination
          | 1: show/rvalue x.source
         end
    | TERNOP_SRC x:
         case i of
            0: show/rvalue x.source1
          | 1: show/rvalue x.source2
          | 2: show/rvalue x.source3
         end
    | TERNOP x:
         case i of
            0: show/lvalue x.destination
          | 1: show/rvalue x.source1
          | 2: show/rvalue x.source2
         end
    | TERNOP_FMT x:
         case i of
            0: show/lvalue x.destination
          | 1: show/rvalue x.source1
          | 2: show/rvalue x.source2
         end
    | QUADOP x:
         case i of
            0: show/lvalue x.destination
          | 1: show/rvalue x.source1
          | 2: show/rvalue x.source2
          | 3: show/rvalue x.source3
         end
    | QUADOP_FMT x:
         case i of
            0: show/lvalue x.destination
          | 1: show/rvalue x.source1
          | 2: show/rvalue x.source2
          | 3: show/rvalue x.source3
         end
    | QUADOP_FMT_SRC x:
         case i of
            0: show/rvalue x.source1
          | 1: show/rvalue x.source2
          | 2: show/rvalue x.source3
          | 3: show/rvalue x.source4
         end
   end


val classify insn = 
   case insn of
      ABS-fmt x: BINOP_FMT x
    | ADD x: TERNOP x
    | ADD-fmt x: TERNOP_FMT x
    | ADDI x: TERNOP x
    | ADDIU x: TERNOP x
    | ADDU x: TERNOP x
    | ALNV-PS x: QUADOP x
    | AND x: TERNOP x
    | ANDI x: TERNOP x
    | BC1F x: BINOP_SRC x
    | BC1FL x: BINOP_SRC x
    | BC1T x: BINOP_SRC x
    | BC1TL x: BINOP_SRC x
    | BC2F x: BINOP_SRC x
    | BC2FL x: BINOP_SRC x
    | BC2T x: BINOP_SRC x
    | BC2TL x: BINOP_SRC x
    | BEQ x: TERNOP_SRC x
    | BEQL x: TERNOP_SRC x
    | BGEZ x: BINOP_SRC x
    | BGEZAL x: BINOP_SRC x
    | BGEZALL x: BINOP_SRC x
    | BGEZL x: BINOP_SRC x
    | BGTZ x: BINOP_SRC x
    | BGTZL x: BINOP_SRC x
    | BLEZ x: BINOP_SRC x
    | BLEZL x: BINOP_SRC x
    | BLTZ x: BINOP_SRC x
    | BLTZAL x: BINOP_SRC x
    | BLTZALL x: BINOP_SRC x
    | BLTZL x: BINOP_SRC x
    | BNE x: TERNOP_SRC x
    | BNEL x: TERNOP_SRC x
    | BREAK x: UNOP_SRC x
    | C-cond-fmt x: QUADOP_FMT_SRC x
    | CACHE x: TERNOP_SRC x
    | CACHEE x: TERNOP_SRC x
    | CEIL-L-fmt x: BINOP_FMT x
    | CEIL-W-fmt x: BINOP_FMT x
    | CFC1 x: BINOP x
    | CFC2 x: BINOP x
    | CLO x: TERNOP x
    | CLZ x: TERNOP x
    | COP2 x: UNOP_SRC x
    | CTC1 x: BINOP x
    | CTC2 x: BINOP_SRC x
    | CVT-D-fmt x: BINOP_FMT x
    | CVT-L-fmt x: BINOP_FMT x
    | CVT-PS-S x: TERNOP x
    | CVT-S-fmt x: BINOP_FMT x
    | CVT-S-PL x: BINOP x
    | CVT-S-PU x: BINOP x
    | CVT-W-fmt x: BINOP_FMT x
    | DERET: NULLOP
    | DI x: UNOP x
    | DIV x: BINOP_SRC x
    | DIV-fmt x: TERNOP_FMT x
    | DIVU x: BINOP_SRC x
    | EI x: UNOP x
    | ERET: NULLOP
    | EXT x: QUADOP x
    | FLOOR-L-fmt x: BINOP_FMT x
    | FLOOR-W-fmt x: BINOP_FMT x
    | INS x: QUADOP x
    | J x: UNOP_SRC x
    | JAL x: UNOP_SRC x
    | JALR x: TERNOP x
    | JALR-HB x: TERNOP x
    | JALX x: UNOP_SRC x
    | JR x: BINOP_SRC x
    | JR-HB x: BINOP_SRC x
    | LB x: TERNOP x
    | LBE x: TERNOP x
    | LBU x: TERNOP x
    | LBUE x: TERNOP x
    | LDC1 x: TERNOP x
    | LDC2 x: TERNOP_SRC x
    | LDXC1 x: TERNOP x
    | LH x: TERNOP x
    | LHE x: TERNOP x
    | LHU x: TERNOP x
    | LHUE x: TERNOP x
    | LL x: TERNOP x
    | LLE x: TERNOP x
    | LUI x: BINOP x
    | LUXC1 x: TERNOP x
    | LW x: TERNOP x
    | LWC1 x: TERNOP x
    | LWC2 x: TERNOP_SRC x
    | LWE x: TERNOP x
    | LWL x: TERNOP x
    | LWLE x: TERNOP x
    | LWR x: TERNOP x
    | LWRE x: TERNOP x
    | LWXC1 x: TERNOP x
    | MADD x: BINOP_SRC x
    | MADD-fmt x: QUADOP_FMT x
    | MADDU x: BINOP_SRC x
    | MFC0 x: TERNOP x
    | MFC1 x: BINOP x
    | MFC2 x: BINOP x
    | MFHC1 x: BINOP x
    | MFHC2 x: BINOP x
    | MFHI x: UNOP x
    | MFLO x: UNOP x
    | MOV-fmt x: BINOP_FMT x
    | MOVF x: TERNOP x
    | MOVF-fmt x: TERNOP_FMT x
    | MOVN x: TERNOP x
    | MOVN-fmt x: TERNOP_FMT x
    | MOVT x: TERNOP x
    | MOVT-fmt x: TERNOP_FMT x
    | MOVZ x: TERNOP x
    | MOVZ-fmt x: TERNOP_FMT x
    | MSUB x: BINOP_SRC x
    | MSUB-fmt x: QUADOP_FMT x
    | MSUBU x: BINOP_SRC x
    | MTC0 x: TERNOP_SRC x
    | MTC1 x: BINOP x
    | MTC2 x: BINOP_SRC x
    | MTHC1 x: BINOP x
    | MTHC2 x: BINOP_SRC x
    | MTHI x: UNOP_SRC x
    | MTLO x: UNOP_SRC x
    | MUL x: TERNOP x
    | MUL-fmt x: TERNOP_FMT x
    | MULT x: BINOP_SRC x
    | MULTU x: BINOP_SRC x
    | NEG-fmt x: BINOP_FMT x
    | NMADD-fmt x: QUADOP_FMT x
    | NMSUB-fmt x: QUADOP_FMT x
    | NOR x: TERNOP x
    | OR x: TERNOP x
    | ORI x: TERNOP x
    | PLL-PS x: TERNOP x
    | PLU-PS x: TERNOP x
    | PREF x: TERNOP_SRC x
    | PREFE x: TERNOP_SRC x
    | PREFX x: TERNOP_SRC x
    | PUL-PS x: TERNOP x
    | PUU-PS x: TERNOP x
    | RDHWR x: BINOP x
    | RDPGPR x: BINOP x
    | RECIP-fmt x: BINOP_FMT x
    | ROTR x: TERNOP x
    | ROTRV x: TERNOP x
    | ROUND-L-fmt x: BINOP_FMT x
    | ROUND-W-fmt x: BINOP_FMT x
    | RSQRT-fmt x: BINOP_FMT x
    | SB x: TERNOP_SRC x
    | SBE x: TERNOP_SRC x
    | SC x: TERNOP x
    | SCE x: TERNOP x
    | SDBBP x: UNOP_SRC x
    | SDC1 x: TERNOP_SRC x
    | SDC2 x: TERNOP_SRC x
    | SDXC1 x: TERNOP_SRC x
    | SEB x: BINOP x
    | SEH x: BINOP x
    | SH x: TERNOP_SRC x
    | SHE x: TERNOP_SRC x
    | SLL x: TERNOP x
    | SLLV x: TERNOP x
    | SLT x: TERNOP x
    | SLTI x: TERNOP x
    | SLTIU x: TERNOP x
    | SLTU x: TERNOP x
    | SQRT-fmt x: BINOP_FMT x
    | SRA x: TERNOP x
    | SRAV x: TERNOP x
    | SRL x: TERNOP x
    | SRLV x: TERNOP x
    | SUB x: TERNOP x
    | SUB-fmt x: TERNOP_FMT x
    | SUBU x: TERNOP x
    | SUXC1 x: TERNOP_SRC x
    | SW x: TERNOP_SRC x
    | SWC1 x: TERNOP_SRC x
    | SWC2 x: TERNOP_SRC x
    | SWE x: TERNOP_SRC x
    | SWL x: TERNOP_SRC x
    | SWLE x: TERNOP_SRC x
    | SWR x: TERNOP_SRC x
    | SWRE x: TERNOP_SRC x
    | SWXC1 x: TERNOP_SRC x
    | SYNC x: UNOP_SRC x
    | SYNCI x: BINOP_SRC x
    | SYSCALL x: UNOP_SRC x
    | TEQ x: TERNOP_SRC x
    | TEQI x: BINOP_SRC x
    | TGE x: TERNOP_SRC x
    | TGEI x: BINOP_SRC x
    | TGEIU x: BINOP_SRC x
    | TGEU x: TERNOP_SRC x
    | TLBINV: NULLOP
    | TLBINVF: NULLOP
    | TLBP: NULLOP
    | TLBR: NULLOP
    | TLBWI: NULLOP
    | TLBWR: NULLOP
    | TLT x: TERNOP_SRC x
    | TLTI x: BINOP_SRC x
    | TLTIU x: BINOP_SRC x
    | TLTU x: TERNOP_SRC x
    | TNE x: TERNOP_SRC x
    | TNEI x: BINOP_SRC x
    | TRUNC-L-fmt x: BINOP_FMT x
    | TRUNC-W-fmt x: BINOP_FMT x
    | WAIT x: UNOP_SRC x
    | WRPGPR x: BINOP_SRC x
    | WSBH x: BINOP x
    | XOR x: TERNOP x
    | XORI x: TERNOP x
   end


val operands insn = 
   case (classify insn) of 
      NULLOP: 0
    | UNOP_SRC o: 1
    | UNOP o: 1
    | BINOP_SRC o: 2
    | BINOP_FMT o: 2
    | BINOP o: 2
    | TERNOP_SRC o: 3
    | TERNOP o: 3
    | TERNOP_FMT o: 3
    | QUADOP o: 4
    | QUADOP_FMT o: 4
    | QUADOP_FMT_SRC o: 4
   end


val show/mnemonic i =
   case i of
      ABS-fmt x: "ABS" +++ show/format x.fmt
    | ADD x: "ADD"
    | ADD-fmt x: "ADD" +++ show/format x.fmt
    | ADDI x: "ADDI"
    | ADDIU x: "ADDIU"
    | ADDU x: "ADDU"
    | ALNV-PS x: "ALNV.PS"
    | AND x: "AND"
    | ANDI x: "ANDI"
    | BC1F x: "BC1F"
    | BC1FL x: "BC1FL"
    | BC1T x: "BC1T"
    | BC1TL x: "BC1TL"
    | BC2F x: "BC2F"
    | BC2FL x: "BC2FL"
    | BC2T x: "BC2T"
    | BC2TL x: "BC2TL"
    | BEQ x: "BEQ"
    | BEQL x: "BEQL"
    | BGEZ x: "BGEZ"
    | BGEZAL x: "BGEZAL"
    | BGEZALL x: "BGEZALL"
    | BGEZL x: "BGEZL"
    | BGTZ x: "BGTZ"
    | BGTZL x: "BGTZL"
    | BLEZ x: "BLEZ"
    | BLEZL x: "BLEZL"
    | BLTZ x: "BLTZ"
    | BLTZAL x: "BLTZAL"
    | BLTZALL x: "BLTZALL"
    | BLTZL x: "BLTZL"
    | BNE x: "BNE"
    | BNEL x: "BNEL"
    | BREAK x: "BREAK"
    | C-cond-fmt x: "C.cond" +++ show/format x.fmt
    | CACHE x: "CACHE"
    | CACHEE x: "CACHEE"
    | CEIL-L-fmt x: "CEIL.L" +++ show/format x.fmt
    | CEIL-W-fmt x: "CEIL.W" +++ show/format x.fmt
    | CFC1 x: "CFC1"
    | CFC2 x: "CFC2"
    | CLO x: "CLO"
    | CLZ x: "CLZ"
    | COP2 x: "COP2"
    | CTC1 x: "CTC1"
    | CTC2 x: "CTC2"
    | CVT-D-fmt x: "CVT.D" +++ show/format x.fmt
    | CVT-L-fmt x: "CVT.L" +++ show/format x.fmt
    | CVT-PS-S x: "CVT.PS.S"
    | CVT-S-fmt x: "CVT.S" +++ show/format x.fmt
    | CVT-S-PL x: "CVT.S.PL"
    | CVT-S-PU x: "CVT.S.PU"
    | CVT-W-fmt x: "CVT.W" +++ show/format x.fmt
    | DERET: "DERET"
    | DI x: "DI"
    | DIV x: "DIV"
    | DIV-fmt x: "DIV" +++ show/format x.fmt
    | DIVU x: "DIVU"
    | EI x: "EI"
    | ERET: "ERET"
    | EXT x: "EXT"
    | FLOOR-L-fmt x: "FLOOR.L" +++ show/format x.fmt
    | FLOOR-W-fmt x: "FLOOR.W" +++ show/format x.fmt
    | INS x: "INS"
    | J x: "J"
    | JAL x: "JAL"
    | JALR x: "JALR"
    | JALR-HB x: "JALR.HB"
    | JALX x: "JALX"
    | JR x: "JR"
    | JR-HB x: "JR.HB"
    | LB x: "LB"
    | LBE x: "LBE"
    | LBU x: "LBU"
    | LBUE x: "LBUE"
    | LDC1 x: "LDC1"
    | LDC2 x: "LDC2"
    | LDXC1 x: "LDXC1"
    | LH x: "LH"
    | LHE x: "LHE"
    | LHU x: "LHU"
    | LHUE x: "LHUE"
    | LL x: "LL"
    | LLE x: "LLE"
    | LUI x: "LUI"
    | LUXC1 x: "LUXC1"
    | LW x: "LW"
    | LWC1 x: "LWC1"
    | LWC2 x: "LWC2"
    | LWE x: "LWE"
    | LWL x: "LWL"
    | LWLE x: "LWLE"
    | LWR x: "LWR"
    | LWRE x: "LWRE"
    | LWXC1 x: "LWXC1"
    | MADD x: "MADD"
    | MADD-fmt x: "MADD" +++ show/format x.fmt
    | MADDU x: "MADDU"
    | MFC0 x: "MFC0"
    | MFC1 x: "MFC1"
    | MFC2 x: "MFC2"
    | MFHC1 x: "MFHC1"
    | MFHC2 x: "MFHC2"
    | MFHI x: "MFHI"
    | MFLO x: "MFLO"
    | MOV-fmt x: "MOV" +++ show/format x.fmt
    | MOVF x: "MOVF"
    | MOVF-fmt x: "MOVF" +++ show/format x.fmt
    | MOVN x: "MOVN"
    | MOVN-fmt x: "MOVN" +++ show/format x.fmt
    | MOVT x: "MOVT"
    | MOVT-fmt x: "MOVT" +++ show/format x.fmt
    | MOVZ x: "MOVZ"
    | MOVZ-fmt x: "MOVZ" +++ show/format x.fmt
    | MSUB x: "MSUB"
    | MSUB-fmt x: "MSUB" +++ show/format x.fmt
    | MSUBU x: "MSUBU"
    | MTC0 x: "MTC0"
    | MTC1 x: "MTC1"
    | MTC2 x: "MTC2"
    | MTHC1 x: "MTHC1"
    | MTHC2 x: "MTHC2"
    | MTHI x: "MTHI"
    | MTLO x: "MTLO"
    | MUL x: "MUL"
    | MUL-fmt x: "MUL" +++ show/format x.fmt
    | MULT x: "MULT"
    | MULTU x: "MULTU"
    | NEG-fmt x: "NEG" +++ show/format x.fmt
    | NMADD-fmt x: "NMADD" +++ show/format x.fmt
    | NMSUB-fmt x: "NMSUB" +++ show/format x.fmt
    | NOR x: "NOR"
    | OR x: "OR"
    | ORI x: "ORI"
    | PLL-PS x: "PLL.PS"
    | PLU-PS x: "PLU.PS"
    | PREF x: "PREF"
    | PREFE x: "PREFE"
    | PREFX x: "PREFX"
    | PUL-PS x: "PUL.PS"
    | PUU-PS x: "PUU.PS"
    | RDHWR x: "RDHWR"
    | RDPGPR x: "RDPGPR"
    | RECIP-fmt x: "RECIP" +++ show/format x.fmt
    | ROTR x: "ROTR"
    | ROTRV x: "ROTRV"
    | ROUND-L-fmt x: "ROUND.L" +++ show/format x.fmt
    | ROUND-W-fmt x: "ROUND.W" +++ show/format x.fmt
    | RSQRT-fmt x: "RSQRT" +++ show/format x.fmt
    | SB x: "SB"
    | SBE x: "SBE"
    | SC x: "SC"
    | SCE x: "SCE"
    | SDBBP x: "SDBBP"
    | SDC1 x: "SDC1"
    | SDC2 x: "SDC2"
    | SDXC1 x: "SDXC1"
    | SEB x: "SEB"
    | SEH x: "SEH"
    | SH x: "SH"
    | SHE x: "SHE"
    | SLL x: "SLL"
    | SLLV x: "SLLV"
    | SLT x: "SLT"
    | SLTI x: "SLTI"
    | SLTIU x: "SLTIU"
    | SLTU x: "SLTU"
    | SQRT-fmt x: "SQRT" +++ show/format x.fmt
    | SRA x: "SRA"
    | SRAV x: "SRAV"
    | SRL x: "SRL"
    | SRLV x: "SRLV"
    | SUB x: "SUB"
    | SUB-fmt x: "SUB" +++ show/format x.fmt
    | SUBU x: "SUBU"
    | SUXC1 x: "SUXC1"
    | SW x: "SW"
    | SWC1 x: "SWC1"
    | SWC2 x: "SWC2"
    | SWE x: "SWE"
    | SWL x: "SWL"
    | SWLE x: "SWLE"
    | SWR x: "SWR"
    | SWRE x: "SWRE"
    | SWXC1 x: "SWXC1"
    | SYNC x: "SYNC"
    | SYNCI x: "SYNCI"
    | SYSCALL x: "SYSCALL"
    | TEQ x: "TEQ"
    | TEQI x: "TEQI"
    | TGE x: "TGE"
    | TGEI x: "TGEI"
    | TGEIU x: "TGEIU"
    | TGEU x: "TGEU"
    | TLBINV: "TLBINV"
    | TLBINVF: "TLBINVF"
    | TLBP: "TLBP"
    | TLBR: "TLBR"
    | TLBWI: "TLBWI"
    | TLBWR: "TLBWR"
    | TLT x: "TLT"
    | TLTI x: "TLTI"
    | TLTIU x: "TLTIU"
    | TLTU x: "TLTU"
    | TNE x: "TNE"
    | TNEI x: "TNEI"
    | TRUNC-L-fmt x: "TRUNC.L" +++ show/format x.fmt
    | TRUNC-W-fmt x: "TRUNC.W" +++ show/format x.fmt
    | WAIT x: "WAIT"
    | WRPGPR x: "WRPGPR"
    | WSBH x: "WSBH"
    | XOR x: "XOR"
    | XORI x: "XORI"
   end

# <- sutl

