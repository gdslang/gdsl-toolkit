export config-default: decoder-configuration
export decode: (decoder-configuration) -> S insndata <{} => {}>
export decoder-config : configuration[vec=decoder-configuration]

type decoder-configuration = 0

val decoder-config = END
val config-default = ''

type insndata = {length:int, insn:instruction}


####################################################################
###             architecture specific configuration              ###
####################################################################

## when set true, the instruction set and string conversion is adapted
## to the mips gnu binutils assembler syntax
val assembler-mode = '0'

## when set false, exceptions are omitted from the translated RReil
## code 
val exceptions_on = '1'

## indicates the used memory layout
val bigendian_mem = '1'

## indicates that MIPS16 is supported
val isMIPS16Implemented = '1'

## architecture revision number (1 to 6 are available)
val architectureRevision = 2


#################################
# decode and configure function
####

val decode config = do
#  endianness endian-little/instr32-big/access64;
#  endianness endian-little/instr32-big/access64;

#  endianness endian-little/instr32-little/access32; #mipsel
  endianness endian-big/instr32-big/access32; #mips
  idx-before <- get-ip;
  insn <- /;
  idx-after <- get-ip;
  return {length=(idx-after - idx-before), insn=insn}
end



##############################################
# operand base types
# - lvalue: left hand side value (dest/source)
# - rvalue: right hand side value (source)
####

type lvalue =
   GPR of gpr-register
 | FPR of fpr-register
 | FCC of fccode
 | C2CC of cop2ccode

type rvalue =
   LVALUE of lvalue
 | IMM of imm
 | OFFSET/BASE of {offset:imm, base:gpr-register}
 | INDEX/BASE of {index:gpr-register, base:gpr-register}
 | MSB/LSB of {msb:imm, lsb:imm}


#########################################
# format
# - FPU, data format identifier
####

type format = 
   S
 | D
 | W
 | L


#########################################
# floating point condition code
# - single status bits of register FCSR
####

type fccode =
   FCC0
 | FCC1
 | FCC2
 | FCC3
 | FCC4
 | FCC5
 | FCC6
 | FCC7

#########################################
# coprocessor 2 condition code
# - single status bits of an unspecified reg
####

type cop2ccode =
   C2CC0
 | C2CC1
 | C2CC2
 | C2CC3
 | C2CC4
 | C2CC5
 | C2CC6
 | C2CC7


##############################
# condition operand
# - only in C-cond-fmt instr.
####

type condop =
   C_F
 | C_UN
 | C_EQ
 | C_UEQ
 | C_OLT
 | C_ULT
 | C_OLE
 | C_ULE
 | C_SF
 | C_NGLE
 | C_SEQ
 | C_NGL
 | C_LT
 | C_NGE
 | C_LE
 | C_NGT


################
# transform a lvalue to rvalue
####

val right lvalue = do
  lvalue <- lvalue;
  return (LVALUE lvalue)
end


########################
# guard conditions
####

val pause? s = (s.rt == '00000') and (s.rd == '00000') and (s.sa == '00101') and (not (assembler-mode))
val jalr? s = not (s.rd == s.rs)
val ext? s = (zx s.lsb) + (zx s.msbd) < 32
val ins? s = (zx s.lsb) - (zx s.msb)  < 1
val cloz? s = (s.rt == s.rd)
val asimpl? s = assembler-mode #and ((zx s.impl) > 31)
val asbreak? s = (s.code10to20 == '0000000000') and assembler-mode
val asmode? s = assembler-mode



######################
# decoder rules
####

### ADD
###  - Add Word
val / ['000000 /rs /rt /rd 00000 100000'] = ternop ADD rd (right rs) (right rt) 

### ADDIU
###  - Add Immediate Unsigned Word
val / ['001001 /rs /rt /immediate16'] = ternop ADDIU rt (right rs) immediate16 

### ADDU
###  - Add Unsigned Word
val / ['000000 /rs /rt /rd 00000 100001'] = ternop ADDU rd (right rs) (right rt) 

### AND
###  - And
val / ['000000 /rs /rt /rd 00000 100100'] = ternop AND rd (right rs) (right rt) 

### ANDI
###  - And Immediate
val / ['001100 /rs /rt /immediate16'] = ternop ANDI rt (right rs) immediate16 

### B
###  - Unconditional Branch
###  => see BEQ r0, r0, offset

### BAL
###  - Branch and Link
###  => see BGEZAL r0, offset

### BEQ
###  - Branch on Equal
val / ['000100 /rs /rt /offset16'] = ternop BEQ (right rs) (right rt) offset18 

### BGEZ
###  - Branch on Greater Than or Equal to Zero
val / ['000001 /rs 00001 /offset16'] = binop BGEZ (right rs) offset18

### BLTZ
###  - Branch on Less Than Zero
val / ['000001 /rs 00000 /offset16'] = binop BLTZ (right rs) offset18

### BNE
###  - Branch on Not Equal
val / ['000101 /rs /rt /offset16'] = ternop BNE (right rs) (right rt) offset18

### BREAK
###  - Breakpoint
val / ['000000 /code10 /code10to20 001101']
 | asbreak? = unop BREAK code10
 | asmode? = nullop UNDEFINED
 | otherwise = unop BREAK code10to20 

### C-cond-fmt
###  - Floating Point Compare
val / ['010001 /fmt5sdps /ft /fs /cc 0 0 11 /cond'] = ternop-cond-fmt C-cond-fmt cond fmt fcc (right fs) (right ft)

### CACHE
###  - Perform Cache Operation
val / ['101111 /base /op /offset16'] = binop CACHE op offset16/base

### CACHEE
###  - Perform Cache Operation EVA
val / ['011111 /base /op /offset9 0 011011']
 | asmode? = nullop UNDEFINED
 | otherwise = binop CACHEE op offset9/base 

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
val / ['010010 00010 /rt /impl']
 | asimpl? = nullop UNDEFINED
 | otherwise = binop CFC2 rt impl 

