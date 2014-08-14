export translate: (insndata) -> S sem_stmt_list <{} => {}>

type signedness =
   Signed
 | Unsigned

val write to from =
   case to of
      GPR r: mov (sizeof-lval to) (semantic-gpr-of r) from
   end

val lval sn x =
   case x of
      GPR r: return (var (semantic-gpr-of r))
    | FPR f: return (var (semantic-fpr-of f))
   end

val rval sn x = let
   val from-vec sn vec =
      case sn of
         Signed: SEM_LIN_IMM {const=sx vec}
       | Unsigned: SEM_LIN_IMM {const=zx vec}
      end

   val from-imm sn imm =
      case imm of
         IMM5 i: from-vec sn i
       | IMM16 i: from-vec sn i
       | OFFSET9 i: from-vec sn i
       | OFFSET16 i: from-vec sn i
       | SEL i: from-vec sn i
       | IMPL i: from-vec sn i
       | CODE10 i: from-vec sn i
       | CODE19 i: from-vec sn i
       | CODE20 i: from-vec sn i
       | STYPE i: from-vec sn i
       | POSSIZE i: from-vec sn i
       | SIZE i: from-vec sn i
       | POS i: from-vec sn i
       | HINT i: from-vec sn i
       | INSTRINDEX i: from-vec sn i
       | COFUN i: from-vec sn i
       | CC i: from-vec sn i
       | COND i: from-vec sn i
       | OP i: from-vec sn i
      end
in
   case x of
      LVALUE lv: lval sn lv
    | IMM i: return (from-imm sn i)
   end
end

val scale i x = SEM_LIN_SCALE{const=i, opnd=x}

val lin-to-int x =
   case x of
      SEM_LIN_IMM li: li.const	
   end

val sizeof-lval x =
   case x of
      GPR r: 32
    | FPR f: 32
   end

val sizeof-rval x = 
   case x of
      LVALUE lv: sizeof-lval lv
    | IMM imm:
         case imm of
            IMM5 i: 5
	  | IMM16 i: 16
          | OFFSET9 i: 9
          | OFFSET16 i: 16
          | SEL i: 3
          | IMPL i: 16
          | CODE10 i: 10
          | CODE19 i: 19
          | CODE20 i: 20
          | STYPE i: 5
          | POSSIZE i: 5
          | SIZE i: 5
          | POS i: 5
          | HINT i: 5
          | INSTRINDEX i: 26
          | COFUN i: 25
          | CC i: 3
          | COND i: 4
          | OP i: 5
         end
   end

val mnemonic-with-format insn x = (mnemonic-of insn) +++ "." +++ show/format x.fmt

val sem-default-unop-src-ro-generic insn x = do
	src-sz <- return (sizeof-rval x.source);

	src <- rval Signed x.source;

	src-up <- unpack-lin src-sz src;

	prim-generic (mnemonic-of insn) varls-none (varls-one (varl src-sz src-up))
end

val sem-default-binop-ro-generic insn x = do
	src-sz <- return (sizeof-rval x.source);
	dst-sz <- return (sizeof-lval x.destination);

	src <- rval Signed x.source;
	dst <- lval Signed x.destination;

	src-up <- unpack-lin src-sz src;
	dst-up <- unpack-lin dst-sz dst;

	prim-generic (mnemonic-of insn) (varls-one (varl dst-sz dst-up)) (varls-one (varl src-sz src-up))
end

val sem-default-binop-fmt-ro-generic insn x = do
	src-sz <- return (sizeof-rval x.source);
	dst-sz <- return (sizeof-lval x.destination);

	src <- rval Signed x.source;
	dst <- lval Signed x.destination;

	src-up <- unpack-lin src-sz src;
	dst-up <- unpack-lin dst-sz dst;

	prim-generic (mnemonic-with-format insn x) (varls-one (varl dst-sz dst-up)) (varls-one (varl src-sz src-up))
end

val sem-default-binop-src-ro-generic insn x = do
	src1-sz <- return (sizeof-rval x.source1);
	src2-sz <- return (sizeof-rval x.source2);

	src1 <- rval Signed x.source1;
	src2 <- rval Signed x.source2;

	src1-up <- unpack-lin src1-sz src1;
	src2-up <- unpack-lin src2-sz src2;

	prim-generic (mnemonic-of insn) varls-none (varls-more (varl src2-sz src2-up) (varls-one (varl src1-sz src1-up)))
end

