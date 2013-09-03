val fCF = sem-reg-offset (semantic-register-of SREG) 0
val fZF = sem-reg-offset (semantic-register-of SREG) 1
val fNF = sem-reg-offset (semantic-register-of SREG) 2
val fVF = sem-reg-offset (semantic-register-of SREG) 3
val fSF = sem-reg-offset (semantic-register-of SREG) 4
val fHF = sem-reg-offset (semantic-register-of SREG) 5
val fTF = sem-reg-offset (semantic-register-of SREG) 6
val fIF = sem-reg-offset (semantic-register-of SREG) 7

val f-at offset = sem-reg-offset (semantic-register-of SREG) offset

val ip-get = return (semantic-register-of PC)

val arch-show-id r =
  case r of
	   Sem_ALL: "memory"
	 | Sem_PC: "PC"
	end

type sem_id =
	 Sem_ALL
 | Sem_PC

val sem-reg-offset r o = @{offset=r.offset + o}r

val semantic-register-of r =
  case r of
     R0: {id=Sem_ALL,offset=0,size=8}
   | R1: {id=Sem_ALL,offset=8,size=8}
   | R2: {id=Sem_ALL,offset=16,size=8}
   | R3: {id=Sem_ALL,offset=24,size=8}
   | R4: {id=Sem_ALL,offset=32,size=8}
   | R5: {id=Sem_ALL,offset=40,size=8}
   | R6: {id=Sem_ALL,offset=48,size=8}
   | R7: {id=Sem_ALL,offset=56,size=8}
   | R8: {id=Sem_ALL,offset=64,size=8}
   | R9: {id=Sem_ALL,offset=72,size=8}
   | R10: {id=Sem_ALL,offset=80,size=8}
   | R11: {id=Sem_ALL,offset=88,size=8}
   | R12: {id=Sem_ALL,offset=96,size=8}
   | R13: {id=Sem_ALL,offset=104,size=8}
   | R14: {id=Sem_ALL,offset=112,size=8}
   | R15: {id=Sem_ALL,offset=120,size=8}
   | R16: {id=Sem_ALL,offset=128,size=8}
   | R17: {id=Sem_ALL,offset=136,size=8}
   | R18: {id=Sem_ALL,offset=144,size=8}
   | R19: {id=Sem_ALL,offset=152,size=8}
   | R20: {id=Sem_ALL,offset=160,size=8}
   | R21: {id=Sem_ALL,offset=168,size=8}
   | R22: {id=Sem_ALL,offset=176,size=8}
   | R23: {id=Sem_ALL,offset=184,size=8}
   | R24: {id=Sem_ALL,offset=192,size=8}
   | R25: {id=Sem_ALL,offset=200,size=8}
   | R26: {id=Sem_ALL,offset=208,size=8}
   | R27: {id=Sem_ALL,offset=216,size=8}
   | R28: {id=Sem_ALL,offset=224,size=8}
   | R29: {id=Sem_ALL,offset=232,size=8}
   | R30: {id=Sem_ALL,offset=240,size=8}
   | R31: {id=Sem_ALL,offset=248,size=8}
   | SREG: {id=Sem_ALL,offset=760,size=8}
   | PC: {id=Sem_PC,offset=0,size=16}
  end