### CLO
###  - Count Leading Ones in Word
val / ['011100 /rs /rt /rd 00000 100001']
 | cloz? = binop CLO rd (right rs)
 | otherwise = nullop UNPREDICTABLE

### CLZ
###  - Count Leading Zeros in Word
val / ['011100 /rs /rt /rd 00000 100000']
 | cloz? = binop CLZ rd (right rs)
 | otherwise = nullop UNPREDICTABLE

### COP2
###  - Coprocessor Operation to Coprocessor 2
val / ['010010 1 /cofun'] = unop COP2 cofun 

### CTC1
###  - Move Control Word to Floating Point
val / ['010001 00110 /rt /fs 00000000000'] = binop CTC1 (right rt) fs/ctrl 

### CTC2
###  - Move Control Word to Coprocessor 2
val / ['010010 00110 /rt /impl']
 | asimpl? = nullop UNDEFINED
 | otherwise = binop CTC2 (right rt) impl 

### CVT-D-fmt
###  - Floating Point Convert To Double Floating Point
val / ['010001 /fmt5swl 00000 /fs /fd 100001'] = binop-fmt CVT-D-fmt fmt fd (right fs) 

### CVT-L-fmt
###  - Floating Point Convert to Long Fixed Point
val / ['010001 /fmt5sd 00000 /fs /fd 100101'] = binop-fmt CVT-L-fmt fmt fd (right fs) 

### CVT-PS-S
###  - Floating Point Convert Pair to Paired Single
val / ['010001 10000 /ft /fs /fd 100110'] = ternop CVT-PS-S fd (right fs) (right ft) 

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
val / ['000000 /rs /rt 0000000000 011010'] = binop DIV (right rs) (right rt) 

### DIV-fmt
###  - Floating Point Divide
val / ['010001 /fmt5sd /ft /fs /fd 000011'] = ternop-fmt DIV-fmt fmt fd (right fs) (right ft) 

### DIVU
###  - Divide Unsigned Word
val / ['000000 /rs /rt 0000000000 011011'] = binop DIVU (right rs) (right rt) 

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
val / ['011111 /rs /rt /msbd /lsb 000000']
 | ext? = quadop EXT rt (right rs) lsb msbd
 | otherwise = nullop UNPREDICTABLE

### FLOOR-L-fmt
###  - Floating Point Floor Convert to Long Fixed Point
val / ['010001 /fmt5sd 00000 /fs /fd 001011'] = binop-fmt FLOOR-L-fmt fmt fd (right fs) 

### FLOOR-W-fmt
###  - Floating Point Floor Convert to Word Fixed Point
val / ['010001 /fmt5sd 00000 /fs /fd 001111'] = binop-fmt FLOOR-W-fmt fmt fd (right fs) 

### INS
###  - Insert Bit Field
val / ['011111 /rs /rt /msb /lsb 000100']
 | ins? = ternop INS rt (right rs) msb/lsb 
 | otherwise = nullop UNPREDICTABLE

### J
###  - Jump
val / ['000010 /instr_index'] = unop J instr_index 

### JAL
###  - Jump And Link
val / ['000011 /instr_index'] = unop JAL instr_index 

### JALR
###  - Jump And Link Register
val / ['000000 /rs 00000 /rd 00000 001001']
 | jalr? = binop JALR rd (right rs) 
 | otherwise = nullop UNPREDICTABLE

### JALR-HB
###  - Jump and Link Register with Hazard Barrier
val / ['000000 /rs 00000 /rd 1 0000 001001']
 | jalr? = binop JALR-HB rd (right rs) 
 | otherwise = nullop UNPREDICTABLE

### JALX
###  - Jump and Link Exchange
val / ['011101 /instr_index'] = unop JALX instr_index 

### JR
###  - Jump Register
val / ['000000 /rs 0000000000 00000 001000'] = unop JR (right rs) 

### JR-HB
###  - Jump Register with Hazard Barrier
val / ['000000 /rs 0000000000 1 0000 001000'] = unop JR-HB (right rs) 

### LB
###  - Load Byte
val / ['100000 /base /rt /offset16'] = binop LB rt offset16/base

### LBE
###  - Load Byte EVA
val / ['011111 /base /rt /offset9 0 101100']
 | asmode? = nullop UNDEFINED
 | otherwise = binop LBE rt offset9/base 

### LBU
###  - Load Byte Unsigned
val / ['100100 /base /rt /offset16'] = binop LBU rt offset16/base

### LBUE
###  - Load Byte Unsigned EVA
val / ['011111 /base /rt /offset9 0 101000']
 | asmode? = nullop UNDEFINED
 | otherwise = binop LBUE rt offset9/base

### LDC1
###  - Load Doubleword to Floating Point
val / ['110101 /base /ft /offset16'] = binop LDC1 ft offset16/base 

### LDC2
###  - Load Doubleword to Coprocessor 2
val / ['110110 /base /rt /offset16'] = binop LDC2 rt/imm offset16/base 

### LDXC1
###  - Load Doubleword Indexed to Floating Point
val / ['010011 /base /index 00000 /fd 000001'] = binop LDXC1 fd index/base

### LH
###  - Load Halfword
val / ['100001 /base /rt /offset16'] = binop LH rt offset16/base

### LHE
###  - Load Halfword EVA
val / ['011111 /base /rt /offset9 0 101101']
 | asmode? = nullop UNDEFINED
 | otherwise = binop LHE rt offset9/base

### LHU
###  - Load Halfword Unsigned
val / ['100101 /base /rt /offset16'] = binop LHU rt offset16/base

### LHUE
###  - Load Halfword Unsigned EVA
val / ['011111 /base /rt /offset9 0 101001']
 | asmode? = nullop UNDEFINED
 | otherwise = binop LHUE rt offset9/base

