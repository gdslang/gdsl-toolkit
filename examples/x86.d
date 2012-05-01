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

val / act = do
   res <- act;
   return (not res)
end

val otherwise = return '1'

val opndsz? = query $opndsz
val addrsz? = query $addrsz
val repne? =  query $repne
val rep? = query $rep
val rexw? = query $rexw
val rex? = query $rex
val mod-mem? = do
   mod <- query $mod;
   case mod of
      '11': return '1'
    | otherwise: return '0'
    end
end
val mod-reg? = / mod-mem?
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
type binop = {opnd1:opnd, opnd2:opnd}
type trinop = {opnd1:opnd, opnd2:opnd, opnd3:opnd}

datatype insn =
   ADD of binop
 | CVTPD2PI of binop
 | MASKMOVDQU of binop
 | VMASKMOVDQU of binop
 | MASKMOVQ of binop
 | MAXPD of binop
 | VMAXPD of trinop
 | MAXPS of binop
 | VMAXPS of trinop
 | MAXSD of binop
 | VMAXSD of trinop
 | MAXSS of binop
 | VMAXSS of trinop
 | MFENCE
 | MINPD of binop
 | VMINPD of trinop
 | MINPS of binop
 | VMINPS of trinop
 | MINSD of binop
 | VMINSD of trinop
 | MINSS of binop
 | VMINSS of trinop
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
 | VMOVDDUP of binop
 | MOVDQA of binop
 | VMOVDQA of binop
 | MOVDQU of binop
 | VMOVDQU of binop
 | MOVDQ2Q of binop
 | MOVHLPS of binop
 | VMOVHLPS of trinop
 | MOVHPD of binop
 | VMOVHPD of trinop
 | VBMOVHPD of binop
 | MOVHPS of binop
 | VMOVHPS of trinop
 | VBMOVHPS of binop
 | MOVLHPS of binop
 | VMOVLHPS of trinop
 | MOVLPD of binop
 | VMOVLPD of trinop
 | VBMOVLPD of binop
 | MOVLPS of binop
 | VMOVLPS of trinop
 | VBMOVLPS of binop
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

 | PHADDW of binop
 | VPHADDW of trinop
 | PHADDD of binop
 | VPHADDD of trinop
 | XADD of binop

val imm8 ['b:8'] = return (IMM8 b)
val imm16 ['b1:8' 'b2:8'] = return (IMM16 (b1 ^ b2))
val imm32 ['b1:8' 'b2:8' 'b3:8' 'b4:8'] = return (IMM32 (b1 ^ b2 ^ b3 ^ b4))
val imm64 ['b1:8' 'b2:8' 'b3:8' 'b4:8' 'b5:8' 'b6:8' 'b7:8' 'b8:8'] =
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
   # We could add syntatic sugar for record field creation:
   #   return (MOV {op1, op2})
end

val trinop cons giveOp1 giveOp2 giveOp3 = do
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
 | / rex? = do
   update @{rexr=r, rexx=x, rexb=b, vexm=m, rexw=w, vexv=v, vexl=l, vexp=p};
   vex-pp pp
end

val /vex [0xc5 'r:1 v:4 l:1 p:2' x='0' b='0' m='00001' w='0'] 
 | / rex? = do
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

#define vex-no-simd '00'
val vex-no-simd? = do
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

val p66 [0x2e] = do update @{segment=CS}; p66 end
val p66 [0x36] = do update @{segment=SS}; p66 end
val p66 [0x3e] = do update @{segment=DS}; p66 end
val p66 [0x26] = do update @{segment=ES}; p66 end
val p66 [0x64] = do update @{segment=FS}; p66 end
val p66 [0x65] = do update @{segment=GS}; p66 end
val p66 [0x66] = do update @{opndsz='1'}; p66 end
val p66 [0x67] = do update @{addrsz='1'}; p66 end
val p66 [0xf2] = do update @{repne='1'}; p66-f2 end
val p66 [0xf3] = do update @{rep='1'}; p66-f3 end
val p66 [/rex] = p66 #Todo: Ignore REX before legacy prefixes

