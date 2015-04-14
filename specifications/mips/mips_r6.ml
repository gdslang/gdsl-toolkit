####################################################################
###                    DECODER FOR REVISION 6                    ###
####################################################################

######################
# guard conditions
####

val bgtz? s = (s.rt == '00000')
val bgtzalc? s = (s.rs == '00000') and (not (s.rt == '00000'))
val bgezalc? s = (s.rs == s.rt) and (not (s.rs == '00000')) 
val blez? s = (s.rt == '00000')
val blezalc? s = (s.rs == '00000') and (not (s.rt == '00000'))
val bltzalc? s = (s.rs == s.rt) and (not (s.rs == '00000'))
val beqzalc? s = ((zx s.rs) < (zx s.rt)) and (s.rs == '00000') and (not (s.rt == '00000'))
val bnezalc? s = ((zx s.rs) < (zx s.rt)) and (s.rs == '00000') and (not (s.rt == '00000'))
val blezc? s = (s.rs == '00000') and (not (s.rt == '00000')) 
val bgezc? s = (s.rs == s.rt) and (not (s.rs == '00000')) and (not (s.rt == '00000'))
val bgec? s = (not (s.rs == s.rt)) and (not (s.rs == '00000')) and (not (s.rt == '00000'))
val bgtzc? s = (s.rs == '00000') and (not (s.rt == '00000')) 
val bltzc? s = (s.rs == s.rt) and (not (s.rs == '00000')) and (not (s.rt == '00000'))
val bltc? s = (not (s.rs == s.rt)) and (not (s.rs == '00000')) and (not (s.rt == '00000'))
val bgeuc? s = (not (s.rs == s.rt)) and (not (s.rs == '00000')) and (not (s.rt == '00000'))
val bltuc? s = (not (s.rs == s.rt)) and (not (s.rs == '00000')) and (not (s.rt == '00000'))
val beqc? s = ((zx s.rs) < (zx s.rt)) and (not (s.rs == '00000')) and (not (s.rt == '00000'))
val bnec? s = ((zx s.rs) < (zx s.rt)) and (not (s.rs == '00000')) and (not (s.rt == '00000'))
val bovc? s = ((zx s.rs) >= (zx s.rt))
val bnvc? s = ((zx s.rs) >= (zx s.rt))


######################
# decoder rules
####

### ABS-fmt
###  - Floating Point Absolute Value
val / ['010001 /fmt5sd 00000 /fs /fd 000101'] = binop-fmt ABS-fmt fmt fd (right fs) 

### ADD-fmt
###  - Floating Point Add
val / ['010001 /fmt5sd /ft /fs /fd 000000'] = ternop-fmt ADD-fmt fmt fd (right fs) (right ft) 

### ADDIUPC
###  - Add Immediate to PC (unsigned - non-trapping)
val / ['111011 /rs 00 /immediate19'] = binop ADDIUPC rs immediate21

### ALIGN
###  - Concatenate two GPRs, and extract a contiguous subset at a byte position
val / ['011111 /rs /rt /rd 010 /bp 100000'] = quadop ALIGN rd (right rs) (right rt) bp

### ALUIPC
###  - Aligned Add Upper Immediate to PC
val / ['111011 /rs 11111 /immediate16'] = binop ALUIPC rs immediate32

### AUI
###  - Add Immediate to Upper Bits
val / ['001111 /rs /rt /immediate16'] = ternop AUI rt (right rs) immediate32

### AUIPC
###  - Add Upper Immediate to PC
val / ['111011 /rs 11110 /immediate16'] = binop AUIPC rs immediate32

### BALC
###  - Branch and Link, Compact
val / ['111010 /offset26'] = unop BALC offset28

### BC
###  - Branch, Compact
val / ['110010 /offset26'] = unop BC offset28

### BC1EQZ
###  - Branch if Coprocessor 1 (FPU) Register Bit 0 Equal to Zero
val / ['010001 01001 /ft /offset16'] = binop BC1EQZ (right ft) offset18

### BC1NEZ
###  - Branch if Coprocessor 1 (FPU) Register Bit 0 Not Equal to Zero
val / ['010001 01101 /ft /offset16'] = binop BC1NEZ (right ft) offset18

