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
      | IMM5 i: from-vec sign i
      | IMM12 i: from-vec sign i
      | MODIMM i: imm (armexpandimm i)
    end
in
  case x of
      IMMEDIATE i: return (from-imm sign i)
    | REGISTER r: return (var (semantic-register-of r))
    | SHIFTED_REGISTER r: do
        shift-register r.shift r.register (imm 0);
        rvals sign (REGISTER r.register)
      end
  end
end

val rval x = rvals Unsigned x

(* TODO: Add RRX rotation. *)
val shift-register shift reg carry_in = let
  val do-shift stype amount = do
    rm <- lval reg;
    amount <- amount;
    case stype of
        LSL: shl 32 rm (var rm) amount
      | LSR: shr 32 rm (var rm) amount
      | ASR: shrs 32 rm (var rm) amount
      | ROR: sem-ror-c 32 rm amount
      | RRX: do
          add 32 rm (var rm) carry_in;
          sem-ror-c 32 rm (imm 1)
        end
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
val get-pc = lval R15

# Stack Pointer register (SP)
val get-sp = lval R13

# Link register (LR)
val get-lr = lval R14

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

val emit-flag-n result = do
  nf <- fNF;
  cmplts 32 nf result (imm 0)
end

val emit-flag-z result = do
  zf <- fZF;
  cmpeq 32 zf result (imm 0)
end

val emit-add-flags sum x y = do
  emit-flag-n sum;
  emit-flag-z sum;

  cf <- fCF;
  vf <- fVF;
  tmp <- mktemp;

  # Check for unsigned overflow (carry):
  cmplts 1 cf sum x;
  cmplts 1 tmp sum y;
  orb 1 cf (var cf) (var tmp)
end

# Rotate operand register by register or immediate [[A2.2.1]]
# NOTE: This operation updates the carry flag.
val sem-ror-c size opnd shift = do
  m <- mktemp;
  mod size m shift (imm opnd.size); # in case shift > 32

  right <- mktemp;
  left <- mktemp;
  shl_amount <- return (SEM_LIN_SUB {opnd1=imm size, opnd2=var m});

  shr size right (var opnd) (var m);
  shl size left (var opnd) shl_amount;

  orb size opnd (var left) (var right);

  cf <- fCF;
  mov size cf (var opnd)
end

# ----------------------------------------------------------------------
# Individual instruction translators
# ----------------------------------------------------------------------

val sem-b x = do
  _if (condition-passed? x.cond) _then do
    offset <- rval x.label;
    pc <- get-pc;
    jump (address pc.size (lin-sum (var pc) offset))
  end
end

val sem-bl x = do
  _if (condition-passed? x.cond) _then do
    offset <- rval x.label;
    pc <- get-pc;
    lr <- get-lr;

    _if instr-set-arm? _then do
      sub lr.size lr (var pc) (imm 4)
    end _else do
      orb lr.size lr (var pc) (imm 1) # set last bit to 1
    end;

    andb pc.size pc (var pc) (imm 0xfffffffa); # Align(PC, 4)
    select-instr-set InstrSet_ARM;
    jump (address pc.size (lin-sum (var pc) offset))
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
    rn <- rval x.rn;
    rd <- lval x.rd;
    op2 <- rval x.op2;

    add 32 rd rn op2;

    if x.s then do
      emit-add-flags (var rd) rn op2
    end else
      return void
  end
end

val sem-sub x = do
  _if (condition-passed? x.cond) _then do
    rd <- lval x.rd;
    rn <- rval x.rn;
    op2 <- rval x.op2;

    sub 32 rd rn op2;

    if x.s then do
      emit-flag-n (var rd);
      emit-flag-z (var rd)
      (* TODO: Update remaining flags *)
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
end

val sem-pop x = let
  val load-registers reglist =
    case reglist of
        REGL_NIL: return void
      | REGL_CONS c: do
          sp <- get-sp;
          dest <- lval c.head;
          load 32 dest 32 (var sp);
          add sp.size sp (var sp) (imm 4);
          load-registers c.tail
        end
    end
in
  _if (condition-passed? x.cond) _then do
    load-registers x.register_list
  end
end

val sem-push x = let
  val store-registers reglist =
    case reglist of
        REGL_NIL: return void
      | REGL_CONS c: do
          sp <- get-sp;
          src <- lval c.head;
          store 32 (address 32 (var sp)) (var src);
          sub sp.size sp (var sp) (imm 4);
          store-registers c.tail
        end
    end
in
  _if (condition-passed? x.cond) _then do
    store-registers x.register_list
  end
end

val sem-str x = do
  _if (condition-passed? x.cond) _then do
    rt <- return (var (semantic-register-of x.rt));
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
