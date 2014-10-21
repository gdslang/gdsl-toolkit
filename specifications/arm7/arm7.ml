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

type decoder-configuration = 0

type insndata = {length:int, insn:instruction}

val config-default = ''
val decoder-config = END

val insn-length insn = insn.length

# ----------------------------------------------------------------------
# Main Entry Point
# ----------------------------------------------------------------------

val decode config = do
  (* TODO: Maybe the endianess should be handled via cmdline options? *)
  endianness endian-little/instr32-little/access32;

  reset;

  idx-before <- get-ip;
  insn <- /;
  idx-after <- get-ip;

  return {length=(idx-after - idx-before), insn=insn}
end

# ----------------------------------------------------------------------

val reset = do
  update@{register_list=REGL_NIL};
  update@{imm='00000000'};
  update@{rotate='0000'};
  update@{b='0', p='0', w='0', u='0'}
end

# ----------------------------------------------------------------------
# Type Definitions
# ----------------------------------------------------------------------

type instruction =
    ADC of dp
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
  | MLA of mul
  | MLS of {cond:condition, rd:register, ra:register, rm:register, rn:register}
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
  | DMB of opt
  | DSB of opt
  | ISB of opt
  | DBG of hint_dbg
  | NOP of hint
  | SEV of hint
  | WFE of hint
  | WFI of hint
  | YIELD of hint
  | PLD of {u:1, r:1, rn:register, imm12:12}
  | PLDW of {u:1, r:1, rn:register, imm12:12}
  | PUSH of {cond:condition, registers:registerlist}

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

# Hint instructions
type hint = {
  cond:condition
}

# Special debug hint instruction
type hint_dbg = {
  cond:condition,
  option:4        # Decoding specified by debug system
}

type opt = {
  option:4
}

# Standard data-processing instruction
type dp = {
  cond:condition, # condition code
  s:1,            # whether the C flag should be set
  rn:register,    # first operand register
  rd:register,    # destination register
  op2:operand     # second operand (immediate or register)
}

type mul = {
  cond:condition,
  s:1,
  rd:register,
  rn:register,
  rs:register,
  rm:register
}

type mull = {
  cond:condition,
  s:1,
  rdhi:register,
  rdlo:register,
  rs:register,
  rm:register
}

