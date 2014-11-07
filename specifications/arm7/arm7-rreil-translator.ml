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

val lval x =
  case x of
      REGISTER r: return (semantic-register-of r)
  end

val rvals-c sign x setcarry = let
  val from-vec sn vector =
    case sn of
        Signed: imm (sx vector)
      | Unsigned: imm (zx vector)
    end
  val from-imm sn immediate setcarry =
    case immediate of
        IMMi i: return (imm i)
      | IMM5 i: return (from-vec sn i)
      | IMM12 i: return (from-vec sn i)
      | MODIMM i: do
          expanded <- return (armexpandimm-c i 0);
          if setcarry then
            mov 1 fCF (imm expanded.carry_out)
          else
            return void
          ;
          return (imm expanded.result)
        end
    end
in
  case x of
      IMMEDIATE i: from-imm sign i setcarry
    | REGISTER r: return (var (semantic-register-of r))
    | SHIFTED_OPERAND r: do
        shift-operand 32 r.opnd r.shift setcarry;
        rvals sign r.opnd
      end
  end
end

val rvals sign x = rvals-c sign x '0'

val rval-c x setcarry = rvals-c Unsigned x setcarry
val rval x = rvals Unsigned x

val shift-operand sz opnd shift setcarry = let
  val sem-shift samount stype = do
    amount <- case samount of
        REGISTER r: return (var (varl 8 (semantic-register-of r)))
      | _: rval-c samount setcarry
    end;
    sem_opnd <- lval opnd;
    case stype of
        LSL: sem-lsl sz sem_opnd amount setcarry
      | LSR: sem-lsr-asr sz sem_opnd amount shr setcarry
      | ASR: sem-lsr-asr sz sem_opnd amount shrs setcarry
      | ROR: sem-ror sz sem_opnd amount setcarry
      | RRX: sem-rrx sz sem_opnd (var fCF) setcarry
    end
  end
in
  case shift.amount of
      IMMEDIATE i:
        if is-zero? i then
          case shift.shifttype of
              ROR: sem-shift shift.amount RRX
            | LSR: sem-shift (opnd-from-int 32) LSR
            | ASR: sem-shift (opnd-from-int 32) ASR
            | _: return void
          end  # See [[A8.4.3]] DecodeImmShift()
        else
          sem-shift shift.amount shift.shifttype
    | _: sem-shift shift.amount shift.shifttype
  end
end

val semantics insn =
  case insn.insn of
      B x: sem-b x
    | BL x: sem-bl x
    | BX x: sem-bx x
    | ADC x: sem-adc x
    | ADD x: sem-add x
    | AND x: sem-and x
    | BIC x: sem-bic x
    | CMN x: sem-cmn x
    | CMP x: sem-cmp x
    | EOR x: sem-eor x
    | MOV x: sem-mov x
    | MVN x: sem-mvn x
    | ORR x: sem-orr x
    | RSB x: sem-rsb x
    | RSC x: sem-rsc x
    | SBC x: sem-sbc x
    | SUB x: sem-sub x
    | TEQ x: sem-teq x
    | TST x: sem-tst x
    | MLA x: sem-mla x
    | MLS x: sem-mls x
    | MUL x: sem-mul x
    | SMLAL x: sem-smlal x
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
val get-sem-pc = lval (register R15)

# Stack Pointer register (SP)
val get-sem-sp = lval (register R13)

# Link register (LR)
val get-sem-lr = lval (register R14)

val is-sem-pc? sem_reg =
  case sem_reg.id of
      Sem_PC: '1'
    | _: '0'
  end

val is-sem-sp? sem_reg =
  case sem_reg.id of
      Sem_SP: '1'
    | _: '0'
  end

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
      EQ: /eq 1 (var fZF) (imm 1)
    | NE: /eq 1 (var fZF) (imm 0)
    | CS: /eq 1 (var fCF) (imm 1)
    | CC: /eq 1 (var fCF) (imm 0)
    | MI: /eq 1 (var fNF) (imm 1)
    | PL: /eq 1 (var fNF) (imm 0)
    | VS: /eq 1 (var fVF) (imm 1)
    | VC: /eq 1 (var fVF) (imm 0)
    | HI: /and (/eq 1 (var fCF) (imm 1)) (/eq 1 (var fZF) (imm 0))
    | LS: /and (/eq 1 (var fCF) (imm 0)) (/eq 1 (var fZF) (imm 1))
    | GE: /eq 1 (var fNF) (var fVF)
    | LT: /neq 1 (var fNF) (var fVF)
    | GT: /and (/eq 1 (var fZF) (imm 0)) (/eq 1 (var fNF) (var fVF))
    | LE: /and (/eq 1 (var fZF) (imm 1)) (/neq 1 (var fNF) (var fVF))
    | AL: const 1
  end

