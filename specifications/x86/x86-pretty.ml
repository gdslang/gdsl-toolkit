# vim:filetype=sml:ts=3:sw=3:expandtab

export pretty : (insndata) -> rope
export pretty-operand : (insndata,int) -> rope
export pretty-mnemonic : (insndata) -> rope

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

val -++ a b = a +++ " " +++ b

val show/x86-register r =
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
	 | s: show/x86-register s +++ ":"
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
    | REG x: show/x86-register x
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

val show/instruction insn = let
   val show/ua mnemonic ua = case ua of
      UA0: mnemonic
    | UA1 a: mnemonic -++ show/arity1 a
    | UA2 a: mnemonic -++ show/arity2 a
    | UA3 a: mnemonic -++ show/arity3 a
    | UA4 a: mnemonic -++ show/arity4 a
    | UAF f: mnemonic -++ show/flow1 f
   end
in
   traverse show/ua insn
end

val show/mnemonic insn = let
   val f a b = a
in
   traverse f insn
end

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
