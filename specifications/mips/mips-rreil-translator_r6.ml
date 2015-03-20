val revision/sizeof-imm imm =
   case imm of
      IMM21 i: 21
    | BP i: 2
   end

val revision/rval-imm sn x = let
   val from-vec sn vec =
      case sn of
         Signed: SEM_LIN_IMM {const=sx vec}
       | Unsigned: SEM_LIN_IMM {const=zx vec}
      end
in
   case x of
      IMM21 i: from-vec sn i
    | BP i: from-vec sn i
   end
end

val sem-addiupc x = do
	imm <- rval Signed x.op2;
	size <- return (sizeof-lval x.op1);
	pc <- return (semantic-reg-of Sem_PC);

	res <- mktemp;
	add size res (var pc) imm;

	write x.op1 (var res)	
end

val sem-align x = do
	rs <- rval Unsigned x.op2;
	rt <- rval Unsigned x.op3;
	bp_op <- rval Unsigned x.op4;
	size <- return (sizeof-rval x.op2);
	
	bp <- return (lin-to-int bp_op);

	left <- mktemp;
	right <- mktemp;
	
	shl size left rt (imm (8 * bp));
	shr size right rs (imm (8 * (4 - bp)));
	
	res <- mktemp;
	orb size res (var left) (var right);

	write x.op1 (var res)	
end

val revision/semantics i =
   case i of
      ADDIUPC x: sem-addiupc x
    | ALIGN x: sem-align x
   end