type loadstore = {
  cond:condition,
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
    IMMEDIATE of immediate
  | REGISTER of register
  | REGISTER_LIST of registerlist
  | SHIFTED_REGISTER of shiftedregister
  | PSR of psr

# Supertype for the various immediate values
type immediate =
    INT of int
  | IMM5 of 5
  | IMM12 of 12
  | IMM24 of 24
  | MODIMM of {byte:8, rot:4}

# A list of registers (for load/store instructions)
type registerlist =
    REGL_NIL
  | REGL_CONS of {head:register, tail:registerlist}

# A register with a shift applied to its value
type shiftedregister = {register:register, shift:shift}

# Shift types for shifted register values
type shift =
    IMMSHIFT of {immediate:immediate, shifttype:shifttype}
  | REGSHIFT of {register:register, shifttype:shifttype}

# Available shift methods
type shifttype =
    LLS  # logical left shift
  | LRS  # logical right shift
  | ARS  # arithmetic right shift
  | RR   # rotate right

# The 16 ARMv7 registers
type register =
    R0   # Argument1, Return Value: Temporory register
  | R1   # Argument2, Second 32-bits if double/int Return Value: Temporary register
  | R2   # Argument: Temporary register
  | R3   # Argument: Temporary register
  | R4   # permanent register
  | R5   # permanent register
  | R6   # permanent register
  | R7   # permanent register (THUMB frame pointer)
  | R8   # permanent register
  | R9   # permanent register
  | R10  # permanent register
  | R11  # ARM frame pointer: permanent register
  | R12  # Temporary register
  | R13  # Stack pointer: permanent register
  | R14  # Link register: permanent register
  | R15  # Program Counter

# ARM condition codes [[A8.3]]
type condition =
    EQ   # Equal
  | NE   # Not equal
  | CS   # Carry set
  | CC   # Carry clear
  | MI   # Minus, negative
  | PL   # Plus, positive or zero
  | VS   # Overflow
  | VC   # No overflow
  | HI   # Unsigned higher
  | LS   # Unsigned lower or same
  | GE   # Signed greater than or equal
  | LT   # Signed less than
  | GT   # Signed greater than
  | LE   # Signed less than or equal
  | AL   # Always (unconditional)
  | NONE # Dummy condition (NONE is not an actual ARM condition)

val dp cons cond s rn rd op2 = do
  cond <- cond;
  s <- s;
  op2 <- op2;
  return (cons{
    cond=cond,
    s=s,
    rn=(register-from-bits rn),
    rd=(register-from-bits rd),
    op2=op2
  })
end

val mls cons cond rd ra rm rn = do
  cond <- cond;
  return (cons{
    cond=cond,
    rd=(register-from-bits rd),
    ra=(register-from-bits ra),
    rm=(register-from-bits rm),
    rn=(register-from-bits rn)
  })
end

val mul cons cond s rd rn rs rm = do
  cond <- cond;
  s <- s;
  return (cons{
    cond=cond,
    s=s,
    rd=(register-from-bits rd),
    rn=(register-from-bits rn),
    rs=(register-from-bits rs),
    rm=(register-from-bits rm)
  })
end

val mull cons cond s rdhi rdlo rs rm = do
  cond <- cond;
  s <- s;
  return (cons{
    cond=cond,
    s=s,
    rdhi=(register-from-bits rdhi),
    rdlo=(register-from-bits rdlo),
    rs=(register-from-bits rs),
    rm=(register-from-bits rm)
  })
end

val loadstore cons cond p u b w rn rd offset = do
  cond <- cond;
  p <- p;
  u <- u;
  b <- b;
  w <- w;
  offset <- offset;
  return (cons{
    cond=cond,
    p=p, u=u, b=b, w=w,
    rn=(register-from-bits rn),
    rd=(register-from-bits rd),
    offset=offset
  })
end

val br cons cond imm24 = do
  cond <- cond;
  return (cons{cond=cond, imm24=imm24})
end

val bx cons cond rm = do
  cond <- cond;
  return (cons{cond=cond, rm=(register-from-bits rm)})
end

val hint_dbg cons cond opt = do
  cond <- cond;
  return (cons{cond=cond, option=opt})
end

val hint cons cond = do
  cond <- cond;
  return (cons{cond=cond})
end

val immediate cons = return (IMMEDIATE(cons))

val regshiftedreg cons rm register shift_type = do
  return (cons{rm=rm, register=register, shift_type=shift_type})
end

val immshiftedreg cons rm amount shift_type = do
  return (cons{rm=rm, amount=amount, shift_type=shift_type})
end

val pld cons u r rn imm12 = do
  return (cons{u=u, r=r, rn=(register-from-bits rn), imm12=imm12})
end

val psr_transfer cons condition source destination flagsonly = do
  condition <- condition;
  source <- source;
  return (cons{condition=condition, source=source, destination=destination, flagsonly=flagsonly})
end

val push cons cond registers = do
  cond <- cond;
  registers <- registers;
  return (cons{cond=cond, registers=registers})
end

# I didn't see this operator anywhere else...
val mod a b = a - (/m a b) * b

# Creates a list of registers
# NOTE: This function should be called by a wrapper like reglist-from-int
val create-reglist intlist reg_index reglist =
  if intlist > 0 then
    if mod intlist 2 === 1 then
      REGL_CONS {
        head=(decode-register reg_index),
        tail=(create-reglist (/m intlist 2) (reg_index + 1) reglist)
      }
    else
      create-reglist (/m intlist 2) (reg_index + 1) reglist
  else
    reglist

# Creates a register list from a (16 bit) bit vector (for load/store insns)
val reglist-from-bits bits = reglist-from-int (zx bits)
val reglist-from-int intlist = create-reglist intlist 0 REGL_NIL

val decode-register reg =
  case reg of
      0: R0
    | 1: R1
    | 2: R2
    | 3: R3
    | 4: R4
    | 5: R5
    | 6: R6
    | 7: R7
    | 8: R8
    | 9: R9
    | 10: R10
    | 11: R11
    | 12: R12
    | 13: R13
    | 14: R14
    | 15: R15
  end

val register-from-bits bits = decode-register (zx bits)

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

# ----------------------------------------------------------------------
# Subdecoder
# ----------------------------------------------------------------------

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

val none = return NONE

# Immediate subdecoder (12 bit immediate)
val /imm12 ['rot:4 byte:8'] = update@{rot=rot, byte=byte}

val imm12 = do
  rot <- query $rot;
  byte <- query $byte;
  update @{rot='0000', byte='00000000'};
  ret <- (immediate (MODIMM{byte=byte, rot=rot}));
  return (ret)
end

# Operand subdecoder: Immediate
# val /op2imm ['rotate:4 imm:8'] = update@{rotate=rotate, imm=imm}

# Operand subdecoder: Register + Immediate shift
val /op2register ['imm5:5 stype:2 0 rm:4'] =
  update@{
    shift_operation=IMMSHIFT{immediate=IMM5(imm5), shifttype=(shifttype-from-bits stype)},
    rm=(register-from-bits rm)
  }

# Operand subdecoder: Register + Register controlled shift
val /op2register ['rs:4 0 stype:2 1 rm:4'] =
  update@{
    shift_operation=REGSHIFT{register=(register-from-bits rs), shifttype=(shifttype-from-bits stype)},
    rm=(register-from-bits rm)
  }

val op2register = do
  shiftoperation <- query $shift_operation;
  rm <- query $rm;
  return (SHIFTED_REGISTER{register=rm, shift=shiftoperation})
end

# S flag subdecoder
val /s ['s:1'] = update@{s=s}

val s = do
  s <- query $s;
  update @{s='0'};
  return (s)
end

# Subdecoder for (16 bit) register_lists for load/store instructions
# NOTE: Bit i of the list is set, if register i should be loaded/stored.
#       Loading/storing the SP (R13) results in undefined behaviour.
val /register_list ['rt:4 000000000100'] = update @{register_list=(reglist-from-int (power 2 (zx rt)))}
val /register_list ['regs@.............0..'] =  update@{register_list=(reglist-from-int (zx regs))}

val register_list = do
  register_list <- query $register_list;
  update @{register_list=REGL_NIL};
  return (register_list)
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
val / ['/cond 0010101 /s rn:4 rd:4 /imm12'] = dp ADC cond s rn rd imm12
###  - Add with Carry (register or register-shifted register) [[A8.8.2]] [[A8.8.3]]
val / ['/cond 0000101 /s rn:4 rd:4 /op2register'] = dp ADC cond s rn rd (op2register)

### ADD
###  - Add (immediate) [[A8.8.5]]
val / ['/cond 0010100 /s rn:4 rd:4 /imm12'] = dp ADD cond s rn rd (imm12)
###  - Add (register or register-shifted register) [[A8.8.7]] [[A8.8.8]]
val / ['/cond 0000100 /s rn:4 rd:4 /op2register'] = dp ADD cond s rn rd (op2register)

### ADR
###  - Add immediate to PC [[A8.8.12]]
### NOTE: This instruction is encoded like AND, except that rn is a
###       a constant '1111' (PC) and s is '0'. Therefore, ADR is handled by
###       the AND decoder.

### AND
###  - And (register)
val / ['/cond 0000000 /s rn:4 rd:4 /op2register'] = dp AND cond s rn rd (op2register)
###  - And (immediate)
val / ['/cond 0010000 /s rn:4 rd:4 /imm12'] = dp AND cond s rn rd (imm12)

### BIC
val / ['/cond 0001110 /s rn:4 rd:4 /op2register'] = dp BIC cond s rn rd (op2register)
val / ['/cond 0011110 /s rn:4 rd:4 /imm12'] = dp BIC cond s rn rd (imm12)

### CMN
val / ['/cond 00010111 rn:4 rd:4 /op2register'] = dp CMN cond (return '1') rn rd (op2register)
val / ['/cond 00110111 rn:4 rd:4 /imm12'] = dp CMN cond (return '1') rn rd (imm12)

### CMP
val / ['/cond 00010101 rn:4 rd:4 /op2register'] = dp CMP cond (return '1') rn rd (op2register)
val / ['/cond 00110101 rn:4 rd:4 /imm12'] = dp CMP cond (return '1') rn rd (imm12)

### EOR
val / ['/cond 0000001 /s rn:4 rd:4 /op2register'] = dp EOR cond s rn rd (op2register)
val / ['/cond 0010001 /s rn:4 rd:4 /imm12'] = dp EOR cond s rn rd (imm12)

### MOV
val / ['/cond 0001101 /s rn:4 rd:4 /op2register'] = dp MOV cond s rn rd (op2register)
val / ['/cond 0011101 /s rn:4 rd:4 /imm12'] = dp MOV cond s rn rd (imm12)

### MVN
val / ['/cond 0001111 /s rn:4 rd:4 /op2register'] = dp MVN cond s rn rd (op2register)
val / ['/cond 0011111 /s rn:4 rd:4 /imm12'] = dp MVN cond s rn rd (imm12)

### ORR
val / ['/cond 0001100 /s rn:4 rd:4 /op2register'] = dp ORR cond s rn rd (op2register)
val / ['/cond 0011100 /s rn:4 rd:4 /imm12'] = dp ORR cond s rn rd (imm12)

### RSB
val / ['/cond 0000011 /s rn:4 rd:4 /op2register'] = dp RSB cond s rn rd (op2register)
val / ['/cond 0010011 /s rn:4 rd:4 /imm12'] = dp RSB cond s rn rd (imm12)

### RSC
val / ['/cond 0000111 /s rn:4 rd:4 /op2register'] = dp RSC cond s rn rd (op2register)
val / ['/cond 0010111 /s rn:4 rd:4 /imm12'] = dp RSC cond s rn rd (imm12)

### SBC
val / ['/cond 0000110 /s rn:4 rd:4 /op2register'] = dp SBC cond s rn rd (op2register)
val / ['/cond 0010110 /s rn:4 rd:4 /imm12'] = dp SBC cond s rn rd (imm12)

### SUB
val / ['/cond 0000010 /s rn:4 rd:4 /op2register'] = dp SUB cond s rn rd (op2register)
val / ['/cond 0010010 /s rn:4 rd:4 /imm12'] = dp SUB cond s rn rd (imm12)

### TEQ
val / ['/cond 00010011 rn:4 rd:4 /op2register'] = dp TEQ cond (return '1') rn rd (op2register)
val / ['/cond 00110011 rn:4 rd:4 /imm12'] = dp TEQ cond (return '1') rn rd (imm12)

### TST
val / ['/cond 00010001 rn:4 rd:4 /op2register'] = dp TST cond (return '1') rn rd (op2register)
val / ['/cond 00110001 rn:4 rd:4 /imm12'] = dp TST cond (return '1') rn rd (imm12)

# --- Multiply instructions --------------------------------------------

### MLA
###  - Multiply Accumulate
val / ['/cond 0000001 /s rd:4 rn:4 rs:4 1001 rm:4'] = mul MUL cond s rd rn rs rm

### MUL
###  - Multiply
val / ['/cond 0000000 /s rd:4 rs@0000 rm:4 1001 rn:4'] = mul MUL cond s rd rs rm rn

### MLS
###  - Multiply and Subtract
val / ['/cond 00000110 rd:4 ra:4 rm:4 1001 rn:4'] = mls MLS cond rd ra rm rn

### SMLAL
###  - Signed Multiply Accumulate Long
val / ['/cond 0000111 /s rdhi:4 rdlo:4 rs:4 1001 rm:4'] = mull SMLAL cond s rdhi rdlo rs rm

### SMULL
###  - Signed Multiply Long
val / ['/cond 0000110 /s rdhi:4 rdlo:4 rs:4 1001 rm:4'] = mull SMULL cond s rdhi rdlo rs rm

### UMLAL
###  - Unsigned Multiply Accumulate Long
val / ['/cond 0000101 /s rdhi:4 rdlo:4 rs:4 1001 rm:4'] = mull UMLAL cond s rdhi rdlo rs rm

### UMULL
###  - Unsigned Multiply Long
val / ['/cond 0000100 /s rdhi:4 rdlo:4 rs:4 1001 rm:4'] = mull UMULL cond s rdhi rdlo rs rm

# --- Load/store instructions ------------------------------------------

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

### LDR
val / ['/cond 010 /ldr/p /u /b /w 1 rn:4 rd:4 imm12:12'] = loadstore LDR cond p u b w rn rd (immediate (INT (zx imm12)))
val / ['/cond 011 /ldr/p /u /b /w 1 rn:4 rd:4 /op2register'] = loadstore LDR cond p u b w rn rd (op2register)

### SDR
val / ['/cond 010 /ldr/p /u /b /w 0 rn:4 rd:4 imm12:12'] = loadstore STR cond p u b w rn rd (immediate (INT (zx imm12)))
val / ['/cond 011 /ldr/p /u /b /w 0 rn:4 rd:4 /op2register'] = loadstore STR cond p u b w rn rd (op2register)

### Half word and signed data transfer

### LDRH
###  - Load memory halfword [15:0] from register address + 5-bit immediate offset
val / ['/cond 000 /ldr/p /u 0 /w 1 rn:4 rd:4 00001011 rm:4'] = loadstore LDRH cond p u (return HALFWORD) w rn rd (return (REGISTER (register-from-bits rm)))

#val / ['/cond 000 /ldr/p /u 1 /w 1 rn:4 rd:4 00001011 rm:4'] =
#       loadstore 
#               LDRH
#               cond

# --- Load/store multiple instructions ---------------------------------

### PUSH
###  - Push Multiple Registers
val / ['/cond 100100 1 0 1101 /register_list'] = push PUSH cond register_list

# --- Hint instructions ------------------------------------------------

### DBG
###  - Debug Hint
val / ['/cond 00110 0 10 0000 1111 0000 1111 opt:4'] = hint_dbg DBG cond opt

### NOP
###  - No Operation
val / ['/cond 0011 0010 0000 1111 0000 00000000'] = hint NOP cond

### SEV
###  - Send Event
val / ['/cond 00110 0 10 0000 1111 0000 00000100'] = hint SEV cond

### YIELD
###  - Yield
val / ['/cond 00110010 0000 1111 0000 00000001'] = hint YIELD cond

### WFE
###  - Wait For Event
val / ['/cond 00110010 0000 1111 0000 00000010'] = hint WFE cond

### WFI
###  - Wait For Interrupt
val / ['/cond 00110010 0000 1111 0000 00000011'] = hint WFI cond

# --- Miscellaneous instructions ---------------------------------------

### CLREX
###  - Clear-Exclusive
val / ['1111 01010111 1 111 1111 0000 0001 1111'] = return CLREX

### DMB
###  - Data Memory Barrier
val / ['1111 01010111 1111 1111 0000 0101 option:4'] = return (DMB{option=option})

### DSB
###  - Data Synchronization Barrier
val / ['1111 01010111 1111 1111 0000 0100 option:4'] = return (DSB{option=option})

### ISB
###  - Instruction Synchronization Buffer
val / ['1111 01010111 1111 1111 0000 0110 option:4'] = return (ISB{option=option})

### PLD
###  - Preload Data (for read)
val / ['1111 01 0 1 u:1 r@1 01 rn:4 1111 imm12:12'] = pld PLD u r rn imm12
###  - Preload Data (for write)
val / ['1111 01 0 1 u:1 r@0 01 rn:4 1111 imm12:12'] = pld PLDW u r rn imm12

