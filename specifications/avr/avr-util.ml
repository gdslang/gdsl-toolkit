export = operands

type insn_cl =
   TERNOP of ternop
 | BINOP of binop
 | UNOP of unop
 | NOOP

val classify insn = case insn of
   ADC o: BINOP o
 | ADD o: BINOP o
 | ADIW o: BINOP o
 | AND o: BINOP o
 | ANDI o: BINOP o
 | ASR o: UNOP o
 | BLD o: BINOP o
 | BRCC o: UNOP o
 | BRCS o: UNOP o
 | BREAK: NOOP
 | BREQ o: UNOP o
 | BRGE o: UNOP o
 | BRHC o: UNOP o
 | BRHS o: UNOP o
 | BRID o: UNOP o
 | BRIE o: UNOP o
 | BRLT o: UNOP o
 | BRMI o: UNOP o
 | BRNE o: UNOP o
 | BRPL o: UNOP o
 | BRTC o: UNOP o
 | BRTS o: UNOP o
 | BRVC o: UNOP o
 | BRVS o: UNOP o
 | BST o: BINOP o
 | CALL o: UNOP o
 | CBI o: BINOP o
 | CBR o: BINOP o
 | CLC: NOOP
 | CLH: NOOP
 | CLI: NOOP
 | CLN: NOOP
 | CLR o: UNOP o
 | CLS: NOOP
 | CLT: NOOP
 | CLV: NOOP
 | CLZ: NOOP
 | COM o: UNOP o
 | CP o: BINOP o
 | CPC o: BINOP o
 | CPI o: BINOP o
 | CPSE o: TERNOP o
 | DEC o: UNOP o
 | DES o: UNOP o
 | EICALL: NOOP
 | EIJMP: NOOP
 | ELPM o: BINOP o
 | EOR o: BINOP o
 | FMUL o: BINOP o
 | FMULS o: BINOP o
 | FMULSU o: BINOP o
 | ICALL: NOOP
 | IJMP: NOOP
 | IN o: BINOP o
 | INC o: UNOP o
 | JMP o: UNOP o
 | LAC o: BINOP o
 | LAS o: BINOP o
 | LAT o: BINOP o
 | LD o: BINOP o
 | LDI o: BINOP o
 | LDS o: BINOP o
 | LPM o: BINOP o
 | LSL o: UNOP o
 | LSR o: UNOP o
 | MOV o: BINOP o
 | MOVW o: BINOP o
 | MUL o: BINOP o
 | MULS o: BINOP o
 | MULSU o: BINOP o
 | NEG o: UNOP o
 | NOP: NOOP
 | OR o: BINOP o
 | ORI o: BINOP o
 | OUT o: BINOP o
 | POP o: UNOP o
 | PUSH o: UNOP o
 | RCALL o: UNOP o
 | RET: NOOP
 | RETI: NOOP
 | RJMP o: UNOP o
 | ROL o: UNOP o
 | ROR o: UNOP o
 | SBC o: BINOP o
 | SBCI o: BINOP o
 | SBI o: BINOP o
 | SBIC o: TERNOP o
 | SBIS o: TERNOP o
 | SBIW o: BINOP o
 | SBR o: BINOP o
 | SBRC o: TERNOP o
 | SBRS o: TERNOP o
 | SEC: NOOP
 | SEH: NOOP
 | SEI: NOOP
 | SEN: NOOP
 | SES: NOOP
 | SET: NOOP
 | SEV: NOOP
 | SEZ: NOOP
 | SLEEP: NOOP
 | SPM o: UNOP o
 | ST o: BINOP o
 | STS o: BINOP o
 | SUB o: BINOP o
 | SUBI o: BINOP o
 | SWAP o: UNOP o
 | TST o: UNOP o
 | WDR: NOOP
 | XCH o: BINOP o
end

val operands insn = case (classify insn) of
   TERNOP o: 3
 | BINOP o: 2
 | UNOP o: 1
 | NOOP: 0
end
