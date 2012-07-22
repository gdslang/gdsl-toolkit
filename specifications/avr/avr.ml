granularity = 16
export = decode

val d ['bit:1'] = do
 rd <- query $rd;
 update@{rd=rd ^ bit}
end

val r ['bit:1'] = do
 rr <- query $rr;
 update@{rr=rr ^ bit}
end

val k ['bit:1'] = do
 ck <- query $ck;
 update@{ck=ck ^ bit}
end

val s ['bit:1'] = do
 cs <- query $cs;
 update@{cs=cs ^ bit}
end

val a ['bit:1'] = do
 io <- query $io;
 update@{io=io ^ bit}
end

val b ['bit:1'] = do
 cb <- query $cb;
 update@{cb=cb ^ bit}
end

val q ['bit:1'] = do
 dq <- query $dq;
 update@{dq=dq ^ bit}
end

### ADC
###  - Add with Carry
val / ['000111 r d d d d d r r r r'] = binop ADC rd5 rr5

### ADD
###  - Add without Carry
val / ['000011 r d d d d d r r r r'] = binop ADD rd5 rr5

### ADIW
###  - Add Immediate to Word
val / ['10010110 k k d d k k k k'] = binop ADIW rd2h-rd2l ck6

### AND
###  - Logical AND
val / ['001000 r d d d d d r r r r'] = binop AND rd5 rr5

### ANDI
###  - Logical AND with Immediate
val / ['0111 k k k k d d d d k k k k'] = binop ANDI rd4 ck8

### ASR
###  - Arithmetic Shift Right
val / ['1001010 d d d d d 0101'] = unop ASR rd5

### BCLR
###  - Bit Clear in SREG
### => see CLC,CLZ,...
#val / ['100101001 s s s 1000'] = unop BCLR cs3

### BLD
###  - Bit Load from the T Flag in SREG to a Bit in Register
val / ['1111100 d d d d d 0 b b b'] = binop BLD rd5 cb3

### BRBC
###  - Branch if Bit in SREG is Cleared
###  => see below
#val / ['111101 k k k k k k k s s s'] = binop BRBC cs3 ck7

### BRBS
###  - Branch if Bit in SREG is Set
###  => see below
#val / ['111100 k k k k k k k s s s'] = binop BRBS cs3 ck7

### BRCC
###  - Branch if Carry Cleared
###  => see BRSH
#val / ['111101 k k k k k k k 000'] = unop BRCC ck7

### BRCS
###  - Branch if Carry Set
###  => see BRLO
#val / ['111100 k k k k k k k 000'] = unop BRCS ck7

### BREAK
###  - Break
val / ['1001010110011000'] = nullop BREAK

### BREQ
###  - Branch if Equal
val / ['111100 k k k k k k k 001'] = unop BREQ ck7

### BRGE
###  - Branch if Greater or Equal (Signed)
val / ['111101 k k k k k k k 100'] = unop BRGE ck7

### BRHC
###  - Branch if Half Carry Flag is Cleared
val / ['111101 k k k k k k k 101'] = unop BRHC ck7

### BRHS
###  - Branch if Half Carry Flag is Set
val / ['111100 k k k k k k k 101'] = unop BRHS ck7

### BRID
###  - Branch if Global Interrupt is Disabled
val / ['111101 k k k k k k k 111'] = unop BRID ck7

### BRIE
###  - Branch if Global Interrupt is Enabled
val / ['111100 k k k k k k k 111'] = unop BRIE ck7

### BRLO
###  - Branch if Lower (Unsigned)
val / ['111100 k k k k k k k 000'] = unop BRLO ck7

### BRLT
###  - Branch if Less Than (Signed)
val / ['111100 k k k k k k k 100'] = unop BRLT ck7

### BRMI
###  - Branch if Minus
val / ['111100 k k k k k k k 010'] = unop BRMI ck7

### BRNE
###  - Branch if Not Equal
val / ['111101 k k k k k k k 001'] = unop BRNE ck7

### BRPL
###  - Branch if Plus
val / ['111101 k k k k k k k 010'] = unop BRPL ck7

### BRSH
###  - Branch if Same or Higher (Unsigned)
val / ['111101 k k k k k k k 000'] = unop BRSH ck7

### BRTC
###  - Branch if the T Flag is Cleared
val / ['111101 k k k k k k k 110'] = unop BRTC ck7

### BRTS
###  - Branch if the T Flag is Set
val / ['111100 k k k k k k k 110'] = unop BRTS ck7

