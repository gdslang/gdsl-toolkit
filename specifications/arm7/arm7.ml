# ======================================================================
# ARMv7 Instruction Set Decoder
# ----------------------------------------------------------------------
# * Currently, only 32bit ARM instructions are supported.
# * Refernces to the ARMv7 manual are marked like this: [[AX.Y.Z]]
#   Note: The ARMv7-A and ARMv7-R Manual (Issue C.c) was used.
# ======================================================================

# ----------------------------------------------------------------------
# Configuration
# ----------------------------------------------------------------------

export config-default: decoder-configuration
export decode: (decoder-configuration) -> S insndata <{} => {}>
export decoder-config : configuration[vec=decoder-configuration]
export insn-length: (insndata) -> int
export operands : (insndata) -> int

type decoder-configuration = 0

type insndata = {length:int, insn:instruction}

val config-default = ''
val decoder-config = END

(* TODO: *)
val operands i = 0

(* TODO *)
val typeof-opnd insn i = 0

val insn-length insn = insn.length

# ----------------------------------------------------------------------
# Main Entry Point
# ----------------------------------------------------------------------

val decode config = do
  (*TODO: Maybe this should be handled via cmdline input?*)
  endianness endian-little/instr32-little/access32;

  reset;

  idx-before <- get-ip;
  insn <- /;
  idx-after <- get-ip;

  return {length=(idx-after - idx-before), insn=insn}
end

# ----------------------------------------------------------------------

val reset = do
  update @{shiftoperation=0};
  update @{rm='0000', shifttype='00'};
  update @{shift_amount='00000'};
  update @{shift_register='0000'};
  update @{imm='00000000'};
  update @{rotate='0000'};
  update @{b='0', p='0', w='0', u='0'}
end

# ----------------------------------------------------------------------
# Type Definitions
# ----------------------------------------------------------------------

type instruction =
   ADC of dp # Missing: ADR, ORN
 | ADD of dp
 | AND of dp
 | BIC of dp
 | CMN of dp
 | CMP of dp
 | EOR of dp
 | MOV of dp
 | MVN of dp
 | ORR of dp
 | RSB of dp
 | RSC of dp
 | SBC of dp
 | SUB of dp
 | TEQ of dp
 | TST of dp
 | MLA of mul # Missing: MLS
 | MUL of mul
 | SMLAL of mull
 | SMULL of mull
 | UMLAL of mull
 | UMULL of mull
 | LDR of loadstore
 | STR of loadstore
 | LDRH of loadstore
 | STRH of loadstore
 | LDRSB of loadstore
 | LDRSRH of loadstore
 | B of br
 | BL of br
 | BLX_reg of bx
 | BLX_imm of {h:1, imm24:24}
 | BX of bx
 | BXJ of bx
 | MRS of psr_transfer
 | MSR of psr_transfer
 | CLREX

type signed =
   SIGNED
 | UNSIGNED

type updown =
   UP
 | DOWN

type width =
   BYTE
 | WORD
 | HALFWORD

type psr =
   CPSR
 | SPSR # _<current mode>

# Standard data-processing instruction
type dp = {
  cond:condition, # condition code
  s:1,            # whether the C flag should be set
  rn:register,    # first operand register
  rd:register,    # destination register
  op2:operand     # second operand (immediate or register)
}

type mul = {
  condition:condition,
  s:1,
  rd:register,
  rn:register,
  rs:register,
  rm:register
}

type mull = {
  condition:condition,
  s:1,
  rdhi:register,
  rdlo:register,
  rs:register,
  rm:register
}

type loadstore = {
  p:1,
  u:updown,
  b:width,
  w:1,
  rn: register,
  rd:register,
  offset: operand
}

# Standard Branching instructions
type br = {
  cond:condition,
  imm24:24
}

# Branch and Exchange instructions
type bx = {
  cond:condition,
  rm:register
}

type psr_transfer = {
  condition:condition,
  source:operand,
  destination:operand,
  flagsonly:1
}

type operand =
   IMMEDIATE of int
 | CONST of const
 | IMM24 of 24
 | REGISTER of register
 | IMMSHIFTEDREGISTER of immshiftedreg # Register shifted by immediate
 | REGSHIFTEDREGISTER of regshiftedreg # Register shifted by register
 | PSR of psr

type const = {
  byte:8, # numeric value
  rot:4   # rotation
}

