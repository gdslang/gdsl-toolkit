export config-default: decoder-configuration
export decode: (decoder-configuration) -> S insndata <{} => {}>
export decoder-config : configuration[vec=decoder-configuration]

type decoder-configuration = 0

val decoder-config = END
val config-default = ''

type insndata = {length:int, insn:instruction}

type imm =
   IMM5 of 5
 | IMM16 of 16
 | OFFSET9 of 9
 | OFFSET16 of 16
 | SEL of 3
 | IMPL of 16
 | CODE10 of 10
 | CODE19 of 19
 | CODE20 of 20
 | STYPE of 5
 | POSSIZE of 5
 | SIZE of 5
 | POS of 5
 | HINT of 5
 | INSTRINDEX of 26
 | COFUN of 25
 | CC of 3
 | COND of 4
 | OP of 5

type lvalue =
   GPR of register
 | FPR of register

type rvalue =
   LVALUE of lvalue
 | IMM of imm

type format = 
   S
 | D
 | W
 | L
 | PS

val right lvalue = do
  lvalue <- lvalue;
  return (LVALUE lvalue)
end


val pause? s = (s.rt == '00000') and (s.rd == '00000') and (s.sa == '00101')

###
# SLL not script handled yet
#val / ['000000 00000 /rt /rd /sa 000000']
# | pause? = ternop PAUSE rd (right rt) sa
# | otherwise = ternop SLL rd (right rt) sa
###

# -> sftl

val decode config = do
  update@{rs='',rt='00000',rd='00000',fr='',fs='',ft='',fd='',immediate='',offset='',sel='',impl='',code10='',code19='',code20='',stype='',msb='',msbd='',lsb='',sa='00000',instr_index='',cofun='',cc='',cond='',op='',hint='',fmt=''};
  idx-before <- idxget;
  insn <- /;
  idx-after <- idxget;
  return {length=(idx-after - idx-before), insn=insn}
end


### ABS-fmt
###  - Floating Point Absolute Value
val / ['010001 /fmt5sdps 00000 /fs /fd 000101'] = binop-fmt ABS-fmt fmt fd (right fs) 

### ADD
###  - Add Word
val / ['000000 /rs /rt /rd 00000 100000'] = ternop ADD rd (right rs) (right rt)
 
### ADD-fmt
###  - Floating Point Add
val / ['010001 /fmt5sdps /ft /fs /fd 000000'] = ternop-fmt ADD-fmt fmt fd (right ft) (right fs) 

### ADDI
###  - Add Immediate Word
val / ['001000 /rs /rt /immediate'] = ternop ADDI rt (right rs) immediate 

### ADDIU
###  - Add Immediate Unsigned Word
val / ['001001 /rs /rt /immediate'] = ternop ADDIU rt (right rs) immediate 

### ADDU
###  - Add Unsigned Word
val / ['000000 /rs /rt /rd 00000 100001'] = ternop ADDU rd (right rs) (right rt) 

### ALNV-PS
###  - Floating Point Align Variable
val / ['010011 /rs /ft /fs /fd 011110'] = quadop ALNV-PS fd (right rs) (right ft) (right fs) 

### AND
###  - And
val / ['000000 /rs /rt /rd 00000 100100'] = ternop AND rd (right rs) (right rt) 

### ANDI
###  - And Immediate
val / ['001100 /rs /rt /immediate'] = ternop ANDI rt (right rs) immediate 

### B
###  - Unconditional Branch
###  => see BEQ r0, r0, offset

### BAL
###  - Branch and Link
###  => see BGEZAL r0, offset

### BC1F
###  - Branch on FP False
val / ['010001 01000 /cc 0 0 /offset16'] = binop-src BC1F cc offset16 

### BC1FL
###  - Branch on FP False Likely
val / ['010001 01000 /cc 1 0 /offset16'] = binop-src BC1FL cc offset16 

### BC1T
###  - Branch on FP True
val / ['010001 01000 /cc 0 1 /offset16'] = binop-src BC1T cc offset16 

### BC1TL
###  - Branch on FP True Likely
val / ['010001 01000 /cc 1 1 /offset16'] = binop-src BC1TL cc offset16 

### BC2F
###  - Branch on COP2 False
val / ['010010 01000 /cc 0 0 /offset16'] = binop-src BC2F cc offset16 

### BC2FL
###  - Branch on COP2 False Likely
val / ['010010 01000 /cc 1 0 /offset16'] = binop-src BC2FL cc offset16 

### BC2T
###  - Branch on COP2 True
val / ['010010 01000 /cc 0 1 /offset16'] = binop-src BC2T cc offset16 

### BC2TL
###  - Branch on COP2 True Likely
val / ['010010 01000 /cc 1 1 /offset16'] = binop-src BC2TL cc offset16 

### BEQ
###  - Branch on Equal
val / ['000100 /rs /rt /offset16'] = ternop-src BEQ (right rs) (right rt) offset16 

### BEQL
###  - Branch on Equal Likely
val / ['010100 /rs /rt /offset16'] = ternop-src BEQL (right rs) (right rt) offset16 

### BGEZ
###  - Branch on Greater Than or Equal to Zero
val / ['000001 /rs 00001 /offset16'] = binop-src BGEZ (right rs) offset16 

### BGEZAL
###  - Branch on Greater Than or Equal to Zero and Link
val / ['000001 /rs 10001 /offset16'] = binop-src BGEZAL (right rs) offset16 

### BGEZALL
###  - Branch on Greater Than or Equal to Zero and Link Likely
val / ['000001 /rs 10011 /offset16'] = binop-src BGEZALL (right rs) offset16 

### BGEZL
###  - Branch on Greater Than or Equal to Zero Likely
val / ['000001 /rs 00011 /offset16'] = binop-src BGEZL (right rs) offset16 

### BGTZ
###  - Branch on Greater Than Zero
val / ['000111 /rs 00000 /offset16'] = binop-src BGTZ (right rs) offset16 

### BGTZL
###  - Branch on Greater Than Zero Likely
val / ['010111 /rs 00000 /offset16'] = binop-src BGTZL (right rs) offset16 

### BLEZ
###  - Branch on Less Than or Equal to Zero
val / ['000110 /rs 00000 /offset16'] = binop-src BLEZ (right rs) offset16 

### BLEZL
###  - Branch on Less Than or Equal to Zero Likely
val / ['010110 /rs 00000 /offset16'] = binop-src BLEZL (right rs) offset16 

### BLTZ
###  - Branch on Less Than Zero
val / ['000001 /rs 00000 /offset16'] = binop-src BLTZ (right rs) offset16 

### BLTZAL
###  - Branch on Less Than Zero And Link
val / ['000001 /rs 10000 /offset16'] = binop-src BLTZAL (right rs) offset16 

### BLTZALL
###  - Branch on Less Than Zero And Link Likely
val / ['000001 /rs 10010 /offset16'] = binop-src BLTZALL (right rs) offset16 

### BLTZL
###  - Branch on Less Than Zero Likely
val / ['000001 /rs 00010 /offset16'] = binop-src BLTZL (right rs) offset16 

