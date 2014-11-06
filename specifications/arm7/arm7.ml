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

type insndata = {ip:int, length:int, insn:instruction}

val config-default = ''
val decoder-config = END

# ----------------------------------------------------------------------
# Entry Point
# ----------------------------------------------------------------------

val decode config = do
  endianness endian-little/instr32-little/access32;

  reset;

  idx-before <- get-ip;
  insn <- /;
  idx-after <- get-ip;

  return {ip=idx-before, length=(idx-after - idx-before), insn=insn}
end

# ----------------------------------------------------------------------

val reset = do
  update@{
    cond='0000',
    b='0', p='0', w='0', s='0',
    imm4='0000', imm4H='0000', imm4L='0000',
    imm12='000000000000',
    byte='00000000', rot='0000',
    operands=OPNDL_NIL
  }
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
  | B of unop
  | BL of unop
  | BLX of unop
  | BX of unop
  | BXJ of unop
  | CLREX of nullop
  | DBG of unop
  | DMB of unop
  | NOP of nullop
  | SEV of nullop
  | WFE of nullop
  | WFI of nullop
  | YIELD of nullop
  | SVC of unop

# Standard data-processing instruction
type dp = {
  cond:condition, # condition code
  s:1,            # whether the APSR flags should be set
  rn:operand,     # first operand register
  rd:operand,     # destination register
  opnd2:operand   # second operand (immediate or register)
}

# Standard multiplication instructions
type mul = {
  cond:condition,
  s:1,
  rd:operand,
  ra:operand,
  rm:operand,
  rn:operand
}

# Long mulitplication instructions
type mull = {
  cond:condition,
  s:1,
  rdhi:operand,
  rdlo:operand,
  rn:operand,
  rm:operand
}

# Load/store instruction
type ls = {
  cond:condition,
  p:1,
  u:1,
  w:1,
  rn:operand,
  rt:operand,
  offset:operand
}

# Load/store multiple instructions
type lsm = {
  cond:condition,
  w:1,
  rn:operand,
  registers:operand
}

# Generic instruction without any operands
type nullop = {
  cond:condition
}

# Generic instruction with one operand
type unop = {
  cond:condition,
  opnd:operand
}

# Generic instruction with two operands
type binop = {
  cond:condition,
  opnd1:operand,
  opnd2:operand
}

type operand =
    IMMEDIATE of immediate
  | REGISTER of register
  | SHIFTED_OPERAND of shiftedoperand
  | OPERAND_LIST of operandlist (* TODO: Replace with operand tuple, maybe? *)

type immediate =
    IMMi of int
  | IMM4 of 4
  | IMM5 of 5
  | IMM8 of 8
  | IMM12 of 12
  | IMM16 of 16
  | IMM24 of 24
  | MODIMM of {byte:8, rot:4} # 8 bit immediate with 4 bit rotation

type operandlist =
    OPNDL_NIL
  | OPNDL_CONS of {hd:operand, tl:operandlist}

val opndl-none = OPNDL_NIL
val opndl-one op = OPNDL_CONS {hd=op, tl=OPNDL_NIL}
val opndl-more op tl = OPNDL_CONS {hd=op, tl=tl}

val opndl-length opndl =
  case opndl of
      OPNDL_NIL: 0
    | OPNDL_CONS l: 1 + (opndl-length l.tl)
  end

type shiftedoperand = {opnd:operand, shift:shift}
type shift = {amount:operand, shifttype:shifttype}

type shifttype =
    LSL  # Logical Shift Left
  | LSR  # Logical Shift Right
  | ASR  # Arithmetic Shift Right
  | ROR  # Rotate Right
  | RRX  # Rotate Right with Extend

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

val is-pc? r =
  case r of
      R15: '1'
    | _: '0'
  end

val is-sp? r =
  case r of
      R13: '1'
    | _: '0'
  end

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

# ----------------------------------------------------------------------
# Utility Functions
# ----------------------------------------------------------------------

val dp cons cond s rn rd opnd2 = do
  cond <- cond;
  s <- s;
  rn <- rn;
  rd <- rd;
  opnd2 <- opnd2;
  return (cons {cond=cond, s=s, rn=rn, rd=rd, opnd2=opnd2})
