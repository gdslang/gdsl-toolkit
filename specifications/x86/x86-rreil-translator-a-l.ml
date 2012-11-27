## A>>

val sem-adc x = do
  sz <- sizeof2 x.opnd1 x.opnd2;
  a <- lval sz x.opnd1;
  b <- read sz x.opnd1;
  c <- read sz x.opnd2;

  t <- mktemp;
  add sz t b c;

  cf <- fCF;
  tc <- mktemp;
  movzx sz tc 1 (var cf);
  add sz t (var t) (var tc);

  emit-add-adc-flags sz (var t) b c (var cf) '1';
  write sz a (var t)
end

val sem-add x = do
  sz <- sizeof2 x.opnd1 x.opnd2;
  a <- lval sz x.opnd1;
  b <- read sz x.opnd1;
  c <- read sz x.opnd2;
  t <- mktemp;
  add sz t b c;
  emit-add-adc-flags sz (var t) b c (imm 0) '1';
  write sz a (var t)
end

#val sem-addpd x = do
#  size <- return 128;
#
#end

val sem-andpd x = do
  size <- return 128;

  src0 <- read size x.opnd1;
  src1 <- read size x.opnd2;

  temp <- mktemp;
  andb size temp src0 src1;

  dst <- lval size x.opnd1;
  write size dst (var temp)
end

val sem-vandpd x = do
  size <- sizeof1 x.opnd1;
  src0 <- read size x.opnd2;
  src1 <- read size x.opnd3;
  out-size <- return 256;
  
  temp <- mktemp;
  andb size temp src0 src1;

  mov (out-size - size) (at-offset temp size) (imm 0);

  dst <- return (semantic-register-of-operand-with-size x.opnd1 out-size);
  mov out-size dst (var temp)
end

## B>>

val sem-bsf x = do
  src <- read x.opnd-sz x.opnd2;

  counter <- mktemp;
  _if (/neq x.opnd-sz src (imm 0)) _then do
    mov x.opnd-sz counter (imm 0);

    temp <- mktemp;
    mov x.opnd-sz temp src;

    _while (/neq 1 (var temp) (imm 1)) __ do
      add x.opnd-sz counter (var counter) (imm 1);
      shr x.opnd-sz temp (var temp) (imm 1)
    end

  end _else
    return void
  ;

  zf <- fZF;
  cmpeq x.opnd-sz zf src (imm 0);

  cf <- fCF;
  ov <- fOF;
  sf <- fSF;
  af <- fAF;
  pf <- fPF;
  undef 1 cf;
  undef 1 ov;
  undef 1 sf;
  undef 1 af;
  undef 1 pf;

  dst <- lval x.opnd-sz x.opnd1;
  write x.opnd-sz dst (var counter)
end

val sem-bsr x = do
  src <- read x.opnd-sz x.opnd2;

  counter <- mktemp;
  _if (/neq x.opnd-sz src (imm 0)) _then do
    mov x.opnd-sz counter (imm (x.opnd-sz - 1));

    temp <- mktemp;
    mov x.opnd-sz temp src;

    _while (/neq 1 (var (at-offset temp (x.opnd-sz - 1))) (imm 1)) __ do
      sub x.opnd-sz counter (var counter) (imm 1);
      shl x.opnd-sz temp (var temp) (imm 1)
    end

  end _else
    return void
  ;

  zf <- fZF;
  cmpeq x.opnd-sz zf src (imm 0);

  cf <- fCF;
  ov <- fOF;
  sf <- fSF;
  af <- fAF;
  pf <- fPF;
  undef 1 cf;
  undef 1 ov;
  undef 1 sf;
  undef 1 af;
  undef 1 pf;

  dst <- lval x.opnd-sz x.opnd1;
  write x.opnd-sz dst (var counter)
end