### BNE
###  - Branch on Not Equal
val / ['000101 /rs /rt /offset16'] = ternop-src BNE (right rs) (right rt) offset16 

### BNEL
###  - Branch on Not Equal Likely
val / ['010101 /rs /rt /offset16'] = ternop-src BNEL (right rs) (right rt) offset16 

### BREAK
###  - Breakpoint
val / ['000000 /code20 001101'] = unop-src BREAK code20 

### C-cond-fmt
###  - Floating Point Compare
val / ['010001 /fmt5sdps /ft /fs /cc 0 0 11 /cond'] = quadop-fmt-src C-cond-fmt fmt (right ft) (right fs) cc cond 

### CACHE
###  - Perform Cache Operation
val / ['101111 /rs /op /offset16'] = ternop-src CACHE (right rs) op offset16 

### CACHEE
###  - Perform Cache Operation EVA
val / ['011111 /rs /op /offset9 0 011011'] = ternop-src CACHEE (right rs) op offset9 

### CEIL-L-fmt
###  - Fixed Point Ceiling Convert to Long Fixed Point
val / ['010001 /fmt5sd 00000 /fs /fd 001010'] = binop-fmt CEIL-L-fmt fmt fd (right fs) 

### CEIL-W-fmt
###  - Floating Point Ceiling Convert to Word Fixed Point
val / ['010001 /fmt5sd 00000 /fs /fd 001110'] = binop-fmt CEIL-W-fmt fmt fd (right fs) 

### CFC1
###  - Move Control Word From Floating Point
val / ['010001 00010 /rt /fs 00000000000'] = binop CFC1 rt (right fs) 

### CFC2
###  - Move Control Word From Coprocessor 2
val / ['010010 00010 /rt /impl'] = binop CFC2 rt impl 

### CLO
###  - Count Leading Ones in Word
val / ['011100 /rs /rt /rd 00000 100001'] = ternop CLO rd (right rs) (right rt) 

### CLZ
###  - Count Leading Zeros in Word
val / ['011100 /rs /rt /rd 00000 100000'] = ternop CLZ rd (right rs) (right rt) 

### COP2
###  - Coprocessor Operation to Coprocessor 2
val / ['010010 1 /cofun'] = unop-src COP2 cofun 

### CTC1
###  - Move Control Word to Floating Point
val / ['010001 00110 /rt /fs 00000000000'] = binop-src CTC1 fs/ctrl (right rt) 

### CTC2
###  - Move Control Word to Coprocessor 2
val / ['010010 00110 /rt /impl'] = binop-src CTC2 (right rt) impl 

### CVT-D-fmt
###  - Floating Point Convert To Double Floating Point
val / ['010001 /fmt5swl 00000 /fs /fd 100001'] = binop-fmt CVT-D-fmt fmt fd (right fs) 

### CVT-L-fmt
###  - Floating Point Convert to Long Fixed Point
val / ['010001 /fmt5sd 00000 /fs /fd 100101'] = binop-fmt CVT-L-fmt fmt fd (right fs) 

### CVT-PS-S
###  - Floating Point Convert Pair to Paired Single
val / ['010001 10000 /ft /fs /fd 100110'] = ternop CVT-PS-S fd (right ft) (right fs) 

### CVT-S-fmt
###  - Floating Point Convert to Single Floating Point
val / ['010001 /fmt5dwl 00000 /fs /fd 100000'] = binop-fmt CVT-S-fmt fmt fd (right fs) 

### CVT-S-PL
###  - Floating Point Convert Pair Lower to Single Floating Point
val / ['010001 10110 00000 /fs /fd 101000'] = binop CVT-S-PL fd (right fs)

### CVT-S-PU
###  - Floating Point Convert Pair Upper to Single Floating Point
val / ['010001 10110 00000 /fs /fd 100000'] = binop CVT-S-PU fd (right fs) 

### CVT-W-fmt
###  - Floating Point Convert to Word Fixed Point
val / ['010001 /fmt5sd 00000 /fs /fd 100100'] = binop-fmt CVT-W-fmt fmt fd (right fs) 

### DERET
###  - Debug Exception Return
val / ['010000 1 0000000000000000000 011111'] = nullop DERET 

### DI
###  - Disable Interrupts
val / ['010000 01011 /rt 01100 00000 0 00 000'] = unop DI rt 

### DIV
###  - Divide Word
val / ['000000 /rs /rt 0000000000 011010'] = binop-src DIV (right rs) (right rt) 

### DIV-fmt
###  - Floating Point Divide
val / ['010001 /fmt5sd /ft /fs /fd 000011'] = ternop-fmt DIV-fmt fmt fd (right ft) (right fs) 

### DIVU
###  - Divide Unsigned Word
val / ['000000 /rs /rt 0000000000 011011'] = binop-src DIVU (right rs) (right rt) 

### EHB
###  - Execution Hazard Barrier
###  => see SLL r0, r0, 3

### EI
###  - Enable Interrupts
val / ['010000 01011 /rt 01100 00000 1 00 000'] = unop EI rt 

### ERET
###  - Exception Return
val / ['010000 1 0000000000000000000 011000'] = nullop ERET 

### EXT
###  - Extract Bit Field
val / ['011111 /rs /rt /msbd /lsb 000000'] = quadop EXT rt (right rs) msbd lsb 

### FLOOR-L-fmt
###  - Floating Point Floor Convert to Long Fixed Point
val / ['010001 /fmt5sd 00000 /fs /fd 001011'] = binop-fmt FLOOR-L-fmt fmt fd (right fs) 

### FLOOR-W-fmt
###  - Floating Point Floor Convert to Word Fixed Point
val / ['010001 /fmt5sd 00000 /fs /fd 001111'] = binop-fmt FLOOR-W-fmt fmt fd (right fs) 

### INS
###  - Insert Bit Field
val / ['011111 /rs /rt /msb /lsb 000100'] = quadop INS rt (right rs) msb lsb 

### J
###  - Jump
val / ['000010 /instr_index'] = unop-src J instr_index 

### JAL
###  - Jump And Link
val / ['000011 /instr_index'] = unop-src JAL instr_index 

### JALR
###  - Jump And Link Register
val / ['000000 /rs 00000 /rd /hint5zero 001001'] = ternop JALR rd (right rs) hint5 

### JALR-HB
###  - Jump and Link Register with Hazard Barrier
val / ['000000 /rs 00000 /rd 1 /hint4zero 001001'] = ternop JALR-HB rd (right rs) hint5 

### JALX
###  - Jump and Link Exchange
val / ['011101 /instr_index'] = unop-src JALX instr_index 

### JR
###  - Jump Register
val / ['000000 /rs 0000000000 /hint5zero 001000'] = binop-src JR (right rs) hint5 

### JR-HB
###  - Jump Register with Hazard Barrier
val / ['000000 /rs 0000000000 1 /hint4zero 001000'] = binop-src JR-HB (right rs) hint5 

### LB
###  - Load Byte
val / ['100000 /rs /rt /offset16'] = ternop LB rt (right rs) offset16 

