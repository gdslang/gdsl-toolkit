granularity = 8
export = main

# Optional arguments
#
# Limit:
#   - Restricts the maximium size of the decode-stream
# Recursion-depth:
#   - Annotate the maximum number of recursion steps for
#     the given decoder. This way, we can compute an upper
#     bound for the maximum used storage for the emitted AST.
#     Additionally, the decoder may fail if during runtime
#     a recrusion depth violation occurs.
#
# limit = 120
# recursion-depth = main = 4

val decoder =
   let val retState x = 
      {mode64='0',
       repne='0',
       rep='0',
       rex='0',
       rexw='0',
       rexb='0',
       rexr='0',
       rexx='0',
       vexm='00001',
       vexv='0000',
       vexl='0',
       vexp='00',
       opndsz='0',
       addrsz='0',
       segment=DS,
       mod='00',
       reg='000',
       rm='000'}
   in
      do
         update retState;
         main
      end
   end

val & giveA giveB = do
   a <- giveA;
   b <- giveB;
   return (a andalso b)
end

(*val / act = do
   res <- act;
   return (not res)
end*)

val otherwise = return '1'

val opndsz? = query $opndsz
val addrsz? = query $addrsz
val repne? =  query $repne
val rep? = query $rep
val rexw? = query $rexw
val rex? = query $rex
#define mod-mem '11'
#define mod-reg '00'|'01'|'10'
(*val mod-mem? = do
   mod <- query $mod;
   case mod of
      '11': return '1'
    | otherwise: return '0'
    end
end
val mod-reg? = !mod-mem?*)
val mode64? = query $mode64

datatype size =
	B | W | DW | QW | DQW

datatype register =
   AL | AH | AX | EAX | RAX
 | BL | BH | BX | EBX | RBX
 | CL | CH | CX | ECX | RCX
 | DL | DH | DX | EDX | RDX
 | R8L | R8W | R8D | R8 
 | R9L | R9W | R9D | R9 
 | R10L | R10W | R10D | R10 
 | R11L | R11W | R11D | R11 
 | R12L | R12W | R12D | R12 
 | R13L | R13W | R13D | R13 
 | R14L | R14W | R14D | R14 
 | R15L | R15W | R15D | R15 
 | SP | ESP | RSP
 | BP | EBP | RBP
 | SI | ESI | RSI
 | DI | EDI | RDI
 | XMM0
 | XMM1
 | XMM2
 | XMM3
 | XMM4
 | XMM5
 | XMM6
 | XMM7
 | XMM8
 | XMM9
 | XMM10
 | XMM11
 | XMM12
 | XMM13
 | XMM14
 | XMM15
 | YMM0
 | YMM1
 | YMM2
 | YMM3
 | YMM4
 | YMM5
 | YMM6
 | YMM7
 | YMM8
 | YMM9
 | YMM10
 | YMM11
 | YMM12
 | YMM13
 | YMM14
 | YMM15
 | MM0
 | MM1
 | MM2
 | MM3
 | MM4
 | MM5
 | MM6
 | MM7
 | MM8
 | MM9
 | MM10
 | MM11
 | MM12
 | MM13
 | MM14
 | MM15
 | ES
 | SS
 | DS
 | FS
 | GS
 | CS

datatype opnd =
   IMM8 of 8
 | IMM16 of 16
 | IMM32 of 32
 | IMM64 of 64
 | REG of register
 | MEM of {sz: int, segment: register, opnd: opnd}
 | SUM of {a:opnd, b:opnd}
 | SCALE of {imm:2, opnd:opnd}

val al = return (REG AL)
val ah = return (REG AH)
val ax = return (REG AX)
val eax = return (REG EAX)
val rax = return (REG RAX)
val bl = return (REG BL)
val bh = return (REG BH)
val bx = return (REG BX)
val ebx = return (REG EBX)
val rbx = return (REG RBX)
val cl = return (REG CL)
val ch = return (REG CH)
val cx = return (REG CX)
val ecx = return (REG ECX)
val rcx = return (REG RCX)
val dl = return (REG DL)
val dh = return (REG DH)
val dx = return (REG DX)
val edx = return (REG EDX)
val rdx = return (REG RDX)
val sp = return (REG SP)
val esp = return (REG ESP)
val rsp = return (REG RSP)
val bp = return (REG BP)
val ebp = return (REG EBP)
val rbp = return (REG RBP)
val si = return (REG SI)
val esi = return (REG ESI)
val rsi = return (REG RSI)
val di = return (REG DI)
val edi = return (REG EDI)
val rdi = return (REG RDI)
val mm0 = return (REG MM0)
val mm1 = return (REG MM1)
val mm2 = return (REG MM2)
val mm3 = return (REG MM3)
val mm4 = return (REG MM4)
val mm5 = return (REG MM5)
val mm6 = return (REG MM6)
val mm7 = return (REG MM7)
val mm8 = return (REG MM8)
val mm9 = return (REG MM9)
val mm10 = return (REG MM10)
val mm11 = return (REG MM11)
val mm12 = return (REG MM12)
val mm13 = return (REG MM13)
val mm14 = return (REG MM14)
val mm15 = return (REG MM15)
val xmm0 = return (REG XMM0)
val xmm1 = return (REG XMM1)
val xmm2 = return (REG XMM2)
val xmm3 = return (REG XMM3)
val xmm4 = return (REG XMM4)
val xmm5 = return (REG XMM5)
val xmm6 = return (REG XMM6)
val xmm7 = return (REG XMM7)
val xmm8 = return (REG XMM8)
val xmm9 = return (REG XMM9)
val xmm10 = return (REG XMM10)
val xmm11 = return (REG XMM11)
val xmm12 = return (REG XMM12)
val xmm13 = return (REG XMM13)
val xmm14 = return (REG XMM14)
val xmm15 = return (REG XMM15)
val ymm0 = return (REG YMM0)
val ymm1 = return (REG YMM1)
val ymm2 = return (REG YMM2)
val ymm3 = return (REG YMM3)
val ymm4 = return (REG YMM4)
val ymm5 = return (REG YMM5)
val ymm6 = return (REG YMM6)
val ymm7 = return (REG YMM7)
val ymm8 = return (REG YMM8)
val ymm9 = return (REG YMM9)
val ymm10 = return (REG YMM10)
val ymm11 = return (REG YMM11)
val ymm12 = return (REG YMM12)
val ymm13 = return (REG YMM13)
val ymm14 = return (REG YMM14)
val ymm15 = return (REG YMM15)

# A type alias used for instructions taking two arguments
type unop = {opnd1:opnd}
type binop = {opnd1:opnd, opnd2:opnd}
type ternop = {opnd1:opnd, opnd2:opnd, opnd3:opnd}
type quaternop = {opnd1:opnd, opnd2:opnd, opnd3:opnd}

