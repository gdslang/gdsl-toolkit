granularity = 8
export = decode

val decode = do
 update@{rd='',rr='',ck='',cs=''};
 /
end

datatype imm =
   IMM3 of 3
 | IMM6 of 6
 | IMM8 of 8

datatype operand =
   REG of register
 | REGHL of {regh:register,regl:register}
 | IMM of imm

type binop = {first:operand,second:operand}
type unop = {operand:operand}

datatype instruction =
   ADC of binop
 | ADD of binop
 | AND of binop
 | ANDI of binop
 | ASR of unop
 | BCLR of unop

datatype register =
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

val X = REGHL {regh=REG R27,regl=REG R26}
val Y = REGHL {regh=REG R29,regl=REG R28}
val Z = REGHL {regh=REG R31,regl=REG R30}

val d ['bit:1'] = do
 rd <- (query $rd) ^ bit;
 update@{rd=rd}
end

val r ['bit:1'] = do
 rr <- (query $rr) ^ bit;
 update@{rr=rr}
end

val k ['bit:1'] = do
 ck <- (query $ck) ^ bit;
 update@{ck=ck}
end

val s ['bit:1'] = do
 cs <- (query $cs) ^ bit;
 update@{cs=cs}
end

val rd5 = do
 rd <- query $rd;
 return (REG (register-from-bits rd))
end

val rd4 = do
 rd <- query $rd;
 return (REG (register-from-bits ('1' ^ rd)))
end
 
val rr5 = do
 rr <- query $rd;
 return (REG (register-from-bits rr))
end
 
val rr4 = do
 rr <- query $rd;
 return (REG (register-from-bits ('1' ^ rr)))
end

val ck6 = do
 ck <- query $ck;
 return (IMM (IMM6 ck))
end

val ck8 = do
 ck <- query $ck;
 return (IMM (IMM8 ck))
end

val cs3 = do
 cs <- query $cs;
 return (IMM (IMM3 cs))
end

val rd5h-rd5l = do
 rd <- query $rd;
 rd-regl <- register-from-bits ('11' ^ rd ^ '0');
 rd-regh <- register-from-bits ('11' ^ rd ^ '1');
 return (REGHL {regh=rd-regh,regl=rd-regl});
end

val binop cons first second = do
 first <- first;
 second <- second;
 return (cons {first=first, second=second});
end

val unop cons operand = do
 operand <- operand;
 return (cons {operand=operand});
end

### ADC
###  - Add with Carry
val / ['000111' r d d d d d r r r r] = binop ADC rd5 rr5

### ADD
###  - Add without Carry
val / ['000011' r d d d d d r r r r] = binop ADD rd5 rr5

### ADIW
###  - Add Immediate to Word
val / ['10010110' k k d d k k k k] = binop ADIW rd5h-rd5l ck6

### AND
###  - Logical AND
val / ['001000' r d d d d d r r r r] = binop AND rd5 rr5

### ANDI
###  - Logical AND with Immediate
val / ['0111' k k k k d d d d k k k k]= binop ANDI rd4 ck8

### ASR
###  - Arithmetic Shift Right
val / ['1001010' d d d d d '0101']= unop ASR rd5

### BCLR
###  - Bit Clear in SREG
val / ['100101001' s s s '1000']= unop BCLR cs3