val sem-default-ternop-fmt-ro-generic insn x = do
	src1-sz <- return (sizeof-rval x.source1);
	src2-sz <- return (sizeof-rval x.source2);
	dst-sz <- return (sizeof-lval x.destination);

	src1 <- rval Signed x.source1;
	src2 <- rval Signed x.source2;
	dst <- lval Signed x.destination;

	src1-up <- unpack-lin src1-sz src1;
	src2-up <- unpack-lin src2-sz src2;
	dst-up <- unpack-lin dst-sz dst;

	prim-generic (mnemonic-with-format insn x) (varls-one (varl dst-sz dst-up)) (varls-more (varl src2-sz src2-up) (varls-one (varl src1-sz src1-up)))
end

val sem-default-quadop-ro-generic insn x = do
	src1-sz <- return (sizeof-rval x.source1);
	src2-sz <- return (sizeof-rval x.source2);
	src3-sz <- return (sizeof-rval x.source3);
	dst-sz <- return (sizeof-lval x.destination);

	src1 <- rval Signed x.source1;
	src2 <- rval Signed x.source2;
	src3 <- rval Signed x.source3;
	dst <- lval Signed x.destination;

	src1-up <- unpack-lin src1-sz src1;
	src2-up <- unpack-lin src2-sz src2;
	src3-up <- unpack-lin src3-sz src3;
	dst-up <- unpack-lin dst-sz dst;

	prim-generic (mnemonic-of insn) (varls-one (varl dst-sz dst-up)) (varls-more (varl src3-sz src3-up) (varls-more (varl src2-sz src2-up) (varls-one (varl src1-sz src1-up))))
end

val sem-default-quadop-fmt-ro-generic insn x = do
	src1-sz <- return (sizeof-rval x.source1);
	src2-sz <- return (sizeof-rval x.source2);
	src3-sz <- return (sizeof-rval x.source3);
	dst-sz <- return (sizeof-lval x.destination);

	src1 <- rval Signed x.source1;
	src2 <- rval Signed x.source2;
	src3 <- rval Signed x.source3;
	dst <- lval Signed x.destination;

	src1-up <- unpack-lin src1-sz src1;
	src2-up <- unpack-lin src2-sz src2;
	src3-up <- unpack-lin src3-sz src3;
	dst-up <- unpack-lin dst-sz dst;

	prim-generic (mnemonic-with-format insn x) (varls-one (varl dst-sz dst-up)) (varls-more (varl src3-sz src3-up) (varls-more (varl src2-sz src2-up) (varls-one (varl src1-sz src1-up))))
end

val sem-default-quadop-fmt-src-ro-generic insn x = do
	src1-sz <- return (sizeof-rval x.source1);
	src2-sz <- return (sizeof-rval x.source2);
	src3-sz <- return (sizeof-rval x.source3);
	src4-sz <- return (sizeof-rval x.source4);

	src1 <- rval Signed x.source1;
	src2 <- rval Signed x.source2;
	src3 <- rval Signed x.source3;
	src4 <- rval Signed x.source4;

	src1-up <- unpack-lin src1-sz src1;
	src2-up <- unpack-lin src2-sz src2;
	src3-up <- unpack-lin src3-sz src3;
	src4-up <- unpack-lin src4-sz src4;

	prim-generic (mnemonic-with-format insn x) varls-none (varls-more (varl src4-sz src4-up) (varls-more (varl src3-sz src3-up) (varls-more (varl src2-sz src2-up) (varls-one (varl src1-sz src1-up)))))
end

###########
### semantics of instructions
###########

val sem-foo = return void
val sem-fp = return void
val sem-fp2 = return void

val sem-add x = do
	rs <- rval Signed x.source1;
	rt <- rval Signed x.source2;
	size <- return (sizeof-lval x.destination);

	res <- mktemp;
	add size res rs rt;

	# THROW EXCEPTION	

	write x.destination (var res)	
end

val sem-addu x = do
	rs <- rval Signed x.source1;
	rt <- rval Signed x.source2;
	size <- return (sizeof-lval x.destination);

	res <- mktemp;
	add size res rs rt;

	write x.destination (var res)	
end

val sem-addi x = do
	rs <- rval Signed x.source1;
	imm <- rval Signed x.source2;
	size <- return (sizeof-lval x.destination);

	res <- mktemp;
	add size res rs imm;

	# THROW EXCEPTION

	write x.destination (var res)	
end

