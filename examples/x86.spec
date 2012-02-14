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

include "x86-registers.spec"

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
val /0 ['mod:2 001 rm:3'] = update {mod=mod, rm=rm, reg/opcode=1}
val /r ['mod:2 reg/opcode:3 rm:3'] = update {mod=mod, reg/opcode=reg/opcode, rm=rm}

val fromEnum i =
   case i of
      '0000': RAX
    | '0001': RBX

val imm8 ['byte:8'] = return (IMM8 {value=byte})
val imm16 ['byte1:8' 'byte2:8'] = return (IMM16 {value=byte1 ^ byte2})

# The 's' action reads one bit and updates the monadic state
val s ['sizeBit:1'] = let
   val sizeTag =
      case sizeBit of
         '0':B
       | '1': W
   val someTag =
      case sizeBit of
         '0': W
       | '1': B
in
   update {size=sizeTag}
end

# `imm` is a monadic action that reads 8 or 16 bits, depending on the current
# state
val imm = do
   sizeTag <- query size;
   case sizeTag of
      B: imm8
    | W: imm16
end

decode [0x80 /r]
   | OPNDSZ = mov r/m16 r16
   | REXW = mov r/m64 r64
   | otherwise = mov r/m32 r32

decode [0xC7 /0]
   | OPNDSZ = mov r16 imm16
   | otherwise = mov r32 imm32

decode [0x66] = do update {OPNDSZ=1}; continue end