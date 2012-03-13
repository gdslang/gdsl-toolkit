(* Nested
 * (* multiline
 *  * comments *)
 *)

granularity = 32

datatype rex = REX of { w:1, r:1, x:1, b:1 }

# The state of the decode monad
state =
   {mode64:1=0,
    rep:1=0,
    rexw:1=0,
    opndsz:1=0,
    addrsz:1=0,
    rex:rex = REX { w = 0, r = 0,  x = 0, b = 0 }
    }

#include "x86-registers.spec"

datatype size =
	B | W | DW | QW | DQW

datatype register =
   AL | AH | AX | EAX | RAX | XMM0
 | CL | CH | CX | ECX | RCX | XMM1
 | DL | DH | DX | EDX | RDX | XMM2
 | BL | BH | BX | EBX | RBX | XMM3
 | SP | ESP | RSP | XMM4
 | BP | EBP | RBP | XMM5
 | SI | ESI | RSI | XMM6
 | DI | EDI | RDI | XMM7
 | R8L  | R8W  | R8D  | R8
 | R9L  | R9W  | R9D  | R9
 | R10L | R10W | R10D | R10
 | R11L | R11W | R11D | R11
 | R12L | R12W | R12D | R12
 | R13L | R13W | R13D | R13
 | R14L | R14W | R14D | R14
 | R15L | R15W | R15D | R15
 | R16L | R16W | R16D | R16

datatype opexp =
   REG of register
 | IMM8 of 8
 | IMM16 of 16
 | IMM32 of 32
 | IMM64 of 64
 | ESUM of { a:opexp, b:opexp }
 | EPROD of { a:opexp, b:opexp }

datatype mopnd = MEM of {accesssize: size, mop: opexp}

datatype lopnd =
   LDIR of register
 | LMEM of mopnd

datatype ropnd =
   RDIR of opexp
 | RMEM of mopnd

type binop = { l:lopnd, r:ropnd}

datatype insn =
   MOV of binop
 | ADD of binop
 | SUB of binop
 | MUL of binop
 | DIV of binop

# Example of bit-patterns
dec /0 ['mod:2 000 rm:3'] = update @{mod=mod, rm=rm, reg/opcode=1}
dec /r ['mod:2 reg/opcode:3 rm:3'] = update @{mod=mod, reg/opcode=reg/opcode, rm=rm}

val fromEnum i =
   case i of
      '0000': RAX
    | '0001': RBX

dec imm8 ['byte:8'] = return (IMM8 {value=byte})
dec imm16 ['byte1:8' 'byte2:8'] = return (IMM16 {value=byte1 ^ byte2})
dec imm32 ['byte1:8' 'byte2:8' 'byte3:8' 'byte4:8'] =
  return (IMM32 {value=byte1 ^ byte2 ^ byte3 ^ byte4})
dec imm64 ['byte1:8' 'byte2:8' 'byte3:8' 'byte4:8' 'byte5:8' 'byte6:8' 'byte7:8' 'byte8:8'] =
  return (IMM64 {value=byte1 ^ byte2 ^ byte3 ^ byte4 ^ byte5 ^ byte6 ^ byte7 ^ byte8})

val reg8 num =
   case num of
       0: AL
    |  1: CL
    |  2: DL
    |  3: BL
    |  4: AH
    |  5: CH
    |  6: DH
    |  7: BH
    |  8: R8L
    |  9: R10L
    | 10: R11L
    | 11: R9L
    | 12: R12L
    | 13: R13L
    | 14: R14L
    | 15: R15L

val reg16 num =
   case num of
       0: AX
    |  1: CX
    |  2: DX
    |  3: BX
    |  4: SP
    |  5: BP
    |  6: SI
    |  7: DI
    |  8: R8W
    |  9: R10W
    | 10: R11W
    | 11: R9W
    | 12: R12W
    | 13: R13W
    | 14: R14W
    | 15: R15W

val reg32 num =
   case num of
       0: EAX
    |  1: ECX
    |  2: EDX
    |  3: EBX
    |  4: ESP
    |  5: EBP
    |  6: ESI
    |  7: EDI
    |  8: R8D
    |  9: R10D
    | 10: R11D
    | 11: R9D
    | 12: R12D
    | 13: R13D
    | 14: R14D
    | 15: R15D

val reg64 num =
   case num of
       0: RAX
    |  1: RCX
    |  2: RDX
    |  3: RBX
    |  4: RSP
    |  5: RBP
    |  6: RSI
    |  7: RDI
    |  8: R8
    |  9: R10
    | 10: R11
    | 11: R9
    | 12: R12
    | 13: R13
    | 14: R14
    | 15: R15

val reg128 num =
   case num of
       0: XMM0
    |  1: XMM1
    |  2: XMM2
    |  3: XMM3
    |  4: XMM4
    |  5: XMM5
    |  6: XMM6
    |  7: XMM7

val regLower regN num = regN num
val regUpper regN num = regN (num + 8)

val regS size
   case size of
      B: reg8
    | W: reg16
    | DW: reg32
    | QW: reg64
    | DQW: reg128

val regSRex = do
   rex <- query $rex;
   case $b rex of 0: return regLower | otherwise: return regUpper
end

val operandSize = do
   rex <- query $rex;
   opndsz <- query $opndsz;
   case ($w rex) of
      '0': (case opndsz of
   	       '0': return DW
   	     | '1': return W)
    | '1': return QW
