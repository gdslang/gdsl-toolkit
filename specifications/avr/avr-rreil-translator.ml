export = translate

val sem-adc bo = do
  rd <- rval Unsigned bo.first;
  rr <- rval Unsigned bo.second;
	size <- return (sizeof bo.first);

	r <- mktemp;
	add size r rd rr;

	cf <- return fCF;
	t <- mktemp;
	movzx size t 1 (var cf);
	add size r (var r) (var t);

  emit-flag-adc-h size rd (var r);
  emit-flag-add-adc-v size rd rr (var r);
  emit-flag-n size (var r);
  emit-flag-z size (var r);
  emit-flag-adc-c size rd (var r);
	emit-flag-s;

	write bo.first (var r)
end

val sem-add bo = do
  rd <- rval Unsigned bo.first;
	rr <- rval Unsigned bo.second;
  size <- return (sizeof bo.first);

	r <- mktemp;
	add size r rd rr;

  emit-flag-add-h size rd (var r);
	emit-flag-add-adc-v size rd rr (var r);
	emit-flag-n size (var r);
	emit-flag-z size (var r);
	emit-flag-add-c size rd (var r);
	emit-flag-s;

	write bo.first (var r)
end

val sem-adiw bo = do
  rd <- rval Unsigned bo.first;
	rr <- rval Unsigned bo.second;
  size <- return (sizeof bo.first);

	r <- mktemp;
	add size r rd rr;

	emit-flag-add-adc-v size rd rr (var r);
	emit-flag-n size (var r);
	emit-flag-z size (var r);
	emit-flag-add-c size rd (var r);
	emit-flag-s;

	write bo.first (var r)
end

val sem-and-andi bo = do
  rd <- rval Unsigned bo.first;
	rr <- rval Unsigned bo.second;
  size <- return (sizeof bo.first);

	r <- mktemp;
	andb size r rd rr;

	ov <- return fVF;
	mov 1 ov (imm 0);
	emit-flag-n size (var r);
	emit-flag-z size (var r);
	emit-flag-s;

	write bo.first (var r)
end

val sem-asr uo = do
  rd <- rval Unsigned uo.operand;
  size <- return (sizeof uo.operand);

	r <- mktemp;
	shrs size r rd (imm 1);

	emit-flag-n size (var r);
	emit-flag-z size (var r);
	cf <- return fCF;
	mov 1 cf rd;
	ov <- return fVF;
	nf <- return fNF;
	xorb 1 ov (var nf) (var cf);
	emit-flag-s;

	write uo.operand (var r)
end

val sem-bclr flag = do
#	sreg <- return (semantic-register-of SREG);

#	t <- mktemp;
#	mov sreg.size t (imm 1);
#	shl sreg.size t (var t) flag;
#	xorb sreg.size t (var t) (imm 255);

  mov 1 (f-at flag) (imm 0)

#	andb sreg.size sreg (var t);
end

val sem-bld bo = do
  rd <- rval Unsigned bo.first;
	b <- return (rval-uint bo.second);
  size <- return (sizeof bo.first);

  tf <- return fTF;
#	a <- mktemp;
#	movzx size a 1 tf;
#	shl size a (var a) b
#
#	b <- mktemp;
#	mov size b (imm -1);

  t <- mktemp;
	mov size t rd;

  mov 1 (at-offset t b) (var tf);
	
	write bo.first (var t)
end

val sem-br uo sc flag = do
  k <- rval Signed uo.operand;

  cond <- sc (var (f-at flag));

	pc <- ip-get;
	
	tgt-t <- mktemp;
	add pc.size tgt-t (var pc) k;
	add pc.size tgt-t (var tgt-t) (imm 1);

  tgt-f <- mktemp;
	add pc.size tgt-f (var pc) (imm 1);

	cbranch cond (address pc.size (var tgt-t)) (address pc.size (var tgt-f))
end

val sem-brbc uo flag = sem-br uo /not flag
val sem-brbs uo flag = sem-br uo /d flag

val sem-break = return void

val sem-bset flag = do
	sreg <- return (semantic-register-of SREG);
  mov 1 (sem-reg-offset sreg flag) (imm 1)
end

val sem-bst bo = do
  rd <- rval Unsigned bo.first;
	b <- return (rval-uint bo.second);
  size <- return (sizeof bo.first);

	t <- mktemp;
	mov size t rd;

  tf <- return fTF;
	mov 1 tf (var (at-offset t b))
end

val sem-call uo = do
  k <- rval Unsigned uo.operand;

  pc <- ip-get;
	t <- mktemp;
	add pc.size t (var pc) (imm 2);

	ps-push pc.size (var t);

	call (address pc.size k)
end

val sem-cbi bo = do
  return void
end

