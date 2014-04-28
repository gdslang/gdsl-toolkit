# vim:ts=3:sw=3:expandtab

export = pretty pretty-operand pretty-mnemonic

val pretty i = show/instruction i

val show/unop x = show/operand x.operand
val show/binop x = show/operand x.first +++ ", " +++ show/operand x.second
val show/ternop x = show/operand x.first +++ ", " +++ show/operand x.second +++ ", " +++ show/operand x.third
val -++ a b = a +++ " " +++ b

val show/side-effect eff =
   case eff of
      NONE: ""
    | INCR a: case a of
         1: "++"
       | _: "(++ " +++ show-int a +++ ")"
      end
    | DECR: "--"
  end

val show/operand opnd = 
   case opnd of
      REG r: show/register r
    | REGHL r: show/register r.regh +++ "/" +++ show/register r.regl
    | REGIHL r: show/register r.regi +++ "/" +++ show/register r.reghl.regh +++ "/" +++ show/register r.reghl.regl
    | IOREG ior: show/register ior
    | IMM imm: show/operand/imm imm
    | OPSE op: show/operand op.op +++ show/side-effect op.se
    | OPDI op: show/operand op.op +++ "+" +++ show/operand/imm op.imm
   end

val show/operand/imm imm =
   case imm of
      IMM3 x: show-int (zx x)
    | IMM4 x: show-int (zx x)
    | IMM6 x: show-int (zx x)
    | IMM7 x: show-int (zx x)
    | IMM8 x: show-int (zx x)
    | IMM12 x: show-int (zx x)
    | IMM16 x: show-int (zx x)
    | IMM22 x: show-int (zx x)
    | IMMi i: show-int i
  end

val show/operands insn_cl =
  case insn_cl of
     TERNOP o: show/ternop o
   | BINOP o: show/binop o
   | UNOP o: show/unop o
   | NOOP: ""
  end

val pretty-operand insn i = let
  val ith3 o = case i of
     0: show/operand o.first
   | 1: show/operand o.second
   | 2: show/operand o.third
  end

  val ith2 o = case i of
     0: show/operand o.first
   | 1: show/operand o.second
  end

  val ith1 o = case i of
     0: show/operand o.operand
  end
in
  case (classify insn) of
     TERNOP o: ith3 o
   | BINOP o: ith2 o
   | UNOP o: ith1 o
  end
end

val show/instruction i = let
  val insn_cl = classify i
in
 show/mnemonic i -++ show/operands insn_cl
end

val show/mnemonic i =
   case i of
      ADC x: "ADC"
    | ADD x: "ADD"
    | ADIW x: "ADIW"
    | AND x: "AND"
    | ANDI x: "ANDI"
    | ASR x: "ASR"
    | BLD x: "BLD"
    | BRCC x: "BRCC"
    | BRCS x: "BRCS"
    | BREAK: "BREAK"
    | BREQ x: "BREQ"
    | BRGE x: "BRGE"
    | BRHC x: "BRHC"
    | BRHS x: "BRHS"
    | BRID x: "BRID"
    | BRIE x: "BRIE"
    | BRLT x: "BRLT"
    | BRMI x: "BRMI"
    | BRNE x: "BRNE"
    | BRPL x: "BRPL"
    | BRTC x: "BRTC"
    | BRTS x: "BRTS"
    | BRVC x: "BRVC"
    | BRVS x: "BRVS"
    | BST x: "BST"
    | CALL x: "CALL"
    | CBI x: "CBI"
    | CBR x: "CBR"
    | CLC: "CLC" 
    | CLH: "CLH"
    | CLI: "CLI"
    | CLN: "CLN"
    | CLR x: "CLR"
    | CLS: "CLS"
    | CLT: "CLT"
    | CLV: "CLV"
    | CLZ: "CLZ"
    | COM x: "COM"
    | CP x: "CP"
    | CPC x: "CPC"
    | CPI x: "CPI"
    | CPSE x: "CPSE"
    | DEC x: "DEC"
    | DES x: "DES"
    | EICALL: "EICALL"
    | EIJMP: "EIJMP"
    | ELPM x: "ELPM"
    | EOR x: "EOR"
    | FMUL x: "FMUL"
    | FMULS x: "FMULS"
    | FMULSU x: "FMULSU"
    | ICALL: "ICALL"
    | IJMP: "IJMP"
    | IN x: "IN"
    | INC x: "INC"
    | JMP x: "JMP"
    | LAC x: "LAC"
    | LAS x: "LAS"
    | LAT x: "LAT"
    | LD x: "LD"
    | LDI x: "LDI"
    | LDS x: "LDS"
    | LPM x: "LPM"
    | LSL x: "LSL"
    | LSR x: "LSR"
    | MOV x: "MOV"
    | MOVW x: "MOVW"
    | MUL x: "MUL"
    | MULS x: "MULS"
    | MULSU x: "MULSU"
    | NEG x: "NEG"
    | NOP: "NOP"
    | OR x: "OR"
    | ORI x: "ORI"
    | OUT x: "OUT"
    | POP x: "POP"
    | PUSH x: "PUSH"
    | RCALL x: "RCALL"
    | RET: "RET"
    | RETI: "RETI"
    | RJMP x: "RJMP"
    | ROL x: "ROL"
    | ROR x: "ROR"
    | SBC x: "SBC"
    | SBCI x: "SBCI"
    | SBI x: "SBI"
    | SBIC x: "SBIC"
    | SBIS x: "SBIS"
    | SBIW x: "SBIW"
    | SBR x: "SBR"
    | SBRC x: "SBRC"
    | SBRS x: "SBRS"
    | SEC: "SEC"
    | SEH: "SEH"
    | SEI: "SEI"
    | SEN: "SEN"
    | SES: "SES"
    | SET: "SET"
    | SEV: "SEV"
    | SEZ: "SEZ"
    | SLEEP: "SLEEP"
    | SPM x: "SPM"
    | ST x: "ST"
    | STS x: "STS"
    | SUB x: "SUB"
    | SUBI x: "SUBI"
    | SWAP x: "SWAP"
    | TST x: "TST"
    | WDR: "WDR"
    | XCH x: "XCH"
   end

