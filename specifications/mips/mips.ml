granularity = 32
export = config-default decode

val s ['bit:1'] = do
 rs <- query $rs;
 update@{rs=rs ^ bit}
end

val t ['bit:1'] = do
 rt <- query $rt;
 update@{rt=rt ^ bit}
end

val d ['bit:1'] = do
 rd <- query $rd;
 update@{rd=rd ^ bit}
end


### PEW
###  - PEW with Carry
val / ['000000 s s s s s t t t t t d d d d d 00000 100000'] = ternop PEW rs5 rt5 rd5

val config-default = ''

val decode config = do
  update@{rs='',rt='',rd=''};
  /
end

val force-int-for-decode-config = decode config-default

type side-effect =
   NONE
 | INCR of int
 | DECR

type imm =
   IMM3 of 3
 | IMM4 of 4
 | IMM6 of 6
 | IMM7 of 7
 | IMM8 of 8
 | IMM12 of 12
 | IMM16 of 16
 | IMM22 of 22
 | IMMi of int

type reghl = {regh:register,regl:register} 

type operand =
   REG of register
 | REGHL of reghl
 | REGIHL of {regi:register,reghl:reghl}
 | IOREG of register
 | IMM of imm
 | OPSE of {op:operand,se:side-effect}
 | OPDI of {op:operand,imm:imm}

type ternop = {first:operand,second:operand,third:operand}
type binop = {first:operand,second:operand}
type unop = {operand:operand}

type instruction =
   ADC of binop
 | PEW of ternop
 | ADD of binop
 | ADIW of binop
 | AND of binop
 | ANDI of binop
 | ASR of unop
 | BLD of binop
 | BRCC of unop
 | BRCS of unop
 | BREAK
 | BREQ of unop
 | BRGE of unop
 | BRHC of unop
 | BRHS of unop
 | BRID of unop
 | BRIE of unop
 | BRLT of unop
 | BRMI of unop
 | BRNE of unop
 | BRPL of unop
 | BRTC of unop
 | BRTS of unop
 | BRVC of unop
 | BRVS of unop
 | BST of binop
 | CALL of unop
 | CBI of binop
 | CBR of binop
 | CLC
 | CLH
 | CLI
 | CLN
 | CLR of unop
 | CLS
 | CLT
 | CLV
 | CLZ
 | COM of unop
 | CP of binop
 | CPC of binop
 | CPI of binop
 | CPSE of ternop
 | DEC of unop
 | DES of unop
 | EICALL
 | EIJMP
 | ELPM of binop
 | EOR of binop
 | FMUL of binop
 | FMULS of binop
 | FMULSU of binop
 | ICALL
 | IJMP
 | IN of binop
 | INC of unop
 | JMP of unop
 | LAC of binop
 | LAS of binop
 | LAT of binop
 | LD of binop
 | LDI of binop
 | LDS of binop
 | LPM of binop
 | LSL of unop
 | LSR of unop
 | MOV of binop
 | MOVW of binop
 | MUL of binop
 | MULS of binop
 | MULSU of binop
 | NEG of unop
 | NOP
 | OR of binop
 | ORI of binop
 | OUT of binop
 | POP of unop
 | PUSH of unop
 | RCALL of unop
 | RET
 | RETI
 | RJMP of unop
 | ROL of unop
 | ROR of unop
 | SBC of binop
 | SBCI of binop
 | SBI of binop
 | SBIC of ternop
 | SBIS of ternop
 | SBIW of binop
 | SBR of binop
 | SBRC of ternop
 | SBRS of ternop
 | SEC
 | SEH
 | SEI
 | SEN
 | SES
 | SET
 | SEV
 | SEZ
 | SLEEP
 | SPM of unop
 | ST of binop
 | STS of binop
 | SUB of binop
 | SUBI of binop
 | SWAP of unop
 | TST of unop
 | WDR
 | XCH of binop

type register =
   R0
 | R1
 | R2
 | R3
 | R4
 | R5
 | R6
 | R7
 | R8
 | R9
 | R10
 | R11
 | R12
 | R13
 | R14
 | R15
 | R16
 | R17
 | R18
 | R19
 | R20
 | R21
 | R22
 | R23
 | R24
 | R25
 | R26
 | R27
 | R28
 | R29
 | R30
 | R31

type register =
   IO0
 | IO1
 | IO2
 | IO3
 | IO4
 | IO5
 | IO6
 | IO7
 | IO8
 | IO9
 | IO10
 | IO11
 | IO12
 | IO13
 | IO14
 | IO15
 | IO16
 | IO17
 | IO18
 | IO19
 | IO20
 | IO21
 | IO22
 | IO23
 | IO24
 | IO25
 | IO26
 | IO27
 | IO28
 | IO29
 | IO30
 | IO31
 | IO32
 | IO33
 | IO34
 | IO35
 | IO36
 | IO37
 | IO38
 | IO39
 | IO40
 | IO41
 | IO42
 | IO43
 | IO44
 | IO45
 | IO46
 | IO47
 | IO48
 | IO49
 | IO50
 | IO51
 | IO52
 | IO53
 | IO54
 | IO55
 | RAMPD
 | RAMPX
 | RAMPY
 | RAMPZ
 | EIND
 | SPL
 | SPH
 | SREG

