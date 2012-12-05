## M>>

val sem-maskmov x size = do
  src <- read size x.opnd1;
  mask <- read size x.opnd2;
  
  src-temp <- mktemp;
  mov size src-temp src;

  mask-temp <- mktemp;
  mov size mask-temp mask;

  byte-size <- return 8;
  let
    val m i = do
      _if (/d (var (at-offset mask-temp ((i + 1)*8 - 1)))) _then do
        dst <- lval-offset byte-size x.opnd3 i;
        write byte-size dst (var (at-offset src-temp (i*8)))
      end
    end
  in
    vector-apply size byte-size m
  end
end

val sem-maskmovdqu-vmaskmovdqu x = sem-maskmov x 128

val sem-maskmovq x = sem-maskmov x 64

val sem-mov avx-encoded x = do
  sz <- sizeof1 x.opnd1;
  a <- lval sz x.opnd1;
  b <- read sz x.opnd2;
  write-extend avx-encoded sz a b
end

#val sem-movap x = do
#  sz <- sizeof1 x.opnd1;
#  dst <- lval sz x.opnd1;
#  src <- read sz x.opnd2;
#
#  temp <- mktemp;
#  mov sz temp src;
#
#  write sz dst (var temp)
#end
#
#val sem-vmovap x = do
#  x <- case x of VA2 x: return x end;
#
#  sz <- sizeof1 x.opnd1;
#  dst <- lval sz x.opnd1;
#  src <- read sz x.opnd2;
#
#  if sz === 128 then
#    do
#      dst-upper <- lval-upper sz x.opnd1;
#      write sz dst-upper (imm 0)
#    end
#  else
#    return void
#  ;
#
#  temp <- mktemp;
#  mov sz temp src;
#  write sz dst (var temp)
#end

val sem-movbe x = do
  src <- read x.opnd-sz x.opnd2;
  dst <- lval x.opnd-sz x.opnd1;

  src-temp <- mktemp;
  mov x.opnd-sz src-temp src;

  dst-temp <- mktemp;

  limit <- return
    (case x.opnd-sz of
        16: 2
      | 32: 4
      | 64: 8
     end)
  ;

  byte-size <- return 8;
  let
    val f i = do
      mov byte-size (at-offset dst-temp (i*8)) (var (at-offset src-temp ((limit - i - 1)*8)));

      if (i < (limit - 1)) then
        f (i + 1)
      else
        return void
    end
  in
    f 0
  end;

  write x.opnd-sz dst (var dst-temp)
end

#val sem-movd-movq-vmovd-vmovq x dst-size = do
#  src-size <- sizeof1 x.opnd2;
#  src <- read src-size x.opnd2;
#
#  dst <- lval dst-size x.opnd1;
#
#  temp <- mktemp;
#  mov dst-size temp (imm 0);
#  mov src-size temp src;
#
#  write dst-size dst (var temp)
#end
#
#val sem-movd-movq x = do
#  dst-size <- sizeof1 x.opnd1;
#  sem-movd-movq-vmovd-vmovq x dst-size
#end
#
#val sem-vmovd-vmovq x = do
#  dst-size <- 
#    case x.opnd1 of
#       MEM m: sizeof1 x.opnd1
#     | REG r: return 256
#    end
#  ;
#  sem-movd-movq-vmovd-vmovq x dst-size
#end
#
#val sem-mov-sse-avx x size out-size = do
#  src <- read size x.opnd2;
#  dst <- lval out-size x.opnd1;
#
#  temp <- mktemp;
#  movzx out-size temp size src;
#
#  write out-size dst (var temp)
#end
#
#val sem-mov-sse x = do
#  size <- sizeof1 x.opnd1;
#  sem-mov-sse-avx x size size
#end
#
#val sem-mov-avx x = do
#  size <- sizeof1 x.opnd1;
#  out-size <- return
#    (case x.opnd1 of
#        MEM m: size
#      | REG r: 256
#    end)
#  ;
#  sem-mov-sse-avx x size out-size
#end
#
#val sem-movdq2q x = do
#  size <- sizeof1 x.opnd1; #Important: Destination size!
#  src <- read size x.opnd2;
#  dst <- lval size x.opnd1;
#
#  write size dst src
#end

val sem-movs x = do
  sz <- sizeof1 x.opnd1;
  src <- read sz x.opnd2;
  dst <- lval sz x.opnd1;
  
  write sz dst src;

  reg0-sem <- return (semantic-register-of (read-addr-reg x.opnd1));
  reg1-sem <- return (semantic-register-of (read-addr-reg x.opnd2));

  direction-adjust x.addr-sz reg0-sem sz;
  direction-adjust x.addr-sz reg1-sem sz
