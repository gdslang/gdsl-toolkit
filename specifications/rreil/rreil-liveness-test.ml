export = tinsng

val arch-show-id x = case 0 of 1: "" end

val print o = update@{nothing=(println o)}

val test-instructions-0 = do
  t0 <- mktemp;
	t1 <- mktemp;
	t2 <- mktemp;

	mov 1 t0 (imm 3);
	mov 1 t1 (imm 4);
	mov 1 t2 (imm 5);

	print t0;

  add 1 t0 (var t1) (var t2);

	mov 1 t0 (imm 42)
end

val tinsng = do
  update@{stack=SEM_NIL,tmp=TLIST_NIL};
  test-instructions-0;
	stack <- query $stack;
	return (rreil-stmts-rev stack)
end
