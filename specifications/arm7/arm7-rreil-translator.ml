export translate: (insndata) -> S sem_stmt_list <{} => {}>

val translate insn = do
  update@{stack=SEM_NIL, tmp=0, lab=0};

  translate-arm7 insn;

  stack <- query $stack;
  return (rreil-stmts-rev stack)
end

val translate-block-single insn = do
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

val get-pc = return (semantic-register-of R15)
val get-sp = return (semantic-register-of R13)

val sem-b x = do
  pc <- get-pc;
  offset <- rval Unsigned x.label;
  jump (address pc.size offset)
end