end

val sem-movsx x = do
  sz-dst <- sizeof1 x.opnd1;
  sz-src <- sizeof1 x.opnd2;
  dst <- lval sz-dst x.opnd1;
  src <- read sz-src x.opnd2;

  temp <- mktemp;
  movsx sz-dst temp sz-src src;

  write sz-dst dst (var temp)
end

val sem-movzx clear-avx x = do
  sz-dst <- sizeof1 x.opnd1;
  sz-src <- sizeof1 x.opnd2;
  dst <- lval sz-dst x.opnd1;
  src <- read sz-src x.opnd2;

  temp <- mktemp;
  movzx sz-dst temp sz-src src;

  write-extend clear-avx sz-dst dst (var temp)
end

val sem-mul conv x = do
  sz <- sizeof1 x.opnd1;

  factor0-sem <- return (semantic-register-of (register-by-size low A sz));
  factor0 <- expand conv (var factor0-sem) sz (sz + sz);

  factor1 <- reads conv (sz + sz) x.opnd1;

  product <- mktemp;
  mul (sz + sz) product factor0 factor1;

  emit-mul-flags sz product;

  case sz of
     8: do
       ax <- return (semantic-register-of AX);
       mov sz ax (var product)
     end
    | _: move-combined sz (register-by-size low D sz) (register-by-size low A sz) product
#   | _: do
#       high <- return (semantic-register-of (register-by-size low D sz));
#       low <- return (semantic-register-of (register-by-size low A sz));
#
#       mov sz high (var (at-offset product sz));
#       mov sz low (var product)
#   end
  end
end

## N>>

val sem-neg x = do
  size <- sizeof1 x.opnd1;
  src <- read size x.opnd1;
  dst <- lval size x.opnd1;

  temp <- mktemp;
  sub size temp (imm 0) src;

  cf <- fCF;
  ov <- fOF;
  sf <- fSF;
  zf <- fZF;

  cmpneq size cf src (imm 0);

  src-temp <- mktemp;
  mov size src-temp src;
  cmpeq 1 ov (var (at-offset temp (size - 1))) (var (at-offset src-temp (size - 1)));
  cmplts size sf (var temp) (imm 0);

  emit-parity-flag (var temp);
  emit-arithmetic-adjust-flag size (var temp) (imm 0) src; #Todo: Correct?

  write size dst (var temp)
end

val sem-nop x = do
  return void
end

val sem-not x = do
  size <- sizeof1 x.opnd1;
  src <- read size x.opnd1;
  dst <- lval size x.opnd1;

  temp <- mktemp;
  xorb size temp src (imm (0-1));

  write size dst (var temp)
end

## O>>

val sem-or x = do
  sz <- sizeof2 x.opnd1 x.opnd2;
  dst <- lval sz x.opnd1;
  src0 <- read sz x.opnd1;
  src1 <- read sz x.opnd2;
  temp <- mktemp;
  orb sz temp src0 src1;

  ov <- fOF;
  mov 1 ov (imm 0);
  cf <- fCF;
  mov 1 cf (imm 0);
  sf <- fSF;
  cmplts sz sf (var temp) (imm 0);
  zf <- fZF;
  cmpeq sz zf (var temp) (imm 0);
  emit-parity-flag (var temp);
  af <- fAF;
  undef 1 af;

  write sz dst (var temp)
end

## P>>

val sem-pabs element-size x = do
  size <- sizeof1 x.opnd1;
  src <- read size x.opnd2;
  dst <- lval size x.opnd1;

  temp-src <- mktemp;
  mov size temp-src src;

  temp-dst <- mktemp;

  let
    val m i = do
      offset <- return (element-size*i);
      current-src <- return (at-offset temp-src offset);
      current-dst <- return (at-offset temp-dst offset);
      _if (/lts element-size (var current-src) (imm 0)) _then
        #xorb element-size current-dst (var current-src) (imm (0-1));
	#add element-size current-dst (var current-dst) (imm 1)
        sub element-size current-dst (imm 0) (var current-src)
      _else do
        mov element-size current-dst (var current-src)
      end
    end
  in
    vector-apply size element-size m
  end;

  write size dst (var temp-dst)
end

