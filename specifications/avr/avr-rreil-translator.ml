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

val sem-bitwise bw bo = do
  rd <- rval Unsigned bo.first;
	rr <- rval Unsigned bo.second;
  size <- return (sizeof bo.first);

	r <- mktemp;
	bw size r rd rr;

	ov <- return fVF;
	mov 1 ov (imm 0);
	emit-flag-n size (var r);
	emit-flag-z size (var r);
	emit-flag-s;

	write bo.first (var r)
end

val sem-and-andi bo = sem-bitwise andb bo
val sem-eor bo = sem-bitwise xorb bo
val sem-or-ori bo = sem-bitwise orb bo

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

	cbranch-rel cond k
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

val sem-write-bit bit bo = do
  a <- rval Unsigned bo.first;
	b <- return (rval-uint bo.second);
  size <- return (sizeof bo.first);

	t <- mktemp;
	mov size t a;

	mov 1 (at-offset t b) (imm bit);

	write bo.first (var t)
end

val sem-cbi bo = sem-write-bit 0 bo

val sem-com uo = do
  rd <- rval Unsigned uo.operand;
	size <- return (sizeof uo.operand);

	t <- mktemp;
	xorb size t rd (imm (0-1));

	ov <- return fVF;
	mov 1 ov (imm 0);
	emit-flag-n size (var t);
	emit-flag-z size (var t);
	cf <- return fCF;
	mov 1 cf (imm 1);
	emit-flag-s;

	write uo.operand (var t)
end

val sem-cp-cpi bo = sem-sub '0' bo

val sem-cpc bo = sem-sub-carry '0' bo

val sem-cpse to = do
  rd <- rval Unsigned to.first;
  rr <- rval Unsigned to.second;
  size <- return (sizeof to.first);
  n <- return (rval-uint to.third);

  cond <- /eq size rd rr;

  cbranch-rel cond (imm n)
end

val sem-dec uo = do
  rd <- rval Unsigned uo.operand;
	sb <- return (imm 1);
  size <- return (sizeof uo.operand);
  
	r <- mktemp;
	sub size r rd sb;

	emit-flag-n size (var r);
	ov <- return fVF;
	cmpeq size ov rd (imm 0x80);
	emit-flag-z size (var r);
	emit-flag-s;

	write uo.operand (var r)
end

val sem-des uo = do
  r0 <- return (semantic-register-of R0);
  undef r0.size r0;
  r1 <- return (semantic-register-of R1);
  undef r1.size r1;
  r2 <- return (semantic-register-of R2);
  undef r2.size r2;
  r3 <- return (semantic-register-of R3);
  undef r3.size r3;
  r4 <- return (semantic-register-of R4);
  undef r4.size r4;
  r5 <- return (semantic-register-of R5);
  undef r5.size r5;
  r6 <- return (semantic-register-of R6);
  undef r6.size r6;
  r7 <- return (semantic-register-of R7);
  undef r7.size r7;
  r8 <- return (semantic-register-of R8);
  undef r8.size r8;
  r9 <- return (semantic-register-of R9);
  undef r9.size r9;
  r10 <- return (semantic-register-of R10);
  undef r10.size r10;
  r11 <- return (semantic-register-of R11);
  undef r11.size r11;
  r12 <- return (semantic-register-of R12);
  undef r12.size r12;
  r13 <- return (semantic-register-of R13);
  undef r13.size r13;
  r14 <- return (semantic-register-of R14);
  undef r14.size r14;
  r15 <- return (semantic-register-of R15);
  undef r15.size r15
end

val sem-eicall = do
  z <- return (semantic-comp-register-of rZ);
	eind <- return (semantic-register-of EIND);

	t <- mktemp;
	mov z.size t (var z);
	mov eind.size (at-offset t z.size) (var eind);

	pc <- ip-get;
  addr-sz <- return pc.size;
	npc <- mktemp;
	add pc.size npc (var pc) (imm 1);

	ps-push addr-sz (var npc);
	call (address addr-sz (var t))
end