type regshiftedreg = {
  rm:register, register:register, shift_type:shifttype
}

type immshiftedreg = {
  rm:register, amount:int, shift_type:shifttype
}

type shifttype =
   LLS # logical left shift
 | LRS # logical right shift
 | ARS # arithmetic right shift
 | RR  # rotate right

type register =
   R0  # Argument1, Return Value: Temporory register
 | R1  # Argument2, Second 32-bits if double/int Return Value: Temporary register
 | R2  # Argument: Temporary register
 | R3  # Argument: Temporary register
 | R4  # permanent register
 | R5  # permanent register
 | R6  # permanent register
 | R7  # permanent register (THUMB frame pointer)
 | R8  # permanent register
 | R9  # permanent register
 | R10 # permanent register
 | R11 # ARM frame pointer: permanent register
 | R12 # Temporary register
 | R13 # Stack pointer: permanent register
 | R14 # Link register: permanent register
 | R15 # Program Counter

type condition =
   EQ
 | NE
 | CS
 | CC
 | MI
 | PL
 | VS
 | VC
 | HI
 | LS
 | GE
 | LT
 | GT
 | LE
 | AL

val dp cons cond s rn rd op2 = do
  cond <- cond;
  s <- s;
  op2 <- op2;
  return (cons{cond=cond, s=s, rn=rn, rd=rd, op2=op2})
end

val mul cons condition s rd rn rs rm = do
  condition <- condition;
  s <- s;
  return (cons{condition=condition, s=s, rd=rd, rn=rn, rs=rs, rm=rm})
end

val mull cons condition s rdhi rdlo rs rm = do
  condition <- condition;
  s <- s;
  return (cons{condition=condition, s=s, rdhi=rdhi, rdlo=rdlo, rs=rs, rm=rm})
end

val loadstore cons condition p u b w rn rd offset = do
  condition <- condition;
  p <- p;
  u <- u;
  b <- b;
  w <- w;
  offset <- offset;
  return (cons{condition=condition, p=p, u=u, b=b, w=w, rn=rn, rd=rd, offset=offset})
end

val br cons cond imm24 = do
  cond <- cond;
  return (cons{cond=cond, imm24=imm24})
end

val bx cons cond rm = do
  cond <- cond;
  return (cons{cond=cond, rm=(register-from-bits rm)})
end

val const cons byte rot = do
  return (cons{byte=byte, rot=rot})
end

val regshiftedreg cons rm register shift_type = do
  return (cons{rm=rm, register=register, shift_type=shift_type})
end

val immshiftedreg cons rm amount shift_type = do
  return (cons{rm=rm, amount=amount, shift_type=shift_type})
end

val psr_transfer cons condition source destination flagsonly = do
  condition <- condition;
  source <- source;
  return (cons{condition=condition, source=source, destination=destination, flagsonly=flagsonly})
end

val register-from-bits bits =
  case bits of
     '0000' : R0
   | '0001' : R1
   | '0010' : R2
   | '0011' : R3
   | '0100' : R4
   | '0101' : R5
   | '0110' : R6
   | '0111' : R7
   | '1000' : R8
   | '1001' : R9
   | '1010' : R10
   | '1011' : R11
   | '1100' : R12
   | '1101' : R13
   | '1110' : R14
  end

val updown-from-bits bits =
  case bits of
      '0' : DOWN
    | '1' : UP
  end

val width-from-bits bits =
  case bits of
      '0' : WORD
    | '1' : BYTE
  end

val shifttype-from-bits bits = 
  case bits of
      '00' : LLS
    | '01' : LRS
    | '10' : ARS
    | '11' : RR
  end

val cond-from-bits bits =
  case bits of
     '0000': EQ
   | '0001': NE
   | '0010': CS
   | '0011': CC
   | '0100': MI
   | '0101': PL
   | '0110': VS
   | '0111': VC
   | '1000': HI
   | '1001': LS
   | '1010': GE
   | '1011': LT
   | '1100': GT
   | '1101': LE
   | '1110': AL
  end

# Condition subdecoder (4 bit condition code; cannot be '1111')
val /cond ['cond@0...'] = update@{cond=cond}
val /cond ['cond@10..'] = update@{cond=cond}
val /cond ['cond@110.'] = update@{cond=cond}
val /cond ['cond@1110'] = update@{cond=cond}