### LL
###  - Load Linked Word
val / ['110000 /base /rt /offset16'] = binop LL rt offset16/base

### LLE
###  - Load Linked Word EVA
val / ['011111 /base /rt /offset9 0 101110']
 | asmode? = nullop UNDEFINED
 | otherwise = binop LLE rt offset9/base

### LUXC1
###  - Load Doubleword Indexed Unaligned to Floating Point
val / ['010011 /base /index 00000 /fd 000101'] = binop LUXC1 fd index/base

### LW
###  - Load word
val / ['100011 /base /rt /offset16'] = binop LW rt offset16/base

### LWC1
###  - Load Word To Floating Point
val / ['110001 /base /ft /offset16'] = binop LWC1 ft offset16/base

### LWE
###  - Load Word EVA
val / ['011111 /base /rt /offset9 0 101111']
 | asmode? = nullop UNDEFINED
 | otherwise = binop LWE rt offset9/base

### MADD
###  - Multiply and Add Word to Hi,Lo
val / ['011100 /rs /rt 00000 00000 000000'] = binop MADD (right rs) (right rt) 

### MADD-fmt
###  - Floating Point Multiply Add
val / ['010011 /fr /ft /fs /fd 100 /fmt3sdps'] = quadop-fmt MADD-fmt fmt fd (right fr) (right fs) (right ft) 

### MADDU
###  - Multiply and Add Unsigned Word to Hi,Lo
val / ['011100 /rs /rt 00000 00000 000001'] = binop MADDU (right rs) (right rt) 

### MFC0
###  - Move from Coprocessor 0
val / ['010000 00000 /rt /rd 00000000 /sel'] = ternop MFC0 rt rd/imm sel 

### MFC1
###  - Move Word From Floating Point
val / ['010001 00000 /rt /fs 00000000000'] = binop MFC1 rt (right fs) 

### MFC2
###  - Move Word From Coprocessor 2
val / ['010010 00000 /rt /impl']
 | asimpl? = nullop UNDEFINED
 | otherwise = binop MFC2 rt impl 

### MFHC1
###  - Move Word From High Half of Floating Point Register
val / ['010001 00011 /rt /fs 00000000000'] = binop MFHC1 rt (right fs) 

### MFHC2
###  - Move Word From High Half of Coprocessor 2 Register
val / ['010010 00011 /rt /impl']
 | asimpl? = nullop UNDEFINED
 | otherwise = binop MFHC2 rt impl

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
val / ['000000 /rs /cc 0 0 /rd 00000 000001'] = ternop MOVF rd (right rs) (right fcc) 

### MOVF-fmt
###  - Floating Point Move Conditional on Floating Point False
val / ['010001 /fmt5sdps /cc 0 0 /fs /fd 010001'] = ternop-fmt MOVF-fmt fmt fd (right fs) (right fcc)

### MOVN
###  - Move Conditional on Not Zero
val / ['000000 /rs /rt /rd 00000 001011'] = ternop MOVN rd (right rs) (right rt) 

### MOVN-fmt
###  - Floating Point Move Conditional on Not Zero
val / ['010001 /fmt5sdps /rt /fs /fd 010011'] = ternop-fmt MOVN-fmt fmt fd (right fs) (right rt) 

### MOVT
###  - Move Conditional on Floating Point True
val / ['000000 /rs /cc 0 1 /rd 00000 000001'] = ternop MOVT rd (right rs) (right fcc) 

### MOVT-fmt
###  - Floating Point Move Conditional on Floating Point True
val / ['010001 /fmt5sdps /cc 0 1 /fs /fd 010001'] = ternop-fmt MOVT-fmt fmt fd (right fs) (right fcc)

### MOVZ
###  - Move Conditional on Not Zero
val / ['000000 /rs /rt /rd 00000 001010'] = ternop MOVZ rd (right rs) (right rt) 

### MOVZ-fmt
###  - Floating Point Move Conditional on Zero
val / ['010001 /fmt5sdps /rt /fs /fd 010010'] = ternop-fmt MOVZ-fmt fmt fd (right fs) (right rt) 

### MSUB
###  - Multiply and Subtract Word to Hi,Lo
val / ['011100 /rs /rt 00000 00000 000100'] = binop MSUB (right rs) (right rt) 

### MSUB-fmt
###  - Floating Point Multiply Subtract
val / ['010011 /fr /ft /fs /fd 101 /fmt3sdps'] = quadop-fmt MSUB-fmt fmt fd (right fr) (right fs) (right ft) 

### MSUBU
###  - Multiply and Subtract Word to Hi,Lo
val / ['011100 /rs /rt 00000 00000 000101'] = binop MSUBU (right rs) (right rt) 

### MTC0
###  - Move to Coprocessor 0
val / ['010000 00100 /rt /rd 00000000 /sel'] = ternop MTC0 (right rt) rd/imm sel 

### MTC1
###  - Move Word to Floating Point
val / ['010001 00100 /rt /fs 00000000000'] = binop MTC1 (right rt) fs

### MTC2
###  - Move Word to Coprocessor 2
val / ['010010 00100 /rt /impl']
 | asimpl? = nullop UNDEFINED
 | otherwise = binop MTC2 (right rt) impl 

### MTHC1
###  - Move Word to High Half of Floating Point Register
val / ['010001 00111 /rt /fs 00000000000'] = binop MTHC1 (right rt) fs

### MTHC2
###  - Move Word to High Half of Coprocessor 2 Register
val / ['010010 00111 /rt /impl']
 | asimpl? = nullop UNDEFINED
 | otherwise = binop MTHC2 (right rt) impl 

### MTHI
###  - Move To HI Register
val / ['000000 /rs 000000000000000 010001'] = unop MTHI (right rs) 

### MTLO
###  - Move To LO Register
val / ['000000 /rs 000000000000000 010011'] = unop MTLO (right rs) 