end

val ml cons cond s rd ra rm rn = do
  cond <- cond;
  s <- s;
  rd <- rd;
  ra <- ra;
  rm <- rm;
  rn <- rn;
  return (cons {cond=cond, s=s, rd=rd, ra=ra, rm=rm, rn=rn})
end

val mull cons cond s rdhi rdlo rm rn = do
  cond <- cond;
  s <- s;
  rdhi <- rdhi;
  rdlo <- rdlo;
  rm <- rm;
  rn <- rn;
  return (cons {cond=cond, s=s, rdhi=rdhi, rdlo=rdlo, rn=rn, rm=rm})
end

val ls cons cond p u w rn rd offset = do
  cond <- cond;
  p <- p;
  u <- u;
  w <- w;
  rn <- rn;
  rt <- rt;
  offset <- offset;
  return (cons {cond=cond, p=p, u=u, w=w, rn=rn, rt=rt, offset=offset})
end

val lsm cons cond w rn registers = do
  cond <- cond;
  w <- w;
  rn <- rn;
  registers <- registers;
  return (cons {cond=cond, w=w, rn=rn, registers=registers})
end

val nullop cons cond = do
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

val register cons = REGISTER cons
val immediate cons = return (IMMEDIATE cons)
val shiftedoperand cons = SHIFTED_OPERAND cons
val operandlist cons = OPERAND_LIST cons

val immint i = IMMEDIATE (IMMi i)

val imm-to-int imm =
  case imm of
      IMMi i: i
    | IMM4 i: zx i
    | IMM5 i: zx i
    | IMM8 i: zx i
    | IMM12 i: zx i
    | IMM24 i: zx i
    | MODIMM i: armexpandimm i
  end

val is-zero? imm = (imm-to-int imm) === 0

# Modulo. I didn't see this operator anywhere else...
val /mod a b = a - (/z a b) * b

# Creates a operand list from a (16 bit) bit vector.
# If bit i is set, then the register Ri is added to the list.
val decode-registerlist bitvec = let
  val from-int i index =
    if i > 0 then
      if /mod i 2 === 1 then
        opndl-more (register (register-from-int index)) (from-int (/z i 2) (index + 1))
      else
        from-int (/z i 2) (index + 1)
    else
      opndl-none
in
  from-int (zx bitvec) 0
end

val register-from-int i =
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

val decode-register bitvec = register-from-int (zx bitvec)

val decode-shifttype bitvec =
  case bitvec of
      '00' : LSL
    | '01' : LSR
    | '10' : ASR
    | '11' : ROR
  end

val decode-condition bitvec =
  case bitvec of
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
# Bit Shifts and Rotations
# ----------------------------------------------------------------------

### Most significant bit
val msb x = /z (/mod x 0x100000000) 0x80000000
### Least significant bit
val lsb x = /mod x 2

### LSL_C
###  - Logical Shift Left (w/ carry out)
val lsl-c x shift = let
  val lsl-shift value amount carry_in =
    if amount === 0 then
      {result=value, carry_out=carry_in}
    else
      lsl-shift (value * 2) (amount - 1) (msb value)
in
  lsl-shift (/mod x 0x100000000) shift 0
end

### LSL
###  - Logical Shift Left
val lsl x shift = (lsl-c x shift).result

### LSR_C
###  - Logical Shift Right (w/ carry out)
val lsr-c x shift = let
  val lsr-shift value amount carry_in =
    if amount === 0 then
      {result=value, carry_out=carry_in}
    else
      lsr-shift (/z value 2) (amount - 1) (lsb value)
in
  lsr-shift (/mod x 0x100000000) shift 0
end

### LSR
###  - Logical Shift Right
val lsr x shift = (lsr-c x shift).result

### ASR_C
###  - Arithmetic Shift Right (w/ carry out)
val asr-c x shift = let
  val asr-shift value amount carry_in =
    if amount === 0 then
      {result=value, carry_out=carry_in}
    else
      asr-shift ((/z value 2) + (0x80000000 * (msb value))) (amount - 1) (lsb value)
