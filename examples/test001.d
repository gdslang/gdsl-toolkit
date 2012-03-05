granularity = 8

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

dec /0 ['mod:2 000 rm:3'] = update @{mod=mod, rm=rm, reg/opcode=0}
dec /1 ['mod:2 001 rm:3'] = update @{mod=mod, rm=rm, reg/opcode=1}
dec /2 ['mod:2 010 rm:3'] = update @{mod=mod, rm=rm, reg/opcode=2}
dec /3 ['mod:2 011 rm:3'] = update @{mod=mod, rm=rm, reg/opcode=3}
dec /4 ['mod:2 100 rm:3'] = update @{mod=mod, rm=rm, reg/opcode=4}
dec /5 ['mod:2 101 rm:3'] = update @{mod=mod, rm=rm, reg/opcode=5}
dec /6 ['mod:2 110 rm:3'] = update @{mod=mod, rm=rm, reg/opcode=6}
dec /7 ['mod:2 111 rm:3'] = update @{mod=mod, rm=rm, reg/opcode=7}

dec [0x83 /0] = return ADD
dec [0x83 /1] = return OR
dec [0x83 /2] = return ADC
dec [0x83 /3] = return SBB
dec [0x83 /4] = return AND
dec [0x83 /5] = return SUB
dec [0x83 /6] = return XOR
dec [0x83 /7] = return CMP

dec [0x66] = do update @{opndsz=1}; continue end