### MUL
###  - Multiply Word to GPR
val / ['011100 /rs /rt /rd 00000 000010'] = ternop MUL rd (right rs) (right rt) 

### MUL-fmt
###  - Floating Point Multiply
val / ['010001 /fmt5sdps /ft /fs /fd 000010'] = ternop-fmt MUL-fmt fmt fd (right fs) (right ft) 

### MULT
###  - Multiply Word
val / ['000000 /rs /rt 0000000000 011000'] = binop MULT (right rs) (right rt) 

### MULTU
###  - Multiply Unsigned Word
val / ['000000 /rs /rt 0000000000 011001'] = binop MULTU (right rs) (right rt) 

### NEG-fmt
###  - Floating Point Negate
val / ['010001 /fmt5sdps 00000 /fs /fd 000111'] = binop-fmt NEG-fmt fmt fd (right fs) 

### NMADD-fmt
###  - Floating Point Negative Multiply Add
val / ['010011 /fr /ft /fs /fd 110 /fmt3sdps'] = quadop-fmt NMADD-fmt fmt fd (right fr) (right fs) (right ft) 

### NMSUB-fmt
###  - Floating Point Negative Multiply Subtract
val / ['010011 /fr /ft /fs /fd 111 /fmt3sdps'] = quadop-fmt NMSUB-fmt fmt fd (right fr) (right fs) (right ft) 

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
val / ['001101 /rs /rt /immediate16'] = ternop ORI rt (right rs) immediate16 

### PAUSE
###  - Wait for the LLBit to clear
###  => see SLL r0, r0, 5

### PLL-PS
###  - Pair Lower Lower
val / ['010001 10110 /ft /fs /fd 101100'] = ternop PLL-PS fd (right fs) (right ft) 

### PLU-PS
###  - Pair Lower Upper
val / ['010001 10110 /ft /fs /fd 101101'] = ternop PLU-PS fd (right fs) (right ft) 

### PREF
###  - Prefetch
val / ['110011 /base /hint5 /offset16'] = binop PREF hint5 offset16/base

### PREFE
###  - Prefetch EVA
val / ['011111 /base /hint5 /offset9 0 100011']
 | asmode? = nullop UNDEFINED
 | otherwise = binop PREFE hint5 offset9/base

### PREFX
###  - Prefetch Indexed
val / ['010011 /base /index /hint5 00000 001111'] = binop PREFX hint5 index/base 

### PUL-PS
###  - Pair Upper Lower
val / ['010001 10110 /ft /fs /fd 101110'] = ternop PUL-PS fd (right fs) (right ft) 

### PUU-PS
###  - Pair Upper Upper
val / ['010001 10110 /ft /fs /fd 101111'] = ternop PUU-PS fd (right fs) (right ft) 

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
val / ['000000 /rs /rt /rd 0000 1 000110'] = ternop ROTRV rd (right rt) (right rs) 

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
val / ['101000 /base /rt /offset16'] = binop SB (right rt) offset16/base

### SBE
###  - Store Byte EVA
val / ['011111 /base /rt /offset9 0 011100']
 | asmode? = nullop UNDEFINED
 | otherwise = binop SBE (right rt) offset9/base 

### SC
###  - Store Conditional Word
val / ['111000 /base /rt /offset16'] = binop SC rt offset16/base

### SCE
###  - Store Conditional Word EVA
val / ['011111 /base /rt /offset9 0 011110']
 | asmode? = nullop UNDEFINED
 | otherwise = binop SCE rt offset9/base

### SDBBP
###  - Software Debug Breakpoint
val / ['011100 /code20 111111'] = unop SDBBP code20 

### SDC1
###  - Store Doubleword from Floating Point
val / ['111101 /base /ft /offset16'] = binop SDC1 (right ft) offset16/base

### SDC2
###  - Store Doubleword from Coprocessor 2
val / ['111110 /base /rt /offset16'] = binop SDC2 rt/imm offset16/base 

### SDXC1
###  - Store Doubleword Indexed from Floating Point
val / ['010011 /base /index /fs 00000 001001'] = binop SDXC1 (right fs) index/base

### SEB
###  - Sign-Extend Byte
val / ['011111 00000 /rt /rd 10000 100000'] = binop SEB rd (right rt) 

### SEH
###  - Sign-Extend Halfword
val / ['011111 00000 /rt /rd 11000 100000'] = binop SEH rd (right rt) 

### SH
###  - Store Halfword
val / ['101001 /base /rt /offset16'] = binop SH (right rt) offset16/base 

### SHE
###  - Store Halfword EVA
val / ['011111 /base /rt /offset9 0 011101']
 | asmode? = nullop UNDEFINED
 | otherwise = binop SHE (right rt) offset9/base 

### SLL
###  - Shift Word Left Logical
val / ['000000 00000 /rt /rd /sa 000000']
 | pause? = nullop PAUSE
 | otherwise = ternop SLL rd (right rt) sa

### SLLV
###  - Shift Word Left Logical Variable
val / ['000000 /rs /rt /rd 00000 000100'] = ternop SLLV rd (right rt) (right rs)

### SLT
###  - Set On Less Than
val / ['000000 /rs /rt /rd 00000 101010'] = ternop SLT rd (right rs) (right rt) 

### SLTI
###  - Set on Less Than Immediate
val / ['001010 /rs /rt /immediate16'] = ternop SLTI rt (right rs) immediate16 

### SLTIU
###  - Set on Less Than Immediate Unsigned
val / ['001011 /rs /rt /immediate16'] = ternop SLTIU rt (right rs) immediate16 

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
val / ['000000 /rs /rt /rd 00000 000111'] = ternop SRAV rd (right rt) (right rs) 

### SRL
###  - Shift Word Right Logical
val / ['000000 0000 0 /rt /rd /sa 000010'] = ternop SRL rd (right rt) sa 

### SRLV
###  - Shift Word Right Logical Variable
val / ['000000 /rs /rt /rd 0000 0 000110'] = ternop SRLV rd (right rt) (right rs) 

