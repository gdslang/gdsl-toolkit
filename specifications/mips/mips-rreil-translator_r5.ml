val revision/sizeof-imm imm = 0
val revision/rval-imm sn x = SEM_LIN_IMM {const=0}


val sem-addi x = do
	rs <- rval Signed x.op2;
	imm <- rval Signed x.op3;
	size <- return (sizeof-lval x.op1);

	res <- mktemp;
	add size res rs imm;

	overflow-add-addi size res rs imm;

	write x.op1 (var res)	
end

val sem-lwl x = do
	off/base <- rval Signed x.op2;
	base <- return (extract-tuple off/base).opnd1;
	off <- return (extract-tuple off/base).opnd2;
	rt <- lval Signed x.op1;
	size <- return (sizeof-lval x.op1);

	vaddr <- mktemp;
	add size vaddr base off;

	bcpu <- is-big-endian-cpu;
	bcpu2 <- mktemp;
	movsx 2 bcpu2 1 bcpu;
 
	byte <- mktemp;
	xorb 2 byte (var vaddr) (var bcpu2);
	shl 32 byte (var byte) (imm 3);
	
	memword <- mktemp;
	load 32 memword size (var vaddr);

	lshift <- mktemp;
	sub size lshift (imm 24) (var byte);
	high <- mktemp;
	shl size high (var memword) (var lshift);

	rshift <- mktemp;
	add size rshift (imm 8) (var byte); 
	low <- mktemp;
	shl size low rt (var rshift);
	shr size low (var low) (var rshift);

	res <- mktemp;
	orb size res (var high) (var low);
	write x.op1 (var res)
end

val sem-lwr x = do
	off/base <- rval Signed x.op2;
	base <- return (extract-tuple off/base).opnd1;
	off <- return (extract-tuple off/base).opnd2;
	rt <- lval Signed x.op1;
	size <- return (sizeof-lval x.op1);

	vaddr <- mktemp;
	add size vaddr base off;

	bcpu <- is-big-endian-cpu;
	bcpu2 <- mktemp;
	movsx 2 bcpu2 1 bcpu;
 
	byte <- mktemp;
	xorb 2 byte (var vaddr) (var bcpu2);
	shl 32 byte (var byte) (imm 3);
	
	memword <- mktemp;
	load 32 memword size (var vaddr);

	lshift <- mktemp;
	sub size lshift (imm 32) (var byte);
	high <- mktemp;
	shr size high (var memword) (var lshift);
	shl size high (var high) (var lshift);

	rshift <- mktemp;
	sub size rshift (imm 31) (var byte); 
	low <- mktemp;
	shl size low rt (var rshift);
	shr size low (var low) (var rshift);

	res <- mktemp;
	orb size res (var high) (var low);
	write x.op1 (var res)
end



val revision/semantics i =
   case i of
      ADDI x: sem-addi x
    | ALNV-PS x: sem-default-quadop-lrrr-generic i x
    | LWL x: sem-lwl x
    | LWLE x: sem-lwl x
    | LWR x: sem-lwr x
    | LWRE x: sem-lwr x
    | LWXC1 x: sem-default-binop-lr-tuple-generic i x
   end
