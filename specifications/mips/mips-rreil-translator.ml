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

###########
### semantics of instructions
###########

val sem-foo = return void
val sem-fp = return void
val sem-fp2 = return void

val sem-add-addi x = do
	s1 <- rval Signed x.source1;
	s2 <- rval Signed x.source2;
	size <- return (sizeof-lval x.destination);

	res <- mktemp;
	add size res s1 s2;
	
	write x.destination (var res)
end

val sem-addu-addiu x = do
	s1 <- rval Signed x.source1;
	s2 <- rval Signed x.source2;
	size <- return (sizeof-lval x.destination);

	res <- mktemp;
	add size res s1 s2;
	
	write x.destination (var res)
end

val sem-bitwise op x = do
	s1 <- rval Unsigned x.source1;
	s2 <- rval Unsigned x.source2;
	size <- return (sizeof-lval x.destination);

	res <- mktemp;
	op size res s1 s2;
	
	write x.destination (var res)
end

val cbranch-rel cond offset = do
	pc <- ip-get;
	
	new_pc <- mktemp;
	add pc.size new_pc (var pc) offset;

	cbranch cond (address pc.size (var new_pc)) (address pc.size (var pc))
end

val sem-b cmp x = do
	s1 <- rval Signed x.source1;
	s2 <- rval Signed x.source2;
	s3 <- rval Signed x.source3;
	size_o <- return (sizeof-rval x.source3);
	size_r <- return (sizeof-rval x.source1);

	offset <- mktemp;
	shl (size_o+2) offset s3 (imm 2);

	cond <- cmp size_r s1 s2;
	cbranch-rel cond (var offset)
end

val sem-bz cmp x = do
	s1 <- rval Signed x.source1;
	s2 <- rval Signed x.source2;
	
	size_o <- return (sizeof-rval x.source2);
	size_r <- return (sizeof-rval x.source1);

	offset <- mktemp;
	shl (size_o+2) offset s2 (imm 2);

	cond <- cmp size_r s1 (imm 0);
	cbranch-rel cond (var offset)
end

val sem-bz-link cmp x = do
	pc <- ip-get;
	ra <- return (semantic-gpr-of RA);

	sem-bz cmp x
end

val sem-break x = return void	# TODO: EXCEPTION
val sem-cache x = return void	# TODO: SEMANTICS
val sem-cachee x = return void	# TODO: SEMANTICS

val sem-cl bit x = do
	s1 <- rval Unsigned x.source1;
	s2 <- rval Unsigned x.source2;
	size <- return (sizeof-lval x.destination);
	
	temp <- mktemp;
	mov size temp (imm 32);
	
	i <- mktemp;
	mov size i (imm 31);

	cond <- mktemp;
	shifted <- mktemp;
	_while (/neq size (var i) (imm 0)) __ do
		shr size shifted s2 (var i);

		_if (/neq 1 (var shifted) (imm bit)) _then do
			sub size temp (imm 31) (var i);
			mov size i (imm 0)
		end _else
			sub size i (var i) (imm 1)
		
	end
	;
	write x.destination (var temp)
end

val sem-deret = return void	#TODO: SEMANTICS
val sem-di x = return void	#TODO: SEMANTICS

val sem-div div_op mod_op x = do
	num <- rval Signed x.source1;
	denom <- rval Signed x.source2;
	size <- return (sizeof-rval x.source1);

	hi <- hi-get;
	lo <- lo-get;

	div_op size lo num denom;
	mod_op size hi num denom
end

val sem-ei x = return void	#TODO: SEMANTICS
val sem-eret = return void	#TODO: SEMANTICS

val sem-ext x = do
	s1 <- rval Unsigned x.source1;
	msbd <- rval Unsigned x.source2;
	lsb <- rval Unsigned x.source3;
	size <- return (sizeof-rval x.source1);

	right <- mktemp;
	left <- mktemp;
	sub size right (imm 31) msbd;
	sub size left (var right) lsb;

	temp <- mktemp;
	shl size temp s1 (var left);
	shr size temp (var temp) (var right);

	write x.destination (var temp)
end

val sem-ins x = do
	s1 <- rval Unsigned x.source1;
	msb <- rval Unsigned x.source2;
	lsb <- rval Unsigned x.source3;
	s2 <- lval Unsigned x.destination;
	size <- return (sizeof-rval x.source1);

	right<- mktemp;
	left <- mktemp;
	sub size right (imm 31) msb;
	sub size left (var right) lsb;

	temp <- mktemp;
	shl size temp s1 (var left);
	shr size temp (var temp) (var right);

	sub size right (imm 32) lsb;
	add size left msb (imm 1);

	orig_left <- mktemp;
	shr size orig_left s2 (var left);
	shl size orig_left (var orig_left) (var left);

	orig_right <- mktemp;
	shl size orig_right s2 (var right);
	shr size orig_right (var orig_right) (var right);

	orb size temp (var temp) (var orig_left);
	orb size temp (var temp) (var orig_right);

	write x.destination (var temp)	