### LBE
###  - Load Byte EVA
val / ['011111 /rs /rt /offset9 0 101100'] = ternop LBE rt (right rs) offset9 

### LBU
###  - Load Byte Unsigned
val / ['100100 /rs /rt /offset16'] = ternop LBU rt (right rs) offset16 

### LBUE
###  - Load Byte Unsigned EVA
val / ['011111 /rs /rt /offset9 0 101000'] = ternop LBUE rt (right rs) offset9 

### LDC1
###  - Load Doubleword to Floating Point
val / ['110101 /rs /ft /offset16'] = ternop LDC1 ft (right rs) offset16 

### LDC2
###  - Load Doubleword to Coprocessor 2
val / ['110110 /rs /rt /offset16'] = ternop-src LDC2 (right rs) rt/imm offset16 

### LDXC1
###  - Load Doubleword Indexed to Floating Point
val / ['010011 /rs /rt 00000 /fd 000001'] = ternop LDXC1 fd (right rs) (right rt) 

### LH
###  - Load Halfword
val / ['100001 /rs /rt /offset16'] = ternop LH rt (right rs) offset16 

### LHE
###  - Load Halfword EVA
val / ['011111 /rs /rt /offset9 0 101101'] = ternop LHE rt (right rs) offset9 

### LHU
###  - Load Halfword Unsigned
val / ['100101 /rs /rt /offset16'] = ternop LHU rt (right rs) offset16 

### LHUE
###  - Load Halfword Unsigned EVA
val / ['011111 /rs /rt /offset9 0 101001'] = ternop LHUE rt (right rs) offset9 

### LL
###  - Load Linked Word
val / ['110000 /rs /rt /offset16'] = ternop LL rt (right rs) offset16 

### LLE
###  - Load Linked Word EVA
val / ['011111 /rs /rt /offset9 0 101110'] = ternop LLE rt (right rs) offset9 

### LUI
###  - Load Upper Immediate
val / ['001111 00000 /rt /immediate'] = binop LUI rt immediate 

### LUXC1
###  - Load Doubleword Indexed Unaligned to Floating Point
val / ['010011 /rs /rt 00000 /fd 000101'] = ternop LUXC1 fd (right rs) (right rt) 

### LW
###  - Load word
val / ['100011 /rs /rt /offset16'] = ternop LW rt (right rs) offset16 

### LWC1
###  - Load Word To Floating Point
val / ['110001 /rs /ft /offset16'] = ternop LWC1 ft (right rs) offset16 

### LWC2
###  - Load Word to Coprocessor 2
val / ['110010 /rs /rt /offset16'] = ternop-src LWC2 (right rs) rt/imm offset16 

### LWE
###  - Load Word EVA
val / ['011111 /rs /rt /offset9 0 101111'] = ternop LWE rt (right rs) offset9 

### LWL
###  - Load Word Left
val / ['100010 /rs /rt /offset16'] = ternop LWL rt (right rs) offset16 

### LWLE
###  - Load Word Left EVA
val / ['011111 /rs /rt /offset9 0 011001'] = ternop LWLE rt (right rs) offset9 

### LWR
###  - Load Word Right
val / ['100110 /rs /rt /offset16'] = ternop LWR rt (right rs) offset16 

### LWRE
###  - Load Word Right EVA
val / ['011111 /rs /rt /offset9 0 011010'] = ternop LWRE rt (right rs) offset9 

### LWXC1
###  - Load Word Indexed to Floating Point
val / ['010011 /rs /rt 00000 /fd 000000'] = ternop LWXC1 fd (right rs) (right rt) 

### MADD
###  - Multiply and Add Word to Hi,Lo
val / ['011100 /rs /rt 00000 00000 000000'] = binop-src MADD (right rs) (right rt) 

### MADD-fmt
###  - Floating Point Multiply Add
val / ['010011 /fr /ft /fs /fd 100 /fmt3sdps'] = quadop-fmt MADD-fmt fmt fd (right fr) (right ft) (right fs) 

### MADDU
###  - Multiply and Add Unsigned Word to Hi,Lo
val / ['011100 /rs /rt 00000 00000 000001'] = binop-src MADDU (right rs) (right rt) 

### MFC0
###  - Move from Coprocessor 0
val / ['010000 00000 /rt /rd 00000000 /sel'] = ternop MFC0 rt rd/imm sel 

### MFC1
###  - Move Word From Floating Point
val / ['010001 00000 /rt /fs 00000000000'] = binop MFC1 rt (right fs) 

### MFC2
###  - Move Word From Coprocessor 2
val / ['010010 00000 /rt /impl'] = binop MFC2 rt impl 

### MFHC1
###  - Move Word From High Half of Floating Point Register
val / ['010001 00011 /rt /fs 00000000000'] = binop MFHC1 rt (right fs) 

### MFHC2
###  - Move Word From High Half of Coprocessor 2 Register
val / ['010010 00011 /rt /impl'] = binop MFHC2 rt impl 

### MFHI
###  - Move From HI Register
val / ['000000 0000000000 /rd 00000 010000'] = unop MFHI rd 

### MFLO
###  - Move From LO Register
val / ['000000 0000000000 /rd 00000 010010'] = unop MFLO rd 

### MOV-fmt
###  - Floating Point Move
val / ['010001 /fmt5sdps 00000 /fs /fd 000110'] = binop-fmt MOV-fmt fmt fd (right fs) 

### MOVF
###  - Move Conditional on Floating Point False
val / ['000000 /rs /cc 0 0 /rd 00000 000001'] = ternop MOVF rd (right rs) cc 

### MOVF-fmt
###  - Floating Point Move Conditional on Floating Point False
val / ['010001 /fmt5sdps /cc 0 0 /fs /fd 010001'] = ternop-fmt MOVF-fmt fmt fd cc (right fs) 

### MOVN
###  - Move Conditional on Not Zero
val / ['000000 /rs /rt /rd 00000 001011'] = ternop MOVN rd (right rs) (right rt) 

### MOVN-fmt
###  - Floating Point Move Conditional on Not Zero
val / ['010001 /fmt5sdps /rt /fs /fd 010011'] = ternop-fmt MOVN-fmt fmt fd (right rt) (right fs) 

### MOVT
###  - Move Conditional on Floating Point True
val / ['000000 /rs /cc 0 1 /rd 00000 000001'] = ternop MOVT rd (right rs) cc 

### MOVT-fmt
###  - Floating Point Move Conditional on Floating Point True
val / ['010001 /fmt5sdps /cc 0 1 /fs /fd 010001'] = ternop-fmt MOVT-fmt fmt fd cc (right fs) 

### MOVZ
###  - Move Conditional on Not Zero
val / ['000000 /rs /rt /rd 00000 001010'] = ternop MOVZ rd (right rs) (right rt) 

### MOVZ-fmt
###  - Floating Point Move Conditional on Zero
val / ['010001 /fmt5sdps /rt /fs /fd 010010'] = ternop-fmt MOVZ-fmt fmt fd (right rt) (right fs) 