### SSNOP
###  - Superscalar No Operation
###  => see SLL r0, r0, 1

### SUB
###  - Subtract Word
val / ['000000 /rs /rt /rd 00000 100010'] = ternop SUB rd (right rs) (right rt) 

### SUB-fmt
###  - Floating Point Subtract
val / ['010001 /fmt5sdps /ft /fs /fd 000001'] = ternop-fmt SUB-fmt fmt fd (right fs) (right ft) 

### SUBU
###  - Subtract Unsigned Word
val / ['000000 /rs /rt /rd 00000 100011'] = ternop SUBU rd (right rs) (right rt) 

### SUXC1
###  - Store Doubleword Indexed Unaligned from Floating Point
val / ['010011 /base /index /fs 00000 001101'] = binop SUXC1 (right fs) index/base

### SW
###  - Store Word
val / ['101011 /base /rt /offset16'] = binop SW (right rt) offset16/base

### SWC1
###  - Store Word from Floating Point
val / ['111001 /base /ft /offset16'] = binop SWC1 (right ft) offset16/base

### SWE
###  - Store Word EVA
val / ['011111 /base /rt /offset9 0 011111']
 | asmode? = nullop UNDEFINED
 | otherwise = binop SWE (right rt) offset9/base 

### SWL
###  - Store Word Left
val / ['101010 /base /rt /offset16'] = binop SWL (right rt) offset16/base 

### SWLE
###  - Store Word Left EVA
val / ['011111 /base /rt /offset9 0 100001']
 | asmode? = nullop UNDEFINED
 | otherwise = binop SWLE (right rt) offset9/base 

### SWR
###  - Store Word Right
val / ['101110 /base /rt /offset16'] = binop SWR (right rt) offset16/base 

### SWRE
###  - Store Word Right EVA
val / ['011111 /base /rt /offset9 0 100010']
 | asmode? = nullop UNDEFINED
 | otherwise = binop SWRE (right rt) offset9/base 

### SWXC1
###  - Store Word Indexed from Floating Point
val / ['010011 /base /index /fs 00000 001000'] = binop SWXC1 (right fs) index/base

### SYNC
###  - Synchronize Shared Memory
val / ['000000 000000000000000 /stype 001111'] = unop SYNC stype 

### SYNCI
###  - Synchronize Caches to Make Instruction Writes Effective
val / ['000001 /base 11111 /offset16'] = unop SYNCI offset16/base

### SYSCALL
###  - System Call
val / ['000000 /code20 001100'] = unop SYSCALL code20 

### TEQ
###  - Trap if Equal
val / ['000000 /rs /rt /code10 110100'] = ternop TEQ (right rs) (right rt) code10 

### TEQI
###  - Trap if Equal Immediate
val / ['000001 /rs 01100 /immediate16'] = binop TEQI (right rs) immediate16 

### TGE
###  - Trap if Greater or Equal
val / ['000000 /rs /rt /code10 110000'] = ternop TGE (right rs) (right rt) code10 

### TGEI
###  - Trap if Greater or Equal Immediate
val / ['000001 /rs 01000 /immediate16'] = binop TGEI (right rs) immediate16 

### TGEIU
###  - Trap if Greater or Equal Immediate Unsigned
val / ['000001 /rs 01001 /immediate16'] = binop TGEIU (right rs) immediate16 

### TGEU
###  - Trap if Greater or Equal Unsigned
val / ['000000 /rs /rt /code10 110001'] = ternop TGEU (right rs) (right rt) code10 

### TLBINV
###  - TLB Invalidate
val / ['010000 1 0000000000000000000 000011']
 | asmode? = nullop UNDEFINED
 | otherwise = nullop TLBINV 

### TLBINVF
###  - TLB Invalidate Flush
val / ['010000 1 0000000000000000000 000100']
 | asmode? = nullop UNDEFINED
 | otherwise = nullop TLBINVF 

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
val / ['000000 /rs /rt /code10 110010'] = ternop TLT (right rs) (right rt) code10 

### TLTI
###  - Trap if Less Than Immediate
val / ['000001 /rs 01010 /immediate16'] = binop TLTI (right rs) immediate16 

### TLTIU
###  - Trap if Less Than Immediate Unsigned
val / ['000001 /rs 01011 /immediate16'] = binop TLTIU (right rs) immediate16 

### TLTU
###  - Trap if Less Than Unsigned
val / ['000000 /rs /rt /code10 110011'] = ternop TLTU (right rs) (right rt) code10 

### TNE
###  - Trap if Not Equal
val / ['000000 /rs /rt /code10 110110'] = ternop TNE (right rs) (right rt) code10 

### TNEI
###  - Trap if Not Equal Immediate
val / ['000001 /rs 01110 /immediate16'] = binop TNEI (right rs) immediate16 

### TRUNC-L-fmt
###  - Floating Point Truncate to Long Fixed Point
val / ['010001 /fmt5sd 00000 /fs /fd 001001'] = binop-fmt TRUNC-L-fmt fmt fd (right fs) 

### TRUNC-W-fmt
###  - Floating Point Truncate to Word Fixed Point
val / ['010001 /fmt5sd 00000 /fs /fd 001101'] = binop-fmt TRUNC-W-fmt fmt fd (right fs) 

### WAIT
###  - Enter Standby Mode
val / ['010000 1 /code19 100000'] = unop WAIT code19 

### WRPGPR
###  - Write to GPR in Previous Shadow Set
val / ['010000 01110 /rt /rd 00000000000'] = binop WRPGPR rd/imm (right rt)

### WSBH
###  - Word Swap Bytes Within Halfwords
val / ['011111 00000 /rt /rd 00010 100000'] = binop WSBH rd (right rt) 

### XOR
###  - Exclusive OR
val / ['000000 /rs /rt /rd 00000 100110'] = ternop XOR rd (right rs) (right rt) 

