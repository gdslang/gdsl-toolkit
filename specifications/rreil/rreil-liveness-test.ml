export = tinsng turner

#val arch-show-id x = case 0 of 1: "" end

val print o = update@{nothing=(println o)}

val test-instructions-0 = do
  t0 <- mktemp;
	t1 <- mktemp;
	t2 <- mktemp;

	#mov 1 t0 (imm 3);
#	mov 1 t1 (imm 4);
	#mov 8 t2 (imm 5);
	#mov 8 (at-offset t2 20) (imm 5);

	#_while (/d (var (at-offset t0 99))) __ do
	#  mov 1 (at-offset t0 33) (var (at-offset t1 33));

	#	mov 32 t1 (imm 888);
	#	mov 32 t2 (imm 888)
	#end;

	#mov 32 t2 (imm 888);
	#_if (/d (var t0)) _then do
  #  mov 1 (at-offset t0 33) (var (at-offset t1 88));
	#	mov 32 t2 (imm 888)
	#end _else do
  #  mov 1 (at-offset t0 33) (var (at-offset t1 107));
	#	mov 32 t1 (imm 888)
	#end;

  cbranch (var t0) (address 99 (var t1)) (address 88 (var t2));

  xmm10 <- return (semantic-register-of XMM10);
  mov 77 xmm10 (imm 42)

  #add 32 t0 (var t1) (var t2);

	#mov 1 t0 (imm 42)
end

val tinsng = do
  update@{stack=SEM_NIL,tmp=0};
  test-instructions-0;
	stack <- query $stack;
  live-registers <- registers-live-map;
  lv-state <- lv-analyze live-registers stack;
  #print (lv-pretty lv-state.greedy);
  #return (("Hallo :-)" +++ "fasel"))
	#return (rreil-stmts-rev stack)
  return lv-state.conservative
  #return live-registers
end

val turner x = x
