# vim:filetype=sml:ts=3:sw=3:expandtab

export pretty_simple : (insndata) -> rope

val flow_decode_pretty_simple = do
  inge <- decode config-default;
  return (pretty_simple inge)
end

val pretty_simple i = show/instruction/s i.insn

val show/arity1/s x = show/operand/s x.opnd1
val show/arity2/s x = show/operand/s x.opnd1 +++ ", " +++ show/operand/s x.opnd2
val show/arity3/s x = show/operand/s x.opnd1 +++ ", " +++ show/operand/s x.opnd2 +++ ", " +++ show/operand/s x.opnd3
val show/arity4/s x = show/operand/s x.opnd1 +++ ", " +++ show/operand/s x.opnd2 +++ ", " +++ show/operand/s x.opnd3 +++ ", " +++ show/operand/s x.opnd4
val show/flow1/s x = show/flowoperand/s x.opnd1
val show/varity/s x =
   case x of
      VA0: ""
    | VA1 x: " " +++ show/arity1/s x
    | VA2 x: " " +++ show/arity2/s x
    | VA3 x: " " +++ show/arity3/s x
    | VA4 x: " " +++ show/arity4/s x
   end

val show/segment/s s = 
   case s of
      SEG_NONE: ""
    | SEG_OVERRIDE r:
        case r of
           DS: ""
         | s: "REG:"
        end
   end

val show/scale/s s = 
   case s of
      '00': "SCALE*"
    | '01': "SCALE*"
    | '10': "SCALE*"
    | '11': "SCALE*"
   end

val show/operand/s op =
   case op of
      IMM8 x: "IMM"
    | IMM16 x: "IMM"
    | IMM32 x: "IMM"
    | IMM64 x: "IMM"
    | REG x: "REG"
    | MEM x: show/segment/s x.segment +++ "[" +++ show/operand/s x.opnd +++ "]" 
    | SUM x: show/operand/s x.a +++ "+" +++ show/operand/s x.b
    | SCALE x: show/scale/s x.imm +++ show/operand/s x.opnd
   end

val show/flowoperand/s op =
   case op of
      REL8 x: "REL"
    | REL16 x: "REL"
    | REL32 x: "REL"
    | REL64 x: "REL"
    | NEARABS x: show/operand/s x 
    | FARABS x: show/operand/s x
   end