end

val addressSize = do
   addrsz <- query $addrsz;
   case addrsz of
      '0': return QW
    | '1': return DW
end	

#dec base ['000'] = reg
#dec sib['scale index base']

dec sib ['scale:2 index:3 base:3'] = do
   mod <- query $mod;
   reg <- regSRex;
   aS <- addressSize;
   base_exp <- case base of
		| '101': (case mod of
			     '00': do
			     	      disp32 <- imm32;
				      return disp32
			     	   end
			   | '01': do
			     	      disp8 <- imm8;
				      return ESUM { a = disp8, b = reg rBP aS }
			     	   end
			   | '10': do
			     	      disp32 <- imm32;
				      return ESUM { a = disp32, b = reg rBP aS }
			     	   end)
		| br: return reg (regS aS) (unsigned br);
   case scale of
      '00': (case index of
              | '100': return base_exp
              | ir: return ESUM { a = base_exp, b = reg (regS aS) (unsigned br) })
    | otherwise: do
    		    scale_exp <- case scale of
		    		    '01': return bits8(2)
				  | '10': return bits8(4)
				  | '11': return bits8(8);
		    case index of
		     | '100': return base_exp
		     | ir: return ESUM { a = base_exp, b = EPROD { a = reg (regS aS) (unsigned ir), b = scale_exp } }
    		 end
end

val e oS = do
   mod <- query $mod;
   rm <- query $rm;
   oS <- oS;
   aS <- addressSize;
   reg <- regSRex;
   case mod of
      '00': (case rm of
	      | '011': do
	      		  sib_exp <- sib;
			  return MEM { accesssize = oS, mop = sib_exp }
		       end
	      | '101': do
	      	          disp32 <- imm32;
			  return MEM { accesssize = oS, mop = disp32 }
	      	       end
	      | br: return MEM { accesssize = oS, mop = reg (regS oS) (unsigned rm) }
    | '11': return reg (regS oS) (unsigned rm)
    | otherwise: do
    		    disp_exp <- case mod of
		    		   '01': do
			     	            disp8 <- imm8;
				            return disp8
			     	         end
		    		 | '10': do
			     	            disp32 <- imm32;
				            return disp32
			     	         end;
		    case rm of
		     | '011': do
			  sib_exp <- sib;
			  return MEM { accesssize = oS, mop = sib_exp }
		              end
		     | '101': do
			  disp32 <- imm32;
			  return MEM { accesssize = oS, mop = disp32 }
		              end
		     | br: return MEM { accesssize = oS, mop = ESUM { a = reg (regS oS) (unsigned rm), b = disp_exp } }    
                 end
end

val g oS = do
   register <- query $reg;
   reg <- regSRex;
   return reg (regS oS) (unsigned register)
end

val i oS = do
   oS <- oS;
   case oS of
      B: imm8
    | W: imm16
    | DW: imm32
    | QW: imm64
end

val b = return B
val w = return W
val d = return DW
val q = return QW
val v = operandSize
val z = do
   oS <- operandSize;
   case oS of
      W: return W
    | DW: return DW
    | QW: return QW
end

val eb = e b
val ev = e v

val gb = g b
val gv = g v

val ib = i b
val iz = i z

val al = return AL
val ax = return AX
val eax = return EAX
val rax = return RAX

val rAX = do
   oS <- operandSize;
   case oS of
      W: return AX
    | DW: return EAX
    | QW: return RAX
end

val r/m8 = e b
val r/m16 = e w
val r/m32 = e d
val r/m64 = e q

val r8 = g b
val r16 = g w
val r32 = g d
val r64 = g q

val add a1 a2 = do
   a1 <- a1;
   a2 <- a2;
   return ADD { l = a1, r = a2 }
end

val mov a1 a2 = do
   a1 <- a1;
   a2 <- a2;
   return MOV { l = a1, r = a2 }
end

dec [0x04] = add al imm8
dec [0x05]
   | rexw = return (add rax imm64)
   | opndsz = return (add eax imm32)
   | otherwise = return (add ax imm16)
dec [0x80 /0] = r/m8 imm8
dec [0x81 /0]
   | rexw = return (add r/m64 imm64)
   | opndsz = return (add r/m32 imm32)
   | otherwise = return (add r/m16 imm16)
dec [0x83 /0]
   | rexw = return (add r/m64 imm8)
   | opndsz = return (add r/m32 imm8)
   | otherwise = return (add r/m16 imm8)
dec [0x00 /r] = add r/m8 r8
dec [0x01 /0]
   | rexw = return (add r/m64 r64)
   | opndsz = return (add r/m32 r32)
   | otherwise = return (add r/m16 r16)
dec [0x02 /r] = add r8 r/m8
dec [0x03 /0]
   | rexw = return (add r64 r/m64)
   | opndsz = return (add r32 r/m32)
   | otherwise = return (add r16 r/m16)

# ???
#dec [0x80 /r]
#   | opndsz = mov r/m16 r16
#   | rexw = mov r/m64 r64
#   | otherwise = mov r/m32 r32
#dec [0x66 0xC7 /0] | opndsz = mov r16 imm16
#   		   | otherwise = mov r32 imm32

dec [0x66] = do update @{opndsz=1}; continue end
dec [0x67] = do update @{addrsz=1}; continue end
dec ['0100 w:1 r:1 x:1 b:1'] = do update @{rex = { w = w, r = r, x = x, b = b }}; continue end

