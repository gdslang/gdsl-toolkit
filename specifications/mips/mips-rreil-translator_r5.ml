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

val sem-beql x = sem-b /eq x
val sem-bgezal x = sem-bz-link /ges x
val sem-bgezall x = sem-bz-link /ges x
val sem-bgezl x = sem-bz /ges x
val sem-bgtzl x = sem-bz /gts x
val sem-blezl x = sem-bz /les x
val sem-bltzal x = sem-bz-link /lts x
val sem-bltzall x = sem-bz-link /lts x
val sem-bltzl x = sem-bz /lts x
val sem-bnel x = sem-b /neq x

val sem-div-divu div_op mod_op x = do
	num <- rval Signed x.op1;
	denom <- rval Signed x.op2;
	size <- return (sizeof-rval x.op1);

	hi <- return (semantic-reg-of Sem_HI);
	lo <- return (semantic-reg-of Sem_LO);

	div_op size lo num denom;
	mod_op size hi num denom
end

val sem-div x = sem-div-divu divs mods x
val sem-divu x = sem-div-divu div mod x

val sem-lui x = do
	immediate <- rval Unsigned x.op2;
	size <- return (sizeof-lval x.op1);
	size_imm <- return (sizeof-rval x.op2);
	
	res <- mktemp;
	shl size res immediate (imm (32-size_imm));

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

val sem-jr x = do
	rs <- rval Signed x.op;
	size <- return (sizeof-rval x.op);
	pc <- return (semantic-reg-of Sem_SREG);

	pc_true <- mktemp;
	mov size pc_true rs; 

	pc_false <- mktemp;
	mov size pc_false rs;
	mov 1 pc_false (imm 0);

	config1CA <- return (fCA);
	cond <- /eq 1 (var config1CA) (imm 0);

	isamode <- return (semantic-reg-of Sem_ISA_MODE);
	_if (/neq 1 (var config1CA) (imm 0)) _then
		mov isamode.size isamode rs;
	
	cbranch cond (address pc.size (var pc_true)) (address pc.size (var pc_false))	
end

val sem-jr-hb x = sem-jr x

val sem-jalx x = do
	isamode <- return (semantic-reg-of Sem_ISA_MODE);

	xorb 1 isamode (var isamode) (imm 1);

	sem-jal x		
end

val sem-madd x = sem-madd-maddu-msub-msubu movsx add x
val sem-maddu x = sem-madd-maddu-msub-msubu movzx add x

val sem-madd-maddu-msub-msubu ext_op add_sub_op x = do
	rs <- rval Signed x.op1;
	rt <- rval Signed x.op2;
	size <- return (sizeof-rval x.op1);

	rs_ext <- mktemp;
	ext_op (size*2) rs_ext size rs;

	rt_ext <- mktemp;
	ext_op (size*2) rt_ext size rt;

	res <- mktemp;
	mul (size*2) res (var rs_ext) (var rt_ext);

	hi <- return (semantic-reg-of Sem_HI);
	lo <- return (semantic-reg-of Sem_LO);

	hilo <- mktemp;
	movzx (size*2) hilo size (var lo);
	mov size (at-offset hilo size) (var hi);

	add_sub_op (size*2) res (var res) (var hilo);

	mov size lo (var res);
	mov size hi (var (at-offset res size))
end

val sem-msub x = sem-madd-maddu-msub-msubu movzx sub x
val sem-msubu x = sem-madd-maddu-msub-msubu movzx sub x 

val sem-mfhi x = do
	hi <- return (semantic-reg-of Sem_HI);
	
	write x.op (var hi)
end

val sem-mflo x = do
	lo <- return (semantic-reg-of Sem_LO);
	
	write x.op (var lo)
end

val sem-movn-movz cmp_op x = do
	rs <- rval Signed x.op2;
	rt <- rval Signed x.op3;
	size <- return (sizeof-rval x.op2);

	_if (cmp_op size rt (imm 0)) _then
		write x.op1 rs
end

val sem-movn x = sem-movn-movz /neq x
val sem-movz x = sem-movn-movz /eq x

val sem-movf-movt x i = do
	rs <- rval Signed x.op2;
	cc <- (rval Signed x.op3);
	
	_if (/eq 1 cc (imm i)) _then
		write x.op1 rs
end

val sem-movf x = sem-movf-movt x 0
val sem-movt x = sem-movf-movt x 1

val sem-mthi x = do
	rs <- rval Signed x.op;
	hi <- return (semantic-reg-of Sem_HI);

	mov hi.size hi rs
end

val sem-mtlo x = do
	rs <- rval Signed x.op;
	lo <- return (semantic-reg-of Sem_LO);

	mov lo.size lo rs
end