in
  asr-shift (/mod x 0x100000000) shift 0
end

### ASR
###  - Arithmetic Shift Right
val asr x shift = (asr-c x shift).result

### ROR_C
###  - Rotate Right (w/ carry out)
val ror-c x shift = let
  val rotate-r value amount carry_in =
    if amount === 0 then
      {result=value, carry_out=carry_in}
    else
      rotate-r ((/z value 2) + (0x80000000 * (lsb value))) (amount - 1) (lsb value)
in
  rotate-r (/mod x 0x100000000) shift 0
end

### ROR
###  - Rotate Right
val ror x shift = (ror-c x shift).result

### RRX_C
###  - Rotate Right with Extend (w/ carry out)
val rrx-c x carry_in = {
  result=((/z (/mod x 0x100000000) 2) + (0x80000000 * carry_in)),
  carry_out=(lsb x)
}

### RRX
###  - Rotate Right with Extend
val rrx x carry_in = (rrx-c x carry_in).result

### Shift_C [[A8.4.3]]
val shift-c value stype amount carry_in =
  if amount === 0 then
    {result=value, carry_out=carry_in}
  else
    case stype of
        LSL: lsl-c value amount
      | LSR: lsr-c value amount
      | ASR: asr-c value amount
      | ROR: ror-c value amount
      | RRX: rrx-c value carry_in
    end

### Shift [[A8.4.3]]
val shift value stype amount carry_in =
  (shift-c value stype amount carry_in).result

### ArmExpandImm_C [[A5.2.4]]
val armexpandimm-c modimm carry_in =
  shift-c (zx modimm.byte) ROR (2 * (zx modimm.rot)) carry_in

### ArmExpandImm [[A5.2.4]]
val armexpandimm modimm = (armexpandimm-c modimm 0).result

# ----------------------------------------------------------------------
# Subdecoder
# ----------------------------------------------------------------------

# --- condition subdecoders --------------------------------------------

# 4 bit condition code; cannot be '1111'
val /cond ['cond@0...'] = update@{cond=cond}
val /cond ['cond@10..'] = update@{cond=cond}
val /cond ['cond@110.'] = update@{cond=cond}
val /cond ['cond@1110'] = update@{cond=cond}

val cond = do
  cond <- query $cond;
  return (decode-condition cond)
end

val none = return NV

# --- flag subdecoders -------------------------------------------------

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

val set0 = return '0'
val set1 = return '1'

# --- immediate subdecoders --------------------------------------------

# default 12 bit immediate
val /imm12 ['imm12:12'] = update@{imm12=imm12}

val imm12 = do
  imm12 <- query $imm12;
  imm <- immediate (IMM12 (imm12));
  return imm
end

(* TODO: Why does the 24bit subdecoder not compile??? *)
val /imm24 ['imm24:25'] = update@{imm24=imm24}

val /imm4H ['imm4H:4'] = update@{imm4H=imm4H}
val /imm4L ['imm4L:4'] = update@{imm4L=imm4L}

val combine-imm8 = do
  imm4H <- query $imm4H;
  imm4L <- query $imm4L;
  imm <- immediate (IMM8 (imm4H^imm4L));
  return imm
end

val /imm4 ['imm4:4'] = update@{imm4=imm4}

val imm4 = do
  imm4 <- query $imm4;
  imm <- immediate (IMM4 (imm4));
  return imm
end

# concats the 4 bit and 12 bit immediates that were decoded most recently
val combine-imm16 = do
  imm4 <- query $imm4;
  imm12 <- query $imm12;
  imm <- immediate (IMMi (zx (imm4^imm12)));
  return imm
end

# modified 12 bit immediate (8 bit immediate with rotation)
val /modimm ['rot:4 byte:8'] = update@{rot=rot, byte=byte}

val modimm = do
  rot <- query $rot;
  byte <- query $byte;
  ret <- immediate (MODIMM {byte=byte, rot=rot});
  return ret
end

# --- shifted operand decoders -----------------------------------------

val /shiftedreg ['/immshift /rm'] = (return 0)
val /shiftedreg ['/regshift /rm'] = (return 0)

