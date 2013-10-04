# vim:ai:tabstop=2:shiftwidth=2:expandtab:filetype=sml

## A>>

val sem-adc x = do
  sz <- sizeof2 x.opnd1 x.opnd2;
  a <- lval sz x.opnd1;
  b <- rval sz x.opnd1;
  c <- rvals Signed sz x.opnd2;

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
  b <- rval sz x.opnd1;
  c <- rvals Signed sz x.opnd2;
  t <- mktemp;
  add sz t b c;
  emit-add-adc-flags sz (var t) b c (imm 0) '1';
  write sz a (var t)
end

#val sem-addpd x = do
#  size <- return 128;
#
#end

val sem-aesdec-opnd avx-encoded opnd1 opnd2 opnd3 = do
  size <- sizeof1 opnd1;
  src0 <- rval size opnd2;
  src1 <- rval size opnd3;
  dst <- lval size opnd1;
  
  t <- mktemp;
  prim size "AESDEC" (lins-one (var t)) (lins-more src0 (lins-one src1));

  write-extend avx-encoded size dst (var t)
end

val sem-aesdec x = sem-aesdec-opnd '0' x.opnd1 x.opnd1 x.opnd2
val sem-vaesdec x = sem-aesdec-opnd '1' x.opnd1 x.opnd2 x.opnd3

val sem-and x = do
  size <- sizeof1 x.opnd1;
  src1 <- rval size x.opnd1;
  src2 <- rvals Signed size x.opnd2;
  dst <- lval size x.opnd1;

  temp <- mktemp;
  andb size temp src1 src2;

  ov <- fOF;
  mov 1 ov (imm 0);
  cf <- fCF;
  mov 1 cf (imm 0);
  sf <- fSF;
  mov 1 sf (var (at-offset temp (size - 1)));
  zf <- fZF;
  cmpeq size zf (var temp) (imm 0);
  emit-parity-flag (var temp);
  af <- fAF;
  undef 1 af;
  emit-virt-flags;

  write size dst (var temp)
end

val sem-andpd-opnds avx-encoded opnd1 opnd2 opnd3 = do
  #size <- return 128;
  size <- sizeof1 opnd1;

  src0 <- rval size opnd2;
  src1 <- rval size opnd3;

  temp <- mktemp;
  andb size temp src0 src1;

  dst <- lval size opnd1;
  write-extend avx-encoded size dst (var temp)
end

val sem-andpd x = sem-andpd-opnds '0' x.opnd1 x.opnd1 x.opnd2
val sem-vandpd x = sem-andpd-opnds '1' x.opnd1 x.opnd2 x.opnd3

## B>>

val sem-bsf x = do
  size <- sizeof1 x.opnd1;
  src <- rval size x.opnd2;

  counter <- mktemp;
  _if (/neq size src (imm 0)) _then do
    mov size counter (imm 0);

    temp <- mktemp;
    mov size temp src;

    _while (/neq 1 (var temp) (imm 1)) __ do
      add size counter (var counter) (imm 1);
      shr size temp (var temp) (imm 1)
    end

  end _else
    return void
  ;

  zf <- fZF;
  cmpeq size zf src (imm 0);

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
  emit-virt-flags;

  dst <- lval size x.opnd1;
  write size dst (var counter)
end

val sem-bsr x = do
  size <- sizeof1 x.opnd1;
  src <- rval size x.opnd2;

  counter <- mktemp;
  _if (/neq size src (imm 0)) _then do
    mov size counter (imm (size - 1));

    temp <- mktemp;
    mov size temp src;

    _while (/neq 1 (var (at-offset temp (size - 1))) (imm 1)) __ do
      sub size counter (var counter) (imm 1);
      shl size temp (var temp) (imm 1)
    end

  end _else
    return void
  ;

  zf <- fZF;
  cmpeq size zf src (imm 0);

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
  emit-virt-flags;

  dst <- lval size x.opnd1;
  write size dst (var counter)
end

val sem-bswap x = do
  size <- sizeof1 x.opnd1;
  src <- rval size x.opnd1;

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

val sem-bt-complement base-sz base dst shifted offset-ext = let
  val sem = do
    output <- mktemp;
    #andb base-sz output (var shifted) (imm 1);
    #shl base-sz output (var output) (var offset-ext);
    shl base-sz output (imm 1) (var offset-ext);
    xorb base-sz output (var output) base;
    write base-sz dst (var output)
  end
