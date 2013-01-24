# This file maps syntactic registers to semantic registers used in RREIL.

# define functions that generate EFLAGS variables
val fCF = return (_var Sem_FLAGS _offset 0)
val fPF = return (_var Sem_FLAGS _offset 2)
val fAF = return (_var Sem_FLAGS _offset 4)
val fZF = return (_var Sem_FLAGS _offset 6)
val fSF = return (_var Sem_FLAGS _offset 7)
val fDF = return (_var Sem_FLAGS _offset 10)
val fOF = return (_var Sem_FLAGS _offset 11)

val rflags = do
  flags <- return {id=Sem_FLAGS,offset=0,size=64};

  #Set missing bits according to manual
  mov 1 (at-offset flags 1) (imm 1);
  mov 1 (at-offset flags 3) (imm 0);
  mov 1 (at-offset flags 5) (imm 0);

  return flags
end

type sem_id
   = Sem_IP
   | Sem_FLAGS
   | Sem_MXCSR
   | Sem_AX
   | Sem_BX
   | Sem_CX
   | Sem_DX
   | Sem_SI
   | Sem_DI
   | Sem_SP
   | Sem_BP
   | Sem_R8
   | Sem_R9
   | Sem_R10
   | Sem_R11
   | Sem_R12
   | Sem_R13
   | Sem_R14
   | Sem_R15
   | Sem_CS    # the segment registers represent their entry in the segment table
   | Sem_DS
   | Sem_SS
   | Sem_ES
   | Sem_FS
   | Sem_GS
   | Sem_ST0
   | Sem_ST1
   | Sem_ST2
   | Sem_ST3
   | Sem_ST4
   | Sem_ST5
   | Sem_ST6
   | Sem_ST7
   | Sem_MM0
   | Sem_MM1
   | Sem_MM2
   | Sem_MM3
   | Sem_MM4
   | Sem_MM5
   | Sem_MM6
   | Sem_MM7
   | Sem_MM8
   | Sem_XMM0
   | Sem_XMM1
   | Sem_XMM2
   | Sem_XMM3
   | Sem_XMM4
   | Sem_XMM5
   | Sem_XMM6
   | Sem_XMM7
   | Sem_XMM8
   | Sem_XMM9
   | Sem_XMM10
   | Sem_XMM11
   | Sem_XMM12
   | Sem_XMM13
   | Sem_XMM14
   | Sem_XMM15