# operand subdecoder: register + immediate shift
val /immshift ['imm5:5 stype:2 0'] = do
  imm <- immediate (IMM5 imm5);
  update@{shift={amount=imm, shifttype=(decode-shifttype stype)}}
end

# operand subdecoder: register + register controlled shift
val /regshift ['rs:4 0 stype:2 1'] = do
  reg <- return (register (decode-register rs));
  update@{shift={amount=reg, shifttype=(decode-shifttype stype)}}
end

val shiftedreg = do
  shift <- query $shift;
  rm <- query $rm;
  return (shiftedoperand {opnd=(register rm), shift=shift})
end

# --- operand list/register list subdecoders ---------------------------

val /registerlist ['regs:16'] = update@{operands=(decode-registerlist regs)}

val registerlist = do
  operands <- query $operands;
  return (operandlist operands)
end

val registerlist-one rx = do
  reg <- rx;
  return (operandlist (opndl-one reg))
end

# --- register subdecoders ---------------------------------------------

val /ra ['ra:4'] = update@{ra=(decode-register ra)}
val /rd ['rd:4'] = update@{rd=(decode-register rd)}
val /rm ['rm:4'] = update@{rm=(decode-register rm)}
val /rn ['rn:4'] = update@{rn=(decode-register rn)}
val /rt ['rt:4'] = update@{rt=(decode-register rt)}

val /rdhi ['rdhi:4'] = update@{rdhi=(decode-register rdhi)}
val /rdlo ['rdlo:4'] = update@{rdlo=(decode-register rdlo)}

val ra = do
  ra <- query $ra;
  return (register ra)
end

val rd = do
  rd <- query $rd;
  return (register rd)
end

val rm = do
  rm <- query $rm;
  return (register rm)
end

val rn = do
  rn <- query $rn;
  return (register rn)
end

val rt = do
  rt <- query $rt;
  return (register rt)
end

val rdhi = do
  rdhi <- query $rdhi;
  return (register rdhi)
end

val rdlo = do
  rdlo <- query $rdlo;
  return (register rdlo)
end

val r0 = return (register R0)

# ----------------------------------------------------------------------
# Instruction Decoding
# ----------------------------------------------------------------------

# --- Branching Instructions -------------------------------------------

### B
### - Branch
val / ['/cond 101 0 imm24:24'] = unop B cond (immediate (IMMi(sx (imm24^'00'))))

### BL
###  - Branch with Link
val / ['/cond 101 1 imm24:24'] = unop BL cond (immediate (IMMi(sx (imm24^'00'))))

### BLX
###  - Branch with Link and Exchange (Immediate)
val / ['1111 101 h:1 imm24:24'] = unop BLX none (immediate (IMMi(sx (imm24^h^'0'))))
###  - Branch with Link and Exchange (Register)
val / ['/cond 000 1 0 0 1 0 1111 1111 1111 0011 /rm'] = unop BLX cond rm

### BX
### - Branch and Exchange
val / ['/cond 000 1 0 0 1 0 1111 1111 1111 0001 /rm'] = unop BX cond rm

### BXJ
###  - Branch and Exchange Jazelle
val / ['/cond 000 1 0 0 1 0 1111 1111 1111 0010 /rm'] = unop BXJ cond rm

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
val / ['/cond 001 1 0 1 1 1 /rn 0000 /modimm'] = dp CMN cond set1 rn r0 modimm
###  - Compare Negative (shifted register)
val / ['/cond 000 1 0 1 1 1 /rn 0000 /shiftedreg'] = dp CMN cond s rn r0 shiftedreg

### CMP
###  - Compare (immediate)
val / ['/cond 001 1 0 1 0 1 /rn 0000 /modimm'] = dp CMP cond set1 rn r0 modimm
###  - Compare (shifted register)
val / ['/cond 000 1 0 1 0 1 /rn 0000 /shiftedreg'] = dp CMP cond set1 rn r0 shiftedreg

### EOR
###  - Bitwise Exclusive OR (immediate)
val / ['/cond 001 0 0 0 1 /S /rn /rd /modimm'] = dp EOR cond s rn rd modimm
###  - Bitwise Exclusive OR (shifted register)
val / ['/cond 000 0 0 0 1 /S /rn /rd /shiftedreg'] = dp EOR cond s rn rd shiftedreg