val sem-addiu x = do
	rs <- rval Signed x.source1;
	imm <- rval Signed x.source2;
	size <- return (sizeof-lval x.destination);

	res <- mktemp;
	add size res rs imm;

	write x.destination (var res)	
end

val sem-bitwise bit_op x = do
	rs <- rval Unsigned x.source1;
	rt <- rval Unsigned x.source2;
	size <- return (sizeof-lval x.destination);

	res <- mktemp;
	bit_op size res rs rt;
	
	write x.destination (var res)
end

val sem-bitwise-imm bit_op x = do
	rs <- rval Unsigned x.source1;
	imm <- rval Unsigned x.source2;
	size <- return (sizeof-lval x.destination);

	res <- mktemp;
	bit_op size res rs imm;
	
	write x.destination (var res)
end

val sem-and x = sem-bitwise andb x
val sem-andi x = sem-bitwise-imm andb x

val sem-or x = sem-bitwise orb x
val sem-ori x = sem-bitwise-imm orb x

val sem-xor x = sem-bitwise xorb x
val sem-xori x = sem-bitwise-imm xorb x

val cbranch-rel cond offset = do
	pc <- return (ip-get);
	
	new_pc <- mktemp;
	add pc.size new_pc (var pc) offset;

	cbranch cond (address pc.size (var new_pc)) (address pc.size (var pc))
end

val sem-b cmp_op x = do
	rs <- rval Signed x.source1;
	rt <- rval Signed x.source2;
	size <- return (sizeof-rval x.source1);
	
	off <- rval Signed x.source3;
	off_ext <- return (scale 4 off);

	cond <- cmp_op size rs rt;
	cbranch-rel cond off_ext
end

val sem-bz cmp_op x = do
	rs <- rval Signed x.source1;
	size <- return (sizeof-rval x.source1);

	off <- rval Signed x.source2;
	off_ext <- return (scale 4 off);

	cond <- cmp_op size rs (imm 0);
	cbranch-rel cond off_ext
end

val sem-bz-link cmp_op x = do
	pc <- return (ip-get);
	ra <- return (semantic-gpr-of RA);

	# 4 instead of 8 since pc got incremented already
	add ra.size ra (var pc) (imm 4);

	sem-bz cmp_op x
end

val sem-beq x = sem-b /eq x
val sem-beql x = sem-b /eq x
val sem-bgez x = sem-bz /ges x
val sem-bgezal x = sem-bz-link /ges x
val sem-bgezall x = sem-bz-link /ges x
val sem-bgezl x = sem-bz /ges x
val sem-bgtz x = sem-bz /gts x
val sem-bgtzl x = sem-bz /gts x
val sem-blez x = sem-bz /les x
val sem-blezl x = sem-bz /les x
val sem-bltz x = sem-bz /lts x
val sem-bltzal x = sem-bz-link /lts x
val sem-bltzall x = sem-bz-link /lts x
val sem-bltzl x = sem-bz /lts x
val sem-bne x = sem-b /neq x
val sem-bnel x = sem-b /neq x

val sem-break x = return void	# TODO: EXCEPTION
val sem-cache x = return void	# TODO: SEMANTICS
val sem-cachee x = return void	# TODO: SEMANTICS

val sem-cl bit x = do
	rs <- rval Unsigned x.source1;
	size <- return (sizeof-rval x.source1);
	
	amount <- mktemp;
	mov size amount (imm 32);
	
	i <- mktemp;
	mov size i (imm 31);

	shifted <- mktemp;
	_while (/neq size (var i) (imm 0)) __ do
		shr size shifted rs (var i);

		_if (/neq 1 (var shifted) (imm bit)) _then do
			sub size amount (imm 31) (var i);
			mov size i (imm 0)
		end _else
			sub size i (var i) (imm 1)
		
	end
	;
	write x.destination (var amount)
end

val sem-deret = return void	#TODO: SEMANTICS
val sem-di x = return void	#TODO: SEMANTICS

val sem-div-divu div_op mod_op x = do
	num <- rval Signed x.source1;
	denom <- rval Signed x.source2;
	size <- return (sizeof-rval x.source1);

	hi <- return (hi-get);
	lo <- return (lo-get);

	div_op size lo num denom;
	mod_op size hi num denom
end

val sem-div x = sem-div-divu div mod x
val sem-divu x = sem-div-divu divs mods x

val sem-ei x = return void	#TODO: SEMANTICS
val sem-eret = return void	#TODO: SEMANTICS

