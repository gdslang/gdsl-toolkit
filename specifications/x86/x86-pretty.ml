# vim:filetype=sml:ts=3:sw=3:expandtab

export = pretty{lock, rep, repne, features, insn} pretty-operand{insn} pretty-mnemonic{insn}

val flow_decode_pretty = do
  inge <- decode config-default;
  return (pretty inge)
end

val pretty i = show/prefixes i +++ show/instruction i.insn -++ (show/features i)

val show/features i =
  if i.features == none then
	  ""
	else
	  " {" +++ (show/features/any "" i.features '1') +++ "}"

val show/features/any acc features first = let
  val append this =
	  if first then
		  this
		else
		  ", " +++ this

	val next me me-str rest =
    if (features and me) == me then
	     show/features/any (append me-str) (features and (not me)) '0'
	  else
	    rest
in
  acc +++
  next aes "AES" (
  next avx "AVX" (
  next f16c "F16C" (
  next invpcid "INVPCID" (
  next mmx "MMX" (
  next clmul "CLMUL" (
  next rdrand "RDRAND" (
  next fsgsbase "FSGSBASE" (
  next sse "SSE" (
  next sse2 "SSE2" (
  next sse3 "SSE3" (
  next sse4_1 "SSE41" (
  next sse4_2 "SSE42" (
  next ssse3 "SSSE3" (
  next xsaveopt "XSAVEOPT" (
  next illegal-rep "ILLEGAL REP" (
  next illegal-repne "ILLEGAL REPNE" (
  next illegal-lock "ILLEGAL LOCK" (
  next illegal-lock-register "ILLEGAL LOCK REGISTER" 
  ""))))))))))))))))))
end

val show/prefixes arity = let
  val first = {any='0', acc=""}

  val next cond str last =
    if cond then
      if last.any then
        {any=last.any, acc=last.acc +++ ", " +++ str}
      else
        {any='1', acc="[" +++ str}
    else
      last
  
  val all =
#    next arity.opnd-sz "OPNDSZ" (
#    next arity.addr-sz "ADDRSZ" (
    next arity.rep "REP" (
    next arity.repne "REPNE" (
    next arity.lock "LOCK" (
    first)))
in
  if all.any then
    all.acc +++ "] "
  else
    ""
end

val show/arity1 x = show/operand '0' x.opnd1
val show/arity2 x = show/operand '0' x.opnd1 +++ ", " +++ show/operand '0' x.opnd2
val show/arity3 x = show/operand '0' x.opnd1 +++ ", " +++ show/operand '0' x.opnd2 +++ ", " +++ show/operand '0' x.opnd3
val show/arity4 x = show/operand '0' x.opnd1 +++ ", " +++ show/operand '0' x.opnd2 +++ ", " +++ show/operand '0' x.opnd3 +++ ", " +++ show/operand '0' x.opnd4
val show/flow1 x = show/flowoperand x.opnd1
val show/varity x =
   case x of
      VA0: ""
    | VA1 x: " " +++ show/arity1 x
    | VA2 x: " " +++ show/arity2 x
    | VA3 x: " " +++ show/arity3 x
    | VA4 x: " " +++ show/arity4 x
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
    | R8L  : "R8L"
    | R8W  : "R8W"
    | R8D  : "R8D"
    | R8   : "R8"
    | R9L  : "R9L"
    | R9W  : "R9W"
    | R9D  : "R9D"
    | R9   : "R9"
    | R10L : "R10L"
    | R10W : "R10W"
    | R10D : "R10D"
    | R10  : "R10"
    | R11L : "R11L"
    | R11W : "R11W"
    | R11D : "R11D"
    | R11  : "R11"
    | R12L : "R12L"
    | R12W : "R12W"
    | R12D : "R12D"
    | R12  : "R12"
    | R13L : "R13L"
    | R13W : "R13W"
    | R13D : "R13D"
    | R13  : "R13"
    | R14L : "R14L"
    | R14W : "R14W"
    | R14D : "R14D"
    | R14  : "R14"
    | R15L : "R15L"
    | R15W : "R15W"
    | R15D : "R15D"
    | R15  : "R15"
    | SPL  : "SPL"
    | SP   : "SP"
    | ESP  : "ESP"
    | RSP  : "RSP"
    | BPL  : "BPL"
    | BP   : "BP"
    | EBP  : "EBP"
    | RBP  : "RBP"
    | SIL  : "SIL"
    | SI   : "SI"
    | ESI  : "ESI"
    | RSI  : "RSI"
    | DIL  : "DIL"
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
    | _: "PTR(" +++ show-int sz +++ ")"
   end

val show/segment s = 
   case s of
      SEG_NONE: ""
    | SEG_OVERRIDE r:
        case r of
	   DS: ""
	 | s: show/register s +++ ":"
        end
   end

val show/scale s = 
   case s of
      '00': ""
    | '01': "2*"
    | '10': "4*"
    | '11': "8*"
   end

val show/operand ext op =
   case op of
#      IMM8 x: show-int (case ext of '0': zx x.imm | '1': sx x.imm end) +++ "@" +++ show-int x.address
#    | IMM16 x: show-int (case ext of '0': zx x.imm | '1': sx x.imm end) +++ "@" +++ show-int x.address
#    | IMM32 x: show-int (case ext of '0': zx x.imm | '1': sx x.imm end) +++ "@" +++ show-int x.address
#    | IMM64 x: show-int (case ext of '0': zx x.imm | '1': sx x.imm end) +++ "@" +++ show-int x.address
      IMM8 x: show-int (case ext of '0': zx x.imm | '1': sx x.imm end)
    | IMM16 x: show-int (case ext of '0': zx x.imm | '1': sx x.imm end)
    | IMM32 x: show-int (case ext of '0': zx x.imm | '1': sx x.imm end)
    | IMM64 x: show-int (case ext of '0': zx x.imm | '1': sx x.imm end)
    | REG x: show/register x
    | MEM x: show/memsz x.sz -++ show/segment x.segment +++ "[" +++ show/operand '1' x.opnd +++ "]" 
    | X86_SUM x: show/operand ext x.a +++ "+" +++ show/operand ext x.b
    | X86_SCALE x: show/scale x.imm +++ show/operand ext x.opnd
   end

val show/flowoperand op =
   case op of
      REL8 x: "(IP + " +++ show-int (sx x) +++ ")"
    | REL16 x: "(IP + " +++ show-int (sx x) +++ ")"
    | REL32 x: "(IP + " +++ show-int (sx x) +++ ")"
    | REL64 x: "(IP + " +++ show-int (sx x) +++ ")"
    | PTR16/16 x: "[16/16: " +++ show-int (sx x) +++ "]"
    | PTR16/32 x: "[16/32: " +++ show-int (sx x) +++ "]"
    | NEARABS x: show/operand '1' x 
    | FARABS x: show/operand '1' x
   end