### BC2EQZ
###  - Branch if Coprocessor 2 Condition (Register) Equal to Zero
val / ['010010 01001 /ct /offset16'] = binop BC2EQZ ct offset18

### BC2NEZ
###  - Branch if Coprocessor 2 Condition (Register) Not Equal to Zero
val / ['010010 01101 /ct /offset16'] = binop BC2NEZ ct offset18

### BGTZ
###  - Branch on Greater Than Zero
###  => see BLTUC

### BLEZ
###  - Branch on Less Than or Equal to Zero
###  => see BGEUC

### B{LE,GE,GT,LT,EQ,NE}ZALC
###  - Compact zero-compare and branch-and-link instructions
###    BLEZALC
###  => see BGEUC

###    BGEZALC
###  => see BGEUC

###    BGTZALC
###  => see BLTTUC

###    BLTZALC
###  => see BLTTUC

###    BEQZALC
###  => see BOVC

###    BNEZALC
###  => see BNVC

### B<cond>C
###  - Compact compare-and-branch instructions
###    BGEC (BLEZ)
val / ['010110 /rs /rt /offset16']
 | blezc? = binop BLEZC (right rt) offset18
 | bgezc? = binop BGEZC (right rt) offset18
 | bgec? = ternop BGEC (right rs) (right rt) offset18

###    BLTC (BGTC)
val / ['010111 /rs /rt /offset16']
 | bgtzc? = binop BGTZC (right rt) offset18
 | bltzc? = binop BLTZC (right rt) offset18
 | bltc? = ternop BLTC (right rs) (right rt) offset18

###    BGEUC (BLEUC)
val / ['000110 /rs /rt /offset16']
 | blez?    = binop BLEZ (right rs) offset18
 | blezalc? = binop BLEZALC (right rt) offset18
 | bgezalc? = binop BGEZALC (right rt) offset18
 | bgeuc?   = ternop BGEUC (right rs) (right rt) offset18

###    BLTUC (BGTUC)
val / ['000111 /rs /rt /offset16']
 | bgtz?    = binop BGTZ (right rs) offset18
 | bgtzalc? = binop BGTZALC (right rt) offset18
 | bltzalc? = binop BLTZALC (right rt) offset18
 | bltuc?   = ternop BLTUC (right rs) (right rt) offset18

###    BEQC
###  => see BOVC

###    BNEC
###  => see BNVC

###    BEQZC
val / ['110110 /rs-notnull /offset21'] = binop BEQZC (right rs) offset23

###    BNEZC
val / ['111110 /rs-notnull /offset21'] = binop BNEZC (right rs) offset23

### BITSWAP
###  - Swaps (reverses) bits in each byte
val / ['011111 00000 /rt /rd 00000 100000'] = binop BITSWAP rd (right rt)

### BOVC
###  - Swaps (reverses) bits in each byte
val / ['001000 /rs /rt /offset16']
 | beqzalc? = binop BEQZALC (right rt) offset18
 | beqc? = ternop BEQC (right rs) (right rt) offset18
 | bovc? = ternop BOVC (right rs) (right rt) offset18

### BNVC
###  - Swaps (reverses) bits in each byte
val / ['011000 /rs /rt /offset16']
 | bnezalc? = binop BNEZALC (right rt) offset18
 | bnec? = ternop BNEC (right rs) (right rt) offset18
 | bnvc? = ternop BNVC (right rs) (right rt) offset18

### CACHE
###  - Perform Cache Operation
val / ['011111 /base /op /offset9 0 100101'] = binop CACHE op offset9/base

### Class-fmt
###  - Scalar Floating-Point Class Mask
val / ['010001 /fmt5sd 00000 /fs /fd 011011'] = binop-fmt CLASS-fmt fmt fd (right fs)

### CMP-condn-fmt
###  - Floating Point Compare setting Mask
val / ['010001 /fmt5sd/wl /ft /fs /fd 0 /condn'] = ternop-cond-fmt CMP-condn-fmt condn fmt fd (right fs) (right ft)

### DIV, MOD, DIVU, MODU
###  - Divide Integers (with result to GPR)
###    DIV
val / ['000000 /rs /rt /rd 00010 011010'] = ternop DIV rd (right rs) (right rt) 

