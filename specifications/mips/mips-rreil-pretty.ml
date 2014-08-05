export pretty-arch-id: (sem_id) -> rope
export pretty-arch-exception: (sem_exception) -> rope

val arch-show-id r =
  case r of
	   Sem_PC: "PC"
	 | Sem_ZERO: "zero"
	 | Sem_AT: "at"
	 | Sem_V0: "v0"
	 | Sem_V1: "v1"
	 | Sem_A0: "a0"
	 | Sem_A1: "a1"
	 | Sem_A2: "a2"
	 | Sem_A3: "a3"
	 | Sem_T0: "t0"
	 | Sem_T1: "t1"
	 | Sem_T2: "t2"
	 | Sem_T3: "t3"
	 | Sem_T4: "t4"
	 | Sem_T5: "t5"
	 | Sem_T6: "t6"
	 | Sem_T7: "t7"
	 | Sem_S0: "s0"
	 | Sem_S1: "s1"
	 | Sem_S2: "s2"
	 | Sem_S3: "s3"
	 | Sem_S4: "s4"
	 | Sem_S5: "s5"
	 | Sem_S6: "s6"
	 | Sem_S7: "s7"
	 | Sem_T8: "t8"
	 | Sem_T9: "t9"
	 | Sem_K0: "k0"
	 | Sem_K1: "k1"
	 | Sem_GP: "gp"
	 | Sem_SP: "sp"
	 | Sem_S8: "s8"
	 | Sem_RA: "ra"
	 | Sem_HI: "HI"
	 | Sem_LO: "LO"
   end

val pretty-arch-id r = arch-show-id r

val pretty-arch-exception exception = ""
