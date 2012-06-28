granularity = 8
export = decode

val decode = do
 update@{rd='',rr='',ck='',cs='',cb='',io=''};
 /
end

datatype imm =
   IMM3 of 3
 | IMM4 of 4
 | IMM6 of 6
 | IMM7 of 7
 | IMM8 of 8
 | IMM22 of 22

datatype operand =
   REG of register
 | REGHL of {regh:register,regl:register}
 | IOREG of io-register
 | IMM of imm

type binop = {first:operand,second:operand}
type unop = {operand:operand}
type nullop = {}

type instruction =
   ADC of binop
 | ADD of binop
 | AND of binop
 | ANDI of binop
 | ASR of unop
 | BCLR of unop
 | BLD of binop
 | BRBC of binop
 | BRBS of binop
 | BREAK of nullop
 | BSET of unop
 | CALL of unop
 | CBI of binop
 | CLC of nullop
 | CLH of nullop
 | CLI of nullop
 | CLN of nullop
 | CLS of nullop
 | CLT of nullop
 | CLV of nullop
 | CLZ of nullop
 | COM of unop
 | CP of binop
 | CPC of binop
 | CPI of binop
 | CPSE of binop
 | DEC of unop
 | DES of unop
 | EICALL of nullop
 | EIJMP of nullop
 | ELPM of nullop

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

datatype io-register =
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

val io-register-from-bits bits =
 case bits of
    '00000': IO0
  | '00001': IO1
  | '00010': IO2
  | '00011': IO3
  | '00100': IO4
  | '00101': IO5
  | '00110': IO6
  | '00111': IO7
  | '01000': IO8
  | '01001': IO9
  | '01010': IO10
  | '01011': IO11
  | '01100': IO12
  | '01101': IO13
  | '01110': IO14
  | '01111': IO15
  | '10000': IO16
  | '10001': IO17
  | '10010': IO18
  | '10011': IO19
  | '10100': IO20
  | '10101': IO21
  | '10110': IO22
  | '10111': IO23
  | '11000': IO24
  | '11001': IO25
  | '11010': IO26
  | '11011': IO27
  | '11100': IO28
  | '11101': IO29
  | '11110': IO30
  | '11111': IO31
 end

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

val a ['bit:1'] = do
 io <- (query $io) ^ bit;
 update@{io=io}
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

val ck4 = do
 ck <- query $ck;
 return (IMM (IMM4 ck))
end

val ck6 = do
 ck <- query $ck;
 return (IMM (IMM6 ck))
end

val ck7 = do
 ck <- query $ck;
 return (IMM (IMM7 ck))
end

val ck8 = do
 ck <- query $ck;
 return (IMM (IMM8 ck))
end

val ck22 = do
 ck <- query $ck;
 return (IMM (IMM22 ck))
end

val cs3 = do
 cs <- query $cs;
 return (IMM (IMM3 cs))
end

val cb3 = do
 cb <- query $cb;
 return (IMM (IMM3 cb))
end

val io = do
 io <- query $io;
 return (IOREG (io-register-from-bits io))
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

val nullop cons = do
 return (cons {});
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
val / ['0111' k k k k d d d d k k k k] = binop ANDI rd4 ck8

### ASR
###  - Arithmetic Shift Right
val / ['1001010' d d d d d '0101'] = unop ASR rd5

### BCLR
###  - Bit Clear in SREG
val / ['100101001' s s s '1000'] = unop BCLR cs3

### BLD
###  - Bit Load from the T Flag in SREG to a Bit in Register
val / ['1111100' d d d d d '0' b b b] = binop BLD rd5 cb3

### BRBC
###  - Branch if Bit in SREG is Cleared
val / ['111101' k k k k k k k s s s] = binop BRBC cs3 ck7

### BRBS
###  - Branch if Bit in SREG is Set
val / ['111100' k k k k k k k s s s] = binop BRBS cs3 ck7

### BREAK
###  - Break
val / ['1001010110011000'] = nullop BREAK

### BSET
###  - Bit Set in SREG
val / ['100101000' s s s '1000'] = unop BSET cs3

### BST
###  - Bit Store from Bit in Register to T Flag in SREG
val / ['1111101' d d d d d '0' b b b] = binop BST rd5 cb3

### CALL
###  - Long Call to a Subroutine
val / ['1001010' k k k k k '111' k k k k k k k k k k k k k k k k k] = unop CALL ck22

### CBI
###  - Clear Bit in I/O Register
val / ['10011000' a a a a a b b b] = binop CBI io cb3

### CLC
###  - Clear Carry Flag
val / ['1001010010001000'] = nullop CLC

### CLH
###  - Clear Half Carry Flag
val / ['1001010011011000'] = nullop CLH

### CLI
###  - Clear Global Interrupt Flag
val / ['1001010011111000'] = nullop CLI

### CLN
###  - Clear Negative Flag
val / ['1001010010101000'] = nullop CLN

### CLS
###  - Clear Signed Flag
val / ['1001010011001000'] = nullop CLS

### CLT
###  - Clear T Flag
val / ['1001010011101000'] = nullop CLT

### CLV
###  - Clear Overflow Flag
val / ['1001010010111000'] = nullop CLV

### CLZ
###  - Clear Zero Flag
val / ['1001010010011000'] = nullop CLZ

### COM
###  - One’s Complement
val / ['1001010' d d d d d '0000'] = unop COM rd5

### CP
###  - Compare
val / ['000101' r d d d d d r r r r] = binop CP rd5 rr5

### CPC
###  - Compare with Carry
val / ['000001' r d d d d d r r r r] = binop CPC rd5 rr5

### CPI
###  - Compare with Immediate
val / ['0011' k k k k d d d d k k k k] = binop CPI rd4 ck8

### CPSE
###  - Compare Skip if Equal
val / ['000100' r d d d d d r r r r] = binop CPSE rd5 rr5

### DEC
###  - Decrement
val / ['1001010' d d d d d '1010'] = unop DEC rd5

### DES
###  - Data Encryption Standard
val / ['10010100' k k k k '1011'] = unop DES ck4

### EICALL
###  - Extended Indirect Call to Subroutine
val / ['1001010100011001'] = nullop EICALL

### EIJMP
###  - Extended Indirect Jump
val / ['1001010000011001'] = nullop EIJMP

### ELPM
###  - Extended Load Program Memory
val / ['1001010111011000'] = nullop ELPM
# ...