### BRVC
###  - Branch if Overflow Cleared
val / ['111101 k k k k k k k 011'] = unop BRVC ck7

### BRVS
###  - Branch if Overflow Set
val / ['111100 k k k k k k k 011'] = unop BRVS ck7

### BSET
###  - Bit Set in SREG
### => see SEC,SEZ,...
#val / ['100101000 s s s 1000'] = unop BSET cs3

### BST
###  - Bit Store from Bit in Register to T Flag in SREG
val / ['1111101 d d d d d 0 b b b'] = binop BST rd5 cb3

### CALL
###  - Long Call to a Subroutine
val / ['1001010 k k k k k 111 k' 'k k k k k k k k k k k k k k k k'] = unop CALL ck22

### CBI
###  - Clear Bit in I/O Register
val / ['10011000 a a a a a b b b'] = binop CBI io5 cb3

### CBR
###  - Clear Bit in I/O Register
###  => see ANDI with K complemented

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

### CLR
###  - Clear Negative Flag
###  => see EOR Rd, Rd

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
val / ['1001010 d d d d d 0000'] = unop COM rd5

### CP
###  - Compare
val / ['000101 r d d d d d r r r r'] = binop CP rd5 rr5

### CPC
###  - Compare with Carry
val / ['000001 r d d d d d r r r r'] = binop CPC rd5 rr5

### CPI
###  - Compare with Immediate
val / ['0011 k k k k d d d d k k k k'] = binop CPI rd4 ck8

### CPSE
###  - Compare Skip if Equal
val / ['000100 r d d d d d r r r r'] = binop CPSE rd5 rr5

### DEC
###  - Decrement
val / ['1001010 d d d d d 1010'] = unop DEC rd5

### DES
###  - Data Encryption Standard
val / ['10010100 k k k k 1011'] = unop DES ck4

### EICALL
###  - Extended Indirect Call to Subroutine
val / ['1001010100011001'] = nullop EICALL

### EIJMP
###  - Extended Indirect Jump
val / ['1001010000011001'] = nullop EIJMP

