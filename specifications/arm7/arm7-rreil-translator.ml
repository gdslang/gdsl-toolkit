export translate: (insndata) -> S sem_stmt_list <{} => {}>

val translate insn = do
  update@{stack=SEM_NIL, tmp=0, carry=0};

  translate-arm7 insn;

  stack <- query $stack;
  return (rreil-stmts-rev stack)
end

val translate-block-single insn = do
  ic <- query $ins_count;
  update@{tmp=0, carry=0, ins_count=ic+1};

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

val lval x =
  case x of
      REGISTER r: return (semantic-register-of r)
  end

val rvals sign x = let
  val from-vec sn vector =
    case sn of
        Signed: imm (sx vector)
      | Unsigned: imm (zx vector)
    end
  val from-imm sn immediate =
    case immediate of
        IMMi i: imm i
      | IMM5 i: from-vec sign i
      | IMM12 i: from-vec sign i
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

(* TODO: Add RRX rotation. *)
val shift-register shift reg = let
  val do-shift stype amount = do
    rm <- return (semantic-register-of reg);
    amount <- amount;
    case stype of
        LSL: sem-lsl 32 rm amount
      | LSR: shr 32 rm (var rm) amount
      | ASR: shrs 32 rm (var rm) amount
      | ROR: sem-ror 32 rm amount
    end
  end
in
  case shift of
      IMMSHIFT s:
        if is-zero? s.immediate then
          return void
        else
          do-shift s.shifttype (rval (IMMEDIATE s.immediate))
    | REGSHIFT s: do-shift s.shifttype (rval (REGISTER s.register))
  end
end

val semantics insn =
  case insn.insn of
      B x: sem-b x
    | BL x: sem-bl x
    | BX x: sem-bx x
    | ADD x: sem-add x
    | ADC x: sem-adc x
    | AND x: sem-and x
    | CMN x: sem-cmn x
    | CMP x: sem-cmp x
    | MOV x: sem-mov x
    | SUB x: sem-sub x
    | LDR x: sem-ldr x
    | POP x: sem-pop x
    | PUSH x: sem-push x
    | STR x: sem-str x
    | _: sem-default
  end

# ----------------------------------------------------------------------
# Utility functions
# ----------------------------------------------------------------------

# Program Counter register (PC/IP)
val get-pc = lval (REGISTER R15)

val is-pc? sem-reg =
  case sem-reg.id of
      Sem_PC: '1'
    | _: '0'
  end

# Stack Pointer register (SP)
val get-sp = lval (REGISTER R13)

# Link register (LR)
val get-lr = lval (REGISTER R14)

val instr-set-arm? = /eq 1 (var isetstate) (imm 0)
val instr-set-thumb? = /eq 1 (var isetstate) (imm 1)
val instr-set-jazelle? = /eq 1 (var isetstate) (imm 2)
val instr-set-thumbee? = /eq 1 (var isetstate) (imm 3)

val select-instr-set iset =
  case iset of
      InstrSet_ARM: mov isetstate.size isetstate (imm 0)
    | InstrSet_Thumb: mov isetstate.size isetstate (imm 1)
    | InstrSet_Jazelle: mov isetstate.size isetstate (imm 2)
    | InstrSet_ThumbEE: mov isetstate.size isetstate (imm 3)
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

# align lvalue to multiple of num_bytes
val align lhs num_bytes =
  andb lhs.size lhs (var lhs) (imm ((power 2 lhs.size) - num_bytes))

# jump/branch to target address [[B1.3.2]]
val branch-to target = jump (address 32 (var target))

# simple branch [[A2.3.2]]
val branch-write-pc addr = do
  _if instr-set-arm? _then do # ARM
    align addr 4;
    branch-to addr
  end _else do # Thumb
    align addr 2;
    branch-to addr
  end
  (* TODO: Jazelle branch handling is missing here... *)
end

# interworking branch (instruction set switch) [[A2.3.2]]
val bx-write-pc addr = do
  _if instr-set-thumbee? _then do
    _if (/eq 1 (var addr) (imm 1)) _then do
      align addr 2;
      branch-to addr
    end
  end _else do
    _if (/eq 1 (var addr) (imm 1)) _then do
      select-instr-set InstrSet_Thumb;
      align addr 2;
      branch-to addr
    end _else do
      _if (/eq 2 (var addr) (imm 0)) _then do
        select-instr-set InstrSet_ARM;
        branch-to addr
      end
    end
  end