datatype insn =
   ADD of binop
 | CVTPD2PI of binop
 | MASKMOVDQU of binop
 | VMASKMOVDQU of binop
 | MASKMOVQ of binop
 | MAXPD of binop
 | VMAXPD of ternop
 | MAXPS of binop
 | VMAXPS of ternop
 | MAXSD of binop
 | VMAXSD of ternop
 | MAXSS of binop
 | VMAXSS of ternop
 | MFENCE
 | MINPD of binop
 | VMINPD of ternop
 | MINPS of binop
 | VMINPS of ternop
 | MINSD of binop
 | VMINSD of ternop
 | MINSS of binop
 | VMINSS of ternop
 | MONITOR
 | MOV of binop
 | MOVAPD of binop
 | VMOVAPD of binop
 | MOVAPS of binop
 | VMOVAPS of binop
 | MOVBE of binop
 | MOVD of binop
 | VMOVD of binop
 | MOVQ of binop
 | VMOVQ of binop
 | MOVDDUP of binop
 | VMOVDDUP_2 of binop
 | VMOVDDUP_3 of ternop
 | MOVDQA of binop
 | VMOVDQA of binop
 | MOVDQU of binop
 | VMOVDQU of binop
 | MOVDQ2Q of binop
 | MOVHLPS of binop
 | VMOVHLPS of ternop
 | MOVHPD of binop
 | VMOVHPD_3 of ternop
 | VMOVHPD_2 of binop
 | MOVHPS of binop
 | VMOVHPS_3 of ternop
 | VMOVHPS_2 of binop
 | MOVLHPS of binop
 | VMOVLHPS of ternop
 | MOVLPD of binop
 | VMOVLPD_3 of ternop
 | VMOVLPD_2 of binop
 | MOVLPS of binop
 | VMOVLPS_3 of ternop
 | VMOVLPS_2 of binop
 | MOVMSKPD of binop
 | VMOVMSKPD of binop
 | MOVMSKPS of binop
 | VMOVMSKPS of binop
 | MOVNTDQA of binop
 | VMOVNTDQA of binop
 | MOVNTDQ of binop
 | VMOVNTDQ of binop
 | MOVNTI of binop
 | MOVNTPD of binop
 | VMOVNTPD of binop
 | MOVNTPS of binop
 | VMOVNTPS of binop
 | MOVNTQ of binop
 | MOVQ2DQ of binop
 | MOVSB of binop
 | MOVSW of binop
 | MOVSQ of binop
 | MOVSD of binop
 | VMOVSD_3 of ternop
 | VMOVSD_2 of binop
 | MOVSHDUP of binop
 | VMOVSHDUP of binop
 | MOVSLDUP of binop
 | VMOVSLDUP of binop
 | MOVSS of binop
 | VMOVSS_3 of ternop
 | VMOVSS_2 of binop
 | MOVSX of binop
 | MOVSXD of binop
 | MOVUPD ob binop
 | VMOVUPD of binop
 | MOVUPS ob binop
 | VMOVUPS of binop
 | MOVZX of binop
 | MPSADBW of ternop
 | VMPSADBW of quaternop
 | MUL of unop
 | MULPD of binop
 | VMULPD of ternop
 | MULPS of binop
 | VMULPS of ternop
 | MULSD of binop
 | VMULSD of ternop
 | MULSS of binop
 | VMULSS of ternop
 | MWAIT
 | NEG of unop
 | NOP_0
 | NOP_1 of unop
 | NOT of unop
 | OR of binop
 | ORPD of binop
 | VORPD of ternop
 | ORPS of binop
 | VORPS of ternop
 | OUT of binop

 | PHADDW of binop
 | VPHADDW of ternop
 | PHADDD of binop
 | VPHADDD of ternop
 | XADD of binop

val imm8 ['b:8'] = return (IMM8 b)
val imm16 ['b1:8' 'b2:8'] = return (IMM16 (b1 ^ b2))
val imm32 ['b1:8' 'b2:8' 'b3:8' 'b4:8'] = return (IMM32 (b1 ^ b2 ^ b3 ^ b4))
val imm64 ['b1:8' 'b2:8' 'b3:8' 'b4:8' 'b5:8' 'b6:8' 'b7:8' 'b8:8'X86 Example Specification

- Ignore rex before legacy prefix
] =
   return (IMM64 (b1 ^ b2 ^ b3 ^ b4 ^ b5 ^ b6 ^ b7 ^ b8))

## Convert a bit-vectors to registers

val reg8 n =
   case n of
      '0000': REG AL
    | '0001': REG CL
    | '0010': REG DL
    | '0011': REG BL
    | '0100': REG AH
    | '0101': REG CH
    | '0110': REG DH
    | '0111': REG BH
    | '1000': REG R8L
    | '1001': REG R10L
    | '1010': REG R11L
    | '1011': REG R9L
    | '1100': REG R12L
    | '1101': REG R13L
    | '1110': REG R14L
    | '1111': REG R15L
   end

val reg8-lower n = reg8 ('0' ^ n)
val reg8-higher n = reg8 ('1' ^ n)
val reg8-rex rex = if rex then reg8-higher else reg8-lower

val reg16 n =
   case n of
      '0000': REG AX
    | '0001': REG CX
    | '0010': REG DX
    | '0011': REG BX
    | '0100': REG SP
    | '0101': REG BP
    | '0110': REG SI
    | '0111': REG DI
    | '1000': REG R8L
    | '1001': REG R10L
    | '1010': REG R11L
    | '1011': REG R9L
    | '1100': REG R12L
    | '1101': REG R13L
    | '1110': REG R14L
    | '1111': REG R15L
   end

val reg16-lower n = reg16 ('0' ^ n)
val reg16-higher n = reg16 ('1' ^ n)
val reg16-rex rex = if rex then reg16-higher else reg16-lower

val reg32 n =
   case n of
      '0000': REG EAX
    | '0001': REG ECX
    | '0010': REG EDX
    | '0011': REG EBX
    | '0100': REG ESP
    | '0101': REG EBP
    | '0110': REG ESI
    | '0111': REG EDI
    | '1000': REG R8D
    | '1001': REG R10D
    | '1010': REG R11D
    | '1011': REG R9D
    | '1100': REG R12D
    | '1101': REG R13D
    | '1110': REG R14D
    | '1111': REG R15D
   end

val reg32-lower n = reg32 ('0' ^ n)
val reg32-higher n = reg32 ('1' ^ n)
val reg32-rex rex = if rex then reg32-higher else reg32-lower

val reg64 n =
   case n of
      '0000': REG RAX
    | '0001': REG RCX
    | '0010': REG RDX
    | '0011': REG RBX
    | '0100': REG RSP
    | '0101': REG RBP
    | '0110': REG RSI
    | '0111': REG RDI
    | '1000': REG R8
    | '1001': REG R10
    | '1010': REG R11
    | '1011': REG R9
    | '1100': REG R12
    | '1101': REG R13
    | '1110': REG R14
    | '1111': REG R15
   end

val reg64-lower n = reg64 ('0' ^ n)
val reg64-higher n = reg64 ('1' ^ n)
val reg64-rex rex = if rex then reg64-higher else reg64-lower

val sreg3 n =
   case n of
      '000': REG ES
    | '001': REG CS
    | '010': REG SS
    | '011': REG DS
    | '100': REG FS
    | '101': REG GS
#| '110': reserved
#| '111': reserved
   end

val sreg3? rex = sreg3

val mm n =
   case n of
      '0000': REG MM0
    | '0001': REG MM1
    | '0010': REG MM2
    | '0011': REG MM3
    | '0100': REG MM4
    | '0101': REG MM5
    | '0110': REG MM6
    | '0111': REG MM7
    | '1000': REG MM8
    | '1001': REG MM9
    | '1010': REG MM10
    | '1011': REG MM11
    | '1100': REG MM12
    | '1101': REG MM13
    | '1110': REG MM14
    | '1111': REG MM15
   end

val mm-lower n = mm ('0' ^ n)
val mm-higher n = mm ('1' ^ n)
val mm-rex rex = if rex then mm-higher else mm-lower

val xmm n =
   case n of
      '0000': REG XMM0
    | '0001': REG XMM1
    | '0010': REG XMM2
    | '0011': REG XMM3
    | '0100': REG XMM4
    | '0101': REG XMM5
    | '0110': REG XMM6
    | '0111': REG XMM7
    | '1000': REG XMM8
    | '1001': REG XMM9
    | '1010': REG XMM10
    | '1011': REG XMM11
    | '1100': REG XMM12
    | '1101': REG XMM13
    | '1110': REG XMM14
    | '1111': REG XMM15
   end

val xmm-lower n = xmm ('0' ^ n)
val xmm-higher n = xmm ('1' ^ n)
val xmm-rex rex = if rex then xmm-higher else xmm-lower