### ELPM
###  - Extended Load Program Memory
val / ['1001010111011000'] = binop ELPM r0 (//Z NONE)
val / ['1001000 d d d d d 0110'] = binop ELPM rd5 (//Z NONE)
val / ['1001000 d d d d d 0111'] = binop ELPM rd5 (//Z INCR)

### EOR
###  - Exclusive OR
val / ['001001 r d d d d d r r r r'] = binop EOR rd5 rr5

### FMUL
###  - Fractional Multiply Unsigned
val / ['000000110 d d d 1 r r r'] = binop FMUL rd3 rr3

### FMULS
###  - Fractional Multiply Signed
val / ['000000111 d d d 0 r r r'] = binop FMULS rd3 rr3

### FMULSU
###  - Fractional Multiply Signed with Unsigned
val / ['000000111 d d d 1 r r r'] = binop FMULSU rd3 rr3

### ICALL
###  - Indirect Call to Subroutine
val / ['1001010100001001'] = nullop ICALL

### IJMP
###  - Indirect Jump
val / ['1001010000001001'] = nullop IJMP

### IN
###  - Load an I/O Location to Register
val / ['10110 a a d d d d d a a a a'] = binop IN rd5 io6

### INC
###  - Increment
val / ['1001010 d d d d d 0011'] = unop INC rd5

### JMP
###  - Jump
val / ['1001 010 k k k k k 110 k' 'k k k k k k k k k k k k k k k k'] = unop JMP ck22

### LAC
###  - Load And Clear
val / ['1001001 d d d d d 0110'] = binop LAC /Z rd5

### LAS
###  - Load And Set
val / ['1001001 d d d d d 0101'] = binop LAS /Z rd5

### LAT
###  - Load And Toggle
val / ['1001001 d d d d d 0111'] = binop LAT /Z rd5

### LD
###  - Load Indirect from Data Space to Register using Index X
val / ['1001000 d d d d d 1100'] = binop LD rd5 (//X NONE)
val / ['1001000 d d d d d 1101'] = binop LD rd5 (//X INCR)
val / ['1001000 d d d d d 1110'] = binop LD rd5 (//X DECR)

### LD
###  - Load Indirect from Data Space to Register using Index Y
#val / ['1000000 d d d d d 1000'] = binop LD rd5 (//Y NONE)
val / ['1001000 d d d d d 1001'] = binop LD rd5 (//Y INCR)
val / ['1001000 d d d d d 1010'] = binop LD rd5 (//Y DECR)
val / ['10 q 0 q q 0 d d d d d 1 q q q '] = binop LD rd5 (///Y dq6)

### LD
###  - Load Indirect from Data Space to Register using Index Z
#val / ['1000000 d d d d d 0000'] = binop LD rd5 (//Z NONE)
val / ['1001000 d d d d d 0001'] = binop LD rd5 (//Z INCR)
val / ['1001000 d d d d d 0010'] = binop LD rd5 (//Z DECR)
val / ['10 q 0 q q 0 d d d d d 0 q q q'] = binop LD rd5 (///Z dq6)

### LDI
###  - Load Immediate
val / ['1110 k k k k d d d d k k k k'] = binop LDI rd4 ck8

### LDS
###  - Load Direct from Data Space
val / ['1001000 d d d d d 0000' 'k k k k k k k k k k k k k k k k'] = binop LDS rd5 ck16
#val / ['10100 k k k d d d d k k k k'] = binop LDS rd4 ck7

### LPM
###  - Load Program Memory
val / ['1001010111001000'] = binop LPM r0 (//Z NONE)
val / ['1001000 d d d d d 0100'] = binop LPM rd5 (//Z NONE)
val / ['1001000 d d d d d 0101'] = binop LPM rd5 (//Z INCR)

### LSL
###  - Logical Shift Left
###  => see ADD Rd, Rd

### LSR
###  - Logical Shift Right
val / ['1001010 d d d d d 0110'] = unop LSR rd5

### MOV
###  - Copy Register
val / ['001011 r d d d d d r r r r'] = binop MOV rd5 rr5

### MOVW
###  - Copy Register Word
val / ['00000001 d d d d r r r r'] = binop MOVW rd4h-rd4l rr4h-rr4l

### MUL
###  - Multiply Unsigned
val / ['100111 r d d d d d r r r r'] = binop MUL rd5 rr5

### MULS
###  - Multiply Signed
val / ['00000010 d d d d r r r r'] = binop MULS rd4 rr4

### MULSU
###  - MULSU – Multiply Signed with Unsigned
val / ['000000110 d d d 0 r r r'] = binop MULSU rd3 rr3

### NEG
###  - Two’s Complement
val / ['1001010 d d d d d 0001'] = unop NEG rd5

### NOP
###  - No Operation
val / ['0000000000000000'] = nullop NOP

### OR
###  - Logical OR
val / ['001010 r d d d d d r r r r'] = binop OR rd5 rr5

### ORI
###  - Logical OR with Immediate
val / ['0110 k k k k d d d d k k k k'] = binop ORI rd4 ck8

### OUT
###  - Store Register to I/O Location
val / ['10111 a a r r r r r a a a a'] = binop OUT io6 rr5

### POP
###  - Pop Register from Stack
val / ['1001000 d d d d d 1111'] = unop POP rd5

### PUSH
###  - Push Register on Stack
val / ['1001001 r r r r r 1111'] = unop PUSH rr5

### RCALL
###  - Relative Call to Subroutine
val / ['1101 k k k k k k k k k k k k'] = unop RCALL ck12

### RET
###  - Return from Subroutine
val / ['1001010100001000'] = nullop RET

### RETI
###  - Return from Interrupt
val / ['1001010100011000'] = nullop RETI

### RJMP
###  - Relative Jump
val / ['1100 k k k k k k k k k k k k'] = unop RJMP ck12

### ROL
###  - Rotate Left trough Carry
###  => see ADC Rd, Rd

### ROR
###  - Rotate Right through Carry
val / ['1001010 d d d d d 0111'] = unop ROR rd5

### SBC
###  - Subtract with Carry
val / ['000010 r d d d d d r r r r'] = binop SBC rd5 rr5

### SBCI
###  - Subtract Immediate with Carry
val / ['0100 k k k k d d d d k k k k'] = binop SBCI rd4 ck8

### SBI
###  - Set Bit in I/O Register
val / ['10011010 a a a a a b b b'] = binop SBI io5 cb3

### SBIC
###  - Skip if Bit in I/O Register is Cleared
val / ['10011001 a a a a a b b b'] = binop SBIC io5 cb3

### SBIS
###  - Skip if Bit in I/O Register is Set
val / ['10011011 a a a a a b b b'] = binop SBIS io5 cb3

### SBIW
###  - Subtract Immediate from Word
val / ['10010111 k k d d k k k k'] = binop SBIW rd2 ck6

### SBR
###  - Set Bits in Register
### => see ORI
#val / ['0110 k k k k d d d d k k k k'] = binop SBR rd4 ck8

### SBRC
###  - Skip if Bit in Register is Cleared
val / ['1111110 r r r r r 0 b b b'] = binop SBRC rr5 cb3

### SBRS
###  - Skip if Bit in Register is Set
val / ['1111111 r r r r r 0 b b b'] = binop SBRS rr5 cb3

### SEC
###  - Set Carry Flag
### <=> BSET 0
val / ['1001010000001000'] = nullop SEC

### SEH
###  - Set Half Carry Flag
val / ['1001010001011000'] = nullop SEH

### SEI
###  - Set Global Interrupt Flag
val / ['1001010001111000'] = nullop SEI

### SEN
###  - Set Negative Flag
val / ['1001010000101000'] = nullop SEN

### SER
###  - Set all Bits in Register
### => see LDS Rd,K
#val / ['11101111 d d d d 1111'] = unop SER rd4

### SES
###  - Set Signed Flag
val / ['1001010001001000'] = nullop SES

### SET
###  - Set T Flag
val / ['1001010001101000'] = nullop SET

### SEV
###  - Set Overflow Flag
val / ['1001010000111000'] = nullop SEV

### SEZ
###  - Set Zero Flag
val / ['1001010000011000'] = nullop SEZ

### SLEEP
val / ['1001010110001000'] = nullop SLEEP

### SPM
###  - Store Program Memory
val / ['1001010111101000'] = unop SPM (//Z INCR)
val / ['1001010111111000'] = unop SPM (//Z INCR)

### ST
###  - Store Indirect From Register to Data Space using Index X
val / ['1001001 r r r r r 1100'] = binop ST (//X NONE) rr5
val / ['1001001 r r r r r 1101'] = binop ST (//X INCR) rr5
val / ['1001001 r r r r r 1110'] = binop ST (//X DECR) rr5

### ST
###  - Store Indirect From Register to Data Space using Index Y
#val / ['1000001 r r r r r 1000'] = binop ST (//Y NONE) rr5
val / ['1001001 r r r r r 1001'] = binop ST (//Y INCR) rr5
val / ['1001001 r r r r r 1010'] = binop ST (//Y DECR) rr5
val / ['10 q 0 q q 1 r r r r r 1 q q q '] = binop ST (///Y dq6) rr5

### ST
###  - Store Indirect From Register to Data Space using Index Z
#val / ['1000001 r r r r r 0000'] = binop ST (//Z NONE) rr5
val / ['1001001 r r r r r 0001'] = binop ST (//Z INCR) rr5
val / ['1001001 r r r r r 0010'] = binop ST (//Z DECR) rr5
val / ['10 q 0 q q 1 r r r r r 0 q q q '] = binop ST (///Z dq6) rr5

### STS
###  - Store Direct to Data Space
val / ['1001001 r r r r r 0000' 'k k k k k k k k k k k k k k k k'] = binop STS ck16 rr5
#val / ['10101 k k k r r r r k k k k'] = binop STS ck7 rr4

### SUB
###  - Subtract without Carry
val / ['000110 r d d d d d r r r r'] = binop SUB rd5 rr5

### SUBI
###  - Subtract Immediate
val / ['0101 k k k k d d d d k k k k'] = binop SUB rd4 ck8

### SWAP
###  - Swap Nibbles
val / ['1001010 d d d d d 0010'] = unop SWAP rd5

### TST
###  - Test for Zero or Minus
###  => see AND Rd, Rd

### WDR
###  - Watchdog Reset
val / ['1001010110101000'] = nullop WDR

### XCH
###  - Exchange
val / ['1001001 d d d d d 0100'] = binop XCH /Z rd5

val decode =
  do update@{rd='',rr='',ck='',cs='',cb='',io='',dq=''};
     /
  end


type side-effect =
   NONE
 | INCR
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

type operand =
   REG of register
 | REGHL of {regh:register,regl:register}
 | IOREG of io-register
 | IMM of imm
 | OPSE of {op:operand,se:side-effect}
 | OPDI of {op:operand,imm:imm}

type binop = {first:operand,second:operand}
type unop = {operand:operand}

type instruction =
   ADC of binop
 | ADD of binop
 | ADIW of binop
 | AND of binop
 | ANDI of binop
 | ASR of unop
 | BCLR of unop
 | BLD of binop
 | BRBC of binop
 | BRBS of binop
 | BRCC of unop
 | BRCS of unop
 | BREAK
 | BREQ of unop
 | BRGE of unop
 | BRHC of unop
 | BRHS of unop
 | BRID of unop
 | BRIE of unop
 | BRLO of unop
 | BRLT of unop
 | BRMI of unop
 | BRNE of unop
 | BRPL of unop
 | BRSH of unop
 | BRTC of unop
 | BRTS of unop
 | BRVC of unop
 | BRVS of unop
 | BSET of unop
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
 | CPSE of binop
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
 | SBIC of binop
 | SBIS of binop
 | SBIW of binop
 | SBR of binop
 | SBRC of binop
 | SBRS of binop
 | SEC
 | SEH
 | SEI
 | SEN
 | SER of unop
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

type io-register =
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
 | IO56
 | IO57
 | IO58
 | IO59
 | IO60
 | IO61
 | IO62
 | IO63


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
  | '111000': IO56
  | '111001': IO57
  | '111010': IO58
  | '111011': IO59
  | '111100': IO60
  | '111101': IO61
  | '111110': IO62
  | '111111': IO63
 end

val /X = return (REGHL {regh=R27,regl=R26})
val /Y = return (REGHL {regh=R29,regl=R28})
val /Z = return (REGHL {regh=R31,regl=R30})

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


val rd5 = do
 rd <- query $rd;
 update @{rd=''};
 return (REG (register-from-bits rd))
end

val rd4 = do
 rd <- query $rd;
 update @{rd=''};
 return (REG (register-from-bits ('1' ^ rd)))
end

val rd3 = do
 rd <- query $rd;
 update @{rd=''};
 return (REG (register-from-bits ('10' ^ rd)))
end

val rd2 = do
 rd <- query $rd;
 update @{rd=''};
 return (REG (register-from-bits ('11' ^ rd ^ '0')))
end
 
val rr5 = do
 rr <- query $rr;
 update @{rr=''};
 return (REG (register-from-bits rr))
end
 
val rr4 = do
 rr <- query $rr;
 update @{rr=''};
 return (REG (register-from-bits ('1' ^ rr)))
end
 
val rr3 = do
 rr <- query $rr;
 update @{rr=''};
 return (REG (register-from-bits ('10' ^ rr)))
end

val ck4 = do
 ck <- query $ck;
 update @{ck=''};
 return (IMM (IMM4 ck))
end

val ck6 = do
 ck <- query $ck;
 update @{ck=''};
 return (IMM (IMM6 ck))
end

val ck7 = do
 ck <- query $ck;
 update @{ck=''};
 return (IMM (IMM7 ck))
end

val ck8 = do
 ck <- query $ck;
 update @{ck=''};
 return (IMM (IMM8 ck))
end

val ck12 = do
 ck <- query $ck;
 update @{ck=''};
 return (IMM (IMM12 ck))
end

val ck16 = do
 ck <- query $ck;
 update @{ck=''};
 return (IMM (IMM16 ck))
end

val ck22 = do
 ck <- query $ck;
 update @{ck=''};
 return (IMM (IMM22 ck))
end

val cs3 = do
 cs <- query $cs;
 update @{cs=''};
 return (IMM (IMM3 cs))
end

val cb3 = do
 cb <- query $cb;
 update @{cb=''};
 return (IMM (IMM3 cb))
end

val io5 = do
 io <- query $io;
 update @{io=''};
 return (IOREG (io-register-from-bits ('0' ^ io)))
end

val io6 = do
 io <- query $io;
 update @{io=''};
 return (IOREG (io-register-from-bits io))
end

val dq6 = do
 dq <- query $dq;
 update @{dq=''};
 return (IMM6 dq)
end

val rd2h-rd2l = do
 rd <- query $rd;
 rd-regl <- return (register-from-bits ('11' ^ rd ^ '0'));
 rd-regh <- return (register-from-bits ('11' ^ rd ^ '1'));
 update @{rd=''};
 return (REGHL {regh=rd-regh,regl=rd-regl})
end

val rd4h-rd4l = do
 rd <- query $rd;
 rd-regl <- return (register-from-bits (rd ^ '0'));
 rd-regh <- return (register-from-bits (rd ^ '1'));
 update @{rd=''};
 return (REGHL {regh=rd-regh,regl=rd-regl})
end

val rr4h-rr4l = do
 rr <- query $rr;
 rr-regl <- return (register-from-bits (rr ^ '0'));
 rr-regh <- return (register-from-bits (rr ^ '1'));
 update @{rr=''};
 return (REGHL {regh=rr-regh,regl=rr-regl})
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