val pf2 [0x2e] = do update @{segment=CS}; pf2 end
val pf2 [0x36] = do update @{segment=SS}; pf2 end
val pf2 [0x3e] = do update @{segment=DS}; pf2 end
val pf2 [0x26] = do update @{segment=ES}; pf2 end
val pf2 [0x64] = do update @{segment=FS}; pf2 end
val pf2 [0x65] = do update @{segment=GS}; pf2 end
val pf2 [0x66] = do update @{opndsz='1'}; p66-f2 end
val pf2 [0x67] = do update @{addrsz='1'}; pf2 end
val pf2 [0xf2] = do update @{repne='1'}; pf2 end
val pf2 [0xf3] = do update @{rep='1'}; pf2-f3 end
val pf2 [/rex] = main #Todo: Ignore REX before legacy prefixes

val pf3 [0x2e] = do update @{segment=CS}; pf3 end
val pf3 [0x36] = do update @{segment=SS}; pf3 end
val pf3 [0x3e] = do update @{segment=DS}; pf3 end
val pf3 [0x26] = do update @{segment=ES}; pf3 end
val pf3 [0x64] = do update @{segment=FS}; pf3 end
val pf3 [0x65] = do update @{segment=GS}; pf3 end
val pf3 [0x66] = do update @{opndsz='1'}; p66-f3 end
val pf3 [0x67] = do update @{addrsz='1'}; pf3 end
val pf3 [0xf2] = do update @{repne='1'}; pf2-f3 end
val pf3 [0xf3] = do update @{rep='1'}; pf3 end
val pf3 [/rex] = main #Todo: Ignore REX before legacy prefixes

val p66-f2 [0x2e] = do update @{segment=CS}; p66-f2 end
val p66-f2 [0x36] = do update @{segment=SS}; p66-f2 end
val p66-f2 [0x3e] = do update @{segment=DS}; p66-f2 end
val p66-f2 [0x26] = do update @{segment=ES}; p66-f2 end
val p66-f2 [0x64] = do update @{segment=FS}; p66-f2 end
val p66-f2 [0x65] = do update @{segment=GS}; p66-f2 end
val p66-f2 [0x66] = do update @{opndsz='1'}; p66-f2 end
val p66-f2 [0x67] = do update @{addrsz='1'}; p66-f2 end
val p66-f2 [0xf2] = do update @{repne='1'}; p66-f2 end
val p66-f2 [0xf3] = do update @{rep='1'}; p66-f2-f3 end
val p66-f2 [/rex] = main #Todo: Ignore REX before legacy prefixes

val p66-f3 [0x2e] = do update @{segment=CS}; p66-f3 end
val p66-f3 [0x36] = do update @{segment=SS}; p66-f3 end
val p66-f3 [0x3e] = do update @{segment=DS}; p66-f3 end
val p66-f3 [0x26] = do update @{segment=ES}; p66-f3 end
val p66-f3 [0x64] = do update @{segment=FS}; p66-f3 end
val p66-f3 [0x65] = do update @{segment=GS}; p66-f3 end
val p66-f3 [0x66] = do update @{opndsz='1'}; p66-f3 end
val p66-f3 [0x67] = do update @{addrsz='1'}; p66-f3 end
val p66-f3 [0xf2] = do update @{repne='1'}; p66-f2-f3 end
val p66-f3 [0xf3] = do update @{rep='1'}; p66-f3 end
val p66-f3 [/rex] = main #Todo: Ignore REX before legacy prefixes

val p66-f2-f3 [0x2e] = do update @{segment=CS}; p66-f2-f3 end
val p66-f2-f3 [0x36] = do update @{segment=SS}; p66-f2-f3 end
val p66-f2-f3 [0x3e] = do update @{segment=DS}; p66-f2-f3 end
val p66-f2-f3 [0x26] = do update @{segment=ES}; p66-f2-f3 end
val p66-f2-f3 [0x64] = do update @{segment=FS}; p66-f2-f3 end
val p66-f2-f3 [0x65] = do update @{segment=GS}; p66-f2-f3 end
val p66-f2-f3 [0x66] = do update @{opndsz='1'}; p66-f2-f3 end
val p66-f2-f3 [0x67] = do update @{addrsz='1'}; p66-f2-f3 end
val p66-f2-f3 [0xf2] = do update @{repne='1'}; p66-f2-f3 end
val p66-f2-f3 [0xf3] = do update @{rep='1'}; p66-f2-f3 end
val p66-f2-f3 [/rex] = main #Todo: Ignore REX before legacy prefixes

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
val add = binop ADD
val main [0x04] = add al imm8
val main [0x05]
 | rexw? = add rax imm64
 | otherwise = add eax imm32