val ps-pop opnd-sz opnd = do
  stack-addr-sz <- runtime-stack-address-size;

  sp-reg <-
    if stack-addr-sz === 32 then
      return ESP
    else if stack-addr-sz === 64 then
      return RSP
    else
      return SP
  ;
  
  sp <- return (semantic-register-of sp-reg);
  sp-size <- sizeof1 (REG sp-reg);

  segmented-load opnd-sz opnd stack-addr-sz (var sp) (SEG_OVERRIDE SS);

  if stack-addr-sz === 32 then
    if opnd-sz === 32 then
      add sp-size sp (var sp) (imm 4)
    else
      add sp-size sp (var sp) (imm 2)
  else if stack-addr-sz === 64 then
    if opnd-sz === 64 then
      add sp-size sp (var sp) (imm 8)
    else
      add sp-size sp (var sp) (imm 2)
  else
    if opnd-sz === 16 then
      add sp-size sp (var sp) (imm 2)
    else
      add sp-size sp (var sp) (imm 4)

  #Todo: Special actions in protected mode
end

val sem-pop x = do
  dst <- lval x.opnd-sz x.opnd1;
  temp-dest <- mktemp;
  ps-pop x.opnd-sz temp-dest;
  write x.opnd-sz dst (var temp-dest)
end

val sem-popf x = do
  popped <- mktemp;
  ps-pop x.opnd-sz popped;

  move-to-rflags x.opnd-sz (var popped)
end

val ps-push opnd-sz opnd = do
  mode64 <- mode64?;
  stack-addr-sz <- runtime-stack-address-size;
  
  sp-reg <-
    if mode64 then
      return RSP
    else if stack-addr-sz === 32 then
      return ESP
    else
      return SP
  ;
  sp <- return (semantic-register-of sp-reg);

  if mode64 then
    if opnd-sz === 64 then
      sub sp.size sp (var sp) (imm 8)
    else
      sub sp.size sp (var sp) (imm 2)
  else
    if opnd-sz === 32 then
      sub sp.size sp (var sp) (imm 4)
    else
      sub sp.size sp (var sp) (imm 2)
  ;

  segmented-store (address sp.size (var sp)) (lin opnd-sz opnd) (SEG_OVERRIDE SS)

  #store (address sp.size (segment-add (var sp) segment)) (lin opnd-sz opnd)
end

val sem-push x = do
  src-size <- sizeof1 x.opnd1;
  src <- read src-size x.opnd1;

  temp <- mktemp;
  case x.opnd1 of
     REG r: 
       if segment-register? r then
         movzx x.opnd-sz temp src-size src
       else
         mov x.opnd-sz temp src
   | MEM m:
       mov x.opnd-sz temp src
   | IMM8 i:
       movsx x.opnd-sz temp src-size src
   | IMM16 i:
       mov x.opnd-sz temp src
   | IMM32 i:
       movsx x.opnd-sz temp src-size src
  end;

  ps-push x.opnd-sz (var temp)
end

val sem-pushf x = do
  mask <- return 0x0000000000fcffff;
  flags <- rflags;

  temp <- mktemp;
  andb flags.size temp (var flags) (imm mask);

  mode64 <- mode64?;
  size <- return (
    if mode64 then
      if x.opnd-sz === 16 then
        16
      else
        64
    else
      x.opnd-sz
  );

  ps-push size (var temp)
end

## Q>>
## R>>

val sem-rep-repe-repne size sem fc = do
  count-reg <- return (semantic-register-of (register-by-size low C size));

  cond-creg <- let
    val v = /neq size (var count-reg) (imm 0)
  in
    return v
  end;

  cond <- mktemp;
  c <- cond-creg;
  mov 1 cond c;
  _while (/d (var cond)) __ do
    sem;

    sub size count-reg (var count-reg) (imm 1);

    c <- /and cond-creg fc;
    mov 1 cond c
  end
end

val sem-rep size sem = sem-rep-repe-repne size sem (return (imm 1))

val sem-repe size sem = let
  val fc = do
    zf <- fZF;
    /not (var zf)
  end
in
  sem-rep-repe-repne size sem fc
end

val sem-repne size sem = let
  val fc = do
    zf <- fZF;
    /d (var zf)
  end
in
  sem-rep-repe-repne size sem fc
end

val sem-repe-repne-insn x sem =
  if x.rep then
    sem-repe x.addr-sz (sem x)
  else if x.repne then
    sem-repne x.addr-sz (sem x)
  else
    sem x

val sem-rep-insn x sem =
  if x.rep then
    sem-rep x.addr-sz (sem x)
  else
    sem x