val cond = do
  cond <- query $cond;
  update @{cond='0000'};
  return (cond-from-bits cond)
end

# Immediate subdecoder (12 bit immediate)
val /imm12 ['rot:4 byte:8'] = update@{rot=rot, byte=byte}

val imm12 = do
  rot <- query $rot;
  byte <- query $byte;
  update @{rot='0000', byte='00000000'};
  ret <- const CONST byte rot;
  return (ret)
end

(**)

# Operand subdecoder: Immediate
# val /op2imm ['rotate:4 imm:8'] = update@{rotate=rotate, imm=imm}

# Operand subdecoder: Register + Immediate shift
val /op2register ['shift:5 shifttype:2 0 rm:4'] = update@{shiftoperation=0, shift_amount=shift, shifttype=shifttype, rm=rm}

# Operand subdecoder: Register + Register controlled shift
val /op2register ['shiftregister:4 0 shifttype:2 1 rm:4'] = update@{shiftoperation=1, shift_register=shiftregister, shifttype=shifttype, rm=rm}

val op2register = do
  shiftoperation <- query $shiftoperation;
  rm <- query $rm;
  shifttype <- query $shifttype;
  shift_amount <- query $shift_amount;
  shift_register <- query $shift_register;
  reset;
  ret <- case shiftoperation of
     0 : immshiftedreg IMMSHIFTEDREGISTER (register-from-bits rm) (zx shift_amount) (shifttype-from-bits shifttype)
   | 1 : regshiftedreg REGSHIFTEDREGISTER (register-from-bits rm) (register-from-bits shift_register) (shifttype-from-bits shifttype)
  end;
  return (ret)
end

(*TODO: this is plain wrong!*)
# val op2imm = do
#   imm <- query $imm;
#   rotate <- query $rotate;
#   reset;
#   zero extend imm to 32 bits
#   rotate right imm by 2 times rotate
#   return (CONST ({byte=zx imm, rot=zx rotate}))
# end

# S flag subdecoder
val /s ['s:1'] = update@{s=s}

val s = do
  s <- query $s;
  update @{s='0'};
  return (s)
end

# ----------------------------------------------------------------------
# Instruction Decoding
# ----------------------------------------------------------------------

# --- Branching Instructions -------------------------------------------

### B
### - Branch [[A8.8.18]]
val / ['/cond 1010 imm24:24'] = br B cond imm24

### BL
###  - Branch with Link [[A8.8.25]]
val / ['/cond 1011 imm24:24'] = br BL cond imm24

### BLX
###  - Branch with Link and Exchange (Immediate) [[A8.8.25]]
val / ['1111 101 h:1 imm24:24'] = return (BLX_imm {h=h, imm24=imm24})
###  - Branch with Link and Exchange (Register) [[A8.8.26]]
val / ['/cond 000100101111111111110111 rm:4'] = bx BLX_reg cond rm

### BX
### - Branch and Exchange [[A8.8.27]]
val / ['/cond 000100101111111111110001 rm:4'] = bx BX cond rm

### BXJ
###  - Branch and Exchange Jazelle [[A8.8.28]]
val / ['/cond 000100101111111111110010 rm:4'] = bx BXJ cond rm

# --- Data Processing Instructions -------------------------------------

### ADC
###  - Add with Carry (immediate) [[A8.8.1]]
val / ['/cond 0010101 /s rn:4 rd:4 /imm12'] = dp ADC cond s (register-from-bits rn) (register-from-bits rd) (imm12)
###  - Add with Carry (register or register-shifted register) [[A8.8.2]] [[A8.8.3]]
val / ['/cond 0000101 /s rn:4 rd:4 /op2register'] = dp ADC cond s (register-from-bits rn) (register-from-bits rd) (op2register)

### ADD
###  - Add (immediate) [[A8.8.5]]
val / ['/cond 0010100 /s rn:4 rd:4 /imm12'] = dp ADD cond s (register-from-bits rn) (register-from-bits rd) (imm12)
###  - Add (register or register-shifted register) [[A8.8.7]] [[A8.8.8]]
val / ['/cond 0000100 /s rn:4 rd:4 /op2register'] = dp ADD cond s (register-from-bits rn) (register-from-bits rd) (op2register)

