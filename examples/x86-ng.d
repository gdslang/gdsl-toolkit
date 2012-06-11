granularity = 8
export = / decode

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
# recursion-depth = p64 = 4

val decode = do
   update
      @{mode64='1',
        repne='0',
        rep='0',
        rex='0',
        rexw='0',
        rexb='0',
        rexr='0',
        rexx='0',
        opndsz='0',
        addrsz='0',
        lock='0',
        segment=DS,
        mod='00',
        reg/opcode='000',
        rm='000',
        ptrty=32}; #TODO: check
   p64
end

val set-opndsz = update@{opndsz='1'}
val set-repne = update@{repne='1'}
val set-rep = update@{rep='1'}

val set-CS = update@{segment=CS}
val set-DS = update@{segment=DS}
val set-ES = update@{segment=ES}
val set-FS = update@{segment=FS}
val set-GS = update@{segment=GS}
val set-SS = update@{segment=SS}
val set-lock = update@{lock='1'}
val set-addrsz = update@{addrsz='1'}

## Decoding prefixes

# The functions 'after' and 'continue' are used to try different decoders
# in sequence. The first function takes two arguments and runs the first
# one until it calls 'continue', at which point the second decoder is run.

val after fst snd = do
  update@{tab=snd};
  r <- fst;
  # make the type checker happy
  update@{~tab};
  return r
end

val continue = do
  t <- query$tab;
  # make the type checker happy
  update@{~tab};  
  # make the type checker happy
  r <- t;
  update@{~tab};
  return r
end

# val after fst snd = do
#    update@{tab=snd};
#    fst
# end
# 
# val continue = do
#    t <- query$tab;
#    t
# end

val /66 [] = continue
val /f2 [] = continue
val /f3 [] = continue

val /legacy-p [0x2e] = do clear-rex; set-CS end
val /legacy-p [0x36] = do clear-rex; set-SS end
val /legacy-p [0x3e] = do clear-rex; set-DS end
val /legacy-p [0x26] = do clear-rex; set-ES end
val /legacy-p [0x64] = do clear-rex; set-FS end
val /legacy-p [0x65] = do clear-rex; set-GS end
val /legacy-p [0x67] = do clear-rex; set-addrsz end
val /legacy-p [0xf0] = do clear-rex; set-lock end

val /rex-p ['0100 w:1 r:1 x:1 b:1'] =
   update @{rex='1', rexw=w, rexb=b, rexx=x, rexr=r}
val clear-rex = update @{rex='0',rexw='0',rexb='0',rexr='0',rexx='0'}

val p/vex/0f [0xc4 'r:1 x:1 b:1 00001' 'w:1 v:4 l:1 00'] = do
   update
      @{rex='1',
        rexw=w,
        vexw=w,
        rexr=not r,
        rexb=not b,
        rexx=not x,
        vexl=l,
        vexv=complement v,
        vexm='00001'}
end

val p/vex/0f [0xc5 'r:1 v:4 l:1 00'] = do
   update
      @{rex='1',
        rexw='0',
        vexw='0',
        rexr=not r,
        vexl=l,
        vexv=complement v,
        vexm='00001'} #TODO: sane default value for vexm,rexw,rexb,..
end

val p/vex/66/0f [0xc4 'r:1 x:1 b:1 00001' 'w:1 v:4 l:1 01'] = do
   update
      @{rex='1',
        rexw=w,
        vexw=w,
        rexr=not r,
        rexb=not b,
        rexx=not x,
        vexl=l,
        vexv=complement v,
        vexm='00001'}
end

val p/vex/66/0f [0xc5 'r:1 v:4 l:1 01'] = do
   update
      @{rex='1',
        rexw='0',
        vexw='0',
        rexr=not r,
        vexl=l,
        vexv=complement v,
        vexm='00001'} #TODO: sane default value for vexm,rexw,rexb,..
end

val p/vex/f3/0f [0xc4 'r:1 x:1 b:1 00001' 'w:1 v:4 l:1 10'] = do
   update
      @{rex='1',
        rexw=w,
        vexw=w,
        rexr=not r,
        rexb=not b,
        rexx=not x,
        vexl=l,
        vexv=complement v,
        vexm='00001'}
end

val p/vex/f3/0f [0xc5 'r:1 v:4 l:1 10'] = do
   update
      @{rex='1',
        rexw='0',
        vexw='0',
        rexr=not r,
        vexl=l,
        vexv=complement v,
        vexm='00001'} #TODO: sane default value for vexm,rexw,rexb,..
end

val p/vex/f2/0f [0xc4 'r:1 x:1 b:1 00001' 'w:1 v:4 l:1 11'] = do
   update
      @{rex='1',
        rexw=w,
        vexw=w,
        rexr=not r,
        rexb=not b,
        rexx=not x,
        vexl=l,
        vexv=complement v,
        vexm='00001'}
end

val p/vex/f2/0f [0xc5 'r:1 v:4 l:1 11'] = do
   update
      @{rex='1',
        rexw='0',
        vexw='0',
        rexr=not r,
        vexl=l,
        vexv=complement v,
        vexm='00001'} #TODO: sane default value for vexm,rexw,rexb,..
end

val p/vex/0f/38 [0xc4 'r:1 x:1 b:1 00010' 'w:1 v:4 l:1 00'] = do
   update
      @{rex='1',
        rexw=w,
        vexw=w,
        rexr=not r,
        rexb=not b,
        rexx=not x,
        vexl=l,
        vexv=complement v,
        vexm='00010'}
end

val p/vex/66/0f/38 [0xc4 'r:1 x:1 b:1 00010' 'w:1 v:4 l:1 01'] = do
   update
      @{rex='1',
        rexw=w,
        vexw=w,
        rexr=not r,
        rexb=not b,
        rexx=not x,
        vexl=l,
        vexv=complement v,
        vexm='00010'}
end

val p/vex/f2/0f/38 [0xc4 'r:1 x:1 b:1 00010' 'w:1 v:4 l:1 11'] = do
   update
      @{rex='1',
        rexw=w,
        vexw=w,
        rexr=not r,
        rexb=not b,
        rexx=not x,
        vexl=l,
        vexv=complement v,
        vexm='00010'}
end

val p/vex/f3/0f/38 [0xc4 'r:1 x:1 b:1 00010' 'w:1 v:4 l:1 10'] = do
   update
      @{rex='1',
        rexw=w,
        vexw=w,
        rexr=not r,
        rexb=not b,
        rexx=not x,
        vexl=l,
        vexv=complement v,
        vexm='00010'}
end

val p/vex/0f/3a [0xc4 'r:1 x:1 b:1 00011' 'w:1 v:4 l:1 00'] = do
   update
      @{rex='1',
        rexw=w,
        vexw=w,
        rexr=not r,
        rexb=not b,
        rexx=not x,
        vexl=l,
        vexv=complement v,
        vexm='00011'}
end

val p/vex/66/0f/3a [0xc4 'r:1 x:1 b:1 00011' 'w:1 v:4 l:1 01'] = do
   update
      @{rex='1',
        rexw=w,
        vexw=w,
        rexr=not r,
        rexb=not b,
        rexx=not x,
        vexl=l,
        vexv=complement v,
        vexm='00011'}
end

val p/vex/f2/0f/3a [0xc4 'r:1 x:1 b:1 00011' 'w:1 v:4 l:1 11'] = do
   update
      @{rex='1',
        rexw=w,
        vexw=w,
        rexr=not r,
        rexb=not b,
        rexx=not x,
        vexl=l,
        vexv=complement v,
        vexm='00011'}
end

val p/vex/f3/0f/3a [0xc4 'r:1 x:1 b:1 00011' 'w:1 v:4 l:1 10'] = do
   update
      @{rex='1',
        rexw=w,
        vexw=w,
        rexr=not r,
        rexb=not b,
        rexx=not x,
        vexl=l,
        vexv=complement v,
        vexm='00011'}
end

val p64 [0x66] = do set-opndsz; p/66 end
val p64 [0xf2] = do set-repne; p/f2 end
val p64 [0xf3] = do set-rep; p/f3 end
val p64 [/legacy-p] = p64
val p64 [/rex-p] = p64
#val p64 [p/vex/0f] = /vex/0f
val p64 [p/vex/f2/0f] = /vex/f2/0f
val p64 [p/vex/f3/0f] = /vex/f3/0f
val p64 [p/vex/66/0f] = /vex/66/0f
val p64 [p/vex/66/0f/38] = /vex/66/0f/38
val p64 [p/vex/66/0f/3a] = /vex/66/0f/3a
#val p64 [p/vex/66/f2/0f] = /vex/66/f2/0f
#val p64 [p/vex/66/f3/0f] = /vex/66/f3/0f
val p64 [] = /

val p/66 [0xf2] = do set-repne; p/66/f2 end
val p/66 [0xf3] = do set-rep; p/66/f3 end
val p/66 [0x66] = do set-opndsz; p/66 end
val p/66 [/legacy-p] = p/66
val p/66 [/rex-p] = p/66
val p/66 [] = after /66 /

val p/f2 [0x66] = do set-opndsz; p/66/f2 end
val p/f2 [0xf2] = do set-repne; p/f2 end
val p/f2 [0xf3] = do set-rep; p/f2/f3 end
val p/f2 [/legacy-p] = p/f2
val p/f2 [/rex-p] = p/f2
val p/f2 [] = after /f2 / 

val p/f3 [0x66] = do set-opndsz; p/66/f3 end
val p/f3 [0xf2] = do set-repne; p/f3/f2 end
val p/f3 [0xf3] = do set-rep; p/f3 end
val p/f3 [/legacy-p] = p/f3
val p/f3 [/rex-p] = p/f3
val p/f3 [] = after /f3 / 

val p/f2/f3 [0x66] = do set-opndsz; p/66/f2/f3 end
val p/f2/f3 [0xf2] = do set-repne; p/f3/f2 end
val p/f2/f3 [0xf3] = do set-rep; p/f2/f3 end
val p/f2/f3 [/legacy-p] = p/f2/f3
val p/f2/f3 [/rex-p] = p/f2/f3
val p/f2/f3 [] = after /f3 (after /f2 /)

val p/f3/f2 [0x66] = do set-opndsz; p/66/f2/f3 end
val p/f3/f2 [0xf2] = do set-repne; p/f3/f2 end
val p/f3/f2 [0xf3] = do set-rep; p/f2/f3 end
val p/f3/f2 [/legacy-p] = p/f3/f2
val p/f3/f2 [/rex-p] = p/f3/f2
val p/f3/f2 [] = after /f2 (after /f3 /)

val p/66/f2 [0x66] = do set-opndsz; p/66/f2 end
val p/66/f2 [0xf2] = do set-repne; p/66/f2 end
val p/66/f2 [0xf3] = do set-rep; p/66/f2/f3 end
val p/66/f2 [/legacy-p] = p/66/f2
val p/66/f2 [/rex-p] = p/66/f2
val p/66/f2 [] = after /f2 (after /66 /)

val p/66/f3 [0x66] = do set-opndsz; p/66/f3 end
val p/66/f3 [0xf2] = do set-repne; p/66/f3/f2 end
val p/66/f3 [0xf3] = do set-rep; p/66/f3 end
val p/66/f3 [/legacy-p] = p/66/f3
val p/66/f3 [/rex-p] = p/66/f3
val p/66/f3 [] = after /f3 (after /66 /)

val p/66/f2/f3 [0x66] = do clear-rex; p/66/f2/f3 end
val p/66/f2/f3 [0xf2] = do clear-rex; p/66/f3/f2 end
val p/66/f2/f3 [0xf3] = do clear-rex; p/66/f2/f3 end
val p/66/f2/f3 [/legacy-p] = p/66/f2/f3
val p/66/f2/f3 [/rex-p] = p/66/f2/f3
val p/66/f2/f3 [] = after /f3 (after /f2 (after /66 /))

