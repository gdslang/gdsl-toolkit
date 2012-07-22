# vim:ts=3:sw=3:expandtab

export = pretty

val pretty i = show/instruction i

val show/unop x = show/operand x.operand
val show/binop x = show/operand x.first +++ ", " +++ show/operand x.second
val -++ a b = a +++ " " +++ b

val show/side-effect eff =
   case eff of
      NONE: ""
    | INCR: "+"
    | DECR: "-"
  end

val show/operand opnd = 
   case opnd of
      REG r: show/register r
    | REGHL r: show/register r.regh +++ "/" +++ show/register r.regl
    | IOREG ior: show/io-register ior
    | IMM imm: show/operand/imm imm
    | OPSE op: show/operand op.op +++ show/side-effect op.se
    | OPDI op: show/operand op.op +++ "+" +++ show/operand/imm op.imm
   end

val show/operand/imm imm =
   case imm of
      IMM3 x: showbitvec x
    | IMM4 x: showbitvec x
    | IMM6 x: showbitvec x
    | IMM7 x: showbitvec x
    | IMM8 x: showbitvec x
    | IMM12 x: showbitvec x
    | IMM16 x: showbitvec x
    | IMM22 x: showbitvec x
  end

val show/instruction i =
   case i of
      ADC x: "ADC" -++ show/binop x    
    | ADD x: "ADD" -++ show/binop x
    | ADIW x: "ADIW" -++ show/binop x
    | AND x: "AND" -++ show/binop x
    | ANDI x: "ANDI" -++ show/binop x
    | ASR x: "ASR" -++ show/unop x
    | BCLR x: "BCLR" -++ show/unop x
    | BLD x: "BLD" -++ show/binop x
    | BRBC x: "BRBC" -++ show/binop x
    | BRBS x: "BRBS" -++ show/binop x
    | BRCC x: "BRCC" -++ show/unop x
    | BRCS x: "BRCS" -++ show/unop x
    | BREAK: "BREAK"
    | BREQ x: "BREQ" -++ show/unop x
    | BRGE x: "BRGE" -++ show/unop x
    | BRHC x: "BRHC" -++ show/unop x
    | BRHS x: "BRHS" -++ show/unop x
    | BRID x: "BRID" -++ show/unop x
    | BRIE x: "BRIE" -++ show/unop x
    | BRLO x: "BRLO" -++ show/unop x
    | BRLT x: "BRLT" -++ show/unop x
    | BRMI x: "BRMI" -++ show/unop x
    | BRNE x: "BRNE" -++ show/unop x
    | BRPL x: "BRPL" -++ show/unop x
    | BRSH x: "BRSH" -++ show/unop x
    | BRTC x: "BRTC" -++ show/unop x
    | BRTS x: "BRTS" -++ show/unop x
    | BRVC x: "BRVC" -++ show/unop x
    | BRVS x: "BRVS" -++ show/unop x
    | BSET x: "BSET" -++ show/unop x
    | BST x: "BST" -++ show/binop x
    | CALL x: "CALL" -++ show/unop x
    | CBI x: "CBI" -++ show/binop x
    | CBR x: "CBR" -++ show/binop x
    | CLC: "CLC" 
    | CLH: "CLH"
    | CLI: "CLI"
    | CLN: "CLN"
    | CLR x: "CLR" -++ show/unop x
    | CLS: "CLS"
    | CLT: "CLT"
    | CLV: "CLV"
    | CLZ: "CLZ"
    | COM x: "COM" -++ show/unop x
    | CP x: "CP" -++ show/binop x
    | CPC x: "CPC" -++ show/binop x
    | CPI x: "CPI" -++ show/binop x
    | CPSE x: "CPSE" -++ show/binop x
    | DEC x: "DEC" -++ show/unop x
    | DES x: "DES" -++ show/unop x
    | EICALL: "EICALL"
    | EIJMP: "EIJMP"
    | ELPM x: "ELPM" -++ show/binop x
    | EOR x: "EOR" -++ show/binop x
    | FMUL x: "FMUL" -++ show/binop x
    | FMULS x: "FMULS" -++ show/binop x
    | FMULSU x: "FMULSU" -++ show/binop x
    | ICALL: "ICALL"
    | IJMP: "IJMP"
    | IN x: "IN" -++ show/binop x
    | INC x: "INC" -++ show/unop x
    | JMP x: "JMP" -++ show/unop x
    | LAC x: "LAC" -++ show/binop x
    | LAS x: "LAS" -++ show/binop x
    | LAT x: "LAT" -++ show/binop x
    | LD x: "LD" -++ show/binop x
    | LDI x: "LDI" -++ show/binop x
    | LDS x: "LDS" -++ show/binop x
    | LPM x: "LPM" -++ show/binop x
    | LSL x: "LSL" -++ show/unop x
    | LSR x: "LSR" -++ show/unop x
    | MOV x: "MOV" -++ show/binop x
    | MOVW x: "MOVW" -++ show/binop x
    | MUL x: "MUL" -++ show/binop x
    | MULS x: "MULS" -++ show/binop x
    | MULSU x: "MULSU" -++ show/binop x
    | NEG x: "NEG" -++ show/unop x
    | NOP: "NOP"
    | OR x: "OR" -++ show/binop x
    | ORI x: "ORI" -++ show/binop x
    | OUT x: "OUT" -++ show/binop x
    | POP x: "POP" -++ show/unop x
    | PUSH x: "PUSH" -++ show/unop x
    | RCALL x: "RCALL" -++ show/unop x
    | RET: "RET"
    | RETI: "RETI"
    | RJMP x: "RJMP" -++ show/unop x
    | ROL x: "ROL" -++ show/unop x
    | ROR x: "ROR" -++ show/unop x
    | SBC x: "SBC" -++ show/binop x
    | SBCI x: "SBCI" -++ show/binop x
    | SBI x: "SBI" -++ show/binop x
    | SBIC x: "SBIC" -++ show/binop x
    | SBIS x: "SBIS" -++ show/binop x
    | SBIW x: "SBIW" -++ show/binop x
    | SBR x: "SBR" -++ show/binop x
    | SBRC x: "SBRC" -++ show/binop x
    | SBRS x: "SBRS" -++ show/binop x
    | SEC: "SEC"
    | SEH: "SEH"
    | SEI: "SEI"
    | SEN: "SEN"
    | SER x: "SER" -++ show/unop x
    | SES: "SES"
    | SET: "SET"
    | SEV: "SEV"
    | SEZ: "SEZ"
    | SLEEP: "SLEEP"
    | SPM x: "SPM" -++ show/unop x
    | ST x: "ST" -++ show/binop x
    | STS x: "STS" -++ show/binop x
    | SUB x: "SUB" -++ show/binop x
    | SUBI x: "SUBI" -++ show/binop x
    | SWAP x: "SWAP" -++ show/unop x
    | TST x: "TST" -++ show/unop x
    | WDR: "WDR"
    | XCH x: "XCH" -++ show/binop x    
   end

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
  end

val show/io-register r =
   case r of
      IO0 : "IO0"   
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
    | IO56: "IO56"
    | IO57: "IO57"
    | IO58: "IO58"
    | IO59: "IO59"
    | IO60: "IO60"
    | IO61: "IO61"
    | IO62: "IO62"
    | IO63: "IO63"
   end
