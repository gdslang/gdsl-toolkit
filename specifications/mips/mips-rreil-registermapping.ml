type sem_id =
   Sem_PC
 | Sem_SREG
 | Sem_LLBIT
 | Sem_DEBUG
 | Sem_CONFIG1
 | Sem_ISA_MODE

type sem_id =
   Sem_ZERO
 | Sem_AT
 | Sem_V0
 | Sem_V1
 | Sem_A0
 | Sem_A1
 | Sem_A2
 | Sem_A3
 | Sem_T0
 | Sem_T1
 | Sem_T2
 | Sem_T3
 | Sem_T4
 | Sem_T5
 | Sem_T6
 | Sem_T7
 | Sem_S0
 | Sem_S1
 | Sem_S2
 | Sem_S3
 | Sem_S4
 | Sem_S5
 | Sem_S6
 | Sem_S7
 | Sem_T8
 | Sem_T9
 | Sem_K0
 | Sem_K1
 | Sem_GP
 | Sem_SP
 | Sem_S8
 | Sem_RA
 | Sem_HI
 | Sem_LO

type sem_id = 
   Sem_F0
 | Sem_F1
 | Sem_F2
 | Sem_F3
 | Sem_F4
 | Sem_F5
 | Sem_F6
 | Sem_F7
 | Sem_F8
 | Sem_F9
 | Sem_F10
 | Sem_F11
 | Sem_F12
 | Sem_F13
 | Sem_F14
 | Sem_F15
 | Sem_F16
 | Sem_F17
 | Sem_F18
 | Sem_F19
 | Sem_F20
 | Sem_F21
 | Sem_F22
 | Sem_F23
 | Sem_F24
 | Sem_F25
 | Sem_F26
 | Sem_F27
 | Sem_F28
 | Sem_F29
 | Sem_F30
 | Sem_F31

val fIE = sem-reg-offset (sreg-get) 0
val fRE = sem-reg-offset (sreg-get) 25
val fCA = sem-reg-offset (config1-get) 2
val fDM = sem-reg-offset (debug-get) 0
val fEXL = sem-reg-offset (sreg-get) 1
val fERL = sem-reg-offset (sreg-get) 2
val fKSU = sem-reg-offset (sreg-get) 3

val sem-reg-offset r o = @{offset=r.offset + o}r

val ip-get = {id=Sem_PC,offset=0,size=32}
val hi-get = {id=Sem_HI,offset=0,size=32}
val lo-get = {id=Sem_LO,offset=0,size=32}
val sreg-get = {id=Sem_SREG,offset=0,size=32}
val llbit-get = {id=Sem_LLBIT,offset=0,size=1}
val debug-get = {id=Sem_DEBUG,offset=0,size=32}
val config1-get = {id=Sem_CONFIG1,offset=0,size=32}
val isa-mode-get = {id=Sem_ISA_MODE,offset=0,size=1}

val semantic-gpr-of r =
   case r of
      ZERO : {id=Sem_ZERO,offset=0,size=32}
    | AT   : {id=Sem_AT  ,offset=0,size=32}
    | V0   : {id=Sem_V0  ,offset=0,size=32}
    | V1   : {id=Sem_V1  ,offset=0,size=32}
    | A0   : {id=Sem_A0  ,offset=0,size=32}
    | A1   : {id=Sem_A1  ,offset=0,size=32}
    | A2   : {id=Sem_A2  ,offset=0,size=32}
    | A3   : {id=Sem_A3  ,offset=0,size=32}
    | T0   : {id=Sem_T0  ,offset=0,size=32}
    | T1   : {id=Sem_T1  ,offset=0,size=32}
    | T2   : {id=Sem_T2  ,offset=0,size=32}
    | T3   : {id=Sem_T3  ,offset=0,size=32}
    | T4   : {id=Sem_T4  ,offset=0,size=32}
    | T5   : {id=Sem_T5  ,offset=0,size=32}
    | T6   : {id=Sem_T6  ,offset=0,size=32}
    | T7   : {id=Sem_T7  ,offset=0,size=32}
    | S0   : {id=Sem_S0  ,offset=0,size=32}
    | S1   : {id=Sem_S1  ,offset=0,size=32}
    | S2   : {id=Sem_S2  ,offset=0,size=32}
    | S3   : {id=Sem_S3  ,offset=0,size=32}
    | S4   : {id=Sem_S4  ,offset=0,size=32}
    | S5   : {id=Sem_S5  ,offset=0,size=32}
    | S6   : {id=Sem_S6  ,offset=0,size=32}
    | S7   : {id=Sem_S7  ,offset=0,size=32}
    | T8   : {id=Sem_T8  ,offset=0,size=32}
    | T9   : {id=Sem_T9  ,offset=0,size=32}
    | K0   : {id=Sem_K0  ,offset=0,size=32}
    | K1   : {id=Sem_K1  ,offset=0,size=32}
    | GP   : {id=Sem_GP  ,offset=0,size=32}
    | SP   : {id=Sem_SP  ,offset=0,size=32}
    | S8   : {id=Sem_S8  ,offset=0,size=32}
    | RA   : {id=Sem_RA  ,offset=0,size=32}
   end

val semantic-fpr-of f =
   case f of
      F0   : {id=Sem_F0  ,offset=0,size=32}
    | F1   : {id=Sem_F1  ,offset=0,size=32}
    | F2   : {id=Sem_F2  ,offset=0,size=32}
    | F3   : {id=Sem_F3  ,offset=0,size=32}
    | F4   : {id=Sem_F4  ,offset=0,size=32}
    | F5   : {id=Sem_F5  ,offset=0,size=32}
    | F6   : {id=Sem_F6  ,offset=0,size=32}
    | F7   : {id=Sem_F7  ,offset=0,size=32}
    | F8   : {id=Sem_F8  ,offset=0,size=32}
    | F9   : {id=Sem_F9  ,offset=0,size=32}
    | F10  : {id=Sem_F10 ,offset=0,size=32}
    | F11  : {id=Sem_F11 ,offset=0,size=32}
    | F12  : {id=Sem_F12 ,offset=0,size=32}
    | F13  : {id=Sem_F13 ,offset=0,size=32}
    | F14  : {id=Sem_F14 ,offset=0,size=32}
    | F15  : {id=Sem_F15 ,offset=0,size=32}
    | F16  : {id=Sem_F16 ,offset=0,size=32}
    | F17  : {id=Sem_F17 ,offset=0,size=32}
    | F18  : {id=Sem_F18 ,offset=0,size=32}
    | F19  : {id=Sem_F19 ,offset=0,size=32}
    | F20  : {id=Sem_F20 ,offset=0,size=32}
    | F21  : {id=Sem_F21 ,offset=0,size=32}
    | F22  : {id=Sem_F22 ,offset=0,size=32}
    | F23  : {id=Sem_F23 ,offset=0,size=32}
    | F24  : {id=Sem_F24 ,offset=0,size=32}
    | F25  : {id=Sem_F25 ,offset=0,size=32}
    | F26  : {id=Sem_F26 ,offset=0,size=32}
    | F27  : {id=Sem_F27 ,offset=0,size=32}
    | F28  : {id=Sem_F28 ,offset=0,size=32}
    | F29  : {id=Sem_F29 ,offset=0,size=32}
    | F30  : {id=Sem_F30 ,offset=0,size=32}
    | F31  : {id=Sem_F31 ,offset=0,size=32}
   end
