granularity = 8

export = main

# The state of the decode monad
state =
   {mode64:1=0,
    rep:1=0,
    rexw:1=0,
    opndsz:1=0,
    addrsz:1=0}

datatype reg =
   EAX
 | EBX
 | RAX

datatype op =
   REG of reg
 | MEM of {accSz:int, ptrSz:int, op:op}

type binop = {op1:op, op2:op}

datatype insn =
   MOV of binop
 | ADD of binop
 | OR of binop
 | ADC of binop
 | SBB of binop
 | AND of binop
 | XOR of binop
 | CMP of binop
 | SUB of binop

val /0 ['mod:2 000 rm:3'] = update @{mod=mod, rm=rm, reg/opcode='000'}
val /1 ['mod:2 001 rm:3'] = update @{mod=mod, rm=rm, reg/opcode='001'}
val /2 ['mod:2 010 rm:3'] = update @{mod=mod, rm=rm, reg/opcode='010'}
val /3 ['mod:2 011 rm:3'] = update @{mod=mod, rm=rm, reg/opcode='011'}
val /4 ['mod:2 100 rm:3'] = update @{mod=mod, rm=rm, reg/opcode='100'}
val /5 ['mod:2 101 rm:3'] = update @{mod=mod, rm=rm, reg/opcode='101'}
val /6 ['mod:2 110 rm:3'] = update @{mod=mod, rm=rm, reg/opcode='110'}
val /7 ['mod:2 111 rm:3'] = update @{mod=mod, rm=rm, reg/opcode='111'}

val r64 = do
   r <- query $rexw;
   case r of
      '0': return RAX
    | '1': return RAX 
   end
end

val r/m64 = return (MEM {ptrSz=64, accSz=64, op=RAX})

val binop cons giveOp1 giveOp2 = do
   op1 <- giveOp1;
   op2 <- giveOp2;
   return (cons {op1=op1, op2=op2})
end

val main [0x83 /0] = binop MOV r64 r64

#val main [0x83 /1] = binop OR r64 r/m64
#val main [0x83 /2] = binop ADC r64 r/m64
#val main [0x83 /3] = binop SBB r64 r/m64
#val main [0x83 /4] = binop AND r64 r/m64
#val main [0x83 /5] = binop SUB r64 r/m64
#val main [0x83 /6] = binop XOR r64 r/m64
#val main [0x83 /7] = binop CMP r64 r/m64

val main [0x66] = do update @{opndsz='1'}; main end