val ps-push size x = do
  sp <- return (semantic-register-of SP);
	store (address sp.size (var sp)) (lin size x);
	sub sp.size sp (var sp) (imm (divb size 8))
end

val ps-pop size x = do
  sp <- return (semantic-register-of SP);
	add sp.size sp (var sp) (imm (divb size 8));
	load size x sp.size (var sp)
end

val sem-undef-binop bo = do
return void
end

val sem-undef-unop uo = do
return void
end

val sem-unknown = do
return void
end

val emit-flag-add-c sz rd r = do
  cf <- return fCF;
  cmpltu sz cf r rd
end

val emit-flag-add-h sz rd r = do
  cf <- return fCF;
  cmpltu (divb sz 2) cf r rd
end

val emit-flag-adc-c sz rd r = do
  cf <- return fCF;
	_if (/d (var cf)) _then
    cmpleu sz cf r rd
	_else
    cmpltu sz cf r rd
end

val emit-flag-adc-h sz rd r = do
  cf <- return fCF;
  hf <- return fHF;
	_if (/d (var cf)) _then
    cmpleu (divb sz 2) hf r rd
	_else
    cmpltu (divb sz 2) hf r rd
end

val emit-flag-add-adc-v sz rd rr r = do
  ov <- return fVF;
	
	t1 <- mktemp;
	t2 <- mktemp;
	t3 <- mktemp;

  xorb sz t1 r rd;
  xorb sz t2 r rr;
  andb sz t3 (var t1) (var t2);
  cmplts sz ov (var t3) (imm 0)
end

val emit-flag-n sz r = do
  nf <- return fNF;

	cmplts sz nf r (imm 0)
end

val emit-flag-z sz r = do
  zf <- return fZF;

	cmpeq sz zf r (imm 0)
end

val emit-flag-s = do
  nf <- return fNF;
  ov <- return fVF;
  sf <- return fSF;

	xorb 1 sf (var nf) (var ov)
end

type signedness =
   Signed
 | Unsigned

val sizeof x =
  case x of
	   REG r: 8
	 | REGHL r: 16
	 | IOREG i: 8
	 | IMM imm: case imm of
	      IMM3 i: 3
	    | IMM4 i: 4
	    | IMM6 i: 6
	    | IMM7 i: 7
	    | IMM8 i: 8
	    | IMM12 i: 12
	    | IMM16 i: 16
	    | IMM22 i: 22
		 end
	 | OPSE o: sizeof o.op
	 | OPDI o: sizeof o.op
  end

val write to from =
  case to of
	   REG r: mov (sizeof to) (semantic-register-of r) from
	 | REGHL r: mov (sizeof to) (@{size=16}(semantic-register-of r.regl)) from
	 | IOREG i: mov (sizeof to) (semantic-register-of i) from
  end

val write-mem size ao v = do
  addr <- rval Unsigned ao;
	store {size=size, address=addr} v
end

val rval sn x = let
  val from-vec sn vec =
	  case sn of
	     Signed: SEM_LIN_IMM {const=sx vec}
	   | Unsigned: SEM_LIN_IMM {const=zx vec}
		end

	val from-imm sn imm =
	  case imm of
	     IMM3 i: from-vec sn i
	   | IMM4 i: from-vec sn i
	   | IMM6 i: from-vec sn i
	   | IMM7 i: from-vec sn i
	   | IMM8 i: from-vec sn i
	   | IMM12 i: from-vec sn i
	   | IMM16 i: from-vec sn i
	   | IMM22 i: from-vec sn i
		end
in
  case x of
	   REG r: return (var (semantic-register-of r))
	 | REGHL r: return (var (@{size=16}(semantic-register-of r.regl)))
	 | IOREG i: return (var (semantic-register-of i))
	 | IMM i: return (from-imm sn i)
	 | OPSE o: case o.se of
	      NONE: rval sn o.op
		  | _: do
	        t <- mktemp;
		      orval <- rval sn o.op;
		      size <- return (sizeof o.op);
		      case o.se of
		         DECR: sub size t orval (imm 1)
		       | _: mov size t orval
		      end;
		      write o.op (var t);
		      case o.se of
		         INCR: add size t orval (imm 1)
		       | _: return void
		      end;
		      return (var t)
	      end end
		| OPDI o: return (SEM_LIN_ADD {opnd1=rval sn o.op, opnd2=from-imm sn o.imm})
	end
end

val rval-uint x =
  case x of
	   IMM imm: case imm of
	      IMM3 i: zx i
	    | IMM4 i: zx i
	    | IMM6 i: zx i
	    | IMM7 i: zx i
	    | IMM8 i: zx i
	    | IMM12 i: zx i
	    | IMM16 i: zx i
	    | IMM22 i: zx i
		 end
	end

