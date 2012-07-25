# vim:filetype=sml:ts=3:sw=3:expandtab

export = pretty

val pretty i = show/instruction i

val show/arity1 x = show/operand x.opnd1
val show/arity2 x = show/operand x.opnd1 +++ ", " +++ show/operand x.opnd2
val show/arity3 x = show/arity2 x +++ ", " +++ show/operand x.opnd3
val show/arity4 x = show/arity3 x +++ ", " +++ show/operand x.opnd4
val show/flow1 x = show/flowoperand x.opnd1
val show/varity x =
   case x of
      VA0: ""
    | VA1 x: show/arity1 x
    | VA2 x: show/arity2 x
    | VA3 x: show/arity3 x
    | VA4 x: show/arity4 x
   end

val -++ a b = a +++ " " +++ b

val show/register r =
   case r of
      AL   : "AL"
    | AH   : "AH"
    | AX   : "AX"
    | EAX  : "EAX"
    | RAX  : "RAX"
    | BL   : "BL"
    | BH   : "BH"
    | BX   : "BX"
    | EBX  : "EBX"
    | RBX  : "RBX"
    | CL   : "CL"
    | CH   : "CH"
    | CX   : "CX"
    | ECX  : "ECX"
    | RCX  : "RCX"
    | DL   : "DL"
    | DH   : "DH"
    | DX   : "DX"
    | EDX  : "EDX"
    | RDX  : "RDX"
    | R8B  : "R8B"
    | R8L  : "R8L"
    | R8D  : "R8D"
    | R8   : "R8"
    | R9B  : "R9B"
    | R9L  : "R9L"
    | R9D  : "R9D"
    | R9   : "R9"
    | R10B : "R10B"
    | R10L : "R10L"
    | R10D : "R10D"
    | R10  : "R10"
    | R11B : "R11B"
    | R11L : "R11L"
    | R11D : "R11D"
    | R11  : "R11"
    | R12B : "R12B"
    | R12L : "R12L"
    | R12D : "R12D"
    | R12  : "R12"
    | R13B : "R13B"
    | R13L : "R13L"
    | R13D : "R13D"
    | R13  : "R13"
    | R14B : "R14B"
    | R14L : "R14L"
    | R14D : "R14D"
    | R14  : "R14"
    | R15B : "R15B"
    | R15L : "R15L"
    | R15D : "R15D"
    | R15  : "R15"
    | SP   : "SP"
    | ESP  : "ESP"
    | RSP  : "RSP"
    | BP   : "BP"
    | EBP  : "EBP"
    | RBP  : "RBP"
    | SI   : "SI"
    | ESI  : "ESI"
    | RSI  : "RSI"
    | DI   : "DI"
    | EDI  : "EDI"
    | RDI  : "RDI"
    | XMM0 : "XMM0"
    | XMM1 : "XMM1"
    | XMM2 : "XMM2"
    | XMM3 : "XMM3"
    | XMM4 : "XMM4"
    | XMM5 : "XMM5"
    | XMM6 : "XMM6"
    | XMM7 : "XMM7"
    | XMM8 : "XMM8"
    | XMM9 : "XMM9"
    | XMM10: "XMM10"
    | XMM11: "XMM11"
    | XMM12: "XMM12"
    | XMM13: "XMM13"
    | XMM14: "XMM14"
    | XMM15: "XMM15"
    | YMM0 : "YMM0"
    | YMM1 : "YMM1"
    | YMM2 : "YMM2"
    | YMM3 : "YMM3"
    | YMM4 : "YMM4"
    | YMM5 : "YMM5"
    | YMM6 : "YMM6"
    | YMM7 : "YMM7"
    | YMM8 : "YMM8"
    | YMM9 : "YMM9"
    | YMM10: "YMM10"
    | YMM11: "YMM11"
    | YMM12: "YMM12"
    | YMM13: "YMM13"
    | YMM14: "YMM14"
    | YMM15: "YMM15"
    | MM0  : "MM0"
    | MM1  : "MM1"
    | MM2  : "MM2"
    | MM3  : "MM3"
    | MM4  : "MM4"
    | MM5  : "MM5"
    | MM6  : "MM6"
    | MM7  : "MM7"
    | MM8  : "MM8"
    | MM9  : "MM9"
    | MM10 : "MM10"
    | MM11 : "MM11"
    | MM12 : "MM12"
    | MM13 : "MM13"
    | MM14 : "MM14"
    | MM15 : "MM15"
    | ES   : "ES"
    | SS   : "SS"
    | DS   : "DS"
    | FS   : "FS"
    | GS   : "GS"
    | CS   : "CS"
    | ST0  : "ST0"
    | ST1  : "ST1"
    | ST2  : "ST2"
    | ST3  : "ST3"
    | ST4  : "ST4"
    | ST5  : "ST5"
    | ST6  : "ST6"
    | ST7  : "ST7"
    | RIP  : "RIP"
   end

