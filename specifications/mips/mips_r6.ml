####################################################################
###                    DECODER FOR REVISION 6                    ###
####################################################################

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


type instruction = 
   ADDIUPC of binop-lr
 | ALIGN of quadop-lrrr

type imm =
   IMM21 of 21
 | BP of 2


###########################
# operand decoders
####

val /immediate19 ['immediate19:19'] = update@{immediate19=immediate19}
val /bp ['bp:2'] = update@{bp=bp}


###########################
# operand constructors
####

val immediate21 = do
  immediate19 <- query $immediate19;
  return (IMM (IMM21 (immediate19 ^ '00')))
end

val bp = do
  bp <- query $bp;
  return (IMM (BP bp))
end


#################################
# to be removed ;)

type format = 
   PS


val /fmt5sdps ['10 /fmt3sdps'] = return void
val /fmt3sdps [/fmt3sd] = return void
val /fmt3sdps ['110'] = update@{fmt=PS}