### MOV
###  - Move (immediate) (Encoding A1)
val / ['/cond 001 1 1 0 1 /S 0000 /rd /modimm'] = dp MOV cond s r0 rd modimm
###  - Move (immediate) (Encoding A2)
val / ['/cond 001 1 0 0 0 0 /imm4 /rd /imm12'] = dp MOV cond set0 r0 rd combine-imm16
###  - Move (shifted register)
val / ['/cond 000 1 1 0 1 /S 0000 /rd /shiftedreg'] = dp MOV cond s r0 rd shiftedreg

### MVN
###  - Bitwise NOT (immediate)
val / ['/cond 001 1 1 1 1 /S 0000 /rd /modimm'] = dp MVN cond s r0 rd modimm
###  - Bitwise NOT (shifted register)
val / ['/cond 000 1 1 1 1 /S 0000 /rd /shiftedreg'] = dp MVN cond s r0 rd shiftedreg

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
val / ['/cond 001 1 0 0 1 1 /rn 0000 /modimm'] = dp TEQ cond set1 rn r0 modimm
###  - Test Equivalence (shifted register)
val / ['/cond 000 1 0 0 1 1 /rn 0000 /shiftedreg'] = dp TEQ cond set1 rn r0 shiftedreg

### TST
###  - Test (immediate)
val / ['/cond 001 1 0 0 0 1 /rn 0000 /modimm'] = dp TST cond set1 rn r0 modimm
###  - Test (shifted register)
val / ['/cond 000 1 0 0 0 1 /rn 0000 /shiftedreg'] = dp TST cond s rn r0 shiftedreg

# --- Shift instructions -----------------------------------------------

(* NOTE: These instructions are implemented by MOV (shifted register) *)

# --- Multiply instructions --------------------------------------------

### MLA
###  - Multiply Accumulate
val / ['/cond 000 0 0 0 1 /S /rd /ra /rm 1001 /rn'] = ml MLA cond s rd ra rm rn

### MLS
###  - Multiply and Subtract
val / ['/cond 000 0 0 1 1 0 /rd /ra /rm 1001 /rn'] = ml MLS cond set0 rd ra rm rn

### MUL
###  - Multiply
val / ['/cond 000 0 0 0 0 /S /rd 0000 /rm 1001 /rn'] = ml MUL cond s rd r0 rm rn

### SMLAL
###  - Signed Multiply Accumulate Long
val / ['/cond 000 0 1 1 1 /S /rdhi /rdlo /rm 1001 /rn'] = mull SMLAL cond s rdhi rdlo rm rn

### SMULL
###  - Signed Multiply Long
val / ['/cond 000 0 1 1 0 /S /rdhi /rdlo /rm 1001 /rn'] = mull SMULL cond s rdhi rdlo rm rn

### UMLAL
###  - Unsigned Multiply Accumulate Long
val / ['/cond 000 0 1 0 1 /S /rdhi /rdlo /rm 1001 /rn'] = mull UMLAL cond s rdhi rdlo rm rn

### UMULL
###  - Unsigned Multiply Long
val / ['/cond 000 0 1 0 0 /S /rdhi /rdlo /rm 1001 /rn'] = mull UMULL cond s rdhi rdlo rm rn

# --- Miscellaneous data-processing instructions -----------------------

### CLZ
###  - Count Leading Zeros
val / ['/cond 000 1 0 1 1 0 1111 /rd 1111 0001 /rm'] = binop CLZ cond rd rm

# --- Load/store instructions ------------------------------------------

val ldr_is_pop? s = (is-sp? s.rn) and (not s.p) and s.u and (not s.w) and (s.imm12 == '000000000100')
val unprivileged? s = (not s.p) and s.w

### LDR/LDRT/POP
val / ['/cond 010 /P /U 0 /W 1 /rn /rt /imm12']
###  - Pop Multiple Registers (Encoding A2)
  | ldr_is_pop? = lsm POP cond w rn (registerlist-one rt)
###  - Load Register Unprivileged (Encoding A1)
  | unprivileged? = ls LDRT cond set0 u set0 rn rt imm12