### AND
###  - And (register)
val / ['/cond 0000000 /s rn:4 rd:4 /op2register'] = dp AND cond s (register-from-bits rn) (register-from-bits rd) (op2register)
###  - And (immediate)
val / ['/cond 0010000 /s rn:4 rd:4 /imm12'] = dp AND cond s (register-from-bits rn) (register-from-bits rd) (imm12)

### BIC
val / ['/cond 0001110 /s rn:4 rd:4 /op2register'] = dp BIC cond s (register-from-bits rn) (register-from-bits rd) (op2register)
val / ['/cond 0011110 /s rn:4 rd:4 /imm12'] = dp BIC cond s (register-from-bits rn) (register-from-bits rd) (imm12)

### CMN
val / ['/cond 00010111 rn:4 rd:4 /op2register'] = dp CMN cond (return '1') (register-from-bits rn) (register-from-bits rd) (op2register)
val / ['/cond 00110111 rn:4 rd:4 /imm12'] = dp CMN cond (return '1') (register-from-bits rn) (register-from-bits rd) (imm12)

### CMP
val / ['/cond 00010101 rn:4 rd:4 /op2register'] = dp CMP cond (return '1') (register-from-bits rn) (register-from-bits rd) (op2register)
val / ['/cond 00110101 rn:4 rd:4 /imm12'] = dp CMP cond (return '1') (register-from-bits rn) (register-from-bits rd) (imm12)

### EOR
val / ['/cond 0000001 /s rn:4 rd:4 /op2register'] = dp EOR cond s (register-from-bits rn) (register-from-bits rd) (op2register)
val / ['/cond 0010001 /s rn:4 rd:4 /imm12'] = dp EOR cond s (register-from-bits rn) (register-from-bits rd) (imm12)

### MOV
val / ['/cond 0001101 /s rn:4 rd:4 /op2register'] = dp MOV cond s (register-from-bits rn) (register-from-bits rd) (op2register)
val / ['/cond 0011101 /s rn:4 rd:4 /imm12'] = dp MOV cond s (register-from-bits rn) (register-from-bits rd) (imm12)

### MVN
val / ['/cond 0001111 /s rn:4 rd:4 /op2register'] = dp MVN cond s (register-from-bits rn) (register-from-bits rd) (op2register)
val / ['/cond 0011111 /s rn:4 rd:4 /imm12'] = dp MVN cond s (register-from-bits rn) (register-from-bits rd) (imm12)

### ORR
val / ['/cond 0001100 /s rn:4 rd:4 /op2register'] = dp ORR cond s (register-from-bits rn) (register-from-bits rd) (op2register)
val / ['/cond 0011100 /s rn:4 rd:4 /imm12'] = dp ORR cond s (register-from-bits rn) (register-from-bits rd) (imm12)

### RSB
val / ['/cond 0000011 /s rn:4 rd:4 /op2register'] = dp RSB cond s (register-from-bits rn) (register-from-bits rd) (op2register)
val / ['/cond 0010011 /s rn:4 rd:4 /imm12'] = dp RSB cond s (register-from-bits rn) (register-from-bits rd) (imm12)

### RSC
val / ['/cond 0000111 /s rn:4 rd:4 /op2register'] = dp RSC cond s (register-from-bits rn) (register-from-bits rd) (op2register)
val / ['/cond 0010111 /s rn:4 rd:4 /imm12'] = dp RSC cond s (register-from-bits rn) (register-from-bits rd) (imm12)

### SBC
val / ['/cond 0000110 /s rn:4 rd:4 /op2register'] = dp SBC cond s (register-from-bits rn) (register-from-bits rd) (op2register)
val / ['/cond 0010110 /s rn:4 rd:4 /imm12'] = dp SBC cond s (register-from-bits rn) (register-from-bits rd) (imm12)

### SUB
val / ['/cond 0000010 /s rn:4 rd:4 /op2register'] = dp SUB cond s (register-from-bits rn) (register-from-bits rd) (op2register)
val / ['/cond 0010010 /s rn:4 rd:4 /imm12'] = dp SUB cond s (register-from-bits rn) (register-from-bits rd) (imm12)

### TEQ
val / ['/cond 00010011 rn:4 rd:4 /op2register'] = dp TEQ cond (return '1') (register-from-bits rn) (register-from-bits rd) (op2register)
val / ['/cond 00110011 rn:4 rd:4 /imm12'] = dp TEQ cond (return '1') (register-from-bits rn) (register-from-bits rd) (imm12)

