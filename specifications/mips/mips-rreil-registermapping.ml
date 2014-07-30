type sem_id =
   Sem_PC

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