val p66 [0x05] = add ax imm16
val main [0x80 /0] = add r/m8 imm8
val main [0x81 /0]
 | rexw? = add r/m64 imm64
 | otherwise = add r/m32 imm32
val p66 [0x81 /0] = add r/m16 imm16
val main [0x83 /0]
 | rexw? = add r/m64 imm8
 | otherwise = add r/m32 imm8
val p66 [0x83 /0] = add r/m16 imm8
val main [0x00 /r] = add r/m8 r8
val main [0x01 /0]
 | rexw? = add r/m64 r64
 | otherwise = add r/m32 r32
val p66 [0x01 /0] = add r/m16 r16
val main [0x02 /r] = add r8 r/m8
val main [0x03 /0]
 | rexw? = add r64 r/m64
 | otherwise = add r32 r/m32
val p66 [0x03 /0] = add r16 r/m16

### CVTPD2PI Vol 2A 3-248
val cvtpdf2pi = binop CVTPD2PI
val p66 [0x0f 0x2d /r] = cvtpdf2pi mm64 xmm/m128

### MASKMOVDQU Vol. 2B 4-9
val maskmovdqu = binop MASKMOVDQU
val vmaskmovdqu = binop VMASKMOVDQU
val p66 [0x0f 0xf7 /r] = maskmovdqu xmm128 xmm/nomem128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-66> 0xf7 /r] = vmaskmovdqu xmm128 xmm/nomem128

### MASKMOVQ Vol. 2B 4-11
val maskmovq = binop MASKMOVQ
val main [0x0f 0xf7 /r] = maskmovq mm64 mm/nomem64

### MAXPD Vol. 2B 4-13
val maxpd = binop MAXPD
val vmaxpd = trinop VMAXPD
val main [0x0f 0x5f /r] = maxpd xmm128 xmm/m128
val main [/vex<m=vex-0f,l=vex-128,p=vex-66> 0x5f /r] = vmaxpd xmm128 vex/xmm xmm/m128
val main [/vex<m=vex-0f,l=vex-256,p=vex-66> 0x5f /r] = vmaxpd ymm256 vex/ymm ymm/m256

### MAXPS 4-16 Vol. 2B
val maxps = binop MAXPS
val vmaxps = trinop VMAXPS
val main [0x0f 0x5f /r] = maxps xmm128 xmm/m128
val main [/vex<m=vex-0f,l=vex-128,p=vex=vex-no-simd> 0x5f /r] = vmaxps xmm128 vex/xmm xmm/m128
val main [/vex<m=vex-0f,l=vex-256,p=vex=vex-no-simd> 0x5f /r] = vmaxps ymm256 vex/ymm ymm/m256

### MAXSD Vol. 2B 4-19
val maxsd = binop MAXSD
val vmaxsd = trinop VMAXSD
val pf2 [0x0f 0x5f /r] = maxsd xmm128 xmm/m64
val main [/vex<m=vex-0f,p=vex-f2> 0x5f /r] = vmaxsd xmm128 vex/xmm xmm/m64

### MAXSS Vol. 2B 4-21
val maxss = binop MAXSS
val vmaxss = trinop VMAXSS
val pf3 [0x0f 0x5f /r] = maxss xmm128 xmm/m32
val main [/vex<m=vex-0f,p=vex-f3> 0x5f /r] = vmaxss xmm128 vex/xmm xmm/m32

### MFENCE Vol. 2B 4-23
val mfence = return MFENCE
val main [0x0f 0xae /6] = mfence

