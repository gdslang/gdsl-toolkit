export pretty-arch-id: (sem_id) -> rope
export pretty-arch-exception: (sem_exception) -> rope

val pretty-arch-id r = arch-show-id r

val pretty-arch-exception exception = case 0 of 1: "" end

val arch-show-id r =
  case r of
      Sem_R0: "R0"
    | Sem_R1: "R1"
    | Sem_R2: "R2"
    | Sem_R3: "R3"
    | Sem_R4: "R4"
    | Sem_R5: "R5"
    | Sem_R6: "R6"
    | Sem_R7: "R7"
    | Sem_R8: "R8"
    | Sem_R9: "R9"
    | Sem_R10: "R10"
    | Sem_R11: "R11"
    | Sem_R12: "R12"
    | Sem_SP: "SP"
    | Sem_LR: "LR"
    | Sem_PC: "PC"
    | Sem_APSR: "APSR"
    | Sem_ISETSTATE: "ISETSTATE"
  end