val sem-ret x =
  case x of
     VA0 x:
       do
         sem-ret-without-operand x;
	 return void
       end
   | VA1 x:
       do
	 address <- sem-ret-without-operand x;
         release-from-stack x;
         ret address
       end
  end

val sem-ret-far x =
  case x of
     VA0 x:
       do
         sem-ret-far-without-operand x;
	 return void
       end
   | VA1 x:
       do
         address <- sem-ret-far-without-operand x;
         release-from-stack x;
         ret address
       end
  end

val pop-ip opnd-sz = do
  ip-sz <-
    if (opnd-sz === 64) then
      return 64
    else
      return 32
  ;

  temp-ip <- mktemp;
  ps-pop ip-sz temp-ip;
  mov (ip-sz - opnd-sz) (at-offset temp-ip opnd-sz) (imm 0);

  return (address opnd-sz (var temp-ip))
end

val sem-ret-without-operand x = do
  pop-ip x.opnd-sz
end

val sem-ret-far-without-operand x = do
  address <- pop-ip x.opnd-sz;

  temp-cs <- mktemp;
  ps-pop x.opnd-sz temp-cs;
  
  sec-reg <- return CS;
  sec-reg-sem <- return (semantic-register-of sec-reg);
  reg-size <- sizeof1 (REG sec-reg);

  mov reg-size sec-reg-sem (var temp-cs);

  return address
end

val release-from-stack x = do
  x-sz <- sizeof1 x.opnd1;
  src <- read x-sz x.opnd1;

  stack-addr-sz <- runtime-stack-address-size;

  sp-reg <-
    if stack-addr-sz === 32 then
      return ESP
    else if stack-addr-sz === 64 then
      return RSP
    else
      return SP
  ;

  sp <- return (semantic-register-of sp-reg);
  sp-size <- sizeof1 (REG sp-reg);

  src-ext <- mktemp;
  movzx sp-size src-ext x-sz src;

  add sp-size sp (var sp) (var src-ext)
end

## S>>

# v-

val sem-sahf x = do
  ah <- return (semantic-register-of AH);
  flags <- rflags;

  move-to-rflags ah.size (var ah)
end

val sem-sal-shl x = do
  sz <- sizeof1 x.opnd1;
  szOp2 <- sizeof1 x.opnd2;
  dst <- lval sz x.opnd1;
  src <- read sz x.opnd1;
  count <- read szOp2 x.opnd2;

  #count-mask <- const
  #   (case sz of
  #       8: 31
  #     | 16: 31
  #     | 32: 31
  #     | 64: 63
  #    end);
  #temp-count <- mktemp;
  #andb sz temp-count count count-mask;
 
  real-shift-count-size <-
    case sz of
       8: return 5
     | 16: return 5
     | 32: return 5
     | 64: return 6
    end
  ;
  temp-count <- mktemp;
  mov real-shift-count-size temp-count count;
  mov (sz - real-shift-count-size) (at-offset temp-count real-shift-count-size) (imm 0);

  tdst <- mktemp;
  cf <- fCF;

  _if (/gtu sz (var temp-count) (imm 0)) _then do
    shl sz tdst src (var temp-count);

    temp-c <- mktemp;
    sub sz temp-c (imm sz) (var temp-count);
    shr sz temp-c src (var temp-c);
    mov 1 cf (var temp-c)
  end;

  ov <- fOF;
  _if (/eq sz (var temp-count) (imm 1)) _then
    xorb 1 ov (var (at-offset tdst (sz - 1))) (var cf)
  _else (_if (/neq sz (var temp-count) (imm 0)) _then
    undef 1 ov)
  ;

  sf <- fSF;
  cmplts sz sf (var tdst) (imm 0);

  zf <- fZF;
  cmpeq sz zf (var tdst) (imm 0);

  emit-parity-flag (var tdst);

  write sz dst (var tdst)