### MSUB
###  - Multiply and Subtract Word to Hi,Lo
val / ['011100 /rs /rt 00000 00000 000100'] = binop-src MSUB (right rs) (right rt) 

### MSUB-fmt
###  - Floating Point Multiply Subtract
val / ['010011 /fr /ft /fs /fd 101 /fmt3sdps'] = quadop-fmt MSUB-fmt fmt fd (right fr) (right ft) (right fs) 

### MSUBU
###  - Multiply and Subtract Word to Hi,Lo
val / ['011100 /rs /rt 00000 00000 000101'] = binop-src MSUBU (right rs) (right rt) 

### MTC0
###  - Move to Coprocessor 0
val / ['010000 00100 /rt /rd 00000000 /sel'] = ternop-src MTC0 (right rt) rd/imm sel 

### MTC1
###  - Move Word to Floating Point
val / ['010001 00100 /rt /fs 00000000000'] = binop MTC1 fs (right rt) 

### MTC2
###  - Move Word to Coprocessor 2
val / ['010010 00100 /rt /impl'] = binop-src MTC2 (right rt) impl 

### MTHC1
###  - Move Word to High Half of Floating Point Register
val / ['010001 00111 /rt /fs 00000000000'] = binop MTHC1 fs (right rt) 

### MTHC2
###  - Move Word to High Half of Coprocessor 2 Register
val / ['010010 00111 /rt /impl'] = binop-src MTHC2 (right rt) impl 

### MTHI
###  - Move To HI Register
val / ['000000 /rs 000000000000000 010001'] = unop-src MTHI (right rs) 

### MTLO
###  - Move To LO Register
val / ['000000 /rs 000000000000000 010011'] = unop-src MTLO (right rs) 

### MUL
###  - Multiply Word to GPR
val / ['011100 /rs /rt /rd 00000 000010'] = ternop MUL rd (right rs) (right rt) 

### MUL-fmt
###  - Floating Point Multiply
val / ['010001 /fmt5sdps /ft /fs /fd 000010'] = ternop-fmt MUL-fmt fmt fd (right ft) (right fs) 

### MULT
###  - Multiply Word
val / ['000000 /rs /rt 0000000000 011000'] = binop-src MULT (right rs) (right rt) 

### MULTU
###  - Multiply Unsigned Word
val / ['000000 /rs /rt 0000000000 011001'] = binop-src MULTU (right rs) (right rt) 

### NEG-fmt
###  - Floating Point Negate
val / ['010001 /fmt5sdps 00000 /fs /fd 000111'] = binop-fmt NEG-fmt fmt fd (right fs) 

### NMADD-fmt
###  - Floating Point Negative Multiply Add
val / ['010011 /fr /ft /fs /fd 110 /fmt3sdps'] = quadop-fmt NMADD-fmt fmt fd (right fr) (right ft) (right fs) 

### NMSUB-fmt
###  - Floating Point Negative Multiply Subtract
val / ['010011 /fr /ft /fs /fd 111 /fmt3sdps'] = quadop-fmt NMSUB-fmt fmt fd (right fr) (right ft) (right fs) 

### NOP
###  - No Operation
###  => see SLL r0, r0, 0

### NOR
###  - Not Or
val / ['000000 /rs /rt /rd 00000 100111'] = ternop NOR rd (right rs) (right rt) 

### OR
###  - Or
val / ['000000 /rs /rt /rd 00000 100101'] = ternop OR rd (right rs) (right rt) 

### ORI
###  - Or Immediate
val / ['001101 /rs /rt /immediate'] = ternop ORI rt (right rs) immediate 

### PAUSE
###  - Wait for the LLBit to clear
###  => see SLL r0, r0, 5

### PLL-PS
###  - Pair Lower Lower
val / ['010001 10110 /ft /fs /fd 101100'] = ternop PLL-PS fd (right ft) (right fs) 

### PLU-PS
###  - Pair Lower Upper
val / ['010001 10110 /ft /fs /fd 101101'] = ternop PLU-PS fd (right ft) (right fs) 

### PREF
###  - Prefetch
val / ['110011 /rs /hint5 /offset16'] = ternop-src PREF (right rs) hint5 offset16 

### PREFE
###  - Prefetch EVA
val / ['011111 /rs /hint5 /offset9 0 100011'] = ternop-src PREFE (right rs) hint5 offset9 

### PREFX
###  - Prefetch Indexed
val / ['010011 /rs /rt /hint5 00000 001111'] = ternop-src PREFX (right rs) (right rt) hint5 

### PUL-PS
###  - Pair Upper Lower
val / ['010001 10110 /ft /fs /fd 101110'] = ternop PUL-PS fd (right ft) (right fs) 

### PUU-PS
###  - Pair Upper Upper
val / ['010001 10110 /ft /fs /fd 101111'] = ternop PUU-PS fd (right ft) (right fs) 

### RDHWR
###  - Read Hardware Register
val / ['011111 00000 /rt /rd 00000 111011'] = binop RDHWR rt rd/imm 

### RDPGPR
###  - Read GRP from Previous Shadow Set
val / ['010000 01010 /rt /rd 00000000000'] = binop RDPGPR rd rt/imm 

### RECIP-fmt
###  - Reciprocal Approximation
val / ['010001 /fmt5sd 00000 /fs /fd 010101'] = binop-fmt RECIP-fmt fmt fd (right fs) 

### ROTR
###  - Rotate Word Right
val / ['000000 0000 1 /rt /rd /sa 000010'] = ternop ROTR rd (right rt) sa 

### ROTRV
###  - Rotate Word Right Variable
val / ['000000 /rs /rt /rd 0000 1 000110'] = ternop ROTRV rd (right rs) (right rt) 

### ROUND-L-fmt
###  - Floating Point Round to Long Fixed Point
val / ['010001 /fmt5sd 00000 /fs /fd 001000'] = binop-fmt ROUND-L-fmt fmt fd (right fs) 

### ROUND-W-fmt
###  - Floating Point Round to Word Fixed Point
val / ['010001 /fmt5sd 00000 /fs /fd 001100'] = binop-fmt ROUND-W-fmt fmt fd (right fs) 

### RSQRT-fmt
###  - Reciprocal Square Root Approximation
val / ['010001 /fmt5sd 00000 /fs /fd 010110'] = binop-fmt RSQRT-fmt fmt fd (right fs) 

### SB
###  - Store Byte
val / ['101000 /rs /rt /offset16'] = ternop-src SB (right rs) (right rt) offset16 

### SBE
###  - Store Byte EVA
val / ['011111 /rs /rt /offset9 0 011100'] = ternop-src SBE (right rs) (right rt) offset9 

### SC
###  - Store Conditional Word
val / ['111000 /rs /rt /offset16'] = ternop SC rt (right rs) offset16 

### SCE
###  - Store Conditional Word EVA
val / ['011111 /rs /rt /offset9 0 011110'] = ternop SCE rt (right rs) offset9 

### SDBBP
###  - Software Debug Breakpoint
val / ['011100 /code20 111111'] = unop-src SDBBP code20 