val show/instruction insn =
   case insn of
      AAA: show/mnemonic insn
    | AAD x: show/mnemonic insn -++ show/arity1 x
    | AAM x: show/mnemonic insn -++ show/arity1 x
    | AAS: show/mnemonic insn
    | ADC x: show/mnemonic insn -++ show/arity2 x
    | ADD x: show/mnemonic insn -++ show/arity2 x
    | ADDPD x: show/mnemonic insn -++ show/arity2 x
    | ADDPS x: show/mnemonic insn -++ show/arity2 x
    | ADDSD x: show/mnemonic insn -++ show/arity2 x
    | ADDSS x: show/mnemonic insn -++ show/arity2 x
    | ADDSUBPD x: show/mnemonic insn -++ show/arity2 x
    | ADDSUBPS x: show/mnemonic insn -++ show/arity2 x
    | AESDEC x: show/mnemonic insn -++ show/arity2 x
    | AESDECLAST x: show/mnemonic insn -++ show/arity2 x
    | AESENC x: show/mnemonic insn -++ show/arity2 x
    | AESENCLAST x: show/mnemonic insn -++ show/arity2 x
    | AESIMC x: show/mnemonic insn -++ show/arity2 x
    | AESKEYGENASSIST x: show/mnemonic insn -++ show/arity3 x
    | AND x: show/mnemonic insn -++ show/arity2 x
    | ANDNPD x: show/mnemonic insn -++ show/arity2 x
    | ANDNPS x: show/mnemonic insn -++ show/arity2 x
    | ANDPD x: show/mnemonic insn -++ show/arity2 x
    | ANDPS x: show/mnemonic insn -++ show/arity2 x
    | ARPL x: show/mnemonic insn -++ show/arity2 x
    | BLENDPD x: show/mnemonic insn -++ show/arity3 x
    | BLENDPS x: show/mnemonic insn -++ show/arity3 x
    | BLENDVPD x: show/mnemonic insn -++ show/arity3 x
    | BLENDVPS x: show/mnemonic insn -++ show/arity3 x
    | BOUND x: show/mnemonic insn -++ show/arity2 x
    | BSF x: show/mnemonic insn -++ show/arity2 x
    | BSR x: show/mnemonic insn -++ show/arity2 x
    | BSWAP x: show/mnemonic insn -++ show/arity1 x
    | BT x: show/mnemonic insn -++ show/arity2 x
    | BTC x: show/mnemonic insn -++ show/arity2 x
    | BTR x: show/mnemonic insn -++ show/arity2 x
    | BTS x: show/mnemonic insn -++ show/arity2 x
    | CALL x: show/mnemonic insn -++ show/flow1 x
    | CBW: show/mnemonic insn
    | CDQ: show/mnemonic insn
    | CDQE: show/mnemonic insn
    | CLC: show/mnemonic insn
    | CLD: show/mnemonic insn
    | CLFLUSH x: show/mnemonic insn -++ show/arity1 x
    | CLI: show/mnemonic insn
    | CLTS: show/mnemonic insn
    | CMC: show/mnemonic insn
    | CMOVA x: show/mnemonic insn -++ show/arity2 x
    | CMOVAE x: show/mnemonic insn -++ show/arity2 x
    | CMOVB x: show/mnemonic insn -++ show/arity2 x
    | CMOVBE x: show/mnemonic insn -++ show/arity2 x
    | CMOVC x: show/mnemonic insn -++ show/arity2 x
    | CMOVE x: show/mnemonic insn -++ show/arity2 x
    | CMOVG x: show/mnemonic insn -++ show/arity2 x
    | CMOVGE x: show/mnemonic insn -++ show/arity2 x
    | CMOVL x: show/mnemonic insn -++ show/arity2 x
    | CMOVLE x: show/mnemonic insn -++ show/arity2 x
    | CMOVNA x: show/mnemonic insn -++ show/arity2 x
    | CMOVNAE x: show/mnemonic insn -++ show/arity2 x
    | CMOVNB x: show/mnemonic insn -++ show/arity2 x
    | CMOVNBE x: show/mnemonic insn -++ show/arity2 x
    | CMOVNC x: show/mnemonic insn -++ show/arity2 x
    | CMOVNE x: show/mnemonic insn -++ show/arity2 x
    | CMOVNG x: show/mnemonic insn -++ show/arity2 x
    | CMOVNGE x: show/mnemonic insn -++ show/arity2 x
    | CMOVNL x: show/mnemonic insn -++ show/arity2 x
    | CMOVNLE x: show/mnemonic insn -++ show/arity2 x
    | CMOVNO x: show/mnemonic insn -++ show/arity2 x
    | CMOVNP x: show/mnemonic insn -++ show/arity2 x
    | CMOVNS x: show/mnemonic insn -++ show/arity2 x
    | CMOVNZ x: show/mnemonic insn -++ show/arity2 x
    | CMOVO x: show/mnemonic insn -++ show/arity2 x
    | CMOVP x: show/mnemonic insn -++ show/arity2 x
    | CMOVPE x: show/mnemonic insn -++ show/arity2 x
    | CMOVPO x: show/mnemonic insn -++ show/arity2 x
    | CMOVS x: show/mnemonic insn -++ show/arity2 x
    | CMOVZ x: show/mnemonic insn -++ show/arity2 x
    | CMP x: show/mnemonic insn -++ show/arity2 x
    | CMPPD x: show/mnemonic insn -++ show/arity3 x
    | CMPPS x: show/mnemonic insn -++ show/arity3 x
    | CMPS x: show/mnemonic insn -++ show/arity2 x
    | CMPSD x: show/mnemonic insn -++ show/arity3 x
    | CMPSS x: show/mnemonic insn -++ show/arity3 x
    | CMPXCHG x: show/mnemonic insn -++ show/arity2 x
    | CMPXCHG16B x: show/mnemonic insn -++ show/arity1 x
    | CMPXCHG8B x: show/mnemonic insn -++ show/arity1 x
    | COMISD x: show/mnemonic insn -++ show/arity2 x
    | COMISS x: show/mnemonic insn -++ show/arity2 x
    | CPUID: show/mnemonic insn
    | CQO: show/mnemonic insn
    | CRC32 x: show/mnemonic insn -++ show/arity2 x
    | CVTDQ2PD x: show/mnemonic insn -++ show/arity2 x
    | CVTDQ2PS x: show/mnemonic insn -++ show/arity2 x
    | CVTPD2DQ x: show/mnemonic insn -++ show/arity2 x
    | CVTPD2PI x: show/mnemonic insn -++ show/arity2 x
    | CVTPD2PS x: show/mnemonic insn -++ show/arity2 x
    | CVTPI2PD x: show/mnemonic insn -++ show/arity2 x
    | CVTPI2PS x: show/mnemonic insn -++ show/arity2 x
    | CVTPS2DQ x: show/mnemonic insn -++ show/arity2 x
    | CVTPS2PD x: show/mnemonic insn -++ show/arity2 x
    | CVTPS2PI x: show/mnemonic insn -++ show/arity2 x
    | CVTSD2SI x: show/mnemonic insn -++ show/arity2 x
    | CVTSD2SS x: show/mnemonic insn -++ show/arity2 x
    | CVTSI2SD x: show/mnemonic insn -++ show/arity2 x
    | CVTSI2SS x: show/mnemonic insn -++ show/arity2 x
    | CVTSS2SD x: show/mnemonic insn -++ show/arity2 x
    | CVTSS2SI x: show/mnemonic insn -++ show/arity2 x
    | CVTTPD2DQ x: show/mnemonic insn -++ show/arity2 x
    | CVTTPD2PI x: show/mnemonic insn -++ show/arity2 x
    | CVTTPS2DQ x: show/mnemonic insn -++ show/arity2 x
    | CVTTPS2PI x: show/mnemonic insn -++ show/arity2 x
    | CVTTSD2SI x: show/mnemonic insn -++ show/arity2 x
    | CVTTSS2SI x: show/mnemonic insn -++ show/arity2 x
    | CWD: show/mnemonic insn
    | CWDE: show/mnemonic insn
    | DAA: show/mnemonic insn
    | DAS: show/mnemonic insn
    | DEC x: show/mnemonic insn -++ show/arity1 x
    | DIV x: show/mnemonic insn -++ show/arity1 x
    | DIVPD x: show/mnemonic insn -++ show/arity2 x
    | DIVPS x: show/mnemonic insn -++ show/arity2 x
    | DIVSD x: show/mnemonic insn -++ show/arity2 x
    | DIVSS x: show/mnemonic insn -++ show/arity2 x
    | DPPD x: show/mnemonic insn -++ show/arity3 x
    | DPPS x: show/mnemonic insn -++ show/arity3 x
    | EMMS: show/mnemonic insn
    | ENTER x: show/mnemonic insn -++ show/arity2 x
    | EXTRACTPS x: show/mnemonic insn -++ show/arity3 x
    | F2XM1: show/mnemonic insn
    | FABS: show/mnemonic insn
    | FADD x: show/mnemonic insn -++ show/arity2 x
    | FADDP x: show/mnemonic insn -++ show/arity2 x
    | FBLD x: show/mnemonic insn -++ show/arity1 x
    | FBSTP x: show/mnemonic insn -++ show/arity1 x
    | FCHS: show/mnemonic insn
    | FCLEX: show/mnemonic insn
    | FCMOVB x: show/mnemonic insn -++ show/arity2 x
    | FCMOVBE x: show/mnemonic insn -++ show/arity2 x
    | FCMOVE x: show/mnemonic insn -++ show/arity2 x
    | FCMOVNB x: show/mnemonic insn -++ show/arity2 x
    | FCMOVNBE x: show/mnemonic insn -++ show/arity2 x
    | FCMOVNE x: show/mnemonic insn -++ show/arity2 x
    | FCMOVNU x: show/mnemonic insn -++ show/arity2 x
    | FCMOVU x: show/mnemonic insn -++ show/arity2 x
    | FCOM x: show/mnemonic insn -++ show/arity1 x
    | FCOMI x: show/mnemonic insn -++ show/arity2 x
    | FCOMIP x: show/mnemonic insn -++ show/arity2 x
    | FCOMP x: show/mnemonic insn -++ show/arity1 x
    | FCOMPP: show/mnemonic insn
    | FCOS: show/mnemonic insn
    | FDECSTP: show/mnemonic insn
    | FDIV x: show/mnemonic insn -++ show/arity2 x
    | FDIVP x: show/mnemonic insn -++ show/arity2 x
    | FDIVR x: show/mnemonic insn -++ show/arity2 x
    | FDIVRP x: show/mnemonic insn -++ show/arity2 x
    | FFREE x: show/mnemonic insn -++ show/arity1 x
    | FIADD x: show/mnemonic insn -++ show/arity1 x
    | FICOM x: show/mnemonic insn -++ show/arity1 x
    | FICOMP x: show/mnemonic insn -++ show/arity1 x
    | FIDIV x: show/mnemonic insn -++ show/arity2 x
    | FIDIVR x: show/mnemonic insn -++ show/arity1 x
    | FILD x: show/mnemonic insn -++ show/arity1 x
    | FIMUL x: show/mnemonic insn -++ show/arity1 x
    | FINCSTP: show/mnemonic insn
    | FINIT: show/mnemonic insn
    | FIST x: show/mnemonic insn -++ show/arity1 x
    | FISTP x: show/mnemonic insn -++ show/arity1 x
    | FISTTP x: show/mnemonic insn -++ show/arity1 x
    | FISUB x: show/mnemonic insn -++ show/arity1 x
    | FISUBR x: show/mnemonic insn -++ show/arity1 x
    | FLD x: show/mnemonic insn -++ show/arity1 x
    | FLD1: show/mnemonic insn
    | FLDCW x: show/mnemonic insn -++ show/arity1 x
    | FLDENV x: show/mnemonic insn -++ show/arity1 x
    | FLDL2E: show/mnemonic insn
    | FLDL2T: show/mnemonic insn
    | FLDLG2: show/mnemonic insn
    | FLDLN2: show/mnemonic insn
    | FLDPI: show/mnemonic insn
    | FLDZ: show/mnemonic insn
    | FMUL x: show/mnemonic insn -++ show/arity2 x
    | FMULP x: show/mnemonic insn -++ show/arity2 x
    | FNCLEX: show/mnemonic insn
    | FNINIT: show/mnemonic insn
    | FNOP: show/mnemonic insn
    | FNSAVE x: show/mnemonic insn -++ show/arity1 x
    | FNSTCW x: show/mnemonic insn -++ show/arity1 x
    | FNSTENV x: show/mnemonic insn -++ show/arity1 x
    | FNSTSW x: show/mnemonic insn -++ show/arity1 x
    | FPATAN: show/mnemonic insn
    | FPREM1: show/mnemonic insn
    | FPREM: show/mnemonic insn
    | FPTAN: show/mnemonic insn
    | FRNDINT: show/mnemonic insn
    | FRSTOR x: show/mnemonic insn -++ show/arity1 x
    | FSAVE x: show/mnemonic insn -++ show/arity1 x
    | FSCALE: show/mnemonic insn
    | FSIN: show/mnemonic insn
    | FSINCOS: show/mnemonic insn
    | FSQRT: show/mnemonic insn
    | FST x: show/mnemonic insn -++ show/arity1 x
    | FSTCW x: show/mnemonic insn -++ show/arity1 x
    | FSTENV x: show/mnemonic insn -++ show/arity1 x
    | FSTP x: show/mnemonic insn -++ show/arity1 x
    | FSTSW x: show/mnemonic insn -++ show/arity1 x
    | FSUB x: show/mnemonic insn -++ show/arity2 x
    | FSUBP x: show/mnemonic insn -++ show/arity2 x
    | FSUBR x: show/mnemonic insn -++ show/arity2 x
    | FSUBRP x: show/mnemonic insn -++ show/arity2 x
    | FTST: show/mnemonic insn
    | FUCOM x: show/mnemonic insn -++ show/arity1 x
    | FUCOMI x: show/mnemonic insn -++ show/arity1 x
    | FUCOMIP x: show/mnemonic insn -++ show/arity1 x
    | FUCOMP x: show/mnemonic insn -++ show/arity1 x
    | FUCOMPP: show/mnemonic insn
    | FXAM: show/mnemonic insn
    | FXCH x: show/mnemonic insn -++ show/arity1 x
    | FXRSTOR x: show/mnemonic insn -++ show/arity1 x
    | FXRSTOR64 x: show/mnemonic insn -++ show/arity1 x
    | FXSAVE x: show/mnemonic insn -++ show/arity1 x
    | FXSAVE64 x: show/mnemonic insn -++ show/arity1 x
    | FXTRACT: show/mnemonic insn
    | FYL2X: show/mnemonic insn
    | FYL2XP1: show/mnemonic insn
    | HADDPD x: show/mnemonic insn -++ show/arity2 x
    | HADDPS x: show/mnemonic insn -++ show/arity2 x
    | HLT: show/mnemonic insn
    | HSUBPD x: show/mnemonic insn -++ show/arity2 x
    | HSUBPS x: show/mnemonic insn -++ show/arity2 x
    | IDIV x: show/mnemonic insn -++ show/arity1 x
    | IMUL x: show/mnemonic insn +++ show/varity x
    | IN x: show/mnemonic insn -++ show/arity2 x
    | INC x: show/mnemonic insn -++ show/arity1 x
    | INSB: show/mnemonic insn
    | INSD: show/mnemonic insn
    | INSERTPS x: show/mnemonic insn -++ show/arity3 x
    | INSW: show/mnemonic insn
    | INT x: show/mnemonic insn -++ show/arity1 x
    | INT0: show/mnemonic insn
    | INT3: show/mnemonic insn
    | INVD: show/mnemonic insn
    | INVLPG x: show/mnemonic insn -++ show/arity1 x
    | INVPCID x: show/mnemonic insn -++ show/arity2 x
    | IRET: show/mnemonic insn
    | IRETD: show/mnemonic insn
    | IRETQ: show/mnemonic insn
    | JA x: show/mnemonic insn -++ show/flow1 x
    | JAE x: show/mnemonic insn -++ show/flow1 x
    | JB x: show/mnemonic insn -++ show/flow1 x
    | JBE x: show/mnemonic insn -++ show/flow1 x
    | JC x: show/mnemonic insn -++ show/flow1 x
    | JCXZ x: show/mnemonic insn -++ show/flow1 x
    | JE x: show/mnemonic insn -++ show/flow1 x
    | JECXZ x: show/mnemonic insn -++ show/flow1 x
    | JG x: show/mnemonic insn -++ show/flow1 x
    | JGE x: show/mnemonic insn -++ show/flow1 x
    | JL x: show/mnemonic insn -++ show/flow1 x
    | JLE x: show/mnemonic insn -++ show/flow1 x
    | JMP x: show/mnemonic insn -++ show/flow1 x
    | JNA x: show/mnemonic insn -++ show/flow1 x
    | JNAE x: show/mnemonic insn -++ show/flow1 x
    | JNB x: show/mnemonic insn -++ show/flow1 x
    | JNBE x: show/mnemonic insn -++ show/flow1 x
    | JNC x: show/mnemonic insn -++ show/flow1 x
    | JNE x: show/mnemonic insn -++ show/flow1 x
    | JNG x: show/mnemonic insn -++ show/flow1 x
    | JNGE x: show/mnemonic insn -++ show/flow1 x
    | JNL x: show/mnemonic insn -++ show/flow1 x
    | JNLE x: show/mnemonic insn -++ show/flow1 x
    | JNO x: show/mnemonic insn -++ show/flow1 x
    | JNP x: show/mnemonic insn -++ show/flow1 x
    | JNS x: show/mnemonic insn -++ show/flow1 x
    | JNZ x: show/mnemonic insn -++ show/flow1 x
    | JO x: show/mnemonic insn -++ show/flow1 x
    | JP x: show/mnemonic insn -++ show/flow1 x
    | JPE x: show/mnemonic insn -++ show/flow1 x
    | JPO x: show/mnemonic insn -++ show/flow1 x
    | JRCXZ x: show/mnemonic insn -++ show/flow1 x
    | JS x: show/mnemonic insn -++ show/flow1 x
    | JZ x: show/mnemonic insn -++ show/flow1 x
    | LAHF: show/mnemonic insn
    | LAR x: show/mnemonic insn -++ show/arity2 x
    | LDDQU x: show/mnemonic insn -++ show/arity2 x
    | LDMXCSR x: show/mnemonic insn -++ show/arity1 x
    | LDS x: show/mnemonic insn -++ show/arity2 x
    | LEA x: show/mnemonic insn -++ show/arity2 x
    | LEAVE: show/mnemonic insn
    | LES x: show/mnemonic insn -++ show/arity2 x
    | LFENCE: show/mnemonic insn
    | LFS x: show/mnemonic insn -++ show/arity2 x
    | LGDT x: show/mnemonic insn -++ show/arity1 x
    | LGS x: show/mnemonic insn -++ show/arity2 x
    | LIDT x: show/mnemonic insn -++ show/arity1 x
    | LLDT x: show/mnemonic insn -++ show/arity1 x
    | LMSW x: show/mnemonic insn -++ show/arity1 x
    | LODS x: show/mnemonic insn -++ show/arity1 x
    | LOOP x: show/mnemonic insn -++ show/flow1 x
    | LOOPE x: show/mnemonic insn -++ show/flow1 x
    | LOOPNE x: show/mnemonic insn -++ show/flow1 x
    | LSL x: show/mnemonic insn -++ show/arity2 x
    | LSS x: show/mnemonic insn -++ show/arity2 x
    | LTR x: show/mnemonic insn -++ show/arity1 x
    | MASKMOVDQU x: show/mnemonic insn -++ show/arity3 x
    | MASKMOVQ x: show/mnemonic insn -++ show/arity3 x
    | MAXPD x: show/mnemonic insn -++ show/arity2 x
    | MAXPS x: show/mnemonic insn -++ show/arity2 x
    | MAXSD x: show/mnemonic insn -++ show/arity2 x
    | MAXSS x: show/mnemonic insn -++ show/arity2 x
    | MFENCE: show/mnemonic insn
    | MINPD x: show/mnemonic insn -++ show/arity2 x
    | MINPS x: show/mnemonic insn -++ show/arity2 x
    | MINSD x: show/mnemonic insn -++ show/arity2 x
    | MINSS x: show/mnemonic insn -++ show/arity2 x
    | MONITOR: show/mnemonic insn
    | MOV x: show/mnemonic insn -++ show/arity2 x
    | MOVAPD x: show/mnemonic insn -++ show/arity2 x
    | MOVAPS x: show/mnemonic insn -++ show/arity2 x
    | MOVBE x: show/mnemonic insn -++ show/arity2 x
    | MOVD x: show/mnemonic insn -++ show/arity2 x
    | MOVDDUP x: show/mnemonic insn -++ show/arity2 x
    | MOVDQ2Q x: show/mnemonic insn -++ show/arity2 x
    | MOVDQA x: show/mnemonic insn -++ show/arity2 x
    | MOVDQU x: show/mnemonic insn -++ show/arity2 x
    | MOVHLPS x: show/mnemonic insn -++ show/arity2 x
    | MOVHPD x: show/mnemonic insn -++ show/arity2 x
    | MOVHPS x: show/mnemonic insn -++ show/arity2 x
    | MOVLHPS x: show/mnemonic insn -++ show/arity2 x
    | MOVLPD x: show/mnemonic insn -++ show/arity2 x
    | MOVLPS x: show/mnemonic insn -++ show/arity2 x
    | MOVMSKPD x: show/mnemonic insn -++ show/arity2 x
    | MOVMSKPS x: show/mnemonic insn -++ show/arity2 x
    | MOVNTDQ x: show/mnemonic insn -++ show/arity2 x
    | MOVNTDQA x: show/mnemonic insn -++ show/arity2 x
    | MOVNTI x: show/mnemonic insn -++ show/arity2 x
    | MOVNTPD x: show/mnemonic insn -++ show/arity2 x
    | MOVNTPS x: show/mnemonic insn -++ show/arity2 x
    | MOVNTQ x: show/mnemonic insn -++ show/arity2 x
    | MOVQ x: show/mnemonic insn -++ show/arity2 x
    | MOVQ2DQ x: show/mnemonic insn -++ show/arity2 x
    | MOVS x: show/mnemonic insn -++ show/arity2 x
    | MOVSD x: show/mnemonic insn -++ show/arity2 x
    | MOVSHDUP x: show/mnemonic insn -++ show/arity2 x
    | MOVSLDUP x: show/mnemonic insn -++ show/arity2 x
    | MOVSS x: show/mnemonic insn -++ show/arity2 x
    | MOVSW x: show/mnemonic insn -++ show/arity2 x
    | MOVSX x: show/mnemonic insn -++ show/arity2 x
    | MOVSXD x: show/mnemonic insn -++ show/arity2 x
    | MOVUPD x: show/mnemonic insn -++ show/arity2 x
    | MOVUPS x: show/mnemonic insn -++ show/arity2 x
    | MOVZX x: show/mnemonic insn -++ show/arity2 x
    | MPSADBW x: show/mnemonic insn -++ show/arity3 x
    | MUL x: show/mnemonic insn -++ show/arity1 x
    | MULPD x: show/mnemonic insn -++ show/arity2 x
    | MULPS x: show/mnemonic insn -++ show/arity2 x
    | MULSD x: show/mnemonic insn -++ show/arity2 x
    | MULSS x: show/mnemonic insn -++ show/arity2 x
    | MWAIT: show/mnemonic insn
    | NEG x: show/mnemonic insn -++ show/arity1 x
    | NOP x: show/mnemonic insn +++ show/varity x
    | NOT x: show/mnemonic insn -++ show/arity1 x
    | OR x: show/mnemonic insn -++ show/arity2 x
    | ORPD x: show/mnemonic insn -++ show/arity2 x
    | ORPS x: show/mnemonic insn -++ show/arity2 x
    | OUT x: show/mnemonic insn -++ show/arity2 x
    | OUTS: show/mnemonic insn
    | OUTSB: show/mnemonic insn
    | OUTSD: show/mnemonic insn
    | OUTSW: show/mnemonic insn
    | PABSB x: show/mnemonic insn -++ show/arity2 x
    | PABSD x: show/mnemonic insn -++ show/arity2 x
    | PABSW x: show/mnemonic insn -++ show/arity2 x
    | PACKSSDW x: show/mnemonic insn -++ show/arity2 x
    | PACKSSWB x: show/mnemonic insn -++ show/arity2 x
    | PACKUSDW x: show/mnemonic insn -++ show/arity2 x
    | PACKUSWB x: show/mnemonic insn -++ show/arity2 x
    | PADDB x: show/mnemonic insn -++ show/arity2 x
    | PADDD x: show/mnemonic insn -++ show/arity2 x
    | PADDQ x: show/mnemonic insn -++ show/arity2 x
    | PADDSB x: show/mnemonic insn -++ show/arity2 x
    | PADDSW x: show/mnemonic insn -++ show/arity2 x
    | PADDUSB x: show/mnemonic insn -++ show/arity2 x
    | PADDUSW x: show/mnemonic insn -++ show/arity2 x
    | PADDW x: show/mnemonic insn -++ show/arity2 x
    | PALIGNR x: show/mnemonic insn -++ show/arity3 x
    | PAND x: show/mnemonic insn -++ show/arity2 x
    | PANDN x: show/mnemonic insn -++ show/arity2 x
    | PAUSE: show/mnemonic insn
    | PAVGB x: show/mnemonic insn -++ show/arity2 x
    | PAVGW x: show/mnemonic insn -++ show/arity2 x
    | PBLENDVB x: show/mnemonic insn -++ show/arity2 x
    | PBLENDW x: show/mnemonic insn -++ show/arity3 x
    | PCLMULQDQ x: show/mnemonic insn -++ show/arity3 x
    | PCMPEQB x: show/mnemonic insn -++ show/arity2 x
    | PCMPEQD x: show/mnemonic insn -++ show/arity2 x
    | PCMPEQQ x: show/mnemonic insn -++ show/arity2 x
    | PCMPEQW x: show/mnemonic insn -++ show/arity2 x
    | PCMPESTRI x: show/mnemonic insn -++ show/arity3 x
    | PCMPESTRM x: show/mnemonic insn -++ show/arity3 x
    | PCMPGRD x: show/mnemonic insn -++ show/arity2 x
    | PCMPGTB x: show/mnemonic insn -++ show/arity2 x
    | PCMPGTD x: show/mnemonic insn -++ show/arity2 x
    | PCMPGTQ x: show/mnemonic insn -++ show/arity2 x
    | PCMPGTW x: show/mnemonic insn -++ show/arity2 x
    | PCMPISTRI x: show/mnemonic insn -++ show/arity3 x
    | PCMPISTRM x: show/mnemonic insn -++ show/arity3 x
    | PEXTRB x: show/mnemonic insn -++ show/arity3 x
    | PEXTRD x: show/mnemonic insn -++ show/arity3 x
    | PEXTRQ x: show/mnemonic insn -++ show/arity3 x
    | PEXTRW x: show/mnemonic insn -++ show/arity3 x
    | PHADDD x: show/mnemonic insn -++ show/arity2 x
    | PHADDSW x: show/mnemonic insn -++ show/arity2 x
    | PHADDW x: show/mnemonic insn -++ show/arity2 x
    | PHMINPOSUW x: show/mnemonic insn -++ show/arity2 x
    | PHSUBD x: show/mnemonic insn -++ show/arity2 x
    | PHSUBSW x: show/mnemonic insn -++ show/arity2 x
    | PHSUBW x: show/mnemonic insn -++ show/arity2 x
    | PINSRB x: show/mnemonic insn -++ show/arity3 x
    | PINSRD x: show/mnemonic insn -++ show/arity3 x
    | PINSRQ x: show/mnemonic insn -++ show/arity3 x
    | PINSRW x: show/mnemonic insn -++ show/arity3 x
    | PMADDUBSW x: show/mnemonic insn -++ show/arity2 x
    | PMADDWD x: show/mnemonic insn -++ show/arity2 x
    | PMAXSB x: show/mnemonic insn -++ show/arity2 x
    | PMAXSD x: show/mnemonic insn -++ show/arity2 x
    | PMAXSW x: show/mnemonic insn -++ show/arity2 x
    | PMAXUB x: show/mnemonic insn -++ show/arity2 x
    | PMAXUD x: show/mnemonic insn -++ show/arity2 x
    | PMAXUW x: show/mnemonic insn -++ show/arity2 x
    | PMINSB x: show/mnemonic insn -++ show/arity2 x
    | PMINSD x: show/mnemonic insn -++ show/arity2 x
    | PMINSW x: show/mnemonic insn -++ show/arity2 x
    | PMINUB x: show/mnemonic insn -++ show/arity2 x
    | PMINUD x: show/mnemonic insn -++ show/arity2 x
    | PMINUW x: show/mnemonic insn -++ show/arity2 x
    | PMOVMSKB x: show/mnemonic insn -++ show/arity2 x
    | PMOVSXBD x: show/mnemonic insn -++ show/arity2 x
    | PMOVSXBQ x: show/mnemonic insn -++ show/arity2 x
    | PMOVSXBW x: show/mnemonic insn -++ show/arity2 x
    | PMOVSXDQ x: show/mnemonic insn -++ show/arity2 x
    | PMOVSXWD x: show/mnemonic insn -++ show/arity2 x
    | PMOVSXWQ x: show/mnemonic insn -++ show/arity2 x
    | PMOVZXBD x: show/mnemonic insn -++ show/arity2 x
    | PMOVZXBQ x: show/mnemonic insn -++ show/arity2 x
    | PMOVZXBW x: show/mnemonic insn -++ show/arity2 x
    | PMOVZXDQ x: show/mnemonic insn -++ show/arity2 x
    | PMOVZXWD x: show/mnemonic insn -++ show/arity2 x
    | PMOVZXWQ x: show/mnemonic insn -++ show/arity2 x
    | PMULDQ x: show/mnemonic insn -++ show/arity2 x
    | PMULHRSW x: show/mnemonic insn -++ show/arity2 x
    | PMULHUW x: show/mnemonic insn -++ show/arity2 x
    | PMULHW x: show/mnemonic insn -++ show/arity2 x
    | PMULLD x: show/mnemonic insn -++ show/arity2 x
    | PMULLW x: show/mnemonic insn -++ show/arity2 x
    | PMULUDQ x: show/mnemonic insn -++ show/arity2 x
    | POP x: show/mnemonic insn -++ show/arity1 x
    | POPA: show/mnemonic insn
    | POPAD: show/mnemonic insn
    | POPCNT x: show/mnemonic insn -++ show/arity2 x
    | POPF: show/mnemonic insn
    | POPFD: show/mnemonic insn
    | POPFQ: show/mnemonic insn
    | POR x: show/mnemonic insn -++ show/arity2 x
    | PREFETCHNTA x: show/mnemonic insn -++ show/arity1 x
    | PREFETCHT0 x: show/mnemonic insn -++ show/arity1 x
    | PREFETCHT1 x: show/mnemonic insn -++ show/arity1 x
    | PREFETCHT2 x: show/mnemonic insn -++ show/arity1 x
    | PREFETCHW x: show/mnemonic insn -++ show/arity1 x
    | PSADBW x: show/mnemonic insn -++ show/arity2 x
    | PSHUFB x: show/mnemonic insn -++ show/arity2 x
    | PSHUFD x: show/mnemonic insn -++ show/arity3 x
    | PSHUFHW x: show/mnemonic insn -++ show/arity3 x
    | PSHUFLW x: show/mnemonic insn -++ show/arity3 x
    | PSHUFW x: show/mnemonic insn -++ show/arity3 x
    | PSIGNB x: show/mnemonic insn -++ show/arity2 x
    | PSIGND x: show/mnemonic insn -++ show/arity2 x
    | PSIGNW x: show/mnemonic insn -++ show/arity2 x
    | PSLLD x: show/mnemonic insn -++ show/arity2 x
    | PSLLDQ x: show/mnemonic insn -++ show/arity2 x
    | PSLLQ x: show/mnemonic insn -++ show/arity2 x
    | PSLLW x: show/mnemonic insn -++ show/arity2 x
    | PSRAD x: show/mnemonic insn -++ show/arity2 x
    | PSRAW x: show/mnemonic insn -++ show/arity2 x
    | PSRLD x: show/mnemonic insn -++ show/arity2 x
    | PSRLDQ x: show/mnemonic insn -++ show/arity2 x
    | PSRLQ x: show/mnemonic insn -++ show/arity2 x
    | PSRLW x: show/mnemonic insn -++ show/arity2 x
    | PSUBB x: show/mnemonic insn -++ show/arity2 x
    | PSUBD x: show/mnemonic insn -++ show/arity2 x
    | PSUBQ x: show/mnemonic insn -++ show/arity2 x
    | PSUBSB x: show/mnemonic insn -++ show/arity2 x
    | PSUBSW x: show/mnemonic insn -++ show/arity2 x
    | PSUBUSB x: show/mnemonic insn -++ show/arity2 x
    | PSUBUSW x: show/mnemonic insn -++ show/arity2 x
    | PSUBW x: show/mnemonic insn -++ show/arity2 x
    | PTEST x: show/mnemonic insn -++ show/arity2 x
    | PUNPCKHBW x: show/mnemonic insn -++ show/arity2 x
    | PUNPCKHDQ x: show/mnemonic insn -++ show/arity2 x
    | PUNPCKHQDQ x: show/mnemonic insn -++ show/arity2 x
    | PUNPCKHWD x: show/mnemonic insn -++ show/arity2 x
    | PUNPCKLBW x: show/mnemonic insn -++ show/arity2 x
    | PUNPCKLDQ x: show/mnemonic insn -++ show/arity2 x
    | PUNPCKLQDQ x: show/mnemonic insn -++ show/arity2 x
    | PUNPCKLWD x: show/mnemonic insn -++ show/arity2 x
    | PUSH x: show/mnemonic insn -++ show/arity1 x
    | PUSHA: show/mnemonic insn
    | PUSHAD: show/mnemonic insn
    | PUSHF: show/mnemonic insn
    | PUSHFD: show/mnemonic insn
    | PUSHFQ: show/mnemonic insn
    | PXOR x: show/mnemonic insn -++ show/arity2 x
    | RCL x: show/mnemonic insn -++ show/arity2 x
    | RCPPS x: show/mnemonic insn -++ show/arity2 x
    | RCPSS x: show/mnemonic insn -++ show/arity2 x
    | RCR x: show/mnemonic insn -++ show/arity2 x
    | RDFSBASE x: show/mnemonic insn -++ show/arity1 x
    | RDGSBASE x: show/mnemonic insn -++ show/arity1 x
    | RDMSR: show/mnemonic insn
    | RDPMC: show/mnemonic insn
    | RDRAND x: show/mnemonic insn -++ show/arity1 x
    | RDTSC: show/mnemonic insn
    | RDTSCP: show/mnemonic insn
    | RET x: show/mnemonic insn +++ show/varity x
    | RET_FAR x: show/mnemonic insn +++ show/varity x
    | ROL x: show/mnemonic insn -++ show/arity2 x
    | ROR x: show/mnemonic insn -++ show/arity2 x
    | ROUNDPD x: show/mnemonic insn -++ show/arity3 x
    | ROUNDPS x: show/mnemonic insn -++ show/arity3 x
    | ROUNDSD x: show/mnemonic insn -++ show/arity3 x
    | ROUNDSS x: show/mnemonic insn -++ show/arity3 x
    | RSM: show/mnemonic insn
    | RSQRTPS x: show/mnemonic insn -++ show/arity2 x
    | RSQRTSS x: show/mnemonic insn -++ show/arity2 x
    | SAHF: show/mnemonic insn
    | SAL x: show/mnemonic insn -++ show/arity2 x
    | SAR x: show/mnemonic insn -++ show/arity2 x
    | SBB x: show/mnemonic insn -++ show/arity2 x
    | SCASB: show/mnemonic insn
    | SCASD: show/mnemonic insn
    | SCASQ: show/mnemonic insn
    | SCASW: show/mnemonic insn
    | SETA x: show/mnemonic insn -++ show/arity1 x
    | SETAE x: show/mnemonic insn -++ show/arity1 x
    | SETB x: show/mnemonic insn -++ show/arity1 x
    | SETBE x: show/mnemonic insn -++ show/arity1 x
    | SETC x: show/mnemonic insn -++ show/arity1 x
    | SETE x: show/mnemonic insn -++ show/arity1 x
    | SETG x: show/mnemonic insn -++ show/arity1 x
    | SETGE x: show/mnemonic insn -++ show/arity1 x
    | SETL x: show/mnemonic insn -++ show/arity1 x
    | SETLE x: show/mnemonic insn -++ show/arity1 x
    | SETNA x: show/mnemonic insn -++ show/arity1 x
    | SETNAE x: show/mnemonic insn -++ show/arity1 x
    | SETNB x: show/mnemonic insn -++ show/arity1 x
    | SETNBE x: show/mnemonic insn -++ show/arity1 x
    | SETNC x: show/mnemonic insn -++ show/arity1 x
    | SETNE x: show/mnemonic insn -++ show/arity1 x
    | SETNG x: show/mnemonic insn -++ show/arity1 x
    | SETNGE x: show/mnemonic insn -++ show/arity1 x
    | SETNL x: show/mnemonic insn -++ show/arity1 x
    | SETNLE x: show/mnemonic insn -++ show/arity1 x
    | SETNO x: show/mnemonic insn -++ show/arity1 x
    | SETNP x: show/mnemonic insn -++ show/arity1 x
    | SETNS x: show/mnemonic insn -++ show/arity1 x
    | SETNZ x: show/mnemonic insn -++ show/arity1 x
    | SETO x: show/mnemonic insn -++ show/arity1 x
    | SETP x: show/mnemonic insn -++ show/arity1 x
    | SETPE x: show/mnemonic insn -++ show/arity1 x
    | SETPO x: show/mnemonic insn -++ show/arity1 x
    | SETS x: show/mnemonic insn -++ show/arity1 x
    | SETZ x: show/mnemonic insn -++ show/arity1 x
    | SFENCE: show/mnemonic insn
    | SGDT x: show/mnemonic insn -++ show/arity1 x
    | SHL x: show/mnemonic insn -++ show/arity2 x
    | SHLD x: show/mnemonic insn -++ show/arity3 x
    | SHR x: show/mnemonic insn -++ show/arity2 x
    | SHRD x: show/mnemonic insn -++ show/arity3 x
    | SHUFPD x: show/mnemonic insn -++ show/arity3 x
    | SHUFPS x: show/mnemonic insn -++ show/arity3 x
    | SIDT x: show/mnemonic insn -++ show/arity1 x
    | SLDT x: show/mnemonic insn -++ show/arity1 x
    | SMSW x: show/mnemonic insn -++ show/arity1 x
    | SQRTPD x: show/mnemonic insn -++ show/arity2 x
    | SQRTPS x: show/mnemonic insn -++ show/arity2 x
    | SQRTSD x: show/mnemonic insn -++ show/arity2 x
    | SQRTSS x: show/mnemonic insn -++ show/arity2 x
    | STC: show/mnemonic insn
    | STD: show/mnemonic insn
    | STI: show/mnemonic insn
    | STMXCSR x: show/mnemonic insn -++ show/arity1 x
    | STOSB: show/mnemonic insn
    | STOSD: show/mnemonic insn
    | STOSQ: show/mnemonic insn
    | STOSW: show/mnemonic insn
    | STR x: show/mnemonic insn -++ show/arity1 x
    | SUB x: show/mnemonic insn -++ show/arity2 x
    | SUBPD x: show/mnemonic insn -++ show/arity2 x
    | SUBPS x: show/mnemonic insn -++ show/arity2 x
    | SUBSD x: show/mnemonic insn -++ show/arity2 x
    | SUBSS x: show/mnemonic insn -++ show/arity2 x
    | SWAPGS: show/mnemonic insn
    | SYSCALL: show/mnemonic insn
    | SYSENTER: show/mnemonic insn
    | SYSEXIT: show/mnemonic insn
    | SYSRET: show/mnemonic insn
    | TEST x: show/mnemonic insn -++ show/arity2 x
    | UCOMISD x: show/mnemonic insn -++ show/arity2 x
    | UCOMISS x: show/mnemonic insn -++ show/arity2 x
    | UD2: show/mnemonic insn
    | UNPCKHPD x: show/mnemonic insn -++ show/arity2 x
    | UNPCKHPS x: show/mnemonic insn -++ show/arity2 x
    | UNPCKLPD x: show/mnemonic insn -++ show/arity2 x
    | UNPCKLPS x: show/mnemonic insn -++ show/arity2 x
    | VADDPD x: show/mnemonic insn +++ show/varity x
    | VADDPS x: show/mnemonic insn +++ show/varity x
    | VADDSD x: show/mnemonic insn +++ show/varity x
    | VADDSS x: show/mnemonic insn +++ show/varity x
    | VADDSUBPD x: show/mnemonic insn +++ show/varity x
    | VADDSUBPS x: show/mnemonic insn +++ show/varity x
    | VAESDEC x: show/mnemonic insn +++ show/varity x
    | VAESDECLAST x: show/mnemonic insn +++ show/varity x
    | VAESENC x: show/mnemonic insn +++ show/varity x
    | VAESENCLAST x: show/mnemonic insn +++ show/varity x
    | VAESIMC x: show/mnemonic insn +++ show/varity x
    | VAESKEYGENASSIST x: show/mnemonic insn +++ show/varity x
    | VANDNPD x: show/mnemonic insn +++ show/varity x
    | VANDNPS x: show/mnemonic insn +++ show/varity x
    | VANDPD x: show/mnemonic insn +++ show/varity x
    | VANDPS x: show/mnemonic insn +++ show/varity x
    | VBLENDPD x: show/mnemonic insn +++ show/varity x
    | VBLENDPS x: show/mnemonic insn +++ show/varity x
    | VBLENDVPD x: show/mnemonic insn +++ show/varity x
    | VBLENDVPS x: show/mnemonic insn +++ show/varity x
    | VBROADCASTF128 x: show/mnemonic insn +++ show/varity x
    | VBROADCASTSD x: show/mnemonic insn +++ show/varity x
    | VBROADCASTSS x: show/mnemonic insn +++ show/varity x
    | VCMPPD x: show/mnemonic insn +++ show/varity x
    | VCMPPS x: show/mnemonic insn +++ show/varity x
    | VCMPSD x: show/mnemonic insn +++ show/varity x
    | VCMPSS x: show/mnemonic insn +++ show/varity x
    | VCOMISD x: show/mnemonic insn +++ show/varity x
    | VCOMISS x: show/mnemonic insn +++ show/varity x
    | VCVTDQ2PD x: show/mnemonic insn +++ show/varity x
    | VCVTDQ2PS x: show/mnemonic insn +++ show/varity x
    | VCVTPD2DQ x: show/mnemonic insn +++ show/varity x
    | VCVTPD2PS x: show/mnemonic insn +++ show/varity x
    | VCVTPH2PS x: show/mnemonic insn +++ show/varity x
    | VCVTPS2DQ x: show/mnemonic insn +++ show/varity x
    | VCVTPS2PD x: show/mnemonic insn +++ show/varity x
    | VCVTPS2PH x: show/mnemonic insn +++ show/varity x
    | VCVTSD2SI x: show/mnemonic insn +++ show/varity x
    | VCVTSD2SS x: show/mnemonic insn +++ show/varity x
    | VCVTSI2SD x: show/mnemonic insn +++ show/varity x
    | VCVTSI2SS x: show/mnemonic insn +++ show/varity x
    | VCVTSS2SD x: show/mnemonic insn +++ show/varity x
    | VCVTSS2SI x: show/mnemonic insn +++ show/varity x
    | VCVTTPD2DQ x: show/mnemonic insn +++ show/varity x
    | VCVTTPS2DQ x: show/mnemonic insn +++ show/varity x
    | VCVTTSD2SI x: show/mnemonic insn +++ show/varity x
    | VCVTTSS2SI x: show/mnemonic insn +++ show/varity x
    | VDIVPD x: show/mnemonic insn +++ show/varity x
    | VDIVPS x: show/mnemonic insn +++ show/varity x
    | VDIVSD x: show/mnemonic insn +++ show/varity x
    | VDIVSS x: show/mnemonic insn +++ show/varity x
    | VDPPD x: show/mnemonic insn +++ show/varity x
    | VDPPS x: show/mnemonic insn +++ show/varity x
    | VERR x: show/mnemonic insn -++ show/arity1 x
    | VERW x: show/mnemonic insn -++ show/arity1 x
    | VEXTRACTF128 x: show/mnemonic insn +++ show/varity x
    | VEXTRACTPS x: show/mnemonic insn +++ show/varity x
    | VHADDPD x: show/mnemonic insn +++ show/varity x
    | VHADDPS x: show/mnemonic insn +++ show/varity x
    | VHSUBPD x: show/mnemonic insn +++ show/varity x
    | VHSUBPS x: show/mnemonic insn +++ show/varity x
    | VINSERTF128 x: show/mnemonic insn +++ show/varity x
    | VINSERTPS x: show/mnemonic insn +++ show/varity x
    | VLDDQU x: show/mnemonic insn +++ show/varity x
    | VLDMXCSR x: show/mnemonic insn +++ show/varity x
    | VMASKMOVDQU x: show/mnemonic insn +++ show/varity x
    | VMASKMOVPD x: show/mnemonic insn +++ show/varity x
    | VMASKMOVPS x: show/mnemonic insn +++ show/varity x
    | VMAXPD x: show/mnemonic insn +++ show/varity x
    | VMAXPS x: show/mnemonic insn +++ show/varity x
    | VMAXSD x: show/mnemonic insn +++ show/varity x
    | VMAXSS x: show/mnemonic insn +++ show/varity x
    | VMINPD x: show/mnemonic insn +++ show/varity x
    | VMINPS x: show/mnemonic insn +++ show/varity x
    | VMINSD x: show/mnemonic insn +++ show/varity x
    | VMINSS x: show/mnemonic insn +++ show/varity x
    | VMOVAPD x: show/mnemonic insn +++ show/varity x
    | VMOVAPS x: show/mnemonic insn +++ show/varity x
    | VMOVD x: show/mnemonic insn +++ show/varity x
    | VMOVDDUP x: show/mnemonic insn +++ show/varity x
    | VMOVDQA x: show/mnemonic insn +++ show/varity x
    | VMOVDQU x: show/mnemonic insn +++ show/varity x
    | VMOVHLPS x: show/mnemonic insn +++ show/varity x
    | VMOVHPD x: show/mnemonic insn +++ show/varity x
    | VMOVHPS x: show/mnemonic insn +++ show/varity x
    | VMOVLHPS x: show/mnemonic insn +++ show/varity x
    | VMOVLPD x: show/mnemonic insn +++ show/varity x
    | VMOVLPS x: show/mnemonic insn +++ show/varity x
    | VMOVMSKPD x: show/mnemonic insn +++ show/varity x
    | VMOVMSKPS x: show/mnemonic insn +++ show/varity x
    | VMOVNTDQ x: show/mnemonic insn +++ show/varity x
    | VMOVNTDQA x: show/mnemonic insn +++ show/varity x
    | VMOVNTPD x: show/mnemonic insn +++ show/varity x
    | VMOVNTPS x: show/mnemonic insn +++ show/varity x
    | VMOVQ x: show/mnemonic insn +++ show/varity x
    | VMOVSD x: show/mnemonic insn +++ show/varity x
    | VMOVSHDUP x: show/mnemonic insn +++ show/varity x
    | VMOVSLDUP x: show/mnemonic insn +++ show/varity x
    | VMOVSS x: show/mnemonic insn +++ show/varity x
    | VMOVUPD x: show/mnemonic insn +++ show/varity x
    | VMOVUPS x: show/mnemonic insn +++ show/varity x
    | VMPSADBW x: show/mnemonic insn +++ show/varity x
    | VMULPD x: show/mnemonic insn +++ show/varity x
    | VMULPS x: show/mnemonic insn +++ show/varity x
    | VMULSD x: show/mnemonic insn +++ show/varity x
    | VMULSS x: show/mnemonic insn +++ show/varity x
    | VORPD x: show/mnemonic insn +++ show/varity x
    | VORPS x: show/mnemonic insn +++ show/varity x
    | VPABSB x: show/mnemonic insn +++ show/varity x
    | VPABSD x: show/mnemonic insn +++ show/varity x
    | VPABSW x: show/mnemonic insn +++ show/varity x
    | VPACKSSDW x: show/mnemonic insn +++ show/varity x
    | VPACKSSWB x: show/mnemonic insn +++ show/varity x
    | VPACKUSDW x: show/mnemonic insn +++ show/varity x
    | VPACKUSWB x: show/mnemonic insn +++ show/varity x
    | VPADDB x: show/mnemonic insn +++ show/varity x
    | VPADDD x: show/mnemonic insn +++ show/varity x
    | VPADDQ x: show/mnemonic insn +++ show/varity x
    | VPADDSB x: show/mnemonic insn +++ show/varity x
    | VPADDSW x: show/mnemonic insn +++ show/varity x
    | VPADDUSB x: show/mnemonic insn +++ show/varity x
    | VPADDUSW x: show/mnemonic insn +++ show/varity x
    | VPADDW x: show/mnemonic insn +++ show/varity x
    | VPALIGNR x: show/mnemonic insn +++ show/varity x
    | VPAND x: show/mnemonic insn +++ show/varity x
    | VPANDN x: show/mnemonic insn +++ show/varity x
    | VPAVGB x: show/mnemonic insn +++ show/varity x
    | VPAVGW x: show/mnemonic insn +++ show/varity x
    | VPBLENDVB x: show/mnemonic insn +++ show/varity x
    | VPBLENDW x: show/mnemonic insn +++ show/varity x
    | VPCLMULQDQ x: show/mnemonic insn +++ show/varity x
    | VPCMPEQB x: show/mnemonic insn +++ show/varity x
    | VPCMPEQD x: show/mnemonic insn +++ show/varity x
    | VPCMPEQQ x: show/mnemonic insn +++ show/varity x
    | VPCMPEQW x: show/mnemonic insn +++ show/varity x
    | VPCMPESTRI x: show/mnemonic insn +++ show/varity x
    | VPCMPESTRM x: show/mnemonic insn +++ show/varity x
    | VPCMPGTB x: show/mnemonic insn +++ show/varity x
    | VPCMPGTD x: show/mnemonic insn +++ show/varity x
    | VPCMPGTQ x: show/mnemonic insn +++ show/varity x
    | VPCMPGTW x: show/mnemonic insn +++ show/varity x
    | VPCMPISTRI x: show/mnemonic insn +++ show/varity x
    | VPCMPISTRM x: show/mnemonic insn +++ show/varity x
    | VPERM2F128 x: show/mnemonic insn +++ show/varity x
    | VPERMILPD x: show/mnemonic insn +++ show/varity x
    | VPERMILPS x: show/mnemonic insn +++ show/varity x
    | VPEXTRB x: show/mnemonic insn +++ show/varity x
    | VPEXTRD x: show/mnemonic insn +++ show/varity x
    | VPEXTRQ x: show/mnemonic insn +++ show/varity x
    | VPEXTRW x: show/mnemonic insn +++ show/varity x
    | VPHADDD x: show/mnemonic insn +++ show/varity x
    | VPHADDSW x: show/mnemonic insn +++ show/varity x
    | VPHADDW x: show/mnemonic insn +++ show/varity x
    | VPHMINPOSUW x: show/mnemonic insn +++ show/varity x
    | VPHSUBD x: show/mnemonic insn +++ show/varity x
    | VPHSUBSW x: show/mnemonic insn +++ show/varity x
    | VPHSUBW x: show/mnemonic insn +++ show/varity x
    | VPINSRB x: show/mnemonic insn +++ show/varity x
    | VPINSRD x: show/mnemonic insn +++ show/varity x
    | VPINSRQ x: show/mnemonic insn +++ show/varity x
    | VPINSRW x: show/mnemonic insn +++ show/varity x
    | VPMADDUBSW x: show/mnemonic insn +++ show/varity x
    | VPMADDWD x: show/mnemonic insn +++ show/varity x
    | VPMAXSB x: show/mnemonic insn +++ show/varity x
    | VPMAXSD x: show/mnemonic insn +++ show/varity x
    | VPMAXSW x: show/mnemonic insn +++ show/varity x
    | VPMAXUB x: show/mnemonic insn +++ show/varity x
    | VPMAXUD x: show/mnemonic insn +++ show/varity x
    | VPMAXUW x: show/mnemonic insn +++ show/varity x
    | VPMINSB x: show/mnemonic insn +++ show/varity x
    | VPMINSD x: show/mnemonic insn +++ show/varity x
    | VPMINSW x: show/mnemonic insn +++ show/varity x
    | VPMINUB x: show/mnemonic insn +++ show/varity x
    | VPMINUD x: show/mnemonic insn +++ show/varity x
    | VPMINUW x: show/mnemonic insn +++ show/varity x
    | VPMOVMSKB x: show/mnemonic insn +++ show/varity x
    | VPMOVSXBD x: show/mnemonic insn +++ show/varity x
    | VPMOVSXBQ x: show/mnemonic insn +++ show/varity x
    | VPMOVSXBW x: show/mnemonic insn +++ show/varity x
    | VPMOVSXDQ x: show/mnemonic insn +++ show/varity x
    | VPMOVSXWD x: show/mnemonic insn +++ show/varity x
    | VPMOVSXWQ x: show/mnemonic insn +++ show/varity x
    | VPMOVZXBD x: show/mnemonic insn +++ show/varity x
    | VPMOVZXBQ x: show/mnemonic insn +++ show/varity x
    | VPMOVZXBW x: show/mnemonic insn +++ show/varity x
    | VPMOVZXDQ x: show/mnemonic insn +++ show/varity x
    | VPMOVZXWD x: show/mnemonic insn +++ show/varity x
    | VPMOVZXWQ x: show/mnemonic insn +++ show/varity x
    | VPMULDQ x: show/mnemonic insn +++ show/varity x
    | VPMULHRSW x: show/mnemonic insn +++ show/varity x
    | VPMULHUW x: show/mnemonic insn +++ show/varity x
    | VPMULHW x: show/mnemonic insn +++ show/varity x
    | VPMULLD x: show/mnemonic insn +++ show/varity x
    | VPMULLW x: show/mnemonic insn +++ show/varity x
    | VPMULUDQ x: show/mnemonic insn +++ show/varity x
    | VPOR x: show/mnemonic insn +++ show/varity x
    | VPSADBW x: show/mnemonic insn +++ show/varity x
    | VPSHUFB x: show/mnemonic insn +++ show/varity x
    | VPSHUFD x: show/mnemonic insn +++ show/varity x
    | VPSHUFHW x: show/mnemonic insn +++ show/varity x
    | VPSHUFLW x: show/mnemonic insn +++ show/varity x
    | VPSIGNB x: show/mnemonic insn +++ show/varity x
    | VPSIGND x: show/mnemonic insn +++ show/varity x
    | VPSIGNW x: show/mnemonic insn +++ show/varity x
    | VPSLLD x: show/mnemonic insn +++ show/varity x
    | VPSLLDQ x: show/mnemonic insn +++ show/varity x
    | VPSLLQ x: show/mnemonic insn +++ show/varity x
    | VPSLLW x: show/mnemonic insn +++ show/varity x
    | VPSRAD x: show/mnemonic insn +++ show/varity x
    | VPSRAW x: show/mnemonic insn +++ show/varity x
    | VPSRLD x: show/mnemonic insn +++ show/varity x
    | VPSRLDQ x: show/mnemonic insn +++ show/varity x
    | VPSRLQ x: show/mnemonic insn +++ show/varity x
    | VPSRLW x: show/mnemonic insn +++ show/varity x
    | VPSUBB x: show/mnemonic insn +++ show/varity x
    | VPSUBD x: show/mnemonic insn +++ show/varity x
    | VPSUBQ x: show/mnemonic insn +++ show/varity x
    | VPSUBSB x: show/mnemonic insn +++ show/varity x
    | VPSUBSW x: show/mnemonic insn +++ show/varity x
    | VPSUBUSB x: show/mnemonic insn +++ show/varity x
    | VPSUBUSW x: show/mnemonic insn +++ show/varity x
    | VPSUBW x: show/mnemonic insn +++ show/varity x
    | VPTEST x: show/mnemonic insn +++ show/varity x
    | VPUNPCKHBW x: show/mnemonic insn +++ show/varity x
    | VPUNPCKHDQ x: show/mnemonic insn +++ show/varity x
    | VPUNPCKHQDQ x: show/mnemonic insn +++ show/varity x
    | VPUNPCKHWD x: show/mnemonic insn +++ show/varity x
    | VPUNPCKLBW x: show/mnemonic insn +++ show/varity x
    | VPUNPCKLDQ x: show/mnemonic insn +++ show/varity x
    | VPUNPCKLQDQ x: show/mnemonic insn +++ show/varity x
    | VPUNPCKLWD x: show/mnemonic insn +++ show/varity x
    | VPXOR x: show/mnemonic insn +++ show/varity x
    | VRCPPS x: show/mnemonic insn +++ show/varity x
    | VRCPSS x: show/mnemonic insn +++ show/varity x
    | VROUNDPD x: show/mnemonic insn +++ show/varity x
    | VROUNDPS x: show/mnemonic insn +++ show/varity x
    | VROUNDSD x: show/mnemonic insn +++ show/varity x
    | VROUNDSS x: show/mnemonic insn +++ show/varity x
    | VRSQRTPS x: show/mnemonic insn +++ show/varity x
    | VRSQRTSS x: show/mnemonic insn +++ show/varity x
    | VSHUFPD x: show/mnemonic insn +++ show/varity x
    | VSHUFPS x: show/mnemonic insn +++ show/varity x
    | VSQRTPD x: show/mnemonic insn +++ show/varity x
    | VSQRTPS x: show/mnemonic insn +++ show/varity x
    | VSQRTSD x: show/mnemonic insn +++ show/varity x
    | VSQRTSS x: show/mnemonic insn +++ show/varity x
    | VSTMXCSR x: show/mnemonic insn +++ show/varity x
    | VSUBPD x: show/mnemonic insn +++ show/varity x
    | VSUBPS x: show/mnemonic insn +++ show/varity x
    | VSUBSD x: show/mnemonic insn +++ show/varity x
    | VSUBSS x: show/mnemonic insn +++ show/varity x
    | VTESTPD x: show/mnemonic insn +++ show/varity x
    | VTESTPS x: show/mnemonic insn +++ show/varity x
    | VUCOMISD x: show/mnemonic insn +++ show/varity x
    | VUCOMISS x: show/mnemonic insn +++ show/varity x
    | VUNPCKHPD x: show/mnemonic insn +++ show/varity x
    | VUNPCKHPS x: show/mnemonic insn +++ show/varity x
    | VUNPCKLPD x: show/mnemonic insn +++ show/varity x
    | VUNPCKLPS x: show/mnemonic insn +++ show/varity x
    | VXORPD x: show/mnemonic insn +++ show/varity x
    | VXORPS x: show/mnemonic insn +++ show/varity x
    | VZEROALL x: show/mnemonic insn +++ show/varity x
    | VZEROUPPER x: show/mnemonic insn +++ show/varity x
    | WAIT: show/mnemonic insn
    | WBINVD: show/mnemonic insn
    | WRFSBASE x: show/mnemonic insn -++ show/arity1 x
    | WRGSBASE x: show/mnemonic insn -++ show/arity1 x
    | WRMSR: show/mnemonic insn
    | XADD x: show/mnemonic insn -++ show/arity2 x
    | XCHG x: show/mnemonic insn -++ show/arity2 x
    | XGETBV: show/mnemonic insn
    | XLATB: show/mnemonic insn
    | XOR x: show/mnemonic insn -++ show/arity2 x
    | XORPD x: show/mnemonic insn -++ show/arity2 x
    | XORPS x: show/mnemonic insn -++ show/arity2 x
    | XRSTOR x: show/mnemonic insn -++ show/arity1 x
    | XRSTOR64 x: show/mnemonic insn -++ show/arity1 x
    | XSAVE x: show/mnemonic insn -++ show/arity1 x
    | XSAVE64 x: show/mnemonic insn -++ show/arity1 x
    | XSAVEOPT x: show/mnemonic insn -++ show/arity1 x
    | XSAVEOPT64 x: show/mnemonic insn -++ show/arity1 x
    | XSETBV: show/mnemonic insn
    #| PSLRDQ: show/mnemonic insn -++ show/arity2 x
    #| VPSLRDQ: show/mnemonic insn +++ show/varity x
   end