#  # dst => a, src => b, amount => c
#  ## Temporary variables:
#  t1 <- mktemp;
#  t2 <- mktemp;
#  cnt <- mktemp;
#  cntIsZero <- mktemp;
#  cntIsOne <- mktemp;
#  af <- fAF;
#  ov <- fOF;
#  cf <- fCF;
#  eq <- fEQ;
#  mask <- const
#     (case sz of
#         8: 31
#       | 16: 31
#       | 32: 31
#       | 64: 63
#      end);
#  zer0 <- const 0;
#  one <- const 1;
#
#  ## Instruction semantics:
#  setflag <- mklabel;
#  exit <- mklabel;
#  nop <- mklabel;
#  convert sz cnt szOp2 c;
#  andb sz cnt (var cnt) mask;
#  cmpeq sz cntIsZero (var cnt) zer0;
#  ifgotolabel (var cntIsZero) nop;
#  shl sz t1 b (/SUB (var cnt) one);
#  mov 1 cf (var (t1 /+ (sz - 1)));
#  shl sz t2 b (var cnt);
#  cmpeq sz cntIsOne (var cnt) one;
#  ifgotolabel (var cntIsOne) setflag;
#  undef 1 ov;
#  gotolabel exit;
#  label setflag;
#  xorb 1 ov (var cf) (var (t2 /+ (sz - 1)));
#  label exit;
#  undef 1 af;
#  write sz a (var t2);
#  label nop;
#  cmpeq sz eq b zer0
end

val sem-sar x = do
  sz <- sizeof1 x.opnd1;
  szOp2 <- sizeof1 x.opnd2;
  dst <- lval sz x.opnd1;
  src <- read sz x.opnd1;
  count <- read szOp2 x.opnd2;

  #count-mask <- const
  #   (case sz of
  #       8: 31
  #     | 16: 31
  #     | 32: 31
  #     | 64: 63
  #    end);
  #temp-count <- mktemp;
  #andb sz temp-count count count-mask;
 
  real-shift-count-size <-
    case sz of
       8: return 5
     | 16: return 5
     | 32: return 5
     | 64: return 6
    end
  ;
  temp-count <- mktemp;
  mov real-shift-count-size temp-count count;
  mov (sz - real-shift-count-size) (at-offset temp-count real-shift-count-size) (imm 0);

  tdst <- mktemp;
  cf <- fCF;

  _if (/gtu sz (var temp-count) (imm 0)) _then do
    sub sz temp-count (var temp-count) (imm 1);
    shrs sz tdst src (var temp-count);

    mov 1 cf (var tdst);

    shrs sz tdst (var tdst) (imm 1)
  end;
 
  ov <- fOF;
  _if (/eq sz (var temp-count) (imm 1)) _then
    mov 1 ov (imm 0)
  _else (_if (/neq sz (var temp-count) (imm 0)) _then
    undef 1 ov)
  ;

  sf <- fSF;
  cmplts sz sf (var tdst) (imm 0);

  zf <- fZF;
  cmpeq sz zf (var tdst) (imm 0);

  emit-parity-flag (var tdst);

  write sz dst (var tdst)
end

val sem-sbb x = do
  sz <- sizeof2 x.opnd1 x.opnd2;
  difference <- lval sz x.opnd1;
  minuend <- read sz x.opnd1;
  subtrahend <- read sz x.opnd2;

  t <- mktemp;
  cf <- fCF;
  movzx sz t 1 (var cf);
  add sz t (var t) subtrahend;
  sub sz t minuend subtrahend;

  emit-sub-sbb-flags sz (var t) minuend subtrahend (var cf) '1';
  write sz difference (var t)
end

val sem-setcc x cond = do
  dst-sz <- sizeof1 x.opnd1;
  dst <- lval dst-sz x.opnd1;

  cond <- cond;
  temp <- mktemp;
  movzx dst-sz temp 1 cond;

  write dst-sz dst (var temp)
end

val sem-scas size x = let
  val sem x = do
    mem-sem <- return (semantic-register-of (register-by-size low DI_ x.addr-sz));

    mem-val <- mktemp;
    segmented-load size mem-val x.addr-sz (var mem-sem) (SEG_OVERRIDE ES);

    a <- return (semantic-register-of (register-by-size low A size));

    temp <- mktemp;
    sub size temp (var a) (var mem-val);

    emit-sub-sbb-flags size (var temp) (var a) (var mem-val) (imm 0) '1';

    direction-adjust mem-sem.size mem-sem size
  end
in
  sem-repe-repne-insn x sem
end

