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
  | Sem_Q0
  | Sem_Q1
  | Sem_Q2
  | Sem_Q3
  | Sem_Q4
  | Sem_Q5
  | Sem_Q6
  | Sem_Q7
  | Sem_Q8
  | Sem_Q9
  | Sem_Q10
  | Sem_Q11
  | Sem_Q12
  | Sem_Q13
  | Sem_Q14
  | Sem_Q15

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

### advanced SIMD and Floating-point register mapping [A2.6.2]

type extension-register =
    Q0
  | Q1
  | Q2
  | Q3
  | Q4
  | Q5
  | Q6
  | Q7
  | Q8
  | Q9
  | Q10
  | Q11
  | Q12
  | Q13
  | Q14
  | Q15
  | D0
  | D1
  | D2
  | D3
  | D4
  | D5
  | D6
  | D7
  | D8
  | D9
  | D10
  | D11
  | D12
  | D13
  | D14
  | D15
  | D16
  | D17
  | D18
  | D19
  | D20
  | D21
  | D22
  | D23
  | D24
  | D25
  | D26
  | D27
  | D28
  | D29
  | D30
  | D31
  | S0
  | S1
  | S2
  | S3
  | S4
  | S5
  | S6
  | S7
  | S8
  | S9
  | S10
  | S11
  | S12
  | S13
  | S14
  | S15
  | S16
  | S17
  | S18
  | S19
  | S20
  | S21
  | S22
  | S23
  | S24
  | S25
  | S26
  | S27
  | S28
  | S29
  | S30
  | S31

val semantic-ext-register-of r =
  case r of
      Q0  : {id=Sem_Q0, offset=0, size=128}
    | Q1  : {id=Sem_Q1, offset=0, size=128}
    | Q2  : {id=Sem_Q2, offset=0, size=128}
    | Q3  : {id=Sem_Q3, offset=0, size=128}
    | Q4  : {id=Sem_Q4, offset=0, size=128}
    | Q5  : {id=Sem_Q5, offset=0, size=128}
    | Q6  : {id=Sem_Q6, offset=0, size=128}
    | Q7  : {id=Sem_Q7, offset=0, size=128}
    | Q8  : {id=Sem_Q8, offset=0, size=128}
    | Q9  : {id=Sem_Q9, offset=0, size=128}
    | Q10 : {id=Sem_Q10, offset=0, size=128}
    | Q11 : {id=Sem_Q11, offset=0, size=128}
    | Q12 : {id=Sem_Q12, offset=0, size=128}
    | Q13 : {id=Sem_Q13, offset=0, size=128}
    | Q14 : {id=Sem_Q14, offset=0, size=128}
    | Q15 : {id=Sem_Q15, offset=0, size=128}
    | D0  : {id=Sem_Q0, offset=0, size=64}
    | D1  : {id=Sem_Q0, offset=64, size=64}
    | D2  : {id=Sem_Q1, offset=0, size=64}
    | D3  : {id=Sem_Q1, offset=64, size=64}
    | D4  : {id=Sem_Q2, offset=0, size=64}
    | D5  : {id=Sem_Q2, offset=64, size=64}
    | D6  : {id=Sem_Q3, offset=0, size=64}
    | D7  : {id=Sem_Q3, offset=64, size=64}
    | D8  : {id=Sem_Q4, offset=0, size=64}
    | D9  : {id=Sem_Q4, offset=64, size=64}
    | D10 : {id=Sem_Q5, offset=0, size=64}
    | D11 : {id=Sem_Q5, offset=64, size=64}
    | D12 : {id=Sem_Q6, offset=0, size=64}
    | D13 : {id=Sem_Q6, offset=64, size=64}
    | D14 : {id=Sem_Q7, offset=0, size=64}
    | D15 : {id=Sem_Q7, offset=64, size=64}
    | D16 : {id=Sem_Q8, offset=0, size=64}
    | D17 : {id=Sem_Q8, offset=64, size=64}
    | D18 : {id=Sem_Q9, offset=0, size=64}
    | D19 : {id=Sem_Q9, offset=64, size=64}
    | D20 : {id=Sem_Q10, offset=0, size=64}
    | D21 : {id=Sem_Q10, offset=64, size=64}
    | D22 : {id=Sem_Q11, offset=0, size=64}
    | D23 : {id=Sem_Q11, offset=64, size=64}
    | D24 : {id=Sem_Q12, offset=0, size=64}
    | D25 : {id=Sem_Q12, offset=64, size=64}
    | D26 : {id=Sem_Q13, offset=0, size=64}
    | D27 : {id=Sem_Q13, offset=64, size=64}
    | D28 : {id=Sem_Q14, offset=0, size=64}
    | D29 : {id=Sem_Q14, offset=64, size=64}
    | D30 : {id=Sem_Q15, offset=0, size=64}
    | D31 : {id=Sem_Q15, offset=64, size=64}
    | S0  : {id=Sem_Q0, offset=0, size=32}
    | S1  : {id=Sem_Q0, offset=32, size=32}
    | S2  : {id=Sem_Q0, offset=64, size=32}
    | S3  : {id=Sem_Q0, offset=96, size=32}
    | S4  : {id=Sem_Q1, offset=0, size=32}
    | S5  : {id=Sem_Q1, offset=32, size=32}
    | S6  : {id=Sem_Q1, offset=64, size=32}
    | S7  : {id=Sem_Q1, offset=96, size=32}
    | S8  : {id=Sem_Q2, offset=0, size=32}
    | S9  : {id=Sem_Q2, offset=32, size=32}
    | S10 : {id=Sem_Q2, offset=64, size=32}
    | S11 : {id=Sem_Q2, offset=96, size=32}
    | S12 : {id=Sem_Q3, offset=0, size=32}
    | S13 : {id=Sem_Q3, offset=32, size=32}
    | S14 : {id=Sem_Q3, offset=64, size=32}
    | S15 : {id=Sem_Q3, offset=96, size=32}
    | S16 : {id=Sem_Q4, offset=0, size=32}
    | S17 : {id=Sem_Q4, offset=32, size=32}
    | S18 : {id=Sem_Q4, offset=64, size=32}
    | S19 : {id=Sem_Q4, offset=96, size=32}
    | S20 : {id=Sem_Q5, offset=0, size=32}
    | S21 : {id=Sem_Q5, offset=32, size=32}
    | S22 : {id=Sem_Q5, offset=64, size=32}
    | S23 : {id=Sem_Q5, offset=96, size=32}
    | S24 : {id=Sem_Q6, offset=0, size=32}
    | S25 : {id=Sem_Q6, offset=32, size=32}
    | S26 : {id=Sem_Q6, offset=64, size=32}
    | S27 : {id=Sem_Q6, offset=96, size=32}
    | S28 : {id=Sem_Q7, offset=0, size=32}
    | S29 : {id=Sem_Q7, offset=32, size=32}
    | S30 : {id=Sem_Q7, offset=64, size=32}
    | S31 : {id=Sem_Q7, offset=96, size=32}
  end