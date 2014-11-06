val _var x = {id=x, offset=0}
val _var x _offset o = {id=x, offset=o}

# APSR status flags
val fNF = _var Sem_APSR _offset 31
val fZF = _var Sem_APSR _offset 30
val fCF = _var Sem_APSR _offset 29
val fVF = _var Sem_APSR _offset 28
val fQF = _var Sem_APSR _offset 27

val get-nf = return fNF
val get-zf = return fZF
val get-cf = return fCF
val get-vf = return fVF
val get-qf = return fQF

# ISETSTATE status flags
val fJF = return (_var Sem_ISETSTATE _offset 1)
val fTF = return (_var Sem_ISETSTATE _offset 0)

val get-jf = (var (_var Sem_ISETSTATE _offset 1))
val get-tf = (var (_var Sem_ISETSTATE _offset 0))

val isetstate = {id=Sem_ISETSTATE, offset=0, size=2}

type sem_id =
    Sem_R0
  | Sem_R1
  | Sem_R2
  | Sem_R3
  | Sem_R4
  | Sem_R5
  | Sem_R6
  | Sem_R7
  | Sem_R8
  | Sem_R9
  | Sem_R10
  | Sem_R11
  | Sem_R12
  | Sem_SP
  | Sem_LR
  | Sem_PC
  | Sem_APSR
  | Sem_ISETSTATE
  | Sem_ITSTATE
  | Sem_ENDIANSTATE

val semantic-register-of r =
  case r of
      R0  : {id=Sem_R0, offset=0, size=32}
    | R1  : {id=Sem_R1, offset=0, size=32}
    | R2  : {id=Sem_R2, offset=0, size=32}
    | R3  : {id=Sem_R3, offset=0, size=32}
    | R4  : {id=Sem_R4, offset=0, size=32}
    | R5  : {id=Sem_R5, offset=0, size=32}
    | R6  : {id=Sem_R6, offset=0, size=32}
    | R7  : {id=Sem_R7, offset=0, size=32}
    | R8  : {id=Sem_R8, offset=0, size=32}
    | R9  : {id=Sem_R9, offset=0, size=32}
    | R10 : {id=Sem_R10, offset=0, size=32}
    | R11 : {id=Sem_R11, offset=0, size=32}
    | R12 : {id=Sem_R12, offset=0, size=32}
    | R13 : {id=Sem_SP, offset=0, size=32}
    | R14 : {id=Sem_LR, offset=0, size=32}
    | R15 : {id=Sem_PC, offset=0, size=32}
  end