### MINPD Vol. 2B 4-25
val minpd = binop MINPD
val vminpd = trinop VMINPD
val p66 [0x0f 0x5d /r] = minpd xmm128 xmm/m128
val main [/vex<m=vex-0f,l=vex-128,p=vex-66> 0x5d /r] = vminpd xmm128 vex/xmm xmm/m128
val main [/vex<m=vex-0f,l=vex-256,p=vex-66> 0x5d /r] = vminpd ymm256 vex/ymm ymm/m256

### MINPS Vol. 2B 4-28
val minps = binop MINPS
val vminps = trinop VMINPS
val main [0x0f 0x5d /r] = minps xmm128 xmm/m128
val main [/vex<m=vex-0f,l=vex-128,p=vex-no-simd> 0x5d /r] = vminps xmm128 vex/xmm xmm/m128
val main [/vex<m=vex-0f,l=vex-256,p=vex-no-simd> 0x5d /r] = vminps ymm256 vex/ymm ymm/m256

### MINSD Vol. 2B 4-31
val minsd = binop MINSD
val vminsd = trinop VMINSD
val pf2 [0x0f 0x5d /r] = minsd xmm128 xmm/m64
val main [/vex<m=vex-0f,p=vex-f2> 0x5d /r] = vminsd xmm128 vex/xmm xmm/m64

### MINSS Vol. 2B 4-33
val minss = binop MINSS
val vminss = trinop VMINSS
val pf3 [0x0f 0x5d /r] = minss xmm128 xmm/m32
val main [/vex<m=vex-0f,p=vex-f3> 0x5d /r] = vminss xmm128 vex/xmm xmm/m32

### MONITOR Vol. 2B 4-35
val monitor = return MONITOR
val main [0x0f 0xae 0x01 0xc8] = monitor

### MOV Vol 2A 3-643
val mov = binop MOV
val main [0x88 /r] = mov r/m8 r8
val p66 [0x89 /r] = mov r/m16 r16
val main [0x89 /r]
 | rexw? = mov r/m64 r64
 | otherwise = mov r/m32 r32
val main [0x8a /r] = mov r8 r/m8
val p66 [0x8b /r] = mov r16 r/m16
val main [0x8b /r] = mov r32 r/m32
val main [0x8c /r] = mov r/m16 (r/ sreg3?)
val main [0x8e /r] = mov (r/ sreg3?) r/m16
val main [0xa0] = mov al moffs8 
val main [0xa1]
 | addrsz? = mov ax moffs16
 | otherwise = mov eax moffs32
val main [0xa2] = mov moffs8 al
val main [0xa3]
 | addrsz? = mov moffs16 ax
 | otherwise = mov moffs32 eax
val main [0xb0] = mov al imm8
val main [0xb1] = mov cl imm8
val main [0xb2] = mov dl imm8
val main [0xb3] = mov bl imm8
val main [0xb4] = mov ah imm8
val main [0xb5] = mov ch imm8
val main [0xb6] = mov dh imm8
val main [0xb7] = mov bh imm8
val p66 [0xb8] = mov ax imm16
val main [0xb8] = mov eax imm32
val p66 [0xb9] = mov cx imm16
val main [0xb9] = mov ecx imm32
val p66 [0xba] = mov dx imm16
val main [0xba] = mov edx imm32
val p66 [0xbb] = mov bx imm16
val main [0xbb] = mov ebx imm32
val p66 [0xbc] = mov sp imm16
val main [0xbc] = mov esp imm32
val p66 [0xbd] = mov bp imm16
val main [0xbd] = mov ebp imm32
val p66 [0xbe] = mov si imm16
val main [0xbe] = mov esi imm32
val p66 [0xbf] = mov di imm16
val main [0xbf] = mov edi imm32
val main [0xc6 /0] = mov r/m8 imm8
val p66 [0xc7 /0] = mov r/m16 imm16
val main [0xc7 /0] = mov r/m32 imm32