val sem-mult-multu ext_op x = do
	rs <- rval Signed x.op1;
	rt <- rval Signed x.op2;
	size <- return (sizeof-rval x.op1);

	rs_ext <- mktemp;
	ext_op (size*2) rs_ext size rs;

	rt_ext <- mktemp;
	ext_op (size*2) rt_ext size rt;

	res <- mktemp;
	mul (size*2) res (var rs_ext) (var rt_ext);

	hi <- return (semantic-reg-of Sem_HI);
	lo <- return (semantic-reg-of Sem_LO);
	
	mov size lo (var res);
	mov size hi (var (at-offset res size))
end

val sem-mult x = sem-mult-multu movsx x
val sem-multu x = sem-mult-multu movzx x

val sem-mul x = do
	rs <- rval Signed x.op2;
	rt <- rval Signed x.op3;
	size <- return (sizeof-rval x.op2);

	rs_ext <- mktemp;
	movsx (size*2) rs_ext size rs;

	rt_ext <- mktemp;
	movsx (size*2) rt_ext size rt;

	res <- mktemp;
	mul (size*2) res (var rs_ext) (var rt_ext);

	write x.op1 (var res)
end


val revision/semantics i =
   case i of
      ADDI x: sem-addi x
    | ALNV-PS x: sem-default-quadop-lrrr-generic i x
    | BC1F x: sem-default-binop-rr-generic i x
    | BC1FL x: sem-default-binop-rr-generic i x
    | BC1T x: sem-default-binop-rr-generic i x
    | BC1TL x: sem-default-binop-rr-generic i x
    | BC2F x: sem-default-binop-rr-generic i x
    | BC2FL x: sem-default-binop-rr-generic i x
    | BC2T x: sem-default-binop-rr-generic i x
    | BC2TL x: sem-default-binop-rr-generic i x
    | BEQL x: sem-beql x
    | BGEZAL x: sem-bgezal x
    | BGEZALL x: sem-bgezall x
    | BGEZL x: sem-bgezl x
    | BGTZL x: sem-bgtzl x
    | BLEZL x: sem-blezl x
    | BLTZAL x: sem-bltzal x
    | BLTZALL x: sem-bltzall x
    | BLTZL x: sem-bltzl x
    | BNEL x: sem-bnel x
    | C-cond-fmt x: sem-default-ternop-cflrr-generic i x
    | CVT-PS-S x: sem-default-ternop-lrr-generic i x
    | CVT-S-PL x: sem-default-binop-lr-generic i x
    | CVT-S-PU x: sem-default-binop-lr-generic i x
    | DIV x: sem-div x
    | DIVU x: sem-divu x 
    | JR x: sem-jr x
    | JR-HB x: sem-jr-hb x
    | JALX x: sem-jalx x
    | LDC2 x: sem-default-binop-rr-tuple-generic i x
    | LDXC1 x: sem-default-binop-lr-tuple-generic i x
    | LUI x: sem-lui x
    | LUXC1 x: sem-default-binop-lr-tuple-generic i x
    | LWC2 x: sem-default-binop-rr-tuple-generic i x
    | LWL x: sem-lwl x
    | LWLE x: sem-lwl x
    | LWR x: sem-lwr x
    | LWRE x: sem-lwr x
    | LWXC1 x: sem-default-binop-lr-tuple-generic i x
    | MADD x: sem-madd x
    | MADD-fmt x: sem-default-ternop-flrr-generic i x
    | MADDU x: sem-maddu x
    | MFHI x: sem-mfhi x
    | MFLO x: sem-mflo x
    | MOVF x: sem-movf x
    | MOVF-fmt x: sem-default-ternop-flrr-generic i x
    | MOVN x: sem-movn x
    | MOVN-fmt x: sem-default-ternop-flrr-generic i x
    | MOVT x: sem-movt x
    | MOVT-fmt x: sem-default-ternop-flrr-generic i x
    | MOVZ x: sem-movz x
    | MOVZ-fmt x: sem-default-ternop-flrr-generic i x
    | MSUB x: sem-msub x
    | MSUB-fmt x: sem-default-quadop-flrrr-generic i x
    | MSUBU x: sem-msubu x
    | MTHI x: sem-mthi x
    | MTLO x: sem-mtlo x
    | MUL x: sem-mul x
    | MULT x: sem-mult x
    | MULTU x: sem-multu x
    | NMADD-fmt x: sem-default-quadop-flrrr-generic i x
    | NMSUB-fmt x: sem-default-quadop-flrrr-generic i x
    | PLL-PS x: sem-default-ternop-lrr-generic i x
    | PLU-PS x: sem-default-ternop-lrr-generic i x
    | PREFX x: sem-default-binop-rr-tuple-generic i x
    | PUL-PS x: sem-default-ternop-lrr-generic i x
    | PUU-PS x: sem-default-ternop-lrr-generic i x
    | SDXC1 x: sem-default-binop-rr-tuple-generic i x
   end