val show/instruction/s insn =
   case insn of
      AAA: "AAA"
    | AAD x: "AAD" -++ show/arity1/s x
    | AAM x: "AAM" -++ show/arity1/s x
    | AAS: "AAS"
    | ADC x: "ADC" -++ show/arity2/s x
    | ADD x: "ADD" -++ show/arity2/s x
    | ADDPD x: "ADDPD" -++ show/arity2/s x
    | ADDPS x: "ADDPS" -++ show/arity2/s x
    | ADDSD x: "ADDSD" -++ show/arity2/s x
    | ADDSS x: "ADDSS" -++ show/arity2/s x
    | ADDSUBPD x: "ADDSUBPD" -++ show/arity2/s x
    | ADDSUBPS x: "ADDSUBPS" -++ show/arity2/s x
    | AESDEC x: "AESDEC" -++ show/arity2/s x
    | AESDECLAST x: "AESDECLAST" -++ show/arity2/s x
    | AESENC x: "AESENC" -++ show/arity2/s x
    | AESENCLAST x: "AESENCLAST" -++ show/arity2/s x
    | AESIMC x: "AESIMC" -++ show/arity2/s x
    | AESKEYGENASSIST x: "AESKEYGENASSIST" -++ show/arity3/s x
    | AND x: "AND" -++ show/arity2/s x
    | ANDNPD x: "ANDNPD" -++ show/arity2/s x
    | ANDNPS x: "ANDNPS" -++ show/arity2/s x
    | ANDPD x: "ANDPD" -++ show/arity2/s x
    | ANDPS x: "ANDPS" -++ show/arity2/s x
    | ARPL x: "ARPL" -++ show/arity2/s x
    | BLENDPD x: "BLENDPD" -++ show/arity3/s x
    | BLENDPS x: "BLENDPS" -++ show/arity3/s x
    | BLENDVPD x: "BLENDVPD" -++ show/arity3/s x
    | BLENDVPS x: "BLENDVPS" -++ show/arity3/s x
    | BOUND x: "BOUND" -++ show/arity2/s x
    | BSF x: "BSF" -++ show/arity2/s x
    | BSR x: "BSR" -++ show/arity2/s x
    | BSWAP x: "BSWAP" -++ show/arity1/s x
    | BT x: "BT" -++ show/arity2/s x
    | BTC x: "BTC" -++ show/arity2/s x
    | BTR x: "BTR" -++ show/arity2/s x
    | BTS x: "BTS" -++ show/arity2/s x
    | CALL x: "CALL" -++ show/flow1/s x
    | CBW: "CBW"
    | CDQ: "CDQ"
    | CDQE: "CDQE"
    | CLC: "CLC"
    | CLD: "CLD"
    | CLFLUSH x: "CLFLUSH" -++ show/arity1/s x
    | CLI: "CLI"
    | CLTS: "CLTS"
    | CMC: "CMC"
    | CMOVA x: "CMOVA" -++ show/arity2/s x
    | CMOVAE x: "CMOVAE" -++ show/arity2/s x
    | CMOVB x: "CMOVB" -++ show/arity2/s x
    | CMOVBE x: "CMOVBE" -++ show/arity2/s x
    | CMOVC x: "CMOVC" -++ show/arity2/s x
    | CMOVE x: "CMOVE" -++ show/arity2/s x
    | CMOVG x: "CMOVG" -++ show/arity2/s x
    | CMOVGE x: "CMOVGE" -++ show/arity2/s x
    | CMOVL x: "CMOVL" -++ show/arity2/s x
    | CMOVLE x: "CMOVLE" -++ show/arity2/s x
    | CMOVNA x: "CMOVNA" -++ show/arity2/s x
    | CMOVNAE x: "CMOVNAE" -++ show/arity2/s x
    | CMOVNB x: "CMOVNB" -++ show/arity2/s x
    | CMOVNBE x: "CMOVNBE" -++ show/arity2/s x
    | CMOVNC x: "CMOVNC" -++ show/arity2/s x
    | CMOVNE x: "CMOVNE" -++ show/arity2/s x
    | CMOVNG x: "CMOVNG" -++ show/arity2/s x
    | CMOVNGE x: "CMOVNGE" -++ show/arity2/s x
    | CMOVNL x: "CMOVNL" -++ show/arity2/s x
    | CMOVNLE x: "CMOVNLE" -++ show/arity2/s x
    | CMOVNO x: "CMOVNO" -++ show/arity2/s x
    | CMOVNP x: "CMOVNP" -++ show/arity2/s x
    | CMOVNS x: "CMOVNS" -++ show/arity2/s x
    | CMOVNZ x: "CMOVNZ" -++ show/arity2/s x
    | CMOVO x: "CMOVO" -++ show/arity2/s x
    | CMOVP x: "CMOVP" -++ show/arity2/s x
    | CMOVPE x: "CMOVPE" -++ show/arity2/s x
    | CMOVPO x: "CMOVPO" -++ show/arity2/s x
    | CMOVS x: "CMOVS" -++ show/arity2/s x
    | CMOVZ x: "CMOVZ" -++ show/arity2/s x
    | CMP x: "CMP" -++ show/arity2/s x
    | CMPPD x: "CMPPD" -++ show/arity3/s x
    | CMPPS x: "CMPPS" -++ show/arity3/s x
    | CMPS x: "CMPS" -++ show/arity2/s x
    | CMPSD x: "CMPSD" -++ show/arity3/s x
    | CMPSS x: "CMPSS" -++ show/arity3/s x
    | CMPXCHG x: "CMPXCHG" -++ show/arity2/s x
    | CMPXCHG16B x: "CMPXCHG16B" -++ show/arity1/s x
    | CMPXCHG8B x: "CMPXCHG8B" -++ show/arity1/s x
    | COMISD x: "COMISD" -++ show/arity2/s x
    | COMISS x: "COMISS" -++ show/arity2/s x
    | CPUID: "CPUID"
    | CQO: "CQO"
    | CRC32 x: "CRC32" -++ show/arity2/s x
    | CVTDQ2PD x: "CVTDQ2PD" -++ show/arity2/s x
    | CVTDQ2PS x: "CVTDQ2PS" -++ show/arity2/s x
    | CVTPD2DQ x: "CVTPD2DQ" -++ show/arity2/s x
    | CVTPD2PI x: "CVTPD2PI" -++ show/arity2/s x
    | CVTPD2PS x: "CVTPD2PS" -++ show/arity2/s x
    | CVTPI2PD x: "CVTPI2PD" -++ show/arity2/s x
    | CVTPI2PS x: "CVTPI2PS" -++ show/arity2/s x
    | CVTPS2DQ x: "CVTPS2DQ" -++ show/arity2/s x
    | CVTPS2PD x: "CVTPS2PD" -++ show/arity2/s x
    | CVTPS2PI x: "CVTPS2PI" -++ show/arity2/s x
    | CVTSD2SI x: "CVTSD2SI" -++ show/arity2/s x
    | CVTSD2SS x: "CVTSD2SS" -++ show/arity2/s x
    | CVTSI2SD x: "CVTSI2SD" -++ show/arity2/s x
    | CVTSI2SS x: "CVTSI2SS" -++ show/arity2/s x
    | CVTSS2SD x: "CVTSS2SD" -++ show/arity2/s x
    | CVTSS2SI x: "CVTSS2SI" -++ show/arity2/s x
    | CVTTPD2DQ x: "CVTTPD2DQ" -++ show/arity2/s x
    | CVTTPD2PI x: "CVTTPD2PI" -++ show/arity2/s x
    | CVTTPS2DQ x: "CVTTPS2DQ" -++ show/arity2/s x
    | CVTTPS2PI x: "CVTTPS2PI" -++ show/arity2/s x
    | CVTTSD2SI x: "CVTTSD2SI" -++ show/arity2/s x
    | CVTTSS2SI x: "CVTTSS2SI" -++ show/arity2/s x
    | CWD: "CWD"
    | CWDE: "CWDE"
    | DAA: "DAA"
    | DAS: "DAS"
    | DEC x: "DEC" -++ show/arity1/s x
    | DIV x: "DIV" -++ show/arity1/s x
    | DIVPD x: "DIVPD" -++ show/arity2/s x
    | DIVPS x: "DIVPS" -++ show/arity2/s x
    | DIVSD x: "DIVSD" -++ show/arity2/s x
    | DIVSS x: "DIVSS" -++ show/arity2/s x
    | DPPD x: "DPPD" -++ show/arity3/s x
    | DPPS x: "DPPS" -++ show/arity3/s x
    | EMMS: "EMMS"
    | ENTER x: "ENTER" -++ show/arity2/s x
    | EXTRACTPS x: "EXTRACTPS" -++ show/arity3/s x
    | F2XM1: "F2XM1"
    | FABS: "FABS"
    | FADD x: "FADD" -++ show/arity2/s x
    | FADDP x: "FADDP" -++ show/arity2/s x
    | FBLD x: "FBLD" -++ show/arity1/s x
    | FBSTP x: "FBSTP" -++ show/arity1/s x
    | FCHS: "FCHS"
    | FCLEX: "FCLEX"
    | FCMOVB x: "FCMOVB" -++ show/arity2/s x
    | FCMOVBE x: "FCMOVBE" -++ show/arity2/s x
    | FCMOVE x: "FCMOVE" -++ show/arity2/s x
    | FCMOVNB x: "FCMOVNB" -++ show/arity2/s x
    | FCMOVNBE x: "FCMOVNBE" -++ show/arity2/s x
    | FCMOVNE x: "FCMOVNE" -++ show/arity2/s x
    | FCMOVNU x: "FCMOVNU" -++ show/arity2/s x
    | FCMOVU x: "FCMOVU" -++ show/arity2/s x
    | FCOM x: "FCOM" -++ show/arity1/s x
    | FCOMI x: "FCOMI" -++ show/arity2/s x
    | FCOMIP x: "FCOMIP" -++ show/arity2/s x
    | FCOMP x: "FCOMP" -++ show/arity1/s x
    | FCOMPP: "FCOMPP"
    | FCOS: "FCOS"
    | FDECSTP: "FDECSTP"
    | FDIV x: "FDIV" -++ show/arity2/s x
    | FDIVP x: "FDIVP" -++ show/arity2/s x
    | FDIVR x: "FDIVR" -++ show/arity2/s x
    | FDIVRP x: "FDIVRP" -++ show/arity2/s x
    | FFREE x: "FFREE" -++ show/arity1/s x
    | FIADD x: "FIADD" -++ show/arity1/s x
    | FICOM x: "FICOM" -++ show/arity1/s x
    | FICOMP x: "FICOMP" -++ show/arity1/s x
    | FIDIV x: "FIDIV" -++ show/arity2/s x
    | FIDIVR x: "FIDIVR" -++ show/arity1/s x
    | FILD x: "FILD" -++ show/arity1/s x
    | FIMUL x: "FIMUL" -++ show/arity1/s x
    | FINCSTP: "FINCSTP"
    | FINIT: "FINIT"
    | FIST x: "FIST" -++ show/arity1/s x
    | FISTP x: "FISTP" -++ show/arity1/s x
    | FISTTP x: "FISTTP" -++ show/arity1/s x
    | FISUB x: "FISUB" -++ show/arity1/s x
    | FISUBR x: "FISUBR" -++ show/arity1/s x
    | FLD x: "FLD" -++ show/arity1/s x
    | FLD1: "FLD1"
    | FLDCW x: "FLDCW" -++ show/arity1/s x
    | FLDENV x: "FLDENV" -++ show/arity1/s x
    | FLDL2E: "FLDL2E"
    | FLDL2T: "FLDL2T"
    | FLDLG2: "FLDLG2"
    | FLDLN2: "FLDLN2"
    | FLDPI: "FLDPI"
    | FLDZ: "FLDZ"
    | FMUL x: "FMUL" -++ show/arity2/s x
    | FMULP x: "FMULP" -++ show/arity2/s x
    | FNCLEX: "FNCLEX"
    | FNINIT: "FNINIT"
    | FNOP: "FNOP"
    | FNSAVE x: "FNSAVE" -++ show/arity1/s x
    | FNSTCW x: "FNSTCW" -++ show/arity1/s x
    | FNSTENV x: "FNSTENV" -++ show/arity1/s x
    | FNSTSW x: "FNSTSW" -++ show/arity1/s x
    | FPATAN: "FPATAN"
    | FPREM1: "FPREM1"
    | FPREM: "FPREM"
    | FPTAN: "FPTAN"
    | FRNDINT: "FRNDINT"
    | FRSTOR x: "FRSTOR" -++ show/arity1/s x
    | FSAVE x: "FSAVE" -++ show/arity1/s x
    | FSCALE: "FSCALE"
    | FSIN: "FSIN"
    | FSINCOS: "FSINCOS"
    | FSQRT: "FSQRT"
    | FST x: "FST" -++ show/arity1/s x
    | FSTCW x: "FSTCW" -++ show/arity1/s x
    | FSTENV x: "FSTENV" -++ show/arity1/s x
    | FSTP x: "FSTP" -++ show/arity1/s x
    | FSTSW x: "FSTSW" -++ show/arity1/s x
    | FSUB x: "FSUB" -++ show/arity2/s x
    | FSUBP x: "FSUBP" -++ show/arity2/s x
    | FSUBR x: "FSUBR" -++ show/arity2/s x
    | FSUBRP x: "FSUBRP" -++ show/arity2/s x
    | FTST: "FTST"
    | FUCOM x: "FUCOM" -++ show/arity1/s x
    | FUCOMI x: "FUCOMI" -++ show/arity1/s x
    | FUCOMIP x: "FUCOMIP" -++ show/arity1/s x
    | FUCOMP x: "FUCOMP" -++ show/arity1/s x
    | FUCOMPP: "FUCOMPP"
    | FXAM: "FXAM"
    | FXCH x: "FXCH" -++ show/arity1/s x
    | FXRSTOR x: "FXRSTOR" -++ show/arity1/s x
    | FXRSTOR64 x: "FXRSTOR64" -++ show/arity1/s x
    | FXSAVE x: "FXSAVE" -++ show/arity1/s x
    | FXSAVE64 x: "FXSAVE64" -++ show/arity1/s x
    | FXTRACT: "FXTRACT"
    | FYL2X: "FYL2X"
    | FYL2XP1: "FYL2XP1"
    | HADDPD x: "HADDPD" -++ show/arity2/s x
    | HADDPS x: "HADDPS" -++ show/arity2/s x
    | HLT: "HLT"
    | HSUBPD x: "HSUBPD" -++ show/arity2/s x
    | HSUBPS x: "HSUBPS" -++ show/arity2/s x
    | IDIV x: "IDIV" -++ show/arity1/s x
    | IMUL x: "IMUL" +++ show/varity/s x
    | IN x: "IN" -++ show/arity2/s x
    | INC x: "INC" -++ show/arity1/s x
    | INSB: "INSB"
    | INSD: "INSD"
    | INSERTPS x: "INSERTPS" -++ show/arity3/s x
    | INSW: "INSW"
    | INT x: "INT" -++ show/arity1/s x
    | INT0: "INT0"
    | INT3: "INT3"
    | INVD: "INVD"
    | INVLPG x: "INVLPG" -++ show/arity1/s x
    | INVPCID x: "INVPCID" -++ show/arity2/s x
    | IRET: "IRET"
    | IRETD: "IRETD"
    | IRETQ: "IRETQ"
    | JA x: "JA" -++ show/flow1/s x
    | JAE x: "JAE" -++ show/flow1/s x
    | JB x: "JB" -++ show/flow1/s x
    | JBE x: "JBE" -++ show/flow1/s x
    | JC x: "JC" -++ show/flow1/s x
    | JCXZ x: "JCXZ" -++ show/flow1/s x
    | JE x: "JE" -++ show/flow1/s x
    | JECXZ x: "JECXZ" -++ show/flow1/s x
    | JG x: "JG" -++ show/flow1/s x
    | JGE x: "JGE" -++ show/flow1/s x
    | JL x: "JL" -++ show/flow1/s x
    | JLE x: "JLE" -++ show/flow1/s x
    | JMP x: "JMP" -++ show/flow1/s x
    | JNA x: "JNA" -++ show/flow1/s x
    | JNAE x: "JNAE" -++ show/flow1/s x
    | JNB x: "JNB" -++ show/flow1/s x
    | JNBE x: "JNBE" -++ show/flow1/s x
    | JNC x: "JNC" -++ show/flow1/s x
    | JNE x: "JNE" -++ show/flow1/s x
    | JNG x: "JNG" -++ show/flow1/s x
    | JNGE x: "JNGE" -++ show/flow1/s x
    | JNL x: "JNL" -++ show/flow1/s x
    | JNLE x: "JNLE" -++ show/flow1/s x
    | JNO x: "JNO" -++ show/flow1/s x
    | JNP x: "JNP" -++ show/flow1/s x
    | JNS x: "JNS" -++ show/flow1/s x
    | JNZ x: "JNZ" -++ show/flow1/s x
    | JO x: "JO" -++ show/flow1/s x
    | JP x: "JP" -++ show/flow1/s x
    | JPE x: "JPE" -++ show/flow1/s x
    | JPO x: "JPO" -++ show/flow1/s x
    | JRCXZ x: "JRCXZ" -++ show/flow1/s x
    | JS x: "JS" -++ show/flow1/s x
    | JZ x: "JZ" -++ show/flow1/s x
    | LAHF: "LAHF"
    | LAR x: "LAR" -++ show/arity2/s x
    | LDDQU x: "LDDQU" -++ show/arity2/s x
    | LDMXCSR x: "LDMXCSR" -++ show/arity1/s x
    | LDS x: "LDS" -++ show/arity2/s x
    | LEA x: "LEA" -++ show/arity2/s x
    | LEAVE: "LEAVE"
    | LES x: "LES" -++ show/arity2/s x
    | LFENCE: "LFENCE"
    | LFS x: "LFS" -++ show/arity2/s x
    | LGDT x: "LGDT" -++ show/arity1/s x
    | LGS x: "LGS" -++ show/arity2/s x
    | LIDT x: "LIDT" -++ show/arity1/s x
    | LLDT x: "LLDT" -++ show/arity1/s x
    | LMSW x: "LMSW" -++ show/arity1/s x
    | LODS x: "LODS" -++ show/arity1/s x
    | LOOP x: "LOOP" -++ show/flow1/s x
    | LOOPE x: "LOOPE" -++ show/flow1/s x
    | LOOPNE x: "LOOPNE" -++ show/flow1/s x
    | LSL x: "LSL" -++ show/arity2/s x
    | LSS x: "LSS" -++ show/arity2/s x
    | LTR x: "LTR" -++ show/arity1/s x
    | MASKMOVDQU x: "MASKMOVDQU" -++ show/arity3/s x
    | MASKMOVQ x: "MASKMOVQ" -++ show/arity3/s x
    | MAXPD x: "MAXPD" -++ show/arity2/s x
    | MAXPS x: "MAXPS" -++ show/arity2/s x
    | MAXSD x: "MAXSD" -++ show/arity2/s x
    | MAXSS x: "MAXSS" -++ show/arity2/s x
    | MFENCE: "MFENCE"
    | MINPD x: "MINPD" -++ show/arity2/s x
    | MINPS x: "MINPS" -++ show/arity2/s x
    | MINSD x: "MINSD" -++ show/arity2/s x
    | MINSS x: "MINSS" -++ show/arity2/s x
    | MONITOR: "MONITOR"
    | MOV x: "MOV" -++ show/arity2/s x
    | MOVAPD x: "MOVAPD" -++ show/arity2/s x
    | MOVAPS x: "MOVAPS" -++ show/arity2/s x
    | MOVBE x: "MOVBE" -++ show/arity2/s x
    | MOVD x: "MOVD" -++ show/arity2/s x
    | MOVDDUP x: "MOVDDUP" -++ show/arity2/s x
    | MOVDQ2Q x: "MOVDQ2Q" -++ show/arity2/s x
    | MOVDQA x: "MOVDQA" -++ show/arity2/s x
    | MOVDQU x: "MOVDQU" -++ show/arity2/s x
    | MOVHLPS x: "MOVHLPS" -++ show/arity2/s x
    | MOVHPD x: "MOVHPD" -++ show/arity2/s x
    | MOVHPS x: "MOVHPS" -++ show/arity2/s x
    | MOVLHPS x: "MOVLHPS" -++ show/arity2/s x
    | MOVLPD x: "MOVLPD" -++ show/arity2/s x
    | MOVLPS x: "MOVLPS" -++ show/arity2/s x
    | MOVMSKPD x: "MOVMSKPD" -++ show/arity2/s x
    | MOVMSKPS x: "MOVMSKPS" -++ show/arity2/s x
    | MOVNTDQ x: "MOVNTDQ" -++ show/arity2/s x
    | MOVNTDQA x: "MOVNTDQA" -++ show/arity2/s x
    | MOVNTI x: "MOVNTI" -++ show/arity2/s x
    | MOVNTPD x: "MOVNTPD" -++ show/arity2/s x
    | MOVNTPS x: "MOVNTPS" -++ show/arity2/s x
    | MOVNTQ x: "MOVNTQ" -++ show/arity2/s x
    | MOVQ x: "MOVQ" -++ show/arity2/s x
    | MOVQ2DQ x: "MOVQ2DQ" -++ show/arity2/s x
    | MOVS x: "MOVS" -++ show/arity2/s x
    | MOVSD x: "MOVSD" -++ show/arity2/s x
    | MOVSHDUP x: "MOVSHDUP" -++ show/arity2/s x
    | MOVSLDUP x: "MOVSLDUP" -++ show/arity2/s x
    | MOVSS x: "MOVSS" -++ show/arity2/s x
    | MOVSW x: "MOVSW" -++ show/arity2/s x
    | MOVSX x: "MOVSX" -++ show/arity2/s x
    | MOVSXD x: "MOVSXD" -++ show/arity2/s x
    | MOVUPD x: "MOVUPD" -++ show/arity2/s x
    | MOVUPS x: "MOVUPS" -++ show/arity2/s x
    | MOVZX x: "MOVZX" -++ show/arity2/s x
    | MPSADBW x: "MPSADBW" -++ show/arity3/s x
    | MUL x: "MUL" -++ show/arity1/s x
    | MULPD x: "MULPD" -++ show/arity2/s x
    | MULPS x: "MULPS" -++ show/arity2/s x
    | MULSD x: "MULSD" -++ show/arity2/s x
    | MULSS x: "MULSS" -++ show/arity2/s x
    | MWAIT: "MWAIT"
    | NEG x: "NEG" -++ show/arity1/s x
    | NOP x: "NOP" +++ show/varity/s x
    | NOT x: "NOT" -++ show/arity1/s x
    | OR x: "OR" -++ show/arity2/s x
    | ORPD x: "ORPD" -++ show/arity2/s x
    | ORPS x: "ORPS" -++ show/arity2/s x
    | OUT x: "OUT" -++ show/arity2/s x
    | OUTS: "OUTS"
    | OUTSB: "OUTSB"
    | OUTSD: "OUTSD"
    | OUTSW: "OUTSW"
    | PABSB x: "PABSB" -++ show/arity2/s x
    | PABSD x: "PABSD" -++ show/arity2/s x
    | PABSW x: "PABSW" -++ show/arity2/s x
    | PACKSSDW x: "PACKSSDW" -++ show/arity2/s x
    | PACKSSWB x: "PACKSSWB" -++ show/arity2/s x
    | PACKUSDW x: "PACKUSDW" -++ show/arity2/s x
    | PACKUSWB x: "PACKUSWB" -++ show/arity2/s x
    | PADDB x: "PADDB" -++ show/arity2/s x
    | PADDD x: "PADDD" -++ show/arity2/s x
    | PADDQ x: "PADDQ" -++ show/arity2/s x
    | PADDSB x: "PADDSB" -++ show/arity2/s x
    | PADDSW x: "PADDSW" -++ show/arity2/s x
    | PADDUSB x: "PADDUSB" -++ show/arity2/s x
    | PADDUSW x: "PADDUSW" -++ show/arity2/s x
    | PADDW x: "PADDW" -++ show/arity2/s x
    | PALIGNR x: "PALIGNR" -++ show/arity3/s x
    | PAND x: "PAND" -++ show/arity2/s x
    | PANDN x: "PANDN" -++ show/arity2/s x
    | PAUSE: "PAUSE"
    | PAVGB x: "PAVGB" -++ show/arity2/s x
    | PAVGW x: "PAVGW" -++ show/arity2/s x
    | PBLENDVB x: "PBLENDVB" -++ show/arity2/s x
    | PBLENDW x: "PBLENDW" -++ show/arity3/s x
    | PCLMULQDQ x: "PCLMULQDQ" -++ show/arity3/s x
    | PCMPEQB x: "PCMPEQB" -++ show/arity2/s x
    | PCMPEQD x: "PCMPEQD" -++ show/arity2/s x
    | PCMPEQQ x: "PCMPEQQ" -++ show/arity2/s x
    | PCMPEQW x: "PCMPEQW" -++ show/arity2/s x
    | PCMPESTRI x: "PCMPESTRI" -++ show/arity3/s x
    | PCMPESTRM x: "PCMPESTRM" -++ show/arity3/s x
    | PCMPGRD x: "PCMPGRD" -++ show/arity2/s x
    | PCMPGTB x: "PCMPGTB" -++ show/arity2/s x
    | PCMPGTD x: "PCMPGTD" -++ show/arity2/s x
    | PCMPGTQ x: "PCMPGTQ" -++ show/arity2/s x
    | PCMPGTW x: "PCMPGTW" -++ show/arity2/s x
    | PCMPISTRI x: "PCMPISTRI" -++ show/arity3/s x
    | PCMPISTRM x: "PCMPISTRM" -++ show/arity3/s x
    | PEXTRB x: "PEXTRB" -++ show/arity3/s x
    | PEXTRD x: "PEXTRD" -++ show/arity3/s x
    | PEXTRQ x: "PEXTRQ" -++ show/arity3/s x
    | PEXTRW x: "PEXTRW" -++ show/arity3/s x
    | PHADDD x: "PHADDD" -++ show/arity2/s x
    | PHADDSW x: "PHADDSW" -++ show/arity2/s x
    | PHADDW x: "PHADDW" -++ show/arity2/s x
    | PHMINPOSUW x: "PHMINPOSUW" -++ show/arity2/s x
    | PHSUBD x: "PHSUBD" -++ show/arity2/s x
    | PHSUBSW x: "PHSUBSW" -++ show/arity2/s x
    | PHSUBW x: "PHSUBW" -++ show/arity2/s x
    | PINSRB x: "PINSRB" -++ show/arity3/s x
    | PINSRD x: "PINSRD" -++ show/arity3/s x
    | PINSRQ x: "PINSRQ" -++ show/arity3/s x
    | PINSRW x: "PINSRW" -++ show/arity3/s x
    | PMADDUBSW x: "PMADDUBSW" -++ show/arity2/s x
    | PMADDWD x: "PMADDWD" -++ show/arity2/s x
    | PMAXSB x: "PMAXSB" -++ show/arity2/s x
    | PMAXSD x: "PMAXSD" -++ show/arity2/s x
    | PMAXSW x: "PMAXSW" -++ show/arity2/s x
    | PMAXUB x: "PMAXUB" -++ show/arity2/s x
    | PMAXUD x: "PMAXUD" -++ show/arity2/s x
    | PMAXUW x: "PMAXUW" -++ show/arity2/s x
    | PMINSB x: "PMINSB" -++ show/arity2/s x
    | PMINSD x: "PMINSD" -++ show/arity2/s x
    | PMINSW x: "PMINSW" -++ show/arity2/s x
    | PMINUB x: "PMINUB" -++ show/arity2/s x
    | PMINUD x: "PMINUD" -++ show/arity2/s x
    | PMINUW x: "PMINUW" -++ show/arity2/s x
    | PMOVMSKB x: "PMOVMSKB" -++ show/arity2/s x
    | PMOVSXBD x: "PMOVSXBD" -++ show/arity2/s x
    | PMOVSXBQ x: "PMOVSXBQ" -++ show/arity2/s x
    | PMOVSXBW x: "PMOVSXBW" -++ show/arity2/s x
    | PMOVSXDQ x: "PMOVSXDQ" -++ show/arity2/s x
    | PMOVSXWD x: "PMOVSXWD" -++ show/arity2/s x
    | PMOVSXWQ x: "PMOVSXWQ" -++ show/arity2/s x
    | PMOVZXBD x: "PMOVZXBD" -++ show/arity2/s x
    | PMOVZXBQ x: "PMOVZXBQ" -++ show/arity2/s x
    | PMOVZXBW x: "PMOVZXBW" -++ show/arity2/s x
    | PMOVZXDQ x: "PMOVZXDQ" -++ show/arity2/s x
    | PMOVZXWD x: "PMOVZXWD" -++ show/arity2/s x
    | PMOVZXWQ x: "PMOVZXWQ" -++ show/arity2/s x
    | PMULDQ x: "PMULDQ" -++ show/arity2/s x
    | PMULHRSW x: "PMULHRSW" -++ show/arity2/s x
    | PMULHUW x: "PMULHUW" -++ show/arity2/s x
    | PMULHW x: "PMULHW" -++ show/arity2/s x
    | PMULLD x: "PMULLD" -++ show/arity2/s x
    | PMULLW x: "PMULLW" -++ show/arity2/s x
    | PMULUDQ x: "PMULUDQ" -++ show/arity2/s x
    | POP x: "POP" -++ show/arity1/s x
    | POPA: "POPA"
    | POPAD: "POPAD"
    | POPCNT x: "POPCNT" -++ show/arity2/s x
    | POPF: "POPF"
    | POPFD: "POPFD"
    | POPFQ: "POPFQ"
    | POR x: "POR" -++ show/arity2/s x
    | PREFETCHNTA x: "PREFETCHNTA" -++ show/arity1/s x
    | PREFETCHT0 x: "PREFETCHT0" -++ show/arity1/s x
    | PREFETCHT1 x: "PREFETCHT1" -++ show/arity1/s x
    | PREFETCHT2 x: "PREFETCHT2" -++ show/arity1/s x
    | PREFETCHW x: "PREFETCHW" -++ show/arity1/s x
    | PSADBW x: "PSADBW" -++ show/arity2/s x
    | PSHUFB x: "PSHUFB" -++ show/arity2/s x
    | PSHUFD x: "PSHUFD" -++ show/arity3/s x
    | PSHUFHW x: "PSHUFHW" -++ show/arity3/s x
    | PSHUFLW x: "PSHUFLW" -++ show/arity3/s x
    | PSHUFW x: "PSHUFW" -++ show/arity3/s x
    | PSIGNB x: "PSIGNB" -++ show/arity2/s x
    | PSIGND x: "PSIGND" -++ show/arity2/s x
    | PSIGNW x: "PSIGNW" -++ show/arity2/s x
    | PSLLD x: "PSLLD" -++ show/arity2/s x
    | PSLLDQ x: "PSLLDQ" -++ show/arity2/s x
    | PSLLQ x: "PSLLQ" -++ show/arity2/s x
    | PSLLW x: "PSLLW" -++ show/arity2/s x
    | PSRAD x: "PSRAD" -++ show/arity2/s x
    | PSRAW x: "PSRAW" -++ show/arity2/s x
    | PSRLD x: "PSRLD" -++ show/arity2/s x
    | PSRLDQ x: "PSRLDQ" -++ show/arity2/s x
    | PSRLQ x: "PSRLQ" -++ show/arity2/s x
    | PSRLW x: "PSRLW" -++ show/arity2/s x
    | PSUBB x: "PSUBB" -++ show/arity2/s x
    | PSUBD x: "PSUBD" -++ show/arity2/s x
    | PSUBQ x: "PSUBQ" -++ show/arity2/s x
    | PSUBSB x: "PSUBSB" -++ show/arity2/s x
    | PSUBSW x: "PSUBSW" -++ show/arity2/s x
    | PSUBUSB x: "PSUBUSB" -++ show/arity2/s x
    | PSUBUSW x: "PSUBUSW" -++ show/arity2/s x
    | PSUBW x: "PSUBW" -++ show/arity2/s x
    | PTEST x: "PTEST" -++ show/arity2/s x
    | PUNPCKHBW x: "PUNPCKHBW" -++ show/arity2/s x
    | PUNPCKHDQ x: "PUNPCKHDQ" -++ show/arity2/s x
    | PUNPCKHQDQ x: "PUNPCKHQDQ" -++ show/arity2/s x
    | PUNPCKHWD x: "PUNPCKHWD" -++ show/arity2/s x
    | PUNPCKLBW x: "PUNPCKLBW" -++ show/arity2/s x
    | PUNPCKLDQ x: "PUNPCKLDQ" -++ show/arity2/s x
    | PUNPCKLQDQ x: "PUNPCKLQDQ" -++ show/arity2/s x
    | PUNPCKLWD x: "PUNPCKLWD" -++ show/arity2/s x
    | PUSH x: "PUSH" -++ show/arity1/s x
    | PUSHA: "PUSHA"
    | PUSHAD: "PUSHAD"
    | PUSHF: "PUSHF"
    | PUSHFD: "PUSHFD"
    | PUSHFQ: "PUSHFQ"
    | PXOR x: "PXOR" -++ show/arity2/s x
    | RCL x: "RCL" -++ show/arity2/s x
    | RCPPS x: "RCPPS" -++ show/arity2/s x
    | RCPSS x: "RCPSS" -++ show/arity2/s x
    | RCR x: "RCR" -++ show/arity2/s x
    | RDFSBASE x: "RDFSBASE" -++ show/arity1/s x
    | RDGSBASE x: "RDGSBASE" -++ show/arity1/s x
    | RDMSR: "RDMSR"
    | RDPMC: "RDPMC"
    | RDRAND x: "RDRAND" -++ show/arity1/s x
    | RDTSC: "RDTSC"
    | RDTSCP: "RDTSCP"
    | RET x: "RET" +++ show/varity/s x
    | RET_FAR x: "RET_FAR" +++ show/varity/s x
    | ROL x: "ROL" -++ show/arity2/s x
    | ROR x: "ROR" -++ show/arity2/s x
    | ROUNDPD x: "ROUNDPD" -++ show/arity3/s x
    | ROUNDPS x: "ROUNDPS" -++ show/arity3/s x
    | ROUNDSD x: "ROUNDSD" -++ show/arity3/s x
    | ROUNDSS x: "ROUNDSS" -++ show/arity3/s x
    | RSM: "RSM"
    | RSQRTPS x: "RSQRTPS" -++ show/arity2/s x
    | RSQRTSS x: "RSQRTSS" -++ show/arity2/s x
    | SAHF: "SAHF"
    | SAL x: "SAL" -++ show/arity2/s x
    | SAR x: "SAR" -++ show/arity2/s x
    | SBB x: "SBB" -++ show/arity2/s x
    | SCASB: "SCASB"
    | SCASD: "SCASD"
    | SCASQ: "SCASQ"
    | SCASW: "SCASW"
    | SETA x: "SETA" -++ show/arity1/s x
    | SETAE x: "SETAE" -++ show/arity1/s x
    | SETB x: "SETB" -++ show/arity1/s x
    | SETBE x: "SETBE" -++ show/arity1/s x
    | SETC x: "SETC" -++ show/arity1/s x
    | SETE x: "SETE" -++ show/arity1/s x
    | SETG x: "SETG" -++ show/arity1/s x
    | SETGE x: "SETGE" -++ show/arity1/s x
    | SETL x: "SETL" -++ show/arity1/s x
    | SETLE x: "SETLE" -++ show/arity1/s x
    | SETNA x: "SETNA" -++ show/arity1/s x
    | SETNAE x: "SETNAE" -++ show/arity1/s x
    | SETNB x: "SETNB" -++ show/arity1/s x
    | SETNBE x: "SETNBE" -++ show/arity1/s x
    | SETNC x: "SETNC" -++ show/arity1/s x
    | SETNE x: "SETNE" -++ show/arity1/s x
    | SETNG x: "SETNG" -++ show/arity1/s x
    | SETNGE x: "SETNGE" -++ show/arity1/s x
    | SETNL x: "SETNL" -++ show/arity1/s x
    | SETNLE x: "SETNLE" -++ show/arity1/s x
    | SETNO x: "SETNO" -++ show/arity1/s x
    | SETNP x: "SETNP" -++ show/arity1/s x
    | SETNS x: "SETNS" -++ show/arity1/s x
    | SETNZ x: "SETNZ" -++ show/arity1/s x
    | SETO x: "SETO" -++ show/arity1/s x
    | SETP x: "SETP" -++ show/arity1/s x
    | SETPE x: "SETPE" -++ show/arity1/s x
    | SETPO x: "SETPO" -++ show/arity1/s x
    | SETS x: "SETS" -++ show/arity1/s x
    | SETZ x: "SETZ" -++ show/arity1/s x
    | SFENCE: "SFENCE"
    | SGDT x: "SGDT" -++ show/arity1/s x
    | SHL x: "SHL" -++ show/arity2/s x
    | SHLD x: "SHLD" -++ show/arity3/s x
    | SHR x: "SHR" -++ show/arity2/s x
    | SHRD x: "SHRD" -++ show/arity3/s x
    | SHUFPD x: "SHUFPD" -++ show/arity3/s x
    | SHUFPS x: "SHUFPS" -++ show/arity3/s x
    | SIDT x: "SIDT" -++ show/arity1/s x
    | SLDT x: "SLDT" -++ show/arity1/s x
    | SMSW x: "SMSW" -++ show/arity1/s x
    | SQRTPD x: "SQRTPD" -++ show/arity2/s x
    | SQRTPS x: "SQRTPS" -++ show/arity2/s x
    | SQRTSD x: "SQRTSD" -++ show/arity2/s x
    | SQRTSS x: "SQRTSS" -++ show/arity2/s x
    | STC: "STC"
    | STD: "STD"
    | STI: "STI"
    | STMXCSR x: "STMXCSR" -++ show/arity1/s x
    | STOSB: "STOSB"
    | STOSD: "STOSD"
    | STOSQ: "STOSQ"
    | STOSW: "STOSW"
    | STR x: "STR" -++ show/arity1/s x
    | SUB x: "SUB" -++ show/arity2/s x
    | SUBPD x: "SUBPD" -++ show/arity2/s x
    | SUBPS x: "SUBPS" -++ show/arity2/s x
    | SUBSD x: "SUBSD" -++ show/arity2/s x
    | SUBSS x: "SUBSS" -++ show/arity2/s x
    | SWAPGS: "SWAPGS"
    | SYSCALL: "SYSCALL"
    | SYSENTER: "SYSENTER"
    | SYSEXIT: "SYSEXIT"
    | SYSRET: "SYSRET"
    | TEST x: "TEST" -++ show/arity2/s x
    | UCOMISD x: "UCOMISD" -++ show/arity2/s x
    | UCOMISS x: "UCOMISS" -++ show/arity2/s x
    | UD2: "UD2"
    | UNPCKHPD x: "UNPCKHPD" -++ show/arity2/s x
    | UNPCKHPS x: "UNPCKHPS" -++ show/arity2/s x
    | UNPCKLPD x: "UNPCKLPD" -++ show/arity2/s x
    | UNPCKLPS x: "UNPCKLPS" -++ show/arity2/s x
    | VADDPD x: "VADDPD" +++ show/varity/s x
    | VADDPS x: "VADDPS" +++ show/varity/s x
    | VADDSD x: "VADDSD" +++ show/varity/s x
    | VADDSS x: "VADDSS" +++ show/varity/s x
    | VADDSUBPD x: "VADDSUBPD" +++ show/varity/s x
    | VADDSUBPS x: "VADDSUBPS" +++ show/varity/s x
    | VAESDEC x: "VAESDEC" +++ show/varity/s x
    | VAESDECLAST x: "VAESDECLAST" +++ show/varity/s x
    | VAESENC x: "VAESENC" +++ show/varity/s x
    | VAESENCLAST x: "VAESENCLAST" +++ show/varity/s x
    | VAESIMC x: "VAESIMC" +++ show/varity/s x
    | VAESKEYGENASSIST x: "VAESKEYGENASSIST" +++ show/varity/s x
    | VANDNPD x: "VANDNPD" +++ show/varity/s x
    | VANDNPS x: "VANDNPS" +++ show/varity/s x
    | VANDPD x: "VANDPD" +++ show/varity/s x
    | VANDPS x: "VANDPS" +++ show/varity/s x
    | VBLENDPD x: "VBLENDPD" +++ show/varity/s x
    | VBLENDPS x: "VBLENDPS" +++ show/varity/s x
    | VBLENDVPD x: "VBLENDVPD" +++ show/varity/s x
    | VBLENDVPS x: "VBLENDVPS" +++ show/varity/s x
    | VBROADCASTF128 x: "VBROADCASTF128" +++ show/varity/s x
    | VBROADCASTSD x: "VBROADCASTSD" +++ show/varity/s x
    | VBROADCASTSS x: "VBROADCASTSS" +++ show/varity/s x
    | VCMPPD x: "VCMPPD" +++ show/varity/s x
    | VCMPPS x: "VCMPPS" +++ show/varity/s x
    | VCMPSD x: "VCMPSD" +++ show/varity/s x
    | VCMPSS x: "VCMPSS" +++ show/varity/s x
    | VCOMISD x: "VCOMISD" +++ show/varity/s x
    | VCOMISS x: "VCOMISS" +++ show/varity/s x
    | VCVTDQ2PD x: "VCVTDQ2PD" +++ show/varity/s x
    | VCVTDQ2PS x: "VCVTDQ2PS" +++ show/varity/s x
    | VCVTPD2DQ x: "VCVTPD2DQ" +++ show/varity/s x
    | VCVTPD2PS x: "VCVTPD2PS" +++ show/varity/s x
    | VCVTPH2PS x: "VCVTPH2PS" +++ show/varity/s x
    | VCVTPS2DQ x: "VCVTPS2DQ" +++ show/varity/s x
    | VCVTPS2PD x: "VCVTPS2PD" +++ show/varity/s x
    | VCVTPS2PH x: "VCVTPS2PH" +++ show/varity/s x
    | VCVTSD2SI x: "VCVTSD2SI" +++ show/varity/s x
    | VCVTSD2SS x: "VCVTSD2SS" +++ show/varity/s x
    | VCVTSI2SD x: "VCVTSI2SD" +++ show/varity/s x
    | VCVTSI2SS x: "VCVTSI2SS" +++ show/varity/s x
    | VCVTSS2SD x: "VCVTSS2SD" +++ show/varity/s x
    | VCVTSS2SI x: "VCVTSS2SI" +++ show/varity/s x
    | VCVTTPD2DQ x: "VCVTTPD2DQ" +++ show/varity/s x
    | VCVTTPS2DQ x: "VCVTTPS2DQ" +++ show/varity/s x
    | VCVTTSD2SI x: "VCVTTSD2SI" +++ show/varity/s x
    | VCVTTSS2SI x: "VCVTTSS2SI" +++ show/varity/s x
    | VDIVPD x: "VDIVPD" +++ show/varity/s x
    | VDIVPS x: "VDIVPS" +++ show/varity/s x
    | VDIVSD x: "VDIVSD" +++ show/varity/s x
    | VDIVSS x: "VDIVSS" +++ show/varity/s x
    | VDPPD x: "VDPPD" +++ show/varity/s x
    | VDPPS x: "VDPPS" +++ show/varity/s x
    | VERR x: "VERR" -++ show/arity1/s x
    | VERW x: "VERW" -++ show/arity1/s x
    | VEXTRACTF128 x: "VEXTRACTF128" +++ show/varity/s x
    | VEXTRACTPS x: "VEXTRACTPS" +++ show/varity/s x
    | VHADDPD x: "VHADDPD" +++ show/varity/s x
    | VHADDPS x: "VHADDPS" +++ show/varity/s x
    | VHSUBPD x: "VHSUBPD" +++ show/varity/s x
    | VHSUBPS x: "VHSUBPS" +++ show/varity/s x
    | VINSERTF128 x: "VINSERTF128" +++ show/varity/s x
    | VINSERTPS x: "VINSERTPS" +++ show/varity/s x
    | VLDDQU x: "VLDDQU" +++ show/varity/s x
    | VLDMXCSR x: "VLDMXCSR" +++ show/varity/s x
    | VMASKMOVDQU x: "VMASKMOVDQU" +++ show/varity/s x
    | VMASKMOVPD x: "VMASKMOVPD" +++ show/varity/s x
    | VMASKMOVPS x: "VMASKMOVPS" +++ show/varity/s x
    | VMAXPD x: "VMAXPD" +++ show/varity/s x
    | VMAXPS x: "VMAXPS" +++ show/varity/s x
    | VMAXSD x: "VMAXSD" +++ show/varity/s x
    | VMAXSS x: "VMAXSS" +++ show/varity/s x
    | VMINPD x: "VMINPD" +++ show/varity/s x
    | VMINPS x: "VMINPS" +++ show/varity/s x
    | VMINSD x: "VMINSD" +++ show/varity/s x
    | VMINSS x: "VMINSS" +++ show/varity/s x
    | VMOVAPD x: "VMOVAPD" +++ show/varity/s x
    | VMOVAPS x: "VMOVAPS" +++ show/varity/s x
    | VMOVD x: "VMOVD" +++ show/varity/s x
    | VMOVDDUP x: "VMOVDDUP" +++ show/varity/s x
    | VMOVDQA x: "VMOVDQA" +++ show/varity/s x
    | VMOVDQU x: "VMOVDQU" +++ show/varity/s x
    | VMOVHLPS x: "VMOVHLPS" +++ show/varity/s x
    | VMOVHPD x: "VMOVHPD" +++ show/varity/s x
    | VMOVHPS x: "VMOVHPS" +++ show/varity/s x
    | VMOVLHPS x: "VMOVLHPS" +++ show/varity/s x
    | VMOVLPD x: "VMOVLPD" +++ show/varity/s x
    | VMOVLPS x: "VMOVLPS" +++ show/varity/s x
    | VMOVMSKPD x: "VMOVMSKPD" +++ show/varity/s x
    | VMOVMSKPS x: "VMOVMSKPS" +++ show/varity/s x
    | VMOVNTDQ x: "VMOVNTDQ" +++ show/varity/s x
    | VMOVNTDQA x: "VMOVNTDQA" +++ show/varity/s x
    | VMOVNTPD x: "VMOVNTPD" +++ show/varity/s x
    | VMOVNTPS x: "VMOVNTPS" +++ show/varity/s x
    | VMOVQ x: "VMOVQ" +++ show/varity/s x
    | VMOVSD x: "VMOVSD" +++ show/varity/s x
    | VMOVSHDUP x: "VMOVSHDUP" +++ show/varity/s x
    | VMOVSLDUP x: "VMOVSLDUP" +++ show/varity/s x
    | VMOVSS x: "VMOVSS" +++ show/varity/s x
    | VMOVUPD x: "VMOVUPD" +++ show/varity/s x
    | VMOVUPS x: "VMOVUPS" +++ show/varity/s x
    | VMPSADBW x: "VMPSADBW" +++ show/varity/s x
    | VMULPD x: "VMULPD" +++ show/varity/s x
    | VMULPS x: "VMULPS" +++ show/varity/s x
    | VMULSD x: "VMULSD" +++ show/varity/s x
    | VMULSS x: "VMULSS" +++ show/varity/s x
    | VORPD x: "VORPD" +++ show/varity/s x
    | VORPS x: "VORPS" +++ show/varity/s x
    | VPABSB x: "VPABSB" +++ show/varity/s x
    | VPABSD x: "VPABSD" +++ show/varity/s x
    | VPABSW x: "VPABSW" +++ show/varity/s x
    | VPACKSSDW x: "VPACKSSDW" +++ show/varity/s x
    | VPACKSSWB x: "VPACKSSWB" +++ show/varity/s x
    | VPACKUSDW x: "VPACKUSDW" +++ show/varity/s x
    | VPACKUSWB x: "VPACKUSWB" +++ show/varity/s x
    | VPADDB x: "VPADDB" +++ show/varity/s x
    | VPADDD x: "VPADDD" +++ show/varity/s x
    | VPADDQ x: "VPADDQ" +++ show/varity/s x
    | VPADDSB x: "VPADDSB" +++ show/varity/s x
    | VPADDSW x: "VPADDSW" +++ show/varity/s x
    | VPADDUSB x: "VPADDUSB" +++ show/varity/s x
    | VPADDUSW x: "VPADDUSW" +++ show/varity/s x
    | VPADDW x: "VPADDW" +++ show/varity/s x
    | VPALIGNR x: "VPALIGNR" +++ show/varity/s x
    | VPAND x: "VPAND" +++ show/varity/s x
    | VPANDN x: "VPANDN" +++ show/varity/s x
    | VPAVGB x: "VPAVGB" +++ show/varity/s x
    | VPAVGW x: "VPAVGW" +++ show/varity/s x
    | VPBLENDVB x: "VPBLENDVB" +++ show/varity/s x
    | VPBLENDW x: "VPBLENDW" +++ show/varity/s x
    | VPCLMULQDQ x: "VPCLMULQDQ" +++ show/varity/s x
    | VPCMPEQB x: "VPCMPEQB" +++ show/varity/s x
    | VPCMPEQD x: "VPCMPEQD" +++ show/varity/s x
    | VPCMPEQQ x: "VPCMPEQQ" +++ show/varity/s x
    | VPCMPEQW x: "VPCMPEQW" +++ show/varity/s x
    | VPCMPESTRI x: "VPCMPESTRI" +++ show/varity/s x
    | VPCMPESTRM x: "VPCMPESTRM" +++ show/varity/s x
    | VPCMPGTB x: "VPCMPGTB" +++ show/varity/s x
    | VPCMPGTD x: "VPCMPGTD" +++ show/varity/s x
    | VPCMPGTQ x: "VPCMPGTQ" +++ show/varity/s x
    | VPCMPGTW x: "VPCMPGTW" +++ show/varity/s x
    | VPCMPISTRI x: "VPCMPISTRI" +++ show/varity/s x
    | VPCMPISTRM x: "VPCMPISTRM" +++ show/varity/s x
    | VPERM2F128 x: "VPERM2F128" +++ show/varity/s x
    | VPERMILPD x: "VPERMILPD" +++ show/varity/s x
    | VPERMILPS x: "VPERMILPS" +++ show/varity/s x
    | VPEXTRB x: "VPEXTRB" +++ show/varity/s x
    | VPEXTRD x: "VPEXTRD" +++ show/varity/s x
    | VPEXTRQ x: "VPEXTRQ" +++ show/varity/s x
    | VPEXTRW x: "VPEXTRW" +++ show/varity/s x
    | VPHADDD x: "VPHADDD" +++ show/varity/s x
    | VPHADDSW x: "VPHADDSW" +++ show/varity/s x
    | VPHADDW x: "VPHADDW" +++ show/varity/s x
    | VPHMINPOSUW x: "VPHMINPOSUW" +++ show/varity/s x
    | VPHSUBD x: "VPHSUBD" +++ show/varity/s x
    | VPHSUBSW x: "VPHSUBSW" +++ show/varity/s x
    | VPHSUBW x: "VPHSUBW" +++ show/varity/s x
    | VPINSRB x: "VPINSRB" +++ show/varity/s x
    | VPINSRD x: "VPINSRD" +++ show/varity/s x
    | VPINSRQ x: "VPINSRQ" +++ show/varity/s x
    | VPINSRW x: "VPINSRW" +++ show/varity/s x
    | VPMADDUBSW x: "VPMADDUBSW" +++ show/varity/s x
    | VPMADDWD x: "VPMADDWD" +++ show/varity/s x
    | VPMAXSB x: "VPMAXSB" +++ show/varity/s x
    | VPMAXSD x: "VPMAXSD" +++ show/varity/s x
    | VPMAXSW x: "VPMAXSW" +++ show/varity/s x
    | VPMAXUB x: "VPMAXUB" +++ show/varity/s x
    | VPMAXUD x: "VPMAXUD" +++ show/varity/s x
    | VPMAXUW x: "VPMAXUW" +++ show/varity/s x
    | VPMINSB x: "VPMINSB" +++ show/varity/s x
    | VPMINSD x: "VPMINSD" +++ show/varity/s x
    | VPMINSW x: "VPMINSW" +++ show/varity/s x
    | VPMINUB x: "VPMINUB" +++ show/varity/s x
    | VPMINUD x: "VPMINUD" +++ show/varity/s x
    | VPMINUW x: "VPMINUW" +++ show/varity/s x
    | VPMOVMSKB x: "VPMOVMSKB" +++ show/varity/s x
    | VPMOVSXBD x: "VPMOVSXBD" +++ show/varity/s x
    | VPMOVSXBQ x: "VPMOVSXBQ" +++ show/varity/s x
    | VPMOVSXBW x: "VPMOVSXBW" +++ show/varity/s x
    | VPMOVSXDQ x: "VPMOVSXDQ" +++ show/varity/s x
    | VPMOVSXWD x: "VPMOVSXWD" +++ show/varity/s x
    | VPMOVSXWQ x: "VPMOVSXWQ" +++ show/varity/s x
    | VPMOVZXBD x: "VPMOVZXBD" +++ show/varity/s x
    | VPMOVZXBQ x: "VPMOVZXBQ" +++ show/varity/s x
    | VPMOVZXBW x: "VPMOVZXBW" +++ show/varity/s x
    | VPMOVZXDQ x: "VPMOVZXDQ" +++ show/varity/s x
    | VPMOVZXWD x: "VPMOVZXWD" +++ show/varity/s x
    | VPMOVZXWQ x: "VPMOVZXWQ" +++ show/varity/s x
    | VPMULDQ x: "VPMULDQ" +++ show/varity/s x
    | VPMULHRSW x: "VPMULHRSW" +++ show/varity/s x
    | VPMULHUW x: "VPMULHUW" +++ show/varity/s x
    | VPMULHW x: "VPMULHW" +++ show/varity/s x
    | VPMULLD x: "VPMULLD" +++ show/varity/s x
    | VPMULLW x: "VPMULLW" +++ show/varity/s x
    | VPMULUDQ x: "VPMULUDQ" +++ show/varity/s x
    | VPOR x: "VPOR" +++ show/varity/s x
    | VPSADBW x: "VPSADBW" +++ show/varity/s x
    | VPSHUFB x: "VPSHUFB" +++ show/varity/s x
    | VPSHUFD x: "VPSHUFD" +++ show/varity/s x
    | VPSHUFHW x: "VPSHUFHW" +++ show/varity/s x
    | VPSHUFLW x: "VPSHUFLW" +++ show/varity/s x
    | VPSIGNB x: "VPSIGNB" +++ show/varity/s x
    | VPSIGND x: "VPSIGND" +++ show/varity/s x
    | VPSIGNW x: "VPSIGNW" +++ show/varity/s x
    | VPSLLD x: "VPSLLD" +++ show/varity/s x
    | VPSLLDQ x: "VPSLLDQ" +++ show/varity/s x
    | VPSLLQ x: "VPSLLQ" +++ show/varity/s x
    | VPSLLW x: "VPSLLW" +++ show/varity/s x
    | VPSRAD x: "VPSRAD" +++ show/varity/s x
    | VPSRAW x: "VPSRAW" +++ show/varity/s x
    | VPSRLD x: "VPSRLD" +++ show/varity/s x
    | VPSRLDQ x: "VPSRLDQ" +++ show/varity/s x
    | VPSRLQ x: "VPSRLQ" +++ show/varity/s x
    | VPSRLW x: "VPSRLW" +++ show/varity/s x
    | VPSUBB x: "VPSUBB" +++ show/varity/s x
    | VPSUBD x: "VPSUBD" +++ show/varity/s x
    | VPSUBQ x: "VPSUBQ" +++ show/varity/s x
    | VPSUBSB x: "VPSUBSB" +++ show/varity/s x
    | VPSUBSW x: "VPSUBSW" +++ show/varity/s x
    | VPSUBUSB x: "VPSUBUSB" +++ show/varity/s x
    | VPSUBUSW x: "VPSUBUSW" +++ show/varity/s x
    | VPSUBW x: "VPSUBW" +++ show/varity/s x
    | VPTEST x: "VPTEST" +++ show/varity/s x
    | VPUNPCKHBW x: "VPUNPCKHBW" +++ show/varity/s x
    | VPUNPCKHDQ x: "VPUNPCKHDQ" +++ show/varity/s x
    | VPUNPCKHQDQ x: "VPUNPCKHQDQ" +++ show/varity/s x
    | VPUNPCKHWD x: "VPUNPCKHWD" +++ show/varity/s x
    | VPUNPCKLBW x: "VPUNPCKLBW" +++ show/varity/s x
    | VPUNPCKLDQ x: "VPUNPCKLDQ" +++ show/varity/s x
    | VPUNPCKLQDQ x: "VPUNPCKLQDQ" +++ show/varity/s x
    | VPUNPCKLWD x: "VPUNPCKLWD" +++ show/varity/s x
    | VPXOR x: "VPXOR" +++ show/varity/s x
    | VRCPPS x: "VRCPPS" +++ show/varity/s x
    | VRCPSS x: "VRCPSS" +++ show/varity/s x
    | VROUNDPD x: "VROUNDPD" +++ show/varity/s x
    | VROUNDPS x: "VROUNDPS" +++ show/varity/s x
    | VROUNDSD x: "VROUNDSD" +++ show/varity/s x
    | VROUNDSS x: "VROUNDSS" +++ show/varity/s x
    | VRSQRTPS x: "VRSQRTPS" +++ show/varity/s x
    | VRSQRTSS x: "VRSQRTSS" +++ show/varity/s x
    | VSHUFPD x: "VSHUFPD" +++ show/varity/s x
    | VSHUFPS x: "VSHUFPS" +++ show/varity/s x
    | VSQRTPD x: "VSQRTPD" +++ show/varity/s x
    | VSQRTPS x: "VSQRTPS" +++ show/varity/s x
    | VSQRTSD x: "VSQRTSD" +++ show/varity/s x
    | VSQRTSS x: "VSQRTSS" +++ show/varity/s x
    | VSTMXCSR x: "VSTMXCSR" +++ show/varity/s x
    | VSUBPD x: "VSUBPD" +++ show/varity/s x
    | VSUBPS x: "VSUBPS" +++ show/varity/s x
    | VSUBSD x: "VSUBSD" +++ show/varity/s x
    | VSUBSS x: "VSUBSS" +++ show/varity/s x
    | VTESTPD x: "VTESTPD" +++ show/varity/s x
    | VTESTPS x: "VTESTPS" +++ show/varity/s x
    | VUCOMISD x: "VUCOMISD" +++ show/varity/s x
    | VUCOMISS x: "VUCOMISS" +++ show/varity/s x
    | VUNPCKHPD x: "VUNPCKHPD" +++ show/varity/s x
    | VUNPCKHPS x: "VUNPCKHPS" +++ show/varity/s x
    | VUNPCKLPD x: "VUNPCKLPD" +++ show/varity/s x
    | VUNPCKLPS x: "VUNPCKLPS" +++ show/varity/s x
    | VXORPD x: "VXORPD" +++ show/varity/s x
    | VXORPS x: "VXORPS" +++ show/varity/s x
    | VZEROALL x: "VZEROALL" +++ show/varity/s x
    | VZEROUPPER x: "VZEROUPPER" +++ show/varity/s x
    | WAIT: "WAIT"
    | WBINVD: "WBINVD"
    | WRFSBASE x: "WRFSBASE" -++ show/arity1/s x
    | WRGSBASE x: "WRGSBASE" -++ show/arity1/s x
    | WRMSR: "WRMSR"
    | XADD x: "XADD" -++ show/arity2/s x
    | XCHG x: "XCHG" -++ show/arity2/s x
    | XGETBV: "XGETBV"
    | XLATB: "XLATB"
    | XOR x: "XOR" -++ show/arity2/s x
    | XORPD x: "XORPD" -++ show/arity2/s x
    | XORPS x: "XORPS" -++ show/arity2/s x
    | XRSTOR x: "XRSTOR" -++ show/arity1/s x
    | XRSTOR64 x: "XRSTOR64" -++ show/arity1/s x
    | XSAVE x: "XSAVE" -++ show/arity1/s x
    | XSAVE64 x: "XSAVE64" -++ show/arity1/s x
    | XSAVEOPT x: "XSAVEOPT" -++ show/arity1/s x
    | XSAVEOPT64 x: "XSAVEOPT64" -++ show/arity1/s x
    | XSETBV: "XSETBV"
    #| PSLRDQ x: "PSLRDQ" -++ show/arity2/s x
    #| VPSLRDQ x: "VPSLRDQ" +++ show/varity/s x
   end
#s/^\(...\)\(\S*\)\s*$/\1\2: "\2"/
#s/^\(...\)\(\S*\) of \(\S*\)\s*$/\1\2 x: "\2" -++ show\/\3 x/
