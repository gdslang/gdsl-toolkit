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



type instruction =
   ADDI of ternop-lrr
 | ALNV-PS of quadop-lrrr
 | LWL of binop-lr
 | LWLE of binop-lr
 | LWR of binop-lr
 | LWRE of binop-lr
 | LWXC1 of binop-lr

type format = 
   PS


val /fmt5sdps ['10 /fmt3sdps'] = return void
val /fmt3sdps [/fmt3sd] = return void
val /fmt3sdps ['110'] = update@{fmt=PS}
