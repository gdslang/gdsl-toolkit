granularity = 8

export = main

# The state of the decode monad
state =
   {mode64:1=0,
    rep:1=0,
    rexw:1=0,
    opndsz:1=0,
    addrsz:1=0}

datatype insn =
   MOV
 | ADD
 | AND
 | ADC
 | CMP
 | OR
 | SBB
 | SUB
 | XOR

val /0 ['mod:2 000 rm:3'] = update @{mod=mod, rm=rm, reg/opcode=0}
val /1 ['mod:2 001 rm:3'] = update @{mod=mod, rm=rm, reg/opcode=1}
val /2 ['mod:2 010 rm:3'] = update @{mod=mod, rm=rm, reg/opcode=2}
val /3 ['mod:2 011 rm:3'] = update @{mod=mod, rm=rm, reg/opcode=3}
val /4 ['mod:2 100 rm:3'] = update @{mod=mod, rm=rm, reg/opcode=4}
val /5 ['mod:2 101 rm:3'] = update @{mod=mod, rm=rm, reg/opcode=5}
val /6 ['mod:2 110 rm:3'] = update @{mod=mod, rm=rm, reg/opcode=6}
val /7 ['mod:2 111 rm:3'] = update @{mod=mod, rm=rm, reg/opcode=7}

val main [0x83 /0] = return ADD
val main [0x83 /1] = return OR
val main [0x83 /2] = return ADC
val main [0x83 /3] = return SBB
val main [0x83 /4] = return AND
val main [0x83 /5] = return SUB
val main [0x83 /6] = return XOR
val main [0x83 /7] = return CMP

val main [0x66] = do update @{opndsz=1}; main end
