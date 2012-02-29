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
	B | W | DW | Q | DQW

datatype register =
   AL | AH | AX | EAX | RAX | XMM0
 | CL | CH | CX | ECX | RCX | XMM1
 | DL | DH | DX | EDX | RDX | XMM2
 | BL | BH | BX | EBX | RBX | XMM3
 | SP | ESP | RSP | XMM4
 | BP | EBP | RBP | XMM5
 | SI | ESI | RSI | XMM6
 | DI | EDI | RDI | XMM7

datatype lopnd;
datatype ropnd;
datatype opexp;

datatype lopnd =
   REG of register
 | MEM of {accesssize: size, mop: opexp}

datatype ropnd =
   RLOP of lopnd
 | IMM8 of 8
 | IMM16 of 16
 | IMM32 of 32
 | IMM64 of 64

datatype opexp =
   ESUM of { a: opexp, b:opexp }
 | EPROD of { a: opexp, b:opexp }
 | EOPND of ropnd
# | IMM of {sizeinbits: int, value: int}
# | BIN of {op: string, left:opnd, right:opnd}

#datatype lval =
# | LMEM of {accesssize: int, mop: opexp}
# | LREG of {sizeinbits: int, reg: register}

#datatype rval =
# | RMEM of {accesssize: int, mop: opexp}
# | RVAL of opexp

type binop = {op1:lopnd, op2:ropnd}

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
  return (IMM32 {value=byte1 ^ byte2 ^ byte3 ^ byte4})
dec imm64 ['byte1:8' 'byte2:8' 'byte3:8' 'byte4:8' 'byte5:8' 'byte6:8' 'byte7:8' 'byte8:8'] =
  return (IMM64 {value=byte1 ^ byte2 ^ byte3 ^ byte4 ^ byte5 ^ byte6 ^ byte7 ^ byte8})

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
   update {size=someTag}
end

# `imm` is a monadic action that reads 8 or 16 bits, depending on the current
# state
val imm = do
   sizeTag <- query $size;
   case sizeTag of
      B: imm8
    | W: imm16
end

val regN num size =
   case num of
       '000': (case size of
	         128: XMM0
	       |  64: RAX
	       |  32: EAX
	       |  16: AX
	       |   8: AL)
     | '001': (case size of
	         128: XMM1
	       |  64: RCX
	       |  32: ECX
	       |  16: CX
	       |   8: CL)
     | '010': (case size of
	         128: XMM2
	       |  64: RDX
	       |  32: EDX
	       |  16: DX
	       |   8: DL)
     | '011': (case size of
	         128: XMM3
	       |  64: RBX
	       |  32: EBX
	       |  16: BX
	       |   8: BL)
     | '100': (case size of
	         128: XMM4
	       |  64: RSP
	       |  32: ESP
	       |  16: SP
	       |   8: AH)
     | '101': (case size of
	         128: XMM5
	       |  64: RBP
	       |  32: EBP
	       |  16: BP
	       |   8: CH)
     | '110': (case size of
	         128: XMM6
	       |  64: RSI
	       |  32: ESI
	       |  16: SI
	       |   8: DH)
     | '111': (case size of
	         128: XMM7
	       |  64: RDI
	       |  32: EDI
	       |  16: DI
	       |   8: BH)


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

dec sib ['scale:2 index:3 base:3'] = do
   mod <- query $mod;
   base_exp <- case base of
   		  '000': return EAX
		| '001': return ECX
		| '010': return EDX
		| '011': return EBX
		| '100': return ESP
		| '101': (case mod of
			     '00': do
			     	      disp32 <- imm32;
				      return disp32
			     	   end
			   | '01': do
			     	      disp8 <- imm8;
				      return ESUM { disp8, EBP }
			     	   end
			   | '10': do
			     	      disp32 <- imm32;
				      return ESUM { disp32, EBP }
			     	   end)
		| '110': return ESI
		| '111': return EDI;
   case scale of
      '00': (case index of
                '000': return ESUM { base_exp, EAX }
              | '001': return ESUM { base_exp, ECX }
              | '010': return ESUM { base_exp, EDX }
              | '011': return ESUM { base_exp, EBX }
              | '100': return base_exp
              | '011': return ESUM { base_exp, EBP }
              | '011': return ESUM { base_exp, ESI }
              | '011': return ESUM { base_exp, EDI })
    | otherwise: do
    		    scale_exp <- case scale of
		    		    '01': return 2
				  | '10': return 4
				  | '11': return 8;
		    case index of
		       '000': return ESUM { base_exp, EPROD { EAX, scale_exp } }
		     | '001': return ESUM { base_exp, EPROD { ECX, scale_exp } }
		     | '010': return ESUM { base_exp, EPROD { EDX, scale_exp } }
		     | '011': return ESUM { base_exp, EPROD { EBX, scale_exp } }
		     | '100': return base_exp
		     | '011': return ESUM { base_exp, EPROD { EBP, scale_exp } }
		     | '011': return ESUM { base_exp, EPROD { ESI, scale_exp } }
		     | '011': return ESUM { base_exp, EPROD { EDI, scale_exp } }
    		 end
end


val e oS = do
   mod <- query $mod;
   rm <- query $rm;
   oS <- oS;
   aS <- addressSize;
   case mod of
      '00': (case rm of
                '000': return MEM { oS, EAX }
	      | '001': return MEM { oS, ECX }
	      | '010': return MEM { oS, EDX }
	      | '011': return MEM { oS, EBX }
	      | '011': do
	      		  sib_exp <- sib;
			  return MEM { oS, sib_exp }
		       end
	      | '101': do
	      	          disp32 <- imm32;
			  return MEM { oS, disp32 }
	      	       end
	      | '110': return MEM { oS, ESI }
	      | '111': return MEM { oS, EDI })
    | '11': return regN rm oS
end

val g oS = do
   reg <- query $reg;
   return regN reg oS
end

val i oS = do
   oS <- oS;
   case oS of
      B: imm8
    | W: imm16
    | DW: imm32
    | Q: imm64
end

val v = operandSize

val eb = e (return B)
val ev = e v

val gb = g (return B)
val gv = g v

val ib = i (return B)

val r/m16 = do
	e W
end

val r16 = do
   reg <- query $reg;
   return (regN reg 32)
end

val r32 = return EAX

val r/m32 = return EAX

val r64 = return RAX

val r/m64 = return RAX

val add a1 a2 = do
   a1 <- a1;
   a2 <- a2;
   return ADD { a1, a2 }
end

val mov a1 a2 = do
   a1 <- a1;
   a2 <- a2;
   return MOV { a1, a2 }
end

doc [0x00] = add eb gb
doc [0x01] = add ev gv
doc [0x02] = add gb eb
doc [0x03] = add gv ev
doc [0x04] = add AL ib

dec [0x80 /r]
   | opndsz = mov r/m16 r16
   | rexw = mov r/m64 r64
   | otherwise = mov r/m32 r32

dec [0x66 0xC7 /0] | opndsz = mov r16 imm16
   		   | otherwise = mov r32 imm32

dec [0x66] = do update @{opndsz=1}; continue end
dec [0x67] = do update @{addrsz=1}; continue end