#s/^\(...\)\(\S*\)\s*$/\1\2: show/mnemonic insn/
#s/^\(...\)\(\S*\) of \(\S*\)\s*$/\1\2 x: show/mnemonic insn -++ show\/\3 x/

val show/mnemonic insn =
    case insn of
      AAA: show/mnemonic insn
    | AAD x: "AAD"
    | AAM x: "AAM"
    | AAS: "AAS"
    | ADC x: "ADC"
    | ADD x: "ADD"
    | ADDPD x: "ADDPD"
    | ADDPS x: "ADDPS"
    | ADDSD x: "ADDSD"
    | ADDSS x: "ADDSS"
    | ADDSUBPD x: "ADDSUBPD"
    | ADDSUBPS x: "ADDSUBPS"
    | AESDEC x: "AESDEC"
    | AESDECLAST x: "AESDECLAST"
    | AESENC x: "AESENC"
    | AESENCLAST x: "AESENCLAST"
    | AESIMC x: "AESIMC"
    | AESKEYGENASSIST x: "AESKEYGENASSIST"
    | AND x: "AND"
    | ANDNPD x: "ANDNPD"
    | ANDNPS x: "ANDNPS"
    | ANDPD x: "ANDPD"
    | ANDPS x: "ANDPS"
    | ARPL x: "ARPL"
    | BLENDPD x: "BLENDPD"
    | BLENDPS x: "BLENDPS"
    | BLENDVPD x: "BLENDVPD"
    | BLENDVPS x: "BLENDVPS"
    | BOUND x: "BOUND"
    | BSF x: "BSF"
    | BSR x: "BSR"
    | BSWAP x: "BSWAP"
    | BT x: "BT"
    | BTC x: "BTC"
    | BTR x: "BTR"
    | BTS x: "BTS"
    | CALL x: "CALL"
    | CBW: "CBW"
    | CDQ: "CDQ"
    | CDQE: "CDQE"
    | CLC: "CLC"
    | CLD: "CLD"
    | CLFLUSH x: "CLFLUSH"
    | CLI: "CLI"
    | CLTS: "CLTS"
    | CMC: "CMC"
    | CMOVA x: "CMOVA"
    | CMOVAE x: "CMOVAE"
    | CMOVB x: "CMOVB"
    | CMOVBE x: "CMOVBE"
    | CMOVC x: "CMOVC"
    | CMOVE x: "CMOVE"
    | CMOVG x: "CMOVG"
    | CMOVGE x: "CMOVGE"
    | CMOVL x: "CMOVL"
    | CMOVLE x: "CMOVLE"
    | CMOVNA x: "CMOVNA"
    | CMOVNAE x: "CMOVNAE"
    | CMOVNB x: "CMOVNB"
    | CMOVNBE x: "CMOVNBE"
    | CMOVNC x: "CMOVNC"
    | CMOVNE x: "CMOVNE"
    | CMOVNG x: "CMOVNG"
    | CMOVNGE x: "CMOVNGE"
    | CMOVNL x: "CMOVNL"
    | CMOVNLE x: "CMOVNLE"
    | CMOVNO x: "CMOVNO"
    | CMOVNP x: "CMOVNP"
    | CMOVNS x: "CMOVNS"
    | CMOVNZ x: "CMOVNZ"
    | CMOVO x: "CMOVO"
    | CMOVP x: "CMOVP"
    | CMOVPE x: "CMOVPE"
    | CMOVPO x: "CMOVPO"
    | CMOVS x: "CMOVS"
    | CMOVZ x: "CMOVZ"
    | CMP x: "CMP"
    | CMPPD x: "CMPPD"
    | CMPPS x: "CMPPS"
    | CMPS x: "CMPS"
    | CMPSD x: "CMPSD"
    | CMPSS x: "CMPSS"
    | CMPXCHG x: "CMPXCHG"
    | CMPXCHG16B x: "CMPXCHG16B"
    | CMPXCHG8B x: "CMPXCHG8B"
    | COMISD x: "COMISD"
    | COMISS x: "COMISS"
    | CPUID: "CPUID"
    | CQO: "CQO"
    | CRC32 x: "CRC32"
    | CVTDQ2PD x: "CVTDQ2PD"
    | CVTDQ2PS x: "CVTDQ2PS"
    | CVTPD2DQ x: "CVTPD2DQ"
    | CVTPD2PI x: "CVTPD2PI"
    | CVTPD2PS x: "CVTPD2PS"
    | CVTPI2PD x: "CVTPI2PD"
    | CVTPI2PS x: "CVTPI2PS"
    | CVTPS2DQ x: "CVTPS2DQ"
    | CVTPS2PD x: "CVTPS2PD"
    | CVTPS2PI x: "CVTPS2PI"
    | CVTSD2SI x: "CVTSD2SI"
    | CVTSD2SS x: "CVTSD2SS"
    | CVTSI2SD x: "CVTSI2SD"
    | CVTSI2SS x: "CVTSI2SS"
    | CVTSS2SD x: "CVTSS2SD"
    | CVTSS2SI x: "CVTSS2SI"
    | CVTTPD2DQ x: "CVTTPD2DQ"
    | CVTTPD2PI x: "CVTTPD2PI"
    | CVTTPS2DQ x: "CVTTPS2DQ"
    | CVTTPS2PI x: "CVTTPS2PI"
    | CVTTSD2SI x: "CVTTSD2SI"
    | CVTTSS2SI x: "CVTTSS2SI"
    | CWD: "CWD"
    | CWDE: "CWDE"
    | DAA: "DAA"
    | DAS: "DAS"
    | DEC x: "DEC"
    | DIV x: "DIV"
    | DIVPD x: "DIVPD"
    | DIVPS x: "DIVPS"
    | DIVSD x: "DIVSD"
    | DIVSS x: "DIVSS"
    | DPPD x: "DPPD"
    | DPPS x: "DPPS"
    | EMMS: "EMMS"
    | ENTER x: "ENTER"
    | EXTRACTPS x: "EXTRACTPS"
    | F2XM1: "F2XM1"
    | FABS: "FABS"
    | FADD x: "FADD"
    | FADDP x: "FADDP"
    | FBLD x: "FBLD"
    | FBSTP x: "FBSTP"
    | FCHS: "FCHS"
    | FCLEX: "FCLEX"
    | FCMOVB x: "FCMOVB"
    | FCMOVBE x: "FCMOVBE"
    | FCMOVE x: "FCMOVE"
    | FCMOVNB x: "FCMOVNB"
    | FCMOVNBE x: "FCMOVNBE"
    | FCMOVNE x: "FCMOVNE"
    | FCMOVNU x: "FCMOVNU"
    | FCMOVU x: "FCMOVU"
    | FCOM x: "FCOM"
    | FCOMI x: "FCOMI"
    | FCOMIP x: "FCOMIP"
    | FCOMP x: "FCOMP"
    | FCOMPP: "FCOMPP"
    | FCOS: "FCOS"
    | FDECSTP: "FDECSTP"
    | FDIV x: "FDIV"
    | FDIVP x: "FDIVP"
    | FDIVR x: "FDIVR"
    | FDIVRP x: "FDIVRP"
    | FFREE x: "FFREE"
    | FIADD x: "FIADD"
    | FICOM x: "FICOM"
    | FICOMP x: "FICOMP"
    | FIDIV x: "FIDIV"
    | FIDIVR x: "FIDIVR"
    | FILD x: "FILD"
    | FIMUL x: "FIMUL"
    | FINCSTP: "FINCSTP"
    | FINIT: "FINIT"
    | FIST x: "FIST"
    | FISTP x: "FISTP"
    | FISTTP x: "FISTTP"
    | FISUB x: "FISUB"
    | FISUBR x: "FISUBR"
    | FLD x: "FLD"
    | FLD1: "FLD1"
    | FLDCW x: "FLDCW"
    | FLDENV x: "FLDENV"
    | FLDL2E: "FLDL2E"
    | FLDL2T: "FLDL2T"
    | FLDLG2: "FLDLG2"
    | FLDLN2: "FLDLN2"
    | FLDPI: "FLDPI"
    | FLDZ: "FLDZ"
    | FMUL x: "FMUL"
    | FMULP x: "FMULP"
    | FNCLEX: "FNCLEX"
    | FNINIT: "FNINIT"
    | FNOP: "FNOP"
    | FNSAVE x: "FNSAVE"
    | FNSTCW x: "FNSTCW"
    | FNSTENV x: "FNSTENV"
    | FNSTSW x: "FNSTSW"
    | FPATAN: "FPATAN"
    | FPREM1: "FPREM1"
    | FPREM: "FPREM"
    | FPTAN: "FPTAN"
    | FRNDINT: "FRNDINT"
    | FRSTOR x: "FRSTOR"
    | FSAVE x: "FSAVE"
    | FSCALE: "FSCALE"
    | FSIN: "FSIN"
    | FSINCOS: "FSINCOS"
    | FSQRT: "FSQRT"
    | FST x: "FST"
    | FSTCW x: "FSTCW"
    | FSTENV x: "FSTENV"
    | FSTP x: "FSTP"
    | FSTSW x: "FSTSW"
    | FSUB x: "FSUB"
    | FSUBP x: "FSUBP"
    | FSUBR x: "FSUBR"
    | FSUBRP x: "FSUBRP"
    | FTST: "FTST"
    | FUCOM x: "FUCOM"
    | FUCOMI x: "FUCOMI"
    | FUCOMIP x: "FUCOMIP"
    | FUCOMP x: "FUCOMP"
    | FUCOMPP: "FUCOMPP"
    | FXAM: "FXAM"
    | FXCH x: "FXCH"
    | FXRSTOR x: "FXRSTOR"
    | FXRSTOR64 x: "FXRSTOR64"
    | FXSAVE x: "FXSAVE"
    | FXSAVE64 x: "FXSAVE64"
    | FXTRACT: "FXTRACT"
    | FYL2X: "FYL2X"
    | FYL2XP1: "FYL2XP1"
    | HADDPD x: "HADDPD"
    | HADDPS x: "HADDPS"
    | HLT: "HLT"
    | HSUBPD x: "HSUBPD"
    | HSUBPS x: "HSUBPS"
    | IDIV x: "IDIV"
    | IMUL x: "IMUL"
    | IN x: "IN"
    | INC x: "INC"
    | INSB: "INSB"
    | INSD: "INSD"
    | INSERTPS x: "INSERTPS"
    | INSW: "INSW"
    | INT x: "INT"
    | INT0: "INT0"
    | INT3: "INT3"
    | INVD: "INVD"
    | INVLPG x: "INVLPG"
    | INVPCID x: "INVPCID"
    | IRET: "IRET"
    | IRETD: "IRETD"
    | IRETQ: "IRETQ"
    | JA x: "JA"
    | JAE x: "JAE"
    | JB x: "JB"
    | JBE x: "JBE"
    | JC x: "JC"
    | JCXZ x: "JCXZ"
    | JE x: "JE"
    | JECXZ x: "JECXZ"
    | JG x: "JG"
    | JGE x: "JGE"
    | JL x: "JL"
    | JLE x: "JLE"
    | JMP x: "JMP"
    | JNA x: "JNA"
    | JNAE x: "JNAE"
    | JNB x: "JNB"
    | JNBE x: "JNBE"
    | JNC x: "JNC"
    | JNE x: "JNE"
    | JNG x: "JNG"
    | JNGE x: "JNGE"
    | JNL x: "JNL"
    | JNLE x: "JNLE"
    | JNO x: "JNO"
    | JNP x: "JNP"
    | JNS x: "JNS"
    | JNZ x: "JNZ"
    | JO x: "JO"
    | JP x: "JP"
    | JPE x: "JPE"
    | JPO x: "JPO"
    | JRCXZ x: "JRCXZ"
    | JS x: "JS"
    | JZ x: "JZ"
    | LAHF: "LAHF"
    | LAR x: "LAR"
    | LDDQU x: "LDDQU"
    | LDMXCSR x: "LDMXCSR"
    | LDS x: "LDS"
    | LEA x: "LEA"
    | LEAVE: "LEAVE"
    | LES x: "LES"
    | LFENCE: "LFENCE"
    | LFS x: "LFS"
    | LGDT x: "LGDT"
    | LGS x: "LGS"
    | LIDT x: "LIDT"
    | LLDT x: "LLDT"
    | LMSW x: "LMSW"
    | LODS x: "LODS"
    | LOOP x: "LOOP"
    | LOOPE x: "LOOPE"
    | LOOPNE x: "LOOPNE"
    | LSL x: "LSL"
    | LSS x: "LSS"
    | LTR x: "LTR"
    | MASKMOVDQU x: "MASKMOVDQU"
    | MASKMOVQ x: "MASKMOVQ"
    | MAXPD x: "MAXPD"
    | MAXPS x: "MAXPS"
    | MAXSD x: "MAXSD"
    | MAXSS x: "MAXSS"
    | MFENCE: "MFENCE"
    | MINPD x: "MINPD"
    | MINPS x: "MINPS"
    | MINSD x: "MINSD"
    | MINSS x: "MINSS"
    | MONITOR: "MONITOR"
    | MOV x: "MOV"
    | MOVAPD x: "MOVAPD"
    | MOVAPS x: "MOVAPS"
    | MOVBE x: "MOVBE"
    | MOVD x: "MOVD"
    | MOVDDUP x: "MOVDDUP"
    | MOVDQ2Q x: "MOVDQ2Q"
    | MOVDQA x: "MOVDQA"
    | MOVDQU x: "MOVDQU"
    | MOVHLPS x: "MOVHLPS"
    | MOVHPD x: "MOVHPD"
    | MOVHPS x: "MOVHPS"
    | MOVLHPS x: "MOVLHPS"
    | MOVLPD x: "MOVLPD"
    | MOVLPS x: "MOVLPS"
    | MOVMSKPD x: "MOVMSKPD"
    | MOVMSKPS x: "MOVMSKPS"
    | MOVNTDQ x: "MOVNTDQ"
    | MOVNTDQA x: "MOVNTDQA"
    | MOVNTI x: "MOVNTI"
    | MOVNTPD x: "MOVNTPD"
    | MOVNTPS x: "MOVNTPS"
    | MOVNTQ x: "MOVNTQ"
    | MOVQ x: "MOVQ"
    | MOVQ2DQ x: "MOVQ2DQ"
    | MOVS x: "MOVS"
    | MOVSD x: "MOVSD"
    | MOVSHDUP x: "MOVSHDUP"
    | MOVSLDUP x: "MOVSLDUP"
    | MOVSS x: "MOVSS"
    | MOVSW x: "MOVSW"
    | MOVSX x: "MOVSX"
    | MOVSXD x: "MOVSXD"
    | MOVUPD x: "MOVUPD"
    | MOVUPS x: "MOVUPS"
    | MOVZX x: "MOVZX"
    | MPSADBW x: "MPSADBW"
    | MUL x: "MUL"
    | MULPD x: "MULPD"
    | MULPS x: "MULPS"
    | MULSD x: "MULSD"
    | MULSS x: "MULSS"
    | MWAIT: "MWAIT"
    | NEG x: "NEG"
    | NOP x: "NOP"
    | NOT x: "NOT"
    | OR x: "OR"
    | ORPD x: "ORPD"
    | ORPS x: "ORPS"
    | OUT x: "OUT"
    | OUTS: "OUTS"
    | OUTSB: "OUTSB"
    | OUTSD: "OUTSD"
    | OUTSW: "OUTSW"
    | PABSB x: "PABSB"
    | PABSD x: "PABSD"
    | PABSW x: "PABSW"
    | PACKSSDW x: "PACKSSDW"
    | PACKSSWB x: "PACKSSWB"
    | PACKUSDW x: "PACKUSDW"
    | PACKUSWB x: "PACKUSWB"
    | PADDB x: "PADDB"
    | PADDD x: "PADDD"
    | PADDQ x: "PADDQ"
    | PADDSB x: "PADDSB"
    | PADDSW x: "PADDSW"
    | PADDUSB x: "PADDUSB"
    | PADDUSW x: "PADDUSW"
    | PADDW x: "PADDW"
    | PALIGNR x: "PALIGNR"
    | PAND x: "PAND"
    | PANDN x: "PANDN"
    | PAUSE: "PAUSE"
    | PAVGB x: "PAVGB"
    | PAVGW x: "PAVGW"
    | PBLENDVB x: "PBLENDVB"
    | PBLENDW x: "PBLENDW"
    | PCLMULQDQ x: "PCLMULQDQ"
    | PCMPEQB x: "PCMPEQB"
    | PCMPEQD x: "PCMPEQD"
    | PCMPEQQ x: "PCMPEQQ"
    | PCMPEQW x: "PCMPEQW"
    | PCMPESTRI x: "PCMPESTRI"
    | PCMPESTRM x: "PCMPESTRM"
    | PCMPGRD x: "PCMPGRD"
    | PCMPGTB x: "PCMPGTB"
    | PCMPGTD x: "PCMPGTD"
    | PCMPGTQ x: "PCMPGTQ"
    | PCMPGTW x: "PCMPGTW"
    | PCMPISTRI x: "PCMPISTRI"
    | PCMPISTRM x: "PCMPISTRM"
    | PEXTRB x: "PEXTRB"
    | PEXTRD x: "PEXTRD"
    | PEXTRQ x: "PEXTRQ"
    | PEXTRW x: "PEXTRW"
    | PHADDD x: "PHADDD"
    | PHADDSW x: "PHADDSW"
    | PHADDW x: "PHADDW"
    | PHMINPOSUW x: "PHMINPOSUW"
    | PHSUBD x: "PHSUBD"
    | PHSUBSW x: "PHSUBSW"
    | PHSUBW x: "PHSUBW"
    | PINSRB x: "PINSRB"
    | PINSRD x: "PINSRD"
    | PINSRQ x: "PINSRQ"
    | PINSRW x: "PINSRW"
    | PMADDUBSW x: "PMADDUBSW"
    | PMADDWD x: "PMADDWD"
    | PMAXSB x: "PMAXSB"
    | PMAXSD x: "PMAXSD"
    | PMAXSW x: "PMAXSW"
    | PMAXUB x: "PMAXUB"
    | PMAXUD x: "PMAXUD"
    | PMAXUW x: "PMAXUW"
    | PMINSB x: "PMINSB"
    | PMINSD x: "PMINSD"
    | PMINSW x: "PMINSW"
    | PMINUB x: "PMINUB"
    | PMINUD x: "PMINUD"
    | PMINUW x: "PMINUW"
    | PMOVMSKB x: "PMOVMSKB"
    | PMOVSXBD x: "PMOVSXBD"
    | PMOVSXBQ x: "PMOVSXBQ"
    | PMOVSXBW x: "PMOVSXBW"
    | PMOVSXDQ x: "PMOVSXDQ"
    | PMOVSXWD x: "PMOVSXWD"
    | PMOVSXWQ x: "PMOVSXWQ"
    | PMOVZXBD x: "PMOVZXBD"
    | PMOVZXBQ x: "PMOVZXBQ"
    | PMOVZXBW x: "PMOVZXBW"
    | PMOVZXDQ x: "PMOVZXDQ"
    | PMOVZXWD x: "PMOVZXWD"
    | PMOVZXWQ x: "PMOVZXWQ"
    | PMULDQ x: "PMULDQ"
    | PMULHRSW x: "PMULHRSW"
    | PMULHUW x: "PMULHUW"
    | PMULHW x: "PMULHW"
    | PMULLD x: "PMULLD"
    | PMULLW x: "PMULLW"
    | PMULUDQ x: "PMULUDQ"
    | POP x: "POP"
    | POPA: "POPA"
    | POPAD: "POPAD"
    | POPCNT x: "POPCNT"
    | POPF: "POPF"
    | POPFD: "POPFD"
    | POPFQ: "POPFQ"
    | POR x: "POR"
    | PREFETCHNTA x: "PREFETCHNTA"
    | PREFETCHT0 x: "PREFETCHT0"
    | PREFETCHT1 x: "PREFETCHT1"
    | PREFETCHT2 x: "PREFETCHT2"
    | PREFETCHW x: "PREFETCHW"
    | PSADBW x: "PSADBW"
    | PSHUFB x: "PSHUFB"
    | PSHUFD x: "PSHUFD"
    | PSHUFHW x: "PSHUFHW"
    | PSHUFLW x: "PSHUFLW"
    | PSHUFW x: "PSHUFW"
    | PSIGNB x: "PSIGNB"
    | PSIGND x: "PSIGND"
    | PSIGNW x: "PSIGNW"
    | PSLLD x: "PSLLD"
    | PSLLDQ x: "PSLLDQ"
    | PSLLQ x: "PSLLQ"
    | PSLLW x: "PSLLW"
    | PSRAD x: "PSRAD"
    | PSRAW x: "PSRAW"
    | PSRLD x: "PSRLD"
    | PSRLDQ x: "PSRLDQ"
    | PSRLQ x: "PSRLQ"
    | PSRLW x: "PSRLW"
    | PSUBB x: "PSUBB"
    | PSUBD x: "PSUBD"
    | PSUBQ x: "PSUBQ"
    | PSUBSB x: "PSUBSB"
    | PSUBSW x: "PSUBSW"
    | PSUBUSB x: "PSUBUSB"
    | PSUBUSW x: "PSUBUSW"
    | PSUBW x: "PSUBW"
    | PTEST x: "PTEST"
    | PUNPCKHBW x: "PUNPCKHBW"
    | PUNPCKHDQ x: "PUNPCKHDQ"
    | PUNPCKHQDQ x: "PUNPCKHQDQ"
    | PUNPCKHWD x: "PUNPCKHWD"
    | PUNPCKLBW x: "PUNPCKLBW"
    | PUNPCKLDQ x: "PUNPCKLDQ"
    | PUNPCKLQDQ x: "PUNPCKLQDQ"
    | PUNPCKLWD x: "PUNPCKLWD"
    | PUSH x: "PUSH"
    | PUSHA: "PUSHA"
    | PUSHAD: "PUSHAD"
    | PUSHF: "PUSHF"
    | PUSHFD: "PUSHFD"
    | PUSHFQ: "PUSHFQ"
    | PXOR x: "PXOR"
    | RCL x: "RCL"
    | RCPPS x: "RCPPS"
    | RCPSS x: "RCPSS"
    | RCR x: "RCR"
    | RDFSBASE x: "RDFSBASE"
    | RDGSBASE x: "RDGSBASE"
    | RDMSR: "RDMSR"
    | RDPMC: "RDPMC"
    | RDRAND x: "RDRAND"
    | RDTSC: "RDTSC"
    | RDTSCP: "RDTSCP"
    | RET x: "RET"
    | RET_FAR x: "RET_FAR"
    | ROL x: "ROL"
    | ROR x: "ROR"
    | ROUNDPD x: "ROUNDPD"
    | ROUNDPS x: "ROUNDPS"
    | ROUNDSD x: "ROUNDSD"
    | ROUNDSS x: "ROUNDSS"
    | RSM: "RSM"
    | RSQRTPS x: "RSQRTPS"
    | RSQRTSS x: "RSQRTSS"
    | SAHF: "SAHF"
    | SAL x: "SAL"
    | SAR x: "SAR"
    | SBB x: "SBB"
    | SCASB: "SCASB"
    | SCASD: "SCASD"
    | SCASQ: "SCASQ"
    | SCASW: "SCASW"
    | SETA x: "SETA"
    | SETAE x: "SETAE"
    | SETB x: "SETB"
    | SETBE x: "SETBE"
    | SETC x: "SETC"
    | SETE x: "SETE"
    | SETG x: "SETG"
    | SETGE x: "SETGE"
    | SETL x: "SETL"
    | SETLE x: "SETLE"
    | SETNA x: "SETNA"
    | SETNAE x: "SETNAE"
    | SETNB x: "SETNB"
    | SETNBE x: "SETNBE"
    | SETNC x: "SETNC"
    | SETNE x: "SETNE"
    | SETNG x: "SETNG"
    | SETNGE x: "SETNGE"
    | SETNL x: "SETNL"
    | SETNLE x: "SETNLE"
    | SETNO x: "SETNO"
    | SETNP x: "SETNP"
    | SETNS x: "SETNS"
    | SETNZ x: "SETNZ"
    | SETO x: "SETO"
    | SETP x: "SETP"
    | SETPE x: "SETPE"
    | SETPO x: "SETPO"
    | SETS x: "SETS"
    | SETZ x: "SETZ"
    | SFENCE: "SFENCE"
    | SGDT x: "SGDT"
    | SHL x: "SHL"
    | SHLD x: "SHLD"
    | SHR x: "SHR"
    | SHRD x: "SHRD"
    | SHUFPD x: "SHUFPD"
    | SHUFPS x: "SHUFPS"
    | SIDT x: "SIDT"
    | SLDT x: "SLDT"
    | SMSW x: "SMSW"
    | SQRTPD x: "SQRTPD"
    | SQRTPS x: "SQRTPS"
    | SQRTSD x: "SQRTSD"
    | SQRTSS x: "SQRTSS"
    | STC: "STC"
    | STD: "STD"
    | STI: "STI"
    | STMXCSR x: "STMXCSR"
    | STOSB: "STOSB"
    | STOSD: "STOSD"
    | STOSQ: "STOSQ"
    | STOSW: "STOSW"
    | STR x: "STR"
    | SUB x: "SUB"
    | SUBPD x: "SUBPD"
    | SUBPS x: "SUBPS"
    | SUBSD x: "SUBSD"
    | SUBSS x: "SUBSS"
    | SWAPGS: "SWAPGS"
    | SYSCALL: "SYSCALL"
    | SYSENTER: "SYSENTER"
    | SYSEXIT: "SYSEXIT"
    | SYSRET: "SYSRET"
    | TEST x: "TEST"
    | UCOMISD x: "UCOMISD"
    | UCOMISS x: "UCOMISS"
    | UD2: "UD2"
    | UNPCKHPD x: "UNPCKHPD"
    | UNPCKHPS x: "UNPCKHPS"
    | UNPCKLPD x: "UNPCKLPD"
    | UNPCKLPS x: "UNPCKLPS"
    | VADDPD x: "VADDPD"
    | VADDPS x: "VADDPS"
    | VADDSD x: "VADDSD"
    | VADDSS x: "VADDSS"
    | VADDSUBPD x: "VADDSUBPD"
    | VADDSUBPS x: "VADDSUBPS"
    | VAESDEC x: "VAESDEC"
    | VAESDECLAST x: "VAESDECLAST"
    | VAESENC x: "VAESENC"
    | VAESENCLAST x: "VAESENCLAST"
    | VAESIMC x: "VAESIMC"
    | VAESKEYGENASSIST x: "VAESKEYGENASSIST"
    | VANDNPD x: "VANDNPD"
    | VANDNPS x: "VANDNPS"
    | VANDPD x: "VANDPD"
    | VANDPS x: "VANDPS"
    | VBLENDPD x: "VBLENDPD"
    | VBLENDPS x: "VBLENDPS"
    | VBLENDVPD x: "VBLENDVPD"
    | VBLENDVPS x: "VBLENDVPS"
    | VBROADCASTF128 x: "VBROADCASTF128"
    | VBROADCASTSD x: "VBROADCASTSD"
    | VBROADCASTSS x: "VBROADCASTSS"
    | VCMPPD x: "VCMPPD"
    | VCMPPS x: "VCMPPS"
    | VCMPSD x: "VCMPSD"
    | VCMPSS x: "VCMPSS"
    | VCOMISD x: "VCOMISD"
    | VCOMISS x: "VCOMISS"
    | VCVTDQ2PD x: "VCVTDQ2PD"
    | VCVTDQ2PS x: "VCVTDQ2PS"
    | VCVTPD2DQ x: "VCVTPD2DQ"
    | VCVTPD2PS x: "VCVTPD2PS"
    | VCVTPH2PS x: "VCVTPH2PS"
    | VCVTPS2DQ x: "VCVTPS2DQ"
    | VCVTPS2PD x: "VCVTPS2PD"
    | VCVTPS2PH x: "VCVTPS2PH"
    | VCVTSD2SI x: "VCVTSD2SI"
    | VCVTSD2SS x: "VCVTSD2SS"
    | VCVTSI2SD x: "VCVTSI2SD"
    | VCVTSI2SS x: "VCVTSI2SS"
    | VCVTSS2SD x: "VCVTSS2SD"
    | VCVTSS2SI x: "VCVTSS2SI"
    | VCVTTPD2DQ x: "VCVTTPD2DQ"
    | VCVTTPS2DQ x: "VCVTTPS2DQ"
    | VCVTTSD2SI x: "VCVTTSD2SI"
    | VCVTTSS2SI x: "VCVTTSS2SI"
    | VDIVPD x: "VDIVPD"
    | VDIVPS x: "VDIVPS"
    | VDIVSD x: "VDIVSD"
    | VDIVSS x: "VDIVSS"
    | VDPPD x: "VDPPD"
    | VDPPS x: "VDPPS"
    | VERR x: "VERR"
    | VERW x: "VERW"
    | VEXTRACTF128 x: "VEXTRACTF128"
    | VEXTRACTPS x: "VEXTRACTPS"
    | VHADDPD x: "VHADDPD"
    | VHADDPS x: "VHADDPS"
    | VHSUBPD x: "VHSUBPD"
    | VHSUBPS x: "VHSUBPS"
    | VINSERTF128 x: "VINSERTF128"
    | VINSERTPS x: "VINSERTPS"
    | VLDDQU x: "VLDDQU"
    | VLDMXCSR x: "VLDMXCSR"
    | VMASKMOVDQU x: "VMASKMOVDQU"
    | VMASKMOVPD x: "VMASKMOVPD"
    | VMASKMOVPS x: "VMASKMOVPS"
    | VMAXPD x: "VMAXPD"
    | VMAXPS x: "VMAXPS"
    | VMAXSD x: "VMAXSD"
    | VMAXSS x: "VMAXSS"
    | VMINPD x: "VMINPD"
    | VMINPS x: "VMINPS"
    | VMINSD x: "VMINSD"
    | VMINSS x: "VMINSS"
    | VMOVAPD x: "VMOVAPD"
    | VMOVAPS x: "VMOVAPS"
    | VMOVD x: "VMOVD"
    | VMOVDDUP x: "VMOVDDUP"
    | VMOVDQA x: "VMOVDQA"
    | VMOVDQU x: "VMOVDQU"
    | VMOVHLPS x: "VMOVHLPS"
    | VMOVHPD x: "VMOVHPD"
    | VMOVHPS x: "VMOVHPS"
    | VMOVLHPS x: "VMOVLHPS"
    | VMOVLPD x: "VMOVLPD"
    | VMOVLPS x: "VMOVLPS"
    | VMOVMSKPD x: "VMOVMSKPD"
    | VMOVMSKPS x: "VMOVMSKPS"
    | VMOVNTDQ x: "VMOVNTDQ"
    | VMOVNTDQA x: "VMOVNTDQA"
    | VMOVNTPD x: "VMOVNTPD"
    | VMOVNTPS x: "VMOVNTPS"
    | VMOVQ x: "VMOVQ"
    | VMOVSD x: "VMOVSD"
    | VMOVSHDUP x: "VMOVSHDUP"
    | VMOVSLDUP x: "VMOVSLDUP"
    | VMOVSS x: "VMOVSS"
    | VMOVUPD x: "VMOVUPD"
    | VMOVUPS x: "VMOVUPS"
    | VMPSADBW x: "VMPSADBW"
    | VMULPD x: "VMULPD"
    | VMULPS x: "VMULPS"
    | VMULSD x: "VMULSD"
    | VMULSS x: "VMULSS"
    | VORPD x: "VORPD"
    | VORPS x: "VORPS"
    | VPABSB x: "VPABSB"
    | VPABSD x: "VPABSD"
    | VPABSW x: "VPABSW"
    | VPACKSSDW x: "VPACKSSDW"
    | VPACKSSWB x: "VPACKSSWB"
    | VPACKUSDW x: "VPACKUSDW"
    | VPACKUSWB x: "VPACKUSWB"
    | VPADDB x: "VPADDB"
    | VPADDD x: "VPADDD"
    | VPADDQ x: "VPADDQ"
    | VPADDSB x: "VPADDSB"
    | VPADDSW x: "VPADDSW"
    | VPADDUSB x: "VPADDUSB"
    | VPADDUSW x: "VPADDUSW"
    | VPADDW x: "VPADDW"
    | VPALIGNR x: "VPALIGNR"
    | VPAND x: "VPAND"
    | VPANDN x: "VPANDN"
    | VPAVGB x: "VPAVGB"
    | VPAVGW x: "VPAVGW"
    | VPBLENDVB x: "VPBLENDVB"
    | VPBLENDW x: "VPBLENDW"
    | VPCLMULQDQ x: "VPCLMULQDQ"
    | VPCMPEQB x: "VPCMPEQB"
    | VPCMPEQD x: "VPCMPEQD"
    | VPCMPEQQ x: "VPCMPEQQ"
    | VPCMPEQW x: "VPCMPEQW"
    | VPCMPESTRI x: "VPCMPESTRI"
    | VPCMPESTRM x: "VPCMPESTRM"
    | VPCMPGTB x: "VPCMPGTB"
    | VPCMPGTD x: "VPCMPGTD"
    | VPCMPGTQ x: "VPCMPGTQ"
    | VPCMPGTW x: "VPCMPGTW"
    | VPCMPISTRI x: "VPCMPISTRI"
    | VPCMPISTRM x: "VPCMPISTRM"
    | VPERM2F128 x: "VPERM2F128"
    | VPERMILPD x: "VPERMILPD"
    | VPERMILPS x: "VPERMILPS"
    | VPEXTRB x: "VPEXTRB"
    | VPEXTRD x: "VPEXTRD"
    | VPEXTRQ x: "VPEXTRQ"
    | VPEXTRW x: "VPEXTRW"
    | VPHADDD x: "VPHADDD"
    | VPHADDSW x: "VPHADDSW"
    | VPHADDW x: "VPHADDW"
    | VPHMINPOSUW x: "VPHMINPOSUW"
    | VPHSUBD x: "VPHSUBD"
    | VPHSUBSW x: "VPHSUBSW"
    | VPHSUBW x: "VPHSUBW"
    | VPINSRB x: "VPINSRB"
    | VPINSRD x: "VPINSRD"
    | VPINSRQ x: "VPINSRQ"
    | VPINSRW x: "VPINSRW"
    | VPMADDUBSW x: "VPMADDUBSW"
    | VPMADDWD x: "VPMADDWD"
    | VPMAXSB x: "VPMAXSB"
    | VPMAXSD x: "VPMAXSD"
    | VPMAXSW x: "VPMAXSW"
    | VPMAXUB x: "VPMAXUB"
    | VPMAXUD x: "VPMAXUD"
    | VPMAXUW x: "VPMAXUW"
    | VPMINSB x: "VPMINSB"
    | VPMINSD x: "VPMINSD"
    | VPMINSW x: "VPMINSW"
    | VPMINUB x: "VPMINUB"
    | VPMINUD x: "VPMINUD"
    | VPMINUW x: "VPMINUW"
    | VPMOVMSKB x: "VPMOVMSKB"
    | VPMOVSXBD x: "VPMOVSXBD"
    | VPMOVSXBQ x: "VPMOVSXBQ"
    | VPMOVSXBW x: "VPMOVSXBW"
    | VPMOVSXDQ x: "VPMOVSXDQ"
    | VPMOVSXWD x: "VPMOVSXWD"
    | VPMOVSXWQ x: "VPMOVSXWQ"
    | VPMOVZXBD x: "VPMOVZXBD"
    | VPMOVZXBQ x: "VPMOVZXBQ"
    | VPMOVZXBW x: "VPMOVZXBW"
    | VPMOVZXDQ x: "VPMOVZXDQ"
    | VPMOVZXWD x: "VPMOVZXWD"
    | VPMOVZXWQ x: "VPMOVZXWQ"
    | VPMULDQ x: "VPMULDQ"
    | VPMULHRSW x: "VPMULHRSW"
    | VPMULHUW x: "VPMULHUW"
    | VPMULHW x: "VPMULHW"
    | VPMULLD x: "VPMULLD"
    | VPMULLW x: "VPMULLW"
    | VPMULUDQ x: "VPMULUDQ"
    | VPOR x: "VPOR"
    | VPSADBW x: "VPSADBW"
    | VPSHUFB x: "VPSHUFB"
    | VPSHUFD x: "VPSHUFD"
    | VPSHUFHW x: "VPSHUFHW"
    | VPSHUFLW x: "VPSHUFLW"
    | VPSIGNB x: "VPSIGNB"
    | VPSIGND x: "VPSIGND"
    | VPSIGNW x: "VPSIGNW"
    | VPSLLD x: "VPSLLD"
    | VPSLLDQ x: "VPSLLDQ"
    | VPSLLQ x: "VPSLLQ"
    | VPSLLW x: "VPSLLW"
    | VPSRAD x: "VPSRAD"
    | VPSRAW x: "VPSRAW"
    | VPSRLD x: "VPSRLD"
    | VPSRLDQ x: "VPSRLDQ"
    | VPSRLQ x: "VPSRLQ"
    | VPSRLW x: "VPSRLW"
    | VPSUBB x: "VPSUBB"
    | VPSUBD x: "VPSUBD"
    | VPSUBQ x: "VPSUBQ"
    | VPSUBSB x: "VPSUBSB"
    | VPSUBSW x: "VPSUBSW"
    | VPSUBUSB x: "VPSUBUSB"
    | VPSUBUSW x: "VPSUBUSW"
    | VPSUBW x: "VPSUBW"
    | VPTEST x: "VPTEST"
    | VPUNPCKHBW x: "VPUNPCKHBW"
    | VPUNPCKHDQ x: "VPUNPCKHDQ"
    | VPUNPCKHQDQ x: "VPUNPCKHQDQ"
    | VPUNPCKHWD x: "VPUNPCKHWD"
    | VPUNPCKLBW x: "VPUNPCKLBW"
    | VPUNPCKLDQ x: "VPUNPCKLDQ"
    | VPUNPCKLQDQ x: "VPUNPCKLQDQ"
    | VPUNPCKLWD x: "VPUNPCKLWD"
    | VPXOR x: "VPXOR"
    | VRCPPS x: "VRCPPS"
    | VRCPSS x: "VRCPSS"
    | VROUNDPD x: "VROUNDPD"
    | VROUNDPS x: "VROUNDPS"
    | VROUNDSD x: "VROUNDSD"
    | VROUNDSS x: "VROUNDSS"
    | VRSQRTPS x: "VRSQRTPS"
    | VRSQRTSS x: "VRSQRTSS"
    | VSHUFPD x: "VSHUFPD"
    | VSHUFPS x: "VSHUFPS"
    | VSQRTPD x: "VSQRTPD"
    | VSQRTPS x: "VSQRTPS"
    | VSQRTSD x: "VSQRTSD"
    | VSQRTSS x: "VSQRTSS"
    | VSTMXCSR x: "VSTMXCSR"
    | VSUBPD x: "VSUBPD"
    | VSUBPS x: "VSUBPS"
    | VSUBSD x: "VSUBSD"
    | VSUBSS x: "VSUBSS"
    | VTESTPD x: "VTESTPD"
    | VTESTPS x: "VTESTPS"
    | VUCOMISD x: "VUCOMISD"
    | VUCOMISS x: "VUCOMISS"
    | VUNPCKHPD x: "VUNPCKHPD"
    | VUNPCKHPS x: "VUNPCKHPS"
    | VUNPCKLPD x: "VUNPCKLPD"
    | VUNPCKLPS x: "VUNPCKLPS"
    | VXORPD x: "VXORPD"
    | VXORPS x: "VXORPS"
    | VZEROALL x: "VZEROALL"
    | VZEROUPPER x: "VZEROUPPER"
    | WAIT: "WAIT"
    | WBINVD: "WBINVD"
    | WRFSBASE x: "WRFSBASE"
    | WRGSBASE x: "WRGSBASE"
    | WRMSR: "WRMSR"
    | XADD x: "XADD"
    | XCHG x: "XCHG"
    | XGETBV: "XGETBV"
    | XLATB: "XLATB"
    | XOR x: "XOR"
    | XORPD x: "XORPD"
    | XORPS x: "XORPS"
    | XRSTOR x: "XRSTOR"
    | XRSTOR64 x: "XRSTOR64"
    | XSAVE x: "XSAVE"
    | XSAVE64 x: "XSAVE64"
    | XSAVEOPT x: "XSAVEOPT"
    | XSAVEOPT64 x: "XSAVEOPT64"
    | XSETBV: "XSETBV"
    #| PSLRDQ: "PSLRDQ"
    #| VPSLRDQ: "VPSLRDQ"
   end
#:'<,'>s/\(.*\)| \(\S*\)\( x\)\=:.*/\1| \2\3: "\2"/g

val pretty-operand x i =
  case (uarity-of x.insn) of
     UA1 v: case i of
        0: show/operand '0' v.opnd1
     end
   | UA2 v: case i of
        0: show/operand '0' v.opnd1
      | 1: show/operand '0' v.opnd2
     end
   | UA3 v: case i of
        0: show/operand '0' v.opnd1
      | 1: show/operand '0' v.opnd2
      | 2: show/operand '0' v.opnd3
     end
   | UA4 v: case i of
        0: show/operand '0' v.opnd1
      | 1: show/operand '0' v.opnd2
      | 2: show/operand '0' v.opnd3
      | 3: show/operand '0' v.opnd4
     end
   | UAF v: case i of
        0: show/flowoperand v.opnd1
     end
  end

val pretty-operand-force-types x = pretty x +++ (pretty-operand x 0)

val pretty-mnemonic x = show/mnemonic x.insn

val pretty-mnemonic-force-types x = pretty x +++ (pretty-mnemonic x)