### XORI
###  - Exclusive OR Immediate
val / ['001110 /rs /rt /immediate16'] = ternop XORI rt (right rs) immediate16 

### UNDEFINED
### - Undefined Instruction
### val / [] = nullop UNDEFINED


###########################
# operand decoders
####

val /rs ['rs:5'] = update@{rs=rs}
val /rt ['rt:5'] = update@{rt=rt}
val /rd ['rd:5'] = update@{rd=rd}
val /fr ['fr:5'] = update@{fr=fr}
val /fs ['fs:5'] = update@{fs=fs}
val /ft ['ft:5'] = update@{ft=ft}
val /fd ['fd:5'] = update@{fd=fd}
val /immediate16 ['immediate16:16'] = update@{immediate16=immediate16}
val /offset9 ['offset9:9'] = update@{offset9=offset9}
val /offset16 ['offset16:16'] = update@{offset16=offset16}
val /base ['base:5'] = update@{base=base}
val /index ['index:5'] = update@{index=index}
val /sel ['sel:3'] = update@{sel=sel}
val /impl ['impl:16'] = update@{impl=impl}
val /code10 ['code10:10'] = update@{code10=code10}
val /code10to20 ['code10to20:10'] = update@{code10to20=code10to20}
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
val /fmt5sd ['10 /fmt3sd'] = return void
val /fmt5dwl ['10001'] = update@{fmt=D}
val /fmt5dwl ['10100'] = update@{fmt=W}
val /fmt5dwl ['10101'] = update@{fmt=L}
val /fmt5swl ['10000'] = update@{fmt=S}
val /fmt5swl ['10100'] = update@{fmt=W}
val /fmt5swl ['10101'] = update@{fmt=L}
val /fmt3sd ['000'] = update@{fmt=S}
val /fmt3sd ['001'] = update@{fmt=D}


###########################
# operand constructors
####

val rs = do
  rs <- query $rs;
  return (GPR (gpr-from-bits rs))
end

val rt = do
  rt <- query $rt;
  return (GPR (gpr-from-bits rt))
end

val rd = do
  rd <- query $rd;
  return (GPR (gpr-from-bits rd))
end

val rd/imm = do
  rd <- query $rd;
  return (IMM (RTRD5 rd))
end

val rt/imm = do
  rt <- query $rt;
  return (IMM (RTRD5 rt))
end

val fr = do
  fr <- query $fr;
  return (FPR (fpr-from-bits fr))
end

val fs = do
  fs <- query $fs;
  return (FPR (fpr-from-bits fs))
end

val ft = do
  ft <- query $ft;
  return (FPR (fpr-from-bits ft))
end

val fd = do
  fd <- query $fd;
  return (FPR (fpr-from-bits fd))
end

val fs/ctrl = do
  fs <- query $fs;
  return (IMM (FSCTRL5 fs))
end

val immediate16 = do
  immediate16 <- query $immediate16;
  return (IMM (IMM16 immediate16))
end

val offset9 = do
  offset9 <- query $offset9;
  return (IMM (OFFSET9 offset9))
end

val offset16 = do
  offset16 <- query $offset16;
  return (IMM (OFFSET16 offset16))
end

val offset18 = do
  offset16 <- query $offset16;
  return (IMM (OFFSET18 (offset16 ^ '00')))
end

val sel = do
  sel <- query $sel;
  return (IMM (SEL sel))
end

val impl = do
  impl <- query $impl;
  return (IMM (IMPL impl))
end

val code10 = do
  code10 <- query $code10;
  return (IMM (CODE10 code10))
end

val code10to20 = do
  code10 <- query $code10;
  code10to20 <- query $code10to20;
  return (IMM (CODE20 (code10 ^ code10to20)))
end

val code19 = do
  code19 <- query $code19;
  return (IMM (CODE19 code19))
end

val code20 = do
  code20 <- query $code20;
  return (IMM (CODE20 code20))
end

val stype = do
  stype <- query $stype;
  return (IMM (STYPE stype))
end

val msbd = do
  msbd <- query $msbd;
  return (IMM (MSBD msbd))
end

val lsb = do
  lsb <- query $lsb;
  return (IMM (LSB lsb))
end

val sa = do
  sa <- query $sa;
  return (IMM (IMM5 sa))
end

val instr_index = do
  instr_index <- query $instr_index;
  return (IMM (INSTRINDEX28 (instr_index ^ '00')))
end

val cofun = do
  cofun <- query $cofun;
  return (IMM (COFUN cofun))
end

val fcc = do
  cc <- query $cc;
  return (FCC (fcc-from-bits cc))
end

val c2cc = do
  cc <- query $cc;
  return (C2CC (c2cc-from-bits cc))
end

val cond = do
  cond <- query $cond;
  return (cond-from-bits (cond))
end

val op = do
  op <- query $op;
  return (IMM (OP op))
end

val hint5 = do
  hint <- query $hint;
  return (IMM (HINT hint))
end

val fmt = do
  fmt <- query $fmt;
  return fmt
end

############################
# tuple constructors
####

val offset9/base = do
  offset9 <- query $offset9;
  base <- query $base;
  return (OFFSET/BASE {offset=(OFFSET9 offset9), base=(gpr-from-bits base)})
end

val offset16/base = do
  offset16 <- query $offset16;
  base <- query $base;
  return (OFFSET/BASE {offset=(OFFSET16 offset16), base=(gpr-from-bits base)})
end

val index/base = do
  index <- query $index;
  base <- query $base;
  return (INDEX/BASE {index=(gpr-from-bits index), base=(gpr-from-bits base)})
end

val msb/lsb = do
  msb <- query $msb;
  lsb <- query $lsb;
  return (MSB/LSB {msb=(MSB msb), lsb=(LSB lsb)})
end


####################################################################
### operation type followed by letters expr. the operand types
### - l for lvalue
### - r for rvalue
### - f for format
### - c for cond
######################