val sem-ext x = do
	rs <- rval Unsigned x.source1;
	msbd <- rval Unsigned x.source2;
	lsb <- rval Unsigned x.source3;
	size <- return (sizeof-rval x.source1);

	ps <- return (lin-to-int lsb);
	sz <- return (1 + lin-to-int msbd);

	temp <- mktemp;
	mov size temp rs;

	res <- mktemp;
	mov size res (imm 0);
	mov sz res (var (at-offset temp ps));

	write x.destination (var res)
end

val sem-ins x = do
	rs <- rval Unsigned x.source1;
	msb <- rval Unsigned x.source2;
	lsb <- rval Unsigned x.source3;
	rt <- lval Unsigned x.destination;
	size <- return (sizeof-rval x.source1);

	ps <- return (lin-to-int lsb);
	sz <- return (1 - ps + lin-to-int msb);

	temp <- mktemp;
	mov size temp rs;

	res <- mktemp;
	mov size res rt;
	mov sz res (var (at-offset temp ps));

	write x.destination (var res)
end

val sem-j x = do
	index <- rval Unsigned x.source;
	size <- return (sizeof-rval x.source);
	index_ext <- return (scale 4 index);

	pc <- return (ip-get);

	addr <- mktemp;
	mov 32 addr (var pc);
	mov (size+2) addr index_ext;

	jump (address pc.size (var addr))
end

val sem-jal x = do
	pc <- return (ip-get);
	ra <- return (semantic-gpr-of RA);

	# 4 instead of 8 since pc got incremented already
	add ra.size ra (var pc) (imm 4);

	sem-j x
end

val sem-jalr x = return void	# TODO: SEMANTICS
val sem-jalr-hb x = return void	# TODO: SEMANTICS
val sem-jalx x = return void	# TODO: SEMANTICS
val sem-jr x = return void	# TODO: SEMANTICS
val sem-jr-hb x = return void	# TODO: SEMANTICS

val sem-lb-lbu ext_op x = do
	base <- rval Signed x.source1;
	off <- rval Signed x.source2;
	size <- return (sizeof-rval x.source1);

	vaddr <- mktemp;
	add size vaddr base off;

	memword <- mktemp;
	load 32 memword size (var vaddr);

	bigendian_cpu <- mktemp;
	re <- return (fRE);
	movsx 2 bigendian_cpu 1 (var re);

	# get depending on the endianess the correct byte out of the word
	byte <- mktemp;
	mov 30 (at-offset byte 2) (imm 0);
	xorb 2 byte (var vaddr) (var bigendian_cpu);
	shl 32 byte (var byte) (imm 3);
	shr 32 memword (var memword) (var byte);

	res <- mktemp;
	ext_op size res 8 (var memword);

	write x.destination (var res)
end

val sem-lb x = sem-lb-lbu movsx x
val sem-lbu x = sem-lb-lbu movzx x

val sem-lh-lhu ext_op x = do
	base <- rval Signed x.source1;
	off <- rval Signed x.source2;
	size <- return (sizeof-rval x.source1);

	# THROW EXCEPTION

	vaddr <- mktemp;
	add size vaddr base off;

	memword <- mktemp;
	load 32 memword size (var vaddr);

	bigendian_cpu <- mktemp;
	mov 1 bigendian_cpu (var fRE);
	shl 2 bigendian_cpu (var bigendian_cpu) (imm 1);

	# get depending on the endianess the correct halfword out of the word
	byte <- mktemp;
	mov 30 (at-offset byte 2) (imm 0);
	xorb 2 byte (var vaddr) (var bigendian_cpu);
	shl 32 byte (var byte) (imm 3);
	shr 32 memword (var memword) (var byte);

	res <- mktemp;
	ext_op size res 16 (var memword);

	write x.destination (var res)
end

val sem-lh x = sem-lh-lhu movsx x
val sem-lhu x = sem-lh-lhu movzx x

val sem-lw x = do
	base <- rval Signed x.source1;
	off <- rval Signed x.source2;
	size <- return (sizeof-rval x.source1);

	# THROW EXCEPTION

	vaddr <- mktemp;
	add size vaddr base off;

	memword <- mktemp;
	load 32 memword size (var vaddr);

	write x.destination (var memword)
end

val sem-lui x = do
	immediate <- rval Unsigned x.source;
	size <- return (sizeof-lval x.destination);
	size_imm <- return (sizeof-rval x.source);
	
	res <- mktemp;
	shl size res immediate (imm (32-size_imm));

	write x.destination (var res)
end