val sem-bswap x = do
  size <- sizeof1 x.opnd1;
  src <- read size x.opnd1;

  src-temp <- mktemp;
  mov size src-temp src;

  temp <- mktemp;
  if size === 32 then do
    mov 8 (at-offset temp 0) (var (at-offset src-temp 24));
    mov 8 (at-offset temp 8) (var (at-offset src-temp 16));
    mov 8 (at-offset temp 16) (var (at-offset src-temp 8));
    mov 8 (at-offset temp 24) (var (at-offset src-temp 0))
  end else do
    mov 8 (at-offset temp 0) (var (at-offset src-temp 56));
    mov 8 (at-offset temp 8) (var (at-offset src-temp 48));
    mov 8 (at-offset temp 16) (var (at-offset src-temp 40));
    mov 8 (at-offset temp 24) (var (at-offset src-temp 32));
    mov 8 (at-offset temp 32) (var (at-offset src-temp 24));
    mov 8 (at-offset temp 40) (var (at-offset src-temp 16));
    mov 8 (at-offset temp 48) (var (at-offset src-temp 8));
    mov 8 (at-offset temp 56) (var (at-offset src-temp 0))
  end;

  dst <- lval size x.opnd1;
  write size dst (var temp)
end

val sem-bt-complement base-sz base base-opnd shifted offset-ext = do
  output <- mktemp;
  andb base-sz output (var shifted) (imm 1);
  shl base-sz output (var output) (var offset-ext);
  xorb base-sz output (var output) base;
  dst <- lval base-sz base-opnd;
  write base-sz dst (var output)
end

val sem-bt-reset base-sz base base-opnd shifted offset-ext = do
  output <- mktemp;
  xorb base-sz output (imm (0-1)) (imm 1);
  shl base-sz output (var output) (var offset-ext);
  andb base-sz output (var output) base;
  dst <- lval base-sz base-opnd;
  write base-sz dst (var output)
end

val sem-bt-set base-sz base base-opnd shifted offset-ext = do
  output <- mktemp;
  shl base-sz output (imm 1) (var offset-ext);
  orb base-sz output (var output) base;
  dst <- lval base-sz base-opnd;
  write base-sz dst (var output)
end

val sem-bt-none base-sz base base-opnd shifted offset-ext = return void

val sem-bt x modifier = do
  base-sz <- sizeof1 x.opnd1;
  base <- read base-sz x.opnd1;
  offset-sz <- sizeof1 x.opnd2;
  offset <- read offset-sz x.opnd2;

  offset-real-sz <-
    case base-sz of
       16: return 4
     | 32: return 5
     | 64: return 6
    end
  ;

  offset-ext <- mktemp;
  mov offset-real-sz offset-ext offset;
  mov (base-sz - offset-real-sz) (at-offset offset-ext offset-real-sz) (imm 0);
  
  shifted <- mktemp;
  shr base-sz shifted base (var offset-ext);
  
  cf <- fCF;
  mov 1 cf (var shifted);

  modifier base-sz base x.opnd1 shifted offset-ext;

  ov <- fOF;
  sf <- fSF;
  af <- fAF;
  pf <- fPF;
  undef 1 ov;
  undef 1 sf;
  undef 1 af;
  undef 1 pf
end

## C>>

val sem-call x = do
  mode64 <- mode64?;
  ip-sz <-
    #Todo: mode64 => RIP?
    #Todo: x.opnd-sz === 64 => RIP?
    if x.opnd-sz === 64 then 
      return 64
    else
      return 32
  ;
  temp-ip <- mktemp;
  
  ip <- ip-get;
  if (near x.opnd1) then do
    target <- read-flow ip-sz x.opnd1;
    if (relative x.opnd1) then do
      add ip-sz temp-ip ip target;
      if (x.opnd-sz === 16) then
          mov (ip-sz - x.opnd-sz) (at-offset temp-ip x.opnd-sz) (imm 0)
      else
         return void
    end else
      mov ip-sz temp-ip target
    ;
    ps-push ip-sz ip
  end else do
    #Todo: Fix FF/3 (Call far, absolute, indirect...)
    sec-reg <- return CS;
    sec-reg-sem <- return (semantic-register-of sec-reg);
    reg-size <- sizeof1 (REG sec-reg);
    sec-reg-extended <- mktemp;
    movzx x.opnd-sz sec-reg-extended reg-size (var sec-reg-sem);
    ps-push x.opnd-sz (var sec-reg-extended);
    ps-push ip-sz ip;

    target-sz <- sizeof-flow x.opnd1;
    target <- read-flow target-sz x.opnd1;

    temp-target <- mktemp;
    mov target-sz temp-target target;
    mov reg-size sec-reg-sem (var (at-offset temp-target x.opnd-sz));

    temp-ip <- mktemp;
    movzx ip-sz temp-ip x.opnd-sz target
  end;
    
  call (address ip-sz (var temp-ip))
end

