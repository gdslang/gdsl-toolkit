export translate: (insndata) -> S sem_stmt_list <{} => {}>

val translate insn = do
  update@{stack=SEM_NIL, tmp=0, lab=0};

  translate-arm7 insn;

  stack <- query $stack;
  return (rreil-stmts-rev stack)
end

val translate-block-single insn = do
  update@{tmp=0};
  translate-arm7 insn
end

val translate-arm7 insn = do
  semantics insn.insn
end

val relative-next stmts = let
  val is_sem_ip x = case x of
      Sem_PC: '1'
    | _: '0'
  end
in
  relative-next-generic is_sem_ip stmts
end

type signedness =
    Signed
  | Unsigned

val rval sn x = let
  val from-vec sn vec =
    case sn of
        Signed: SEM_LIN_IMM {const=sx vec}
      | Unsigned: SEM_LIN_IMM {const=zx vec}
    end
  val from-imm sn imm =
    case imm of
        IMMi i: SEM_LIN_IMM {const=i}
    end
in
  case x of
      REGISTER r: return (var (semantic-register-of r))
    | IMMEDIATE i: return (from-imm sn i)
  end
end

val semantics insn =
  case insn of
      B x: sem-b x
  end

# ----------------------------------------------------------------------
# Utility functions
# ----------------------------------------------------------------------

# Program Counter register (PC/IP)
val get-pc = semantic-register-of R15
# Stack Pointer register (SP)
val get-sp = semantic-register-of R13

val sem-cc cond =
  case cond of
      EQ: /eq 1 get-zf (imm 1)
    | NE: /eq 1 get-zf (imm 0)
    | CS: /eq 1 get-cf (imm 1)
    | CC: /eq 1 get-cf (imm 0)
    | MI: /eq 1 get-nf (imm 1)
    | PL: /eq 1 get-nf (imm 0)
    | VS: /eq 1 get-vf (imm 1)
    | VC: /eq 1 get-vf (imm 0)
    | HI: /and (/eq 1 get-cf (imm 1)) (/eq 1 get-zf (imm 0))
    | LS: /and (/eq 1 get-cf (imm 0)) (/eq 1 get-zf (imm 1))
    | GE: /eq 1 get-nf get-vf
    | LT: /neq 1 get-nf get-vf
    | GT: /and (/eq 1 get-zf (imm 0)) (/eq 1 get-nf get-vf)
    | LE: /and (/eq 1 get-zf (imm 1)) (/neq 1 get-nf get-vf)
    | AL: const 1
  end

# ----------------------------------------------------------------------
# Bit shifts and rotations
# ----------------------------------------------------------------------

### Most significant bit
val msb x = /z (/mod x 0x100000000) 0x80000000
### Least significant bit
val lsb x = /mod x 2

### Logical Shift Left (with carry out)
### (result, carry_out) = LSL_C(x, shift)
val lsl-c x shift = let
  val lsl-shift value amount carry_in =
    if amount === 0 then
      {result=value, carry_out=carry_in}
    else
      lsl-shift (value * 2) (amount - 1) (msb value)
in
  lsl-shift (/mod x 0x100000000) shift 0
end

### Logical Shift Left
val lsl x shift = (lsl-c x shift).result

### Logical Shift Right (with carry out)
### (result, carry_out) = LSR_C(x, shift)
val lsr-c x shift = let
  val lsr-shift value amount carry_in =
    if amount === 0 then
      {result=value, carry_out=carry_in}
    else
      lsr-shift (/z value 2) (amount - 1) (lsb value)
in
  lsr-shift (/mod x 0x100000000) shift 0
end

### Logical Shift Right
val lsr x shift = (lsr-c x shift).result

### Arithmetic Shift Right (with carry out)
### (result, carry_out) = ASR_C(x, shift)
val asr-c x shift = let
  val asr-shift value amount carry_in =
    if amount === 0 then
      {result=value, carry_out=carry_in}
    else
      asr-shift ((/z x 2) + (0x80000000 * (msb value))) (amount - 1) (lsb value)
in
  asr-shift (/mod x 0x100000000) shift 0
end

### Arithmetic Shift Right
val asr x shift = (asr-c x shift).result

### Rotate Right (with carry out)
### (result, carry_out) = ROR_C(x, shift)
val ror-c x shift = let
  val rotate-r value amount carry_in =
    if amount === 0 then
      {result=value, carry_out=carry_in}
    else
      rotate-r ((/z x 2) + (0x80000000 * (lsb value))) (amount - 1) (lsb value)
in
  rotate-r (/mod x 0x100000000) shift 0
end

### Rotate Right
val ror x shift = (ror-c x shift).result

### Rotate Right with Extend (with carry out)
### (result, carry_out) = RRX_C(x, carry_in)
val rrx-c x carry_in = {
  result=((/z (/mod x 0x100000000) 2) + (0x80000000 * carry_in)),
  carry_out=(lsb x)
}

### Rotate Right with Extend
val rrx x carry_in = (rrx-c x carry_in).result

# ----------------------------------------------------------------------
# Individual instruction translators
# ----------------------------------------------------------------------

val sem-b x = do
  offset <- rval Unsigned x.label;
  _if (sem-cc x.cond) _then
    jump (address get-pc.size offset)
end