val semantic-register-of r = case r of
    AL    : {id=Sem_AX,offset=0,size=8}
   | AH    : {id=Sem_AX,offset=8,size=8}
   | AX    : {id=Sem_AX,offset=0,size=16}
   | EAX   : {id=Sem_AX,offset=0,size=32}
   | RAX   : {id=Sem_AX,offset=0,size=64}
   | BL    : {id=Sem_BX,offset=0,size=8}
   | BH    : {id=Sem_BX,offset=8,size=8}
   | BX    : {id=Sem_BX,offset=0,size=16}
   | EBX   : {id=Sem_BX,offset=0,size=32}
   | RBX   : {id=Sem_BX,offset=0,size=64}
   | CL    : {id=Sem_CX,offset=0,size=8}
   | CH    : {id=Sem_CX,offset=8,size=8}
   | CX    : {id=Sem_CX,offset=0,size=16}
   | ECX   : {id=Sem_CX,offset=0,size=32}
   | RCX   : {id=Sem_CX,offset=0,size=64}
   | DL    : {id=Sem_DX,offset=0,size=8}
   | DH    : {id=Sem_DX,offset=8,size=8}
   | DX    : {id=Sem_DX,offset=0,size=16}
   | EDX   : {id=Sem_DX,offset=0,size=32}
   | RDX   : {id=Sem_DX,offset=0,size=64}
   | R8B   : {id=Sem_R8,offset=0,size=8}
   | R8L   : {id=Sem_R8,offset=0,size=16}
   | R8D   : {id=Sem_R8,offset=0,size=32}
   | R8    : {id=Sem_R8,offset=0,size=64}
   | R9B   : {id=Sem_R9,offset=0,size=8}
   | R9L   : {id=Sem_R9,offset=0,size=16}
   | R9D   : {id=Sem_R9,offset=0,size=32}
   | R9    : {id=Sem_R9,offset=0,size=64}
   | R10B  : {id=Sem_R10,offset=0,size=8}
   | R10L  : {id=Sem_R10,offset=0,size=16}
   | R10D  : {id=Sem_R10,offset=0,size=32}
   | R10   : {id=Sem_R10,offset=0,size=64}
   | R11B  : {id=Sem_R11,offset=0,size=8}
   | R11L  : {id=Sem_R11,offset=0,size=16}
   | R11D  : {id=Sem_R11,offset=0,size=32}
   | R11   : {id=Sem_R11,offset=0,size=64}
   | R12B  : {id=Sem_R12,offset=0,size=8}
   | R12L  : {id=Sem_R12,offset=0,size=16}
   | R12D  : {id=Sem_R12,offset=0,size=32}
   | R12   : {id=Sem_R12,offset=0,size=64}
   | R13B  : {id=Sem_R13,offset=0,size=8}
   | R13L  : {id=Sem_R13,offset=0,size=16}
   | R13D  : {id=Sem_R13,offset=0,size=32}
   | R13   : {id=Sem_R13,offset=0,size=64}
   | R14B  : {id=Sem_R14,offset=0,size=8}
   | R14L  : {id=Sem_R14,offset=0,size=16}
   | R14D  : {id=Sem_R14,offset=0,size=32}
   | R14   : {id=Sem_R14,offset=0,size=64}
   | R15B  : {id=Sem_R15,offset=0,size=8}
   | R15L  : {id=Sem_R15,offset=0,size=16}
   | R15D  : {id=Sem_R15,offset=0,size=32}
   | R15   : {id=Sem_R15,offset=0,size=64}
   | SP    : {id=Sem_SP, offset=0,size=16}
   | ESP   : {id=Sem_SP, offset=0,size=32}
   | RSP   : {id=Sem_SP, offset=0,size=64}
   | BP    : {id=Sem_BP, offset=0,size=16}
   | EBP   : {id=Sem_BP, offset=0,size=32}
   | RBP   : {id=Sem_BP, offset=0,size=64}
   | SI    : {id=Sem_SI, offset=0,size=16}
   | ESI   : {id=Sem_SI, offset=0,size=32}
   | RSI   : {id=Sem_SI, offset=0,size=64}
   | DI    : {id=Sem_DI, offset=0,size=16}
   | EDI   : {id=Sem_DI, offset=0,size=32}
   | RDI   : {id=Sem_DI, offset=0,size=64}
   | XMM0  : {id=Sem_XMM0, offset=0,size=128}
   | XMM1  : {id=Sem_XMM1, offset=0,size=128}
   | XMM2  : {id=Sem_XMM2, offset=0,size=128}
   | XMM3  : {id=Sem_XMM3, offset=0,size=128}
   | XMM4  : {id=Sem_XMM4, offset=0,size=128}
   | XMM5  : {id=Sem_XMM5, offset=0,size=128}
   | XMM6  : {id=Sem_XMM6, offset=0,size=128}
   | XMM7  : {id=Sem_XMM7, offset=0,size=128}
   | XMM8  : {id=Sem_XMM8, offset=0,size=128}
   | XMM9  : {id=Sem_XMM9, offset=0,size=128}
   | XMM10 : {id=Sem_XMM10, offset=0,size=128}
   | XMM11 : {id=Sem_XMM11, offset=0,size=128}
   | XMM12 : {id=Sem_XMM12, offset=0,size=128}
   | XMM13 : {id=Sem_XMM13, offset=0,size=128}
   | XMM14 : {id=Sem_XMM14, offset=0,size=128}
   | XMM15 : {id=Sem_XMM15, offset=0,size=128}
   | YMM0  : {id=Sem_XMM0, offset=0,size=256}
   | YMM1  : {id=Sem_XMM1, offset=0,size=256}
   | YMM2  : {id=Sem_XMM2, offset=0,size=256}
   | YMM3  : {id=Sem_XMM3, offset=0,size=256}
   | YMM4  : {id=Sem_XMM4, offset=0,size=256}
   | YMM5  : {id=Sem_XMM5, offset=0,size=256}
   | YMM6  : {id=Sem_XMM6, offset=0,size=256}
   | YMM7  : {id=Sem_XMM7, offset=0,size=256}
   | YMM8  : {id=Sem_XMM8, offset=0,size=256}
   | YMM9  : {id=Sem_XMM9, offset=0,size=256}
   | YMM10 : {id=Sem_XMM10, offset=0,size=256}
   | YMM11 : {id=Sem_XMM11, offset=0,size=256}
   | YMM12 : {id=Sem_XMM12, offset=0,size=256}
   | YMM13 : {id=Sem_XMM13, offset=0,size=256}
   | YMM14 : {id=Sem_XMM14, offset=0,size=256}
   | YMM15 : {id=Sem_XMM15, offset=0,size=256}
   | MM0   : {id=Sem_MM0, offset=0, size=64}
   | MM1   : {id=Sem_MM1, offset=0, size=64}
   | MM2   : {id=Sem_MM2, offset=0, size=64}
   | MM3   : {id=Sem_MM3, offset=0, size=64}
   | MM4   : {id=Sem_MM4, offset=0, size=64}
   | MM5   : {id=Sem_MM5, offset=0, size=64}
   | MM6   : {id=Sem_MM6, offset=0, size=64}
   | MM7   : {id=Sem_MM7, offset=0, size=64}
   | ES    : {id=Sem_ES, offset=0, size=64} # content of segment table
   | SS    : {id=Sem_SS, offset=0, size=64}
   | DS    : {id=Sem_DS, offset=0, size=64}
   | FS    : {id=Sem_FS, offset=0, size=64}
   | GS    : {id=Sem_GS, offset=0, size=64}
   | CS    : {id=Sem_CS, offset=0, size=64}
   | ST0   : {id=Sem_ST0, offset=0, size=80}
   | ST1   : {id=Sem_ST1, offset=0, size=80}
   | ST2   : {id=Sem_ST2, offset=0, size=80}
   | ST3   : {id=Sem_ST3, offset=0, size=80}
   | ST4   : {id=Sem_ST4, offset=0, size=80}
   | ST5   : {id=Sem_ST5, offset=0, size=80}
   | ST6   : {id=Sem_ST6, offset=0, size=80}
   | ST7   : {id=Sem_ST7, offset=0, size=80}
   | RIP   : {id=Sem_IP, offset=0, size=64}
