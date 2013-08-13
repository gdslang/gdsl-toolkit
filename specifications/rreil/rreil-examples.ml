export = example_a example_b

val example_a = do
  update@{stack=SEM_NIL,tmp=0,lab=0,mode64='1'};

  t0 <- mktemp;
	t1 <- mktemp;
	t2 <- mktemp;
	mov 1 t0 (imm 0);
	mov 1 t2 (imm 1);
	_if (/not (var t0)) _then
    (_if (/d (var t2)) _then
	    mov 64 t1 (imm 200)
    _else
	    mov 64 t1 (imm 500))
	_else
	  mov 64 t1 (imm 300)
	;
	jump (address 64 (var t1));

	stack <- query $stack;
  return (rreil-stmts-rev stack)
end

val example_b = do
  update@{stack=SEM_NIL,tmp=0,lab=0,mode64='1'};

  ax <- mktemp;
  t0 <- mktemp;
	t1 <- mktemp;

	mov 64 ax (imm 131281400902434);
	mov 6 t0 (imm 2);
	mov 58 (at-offset t0 6) (imm 0);

	jump (address 64 (var t0));

	stack <- query $stack;
  return (rreil-stmts-rev stack)
end