type unop-r = {op:rvalue}
type unop-l = {op:lvalue}
type binop-rr = {op1:rvalue, op2:rvalue}
type binop-rl = {op1:rvalue, op2:lvalue}
type binop-lr = {op1:lvalue, op2:rvalue}
type binop-flr = {fmt:format, op1:lvalue, op2:rvalue}
type ternop-rrr = {op1:rvalue, op2:rvalue, op3:rvalue}
type ternop-lrr = {op1:lvalue, op2:rvalue, op3:rvalue}
type ternop-flrr = {fmt:format, op1:lvalue, op2:rvalue, op3:rvalue}
type ternop-cflrr = {cond:condop, fmt:format, op1:lvalue, op2:rvalue, op3:rvalue}
type quadop-lrrr = {op1:lvalue, op2:rvalue, op3:rvalue, op4:rvalue}
type quadop-flrrr = {fmt:format, op1:lvalue, op2:rvalue, op3:rvalue, op4:rvalue}


val nullop cons = do
 return cons
end

val unop cons getOp = do
 op <- getOp;
 return (cons {op=op})
end

val binop cons getOp1 getOp2 = do
 op1 <- getOp1;
 op2 <- getOp2;
 return (cons {op1=op1, op2=op2})
end

val binop-fmt cons getFMT getOp1 getOp2 = do
 fmt <- getFMT;
 op1 <- getOp1;
 op2 <- getOp2;
 return (cons {fmt=fmt, op1=op1, op2=op2})
end

val ternop cons getOp1 getOp2 getOp3 = do
 op1 <- getOp1;
 op2 <- getOp2;
 op3 <- getOp3;
 return (cons {op1=op1, op2=op2, op3=op3})
end

val ternop-fmt cons getFMT getOp1 getOp2 getOp3 = do
 fmt <- getFMT;
 op1 <- getOp1;
 op2 <- getOp2;
 op3 <- getOp3;
 return (cons {fmt=fmt, op1=op1, op2=op2, op3=op3})
end

val ternop-cond-fmt cons getCond getFMT getOp1 getOp2 getOp3 = do
 cond <- getCond;
 fmt <- getFMT;
 op1 <- getOp1;
 op2 <- getOp2;
 op3 <- getOp3;
 return (cons {cond=cond, fmt=fmt, op1=op1, op2=op2, op3=op3})
end

val quadop cons getOp1 getOp2 getOp3 getOp4 = do
 op1 <- getOp1;
 op2 <- getOp2;
 op3 <- getOp3;
 op4 <- getOp4;
 return (cons {op1=op1, op2=op2, op3=op3, op4=op4})
end

val quadop-fmt cons getFMT getOp1 getOp2 getOp3 getOp4 = do
 fmt <- getFMT;
 op1 <- getOp1;
 op2 <- getOp2;
 op3 <- getOp3;
 op4 <- getOp4;
 return (cons {fmt=fmt, op1=op1, op2=op2, op3=op3, op4=op4})
end