val sem-madd-maddu-msub-msubu ext_op add_sub_op x = do
	rs <- rval Signed x.source1;
	rt <- rval Signed x.source2;
	size <- return (sizeof-rval x.source1);

	rs_ext <- mktemp;
	ext_op (size*2) rs_ext size rs;

	rt_ext <- mktemp;
	ext_op (size*2) rt_ext size rt;

	res <- mktemp;
	mul (size*2) res (var rs_ext) (var rt_ext);

	hi <- return (hi-get);
	lo <- return (lo-get);

	hilo <- mktemp;
	movzx (size*2) hilo size (var lo);
	mov size (at-offset hilo size) (var hi);

	add_sub_op (size*2) res (var res) (var hilo);

	mov size lo (var res);
	mov size hi (var (at-offset res size))
end

val sem-madd x = sem-madd-maddu-msub-msubu movsx add x
val sem-maddu x = sem-madd-maddu-msub-msubu movzx add x
val sem-msub x = sem-madd-maddu-msub-msubu movzx sub x
val sem-msubu x = sem-madd-maddu-msub-msubu movzx sub x 

val sem-mfhi x = do
	hi <- return (hi-get);
	
	write x.destination (var hi)
end

val sem-mflo x = do
	lo <- return (lo-get);
	
	write x.destination (var lo)
end

val sem-mthi x = do
	rs <- rval Signed x.source;
	hi <- return (hi-get);

	mov hi.size hi rs
end

val sem-mtlo x = do
	rs <- rval Signed x.source;
	lo <- return (lo-get);

	mov lo.size lo rs
end

val sem-movn-movz cmp_op x = do
	rs <- rval Signed x.source1;
	rt <- rval Signed x.source2;
	size <- return (sizeof-rval x.source1);

	_if (cmp_op size rt (imm 0)) _then
		write x.destination rs
end

val sem-movn x = sem-movn-movz /neq x
val sem-movz x = sem-movn-movz /eq x

val sem-mult-multu ext_op x = do
	rs <- rval Signed x.source1;
	rt <- rval Signed x.source2;
	size <- return (sizeof-rval x.source1);

	rs_ext <- mktemp;
	ext_op (size*2) rs_ext size rs;

	rt_ext <- mktemp;
	ext_op (size*2) rt_ext size rt;

	res <- mktemp;
	mul (size*2) res (var rs_ext) (var rt_ext);

	hi <- return (hi-get);
	lo <- return (lo-get);
	
	mov size lo (var res);
	mov size hi (var (at-offset res size))
end

val sem-mult x = sem-mult-multu movsx x
val sem-multu x = sem-mult-multu movzx x

val sem-mul x = do
	rs <- rval Signed x.source1;
	rt <- rval Signed x.source2;
	size <- return (sizeof-rval x.source1);

	rs_ext <- mktemp;
	movsx (size*2) rs_ext size rs;

	rt_ext <- mktemp;
	movsx (size*2) rt_ext size rt;

	res <- mktemp;
	mul (size*2) res (var rs_ext) (var rt_ext);

	write x.destination (var res)
end

val sem-nor x = do
	s1 <- rval Unsigned x.source1;
	s2 <- rval Unsigned x.source2;
	size <- return (sizeof-lval x.destination);

	res <- mktemp;
	orb size res s1 s2;
	xorb size res (var res) (imm (0-1));
	
	write x.destination (var res)
end

val sem-rotr x = do
	rt <- rval Signed x.source1;
	sa <- rval Unsigned x.source2;
	size <- return (sizeof-rval x.source1);
	amount <- return (lin-to-int sa);

	res <- mktemp;
	shr size res rt sa;
	mov amount (at-offset res (32-amount)) rt;

	write x.destination (var res)
end

val sem-rotrv x = do
	rt <- rval Signed x.source1;
	rs <- rval Unsigned x.source2;
	size <- return (sizeof-rval x.source1);

	left <- mktemp;
	shr size left rt rs;

	amount <- mktemp;
	sub size amount (imm 32) rs;

	right <- mktemp;
	shl size right rt (var amount);

	res <- mktemp;
	orb size res (var left) (var right);

	write x.destination (var res)
end

val sem-se sz x = do
	rt <- rval Signed x.source;
	size <- return (sizeof-rval x.source);

	res <- mktemp;
	movsx size res sz rt;

	write x.destination (var res)
end

val sem-seb x = sem-se 8 x
val sem-seh x = sem-se 16 x