# --- Simplyfied jumps (without Thumb/ThumbEE/Jazelle handling) --------

# align lvalue to multiple of num_bytes
val align lhs num_bytes =
  andb lhs.size lhs (var lhs) (imm ((power 2 lhs.size) - num_bytes))

# jump/branch to target address [[B1.3.2]]
val branch-to target = jump (address 32 (var target))

# simple branch [[A2.3.2]]
val branch-write-pc addr = do
  align addr 4;
  branch-to addr
end

# interworking branch (instruction set switch) [[A2.3.2]]
val bx-write-pc addr = do
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

# architecture version specific branch [[A2.3.2]]
val load-write-pc addr = bx-write-pc addr

# instrset/arch version specific branch [[A2.3.2]]
val alu-write-pc addr = bx-write-pc addr

# --- Flag handling ----------------------------------------------------

# set the N flag, if the result is negative.
val emit-flag-n result = cmplts 32 fNF result (imm 0)

# set the Z flag, if the result is zero.
val emit-flag-z result = cmpeq 32 fZF result (imm 0)

val emit-flags-nz result setflags = do
  if setflags then do
    emit-flag-n result;
    emit-flag-z result
  end else
    return void
end

val emit-add-adc-flags sz sum x y setflags = do
  emit-flags-nz (var sum) setflags;

  if setflags then do
    t1 <- mktemp;
    t2 <- mktemp;
    t3 <- mktemp;

    # Set the C flag in case of unsigned overflow (carry).
    cmpltu sz fCF (var sum) x;

    # Set the V flag in case of signed overflow.
    xorb sz t1 (var sum) x;
    xorb sz t2 (var sum) y;
    andb sz t3 (var t1) (var t2);
    cmplts sz fVF (var t3) (imm 0)
  end else
    return void
end

val emit-sub-sbc-flags sz difference x y setflags = do
  minus_y <- mktemp;
  xorb 32 minus_y y (imm 0); # 2 complement
  add 32 minus_y (var minus_y) (imm 1);

  emit-add-adc-flags sz difference x y setflags
end

val emit-rsb-rsc-flags sz difference x y setflags =
  emit-sub-sbc-flags sz difference y x setflags

# --- Shift/rotate functions -------------------------------------------

# logic shift left
val sem-lsl sz opnd shiftamount setcarry = do
  shift_minus_one <- return (lin-diff shiftamount (imm 1));

  shl sz opnd (var opnd) shift_minus_one;

  if setcarry then
    mov 1 fCF (var (at-offset opnd (sz - 1)))
  else
    return void
  ;

  shl sz opnd (var opnd) (imm 1)
end

# logic or arithmetic shift right
val sem-lsr-asr sz opnd shiftamount shiftop setcarry = do
  shift_minus_one <- return (lin-diff shiftamount (imm 1));

  shiftop sz opnd (var opnd) shift_minus_one;

  if setcarry then
    mov 1 fCF (var opnd)
  else
    return void
  ;

  shiftop sz opnd (var opnd) (imm 1)
end

# rotate operand register by register or immediate [[A2.2.1]]
val sem-ror sz opnd shiftamount setcarry = do
  m <- mktemp;
  mod sz m shiftamount (imm opnd.size); # in case shift > 32

  right <- mktemp;
  left <- mktemp;

  shr sz right (var opnd) (var m);
  shl sz left (var opnd) (lin-diff (imm sz) (var m));

  orb sz opnd (var left) (var right);

  if setcarry then do
    mov 1 fCF (var (at-offset opnd (sz - 1))) # msb = carry_out
  end else
    return void
end

(* TODO: Merge sem-ror with sem-rrx *)

# rotate the opnd right by one and append carry_in as msb [[A2.2.1]]
val sem-rrx sz opnd carry_in setcarry = do
  if setcarry then
    mov 1 fCF (var opnd)
  else
    return void
  ;

  t0 <- mktemp;

  shr sz opnd (var opnd) (imm 1);
  shl sz t0 (carry_in) (imm (sz - 1));
  orb sz opnd (var opnd) (var t0)