val ymm n =
   case n of
      '0000': REG YMM0
    | '0001': REG YMM1
    | '0010': REG YMM2
    | '0011': REG YMM3
    | '0100': REG YMM4
    | '0101': REG YMM5
    | '0110': REG YMM6
    | '0111': REG YMM7
    | '1000': REG YMM8
    | '1001': REG YMM9
    | '1010': REG YMM10
    | '1011': REG YMM11
    | '1100': REG YMM12
    | '1101': REG YMM13
    | '1110': REG YMM14
    | '1111': REG YMM15
   end

val ymm-lower n = ymm ('0' ^ n)
val ymm-higher n = ymm ('1' ^ n)
val ymm-rex rex = if rex then ymm-higher else ymm-lower

# Deslice the mod/rm byte and put it into the the state

val /0 ['mod:2 000 rm:3'] = update @{mod=mod, rm=rm, reg/opcode='000'}
val /1 ['mod:2 001 rm:3'] = update @{mod=mod, rm=rm, reg/opcode='001'}
val /2 ['mod:2 010 rm:3'] = update @{mod=mod, rm=rm, reg/opcode='010'}
val /3 ['mod:2 011 rm:3'] = update @{mod=mod, rm=rm, reg/opcode='011'}
val /4 ['mod:2 100 rm:3'] = update @{mod=mod, rm=rm, reg/opcode='100'}
val /5 ['mod:2 101 rm:3'] = update @{mod=mod, rm=rm, reg/opcode='101'}
val /6 ['mod:2 110 rm:3'] = update @{mod=mod, rm=rm, reg/opcode='110'}
val /7 ['mod:2 111 rm:3'] = update @{mod=mod, rm=rm, reg/opcode='111'}
val /r ['mod:2 reg/opcode:3 rm:3'] = update @{mod=mod, reg/opcode=reg/opcode, rm=rm}

## Decoding the SIB byte
#    TODO: this is only for 32bit addressing

val sib-without-index reg = do
   mod <- query $mod;
   rexb <- query $rexb;
   case mod of
      '00': imm32
    | '01': return ((reg rexb) '101') # rBP
    | '10': return ((reg rexb) '101') # rBP
   end
end

val sib-without-base reg scale index = do
   rexx <- query $rexx;
   let
      val scaled = SCALE{imm=scale, opnd=(reg rexx) index}
   in
      do
         mod <- query $mod;
	      rexb <- query $rexb;
         case mod of
            '00': 
               do
                  i <- imm32;
                  return (SUM{a=scaled, b=i})
               end
          | _ : return (SUM{a=scaled, b=(reg rexb) '101'}) # rBP
         end
      end
   end
end

val sib-with-index-and-base reg s i b = do
   rexx <- query $rexx;
   rexb <- query $rexb;
   return (SUM{a=SCALE{imm=s, opnd=(reg rexx) i}, b=(reg rexb) b})
end

val sib ['scale:2 100 101']
 | addrsz? = sib-without-index reg16-rex
 | otherwise = sib-without-index reg32-rex

val sib ['scale:2 index:3 101'] 
 | addrsz? = sib-without-base reg16-rex scale index
 | otherwise = sib-without-base reg32-rex scale index

val sib ['scale:2 index:3 base:3']
 | addrsz? = sib-with-index-and-base reg16-rex scale index base
 | otherwise = sib-with-index-and-base reg32-rex scale index base

## Decoding the mod/rm byte

val addrsz = do
   sz <- query $addrsz;
   case sz of
      '1': return 16
    | '0': return 32
   end
end

val mem op = do
   sz <- addrsz;
   seg <- query $segment;
   return (MEM {sz=sz, segment=seg, opnd=op})
end

val r/m-with-sib = do
   sibOpnd <- sib;
   mod <- query $mod;
   case mod of
      '00': mem sibOpnd
    | '01':
         do
            i <- imm8;
            mem (SUM{a=sibOpnd, b=i})
         end
    | '10':
         do
            i <- imm32;
            mem (SUM{a=sibOpnd, b=i})
         end
   end
end

val r/m-without-sib reg addr-reg = do
   mod <- query $mod;
   rm <- query $rm;
   case mod of
      '00':
         case rm of
            '101':
               do
                  i <- imm32;
                  mem i
               end
          | _ : mem (addr-reg rm)
         end
    | '01':
         do
            i <- imm8;
            mem (SUM{a=addr-reg rm, b=i})
         end
    | '10':
         do
            i <- imm32;
            mem (SUM{a=addr-reg rm, b=i})
         end
    | '11': return (reg rm)
   end
end

val addrReg = do
   addrsz <- query $addrsz;
   case addrsz of
      '0': return reg64-rex
    | '1': return reg32-rex
   end
end

val r/m reg = do
   mod <- query $mod;
   rm <- query $rm;
   rexb <- query $rexb;
   addr-reg <- addrReg;
   case rm of
      '100': r/m-with-sib
    | _ : r/m-without-sib (reg rexb) (addr-reg rexb)
   end
end

val r/m8 = r/m reg8-rex
val r/m16 = r/m reg16-rex
val r/m32 = r/m reg32-rex
val r/m64 = r/m reg64-rex
val mm/m64 = r/m mm-rex
val xmm/m128 = r/m xmm-rex
val xmm/m64 = r/m xmm-rex
val xmm/m32 = r/m xmm-rex
val ymm/m256 = r/m ymm-rex

val reg/nomem reg = do
   mod <- query $mod;
   case mod of
      '11': r/m reg
   end
end
val xmm/nomem128 = reg/nomem xmm-rex
val mm/nomem64 = reg/nomem mm-rex

val m r/m = do
   mod <- query $mod;
   case mod of
      '00': r/m
    | '01': r/m
    | '10': r/m
   end
#   if (unsigned (not mod)) > 0 then r/m else r/m
end
val m16 = m r/m16
val m32 = m r/m32
val m64 = m r/m64
val m128 = m xmm/m128
val m256 = m ymm/m256

val r/ reg = do
   rexr <- query $rexr;
   r <- query $reg;
   return ((reg rexr) r)
end

val r8 = r/ reg8-rex
val r16 = r/ reg16-rex
val r32 = r/ reg32-rex
val r64 = r/ reg64-rex
val mm64 = r/ mm-rex
val xmm128 = r/ xmm-rex
val ymm256 = r/ ymm-rex

val vex/'mm mmF = do
   vexv <- query $vexv;
   return (mmF (not vexv))
end
val vex/xmm = vex/'mm xmm
val vex/ymm = vex/'mm ymm

val moffs8 = do
   i <- imm8;
   mem i
end

val moffs16 = do
   i <- imm16;
   mem i
end

val moffs32 = do
   i <- imm32;
   mem i
end

val moffs64 = do
   i <- imm64;
   mem i
end

val binop cons giveOp1 giveOp2 = do
   op1 <- giveOp1;
   op2 <- giveOp2;
   return (cons {opnd1=op1, opnd2=op2})
   # We could binop ADD syntatic sugar for record field creation:
   #   return (MOV {op1, op2})
end

val ternop cons giveOp1 giveOp2 giveOp3 = do
   op1 <- giveOp1;
   op2 <- giveOp2;
   op3 <- giveOp3;
   return (cons {opnd1=op1, opnd2=op2, opnd3=op3})
end

## The VEX prefixes

val vex-pp pp =
   case pp of
      '01': update @{opndsz='1'}
#    | '10': => F3 Prefix
#    | '11': => F2 Prefix
   end

val /vex [0xc4 'r:1 x:1 b:1 m:5' 'w:1 v:4 l:1 p:2']
 | !rex? = do
   update @{rexr=r, rexx=x, rexb=b, vexm=m, rexw=w, vexv=v, vexl=l, vexp=p};
   vex-pp pp
end

val /vex [0xc5 'r:1 v:4 l:1 p:2' x='0' b='0' m='00001' w='0'] 
 | !rex? = do
   update @{rexr=r, rexx=x, rexb=b, vexm=m, rexw=w, vexv=v, vexl=l, vexp=p};
   vex-pp pp