val sem-slt-sltu cmp_op x = do
	s1 <- rval Signed x.source1;
	s2 <- rval Signed x.source2;
	size <- return (sizeof-rval x.source1);

	res <- mktemp;
	cmp_op size res s1 s2;
	movzx size res 1 (var res);

	write x.destination (var res)
end

val sem-slt x = sem-slt-sltu cmplts x
val sem-sltu x = sem-slt-sltu cmpltu x

val sem-slti-sltiu mov_op cmp_op x = do
	rt <- rval Signed x.source1;
	imm <- rval Signed x.source2;
	size <- return (sizeof-rval x.source1);
	size_imm <- return (sizeof-rval x.source2);

	imm_ext <- mktemp;
	mov_op size imm_ext size_imm imm;
 
	res <- mktemp;
	cmp_op size res rt (var imm_ext);
	movzx size res 1 (var res);

	write x.destination (var res)
end

val sem-slti x = sem-slti-sltiu movsx cmplts x
val sem-sltiu x = sem-slti-sltiu movzx cmpltu x

val sem-sub x = do
	s1 <- rval Signed x.source1;
	s2 <- rval Signed x.source2;
	size <- return (sizeof-lval x.destination);

	res <- mktemp;
	sub size res s1 s2;
	
	# EXCEPTION THROWN

	write x.destination (var res)
end

val sem-subu x = do
	s1 <- rval Signed x.source1;
	s2 <- rval Signed x.source2;
	size <- return (sizeof-lval x.destination);

	res <- mktemp;
	sub size res s1 s2;
	
	write x.destination (var res)
end

val sem-sb x = do
	rt <- rval Signed x.source2;
	base <- rval Signed x.source1;
	off <- rval Signed x.source3;
	size <- return (sizeof-rval x.source1);

	vaddr <- mktemp;
	add size vaddr base off;

	bigendian_cpu <- mktemp;
	re <- return (fRE);
	movsx 2 bigendian_cpu 1 (var re);

	byte <- mktemp;
	mov 30 (at-offset byte 2) (imm 0);
	xorb 2 byte (var vaddr) (var bigendian_cpu);
	shl 32 byte (var byte) (imm 3);

	memword <- mktemp;
	shl 32 memword rt (var byte);

	store 32 (address size (var vaddr)) (var memword)
end

val sem-sh x = do
	rt <- rval Signed x.source2;
	base <- rval Signed x.source1;
	off <- rval Signed x.source3;
	size <- return (sizeof-rval x.source1);

	# THROW EXCEPTION

	vaddr <- mktemp;
	add size vaddr base off;

	bigendian_cpu <- mktemp;
	shl 2 bigendian_cpu (var fRE) (imm 1);

	byte <- mktemp;
	mov 30 (at-offset byte 2) (imm 0);
	xorb 2 byte (var vaddr) (var bigendian_cpu);
	shl 32 byte (var byte) (imm 3);

	memword <- mktemp;
	shl 32 memword rt (var byte);

	store 32 (address size (var vaddr)) (var memword)
end

val sem-sw x = do
	rt <- rval Signed x.source2;
	base <- rval Signed x.source1;
	off <- rval Signed x.source3;
	size <- return (sizeof-rval x.source1);

	# THROW EXCEPTION

	vaddr <- mktemp;
	add size vaddr base off;

	store 32 (address size (var vaddr)) rt
end

val sem-sll-sra-srl shift_op x = do
	rt <- rval Signed x.source1;
	amount <- rval Signed x.source2;
	size <- return (sizeof-lval x.destination);

	temp <- mktemp;
	shift_op size temp rt amount;
	
	write x.destination (var temp)
end

val sem-sll x = sem-sll-sra-srl shl x
val sem-sra x = sem-sll-sra-srl shrs x
val sem-srl x = sem-sll-sra-srl shr x

val sem-sllv-srav-srlv shift_op x = do
	rt <- rval Signed x.source1;
	rs <- rval Signed x.source2;
	size <- return (sizeof-lval x.destination);
	
	amount <- mktemp;
	mov 5 amount rs;

	temp <- mktemp;
	shift_op size temp rt (var amount);

	write x.destination (var temp)
end

val sem-sllv x = sem-sllv-srav-srlv shl x
val sem-srav x = sem-sllv-srav-srlv shrs x
val sem-srlv x = sem-sllv-srav-srlv shr x