val pretty-mnemonic i = show/mnemonic i

val show/register r =
   case r of
      R0 : "R0"  
    | R1 : "R1"
    | R2 : "R2"
    | R3 : "R3"
    | R4 : "R4"
    | R5 : "R5"
    | R6 : "R6"
    | R7 : "R7"
    | R8 : "R8"
    | R9 : "R9"
    | R10: "R10" 
    | R11: "R11"
    | R12: "R12"
    | R13: "R13"
    | R14: "R14"
    | R15: "R15"
    | R16: "R16"
    | R17: "R17"
    | R18: "R18"
    | R19: "R19"
    | R20: "R20"
    | R21: "R21"
    | R22: "R22"
    | R23: "R23"
    | R24: "R24"
    | R25: "R25"
    | R26: "R26"
    | R27: "R27"
    | R28: "R28"
    | R29: "R29"
    | R30: "R30"
    | R31: "R31"
    | IO0 : "IO0"   
    | IO1 : "IO1"
    | IO2 : "IO2"
    | IO3 : "IO3"
    | IO4 : "IO4"
    | IO5 : "IO5"
    | IO6 : "IO6"
    | IO7 : "IO7"
    | IO8 : "IO8"
    | IO9 : "IO9"
    | IO10: "IO10"
    | IO11: "IO11"
    | IO12: "IO12"
    | IO13: "IO13"
    | IO14: "IO14"
    | IO15: "IO15"
    | IO16: "IO16"
    | IO17: "IO17"
    | IO18: "IO18"
    | IO19: "IO19"
    | IO20: "IO20"
    | IO21: "IO21"
    | IO22: "IO22"
    | IO23: "IO23"
    | IO24: "IO24"
    | IO25: "IO25"
    | IO26: "IO26"
    | IO27: "IO27"
    | IO28: "IO28"
    | IO29: "IO29"
    | IO30: "IO30"
    | IO31: "IO31"
    | IO32: "IO32"
    | IO33: "IO33"
    | IO34: "IO34"
    | IO35: "IO35"
    | IO36: "IO36"
    | IO37: "IO37"
    | IO38: "IO38"
    | IO39: "IO39"
    | IO40: "IO40"
    | IO41: "IO41"
    | IO42: "IO42"
    | IO43: "IO43"
    | IO44: "IO44"
    | IO45: "IO45"
    | IO46: "IO46"
    | IO47: "IO47"
    | IO48: "IO48"
    | IO49: "IO49"
    | IO50: "IO50"
    | IO51: "IO51"
    | IO52: "IO52"
    | IO53: "IO53"
    | IO54: "IO54"
    | IO55: "IO55"
    | RAMPD: "RAMPD"
    | RAMPX: "RAMPX"
    | RAMPY: "RAMPY"
    | RAMPZ: "RAMPZ"
    | EIND: "EIND"
    | SPL: "SPL"
    | SPH: "SPH"
    | SREG: "SREG"
    | PC: "PC"
   end