end

#define vex-128 '1'
val vex-128? = query $vexl

#define vex-256 '0'
val vex-256? = do
   b <- query $vexl;
   return (not b)
end

#define vex-noreg '1111'
val vex-noreg? = do 
   v <- query $vexv;
   return (v == '1111')
end

#define vex-66 '01'
val vex-66? = do
   p <- query $vexp;
   return (p == '01')
end

#define vex-f2 '11'
val vex-f2? = do
   p <- query $vexp;
   return (p == '11')
end

#define vex-f3 '10'
val vex-f3? = do
   p <- query $vexp;
   return (p == '10')
end

#define vex-nosimd '00'
val vex-nosimd? = do
   p <- query $vexp;
   return (p == '00')
end

#define vex-0f '00001'
#define vex-0f-38 '00010'
#define vex-0f-3a '00011'

# Rückgabewert in Pattern??

## The REX prefixes

val /rex ['0100 w:1 r:1 x:1 b:1'] = update @{rex='1', rexw=w, rexb=b, rexx=x, rexr=r}

## Decode prefixes, recursion could be limited with "recursion-depth main = 4" 

val main [0x2e] = do update @{segment=CS}; main end
val main [0x36] = do update @{segment=SS}; main end
val main [0x3e] = do update @{segment=DS}; main end
val main [0x26] = do update @{segment=ES}; main end
val main [0x64] = do update @{segment=FS}; main end
val main [0x65] = do update @{segment=GS}; main end
val main [0x66] = do update @{opndsz='1'}; p66 end
val main [0x67] = do update @{addrsz='1'}; main end
val main [0xf2] = do update @{repne='1'}; pf2 end
val main [0xf3] = do update @{rep='1'}; pf3 end
val main [/rex] = main #Todo: Ignore REX before legacy prefixes
(*val main [/vex] = do #Todo: (REX|0x66|0xf2|0xf3) + VEX => Error
   vexm <- query $vexm;
   case vexm of
      '00001': vex-0f 
    | '00010': vex-0f-38
#   | '00011': vex-0f-3a
#   | _: main
    end
end
val vex-0f = do
   v <- query $vexv;
   case v of
      '1111': vex-0f-noreg
     | _ : vex-0f-reg
end
val vex-0f-38 = do
   v <- query $vexv;
   case v of
      '1111': vex-0f-38-noreg
     | _ : vex-0f-38-reg
end
val vex-0f-3a = do
   v <- query $vexv;
   case v of
      '1111': vex-0f-3a-noreg
     | _ : vex-0f-3a-reg
end*)

val rex-clear = do
   update @{rexw='0'};
   update @{rexb='0'};
   update @{rexr='0'};
   update @{rexx='0'};
end

val p66 [0x2e] = do rex-clear; update @{segment=CS}; p66 end
val p66 [0x36] = do rex-clear; update @{segment=SS}; p66 end
val p66 [0x3e] = do rex-clear; update @{segment=DS}; p66 end
val p66 [0x26] = do rex-clear; update @{segment=ES}; p66 end
val p66 [0x64] = do rex-clear; update @{segment=FS}; p66 end
val p66 [0x65] = do rex-clear; update @{segment=GS}; p66 end
val p66 [0x66] = do rex-clear; update @{opndsz='1'}; p66 end
val p66 [0x67] = do rex-clear; update @{addrsz='1'}; p66 end
val p66 [0xf2] = do rex-clear; update @{repne='1'}; p66-f2 end
val p66 [0xf3] = do rex-clear; update @{rep='1'}; p66-f3 end
val p66 [/rex] = p66

val pf2 [0x2e] = do rex-clear; update @{segment=CS}; pf2 end
val pf2 [0x36] = do rex-clear; update @{segment=SS}; pf2 end
val pf2 [0x3e] = do rex-clear; update @{segment=DS}; pf2 end
val pf2 [0x26] = do rex-clear; update @{segment=ES}; pf2 end
val pf2 [0x64] = do rex-clear; update @{segment=FS}; pf2 end
val pf2 [0x65] = do rex-clear; update @{segment=GS}; pf2 end
val pf2 [0x66] = do rex-clear; update @{opndsz='1'}; p66-f2 end
val pf2 [0x67] = do rex-clear; update @{addrsz='1'}; pf2 end
val pf2 [0xf2] = do rex-clear; update @{repne='1'}; pf2 end
val pf2 [0xf3] = do rex-clear; update @{rep='1'}; pf2-f3 end
val pf2 [/rex] = main

val pf3 [0x2e] = do rex-clear; update @{segment=CS}; pf3 end
val pf3 [0x36] = do rex-clear; update @{segment=SS}; pf3 end
val pf3 [0x3e] = do rex-clear; update @{segment=DS}; pf3 end
val pf3 [0x26] = do rex-clear; update @{segment=ES}; pf3 end
val pf3 [0x64] = do rex-clear; update @{segment=FS}; pf3 end
val pf3 [0x65] = do rex-clear; update @{segment=GS}; pf3 end
val pf3 [0x66] = do rex-clear; update @{opndsz='1'}; p66-f3 end
val pf3 [0x67] = do rex-clear; update @{addrsz='1'}; pf3 end
val pf3 [0xf2] = do rex-clear; update @{repne='1'}; pf2-f3 end
val pf3 [0xf3] = do rex-clear; update @{rep='1'}; pf3 end
val pf3 [/rex] = main

val p66-f2 [0x2e] = do rex-clear; update @{segment=CS}; p66-f2 end
val p66-f2 [0x36] = do rex-clear; update @{segment=SS}; p66-f2 end
val p66-f2 [0x3e] = do rex-clear; update @{segment=DS}; p66-f2 end
val p66-f2 [0x26] = do rex-clear; update @{segment=ES}; p66-f2 end
val p66-f2 [0x64] = do rex-clear; update @{segment=FS}; p66-f2 end
val p66-f2 [0x65] = do rex-clear; update @{segment=GS}; p66-f2 end
val p66-f2 [0x66] = do rex-clear; update @{opndsz='1'}; p66-f2 end
val p66-f2 [0x67] = do rex-clear; update @{addrsz='1'}; p66-f2 end
val p66-f2 [0xf2] = do rex-clear; update @{repne='1'}; p66-f2 end
val p66-f2 [0xf3] = do rex-clear; update @{rep='1'}; p66-f2-f3 end
val p66-f2 [/rex] = main

val p66-f3 [0x2e] = do rex-clear; update @{segment=CS}; p66-f3 end
val p66-f3 [0x36] = do rex-clear; update @{segment=SS}; p66-f3 end
val p66-f3 [0x3e] = do rex-clear; update @{segment=DS}; p66-f3 end
val p66-f3 [0x26] = do rex-clear; update @{segment=ES}; p66-f3 end
val p66-f3 [0x64] = do rex-clear; update @{segment=FS}; p66-f3 end
val p66-f3 [0x65] = do rex-clear; update @{segment=GS}; p66-f3 end
val p66-f3 [0x66] = do rex-clear; update @{opndsz='1'}; p66-f3 end
val p66-f3 [0x67] = do rex-clear; update @{addrsz='1'}; p66-f3 end
val p66-f3 [0xf2] = do rex-clear; update @{repne='1'}; p66-f2-f3 end
val p66-f3 [0xf3] = do rex-clear; update @{rep='1'}; p66-f3 end
val p66-f3 [/rex] = main

