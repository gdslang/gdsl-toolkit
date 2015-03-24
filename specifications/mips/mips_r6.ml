####################################################################
###                    DECODER FOR REVISION 6                    ###
####################################################################

######################
# guard conditions
####

val lui? s = (s.rs == '00000')
val bgtz? s = (s.rt == '00000')
val bgtzalc? s = (s.rs == '00000')
val bgezalc? s = (s.rs == s.rt) and (not (s.rs == '00000')) 
val blez? s = (s.rt == '00000')
val blezalc? s = (s.rs == '00000')
val bltzalc? s = (s.rs == s.rt) and (not (s.rs == '00000'))
val beqzalc? s = not (s.rt == '00000')
val bnezalc? s = not (s.rt == '00000')

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
val / ['001111 /rs /rt /immediate16']
 | lui? = binop LUI rt immediate16
 | otherwise = ternop AUI rt (right rs) immediate32

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
###  => see BGEZALC

### BLEZ
###  - Branch on Less Than or Equal to Zero
###  => see BLTZALC

### B{LE,GE,GT,LT,EQ,NE}ZALC
###  - Compact zero-compare and branch-and-link instructions
###    BGEZALC
val / ['000110 /rs /rt /offset16']
 | blez?    = binop BLEZ (right rs) offset18
 | blezalc? = binop BLEZALC (right rt) offset18
 | bgezalc? = binop BGEZALC (right rt) offset18

###    BLTZALC
val / ['000111 /rs /rt /offset16']
 | bgtz?    = binop BGTZ (right rs) offset18
 | bgtzalc? = binop BGTZALC (right rt) offset18
 | bltzalc? = binop BLTZALC (right rt) offset18

###    BEQZALC
val / ['001000 00000 /rt /offset16']
 | beqzalc? = binop BEQZALC (right rt) offset18

###    BNEZALC
val / ['011000 00000 /rt /offset16']
 | bnezalc? = binop BNEZALC (right rt) offset18

### LUI
###  - Load Upper Immediate
###  => see AUI r0, rt, immediate16


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

type imm =
   IMM21 of 21
 | IMM32 of 32
 | BP of 2
 | OFFSET28 of 28
 | C2CONDITION of 5


###########################
# operand decoders
####

val /immediate19 ['immediate19:19'] = update@{immediate19=immediate19}
val /offset26 ['offset26:26'] = update@{offset26=offset26}
val /bp ['bp:2'] = update@{bp=bp}
val /ct ['ct:5'] = update@{ct=ct}

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

val offset28 = do
  offset26 <- query $offset26;
  return (IMM (OFFSET28 (offset26 ^ '00')))
end

val bp = do
  bp <- query $bp;
  return (IMM (BP bp))
end

val ct = do
  ct <- query $ct;
  return (IMM (C2CONDITION ct))
end


#################################
# to be removed ;)

type format = 
   PS


val /fmt5sdps ['10 /fmt3sdps'] = return void
val /fmt3sdps [/fmt3sd] = return void
val /fmt3sdps ['110'] = update@{fmt=PS}