end

val lin-diff x y = SEM_LIN_SUB {opnd1=x, opnd2=y}

# ----------------------------------------------------------------------
# Individual instruction translators
# ----------------------------------------------------------------------

val sem-b x = do
  _if (condition-passed? x.cond) _then do
    offset <- rval x.opnd;
    pc <- get-sem-pc;
    jump (address pc.size (lin-sum (var pc) offset))
  end
end

val sem-bl x = do
  _if (condition-passed? x.cond) _then do
    offset <- rval x.opnd;
    pc <- get-sem-pc;
    lr <- get-sem-lr;

    sub 32 lr (var pc) (imm 4);

    align pc 4;
    add 32 pc (var pc) offset;
    branch-write-pc pc
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

    add 32 rd rn opnd2;
    add 32 rd (var rd) (var fCF);

    if is-sem-pc? rd then do
      alu-write-pc rd
    end else
      emit-add-adc-flags 32 rd rn opnd2 x.setflags
  end
end

val sem-add x = do
  _if (condition-passed? x.cond) _then do
    rn <- rval x.rn;
    rd <- lval x.rd;
    opnd2 <- rval x.opnd2;

    add 32 rd rn opnd2;

    if is-sem-pc? rd then do
      alu-write-pc rd
    end else
      emit-add-adc-flags 32 rd rn opnd2 x.setflags
  end
end

val sem-and x = do
  _if (condition-passed? x.cond) _then do
    rn <- rval x.rn;
    rd <- lval x.rd;
    opnd2 <- rval-c x.opnd2 x.setflags; # update carry!

    andb 32 rd rn opnd2;

    if is-sem-pc? rd then do
      alu-write-pc rd
    end else
      emit-flags-nz (var rd) x.setflags
  end
end

val sem-bic x = do
  _if (condition-passed? x.cond) _then do
    rd <- lval x.rd;
    rn <- rval x.rn;
    opnd2 <- rval-c x.opnd2 x.setflags; # update carry!
    not_opnd2 <- mktemp;

    xorb 32 not_opnd2 opnd2 (imm 0);
    andb 32 rd rn (var not_opnd2);

    if is-sem-pc? rd then
      alu-write-pc rd
    else
      emit-flags-nz (var rd) x.setflags
  end
end

val sem-cmn x = do
  _if (condition-passed? x.cond) _then do
    rn <- rval x.rn;
    opnd2 <- rval x.opnd2;
    cmn_result <- mktemp;

    add 32 cmn_result rn opnd2;

    emit-add-adc-flags 32 cmn_result rn opnd2 '1'
  end
end

val sem-cmp x = do
  _if (condition-passed? x.cond) _then do
    rn <- rval x.rn;
    opnd2 <- rval x.opnd2;
    cmp_result <- mktemp;

    sub 32 cmp_result rn opnd2;

    emit-sub-sbc-flags 32 cmp_result rn opnd2 '1'
  end
end

val sem-eor x = do
  _if (condition-passed? x.cond) _then do
    rd <- lval x.rd;
    rn <- rval x.rn;
    opnd2 <- rval-c x.opnd2 x.setflags; # update carry!

    xorb 32 rd rn opnd2;

    if is-sem-pc? rd then
      alu-write-pc rd
    else
      emit-flags-nz (var rd) x.setflags
  end
end

val sem-mov x = do
  _if (condition-passed? x.cond) _then do
    rd <- lval x.rd;
    opnd2 <- rval-c x.opnd2 x.setflags;

    mov 32 rd opnd2;

    if is-sem-pc? rd then
      alu-write-pc rd
    else
      emit-flags-nz (var rd) x.setflags
  end
end

val sem-mvn x = do
  _if (condition-passed? x.cond) _then do
    rd <- lval x.rd;
    opnd2 <- rval-c x.opnd2 x.setflags; # update carry!

    xorb 32 rd opnd2 (imm 0); # NOT (opnd2)

    if is-sem-pc? rd then
      alu-write-pc rd
    else
      emit-flags-nz (var rd) x.setflags
  end
end

val sem-orr x = do
  _if (condition-passed? x.cond) _then do
    rd <- lval x.rd;
    rn <- rval x.rn;
    opnd2 <- rval-c x.opnd2 x.setflags; # update carry!

    orb 32 rd rn opnd2;

    if is-sem-pc? rd then
      alu-write-pc rd
    else
      emit-flags-nz (var rd) x.setflags
  end
