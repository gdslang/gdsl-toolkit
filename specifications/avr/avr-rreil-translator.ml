export = translate

val sem-undef-binop bo = do
return 42
end

val sem-undef-unop uo = do
return 42
end

val sem-unknown = do
return 42
end

val sem-adc bo = do
return 42
end

val semantics insn =
 case insn of
    ADC x: sem-adc x
  | ADD x: sem-undef-binop x
  | ADIW x: sem-undef-binop x
  | AND x: sem-undef-binop x
  | ANDI x: sem-undef-binop x
  | ASR x: sem-undef-unop x
  | BLD x: sem-undef-binop x
  | BRCC x: sem-undef-unop x
  | BRCS x: sem-undef-unop x
  | BREAK: sem-unknown
  | BREQ x: sem-undef-unop x
  | BRGE x: sem-undef-unop x
  | BRHC x: sem-undef-unop x
  | BRHS x: sem-undef-unop x
  | BRID x: sem-undef-unop x
  | BRIE x: sem-undef-unop x
  | BRLT x: sem-undef-unop x
  | BRMI x: sem-undef-unop x
  | BRNE x: sem-undef-unop x
  | BRPL x: sem-undef-unop x
  | BRTC x: sem-undef-unop x
  | BRTS x: sem-undef-unop x
  | BRVC x: sem-undef-unop x
  | BRVS x: sem-undef-unop x
  | BSET x: sem-undef-unop x
  | BST x: sem-undef-binop x
  | CALL x: sem-undef-unop x
  | CBI x: sem-undef-binop x
  | CBR x: sem-undef-binop x
  | CLC: sem-unknown
  | CLH: sem-unknown
  | CLI: sem-unknown
  | CLN: sem-unknown
  | CLR x: sem-undef-unop x
  | CLS: sem-unknown
  | CLT: sem-unknown
  | CLV: sem-unknown
  | CLZ: sem-unknown
  | COM x: sem-undef-unop x
  | CP x: sem-undef-binop x
  | CPC x: sem-undef-binop x
  | CPI x: sem-undef-binop x
  | CPSE x: sem-undef-binop x
  | DEC x: sem-undef-unop x
  | DES x: sem-undef-unop x
  | EICALL: sem-unknown
  | EIJMP: sem-unknown
  | ELPM x: sem-undef-binop x
  | EOR x: sem-undef-binop x
  | FMUL x: sem-undef-binop x
  | FMULS x: sem-undef-binop x
  | FMULSU x: sem-undef-binop x
  | ICALL: sem-unknown
  | IJMP: sem-unknown
  | IN x: sem-undef-binop x
  | INC x: sem-undef-unop x
  | JMP x: sem-undef-unop x
  | LAC x: sem-undef-binop x
  | LAS x: sem-undef-binop x
  | LAT x: sem-undef-binop x
  | LD x: sem-undef-binop x
  | LDI x: sem-undef-binop x
  | LDS x: sem-undef-binop x
  | LPM x: sem-undef-binop x
  | LSL x: sem-undef-unop x
  | LSR x: sem-undef-unop x
  | MOV x: sem-undef-binop x
  | MOVW x: sem-undef-binop x
  | MUL x: sem-undef-binop x
  | MULS x: sem-undef-binop x
  | MULSU x: sem-undef-binop x
  | NEG x: sem-undef-unop x
  | NOP: sem-unknown
  | OR x: sem-undef-binop x
  | ORI x: sem-undef-binop x
  | OUT x: sem-undef-binop x
  | POP x: sem-undef-unop x
  | PUSH x: sem-undef-unop x
  | RCALL x: sem-undef-unop x
  | RET: sem-unknown
  | RETI: sem-unknown
  | RJMP x: sem-undef-unop x
  | ROL x: sem-undef-unop x
  | ROR x: sem-undef-unop x
  | SBC x: sem-undef-binop x
  | SBCI x: sem-undef-binop x
  | SBI x: sem-undef-binop x
  | SBIC x: sem-undef-binop x
  | SBIS x: sem-undef-binop x
  | SBIW x: sem-undef-binop x
  | SBR x: sem-undef-binop x
  | SBRC x: sem-undef-binop x
  | SBRS x: sem-undef-binop x
  | SEC: sem-unknown
  | SEH: sem-unknown
  | SEI: sem-unknown
  | SEN: sem-unknown
  | SES: sem-unknown
  | SET: sem-unknown
  | SEV: sem-unknown
  | SEZ: sem-unknown
  | SLEEP: sem-unknown
  | SPM x: sem-undef-unop x
  | ST x: sem-undef-binop x
  | STS x: sem-undef-binop x
  | SUB x: sem-undef-binop x
  | SUBI x: sem-undef-binop x
  | SWAP x: sem-undef-unop x
  | TST x: sem-undef-unop x
  | WDR: sem-unknown
  | XCH x: sem-undef-binop x
end

val translate insn = do
  update@{stack=SEM_NIL,tmp=0,lab=0,mode64='1'};
#case 0 of 1: return 0 end;
  semantics insn;
  stack <- query $stack;
  return (rreil-stmts-rev stack)
end