type instruction = 
   UNPREDICTABLE
 | UNDEFINED
 | ABS-fmt of binop-flr
 | ADD of ternop-lrr
 | ADD-fmt of ternop-flrr
 | ADDIU of ternop-lrr
 | ADDU of ternop-lrr
 | AND of ternop-lrr
 | ANDI of ternop-lrr
 | BEQ of ternop-rrr
 | BGEZ of binop-rr
 | BGTZ of binop-rr
 | BLEZ of binop-rr
 | BLTZ of binop-rr
 | BNE of ternop-rrr
 | BREAK of unop-r
 | C-cond-fmt of ternop-cflrr
 | CACHE of binop-rr
 | CACHEE of binop-rr
 | CEIL-L-fmt of binop-flr
 | CEIL-W-fmt of binop-flr
 | CFC1 of binop-lr
 | CFC2 of binop-lr
 | CLO of binop-lr
 | CLZ of binop-lr
 | COP2 of unop-r
 | CTC1 of binop-rr
 | CTC2 of binop-rr
 | CVT-D-fmt of binop-flr
 | CVT-L-fmt of binop-flr
 | CVT-PS-S of ternop-lrr
 | CVT-S-fmt of binop-flr
 | CVT-S-PL of binop-lr
 | CVT-S-PU of binop-lr
 | CVT-W-fmt of binop-flr
 | DERET
 | DI of unop-l
 | DIV of binop-rr
 | DIV-fmt of ternop-flrr
 | DIVU of binop-rr
 | EI of unop-l
 | ERET
 | EXT of quadop-lrrr
 | FLOOR-L-fmt of binop-flr
 | FLOOR-W-fmt of binop-flr
 | INS of ternop-lrr
 | J of unop-r
 | JAL of unop-r
 | JALR of binop-lr
 | JALR-HB of binop-lr
 | JALX of unop-r
 | JR of unop-r
 | JR-HB of unop-r
 | LB of binop-lr
 | LBE of binop-lr
 | LBU of binop-lr
 | LBUE of binop-lr
 | LDC1 of binop-lr
 | LDC2 of binop-rr
 | LDXC1 of binop-lr
 | LH of binop-lr
 | LHE of binop-lr
 | LHU of binop-lr
 | LHUE of binop-lr
 | LL of binop-lr
 | LLE of binop-lr
 | LUI of binop-lr
 | LUXC1 of binop-lr
 | LW of binop-lr
 | LWC1 of binop-lr
 | LWE of binop-lr
 | MADD of binop-rr
 | MADD-fmt of quadop-flrrr
 | MADDU of binop-rr
 | MFC0 of ternop-lrr
 | MFC1 of binop-lr
 | MFC2 of binop-lr
 | MFHC1 of binop-lr
 | MFHC2 of binop-lr
 | MFHI of unop-l
 | MFLO of unop-l
 | MOV-fmt of binop-flr
 | MOVF of ternop-lrr
 | MOVF-fmt of ternop-flrr
 | MOVN of ternop-lrr
 | MOVN-fmt of ternop-flrr
 | MOVT of ternop-lrr
 | MOVT-fmt of ternop-flrr
 | MOVZ of ternop-lrr
 | MOVZ-fmt of ternop-flrr
 | MSUB of binop-rr
 | MSUB-fmt of quadop-flrrr
 | MSUBU of binop-rr
 | MTC0 of ternop-rrr
 | MTC1 of binop-rl
 | MTC2 of binop-rr
 | MTHC1 of binop-rl
 | MTHC2 of binop-rr
 | MTHI of unop-r
 | MTLO of unop-r
 | MUL of ternop-lrr
 | MUL-fmt of ternop-flrr
 | MULT of binop-rr
 | MULTU of binop-rr
 | NEG-fmt of binop-flr
 | NMADD-fmt of quadop-flrrr
 | NMSUB-fmt of quadop-flrrr
 | NOR of ternop-lrr
 | OR of ternop-lrr
 | ORI of ternop-lrr
 | PAUSE
 | PLL-PS of ternop-lrr
 | PLU-PS of ternop-lrr
 | PREF of binop-rr
 | PREFE of binop-rr
 | PREFX of binop-rr
 | PUL-PS of ternop-lrr
 | PUU-PS of ternop-lrr
 | RDHWR of binop-lr
 | RDPGPR of binop-lr
 | RECIP-fmt of binop-flr
 | ROTR of ternop-lrr
 | ROTRV of ternop-lrr
 | ROUND-L-fmt of binop-flr
 | ROUND-W-fmt of binop-flr
 | RSQRT-fmt of binop-flr
 | SB of binop-rr
 | SBE of binop-rr
 | SC of binop-lr
 | SCE of binop-lr
 | SDBBP of unop-r
 | SDC1 of binop-rr
 | SDC2 of binop-rr
 | SDXC1 of binop-rr
 | SEB of binop-lr
 | SEH of binop-lr
 | SH of binop-rr
 | SHE of binop-rr
 | SLL of ternop-lrr
 | SLLV of ternop-lrr
 | SLT of ternop-lrr
 | SLTI of ternop-lrr
 | SLTIU of ternop-lrr
 | SLTU of ternop-lrr
 | SQRT-fmt of binop-flr
 | SRA of ternop-lrr
 | SRAV of ternop-lrr
 | SRL of ternop-lrr
 | SRLV of ternop-lrr
 | SUB of ternop-lrr
 | SUB-fmt of ternop-flrr
 | SUBU of ternop-lrr
 | SUXC1 of binop-rr
 | SW of binop-rr
 | SWC1 of binop-rr
 | SWC2 of binop-rr
 | SWE of binop-rr
 | SWL of binop-rr
 | SWLE of binop-rr
 | SWR of binop-rr
 | SWRE of binop-rr
 | SWXC1 of binop-rr
 | SYNC of unop-r
 | SYNCI of unop-r
 | SYSCALL of unop-r
 | TEQ of ternop-rrr
 | TEQI of binop-rr
 | TGE of ternop-rrr
 | TGEI of binop-rr
 | TGEIU of binop-rr
 | TGEU of ternop-rrr
 | TLBINV
 | TLBINVF
 | TLBP
 | TLBR
 | TLBWI
 | TLBWR
 | TLT of ternop-rrr
 | TLTI of binop-rr
 | TLTIU of binop-rr
 | TLTU of ternop-rrr
 | TNE of ternop-rrr
 | TNEI of binop-rr
 | TRUNC-L-fmt of binop-flr
 | TRUNC-W-fmt of binop-flr
 | WAIT of unop-r
 | WRPGPR of binop-rr
 | WSBH of binop-lr
 | XOR of ternop-lrr
 | XORI of ternop-lrr


################################
# all required immediate types
####

type imm =
   IMM5 of 5
 | IMM16 of 16
 | RTRD5 of 5
 | FSCTRL5 of 5
 | OFFSET9 of 9
 | OFFSET16 of 16
 | OFFSET18 of 18
 | SEL of 3
 | IMPL of 16
 | CODE10 of 10
 | CODE19 of 19
 | CODE20 of 20
 | STYPE of 5
 | MSB of 5
 | MSBD of 5
 | LSB of 5
 | HINT of 5
 | INSTRINDEX28 of 28
 | COFUN of 25
 | OP of 5


#############################
# general purpose registers
####

type gpr-register =
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


#############################
# special purpose registers
####

type sp-register =
   HI
 | LO
 | PC
 | SREG


#############################
# floating point registers
####

type fpr-register =
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


#####################################
# floating point control registers
####

type fcr-register =
   FCCR
 | FEXR
 | FENR
 | FCSR
 | FIR

##############################################
# helpers to assign bit vectors to a register,
# condition or a format
####

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

val fcc-from-bits bits =
 case bits of
    '000': FCC0
  | '001': FCC1
  | '010': FCC2
  | '011': FCC3
  | '100': FCC4
  | '101': FCC5
  | '110': FCC6
  | '111': FCC7
 end

val c2cc-from-bits bits =
 case bits of
    '000': C2CC0
  | '001': C2CC1
  | '010': C2CC2
  | '011': C2CC3
  | '100': C2CC4
  | '101': C2CC5
  | '110': C2CC6
  | '111': C2CC7
 end

val cond-from-bits bits =
 case bits of
    '0000': C_F
  | '0001': C_UN
  | '0010': C_EQ
  | '0011': C_UEQ
  | '0100': C_OLT
  | '0101': C_ULT
  | '0110': C_OLE
  | '0111': C_ULE
  | '1000': C_SF
  | '1001': C_NGLE
  | '1010': C_SEQ
  | '1011': C_NGL
  | '1100': C_LT
  | '1101': C_NGE
  | '1110': C_LE
  | '1111': C_NGT
 end