### SDC1
###  - Store Doubleword from Floating Point
val / ['111101 /rs /ft /offset16'] = ternop-src SDC1 (right rs) (right ft) offset16 

### SDC2
###  - Store Doubleword from Coprocessor 2
val / ['111110 /rs /rt /offset16'] = ternop-src SDC2 (right rs) rt/imm offset16 

### SDXC1
###  - Store Doubleword Indexed from Floating Point
val / ['010011 /rs /rt /fs 00000 001001'] = ternop-src SDXC1 (right rs) (right rt) (right fs) 

### SEB
###  - Sign-Extend Byte
val / ['011111 00000 /rt /rd 10000 100000'] = binop SEB rd (right rt) 

### SEH
###  - Sign-Extend Halfword
val / ['011111 00000 /rt /rd 11000 100000'] = binop SEH rd (right rt) 

### SH
###  - Store Halfword
val / ['101001 /rs /rt /offset16'] = ternop-src SH (right rs) (right rt) offset16 

### SHE
###  - Store Halfword EVA
val / ['011111 /rs /rt /offset9 0 011101'] = ternop-src SHE (right rs) (right rt) offset9 

### SLL
###  - Shift Word Left Logical
val / ['000000 00000 /rt /rd /sa 000000']
 | pause? = nullop DERET
 | otherwise = ternop SLL rd (right rt) sa

### SLLV
###  - Shift Word Left Logical Variable
val / ['000000 /rs /rt /rd 00000 000100'] = ternop SLLV rd (right rs) (right rt) 

### SLT
###  - Set On Less Than
val / ['000000 /rs /rt /rd 00000 101010'] = ternop SLT rd (right rs) (right rt) 

### SLTI
###  - Set on Less Than Immediate
val / ['001010 /rs /rt /immediate'] = ternop SLTI rt (right rs) immediate 

### SLTIU
###  - Set on Less Than Immediate Unsigned
val / ['001011 /rs /rt /immediate'] = ternop SLTIU rt (right rs) immediate 

### SLTU
###  - Set on Less Than Unsigned
val / ['000000 /rs /rt /rd 00000 101011'] = ternop SLTU rd (right rs) (right rt) 

### SQRT-fmt
###  - Floating Point Square Root
val / ['010001 /fmt5sd 00000 /fs /fd 000100'] = binop-fmt SQRT-fmt fmt fd (right fs) 

### SRA
###  - Shift Word Right Arithmetic
val / ['000000 00000 /rt /rd /sa 000011'] = ternop SRA rd (right rt) sa 

### SRAV
###  - Shift Word Right Arithmetic Variable
val / ['000000 /rs /rt /rd 00000 000111'] = ternop SRAV rd (right rs) (right rt) 

### SRL
###  - Shift Word Right Logical
val / ['000000 0000 0 /rt /rd /sa 000010'] = ternop SRL rd (right rt) sa 

### SRLV
###  - Shift Word Right Logical Variable
val / ['000000 /rs /rt /rd 0000 0 000110'] = ternop SRLV rd (right rs) (right rt) 

### SSNOP
###  - Superscalar No Operation
###  => see SLL r0, r0, 1

### SUB
###  - Subtract Word
val / ['000000 /rs /rt /rd 00000 100010'] = ternop SUB rd (right rs) (right rt) 

### SUB-fmt
###  - Floating Point Subtract
val / ['010001 /fmt5sdps /ft /fs /fd 000001'] = ternop-fmt SUB-fmt fmt fd (right ft) (right fs) 

### SUBU
###  - Subtract Unsigned Word
val / ['000000 /rs /rt /rd 00000 100011'] = ternop SUBU rd (right rs) (right rt) 

### SUXC1
###  - Store Doubleword Indexed Unaligned from Floating Point
val / ['010011 /rs /rt /fs 00000 001101'] = ternop-src SUXC1 (right rs) (right rt) (right fs) 

### SW
###  - Store Word
val / ['101011 /rs /rt /offset16'] = ternop-src SW (right rs) (right rt) offset16 

### SWC1
###  - Store Word from Floating Point
val / ['111001 /rs /ft /offset16'] = ternop-src SWC1 (right rs) (right ft) offset16 

### SWC2
###  - Store Word from Coprocessor 2
val / ['111010 /rs /rt /offset16'] = ternop-src SWC2 (right rs) rt/imm offset16 

### SWE
###  - Store Word EVA
val / ['011111 /rs /rt /offset9 0 011111'] = ternop-src SWE (right rs) (right rt) offset9 

### SWL
###  - Store Word Left
val / ['101010 /rs /rt /offset16'] = ternop-src SWL (right rs) (right rt) offset16 

### SWLE
###  - Store Word Left EVA
val / ['011111 /rs /rt /offset9 0 100001'] = ternop-src SWLE (right rs) (right rt) offset9 

### SWR
###  - Store Word Right
val / ['101110 /rs /rt /offset16'] = ternop-src SWR (right rs) (right rt) offset16 

### SWRE
###  - Store Word Right EVA
val / ['011111 /rs /rt /offset9 0 100010'] = ternop-src SWRE (right rs) (right rt) offset9 

### SWXC1
###  - Store Word Indexed from Floating Point
val / ['010011 /rs /rt /fs 00000 001000'] = ternop-src SWXC1 (right rs) (right rt) (right fs) 

### SYNC
###  - Synchronize Shared Memory
val / ['000000 000000000000000 /stype 001111'] = unop-src SYNC stype 

### SYNCI
###  - Synchronize Caches to Make Instruction Writes Effective
val / ['000001 /rs 11111 /offset16'] = binop-src SYNCI (right rs) offset16 

### SYSCALL
###  - System Call
val / ['000000 /code20 001100'] = unop-src SYSCALL code20 

### TEQ
###  - Trap if Equal
val / ['000000 /rs /rt /code10 110100'] = ternop-src TEQ (right rs) (right rt) code10 

### TEQI
###  - Trap if Equal Immediate
val / ['000001 /rs 01100 /immediate'] = binop-src TEQI (right rs) immediate 

### TGE
###  - Trap if Greater or Equal
val / ['000000 /rs /rt /code10 110000'] = ternop-src TGE (right rs) (right rt) code10 

### TGEI
###  - Trap if Greater or Equal Immediate
val / ['000001 /rs 01000 /immediate'] = binop-src TGEI (right rs) immediate 

### TGEIU
###  - Trap if Greater or Equal Immediate Unsigned
val / ['000001 /rs 01001 /immediate'] = binop-src TGEIU (right rs) immediate 

### TGEU
###  - Trap if Greater or Equal Unsigned
val / ['000000 /rs /rt /code10 110001'] = ternop-src TGEU (right rs) (right rt) code10 

### TLBINV
###  - TLB Invalidate
val / ['010000 1 0000000000000000000 000011'] = nullop TLBINV 

### TLBINVF
###  - TLB Invalidate Flush
val / ['010000 1 0000000000000000000 000100'] = nullop TLBINVF 

### TLBP
###  - Probe TLB for Matching Entry
val / ['010000 1 0000000000000000000 001000'] = nullop TLBP 

