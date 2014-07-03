export operands : (insndata) -> int

type uarity =
   UA0
 | UA1 of arity1
 | UA2 of arity2
 | UA3 of arity3
 | UA4 of arity4
 | UAF of flow1

val to-uarity va =
  case va of
     VA0: UA0
   | VA1 x: UA1 x
   | VA2 x: UA2 x
   | VA3 x: UA3 x
   | VA4 x: UA4 x
  end

val uarity-of insn = case insn of
   AAA: UA0
 | AAD a: UA1 a
 | AAM a: UA1 a
 | AAS: UA0
 | ADC a: UA2 a
 | ADD a: UA2 a
 | ADDPD a: UA2 a
 | ADDPS a: UA2 a
 | ADDSD a: UA2 a
 | ADDSS a: UA2 a
 | ADDSUBPD a: UA2 a
 | ADDSUBPS a: UA2 a
 | AESDEC a: UA2 a
 | AESDECLAST a: UA2 a
 | AESENC a: UA2 a
 | AESENCLAST a: UA2 a
 | AESIMC a: UA2 a
 | AESKEYGENASSIST a: UA3 a
 | AND a: UA2 a
 | ANDNPD a: UA2 a
 | ANDNPS a: UA2 a
 | ANDPD a: UA2 a
 | ANDPS a: UA2 a
 | ARPL a: UA2 a
 | BLENDPD a: UA3 a
 | BLENDPS a: UA3 a
 | BLENDVPD a: UA3 a
 | BLENDVPS a: UA3 a
 | BOUND a: UA2 a
 | BSF a: UA2 a
 | BSR a: UA2 a
 | BSWAP a: UA1 a
 | BT a: UA2 a
 | BTC a: UA2 a
 | BTR a: UA2 a
 | BTS a: UA2 a
 | CALL a: UAF a
 | CBW: UA0
 | CDQ: UA0
 | CDQE: UA0
 | CLC: UA0
 | CLD: UA0
 | CLFLUSH a: UA1 a
 | CLI: UA0
 | CLTS: UA0
 | CMC: UA0
 | CMOVA a: UA2 a
 | CMOVAE a: UA2 a
 | CMOVB a: UA2 a
 | CMOVBE a: UA2 a
 | CMOVC a: UA2 a
 | CMOVE a: UA2 a
 | CMOVG a: UA2 a
 | CMOVGE a: UA2 a
 | CMOVL a: UA2 a
 | CMOVLE a: UA2 a
 | CMOVNA a: UA2 a
 | CMOVNAE a: UA2 a
 | CMOVNB a: UA2 a
 | CMOVNBE a: UA2 a
 | CMOVNC a: UA2 a
 | CMOVNE a: UA2 a
 | CMOVNG a: UA2 a
 | CMOVNGE a: UA2 a
 | CMOVNL a: UA2 a
 | CMOVNLE a: UA2 a
 | CMOVNO a: UA2 a
 | CMOVNP a: UA2 a
 | CMOVNS a: UA2 a
 | CMOVNZ a: UA2 a
 | CMOVO a: UA2 a
 | CMOVP a: UA2 a
 | CMOVPE a: UA2 a
 | CMOVPO a: UA2 a
 | CMOVS a: UA2 a
 | CMOVZ a: UA2 a
 | CMP a: UA2 a
 | CMPPD a: UA3 a
 | CMPPS a: UA3 a
 | CMPS a: UA2 a
 | CMPSD a: UA3 a
 | CMPSS a: UA3 a
 | CMPXCHG a: UA2 a
 | CMPXCHG16B a: UA1 a
 | CMPXCHG8B a: UA1 a
 | COMISD a: UA2 a
 | COMISS a: UA2 a
 | CPUID: UA0
 | CQO: UA0
 | CRC32 a: UA2 a
 | CVTDQ2PD a: UA2 a
 | CVTDQ2PS a: UA2 a
 | CVTPD2DQ a: UA2 a
 | CVTPD2PI a: UA2 a
 | CVTPD2PS a: UA2 a
 | CVTPI2PD a: UA2 a
 | CVTPI2PS a: UA2 a
 | CVTPS2DQ a: UA2 a
 | CVTPS2PD a: UA2 a
 | CVTPS2PI a: UA2 a
 | CVTSD2SI a: UA2 a
 | CVTSD2SS a: UA2 a
 | CVTSI2SD a: UA2 a
 | CVTSI2SS a: UA2 a
 | CVTSS2SD a: UA2 a
 | CVTSS2SI a: UA2 a
 | CVTTPD2DQ a: UA2 a
 | CVTTPD2PI a: UA2 a
 | CVTTPS2DQ a: UA2 a
 | CVTTPS2PI a: UA2 a
 | CVTTSD2SI a: UA2 a
 | CVTTSS2SI a: UA2 a
 | CWD: UA0
 | CWDE: UA0
 | DAA: UA0
 | DAS: UA0
 | DEC a: UA1 a
 | DIV a: UA1 a
 | DIVPD a: UA2 a
 | DIVPS a: UA2 a
 | DIVSD a: UA2 a
 | DIVSS a: UA2 a
 | DPPD a: UA3 a
 | DPPS a: UA3 a
 | EMMS: UA0
 | ENTER a: UA2 a
 | EXTRACTPS a: UA3 a
 | F2XM1: UA0
 | FABS: UA0
 | FADD a: UA2 a
 | FADDP a: UA2 a
 | FBLD a: UA1 a
 | FBSTP a: UA1 a
 | FCHS: UA0
 | FCLEX: UA0
 | FCMOVB a: UA2 a
 | FCMOVBE a: UA2 a
 | FCMOVE a: UA2 a
 | FCMOVNB a: UA2 a
 | FCMOVNBE a: UA2 a
 | FCMOVNE a: UA2 a
 | FCMOVNU a: UA2 a
 | FCMOVU a: UA2 a
 | FCOM a: UA1 a
 | FCOMI a: UA2 a
 | FCOMIP a: UA2 a
 | FCOMP a: UA1 a
 | FCOMPP: UA0
 | FCOS: UA0
 | FDECSTP: UA0
 | FDIV a: UA2 a
 | FDIVP a: UA2 a
 | FDIVR a: UA2 a
 | FDIVRP a: UA2 a
 | FFREE a: UA1 a
 | FIADD a: UA1 a
 | FICOM a: UA1 a
 | FICOMP a: UA1 a
 | FIDIV a: UA2 a
 | FIDIVR a: UA1 a
 | FILD a: UA1 a
 | FIMUL a: UA1 a
 | FINCSTP: UA0
 | FINIT: UA0
 | FIST a: UA1 a
 | FISTP a: UA1 a
 | FISTTP a: UA1 a
 | FISUB a: UA1 a
 | FISUBR a: UA1 a
 | FLD a: UA1 a
 | FLD1: UA0
 | FLDCW a: UA1 a
 | FLDENV a: UA1 a
 | FLDL2E: UA0
 | FLDL2T: UA0
 | FLDLG2: UA0
 | FLDLN2: UA0
 | FLDPI: UA0
 | FLDZ: UA0
 | FMUL a: UA2 a
 | FMULP a: UA2 a
 | FNCLEX: UA0
 | FNINIT: UA0
 | FNOP: UA0
 | FNSAVE a: UA1 a
 | FNSTCW a: UA1 a
 | FNSTENV a: UA1 a
 | FNSTSW a: UA1 a
 | FPATAN: UA0
 | FPREM: UA0
 | FPREM1: UA0
 | FPTAN: UA0
 | FRNDINT: UA0
 | FRSTOR a: UA1 a
 | FSAVE a: UA1 a
 | FSCALE: UA0
 | FSIN: UA0
 | FSINCOS: UA0
 | FSQRT: UA0
 | FST a: UA1 a
 | FSTCW a: UA1 a
 | FSTENV a: UA1 a
 | FSTP a: UA1 a
 | FSTSW a: UA1 a
 | FSUB a: UA2 a
 | FSUBP a: UA2 a
 | FSUBR a: UA2 a
 | FSUBRP a: UA2 a
 | FTST: UA0
 | FUCOM a: UA1 a
 | FUCOMI a: UA1 a
 | FUCOMIP a: UA1 a
 | FUCOMP a: UA1 a
 | FUCOMPP: UA0
 | FXAM: UA0
 | FXCH a: UA1 a
 | FXRSTOR a: UA1 a
 | FXRSTOR64 a: UA1 a
 | FXSAVE a: UA1 a
 | FXSAVE64 a: UA1 a
 | FXTRACT: UA0
 | FYL2X: UA0
 | FYL2XP1: UA0
 | HADDPD a: UA2 a
 | HADDPS a: UA2 a
 | HLT: UA0
 | HSUBPD a: UA2 a
 | HSUBPS a: UA2 a
 | IDIV a: UA1 a
 | IMUL a: (to-uarity a)
 | IN a: UA2 a
 | INC a: UA1 a
 | INSB: UA0
 | INSD: UA0
 | INSERTPS a: UA3 a
 | INSW: UA0
 | INT a: UA1 a
 | INT0: UA0
 | INT3: UA0
 | INVD: UA0
 | INVLPG a: UA1 a
 | INVPCID a: UA2 a
 | IRET: UA0
 | IRETD: UA0
 | IRETQ: UA0
 | JA a: UAF a
 | JAE a: UAF a
 | JB a: UAF a
 | JBE a: UAF a
 | JC a: UAF a
 | JCXZ a: UAF a
 | JE a: UAF a
 | JECXZ a: UAF a
 | JG a: UAF a
 | JGE a: UAF a
 | JL a: UAF a
 | JLE a: UAF a
 | JMP a: UAF a
 | JNA a: UAF a
 | JNAE a: UAF a
 | JNB a: UAF a
 | JNBE a: UAF a
 | JNC a: UAF a
 | JNE a: UAF a
 | JNG a: UAF a
 | JNGE a: UAF a
 | JNL a: UAF a
 | JNLE a: UAF a
 | JNO a: UAF a
 | JNP a: UAF a
 | JNS a: UAF a
 | JNZ a: UAF a
 | JO a: UAF a
 | JP a: UAF a
 | JPE a: UAF a
 | JPO a: UAF a
 | JRCXZ a: UAF a
 | JS a: UAF a
 | JZ a: UAF a
 | LAHF: UA0
 | LAR a: UA2 a
 | LDDQU a: UA2 a
 | LDMXCSR a: UA1 a
 | LDS a: UA2 a
 | LEA a: UA2 a
 | LEAVE: UA0
 | LES a: UA2 a
 | LFENCE: UA0
 | LFS a: UA2 a
 | LGDT a: UA1 a
 | LGS a: UA2 a
 | LIDT a: UA1 a
 | LLDT a: UA1 a
 | LMSW a: UA1 a
 | LODS a: UA1 a
 | LOOP a: UAF a
 | LOOPE a: UAF a
 | LOOPNE a: UAF a
 | LSL a: UA2 a
 | LSS a: UA2 a
 | LTR a: UA1 a
 | MASKMOVDQU a: UA3 a
 | MASKMOVQ a: UA3 a
 | MAXPD a: UA2 a
 | MAXPS a: UA2 a
 | MAXSD a: UA2 a
 | MAXSS a: UA2 a
 | MFENCE: UA0
 | MINPD a: UA2 a
 | MINPS a: UA2 a
 | MINSD a: UA2 a
 | MINSS a: UA2 a
 | MONITOR: UA0
 | MOV a: UA2 a
 | MOVAPD a: UA2 a
 | MOVAPS a: UA2 a
 | MOVBE a: UA2 a
 | MOVD a: UA2 a
 | MOVDDUP a: UA2 a
 | MOVDQ2Q a: UA2 a
 | MOVDQA a: UA2 a
 | MOVDQU a: UA2 a
 | MOVHLPS a: UA2 a
 | MOVHPD a: UA2 a
 | MOVHPS a: UA2 a
 | MOVLHPS a: UA2 a
 | MOVLPD a: UA2 a
 | MOVLPS a: UA2 a
 | MOVMSKPD a: UA2 a
 | MOVMSKPS a: UA2 a
 | MOVNTDQ a: UA2 a
 | MOVNTDQA a: UA2 a
 | MOVNTI a: UA2 a
 | MOVNTPD a: UA2 a
 | MOVNTPS a: UA2 a
 | MOVNTQ a: UA2 a
 | MOVQ a: UA2 a
 | MOVQ2DQ a: UA2 a
 | MOVS a: UA2 a
 | MOVSD a: UA2 a
 | MOVSHDUP a: UA2 a
 | MOVSLDUP a: UA2 a
 | MOVSS a: UA2 a
 | MOVSW a: UA2 a
 | MOVSX a: UA2 a
 | MOVSXD a: UA2 a
 | MOVUPD a: UA2 a
 | MOVUPS a: UA2 a
 | MOVZX a: UA2 a
 | MPSADBW a: UA3 a
 | MUL a: UA1 a
 | MULPD a: UA2 a
 | MULPS a: UA2 a
 | MULSD a: UA2 a
 | MULSS a: UA2 a
 | MWAIT: UA0
 | NEG a: UA1 a
 | NOP a: (to-uarity a)
 | NOT a: UA1 a
 | OR a: UA2 a
 | ORPD a: UA2 a
 | ORPS a: UA2 a
 | OUT a: UA2 a
 | OUTS: UA0
 | OUTSB: UA0
 | OUTSD: UA0
 | OUTSW: UA0
 | PABSB a: UA2 a
 | PABSD a: UA2 a
 | PABSW a: UA2 a
 | PACKSSDW a: UA2 a
 | PACKSSWB a: UA2 a
 | PACKUSDW a: UA2 a
 | PACKUSWB a: UA2 a
 | PADDB a: UA2 a
 | PADDD a: UA2 a
 | PADDQ a: UA2 a
 | PADDSB a: UA2 a
 | PADDSW a: UA2 a
 | PADDUSB a: UA2 a
 | PADDUSW a: UA2 a
 | PADDW a: UA2 a
 | PALIGNR a: UA3 a
 | PAND a: UA2 a
 | PANDN a: UA2 a
 | PAUSE: UA0
 | PAVGB a: UA2 a
 | PAVGW a: UA2 a
 | PBLENDVB a: UA2 a
 | PBLENDW a: UA3 a
 | PCLMULQDQ a: UA3 a
 | PCMPEQB a: UA2 a
 | PCMPEQD a: UA2 a
 | PCMPEQQ a: UA2 a
 | PCMPEQW a: UA2 a
 | PCMPESTRI a: UA3 a
 | PCMPESTRM a: UA3 a
 | PCMPGRD a: UA2 a
 | PCMPGTB a: UA2 a
 | PCMPGTD a: UA2 a
 | PCMPGTQ a: UA2 a
 | PCMPGTW a: UA2 a
 | PCMPISTRI a: UA3 a
 | PCMPISTRM a: UA3 a
 | PEXTRB a: UA3 a
 | PEXTRD a: UA3 a
 | PEXTRQ a: UA3 a
 | PEXTRW a: UA3 a
 | PHADDD a: UA2 a
 | PHADDSW a: UA2 a
 | PHADDW a: UA2 a
 | PHMINPOSUW a: UA2 a
 | PHSUBD a: UA2 a
 | PHSUBSW a: UA2 a
 | PHSUBW a: UA2 a
 | PINSRB a: UA3 a
 | PINSRD a: UA3 a
 | PINSRQ a: UA3 a
 | PINSRW a: UA3 a
 | PMADDUBSW a: UA2 a
 | PMADDWD a: UA2 a
 | PMAXSB a: UA2 a
 | PMAXSD a: UA2 a
 | PMAXSW a: UA2 a
 | PMAXUB a: UA2 a
 | PMAXUD a: UA2 a
 | PMAXUW a: UA2 a
 | PMINSB a: UA2 a
 | PMINSD a: UA2 a
 | PMINSW a: UA2 a
 | PMINUB a: UA2 a
 | PMINUD a: UA2 a
 | PMINUW a: UA2 a
 | PMOVMSKB a: UA2 a
 | PMOVSXBD a: UA2 a
 | PMOVSXBQ a: UA2 a
 | PMOVSXBW a: UA2 a
 | PMOVSXDQ a: UA2 a
 | PMOVSXWD a: UA2 a
 | PMOVSXWQ a: UA2 a
 | PMOVZXBD a: UA2 a
 | PMOVZXBQ a: UA2 a
 | PMOVZXBW a: UA2 a
 | PMOVZXDQ a: UA2 a
 | PMOVZXWD a: UA2 a
 | PMOVZXWQ a: UA2 a
 | PMULDQ a: UA2 a
 | PMULHRSW a: UA2 a
 | PMULHUW a: UA2 a
 | PMULHW a: UA2 a
 | PMULLD a: UA2 a
 | PMULLW a: UA2 a
 | PMULUDQ a: UA2 a
 | POP a: UA1 a
 | POPA: UA0
 | POPAD: UA0
 | POPCNT a: UA2 a
 | POPF: UA0
 | POPFD: UA0
 | POPFQ: UA0
 | POR a: UA2 a
 | PREFETCHNTA a: UA1 a
 | PREFETCHT0 a: UA1 a
 | PREFETCHT1 a: UA1 a
 | PREFETCHT2 a: UA1 a
 | PREFETCHW a: UA1 a
 | PSADBW a: UA2 a
 | PSHUFB a: UA2 a
 | PSHUFD a: UA3 a
 | PSHUFHW a: UA3 a
 | PSHUFLW a: UA3 a
 | PSHUFW a: UA3 a
 | PSIGNB a: UA2 a
 | PSIGND a: UA2 a
 | PSIGNW a: UA2 a
 | PSLLD a: UA2 a
 | PSLLDQ a: UA2 a
 | PSLLQ a: UA2 a
 | PSLLW a: UA2 a
 | PSRAD a: UA2 a
 | PSRAW a: UA2 a
 | PSRLD a: UA2 a
 | PSRLDQ a: UA2 a
 | PSRLQ a: UA2 a
 | PSRLW a: UA2 a
 | PSUBB a: UA2 a
 | PSUBD a: UA2 a
 | PSUBQ a: UA2 a
 | PSUBSB a: UA2 a
 | PSUBSW a: UA2 a
 | PSUBUSB a: UA2 a
 | PSUBUSW a: UA2 a
 | PSUBW a: UA2 a
 | PTEST a: UA2 a
 | PUNPCKHBW a: UA2 a
 | PUNPCKHDQ a: UA2 a
 | PUNPCKHQDQ a: UA2 a
 | PUNPCKHWD a: UA2 a
 | PUNPCKLBW a: UA2 a
 | PUNPCKLDQ a: UA2 a
 | PUNPCKLQDQ a: UA2 a
 | PUNPCKLWD a: UA2 a
 | PUSH a: UA1 a
 | PUSHA: UA0
 | PUSHAD: UA0
 | PUSHF: UA0
 | PUSHFD: UA0
 | PUSHFQ: UA0
 | PXOR a: UA2 a
 | RCL a: UA2 a
 | RCPPS a: UA2 a
 | RCPSS a: UA2 a
 | RCR a: UA2 a
 | RDFSBASE a: UA1 a
 | RDGSBASE a: UA1 a
 | RDMSR: UA0
 | RDPMC: UA0
 | RDRAND a: UA1 a
 | RDTSC: UA0
 | RDTSCP: UA0
 | RET a: (to-uarity a)
 | RET_FAR a: (to-uarity a)
 | ROL a: UA2 a
 | ROR a: UA2 a
 | ROUNDPD a: UA3 a
 | ROUNDPS a: UA3 a
 | ROUNDSD a: UA3 a
 | ROUNDSS a: UA3 a
 | RSM: UA0
 | RSQRTPS a: UA2 a
 | RSQRTSS a: UA2 a
 | SAHF: UA0
 | SAL a: UA2 a
 | SAR a: UA2 a
 | SBB a: UA2 a
 | SCASB: UA0
 | SCASD: UA0
 | SCASQ: UA0
 | SCASW: UA0
 | SETA a: UA1 a
 | SETAE a: UA1 a
 | SETB a: UA1 a
 | SETBE a: UA1 a
 | SETC a: UA1 a
 | SETE a: UA1 a
 | SETG a: UA1 a
 | SETGE a: UA1 a
 | SETL a: UA1 a
 | SETLE a: UA1 a
 | SETNA a: UA1 a
 | SETNAE a: UA1 a
 | SETNB a: UA1 a
 | SETNBE a: UA1 a
 | SETNC a: UA1 a
 | SETNE a: UA1 a
 | SETNG a: UA1 a
 | SETNGE a: UA1 a
 | SETNL a: UA1 a
 | SETNLE a: UA1 a
 | SETNO a: UA1 a
 | SETNP a: UA1 a
 | SETNS a: UA1 a
 | SETNZ a: UA1 a
 | SETO a: UA1 a
 | SETP a: UA1 a
 | SETPE a: UA1 a
 | SETPO a: UA1 a
 | SETS a: UA1 a
 | SETZ a: UA1 a
 | SFENCE: UA0
 | SGDT a: UA1 a
 | SHL a: UA2 a
 | SHLD a: UA3 a
 | SHR a: UA2 a
 | SHRD a: UA3 a
 | SHUFPD a: UA3 a
 | SHUFPS a: UA3 a
 | SIDT a: UA1 a
 | SLDT a: UA1 a
 | SMSW a: UA1 a
 | SQRTPD a: UA2 a
 | SQRTPS a: UA2 a
 | SQRTSD a: UA2 a
 | SQRTSS a: UA2 a
 | STC: UA0
 | STD: UA0
 | STI: UA0
 | STMXCSR a: UA1 a
 | STOSB: UA0
 | STOSD: UA0
 | STOSQ: UA0
 | STOSW: UA0
 | STR a: UA1 a
 | SUB a: UA2 a
 | SUBPD a: UA2 a
 | SUBPS a: UA2 a
 | SUBSD a: UA2 a
 | SUBSS a: UA2 a
 | SWAPGS: UA0
 | SYSCALL: UA0
 | SYSENTER: UA0
 | SYSEXIT: UA0
 | SYSRET: UA0
 | TEST a: UA2 a
 | UCOMISD a: UA2 a
 | UCOMISS a: UA2 a
 | UD2: UA0
 | UNPCKHPD a: UA2 a
 | UNPCKHPS a: UA2 a
 | UNPCKLPD a: UA2 a
 | UNPCKLPS a: UA2 a
 | VADDPD a: (to-uarity a)
 | VADDPS a: (to-uarity a)
 | VADDSD a: (to-uarity a)
 | VADDSS a: (to-uarity a)
 | VADDSUBPD a: (to-uarity a)
 | VADDSUBPS a: (to-uarity a)
 | VAESDEC a: (to-uarity a)
 | VAESDECLAST a: (to-uarity a)
 | VAESENC a: (to-uarity a)
 | VAESENCLAST a: (to-uarity a)
 | VAESIMC a: (to-uarity a)
 | VAESKEYGENASSIST a: (to-uarity a)
 | VANDNPD a: (to-uarity a)
 | VANDNPS a: (to-uarity a)
 | VANDPD a: (to-uarity a)
 | VANDPS a: (to-uarity a)
 | VBLENDPD a: (to-uarity a)
 | VBLENDPS a: (to-uarity a)
 | VBLENDVPD a: (to-uarity a)
 | VBLENDVPS a: (to-uarity a)
 | VBROADCASTF128 a: (to-uarity a)
 | VBROADCASTSD a: (to-uarity a)
 | VBROADCASTSS a: (to-uarity a)
 | VCMPPD a: (to-uarity a)
 | VCMPPS a: (to-uarity a)
 | VCMPSD a: (to-uarity a)
 | VCMPSS a: (to-uarity a)
 | VCOMISD a: (to-uarity a)
 | VCOMISS a: (to-uarity a)
 | VCVTDQ2PD a: (to-uarity a)
 | VCVTDQ2PS a: (to-uarity a)
 | VCVTPD2DQ a: (to-uarity a)
 | VCVTPD2PS a: (to-uarity a)
 | VCVTPH2PS a: (to-uarity a)
 | VCVTPS2DQ a: (to-uarity a)
 | VCVTPS2PD a: (to-uarity a)
 | VCVTPS2PH a: (to-uarity a)
 | VCVTSD2SI a: (to-uarity a)
 | VCVTSD2SS a: (to-uarity a)
 | VCVTSI2SD a: (to-uarity a)
 | VCVTSI2SS a: (to-uarity a)
 | VCVTSS2SD a: (to-uarity a)
 | VCVTSS2SI a: (to-uarity a)
 | VCVTTPD2DQ a: (to-uarity a)
 | VCVTTPS2DQ a: (to-uarity a)
 | VCVTTSD2SI a: (to-uarity a)
 | VCVTTSS2SI a: (to-uarity a)
 | VDIVPD a: (to-uarity a)
 | VDIVPS a: (to-uarity a)
 | VDIVSD a: (to-uarity a)
 | VDIVSS a: (to-uarity a)
 | VDPPD a: (to-uarity a)
 | VDPPS a: (to-uarity a)
 | VERR a: UA1 a
 | VERW a: UA1 a
 | VEXTRACTF128 a: (to-uarity a)
 | VEXTRACTPS a: (to-uarity a)
 | VHADDPD a: (to-uarity a)
 | VHADDPS a: (to-uarity a)
 | VHSUBPD a: (to-uarity a)
 | VHSUBPS a: (to-uarity a)
 | VINSERTF128 a: (to-uarity a)
 | VINSERTPS a: (to-uarity a)
 | VLDDQU a: (to-uarity a)
 | VLDMXCSR a: (to-uarity a)
 | VMASKMOVDQU a: (to-uarity a)
 | VMASKMOVPD a: (to-uarity a)
 | VMASKMOVPS a: (to-uarity a)
 | VMAXPD a: (to-uarity a)
 | VMAXPS a: (to-uarity a)
 | VMAXSD a: (to-uarity a)
 | VMAXSS a: (to-uarity a)
 | VMINPD a: (to-uarity a)
 | VMINPS a: (to-uarity a)
 | VMINSD a: (to-uarity a)
 | VMINSS a: (to-uarity a)
 | VMOVAPD a: (to-uarity a)
 | VMOVAPS a: (to-uarity a)
 | VMOVD a: (to-uarity a)
 | VMOVDDUP a: (to-uarity a)
 | VMOVDQA a: (to-uarity a)
 | VMOVDQU a: (to-uarity a)
 | VMOVHLPS a: (to-uarity a)
 | VMOVHPD a: (to-uarity a)
 | VMOVHPS a: (to-uarity a)
 | VMOVLHPS a: (to-uarity a)
 | VMOVLPD a: (to-uarity a)
 | VMOVLPS a: (to-uarity a)
 | VMOVMSKPD a: (to-uarity a)
 | VMOVMSKPS a: (to-uarity a)
 | VMOVNTDQ a: (to-uarity a)
 | VMOVNTDQA a: (to-uarity a)
 | VMOVNTPD a: (to-uarity a)
 | VMOVNTPS a: (to-uarity a)
 | VMOVQ a: (to-uarity a)
 | VMOVSD a: (to-uarity a)
 | VMOVSHDUP a: (to-uarity a)
 | VMOVSLDUP a: (to-uarity a)
 | VMOVSS a: (to-uarity a)
 | VMOVUPD a: (to-uarity a)
 | VMOVUPS a: (to-uarity a)
 | VMPSADBW a: (to-uarity a)
 | VMULPD a: (to-uarity a)
 | VMULPS a: (to-uarity a)
 | VMULSD a: (to-uarity a)
 | VMULSS a: (to-uarity a)
 | VORPD a: (to-uarity a)
 | VORPS a: (to-uarity a)
 | VPABSB a: (to-uarity a)
 | VPABSD a: (to-uarity a)
 | VPABSW a: (to-uarity a)
 | VPACKSSDW a: (to-uarity a)
 | VPACKSSWB a: (to-uarity a)
 | VPACKUSDW a: (to-uarity a)
 | VPACKUSWB a: (to-uarity a)
 | VPADDB a: (to-uarity a)
 | VPADDD a: (to-uarity a)
 | VPADDQ a: (to-uarity a)
 | VPADDSB a: (to-uarity a)
 | VPADDSW a: (to-uarity a)
 | VPADDUSB a: (to-uarity a)
 | VPADDUSW a: (to-uarity a)
 | VPADDW a: (to-uarity a)
 | VPALIGNR a: (to-uarity a)
 | VPAND a: (to-uarity a)
 | VPANDN a: (to-uarity a)
 | VPAVGB a: (to-uarity a)
 | VPAVGW a: (to-uarity a)
 | VPBLENDVB a: (to-uarity a)
 | VPBLENDW a: (to-uarity a)
 | VPCLMULQDQ a: (to-uarity a)
 | VPCMPEQB a: (to-uarity a)
 | VPCMPEQD a: (to-uarity a)
 | VPCMPEQQ a: (to-uarity a)
 | VPCMPEQW a: (to-uarity a)
 | VPCMPESTRI a: (to-uarity a)
 | VPCMPESTRM a: (to-uarity a)
 | VPCMPGTB a: (to-uarity a)
 | VPCMPGTD a: (to-uarity a)
 | VPCMPGTQ a: (to-uarity a)
 | VPCMPGTW a: (to-uarity a)
 | VPCMPISTRI a: (to-uarity a)
 | VPCMPISTRM a: (to-uarity a)
 | VPERM2F128 a: (to-uarity a)
 | VPERMILPD a: (to-uarity a)
 | VPERMILPS a: (to-uarity a)
 | VPEXTRB a: (to-uarity a)
 | VPEXTRD a: (to-uarity a)
 | VPEXTRQ a: (to-uarity a)
 | VPEXTRW a: (to-uarity a)
 | VPHADDD a: (to-uarity a)
 | VPHADDSW a: (to-uarity a)
 | VPHADDW a: (to-uarity a)
 | VPHMINPOSUW a: (to-uarity a)
 | VPHSUBD a: (to-uarity a)
 | VPHSUBSW a: (to-uarity a)
 | VPHSUBW a: (to-uarity a)
 | VPINSRB a: (to-uarity a)
 | VPINSRD a: (to-uarity a)
 | VPINSRQ a: (to-uarity a)
 | VPINSRW a: (to-uarity a)
 | VPMADDUBSW a: (to-uarity a)
 | VPMADDWD a: (to-uarity a)
 | VPMAXSB a: (to-uarity a)
 | VPMAXSD a: (to-uarity a)
 | VPMAXSW a: (to-uarity a)
 | VPMAXUB a: (to-uarity a)
 | VPMAXUD a: (to-uarity a)
 | VPMAXUW a: (to-uarity a)
 | VPMINSB a: (to-uarity a)
 | VPMINSD a: (to-uarity a)
 | VPMINSW a: (to-uarity a)
 | VPMINUB a: (to-uarity a)
 | VPMINUD a: (to-uarity a)
 | VPMINUW a: (to-uarity a)
 | VPMOVMSKB a: (to-uarity a)
 | VPMOVSXBD a: (to-uarity a)
 | VPMOVSXBQ a: (to-uarity a)
 | VPMOVSXBW a: (to-uarity a)
 | VPMOVSXDQ a: (to-uarity a)
 | VPMOVSXWD a: (to-uarity a)
 | VPMOVSXWQ a: (to-uarity a)
 | VPMOVZXBD a: (to-uarity a)
 | VPMOVZXBQ a: (to-uarity a)
 | VPMOVZXBW a: (to-uarity a)
 | VPMOVZXDQ a: (to-uarity a)
 | VPMOVZXWD a: (to-uarity a)
 | VPMOVZXWQ a: (to-uarity a)
 | VPMULDQ a: (to-uarity a)
 | VPMULHRSW a: (to-uarity a)
 | VPMULHUW a: (to-uarity a)
 | VPMULHW a: (to-uarity a)
 | VPMULLD a: (to-uarity a)
 | VPMULLW a: (to-uarity a)
 | VPMULUDQ a: (to-uarity a)
 | VPOR a: (to-uarity a)
 | VPSADBW a: (to-uarity a)
 | VPSHUFB a: (to-uarity a)
 | VPSHUFD a: (to-uarity a)
 | VPSHUFHW a: (to-uarity a)
 | VPSHUFLW a: (to-uarity a)
 | VPSIGNB a: (to-uarity a)
 | VPSIGND a: (to-uarity a)
 | VPSIGNW a: (to-uarity a)
 | VPSLLD a: (to-uarity a)
 | VPSLLDQ a: (to-uarity a)
 | VPSLLQ a: (to-uarity a)
 | VPSLLW a: (to-uarity a)
 | VPSRAD a: (to-uarity a)
 | VPSRAW a: (to-uarity a)
 | VPSRLD a: (to-uarity a)
 | VPSRLDQ a: (to-uarity a)
 | VPSRLQ a: (to-uarity a)
 | VPSRLW a: (to-uarity a)
 | VPSUBB a: (to-uarity a)
 | VPSUBD a: (to-uarity a)
 | VPSUBQ a: (to-uarity a)
 | VPSUBSB a: (to-uarity a)
 | VPSUBSW a: (to-uarity a)
 | VPSUBUSB a: (to-uarity a)
 | VPSUBUSW a: (to-uarity a)
 | VPSUBW a: (to-uarity a)
 | VPTEST a: (to-uarity a)
 | VPUNPCKHBW a: (to-uarity a)
 | VPUNPCKHDQ a: (to-uarity a)
 | VPUNPCKHQDQ a: (to-uarity a)
 | VPUNPCKHWD a: (to-uarity a)
 | VPUNPCKLBW a: (to-uarity a)
 | VPUNPCKLDQ a: (to-uarity a)
 | VPUNPCKLQDQ a: (to-uarity a)
 | VPUNPCKLWD a: (to-uarity a)
 | VPXOR a: (to-uarity a)
 | VRCPPS a: (to-uarity a)
 | VRCPSS a: (to-uarity a)
 | VROUNDPD a: (to-uarity a)
 | VROUNDPS a: (to-uarity a)
 | VROUNDSD a: (to-uarity a)
 | VROUNDSS a: (to-uarity a)
 | VRSQRTPS a: (to-uarity a)
 | VRSQRTSS a: (to-uarity a)
 | VSHUFPD a: (to-uarity a)
 | VSHUFPS a: (to-uarity a)
 | VSQRTPD a: (to-uarity a)
 | VSQRTPS a: (to-uarity a)
 | VSQRTSD a: (to-uarity a)
 | VSQRTSS a: (to-uarity a)
 | VSTMXCSR a: (to-uarity a)
 | VSUBPD a: (to-uarity a)
 | VSUBPS a: (to-uarity a)
 | VSUBSD a: (to-uarity a)
 | VSUBSS a: (to-uarity a)
 | VTESTPD a: (to-uarity a)
 | VTESTPS a: (to-uarity a)
 | VUCOMISD a: (to-uarity a)
 | VUCOMISS a: (to-uarity a)
 | VUNPCKHPD a: (to-uarity a)
 | VUNPCKHPS a: (to-uarity a)
 | VUNPCKLPD a: (to-uarity a)
 | VUNPCKLPS a: (to-uarity a)
 | VXORPD a: (to-uarity a)
 | VXORPS a: (to-uarity a)
 | VZEROALL a: (to-uarity a)
 | VZEROUPPER a: (to-uarity a)
 | WAIT: UA0
 | WBINVD: UA0
 | WRFSBASE a: UA1 a
 | WRGSBASE a: UA1 a
 | WRMSR: UA0
 | XADD a: UA2 a
 | XCHG a: UA2 a
 | XGETBV: UA0
 | XLATB: UA0
 | XOR a: UA2 a
 | XORPD a: UA2 a
 | XORPS a: UA2 a
 | XRSTOR a: UA1 a
 | XRSTOR64 a: UA1 a
 | XSAVE a: UA1 a
 | XSAVE64 a: UA1 a
 | XSAVEOPT a: UA1 a
 | XSAVEOPT64 a: UA1 a
 | XSETBV: UA0
end

val operands x =
  case (uarity-of x.insn) of
     UA0: 0
   | UA1 x: 1
   | UA2 x: 2
   | UA3 x: 3
   | UA4 x: 4
   | UAF x: 1
  end

val operands-force-types x = pretty x +++ (show-int (operands x))