val sem-convert size = do
  src <- return (semantic-register-of (register-by-size low A size));
  dst <- return (semantic-register-of (register-by-size low A (2*size)));

  movsx dst.size dst src.size (var src)
end

val sem-cdqe = do
  a <- return (semantic-register-of RAX);
  movsx 64 a 32 (var a)
end

val sem-clc = do
  cf <- fCF;
  mov 1 cf (imm 0)
end

val sem-cld = do
  df <- fDF;
  mov 1 df (imm 0)
end

val sem-cmc = do
  cf <- fCF;
  xorb 1 cf (var cf) (imm 1)
end

val sem-cmovcc x cond = do
  sz <- sizeof1 x.opnd1;
  dst <- lval sz x.opnd1;
  dst-read <- read sz x.opnd1;

  src <- read sz x.opnd2;

  temp <- mktemp;
  mov sz temp dst-read;

  _if cond _then
    mov sz temp src
  ;

  write sz dst (var temp)
end

val sem-cmp x = do
  sz <- sizeof2 x.opnd1 x.opnd2;
  a <- lval sz x.opnd1;
  b <- read sz x.opnd1;
  c <- read sz x.opnd2;
  t <- mktemp;
  sub sz t b c;
  emit-sub-sbb-flags sz (var t) b c (imm 0) '1'
end

val sem-cmps x = do
  sz <- sizeof1 x.opnd1;
  src0 <- read sz x.opnd1;
  src1 <- read sz x.opnd2;

  temp <- mktemp;
  sub sz temp src0 src1;
  emit-sub-sbb-flags sz (var temp) src0 src1 (imm 0) '1';

  reg0-sem <- return (semantic-register-of (read-addr-reg x.opnd1));
  reg1-sem <- return (semantic-register-of (read-addr-reg x.opnd2));

  direction-adjust x.addr-sz reg0-sem sz;
  direction-adjust x.addr-sz reg1-sem sz

#  addr-sz <- address-size;
#
#  reg0 <-
#    case addr-sz of
#       16: return SI
#     | 32: return ESI
#     | 64: return RSI
#    end
#  ;
#  reg0-sem <- return (semantic-register-of reg0);
#  reg0-sz <- sizeof1 (REG reg0);
#  
#  #Todo: Fix, use specified segment
#  reg0-segment <- segment DS;
#  src0 <- read sz (MEM{sz=sz,psz=addr-sz,segment=reg0-segment,opnd=REG reg0});
#
#  reg1 <-
#    case addr-sz of
#       16: return DI
#     | 32: return EDI
#     | 64: return RDI
#    end
#  ;
#  reg1-sem <- return (semantic-register-of reg1);
#  reg1-sz <- sizeof1 (REG reg1);
#  reg1-segment <- segment ES;
#  src1 <- read sz (MEM{sz=sz,psz=addr-sz,segment=reg1-segment,opnd=REG reg1});
#
end
#val sem-cmpsb = sem-cmps 8
#val sem-cmpsw = sem-cmps 16
#val sem-cmpsd = sem-cmps 32
#val sem-cmpsq = sem-cmps 64

val sem-cmpxchg x = do
  size <- sizeof1 x.opnd1;

  subtrahend <- read size x.opnd1;
  minuend <- return (semantic-register-of (register-by-size low A size)); #accumulator

  difference <- mktemp;
  sub size difference (var minuend) subtrahend;

  emit-sub-sbb-flags size (var difference) (var minuend) subtrahend (imm 0) '1';
  
  zf <- fZF;
  _if (/d (var zf)) _then do
    dst <- lval size x.opnd1;
    src <- read size x.opnd2;
    write size dst src
  end _else do
    dst <- read size x.opnd1;
    mov size minuend dst
  end
end

val sem-cmpxchg16b-cmpxchg8b x = do
  subtrahend <- read (2*x.opnd-sz) x.opnd1;

  minuend <- combine (register-by-size low D x.opnd-sz) (register-by-size low A x.opnd-sz);

  zf <- fZF;

  cmpeq (2*x.opnd-sz) zf (var minuend) (subtrahend);

  _if (/d (var zf)) _then do
    src-reg <- combine (register-by-size low C x.opnd-sz) (register-by-size low B x.opnd-sz);
    dst <- lval (2*x.opnd-sz) x.opnd1;
    write (2*x.opnd-sz) dst (var src-reg)
  end _else
    #Todo: Nicht Tx = blah, sondern Reg = blah
    mov (2*x.opnd-sz) minuend subtrahend