### MOVAPD Vol. 2B 4-52
val movapd = binop MOVAPD
val vmovapd = binop VMOVAPD
val p66 [0x0f 0x28 /r] = movapd xmm128 xmm/m128
val p66 [0x0f 0x29 /r] = movapd xmm/m128 xmm128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-66> 0x28 /r] = vmovapd xmm128 xmm/m128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-256,p=vex-66> 0x28 /r] = vmovapd ymm256 ymm/m256
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-66> 0x29 /r] = vmovapd xmm/m128 xmm128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-256,p=vex-66> 0x29 /r] = vmovapd ymm/m256 ymm256

### MOVAPS Vol. 2B 4-55
val movaps = binop MOVAPS
val vmovaps = binop VMOVAPS
val main [0x0f 0x28 /r] = movaps xmm128 xmm/m128
val main [0x0f 0x29 /r] = movaps xmm/m128 xmm128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-no-simd> 0x28 /r] = vmovaps xmm128 xmm/m128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-256,p=vex-no-simd> 0x28 /r] = vmovaps ymm256 ymm/m256
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-no-simd> 0x29 /r] = vmovaps xmm/m128 xmm128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-256,p=vex-no-simd> 0x29 /r] = vmovaps ymm/m256 ymm256

### MOVBE Vol. 2B 4-58
val movbe = binop MOVBE
val p66 [0x0f 0x38 0xf0 /r] = movbe r16 m16
val main [0x0f 0x38 0xf0 /r]
 | rexw? = movbe r64 m64
 | otherwise = movbe r32 m32
val p66 [0x0f 0x38 0xf1 /r] = movbe m16 r16
val main [0x0f 0x38 0xf1 /r]
 | rexw? = movbe m64 r64
 | otherwise = movbe m32 r32

### MOVD/MOVQ Vol. 2B 4-61
val movd = binop MOVD
val vmovd = binop VMOVD
val movq = binop MOVQ
val vmovq = binop VMOVQ
val main [0x0f 0x6e /r]
 | rexw? = movq mm64 r/m64
 | otherwise = movd mm64 r/m32
val main [0x0f 0x7e /r]
 | rexw? = movq r/m64 mm64
 | otherwise = movd r/m32 mm64
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-66> 0x6e /r]
 | rexw? = vmovd xmm128 r/m64
 | otherwise = vmovd xmm128 r/m32
val p66 [0x0f 0x6e /r]
 | rexw? = movq xmm128 r/m64
 | otherwise = movd xmm128 r/m32
val p66 [0x0f 0x7e /r]
 | rexw? = movq r/m64 xmm128
 | otherwise = movd r/m32 xmm128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-66> 0x7e /r]
 | rexw? = vmovd r/m64 xmm128
 | otherwise = vmovd r/m32 xmm128

### MOVDDUP Vol. 2B 4-64
val movddup = binop MOVDDUP
val vmovddup = binop VMOVDDUP
val pf2 [0x0f 0x12 /r] = movddup xmm128 xmm/m64
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-f2> 0x12 /r] = vmovddup xmm128 xmm/m64
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-256,p=vex-f2> 0x12 /r] = vmovddup vmovddup ymm256 ymm/m256

### MOVDQA Vol. 2B 4-67
val movdqa = binop MOVDQA
val vmovdqa = binop VMOVDQA
val p66 [0x0f 0x6f /r] = movdqa xmm128 xmm/m128
val p66 [0x0f 0x7f /r] = movdqa xmm/m128 xmm128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-66> 0x6f /r] = vmovdqa xmm128 xmm/m128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-256,p=vex-66> 0x6f /r] = vmovdqa ymm256 ymm/m256
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-66> 0x7f /r] = vmovdqa xmm/m128 xmm128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-256,p=vex-66> 0x7f /r] = vmovdqa ymm/m256 ymm256

### MOVDQU Vol. 2B 4-70
val movdqu = binop MOVDQU
val vmovdqu = binop VMOVDQU
val pf3 [0x0f 0x6f /r] = movdqu xmm128 xmm/m128
val pf3 [0x0f 0x7f /r] = movdqu xmm/m128 xmm128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-f3> 0x6f /r] = vmovdqu xmm128 xmm/m128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-256,p=vex-f3> 0x6f /r] = vmovdqu ymm256 ymm/m256
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-f3> 0x7f /r] = vmovdqu xmm/m128 xmm128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-256,p=vex-f3> 0x7f /r] = vmovdqu ymm/m256 ymm256