###  - Load Register (immediate/literal)
  | otherwise = ls LDR cond p u w rn rt imm12
val / ['/cond 011 /P /U 0 /W 1 /rn /rt /immshift /rm']
###  - Load Register Unprivileged (Encoding A2)
  | unprivileged? = ls LDRT cond set0 u set0 rn rt shiftedreg
###  - Load Register (register)
  | otherwise = ls LDR cond p u w rn rt shiftedreg

### LDRB/LDRBT
val / ['/cond 010 /P /U 1 /W 1 /rn /rt /imm12']
###  - Load Register Byte Unprivileged (Encoding A1)
  | unprivileged? = ls LDRBT cond set0 u set0 rn rt imm12
###  - Load Register Byte (immediate/literal)
  | otherwise = ls LDRB cond p u w rn rt imm12
val / ['/cond 011 /P /U 1 /W 1 /rn /rt /immshift /rm']
###  - Load Register Byte Unprivileged (Encoding A2)
  | unprivileged? = ls LDRBT cond set0 u set0 rn rt shiftedreg
###  - Load Register Byte (register)
  | otherwise = ls LDRB cond p u w rn rt shiftedreg

### LDRD
val / ['/cond 000 /P /U 1 /W 0 /rn /rt /imm4H 1101 /imm4L'] =
###  - Load Register Dual (immediate/literal)
  ls LDRD cond p u w rn rt combine-imm8
###  - Load Register Dual (register)
val / ['/cond 000 /P /U 0 /W 0 /rn /rt 0000 1101 /rm'] =
  ls LDRD cond p u w rn rt rm

### LDRH/LDRHT
val / ['/cond 000 /P /U 1 /W 1 /rn /rt /imm4H 1011 /imm4L']
###  - Load Register Halfword Unprivileged (Encoding A1)
  | unprivileged? = ls LDRHT cond set0 u set0 rn rt combine-imm8
###  - Load Register Halfword (immediat/literal)
  | otherwise = ls LDRH cond p u w rn rt combine-imm8
val / ['/cond 000 /P /U 0 /W 1 /rn /rt 0000 1011 /rm']
###  - Load Register Halfword Unprivileged (Encoding A2)
  | unprivileged? = ls LDRHT cond set0 u set0 rn rt rm
###  - Load Register Halfword (register)
  | otherwise = ls LDRH cond p u w rn rt rm

### LDRSB/LDRSBT
val / ['/cond 000 /P /U 1 /W 1 /rn /rt /imm4H 1101 /imm4L']
###  - Load Register Signed Byte (Encoding A1)
  | unprivileged? = ls LDRSBT cond set0 u set0 rn rt combine-imm8
###  - Load Register Signed Byte (immediate/literal)
  | otherwise = ls LDRSB cond p u w rn rt combine-imm8
val / ['/cond 000 /P /U 0 /W 1 /rn /rt 0000 1101 /rm']
###  - Load Register Signed Byte (Encoding A2)
  | unprivileged? = ls LDRSBT cond set0 u set0 rn rt rm
###  - Load Register Signed Byte (register)
  | otherwise = ls LDRSB cond p u w rn rt rm

### LDRSH/LDRSHT
val / ['/cond 000 /P /U 1 /W 1 /rn /rt /imm4H 1111 /imm4L']
###  - Load Register Signed Halfword Unprivileged (Encoding A1)
  | unprivileged? = ls LDRSHT cond set0 u set0 rn rt combine-imm8
###  - Load Register Signed Halfword (immediate/literal)
  | otherwise = ls LDRSH cond p u w rn rt combine-imm8
val / ['/cond 000 /P /U 0 /W 1 /rn /rt 0000 1111 /rm']
###  - Load Register Signed Halfword Unprivileged (Encoding A2)
  | unprivileged? = ls LDRSHT cond set0 u set0 rn rt rm
###  - Load Register Signed Halfword (register)
  | otherwise = ls LDRSH cond p u w rn rt rm

val str-is-push? s = (is-sp? s.rn) and (not s.u) and (s.imm12 == '000000000100')