val p/66/f3/f2 [0x66] = do clear-rex; p/66/f3/f2 end
val p/66/f3/f2 [0xf2] = do clear-rex; p/66/f3/f2 end
val p/66/f3/f2 [0xf3] = do clear-rex; p/66/f2/f3 end
val p/66/f3/f2 [/legacy-p] = p/66/f3/f2
val p/66/f3/f2 [/rex-p] = p/66/f3/f2
val p/66/f3/f2 [] = after /f2 (after /f3 (after /66 /))

datatype register =
   AL
 | AH
 | AX
 | EAX
 | RAX
 | BL
 | BH
 | BX
 | EBX
 | RBX
 | CL
 | CH
 | CX
 | ECX
 | RCX
 | DL
 | DH
 | DX
 | EDX
 | RDX
 | R8B
 | R8L
 | R8D
 | R8 
 | R9B
 | R9L
 | R9D
 | R9 
 | R10B
 | R10L
 | R10D
 | R10 
 | R11B
 | R11L
 | R11D
 | R11 
 | R12B
 | R12L
 | R12D
 | R12 
 | R13B
 | R13L
 | R13D
 | R13 
 | R14B
 | R14L
 | R14D
 | R14 
 | R15B
 | R15L
 | R15D
 | R15 
 | SP
 | ESP
 | RSP
 | BP
 | EBP
 | RBP
 | SI
 | ESI
 | RSI
 | DI
 | EDI
 | RDI
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
 | ST0
 | ST1
 | ST2
 | ST3
 | ST4
 | ST5
 | ST6
 | ST7

datatype opnd =
   IMM8 of 8
 | IMM16 of 16
 | IMM32 of 32
 | IMM64 of 64
 | REG of register
 | MEM of {sz: int, segment: register, opnd: opnd}
 | SUM of {a:opnd, b:opnd}
 | SCALE of {imm:2, opnd:opnd}

datatype flowopnd =
   REL8 of 8
 | REL16 of 16
 | REL32 of 32
 | REL64 of 64
 | NEARABS of opnd
 | FARABS of opnd

datatype insn =
   ARITY0 of {tag:mnemonic}
 | ARITY1 of {tag:mnemonic,opnd1:opnd}
 | ARITY2 of {tag:mnemonic,opnd1:opnd,opnd2:opnd}
 | ARITY3 of {tag:mnemonic,opnd1:opnd,opnd2:opnd,opnd3:opnd}
 | ARITY4 of {tag:mnemonic,opnd1:opnd,opnd2:opnd,opnd3:opnd,opnd4:opnd}
 | FLOW1 of {tag:mnemonic,opnd1:flowopnd}

datatype mnemonic =
   ADC
 | ADD
 | AND
 | BSF
 | BSR
 | BSWAP
 | BT
 | CALL
 | CBW
 | CDQE
 | CLD
 | CMOVA
 | CMOVAE
 | CMOVB
 | CMOVBE
 | CMOVC
 | CMOVE
 | CMOVG
 | CMOVGE
 | CMOVL
 | CMOVLE
 | CMOVNA
 | CMOVNAE
 | CMOVNB
 | CMOVNBE
 | CMOVNC
 | CMOVNE
 | CMOVNG
 | CMOVNGE
 | CMOVNL
 | CMOVNLE
 | CMOVNO
 | CMOVNP
 | CMOVNS
 | CMOVNZ
 | CMOVO
 | CMOVP
 | CMOVPE
 | CMOVPO
 | CMOVS
 | CMOVZ
 | CMP
 | CMPSB
 | CMPSD
 | CMPSQ
 | CMPSW
 | CMPXCHG
 | CPUID
 | CVTPD2PI
 | CVTSI2SD
 | CWDE
 | DEC
 | DIV
 | DIVSD
 | FCHS
 | FCMOVB
 | FCMOVBE
 | FCMOVE
 | FCMOVNB
 | FCMOVNBE
 | FCMOVNE
 | FCMOVNU
 | FCMOVU
 | FCOMI
 | FCOMIP
 | FLD
 | FLD1
 | FLDCW
 | FLDENV
 | FLDL2E
 | FLDL2T
 | FLDLG2
 | FLDLN2
 | FLDPI
 | FLDZ
 | FNSTCW
 | FST
 | FSTCW
 | FSTP
 | FUCOMI
 | FUCOMIP
 | HLT
 | IDIV
 | IMUL
 | INC
 | JA
 | JAE
 | JB
 | JBE
 | JC
 | JCXZ
 | JE
 | JECXZ
 | JG
 | JGE
 | JL
 | JLE
 | JMP
 | JNA
 | JNAE
 | JNB
 | JNBE
 | JNC
 | JNE
 | JNG
 | JNGE
 | JNL
 | JNLE
 | JNO
 | JNP
 | JNS
 | JNZ
 | JO
 | JP
 | JPE
 | JPO
 | JRCXZ
 | JS
 | JZ
 | LDDQU
 | LEA
 | LEAVE
 | LFENCE
 | MASKMOVDQU
 | MASKMOVQ
 | MAXPD
 | MAXPS
 | MAXSD
 | MAXSS
 | MFENCE
 | MINPD
 | MINPS
 | MINSD
 | MINSS
 | MONITOR
 | MOV
 | MOVAPD
 | MOVAPS
 | MOVBE
 | MOVD
 | MOVDDUP
 | MOVDQ2Q
 | MOVDQA
 | MOVDQU
 | MOVHLPS
 | MOVHPD
 | MOVHPS
 | MOVLHPS
 | MOVLPD
 | MOVLPS
 | MOVMSKPD
 | MOVMSKPS
 | MOVNTDQ
 | MOVNTDQA
 | MOVNTI
 | MOVNTPD
 | MOVNTPS
 | MOVNTQ
 | MOVQ
 | MOVSB
 | MOVSD
 | MOVSQ
 | MOVSS
 | MOVSW
 | MOVSX
 | MOVSXD
 | MOVZX
 | MUL
 | NEG
 | NOP
 | NOT
 | OR
 | PALIGNR
 | PAND
 | PCMPEQB
 | PCMPEQD
 | PCMPEQQ
 | PCMPEQW
 | PCMPESTRI
 | PCMPGRD
 | PCMPGTB
 | PCMPGTD
 | PCMPGTW
 | PCMPISTRI
 | PHADDD
 | PHADDW
 | PINSRB
 | PINSRD
 | PINSRQ
 | PMOVMSKB
 | POP
 | POR
 | PREFETCHT0
 | PREFETCHT1
 | PREFETCHT2
 | PREFETCHNTA
 | PREFETCHW
 | PSHUFB
 | PSHUFD
 | PSLLDQ
 | PSLRDQ
 | PSRLDQ
 | PSUBB
 | PSUBD
 | PSUBW
 | PTEST
 | PUNPACKLBW
 | PUNPACKLDQ
 | PUNPACKLQDQ
 | PUNPACKLWD
 | PUNPCKLBW
 | PUNPCKLQDQ
 | PUSH
 | PXOR
 | RCL
 | RCR
 | RDTSC
 | RDTSCP
 | RET
 | RET_FAR
 | ROL
 | ROR
 | SAL
 | SAR
 | SBB
 | SCASB
 | SCASD
 | SCASQ
 | SCASW
 | SETA
 | SETAE
 | SETB
 | SETBE
 | SETC
 | SETE
 | SETG
 | SETGE
 | SETL
 | SETLE
 | SETNA
 | SETNAE
 | SETNB
 | SETNBE
 | SETNC
 | SETNE
 | SETNG
 | SETNGE
 | SETNL
 | SETNLE
 | SETNO
 | SETNP
 | SETNS
 | SETNZ
 | SETO
 | SETP
 | SETPE
 | SETPO
 | SETS
 | SETZ
 | SFENCE
 | SHL
 | SHLD
 | SHR
 | SHRD
 | STOSB
 | STOSD
 | STOSQ
 | STOSW
 | SUB
 | SYSCALL
 | TEST
 | UCOMISD
 | UD2
 | VBMOVHPD
 | VBMOVHPS
 | VBMOVLPD
 | VBMOVLPS
 | VCMPEQB
 | VCMPEQD
 | VCMPEQW
 | VCMPESTRI
 | VLDDQU
 | VMASKMOVDQU
 | VMAXPD
 | VMAXPS
 | VMAXSD
 | VMAXSS
 | VMINPD
 | VMINPS
 | VMINSD
 | VMINSS
 | VMOVAPD
 | VMOVAPS
 | VMOVD
 | VMOVDDUP
 | VMOVDQA
 | VMOVDQU
 | VMOVHLPS
 | VMOVHPD
 | VMOVHPS
 | VMOVLHPS
 | VMOVLPD
 | VMOVLPS
 | VMOVMSKPD
 | VMOVMSKPS
 | VMOVNTDQ
 | VMOVNTDQA
 | VMOVNTPD
 | VMOVNTPS
 | VMOVQ
 | VMOVSS
 | VPALIGNR
 | VPAND
 | VPCMPEQQ
 | VPCMPGTB
 | VPCMPGTD
 | VPCMPGTW
 | VPCMPISTRI
 | VPHADDD
 | VPHADDW
 | VPINSRB
 | VPINSRD
 | VPINSRQ
 | VPMOVMSKB
 | VPOR
 | VPSHUFB
 | VPSHUFD
 | VPSLLDQ
 | VPSLRDQ
 | VPSUBB
 | VPSUBD
 | VPSUBW
 | VPTEST
 | VPUNPACKLBW
 | VPUNPACKLDQ
 | VPUNPACKLQDQ
 | VPUNPACKLWD
 | VUCOMISD
 | VXORPS
 | XADD
 | XCHG
 | XGETBV
 | XOR
 | XORPD
 | XORPS

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
val cs = return (REG CS)
val ds = return (REG DS)
val es = return (REG ES)
val fs = return (REG FS)
val gs = return (REG GS)
val ss = return (REG SS)
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
val st0 = return (REG ST0)

val imm8 ['b:8'] = return (IMM8 b)
val imm16 ['b1:8' 'b2:8'] = return (IMM16 (b2 ^ b1))
val imm32 ['b1:8' 'b2:8' 'b3:8' 'b4:8'] = return (IMM32 (b4 ^ b3 ^ b2 ^ b1))
val imm64 ['b1:8' 'b2:8' 'b3:8' 'b4:8' 'b5:8' 'b6:8' 'b7:8' 'b8:8'] =
   return (IMM64 (b8 ^ b7 ^ b6 ^ b5 ^ b4 ^ b3 ^ b2 ^ b1))

val rel8 ['b:8'] = return (REL8 b)
val rel16 ['b1:8' 'b2:8'] = return (REL16 (b2 ^ b1))
val rel32 ['b1:8' 'b2:8' 'b3:8' 'b4:8'] = return (REL32 (b4 ^ b3 ^ b2 ^ b1))
val rel64 ['b1:8' 'b2:8' 'b3:8' 'b4:8' 'b5:8' 'b6:8' 'b7:8' 'b8:8'] =
   return (REL64 (b8 ^ b7 ^ b6 ^ b5 ^ b4 ^ b3 ^ b2 ^ b1))

val & giveA giveB = do
   a <- giveA;
   b <- giveB;
   return (a andalso b)
end

val otherwise = return '1'

val vex128? = do
   l <- query $vexl;
   return (l == '0')
end

val vex256? = query $vexl

val vnds? = do
   v <- query $vexv;
   return (not (v == '1111'))
end

val vndd? = do
   v <- query $vexv;
   return (not (v == '1111'))
end

val vexw0? = do
   w <- query $vexw;
   return (w == '0')
end

val vexw1? = do
   w <- query $vexw;
   return (w == '1')
end

val complement v = not v

