####################################################################
###                    DECODER FOR REVISION 5                    ###
####################################################################


######################
# decoder rules
####

### ABS-fmt
###  - Floating Point Absolute Value
val / ['010001 /fmt5sdps 00000 /fs /fd 000101'] = binop-fmt ABS-fmt fmt fd (right fs) 

### ADD-fmt
###  - Floating Point Add
val / ['010001 /fmt5sdps /ft /fs /fd 000000'] = ternop-fmt ADD-fmt fmt fd (right fs) (right ft) 

### ADDI
###  - Add Immediate Word
val / ['001000 /rs /rt /immediate16'] = ternop ADDI rt (right rs) immediate16 

### ALNV-PS
###  - Floating Point Align Variable
val / ['010011 /rs /ft /fs /fd 011110'] = quadop ALNV-PS fd (right fs) (right ft) (right rs) 

### BC1F
###  - Branch on FP False
val / ['010001 01000 /cc 0 0 /offset16'] = binop BC1F (right fcc) offset18 

### BC1FL
###  - Branch on FP False Likely
val / ['010001 01000 /cc 1 0 /offset16'] = binop BC1FL (right fcc) offset18 

### BC1T
###  - Branch on FP True
val / ['010001 01000 /cc 0 1 /offset16'] = binop BC1T (right fcc) offset18 

### BC1TL
###  - Branch on FP True Likely
val / ['010001 01000 /cc 1 1 /offset16'] = binop BC1TL (right fcc) offset18 

### BC2F
###  - Branch on COP2 False
val / ['010010 01000 /cc 0 0 /offset16'] = binop BC2F (right c2cc) offset18 

### BC2FL
###  - Branch on COP2 False Likely
val / ['010010 01000 /cc 1 0 /offset16'] = binop BC2FL (right c2cc) offset18 

### BC2T
###  - Branch on COP2 True
val / ['010010 01000 /cc 0 1 /offset16'] = binop BC2T (right c2cc) offset18 

### BC2TL
###  - Branch on COP2 True Likely
val / ['010010 01000 /cc 1 1 /offset16'] = binop BC2TL (right c2cc) offset18 

### BEQL
###  - Branch on Equal Likely
val / ['010100 /rs /rt /offset16'] = ternop BEQL (right rs) (right rt) offset18

### BGEZAL
###  - Branch on Greater Than or Equal to Zero and Link
val / ['000001 /rs 10001 /offset16'] = binop BGEZAL (right rs) offset18

### BGEZALL
###  - Branch on Greater Than or Equal to Zero and Link Likely
val / ['000001 /rs 10011 /offset16'] = binop BGEZALL (right rs) offset18

### BGEZL
###  - Branch on Greater Than or Equal to Zero Likely
val / ['000001 /rs 00011 /offset16'] = binop BGEZL (right rs) offset18

### BGTZ
###  - Branch on Greater Than Zero
val / ['000111 /rs 00000 /offset16'] = binop BGTZ (right rs) offset18

### BGTZL
###  - Branch on Greater Than Zero Likely
val / ['010111 /rs 00000 /offset16'] = binop BGTZL (right rs) offset18

### BLEZ
###  - Branch on Less Than or Equal to Zero
val / ['000110 /rs 00000 /offset16'] = binop BLEZ (right rs) offset18

### BLEZL
###  - Branch on Less Than or Equal to Zero Likely
val / ['010110 /rs 00000 /offset16'] = binop BLEZL (right rs) offset18

### BLTZAL
###  - Branch on Less Than Zero And Link
val / ['000001 /rs 10000 /offset16'] = binop BLTZAL (right rs) offset18

### BLTZALL
###  - Branch on Less Than Zero And Link Likely
val / ['000001 /rs 10010 /offset16'] = binop BLTZALL (right rs) offset18

### BLTZL
###  - Branch on Less Than Zero Likely
val / ['000001 /rs 00010 /offset16'] = binop BLTZL (right rs) offset18

### BNEL
###  - Branch on Not Equal Likely
val / ['010101 /rs /rt /offset16'] = ternop BNEL (right rs) (right rt) offset18

### CACHE
###  - Perform Cache Operation
val / ['101111 /base /op /offset16'] = binop CACHE op offset16/base

