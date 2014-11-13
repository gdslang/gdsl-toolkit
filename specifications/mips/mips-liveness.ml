val registers-live-map = let
  val ++- map reg-sem = 
    fmap-add-range map reg-sem.id reg-sem.size reg-sem.offset
  val ++++ map r = map ++- semantic-gpr-of r
  val +++++ map r = map ++- semantic-fpr-of r
  val ++++++ map r = map ++- semantic-fcr-of r
  val +++++++ map r = map ++- semantic-reg-of r
in
  fmap-empty 
  ++++ ZERO
  ++++ AT
  ++++ V0
  ++++ V1
  ++++ A0
  ++++ A1
  ++++ A2
  ++++ A3
  ++++ T0
  ++++ T1
  ++++ T2
  ++++ T3
  ++++ T4
  ++++ T5
  ++++ T6
  ++++ T7
  ++++ S0
  ++++ S1
  ++++ S2
  ++++ S3
  ++++ S4
  ++++ S5
  ++++ S6
  ++++ S7
  ++++ T8
  ++++ T9
  ++++ K0
  ++++ K1
  ++++ GP
  ++++ SP
  ++++ S8
  ++++ RA

  +++++ F0
  +++++ F1
  +++++ F2
  +++++ F3
  +++++ F4
  +++++ F5
  +++++ F6
  +++++ F7
  +++++ F8
  +++++ F9
  +++++ F10
  +++++ F11
  +++++ F12
  +++++ F13
  +++++ F14
  +++++ F15
  +++++ F16
  +++++ F17
  +++++ F18
  +++++ F19
  +++++ F20
  +++++ F21
  +++++ F22
  +++++ F23
  +++++ F24
  +++++ F25
  +++++ F26
  +++++ F27
  +++++ F28
  +++++ F29
  +++++ F30
  +++++ F31

  ++++++ FCCR
  ++++++ FEXR
  ++++++ FENR
  ++++++ FCSR
  ++++++ FIR

  +++++++ Sem_PC
  +++++++ Sem_HI
  +++++++ Sem_LO
  +++++++ Sem_SREG
  +++++++ Sem_LLBIT
  +++++++ Sem_DEBUG
  +++++++ Sem_CONFIG1
  +++++++ Sem_CONFIG3
  +++++++ Sem_ISA_MODE
  +++++++ Sem_SRSCTL
  +++++++ Sem_EPC
  +++++++ Sem_ERROR_EPC
  +++++++ Sem_DEPC
  +++++++ Sem_CPUNUM
  +++++++ Sem_SYNCI_STEP
  +++++++ Sem_CC
  +++++++ Sem_CCRES
  +++++++ Sem_ULR
  +++++++ Sem_C2CCREG
end