### MOVDQ2Q Vol. 2B 4-73
val movdq2q = binop MOVDQ2Q
val pf2 [0x0f 0xd6 /r] = movdq2q mm64 xmm128

### MOVHLPS Vol. 2B 4-75
val movhlps = binop MOVHLPS
val vmovhlps = trinop VMOVHLPS
val main [0x0f 0x12 /r] = movhlps xmm128 xmm/nomem128
val main [/vex<m=vex-0f,l=vex-128,p=vex-no-simd> 0x12 /r] = vmovhlps xmm128 vex/xmm xmm/nomem128

### MOVHPD Vol. 2B 4-77
val movhpd = binop MOVHPD
val vmovhpd = trinop VMOVHPD
val vbmovhpd = binop VBMOVHPD
val p66 [0x0f 0x16 /r] = movhpd xmm128 m64
val p66 [0x0f 0x17 /r] = movhpd m64 xmm128
val main [/vex<m=vex-0f,l=vex-128,p=vex-66> 0x16 /r] = vmovhpd xmm128 vex/xmm m64
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-66> 0x17 /r] = vbmovhpd m64 xmm128

### MOVHPS Vol. 2B 4-79
val movhps = binop MOVHPS
val vmovhps = trinop VMOVHPS
val vbmovhps = binop VBMOVHPS
val main [0x0f 0x16 /r]
 | mod-mem? = movhps xmm128 m64
val main [0x0f 0x17 /r]
 | mod-mem? = movhps m64 xmm128
val main [/vex<m=vex-0f,l=vex-128,p=vex-no-simd> 0x16 /r]
 | mod-mem? = vmovhps xmm128 vex/xmm m64
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-no-simd> 0x17 /r]
 | mod-mem? = vbmovhps m64 xmm128

### MOVLHPS Vol. 2B 4-81
val movlhps = binop MOVLHPS
val vmovlhps = trinop VMOVLHPS
val main [0x0f 0x16 /r]
 | mod-reg? = movlhps xmm128 xmm/nomem128
val main [/vex<m=vex-0f,l=vex-128,p=vex-no-simd> 0x16 /r]
 | mod-reg? = vmovlhps xmm128 vex/xmm xmm/nomem128

### MOVLPD Vol. 2B 4-83
val movlpd = binop MOVLPD
val vmovlpd = trinop VMOVLPD
val vbmovlpd = binop VBMOVLPD
val p66 [0x0f 0x12 /r] = movlpd xmm128 m64
val p66 [0x0f 0x13 /r] = movlpd m64 xmm128
val main [/vex<m=vex-0f,l=vex-128,p=vex-66> 0x12 /r] = vmovlpd xmm128 vex/xmm m64
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-66> 0x13 /r] = vbmovlpd m64 xmm128

### MOVLPS Vol. 2B 4-85
val movlps = binop MOVLPD
val vmovlps = trinop VMOVLPD
val vbmovlps = binop VBMOVLPD
val main [0x0f 0x12 /r] = movlps xmm128 m64
val main [0x0f 0x13 /r] = movlps m64 xmm128
val main [/vex<m=vex-0f,l=vex-128,p=vex-no-simd> 0x12 /r] = vmovlps xmm128 vex/xmm m64
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-no-simd> 0x13 /r] = vbmovlps m64 xmm128

### MOVMSKPD Vol. 2B 4-87
val movmskpd = binop MOVMSKPD
val vmovmskpd = binop VMOVMSKPD
val p66 [0x0f 0x50 /r]
 | mode64? = movmskpd r64 xmm128
 | otherwise = movmskpd r32 xmm128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-66> 0x50 /r]
 | mode64? = vmovmskpd r64 xmm128
 | otherwise = vmovmskpd r64 xmm128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-256,p=vex-66> 0x50 /r]
 | mode64? = vmovmskpd r64 ymm256
 | otherwise = vmovmskpd r64 ymm256
