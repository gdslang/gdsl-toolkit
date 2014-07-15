export example_a : S sem_stmt_list <{} => {}>
export example_b : S sem_stmt_list <{} => {}>

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

val example_lin = do
  update@{stack=SEM_NIL,tmp=0,lab=0,mode64='1'};

  t0 <- mktemp;
	t1 <- mktemp;

  b <- return (SEM_LIN_ADD {opnd1=var t0,opnd2=SEM_LIN_SCALE{const=99,opnd=SEM_LIN_ADD {opnd1=var t1,opnd2=imm 42}}});
  push (/ASSIGN 64 t0 (SEM_SEXPR (SEM_SEXPR_LIN b)));

	stack <- query $stack;
  return (rreil-stmts-rev stack)
end
