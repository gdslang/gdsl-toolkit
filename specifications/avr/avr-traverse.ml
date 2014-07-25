type uarity =
   UA0
 | UA1 of unop
 | UA2 of binop
 | UA3 of ternop

val uarity-of insn = let
  val f a b = b
in
  traverse f insn
end

val traverse f insn = case insn of
   ADC b: f "ADC" (UA2 b)
 | ADD b: f "ADD" (UA2 b)
 | ADIW b: f "ADIW" (UA2 b)
 | AND b: f "AND" (UA2 b)
 | ANDI b: f "ANDI" (UA2 b)
 | ASR u: f "ASR" (UA1 u)
 | BLD b: f "BLD" (UA2 b)
 | BRCC u: f "BRCC" (UA1 u)
 | BRCS u: f "BRCS" (UA1 u)
 | BREAK: f "BREAK" UA0
 | BREQ u: f "BREQ" (UA1 u)
 | BRGE u: f "BRGE" (UA1 u)
 | BRHC u: f "BRHC" (UA1 u)
 | BRHS u: f "BRHS" (UA1 u)
 | BRID u: f "BRID" (UA1 u)
 | BRIE u: f "BRIE" (UA1 u)
 | BRLT u: f "BRLT" (UA1 u)
 | BRMI u: f "BRMI" (UA1 u)
 | BRNE u: f "BRNE" (UA1 u)
 | BRPL u: f "BRPL" (UA1 u)
 | BRTC u: f "BRTC" (UA1 u)
 | BRTS u: f "BRTS" (UA1 u)
 | BRVC u: f "BRVC" (UA1 u)
 | BRVS u: f "BRVS" (UA1 u)
 | BST b: f "BST" (UA2 b)
 | CALL u: f "CALL" (UA1 u)
 | CBI b: f "CBI" (UA2 b)
 | CBR b: f "CBR" (UA2 b)
 | CLC: f "CLC" UA0
 | CLH: f "CLH" UA0
 | CLI: f "CLI" UA0
 | CLN: f "CLN" UA0
 | CLR u: f "CLR" (UA1 u)
 | CLS: f "CLS" UA0
 | CLT: f "CLT" UA0
 | CLV: f "CLV" UA0
 | CLZ: f "CLZ" UA0
 | COM u: f "COM" (UA1 u)
 | CP b: f "CP" (UA2 b)
 | CPC b: f "CPC" (UA2 b)
 | CPI b: f "CPI" (UA2 b)
 | CPSE t: f "CPSE" (UA3 t)
 | DEC u: f "DEC" (UA1 u)
 | DES u: f "DES" (UA1 u)
 | EICALL: f "EICALL" UA0
 | EIJMP: f "EIJMP" UA0
 | ELPM b: f "ELPM" (UA2 b)
 | EOR b: f "EOR" (UA2 b)
 | FMUL b: f "FMUL" (UA2 b)
 | FMULS b: f "FMULS" (UA2 b)
 | FMULSU b: f "FMULSU" (UA2 b)
 | ICALL: f "ICALL" UA0
 | IJMP: f "IJMP" UA0
 | IN b: f "IN" (UA2 b)
 | INC u: f "INC" (UA1 u)
 | JMP u: f "JMP" (UA1 u)
 | LAC b: f "LAC" (UA2 b)
 | LAS b: f "LAS" (UA2 b)
 | LAT b: f "LAT" (UA2 b)
 | LD b: f "LD" (UA2 b)
 | LDI b: f "LDI" (UA2 b)
 | LDS b: f "LDS" (UA2 b)
 | LPM b: f "LPM" (UA2 b)
 | LSL u: f "LSL" (UA1 u)
 | LSR u: f "LSR" (UA1 u)
 | MOV b: f "MOV" (UA2 b)
 | MOVW b: f "MOVW" (UA2 b)
 | MUL b: f "MUL" (UA2 b)
 | MULS b: f "MULS" (UA2 b)
 | MULSU b: f "MULSU" (UA2 b)
 | NEG u: f "NEG" (UA1 u)
 | NOP: f "NOP" UA0
 | OR b: f "OR" (UA2 b)
 | ORI b: f "ORI" (UA2 b)
 | OUT b: f "OUT" (UA2 b)
 | POP u: f "POP" (UA1 u)
 | PUSH u: f "PUSH" (UA1 u)
 | RCALL u: f "RCALL" (UA1 u)
 | RET: f "RET" UA0
 | RETI: f "RETI" UA0
 | RJMP u: f "RJMP" (UA1 u)
 | ROL u: f "ROL" (UA1 u)
 | ROR u: f "ROR" (UA1 u)
 | SBC b: f "SBC" (UA2 b)
 | SBCI b: f "SBCI" (UA2 b)
 | SBI b: f "SBI" (UA2 b)
 | SBIC t: f "SBIC" (UA3 t)
 | SBIS t: f "SBIS" (UA3 t)
 | SBIW b: f "SBIW" (UA2 b)
 | SBR b: f "SBR" (UA2 b)
 | SBRC t: f "SBRC" (UA3 t)
 | SBRS t: f "SBRS" (UA3 t)
 | SEC: f "SEC" UA0
 | SEH: f "SEH" UA0
 | SEI: f "SEI" UA0
 | SEN: f "SEN" UA0
 | SES: f "SES" UA0
 | SET: f "SET" UA0
 | SEV: f "SEV" UA0
 | SEZ: f "SEZ" UA0
 | SLEEP: f "SLEEP" UA0
 | SPM u: f "SPM" (UA1 u)
 | ST b: f "ST" (UA2 b)
 | STS b: f "STS" (UA2 b)
 | SUB b: f "SUB" (UA2 b)
 | SUBI b: f "SUBI" (UA2 b)
 | SWAP u: f "SWAP" (UA1 u)
 | TST u: f "TST" (UA1 u)
 | WDR: f "WDR" UA0
 | XCH b: f "XCH" (UA2 b)
end
