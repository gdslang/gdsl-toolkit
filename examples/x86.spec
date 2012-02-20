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
   RAX | EAX | AX | AH | AL
 | RBX | EBX | BX | BH | BL
 | RCX | ECX | CX | CH | CL

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
dec /0 ['mod:2 001 rm:3'] = update {mod=mod, rm=rm, reg/opcode=1}
dec /r ['mod:2 reg/opcode:3 rm:3'] = update {mod=mod, reg/opcode=reg/opcode, rm=rm}

val fromEnum i =
   case i of
      '0000': RAX
    | '0001': RBX

dec imm8 ['byte:8'] = return (IMM8 {value=byte})
dec imm16 ['byte1:8' 'byte2:8'] = return (IMM16 {value=byte1 ^ byte2})
dec imm32 ['byte1:8' 'byte2:8' 'byte3:8' 'byte4:8'] = return (IMM32 {value=byte1 ^ byte2 ^ byte3 ^ byte4})

# The 's' action reads one bit and updates the monadic state
dec s ['sizeBit:1'] = let
   val sizeBit =
      case sizeBit of
         '0': B
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

val regByNum num =
   case reg of
       '000': return AX
     | '001': return CX
     | '010': return DX
     | '011': return BX
     | '100': return SP
     | '101': return BP
     | '110': return SI
     | '111': return DI
end

val r/m16 = do
   mod <- query mod;
   rm <- query rm;
   case mod of
      '00': case rm of
             ...
    | '11: return (regByNum rm)
end

val r16 = do
   reg <- query reg;
   return (regByNum reg)
end

val mov a1 a2 = do
   a1' <- a1;
   a2' <- a2;
   return (MOV {op1=a1', op2=a2'})
end

val add a1 a2 = do
   a1' <- a1;
   a2' <- a2;
   return (ADD {op1=a1', op2=a2'})
end

dec [0x80 /r]
   | OPNDSZ = mov r/m16 r16
   | REXW = mov r/m64 r64
   | otherwise = mov r/m32 r32

dec [0x66 0xC7 /0]
   | OPNDSZ = mov r16 imm16
   | otherwise = mov r32 imm32

dec [0x04]
     add AL imm8

dec [0x05]
     add AX imm16

dec [0x66] = do update {OPNDSZ=1}; continue end
