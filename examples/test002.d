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

val /0 ['mod:2 000 rm:3']
 | $opndsz = update @{opndsz=0}
 | $addrsz = update @{addrsz=0}

val main [0x83 /0] = return ADD

val main [0x66] = do update @{opndsz=1}; main end