end

val sem-j x = do
	index <- rval Unsigned x.source;
	size <- return (sizeof-rval x.source);

	a <- mktemp;
	shl (size+2) a index (imm 2);
	
	pc <- ip-get;
	addr-sz <- return pc.size;

	addr <- mktemp;
	mov 32 addr (var pc);
	mov (size+2) addr (var a);

	jump (address addr-sz (var addr))
end

val sem-jal x = do
	pc <- ip-get;
	ra <- return (semantic-gpr-of RA);

	add ra.size ra (var pc) (imm 8);

	sem-j x
end

val sem-jalr x = return void	# TODO: SEMANTICS
val sem-jalr-hb x = return void	# TODO: SEMANTICS
val sem-jalx x = return void	# TODO: SEMANTICS
val sem-jr x = return void	# TODO: SEMANTICS
val sem-jr-hb x = return void	# TODO: SEMANTICS

val sem-lb x = return void	# TODO: SEMANTICS

val sem-mul x = do
	s1 <- rval Signed x.source1;
	s2 <- rval Signed x.source2;
	size <- return (sizeof-rval x.source1);

	res <- mktemp;
	mul (size*2) res s1 s2;

	hi <- hi-get;
	lo <- lo-get;
	
	mov size lo (var res);
	mov size hi (var (at-offset res size))
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

val sem-slt-slti x = do
	s1 <- rval Signed x.source1;
	s2 <- rval Signed x.source2;
	size <- return (sizeof-rval x.source1);

	res <- mktemp;
	cmplts size res s1 s2;

	write x.destination (var res)
end

val sem-sltu-sltiu x = do
	s1 <- rval Unsigned x.source1;
	s2 <- rval Unsigned x.source2;
	size <- return (sizeof-rval x.source1);

	res <- mktemp;
	cmpltu size res s1 s2;

	write x.destination (var res)
end

val sem-sub x = do
	s1 <- rval Signed x.source1;
	s2 <- rval Signed x.source2;
	size <- return (sizeof-lval x.destination);

	res <- mktemp;
	sub size res s1 s2;
	
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

val sem-bitshift op x = do
	rt <- rval Signed x.source1;
	amount <- rval Signed x.source2;
	size <- return (sizeof-lval x.destination);

	temp <- mktemp;
	op size temp rt amount;
	
	write x.destination (var temp)
end

val sem-bitshift-variable op x = do
	rt <- rval Signed x.source1;
	rs <- rval Signed x.source2;
	size <- return (sizeof-lval x.destination);
	
	amount <- mktemp;
	mov 5 amount rs;

	temp <- mktemp;
	op size temp rt (var amount);

	write x.destination (var temp)	
end