val sem-eijmp = do
  z <- return (semantic-comp-register-of rZ);
	eind <- return (semantic-register-of EIND);

	t <- mktemp;
	mov z.size t (var z);
	mov eind.size (at-offset t z.size) (var eind);

  addr-sz <- return (semantic-register-of PC).size;
	jump (address addr-sz (var t))
end

val sem-elpm bo = do
  size <- return (sizeof bo.first);
	addr <- rval Unsigned bo.second;
	addr-sz <- return (sizeof bo.second);

	pm <- pm-get;
	pmptr <- mktemp;
  add addr-sz pmptr addr (var pm);

  t <- mktemp;
	load size t addr-sz (var pmptr);

	write bo.first (var t)
end

val sem-fmul-fmuls-fmulsu exa exb bo = do
  rd <- rval Unsigned bo.first;
  rr <- rval Unsigned bo.second;
	size <- return (sizeof bo.first);

  rde <- mktemp;
	exa (2*size) rde size rd;
  rre <- mktemp;
	exb (2*size) rre size rr;

	r <- return (@{size=16}(semantic-register-of R0));
	mul (2*size) r (var rde) (var rre);

	cf <- return fCF;
	cmplts (2*size) cf (var r) (imm 0);
	emit-flag-z (2*size) (var r);

	shl (2*size) r (var r) (imm 1)
end

val sem-fmul bo = sem-fmul-fmuls-fmulsu movzx movzx bo
val sem-fmuls bo = sem-fmul-fmuls-fmulsu movsx movsx bo
val sem-fmulsu bo = sem-fmul-fmuls-fmulsu movsx movzx bo

val sem-icall = do
  z <- return (semantic-comp-register-of rZ);
  pc <- return (semantic-register-of PC);

	t <- mktemp;
	mov z.size t (var z);

	if pc.size > z.size then
	  mov (pc.size - z.size) (at-offset t z.size) (imm 0)
	else
	  return void
	;

  q <- mktemp;
	add pc.size q (var pc) (imm 1);
	ps-push pc.size (var q);

	call (address pc.size (var t))
end

val sem-ijmp = do
  z <- return (semantic-comp-register-of rZ);
  pc <- return (semantic-register-of PC);

	t <- mktemp;
	mov z.size t (var z);

	if pc.size > z.size then
	  mov (pc.size - z.size) (at-offset t z.size) (imm 0)
	else
	  return void
	;

	jump (address pc.size (var t))
end

val sem-in bo = do
  io <- rval Unsigned bo.second;
	write bo.first io
end

val sem-inc uo = do
  rd <- rval Unsigned uo.operand;
	sb <- return (imm 1);
  size <- return (sizeof uo.operand);
  
	r <- mktemp;
	add size r rd sb;

	emit-flag-n size (var r);
	ov <- return fVF;
	cmpeq size ov rd (imm 0x7f);
	emit-flag-z size (var r);
	emit-flag-s;

	write uo.operand (var r)
end

val sem-jmp uo = do
  k <- rval Unsigned uo.operand;
	pc <- return (semantic-register-of PC);

	jump (address pc.size k)
end

val sem-lac bo = do
  z <- rval Unsigned bo.first;
	ptrsz <- return (sizeof bo.first);
	rd <- rval Unsigned bo.second;
  size <- return (sizeof bo.second);

	t <- mktemp;
	xorb size t rd (imm (0-1));

	zv <- mktemp;
	load size zv ptrsz z;

	andb size t (var t) (var zv);

	store size (address ptrsz z) (var t)
end

val sem-las-lat bw bo = do
  z <- rval Unsigned bo.first;
	ptrsz <- return (sizeof bo.first);
	rd <- rval Unsigned bo.second;
  size <- return (sizeof bo.second);

	zv <- mktemp;
	load size zv ptrsz z;

  r <- mktemp;
	bw size r (var zv) rd;

	store size (address ptrsz z) (var r);
	write bo.second (var zv)
end

val sem-las bo = sem-las-lat orb bo
val sem-lat bo = sem-las-lat xorb bo

val sem-ld-ldd-lds bo = do
  #Todo: undefined combinations

	size <- return (sizeof bo.first);
	ptr <- rval Unsigned bo.second;
	ptrsz <- return (sizeof bo.second);

	t <- mktemp;
	load size t ptrsz ptr;

	write bo.first (var t)