(*#########################
##### ~~ VERIFY! ~~ #####
#########################*)

### MOVMSKPS Vol. 2B 4-89
val movmskps = binop MOVMSKPS
val vmovmskps = binop VMOVMSKPS
val main [0x0f 0x50 /r]
 | mode64? = movmskps r64 xmm128
 | otherwise = movmskps r32 xmm128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-no-simd> 0x50 /r]
 | mode64? = vmovmskps r64 xmm128
 | otherwise = vmovmskps r64 xmm128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-256,p=vex-no-simd> 0x50 /r]
 | mode64? = vmovmskps r64 ymm256
 | otherwise = vmovmskps r64 ymm256
(*#########################
##### ~~ VERIFY! ~~ #####
#########################*)

### MOVNTDQA Vol. 2B 4-92
val movntdqa = binop MOVNTDQA
val vmovntdqa = binop VMOVNTDQA
val p66 [0x0f 0x38 0x2a /r] = movntdqa xmm128 m128
val main [/vex<m=vex-0f-38,v=vex-noreg,l=vex-128,p=vex-66> 0x2a /r] = vmovntdqa xmm128 m128

### MOVNTDQ Vol. 2B 4-95
val movntdq = binop MOVNTDQ
val vmovntdq = binop VMOVNTDQ
val p66 [0x0f 0xe7 /r] = movntdq m128 xmm128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-66> 0xe7 /r] = vmovntdq m128 xmm128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-256,p=vex-66> 0xe7 /r] = vmovntdq m256 ymm256

### MOVNTI Vol. 2B 4-97
val movnti = binop MOVNTI
val main [0x0f 0xc3 /r]
 | rexw? = movnti m64 r64
 | otherwise = movnti m32 r32

### MOVNTPD Vol. 2B 4-99
val movntpd = binop MOVNTPD
val vmovntpd = binop VMOVNTPD
val p66 [0x0f 0x2b /r] = movntpd m128 xmm128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-66> 0x2b /r] = vmovntpd m128 xmm128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-256,p=vex-66> 0x2b /r] = vmovntpd m256 ymm256

### MOVNTPS Vol. 2B 4-99
val movntps = binop MOVNTPD
val vmovntps = binop VMOVNTPD
val main [0x0f 0x2b /r] = movntps m128 xmm128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-128,p=vex-no-simd> 0x2b /r] = vmovntps m128 xmm128
val main [/vex<m=vex-0f,v=vex-noreg,l=vex-256,p=vex-no-simd> 0x2b /r] = vmovntps m256 ymm256

### MOVNTQ Vol. 2B 4-103
val movntq = binop MOVNTQ
val main [0x0f 0xe7 /r] = movntq m64 mm64

### MOVQ Vol. 2B 4-105
val main [0x0f 0x6f /r] = movq mm64 mm/m64
val main [0x0f 0x7f /r] = movq mm/m64 mm64
val pf3 [0x0f 0x7e /r] = movq xmm128 xmm/m64
val p66 [0x0f 0xd6 /r] = movq xmm/m64 xmm128

### PHADDW/PHADDD Vol. 2B 4-253
val phaddw = binop PHADDW
val vphaddw = trinop VPHADDW
val phaddd = binop PHADDD
val vphaddd = trinop VPHADDD
val p66 [0x0f 0x38 01 /r] = phaddw xmm128 xmm/m128
val main [0x0f 0x38 01 /r] = phaddw mm64 mm/m64
val p66 [0x0f 0x38 02 /r] = phaddd xmm128 xmm/m128
val main [0x0f 0x38 02 /r] = phaddd mm64 mm/m64
val vex-0f-38 [01 /r]
 | opndsz? & vex-128? & vex-66? = vphaddw xmm128 vex/xmm xmm/m128
val vex-0f-38 [02 /r]
 | opndsz? & vex-128? & vex-66? = vphaddd xmm128 vex/xmm xmm/m128

### XADD Vol. 2B 4-667
val xadd = binop XADD
val main [0x0f 0xc0 /r] = xadd r/m8 r8
val p66 [0x0f 0xc1 /r] = mov r/m16 r16
val main [0x0f 0xc1 /r]
 | rexw? = xadd r/m64 r64
 | otherwise = mov r/m32 r32