in
  with-subscope sem
end

val sem-bt-reset base-sz base dst shifted offset-ext = let
  val sem = do
   output <- mktemp;
   shl base-sz output (imm 1) (var offset-ext);
   xorb base-sz output (var output) (imm (0-1));
   #xorb base-sz output (imm (0-1)) (imm 1);
   #shl base-sz output (var output) (var offset-ext);
   andb base-sz output (var output) base;
   write base-sz dst (var output)
 end
in
  with-subscope sem
end

val sem-bt-set base-sz base dst shifted offset-ext = let
  val sem = do
    output <- mktemp;
    shl base-sz output (imm 1) (var offset-ext);
    orb base-sz output (var output) base;
    write base-sz dst (var output)
  end
in
  with-subscope sem
end

val sem-bt-none base-sz base base-opnd shifted offset-ext = return void

val sem-bt x modifier = do
  offset-sz <- sizeof1 x.opnd2;
  offset <- rvals Unsigned offset-sz x.opnd2;
  base-sz <- sizeof1 x.opnd1;
  
  offset-real-sz <-
    case base-sz of
       16: return 4
     | 32: return 5
     | 64: return 6
    end
  ;

  bd <- case x.opnd1 of
     MEM m: do
       t <- mktemp;
       (case x.opnd2 of
          REG r: movsx m.psz t offset-sz offset
        | _: movzx m.psz t offset-real-sz offset
       end);
       shrs m.psz t (var t) (imm 3);
       mov (offset-real-sz - 3) t (imm 0);
       base <- rval-ptroff base-sz (var t) x.opnd1;
       dst <- lval-ptroff base-sz (var t) x.opnd1;
       return {base=base, dst=dst}
     end
   | _: do 
       base <- rval base-sz x.opnd1;
       dst <- lval base-sz x.opnd1;
       return {base=base, dst=dst}
     end
  end;

  offset-ext <- mktemp;
  mov offset-real-sz offset-ext offset;
  mov (base-sz - offset-real-sz) (at-offset offset-ext offset-real-sz) (imm 0);

  shifted <- mktemp;
  shr base-sz shifted bd.base (var offset-ext);

  cf <- fCF;
  mov 1 cf (var shifted);

  modifier base-sz bd.base bd.dst shifted offset-ext;

  ov <- fOF;
  sf <- fSF;
  af <- fAF;
  pf <- fPF;
  undef 1 ov;
  undef 1 sf;
  undef 1 af;
  undef 1 pf;
  emit-virt-flags
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
  
  result <- if (near x.opnd1) then do
    target <- read-flow ip-sz x.opnd1;
    result <- if (relative x.opnd1) then do
      result <- if (x.opnd-sz === 16) then do
          add ip-sz temp-ip ip target;
          mov (ip-sz - x.opnd-sz) (at-offset temp-ip x.opnd-sz) (imm 0);
					return (var temp-ip)
      end else
         return (lin-sum ip target)
			;
			return result
    end else
#      mov ip-sz temp-ip target
       return target
    ;
    ps-push ip-sz ip;
		return result
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

    movzx ip-sz temp-ip x.opnd-sz target;

		return (var temp-ip)
  end;

  call (address ip-sz result)
end

val sem-convert size = do
  src <- return (semantic-register-of (register-by-size low A size));
  dst <- return (semantic-register-of (register-by-size low A (2*size)));

  t <- mktemp;
  movsx dst.size t src.size (var src);

  write-extend-reg '0' dst.size dst (var t)
end

#val sem-cdqe = do
#  a <- return (semantic-register-of RAX);
#  movsx 64 a 32 (var a)
#end

val sem-clc = do
  cf <- fCF;
  mov 1 cf (imm 0);
  emit-virt-flags
end

val sem-cld = do
  df <- fDF;
  mov 1 df (imm 0)
end

val sem-cmc = do
  cf <- fCF;
  xorb 1 cf (var cf) (imm 1);
  emit-virt-flags
end