end

val semantic-register-of-operand-with-size opnd size =
  case opnd of
     REG r: @{size=size} (semantic-register-of r)
  end

val semantic-register id offset size = {id=id,offset=offset,size=size}

val arch-show-id r = case r of
     Sem_IP : "IP"
   | Sem_FLAGS : "FLAGS"
   | Sem_MXCSR : "MXCSR"
   | Sem_AX : "AX"
   | Sem_BX : "BX"
   | Sem_CX : "CX"
   | Sem_DX : "DX"
   | Sem_SI : "SI"
   | Sem_DI : "DI"
   | Sem_SP : "SP"
   | Sem_BP : "BP"
   | Sem_R8 : "R8"
   | Sem_R9 : "R9"
   | Sem_R10 : "R10"
   | Sem_R11 : "R11"
   | Sem_R12 : "R12"
   | Sem_R13 : "R13"
   | Sem_R14 : "R14"
   | Sem_R15 : "R15"
   | Sem_CS : "CS"
   | Sem_DS : "DS"
   | Sem_SS : "SS"
   | Sem_ES : "ES"
   | Sem_FS : "FS"
   | Sem_GS : "GS"
   | Sem_ST0 : "ST0"
   | Sem_ST1 : "ST1"
   | Sem_ST2 : "ST2"
   | Sem_ST3 : "ST3"
   | Sem_ST4 : "ST4"
   | Sem_ST5 : "ST5"
   | Sem_ST6 : "ST6"
   | Sem_ST7 : "ST7"
   | Sem_MM0 : "MM0"
   | Sem_MM1 : "MM1"
   | Sem_MM2 : "MM2"
   | Sem_MM3 : "MM3"
   | Sem_MM4 : "MM4"
   | Sem_MM5 : "MM5"
   | Sem_MM6 : "MM6"
   | Sem_MM7 : "MM7"
   | Sem_MM8 : "MM8"
   | Sem_XMM0 : "XMM0"
   | Sem_XMM1 : "XMM1"
   | Sem_XMM2 : "XMM2"
   | Sem_XMM3 : "XMM3"
   | Sem_XMM4 : "XMM4"
   | Sem_XMM5 : "XMM5"
   | Sem_XMM6 : "XMM6"
   | Sem_XMM7 : "XMM7"
   | Sem_XMM8 : "XMM8"
   | Sem_XMM9 : "XMM9"
   | Sem_XMM10 : "XMM10"
   | Sem_XMM11 : "XMM11"
   | Sem_XMM12 : "XMM12"
   | Sem_XMM13 : "XMM13"
   | Sem_XMM14 : "XMM14"
   | Sem_XMM15 : "XMM15"
end

val is-avx-sse id =
  case id of
     Sem_XMM0 : '1'
   | Sem_XMM1 : '1'
   | Sem_XMM2 : '1'
   | Sem_XMM3 : '1'
   | Sem_XMM4 : '1'
   | Sem_XMM5 : '1'
   | Sem_XMM6 : '1'
   | Sem_XMM7 : '1'
   | Sem_XMM8 : '1'
   | Sem_XMM9 : '1'
   | Sem_XMM10 : '1'
   | Sem_XMM11 : '1'
   | Sem_XMM12 : '1'
   | Sem_XMM13 : '1'
   | Sem_XMM14 : '1'
   | Sem_XMM15 : '1'
   | _: '0'
end

type register-without-size =
   A
 | B
 | C
 | D
 | SI_
 | DI_
 | BP_
 | SP_

val high reg =
  case reg of
     A: AH
   | B: BH
   | C: CH
   | D: DH
  end

val low reg =
  case reg of
     A: AL
   | B: BL
   | C: CL
   | D: DL
  end
 

val register-by-size modifier reg-unsized size =
  case reg-unsized of
     A:
       case size of
          8: modifier A
        | 16: AX
        | 32: EAX
        | 64: RAX
       end
   | B:
       case size of
          8: modifier B
        | 16: BX
        | 32: EBX
        | 64: RBX
       end
   | C:
       case size of
          8: modifier C
        | 16: CX
        | 32: ECX
        | 64: RCX
       end
   | D:
       case size of
          8: modifier D
        | 16: DX
        | 32: EDX
        | 64: RDX
       end
   | SI_:
       case size of
          16: SI
        | 32: ESI
        | 64: RSI
       end
   | DI_:
       case size of
          16: DI
        | 32: EDI
        | 64: RDI
       end
   | BP_:
       case size of
          16: BP
        | 32: EBP
        | 64: RBP
       end
   | SP_:
       case size of
          16: SP
        | 32: ESP
        | 64: RSP
       end
  end