type register =
   PC
 | SP

val register-from-bits bits =
 case bits of
    '00000': R0
  | '00001': R1
  | '00010': R2
  | '00011': R3
  | '00100': R4
  | '00101': R5
  | '00110': R6
  | '00111': R7
  | '01000': R8
  | '01001': R9
  | '01010': R10
  | '01011': R11
  | '01100': R12
  | '01101': R13
  | '01110': R14
  | '01111': R15
  | '10000': R16
  | '10001': R17
  | '10010': R18
  | '10011': R19
  | '10100': R20
  | '10101': R21
  | '10110': R22
  | '10111': R23
  | '11000': R24
  | '11001': R25
  | '11010': R26
  | '11011': R27
  | '11100': R28
  | '11101': R29
  | '11110': R30
  | '11111': R31
 end

val io-register-from-bits bits =
 case bits of
    '000000': IO0
  | '000001': IO1
  | '000010': IO2
  | '000011': IO3
  | '000100': IO4
  | '000101': IO5
  | '000110': IO6
  | '000111': IO7
  | '001000': IO8
  | '001001': IO9
  | '001010': IO10
  | '001011': IO11
  | '001100': IO12
  | '001101': IO13
  | '001110': IO14
  | '001111': IO15
  | '010000': IO16
  | '010001': IO17
  | '010010': IO18
  | '010011': IO19
  | '010100': IO20
  | '010101': IO21
  | '010110': IO22
  | '010111': IO23
  | '011000': IO24
  | '011001': IO25
  | '011010': IO26
  | '011011': IO27
  | '011100': IO28
  | '011101': IO29
  | '011110': IO30
  | '011111': IO31
  | '100000': IO32
  | '100001': IO33
  | '100010': IO34
  | '100011': IO35
  | '100100': IO36
  | '100101': IO37
  | '100110': IO38
  | '100111': IO39
  | '101000': IO40
  | '101001': IO41
  | '101010': IO42
  | '101011': IO43
  | '101100': IO44
  | '101101': IO45
  | '101110': IO46
  | '101111': IO47
  | '110000': IO48
  | '110001': IO49
  | '110010': IO50
  | '110011': IO51
  | '110100': IO52
  | '110101': IO53
  | '110110': IO54
  | '110111': IO55
  | '111000': RAMPD
  | '111001': RAMPX
  | '111010': RAMPY
  | '111011': RAMPZ
  | '111100': EIND
  | '111101': SPL
  | '111110': SPH
  | '111111': SREG
 end


val rX = REGHL {regh=R27,regl=R26}
val rY = REGHL {regh=R29,regl=R28}
val rZ = REGHL {regh=R31,regl=R30}

val rampz-z = REGIHL {regi=RAMPZ,reghl=case rZ of REGHL x: x end}

val /X = return rX
val /Y = return rY
val /Z = return rZ

val /RAMPZ-Z = return rampz-z

val r0 = return (REG R0)

val //X se = do
 /X <- /X;
 return (OPSE {op=(/X),se=se})
end
val //Y se = do
 /Y <- /Y;
 return (OPSE {op=(/Y),se=se})
end
val //Z se = do
 /Z <- /Z;
 return (OPSE {op=(/Z),se=se})
end
val //RAMPZ-Z se = do
 /RAMPZ-Z <- /RAMPZ-Z;
 return (OPSE {op=(/RAMPZ-Z),se=se})
end

val ///X imm = do
 /X <- /X;
 imm <- imm;
 return (OPDI {op=(/X),imm=imm})
end
val ///Y imm = do
 /Y <- /Y;
 imm <- imm;
 return (OPDI {op=(/Y),imm=imm})
end
val ///Z imm = do
 /Z <- /Z;
 imm <- imm;
 return (OPDI {op=(/Z),imm=imm})
end

val rs5 = do
 rs <- query $rs;
 update @{rs=''};
 return (REG (register-from-bits rs))
end

val rt5 = do
 rt <- query $rt;
 update @{rt=''};
 return (REG (register-from-bits rt))
end

val rd5 = do
 rd <- query $rd;
 update @{rd=''};
 return (REG (register-from-bits rd))
end
 
val sizeof-next = do
  index <- idxget;
  /;
  new <- idxget;
  seek index;
  return (IMM (IMMi (/z (new - index) 2)))
end

val ternop cons first second third = do
 first <- first;
 second <- second;
 third <- third;
 return (cons {first=first, second=second, third=third})
end

val binop cons first second = do
 first <- first;
 second <- second;
 return (cons {first=first, second=second})
end

val unop cons operand = do
 operand <- operand;
 return (cons {operand=operand})
end

val nullop cons = do
 return cons
end