val show/memsz sz =
   case sz of
      8  : "BYTE PTR"
    | 16 : "WORD PTR"
    | 32 : "DWORD PTR"
    | 64 : "QWORD PTR"
    | 128: "XMMWORD PTR"
    | 256: "YMMWORD PTR"
    | _: "PTR(" +++ showint sz +++ ")"
   end

val show/segment s = 
   case s of
      DS: ""
    | _: show/register s +++ ":"
   end

val show/scale s = 
   case s of
      '00': ""
    | '01': "2*"
    | '10': "4*"
    | '11': "8*"
   end

val show/operand op =
   case op of
      IMM8 x: showbitvec x
    | IMM16 x: showbitvec x
    | IMM32 x: showbitvec x
    | IMM64 x: showbitvec x
    | REG x: show/register x
    | MEM x: show/memsz x.sz -++ show/segment x.segment +++ "[" +++ show/operand x.opnd +++ "]" 
    | SUM x: show/operand x.a +++ "+" +++ show/operand x.b
    | SCALE x: show/scale x.imm +++ show/operand x.opnd
   end

val show/flowoperand op =
   case op of
      REL8 x: showint (sx x)
    | REL16 x: showint (sx x)
    | REL32 x: showint (sx x)
    | REL64 x: showint (sx x)
    | NEARABS x: show/operand x 
    | FARABS x: show/operand x
   end