end

# ^-

val sem-cpuid x = do
  #Todo: ;-)
  eax <- return (semantic-register-of EAX);
  ebx <- return (semantic-register-of EBX);
  ecx <- return (semantic-register-of ECX);
  edx <- return (semantic-register-of EDX);
  
  undef eax.size eax;
  undef ebx.size ebx;
  undef ecx.size ecx;
  undef edx.size edx
end

val sem-cwd-cdq-cqo x = do
  src <-
    case x.opnd-sz of
       16: return AX
     | 32: return EAX
     | 64: return RAX
    end
  ;
  src-sem <- return (semantic-register-of src);
  
  temp <- mktemp;
  movsx src-sem.size temp 1 (var (at-offset src-sem (src-sem.size - 1)));

  dst-high <-
    case x.opnd-sz of
       16: return DX
     | 32: return EDX
     | 64: return RDX
    end
  ;
  
  dst-high-sem <- return (semantic-register-of dst-high);
  mov dst-high-sem.size dst-high-sem (var temp)
end

## D>>

val sem-dec x = do
  sz <- sizeof1 x.opnd1;
  src <- read sz x.opnd1;
  dst <- lval sz x.opnd1;

  temp <- mktemp;
  sub sz temp src (imm 1);
  
  emit-sub-sbb-flags sz (var temp) src (imm 1) (imm 0) '0';

  write sz dst (var temp)
end

val sem-div signedness x = do
  sz <- sizeof1 x.opnd1;
  divisor <- read (sz + sz) x.opnd1;

  dividend <-
    case sz of
       8: return (semantic-register-of AX)
     | _: combine (register-by-size low D sz) (register-by-size low A sz)
    end
  ;

  quotient <- mktemp;
  #Todo: Handle exception
  case signedness of
     Unsigned: div (sz + sz) quotient (var dividend) divisor
   | Signed: divs (sz + sz) quotient (var dividend) divisor
  end;
  quotient-sem <- return (semantic-register-of (register-by-size low A sz));
  mov sz quotient-sem (var quotient);

  remainder <- mktemp;
  modulo (sz + sz) remainder (var dividend) divisor;
  remainder-sem <-
    case sz of
       8: return (semantic-register-of AH)
     | _: return (semantic-register-of (register-by-size high D sz))
    end
  ;
  mov sz remainder-sem (var remainder);

  cf <- fCF;
  ov <- fOF;
  sf <- fSF;
  zf <- fZF;
  af <- fAF;
  pf <- fPF;

  undef 1 cf;
  undef 1 ov;
  undef 1 sf;
  undef 1 zf;
  undef 1 af;
  undef 1 pf
end

## E>>
## F>>
## G>>
## H>>

val sem-hlt = do
  return void
end

## I>>

val sem-idiv x = sem-div Signed x

val sem-imul-1 x = sem-mul Signed x
val sem-imul-2-3 op1 op2 op3 = do
  sz <- sizeof1 op1;

  factor0 <- reads Signed (sz + sz) op2;
  factor1 <- reads Signed (sz + sz) op3;

  product <- mktemp;
  mul (sz + sz) product factor0 factor1;

  emit-mul-flags sz product;

  result <- lval sz op1;
  write sz result (var product)
end
val sem-imul-2 x = sem-imul-2-3 x.opnd1 x.opnd1 x.opnd2
val sem-imul-3 x = sem-imul-2-3 x.opnd1 x.opnd2 x.opnd3

val sem-inc x = do
  sz <- sizeof1 x.opnd1;
  src <- read sz x.opnd1;
  dst <- lval sz x.opnd1;

  temp <- mktemp;
  add sz temp src (imm 1);
  
  emit-add-adc-flags sz (var temp) src (imm 1) (imm 0) '0';

  write sz dst (var temp)
end

val sem-invd = return void

## J>>

val sem-jcc x cond = do
  ip-sz <-
    if (x.opnd-sz === 64) then
      return 64
    else
      return 32
  ;
  ip <- ip-get;

  target <- read-flow ip-sz x.opnd1;

  temp-ip <- mktemp;
  add ip-sz temp-ip target ip;

  cond <- cond;
  cbranch cond (address ip-sz (var temp-ip)) (address ip-sz ip)
end

