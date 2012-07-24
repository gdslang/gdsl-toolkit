
val semanticRegisterOf r = 
   case r of
      RAX: {id=ARCH_R 0,offset=0,size=64}
    | RBX: {id=ARCH_R 1,offset=0,size=64}
    | RBP: {id=ARCH_R 2,offset=0,size=64}
    | RSP: {id=ARCH_R 3,offset=0,size=64}
    | EAX: {id=ARCH_R 0,offset=0,size=32}
    | EBX: {id=ARCH_R 1,offset=0,size=32}
    | EBP: {id=ARCH_R 2,offset=0,size=32}
    | ESP: {id=ARCH_R 3,offset=0,size=32}
   end

val show/arch r =
  case r of
     0: "RAX"
   | 1: "RBX"
   | 2: "RBP"
   | 3: "RSP"
   | _ : "ARCH(" +++ showint r +++ ")"
  end