### STR/PUSH
val / ['/cond 010 /P /U 0 /W 0 /rn /rt /imm12']
###  - Push Multiple Registers (Encoding A2)
  | str-is-push? = lsm PUSH cond w rn (registerlist-one rt)
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
  ls STRD cond p u w rn rt combine-imm8
###  - Store Register Dual (register)
val / ['/cond 000 /P /U 0 /W 0 /rn /rt 0000 1111 /rm'] =
  ls STRD cond p u w rn rt rm

### STRH
###  - Store Register Halfword (immediate)
val / ['/cond 000 /P /U 1 /W 0 /rn /rt /imm4H 1011 /imm4L'] =
  ls STRH cond p u w rn rt combine-imm8
###  - Store Register Halfword (register)
val / ['/cond 000 /P /U 0 /W 0 /rn /rt 0000 1011 /rm'] =
  ls STRH cond p u w rn rt rm

# --- Load/store multiple instructions ---------------------------------

val ldm-is-pop? s = (is-sp? s.rn) and s.w and (opndl-length s.operands) > 1

### LDM/POP
val / ['/cond 100 0 1 0 /W 1 /rn /registerlist']
###  - Pop Multiple Registers (Encoding A1)
  | ldm-is-pop? = lsm POP cond set1 rn registerlist
###  - Load Multiple
  | otherwise = lsm LDM cond (return '1') rn registerlist

### LDMDA
###  - Load Multiple Decrement After
val / ['/cond 100 0 0 0 /W 1 /rn /registerlist'] = lsm LDMDA cond w rn registerlist

### LDMDB
###  - Load Multiple Decrement Before
val / ['/cond 100 1 0 0 /W 1 /rn /registerlist'] = lsm LDMDB cond w rn registerlist

### LDMIB
###  - Load Multiple Increment Before
val / ['/cond 100 1 1 0 /W 1 /rn /registerlist'] = lsm LDMIB cond w rn registerlist

### STM
###  - Store Multiple
val / ['/cond 100 0 1 0 /W 0 /rn /registerlist'] = lsm STM cond w rn registerlist

val stmdb-is-push? s = (is-sp? s.rn) and s.w and (opndl-length s.operands) > 1

### STMDB/PUSH
val / ['/cond 100 1 0 0 /W 0 /rn /registerlist']
###  - Push Multiple Registers (Encoding A1)
  | stmdb-is-push? = lsm PUSH cond w rn registerlist
###  - Store Multiple Decrement Before
  | otherwise = lsm STMDB cond w rn registerlist

### STMDA
###  - Store Multiple Decrement After
val / ['/cond 100 0 0 0 /W 0 /rn /registerlist'] = lsm STMDA cond w rn registerlist

### STMIB
###  - Store Multiple Increment Before
val / ['/cond 100 1 1 0 /W 0 /rn /registerlist'] = lsm STMIB cond w rn registerlist

# --- Miscellaneous instructions ---------------------------------------

### CLREX
###  - Clear-Exclusive
val / ['1111 010 1 0 1 1 1 1111 1111 0000 0001 1111'] = nullop CLREX none

### DBG
###  - Debug Hint
val / ['/cond 001 1 0 0 1 0 0000 1111 0000 1111 /imm4'] = unop DBG cond imm4

### NOP
###  - No Operation
val / ['/cond 001 1 0 0 1 0 0000 1111 0000 0000 0000'] = nullop NOP cond

### SEV
###  - Send Event
val / ['/cond 001 1 0 0 1 0 0000 1111 0000 0000 0100'] = nullop SEV cond

### YIELD
###  - Yield
val / ['/cond 001 1 0 0 1 0 0000 1111 0000 0000 0001'] = nullop YIELD cond

### WFE
###  - Wait For Event
val / ['/cond 001 1 0 0 1 0 0000 1111 0000 0000 0010'] = nullop WFE cond

### WFI
###  - Wait For Interrupt
val / ['/cond 001 1 0 0 1 0 0000 1111 0000 0000 0011'] = nullop WFI cond

# --- Exception-generating/-handling instructions

val / ['/cond 111 1 imm24:24'] = unop SVC cond (immediate (IMM24(imm24)))
