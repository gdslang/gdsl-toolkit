export translate: (insndata) -> S sem_stmt_list <{} => {}>

val translate insn = do
  update@{stack=SEM_NIL, tmp=0};

  translate-arm7 insn;

  stack <- query $stack;
  return (rreil-stmts-rev stack)
end

val translate-block-single insn = do
  ic <- query $ins_count;
  update@{tmp=0, ins_count=ic+1};

  translate-arm7 insn
end

val translate-arm7 insn = semantics insn

val relative-next stmts = let
  val is_sem_ip x = case x of
      Sem_PC: '1'
    | _: '0'
  end
in
  relative-next-generic is_sem_ip stmts
end

type instructionset =
    InstrSet_ARM
  | InstrSet_Thumb
  | InstrSet_Jazelle
  | InstrSet_ThumbEE

type signedness =
    Signed
  | Unsigned

val lval x = return (semantic-register-of x)

val rvals sign x = let
  val from-vec sn vector =
    case sn of
        Signed: imm (sx vector)
      | Unsigned: imm (zx vector)
    end
  val from-imm sn immediate =
    case immediate of
        IMMi i: imm i
      | IMM5 i: imm (zx i)
      | IMM12 i: imm (zx i)
      | MODIMM i: imm (armexpandimm i)
    end
in
  case x of
      IMMEDIATE i: return (from-imm sign i)
    | REGISTER r: return (var (semantic-register-of r))
    | SHIFTED_REGISTER r: do
        shift-register r.shift r.register;
        rvals sign (REGISTER r.register)
      end
  end
end

val rval x = rvals Unsigned x

val shift-register shift reg = let
  val do-shift stype amount = do
    rm <- lval reg;
    amount <- amount;
    case stype of
        LSL: shl 32 rm (var rm) amount
      | LSR: shr 32 rm (var rm) amount
      | ASR: shrs 32 rm (var rm) amount
    end
  end
in
    case shift of
        IMMSHIFT s: do-shift s.shifttype (rval (IMMEDIATE s.immediate))
      | REGSHIFT s: do-shift s.shifttype (rval (REGISTER s.register))
    end
end

val semantics insn =
  case insn.insn of
      B x: sem-b x
    | BX x: sem-bx x
    | ADD x: sem-add x
    | MOV x: sem-mov x
    | LDR x: sem-ldr x
    | PUSH x: sem-push x
    | _: sem-default
  end

# ----------------------------------------------------------------------
# Utility functions
# ----------------------------------------------------------------------

# Program Counter register (PC/IP)
val get-pc = lval R15
# Stack Pointer register (SP)
val get-sp = lval R13

val is-pc? sem-reg =
  case sem-reg.id of
      Sem_PC: '1'
    | _: '0'
  end

val condition-passed? cond =
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

# Set the N (negative) flag if the result is less than zero
val emit-flag-n result = do
  nf <- fNF;
  cmplts 32 nf result (imm 0)
end

# Set the Z (zero) flag if the result is zero
val emit-flag-z result = do
  zf <- fZF;
  cmpeq 32 zf result (imm 0)
end

# ----------------------------------------------------------------------
# Bit shifts and rotations
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
# Individual instruction translators
# ----------------------------------------------------------------------

val sem-b x = do
  _if (condition-passed? x.cond) _then do
    offset <- rval x.label;
    pc <- get-pc;
    jump (address 32 (lin-sum (var pc) offset))
  end
end

val sem-bx x = do
  _if (condition-passed? x.cond) _then do
    m <- rval x.label;
    jump (address 32 m)
  end
end

val sem-add x = do
  _if (condition-passed? x.cond) _then do
    op2 <- rval x.op2;
    rd <- lval x.rd;
    rn <- rval x.rn;

    add 32 rd rn op2;

    if x.s then do
      emit-flag-n (var rd);
      emit-flag-z (var rd)
    end else
      return void
  end
end

val sem-mov x = do
  _if (condition-passed? x.cond) _then do
    rd <- lval x.rd;
    op2 <- rval x.op2;

    mov 32 rd op2;

    if x.s then do
      emit-flag-n (var rd);
      emit-flag-z (var rd)
    end else
      return void
  end
end

val sem-ldr x = do
  rt <- lval x.rt;
  rn <- lval x.rn;
  offset <- rval x.offset;

  wback <- return (x.w or (not x.p));
  index <- return x.p;

  offset_addr <- return (
    if x.u then
      SEM_LIN_ADD {opnd1=var rn, opnd2=offset}
    else
      SEM_LIN_SUB {opnd1=var rn, opnd2=offset}
  );

  if wback then
    mov 32 rn offset_addr
  else
    return void
  ;

  if index then
    load 32 rt 32 offset_addr
  else
    load 32 rt 32 (var rn)
end

val sem-push x = let
  val store-registers reglist =
    case reglist of
        REGL_NIL: return void
      | REGL_CONS c: do
          sp <- get-sp;
          store 32 (address 32 (var sp)) (var (semantic-register-of c.head));
          sub sp.size sp (var sp) (imm 4);
          (store-registers c.tail)
      end
    end
in
  _if (condition-passed? x.cond) _then do
    store-registers x.register_list
  end
end

val sem-default = do
  pc <- get-pc;
  add 32 pc (var pc) (imm 0)
end