val opndsz? = query $opndsz
val addrsz? = query $addrsz
val repne? =  query $repne
val rep? = query $rep
val rexw? = query $rexw
val vexw? = query $rexw
val rex? = query $rex

val mode64? = query $mode64

## Convert a bit-vectors to registers

val st-reg n = 
   case n of
      '0000': REG ST0
    | '0001': REG ST1
    | '0010': REG ST2
    | '0011': REG ST3
    | '0100': REG ST4
    | '0101': REG ST5
    | '0110': REG ST6
    | '0111': REG ST7
  end

val sti extension n = st-reg (extension ^ n)
val st n = return (st-reg n)
val st/i n = return (st-reg ('0' ^ n))

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
    | '1000': REG R8B
    | '1001': REG R9B
    | '1010': REG R10B
    | '1011': REG R11B
    | '1100': REG R12B
    | '1101': REG R13B
    | '1110': REG R14B
    | '1111': REG R15B
   end

val reg8-rex rex reg-idx = reg8 (rex ^ reg-idx)

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
    | '1001': REG R9L
    | '1010': REG R10L
    | '1011': REG R11L
    | '1100': REG R12L
    | '1101': REG R13L
    | '1110': REG R14L
    | '1111': REG R15L
   end

val reg16-rex rex reg-idx = reg16 (rex ^ reg-idx)

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
    | '1001': REG R9D
    | '1010': REG R10D
    | '1011': REG R11D
    | '1100': REG R12D
    | '1101': REG R13D
    | '1110': REG R14D
    | '1111': REG R15D
   end

val reg32-rex rex reg-idx = reg32 (rex ^ reg-idx)

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
    | '1001': REG R9
    | '1010': REG R10
    | '1011': REG R11
    | '1100': REG R12
    | '1101': REG R13
    | '1110': REG R14
    | '1111': REG R15
   end

val reg64-rex rex reg-idx = reg64 (rex ^ reg-idx)

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

val sreg3? rex n = sreg3 n

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

val mm-rex rex reg-idx = mm (rex ^ reg-idx)

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

val xmm-rex rex reg-idx = xmm (rex ^ reg-idx)

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

val ymm-rex rex reg-idx = ymm (rex ^ reg-idx)

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
val /r-mem ['mod@00|01|10 reg/opcode:3 rm:3'] = update @{mod=mod, reg/opcode=reg/opcode, rm=rm}
val /r-nomem ['11 reg/opcode:3 rm:3'] = update @{mod='11', reg/opcode=reg/opcode, rm=rm}
val /0-mem ['mod@00|01|10 000 rm:3'] = update @{mod=mod, rm=rm, reg/opcode='000'}
val /1-mem ['mod@00|01|10 001 rm:3'] = update @{mod=mod, rm=rm, reg/opcode='001'}
val /2-mem ['mod@00|01|10 010 rm:3'] = update @{mod=mod, rm=rm, reg/opcode='010'}
val /3-mem ['mod@00|01|10 011 rm:3'] = update @{mod=mod, rm=rm, reg/opcode='011'}
val /4-mem ['mod@00|01|10 100 rm:3'] = update @{mod=mod, rm=rm, reg/opcode='100'}
val /5-mem ['mod@00|01|10 101 rm:3'] = update @{mod=mod, rm=rm, reg/opcode='101'}
val /6-mem ['mod@00|01|10 110 rm:3'] = update @{mod=mod, rm=rm, reg/opcode='110'}
val /7-mem ['mod@00|01|10 111 rm:3'] = update @{mod=mod, rm=rm, reg/opcode='111'}
val /0-nomem ['11 000 rm:3'] = update @{mod='11', rm=rm, reg/opcode='000'}
val /1-nomem ['11 001 rm:3'] = update @{mod='11', rm=rm, reg/opcode='001'}
val /2-nomem ['11 010 rm:3'] = update @{mod='11', rm=rm, reg/opcode='010'}
val /3-nomem ['11 011 rm:3'] = update @{mod='11', rm=rm, reg/opcode='011'}
val /4-nomem ['11 100 rm:3'] = update @{mod='11', rm=rm, reg/opcode='100'}
val /5-nomem ['11 101 rm:3'] = update @{mod='11', rm=rm, reg/opcode='101'}
val /6-nomem ['11 110 rm:3'] = update @{mod='11', rm=rm, reg/opcode='110'}
val /7-nomem ['11 111 rm:3'] = update @{mod='11', rm=rm, reg/opcode='111'}

## Decoding the SIB byte
#    TODO: this is only for 32bit addressing

val sib-without-index reg = do
   mod <- query $mod;
   rexb <- query $rexb;
   case mod of
      '00': imm32
    | '01': return (reg rexb '101') # rBP
    | '10': return (reg rexb '101') # rBP
   end
end

val sib-without-base reg scale index = do
   rexx <- query $rexx;
   scaled <- return (SCALE{imm=scale, opnd=reg rexx index});
   mod <- query $mod;
   rexb <- query $rexb;
   case mod of
      '00': 
         do
            i <- imm32;
            return (SUM{a=scaled, b=i})
         end
    | _ : return (SUM{a=scaled, b=reg rexb '101'}) # rBP
   end
end

val sib-with-index-and-base reg s i b = do
   rexx <- query $rexx;
   rexb <- query $rexb;
   case i of
      '100':
         case b of
            '101': sib-without-index reg
          | _: return (reg rexb b)
         end
    | _:
         case b of
            '101': sib-without-base reg s i
          | _: return (SUM{a=SCALE{imm=s, opnd=reg rexx i}, b=reg rexb b})
         end
   end
end

val sib ['scale:2 index:3 base:3']
 | addrsz? = sib-with-index-and-base reg16-rex scale index base
 | mode64? = sib-with-index-and-base reg64-rex scale index base
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
   sz <- query $ptrty;
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

val r/m-without-sib = do
   mod <- query $mod;
   rm <- query $rm;
   rexb <- query $rexb;
   addr-reg <- addrReg;
   case mod of
      '00':
         case rm of
            '101':
               do
                  i <- imm32;
                  mem i
               end
          | _ : mem (addr-reg rexb rm)
         end
    | '01':
         do
            i <- imm8;
            mem (SUM{a=addr-reg rexb rm, b=i})
         end
    | '10':
         do
            i <- imm32;
            mem (SUM{a=addr-reg rexb rm, b=i})
         end
   end
end

val addrReg = do
   addrsz <- query $addrsz;
   case addrsz of
      '0': return reg64-rex
    | '1': return reg32-rex
   end
end

val r/m ptrTy reg = do
   update@{ptrty=ptrTy};
   mod <- query $mod;
   rm <- query $rm;
   rexb <- query $rexb;
   case mod of
      '11': return (reg rexb rm)
    | _:
         case rm of
            '100': r/m-with-sib
          | _ : r/m-without-sib
         end
   end
end

val r/m8 = r/m 8 reg8-rex
val r/m16 = r/m 16 reg16-rex
val r/m32 = r/m 32 reg32-rex
val r/m64 = r/m 64 reg64-rex
val mm/m64 = r/m 64 mm-rex
val mm/m32 = r/m 32 mm-rex
val xmm/m128 = r/m 128 xmm-rex
val xmm/m64 = r/m 64 xmm-rex
val xmm/m32 = r/m 32 xmm-rex
val ymm/m256 = r/m 256 ymm-rex

val v/xmm = do
   v <- query $vexv;
   return (xmm v)
end

val v/ymm = do
   v <- query $vexv;
   return (ymm v)
end

val reg/nomem reg = do
   mod <- query $mod;
   case mod of
      '11': r/m 0 reg
   end
end

val xmm/nomem128 = reg/nomem xmm-rex
val mm/nomem64 = reg/nomem mm-rex

val m8 = r/m8
val m16 = r/m16
val m32 = r/m32
val m64 = r/m64
val m128 = xmm/m128
val m256 = ymm/m256
val m80fp = r/m 80 reg64-rex #TODO: check

val st/m16 = r/m 16 sti
val st/m32 = r/m 32 sti
val st/m64 = r/m 64 sti

val r/rexb reg = do
   mod <- query $rexb;
   r <- query $reg/opcode;
   return (reg mod r)
end

val r/rexr reg = do
   mod <- query $rexr;
   r <- query $reg/opcode;
   return (reg mod r)
end

val r8 = r/rexr reg8-rex
val r16 = r/rexr reg16-rex
val r32 = r/rexr reg32-rex
val r64 = r/rexr reg64-rex
val r8/rexb = r/rexb reg8-rex
val r16/rexb = r/rexb reg16-rex
val r32/rexb = r/rexb reg32-rex
val r64/rexb = r/rexb reg64-rex
val mm64 = r/rexb mm-rex
val xmm128 = r/rexr xmm-rex
val ymm256 = r/rexr ymm-rex

val reg = do
   r <- query$rexw;
   case r of
      '1': r64
    | '0': r32
   end
end

val vreg = do
   r <- query$vexw;
   case r of
      '1': r64
    | '0': r32
   end
end

#TODO: set correct `ptrty` for `moffs*`

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

val arity0 cons = return (ARITY0 {tag=cons})

val unop cons giveOp1 = do
  op1 <- giveOp1;
  return (ARITY1 {tag=cons,opnd1=op1})
end

val binop cons giveOp1 giveOp2 = do
   op1 <- giveOp1;
   op2 <- giveOp2;
   return (ARITY2 {tag=cons,opnd1=op1,opnd2=op2})
end

val ternop cons giveOp1 giveOp2 giveOp3 = do
   op1 <- giveOp1;
   op2 <- giveOp2;
   op3 <- giveOp3;
   return (ARITY3 {tag=cons,opnd1=op1,opnd2=op2,opnd3=op3})
end

val quaternop cons giveOp1 giveOp2 giveOp3 giveOp4 = do
   op1 <- giveOp1;
   op2 <- giveOp2;
   op3 <- giveOp3;
   op4 <- giveOp4;
   return (ARITY4 {tag=cons,opnd1=op1,opnd2=op2,opnd3=op3,opnd4=op4})
end

val near-abs cons giveOp = do
   op <- giveOp;
   return (FLOW1 {tag=cons,opnd1=NEARABS op})
end

val near-rel cons giveOp = do
   op <- giveOp;
   return (FLOW1 {tag=cons,opnd1=op})
end

val far-abs cons giveOp = do
   op <- giveOp;
   return (FLOW1 {tag=cons,opnd1=FARABS op})
end

val one = return (IMM8 '00000001')

### ADC 
val / [0x14] = binop ADC al imm8
val / [0x15]
 | opndsz? = binop ADC ax imm16
 | rexw? = binop ADC rax imm32
 | otherwise = binop ADC eax imm32
val / [0x80 /2] = binop ADC r/m8 imm8
val / [0x81 /2]
 | opndsz? = binop ADC r/m16 imm16
 | rexw? = binop ADC r/m64 imm32
 | otherwise = binop ADC r/m32 imm32
val / [0x83 /2]
 | opndsz? = binop ADC r/m16 imm8
 | rexw? = binop ADC r/m64 imm8
 | otherwise = binop ADC r/m32 imm8
val / [0x10 /r] = binop ADC r/m8 r8
val / [0x11 /r]
 | opndsz? = binop ADC r/m16 r16
 | rexw? = binop ADC r/m64 r64
 | otherwise = binop ADC r/m32 r32
val / [0x12 /r] = binop ADC r8 r/m8
val / [0x13 /r]
 | opndsz? = binop ADC r16 r/m16
 | rexw? = binop ADC r64 r/m64
 | otherwise = binop ADC r32 r/m32 

### BSF
val / [0x0f 0xbc /r]
 | opndsz? = binop BSF r16 r/m16
 | rexw? = binop BSF r64 r/m64
 | otherwise = binop BSF r32 r/m32