### TLBR
###  - Read Indexed TLB Entry
val / ['010000 1 0000000000000000000 000001'] = nullop TLBR 

### TLBWI
###  - Write Indexed TLB Entry
val / ['010000 1 0000000000000000000 000010'] = nullop TLBWI 

### TLBWR
###  - Write Random TLB Entry
val / ['010000 1 0000000000000000000 000110'] = nullop TLBWR 

### TLT
###  - Trap if Less Than
val / ['000000 /rs /rt /code10 110010'] = ternop-src TLT (right rs) (right rt) code10 

### TLTI
###  - Trap if Less Than Immediate
val / ['000001 /rs 01010 /immediate'] = binop-src TLTI (right rs) immediate 

### TLTIU
###  - Trap if Less Than Immediate Unsigned
val / ['000001 /rs 01011 /immediate'] = binop-src TLTIU (right rs) immediate 

### TLTU
###  - Trap if Less Than Unsigned
val / ['000000 /rs /rt /code10 110011'] = ternop-src TLTU (right rs) (right rt) code10 

### TNE
###  - Trap if Not Equal
val / ['000000 /rs /rt /code10 110110'] = ternop-src TNE (right rs) (right rt) code10 

### TNEI
###  - Trap if Not Equal Immediate
val / ['000001 /rs 01110 /immediate'] = binop-src TNEI (right rs) immediate 

### TRUNC-L-fmt
###  - Floating Point Truncate to Long Fixed Point
val / ['010001 /fmt5sd 00000 /fs /fd 001001'] = binop-fmt TRUNC-L-fmt fmt fd (right fs) 

### TRUNC-W-fmt
###  - Floating Point Truncate to Word Fixed Point
val / ['010001 /fmt5sd 00000 /fs /fd 001101'] = binop-fmt TRUNC-W-fmt fmt fd (right fs) 

### WAIT
###  - Enter Standby Mode
val / ['010000 1 /code19 100000'] = unop-src WAIT code19 

### WRPGPR
###  - Write to GPR in Previous Shadow Set
val / ['010000 01110 /rt /rd 00000000000'] = binop-src WRPGPR (right rt) rd/imm 

### WSBH
###  - Word Swap Bytes Within Halfwords
val / ['011111 00000 /rt /rd 00010 100000'] = binop WSBH rd (right rt) 

### XOR
###  - Exclusive OR
val / ['000000 /rs /rt /rd 00000 100110'] = ternop XOR rd (right rs) (right rt) 

### XORI
###  - Exclusive OR Immediate
val / ['001110 /rs /rt /immediate'] = ternop XORI rt (right rs) immediate 


val rs = do
  rs <- query $rs;
  update @{rs=''};
  return (GPR (gpr-from-bits rs))
end

val rt = do
  rt <- query $rt;
  update @{rt='00000'};
  return (GPR (gpr-from-bits rt))
end

val rd = do
  rd <- query $rd;
  update @{rd='00000'};
  return (GPR (gpr-from-bits rd))
end

val rd/imm = do
  rd <- query $rd;
  update @{rd='00000'};
  return (IMM (IMM5 rd))
end

val rt/imm = do
  rt <- query $rt;
  update @{rt='00000'};
  return (IMM (IMM5 rt))
end

val fr = do
  fr <- query $fr;
  update @{fr=''};
  return (FPR (fpr-from-bits fr))
end

val fs = do
  fs <- query $fs;
  update @{fs=''};
  return (FPR (fpr-from-bits fs))
end

val ft = do
  ft <- query $ft;
  update @{ft=''};
  return (FPR (fpr-from-bits ft))
end

val fd = do
  fd <- query $fd;
  update @{fd=''};
  return (FPR (fpr-from-bits fd))
end

val fs/ctrl = do
  fs <- query $fs;
  update @{fs=''};
  return (IMM (IMM5 fs))
end

val immediate = do
  immediate <- query $immediate;
  update @{immediate=''};
  return (IMM (IMM16 immediate))
end

val offset16 = do
  offset <- query $offset;
  update @{offset=''};
  return (IMM (OFFSET16 offset))
end

val offset9 = do
  offset <- query $offset;
  update @{offset=''};
  return (IMM (OFFSET9 offset))
end

val sel = do
  sel <- query $sel;
  update @{sel=''};
  return (IMM (SEL sel))
end

val impl = do
  impl <- query $impl;
  update @{impl=''};
  return (IMM (IMPL impl))
end

val code10 = do
  code10 <- query $code10;
  update @{code10=''};
  return (IMM (CODE10 code10))
end

val code19 = do
  code19 <- query $code19;
  update @{code19=''};
  return (IMM (CODE19 code19))
end

val code20 = do
  code20 <- query $code20;
  update @{code20=''};
  return (IMM (CODE20 code20))
end

val stype = do
  stype <- query $stype;
  update @{stype=''};
  return (IMM (STYPE stype))
end

val msb = do
  msb <- query $msb;
  update @{msb=''};
  return (IMM (POSSIZE msb))
end

val msbd = do
  msbd <- query $msbd;
  update @{msbd=''};
  return (IMM (SIZE msbd))
end

val lsb = do
  lsb <- query $lsb;
  update @{lsb=''};
  return (IMM (POS lsb))
end

val sa = do
  sa <- query $sa;
  update @{sa='00000'};
  return (IMM (IMM5 sa))
end

val instr_index = do
  instr_index <- query $instr_index;
  update @{instr_index=''};
  return (IMM (INSTRINDEX instr_index))
end

val cofun = do
  cofun <- query $cofun;
  update @{cofun=''};
  return (IMM (COFUN cofun))
end

val cc = do
  cc <- query $cc;
  update @{cc=''};
  return (IMM (CC cc))
end

val cond = do
  cond <- query $cond;
  update @{cond=''};
  return (IMM (COND cond))
end

val op = do
  op <- query $op;
  update @{op=''};
  return (IMM (OP op))
end

val hint5 = do
  hint <- query $hint;
  update @{hint=''};
  return (IMM (HINT hint))
end

val fmt = do
  fmt <- query $fmt;
  update @{fmt=''};
  return (format-from-bits (fmt))
end


