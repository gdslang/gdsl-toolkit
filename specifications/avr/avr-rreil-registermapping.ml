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
   | IO0: {id=Sem_ALL,offset=256,size=8}
   | IO1: {id=Sem_ALL,offset=264,size=8}
   | IO2: {id=Sem_ALL,offset=272,size=8}
   | IO3: {id=Sem_ALL,offset=280,size=8}
   | IO4: {id=Sem_ALL,offset=288,size=8}
   | IO5: {id=Sem_ALL,offset=296,size=8}
   | IO6: {id=Sem_ALL,offset=304,size=8}
   | IO7: {id=Sem_ALL,offset=312,size=8}
   | IO8: {id=Sem_ALL,offset=320,size=8}
   | IO9: {id=Sem_ALL,offset=328,size=8}
   | IO10: {id=Sem_ALL,offset=336,size=8}
   | IO11: {id=Sem_ALL,offset=344,size=8}
   | IO12: {id=Sem_ALL,offset=352,size=8}
   | IO13: {id=Sem_ALL,offset=360,size=8}
   | IO14: {id=Sem_ALL,offset=368,size=8}
   | IO15: {id=Sem_ALL,offset=376,size=8}
   | IO16: {id=Sem_ALL,offset=384,size=8}
   | IO17: {id=Sem_ALL,offset=392,size=8}
   | IO18: {id=Sem_ALL,offset=400,size=8}
   | IO19: {id=Sem_ALL,offset=408,size=8}
   | IO20: {id=Sem_ALL,offset=416,size=8}
   | IO21: {id=Sem_ALL,offset=424,size=8}
   | IO22: {id=Sem_ALL,offset=432,size=8}
   | IO23: {id=Sem_ALL,offset=440,size=8}
   | IO24: {id=Sem_ALL,offset=448,size=8}
   | IO25: {id=Sem_ALL,offset=456,size=8}
   | IO26: {id=Sem_ALL,offset=464,size=8}
   | IO27: {id=Sem_ALL,offset=472,size=8}
   | IO28: {id=Sem_ALL,offset=480,size=8}
   | IO29: {id=Sem_ALL,offset=488,size=8}
   | IO30: {id=Sem_ALL,offset=496,size=8}
   | IO31: {id=Sem_ALL,offset=504,size=8}
   | IO32: {id=Sem_ALL,offset=512,size=8}
   | IO33: {id=Sem_ALL,offset=520,size=8}
   | IO34: {id=Sem_ALL,offset=528,size=8}
   | IO35: {id=Sem_ALL,offset=536,size=8}
   | IO36: {id=Sem_ALL,offset=544,size=8}
   | IO37: {id=Sem_ALL,offset=552,size=8}
   | IO38: {id=Sem_ALL,offset=560,size=8}
   | IO39: {id=Sem_ALL,offset=568,size=8}
   | IO40: {id=Sem_ALL,offset=576,size=8}
   | IO41: {id=Sem_ALL,offset=584,size=8}
   | IO42: {id=Sem_ALL,offset=592,size=8}
   | IO43: {id=Sem_ALL,offset=600,size=8}
   | IO44: {id=Sem_ALL,offset=608,size=8}
   | IO45: {id=Sem_ALL,offset=616,size=8}
   | IO46: {id=Sem_ALL,offset=624,size=8}
   | IO47: {id=Sem_ALL,offset=632,size=8}
   | IO48: {id=Sem_ALL,offset=640,size=8}
   | IO49: {id=Sem_ALL,offset=648,size=8}
   | IO50: {id=Sem_ALL,offset=656,size=8}
   | IO51: {id=Sem_ALL,offset=664,size=8}
   | IO52: {id=Sem_ALL,offset=672,size=8}
   | IO53: {id=Sem_ALL,offset=680,size=8}
   | IO54: {id=Sem_ALL,offset=688,size=8}
   | IO55: {id=Sem_ALL,offset=696,size=8}
   | IO56: {id=Sem_ALL,offset=704,size=8}
   | IO57: {id=Sem_ALL,offset=712,size=8}
   | IO58: {id=Sem_ALL,offset=720,size=8}
   | IO59: {id=Sem_ALL,offset=728,size=8}
   | IO60: {id=Sem_ALL,offset=736,size=8}
   | SPL: {id=Sem_ALL,offset=744,size=8}
   | SPH: {id=Sem_ALL,offset=752,size=8}
   | SREG: {id=Sem_ALL,offset=760,size=8}
   | PC: {id=Sem_PC,offset=0,size=16}
   | SP: @{size=16}(semantic-register-of SPL)
  end
