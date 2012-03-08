granularity = 32

export = main

# The state of the decode monad
state =
   {cond:cond=NONE}

datatype cond
   EQ
 | NE
 | CS
 | CC
 | MI
 | PL
 | VS
 | VC
 | HI
 | LS
 | GE
 | LT
 | GT
 | LE
 | NONE

datatype reg =
   R0
 | R1
 | R2

datatype sty =
   LSL
 | LSR
 | ASR
 | ROR

datatype op =
 | IMM4 of 4
 | IMM12 of 12
 | REG of reg

datatype triop = {s:1, cond:cond, op1:op, op2:op, op3:op}

val reg r =
   case r of
      '000': R0
    | '001': R1
    | '010': R2
    # and so on ...

datatype insn =
   AND of triop
 | ADC of triop

val cond ['0000'] = update @{cond=EQ}
val cond ['0001'] = update @{cond=NE}
val cond ['0010'] = update @{cond=CS}
val cond ['0011'] = update @{cond=CC}
val cond ['0100'] = update @{cond=MI}
val cond ['0101'] = update @{cond=PL}
val cond ['0110'] = update @{cond=VS}
val cond ['0111'] = update @{cond=VC}
val cond ['1000'] = update @{cond=HI}
val cond ['1001'] = update @{cond=LS}
val cond ['1010'] = update @{cond=GE}
val cond ['1011'] = update @{cond=LT}
val cond ['1100'] = update @{cond=GT}
val cond ['1101'] = update @{cond=LE}
val cond ['1110'] = update @{cond=NONE}

val shift imm ty rm = LSL

val shift ['imm:5 ty:2 0 rm:4'] = update @{shift=shift imm ty rm}

val build i = do
   c <- query $cond
   return c (i@{cond=c})

val buildWithShift i = do
   c <- query $cond
   s <- query $shift
   return c (i@{cond=c, shift=s})

val main ['cond 0010000 s:1 rn:4 rd:4 imm:12'] =
   build AND {s=s, op1=reg rn, op2=reg rd, op3=IMM12 imm}
val main ['cond 0000101 s:1 rn:4 rd:4 shift'] =
   build ADC {s=s, op1=reg rn, op2=reg rd}