val /rs ['rs:5'] = update@{rs=rs}
val /rt ['rt:5'] = update@{rt=rt}
val /rd ['rd:5'] = update@{rd=rd}
val /fr ['fr:5'] = update@{fr=fr}
val /fs ['fs:5'] = update@{fs=fs}
val /ft ['ft:5'] = update@{ft=ft}
val /fd ['fd:5'] = update@{fd=fd}
val /immediate ['immediate:16'] = update@{immediate=immediate}
val /offset16 ['offset:16'] = update@{offset=offset}
val /offset9 ['offset:9'] = update@{offset=offset}
val /sel ['sel:3'] = update@{sel=sel}
val /impl ['impl:16'] = update@{impl=impl}
val /code10 ['code10:10'] = update@{code10=code10}
val /code19 ['code19:19'] = update@{code19=code19}
val /code20 ['code20:20'] = update@{code20=code20}
val /stype ['stype:5'] = update@{stype=stype}
val /msb ['msb:5'] = update@{msb=msb}
val /msbd ['msbd:5'] = update@{msbd=msbd}
val /lsb ['lsb:5'] = update@{lsb=lsb}
val /sa ['sa:5'] = update@{sa=sa}
val /instr_index ['instr_index:26'] = update@{instr_index=instr_index}
val /cofun ['cofun:25'] = update@{cofun=cofun}
val /cc ['cc:3'] = update@{cc=cc}
val /cond ['cond:4'] = update@{cond=cond}
val /op ['op:5'] = update@{op=op}
val /hint5 ['hint:5'] = update@{hint=hint}
val /hint5zero ['00000'] = update@{hint='00000'}
val /hint4zero ['0000'] = update@{hint='00000'}
val /fmt5sd ['10000'] = update@{fmt='10000'}
val /fmt5sd ['10001'] = update@{fmt='10001'}
val /fmt5sdps ['10000'] = update@{fmt='10000'}
val /fmt5sdps ['10001'] = update@{fmt='10001'}
val /fmt5sdps ['10110'] = update@{fmt='10110'}
val /fmt5dwl ['10001'] = update@{fmt='10001'}
val /fmt5dwl ['10100'] = update@{fmt='10100'}
val /fmt5dwl ['10101'] = update@{fmt='10101'}
val /fmt5swl ['10000'] = update@{fmt='10000'}
val /fmt5swl ['10100'] = update@{fmt='10100'}
val /fmt5swl ['10101'] = update@{fmt='10101'}
val /fmt3sdps ['000'] = update@{fmt='10000'}
val /fmt3sdps ['001'] = update@{fmt='10001'}
val /fmt3sdps ['110'] = update@{fmt='10110'}


type unop-src = {source:rvalue}
type unop = {destination:lvalue}
type binop-src = {source1:rvalue,source2:rvalue}
type binop-fmt = {fmt:format,destination:lvalue,source:rvalue}
type binop = {destination:lvalue,source:rvalue}
type ternop-src = {source1:rvalue,source2:rvalue,source3:rvalue}
type ternop = {destination:lvalue,source1:rvalue,source2:rvalue}
type ternop-fmt = {fmt:format,destination:lvalue,source1:rvalue,source2:rvalue}
type quadop = {destination:lvalue,source1:rvalue,source2:rvalue,source3:rvalue}
type quadop-fmt = {fmt:format,destination:lvalue,source1:rvalue,source2:rvalue,source3:rvalue}
type quadop-fmt-src = {fmt:format,source1:rvalue,source2:rvalue,source3:rvalue,source4:rvalue}


val nullop cons = do
 return cons
end

val unop-src cons source = do
 source <- source;
 return (cons {source=source})
end

val unop cons destination = do
 destination <- destination;
 return (cons {destination=destination})
end

val binop-src cons source1 source2 = do
 source1 <- source1;
 source2 <- source2;
 return (cons {source1=source1, source2=source2})
end

val binop-fmt cons fmt destination source = do
 fmt <- fmt;
 destination <- destination;
 source <- source;
 return (cons {fmt=fmt, destination=destination, source=source})
end

val binop cons destination source = do
 destination <- destination;
 source <- source;
 return (cons {destination=destination, source=source})
end

val ternop-src cons source1 source2 source3 = do
 source1 <- source1;
 source2 <- source2;
 source3 <- source3;
 return (cons {source1=source1, source2=source2, source3=source3})
end

val ternop cons destination source1 source2 = do
 destination <- destination;
 source1 <- source1;
 source2 <- source2;
 return (cons {destination=destination, source1=source1, source2=source2})
end

val ternop-fmt cons fmt destination source1 source2 = do
 fmt <- fmt;
 destination <- destination;
 source1 <- source1;
 source2 <- source2;
 return (cons {fmt=fmt, destination=destination, source1=source1, source2=source2})
end

val quadop cons destination source1 source2 source3 = do
 destination <- destination;
 source1 <- source1;
 source2 <- source2;
 source3 <- source3;
 return (cons {destination=destination, source1=source1, source2=source2, source3=source3})
end

val quadop-fmt cons fmt destination source1 source2 source3 = do
 fmt <- fmt;
 destination <- destination;
 source1 <- source1;
 source2 <- source2;
 source3 <- source3;
 return (cons {fmt=fmt, destination=destination, source1=source1, source2=source2, source3=source3})
end

val quadop-fmt-src cons fmt source1 source2 source3 source4 = do
 fmt <- fmt;
 source1 <- source1;
 source2 <- source2;
 source3 <- source3;
 source4 <- source4;
 return (cons {fmt=fmt, source1=source1, source2=source2, source3=source3, source4=source4})
end