end

val sem-ldi bo = do
  k <- rval Unsigned bo.second;
	size <- return (sizeof bo.first);

	write bo.first k
end

val sem-lpm bo = do
  #Todo: undefined combinations

	size <- return (sizeof bo.first);
	ptr <- rval Unsigned bo.second;
	ptrsz <- return (sizeof bo.second);

	pm <- pm-get;
	pmptr <- mktemp;
	#if pm.size > ptrsz then do
  #  movzx pm.size pmptr ptrsz ptr;
  #  add pm.size pmptr (var pmptr) (var pm)
  #end else
  #  add ptrsz pmptr ptr (var pm)
  #;
  add ptrsz pmptr ptr (var pm);

	t <- mktemp;
	load size t ptrsz (var pmptr);

	write bo.first (var t)
end

val sem-lsr uo = do
  rd <- rval Unsigned uo.operand;
  size <- return (sizeof uo.operand);

	r <- mktemp;
	shr size r rd (imm 1);

	nf <- return fNF;
	mov 1 nf (imm 0);
	emit-flag-z size (var r);
	cf <- return fCF;
	mov 1 cf rd;
	ov <- return fVF;
	mov 1 ov (var cf);
	emit-flag-s;

	write uo.operand (var r)
end

val sem-mov-movw bo = do
  rr <- rval Unsigned bo.second;

  write bo.first rr
end

val sem-mul-muls-mulsu exa exb bo = do
  rd <- rval Unsigned bo.first;
  rr <- rval Unsigned bo.second;
	size <- return (sizeof bo.first);

  rde <- mktemp;
	exa (2*size) rde size rd;
  rre <- mktemp;
	exb (2*size) rre size rr;

	r <- return (@{size=16}(semantic-register-of R0));
	mul (2*size) r (var rde) (var rre);

	cf <- return fCF;
	cmplts (2*size) cf (var r) (imm 0);
	emit-flag-z (2*size) (var r)
end

val sem-neg uo = do
  rd <- rval Unsigned uo.operand;
	size <- return (sizeof uo.operand);
  mu <- return (imm 0);

  r <- mktemp;
  sub size r mu rd;

  emit-flag-sub-h size rd mu;
	emit-flag-n size (var r);
	emit-flag-sub-sbc-v size rd mu;
	emit-flag-z size (var r);
	emit-flag-sub-c size rd mu;
	emit-flag-s;

  write uo.operand (var r)
end

val sem-nop = return void

val sem-mul bo = sem-mul-muls-mulsu movzx movzx bo
val sem-muls bo = sem-mul-muls-mulsu movsx movsx bo
val sem-mulsu bo = sem-mul-muls-mulsu movsx movzx bo

val sem-out bo = do
  rr <- rval Unsigned bo.second;
	write bo.first rr
end

val sem-pop uo = do
	size <- return (sizeof uo.operand);

  t <- mktemp;
  ps-pop size t;

  write uo.operand (var t)
end

val sem-push uo = do
  rr <- rval Unsigned uo.operand;
	size <- return (sizeof uo.operand);

  ps-push size rr
end

val sem-rcall uo = do
  k <- rval Signed uo.operand;
  
  pc <- ip-get;

  t <- mktemp;
  add pc.size t (var pc) k;
  add pc.size t (var t) (imm 1);

  ps-push pc.size (var pc);

  call (address pc.size (var t))
end

val sem-ret = do
  pc <- ip-get;

  t <- mktemp;
  ps-pop pc.size t;

  ret (address pc.size (var t))
end

val sem-reti = do
  pc <- ip-get;

  t <- mktemp;
  ps-pop pc.size t;
  
  iv <- return fIF;
  mov 1 iv (imm 1);

  ret (address pc.size (var t))
end

val sem-rjmp uo = do
  k <- rval Signed uo.operand;
  
  pc <- ip-get;

  t <- mktemp;
  add pc.size t (var pc) k;
  add pc.size t (var t) (imm 1);

  jump (address pc.size (var t))
end