val p66-f2-f3 [0x2e] = do rex-clear; update @{segment=CS}; p66-f2-f3 end
val p66-f2-f3 [0x36] = do rex-clear; update @{segment=SS}; p66-f2-f3 end
val p66-f2-f3 [0x3e] = do rex-clear; update @{segment=DS}; p66-f2-f3 end
val p66-f2-f3 [0x26] = do rex-clear; update @{segment=ES}; p66-f2-f3 end
val p66-f2-f3 [0x64] = do rex-clear; update @{segment=FS}; p66-f2-f3 end
val p66-f2-f3 [0x65] = do rex-clear; update @{segment=GS}; p66-f2-f3 end
val p66-f2-f3 [0x66] = do rex-clear; update @{opndsz='1'}; p66-f2-f3 end
val p66-f2-f3 [0x67] = do rex-clear; update @{addrsz='1'}; p66-f2-f3 end
val p66-f2-f3 [0xf2] = do rex-clear; update @{repne='1'}; p66-f2-f3 end
val p66-f2-f3 [0xf3] = do rex-clear; update @{rep='1'}; p66-f2-f3 end
val p66-f2-f3 [/rex] = main

val p66-f2 [] = p66
val p66-f3 [] = p66
val p66-f2-f3 [] = p66
val pf2 [] = main
val pf3 [] = main
val pf2-f3 [] = main

## Instruction decoders

## One Byte Opcodes
## Two Byte Opcodes with Prefix 0x0f
## Three Byte Opcodes with Prefix 0x0f38

### ADD Vol. 2A 3-35
val main [0x04] = binop ADD al imm8
val main [0x05]
 | rexw? = binop ADD rax imm64
 | otherwise = binop ADD eax imm32
val p66 [0x05] = binop ADD ax imm16
val main [0x80 /0] = binop ADD r/m8 imm8
val main [0x81 /0]
 | rexw? = binop ADD r/m64 imm64
 | otherwise = binop ADD r/m32 imm32
val p66 [0x81 /0] = binop ADD r/m16 imm16
val main [0x83 /0]
 | rexw? = binop ADD r/m64 imm8
 | otherwise = binop ADD r/m32 imm8
val p66 [0x83 /0] = binop ADD r/m16 imm8
val main [0x00 /r] = binop ADD r/m8 r8
val main [0x01 /0]
 | rexw? = binop ADD r/m64 r64
 | otherwise = binop ADD r/m32 r32
val p66 [0x01 /0] = binop ADD r/m16 r16
val main [0x02 /r] = binop ADD r8 r/m8
val main [0x03 /0]
 | rexw? = binop ADD r64 r/m64
 | otherwise = binop ADD r32 r/m32
val p66 [0x03 /0] = binop ADD r16 r/m16

### CVTPD2PI Vol 2A 3-248
val p66 [0x0f 0x2d /r] = binop CVTPD2PI mm64 xmm/m128

### MASKMOVDQU Vol. 2B 4-9
val p66 [0x0f 0xf7 /r] = binop MASKMOVDQU xmm128 xmm/nomem128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-66> 0xf7 /r] = binop VMASKMOVDQU xmm128 xmm/nomem128

### MASKMOVQ Vol. 2B 4-11
val main [0x0f 0xf7 /r] = binop MASKMOVQ mm64 mm/nomem64

### MAXPD Vol. 2B 4-13
val main [0x0f 0x5f /r] = binop maxpd xmm128 xmm/m128
val main [/vex<m=vex-0f,l=vex-128,p=vex-66> 0x5f /r] = ternop VMAXPD xmm128 vex/xmm xmm/m128
val main [/vex<m=vex-0f,l=vex-256,p=vex-66> 0x5f /r] = ternop VMAXPD ymm256 vex/ymm ymm/m256

### MAXPS 4-16 Vol. 2B
val main [0x0f 0x5f /r] = binop MAXPS xmm128 xmm/m128
val main [/vex<m=vex-0f,l=vex-128,p=vex-nosimd> 0x5f /r] = ternop VMAXPS xmm128 vex/xmm xmm/m128
val main [/vex<m=vex-0f,l=vex-256,p=vex-nosimd> 0x5f /r] = ternop VMAXPS ymm256 vex/ymm ymm/m256

### MAXSD Vol. 2B 4-19
val pf2 [0x0f 0x5f /r] = binop MAXSD xmm128 xmm/m64
val main [/vex<m=vex-0f,p=vex-f2> 0x5f /r] = ternop VMAXSD xmm128 vex/xmm xmm/m64

### MAXSS Vol. 2B 4-21
val pf3 [0x0f 0x5f /r] = binop MAXSS xmm128 xmm/m32
val main [/vex<m=vex-0f,p=vex-f3> 0x5f /r] = ternop VMAXSS xmm128 vex/xmm xmm/m32

### MFENCE Vol. 2B 4-23
val main [0x0f 0xae /6] = MFENCE

### MINPD Vol. 2B 4-25
val p66 [0x0f 0x5d /r] = binop MINPD xmm128 xmm/m128
val main [/vex<m=vex-0f,l=vex-128,p=vex-66> 0x5d /r] = ternop VMINPD xmm128 vex/xmm xmm/m128
val main [/vex<m=vex-0f,l=vex-256,p=vex-66> 0x5d /r] = ternop VMINPD ymm256 vex/ymm ymm/m256

### MINPS Vol. 2B 4-28
val main [0x0f 0x5d /r] = binop MINPS xmm128 xmm/m128
val main [/vex<m=vex-0f,l=vex-128,p=vex-nosimd> 0x5d /r] = ternop VMINPS xmm128 vex/xmm xmm/m128
val main [/vex<m=vex-0f,l=vex-256,p=vex-nosimd> 0x5d /r] = ternop VMINPS ymm256 vex/ymm ymm/m256

### MINSD Vol. 2B 4-31
val pf2 [0x0f 0x5d /r] = MINSD xmm128 xmm/m64
val main [/vex<m=vex-0f,p=vex-f2> 0x5d /r] = ternop VMINSD xmm128 vex/xmm xmm/m64

### MINSS Vol. 2B 4-33
val pf3 [0x0f 0x5d /r] = binop MINSS xmm128 xmm/m32
val main [/vex<m=vex-0f,p=vex-f3> 0x5d /r] = ternop VMINSS xmm128 vex/xmm xmm/m32

### MONITOR Vol. 2B 4-35
val main [0x0f 0xae 0x01 0xc8] = MONITOR

### MOV Vol 2A 3-643
val main [0x88 /r] = binop MOV r/m8 r8
val p66 [0x89 /r] = binop MOV r/m16 r16
val main [0x89 /r]
 | rexw? = binop MOV r/m64 r64
 | otherwise = binop MOV r/m32 r32
val main [0x8a /r] = binop MOV r8 r/m8
val p66 [0x8b /r] = binop MOV r16 r/m16
val main [0x8b /r] = binop MOV r32 r/m32
val main [0x8c /r] = binop MOV r/m16 (r/ sreg3?)
val main [0x8e /r] = binop MOV (r/ sreg3?) r/m16
val main [0xa0] = binop MOV al moffs8 
val main [0xa1]
 | addrsz? = binop MOV ax moffs16
 | otherwise = binop MOV eax moffs32
val main [0xa2] = binop MOV moffs8 al
val main [0xa3]
 | addrsz? = binop MOV moffs16 ax
 | otherwise = binop MOV moffs32 eax
val main [0xb0] = binop MOV al imm8
val main [0xb1] = binop MOV cl imm8
val main [0xb2] = binop MOV dl imm8
val main [0xb3] = binop MOV bl imm8
val main [0xb4] = binop MOV ah imm8
val main [0xb5] = binop MOV ch imm8
val main [0xb6] = binop MOV dh imm8
val main [0xb7] = binop MOV bh imm8
val p66 [0xb8] = binop MOV ax imm16
val main [0xb8] = binop MOV eax imm32
val p66 [0xb9] = binop MOV cx imm16
val main [0xb9] = binop MOV ecx imm32
val p66 [0xba] = binop MOV dx imm16
val main [0xba] = binop MOV edx imm32
val p66 [0xbb] = binop MOV bx imm16
val main [0xbb] = binop MOV ebx imm32
val p66 [0xbc] = binop MOV sp imm16
val main [0xbc] = binop MOV esp imm32
val p66 [0xbd] = binop MOV bp imm16
val main [0xbd] = binop MOV ebp imm32
val p66 [0xbe] = binop MOV si imm16
val main [0xbe] = binop MOV esi imm32
val p66 [0xbf] = binop MOV di imm16
val main [0xbf] = binop MOV edi imm32
val main [0xc6 /0] = binop MOV r/m8 imm8
val p66 [0xc7 /0] = binop MOV r/m16 imm16
val main [0xc7 /0] = binop MOV r/m32 imm32