type instruction = 
   ABS-fmt of binop-fmt
 | ADD of ternop
 | ADD-fmt of ternop-fmt
 | ADDI of ternop
 | ADDIU of ternop
 | ADDU of ternop
 | ALNV-PS of quadop
 | AND of ternop
 | ANDI of ternop
 | BC1F of binop-src
 | BC1FL of binop-src
 | BC1T of binop-src
 | BC1TL of binop-src
 | BC2F of binop-src
 | BC2FL of binop-src
 | BC2T of binop-src
 | BC2TL of binop-src
 | BEQ of ternop-src
 | BEQL of ternop-src
 | BGEZ of binop-src
 | BGEZAL of binop-src
 | BGEZALL of binop-src
 | BGEZL of binop-src
 | BGTZ of binop-src
 | BGTZL of binop-src
 | BLEZ of binop-src
 | BLEZL of binop-src
 | BLTZ of binop-src
 | BLTZAL of binop-src
 | BLTZALL of binop-src
 | BLTZL of binop-src
 | BNE of ternop-src
 | BNEL of ternop-src
 | BREAK of unop-src
 | C-cond-fmt of quadop-fmt-src
 | CACHE of ternop-src
 | CACHEE of ternop-src
 | CEIL-L-fmt of binop-fmt
 | CEIL-W-fmt of binop-fmt
 | CFC1 of binop
 | CFC2 of binop
 | CLO of ternop
 | CLZ of ternop
 | COP2 of unop-src
 | CTC1 of binop-src
 | CTC2 of binop-src
 | CVT-D-fmt of binop-fmt
 | CVT-L-fmt of binop-fmt
 | CVT-PS-S of ternop
 | CVT-S-fmt of binop-fmt
 | CVT-S-PL of binop
 | CVT-S-PU of binop
 | CVT-W-fmt of binop-fmt
 | DERET
 | DI of unop
 | DIV of binop-src
 | DIV-fmt of ternop-fmt
 | DIVU of binop-src
 | EI of unop
 | ERET
 | EXT of quadop
 | FLOOR-L-fmt of binop-fmt
 | FLOOR-W-fmt of binop-fmt
 | INS of quadop
 | J of unop-src
 | JAL of unop-src
 | JALR of ternop
 | JALR-HB of ternop
 | JALX of unop-src
 | JR of binop-src
 | JR-HB of binop-src
 | LB of ternop
 | LBE of ternop
 | LBU of ternop
 | LBUE of ternop
 | LDC1 of ternop
 | LDC2 of ternop-src
 | LDXC1 of ternop
 | LH of ternop
 | LHE of ternop
 | LHU of ternop
 | LHUE of ternop
 | LL of ternop
 | LLE of ternop
 | LUI of binop
 | LUXC1 of ternop
 | LW of ternop
 | LWC1 of ternop
 | LWC2 of ternop-src
 | LWE of ternop
 | LWL of ternop
 | LWLE of ternop
 | LWR of ternop
 | LWRE of ternop
 | LWXC1 of ternop
 | MADD of binop-src
 | MADD-fmt of quadop-fmt
 | MADDU of binop-src
 | MFC0 of ternop
 | MFC1 of binop
 | MFC2 of binop
 | MFHC1 of binop
 | MFHC2 of binop
 | MFHI of unop
 | MFLO of unop
 | MOV-fmt of binop-fmt
 | MOVF of ternop
 | MOVF-fmt of ternop-fmt
 | MOVN of ternop
 | MOVN-fmt of ternop-fmt
 | MOVT of ternop
 | MOVT-fmt of ternop-fmt
 | MOVZ of ternop
 | MOVZ-fmt of ternop-fmt
 | MSUB of binop-src
 | MSUB-fmt of quadop-fmt
 | MSUBU of binop-src
 | MTC0 of ternop-src
 | MTC1 of binop
 | MTC2 of binop-src
 | MTHC1 of binop
 | MTHC2 of binop-src
 | MTHI of unop-src
 | MTLO of unop-src
 | MUL of ternop
 | MUL-fmt of ternop-fmt
 | MULT of binop-src
 | MULTU of binop-src
 | NEG-fmt of binop-fmt
 | NMADD-fmt of quadop-fmt
 | NMSUB-fmt of quadop-fmt
 | NOR of ternop
 | OR of ternop
 | ORI of ternop
 | PLL-PS of ternop
 | PLU-PS of ternop
 | PREF of ternop-src
 | PREFE of ternop-src
 | PREFX of ternop-src
 | PUL-PS of ternop
 | PUU-PS of ternop
 | RDHWR of binop
 | RDPGPR of binop
 | RECIP-fmt of binop-fmt
 | ROTR of ternop
 | ROTRV of ternop
 | ROUND-L-fmt of binop-fmt
 | ROUND-W-fmt of binop-fmt
 | RSQRT-fmt of binop-fmt
 | SB of ternop-src
 | SBE of ternop-src
 | SC of ternop
 | SCE of ternop
 | SDBBP of unop-src
 | SDC1 of ternop-src
 | SDC2 of ternop-src
 | SDXC1 of ternop-src
 | SEB of binop
 | SEH of binop
 | SH of ternop-src
 | SHE of ternop-src
 | SLL of ternop
 | SLLV of ternop
 | SLT of ternop
 | SLTI of ternop
 | SLTIU of ternop
 | SLTU of ternop
 | SQRT-fmt of binop-fmt
 | SRA of ternop
 | SRAV of ternop
 | SRL of ternop
 | SRLV of ternop
 | SUB of ternop
 | SUB-fmt of ternop-fmt
 | SUBU of ternop
 | SUXC1 of ternop-src
 | SW of ternop-src
 | SWC1 of ternop-src
 | SWC2 of ternop-src
 | SWE of ternop-src
 | SWL of ternop-src
 | SWLE of ternop-src
 | SWR of ternop-src
 | SWRE of ternop-src
 | SWXC1 of ternop-src
 | SYNC of unop-src
 | SYNCI of binop-src
 | SYSCALL of unop-src
 | TEQ of ternop-src
 | TEQI of binop-src
 | TGE of ternop-src
 | TGEI of binop-src
 | TGEIU of binop-src
 | TGEU of ternop-src
 | TLBINV
 | TLBINVF
 | TLBP
 | TLBR
 | TLBWI
 | TLBWR
 | TLT of ternop-src
 | TLTI of binop-src
 | TLTIU of binop-src
 | TLTU of ternop-src
 | TNE of ternop-src
 | TNEI of binop-src
 | TRUNC-L-fmt of binop-fmt
 | TRUNC-W-fmt of binop-fmt
 | WAIT of unop-src
 | WRPGPR of binop-src
 | WSBH of binop
 | XOR of ternop
 | XORI of ternop

# <- sutl

type instruction = 
   PAUSE of ternop

type register =
   ZERO
 | AT
 | V0
 | V1
 | A0
 | A1
 | A2
 | A3
 | T0
 | T1
 | T2
 | T3
 | T4
 | T5
 | T6
 | T7
 | S0
 | S1
 | S2
 | S3
 | S4
 | S5
 | S6
 | S7
 | T8
 | T9
 | K0
 | K1
 | GP
 | SP
 | S8
 | RA

type register =
   HI
 | LO
 | PC
 | SREG

type register =
   F0
 | F1
 | F2
 | F3
 | F4
 | F5
 | F6
 | F7
 | F8
 | F9
 | F10
 | F11
 | F12
 | F13
 | F14
 | F15
 | F16
 | F17
 | F18
 | F19
 | F20
 | F21
 | F22
 | F23
 | F24
 | F25
 | F26
 | F27
 | F28
 | F29
 | F30
 | F31
 | FIR
 | FCCR
 | FEXR
 | FENR
 | FCSR

val gpr-from-bits bits =
 case bits of
    '00000': ZERO
  | '00001': AT
  | '00010': V0
  | '00011': V1
  | '00100': A0
  | '00101': A1
  | '00110': A2
  | '00111': A3
  | '01000': T0
  | '01001': T1
  | '01010': T2
  | '01011': T3
  | '01100': T4
  | '01101': T5
  | '01110': T6
  | '01111': T7
  | '10000': S0
  | '10001': S1
  | '10010': S2
  | '10011': S3
  | '10100': S4
  | '10101': S5
  | '10110': S6
  | '10111': S7
  | '11000': T8
  | '11001': T9
  | '11010': K0
  | '11011': K1
  | '11100': GP
  | '11101': SP
  | '11110': S8
  | '11111': RA
 end

val fpr-from-bits bits =
 case bits of
    '00000': F0
  | '00001': F1
  | '00010': F2
  | '00011': F3
  | '00100': F4
  | '00101': F5
  | '00110': F6
  | '00111': F7
  | '01000': F8
  | '01001': F9
  | '01010': F10
  | '01011': F11
  | '01100': F12
  | '01101': F13
  | '01110': F14
  | '01111': F15
  | '10000': F16
  | '10001': F17
  | '10010': F18
  | '10011': F19
  | '10100': F20
  | '10101': F21
  | '10110': F22
  | '10111': F23
  | '11000': F24
  | '11001': F25
  | '11010': F26
  | '11011': F27
  | '11100': F28
  | '11101': F29
  | '11110': F30
  | '11111': F31
 end

val format-from-bits bits = 
 case bits of
    '10000': S
  | '10001': D
  | '10100': W
  | '10101': L
  | '10110': PS
 end
