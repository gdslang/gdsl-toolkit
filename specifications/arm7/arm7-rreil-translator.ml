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
      Sem_IP: '1'
    | _: '0'
  end
in
  relative-next-generic is_sem_ip stmts
end


val semantics insn =
  case insn of
      ADC x: sem-adc x
    | AND x: sem-and x
  end

val sem-adc x = do
  return 0
end

val sem-and x = do
  return 0
end
