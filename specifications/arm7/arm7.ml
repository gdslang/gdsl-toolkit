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

type decoder-configuration = 0

type insndata = {ip:int, insn:instruction}

val config-default = ''
val decoder-config = END

# ----------------------------------------------------------------------
# Main Entry Point
# ----------------------------------------------------------------------

val decode config = do
  (* TODO: Maybe the endianess should be handled via cmdline options? *)
  endianness endian-little/instr32-little/access32;

  reset;

  idx-before <- get-ip;
  insn <- /;

  return {ip=idx-before, insn=insn}
end

# ----------------------------------------------------------------------

(* NOTE: This function is most likely unnecessary... It doesn't really matter*)
val reset = do
  update@{
    cond='0000',
    b='0', p='0', w='0', s='0',
    ra='0000', rd='0000', rm='0000', rn='0000', rt='0000',
    rdhi='0000', rdlo='0000',
    imm4='0000', imm4H='0000', imm4L='0000',
    imm12='000000000000',
    byte='00000000', rot='0000'
  }
end

# ----------------------------------------------------------------------
# Utility Functions
# ----------------------------------------------------------------------

# I didn't see this operator anywhere else...
val mod a b = a - (/z a b) * b

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
  | MLS of mul
  | MUL of mul
  | SMLAL of mull
  | SMULL of mull
  | UMLAL of mull
  | UMULL of mull
  | CLZ of binop
  | LDR of ls
  | LDRT of ls
  | LDRB of ls
  | LDRBT of ls
  | LDRH of ls
  | LDRHT of ls
  | LDRSB of ls
  | LDRSBT of ls
  | LDRSH of ls
  | LDRSHT of ls
  | LDRD of ls
  | STR of ls
  | STRB of ls
  | STRD of ls
  | STRH of ls
  | LDM of lsm
  | LDMDA of lsm
  | LDMDB of lsm
  | LDMIB of lsm
  | POP of lsm
  | STM of lsm
  | STMDA of lsm
  | STMDB of lsm
  | STMIB of lsm
  | PUSH of lsm
  | B of br
  | BL of br
  | BLX of br
  | BX of br
  | BXJ of br
  | MRS of psr_transfer
  | MSR of psr_transfer
  | NOP of nulop
  | SEV of nulop
  | WFE of nulop
  | WFI of nulop
  | YIELD of nulop
  | DBG of unop
  | SVC of unop

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

# Standard multiplication instructions
type mul = {
  cond:condition,
  s:1,
  rd:register,
  ra:register,
  rm:register,
  rn:register
}

# Long mulitplication instructions
type mull = {
  cond:condition,
  s:1,
  rdhi:register,
  rdlo:register,
  rn:register,
  rm:register
}

# Load/store instruction
type ls = {
  cond:condition,
  p:1,
  u:1,
  w:1,
  rn:register,
  rt:register,
  offset:operand
}

# Load/store multiple instructions
type lsm = {
  cond:condition,
  w:1,
  rn:register,
  register_list:operand
}

# Branch instructions
type br = {
  cond:condition,
  label:operand
}

type nulop = {
  cond:condition
}

type unop = {
  cond:condition,
  opnd:operand
}

type binop = {
  cond:condition,
  opnd1:operand,
  opnd2:operand
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
    IMMi of int
  | IMM4 of 4
  | IMM5 of 5
  | IMM8 of 8
  | IMM12 of 12
  | IMM16 of 16
  | IMM24 of 24
  | MODIMM of {byte:8, rot:4} # 8 bit immediate with 4 bit rotation

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
    LSL  # Logical Shift Left
  | LSR  # Logical Shift Right
  | ASR  # Arithmetic Shift Right
  | ROR  # Rotate Right

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
  | NV   # Never: Dummy condition (NV is not an actual ARM condition)

val dp cons cond s rn rd op2 = do
  cond <- cond;
  s <- s;
  rn <- rn;
  rd <- rd;
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

val mul cons cond s rd ra rm rn = do
  cond <- cond;
  s <- s;
  rd <- rd;
  ra <- ra;
  rm <- rm;
  rn <- rn;
  return (cons{
    cond=cond,
    s=s,
    rd=(register-from-bits rd),
    ra=(register-from-bits ra),
    rm=(register-from-bits rm),
    rn=(register-from-bits rn)
  })
end

val mull cons cond s rdhi rdlo rm rn = do
  cond <- cond;
  rdhi <- rdhi;
  rdlo <- rdlo;
  rm <- rm;
  rn <- rn;
  return (cons{
    cond=cond,
    s=s,
    rdhi=(register-from-bits rdhi),
    rdlo=(register-from-bits rdlo),
    rn=(register-from-bits rn),
    rm=(register-from-bits rm)
  })
end

val ls cons cond p u w rn rd offset = do
  cond <- cond;
  p <- p;
  u <- u;
  w <- w;
  rn <- rn;
  rt <- rt;
  offset <- offset;
  return (cons{
    cond=cond,
    p=p, u=u, w=w,
    rn=(register-from-bits rn),
    rt=(register-from-bits rt),
    offset=offset
  })
end

val lsm cons cond w rn register_list = do
  cond <- cond;
  w <- w;
  rn <- rn;
  register_list <- register_list;
  return (cons{
    cond=cond, w=w,
    rn=(register-from-bits rn),
    register_list=(REGISTER_LIST(register_list))
  })
end

val br cons cond label = do
  cond <- cond;
  label <- label;
  return (cons{cond=cond, label=label})
end

val nulop cons cond = do
  cond <- cond;
  return (cons{cond=cond})
end

val unop cons cond opnd = do
  cond <- cond;
  opnd <- opnd;
  return (cons{cond=cond, opnd=opnd})
end

val binop cons cond opnd1 opnd2 = do
  cond <- cond;
  opnd1 <- opnd1;
  opnd2 <- opnd2;
  return (cons{cond=cond, opnd1=opnd1, opnd2=opnd2})
end

val immediate cons = return (IMMEDIATE(cons))

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

# Returns the number of registers in a register list
val reglist-length reglist =
  case reglist of
      REGL_NIL: 0
    | REGL_CONS l: 1 + (reglist-length l.tail)
  end

# Creates a register list from a (16 bit) bit vector (for load/store insns)
val reglist-from-bits bits = reglist-from-int (zx bits)
val reglist-from-int intlist = create-reglist intlist 0 REGL_NIL

val decode-register i =
  case i of
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
      '00' : LSL
    | '01' : LSR
    | '10' : ASR
    | '11' : ROR
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
  return (cond-from-bits cond)
end

val no_cond = return NV

# Flag subdecoders
val /P ['p:1'] = update@{p=p}
val /W ['w:1'] = update@{w=w}
val /U ['u:1'] = update@{u=u}
val /S ['s:1'] = update@{s=s}

val p = do
  p <- query $p;
  return p
end

val w = do
  w <- query $w;
  return w
end

val u = do
  u <- query $u;
  return u
end

val s = do
  s <- query $s;
  return s
end

# set0 and set1 can be used if one of the flags for a particular
# instruction has a fixed value:
val set0 = return '0'
val set1 = return '1'

# Immediate subdecoder (default 12 bit immediate)
val /imm12 ['imm12:12'] = update@{imm12=imm12}

val imm12 = do
  imm12 <- query $imm12;
  imm <- immediate (IMM12(imm12));
  return imm
end

val /imm4H ['imm4H:4'] = update@{imm4H=imm4H}
val /imm4L ['imm4L:4'] = update@{imm4L=imm4L}

val combine_imm8 = do
  imm4H <- query $imm4H;
  imm4L <- query $imm4L;
  imm <- immediate (IMM8(imm4H^imm4L));
  return imm
end

val /imm4 ['imm4:4'] = update@{imm4=imm4}

val combine_imm16 = do
  imm4 <- query $imm4;
  imm12 <- query $imm12;
  imm <- immediate (IMMi(zx (imm4^imm12)));
  return imm
end

# Immediate subdecoder (modified 12 bit immediate)
val /modimm ['rot:4 byte:8'] = update@{rot=rot, byte=byte}

val modimm = do
  rot <- query $rot;
  byte <- query $byte;
  ret <- immediate (MODIMM{byte=byte, rot=rot});
  return ret
end

val /shiftedreg ['/immshift /rm'] = (return 0)
val /shiftedreg ['/regshift /rm'] = (return 0)

# Operand subdecoder: Register + Immediate shift
val /immshift ['imm5:5 stype:2 0'] =
  update@{
    shiftop=IMMSHIFT{immediate=IMM5(imm5), shifttype=(shifttype-from-bits stype)}
  }

# Operand subdecoder: Register + Register controlled shift
val /regshift ['rs:4 0 stype:2 1'] =
  update@{
    shiftop=REGSHIFT{register=(register-from-bits rs), shifttype=(shifttype-from-bits stype)}
  }

val shiftedreg = do
  shiftoperation <- query $shiftop;
  rm <- query $rm;
  return (SHIFTED_REGISTER{register=(register-from-bits rm), shift=shiftoperation})
end

# Subdecoder for (16 bit) register_lists for load/store instructions
val /register_list ['regs:16'] =
  update@{register_list=(reglist-from-int (zx regs))}

val /register_list_one ['rt:4 000000000100'] =
  update@{register_list=(reglist-from-int (power 2 (zx rt)))}
 
val /register_list_many ['regs@.............0..'] =
  update@{register_list=(reglist-from-int (zx regs))}

# Returns the register list that was decoded most recently.
val register_list = do
  register_list <- query $register_list;
  return register_list
end

val rx2reglist rx = do
  reg <- rx;
  return (reglist-from-int (power 2 (zx reg)))
end

# Register subdecoders
val /ra ['ra:4'] = update@{ra=ra}
val /rd ['rd:4'] = update@{rd=rd}
val /rm ['rm:4'] = update@{rm=rm}
val /rn ['rn:4'] = update@{rn=rn}
val /rt ['rt:4'] = update@{rt=rt}

val /rdhi ['rdhi:4'] = update@{rdhi=rdhi}
val /rdlo ['rdlo:4'] = update@{rdlo=rdlo}

val ra = do
  ra <- query $ra;
  return ra
end

val rd = do
  rd <- query $rd;
  return rd
end

val rm = do
  rm <- query $rm;
  return rm
end

val rn = do
  rn <- query $rn;
  return rn
end

val rt = do
  rt <- query $rt;
  return rt
end

val rdhi = do
  rdhi <- query $rdhi;
  return rdhi
end

val rdlo = do
  rdlo <- query $rdlo;
  return rdlo
end

val rx2operand rx = do
  reg <- rx;
  return (REGISTER(register-from-bits reg))
end

# ----------------------------------------------------------------------
# Instruction Decoding
# ----------------------------------------------------------------------

# --- Branching Instructions -------------------------------------------

### B
### - Branch
val / ['/cond 101 0 imm24:24'] = br B cond (immediate (IMMi(sx (imm24^'00'))))

### BL
###  - Branch with Link
val / ['/cond 101 1 imm24:24'] = br BL cond (immediate (IMMi(sx (imm24^'00'))))

### BLX
###  - Branch with Link and Exchange (Immediate)
val / ['1111 101 h:1 imm24:24'] = br BLX no_cond (immediate (IMMi(sx (imm24^h^'0'))))
###  - Branch with Link and Exchange (Register)
val / ['/cond 000 1 0 0 1 0 1111 1111 1111 0011 /rm'] = br BLX cond (rx2operand rm)

### BX
### - Branch and Exchange
val / ['/cond 000 1 0 0 1 0 1111 1111 1111 0001 /rm'] = br BX cond (rx2operand rm)

### BXJ
###  - Branch and Exchange Jazelle
val / ['/cond 000 1 0 0 1 0 1111 1111 1111 0010 /rm'] = br BXJ cond (rx2operand rm)

# --- Data Processing Instructions -------------------------------------

### ADC
###  - Add with Carry (immediate)
val / ['/cond 001 0 1 0 1 /S /rn /rd /modimm'] = dp ADC cond s rn rd modimm
###  - Add with Carry (shifted register)
val / ['/cond 000 0 1 0 1 /S /rn /rd /shiftedreg'] = dp ADC cond s rn rd shiftedreg

### ADD
###  - Add (immediate)
val / ['/cond 001 0 1 0 0 /S /rn /rd /modimm'] = dp ADD cond s rn rd modimm
###  - Add (shifted register)
val / ['/cond 000 0 1 0 0 /S /rn /rd /shiftedreg'] = dp ADD cond s rn rd shiftedreg

### AND
###  - And (immediate)
val / ['/cond 001 0 0 0 0 /S /rn /rd /modimm'] = dp AND cond s rn rd modimm
###  - And (shifted register)
val / ['/cond 000 0 0 0 0 /S /rn /rd /shiftedreg'] = dp AND cond s rn rd shiftedreg

### BIC
###  - Bitwise Bit Clear (immediate)
val / ['/cond 001 1 1 1 0 /S /rn /rd /modimm'] = dp BIC cond s rn rd modimm
###  - Bitwise Bit Clear (shifted register)
val / ['/cond 000 1 1 1 0 /S /rn /rd /shiftedreg'] = dp BIC cond s rn rd shiftedreg

### CMN
###  - Compare Negative (immediate)
val / ['/cond 001 1 0 1 1 1 /rn 0000 /modimm'] = dp CMN cond set1 rn (return '0000') modimm
###  - Compare Negative (shifted register)
val / ['/cond 000 1 0 1 1 1 /rn 0000 /shiftedreg'] = dp CMN cond s rn (return '0000') shiftedreg

### CMP
###  - Compare (immediate)
val / ['/cond 001 1 0 1 0 1 /rn 0000 /modimm'] = dp CMP cond set1 rn (return '0000') modimm
###  - Compare (shifted register)
val / ['/cond 000 1 0 1 0 1 /rn 0000 /shiftedreg'] = dp CMP cond set1 rn (return '0000') shiftedreg

### EOR
###  - Bitwise Exclusive OR (immediate)
val / ['/cond 001 0 0 0 1 /S /rn /rd /modimm'] = dp EOR cond s rn rd modimm
###  - Bitwise Exclusive OR (shifted register)
val / ['/cond 000 0 0 0 1 /S /rn /rd /shiftedreg'] = dp EOR cond s rn rd shiftedreg

### MOV
###  - Move (immediate) (Encoding A1)
val / ['/cond 001 1 1 0 1 /S 0000 /rd /modimm'] = dp MOV cond s (return '0000') rd modimm
###  - Move (immediate) (Encoding A2)
val / ['/cond 001 1 0 0 0 0 /imm4 /rd /imm12'] = dp MOV cond set0 (return '0000') rd combine_imm16
###  - Move (shifted register)
val / ['/cond 000 1 1 0 1 /S 0000 /rd /shiftedreg'] = dp MOV cond s (return '0000') rd shiftedreg

### MVN
###  - Bitwise NOT (immediate)
val / ['/cond 001 1 1 1 1 /S 0000 /rd /modimm'] = dp MVN cond s (return '0000') rd modimm
###  - Bitwise NOT (shifted register)
val / ['/cond 000 1 1 1 1 /S 0000 /rd /shiftedreg'] = dp MVN cond s (return '0000') rd shiftedreg

### ORR
###  - Bitwise OR (immediate)
val / ['/cond 001 1 1 0 0 /S /rn /rd /modimm'] = dp ORR cond s rn rd modimm
###  - Bitwise OR (shifted register)
val / ['/cond 000 1 1 0 0 /S /rn /rd /shiftedreg'] = dp ORR cond s rn rd shiftedreg

### RSB
###  - Reverse Subtract (immediate)
val / ['/cond 001 0 0 1 1 /S /rn /rd /modimm'] = dp RSB cond s rn rd modimm
###  - Reverse Subtract (shifted-register)
val / ['/cond 000 0 0 1 1 /S /rn /rd /shiftedreg'] = dp RSB cond s rn rd shiftedreg

### RSC
###  - Reverse Subtract with Carry (immediate)
val / ['/cond 001 0 1 1 1 /S /rn /rd /modimm'] = dp RSC cond s rn rd modimm
###  - Reverse Subtract with Carry (shifted register)
val / ['/cond 000 0 1 1 1 /S /rn /rd /shiftedreg'] = dp RSC cond s rn rd shiftedreg

### SBC
###  - Subtract with Carry (immediate)
val / ['/cond 001 0 1 1 0 /S /rn /rd /modimm'] = dp SBC cond s rn rd modimm
###  - Subtract with Carry (shifted register)
val / ['/cond 000 0 1 1 0 /S /rn /rd /shiftedreg'] = dp SBC cond s rn rd shiftedreg

### SUB
###  - Subtract (immediate)
val / ['/cond 001 0 0 1 0 /S /rn /rd /modimm'] = dp SUB cond s rn rd modimm
###  - Subtract (shifted register)
val / ['/cond 000 0 0 1 0 /S /rn /rd /shiftedreg'] = dp SUB cond s rn rd shiftedreg

### TEQ
###  - Test Equivalence (immediate)
val / ['/cond 001 1 0 0 1 1 /rn 0000 /modimm'] = dp TEQ cond set1 rn (return '0000') modimm
###  - Test Equivalence (shifted register)
val / ['/cond 000 1 0 0 1 1 /rn 0000 /shiftedreg'] = dp TEQ cond set1 rn (return '0000') shiftedreg

### TST
###  - Test (immediate)
val / ['/cond 001 1 0 0 0 1 /rn 0000 /modimm'] = dp TST cond set1 rn (return '0000') modimm
###  - Test (shifted register)
val / ['/cond 000 1 0 0 0 1 /rn 0000 /shiftedreg'] = dp TST cond s rn (return '0000') shiftedreg

# --- Shift instructions -----------------------------------------------

(* NOTE: These instructions are implemented by MOV (shifted-register) *)

# --- Multiply instructions --------------------------------------------

### MLA
###  - Multiply Accumulate
val / ['/cond 000 0 0 0 1 /S /rd /ra /rm 1001 /rn'] =
  mul MLA cond s rd ra rm rn

### MLS
###  - Multiply and Subtract
val / ['/cond 000 0 0 1 1 0 /rd /ra /rm 1001 /rn'] =
  mul MLS cond set0 rd ra rm rn

### MUL
###  - Multiply
val / ['/cond 000 0 0 0 0 /S /rd ra@0000 /rm 1001 /rn'] =
  mul MUL cond s rd (return ra) rm rn

### SMLAL
###  - Signed Multiply Accumulate Long
val / ['/cond 000 0 1 1 1 s:1 /rdhi /rdlo /rm 1001 /rn'] =
  mull SMLAL cond s rdhi rdlo rm rn

### SMULL
###  - Signed Multiply Long
val / ['/cond 000 0 1 1 0 s:1 /rdhi /rdlo /rm 1001 /rn'] =
  mull SMULL cond s rdhi rdlo rm rn

### UMLAL
###  - Unsigned Multiply Accumulate Long
val / ['/cond 000 0 1 0 1 s:1 /rdhi /rdlo /rm 1001 /rn'] =
  mull UMLAL cond s rdhi rdlo rm rn

### UMULL
###  - Unsigned Multiply Long
val / ['/cond 000 0 1 0 0 s:1 /rdhi /rdlo /rm 1001 /rn'] =
  mull UMULL cond s rdhi rdlo rm rn

# --- Miscellaneous data-processing instructions -----------------------

### CLZ
###  - Count Leading Zeros
val / ['/cond 000 1 0 1 1 0 1111 /rd 1111 0001 /rm'] = binop CLZ cond (rx2operand rd)  (rx2operand rm)

# --- Load/store instructions ------------------------------------------

val ldr_is_pop? s = ($rn s == '1101') and ($p s == '0') and ($u s) and ($w s == '0') and ($imm12 s == '000000000100')
val is_unprivileged? s = ($p s == '0') and ($w s)

### LDR/LDRT/POP
val / ['/cond 010 /P /U 0 /W 1 /rn /rt /imm12']
###  - Pop Multiple Registers (Encoding A2)
  | ldr_is_pop? = lsm POP cond w rn (rx2reglist rt)
###  - Load Register Unprivileged (Encoding A1)
  | is_unprivileged? = ls LDRT cond set0 u set0 rn rt imm12
###  - Load Register (immediate/literal)
  | otherwise = ls LDR cond p u w rn rt imm12
val / ['/cond 011 /P /U 0 /W 1 /rn /rt /immshift /rm']
###  - Load Register Unprivileged (Encoding A2)
  | is_unprivileged? = ls LDRT cond set0 u set0 rn rt shiftedreg
###  - Load Register (register)
  | otherwise = ls LDR cond p u w rn rt shiftedreg

### LDRB/LDRBT
val / ['/cond 010 /P /U 1 /W 1 /rn /rt /imm12']
###  - Load Register Byte Unprivileged (Encoding A1)
  | is_unprivileged? = ls LDRBT cond set0 u set0 rn rt imm12
###  - Load Register Byte (immediate/literal)
  | otherwise = ls LDRB cond p u w rn rt imm12
val / ['/cond 011 /P /U 1 /W 1 /rn /rt /immshift /rm']
###  - Load Register Byte Unprivileged (Encoding A2)
  | is_unprivileged? = ls LDRBT cond set0 u set0 rn rt shiftedreg
###  - Load Register Byte (register)
  | otherwise = ls LDRB cond p u w rn rt shiftedreg

### LDRD
###  - Load Register Dual (immediate/literal)
val / ['/cond 000 /P /U 1 /W 0 /rn /rt /imm4H 1101 /imm4L'] =
  ls LDRD cond p u w rn rt combine_imm8
###  - Load Register Dual (register)
val / ['/cond 000 /P /U 0 /W 0 /rn /rt 0000 1101 /rm'] =
  ls LDRD cond p u w rn rt (rx2operand rm)

### LDRH/LDRHT
val / ['/cond 000 /P /U 1 /W 1 /rn /rt /imm4H 1011 /imm4L']
###  - Load Register Halfword Unprivileged (Encoding A1)
  | is_unprivileged? = ls LDRHT cond set0 u set0 rn rt combine_imm8
###  - Load Register Halfword (immediat/literal)
  | otherwise = ls LDRH cond p u w rn rt combine_imm8
val / ['/cond 000 /P /U 0 /W 1 /rn /rt 0000 1011 /rm']
###  - Load Register Halfword Unprivileged (Encoding A2)
  | is_unprivileged? = ls LDRHT cond set0 u set0 rn rt (rx2operand rm)
###  - Load Register Halfword (register)
  | otherwise = ls LDRH cond p u w rn rt (rx2operand rm)

### LDRSB/LDRSBT
val / ['/cond 000 /P /U 1 /W 1 /rn /rt /imm4H 1101 /imm4L']
###  - Load Register Signed Byte (Encoding A1)
  | is_unprivileged? = ls LDRSBT cond set0 u set0 rn rt combine_imm8
###  - Load Register Signed Byte (immediate/literal)
  | otherwise = ls LDRSB cond p u w rn rt combine_imm8
val / ['/cond 000 /P /U 0 /W 1 /rn /rt 0000 1101 /rm']
###  - Load Register Signed Byte (Encoding A2)
  | is_unprivileged? = ls LDRSBT cond set0 u set0 rn rt (rx2operand rm)
###  - Load Register Signed Byte (register)
  | otherwise = ls LDRSB cond p u w rn rt (rx2operand rm)

### LDRSH/LDRSHT
val / ['/cond 000 /P /U 1 /W 1 /rn /rt /imm4H 1111 /imm4L']
###  - Load Register Signed Halfword Unprivileged (Encoding A1)
  | is_unprivileged? = ls LDRSHT cond set0 u set0 rn rt combine_imm8
###  - Load Register Signed Halfword (immediat/literal)
  | otherwise = ls LDRSH cond p u w rn rt combine_imm8
val / ['/cond 000 /P /U 0 /W 1 /rn /rt 0000 1111 /rm']
###  - Load Register Signed Halfword Unprivileged (Encoding A2)
  | is_unprivileged? = ls LDRSHT cond set0 u set0 rn rt (rx2operand rm)
###  - Load Register Signed Halfword (register)
  | otherwise = ls LDRSH cond p u w rn rt (rx2operand rm)

val str_is_push? s = ($rn s == '1101') and ($p s == '1') and ($u s == '0') and ($imm12 s == '000000000100')

### STR/PUSH
val / ['/cond 010 /P /U 0 /W 0 /rn /rt /imm12']
###  - Push Multiple Registers (Encoding A2)
  | str_is_push? = lsm PUSH cond w rn (rx2reglist rt)
###  - Store Register (immediate)
  | otherwise = ls STR cond p u w rn rt imm12
###  - Store Register (register)
val / ['/cond 011 /P /U 0 /W 0 /rn /rt /immshift /rm'] =
  ls STR cond p u w rn rt shiftedreg

### STRB
###  - Store Register Byte (immediate)
val / ['/cond 010 /P /U 1 /W 0 /rn /rt /imm12'] =
  ls STRB cond p u w rn rt imm12
###  - Store Register Byte (register)
val / ['/cond 011 /P /U 1 /W 0 /rn /rt /immshift /rm'] =
  ls STRB cond p u w rn rt shiftedreg

### STRD
###  - Store Register Dual (immediate)
val / ['/cond 000 /P /U 1 /W 0 /rn /rt /imm4H 1111 /imm4L'] =
  ls STRD cond p u w rn rt combine_imm8
###  - Store Register Dual (register)
val / ['/cond 000 /P /U 0 /W 0 /rn /rt 0000 1111 /rm'] =
  ls STRD cond p u w rn rt (rx2operand rm)

### STRH
###  - Store Register Halfword (immediate)
val / ['/cond 000 /P /U 1 /W 0 /rn /rt /imm4H 1011 /imm4L'] =
  ls STRH cond p u w rn rt combine_imm8
###  - Store Register Halfword (register)
val / ['/cond 000 /P /U 0 /W 0 /rn /rt 0000 1011 /rm'] =
  ls STRH cond p u w rn rt (rx2operand rm)

# --- Load/store multiple instructions ---------------------------------

val ldm_is_pop? s = ($w s == '1') and (($rn s) == '1101') and (reglist-length ($register_list s)) > 1

### LDM/POP
val / ['/cond 100 0 1 0 /W 1 /rn /register_list']
  | ldm_is_pop? = lsm POP cond set1 rn register_list
###  - Load Multiple
  | otherwise = lsm LDM cond (return '1') rn register_list

### LDMDA
###  - Load Multiple Decrement After
val / ['/cond 100 0 0 0 /W 1 /rn /register_list'] =
  lsm LDMDA cond w rn register_list

### LDMDB
###  - Load Multiple Decrement Before
val / ['/cond 100 1 0 0 /W 1 /rn /register_list'] =
  lsm LDMDB cond w rn register_list

### LDMIB
###  - Load Multiple Increment Before
val / ['/cond 100 1 1 0 /W 1 /rn /register_list'] =
  lsm LDMIB cond w rn register_list

### STM
###  - Store Multiple
val / ['/cond 100 0 1 0 /W 0 /rn /register_list'] =
  lsm STM cond w rn register_list

val stmdb_is_push? s = ($w s == '1') and ($rn s == '1101') and (reglist-length ($register_list s)) > 1

### STMDB/PUSH
val / ['/cond 100 1 0 0 /W 0 /rn /register_list']
###  - Push Multiple Registers
  | stmdb_is_push? = lsm PUSH cond w rn register_list
###  - Store Multiple Decrement Before
  | otherwise = lsm STMDB cond w rn register_list

### STMDA
###  - Store Multiple Decrement After
val / ['/cond 100 0 0 0 /W 0 /rn /register_list'] =
  lsm STMDA cond w rn register_list

### STMIB
###  - Store Multiple Increment Before
val / ['/cond 100 1 1 0 /W 0 /rn /register_list'] =
  lsm STMIB cond w rn register_list

# --- Hint instructions ------------------------------------------------

### DBG
###  - Debug Hint
val / ['/cond 001 1 0 0 1 0 0000 1111 0000 1111 opt:4'] = unop DBG cond (immediate (IMM4(opt)))

### NOP
###  - No Operation
val / ['/cond 001 1 0 0 1 0 0000 1111 0000 0000 0000'] = nulop NOP cond

### SEV
###  - Send Event
val / ['/cond 001 1 0 0 1 0 0000 1111 0000 0000 0100'] = nulop SEV cond

### YIELD
###  - Yield
val / ['/cond 001 1 0 0 1 0 0000 1111 0000 0000 0001'] = nulop YIELD cond

### WFE
###  - Wait For Event
val / ['/cond 001 1 0 0 1 0 0000 1111 0000 0000 0010'] = nulop WFE cond

### WFI
###  - Wait For Interrupt
val / ['/cond 001 1 0 0 1 0 0000 1111 0000 0000 0011'] = nulop WFI cond

# --- Miscellaneous instructions ---------------------------------------

# Coming soon...

# --- Exception-generating/-handling instructions

val / ['/cond 111 1 imm24:24'] = unop SVC cond (immediate (IMM24(imm24)))
