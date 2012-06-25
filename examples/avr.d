granularity = 8
export = decode

val decode = do
 update@{rd='',rr='',ck=''};
 /
end

datatype operand =
   REG of register
 | REGHL of {regh:register,regl:register}
 | IMM6 of 6
 | IMM8 of 8

type binop = {first:operand,second:operand}

datatype instruction =
   ADC of binop
 | ADD of binop
 | AND of binop
 | ANDI of binop

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
    '00000': REG R0
  | '00001': REG R1
  | '00010': REG R2
  | '00011': REG R3
  | '00100': REG R4
  | '00101': REG R5
  | '00110': REG R6
  | '00111': REG R7
  | '01000': REG R8
  | '01001': REG R9
  | '01010': REG R10
  | '01011': REG R11
  | '01100': REG R12
  | '01101': REG R13
  | '01110': REG R14
  | '01111': REG R15
  | '10000': REG R16
  | '10001': REG R17
  | '10010': REG R18
  | '10011': REG R19
  | '10100': REG R20
  | '10101': REG R21
  | '10110': REG R22
  | '10111': REG R23
  | '11000': REG R24
  | '11001': REG R25
  | '11010': REG R26
  | '11011': REG R27
  | '11100': REG R28
  | '11101': REG R29
  | '11110': REG R30
  | '11111': REG R31

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

val rd5 = do
 rd <- query $rd;
 return (register-from-bits rd)
end

val rd4 = do
 rd <- query $rd;
 return (register-from-bits ('1' ^ rd))
end
 
val rr5 = do
 rr <- query $rd;
 return (register-from-bits rr)
end
 
val rr4 = do
 rr <- query $rd;
 return (register-from-bits ('1' ^ rr))
end

val ck6 = do
 ck <- query $ck;
 return (IMM6 ck)
end

val ck8 = do
 ck <- query $ck;
 return (IMM8 ck)
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