end

# architecture version specific branch [[A2.3.2]]
val load-write-pc addr = bx-write-pc addr

# instrset/arch version specific branch [[A2.3.2]]
val alu-write-pc addr = do
  _if instr-set-arm? _then do
    bx-write-pc addr
  end _else do
    branch-write-pc addr
  end
end

# set the N flag, if the result is negative.
val emit-flag-n result = do
  nf <- fNF;
  cmplts 32 nf result (imm 0)
end

# set the Z flag, if the result is zero.
val emit-flag-z result = do
  zf <- fZF;
  cmpeq 32 zf result (imm 0)
end

# sum = x + y + carry_in [[A2.2.1]]
# NOTE: This operation updates the APSR flags.
val add-with-carry sz sum x y carry_in setflags = do
  add sz sum x y;
  add sz sum (var sum) carry_in;

  if setflags then do
    emit-flag-n (var sum);
    emit-flag-z (var sum);

    cf <- fCF;
    vf <- fVF;
    t1 <- mktemp;
    t2 <- mktemp;
    t3 <- mktemp;

    # Set the C flag in case of unsigned overflow (carry).
    cmpltu sz cf (var sum) x;

    # Set the V flag in case of signed overflow.
    xorb sz t1 (var sum) x;
    xorb sz t2 (var sum) y;
    andb sz t3 (var t1) (var t2);
    cmplts sz vf (var t3) (imm 0)
  end else
    return void
end

val sem-lsl sz opnd shift = do
  cf <- fCF;
  _if (/gtu sz shift (imm 32)) _then do
    mov 1 cf (imm 0)
  end _else do
    shift_inv <- mktemp;
    shr sz shift_inv (var opnd) (lin-sub (imm 32) shift);
    mov 1 cf (var shift_inv)
  end;

  shl sz opnd (var opnd) shift
end

# Rotate operand register by register or immediate [[A2.2.1]]
# NOTE: This operation updates the carry flag.
val sem-ror sz opnd shift = do
  m <- mktemp;
  mod sz m shift (imm opnd.size); # in case shift > 32

  right <- mktemp;
  left <- mktemp;

  shr sz right (var opnd) (var m);
  shl sz left (var opnd) (lin-sub (imm sz) (var m));

  orb sz opnd (var left) (var right);

  cf <- fCF;
  mov 1 cf (var opnd)
end

# equivalent to lin-sum from 'specifications/rreil/rreil.ml'
val lin-sub x y = SEM_LIN_SUB {opnd1=x, opnd2=y}

# ----------------------------------------------------------------------
# Individual instruction translators
# ----------------------------------------------------------------------

val sem-b x = do
  _if (condition-passed? x.cond) _then do
    offset <- rval x.opnd;
    pc <- get-pc;
    jump (address pc.size (lin-sum (var pc) offset))
  end
end

val sem-bl x = do
  _if (condition-passed? x.cond) _then do
    offset <- rval x.opnd;
    pc <- get-pc;
    lr <- get-lr;

    _if instr-set-arm? _then do
      sub lr.size lr (var pc) (imm 4)
    end _else do
      orb lr.size lr (var pc) (imm 1) # set last bit to 1
    end;

    align pc 4;
    select-instr-set InstrSet_ARM;
    jump (address pc.size (lin-sum (var pc) offset))
  end
end

val sem-bx x = do
  _if (condition-passed? x.cond) _then do
    m <- rval x.opnd;
    jump (address 32 m)
  end
end

val sem-adc x = do
  _if (condition-passed? x.cond) _then do
    rn <- rval x.rn;
    rd <- lval x.rd;
    opnd2 <- rval x.opnd2;

    cf <- fCF;

    if is-pc? rd then do
      add-with-carry 32 rd rn opnd2 (var cf) '0';
      alu-write-pc rd
    end else
      add-with-carry 32 rd rn opnd2 (var cf) x.s
  end
end