###    MOD
val / ['000000 /rs /rt /rd 00011 011010'] = ternop MOD rd (right rs) (right rt) 

###    DIVU
val / ['000000 /rs /rt /rd 00010 011011'] = ternop DIVU rd (right rs) (right rt) 

###    MODU
val / ['000000 /rs /rt /rd 00011 011011'] = ternop MODU rd (right rs) (right rt) 

### DVP
###  - Disable Virtual Processor
val / ['010000 01011 /rt 00000 00000 1 00 100'] = unop DVP rt

### EVP
###  - Enable Virtual Processor
val / ['010000 01011 /rt 00000 00000 0 00 100'] = unop EVP rt

### JR
### Jump Register
###  => see JALR with rd = 0

### JR-HB
### Jump Register with Hazard Barrier
###  => see JALR-HB with rd = 0

### JIALC
###  - Jump Indexed and Link, Compact
val / ['111110 00000 /rt /offset16'] = binop JIALC (right rt) offset16

### JIC
###  - Jump Indexed and Link, Compact
val / ['110110 00000 /rt /offset16'] = binop JIALC (right rt) offset16

### LSA
###  - Load Scaled Address
val / ['000000 /rs /rt /rd 000 /sa2 000101'] = quadop LSA rd (right rs) (right rt) sa2

### LUI
###  - Load Upper Immediate
###  => see AUI r0, rt, immediate16

### MADDF-fmt
###  - Floating Point Fused Multiply Add
val / ['010001 /fmt5sd /ft /fs /fd 011000'] = ternop-fmt MADDF-fmt fmt fd (right fs) (right ft)

### MSUBF-fmt
###  - Floating Point Fused Multiply Subtract
val / ['010001 /fmt5sd /ft /fs /fd 011001'] = ternop-fmt MSUBF-fmt fmt fd (right fs) (right ft)

### MAX-fmt
###  - Scalar Floating-Point Max
val / ['010001 /fmt5sd /ft /fs /fd 011110'] = ternop-fmt MAX-fmt fmt fd (right fs) (right ft)

### MAXA-fmt
###  - Scalar Floating-Point maxNumMag
val / ['010001 /fmt5sd /ft /fs /fd 011111'] = ternop-fmt MAXA-fmt fmt fd (right fs) (right ft)

### MIN-fmt
###  - Scalar Floating-Point Min
val / ['010001 /fmt5sd /ft /fs /fd 011100'] = ternop-fmt MIN-fmt fmt fd (right fs) (right ft)

### MINA-fmt
###  - Scalar Floating-Point minNumMag
val / ['010001 /fmt5sd /ft /fs /fd 011101'] = ternop-fmt MINA-fmt fmt fd (right fs) (right ft)

### MOV-fmt
###  - Floating Point Move
val / ['010001 /fmt5sd 00000 /fs /fd 000110'] = binop-fmt MOV-fmt fmt fd (right fs) 

### MUL-fmt
###  - Floating Point Multiply
val / ['010001 /fmt5sd /ft /fs /fd 000010'] = ternop-fmt MUL-fmt fmt fd (right fs) (right ft) 

### MUL
###  - Multiply Words Signed, Low Word
val / ['000000 /rs /rt /rd 00010 011000'] = ternop MUL rd (right rs) (right rt) 

### MUH
###  - Multiply Words Signed, High Word
val / ['000000 /rs /rt /rd 00011 011000'] = ternop MUH rd (right rs) (right rt) 

### MULU
###  - Multiply Words Unsigned, Low Word
val / ['000000 /rs /rt /rd 00010 011001'] = ternop MULU rd (right rs) (right rt) 

### MUHU
###  - Multiply Words Unsigned, High Word
val / ['000000 /rs /rt /rd 00011 011001'] = ternop MUHU rd (right rs) (right rt) 

### NAL
###  - No-op and Link
val / ['000001 00000 10000 /offset16'] = nullop NAL

### NEG-fmt
###  - Floating Point Negate
val / ['010001 /fmt5sd 00000 /fs /fd 000111'] = binop-fmt NEG-fmt fmt fd (right fs) 