val sem-cmovcc x cond = do
  sz <- sizeof1 x.opnd1;

  dst <- lval sz x.opnd1;
  dst-old <- rval sz x.opnd1;
  src <- rval sz x.opnd2;

  temp <- mktemp;
  mov sz temp dst-old;

  _if cond _then
    mov sz temp src
  ;

  write sz dst (var temp)
end

val sem-cmp x = do
  sz <- sizeof2 x.opnd1 x.opnd2;
  a <- lval sz x.opnd1;
  b <- rval sz x.opnd1;
  c <- rvals Signed sz x.opnd2;
  t <- mktemp;
  sub sz t b c;
  emit-sub-sbb-flags sz (var t) b c (imm 0) '1'
end

val sem-cmps x = do
  sz <- sizeof1 x.opnd1;
  src0 <- rval sz x.opnd1;
  src1 <- rval sz x.opnd2;

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
#  src0 <- rval sz (MEM{sz=sz,psz=addr-sz,segment=reg0-segment,opnd=REG reg0});
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
#  src1 <- rval sz (MEM{sz=sz,psz=addr-sz,segment=reg1-segment,opnd=REG reg1});
#
end
#val sem-cmpsb = sem-cmps 8
#val sem-cmpsw = sem-cmps 16
#val sem-cmpsd = sem-cmps 32
#val sem-cmpsq = sem-cmps 64

val sem-cmpxchg x = do
  size <- sizeof1 x.opnd1;

  subtrahend <- rval size x.opnd1;
  minuend <- return (semantic-register-of (register-by-size low A size)); #accumulator

  difference <- mktemp;
  sub size difference (var minuend) subtrahend;

  emit-sub-sbb-flags size (var difference) (var minuend) subtrahend (imm 0) '1';

  zf <- fZF;
  _if (/d (var zf)) _then do
    dst <- lval size x.opnd1;
    src <- rval size x.opnd2;
    write size dst src
  end _else do
    dst <- rval size x.opnd1;
    write-extend-reg '0' size minuend dst
  end
end

val sem-cmpxchg16b-cmpxchg8b x = do
  subtrahend <- rval (2*x.opnd-sz) x.opnd1;

  minuend <- combine (register-by-size low D x.opnd-sz) (register-by-size low A x.opnd-sz);

  zf <- fZF;

  cmpeq (2*x.opnd-sz) zf (var minuend) subtrahend;

  _if (/d (var zf)) _then do
    src-reg <- combine (register-by-size low C x.opnd-sz) (register-by-size low B x.opnd-sz);
    dst <- lval (2*x.opnd-sz) x.opnd1;
    write (2*x.opnd-sz) dst (var src-reg)
  end _else do
    temp <- mktemp;
    mov (2*x.opnd-sz) temp subtrahend;

    move-combined x.opnd-sz (register-by-size low D x.opnd-sz) (register-by-size low A x.opnd-sz) temp
  end;

  emit-virt-flags
end

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
  write-extend-reg '0' dst-high-sem.size dst-high-sem (var temp)
end

## D>>

val sem-dec x = do
  sz <- sizeof1 x.opnd1;
  src <- rval sz x.opnd1;
  dst <- lval sz x.opnd1;

  temp <- mktemp;
  sub sz temp src (imm 1);

  emit-sub-sbb-flags sz (var temp) src (imm 1) (imm 0) '0';

  write sz dst (var temp)
end

val sem-div signedness x = do
  sz <- sizeof1 x.opnd1;
  divisor <- rvals signedness (sz + sz) x.opnd1;

  _if (/eq (sz + sz) divisor (imm 0)) _then
    throw SEM_DIVISION_BY_ZERO
  ;

  dividend <-
    case sz of
       8: return (semantic-register-of AX)
     | _: combine (register-by-size low D sz) (register-by-size low A sz)
    end
  ;

  quotient <- mktemp;
  (case signedness of
     Unsigned: div
   | Signed: divs
  end) (sz + sz) quotient (var dividend) divisor;

  case signedness of
     Unsigned:
       _if (/neq sz (var (at-offset quotient sz)) (imm 0)) _then
         throw SEM_DIVISION_OVERFLOW
   | Signed: do
       _if (/or (/gts (sz + sz) (var quotient) (imm ((power 2 (sz - 1)) - 1))) (/lts (sz + sz) (var quotient) (imm (0 - (power 2 (sz - 1)))))) _then
         throw SEM_DIVISION_OVERFLOW
     end
  end;

  remainder <- mktemp;
  (case signedness of
     Unsigned: mod
   | Signed: mods
  end) (sz + sz) remainder (var dividend) divisor;