### BSR
val / [0x0f 0xbd /r]
 | opndsz? = binop BSR r16 r/m16
 | rexw? = binop BSR r64 r/m64
 | otherwise = binop BSR r32 r/m32

### CLD
val / [0xfc] = arity0 CLD

### CPUID
val / [0x0f 0xa2] = arity0 CPUID

### FCHS
val / [0xd9 0xe0] = arity0 FCHS

### FCMOVcc
val / [0xda '11000 i:3'] = binop FCMOVB st0 (st/i i)
val / [0xda '11001 i:3'] = binop FCMOVE st0 (st/i i)
val / [0xda '11010 i:3'] = binop FCMOVBE st0 (st/i i)
val / [0xda '10011 i:3'] = binop FCMOVU st0 (st/i i)
val / [0xdb '11000 i:3'] = binop FCMOVNB st0 (st/i i)
val / [0xdb '11001 i:3'] = binop FCMOVNE st0 (st/i i)
val / [0xdb '11010 i:3'] = binop FCMOVNBE st0 (st/i i)
val / [0xdb '10011 i:3'] = binop FCMOVNU st0 (st/i i)

### FLD
val / [0xd9 /0] = unop FLD st/m32
val / [0xdd /0-mem] = unop FLD m64
val / [0xdb /5-mem] = unop FLD m80fp

### FLDCW
val / [0xd9 /5-mem] = unop FLDCW m2byte 

val m14/28byte = m80fp #TODO: fix
val m2byte = m16 #TODO: check

### FLD1/FLDL2T/FLDL2E/FLDPI/FLDLG2/FLDLN2/FLDZ
val / [0xd9 0xe8] = arity0 FLD1
val / [0xd9 0xe9] = arity0 FLDL2T
val / [0xd9 0xea] = arity0 FLDL2E
val / [0xd9 0xeb] = arity0 FLDPI
val / [0xd9 0xec] = arity0 FLDLG2
val / [0xd9 0xed] = arity0 FLDLN2
val / [0xd9 0xee] = arity0 FLDZ

### FLDENV
val / [0xd9 /4-mem] = unop FLDENV m14/28byte

### FSTCW/FNSTCW
val / [0x9b 0xd9 /7-mem] = unop FSTCW m2byte
val / [0xd9 /7-mem] = unop FNSTCW m2byte

### FSTP
val / [0xd9 /2-mem] = unop FST m32
val / [0xdd /2] = unop FST st/m64
val / [0xd9 /3-mem] = unop FSTP m32
val / [0xdd /3] = unop FSTP st/m64
val / [0xdb /7-mem] = unop FSTP m80fp

### FCOMI/FCOMIP/FUCOMI/FUCOMIP
val / [0xdb '11110 i:3'] = binop FCOMI st0 (st/i i)
val / [0xdf '11110 i:3'] = binop FCOMIP st0 (st/i i)
val / [0xdb '11101 i:3'] = binop FUCOMI st0 (st/i i)
val / [0xdf '11101 i:3'] = binop FUCOMIP st0 (st/i i)

### LDDQU
val /f2 [0x0f 0xf0 /r-mem] = binop LDDQU xmm128 m128
val /vex/f2/0f [0xf0 /r-mem]
 | vex128? = binop VLDDQU xmm128 m128
 | otherwise = binop VLDDQU ymm256 m256

### LFENCE
val / [0x0f 0xae /5] = arity0 LFENCE

### MOVSS
val /f3 [0x0f 0x10 /r] = binop MOVSS xmm128 xmm/m32
val /vex/f3/0f [0x10 /r]
 | vnds? = ternop VMOVSS xmm128 v/xmm xmm/nomem128 
 | otherwise = binop VMOVSS xmm128 m32
val /f3 [0x0f 0x11 /r] = binop MOVSS xmm/m32 xmm128
val /vex/f2/0f [0x11 /r]
 | vnds? = ternop VMOVSS xmm128 v/xmm xmm/nomem128
 | otherwise = binop VMOVSS m32 xmm128

### PALIGNR
val / [0x0f 0x3a 0x0f /r] = ternop PALIGNR mm64 mm/m64 imm8
val /66 [0x0f 0x3a 0x0f /r] = ternop PALIGNR xmm128 xmm/m128 imm8
val /vex/66/0f/3a [0x0f /r] | vex128? = quaternop VPALIGNR xmm128 v/xmm xmm/m128 imm8

### PAND
val / [0x0f 0xdb /r] = binop PAND mm64 mm/m64
val /66 [0x0f 0xdb /r] = binop PAND xmm128 xmm/m128
val /vex/66/0f [0xdb /r] | vnds? & vex128? = ternop VPAND xmm128 v/xmm xmm/m128

### PCMPEQB/PCMPEQW/PCMPEQD
val / [0x0f 0x74 /r] = binop PCMPEQB mm64 mm/m64
val /66 [0x0f 0x74 /r] = binop PCMPEQB xmm128 xmm/m128
val / [0x0f 0x75 /r] = binop PCMPEQW mm64 mm/m64
val /66 [0x0f 0x75 /r] = binop PCMPEQW xmm128 xmm/m128
val / [0x0f 0x76 /r] = binop PCMPEQD mm64 mm/m64
val /66 [0x0f 0x76 /r] = binop PCMPEQD xmm128 xmm/m128
val /vex/66/0f [0x74 /r] | vnds? = ternop VCMPEQB xmm128 v/xmm xmm/m128
val /vex/66/0f [0x75 /r] | vnds? = ternop VCMPEQW xmm128 v/xmm xmm/m128
val /vex/66/0f [0x76 /r] | vnds? = ternop VCMPEQD xmm128 v/xmm xmm/m128

### PCMPESTRI
val /66 [0x0f 0x3a 0x61 /r] = ternop PCMPESTRI xmm128 xmm/m128 imm8
val /vex/66/0f/3a [0x61 /r] = ternop VCMPESTRI xmm128 xmm/m128 imm8

### PCMPGTB/PCMPGTW/PCMPGTD
val / [0x0f 0x64 /r] = binop PCMPGTB mm64 mm/m64
val /66 [0x0f 0x64 /r] = binop PCMPGTB xmm128 xmm/m128
val / [0x0f 0x65 /r] = binop PCMPGTW mm64 mm/m64
val /66 [0x0f 0x65 /r] = binop PCMPGTW xmm128 xmm/m128
val / [0x0f 0x66 /r] = binop PCMPGTD mm64 mm/m64
val /66 [0x0f 0x66 /r] = binop PCMPGRD xmm128 xmm/m128
val /vex/66/0f [0x64 /r] | vnds? & vex128? = ternop VPCMPGTB xmm128 v/xmm xmm/m128
val /vex/66/0f [0x65 /r] | vnds? & vex128? = ternop VPCMPGTW xmm128 v/xmm xmm/m128
val /vex/66/0f [0x66 /r] | vnds? & vex128? = ternop VPCMPGTD xmm128 v/xmm xmm/m128

### PCMPISTRI
val /66 [0x0f 0x3a 0x63 /r] = ternop PCMPISTRI xmm128 xmm/m128 imm8
val /vex/66/0f/3a [0x63 /r] | vex128? = ternop VPCMPISTRI xmm128 xmm/m128 imm8

### PINSRB/PINSRD/PINSRQ
val /66 [0x0f 0x3a 0x20 /r] = ternop PINSRB xmm128 r/m8 imm8
val /66 [0x0f 0x3a 0x22 /r]
 | rexw? = ternop PINSRQ xmm128 r/m64 imm8
 | otherwise = ternop PINSRD xmm128 r/m32 imm8
val /vex/66/0f/3a [0x20 /r] | vex128? & vexw0? = quaternop VPINSRB xmm128 v/xmm r/m8 imm8
val /vex/66/0f/3a [0x22 /r] 
 | vex128? & vexw1? = quaternop VPINSRQ xmm128 v/xmm r/m64 imm8
 | vex128? = quaternop VPINSRD xmm128 v/xmm r/m32 imm8

### POR
val / [0x0f 0xeb /r] = binop POR mm64 mm/m64
val /66 [0x0f 0xeb /r] = binop POR xmm128 xmm/m128
val /vex/66/0f [0xeb /r] | vnds? & vex128? = ternop VPOR xmm128 v/xmm xmm/m128

### PREFETCHh
val / [0x0f 0x18 /1-mem] = unop PREFETCHT0 m8
val / [0x0f 0x18 /2-mem] = unop PREFETCHT1 m8
val / [0x0f 0x18 /3-mem] = unop PREFETCHT2 m8
val / [0x0f 0x18 /0-mem] = unop PREFETCHNTA m8

### PREFETCHW
###   - this instruction is not part of the intel manual
val / [0x0f 0x0d /r-mem] = unop PREFETCHW m8

### PSHUFB
val / [0x0f 0x38 0x00 /r] = binop PSHUFB mm64 mm/m64
val /66 [0x0f 0x38 0x00 /r] = binop PSHUFB xmm128 xmm/m128
val /vex/66/0f/38 [0x00 /r] | vnds? & vex128? = ternop VPSHUFB xmm128 v/xmm xmm/m128

### PSHUFD
val /66 [0x0f 0x70 /r] = ternop PSHUFD xmm128 xmm/m128 imm8
val /vex/66/0f [0x70 /r] | vex128? = ternop VPSHUFD xmm128 xmm/m128 imm8

### PSLLDQ
val /66 [0x0f 0x73 /7-nomem] = binop PSLLDQ xmm128 imm8
val /vex/66/0f [0x73 /7-nomem] | vndd? & vex128? = ternop VPSLLDQ xmm128 v/xmm imm8

### PSLRDQ
val /66 [0x0f 0x73 /3-nomem] = binop PSLRDQ xmm128 imm8
val /vex/66/0f [0x73 /3-nomem] | vndd? & vex128? = ternop VPSLRDQ xmm128 v/xmm imm8

### PSUBB/PSUBW/PSUBD
val / [0x0f 0xf8 /r] = binop PSUBB mm64 mm/m64
val /66 [0x0f 0xf8 /r] = binop PSUBB xmm128 xmm/m128
val / [0x0f 0xf9 /r] = binop PSUBW mm64 mm/m64
val /66 [0x0f 0xf9 /r] = binop PSUBW xmm128 xmm/m128
val / [0x0f 0xfa /r] = binop PSUBD mm64 mm/m64
val /66 [0x0f 0xfa /r] = binop PSUBD xmm128 xmm/m128
val /vex/66/0f [0xf8 /r] | vnds? & vex128? = ternop VPSUBB xmm128 v/xmm xmm/m128
val /vex/66/0f [0xf9 /r] | vnds? & vex128? = ternop VPSUBW xmm128 v/xmm xmm/m128
val /vex/66/0f [0xfa /r] | vnds? & vex128? = ternop VPSUBD xmm128 v/xmm xmm/m128

### PTEST
val /66 [0x0f 0x38 0x17 /r] = binop PTEST xmm128 xmm/m128
val /vex/66/0f/38 [0x17 /r]
 | vex128? = binop VPTEST xmm128 xmm/m128
 | otherwise = binop VPTEST ymm256 ymm/m256

### PUNPACKLBW/PUNPACKLWD/PUNPACKLDQ/PUNPACKLQDQ
val / [0x0f 0x60 /r] = binop PUNPACKLBW mm64 mm/m32
val /66 [0x0f 0x60 /r] = binop PUNPACKLBW xmm128 xmm/m128
val / [0x0f 0x61 /r] = binop PUNPACKLWD mm64 mm/m32
val /66 [0x0f 0x61 /r] = binop PUNPACKLWD xmm128 xmm/m128
val / [0x0f 0x62 /r] = binop PUNPACKLDQ mm64 mm/m32
val /66 [0x0f 0x62 /r] = binop PUNPACKLDQ xmm128 xmm/m128
val /66 [0x0f 0x6c /r] = binop PUNPACKLQDQ xmm128 xmm/m128
val /vex/66/0f [0x60 /r] | vnds? & vex128? = ternop VPUNPACKLBW xmm128 v/xmm xmm/m128
val /vex/66/0f [0x61 /r] | vnds? & vex128? = ternop VPUNPACKLWD xmm128 v/xmm xmm/m128
val /vex/66/0f [0x62 /r] | vnds? & vex128? = ternop VPUNPACKLDQ xmm128 v/xmm xmm/m128
val /vex/66/0f [0x6c /r] | vnds? & vex128? = ternop VPUNPACKLQDQ xmm128 v/xmm xmm/m128