val sem-shr x = do
  sz <- sizeof1 x.opnd1;
  szOp2 <- sizeof1 x.opnd2;
  dst <- lval sz x.opnd1;
  src <- read sz x.opnd1;
  count <- read szOp2 x.opnd2;

  #count-mask <- const
  #   (case sz of
  #       8: 31
  #     | 16: 31
  #     | 32: 31
  #     | 64: 63
  #    end);
  #temp-count <- mktemp;
  #andb sz temp-count count count-mask;

  real-shift-count-size <-
    case sz of
       8: return 5
     | 16: return 5
     | 32: return 5
     | 64: return 6
    end
  ;
  temp-count <- mktemp;
  mov real-shift-count-size temp-count count;
  mov (sz - real-shift-count-size) (at-offset temp-count real-shift-count-size) (imm 0);

  tdst <- mktemp;
  cf <- fCF;

  _if (/gtu sz (var temp-count) (imm 0)) _then do
    sub sz temp-count (var temp-count) (imm 1);
    shr sz tdst src (var temp-count);

    mov 1 cf (var tdst);

    shr sz tdst (var tdst) (imm 1)
  end;
 
  ov <- fOF;
  _if (/eq sz (var temp-count) (imm 1)) _then do
    t <- mktemp;
    mov sz t src;
    mov 1 ov (var (at-offset t (sz - 1)))
  end _else (_if (/neq sz (var temp-count) (imm 0)) _then
    undef 1 ov)
  ;

  sf <- fSF;
  cmplts sz sf (var tdst) (imm 0);

  zf <- fZF;
  cmpeq sz zf (var tdst) (imm 0);

  emit-parity-flag (var tdst);

  write sz dst (var tdst)
end

val sem-stc = do
  cf <- fCF;
  mov 1 cf (imm 1)
end

val sem-std = do
  df <- fDF;
  mov 1 df (imm 1)
end

val sem-stos size x = let
  val sem x = do
    mem-sem <- return (semantic-register-of (register-by-size low DI_ x.addr-sz));
    a <- return (semantic-register-of (register-by-size low A size));

    segmented-store (address x.addr-sz (var mem-sem)) (lin a.size (var a)) (SEG_OVERRIDE ES);

    direction-adjust mem-sem.size mem-sem size
  end
in
  sem-rep-insn x sem
end

val sem-sub x = do
  sz <- sizeof2 x.opnd1 x.opnd2;
  difference <- lval sz x.opnd1;
  minuend <- read sz x.opnd1;
  subtrahend <- read sz x.opnd2;

  t <- mktemp;
  sub sz t minuend subtrahend;

  emit-sub-sbb-flags sz (var t) minuend subtrahend (imm 0) '1';
  write sz difference (var t)
end

## T>>

val sem-test x = do
  sz <- sizeof2 x.opnd1 x.opnd2;
  a <- read sz x.opnd1;
  b <- read sz x.opnd2;
  
  temp <- mktemp;
  andb sz temp a b;

  sf <- fSF;
  cmplts sz sf (var temp) (imm 0);

  zf <- fZF;
  cmpeq sz zf (var temp) (imm 0);
  
  emit-parity-flag (var temp);

  cf <- fCF;
  mov 1 cf (imm 0);
  
  ov <- fOF;
  mov 1 ov (imm 0);

  af <- fAF;
  undef 1 af
end

## U>>
## V>>
## W>>
## X>>

val sem-xadd x = do
  size <- sizeof1 x.opnd1;
  src0 <- read size x.opnd1;
  src1 <- read size x.opnd2;
  dst0 <- lval size x.opnd1;
  dst1 <- lval size x.opnd2;

  sum <- mktemp;
  add size sum src0 src1;

  emit-add-adc-flags size (var sum) src0 src1 (imm 0) '1';

  write size dst0 (var sum);
  write size dst1 src0
end

val sem-xchg x = do
  sz <- sizeof1 x.opnd1;
  a-r <- read sz x.opnd1;
  b-r <- read sz x.opnd2;
  a-w <- lval sz x.opnd1;
  b-w <- lval sz x.opnd2;

  temp <- mktemp;
  
  mov sz temp a-r;
  write sz a-w b-r;
  write sz b-w (var temp)
end

val sem-xor x = do
  sz <- sizeof2 x.opnd1 x.opnd2;
  dst <- lval sz x.opnd1;
  src0 <- read sz x.opnd1;
  src1 <- read sz x.opnd2;

  temp <- mktemp;
  xorb sz temp src0 src1;

  sf <- fSF;
  cmplts sz sf (var temp) (imm 0);

  zf <- fZF;
  cmpeq sz zf (var temp) (imm 0);
  
  emit-parity-flag (var temp);

  cf <- fCF;
  mov 1 cf (imm 0);
  
  ov <- fOF;
  mov 1 ov (imm 0);

  af <- fAF;
  undef 1 af;

  write sz dst (var temp)
end

## Y>>
## Z>>