### MOVAPD Vol. 2B 4-52
val p66 [0x0f 0x28 /r] = binop MOVAPD xmm128 xmm/m128
val p66 [0x0f 0x29 /r] = binop MOVAPD xmm/m128 xmm128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-66> 0x28 /r] = binop VMOVAPD xmm128 xmm/m128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-256,p=vex-66> 0x28 /r] = binop VMOVAPD ymm256 ymm/m256
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-66> 0x29 /r] = binop VMOVAPD xmm/m128 xmm128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-256,p=vex-66> 0x29 /r] = binop VMOVAPD ymm/m256 ymm256

### MOVAPS Vol. 2B 4-55
val main [0x0f 0x28 /r] = binop MOVAPS xmm128 xmm/m128
val main [0x0f 0x29 /r] = binop MOVAPS xmm/m128 xmm128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-nosimd> 0x28 /r] = binop VMOVAPS xmm128 xmm/m128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-256,p=vex-nosimd> 0x28 /r] = binop VMOVAPS ymm256 ymm/m256
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-nosimd> 0x29 /r] = binop VMOVAPS xmm/m128 xmm128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-256,p=vex-nosimd> 0x29 /r] = binop VMOVAPS ymm/m256 ymm256

### MOVBE Vol. 2B 4-58
val p66 [0x0f 0x38 0xf0 /r] = binop MOVBE r16 m16
val main [0x0f 0x38 0xf0 /r]
 | rexw? = binop MOVBE r64 m64
 | otherwise = binop MOVBE r32 m32
val p66 [0x0f 0x38 0xf1 /r] = binop MOVBE m16 r16
val main [0x0f 0x38 0xf1 /r]
 | rexw? = binop MOVBE m64 r64
 | otherwise = binop MOVBE m32 r32

### MOVD/MOVQ Vol. 2B 4-61
val main [0x0f 0x6e /r]
 | rexw? = binop MOVQ mm64 r/m64
 | otherwise = binop MOVD mm64 r/m32
val main [0x0f 0x7e /r]
 | rexw? = binop MOVQ r/m64 mm64
 | otherwise = binop MOVD r/m32 mm64
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-66> 0x6e /r]
 | rexw? = binop VMOVD xmm128 r/m64
 | otherwise = binop VMOVD xmm128 r/m32
val p66 [0x0f 0x6e /r]
 | rexw? = binop MOVQ xmm128 r/m64
 | otherwise = binop MOVD xmm128 r/m32
val p66 [0x0f 0x7e /r]
 | rexw? = binop MOVQ r/m64 xmm128
 | otherwise = binop MOVD r/m32 xmm128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-66> 0x7e /r]
 | rexw? = binop VMOVD r/m64 xmm128
 | otherwise = binop VMOVD r/m32 xmm128

### MOVDDUP Vol. 2B 4-64
val pf2 [0x0f 0x12 /r] = binop MOVDDUP xmm128 xmm/m64
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-f2> 0x12 /r] = binop VMOVDDUP_2 xmm128 xmm/m64
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-256,p=vex-f2> 0x12 /r] = ternop VMOVDDUP_3 vmovddup ymm256 ymm/m256

### MOVDQA Vol. 2B 4-67
val p66 [0x0f 0x6f /r] = binop MOVDQA xmm128 xmm/m128
val p66 [0x0f 0x7f /r] = binop MOVDQA xmm/m128 xmm128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-66> 0x6f /r] = binop VMOVDQA xmm128 xmm/m128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-256,p=vex-66> 0x6f /r] = binop VMOVDQA ymm256 ymm/m256
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-66> 0x7f /r] = binop VMOVDQA xmm/m128 xmm128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-256,p=vex-66> 0x7f /r] = binop VMOVDQA ymm/m256 ymm256

### MOVDQU Vol. 2B 4-70
val pf3 [0x0f 0x6f /r] = binop MOVDQU xmm128 xmm/m128
val pf3 [0x0f 0x7f /r] = binop MOVDQU xmm/m128 xmm128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-f3> 0x6f /r] = binop VMOVDQU xmm128 xmm/m128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-256,p=vex-f3> 0x6f /r] = binop VMOVDQU ymm256 ymm/m256
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-f3> 0x7f /r] = binop VMOVDQU xmm/m128 xmm128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-256,p=vex-f3> 0x7f /r] = binop VMOVDQU ymm/m256 ymm256

### MOVDQ2Q Vol. 2B 4-73
val pf2 [0x0f 0xd6 /r] = binop MOVDQ2Q mm64 xmm128

### MOVHLPS Vol. 2B 4-75
val main [0x0f 0x12 /r<mod=mod-reg>] = binop MOVHLPS xmm128 xmm/nomem128
val main [/vex<m=vex-0f,l=vex-128,p=vex-nosimd> 0x12 /r<mod=mod-reg>] = ternop VMOVHLPS xmm128 vex/xmm xmm/nomem128

### MOVHPD Vol. 2B 4-77
val p66 [0x0f 0x16 /r] = binop MOVHPD xmm128 m64
val p66 [0x0f 0x17 /r] = binop MOVHPD m64 xmm128
val main [/vex<m=vex-0f,l=vex-128,p=vex-66> 0x16 /r] = ternop VMOVHPD_3 xmm128 vex/xmm m64
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-66> 0x17 /r] = binop VMOVHPD_2 m64 xmm128

### MOVHPS Vol. 2B 4-79
val main [0x0f 0x16 /r<mod=mod-mem>] = binop MOVHPS xmm128 m64
val main [0x0f 0x17 /r<mod=mod-mem>] = binop MOVHPS m64 xmm128
val main [/vex<m=vex-0f,l=vex-128,p=vex-nosimd> 0x16 /r<mod=mod-mem>] = ternop VMOVHPS_3 xmm128 vex/xmm m64
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-nosimd> 0x17 /r<mod=mod-mem>] = binop VMOVHPS_2 m64 xmm128

### MOVLHPS Vol. 2B 4-81
val main [0x0f 0x16 /r<mod=mod-reg>] = binop MOVLHPS xmm128 xmm/nomem128
val main [/vex<m=vex-0f,l=vex-128,p=vex-nosimd> 0x16 /r<mod=mod-reg>] = ternop VMOVLHPS xmm128 vex/xmm xmm/nomem128

### MOVLPD Vol. 2B 4-83
val p66 [0x0f 0x12 /r] = binop MOVLPD xmm128 m64
val p66 [0x0f 0x13 /r] = binop MOVLPD m64 xmm128
val main [/vex<m=vex-0f,l=vex-128,p=vex-66> 0x12 /r] = ternop VMOVLPD_3 xmm128 vex/xmm m64
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-66> 0x13 /r] = binop VMOVLPD_2 m64 xmm128

### MOVLPS Vol. 2B 4-85
val main [0x0f 0x12 /r<mod=mod-mem>] = binop MOVLPS xmm128 m64
val main [0x0f 0x13 /r<mod=mod-mem>] = binop MOVLPS m64 xmm128
val main [/vex<m=vex-0f,l=vex-128,p=vex-nosimd> 0x12 /r<mod=mod-mem>] = ternop VMOVLPS_3 xmm128 vex/xmm m64
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-nosimd> 0x13 /r<mod=mod-mem>] = binop VMOVLPS_2 m64 xmm128