### PREF
###  - Prefetch
val / ['011111 /base /hint5 /offset9 0 110101'] = binop PREF hint5 offset9/base

### RINT-fmt
###  - Floating-Point Round to Integral
val / ['010001 /fmt5sd 00000 /fs /fd 011010'] = binop-fmt RINT-fmt fmt fd (right fs) 

### SC
###  - Store Conditional Word
val / ['011111 /base /rt /offset9 0 100110'] = binop SC rt offset9/base

### SDBBP
###  - Software Debug Breakpoint
val / ['000000 /code20 001110'] = unop SDBBP code20 

### SDC2
###  - Store Doubleword from Coprocessor 2
val / ['010010 01111 /base /rt /offset11'] = binop SDC2 rt/imm offset11/base 

### SEL-fmt
###  - Select floating point values with FPR condition
val / ['010001 /fmt5sd /ft /fs /fd 010000'] = ternop-fmt SEL-fmt fmt fd (right fs) (right ft) 

### SELEQZ
###  - Select integer GPR value or zero
val / ['000000 /rs /rt /rd 00000 110101'] = ternop SELEQZ rd (right rs) (right rt) 

### SELNEZ
###  - Select integer GPR value or zero
val / ['000000 /rs /rt /rd 00000 110111'] = ternop SELNEZ rd (right rs) (right rt) 

### SELEQZ
###  - Select floating point value or zero with FPR condition
val / ['010001 /fmt5sd /ft /fs /fd 010100'] = ternop-fmt SELEQZ-fmt fmt fd (right fs) (right ft) 

### SELNEQZ
###  - Select floating point value or zero with FPR condition
val / ['010001 /fmt5sd /ft /fs /fd 010111'] = ternop-fmt SELNEQZ-fmt fmt fd (right fs) (right ft) 



type instruction = 
   ADDIUPC of binop-lr
 | ALIGN of quadop-lrrr
 | ALUIPC of binop-lr
 | AUI of ternop-lrr
 | AUIPC of binop-lr
 | BALC of unop-r
 | BC of unop-r
 | BC1EQZ of binop-rr
 | BC1NEZ of binop-rr
 | BC2EQZ of binop-rr
 | BC2NEZ of binop-rr
 | BLEZALC of binop-rr
 | BGEZALC of binop-rr
 | BGTZALC of binop-rr
 | BLTZALC of binop-rr
 | BEQZALC of binop-rr
 | BNEZALC of binop-rr
 | BLEZC of binop-rr
 | BGEZC of binop-rr
 | BGEC of ternop-rrr
 | BGTZC of binop-rr
 | BLTZC of binop-rr
 | BLTC of ternop-rrr
 | BGEUC of ternop-rrr
 | BLTUC of ternop-rrr
 | BEQC of ternop-rrr
 | BNEC of ternop-rrr
 | BEQZC of binop-rr
 | BNEZC of binop-rr
 | BITSWAP of binop-lr
 | BOVC of ternop-rrr
 | BNVC of ternop-rrr
 | CLASS-fmt of binop-flr
 | CMP-condn-fmt of ternop-cflrr
 | DIV of ternop-lrr
 | MOD of ternop-lrr
 | DIVU of ternop-lrr
 | MODU of ternop-lrr
 | DVP of unop-l
 | EVP of unop-l
 | JIALC of binop-rr
 | JIC of binop-rr
 | LSA of quadop-lrrr
 | MADDF-fmt of ternop-flrr
 | MSUBF-fmt of ternop-flrr
 | MAX-fmt of ternop-flrr
 | MAXA-fmt of ternop-flrr
 | MIN-fmt of ternop-flrr
 | MINA-fmt of ternop-flrr
 | MUL of ternop-lrr
 | MUH of ternop-lrr
 | MULU of ternop-lrr
 | MUHU of ternop-lrr
 | NAL
 | RINT-fmt of binop-flr
 | SEL-fmt of ternop-flrr
 | SELEQZ of ternop-lrr
 | SELNEZ of ternop-lrr
 | SELEQZ-fmt of ternop-flrr
 | SELNEQZ-fmt of ternop-flrr

