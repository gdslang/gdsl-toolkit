(* Nested
 * (* multiline
 *  * comments *)
 *)

granularity = 32

# The state of the decode monad
state =
   {MODE64:1=0,
    REP:1=0,
    REXW:1=0,
    OPNDSZ:1=0,
    ADDRSZ:1=0}

#include "x86-registers.spec"

datatype register =
   EAX
 | EBX
 | ECX

datatype opnd =
   REG of {sizeinbits: int, reg: register}
 | MEM of {accesssize: int, opnd: opnd}
 | IMM of {sizeinbits: int, value: int}
 | BIN of {op: string, left:opnd, right:opnd}

type binop = {op1:opnd, op2:opnd}

datatype insn =
   MOV of binop
 | ADD of binop
 | SUB of binop
 | MUL of binop
 | DIV of binop

# Example of bit-patterns
/0 ['mod:2 001 rm:3'] = update {mod=mod, rm=rm, reg/opcode=1}
/r ['mod:2 reg/opcode:3 rm:3'] = update {mod=mod, reg/opcode=reg/opcode, rm=rm}

decode [80 /r]
   | OPNDSZ = mov r/m16 r16
   | REXW = mov r/m64 r64
   | otherwise = mov r/m32 r32

decode [C7 /0]
   | OPNDSZ = mov r16 imm16
   | otherwise = mov r32 imm32

decode [66] = do update {OPNDSZ=1}; continue;