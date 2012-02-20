(* Nested
 * (* multiline
 *  * comments *)
 *)

granularity = 8


# The state of the decode monad
state =
   {mode64:1=0,
    rep:1=0,
    rexw:1=0,
    opndsz:1=0,
    addrsz:1=0}

include "x86-registers.spec"

datatype register =
   AL | AH | AX | EAX | RAX
 | BL | BH | BX | EBX | RBX
 | CL | CH | CX | ECX | RCX
 | DL | DH | DX | EDX | RDX

datatype opnd =
   REG of {sizeinbits: int, reg: register}
 | MEM of {accesssize: int, opnd: opnd}
 | IMM of {sizeinbits: int, value: int}
 | BIN of {op: string, left:opnd, right:opnd}
 | IMM8 of 8
 | IMM16 of 16
 | IMM32 of 32

type binop = {op1:opnd, op2:opnd}

datatype insn =
   MOV of binop
 | ADD of binop
 | SUB of binop
 | MUL of binop
 | DIV of binop

# Example of bit-patterns
dec /0 ['mod:2 001 rm:3'] = update @{mod=mod, rm=rm, reg/opcode=1}
dec /r ['mod:2 reg/opcode:3 rm:3'] = update @{mod=mod, reg/opcode=reg/opcode, rm=rm}

val fromEnum i =
   case i of
      '0000': RAX
    | '0001': RBX

dec imm8 ['byte:8'] = return (IMM8 {value=byte})
dec imm16 ['byte1:8' 'byte2:8'] = return (IMM16 {value=byte1 ^ byte2})
dec imm32 ['byte1:8' 'byte2:8' 'byte3:8' 'byte4:8'] =
  return (IMM16 {value=byte1 ^ byte2 ^ byte3 ^ byte4})


val r/m16 = do
   mod <- query $mod;
   rm <- query $rm;
   case mod of
      '001': return AX
    | '010': return BX
end

val r16 = return EAX

val r32 = return EAX

val r/m32 = return EAX

val r64 = return RAX

val r/m64 = return RAX

val mov a1 a2 = do
   a1 <- a1;
   a2 <- a2;
   return (MOV {op1=a1, op2=a2})
end

dec [0x80 /r]
   | opndsz = mov r/m16 r16
   | rexw = mov r/m64 r64
   | otherwise = mov r/m32 r32

dec [0x66 0xC7 /0]
   | opndsz = mov r16 imm16
   | otherwise = mov r32 imm32

dec [0x66] = do update @{opndsz=1}; continue end
