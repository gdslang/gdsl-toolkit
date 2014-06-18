export = translate


val sem-idle = return void

val semantics insn =
 case insn of
    ADD x: sem-idle
end

val translate-mips insn = semantics insn

val translate insn = do
  update@{stack=SEM_NIL,tmp=0,lab=0};
  
  translate-mips insn;
  
  stack <- query $stack;
  return (rreil-stmts-rev stack)
end

val translate-block-single insn = do
   ic <- query $ins_count;
   update@{tmp=0,ins_count=ic+1};
   
   translate-mips insn
end

val relative-next stmts = let
  val is_sem_ip x = case x of
     Sem_PC: '1'
   | _: '0'
  end
in
  relative-next-generic is_sem_ip stmts
end
