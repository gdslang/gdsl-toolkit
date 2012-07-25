
val semantic-register-of r = 
   case r of
       RAX: {id=ARCH_R 0,offset=0,size=64}
     | RBX: {id=ARCH_R 1,offset=0,size=64}
     | RCX: {id=ARCH_R 2,offset=0,size=64}
     | RDX: {id=ARCH_R 3,offset=0,size=64}
     | R8 : {id=ARCH_R 4,offset=0,size=64}
     | R9 : {id=ARCH_R 5,offset=0,size=64}
     | R10: {id=ARCH_R 6,offset=0,size=64}
     | R11: {id=ARCH_R 7,offset=0,size=64}
     | R12: {id=ARCH_R 8,offset=0,size=64} 
     | R13: {id=ARCH_R 9,offset=0,size=64} 
     | R14: {id=ARCH_R 10,offset=0,size=64} 
     | R15: {id=ARCH_R 11,offset=0,size=64} 
     | RSP: {id=ARCH_R 12,offset=0,size=64}
     | RBP: {id=ARCH_R 13,offset=0,size=64}
     | RSI: {id=ARCH_R 14,offset=0,size=64}
     | RDI: {id=ARCH_R 15,offset=0,size=64}
     | EAX: {id=ARCH_R 0,offset=0,size=32}
     | EBX: {id=ARCH_R 1,offset=0,size=32}
     | ECX: {id=ARCH_R 2,offset=0,size=32}
     | EDX: {id=ARCH_R 3,offset=0,size=32}
     | R8D: {id=ARCH_R 4,offset=0,size=32}
     | R9D: {id=ARCH_R 5,offset=0,size=32}
     | R10D: {id=ARCH_R 6,offset=0,size=32}
     | R11D: {id=ARCH_R 7,offset=0,size=32}
     | R12D: {id=ARCH_R 8,offset=0,size=32} 
     | R13D: {id=ARCH_R 9,offset=0,size=32} 
     | R14D: {id=ARCH_R 10,offset=0,size=32} 
     | R15D: {id=ARCH_R 11,offset=0,size=32} 
     | ESP: {id=ARCH_R 12,offset=0,size=32}
     | EBP: {id=ARCH_R 13,offset=0,size=32}
     | ESI: {id=ARCH_R 14,offset=0,size=32}
     | EDI: {id=ARCH_R 15,offset=0,size=32}
   end

val arch-show-id r =
  case r of
     0:  "RAX" 
   | 1:  "RBX"
   | 2:  "RCX"
   | 3:  "RDX"
   | 4:  "R8"
   | 5:  "R9"
   | 6:  "R10"
   | 7:  "R11"
   | 8:  "R12"
   | 9:  "R13"
   | 10: "R14"
   | 11: "R15"
   | 12: "RSP"
   | 13: "RBP"
   | 14: "RSI"
   | 15: "RDI"
   | _ : "ARCH(" +++ showint r +++ ")"
  end