### RCL/RCR/ROL/ROR
val / [0xd0 /2] = binop RCL r/m8 one
val / [0xd2 /2] = binop RCL r/m8 cl
val / [0xc0 /2] = binop RCL r/m8 imm8
val / [0xd1 /2]
 | opndsz? = binop RCL r/m16 one
 | rexw? = binop RCL r/m64 one
 | otherwise = binop RCL r/m32 one
val / [0xd3 /2]
 | opndsz? = binop RCL r/m16 cl
 | rexw? = binop RCL r/m64 cl
 | otherwise = binop RCL r/m32 cl
val / [0xc1 /2]
 | opndsz? = binop RCL r/m16 imm8
 | rexw? = binop RCL r/m64 imm8
 | otherwise = binop RCL r/m32 imm8
val / [0xd0 /3] = binop RCR r/m8 one
val / [0xd2 /3] = binop RCR r/m8 cl
val / [0xc0 /3] = binop RCR r/m8 imm8
val / [0xd1 /3]
 | opndsz? = binop RCR r/m16 one
 | rexw? = binop RCR r/m64 one
 | otherwise = binop RCR r/m32 one
val / [0xd3 /3]
 | opndsz? = binop RCR r/m16 cl
 | rexw? = binop RCR r/m64 cl
 | otherwise = binop RCR r/m32 cl
val / [0xc1 /3]
 | opndsz? = binop RCR r/m16 imm8
 | rexw? = binop RCR r/m64 imm8
 | otherwise = binop RCR r/m32 imm8
val / [0xd0 /0] = binop ROL r/m8 one
val / [0xd2 /0] = binop ROL r/m8 cl
val / [0xc0 /0] = binop ROL r/m8 imm8
val / [0xd1 /0]
 | opndsz? = binop ROL r/m16 one
 | rexw? = binop ROL r/m64 one
 | otherwise = binop ROL r/m32 one
val / [0xd3 /0]
 | opndsz? = binop ROL r/m16 cl
 | rexw? = binop ROL r/m64 cl
 | otherwise = binop ROL r/m32 cl
val / [0xc1 /0]
 | opndsz? = binop ROL r/m16 imm8
 | rexw? = binop ROL r/m64 imm8
 | otherwise = binop ROL r/m32 imm8
val / [0xd0 /1] = binop ROR r/m8 one
val / [0xd2 /1] = binop ROR r/m8 cl
val / [0xc0 /1] = binop ROR r/m8 imm8
val / [0xd1 /1]
 | opndsz? = binop ROR r/m16 one
 | rexw? = binop ROR r/m64 one
 | otherwise = binop ROR r/m32 one
val / [0xd3 /1]
 | opndsz? = binop ROR r/m16 cl
 | rexw? = binop ROR r/m64 cl
 | otherwise = binop ROR r/m32 cl
val / [0xc1 /1]
 | opndsz? = binop ROR r/m16 imm8
 | rexw? = binop ROR r/m64 imm8
 | otherwise = binop ROR r/m32 imm8

### SFENCE
val / [0x0f 0xae /7] = arity0 SFENCE

### SHLD
val / [0x0f 0xa4 /r]
 | opndsz? = ternop SHLD r/m16 r16 imm8
 | rexw? = ternop SHLD r/m64 r64 imm8
 | otherwise = ternop SHLD r/m32 r32 imm8
val / [0x0f 0xa5 /r]
 | opndsz? = ternop SHLD r/m16 r16 cl
 | rexw? = ternop SHLD r/m64 r64 cl
 | otherwise = ternop SHLD r/m32 r32 cl

### SHRD
val / [0x0f 0xac /r]
 | opndsz? = ternop SHLD r/m16 r16 imm8
 | rexw? = ternop SHLD r/m64 r64 imm8
 | otherwise = ternop SHLD r/m32 r32 imm8
val / [0x0f 0xad /r]
 | opndsz? = ternop SHLD r/m16 r16 cl
 | rexw? = ternop SHLD r/m64 r64 cl
 | otherwise = ternop SHLD r/m32 r32 cl

### UCOMISD
val /66 [0x0f 0x2e /r] = binop UCOMISD xmm128 xmm/m64
val /vex/66/0f [0x2e /r] = binop VUCOMISD xmm128 xmm/m64

### UD2
val / [0x0f 0x0b] = arity0 UD2

### XGETBV
val / [0x0f 0x01 0xd0] = arity0 XGETBV

### XORPS
val / [0x0f 0x57 /r] = binop XORPS xmm128 xmm/m128
val /vex/66/0f [0x57 /r]
 | vnds? & vex128? = ternop VXORPS xmm128 v/xmm xmm/m128
 | vnds? = ternop VXORPS ymm256 v/ymm ymm/m256

### CALL 3-112 Vol. 2A
val / [0xe8]
 | opndsz? = near-rel CALL rel16
 | otherwise = near-rel CALL rel32
val / [0xff /2] = near-abs CALL r/m64

### LEA 3-579 Vol. 2A
val / [0x8d /r]
 | opndsz? & addrsz? = binop LEA r16 r/m16
 | opndsz? = binop LEA r16 r/m32
 | rexw? & addrsz? = binop LEA r64 r/m32
 | rexw? = binop LEA r64 r/m64
 | addrsz? = binop LEA r32 r/m16
 | otherwise = binop LEA r32 r/m32

### INC 3-501 Vol. 2A
val / [0xfe /0] = unop INC r/m8
val / [0xff /0]
 | opndsz? = unop INC r/m16
 | rexw? = unop INC r/m64
 | otherwise = unop INC r/m32

### DEC Vol. 2A 3-296
val / [0xfe /1] = unop DEC r/m8
val / [0xff /1]
 | opndsz? = unop DEC r/m16
 | rexw? = unop DEC r/m64
 | otherwise = unop DEC r/m32

### SAL/SAR/SHL/SHR 4-353 Vol. 2B
#### SAL/SHL
val / [0xd0 /4] = binop SHL r/m8 one
val / [0xd0 /6] = binop SHL r/m8 one
val / [0xd2 /4] = binop SHL r/m8 cl
val / [0xc0 /4] = binop SHL r/m8 imm8
val / [0xd1 /4]
 | opndsz? = binop SHL r/m16 one
 | rexw? = binop SHL r/m64 one
 | otherwise = binop SHL r/m32 one
val / [0xd3 /4]
 | opndsz? = binop SHL r/m16 cl
 | rexw? = binop SHL r/m64 cl
 | otherwise = binop SHL r/m32 cl
val / [0xc1 /4]
 | opndsz? = binop SHL r/m16 imm8
 | rexw? = binop SHL r/m64 imm8
 | otherwise = binop SHL r/m32 imm8
#### SAR
val / [0xd0 /7] = binop SAR r/m8 one
val / [0xd2 /7] = binop SAR r/m8 cl
val / [0xc0 /7] = binop SAR r/m8 imm8
val / [0xd1 /7]
 | opndsz? = binop SAR r/m16 one
 | rexw? = binop SAR r/m64 one
 | otherwise = binop SAR r/m32 one
val / [0xd3 /7]
 | opndsz? = binop SAR r/m16 cl
 | rexw? = binop SAR r/m64 cl
 | otherwise = binop SAR r/m32 cl
val / [0xc1 /7]
 | opndsz? = binop SAR r/m16 imm8
 | rexw? = binop SAR r/m64 imm8
 | otherwise = binop SAR r/m32 imm8
#### SHR
val / [0xd0 /5] = binop SHR r/m8 one
val / [0xd2 /5] = binop SHR r/m8 cl
val / [0xc0 /5] = binop SHR r/m8 imm8
val / [0xd1 /5]
 | opndsz? = binop SHR r/m16 one
 | rexw? = binop SHR r/m64 one
 | otherwise = binop SHR r/m32 one
val / [0xd3 /5]
 | opndsz? = binop SHR r/m16 cl
 | rexw? = binop SHR r/m64 cl
 | otherwise = binop SHR r/m32 cl
val / [0xc1 /5]
 | opndsz? = binop SHR r/m16 imm8
 | rexw? = binop SHR r/m64 imm8
 | otherwise = binop SHR r/m32 imm8

### TEST 4-451 Vol. 2B
val / [0xa8] = binop TEST al imm8
val / [0xa9]
 | opndsz? = binop TEST ax imm16
 | rexw? = binop TEST rax imm32
 | otherwise = binop TEST eax imm32
val / [0xf6 /0] = binop TEST r/m8 imm8
val / [0xf7 /0]
 | opndsz? = binop TEST r/m16 imm16
 | rexw? = binop TEST r/m64 imm32
 | otherwise = binop TEST r/m32 imm32
val / [0x84 /r] = binop TEST r/m8 r8
val / [0x85 /r]
 | opndsz? = binop TEST r/m16 r16
 | rexw? = binop TEST r/m64 r64
 | otherwise = binop TEST r/m32 r32

### BT Vol. 2A 3-100
val / [0x0f 0xa3 /r]
 | opndsz? = binop BT r/m16 r16
 | rexw? = binop BT r/m64 r64
 | otherwise = binop BT r/m32 r32
val / [0x0f 0xba /4]
 | opndsz? = binop BT r/m16 imm8
 | rexw? = binop BT r/m64 imm8
 | otherwise = binop BT r/m32 imm8

### CMP 3-150 Vol. 2A
val / [0x3c] = binop CMP al imm8
val / [0x3d]
 | opndsz? = binop CMP ax imm16
 | rexw? = binop CMP rax imm32
 | otherwise = binop CMP eax imm32
val / [0x80 /7] = binop CMP r/m8 imm8
val / [0x81 /7]
 | opndsz? = binop CMP r/m16 imm16
 | rexw? = binop CMP r/m64 imm32
 | otherwise = binop CMP r/m32 imm32
val / [0x83 /7]
 | opndsz? = binop CMP r/m16 imm8
 | rexw? = binop CMP r/m64 imm8
 | otherwise = binop CMP r/m32 imm8
val / [0x38 /r] = binop CMP r/m8 r8
val / [0x39 /r]
 | opndsz? = binop CMP r/m16 r16
 | rexw? = binop CMP r/m64 r64
 | otherwise = binop CMP r/m32 r32
val / [0x3a /r] = binop CMP r8 r/m8
val / [0x3b /r]
 | opndsz? = binop CMP r16 r/m16
 | rexw? = binop CMP r64 r/m64
 | otherwise = binop CMP r32 r/m32

### BSWAP Vol. 2A 3-98
val / [0x0f '11001 r:3']
 | rexw? = do update@{reg/opcode=r}; unop BSWAP r64/rexb end 
 | otherwise = do update@{reg/opcode=r}; unop BSWAP r32/rexb end

### NOP 4-12 Vol. 2B
#val / [0x90] = arity0 NOP
#val /66 [0x90] = arity0 NOP
val /66 [0x0f 0x1f /0] = binop NOP r/m16 r16
val / [0x0f 0x1f /0]
 | rexw? = binop NOP r/m64 r64
 | otherwise = binop NOP r/m32 r32