### C-cond-fmt
###  - Floating Point Compare
val / ['010001 /fmt5sdps /ft /fs /cc 0 0 11 /cond'] = ternop-cond-fmt C-cond-fmt cond fmt fcc (right fs) (right ft)

### CVT-PS-S
###  - Floating Point Convert Pair to Paired Single
val / ['010001 10000 /ft /fs /fd 100110'] = ternop CVT-PS-S fd (right fs) (right ft) 

### CVT-S-PL
###  - Floating Point Convert Pair Lower to Single Floating Point
val / ['010001 10110 00000 /fs /fd 101000'] = binop CVT-S-PL fd (right fs) 

### CVT-S-PU
###  - Floating Point Convert Pair Upper to Single Floating Point
val / ['010001 10110 00000 /fs /fd 100000'] = binop CVT-S-PU fd (right fs) 

### DIV
###  - Divide Word
val / ['000000 /rs /rt 0000000000 011010'] = binop DIV (right rs) (right rt) 

### DIVU
###  - Divide Unsigned Word
val / ['000000 /rs /rt 0000000000 011011'] = binop DIVU (right rs) (right rt) 

### LDC2
###  - Load Doubleword to Coprocessor 2
val / ['110110 /base /rt /offset16'] = binop LDC2 rt/imm offset16/base 

### LUI
###  - Load Upper Immediate
val / ['001111 00000 /rt /immediate16'] = binop LUI rt immediate16 

### LWC2
###  - Load Word to Coprocessor 2
val / ['110010 /base /rt /offset16'] = binop LWC2 rt/imm offset16/base 

### LWL
###  - Load Word Left
val / ['100010 /base /rt /offset16'] = binop LWL rt offset16/base

### LWLE
###  - Load Word Left EVA
val / ['011111 /base /rt /offset9 0 011001']
 | asmode? = nullop UNDEFINED
 | otherwise = binop LWLE rt offset9/base

### LWR
###  - Load Word Right
val / ['100110 /base /rt /offset16'] = binop LWR rt offset16/base

### LWRE
###  - Load Word Right EVA
val / ['011111 /base /rt /offset9 0 011010']
 | asmode? = nullop UNDEFINED
 | otherwise = binop LWRE rt offset9/base

### LWXC1
###  - Load Word Indexed to Floating Point
val / ['010011 /base /index 00000 /fd 000000'] = binop LWXC1 fd index/base

### SDC2
###  - Store Doubleword from Coprocessor 2
val / ['111110 /base /rt /offset16'] = binop SDC2 rt/imm offset16/base 

### SWC2
###  - Store Word from Coprocessor 2
val / ['111010 /base /rt /offset16'] = binop SWC2 rt/imm offset16/base


type instruction =
   ADDI of ternop-lrr
 | ALNV-PS of quadop-lrrr
 | BC1F of binop-rr
 | BC1FL of binop-rr
 | BC1T of binop-rr
 | BC1TL of binop-rr
 | BC2F of binop-rr
 | BC2FL of binop-rr
 | BC2T of binop-rr
 | BC2TL of binop-rr
 | BEQL of ternop-rrr
 | BGEZAL of binop-rr
 | BGEZALL of binop-rr
 | BGEZL of binop-rr
 | BGTZL of binop-rr
 | BLEZL of binop-rr
 | BLTZAL of binop-rr
 | BLTZALL of binop-rr
 | BLTZL of binop-rr
 | BNEL of ternop-rrr
 | C-cond-fmt of ternop-cflrr
 | CVT-PS-S of ternop-lrr
 | CVT-S-PL of binop-lr
 | CVT-S-PU of binop-lr
 | DIV of binop-rr
 | DIVU of binop-rr
 | LDC2 of binop-rr
 | LWC2 of binop-rr
 | LWL of binop-lr
 | LWLE of binop-lr
 | LWR of binop-lr
 | LWRE of binop-lr
 | LWXC1 of binop-lr
 | SDC2 of binop-rr

type format = 
   PS

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

val /cond ['cond:4'] = update@{cond=cond}
val /fmt5sdps ['10 /fmt3sdps'] = return void
val /fmt3sdps [/fmt3sd] = return void
val /fmt3sdps ['110'] = update@{fmt=PS}

val cond = do
  cond <- query $cond;
  return (cond-from-bits (cond))
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