### MOVMSKPD Vol. 2B 4-87
val p66 [0x0f 0x50 /r]
 | mode64? = binop MOVMSKPD r64 xmm128
 | otherwise = binop MOVMSKPD r32 xmm128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-66> 0x50 /r]
 | mode64? = binop VMOVMSKPD r64 xmm128
 | otherwise = binop VMOVMSKPD r64 xmm128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-256,p=vex-66> 0x50 /r]
 | mode64? = binop VMOVMSKPD r64 ymm256
 | otherwise = binop VMOVMSKPD r64 ymm256
(*#########################
##### ~~ VERIFY! ~~ #####
#########################*)

### MOVMSKPS Vol. 2B 4-89
val movmskps = binop MOVMSKPS
val vmovmskps = binop VMOVMSKPS
val main [0x0f 0x50 /r]
 | mode64? = binop MOVMSKPS r64 xmm128
 | otherwise = binop MOVMSKPS r32 xmm128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-nosimd> 0x50 /r]
 | mode64? = binop VMOVMSKPS r64 xmm128
 | otherwise = binop VMOVMSKPS r64 xmm128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-256,p=vex-nosimd> 0x50 /r]
 | mode64? = binop VMOVMSKPS r64 ymm256
 | otherwise = binop VMOVMSKPS r64 ymm256
(*#########################
##### ~~ VERIFY! ~~ #####
#########################*)

### MOVNTDQA Vol. 2B 4-92
val p66 [0x0f 0x38 0x2a /r] = binop MOVNTDQA xmm128 m128
val main [/vex<m=vex-0f-38,v=vex-noreg,l=vex-128,p=vex-66> 0x2a /r] = binop VMOVNTDQA xmm128 m128

### MOVNTDQ Vol. 2B 4-95
val p66 [0x0f 0xe7 /r] = binop MOVNTDQ m128 xmm128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-66> 0xe7 /r] = binop VMOVNTDQ m128 xmm128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-256,p=vex-66> 0xe7 /r] = binop VMOVNTDQ m256 ymm256

### MOVNTI Vol. 2B 4-97
val main [0x0f 0xc3 /r]
 | rexw? = binop MOVNTI m64 r64
 | otherwise = binop MOVNTI m32 r32

### MOVNTPD Vol. 2B 4-99
val p66 [0x0f 0x2b /r] = binop MOVNTPD m128 xmm128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-66> 0x2b /r] = binop VMOVNTPD m128 xmm128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-256,p=vex-66> 0x2b /r] = binop VMOVNTPD m256 ymm256

### MOVNTPS Vol. 2B 4-99
val main [0x0f 0x2b /r] = binop MOVNTPS m128 xmm128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-nosimd> 0x2b /r] = binop VMOVNTPS m128 xmm128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-256,p=vex-nosimd> 0x2b /r] = binop VMOVNTPS m256 ymm256

### MOVNTQ Vol. 2B 4-103
val movntq = binop MOVNTQ
val main [0x0f 0xe7 /r<mod=mod-mem>] = binop MOVNTQ m64 mm64

### MOVQ Vol. 2B 4-105
val main [0x0f 0x6f /r] = binop MOVQ mm64 mm/m64
val main [0x0f 0x7f /r] = binop MOVQ mm/m64 mm64
val pf3 [0x0f 0x7e /r] = binop MOVQ xmm128 xmm/m64
val p66 [0x0f 0xd6 /r] = binop MOVQ xmm/m64 xmm128

### MOVQ2DQ Vol. 2B 4-107
val pf3 [0x0f 0xd6 /r<mod=mod-reg>] = binop MOVQ2DQ xmm128 mm/nomem64

### MOVS/MOVSB/MOVSW/MOVSD/MOVSQ Vol. 2B 4-109
val main [0xa4] =
 | mode64? = binop MOVSB (mem (REG RDI)) (mem (REG RSI))
 | otherwise = binop MOVSB (mem (REG EDI)) (mem (REG ESI))
val main [0xa5] =
 | mode64? & rexw? = binop MOVSQ (mem (REG RDI)) (mem (REG RSI))
 | mode64? & !rexw? = binop MOVSQ (mem (REG RDI)) (mem (REG RSI))
 | otherwise = binop MODSD (mem (REG EDI)) (mem (REG ESI))
val p66 [0xa5] =
 | mode64? & rexw? = binop MOVSQ (mem (REG RDI)) (mem (REG RSI))
 | mode64? & !rexw? = binop MOVSW (mem (REG RDI)) (mem (REG RSI))
 | otherwise = binop MODSW (mem (REG EDI)) (mem (REG ESI))

### MOVSD Vol. 2B 4-114
val pf2 [0x0f 0x10 /r] = binop MOVSD xmm128 xmm/m64
val main [/vex<m=vex-0f,p=vex-f2> 0x10 /r<mod=mod-reg>] = ternop VMOVSD_3 xmm128 vex/xmm xmm/nomem128
val main [/vex<m=vex-0f,v=vex-noreg,p=vex-f2> 0x10 /r<mod=mod-mem>] = binop VMOVSD_2 xmm128 m64
val pf2 [0x0f 0x11 /r] = binop MOVSD xmm/m64 xmm128
val main [/vex<m=vex-0f,p=vex-f2> 0x11 /r<mod=mod-reg>] = ternop VMOVSD_3 xmm/nomem128 vex/xmm xmm128
val main [/vex<m=vex-0f,v=vex-noreg,p=vex-f2> 0x11 /r<mod=mod-mem>] = binop VMOVSD_2 m64 xmm128

### MOVSHDUP Vol. 2B 4-117
val pf3 [0x0f 0x16 /r] = binop MOVSHDUP xmm128 xmm/mem128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-f3> 0x16 /r] = binop VMOVSHDUP xmm128 xmm/mem128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-256,p=vex-f3> 0x16 /r] = binop VMOVSHDUP ymm256 xmm/mem256

### MOVSLDUP Vol. 2B 4-120
val pf3 [0x0f 0x12 /r] = binop MOVSLDUP xmm128 xmm/mem128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-f3> 0x12 /r] = binop VMOVSLDUP xmm128 xmm/mem128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-256,p=vex-f3> 0x12 /r] = binop VMOVSLDUP ymm256 xmm/mem256

### MOVSS Vol. 2B 4-123
val pf3 [0x0f 0x10 /r] = binop MOVSS xmm128 xmm/m32
val main [/vex<m=vex-0f,p=vex-f3> 0x10 /r<mod=mod-reg>] = ternop VMOVSS_3 xmm128 vex/xmm xmm/nomem128
val main [/vex<m=vex-0f,v=vex-noreg,p=vex-f3> 0x10 /r<mod=mod-mem>] = binop VMOVSS_2 xmm128 m32
val pf3 [0x0f 0x11 /r] = binop MOVSS xmm/m32 xmm128
val main [/vex<m=vex-0f,p=vex-f3> 0x11 /r<mod=mod-reg>] = ternop VMOVSS_3 xmm/nomem128 vex/xmm xmm128
val main [/vex<m=vex-0f,v=vex-noreg,p=vex-f3> 0x11 /r<mod=mod-mem>] = binop VMOVSS_2 m32 xmm128

### MOVSX/MOVSXD Vol. 2B 4-126
val p66 [0x0f 0xbe /r] = binop MOVSX r16 r/m8
val main [0x0f 0xbe /r]
 | rexw? = binop MOVSX r64 r/m8
 | otherwise = binop MOVSX r32 r/m8
val main [0x0f 0xbf /r]
 | rexw? = binop MOVSX r64 r/m16
 | otherwise = binop MOVSX r32 r/m16
val main [0x63 /r]
 | rexw? = binop MOVSXD r64 r/m32