### XCHG Vol. 2A 4-510
val / ['10010 r:3']
 | opndsz? = do update@{reg/opcode=r}; binop XCHG ax r16/rexb end 
 | rexw? = do update@{reg/opcode=r}; binop XCHG rax r64/rexb end 
 | otherwise = do update@{reg/opcode=r}; binop XCHG eax r32/rexb end
val / [0x86 /r] = binop XCHG r8 r/m8
val / [0x87 /r]
 | opndsz? = binop XCHG r/m16 r16
 | rexw? = binop XCHG r/m64 r64
 | otherwise = binop XCHG r/m32 r32

### CMPXCHG Vol. 2A 3-188
val / [0x0f 0xb0 /r] = binop CMPXCHG r/m8 r8
val / [0x0f 0xb1 /r]
 | opndsz? = binop CMPXCHG r/m16 r16
 | rexw? = binop CMPXCHG r/m64 r64
 | otherwise = binop CMPXCHG r/m32 r32

### RDTSC Vol. 2B 4-312
val / [0x0f 0x31] = arity0 RDTSC

### RDTSCP Vol. 2B 4-313
val / [0x0f 0x01 0xf9] = arity0 RDTSCP

### SYSCALL Vol. 2B 4-438
val / [0x0f 0x05] = arity0 SYSCALL

### RET 4-321 Vol. 2B
val / [0xc3] = arity0 RET
val / [0xcb] = arity0 RET_FAR
val / [0xc2] = unop RET imm16
val / [0xca] = unop RET_FAR imm16

### LEAVE Vol. 2A 
#TODO: handle different effects to BP/EBP/RBP
val / [0xc9] = arity0 LEAVE

### IMUL 3-494 Vol. 2A
val / [0xf6 /5] = unop IMUL r/m8
val / [0xf7 /5]
 | opndsz? = unop IMUL r/m16
 | rexw? = unop IMUL r/m64
 | otherwise = unop IMUL r/m32
val / [0x0f 0xaf /r]
 | opndsz? = binop IMUL r16 r/m16
 | rexw? = binop IMUL r64 r/m64
 | otherwise = binop IMUL r32 r/m32
val / [0x6b /r]
 | opndsz? = ternop IMUL r16 r/m16 imm8
 | rexw? = ternop IMUL r64 r/m64 imm8
 | otherwise = ternop IMUL r32 r/m32 imm8
val / [0x69 /r]
 | opndsz? = ternop IMUL r16 r/m16 imm16
 | rexw? = ternop IMUL r64 r/m64 imm32
 | otherwise = ternop IMUL r32 r/m32 imm32

### CBW/CWDE/CDQE 3-131 Vol. 2A
val / [0x98] 
 | opndsz? = arity0 CBW
 | rexw? = arity0 CDQE
 | otherwise = arity0 CWDE

### MOVZX 3-739 Vol. 2A
val / [0x0f 0xb6 /r]
 | opndsz? = binop MOVZX r16 r/m8
 | rexw? = binop MOVZX r64 r/m8
 | otherwise = binop MOVZX r32 r/m8
val / [0x0f 0xb7 /r]
 | rexw? = binop MOVZX r64 r/m16
 | otherwise = binop MOVZX r32 r/m16

### MOVSX/MOVSXD 3-730 Vol. 2A
val / [0x0f 0xbe /r]
 | opndsz? = binop MOVSX r16 r/m8
 | rexw? = binop MOVSX r64 r/m64
 | otherwise = binop MOVSX r32 r/m32
val / [0x0f 0xbf /r]
 | rexw? = binop MOVSX r64 r/m16
 | otherwise = binop MOVSX r32 r/m16
val / [0x63 /r]
 | rexw? = binop MOVSXD r64 r/m32
 | otherwise = binop MOVSXD r32 r/m32 #TODO: check

### DIV 3-299 Vol. 2A
val / [0xf6 /6] = unop DIV r/m8
val / [0xf7 /6]
 | opndsz? = unop DIV r/m16
 | rexw? = unop DIV r/m64
 | otherwise = unop DIV r/m32

### IDIV Vol. 2A 3-490
val / [0xf6 /7] = unop IDIV r/m8
val / [0xf7 /7]
 | opndsz? = unop IDIV r/m16
 | rexw? = unop IDIV r/m32
 | otherwise = unop IDIV r/m64

### DIVSD Vol. 2A 3-309
val /f2 [0x0f 0x5e /r] = binop DIVSD xmm128 xmm/m64

### MUL 3-746 Vol. 2A
val / [0xf6 /4] = unop MUL r/m8
val / [0xf7 /4]
 | opndsz? = unop MUL r/m16
 | rexw? = unop MUL r/m64
 | otherwise = unop MUL r/m32

### NEG 4-9 Vol. 2B
val / [0xf6 /3] = unop NEG r/m8
val / [0xf7 /3]
 | opndsz? = unop NEG r/m16
 | rexw? = unop NEG r/m64
 | otherwise = unop NEG r/m32

### CMPS/CMPSB/CMPSW/CMPSD/CMPSQ 3-170 Vol. 2A
val / [0xa6] = arity0 CMPSB
val / [0xa7]
 | opndsz? = arity0 CMPSB
 | rexw? = arity0 CMPSQ
 | otherwise = arity0 CMPSD

### MOVS/MOVSB/MOVSW/MOVSD/MOVSQ  3-713 Vol. 2A
val / [0xa4] = arity0 MOVSB
val / [0xa5]
 | opndsz? = arity0 MOVSB
 | rexw? = arity0 MOVSQ
 | otherwise = arity0 MOVSD

### MOVSD Vol. 2A 3-718
val /f2 [0x0f 0x10 /r] = binop MOVSD xmm128 xmm/m64
val /f2 [0x0f 0x11 /r] = binop MOVSD xmm/m64 xmm128

### STOS/STOSB/STOSW/STOSD/STOSQ 4-417 Vol. 2B
val / [0xaa] = arity0 STOSB
val / [0xab]
 | opndsz? = arity0 STOSW
 | rexw? = arity0 STOSQ
 | otherwise = arity0 STOSD

### SCAS/SCASB/SCASW/SCASD/SCASQ 4-365 Vol. 2B
val / [0xae] = arity0 SCASB
val / [0xaf]
 | opndsz? = arity0 SCASW
 | rexw? = arity0 SCASQ
 | otherwise = arity0 SCASD

### CMOVcc 3-143 Vol. 2A
val / [0x0f 0x47 /r]
 | opndsz? = binop CMOVA r16 r/m16
 | rexw? = binop CMOVA r64 r/m64
 | otherwise = binop CMOVA r32 r/m32
val / [0x0f 0x43 /r]
 | opndsz? = binop CMOVAE r16 r/m16
 | rexw? = binop CMOVAE r64 r/m64
 | otherwise = binop CMOVAE r32 r/m32
val / [0x0f 0x42 /r]
 | opndsz? = binop CMOVB r16 r/m16
 | rexw? = binop CMOVB r64 r/m64
 | otherwise = binop CMOVB r32 r/m32
val / [0x0f 0x46 /r]
 | opndsz? = binop CMOVBE r16 r/m16
 | rexw? = binop CMOVBE r64 r/m64
 | otherwise = binop CMOVBE r32 r/m32
val / [0x0f 0x44 /r]
 | opndsz? = binop CMOVE r16 r/m16
 | rexw? = binop CMOVE r64 r/m64
 | otherwise = binop CMOVE r32 r/m32
val / [0x0f 0x4f /r]
 | opndsz? = binop CMOVG r16 r/m16
 | rexw? = binop CMOVG r64 r/m64
 | otherwise = binop CMOVG r32 r/m32
val / [0x0f 0x4d /r]
 | opndsz? = binop CMOVGE r16 r/m16
 | rexw? = binop CMOVGE r64 r/m64
 | otherwise = binop CMOVGE r32 r/m32
val / [0x0f 0x4c /r]
 | opndsz? = binop CMOVL r16 r/m16
 | rexw? = binop CMOVL r64 r/m64
 | otherwise = binop CMOVL r32 r/m32
val / [0x0f 0x4e /r]
 | opndsz? = binop CMOVLE r16 r/m16
 | rexw? = binop CMOVLE r64 r/m64
 | otherwise = binop CMOVLE r32 r/m32
val / [0x0f 0x45 /r]
 | opndsz? = binop CMOVNE r16 r/m16
 | rexw? = binop CMOVNE r64 r/m64
 | otherwise = binop CMOVNE r32 r/m32
val / [0x0f 0x41 /r]
 | opndsz? = binop CMOVNO r16 r/m16
 | rexw? = binop CMOVNO r64 r/m64
 | otherwise = binop CMOVNO r32 r/m32
val / [0x0f 0x4b /r]
 | opndsz? = binop CMOVNP r16 r/m16
 | rexw? = binop CMOVNP r64 r/m64
 | otherwise = binop CMOVNP r32 r/m32
val / [0x0f 0x49 /r]
 | opndsz? = binop CMOVNS r16 r/m16
 | rexw? = binop CMOVNS r64 r/m64
 | otherwise = binop CMOVNS r32 r/m32
val / [0x0f 0x40 /r]
 | opndsz? = binop CMOVO r16 r/m16
 | rexw? = binop CMOVO r64 r/m64
 | otherwise = binop CMOVO r32 r/m32
val / [0x0f 0x4a /r]
 | opndsz? = binop CMOVP r16 r/m16
 | rexw? = binop CMOVP r64 r/m64
 | otherwise = binop CMOVP r32 r/m32
val / [0x0f 0x48 /r]
 | opndsz? = binop CMOVS r16 r/m16
 | rexw? = binop CMOVS r64 r/m64
 | otherwise = binop CMOVS r32 r/m32

### Jcc 3-544 Vol. 2A
val / [0x77] = near-rel JA rel8  # JNBE
val / [0x73] = near-rel JAE rel8 # JNB, JNC
val / [0x72] = near-rel JC rel8  # JB,JNAE
val / [0x76] = near-rel JBE rel8 # JNA
val /66 [0xe3] = near-rel JCXZ rel8
val / [0xe3]
 | rexw? = near-rel JRCXZ rel8
 | otherwise = near-rel JECXZ rel8 
val / [0x74] = near-rel JE rel8  # JZ
val / [0x7f] = near-rel JG rel8  # JNLE
val / [0x7d] = near-rel JGE rel8 # JNL
val / [0x7c] = near-rel JL rel8  # JNGE
val / [0x7e] = near-rel JLE rel8 # JNG
val / [0x75] = near-rel JNE rel8 # JNZ
val / [0x71] = near-rel JNO rel8
val / [0x7b] = near-rel JNP rel8 # JPO
val / [0x79] = near-rel JNS rel8
val / [0x70] = near-rel JO rel8
val / [0x7a] = near-rel JP rel8  # JPE
val / [0x78] = near-rel JS rel8
val /66 [0x0f 0x87]
 | mode64? = near-rel JA rel32
 | otherwise = near-rel JA rel16
val / [0x0f 0x87] = near-rel JA rel32
val /66 [0x0f 0x83]
 | mode64? = near-rel JAE rel32
 | otherwise = near-rel JAE rel16
val / [0x0f 0x83] = near-rel JAE rel32
val /66 [0x0f 0x82]
 | mode64? = near-rel JB rel32
 | otherwise = near-rel JB rel16
val / [0x0f 0x82] = near-rel JB rel32
val /66 [0x0f 0x86]
 | mode64? = near-rel JBE rel32
 | otherwise = near-rel JBE rel16
val / [0x0f 0x86] = near-rel JBE rel32
val /66 [0x0f 0x84]
 | mode64? = near-rel JE rel32
 | otherwise = near-rel JE rel16
val / [0x0f 0x84] = near-rel JE rel32
val /66 [0x0f 0x8f]
 | mode64? = near-rel JG rel32
 | otherwise = near-rel JG rel16