type imm =
   IMM21 of 21
 | IMM32 of 32
 | BP of 2
 | SA2 of 2
 | OFFSET11 of 11
 | OFFSET23 of 23
 | OFFSET28 of 28
 | C2CONDITION of 5


###########################
# operand decoders
####

val /immediate19 ['immediate19:19'] = update@{immediate19=immediate19}
val /offset11 ['offset11:11'] = update@{offset11=offset11}
val /offset21 ['offset21:21'] = update@{offset21=offset21}
val /offset26 ['offset26:26'] = update@{offset26=offset26}
val /bp ['bp:2'] = update@{bp=bp}
val /sa2 ['sa2:2'] = update@{sa2=sa2}
val /ct ['ct:5'] = update@{ct=ct}
val /fmt5sd/wl ['10100'] = update@{fmt=S}
val /fmt5sd/wl ['10101'] = update@{fmt=D}
val /condn ['condn:5'] = update@{condn=condn}
val /rs-notnull ['rs@00001|00010|00011|00100|00101|00110|00111|01000|01001|01010|01011|01100|01101|01110|01111|10000|10001|10010|10011|10100|10101|10110|10111|11000|11001|11010|11011|11100|11101|11110|11111'] = update@{rs=rs}

###########################
# operand constructors
####

val immediate21 = do
  immediate19 <- query $immediate19;
  return (IMM (IMM21 (immediate19 ^ '00')))
end

val immediate32 = do
  immediate16 <- query $immediate16;
  return (IMM (IMM32 (immediate16 ^ '0000000000000000')))
end

val offset23 = do
  offset21 <- query $offset21;
  return (IMM (OFFSET23 (offset21 ^ '00')))
end

val offset28 = do
  offset26 <- query $offset26;
  return (IMM (OFFSET28 (offset26 ^ '00')))
end

val bp = do
  bp <- query $bp;
  return (IMM (BP bp))
end

val sa2 = do
  sa2 <- query $sa2;
  return (IMM (SA2 sa2))
end

val condn = do
  condn <- query $condn;
  return (condn-from-bits (condn))
end

val ct = do
  ct <- query $ct;
  return (IMM (C2CONDITION ct))
end

val offset11/base = do
  offset11 <- query $offset11;
  base <- query $base;
  return (OFFSET/BASE {offset=(OFFSET11 offset11), base=(gpr-from-bits base)})
end

val condn-from-bits bits =
 case bits of
    '00000': C_AF
  | '00001': C_UN
  | '00010': C_EQ
  | '00011': C_UEQ
  | '00100': C_LT
  | '00101': C_ULT
  | '00110': C_LE
  | '00111': C_ULE
  | '01000': C_SAF
  | '01001': C_SUN
  | '01010': C_SEQ
  | '01011': C_SUEQ
  | '01100': C_SLT
  | '01101': C_SULT
  | '01110': C_SLE
  | '01111': C_SULE
  | '10000': C_AT
  | '10001': C_OR
  | '10010': C_UNE
  | '10011': C_NE
  | '10100': C_UGE
  | '10101': C_OGE
  | '10110': C_UGT
  | '10111': C_OGT
  | '11000': C_SAT
  | '11001': C_SOR
  | '11010': C_SUNE
  | '11011': C_SNE
  | '11100': C_SUGE
  | '11101': C_SOGE
  | '11110': C_SUGT
  | '11111': C_SOGT
 end

type condop = 
   C_AF
 | C_UN
 | C_EQ
 | C_UEQ
 | C_LT
 | C_ULT
 | C_LE
 | C_ULE
 | C_SAF
 | C_SUN
 | C_SEQ
 | C_SUEQ
 | C_SLT
 | C_SULT
 | C_SLE
 | C_SULE
 | C_AT
 | C_OR
 | C_UNE
 | C_NE
 | C_UGE
 | C_OGE
 | C_UGT
 | C_OGT
 | C_SAT
 | C_SOR
 | C_SUNE
 | C_SNE
 | C_SUGE
 | C_SOGE
 | C_SUGT
 | C_SOGT


#################################
# to be removed ;)

type format = 
   PS


val /fmt5sdps ['10 /fmt3sdps'] = return void
val /fmt3sdps [/fmt3sd] = return void
val /fmt3sdps ['110'] = update@{fmt=PS}