val sem-jregz x reg = do
  reg-sem <- return (semantic-register-of reg);
  sem-jcc x (/eq reg-sem.size (var reg-sem) (imm 0))
end

val sem-jcxz x = sem-jregz x CX
val sem-jecxz x = sem-jregz x ECX
val sem-jrcxz x = sem-jregz x RCX

val sem-jmp x = do
  mode64 <- mode64?;
  ip-sz <-
    if mode64 then
      return 64
    else
      return 32
  ;
  temp-ip <- mktemp;

  if (near x.opnd1) then do
    target <- read-flow ip-sz x.opnd1;
    if (relative x.opnd1) then do
      ip <- ip-get;
      add ip-sz temp-ip ip target
    end else
      mov ip-sz temp-ip target
    ;
    if (x.opnd-sz === 16) then
      #andb ip-sz temp-ip (var temp-ip) (imm 0xffff)
      mov (ip-sz - x.opnd-sz) (at-offset temp-ip x.opnd-sz) (imm 0)
    else
      return void
    end
  else if (not mode64) then do
    target-sz <- sizeof-flow x.opnd1;
    target <- read-flow target-sz x.opnd1;
    movzx ip-sz temp-ip x.opnd-sz target;
    #if (opnd-sz === 16) then
    #  #andb ip-sz temp-ip (var temp-ip) (imm 0xffff)
    #  mov (ip-sz - opnd-sz) (at-offset temp-ip x.opnd-sz) (imm 0)
    #else
    #  return void
    #;
    reg <- return CS;
    reg-sem <- return (semantic-register-of reg);
    reg-size <- sizeof1 (REG reg);
    temp-target <- mktemp;
    mov target-sz temp-target target;
    mov reg-size reg-sem (var (at-offset temp-target x.opnd-sz))
  end else
    return void
  ;

  jump (address ip-sz (var temp-ip))
end

## K>>
## L>>

val sem-lahf = do
  ah <- return (semantic-register-of AH);
  flags <- rflags;

  mov ah.size ah (var flags)
end

val sem-lar x = do
  sem-undef-arity2
end

#val sem-lddqu-vlddqu size x = do
#  src <- read size x.opnd2;
#  dst <- lval size x.opnd1;
#
#  write size dst src
#end
#
#val sem-lddqu x = sem-lddqu-vlddqu 128 x;
#val sem-vlddqu x = sem-lddqu-vlddqu 256 x;

val sem-lds-les-lfs-lgs-lss x segment = do
  src-size <- sizeof1 x.opnd1;
  src <- read src-size x.opnd1;

  src-temp <- mktemp;
  mov src-size src-temp src;

  ds <- return (semantic-register-of segment);
  mov ds.size ds (var (at-offset src-temp 0));

  dst <- lval x.opnd-sz x.opnd2;
  write x.opnd-sz dst (var (at-offset src-temp ds.size))
end

val sem-lea x = do
  opnd-sz <- sizeof1 x.opnd1;
  dst <- lval opnd-sz x.opnd1;
  src <-
    case x.opnd2 of
      MEM m: return m
    end
  ;
  addr-sz <- return src.psz;
  address <- conv-with Signed src.psz src.opnd;

  temp <- mktemp;
  movzx opnd-sz temp addr-sz address;

  write opnd-sz dst (var temp)
end

val sem-lods x = do
  sz <- sizeof1 x.opnd1;
  src <- read sz x.opnd1;

  dst <- return (semantic-register-of (register-by-size low A sz));
  mov dst.size dst src;

  reg0-sem <- return (semantic-register-of (read-addr-reg x.opnd1));

  direction-adjust x.addr-sz reg0-sem sz
end

val sem-loop-loop x = do
  reg <- return (semantic-register-of (
    case x.addr-sz of
       32: ECX
     | 64: RCX
     | _: CX
    end
  ));

  sub reg.size reg (var reg) (imm 1);

  return reg
end

val sem-loop x = do
  reg <- sem-loop-loop x;
  sem-jcc x (/neq reg.size (var reg) (imm 0))
end

val sem-loope x = do
  reg <- sem-loop-loop x;
  zf <- fZF;
  sem-jcc x (/and (/d (var zf)) (/neq reg.size (var reg) (imm 0)))
end

val sem-loopne x = do
  reg <- sem-loop-loop x;
  zf <- fZF;
  sem-jcc x (/and (/not (var zf)) (/neq reg.size (var reg) (imm 0)))
end