val semantics i =
   case i of
      ABS-fmt x: sem-default-binop-fmt-ro-generic i x
    | ADD x: sem-add x
    | ADD-fmt x: sem-default-ternop-fmt-ro-generic i x
    | ADDI x: sem-addi x
    | ADDIU x: sem-addiu x
    | ADDU x: sem-addu x
    | ALNV-PS x: sem-default-quadop-ro-generic i x
    | AND x: sem-and x
    | ANDI x: sem-andi x
    | BC1F x: sem-default-binop-src-ro-generic i x
    | BC1FL x: sem-default-binop-src-ro-generic i x
    | BC1T x: sem-default-binop-src-ro-generic i x
    | BC1TL x: sem-default-binop-src-ro-generic i x
    | BC2F x: sem-default-binop-src-ro-generic i x
    | BC2FL x: sem-default-binop-src-ro-generic i x
    | BC2T x: sem-default-binop-src-ro-generic i x
    | BC2TL x: sem-default-binop-src-ro-generic i x
    | BEQ x: sem-beq x
    | BEQL x: sem-beql x
    | BGEZ x: sem-bgez x
    | BGEZAL x: sem-bgezal x
    | BGEZALL x: sem-bgezall x
    | BGEZL x: sem-bgezl x
    | BGTZ x: sem-bgtz x
    | BGTZL x: sem-bgtzl x
    | BLEZ x: sem-blez x
    | BLEZL x: sem-blezl x
    | BLTZ x: sem-bltz x
    | BLTZAL x: sem-bltzal x
    | BLTZALL x: sem-bltzall x
    | BLTZL x: sem-bltzl x
    | BNE x: sem-bne x
    | BNEL x: sem-bnel x
    | BREAK x: sem-break x
    | C-cond-fmt x: sem-default-quadop-fmt-src-ro-generic i x
    | CACHE x: sem-cache x
    | CACHEE x: sem-cachee x
    | CEIL-L-fmt x: sem-default-binop-fmt-ro-generic i x
    | CEIL-W-fmt x: sem-default-binop-fmt-ro-generic i x
    | CFC1 x: sem-default-binop-ro-generic i x
    | CFC2 x: sem-default-binop-ro-generic i x
    | CLO x: sem-cl 1 x
    | CLZ x: sem-cl 0 x
    | COP2 x: sem-default-unop-src-ro-generic i x
    | CTC1 x: sem-default-binop-ro-generic i x
    | CTC2 x: sem-default-binop-src-ro-generic i x
    | CVT-D-fmt x: sem-default-binop-fmt-ro-generic i x
    | CVT-L-fmt x: sem-default-binop-fmt-ro-generic i x
    | CVT-PS-S x: sem-fp
    | CVT-S-fmt x: sem-fp
    | CVT-S-PL x: sem-fp
    | CVT-S-PU x: sem-fp
    | CVT-W-fmt x: sem-fp
    | DERET: sem-deret
    | DI x: sem-di x
    | DIV x: sem-div x
    | DIV-fmt x: sem-fp
    | DIVU x: sem-divu x 
    | EI x: sem-ei x
    | ERET: sem-eret
    | EXT x: sem-ext x
    | FLOOR-L-fmt x: sem-fp
    | FLOOR-W-fmt x: sem-fp
    | INS x: sem-ins x
    | J x: sem-j x
    | JAL x: sem-jal x
    | JALR x: sem-jalr x
    | JALR-HB x: sem-jalr-hb x
    | JALX x: sem-jalx x
    | JR x: sem-jr x
    | JR-HB x: sem-jr-hb x
    | LB x: sem-lb x
    | LBE x: sem-lb x
    | LBU x: sem-lbu x
    | LBUE x: sem-lbu x
    | LDC1 x: sem-foo
    | LDC2 x: sem-foo
    | LDXC1 x: sem-foo
    | LH x: sem-lh x
    | LHE x: sem-lh x
    | LHU x: sem-lhu x
    | LHUE x: sem-lhu x
    | LL x: sem-foo
    | LLE x: sem-foo
    | LUI x: sem-lui x
    | LUXC1 x: sem-foo
    | LW x: sem-lw x
    | LWC1 x: sem-foo
    | LWC2 x: sem-foo
    | LWE x: sem-lw x
    | LWL x: sem-foo
    | LWLE x: sem-foo
    | LWR x: sem-foo
    | LWRE x: sem-foo
    | LWXC1 x: sem-foo
    | MADD x: sem-madd x
    | MADD-fmt x: sem-foo
    | MADDU x: sem-maddu x
    | MFC0 x: sem-foo
    | MFC1 x: sem-foo
    | MFC2 x: sem-foo
    | MFHC1 x: sem-foo
    | MFHC2 x: sem-foo
    | MFHI x: sem-mfhi x
    | MFLO x: sem-mflo x
    | MOV-fmt x: sem-foo
    | MOVF x: sem-foo
    | MOVF-fmt x: sem-foo
    | MOVN x: sem-movn x
    | MOVN-fmt x: sem-foo
    | MOVT x: sem-foo
    | MOVT-fmt x: sem-foo
    | MOVZ x: sem-movz x
    | MOVZ-fmt x: sem-foo
    | MSUB x: sem-msub x
    | MSUB-fmt x: sem-foo
    | MSUBU x: sem-msubu x
    | MTC0 x: sem-foo
    | MTC1 x: sem-foo
    | MTC2 x: sem-foo
    | MTHC1 x: sem-foo
    | MTHC2 x: sem-foo
    | MTHI x: sem-mthi x
    | MTLO x: sem-mtlo x
    | MUL x: sem-mul x
    | MUL-fmt x: sem-foo
    | MULT x: sem-mult x
    | MULTU x: sem-multu x
    | NEG-fmt x: sem-foo
    | NMADD-fmt x: sem-foo
    | NMSUB-fmt x: sem-foo
    | NOR x: sem-nor x
    | OR x: sem-or x
    | ORI x: sem-ori x
    | PLL-PS x: sem-foo
    | PLU-PS x: sem-foo
    | PREF x: sem-foo
    | PREFE x: sem-foo
    | PREFX x: sem-foo
    | PUL-PS x: sem-foo
    | PUU-PS x: sem-foo
    | RDHWR x: sem-foo
    | RDPGPR x: sem-foo
    | RECIP-fmt x: sem-foo
    | ROTR x: sem-rotr x
    | ROTRV x: sem-rotrv x
    | ROUND-L-fmt x: sem-foo
    | ROUND-W-fmt x: sem-foo
    | RSQRT-fmt x: sem-foo
    | SB x: sem-sb x
    | SBE x: sem-sb x
    | SC x: sem-foo
    | SCE x: sem-foo
    | SDBBP x: sem-foo
    | SDC1 x: sem-foo
    | SDC2 x: sem-foo
    | SDXC1 x: sem-foo
    | SEB x: sem-seb x
    | SEH x: sem-seh x
    | SH x: sem-sh x
    | SHE x: sem-sh x
    | SLL x: sem-sll x
    | SLLV x: sem-sllv x
    | SLT x: sem-slt x
    | SLTI x: sem-slti x
    | SLTIU x: sem-sltiu x
    | SLTU x: sem-sltu x
    | SQRT-fmt x: sem-fp
    | SRA x: sem-sra x
    | SRAV x: sem-srav x
    | SRL x: sem-srl x
    | SRLV x: sem-srlv x
    | SUB x: sem-sub x
    | SUB-fmt x: sem-foo
    | SUBU x: sem-subu x
    | SUXC1 x: sem-foo
    | SW x: sem-sw x
    | SWC1 x: sem-foo
    | SWC2 x: sem-foo
    | SWE x: sem-sw x
    | SWL x: sem-foo
    | SWLE x: sem-foo
    | SWR x: sem-foo
    | SWRE x: sem-foo
    | SWXC1 x: sem-foo
    | SYNC x: sem-foo
    | SYNCI x: sem-foo
    | SYSCALL x: sem-foo
    | TEQ x: sem-foo
    | TEQI x: sem-foo
    | TGE x: sem-foo
    | TGEI x: sem-foo
    | TGEIU x: sem-foo
    | TGEU x: sem-foo
    | TLBINV: sem-foo
    | TLBINVF: sem-foo
    | TLBP: sem-foo
    | TLBR: sem-foo
    | TLBWI: sem-foo
    | TLBWR: sem-foo
    | TLT x: sem-foo
    | TLTI x: sem-foo
    | TLTIU x: sem-foo
    | TLTU x: sem-foo
    | TNE x: sem-foo
    | TNEI x: sem-foo
    | TRUNC-L-fmt x: sem-foo
    | TRUNC-W-fmt x: sem-foo
    | WAIT x: sem-foo
    | WRPGPR x: sem-foo
    | WSBH x: sem-foo
    | XOR x: sem-xor x
    | XORI x: sem-xori x
   end

# -> sftl

# <- sutl

val translate-mips insn = semantics insn.insn

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