val / [0x0f 0x8f] = near-rel JG rel32
val /66 [0x0f 0x8d]
 | mode64? = near-rel JGE rel32
 | otherwise = near-rel JGE rel16
val / [0x0f 0x8d] = near-rel JGE rel32
val /66 [0x0f 0x8c]
 | mode64? = near-rel JL rel32
 | otherwise = near-rel JL rel16
val / [0x0f 0x8c] = near-rel JL rel32
val /66 [0x0f 0x8e]
 | mode64? = near-rel JLE rel32
 | otherwise = near-rel JLE rel16
val / [0x0f 0x8e] = near-rel JLE rel32
val /66 [0x0f 0x85]
 | mode64? = near-rel JNE rel32
 | otherwise = near-rel JNE rel16
val / [0x0f 0x85] = near-rel JNE rel32
val /66 [0x0f 0x81]
 | mode64? = near-rel JNO rel32
 | otherwise = near-rel JNO rel16
val / [0x0f 0x81] = near-rel JNO rel32
val /66 [0x0f 0x8b]
 | mode64? = near-rel JNP rel32
 | otherwise = near-rel JNP rel16
val / [0x0f 0x8b] = near-rel JNP rel32
val /66 [0x0f 0x89]
 | mode64? = near-rel JNS rel32
 | otherwise = near-rel JNS rel16
val / [0x0f 0x89] = near-rel JNS rel32
val /66 [0x0f 0x80]
 | mode64? = near-rel JO rel32
 | otherwise = near-rel JO rel16
val / [0x0f 0x80] = near-rel JO rel32
val /66 [0x0f 0x8a]
 | mode64? = near-rel JP rel32
 | otherwise = near-rel JP rel16
val / [0x0f 0x8a] = near-rel JP rel32
val /66 [0x0f 0x88]
 | mode64? = near-rel JS rel32
 | otherwise = near-rel JS rel16
val / [0x0f 0x88] = near-rel JS rel32

### JMP 3-552 Vol. 2A
#TODO: jmp far
val / [0xeb] = near-rel JMP rel8
val /66 [0xe9]
 | mode64? = near-rel JMP rel32
 | otherwise = near-rel JMP rel16
val / [0xe9] = near-rel JMP rel32
val /66 [0xff /4]
 | mode64? = near-abs JMP r/m64
 | otherwise = near-abs JMP r/m16
val / [0xff /4]
 | mode64? = near-abs JMP r/m64
 | otherwise = near-abs JMP r/m32

### SETcc 4-372 Vol. 2B
val / [0x0f 0x97 /r] = unop SETA r/m8
val / [0x0f 0x93 /r] = unop SETAE r/m8
val / [0x0f 0x92 /r] = unop SETB r/m8
val / [0x0f 0x96 /r] = unop SETBE r/m8
val / [0x0f 0x94 /r] = unop SETE r/m8
val / [0x0f 0x9f /r] = unop SETG r/m8
val / [0x0f 0x9d /r] = unop SETGE r/m8
val / [0x0f 0x9c /r] = unop SETL r/m8
val / [0x0f 0x9e /r] = unop SETLE r/m8
val / [0x0f 0x95 /r] = unop SETNE r/m8
val / [0x0f 0x91 /r] = unop SETNO r/m8
val / [0x0f 0x9b /r] = unop SETNP r/m8
val / [0x0f 0x99 /r] = unop SETNS r/m8
val / [0x0f 0x90 /r] = unop SETO r/m8
val / [0x0f 0x9a /r] = unop SETP r/m8
val / [0x0f 0x98 /r] = unop SETS r/m8

### SUB 4-572 Vol. 2B
val / [0x2c] = binop SUB al imm8
val / [0x2d]
 | opndsz? = binop SUB ax imm16
 | rexw? = binop SUB rax imm32
 | otherwise = binop SUB eax imm32
val / [0x80 /5] = binop SUB r/m8 imm8
val / [0x81 /5]
 | opndsz? = binop SUB r/m16 imm16
 | rexw? = binop SUB r/m64 imm32
 | otherwise = binop SUB r/m32 imm32
val / [0x83 /5]
 | opndsz? = binop SUB r/m16 imm8
 | rexw? = binop SUB r/m64 imm8
 | otherwise = binop SUB r/m32 imm8
val / [0x28 /r] = binop SUB r/m8 r8
val / [0x29 /r]
 | opndsz? = binop SUB r/m16 r16
 | rexw? = binop SUB r/m64 r64
 | otherwise = binop SUB r/m32 r32
val / [0x2a /r] = binop SUB r8 r/m8
val / [0x2b /r]
 | opndsz? = binop SUB r16 r/m16
 | rexw? = binop SUB r64 r/m64
 | otherwise = binop SUB r32 r/m32

### SBB 4-361 Vol. 2B
val / [0x1c] = binop SBB al imm8
val / [0x1d]
 | opndsz? = binop SBB ax imm16
 | rexw? = binop SBB rax imm32
 | otherwise = binop SBB eax imm32
val / [0x80 /3] = binop SBB r/m8 imm8
val / [0x81 /3]
 | opndsz? = binop SBB r/m16 imm16
 | rexw? = binop SBB r/m64 imm32
 | otherwise = binop SBB r/m32 imm32
val / [0x83 /3]
 | opndsz? = binop SBB r/m16 imm8
 | rexw? = binop SBB r/m64 imm8
 | otherwise = binop SBB r/m32 imm8
val / [0x18 /r] = binop SBB r/m8 r8
val / [0x19 /r]
 | opndsz? = binop SBB r/m16 r16
 | rexw? = binop SBB r/m64 r64
 | otherwise = binop SBB r/m32 r32
val / [0x1a /r] = binop SBB r8 r/m8
val / [0x1b /r]
 | opndsz? = binop SBB r16 r/m16
 | rexw? = binop SBB r64 r/m64
 | otherwise = binop SBB r32 r/m32

### OR 4-16 Vol. 2B
val / [0x0c] = binop OR al imm8
val / [0x0d]
 | opndsz? = binop OR ax imm16
 | rexw? = binop OR rax imm32
 | otherwise = binop OR eax imm32
val / [0x80 /1] = binop OR r/m8 imm8
val / [0x81 /1]
 | opndsz? = binop OR r/m16 imm16
 | rexw? = binop OR r/m64 imm32
 | otherwise = binop OR r/m32 imm32
val / [0x83 /1]
 | opndsz? = binop OR r/m16 imm8
 | rexw? = binop OR r/m64 imm8
 | otherwise = binop OR r/m32 imm8
val / [0x08 /r] = binop OR r/m8 r8
val / [0x09 /r]
 | opndsz? = binop OR r/m16 r16
 | rexw? = binop OR r/m64 r64
 | otherwise = binop OR r/m32 r32
val / [0x0a /r] = binop OR r8 r/m8
val / [0x0b /r]
 | opndsz? = binop OR r16 r/m16
 | rexw? = binop OR r64 r/m64
 | otherwise = binop OR r32 r/m32

### AND 3-64 Vol. 2A
val / [0x24] = binop AND al imm8
val / [0x25]
 | opndsz? = binop AND ax imm16
 | rexw? = binop AND rax imm32
 | otherwise = binop AND eax imm32
val / [0x80 /4] = binop AND r/m8 imm8
val / [0x81 /4]
 | opndsz? = binop AND r/m16 imm16
 | rexw? = binop AND r/m64 imm32
 | otherwise = binop AND r/m32 imm32
val / [0x83 /4]
 | opndsz? = binop AND r/m16 imm8
 | rexw? = binop AND r/m64 imm8
 | otherwise = binop AND r/m32 imm8
val / [0x20 /r] = binop AND r/m8 r8
val / [0x21 /r]
 | opndsz? = binop AND r/m16 r16
 | rexw? = binop AND r/m64 r64
 | otherwise = binop AND r/m32 r32
val / [0x22 /r] = binop AND r8 r/m8
val / [0x23 /r]
 | opndsz? = binop AND r16 r/m16
 | rexw? = binop AND r64 r/m64
 | otherwise = binop AND r32 r/m32

### NOT 4-14 Vol. 2B
val / [0xf6 /2] = unop NOT r/m8
val / [0xf7 /2]
 | opndsz? = unop NOT r/m16
 | rexw? = unop NOT r/m64
 | otherwise = unop NOT r/m32

### HLT 3-481 Vol. 2A
val / [0xf4] = arity0 HLT

### XOR 4-678 Vol. 2B
val / [0x34] = binop XOR al imm8
val / [0x35]
 | opndsz? = binop XOR ax imm16
 | rexw? = binop XOR rax imm32
 | otherwise = binop XOR eax imm32
val / [0x80 /6] = binop XOR r/m8 imm8
val / [0x81 /6]
 | opndsz? = binop XOR r/m16 imm16
 | rexw? = binop XOR r/m64 imm32
 | otherwise = binop XOR r/m32 imm32
val / [0x83 /6]
 | opndsz? = binop XOR r/m16 imm8
 | rexw? = binop XOR r/m64 imm8
 | otherwise = binop XOR r/m32 imm8
val / [0x30 /r] = binop XOR r/m8 r8
val / [0x31 /r]
 | opndsz? = binop XOR r/m16 r16
 | rexw? = binop XOR r/m64 r64
 | otherwise = binop XOR r/m32 r32
val / [0x32 /r] = binop XOR r8 r/m8
val / [0x33 /r]
 | opndsz? = binop XOR r16 r/m16
 | rexw? = binop XOR r64 r/m64
 | otherwise = binop XOR r32 r/m32

### PUSH 4-275 Vol. 2B
#TODO: correctly implement 32bit and 64bit modes
val / [0xff /6]
 | opndsz? = unop PUSH r/m16
 | otherwise = unop PUSH r/m64
val / ['01010 r:3']
 | opndsz? = do update@{reg/opcode=r}; unop PUSH r16/rexb end
 | otherwise = do update@{reg/opcode=r}; unop PUSH r64/rexb end
val / [0x6a] = unop PUSH imm8
val / [0x68]
 | opndsz? = unop PUSH imm16
 | otherwise = unop PUSH imm32
val / [0x0e] = unop PUSH cs
val / [0x16] = unop PUSH ds
val / [0x06] = unop PUSH es
val / [0x0f 0xa0] = unop PUSH fs
val / [0x0f 0xa8] = unop PUSH gs

### POP 4-188 Vol. 2B
#TODO: correctly implement 32bit and 64bit modes
val / [0x8f /0]
 | opndsz? = unop POP r/m16
 | otherwise = unop POP r/m64
val / ['01011 r:3']
 | opndsz? = do update@{reg/opcode=r}; unop POP r16/rexb end
 | otherwise = do update@{reg/opcode=r}; unop POP r64/rexb end
val / [0x1f] = unop POP ds
val / [0x07] = unop POP es
val / [0x17] = unop POP ss

### ADD Vol. 2A 3-35
val / [0x04] = binop ADD al imm8
val / [0x05]
 | opndsz? = binop ADD ax imm16
 | rexw? = binop ADD rax imm32
 | otherwise = binop ADD eax imm32
val / [0x80 /0] = binop ADD r/m8 imm8
val / [0x81 /0]
 | opndsz? = binop ADD r/m16 imm16
 | rexw? = binop ADD r/m64 imm32 
 | otherwise = binop ADD r/m32 imm32
val / [0x83 /0]
 | opndsz? = binop ADD r/m16 imm8
 | rexw? = binop ADD r/m64 imm8
 | otherwise = binop ADD r/m32 imm8
val / [0x00 /r] = binop ADD r/m8 r8
val / [0x01 /r]
 | opndsz? = binop ADD r/m16 r16
 | rexw? = binop ADD r/m64 r64
 | otherwise = binop ADD r/m32 r32