#   | Signed: prim (sz + sz) "mods" (lins-one (var remainder)) (lins-more (var dividend) (lins-one divisor))

  quotient-sem <- return (semantic-register-of (register-by-size low A sz));
  write-extend-reg '0' sz quotient-sem (var quotient);

  remainder-sem <-
    case sz of
       8: return (semantic-register-of AH)
     | _: return (semantic-register-of (register-by-size high D sz))
    end
  ;
  write-extend-reg '0' sz remainder-sem (var remainder);

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
  undef 1 pf;
  emit-virt-flags
end

## E>>
## F>>

val sem-fadd x = do
  sz <- sizeof1 x.opnd1;
  src0 <- rval sz x.opnd1;
  src1 <- rval sz x.opnd2;
  dst <- lval sz x.opnd1;

  t <- mktemp;
  bflop sz SEM_FADD t src0 src1; 

  write sz dst (var t)
end

## G>>
## H>>

val sem-hlt = do
  #Todo: ...
  return void
end

## I>>

val sem-idiv x = sem-div Signed x

val sem-imul-1 x = sem-mul Signed x
val sem-imul-2-3 op1 op2 op3 = do
  sz <- sizeof1 op1;

  factor0 <- rvals Signed (sz + sz) op2;
  factor1 <- rvals Signed (sz + sz) op3;

  product <- mktemp;
  mul (sz + sz) product factor0 factor1;

  emit-mul-flags Signed sz product;

  result <- lval sz op1;
  write sz result (var product)
end
val sem-imul-2 x = sem-imul-2-3 x.opnd1 x.opnd1 x.opnd2
val sem-imul-3 x = sem-imul-2-3 x.opnd1 x.opnd2 x.opnd3

val sem-inc x = do
  sz <- sizeof1 x.opnd1;
  src <- rval sz x.opnd1;
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

#  temp-ip <- mktemp;
#  add ip-sz temp-ip target ip;
  temp-ip <- return (lin-sum target ip);

  cond <- cond;
  cbranch cond (address ip-sz temp-ip) (address ip-sz ip)
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

  result <- if (near x.opnd1) then do
    target <- read-flow ip-sz x.opnd1;
    result <- if (relative x.opnd1) then do
      ip <- ip-get;
      #add ip-sz temp-ip ip target
			return (lin-sum ip target)
    end else
      #mov ip-sz temp-ip target
			return target
    ;
    result <- if (x.opnd-sz === 16) then do
      #andb ip-sz temp-ip (var temp-ip) (imm 0xffff)
			mov ip-sz temp-ip result;
      mov (ip-sz - x.opnd-sz) (at-offset temp-ip x.opnd-sz) (imm 0);
			return (var temp-ip)
    end else
      return result
	  ;
	  return result
  end else if (not mode64) then do
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
    mov reg-size reg-sem (var (at-offset temp-target x.opnd-sz));

		return (var temp-ip)
  end else
    return (var temp-ip)
  ;

  jump (address ip-sz result)
end

## K>>
## L>>

val sem-lahf = do
  ah <- return (semantic-register-of AH);
  flags <- rflags;

  mov ah.size ah (var flags)
end

val sem-lar x = do
  sem-undef-arity2 x
end

#val sem-lddqu-vlddqu size x = do
#  src <- rval size x.opnd2;
#  dst <- lval size x.opnd1;
#
#  write size dst src
#end
#
#val sem-lddqu x = sem-lddqu-vlddqu 128 x;
#val sem-vlddqu x = sem-lddqu-vlddqu 256 x;

val sem-lds-les-lfs-lgs-lss x segment = do
  src-size <- sizeof1 x.opnd1;
  src <- rval src-size x.opnd1;

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
  address <- conv-with '1' OFFSET_NONE Signed src.psz src.opnd;

  temp <- mktemp;
  movzx opnd-sz temp addr-sz address;

  write opnd-sz dst (var temp)
end

val sem-lods x = do
  sz <- sizeof1 x.opnd1;
  src <- rval sz x.opnd1;

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
  postproc-reg '0' reg.size reg;  

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