val sem-ror uo = do
  rd <- rval Unsigned uo.operand;
  size <- return (sizeof uo.operand);

  nc <- mktemp;
  mov 1 nc rd;

  t <- mktemp;
  shr size t rd (imm 1);

  cf <- return fCF;
  mov 1 (at-offset t (size - 1)) (var cf);
  mov 1 cf (var nc);

  emit-flag-n size (var t);
  emit-flag-z size (var t);
  ov <- return fVF;
  nf <- return fNF;
  xorb 1 ov (var nf) (var cf);

  write uo.operand (var t)
end

val sem-sub-carry wb bo = do
  rd <- rval Unsigned bo.first;
	rr <- rval Unsigned bo.second;
  size <- return (sizeof bo.first);

	r <- mktemp;
	sub size r rd rr;

  cf <- return fCF;
  cfe <- mktemp;
  movzx size cfe 1 (var cf);
  sub size r (var r) (var cfe);

  emit-flag-sbc-h size rd rr;
	emit-flag-n size (var r);
	emit-flag-sub-sbc-v size rd rr;
	emit-flag-z size (var r);
	emit-flag-sbc-c size rd rr;
	sf <- return fSF;
  cmplts size sf rd rr;

  if wb then
    write bo.first (var r)
  else
    return void
end

val sem-sbc-sbci bo = sem-sub-carry '1' bo

val sem-sub wb bo = do
  rd <- rval Unsigned bo.first;
	rr <- rval Unsigned bo.second;
  size <- return (sizeof bo.first);

	r <- mktemp;
	sub size r rd rr;

  emit-flag-sub-h size rd rr;
	emit-flag-n size (var r);
	emit-flag-sub-sbc-v size rd rr;
	emit-flag-z size (var r);
	emit-flag-sub-c size rd rr;
	sf <- return fSF;
  cmplts size sf rd rr;

  if wb then
    write bo.first (var r)
  else
    return void
end

val sem-sbi bo = sem-write-bit 1 bo

val sem-sbirc-sbirs sc to = do
  a <- rval Unsigned to.first;
  size <- return (sizeof to.first);
  b <- return (rval-uint to.second);
  n <- return (rval-uint to.third);

  t <- mktemp;
  mov size t a;

  cond <- sc (var (at-offset t b));

  cbranch-rel cond (imm n)
end

val sem-sbic-sbrc to = sem-sbirc-sbirs /not to
val sem-sbis-sbrs to = sem-sbirc-sbirs /d to

val sem-sbiw bo = do
  rd <- rval Unsigned bo.first;
	rr <- rval Unsigned bo.second;
  size <- return (sizeof bo.first);

	r <- mktemp;
	sub size r rd rr;

	emit-flag-n size (var r);
	emit-flag-sub-sbc-v size rd rr;
	emit-flag-z size (var r);
	emit-flag-sub-c size rd rr;
	emit-flag-s;

  write bo.first (var r)
end

val sem-sleep = return void

val sem-spm uo = do
  ptr <- rval Unsigned uo.operand;
  ptrsz <- return (sizeof uo.operand);
  r <- return (@{size=16}(semantic-register-of R0));

  pm <- pm-get;
	pmptr <- mktemp;
  add ptrsz pmptr ptr (var pm);

  store r.size (address ptrsz (var pmptr)) (var r)
end

val sem-st-std-sts bo = do
  ptr <- rval Unsigned bo.first;
  ptrsz <- return (sizeof bo.first);
  rr <- rval Unsigned bo.second;
  size <- return (sizeof bo.second);

  store size (address ptrsz ptr) rr  
end

val sem-sub-subi bo = sem-sub '1' bo

val sem-swap uo = do
  rd <- rval Unsigned uo.operand;
  size <- return (sizeof uo.operand);
  csz <- return (/z size 2);

  p <- mktemp;
  mov size p rd;

  r <- mktemp;
  mov csz r (var (at-offset p csz));
  mov csz (at-offset r csz) (var p);

  write uo.operand (var r)
end

val sem-wdr = do
  return void
end

val sem-xch bo = do
  z <- rval Unsigned bo.first;
  zsz <- return (sizeof bo.first);
  rd <- rval Unsigned bo.second;
  size <- return (sizeof bo.second);

  t <- mktemp;
  load size t zsz z;

  store size (address zsz z) rd;

  write bo.second (var t)