val sem-add x = do
  _if (condition-passed? x.cond) _then do
    rn <- rval x.rn;
    rd <- lval x.rd;
    opnd2 <- rval x.opnd2;

    if is-pc? rd then do
      add-with-carry 32 rd rn opnd2 (imm 0) '0';
      alu-write-pc rd
    end else
      add-with-carry 32 rd rn opnd2 (imm 0) x.s
  end
end

val sem-and x = do
  _if (condition-passed? x.cond) _then do
    rn <- rval x.rn;
    rd <- lval x.rd;
    opnd2 <- rval x.opnd2;

    andb 32 rd rn opnd2;

    if is-pc? rd then do
      alu-write-pc rd
    end else
      if x.s then do
        emit-flag-z (var rd);
        emit-flag-n (var rd)
        # the carry flag is updated with 'rval x.opnd2'
      end else
        return void
  end
end

val sem-cmn x = do
  return void
end

val sem-cmp x = do
  return void
end

val sem-sub x = do
  _if (condition-passed? x.cond) _then do
    rd <- lval x.rd;
    rn <- rval x.rn;
    opnd2 <- rval x.opnd2;

    not_opnd2 <- mktemp;
    xorb rd.size not_opnd2 opnd2 (imm 0);

    if is-pc? rd then do
      add-with-carry 32 rd rn (var not_opnd2) (imm 1) '0';
      alu-write-pc rd
    end else
      add-with-carry 32 rd rn (var not_opnd2) (imm 1) x.s
  end
end

val sem-mov x = do
  _if (condition-passed? x.cond) _then do
    rd <- lval x.rd;
    op2 <- rval x.opnd2;

    mov 32 rd op2;

    if x.s then do
      emit-flag-n (var rd);
      emit-flag-z (var rd)
      (* TODO: Update carry flag *)
    end else
      return void
  end
end

val sem-ldr x = do
  _if (condition-passed? x.cond) _then do
    rt <- lval x.rt;
    rn <- lval x.rn;
    offset <- rval x.offset;

    wback <- return (x.w or (not x.p));
    index <- return x.p;

    offset_addr <- return (
      if x.u then
        lin-sum (var rn) (offset)
      else
        lin-sub (var rn) (offset)
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
end

val sem-pop x = let
  val load-operand opnd =
    case opnd of
        OPERAND_LIST l: load-operandlist l
      | _: do
          sp <- get-sp;
          dest <- lval opnd;
          load 32 dest 32 (var sp);
          add sp.size sp (var sp) (imm 4)
        end
    end

  val load-operandlist opndl =
    case opndl of
        OPNDL_NIL: return void
      | OPNDL_CONS c: do
          load-operand c.hd;
          load-operandlist c.tl
        end
    end
in
  _if (condition-passed? x.cond) _then do
    load-operand x.registers
  end
end

val sem-push x = let
  val store-operand opnd =
    case opnd of
        OPERAND_LIST l: store-operandlist l
      | _: do
          sp <- get-sp;
          src <- lval opnd;
          store 32 (address 32 (var sp)) (var src);
          sub sp.size sp (var sp) (imm 4)
        end
    end

  val store-operandlist opndl =
    case opndl of
        OPNDL_NIL: return void
      | OPNDL_CONS c: do
          store-operand c.hd;
          store-operandlist c.tl
        end
    end
in
  _if (condition-passed? x.cond) _then do
    store-operand x.registers
  end
end

val sem-str x = do
  _if (condition-passed? x.cond) _then do
    rt <- rval x.rt;
    rn <- lval x.rn;
    offset <- rval x.offset;

    index <- return x.p;
    wback <- return (x.w or (not x.p));

    offset_addr <- return (
      if x.u then
        SEM_LIN_ADD {opnd1=var rn, opnd2=offset}
      else
        SEM_LIN_SUB {opnd1=var rn, opnd2=offset}
    );

    if index then
      store 32 (address 32 offset_addr) rt
    else
      store 32 (address 32 (var rn)) rt
    ;

    if wback then
      mov 32 rn offset_addr
    else
      return void
  end
end

val sem-default = do
  pc <- get-pc;
  add 32 pc (var pc) (imm 0)
end