end

val sem-rsb x = do
  _if (condition-passed? x.cond) _then do
    rd <- lval x.rd;
    rn <- rval x.rn;
    opnd2 <- rval x.opnd2;

    sub 32 rd opnd2 rn;

    if is-sem-pc? rd then
      alu-write-pc rd
    else
      emit-rsb-rsc-flags 32 rd opnd2 rn x.setflags
  end
end

val sem-rsc x = do
  _if (condition-passed? x.cond) _then do
    rd <- lval x.rd;
    rn <- rval x.rn;
    opnd2 <- rval x.opnd2;

    sub 32 rd opnd2 rn;
    sub 32 rd (var rd) (var fCF);

    if is-sem-pc? rd then
      alu-write-pc rd
    else
      emit-rsb-rsc-flags 32 rd opnd2 rn x.setflags
  end
end

val sem-sbc x = do
  _if (condition-passed? x.cond) _then do
    rd <- lval x.rn;
    rn <- rval x.rn;
    opnd2 <- rval x.opnd2;

    sub 32 rd rn opnd2;
    sub 32 rd (var rd) (var fCF);

    if is-sem-pc? rd then
      alu-write-pc rd
    else
      emit-sub-sbc-flags 32 rd rn opnd2 x.setflags
  end
end

val sem-sub x = do
  _if (condition-passed? x.cond) _then do
    rd <- lval x.rd;
    rn <- rval x.rn;
    opnd2 <- rval x.opnd2;

    sub 32 rd rn opnd2;

    if is-sem-pc? rd then
      alu-write-pc rd
    else
      emit-sub-sbc-flags 32 rd rn opnd2 x.setflags
  end
end

val sem-tst x = do
  _if (condition-passed? x.cond) _then do
    rn <- rval x.rn;
    opnd2 <- rval-c x.opnd2 '1'; # update carry!
    tst_result <- mktemp;

    andb 32 tst_result rn opnd2;

    emit-flags-nz (var tst_result) '1'
  end
end

val sem-teq x = do
  _if (condition-passed? x.cond) _then do
    rn <- rval x.rn;
    opnd2 <- rval-c x.opnd2 '1'; # update carry!
    teq_result <- mktemp;

    xorb 32 teq_result rn opnd2;

    emit-flags-nz (var teq_result) '1'
  end
end

val sem-mla x = do
  _if (condition-passed? x.cond) _then do
    result <- lval x.rd;
    opnd1 <- rval x.rn;
    opnd2 <- rval x.rm;
    addend <- rval x.ra;

    mul 32 result opnd1 opnd2;
    add 32 result (var result) addend;

    emit-flags-nz (var result) x.setflags
  end
end

val sem-mls x = do
  _if (condition-passed? x.cond) _then do
    result <- lval x.rd;
    opnd1 <- rval x.rn;
    opnd2 <- rval x.rm;
    addend <- rval x.ra;

    mul 32 result opnd1 opnd2;
    sub 32 result addend (var result)
  end
end

val sem-mul x = do
  _if (condition-passed? x.cond) _then do
    result <- lval x.rd;
    opnd1 <- rval x.rn;
    opnd2 <- rval x.rm;

    mul 32 result opnd1 opnd2;

    emit-flags-nz (var result) x.setflags
  end
end

val sem-smlal x = do
  _if (condition-passed? x.cond) _then do
    opnd1 <- rval x.rn;
    opnd2 <- rval x.rm;
    high <- lval x.rdhi;
    low <- lval x.rdlo;

    result <- mktemp;
    addend <- mktemp;

    mov 64 addend (var high);
    shl 64 addend (var addend) (imm 32);
    orb 64 addend (var addend) (var low);

    mul 64 result opnd1 opnd2;
    add 64 result (var result) (var addend);

    mov 32 high (var (at-offset result 32));
    mov 32 low (var result);

    emit-flags-nz (var result) x.setflags
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
        lin-diff (var rn) (offset)
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
          sp <- get-sem-sp;
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
          sp <- get-sem-sp;
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
        lin-sum (var rn) (offset)
      else
        lin-diff (var rn) (offset)
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
  pc <- get-sem-pc;
  add 32 pc (var pc) (imm 0)
end