val semantics i =
   case i of
      ABS-fmt x: sem-fp
    | ADD x: sem-add-addi x
    | ADD-fmt x: sem-fp
    | ADDI x: sem-add-addi x
    | ADDIU x: sem-addu-addiu x
    | ADDU x: sem-addu-addiu x
    | ALNV-PS x: sem-fp
    | AND x: sem-bitwise andb x
    | ANDI x: sem-bitwise andb x
    | BC1F x: sem-fp
    | BC1FL x: sem-fp
    | BC1T x: sem-fp
    | BC1TL x: sem-fp
    | BC2F x: sem-fp2
    | BC2FL x: sem-fp2
    | BC2T x: sem-fp2
    | BC2TL x: sem-fp2
    | BEQ x: sem-b /eq x
    | BEQL x: sem-b /eq x
    | BGEZ x: sem-bz /ges x
    | BGEZAL x: sem-bz-link /ges x
    | BGEZALL x: sem-bz-link /ges x
    | BGEZL x: sem-bz /ges x
    | BGTZ x: sem-bz /gts x
    | BGTZL x: sem-bz /gts x
    | BLEZ x: sem-bz /les x
    | BLEZL x: sem-bz /les x
    | BLTZ x: sem-bz /lts x
    | BLTZAL x: sem-bz-link /lts x
    | BLTZALL x: sem-bz-link /lts x
    | BLTZL x: sem-bz /lts x
    | BNE x: sem-b /neq x
    | BNEL x: sem-b /neq x
    | BREAK x: sem-break x
    | C-cond-fmt x: sem-fp
    | CACHE x: sem-cache x
    | CACHEE x: sem-cachee x
    | CEIL-L-fmt x: sem-fp
    | CEIL-W-fmt x: sem-fp
    | CFC1 x: sem-fp
    | CFC2 x: sem-fp2
    | CLO x: sem-cl 1 x
    | CLZ x: sem-cl 0 x
    | COP2 x: sem-fp2
    | CTC1 x: sem-fp
    | CTC2 x: sem-fp2
    | CVT-D-fmt x: sem-fp
    | CVT-L-fmt x: sem-fp
    | CVT-PS-S x: sem-fp
    | CVT-S-fmt x: sem-fp
    | CVT-S-PL x: sem-fp
    | CVT-S-PU x: sem-fp
    | CVT-W-fmt x: sem-fp
    | DERET: sem-deret
    | DI x: sem-di x
    | DIV x: sem-div divs mods x
    | DIV-fmt x: sem-fp
    | DIVU x: sem-div div mod x 
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
    | LBE x: sem-foo
    | LBU x: sem-foo
    | LBUE x: sem-foo
    | LDC1 x: sem-foo
    | LDC2 x: sem-foo
    | LDXC1 x: sem-foo
    | LH x: sem-foo
    | LHE x: sem-foo
    | LHU x: sem-foo
    | LHUE x: sem-foo
    | LL x: sem-foo
    | LLE x: sem-foo
    | LUI x: sem-foo
    | LUXC1 x: sem-foo
    | LW x: sem-foo
    | LWC1 x: sem-foo
    | LWC2 x: sem-foo
    | LWE x: sem-foo
    | LWL x: sem-foo
    | LWLE x: sem-foo
    | LWR x: sem-foo
    | LWRE x: sem-foo
    | LWXC1 x: sem-foo
    | MADD x: sem-foo
    | MADD-fmt x: sem-foo
    | MADDU x: sem-foo
    | MFC0 x: sem-foo
    | MFC1 x: sem-foo
    | MFC2 x: sem-foo
    | MFHC1 x: sem-foo
    | MFHC2 x: sem-foo
    | MFHI x: sem-foo
    | MFLO x: sem-foo
    | MOV-fmt x: sem-foo
    | MOVF x: sem-foo
    | MOVF-fmt x: sem-foo
    | MOVN x: sem-foo
    | MOVN-fmt x: sem-foo
    | MOVT x: sem-foo
    | MOVT-fmt x: sem-foo
    | MOVZ x: sem-foo
    | MOVZ-fmt x: sem-foo
    | MSUB x: sem-foo
    | MSUB-fmt x: sem-foo
    | MSUBU x: sem-foo
    | MTC0 x: sem-foo
    | MTC1 x: sem-foo
    | MTC2 x: sem-foo
    | MTHC1 x: sem-foo
    | MTHC2 x: sem-foo
    | MTHI x: sem-foo
    | MTLO x: sem-foo
    | MUL x: sem-foo
    | MUL-fmt x: sem-foo
    | MULT x: sem-mul x
    | MULTU x: sem-mul x
    | NEG-fmt x: sem-foo
    | NMADD-fmt x: sem-foo
    | NMSUB-fmt x: sem-foo
    | NOR x: sem-nor x
    | OR x: sem-bitwise orb x
    | ORI x: sem-bitwise orb x
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
    | ROTR x: sem-foo
    | ROTRV x: sem-foo
    | ROUND-L-fmt x: sem-foo
    | ROUND-W-fmt x: sem-foo
    | RSQRT-fmt x: sem-foo
    | SB x: sem-foo
    | SBE x: sem-foo
    | SC x: sem-foo
    | SCE x: sem-foo
    | SDBBP x: sem-foo
    | SDC1 x: sem-foo
    | SDC2 x: sem-foo
    | SDXC1 x: sem-foo
    | SEB x: sem-foo
    | SEH x: sem-foo
    | SH x: sem-foo
    | SHE x: sem-foo
    | SLL x: sem-bitshift shl x
    | SLLV x: sem-bitshift-variable shl x
    | SLT x: sem-slt-slti x
    | SLTI x: sem-slt-slti x
    | SLTIU x: sem-sltu-sltiu x
    | SLTU x: sem-sltu-sltiu x
    | SQRT-fmt x: sem-foo
    | SRA x: sem-bitshift shrs x
    | SRAV x: sem-bitshift-variable shrs x
    | SRL x: sem-bitshift shr x
    | SRLV x: sem-bitshift-variable shr x
    | SUB x: sem-sub x
    | SUB-fmt x: sem-foo
    | SUBU x: sem-subu x
    | SUXC1 x: sem-foo
    | SW x: sem-foo
    | SWC1 x: sem-foo
    | SWC2 x: sem-foo
    | SWE x: sem-foo
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
    | XOR x: sem-bitwise xorb x
    | XORI x: sem-bitwise xorb x
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