val semantics insn =
 case insn of
    ADC x: sem-adc x
  | ADD x: sem-add x
  | ADIW x: sem-adiw x
  | AND x: sem-and-andi x
  | ANDI x: sem-and-andi x
  | ASR x: sem-asr x
  | BLD x: sem-bld x
  | BRCC x: sem-brbc x 0
  | BRCS x: sem-brbs x 0
  | BREAK: sem-break
  | BREQ x: sem-brbs x 1
  | BRGE x: sem-brbc x 4
  | BRHC x: sem-brbc x 5
  | BRHS x: sem-brbs x 5
  | BRID x: sem-brbc x 7
  | BRIE x: sem-brbs x 7
  | BRLT x: sem-brbs x 4
  | BRMI x: sem-brbs x 2
  | BRNE x: sem-brbc x 1
  | BRPL x: sem-brbc x 2
  | BRTC x: sem-brbc x 6
  | BRTS x: sem-brbs x 6
  | BRVC x: sem-brbc x 3
  | BRVS x: sem-brbs x 3
#  | BSET x: sem-undef-unop x
  | BST x: sem-bst x
  | CALL x: sem-call x
  | CBI x: sem-undef-binop x
  | CBR x: sem-undef-binop x
  | CLC: sem-bclr 0
  | CLH: sem-bclr 5
  | CLI: sem-bclr 7
  | CLN: sem-bclr 2
  | CLR x: sem-undef-unop x
  | CLS: sem-bclr 4
  | CLT: sem-bclr 6
  | CLV: sem-bclr 3
  | CLZ: sem-bclr 1
  | COM x: sem-undef-unop x
  | CP x: sem-undef-binop x
  | CPC x: sem-undef-binop x
  | CPI x: sem-undef-binop x
  | CPSE x: sem-undef-binop x
  | DEC x: sem-undef-unop x
  | DES x: sem-undef-unop x
  | EICALL: sem-unknown
  | EIJMP: sem-unknown
  | ELPM x: sem-undef-binop x
  | EOR x: sem-undef-binop x
  | FMUL x: sem-undef-binop x
  | FMULS x: sem-undef-binop x
  | FMULSU x: sem-undef-binop x
  | ICALL: sem-unknown
  | IJMP: sem-unknown
  | IN x: sem-undef-binop x
  | INC x: sem-undef-unop x
  | JMP x: sem-undef-unop x
  | LAC x: sem-undef-binop x
  | LAS x: sem-undef-binop x
  | LAT x: sem-undef-binop x
  | LD x: sem-undef-binop x
  | LDI x: sem-undef-binop x
  | LDS x: sem-undef-binop x
  | LPM x: sem-undef-binop x
  | LSL x: sem-undef-unop x
  | LSR x: sem-undef-unop x
  | MOV x: sem-undef-binop x
  | MOVW x: sem-undef-binop x
  | MUL x: sem-undef-binop x
  | MULS x: sem-undef-binop x
  | MULSU x: sem-undef-binop x
  | NEG x: sem-undef-unop x
  | NOP: sem-unknown
  | OR x: sem-undef-binop x
  | ORI x: sem-undef-binop x
  | OUT x: sem-undef-binop x
  | POP x: sem-undef-unop x
  | PUSH x: sem-undef-unop x
  | RCALL x: sem-undef-unop x
  | RET: sem-unknown
  | RETI: sem-unknown
  | RJMP x: sem-undef-unop x
  | ROL x: sem-undef-unop x
  | ROR x: sem-undef-unop x
  | SBC x: sem-undef-binop x
  | SBCI x: sem-undef-binop x
  | SBI x: sem-undef-binop x
  | SBIC x: sem-undef-binop x
  | SBIS x: sem-undef-binop x
  | SBIW x: sem-undef-binop x
  | SBR x: sem-undef-binop x
  | SBRC x: sem-undef-binop x
  | SBRS x: sem-undef-binop x
  | SEC: sem-bset 0
  | SEH: sem-bset 5
  | SEI: sem-bset 7
  | SEN: sem-bset 2
  | SES: sem-bset 4
  | SET: sem-bset 6
  | SEV: sem-bset 3
  | SEZ: sem-bset 1
  | SLEEP: sem-unknown
  | SPM x: sem-undef-unop x
  | ST x: sem-undef-binop x
  | STS x: sem-undef-binop x
  | SUB x: sem-undef-binop x
  | SUBI x: sem-undef-binop x
  | SWAP x: sem-undef-unop x
  | TST x: sem-undef-unop x
  | WDR: sem-unknown
  | XCH x: sem-undef-binop x
end

val translate insn = do
  update@{stack=SEM_NIL,tmp=0,lab=0,mode64='1'};
#case 0 of 1: return 0 end;
  semantics insn;
  stack <- query $stack;
  return (rreil-stmts-rev stack)
end