end

val ps-push size x = do
  sp <- return (semantic-register-of SP);
	store size (address sp.size (var sp)) x;
	sub sp.size sp (var sp) (imm (/p size 8))
end

val ps-pop size x = do
  sp <- return (semantic-register-of SP);
	add sp.size sp (var sp) (imm (/p size 8));
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

val emit-flag-sub-c sz rd rr = do
  cf <- return fCF;
  cmpltu sz cf rd rr
end

val emit-flag-add-h sz rd r = do
  hf <- return fHF;
  cmpltu (/m sz 2) hf r rd
end

val emit-flag-sub-h sz rd rr = do
  hf <- return fHF;
  cmpltu (/m sz 2) hf rd rr
end

val emit-flag-adc-c sz rd r = do
  cf <- return fCF;
	_if (/d (var cf)) _then
    cmpleu sz cf r rd
	_else
    cmpltu sz cf r rd
end

val emit-flag-sbc-c sz rd rr = do
  cf <- return fCF;
	_if (/d (var cf)) _then
    cmpleu sz cf rd rr
	_else
    cmpltu sz cf rd rr
end

val emit-flag-adc-h sz rd r = do
  cf <- return fCF;
  hf <- return fHF;
	_if (/d (var cf)) _then
    cmpleu (/m sz 2) hf r rd
	_else
    cmpltu (/m sz 2) hf r rd
end

val emit-flag-sbc-h sz rd rr = do
  cf <- return fCF;
  hf <- return fHF;
	_if (/d (var cf)) _then
    cmpleu (/m sz 2) hf rd rr
	_else
    cmpltu (/m sz 2) hf rd rr
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

val emit-flag-sub-sbc-v sz rd rr = do #requires n
  ov <- return fVF;

	lts <- mktemp;
	cmplts sz lts rd rr;
  nf <- return fNF;

  xorb 1 ov (var lts) (var nf)
end

val emit-flag-n sz r = do
  nf <- return fNF;

	cmplts sz nf r (imm 0)
end

val emit-flag-z sz r = do
  zf <- return fZF;

	cmpeq sz zf r (imm 0)
end

val emit-flag-s = do #requires n, v
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
	 | REGIHL r: 24
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
	    | IMMi i: 64
		 end
	 | OPSE o: sizeof o.op
	 | OPDI o: sizeof o.op
  end

val write to from =
  case to of
	   REG r: mov (sizeof to) (semantic-register-of r) from
	 | REGHL r: mov (sizeof to) (@{size=16}(semantic-register-of r.regl)) from
	 | REGIHL r: do
	     t <- mktemp;
			 mov (sizeof to) t from;
		   mov 16 (@{size=16}(semantic-register-of r.reghl.regl)) (var t);
			 mov 8 (semantic-register-of r.regi) (var (at-offset t 16))
	   end
	 | IOREG i: mov (sizeof to) (semantic-register-of i) from
  end

#val write-mem size ao v = do
#  addr <- rval Unsigned ao;
#	store {size=size, address=addr} v
#end

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
	   | IMMi i: SEM_LIN_IMM {const=i}
		end
in
  case x of
	   REG r: return (var (semantic-register-of r))
	 | REGHL r: return (var (@{size=16}(semantic-register-of r.regl)))
	 | REGIHL r: do
		   high <- return (semantic-register-of r.regi);
			 low <- return (@{size=16}(semantic-register-of r.reghl.regl));

			 t <- mktemp;
			 mov low.size t (var low);
			 mov high.size (at-offset t low.size) (var high);

			 return (var t)
	   end
	 | IOREG i: return (var (semantic-register-of i))
	 | IMM i: return (from-imm sn i)
	 | OPSE o: case o.se of
	      NONE: rval sn o.op
		  | _: do
		      orval <- rval sn o.op;
		      size <- return (sizeof o.op);
	        t <- mktemp;
		      j <- case o.se of
		         DECR: do
						   sub size t orval (imm 1);
							 return t
						 end
		       | INCR a: do
					     j <- mktemp;
							 mov size j orval;
						   add size t orval (imm a);
							 return j
						 end
		       | _: return t
		      end;
		      write o.op (var t);
		      return (var j)
	      end end
		| OPDI o: do
		  opnd1 <- rval sn o.op;
		  return (SEM_LIN_ADD {opnd1=opnd1, opnd2=from-imm sn o.imm})
		end
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
	    | IMMi i: i
		 end
	end

