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
#    | MM8  : "MM8"
#    | MM9  : "MM9"
#    | MM10 : "MM10"
#    | MM11 : "MM11"
#    | MM12 : "MM12"
#    | MM13 : "MM13"
#    | MM14 : "MM14"
#    | MM15 : "MM15"
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
    | ADDPS x: "ADDPS" -++ show/arity2 x
    | ADDSD x: "ADDSD" -++ show/arity2 x
    | ADDSS x: "ADDSS" -++ show/arity2 x
    | ADDSUBPD x: "ADDSUBPD" -++ show/arity2 x
    | ADDSUBPS x: "ADDSUBPS" -++ show/arity2 x
    | AESDEC x: "AESDEC" -++ show/arity2 x
    | AESDECLAST x: "AESDECLAST" -++ show/arity2 x
    | AESENC x: "AESENC" -++ show/arity2 x
    | AESENCLAST x: "AESENCLAST" -++ show/arity2 x
    | AESIMC x: "AESIMC" -++ show/arity2 x
    | AESKEYGENASSIST x: "AESKEYGENASSIST" -++ show/arity3 x
    | AND x: "AND" -++ show/arity2 x
    | ANDNPD x: "ANDNPD" -++ show/arity2 x
    | ANDNPS x: "ANDNPS" -++ show/arity2 x
    | ANDPD x: "ANDPD" -++ show/arity2 x
    | ANDPS x: "ANDPS" -++ show/arity2 x
    | ARPL x: "ARPL" -++ show/arity2 x
    | BLENDPD x: "BLENDPD" -++ show/arity3 x
    | BLENDPS x: "BLENDPS" -++ show/arity3 x
    | BLENDVPD x: "BLENDVPD" -++ show/arity3 x
    | BLENDVPS x: "BLENDVPS" -++ show/arity3 x
    | BOUND x: "BOUND" -++ show/arity2 x
    | BSF x: "BSF" -++ show/arity2 x
    | BSR x: "BSR" -++ show/arity2 x
    | BSWAP x: "BSWAP" -++ show/arity1 x
    | BT x: "BT" -++ show/arity2 x
    | BTC x: "BTC" -++ show/arity2 x
    | BTR x: "BTR" -++ show/arity2 x
    | BTS x: "BTS" -++ show/arity2 x
    | CALL x: "CALL" -++ show/flow1 x
    | CBW: "CBW"
    | CDQ: "CDQ"
    | CDQE: "CDQE"
    | CLC: "CLC"
    | CLD: "CLD"
    | CLFLUSH x: "CLFLUSH" -++ show/arity1 x
    | CLI: "CLI"
    | CLTS: "CLTS"
    | CMC: "CMC"
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
    | CMPPD x: "CMPPD" -++ show/arity3 x
    | CMPPS x: "CMPPS" -++ show/arity3 x
    | CMPS x: "CMPS" -++ show/arity2
    | CMPSD x: "CMPSD" -++ show/arity3 x
    | CMPSS x: "CMPSS" -++ show/arity3 x
    | CMPXCHG x: "CMPXCHG" -++ show/arity2 x
    | CMPXCHG16B x: "CMPXCHG16B" -++ show/arity1 x
    | CMPXCHG8B x: "CMPXCHG8B" -++ show/arity1 x
    | COMISD x: "COMISD" -++ show/arity2 x
    | COMISS x: "COMISS" -++ show/arity2 x
    | CPUID: "CPUID"
    | CQO: "CQO"
    | CRC32 x: "CRC32" -++ show/arity2 x
    | CVTDQ2PD x: "CVTDQ2PD" -++ show/arity2 x
    | CVTDQ2PS x: "CVTDQ2PS" -++ show/arity2 x
    | CVTPD2DQ x: "CVTPD2DQ" -++ show/arity2 x
    | CVTPD2PI x: "CVTPD2PI" -++ show/arity2 x
    | CVTPD2PS x: "CVTPD2PS" -++ show/arity2 x
    | CVTPI2PD x: "CVTPI2PD" -++ show/arity2 x
    | CVTPI2PS x: "CVTPI2PS" -++ show/arity2 x
    | CVTPS2DQ x: "CVTPS2DQ" -++ show/arity2 x
    | CVTPS2PD x: "CVTPS2PD" -++ show/arity2 x
    | CVTPS2PI x: "CVTPS2PI" -++ show/arity2 x
    | CVTSD2SI x: "CVTSD2SI" -++ show/arity2 x
    | CVTSD2SS x: "CVTSD2SS" -++ show/arity2 x
    | CVTSI2SD x: "CVTSI2SD" -++ show/arity2 x
    | CVTSI2SS x: "CVTSI2SS" -++ show/arity2 x
    | CVTSS2SD x: "CVTSS2SD" -++ show/arity2 x
    | CVTSS2SI x: "CVTSS2SI" -++ show/arity2 x
    | CVTTPD2DQ x: "CVTTPD2DQ" -++ show/arity2 x
    | CVTTPD2PI x: "CVTTPD2PI" -++ show/arity2 x
    | CVTTPS2DQ x: "CVTTPS2DQ" -++ show/arity2 x
    | CVTTPS2PI x: "CVTTPS2PI" -++ show/arity2 x
    | CVTTSD2SI x: "CVTTSD2SI" -++ show/arity2 x
    | CVTTSS2SI x: "CVTTSS2SI" -++ show/arity2 x
    | CWD: "CWD"
    | CWDE: "CWDE"
    | DAA: "DAA"
    | DAS: "DAS"
    | DEC x: "DEC" -++ show/arity1 x
    | DIV x: "DIV" -++ show/arity1 x
    | DIVPD x: "DIVPD" -++ show/arity2 x
    | DIVPS x: "DIVPS" -++ show/arity2 x
    | DIVSD x: "DIVSD" -++ show/arity2 x
    | DIVSS x: "DIVSS" -++ show/arity2 x
    | DPPD x: "DPPD" -++ show/arity3 x
    | DPPS x: "DPPS" -++ show/arity3 x
    | EMMS: "EMMS"
    | ENTER x: "ENTER" -++ show/arity2 x
    | EXTRACTPS x: "EXTRACTPS" -++ show/arity3 x
    | F2XM1: "F2XM1"
    | FABS: "FABS"
    | FADD x: "FADD" -++ show/arity2 x
    | FADDP x: "FADDP" -++ show/arity2 x
    | FBLD x: "FBLD" -++ show/arity1 x
    | FBSTP x: "FBSTP" -++ show/arity1 x
    | FCHS: "FCHS"
    | FCLEX: "FCLEX"
    | FCMOVB x: "FCMOVB" -++ show/arity2 x
    | FCMOVBE x: "FCMOVBE" -++ show/arity2 x
    | FCMOVE x: "FCMOVE" -++ show/arity2 x
    | FCMOVNB x: "FCMOVNB" -++ show/arity2 x
    | FCMOVNBE x: "FCMOVNBE" -++ show/arity2 x
    | FCMOVNE x: "FCMOVNE" -++ show/arity2 x
    | FCMOVNU x: "FCMOVNU" -++ show/arity2 x
    | FCMOVU x: "FCMOVU" -++ show/arity2 x
    | FCOM x: "FCOM" -++ show/arity1 x
    | FCOMI x: "FCOMI" -++ show/arity2 x
    | FCOMIP x: "FCOMIP" -++ show/arity2 x
    | FCOMP x: "FCOMP" -++ show/arity1 x
    | FCOMPP: "FCOMPP"
    | FCOS: "FCOS"
    | FDECSTP: "FDECSTP"
    | FDIV x: "FDIV" -++ show/arity2 x
    | FDIVP x: "FDIVP" -++ show/arity2 x
    | FDIVR x: "FDIVR" -++ show/arity2 x
    | FDIVRP x: "FDIVRP" -++ show/arity2 x
    | FFREE x: "FFREE" -++ show/arity1 x
    | FIADD x: "FIADD" -++ show/arity1 x
    | FICOM x: "FICOM" -++ show/arity1 x
    | FICOMP x: "FICOMP" -++ show/arity1 x
    | FIDIV x: "FIDIV" -++ show/arity2 x
    | FIDIVR x: "FIDIVR" -++ show/arity1 x
    | FILD x: "FILD" -++ show/arity1 x
    | FIMUL x: "FIMUL" -++ show/arity1 x
    | FINCSTP: "FINCSTP"
    | FINIT: "FINIT"
    | FIST x: "FIST" -++ show/arity1 x
    | FISTP x: "FISTP" -++ show/arity1 x
    | FISTTP x: "FISTTP" -++ show/arity1 x
    | FISUB x: "FISUB" -++ show/arity1 x
    | FISUBR x: "FISUBR" -++ show/arity1 x
    | FLD x: "FLD" -++ show/arity1 x
    | FLD1: "FLD1"
    | FLDCW x: "FLDCW" -++ show/arity1 x
    | FLDENV x: "FLDENV" -++ show/arity1 x
    | FLDL2E: "FLDL2E"
    | FLDL2T: "FLDL2T"
    | FLDLG2: "FLDLG2"
    | FLDLN2: "FLDLN2"
    | FLDPI: "FLDPI"
    | FLDZ: "FLDZ"
    | FMUL x: "FMUL" -++ show/arity2 x
    | FMULP x: "FMULP" -++ show/arity2 x
    | FNCLEX: "FNCLEX"
    | FNINIT: "FNINIT"
    | FNOP: "FNOP"
    | FNSAVE x: "FNSAVE" -++ show/arity1 x
    | FNSTCW x: "FNSTCW" -++ show/arity1 x
    | FNSTENV x: "FNSTENV" -++ show/arity1 x
    | FNSTSW x: "FNSTSW" -++ show/arity1 x
    | FPATAN: "FPATAN"
    | FPREM1: "FPREM1"
    | FPREM: "FPREM"
    | FPTAN: "FPTAN"
    | FRNDINT: "FRNDINT"
    | FRSTOR x: "FRSTOR" -++ show/arity1 x
    | FSAVE x: "FSAVE" -++ show/arity1 x
    | FSCALE: "FSCALE"
    | FSIN: "FSIN"
    | FSINCOS: "FSINCOS"
    | FSQRT: "FSQRT"
    | FST x: "FST" -++ show/arity1 x
    | FSTCW x: "FSTCW" -++ show/arity1 x
    | FSTENV x: "FSTENV" -++ show/arity1 x
    | FSTP x: "FSTP" -++ show/arity1 x
    | FSTSW x: "FSTSW" -++ show/arity1 x
    | FSUB x: "FSUB" -++ show/arity2 x
    | FSUBP x: "FSUBP" -++ show/arity2 x
    | FSUBR x: "FSUBR" -++ show/arity2 x
    | FSUBRP x: "FSUBRP" -++ show/arity2 x
    | FTST: "FTST"
    | FUCOM x: "FUCOM" -++ show/arity1 x
    | FUCOMI x: "FUCOMI" -++ show/arity1 x
    | FUCOMIP x: "FUCOMIP" -++ show/arity1 x
    | FUCOMP x: "FUCOMP" -++ show/arity1 x
    | FUCOMPP: "FUCOMPP"
    | FXAM: "FXAM"
    | FXCH x: "FXCH" -++ show/arity1 x
    | FXRSTOR x: "FXRSTOR" -++ show/arity1 x
    | FXRSTOR64 x: "FXRSTOR64" -++ show/arity1 x
    | FXSAVE x: "FXSAVE" -++ show/arity1 x
    | FXSAVE64 x: "FXSAVE64" -++ show/arity1 x
    | FXTRACT: "FXTRACT"
    | FYL2X: "FYL2X"
    | FYL2XP1: "FYL2XP1"
    | HADDPD x: "HADDPD" -++ show/arity2 x
    | HADDPS x: "HADDPS" -++ show/arity2 x
    | HLT: "HLT"
    | HSUBPD x: "HSUBPD" -++ show/arity2 x
    | HSUBPS x: "HSUBPS" -++ show/arity2 x
    | IDIV x: "IDIV" -++ show/arity1 x
    | IMUL x: "IMUL" -++ show/varity x
    | IN x: "IN" -++ show/arity2 x
    | INC x: "INC" -++ show/arity1 x
    | INSB: "INSB"
    | INSD: "INSD"
    | INSERTPS x: "INSERTPS" -++ show/arity3 x
    | INSW: "INSW"
    | INT x: "INT" -++ show/arity1 x
    | INT0: "INT0"
    | INT3: "INT3"
    | INVD: "INVD"
    | INVLPG x: "INVLPG" -++ show/arity1 x
    | INVPCID x: "INVPCID" -++ show/arity2 x
    | IRET: "IRET"
    | IRETD: "IRETD"
    | IRETQ: "IRETQ"
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
    | LAHF: "LAHF"
    | LAR x: "LAR" -++ show/arity2 x
    | LDDQU x: "LDDQU" -++ show/arity2 x
    | LDMXCSR x: "LDMXCSR" -++ show/arity1 x
    | LDS x: "LDS" -++ show/arity2 x
    | LEA x: "LEA" -++ show/arity2 x
    | LEAVE: "LEAVE"
    | LES x: "LES" -++ show/arity2 x
    | LFENCE: "LFENCE"
    | LFS x: "LFS" -++ show/arity2 x
    | LGDT x: "LGDT" -++ show/arity1 x
    | LGS x: "LGS" -++ show/arity2 x
    | LIDT x: "LIDT" -++ show/arity1 x
    | LLDT x: "LLDT" -++ show/arity1 x
    | LMSW x: "LMSW" -++ show/arity1 x
    | LODS x: "LODS" -++ show/arity1 x
    | LOOP x: "LOOP" -++ show/flow1 x
    | LOOPE x: "LOOPE" -++ show/flow1 x
    | LOOPNE x: "LOOPNE" -++ show/flow1 x
    | LSL x: "LSL" -++ show/arity2 x
    | LSS x: "LSS" -++ show/arity2 x
    | LTR x: "LTR" -++ show/arity1 x
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
    | MOVS x: "MOVS" -++ show/arity2 x
    | MOVSD x: "MOVSD" -++ show/arity2 x
    | MOVSHDUP x: "MOVSHDUP" -++ show/arity2 x
    | MOVSLDUP x: "MOVSLDUP" -++ show/arity2 x
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
    | OUTSD: "OUTSD"
    | OUTSW: "OUTSW"
    | PABSB x: "PABSB" -++ show/arity2 x
    | PABSD x: "PABSD" -++ show/arity2 x
    | PABSW x: "PABSW" -++ show/arity2 x
    | PACKSSDW x: "PACKSSDW" -++ show/arity2 x
    | PACKSSWB x: "PACKSSWB" -++ show/arity2 x
    | PACKUSDW x: "PACKUSDW" -++ show/arity2 x
    | PACKUSWB x: "PACKUSWB" -++ show/arity2 x
    | PADDB x: "PADDB" -++ show/arity2 x
    | PADDD x: "PADDD" -++ show/arity2 x
    | PADDQ x: "PADDQ" -++ show/arity2 x
    | PADDSB x: "PADDSB" -++ show/arity2 x
    | PADDSW x: "PADDSW" -++ show/arity2 x
    | PADDUSB x: "PADDUSB" -++ show/arity2 x
    | PADDUSW x: "PADDUSW" -++ show/arity2 x
    | PADDW x: "PADDW" -++ show/arity2 x
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
    | PCMPGTQ x: "PCMPGTQ" -++ show/arity2 x
    | PCMPGTW x: "PCMPGTW" -++ show/arity2 x
    | PCMPISTRI x: "PCMPISTRI" -++ show/arity3 x
    | PCMPISTRM x: "PCMPISTRM" -++ show/arity3 x
    | PEXTRB x: "PEXTRB" -++ show/arity3 x
    | PEXTRD x: "PEXTRD" -++ show/arity3 x
    | PEXTRQ x: "PEXTRQ" -++ show/arity3 x
    | PEXTRW x: "PEXTRW" -++ show/arity3 x
    | PHADDD x: "PHADDD" -++ show/arity2 x
    | PHADDSW x: "PHADDSW" -++ show/arity2 x
    | PHADDW x: "PHADDW" -++ show/arity2 x
    | PHMINPOSUW x: "PHMINPOSUW" -++ show/arity2 x
    | PHSUBD x: "PHSUBD" -++ show/arity2 x
    | PHSUBSW x: "PHSUBSW" -++ show/arity2 x
    | PHSUBW x: "PHSUBW" -++ show/arity2 x
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
    | PMOVSXBD x: "PMOVSXBD" -++ show/arity2 x
    | PMOVSXBQ x: "PMOVSXBQ" -++ show/arity2 x
    | PMOVSXBW x: "PMOVSXBW" -++ show/arity2 x
    | PMOVSXDQ x: "PMOVSXDQ" -++ show/arity2 x
    | PMOVSXWD x: "PMOVSXWD" -++ show/arity2 x
    | PMOVSXWQ x: "PMOVSXWQ" -++ show/arity2 x
    | PMOVZXBD x: "PMOVZXBD" -++ show/arity2 x
    | PMOVZXBQ x: "PMOVZXBQ" -++ show/arity2 x
    | PMOVZXBW x: "PMOVZXBW" -++ show/arity2 x
    | PMOVZXDQ x: "PMOVZXDQ" -++ show/arity2 x
    | PMOVZXWD x: "PMOVZXWD" -++ show/arity2 x
    | PMOVZXWQ x: "PMOVZXWQ" -++ show/arity2 x
    | PMULDQ x: "PMULDQ" -++ show/arity2 x
    | PMULHRSW x: "PMULHRSW" -++ show/arity2 x
    | PMULHUW x: "PMULHUW" -++ show/arity2 x
    | PMULHW x: "PMULHW" -++ show/arity2 x
    | PMULLD x: "PMULLD" -++ show/arity2 x
    | PMULLW x: "PMULLW" -++ show/arity2 x
    | PMULUDQ x: "PMULUDQ" -++ show/arity2 x
    | POP x: "POP" -++ show/arity1 x
    | POPA: "POPA"
    | POPAD: "POPAD"
    | POPCNT x: "POPCNT" -++ show/arity2 x
    | POPF: "POPF"
    | POPFD: "POPFD"
    | POPFQ: "POPFQ"
    | POR x: "POR" -++ show/arity2 x
    | PREFETCHNTA x: "PREFETCHNTA" -++ show/arity1 x
    | PREFETCHT0 x: "PREFETCHT0" -++ show/arity1 x
    | PREFETCHT1 x: "PREFETCHT1" -++ show/arity1 x
    | PREFETCHT2 x: "PREFETCHT2" -++ show/arity1 x
    | PREFETCHW x: "PREFETCHW" -++ show/arity1 x
    | PSADBW x: "PSADBW" -++ show/arity2 x
    | PSHUFB x: "PSHUFB" -++ show/arity2 x
    | PSHUFD x: "PSHUFD" -++ show/arity3 x
    | PSHUFHW x: "PSHUFHW" -++ show/arity3 x
    | PSHUFLW x: "PSHUFLW" -++ show/arity3 x
    | PSHUFW x: "PSHUFW" -++ show/arity3 x
    | PSIGNB x: "PSIGNB" -++ show/arity2 x
    | PSIGND x: "PSIGND" -++ show/arity2 x
    | PSIGNW x: "PSIGNW" -++ show/arity2 x
    | PSLLD x: "PSLLD" -++ show/arity2 x
    | PSLLDQ x: "PSLLDQ" -++ show/arity2 x
    | PSLLQ x: "PSLLQ" -++ show/arity2 x
    | PSLLW x: "PSLLW" -++ show/arity2 x
    | PSRAD x: "PSRAD" -++ show/arity2 x
    | PSRAW x: "PSRAW" -++ show/arity2 x
    | PSRLD x: "PSRLD" -++ show/arity2 x
    | PSRLDQ x: "PSRLDQ" -++ show/arity2 x
    | PSRLQ x: "PSRLQ" -++ show/arity2 x
    | PSRLW x: "PSRLW" -++ show/arity2 x
    | PSUBB x: "PSUBB" -++ show/arity2 x
    | PSUBD x: "PSUBD" -++ show/arity2 x
    | PSUBQ x: "PSUBQ" -++ show/arity2 x
    | PSUBSB x: "PSUBSB" -++ show/arity2 x
    | PSUBSW x: "PSUBSW" -++ show/arity2 x
    | PSUBUSB x: "PSUBUSB" -++ show/arity2 x
    | PSUBUSW x: "PSUBUSW" -++ show/arity2 x
    | PSUBW x: "PSUBW" -++ show/arity2 x
    | PTEST x: "PTEST" -++ show/arity2 x
    | PUNPCKHBW x: "PUNPCKHBW" -++ show/arity2 x
    | PUNPCKHDQ x: "PUNPCKHDQ" -++ show/arity2 x
    | PUNPCKHQDQ x: "PUNPCKHQDQ" -++ show/arity2 x
    | PUNPCKHWD x: "PUNPCKHWD" -++ show/arity2 x
    | PUNPCKLBW x: "PUNPCKLBW" -++ show/arity2 x
    | PUNPCKLDQ x: "PUNPCKLDQ" -++ show/arity2 x
    | PUNPCKLQDQ x: "PUNPCKLQDQ" -++ show/arity2 x
    | PUNPCKLWD x: "PUNPCKLWD" -++ show/arity2 x
    | PUSH x: "PUSH" -++ show/arity1 x
    | PUSHA: "PUSHA"
    | PUSHAD: "PUSHAD"
    | PUSHF: "PUSHF"
    | PUSHFD: "PUSHFD"
    | PUSHFQ: "PUSHFQ"
    | PXOR x: "PXOR" -++ show/arity2 x
    | RCL x: "RCL" -++ show/arity2 x
    | RCPPS x: "RCPPS" -++ show/arity2 x
    | RCPSS x: "RCPSS" -++ show/arity2 x
    | RCR x: "RCR" -++ show/arity2 x
    | RDFSBASE x: "RDFSBASE" -++ show/arity1 x
    | RDGSBASE x: "RDGSBASE" -++ show/arity1 x
    | RDMSR: "RDMSR"
    | RDPMC: "RDPMC"
    | RDRAND x: "RDRAND" -++ show/arity1 x
    | RDTSC: "RDTSC"
    | RDTSCP: "RDTSCP"
    | RET x: "RET" -++ show/varity x
    | RET_FAR x: "RET_FAR" -++ show/varity x
    | ROL x: "ROL" -++ show/arity2 x
    | ROR x: "ROR" -++ show/arity2 x
    | ROUNDPD x: "ROUNDPD" -++ show/arity3 x
    | ROUNDPS x: "ROUNDPS" -++ show/arity3 x
    | ROUNDSD x: "ROUNDSD" -++ show/arity3 x
    | ROUNDSS x: "ROUNDSS" -++ show/arity3 x
    | RSM: "RSM"
    | RSQRTPS x: "RSQRTPS" -++ show/arity2 x
    | RSQRTSS x: "RSQRTSS" -++ show/arity2 x
    | SAHF: "SAHF"
    | SAL x: "SAL" -++ show/arity2 x
    | SAR x: "SAR" -++ show/arity2 x
    | SBB x: "SBB" -++ show/arity2 x
    | SCASB: "SCASB"
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
    | SGDT x: "SGDT" -++ show/arity1 x
    | SHL x: "SHL" -++ show/arity2 x
    | SHLD x: "SHLD" -++ show/arity3 x
    | SHR x: "SHR" -++ show/arity2 x
    | SHRD x: "SHRD" -++ show/arity3 x
    | SHUFPD x: "SHUFPD" -++ show/arity3 x
    | SHUFPS x: "SHUFPS" -++ show/arity3 x
    | SIDT x: "SIDT" -++ show/arity1 x
    | SLDT x: "SLDT" -++ show/arity1 x
    | SMSW x: "SMSW" -++ show/arity1 x
    | SQRTPD x: "SQRTPD" -++ show/arity2 x
    | SQRTPS x: "SQRTPS" -++ show/arity2 x
    | SQRTSD x: "SQRTSD" -++ show/arity2 x
    | SQRTSS x: "SQRTSS" -++ show/arity2 x
    | STC: "STC"
    | STD: "STD"
    | STI: "STI"
    | STMXCSR x: "STMXCSR" -++ show/arity1 x
    | STOSB: "STOSB"
    | STOSD: "STOSD"
    | STOSQ: "STOSQ"
    | STOSW: "STOSW"
    | STR x: "STR" -++ show/arity1 x
    | SUB x: "SUB" -++ show/arity2 x
    | SUBPD x: "SUBPD" -++ show/arity2 x
    | SUBPS x: "SUBPS" -++ show/arity2 x
    | SUBSD x: "SUBSD" -++ show/arity2 x
    | SUBSS x: "SUBSS" -++ show/arity2 x
    | SWAPGS: "SWAPGS"
    | SYSCALL: "SYSCALL"
    | SYSENTER: "SYSENTER"
    | SYSEXIT: "SYSEXIT"
    | SYSRET: "SYSRET"
    | TEST x: "TEST" -++ show/arity2 x
    | UCOMISD x: "UCOMISD" -++ show/arity2 x
    | UCOMISS x: "UCOMISS" -++ show/arity2 x
    | UD2: "UD2"
    | UNPCKHPD x: "UNPCKHPD" -++ show/arity2 x
    | UNPCKHPS x: "UNPCKHPS" -++ show/arity2 x
    | UNPCKLPD x: "UNPCKLPD" -++ show/arity2 x
    | UNPCKLPS x: "UNPCKLPS" -++ show/arity2 x
    | VADDPD x: "VADDPD" -++ show/varity x
    | VADDPS x: "VADDPS" -++ show/varity x
    | VADDSD x: "VADDSD" -++ show/varity x
    | VADDSS x: "VADDSS" -++ show/varity x
    | VADDSUBPD x: "VADDSUBPD" -++ show/varity x
    | VADDSUBPS x: "VADDSUBPS" -++ show/varity x
    | VAESDEC x: "VAESDEC" -++ show/varity x
    | VAESDECLAST x: "VAESDECLAST" -++ show/varity x
    | VAESENC x: "VAESENC" -++ show/varity x
    | VAESENCLAST x: "VAESENCLAST" -++ show/varity x
    | VAESIMC x: "VAESIMC" -++ show/varity x
    | VAESKEYGENASSIST x: "VAESKEYGENASSIST" -++ show/varity x
    | VANDNPD x: "VANDNPD" -++ show/varity x
    | VANDNPS x: "VANDNPS" -++ show/varity x
    | VANDPD x: "VANDPD" -++ show/varity x
    | VANDPS x: "VANDPS" -++ show/varity x
    | VBLENDPD x: "VBLENDPD" -++ show/varity x
    | VBLENDPS x: "VBLENDPS" -++ show/varity x
    | VBLENDVPD x: "VBLENDVPD" -++ show/varity x
    | VBLENDVPS x: "VBLENDVPS" -++ show/varity x
    | VBROADCASTF128 x: "VBROADCASTF128" -++ show/varity x
    | VBROADCASTSD x: "VBROADCASTSD" -++ show/varity x
    | VBROADCASTSS x: "VBROADCASTSS" -++ show/varity x
    | VCMPEQB x: "VCMPEQB" -++ show/varity x
    | VCMPEQD x: "VCMPEQD" -++ show/varity x
    | VCMPEQW x: "VCMPEQW" -++ show/varity x
    | VCMPPD x: "VCMPPD" -++ show/varity x
    | VCMPPS x: "VCMPPS" -++ show/varity x
    | VCMPSD x: "VCMPSD" -++ show/varity x
    | VCMPSS x: "VCMPSS" -++ show/varity x
    | VCOMISD x: "VCOMISD" -++ show/varity x
    | VCOMISS x: "VCOMISS" -++ show/varity x
    | VCVTDQ2PD x: "VCVTDQ2PD" -++ show/varity x
    | VCVTDQ2PS x: "VCVTDQ2PS" -++ show/varity x
    | VCVTPD2DQ x: "VCVTPD2DQ" -++ show/varity x
    | VCVTPD2PS x: "VCVTPD2PS" -++ show/varity x
    | VCVTPH2PS x: "VCVTPH2PS" -++ show/varity x
    | VCVTPS2DQ x: "VCVTPS2DQ" -++ show/varity x
    | VCVTPS2PD x: "VCVTPS2PD" -++ show/varity x
    | VCVTPS2PH x: "VCVTPS2PH" -++ show/varity x
    | VCVTSD2SI x: "VCVTSD2SI" -++ show/varity x
    | VCVTSD2SS x: "VCVTSD2SS" -++ show/varity x
    | VCVTSI2SD x: "VCVTSI2SD" -++ show/varity x
    | VCVTSI2SS x: "VCVTSI2SS" -++ show/varity x
    | VCVTSS2SD x: "VCVTSS2SD" -++ show/varity x
    | VCVTSS2SI x: "VCVTSS2SI" -++ show/varity x
    | VCVTTPD2DQ x: "VCVTTPD2DQ" -++ show/varity x
    | VCVTTPS2DQ x: "VCVTTPS2DQ" -++ show/varity x
    | VCVTTSD2SI x: "VCVTTSD2SI" -++ show/varity x
    | VCVTTSS2SI x: "VCVTTSS2SI" -++ show/varity x
    | VDIVPD x: "VDIVPD" -++ show/varity x
    | VDIVPS x: "VDIVPS" -++ show/varity x
    | VDIVSD x: "VDIVSD" -++ show/varity x
    | VDIVSS x: "VDIVSS" -++ show/varity x
    | VDPPD x: "VDPPD" -++ show/varity x
    | VDPPS x: "VDPPS" -++ show/varity x
    | VERR x: "VERR" -++ show/arity1 x
    | VERW x: "VERW" -++ show/arity1 x
    | VEXTRACTF128 x: "VEXTRACTF128" -++ show/varity x
    | VEXTRACTPS x: "VEXTRACTPS" -++ show/varity x
    | VHADDPD x: "VHADDPD" -++ show/varity x
    | VHADDPS x: "VHADDPS" -++ show/varity x
    | VHSUBPD x: "VHSUBPD" -++ show/varity x
    | VHSUBPS x: "VHSUBPS" -++ show/varity x
    | VINSERTF128 x: "VINSERTF128" -++ show/varity x
    | VINSERTPS x: "VINSERTPS" -++ show/varity x
    | VLDDQU x: "VLDDQU" -++ show/varity x
    | VLDMXCSR x: "VLDMXCSR" -++ show/varity x
    | VMASKMOVDQU x: "VMASKMOVDQU" -++ show/varity x
    | VMASKMOVPD x: "VMASKMOVPD" -++ show/varity x
    | VMASKMOVPS x: "VMASKMOVPS" -++ show/varity x
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
    | VPABSD x: "VPABSD" -++ show/varity x
    | VPABSW x: "VPABSW" -++ show/varity x
    | VPACKSSDW x: "VPACKSSDW" -++ show/varity x
    | VPACKSSWB x: "VPACKSSWB" -++ show/varity x
    | VPACKUSDW x: "VPACKUSDW" -++ show/varity x
    | VPACKUSWB x: "VPACKUSWB" -++ show/varity x
    | VPADDB x: "VPADDB" -++ show/varity x
    | VPADDD x: "VPADDD" -++ show/varity x
    | VPADDQ x: "VPADDQ" -++ show/varity x
    | VPADDSB x: "VPADDSB" -++ show/varity x
    | VPADDSW x: "VPADDSW" -++ show/varity x
    | VPADDUSB x: "VPADDUSB" -++ show/varity x
    | VPADDUSW x: "VPADDUSW" -++ show/varity x
    | VPADDW x: "VPADDW" -++ show/varity x
    | VPALIGNR x: "VPALIGNR" -++ show/varity x
    | VPAND x: "VPAND" -++ show/varity x
    | VPANDN x: "VPANDN" -++ show/varity x
    | VPAVGB x: "VPAVGB" -++ show/varity x
    | VPAVGW x: "VPAVGW" -++ show/varity x
    | VPBLENDVB x: "VPBLENDVB" -++ show/varity x
    | VPBLENDW x: "VPBLENDW" -++ show/varity x
    | VPCLMULQDQ x: "VPCLMULQDQ" -++ show/varity x
    | VPCMPEQB x: "VPCMPEQB" -++ show/varity x
    | VPCMPEQD x: "VPCMPEQD" -++ show/varity x
    | VPCMPEQQ x: "VPCMPEQQ" -++ show/varity x
    | VPCMPEQW x: "VPCMPEQW" -++ show/varity x
    | VPCMPESTRI x: "VPCMPESTRI" -++ show/varity x
    | VPCMPESTRM x: "VPCMPESTRM" -++ show/varity x
    | VPCMPGTB x: "VPCMPGTB" -++ show/varity x
    | VPCMPGTD x: "VPCMPGTD" -++ show/varity x
    | VPCMPGTQ x: "VPCMPGTQ" -++ show/varity x
    | VPCMPGTW x: "VPCMPGTW" -++ show/varity x
    | VPCMPISTRI x: "VPCMPISTRI" -++ show/varity x
    | VPCMPISTRM x: "VPCMPISTRM" -++ show/varity x
    | VPERM2F128 x: "VPERM2F128" -++ show/varity x
    | VPERMILPD x: "VPERMILPD" -++ show/varity x
    | VPERMILPS x: "VPERMILPS" -++ show/varity x
    | VPEXTRB x: "VPEXTRB" -++ show/varity x
    | VPEXTRD x: "VPEXTRD" -++ show/varity x
    | VPEXTRQ x: "VPEXTRQ" -++ show/varity x
    | VPEXTRW x: "VPEXTRW" -++ show/varity x
    | VPHADDD x: "VPHADDD" -++ show/varity x
    | VPHADDSW x: "VPHADDSW" -++ show/varity x
    | VPHADDW x: "VPHADDW" -++ show/varity x
    | VPHMINPOSUW x: "VPHMINPOSUW" -++ show/varity x
    | VPHSUBD x: "VPHSUBD" -++ show/varity x
    | VPHSUBSW x: "VPHSUBSW" -++ show/varity x
    | VPHSUBW x: "VPHSUBW" -++ show/varity x
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
    | VPMOVSXBD x: "VPMOVSXBD" -++ show/varity x
    | VPMOVSXBQ x: "VPMOVSXBQ" -++ show/varity x
    | VPMOVSXBW x: "VPMOVSXBW" -++ show/varity x
    | VPMOVSXDQ x: "VPMOVSXDQ" -++ show/varity x
    | VPMOVSXWD x: "VPMOVSXWD" -++ show/varity x
    | VPMOVSXWQ x: "VPMOVSXWQ" -++ show/varity x
    | VPMOVZXBD x: "VPMOVZXBD" -++ show/varity x
    | VPMOVZXBQ x: "VPMOVZXBQ" -++ show/varity x
    | VPMOVZXBW x: "VPMOVZXBW" -++ show/varity x
    | VPMOVZXDQ x: "VPMOVZXDQ" -++ show/varity x
    | VPMOVZXWD x: "VPMOVZXWD" -++ show/varity x
    | VPMOVZXWQ x: "VPMOVZXWQ" -++ show/varity x
    | VPMULDQ x: "VPMULDQ" -++ show/varity x
    | VPMULHRSW x: "VPMULHRSW" -++ show/varity x
    | VPMULHUW x: "VPMULHUW" -++ show/varity x
    | VPMULHW x: "VPMULHW" -++ show/varity x
    | VPMULLD x: "VPMULLD" -++ show/varity x
    | VPMULLW x: "VPMULLW" -++ show/varity x
    | VPMULUDQ x: "VPMULUDQ" -++ show/varity x
    | VPOR x: "VPOR" -++ show/varity x
    | VPSADBW x: "VPSADBW" -++ show/varity x
    | VPSHUFB x: "VPSHUFB" -++ show/varity x
    | VPSHUFD x: "VPSHUFD" -++ show/varity x
    | VPSHUFHW x: "VPSHUFHW" -++ show/varity x
    | VPSHUFLW x: "VPSHUFLW" -++ show/varity x
    | VPSIGNB x: "VPSIGNB" -++ show/varity x
    | VPSIGND x: "VPSIGND" -++ show/varity x
    | VPSIGNW x: "VPSIGNW" -++ show/varity x
    | VPSLLD x: "VPSLLD" -++ show/varity x
    | VPSLLDQ x: "VPSLLDQ" -++ show/varity x
    | VPSLLQ x: "VPSLLQ" -++ show/varity x
    | VPSLLW x: "VPSLLW" -++ show/varity x
    | VPSRAD x: "VPSRAD" -++ show/varity x
    | VPSRAW x: "VPSRAW" -++ show/varity x
    | VPSRLD x: "VPSRLD" -++ show/varity x
    | VPSRLDQ x: "VPSRLDQ" -++ show/varity x
    | VPSRLQ x: "VPSRLQ" -++ show/varity x
    | VPSRLW x: "VPSRLW" -++ show/varity x
    | VPSUBB x: "VPSUBB" -++ show/varity x
    | VPSUBD x: "VPSUBD" -++ show/varity x
    | VPSUBQ x: "VPSUBQ" -++ show/varity x
    | VPSUBSB x: "VPSUBSB" -++ show/varity x
    | VPSUBSW x: "VPSUBSW" -++ show/varity x
    | VPSUBUSB x: "VPSUBUSB" -++ show/varity x
    | VPSUBUSW x: "VPSUBUSW" -++ show/varity x
    | VPSUBW x: "VPSUBW" -++ show/varity x
    | VPTEST x: "VPTEST" -++ show/varity x
    | VPUNPCKHBW x: "VPUNPCKHBW" -++ show/varity x
    | VPUNPCKHDQ x: "VPUNPCKHDQ" -++ show/varity x
    | VPUNPCKHQDQ x: "VPUNPCKHQDQ" -++ show/varity x
    | VPUNPCKHWD x: "VPUNPCKHWD" -++ show/varity x
    | VPUNPCKLBW x: "VPUNPCKLBW" -++ show/varity x
    | VPUNPCKLDQ x: "VPUNPCKLDQ" -++ show/varity x
    | VPUNPCKLQDQ x: "VPUNPCKLQDQ" -++ show/varity x
    | VPUNPCKLWD x: "VPUNPCKLWD" -++ show/varity x
    | VPXOR x: "VPXOR" -++ show/varity x
    | VRCPPS x: "VRCPPS" -++ show/varity x
    | VRCPSS x: "VRCPSS" -++ show/varity x
    | VROUNDPD x: "VROUNDPD" -++ show/varity x
    | VROUNDPS x: "VROUNDPS" -++ show/varity x
    | VROUNDSD x: "VROUNDSD" -++ show/varity x
    | VROUNDSS x: "VROUNDSS" -++ show/varity x
    | VRSQRTPS x: "VRSQRTPS" -++ show/varity x
    | VRSQRTSS x: "VRSQRTSS" -++ show/varity x
    | VSHUFPD x: "VSHUFPD" -++ show/varity x
    | VSHUFPS x: "VSHUFPS" -++ show/varity x
    | VSQRTPD x: "VSQRTPD" -++ show/varity x
    | VSQRTPS x: "VSQRTPS" -++ show/varity x
    | VSQRTSD x: "VSQRTSD" -++ show/varity x
    | VSQRTSS x: "VSQRTSS" -++ show/varity x
    | VSTMXCSR x: "VSTMXCSR" -++ show/varity x
    | VSUBPD x: "VSUBPD" -++ show/varity x
    | VSUBPS x: "VSUBPS" -++ show/varity x
    | VSUBSD x: "VSUBSD" -++ show/varity x
    | VSUBSS x: "VSUBSS" -++ show/varity x
    | VTESTPD x: "VTESTPD" -++ show/varity x
    | VTESTPS x: "VTESTPS" -++ show/varity x
    | VUCOMISD x: "VUCOMISD" -++ show/varity x
    | VUCOMISS x: "VUCOMISS" -++ show/varity x
    | VUNPCKHPD x: "VUNPCKHPD" -++ show/varity x
    | VUNPCKHPS x: "VUNPCKHPS" -++ show/varity x
    | VUNPCKLPD x: "VUNPCKLPD" -++ show/varity x
    | VUNPCKLPS x: "VUNPCKLPS" -++ show/varity x
    | VXORPS x: "VXORPS" -++ show/varity x
    | VZEROALL x: "VZEROALL" -++ show/varity x
    | VZEROUPPER x: "VZEROUPPER" -++ show/varity x
    | WAIT: "WAIT"
    | WBINVD: "WBINVD"
    | WRFSBASE x: "WRFSBASE" -++ show/arity1 x
    | WRGSBASE x: "WRGSBASE" -++ show/arity1 x
    | WRMSR: "WRMSR"
    | XADD x: "XADD" -++ show/arity2 x
    | XCHG x: "XCHG" -++ show/arity2 x
    | XGETBV: "XGETBV"
    | XLAT: "XLAT"
    | XLATB: "XLATB"
    | XOR x: "XOR" -++ show/arity2 x
    | XORPD x: "XORPD" -++ show/arity2 x
    | XORPS x: "XORPS" -++ show/arity2 x
    | XRSTOR x: "XRSTOR" -++ show/arity1 x
    | XRSTOR64 x: "XRSTOR64" -++ show/arity1 x
    | XSAVE x: "XSAVE" -++ show/arity1 x
    | XSAVE64 x: "XSAVE64" -++ show/arity1 x
    | XSAVEOPT x: "XSAVEOPT" -++ show/arity1 x
    | XSAVEOPT64 x: "XSAVEOPT64" -++ show/arity1 x
    | XSETBV: "XSETBV"
    #| PSLRDQ x: "PSLRDQ" -++ show/arity2 x
    #| VPSLRDQ x: "VPSLRDQ" -++ show/varity x
   end
#s/^\(...\)\(\S*\)\s*$/\1\2: "\2"/
#s/^\(...\)\(\S*\) of \(\S*\)\s*$/\1\2 x: "\2" -++ show\/\3 x/