### TST
val / ['/cond 00010001 rn:4 rd:4 /op2register'] = dp TST cond (return '1') (register-from-bits rn) (register-from-bits rd) (op2register)
val / ['/cond 00110001 rn:4 rd:4 /imm12'] = dp TST cond (return '1') (register-from-bits rn) (register-from-bits rd) (imm12)

### LSL
### - Logical Shift Left (immediate) [[A8.8.94]]
## val / ['/cond 0001101 /s 0000 rd:4 imm5:5 000 rm:4'] = 

##### MUL,MLA

# MUL
val / ['/cond 0000000 /s rd:4 rn:4 rs:4 1001 rm:4'] =
        mul
                MUL
                cond
                s
                (register-from-bits rd)
                (register-from-bits rn)
                (register-from-bits rs)
                (register-from-bits rm) 

# MLA
val / ['/cond 0000001 /s rd:4 rn:4 rs:4 1001 rm:4'] = 
        mul
                MUL
                cond
                s
                (register-from-bits rd)
                (register-from-bits rn)
                (register-from-bits rs)
                (register-from-bits rm) 

### MULL

# UMULL
val / ['/cond 0000100 /s rdhi:4 rdlo:4 rs:4 1001 rm:4'] = mull UMULL cond s (register-from-bits rdhi) (register-from-bits rdlo) (register-from-bits rs) (register-from-bits rm) 

# SMULL
val / ['/cond 0000110 /s rdhi:4 rdlo:4 rs:4 1001 rm:4'] = mull SMULL cond s (register-from-bits rdhi) (register-from-bits rdlo) (register-from-bits rs) (register-from-bits rm) 

# UMLAL
val / ['/cond 0000101 /s rdhi:4 rdlo:4 rs:4 1001 rm:4'] = mull UMLAL cond s (register-from-bits rdhi) (register-from-bits rdlo) (register-from-bits rs) (register-from-bits rm) 

# SMLAL
val / ['/cond 0000111 /s rdhi:4 rdlo:4 rs:4 1001 rm:4'] = mull SMLAL cond s (register-from-bits rdhi) (register-from-bits rdlo) (register-from-bits rs) (register-from-bits rm) 

# LDR,STR

val /ldr/p ['p:1'] = update@{p=p}
val /b ['b:1'] = update@{b=b}
val /w ['w:1'] = update@{w=w}
val /u ['u:1'] = update@{u=u}

val p = do
        p <- query $p;
        update @{p='0'};
        return (p)
end

val b = do
        b <- query $b;
        update @{b='0'};
        return (width-from-bits b)
end

val w = do
        w <- query $w;
        update @{w='0'};
        return (w)
end

val u = do
        u <- query $u;
        update @{u='0'};
        return (updown-from-bits u)
end

#LDR
val / ['/cond 010 /ldr/p /u /b /w 1 rn:4 rd:4 offset:12'] = loadstore LDR cond p u b w (register-from-bits rn) (register-from-bits rd) (return (IMMEDIATE (zx offset)))
val / ['/cond 011 /ldr/p /u /b /w 1 rn:4 rd:4 /op2register'] = loadstore LDR cond p u b w (register-from-bits rn) (register-from-bits rd) (op2register)

#SDR 
val / ['/cond 010 /ldr/p /u /b /w 0 rn:4 rd:4 offset:12'] = loadstore STR cond p u b w (register-from-bits rn) (register-from-bits rd) (return (IMMEDIATE (zx offset)))
val / ['/cond 011 /ldr/p /u /b /w 0 rn:4 rd:4 /op2register'] = loadstore STR cond p u b w (register-from-bits rn) (register-from-bits rd) (op2register)

### Half word and signed data transfer

### LDRH
###  - Load memory halfword [15:0] from register address + 5-bit immediate offset
val / ['/cond 000 /ldr/p /u 0 /w 1 rn:4 rd:4 00001011 rm:4'] = 
        loadstore 
                LDRH
                cond
                p
                u
                (return HALFWORD)
                w
                (register-from-bits rn)
                (register-from-bits rd)
                (return (REGISTER (register-from-bits rm)))

#val / ['/cond 000 /ldr/p /u 1 /w 1 rn:4 rd:4 00001011 rm:4'] = 
#       loadstore 
#               LDRH
#               cond

### CLREX [[A8.6.30]]
###  - Clear-Exclusive
# val / ['11110101011111111111000000011111'] = return CLREX