val / [0x02 /r] = binop ADD r8 r/m8
val / [0x03 /r]
 | opndsz? = binop ADD r16 r/m16
 | rexw? = binop ADD r64 r/m64
 | otherwise = binop ADD r32 r/m32

### CVTSI2SD Vol. 2A 3-268
val /f2 [0x0f 0x2a /r]
 | rexw? = binop CVTSI2SD xmm128 r/m64
 | otherwise = binop CVTSI2SD xmm128 r/m32

### XORPD Vol. 2B 4-521
val /66 [0x0f 0x57 /r] = binop XORPD xmm128 xmm/m128

### PXOR Vol. 2B 4-286
val / [0x0f 0xef /r] = binop PXOR mm64 mm/m64
val /66 [0x0f 0xef /r] = binop PXOR xmm128 xmm/m128

### CVTPD2PI Vol. 2A 3-248
val /66 [0x0f 0x2d /r] = binop CVTPD2PI mm64 xmm/m128

### MASKMOVDQU Vol. 2B 4-9
val /66 [0x0f 0xf7 /r] = binop MASKMOVDQU xmm128 xmm/nomem128

### MASKMOVQ Vol. 2B 4-11
val / [0x0f 0xf7 /r] = binop MASKMOVQ mm64 mm/nomem64

### MAXPD Vol. 2B 4-13
val /66 [0x0f 0x5f /r] = binop MAXPD xmm128 xmm/m128

### MAXPS 4-16 Vol. 2B
val / [0x0f 0x5f /r] = binop MAXPS xmm128 xmm/m128

### MAXSD Vol. 2B 4-19
val /f2 [0x0f 0x5f /r] = binop MAXSD xmm128 xmm/m64

### MAXSS Vol. 2B 4-21
val /f3 [0x0f 0x5f /r] = binop MAXSS xmm128 xmm/m32

### MFENCE Vol. 2B 4-23
val / [0x0f 0xae /6] = arity0 MFENCE

### MINPD Vol. 2B 4-25
val /66 [0x0f 0x5d /r] = binop MINPD xmm128 xmm/m128

### MINPS Vol. 2B 4-28
val / [0x0f 0x5d /r] = binop MINPS xmm128 xmm/m128

### MINSD Vol. 2B 4-31
val /f2 [0x0f 0x5d /r] = binop MINSD xmm128 xmm/m64

### MINSS Vol. 2B 4-33
val /f3 [0x0f 0x5d /r] = binop MINSS xmm128 xmm/m32

### PCMPEQQ
val /66 [0x0f 0x38 0x29 /r] = binop PCMPEQQ xmm128 xmm/m128
val /vex/66/0f/38 [0x29 /r] | vex128? = ternop VPCMPEQQ xmm128 v/xmm xmm/m128 

### PMOVMSKB
val / [0x0f 0xd7 /r] = binop PMOVMSKB reg mm64
val /66 [0x0f 0xd7 /r] = binop PMOVMSKB reg xmm/nomem128
val /vex/66/0f [0xd7 /r] | vex128? = binop VPMOVMSKB vreg xmm/nomem128

### MONITOR Vol. 2B 4-35
val / [0x0f 0xae 0x01 0xc8] = arity0 MONITOR

### MOV Vol 2A 3-643
val / [0x88 /r] = binop MOV r/m8 r8
val / [0x89 /r]
 | opndsz? = binop MOV r/m16 r16
 | rexw? = binop MOV r/m64 r64
 | otherwise = binop MOV r/m32 r32
val / [0x8a /r] = binop MOV r8 r/m8
val / [0x8b /r]
 | opndsz? = binop MOV r16 r/m16
 | rexw? = binop MOV r64 r/m32
 | otherwise = binop MOV r32 r/m32
val / [0x8c /r] = binop MOV r/m16 (r/rexb sreg3?)
val / [0x8e /r] = binop MOV (r/rexb sreg3?) r/m16
val / [0xa0] = binop MOV al moffs8 
val / [0xa1]
 | addrsz? = binop MOV ax moffs16
 | otherwise = binop MOV eax moffs32
val / [0xa2] = binop MOV moffs8 al
val / [0xa3]
 | addrsz? = binop MOV moffs16 ax
 | otherwise = binop MOV moffs32 eax
val / ['10110 r:3'] = do update@{reg/opcode=r}; binop MOV r8/rexb imm8 end
val / ['10111 r:3']
 | opndsz? = do update@{reg/opcode=r}; binop MOV r16/rexb imm16 end
 | rexw? = do update@{reg/opcode=r}; binop MOV r64/rexb imm64 end
 | otherwise = do update@{reg/opcode=r}; binop MOV r32/rexb imm32 end
val / [0xc6 /0] = binop MOV r/m8 imm8
val / [0xc7 /0]
 | opndsz? = binop MOV r/m16 imm16
 | rexw? = binop MOV r/m64 imm32
 | otherwise = binop MOV r/m32 imm32

### MOVAPD Vol. 2B 4-52
val /66 [0x0f 0x28 /r] = binop MOVAPD xmm128 xmm/m128
val /66 [0x0f 0x29 /r] = binop MOVAPD xmm/m128 xmm128

### MOVAPS Vol. 2B 4-55
val / [0x0f 0x28 /r] = binop MOVAPS xmm128 xmm/m128
val / [0x0f 0x29 /r] = binop MOVAPS xmm/m128 xmm128

### MOVBE Vol. 2B 4-58
val /66 [0x0f 0x38 0xf0 /r] = binop MOVBE r16 m16
val / [0x0f 0x38 0xf0 /r]
 | rexw? = binop MOVBE r64 m64
 | otherwise = binop MOVBE r32 m32
val /66 [0x0f 0x38 0xf1 /r] = binop MOVBE m16 r16
val / [0x0f 0x38 0xf1 /r]
 | rexw? = binop MOVBE m64 r64
 | otherwise = binop MOVBE m32 r32

### MOVD/MOVQ Vol. 2B 4-61
val / [0x0f 0x6e /r]
 | rexw? = binop MOVQ mm64 r/m64
 | otherwise = binop MOVD mm64 r/m32
val / [0x0f 0x7e /r]
 | rexw? = binop MOVQ r/m64 mm64
 | otherwise = binop MOVD r/m32 mm64
val /66 [0x0f 0x6e /r]
 | rexw? = binop MOVQ xmm128 r/m64
 | otherwise = binop MOVD xmm128 r/m32
val /66 [0x0f 0x7e /r]
 | rexw? = binop MOVQ r/m64 xmm128
 | otherwise = binop MOVD r/m32 xmm128

### MOVDDUP Vol. 2B 4-64
val /f2 [0x0f 0x12 /r] = binop MOVDDUP xmm128 xmm/m64

### MOVDQA Vol. 2B 4-67
val /66 [0x0f 0x6f /r] = binop MOVDQA xmm128 xmm/m128
val /66 [0x0f 0x7f /r] = binop MOVDQA xmm/m128 xmm128
val /vex/66/0f [0x6f /r]
 | vex128? = binop VMOVDQA xmm128 xmm/m128
 | otherwise = binop VMOVDQA ymm256 ymm/m256
val /vex/66/0f [0x7f /r]
 | vex128? = binop VMOVDQA xmm/m128 xmm128
 | otherwise = binop VMOVDQA ymm/m256 ymm256

### MOVDQU Vol. 2B 4-70
val /f3 [0x0f 0x6f /r] = binop MOVDQU xmm128 xmm/m128
val /f3 [0x0f 0x7f /r] = binop MOVDQU xmm/m128 xmm128
val /vex/f3/0f [0x6f /r]
 | vex128? = binop VMOVDQU xmm128 xmm/m128
 | otherwise = binop VMOVDQU ymm256 ymm/m256
val /vex/f3/0f [0x7f /r]
 | vex128? = binop VMOVDQU xmm/m128 xmm128
 | otherwise = binop VMOVDQU ymm/m256 ymm256

### MOVDQ2Q Vol. 2B 4-73
val /f2 [0x0f 0xd6 /r] = binop MOVDQ2Q mm64 xmm128

### MOVHLPS Vol. 2B 4-75
## CHECK collision with movlps
#val movhlps = binop MOVHLPS
#val vmovhlps = ternop VMOVHLPS
#val / [0x0f 0x12 /r] = movhlps xmm128 xmm/nomem128

### MOVHPD Vol. 2B 4-77
val /66 [0x0f 0x16 /r] = binop MOVHPD xmm128 m64
val /66 [0x0f 0x17 /r] = binop MOVHPD m64 xmm128

### MOVHPS Vol. 2B 4-79
val / [0x0f 0x16 /r-mem] = binop MOVHPS xmm128 m64
val / [0x0f 0x17 /r-mem] = binop MOVHPS m64 xmm128

### MOVLHPS Vol. 2B 4-81
## CHECK collision with movhps
#val movlhps = binop MOVLHPS
#val vmovlhps = ternop VMOVLHPS
#val / [0x0f 0x16 /r]
# | mod-reg? = movlhps xmm128 xmm/nomem128

### MOVLPD Vol. 2B 4-83
val /66 [0x0f 0x12 /r-mem] = binop MOVLPD xmm128 m64
val /66 [0x0f 0x13 /r-mem] = binop MOVLPD m64 xmm128

### MOVLPS Vol. 2B 4-85
val / [0x0f 0x12 /r-mem] = binop MOVLPS xmm128 m64
val / [0x0f 0x13 /r-mem] = binop MOVLPS m64 xmm128

### MOVMSKPD Vol. 2B 4-87
val /66 [0x0f 0x50 /r]
 | mode64? = binop MOVMSKPD r64 xmm128
 | otherwise = binop MOVMSKPD r32 xmm128

### MOVMSKPS Vol. 2B 4-89
val / [0x0f 0x50 /r]
 | mode64? = binop MOVMSKPD r64 xmm128
 | otherwise = binop MOVMSKPD r32 xmm128

### MOVNTDQA Vol. 2B 4-92
val /66 [0x0f 0x38 0x2a /r] = binop MOVNTDQA xmm128 m128

### MOVNTDQ Vol. 2B 4-95
val /66 [0x0f 0xe7 /r] = binop MOVNTDQ m128 xmm128

### MOVNTI Vol. 2B 4-97
val / [0x0f 0xc3 /r]
 | rexw? = binop MOVNTI m64 r64
 | otherwise = binop MOVNTI m32 r32

### MOVNTPD Vol. 2B 4-99
val /66 [0x0f 0x2b /r] = binop MOVNTPD m128 xmm128

### MOVNTPS Vol. 2B 4-99
val / [0x0f 0x2b /r] = binop MOVNTPS m128 xmm128

### MOVNTQ Vol. 2B 4-103
val / [0x0f 0xe7 /r] = binop MOVNTQ m64 mm64

### MOVQ Vol. 2B 4-105
val / [0x0f 0x6f /r] = binop MOVQ mm64 mm/m64
val / [0x0f 0x7f /r] = binop MOVQ mm/m64 mm64
val /f3 [0x0f 0x7e /r] = binop MOVQ xmm128 xmm/m64
val /66 [0x0f 0xd6 /r] = binop MOVQ xmm/m64 xmm128

### PHADDW/PHADDD Vol. 2B 4-253
val /66 [0x0f 0x38 0x01 /r] = binop PHADDW xmm128 xmm/m128
val / [0x0f 0x38 0x01 /r] = binop PHADDW mm64 mm/m64
val /66 [0x0f 0x38 0x02 /r] = binop PHADDD xmm128 xmm/m128
val / [0x0f 0x38 0x02 /r] = binop PHADDD mm64 mm/m64

### XADD Vol. 2B 4-667
val / [0x0f 0xc0 /r] = binop XADD r/m8 r8
val / [0x0f 0xc1 /r]
 | opndsz? = binop MOV r/m16 r16
 | rexw? = binop XADD r/m64 r64
 | otherwise = binop MOV r/m32 r32