### MOVUPD Vol. 2B 4-129
val p66 [0x0f 0x10 /r] = binop MOVUPD xmm128 xmm/m128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-66> 0x10 /r] = binop VMOVUPD xmm128 xmm/m128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-256,p=vex-66> 0x10 /r] = binop VMOVUPD ymm256 ymm/m256
val p66 [0x0f 0x11 /r] = binop MOVUPD xmm/m128 xmm128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-66> 0x11 /r] = binop VMOVUPD xmm/m128 xmm128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-256,p=vex-66> 0x11 /r] = binop VMOVUPD ymm/m256 ymm256

### MOVUPS Vol. 2B 4-132
val main [0x0f 0x10 /r] = binop MOVUPS xmm128 xmm/m128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-nosimd> 0x10 /r] = binop VMOVUPS xmm128 xmm/m128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-256,p=vex-nosimd> 0x10 /r] = binop VMOVUPS ymm256 ymm/m256
val main [0x0f 0x11 /r] = binop MOVUPD xmm/m128 xmm128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-nosimd> 0x11 /r] = binop VMOVUPS xmm/m128 xmm128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-256,p=vex-nosimd> 0x11 /r] = binop VMOVUPS ymm/m256 ymm256

### MOVZX Vol. 2B 4-135
val main [0x0f 0xb6 /r] = binop MOVZX r16 r/m8
val main [0x0f 0xb6 /r]
 | rexw? = binop MOVZX r64 r/m8
 | otherwise = binop MOVZX r32 r/m8
val main [0x0f 0xb7 /r]
 | rexw? = binop MOVZX r64 r/m16
 | otherwise = binop MOVZX r32 r/m16

### MPSADBW Vol. 2B 4-137
val p66 [0x0f 0x3a 0x42 /r] = ternop MPSADBW xmm128 xmm/m128 imm8
val main [/vex<m=vex-0f-3a,l=vex-128,p=vex-66> 0x42 /r] = quaternop VMPSADBW xmm128 vex/xmm xmm/m128 imm8

### MUL Vol. 2B 4-142
val main [0xf6 /4] = unop MUL r/m8
val p66 [0xf7 /4] = unop MUL r/m16
val main [0xf7 /4]
 | rexw? = unop MUL r/m64
 | otherwise = unop MUL r/m32

### MULPD Vol. 2B 4-145
val p66 [0x0f 0x59 /r] = binop MULPD xmm128 xmm/m128
val main [/vex<m=vex-0f,l=vex-128,p=vex-66> 0x59 /r] = ternop VMULPD xmm128 vex/xmm xmm/m128
val main [/vex<m=vex-0f,l=vex-256,p=vex-66> 0x59 /r] = ternop VMULPD ymm256 vex/xmm ymm/m256

### MULPS Vol. 2B 4-147
val mulps = binop MULPS
val vmulps = ternop VMULPS
val main [0x0f 0x59 /r] = binop MULPS xmm128 xmm/m128
val main [/vex<m=vex-0f,l=vex-128,p=vex-nosimd> 0x59 /r] = ternop VMULPS xmm128 vex/xmm xmm/m128
val main [/vex<m=vex-0f,l=vex-256,p=vex-nosimd> 0x59 /r] = ternop VMULPS ymm256 vex/xmm ymm/m256

### MULSD Vol. 2B 4-149
val pf2 [0x0f 0x59 /r] = binop MULSD xmm128 xmm/m64
val main [/vex<m=vex-0f,p=vex-f2> 0x59 /r] = ternop VMULSD xmm128 vex/xmm xmm/m64

### MULSS Vol. 2B 4-151
val pf3 [0x0f 0x59 /r] = binop MULSS xmm128 xmm/m32
val main [/vex<m=vex-0f,p=vex-f3> 0x59 /r] = ternop VMULSS xmm128 vex/xmm xmm/m32

### MWAIT Vol. 2B 4-153
val main [0x0f 0x01 0xc9] = return MWAIT

### NEG Vol. 2B 4-157
val main [0xf6 /3] = unop NEGr/m8
val p66 [0xf7 /3] = unop NEGr/m16
val main [0xf7 /3]
 | rexw? = unop NEGr/m64
 | otherwise = unop NEGr/m32

### NOP Vol. 2B 4-160
val main [0x90] = return NOP_0
val p66 [0x0f 0x1f /0] = unop NOP_1 r/m16
val main [0x0f 0x1f /0] = unop NOP_1 r/m32

### NOT Vol. 2B 4-162
val main [0xf6 /2] = unop NOT r/m8
val p66 [0xf7 /2] = unop NOT r/m16
val main [0xf7 /2]
 | rexw? = unop NOT r/m64
 | otherwise = unop NOT r/m64

### OR Vol. 2B 4-164
val main [0x0c] = binop OR al imm8
val p66 [0x0d] = binop OR ax imm16
val main [0x0d]
 | rexw? = binop OR rax imm64
 | otherwise = binop OR eax imm32
val main [0x80 /1] = binop OR r/m8 imm8
val p66 [0x81 /1] = binop OR r/m16 imm16
val main [0x81 /1]
 | rexw? = binop OR r/m64 imm32
 | otherwise = binop OR r/m32 imm32
val p66 [0x83 /1] = binop OR r/m16 imm8
val main [0x83 /1]
 | rexw? = binop OR r/m64 imm8
 | otherwise = binop OR r/m32 imm8
val main [0x08] = binop OR r/m8 r8
val p66 [0x09 /1] = binop OR r/m16 imm16
val main [0x09 /1]
 | rexw? = binop OR r/m64 imm64
 | otherwise = binop OR r/m32 imm32
val main [0x0a] = binop OR r8 r/m8
val p66 [0x0b /1] = binop OR r16 r/m16
val main [0x0b /1]
 | rexw? = binop OR r64 r/m64
 | otherwise = binop OR r32 r/m32

### ORPD Vol. 2B 4-164
val p66 [0x0f 0x56 /r] = binop ORPD xmm128 xmm/m128
val main [/vex<m=vex-0f,l=vex-128,p=vex-66> 0x56 /r] = ternop VORPD xmm128 vex/xmm xmm/m128
val main [/vex<m=vex-0f,l=vex-256,p=vex-66> 0x56 /r] = ternop VORPD ymm256 vex/xmm ymm/m256

### ORPS Vol. 2B 4-169
val main [0x0f 0x56 /r] = binop ORPS xmm128 xmm/m128
val main [/vex<m=vex-0f,l=vex-128,p=vex-nosimd> 0x56 /r] = ternop VORPS xmm128 vex/xmm xmm/m128
val main [/vex<m=vex-0f,l=vex-256,p=vex-nosimd> 0x56 /r] = ternop VORPS ymm256 vex/xmm ymm/m256

### OUT Vol. 2B 4-171
val main [0xe6] = binop OUT imm8 al
val p66 [0xe7] = binop OUT imm8 ax
val main [0xe7] = binop OUT imm8 eax
val main [0xee] = binop OUT dx al
val p66 [0xef] = binop OUT dx ax
val main [0xef] = binop OUT dx eax

### PHADDW/PHADDD Vol. 2B 4-253
val p66 [0x0f 0x38 0x01 /r] = binop PHADDW xmm128 xmm/m128
val main [0x0f 0x38 0x01 /r] = binop PHADDW mm64 mm/m64
val p66 [0x0f 0x38 0x02 /r] = binop PHADDD xmm128 xmm/m128
val main [0x0f 0x38 0x02 /r] = binop PHADDD mm64 mm/m64
val main [/vex<m=vex-0f-38,l=vex-128,p=vex-66> 0x01 /r] = ternop VPHADDW xmm128 vex/xmm xmm/m128
val main [/vex<m=vex-0f-38,l=vex-128,p=vex-66> 0x02 /r] = ternop VPHADDD xmm128 vex/xmm xmm/m128

### XADD Vol. 2B 4-667
val main [0x0f 0xc0 /r] = binop XADD r/m8 r8
val p66 [0x0f 0xc1 /r] = binop XADD r/m16 r16
val main [0x0f 0xc1 /r]
 | rexw? = binop XADD r/m64 r64
 | otherwise = binop XADD r/m32 r32