val cbranch-rel cond k = do
	pc <- ip-get;
	
	tgt-t <- mktemp;
	add pc.size tgt-t (var pc) k;
	add pc.size tgt-t (var tgt-t) (imm 1);

  tgt-f <- mktemp;
	add pc.size tgt-f (var pc) (imm 1);

	cbranch cond (address pc.size (var tgt-t)) (address pc.size (var tgt-f))
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
  | CBI x: sem-cbi x
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
  | COM x: sem-com x
  | CP x: sem-cp-cpi x
  | CPC x: sem-cpc x
  | CPI x: sem-cp-cpi x
  | CPSE x: sem-cpse x
  | DEC x: sem-dec x
  | DES x: sem-des x
  | EICALL: sem-eicall
  | EIJMP: sem-eijmp
  | ELPM x: sem-elpm x
  | EOR x: sem-eor x
  | FMUL x: sem-fmul x
  | FMULS x: sem-fmuls x
  | FMULSU x: sem-fmulsu x
  | ICALL: sem-icall
  | IJMP: sem-ijmp
  | IN x: sem-in x
  | INC x: sem-inc x
  | JMP x: sem-jmp x
  | LAC x: sem-lac x
  | LAS x: sem-las x
  | LAT x: sem-lat x
  | LD x: sem-ld-ldd-lds x
  | LDI x: sem-ldi x
  | LDS x: sem-ld-ldd-lds x
  | LPM x: sem-lpm x
#  | LSL x: sem-undef-unop x
  | LSR x: sem-lsr x
  | MOV x: sem-mov-movw x
  | MOVW x: sem-mov-movw x
  | MUL x: sem-mul x
  | MULS x: sem-muls x
  | MULSU x: sem-mulsu x
  | NEG x: sem-neg x
  | NOP: sem-nop
  | OR x: sem-or-ori x
  | ORI x: sem-or-ori x
  | OUT x: sem-out x
  | POP x: sem-pop x
  | PUSH x: sem-push x
  | RCALL x: sem-rcall x
  | RET: sem-ret
  | RETI: sem-reti
  | RJMP x: sem-rjmp x
#  | ROL x: sem-undef-unop x
  | ROR x: sem-ror x
  | SBC x: sem-sbc-sbci x
  | SBCI x: sem-sbc-sbci x
  | SBI x: sem-sbi x
  | SBIC x: sem-sbic-sbrc x
  | SBIS x: sem-sbis-sbrs x
  | SBIW x: sem-sbiw x
#  | SBR x: sem-undef-binop x
  | SBRC x: sem-sbic-sbrc x
  | SBRS x: sem-sbis-sbrs x
  | SEC: sem-bset 0
  | SEH: sem-bset 5
  | SEI: sem-bset 7
  | SEN: sem-bset 2
  | SES: sem-bset 4
  | SET: sem-bset 6
  | SEV: sem-bset 3
  | SEZ: sem-bset 1
  | SLEEP: sem-sleep
  | SPM x: sem-spm x
  | ST x: sem-st-std-sts x
  | STS x: sem-st-std-sts x
  | SUB x: sem-sub-subi x
  | SUBI x: sem-sub-subi x
  | SWAP x: sem-swap x
#  | TST x: sem-undef-unop x
  | WDR: sem-wdr
  | XCH x: sem-xch x
end

val translate-avr insn = semantics insn

val translate insn = do
  update@{stack=SEM_NIL,tmp=0,lab=0};
  
  translate-avr insn;
  
  stack <- query $stack;
  return (rreil-stmts-rev stack)
end

val translate-block-single insn = do
   ic <- query $ins_count;
   update@{tmp=0,ins_count=ic+1};
   
   translate-avr insn
end

val relative-next stmts = let
  val is_sem_ip x = case x of
     Sem_PC: '1'
   | _: '0'
  end
in
  relative-next-generic is_sem_ip stmts
end
