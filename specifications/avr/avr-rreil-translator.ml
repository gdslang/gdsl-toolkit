export = translate

val translate insn = do
  update@{stack=SEM_NIL,tmp=0,lab=0,mode64='1'};
#case 0 of 1: return 0 end;
  #semantics insn;
  stack <- query $stack;
  return (rreil-stmts-rev stack)
end