val show/instruction insn =
   case insn of
      AAA: "AAA"
    | AAD x: "AAD" -++ show/arity1 x
    | AAM x: "AAM" -++ show/arity1 x
    | AAS: "AAS"
    | ADC x: "ADC" -++ show/arity2 x
    | ADD x: "ADD" -++ show/arity2 x
    | ADDPD x: "ADDPD" -++ show/arity2 x
    | AND x: "AND" -++ show/arity2 x
    | BSF x: "BSF" -++ show/arity2 x
    | BSR x: "BSR" -++ show/arity2 x
    | BSWAP x: "BSWAP" -++ show/arity1 x
    | BT x: "BT" -++ show/arity2 x
    | CALL x: "CALL" -++ show/flow1 x
    | CBW: "CBW"
    | CDQE: "CDQE"
    | CLD: "CLD"
    | CMOVA x: "CMOVA" -++ show/arity2 x
    | CMOVAE x: "CMOVAE" -++ show/arity2 x
    | CMOVB x: "CMOVB" -++ show/arity2 x
    | CMOVBE x: "CMOVBE" -++ show/arity2 x
    | CMOVC x: "CMOVC" -++ show/arity2 x
    | CMOVE x: "CMOVE" -++ show/arity2 x
    | CMOVG x: "CMOVG" -++ show/arity2 x
    | CMOVGE x: "CMOVGE" -++ show/arity2 x
    | CMOVL x: "CMOVL" -++ show/arity2 x
    | CMOVLE x: "CMOVLE" -++ show/arity2 x
    | CMOVNA x: "CMOVNA" -++ show/arity2 x
    | CMOVNAE x: "CMOVNAE" -++ show/arity2 x
    | CMOVNB x: "CMOVNB" -++ show/arity2 x
    | CMOVNBE x: "CMOVNBE" -++ show/arity2 x
    | CMOVNC x: "CMOVNC" -++ show/arity2 x
    | CMOVNE x: "CMOVNE" -++ show/arity2 x
    | CMOVNG x: "CMOVNG" -++ show/arity2 x
    | CMOVNGE x: "CMOVNGE" -++ show/arity2 x
    | CMOVNL x: "CMOVNL" -++ show/arity2 x
    | CMOVNLE x: "CMOVNLE" -++ show/arity2 x
    | CMOVNO x: "CMOVNO" -++ show/arity2 x
    | CMOVNP x: "CMOVNP" -++ show/arity2 x
    | CMOVNS x: "CMOVNS" -++ show/arity2 x
    | CMOVNZ x: "CMOVNZ" -++ show/arity2 x
    | CMOVO x: "CMOVO" -++ show/arity2 x
    | CMOVP x: "CMOVP" -++ show/arity2 x
    | CMOVPE x: "CMOVPE" -++ show/arity2 x
    | CMOVPO x: "CMOVPO" -++ show/arity2 x
    | CMOVS x: "CMOVS" -++ show/arity2 x
    | CMOVZ x: "CMOVZ" -++ show/arity2 x
    | CMP x: "CMP" -++ show/arity2 x
    | CMPSB: "CMPSB"
    | CMPSD: "CMPSD"
    | CMPSQ: "CMPSQ"
    | CMPSW: "CMPSW"
    | CMPXCHG x: "CMPXCHG" -++ show/arity2 x
    | CPUID: "CPUID"
    | CVTPD2PI x: "CVTPD2PI" -++ show/arity2 x
    | CVTSI2SD x: "CVTSI2SD" -++ show/arity2 x
    | CWDE: "CWDE"
    | DEC x: "DEC" -++ show/arity1 x
    | DIV x: "DIV" -++ show/arity1 x
    | DIVSD x: "DIVSD" -++ show/arity1 x
    | FCHS: "FCHS"
    | FCMOVB x: "FCMOVB" -++ show/arity2 x
    | FCMOVBE x: "FCMOVBE" -++ show/arity2 x
    | FCMOVE x: "FCMOVE" -++ show/arity2 x
    | FCMOVNB x: "FCMOVNB" -++ show/arity2 x
    | FCMOVNBE x: "FCMOVNBE" -++ show/arity2 x
    | FCMOVNE x: "FCMOVNE" -++ show/arity2 x
    | FCMOVNU x: "FCMOVNU" -++ show/arity2 x
    | FCMOVU x: "FCMOVU" -++ show/arity2 x
    | FCOMI x: "FCOMI" -++ show/arity2 x
    | FCOMIP x: "FCOMIP" -++ show/arity2 x
    | FLD x: "FLD" -++ show/arity1 x
    | FLD1: "FLD1"
    | FLDCW x: "FLDCW" -++ show/arity1 x
    | FLDENV x: "FLDENV" -++ show/arity1 x
    | FLDL2E: "FLDL2E"
    | FLDL2T: "FLD2T"
    | FLDLG2: "FLDLG2"
    | FLDLN2: "FLDLN2"
    | FLDPI: "FLDPI"
    | FLDZ: "FLDZ"
    | FNSTCW x: "FNSTCW" -++ show/arity1 x
    | FST x: "FST" -++ show/arity1 x
    | FSTCW x: "FSTCW" -++ show/arity1 x
    | FSTP x: "FSTP" -++ show/arity1 x
    | FUCOMI x: "FUCOMI" -++ show/arity1 x
    | FUCOMIP x: "FUCOMIP" -++ show/arity1 x
    | HLT: "HLT"
    | IDIV x: "IDIV" -++ show/arity1 x
    | IMUL x: "IMUL" -++ show/arity1 x
    | INC x: "INC" -++ show/arity1 x
    | JA x: "JA" -++ show/flow1 x
    | JAE x: "JAE" -++ show/flow1 x
    | JB x: "JB" -++ show/flow1 x
    | JBE x: "JBE" -++ show/flow1 x
    | JC x: "JC" -++ show/flow1 x
    | JCXZ x: "JCXZ" -++ show/flow1 x
    | JE x: "JE" -++ show/flow1 x
    | JECXZ x: "JECXZ" -++ show/flow1 x
    | JG x: "JG" -++ show/flow1 x
    | JGE x: "JGE" -++ show/flow1 x
    | JL x: "JL" -++ show/flow1 x
    | JLE x: "JLE" -++ show/flow1 x
    | JMP x: "JMP" -++ show/flow1 x
    | JNA x: "JNA" -++ show/flow1 x
    | JNAE x: "JNAE" -++ show/flow1 x
    | JNB x: "JNB" -++ show/flow1 x
    | JNBE x: "JNBE" -++ show/flow1 x
    | JNC x: "JNC" -++ show/flow1 x
    | JNE x: "JNE" -++ show/flow1 x
    | JNG x: "JNG" -++ show/flow1 x
    | JNGE x: "JNGE" -++ show/flow1 x
    | JNL x: "JNL" -++ show/flow1 x
    | JNLE x: "JNLE" -++ show/flow1 x
    | JNO x: "JNO" -++ show/flow1 x
    | JNP x: "JNP" -++ show/flow1 x
    | JNS x: "JNS" -++ show/flow1 x
    | JNZ x: "JNZ" -++ show/flow1 x
    | JO x: "JO" -++ show/flow1 x
    | JP x: "JP" -++ show/flow1 x
    | JPE x: "JPE" -++ show/flow1 x
    | JPO x: "JPO" -++ show/flow1 x
    | JRCXZ x: "JRCXZ" -++ show/flow1 x
    | JS x: "JS" -++ show/flow1 x
    | JZ x: "JZ" -++ show/flow1 x
    | LDDQU x: "LDDQU" -++ show/arity2 x
    | LEA x: "LEA" -++ show/arity2 x
    | LEAVE: "LEAVE"
    | LFENCE: "LFENCE"
    | MASKMOVDQU x: "MASKMOVDQU" -++ show/arity2 x
    | MASKMOVQ x: "MASKMOVQ" -++ show/arity2 x
    | MAXPD x: "MAXPD" -++ show/arity2 x
    | MAXPS x: "MAXPS" -++ show/arity2 x
    | MAXSD x: "MAXSD" -++ show/arity2 x
    | MAXSS x: "MAXSS" -++ show/arity2 x
    | MFENCE: "MFENCE"
    | MINPD x: "MINPD" -++ show/arity2 x
    | MINPS x: "MINPS" -++ show/arity2 x
    | MINSD x: "MINSD" -++ show/arity2 x
    | MINSS x: "MINSS" -++ show/arity2 x
    | MONITOR: "MONITOR"
    | MOV x: "MOV" -++ show/arity2 x
    | MOVAPD x: "MOVAPD" -++ show/arity2 x
    | MOVAPS x: "MOVAPS" -++ show/arity2 x
    | MOVBE x: "MOVBE" -++ show/arity2 x
    | MOVD x: "MOVD" -++ show/arity2 x
    | MOVDDUP x: "MOVDDUP" -++ show/arity2 x
    | MOVDQ2Q x: "MOVDQ2Q" -++ show/arity2 x
    | MOVDQA x: "MOVDQA" -++ show/arity2 x
    | MOVDQU x: "MOVDQU" -++ show/arity2 x
    | MOVHLPS x: "MOVHLPS" -++ show/arity2 x
    | MOVHPD x: "MOVHPD" -++ show/arity2 x
    | MOVHPS x: "MOVHPS" -++ show/arity2 x
    | MOVLHPS x: "MOVLHPS" -++ show/arity2 x
    | MOVLPD x: "MOVLPD" -++ show/arity2 x
    | MOVLPS x: "MOVLPS" -++ show/arity2 x
    | MOVMSKPD x: "MOVMSKPD" -++ show/arity2 x
    | MOVMSKPS x: "MOVMSKPS" -++ show/arity2 x
    | MOVNTDQ x: "MOVNTDQ" -++ show/arity2 x
    | MOVNTDQA x: "MOVNTDQA" -++ show/arity2 x
    | MOVNTI x: "MOVNTI" -++ show/arity2 x
    | MOVNTPD x: "MOVNTPD" -++ show/arity2 x
    | MOVNTPS x: "MOVNTPS" -++ show/arity2 x
    | MOVNTQ x: "MOVNTQ" -++ show/arity2 x
    | MOVQ x: "MOVQ" -++ show/arity2 x
    | MOVQ2DQ x: "MOVQ2DQ" -++ show/arity2 x
    | MOVSB: "MOVSB"
    | MOVSD x: "MOVSD" -++ show/varity x
    | MOVSHDUP x: "MOVSHDUP" -++ show/arity2 x
    | MOVSLDUP x: "MOVSLDUP" -++ show/arity2 x
    | MOVSQ: "MOVSQ"
    | MOVSS x: "MOVSS" -++ show/arity2 x
    | MOVSW x: "MOVSW" -++ show/arity2 x
    | MOVSX x: "MOVSX" -++ show/arity2 x
    | MOVSXD x: "MOVSXD" -++ show/arity2 x
    | MOVUPD x: "MOVUPD" -++ show/arity2 x
    | MOVUPS x: "MOVUPS" -++ show/arity2 x
    | MOVZX x: "MOVZX" -++ show/arity2 x
    | MPSADBW x: "MPSADBW" -++ show/arity3 x
    | MUL x: "MUL" -++ show/arity1 x
    | MULPD x: "MULPD" -++ show/arity2 x
    | MULPS x: "MULPS" -++ show/arity2 x
    | MULSD x: "MULSD" -++ show/arity2 x
    | MULSS x: "MULSS" -++ show/arity2 x
    | MWAIT: "MWAIT"
    | NEG x: "NEG" -++ show/arity1 x
    | NOP x: "NOP" -++ show/varity x
    | NOT x: "NOT" -++ show/arity1 x
    | OR x: "OR" -++ show/arity2 x
    | ORPD x: "ORPD" -++ show/arity2 x
    | ORPS x: "ORPS" -++ show/arity2 x
    | OUT x: "OUT" -++ show/arity2 x
    | OUTS: "OUTS"
    | OUTSB: "OUTSB"
    | OUTSW: "OUTSW"
    | OUTSD: "OUTSD"
    | PABSB x: "PABSB" -++ show/arity2 x
    | PABSW x: "PABSW" -++ show/arity2 x
    | PABSD x: "PABSD" -++ show/arity2 x
    | PACKSSWB x: "PACKSSWB" -++ show/arity2 x
    | PACKSSDW x: "PACKSSDW" -++ show/arity2 x
    | PACKUSDW x: "PACKUSDW" -++ show/arity2 x
    | PACKUSWB x: "PACKUSWB" -++ show/arity2 x
    | PADDB x: "PADDB" -++ show/arity2 x
    | PADDD x: "PADDD" -++ show/arity2 x
    | PADDW x: "PADDW" -++ show/arity2 x
    | PADDQ x: "PADDQ" -++ show/arity2 x
    | PADDSB x: "PADDSB" -++ show/arity2 x
    | PADDSW x: "PADDSW" -++ show/arity2 x
    | PADDUSB x: "PADDUSB" -++ show/arity2 x
    | PADDUSW x: "PADDUSW" -++ show/arity2 x
    | PALIGNR x: "PALIGNR" -++ show/arity3 x
    | PAND x: "PAND" -++ show/arity2 x
    | PANDN x: "PANDN" -++ show/arity2 x
    | PAUSE: "PAUSE"
    | PAVGB x: "PAVGB" -++ show/arity2 x
    | PAVGW x: "PAVGW" -++ show/arity2 x
    | PBLENDVB x: "PBLENDVB" -++ show/arity2 x
    | PBLENDW x: "PBLENDW" -++ show/arity3 x
    | PCLMULQDQ x: "PCLMULQDQ" -++ show/arity3 x
    | PCMPEQB x: "PCMPEQB" -++ show/arity2 x
    | PCMPEQD x: "PCMPEQD" -++ show/arity2 x
    | PCMPEQQ x: "PCMPEQQ" -++ show/arity2 x
    | PCMPEQW x: "PCMPEQW" -++ show/arity2 x
    | PCMPESTRI x: "PCMPESTRI" -++ show/arity3 x
    | PCMPESTRM x: "PCMPESTRM" -++ show/arity3 x
    | PCMPGRD x: "PCMPGRD" -++ show/arity2 x
    | PCMPGTB x: "PCMPGTB" -++ show/arity2 x
    | PCMPGTD x: "PCMPGTD" -++ show/arity2 x
    | PCMPGTW x: "PCMPGTW" -++ show/arity2 x
    | PCMPGTQ x: "PCMPGTQ" -++ show/arity2 x
    | PCMPISTRI x: "PCMPISTRI" -++ show/arity3 x
    | PCMPISTRM x: "PCMPISTRM" -++ show/arity3 x
    | PEXTRB x: "PEXTRB" -++ show/arity3 x
    | PEXTRD x: "PEXTRD" -++ show/arity3 x
    | PEXTRQ x: "PEXTRQ" -++ show/arity3 x
    | PEXTRW x: "PEXTRW" -++ show/arity3 x
    | PHADDD x: "PHADDD" -++ show/arity2 x
    | PHADDW x: "PHADDW" -++ show/arity2 x
    | PHADDSW x: "PHADDSW" -++ show/arity2 x
    | PHMINPOSUW x: "PHMINPOSUW" -++ show/arity2 x
    | PHSUBW x: "PHSUBW" -++ show/arity2 x
    | PHSUBD x: "PHSUBD" -++ show/arity2 x
    | PHSUBSW x: "PHSUBSW" -++ show/arity2 x
    | PINSRB x: "PINSRB" -++ show/arity3 x
    | PINSRD x: "PINSRD" -++ show/arity3 x
    | PINSRQ x: "PINSRQ" -++ show/arity3 x
    | PINSRW x: "PINSRW" -++ show/arity3 x
    | PMADDUBSW x: "PMADDUBSW" -++ show/arity2 x
    | PMADDWD x: "PMADDWD" -++ show/arity2 x
    | PMAXSB x: "PMAXSB" -++ show/arity2 x
    | PMAXSD x: "PMAXSD" -++ show/arity2 x
    | PMAXSW x: "PMAXSW" -++ show/arity2 x
    | PMAXUB x: "PMAXUB" -++ show/arity2 x
    | PMAXUD x: "PMAXUD" -++ show/arity2 x
    | PMAXUW x: "PMAXUW" -++ show/arity2 x
    | PMINSB x: "PMINSB" -++ show/arity2 x
    | PMINSD x: "PMINSD" -++ show/arity2 x
    | PMINSW x: "PMINSW" -++ show/arity2 x
    | PMINUB x: "PMINUB" -++ show/arity2 x
    | PMINUD x: "PMINUD" -++ show/arity2 x
    | PMINUW x: "PMINUW" -++ show/arity2 x

    | PMOVMSKB x: "PMOVMSKB" -++ show/arity2 x
    | POP x: "POP" -++ show/arity1 x
    | POR x: "POR" -++ show/arity2 x
    | PREFETCHNTA x: "PREFETCHNTA" -++ show/arity1 x
    | PREFETCHT0 x: "PREFETCHT0" -++ show/arity1 x
    | PREFETCHT1 x: "PREFETCHT1" -++ show/arity1 x
    | PREFETCHT2 x: "PREFETCHT2" -++ show/arity1 x
    | PREFETCHW x: "PREFETCHW" -++ show/arity1 x
    | PSHUFB x: "PSHUFB" -++ show/arity2 x
    | PSHUFD x: "PSHUFD" -++ show/arity3 x
    | PSLLDQ x: "PSLLDQ" -++ show/arity2 x
    | PSLRDQ x: "PSLRDQ" -++ show/arity2 x
    | PSRLDQ x: "PSRLDQ" -++ show/arity2 x
    | PSUBB x: "PSUBB" -++ show/arity2 x
    | PSUBD x: "PSUBD" -++ show/arity2 x
    | PSUBW x: "PSUBW" -++ show/arity2 x
    | PTEST x: "PTEST" -++ show/arity2 x
    | PUNPCKLDQ x: "PUNPCKLDQ" -++ show/arity2 x
    | PUNPCKLWD x: "PUNPCKLWD" -++ show/arity2 x
    | PUNPCKLBW x: "PUNPCKLBW" -++ show/arity2 x
    | PUNPCKLQDQ x: "PUNPCKLQDQ" -++ show/arity2 x
    | PUSH x: "PUSH" -++ show/arity1 x
    | PXOR x: "PXOR" -++ show/arity2 x
    | RCL x: "RCL" -++ show/arity2 x
    | RCR x: "RCR" -++ show/arity2 x
    | RDTSC: "RDTSC"
    | RDTSCP: "RDTSCP"
    | RET x: "RET" -++ show/varity x
    | RET_FAR x: "RET_FAR" -++ show/varity x
    | ROL x: "ROL" -++ show/arity2 x
    | ROR x: "ROR" -++ show/arity2 x
    | SAL x: "SAL" -++ show/arity2 x
    | SAR x: "SAR" -++ show/arity2 x
    | SBB x: "SBB" -++ show/arity2 x
    | SCASB: "SACSB"
    | SCASD: "SCASD"
    | SCASQ: "SCASQ"
    | SCASW: "SCASW"
    | SETA x: "SETA" -++ show/arity1 x
    | SETAE x: "SETAE" -++ show/arity1 x
    | SETB x: "SETB" -++ show/arity1 x
    | SETBE x: "SETBE" -++ show/arity1 x
    | SETC x: "SETC" -++ show/arity1 x
    | SETE x: "SETE" -++ show/arity1 x
    | SETG x: "SETG" -++ show/arity1 x
    | SETGE x: "SETGE" -++ show/arity1 x
    | SETL x: "SETL" -++ show/arity1 x
    | SETLE x: "SETLE" -++ show/arity1 x
    | SETNA x: "SETNA" -++ show/arity1 x
    | SETNAE x: "SETNAE" -++ show/arity1 x
    | SETNB x: "SETNB" -++ show/arity1 x
    | SETNBE x: "SETNBE" -++ show/arity1 x
    | SETNC x: "SETNC" -++ show/arity1 x
    | SETNE x: "SETNE" -++ show/arity1 x
    | SETNG x: "SETNG" -++ show/arity1 x
    | SETNGE x: "SETNGE" -++ show/arity1 x
    | SETNL x: "SETNL" -++ show/arity1 x
    | SETNLE x: "SETNLE" -++ show/arity1 x
    | SETNO x: "SETNO" -++ show/arity1 x
    | SETNP x: "SETNP" -++ show/arity1 x
    | SETNS x: "SETNS" -++ show/arity1 x
    | SETNZ x: "SETNZ" -++ show/arity1 x
    | SETO x: "SETO" -++ show/arity1 x
    | SETP x: "SETP" -++ show/arity1 x
    | SETPE x: "SETPE" -++ show/arity1 x
    | SETPO x: "SETPO" -++ show/arity1 x
    | SETS x: "SETS" -++ show/arity1 x
    | SETZ x: "SETZ" -++ show/arity1 x
    | SFENCE: "SFENCE"
    | SHL x: "SHL" -++ show/arity2 x
    | SHLD x: "SHLD" -++ show/arity3 x
    | SHR x: "SHR" -++ show/arity2 x
    | SHRD x: "SHRD" -++ show/arity3 x
    | STOSB: "STOSB"
    | STOSD: "STOSD"
    | STOSQ: "STOSQ"
    | STOSW: "STOSW"
    | SUB x: "SUB" -++ show/arity2 x
    | SYSCALL: "SYSCALL"
    | TEST x: "TEST" -++ show/arity2 x
    | UCOMISD x: "UCOMISD" -++ show/arity2 x
    | UD2: "UD2"
    | VADDPD x: "VADDPD" -++ show/varity x
    | VCMPEQB x: "VCMPEQB" -++ show/varity x
    | VCMPEQD x: "VCMPEQD" -++ show/varity x
    | VCMPEQW x: "VCMPEQW" -++ show/varity x
    | VLDDQU x: "VLDDQU" -++ show/varity x
    | VMASKMOVDQU x: "VMASKMOVDQU" -++ show/varity x
    | VMAXPD x: "VMAXPD" -++ show/varity x
    | VMAXPS x: "VMAXPS" -++ show/varity x
    | VMAXSD x: "VMAXSD" -++ show/varity x
    | VMAXSS x: "VMAXSS" -++ show/varity x
    | VMINPD x: "VMINPD" -++ show/varity x
    | VMINPS x: "VMINPS" -++ show/varity x
    | VMINSD x: "VMINSD" -++ show/varity x
    | VMINSS x: "VMINSS" -++ show/varity x
    | VMOVAPD x: "VMOVAPD" -++ show/varity x
    | VMOVAPS x: "VMOVAPS" -++ show/varity x
    | VMOVD x: "VMOVD" -++ show/varity x
    | VMOVDDUP x: "VMOVDDUP" -++ show/varity x
    | VMOVDQA x: "VMOVDQA" -++ show/varity x
    | VMOVDQU x: "VMOVDQU" -++ show/varity x
    | VMOVHLPS x: "VMOVHLPS" -++ show/varity x
    | VMOVHPD x: "VMOVHPD" -++ show/varity x
    | VMOVHPS x: "VMOVHPS" -++ show/varity x
    | VMOVLHPS x: "VMOVLHPS" -++ show/varity x
    | VMOVLPD x: "VMOVLPD" -++ show/varity x
    | VMOVLPS x: "VMOVLPS" -++ show/varity x
    | VMOVMSKPD x: "VMOVMSKPD" -++ show/varity x
    | VMOVMSKPS x: "VMOVMSKPS" -++ show/varity x
    | VMOVNTDQ x: "VMOVNTDQ" -++ show/varity x
    | VMOVNTDQA x: "VMOVNTDQA" -++ show/varity x
    | VMOVNTPD x: "VMOVNTPD" -++ show/varity x
    | VMOVNTPS x: "VMOVNTPS" -++ show/varity x
    | VMOVQ x: "VMOVQ" -++ show/varity x
    | VMOVSD x: "VMOVSD" -++ show/varity x
    | VMOVSHDUP x: "VMOVSHDUP" -++ show/varity x
    | VMOVSLDUP x: "VMOVSLDUP" -++ show/varity x
    | VMOVSS x: "VMOVSS" -++ show/varity x
    | VMOVUPD x: "VMOVUPD" -++ show/varity x
    | VMOVUPS x: "VMOVUPS" -++ show/varity x
    | VMPSADBW x: "VMPSADBW" -++ show/varity x
    | VMULPD x: "VMULPD" -++ show/varity x
    | VMULPS x: "VMULPS" -++ show/varity x
    | VMULSD x: "VMULSD" -++ show/varity x
    | VMULSS x: "VMULSS" -++ show/varity x
    | VORPD x: "VORPD" -++ show/varity x
    | VORPS x: "VORPS" -++ show/varity x
    | VPABSB x: "VPABSB" -++ show/varity x
    | VPABSW x: "VPABSW" -++ show/varity x
    | VPABSD x: "VPABSD" -++ show/varity x
    | VPACKSSWB x: "VPACKSSWB" -++ show/varity x
    | VPACKSSDW x: "VPACKSSDW" -++ show/varity x
    | VPACKUSDW x: "VPACKUSDW" -++ show/varity x
    | VPACKUSWB x: "VPACKUSWB" -++ show/varity x
    | VPADDB x: "VPADDB" -++ show/varity x
    | VPADDD x: "VPADDD" -++ show/varity x
    | VPADDW x: "VPADDW" -++ show/varity x
    | VPADDQ x: "VPADDQ" -++ show/varity x
    | VPADDSB x: "VPADDSB" -++ show/varity x
    | VPADDSW x: "VPADDSW" -++ show/varity x
    | VPADDUSB x: "VPADDUSB" -++ show/varity x
    | VPADDUSW x: "VPADDUSW" -++ show/varity x
    | VPALIGNR x: "VPALIGNR" -++ show/varity x
    | VPAND x: "VPAND" -++ show/varity x
    | VPANDN x: "VPANDN" -++ show/varity x
    | VPAVGB x: "VPAVGB" -++ show/varity x
    | VPAVGW x: "VPAVGW" -++ show/varity x
    | VPBLENDVB x: "VPBLENDVB" -++ show/varity x
    | VPBLENDW x: "VPBLENDW" -++ show/varity x
    | VPCLMULQDQ x: "VPCLMULQDQ" -++ show/varity x
    | VPCMPEQB x: "VPCMPEQB" -++ show/varity x
    | VPCMPEQW x: "VPCMPEQW" -++ show/varity x
    | VPCMPEQD x: "VPCMPEQD" -++ show/varity x
    | VPCMPEQQ x: "VPCMPEQQ" -++ show/varity x
    | VPCMPESTRI x: "VPCMPESTRI" -++ show/varity x
    | VPCMPESTRM x: "VPCMPESTRM" -++ show/varity x
    | VPCMPGTB x: "VPCMPGTB" -++ show/varity x
    | VPCMPGTD x: "VPCMPGTD" -++ show/varity x
    | VPCMPGTW x: "VPCMPGTW" -++ show/varity x
    | VPCMPGTQ x: "VPCMPGTQ" -++ show/varity x
    | VPCMPISTRI x: "VPCMPISTRI" -++ show/varity x
    | VPCMPISTRM x: "VPCMPISTRM" -++ show/varity x
    | VPEXTRB x: "VPEXTRB" -++ show/varity x
    | VPEXTRD x: "VPEXTRD" -++ show/varity x
    | VPEXTRQ x: "VPEXTRQ" -++ show/varity x
    | VPEXTRW x: "VPEXTRW" -++ show/varity x
    | VPHADDD x: "VPHADDD" -++ show/varity x
    | VPHADDW x: "VPHADDW" -++ show/varity x
    | VPHADDSW x: "VPHADDSW" -++ show/varity x
    | VPHMINPOSUW x: "VPHMINPOSUW" -++ show/varity x
    | VPHSUBW x: "VPHSUBW" -++ show/varity x
    | VPHSUBD x: "VPHSUBD" -++ show/varity x
    | VPHSUBSW x: "VPHSUBSW" -++ show/varity x
    | VPINSRB x: "VPINSRB" -++ show/varity x
    | VPINSRD x: "VPINSRD" -++ show/varity x
    | VPINSRQ x: "VPINSRQ" -++ show/varity x
    | VPINSRW x: "VPINSRW" -++ show/varity x
    | VPMADDUBSW x: "VPMADDUBSW" -++ show/varity x
    | VPMADDWD x: "VPMADDWD" -++ show/varity x
    | VPMAXSB x: "VPMAXSB" -++ show/varity x
    | VPMAXSD x: "VPMAXSD" -++ show/varity x
    | VPMAXSW x: "VPMAXSW" -++ show/varity x
    | VPMAXUB x: "VPMAXUB" -++ show/varity x
    | VPMAXUD x: "VPMAXUD" -++ show/varity x
    | VPMAXUW x: "VPMAXUW" -++ show/varity x
    | VPMINSB x: "VPMINSB" -++ show/varity x
    | VPMINSD x: "VPMINSD" -++ show/varity x
    | VPMINSW x: "VPMINSW" -++ show/varity x
    | VPMINUB x: "VPMINUB" -++ show/varity x
    | VPMINUD x: "VPMINUD" -++ show/varity x
    | VPMINUW x: "VPMINUW" -++ show/varity x

    | VPMOVMSKB x: "VPMOVMSKB" -++ show/varity x
    | VPOR x: "VPOR" -++ show/varity x
    | VPSHUFB x: "VPSHUFB" -++ show/varity x
    | VPSHUFD x: "VPSHUFD" -++ show/varity x
    | VPSLLDQ x: "VPSLLDQ" -++ show/varity x
    | VPSLRDQ x: "VPSLRDQ" -++ show/varity x
    | VPSUBB x: "VPSUBB" -++ show/varity x
    | VPSUBD x: "VPSUBD" -++ show/varity x
    | VPSUBW x: "VPSUBW" -++ show/varity x
    | VPTEST x: "VPTEST" -++ show/varity x
    | VPUNPCKLBW x: "VPUNPCKLBW" -++ show/varity x
    | VPUNPCKLDQ x: "VPUNPCKLDQ" -++ show/varity x
    | VPUNPCKLQDQ x: "VPUNPCKLQDQ" -++ show/varity x
    | VPUNPCKLWD x: "VPUNPCKLWD" -++ show/varity x
    | VUCOMISD x: "VUCOMISD" -++ show/varity x
    | VXORPS x: "VXORPS" -++ show/varity x
    | XADD x: "XADD" -++ show/arity2 x
    | XCHG x: "XCHG" -++ show/arity2 x
    | XGETBV: "XGETBV"
    | XOR x: "XOR" -++ show/arity2 x
    | XORPD x: "XORPD" -++ show/arity2 x
    | XORPS x: "XORPS" -++ show/arity2 x
   end
