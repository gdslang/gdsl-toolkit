# vim:filetype=sml:ts=3:sw=3:expandtab

export = translate translateBlock

#Todo: fix
val runtime-stack-address-size = do
  mode64 <- mode64?;
  if mode64 then
    return 64
  else
    return 32
end

val ip-get = do
  return (imm 0)
end

val segment-register? x =
  case x of
     CS: '1'
   | SS: '1'
   | DS: '1'
   | ES: '1'
   | FS: '1'
   | GS: '1'
  end

val sizeof2 dst/src1 src2 =
   case dst/src1 of
      REG r: return ($size (semantic-register-of r))
    | MEM x: return x.sz
    | _:
         case src2 of
            REG r: return ($size (semantic-register-of r))
          | MEM x: return x.sz
         end
   end

val sizeof-flow target =
  case target of
     REL8 x: return 8
   | REL16 x: return 16
   | REL32 x: return 32
   | REL64 x: return 64
   | NEARABS x: sizeof1 x
   | FARABS x: sizeof1 x
  end

val sizeof1 op =
   case op of
      REG r: return (semantic-register-of r).size
    | MEM x: return x.sz
    | IMM8 i: return 8
    | IMM16 i: return 16
    | IMM32 i: return 32
    | IMM64 i: return 64
   end

type signedness =
   Signed
 | Unsigned

val expand conv lin from-sz to-sz = do
  if from-sz === to-sz then
    return lin
  else
    do
      expanded <- mktemp;
      case conv of
         Signed: movsx to-sz expanded from-sz lin
       | Unsigned: movzx to-sz expanded from-sz lin
      end;
      return (var expanded)
    end
end

val segment-add mode64 address segment = let
  val seg-sem seg-reg = SEM_LIN_VAR(semantic-register-of seg-reg)
in
  case segment of
     SEG_NONE:
       if mode64 then
         address
       else
         SEM_LIN_ADD {opnd1=seg-sem DS,opnd2=address}
   | SEG_OVERRIDE s:
       if mode64 then
         case s of
            FS: SEM_LIN_ADD {opnd1=seg-sem s,opnd2=address}
  	  | GS: SEM_LIN_ADD {opnd1=seg-sem s,opnd2=address}
	  | _: address
	 end
       else
         SEM_LIN_ADD {opnd1=seg-sem s,opnd2=address}
  end
end

#IA-32e => 64 bit real addresses
val real-addr-sz = return 64

val segmented-lin lin sz segment = do
  real-addr-sz <- real-addr-sz;
  mode64 <- mode64?;

  expanded <- expand Unsigned lin sz real-addr-sz;
  return (segment-add mode64 expanded segment)
end
val segmented-reg reg segment = segmented-lin (var reg) reg.size segment

val segmented-load dst-sz dst addr-sz address segment = do
  address-segmented <- segmented-lin address addr-sz segment;
  addr-sz <- real-addr-sz;
  load dst-sz dst addr-sz address-segmented
end

val segmented-store addr rhs segment = do
  address-segmented <- segmented-lin addr.address addr.size segment;
  addr-sz <- real-addr-sz;
  store (address addr-sz address-segmented) rhs
end

#val segment segment = do
#  mode64 <- mode64?;
#  if mode64 then
#    case segment of
#       SEG_NONE: return 
#
#    case segment of
#       FS: return segment
#     | GS: return segment
#     | _: return DS
#    end
#  else
#    return segment
#  return DS
#end

val conv-with conv sz x =
   let
      val conv-imm conv x = case conv of
      	  Signed: return (SEM_LIN_IMM{imm=sx x})
	| Unsigned: return (SEM_LIN_IMM{imm=zx x})
      end

      val conv-reg conv sz r = do
        reg <- return (semantic-register-of r);
	expand conv (var reg) reg.size sz
      end

      val conv-sum conv sz x =
         do op1 <- conv-with conv sz x.a;
            op2 <- conv-with conv sz x.b;
            return
               (SEM_LIN_ADD
                  {opnd1=op1,
                   opnd2=op2})
         end

      val conv-scale conv sz x =
         do op <- conv-with conv sz x.opnd;
            return
               (SEM_LIN_SCALE
                  {opnd=op,
                   imm=
                     case $imm x of
                        '00': 1
                      | '01': 2
                      | '10': 4
                      | '11': 8
                     end})
         end

      val conv-mem x = conv-with Signed x.psz x.opnd
   in
      case x of
         IMM8 x: conv-imm conv x
       | IMM16 x: conv-imm conv x
       | IMM32 x: conv-imm conv x
       | IMM64 x: conv-imm conv x
       | REG x: conv-reg conv sz x
       | SUM x: conv-sum conv sz x
       | SCALE x: conv-scale conv sz x
       | MEM x:
           do
	     t <- mktemp;
             address <- conv-mem x;
             segmented-load x.sz t x.psz address x.segment;
             expand conv (var t) x.sz sz
           end
      end
   end

val read sz x = conv-with Unsigned sz x
val reads conv sz x = conv-with conv sz x

val read-addr-reg x =
  case x of
     MEM m:
       case m.opnd of
          REG r: r
       end
  end

val read-flow sz x =
   let
      val conv-bv v = return (SEM_LIN_IMM{imm=sx v})
   in
      case x of
         REL8 x: conv-bv x
       | REL16 x: conv-bv x
       | REL32 x: conv-bv x
       | REL64 x: conv-bv x
       | NEARABS x: read sz x
       | FARABS x: read sz x
      end
   end

val near target =
  case target of
     REL8 x: '1'
   | REL16 x: '1'
   | REL32 x: '1'
   | REL64 x: '1'
   | NEARABS x: '1'
   | _: '0'
  end

val far target = not (near target)

val relative target =
  case target of
     REL8 x: '1'
   | REL16 x: '1'
   | REL32 x: '1'
   | REL64 x: '1'
   | _: '0'
  end

val absolute target = not (relative target)

val write-offset sz x offset =
   case x of
     MEM x:
       do
         #Todo: Offset for memory operands?
         address <- conv-with Signed x.psz x.opnd;
         return (SEM_WRITE_MEM{size=x.psz,address=address,segment=x.segment})
       end
    | REG x:
       do 
         id <- return (semantic-register-of x);
	 id <- return (@{offset=id.offset + offset} id);
         return (SEM_WRITE_VAR{size= $size id,id=id})
       end
   end


val write sz x = write-offset sz x 0
val write-upper sz x = write-offset sz x sz

val register? x =
  case x of
      REG: '1'
    | _: '0'
  end

val commit sz a b =
   case a of
      SEM_WRITE_MEM x:
         #store x (SEM_LIN{size=sz,opnd1=b})
	 segmented-store x (SEM_LIN{size=sz,opnd1=b}) x.segment
    | SEM_WRITE_VAR x:
         #TODO: no zero extension when not in 64bit mode
         case sz of
            32:
               case x.id.offset of
                  0:
                     do mov 32 x.id b;
                        # Zero the upper half of the given register/variable
                        mov 32 (@{offset=32} x.id) (SEM_LIN_IMM {imm=0})
                     end
                | _: mov sz x.id b
               end
          | _: mov sz x.id b
         end
   end

val combine high low = do
  high <- return (semantic-register-of high);
  low <- return (semantic-register-of low);
 
  sz <- return high.size;
 
  combined <- mktemp;
  mov sz (at-offset combined sz) (var high);
  mov sz combined (var low);
 
  return combined
end

val fEQ = return (_var VIRT_EQ)
val fNEQ = return (_var VIRT_NEQ)
val fLES = return (_var VIRT_LES)
val fLEU = return (_var VIRT_LEU)
val fLTS = return (_var VIRT_LTS)
val fLTU = return (_var VIRT_LTU)

val zero = return (SEM_LIN_IMM{imm=0})

val _if c _then a _else b = do
  c <- c;
  stack <- pop-all;
  a;
  t <- pop-all;
  b;
  e <- pop-all;
  stack-set stack;
  ite c t e
end

val _if c _then a = do
  _if c _then a _else (return void)
end

val /d cond = return cond

val /and a b = do
  a <- a;
  b <- b;
  t <- mktemp;
  andb 1 t a b;
  return (var t)
end

val /or a b = do
  a <- a;
  b <- b;
  t <- mktemp;
  orb 1 t a b;
  return (var t)
end

val /not a = do
  t <- mktemp;
  xorb 1 t a (imm 1);
  return (var t)
end

val /eq sz a b = do
  t <- mktemp;
  cmpeq sz t a b;
  return (var t)
end

val /neq sz a b = do
  t <- mktemp;
  cmpneq sz t a b;
  return (var t)
end

val /gtu sz a b = do
  t <- mktemp;
  cmpleu sz t a b;
  xorb 1 t (var t) (imm 1);
  return (var t)
end

val _while c __ b = do
  c <- c;
  stack <- pop-all;
  b;
  body <- pop-all;
  stack-set stack;
  while c body
end

val sem-a sem-cc x = do
  cf <- fCF;
  zf <- fZF;
  sem-cc x (/and (/not (var cf)) (/not (var zf)))
end
val sem-nbe sem-cc x = sem-a sem-cc x

val sem-ae sem-cc x = do
  cf <- fCF;
  sem-cc x (/not (var cf))
end
val sem-nb sem-cc x = sem-ae sem-cc x
val sem-nc sem-cc x = sem-ae sem-cc x

val sem-c sem-cc x = do
  cf <- fCF;
  sem-cc x (/d (var cf))
end
val sem-b sem-cc x = sem-c sem-cc x
val sem-nae sem-cc x = sem-nae sem-cc x

val sem-be sem-cc x = do
  cf <- fCF;
  zf <- fZF;
  sem-cc x (/or (/d (var cf)) (/d (var zf)))
end
val sem-na sem-cc x = sem-be sem-cc x

val sem-e sem-cc x = do
  zf <- fZF;
  sem-cc x (/d (var zf))
end
val sem-z sem-cc x = sem-e sem-cc x

val sem-g sem-cc x = do
  zf <- fZF;
  sf <- fSF;
  ov <- fOF;
  sem-cc x (/and (/not (var zf)) (/eq 1 (var sf) (var ov)))
end
val sem-nle sem-cc x = sem-g sem-cc x

val sem-ge sem-cc x = do
  sf <- fSF;
  ov <- fOF;
  sem-cc x (/eq 1 (var sf) (var ov))
end
val sem-nl sem-cc x = sem-ge sem-cc x

val sem-l sem-cc x = do
  sf <- fSF;
  ov <- fOF;
  sem-cc x (/neq 1 (var sf) (var ov))
end
val sem-nge sem-cc x = sem-l sem-cc x

val sem-le sem-cc x = do
  zf <- fZF;
  sf <- fSF;
  ov <- fOF;
  sem-cc x (/or (/d (var zf)) (/neq 1 (var sf) (var ov)))
end
val sem-ng sem-cc x = sem-le sem-cc x

val sem-ne sem-cc x = do
  zf <- fZF;
  sem-cc x (/not (var zf))
end
val sem-nz sem-cc x = sem-ne sem-cc x

val sem-no sem-cc x = do
  ov <- fOF;
  sem-cc x (/not (var ov))
end

val sem-np sem-cc x = do
  pf <- fPF;
  sem-cc x (/not (var pf))
end
val sem-po sem-cc x = sem-np sem-cc x

val sem-ns sem-cc x = do
  sf <- fSF;
  sem-cc x (/not (var sf))
end

val sem-o sem-cc x = do
  ov <- fOF;
  sem-cc x (/d (var ov))
end

val sem-p sem-cc x = do
  pf <- fPF;
  sem-cc x (/d (var pf))
end
val sem-pe sem-cc x = sem-p sem-cc x

val sem-s sem-cc x = do
  sf <- fSF;
  sem-cc x (/d (var sf))
end

val undef-opnd opnd = do
  sz <- sizeof1 opnd;
  a <- write sz opnd;
  t <- mktemp;
  commit sz a (var t)
end

val sem-undef-arity-ge1 x = do
  case x.opnd1 of
     REG r: undef-opnd x.opnd1
   | MEM m: undef-opnd x.opnd1
  end
end

val sem-undef-arity0 x = do
  return void
end

val sem-undef-arity1 x = do
  sem-undef-arity-ge1 x
end

val sem-undef-arity2 x = do
  sem-undef-arity-ge1 x
end

val sem-undef-arity3 x = do
  sem-undef-arity-ge1 x
end

val sem-undef-arity4 x = do
  sem-undef-arity-ge1 x
end

val sem-undef-varity x = do
  case x of
     VA1 x: sem-undef-arity1 x
   | VA2 x: sem-undef-arity2 x
   | VA3 x: sem-undef-arity3 x
   | VA4 x: sem-undef-arity4 x
  end
end

val sem-undef-flow1 x = do
  return void
end

val emit-parity-flag r = do
  byte-size <- return 8;

  low-byte <- mktemp;
  mov byte-size low-byte r;

  pf <- fPF;
  # Bitwise XNOR
  cmpeq 1 pf (var (at-offset low-byte 7)) (var (at-offset low-byte 6));
  cmpeq 1 pf (var pf) (var (at-offset low-byte 5));
  cmpeq 1 pf (var pf) (var (at-offset low-byte 4));
  cmpeq 1 pf (var pf) (var (at-offset low-byte 3));
  cmpeq 1 pf (var pf) (var (at-offset low-byte 2));
  cmpeq 1 pf (var pf) (var (at-offset low-byte 1));
  cmpeq 1 pf (var pf) (var (at-offset low-byte 0))
end

val emit-arithmetic-adjust-flag sz r op0 op1 = do
  # Hacker's Delight - How the Computer Sets Overflow for Signed Add/Subtract
  t <- mktemp;
  xorb sz t r op0;
  xorb sz t (var t) op1;

  andb sz t (var t) (imm 0x10);
  af <- fAF;
  cmpneq sz af (var t) (imm 0)
end

val emit-add-adc-flags sz sum s0 s1 carry set-carry = do
  eq <- fEQ;
  les <- fLES;
  leu <- fLEU;
  lts <- fLTS;
  ltu <- fLTU;
  sf <- fSF;
  ov <- fOF;
  z <- fZF;
  cf <- fCF;
  t1 <- mktemp;
  t2 <- mktemp;
  t3 <- mktemp;
  zer0 <- zero;

  cmpltu sz ltu s0 s1;
  xorb sz t1 sum s0;
  xorb sz t2 sum s1;
  andb sz t3 (var t1) (var t2);
  cmplts sz ov (var t3) zer0;
  cmplts sz sf sum zer0;
  cmpeq sz eq sum zer0;
  xorb 1 lts (var sf) (var ov);
  orb 1 leu (var ltu) (var eq);
  orb 1 les (var lts) (var eq);
  cmpeq sz z sum zer0;

  # Hacker's Delight - Unsigned Add/Subtract
  if set-carry then (
    _if (/d carry) _then do
      cmpleu sz cf sum s0
    end _else do
      cmpltu sz cf sum s0
    end
  ) else
    return void
  ;

  emit-parity-flag sum;
  emit-arithmetic-adjust-flag sz sum s0 s1
end

val emit-sub-sbb-flags sz difference minuend subtrahend carry set-carry = do
  eq <- fEQ;
  les <- fLES;
  leu <- fLEU;
  lts <- fLTS;
  ltu <- fLTU;
  sf <- fSF;
  ov <- fOF;
  cf <- fCF;
  z <- fZF;
  t1 <- mktemp;
  t2 <- mktemp;
  t3 <- mktemp;
  zer0 <- zero;

  cmpltu sz ltu minuend subtrahend;
  cmpleu sz leu minuend subtrahend;
  cmplts sz lts minuend subtrahend;
  cmples sz les minuend subtrahend;
  cmpeq sz eq minuend subtrahend;
  cmplts sz sf difference zer0;
  xorb 1 ov (var lts) (var sf);
  cmpeq sz z difference zer0;

  if set-carry then (
    # Hacker's Delight - Unsigned Add/Subtract
    _if (/d carry) _then do
      cmpleu sz cf minuend subtrahend
    end _else do
      cmpltu sz cf minuend subtrahend
    end
  ) else
    return void
  ;

  emit-parity-flag difference;
  emit-arithmetic-adjust-flag sz difference minuend subtrahend
end

val emit-mul-flags sz product = do
  ov <- fOF;
  cf <- fCF;
  sf <- fSF;
  zf <- fZF;
  af <- fAF;
  pf <- fPF;

  sgn-ext <- mktemp;
  movsx sz sgn-ext 1 (var (at-offset product (sz + sz - 1)));

  cmpneq sz ov (var (at-offset product sz)) (var sgn-ext);
  mov 1 cf (var ov);

  undef 1 sf;
  undef 1 zf;
  undef 1 af;
  undef 1 pf
end

val move-to-rflags size lin = do
  flags <- rflags;

  in-mask <- return 0x0000000000245fd5;
  out-mask <- return 0xffffffffffc3a02a;

  temp <- mktemp;
  andb size temp lin (imm in-mask);
  andb size flags (var flags) (imm out-mask);
  orb size flags (var flags) (var temp)
end

val direction-adjust reg-size reg-sem for-size = do
  amount <-
    case for-size of
       8: return 1
     | 16: return 2
     | 32: return 4
     | 64: return 8
    end
  ;

  df <- fDF;
  _if (/not (var df)) _then
    add reg-size reg-sem (var reg-sem) (imm amount)  
  _else
    sub reg-size reg-sem (var reg-sem) (imm amount)
end

## A>>

val sem-adc x = do
  sz <- sizeof2 x.opnd1 x.opnd2;
  a <- write sz x.opnd1;
  b <- read sz x.opnd1;
  c <- read sz x.opnd2;

  t <- mktemp;
  add sz t b c;

  cf <- fCF;
  tc <- mktemp;
  movzx sz tc 1 (var cf);
  add sz t (var t) (var tc);

  emit-add-adc-flags sz (var t) b c (var cf) '1';
  commit sz a (var t)
end

val sem-add x = do
  sz <- sizeof2 x.opnd1 x.opnd2;
  a <- write sz x.opnd1;
  b <- read sz x.opnd1;
  c <- read sz x.opnd2;
  t <- mktemp;
  add sz t b c;
  emit-add-adc-flags sz (var t) b c (imm 0) '1';
  commit sz a (var t)
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

  dst <- write size x.opnd1;
  commit size dst (var temp)
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

  dst <- write x.opnd-sz x.opnd1;
  commit x.opnd-sz dst (var counter)
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

  dst <- write x.opnd-sz x.opnd1;
  commit x.opnd-sz dst (var counter)
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

  dst <- write size x.opnd1;
  commit size dst (var temp)
end

val sem-bt-complement base-sz base base-opnd shifted offset-ext = do
  output <- mktemp;
  andb base-sz output (var shifted) (imm 1);
  shl base-sz output (var output) (var offset-ext);
  xorb base-sz output (var output) base;
  dst <- write base-sz base-opnd;
  commit base-sz dst (var output)
end

val sem-bt-reset base-sz base base-opnd shifted offset-ext = do
  output <- mktemp;
  xorb base-sz output (imm (0-1)) (imm 1);
  shl base-sz output (var output) (var offset-ext);
  andb base-sz output (var output) base;
  dst <- write base-sz base-opnd;
  commit base-sz dst (var output)
end

val sem-bt-set base-sz base base-opnd shifted offset-ext = do
  output <- mktemp;
  shl base-sz output (imm 1) (var offset-ext);
  orb base-sz output (var output) base;
  dst <- write base-sz base-opnd;
  commit base-sz dst (var output)
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
  ip-sz <-
    if (x.opnd-sz === 64) then
      return 64
    else
      return 32
  ;
  temp-ip <- mktemp;
  
  mode64 <- mode64?;
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
  dst <- write sz x.opnd1;
  dst-read <- read sz x.opnd1;

  src <- read sz x.opnd2;

  temp <- mktemp;
  mov sz temp dst-read;

  _if cond _then
    mov sz temp src
  ;

  commit sz dst (var temp)
end

val sem-cmp x = do
  sz <- sizeof2 x.opnd1 x.opnd2;
  a <- write sz x.opnd1;
  b <- read sz x.opnd1;
  c <- read sz x.opnd2;
  t <- mktemp;
  sub sz t b c;
  emit-sub-sbb-flags sz (var t) b c (imm 0) '1'
end

val sem-cmps x = do
  src0 <- read x.opnd-sz x.opnd1;
  src1-sz <- sizeof1 x.opnd2;
  src1 <- read x.opnd-sz x.opnd2;

  temp <- mktemp;
  sub x.opnd-sz temp src0 src1;
  emit-sub-sbb-flags x.opnd-sz (var temp) src0 src1 (imm 0) '1';

  reg0-sem <- return (semantic-register-of (read-addr-reg x.opnd1));
  reg1-sem <- return (semantic-register-of (read-addr-reg x.opnd2));

  direction-adjust x.addr-sz reg0-sem x.opnd-sz;
  direction-adjust x.addr-sz reg1-sem x.opnd-sz

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
    dst <- write size x.opnd1;
    src <- read size x.opnd2;
    commit size dst src
  end _else do
    dst <- read size x.opnd1;
    mov size minuend dst
  end
end

val sem-cmpxchg16b-cmpxchg8b x = do
  subtrahend <- read (2*x.opnd-sz) x.opnd1;

  minuend <- combine (register-by-size low C x.opnd-sz) (register-by-size low B x.opnd-sz);

  difference <- mktemp;
  sub (2*x.opnd-sz) difference (var minuend) subtrahend;

  emit-sub-sbb-flags (2*x.opnd-sz) (var difference) (var minuend) subtrahend (imm 0) '1';

  zf <- fZF;
  _if (/d (var zf)) _then do
    dst <- write (2*x.opnd-sz) x.opnd1;
    commit (2*x.opnd-sz) dst (var minuend)
  end _else do
    dst <- combine (register-by-size low D x.opnd-sz) (register-by-size low A x.opnd-sz);
    mov (2*x.opnd-sz) dst subtrahend
  end
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
  movsx (src-sem.size + src-sem.size) temp src-sem.size (var src-sem);

  dst-high <-
    case x.opnd-sz of
       16: return DX
     | 32: return EDX
     | 64: return RDX
    end
  ;
  
  dst-high-sem <- return (semantic-register-of dst-high);
  mov dst-high-sem.size dst-high-sem (var (at-offset temp src-sem.size))
end

## D>>

val sem-dec x = do
  sz <- sizeof1 x.opnd1;
  src <- read sz x.opnd1;
  dst <- write sz x.opnd1;

  temp <- mktemp;
  sub sz temp src (imm 1);
  
  emit-sub-sbb-flags sz (var temp) src (imm 1) (imm 0) '0';

  commit sz dst (var temp)
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

  result <- write sz op1;
  commit sz result (var product)
end
val sem-imul-2 x = sem-imul-2-3 x.opnd1 x.opnd1 x.opnd2
val sem-imul-3 x = sem-imul-2-3 x.opnd1 x.opnd2 x.opnd3

val sem-inc x = do
  sz <- sizeof1 x.opnd1;
  src <- read sz x.opnd1;
  dst <- write sz x.opnd1;

  temp <- mktemp;
  add sz temp src (imm 1);
  
  emit-sub-sbb-flags sz (var temp) src (imm 1) (imm 0) '0';

  commit sz dst (var temp)
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

val sem-lea x = do
  opnd-sz <- sizeof1 x.opnd1;
  dst <- write opnd-sz x.opnd1;
  src <-
    case x.opnd2 of
      MEM m: return m
    end
  ;
  addr-sz <- return src.psz;
  address <- conv-with Signed src.psz src.opnd;

  temp <- mktemp;
  movzx opnd-sz temp addr-sz address;

  commit opnd-sz dst (var temp)
end

val sem-lods x = do
  sz <- sizeof1 x.opnd1;
  src <- read sz x.opnd1;

  dst <- return (semantic-register-of (register-by-size low A sz));

  mov dst.size dst src
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

## M>>

val sem-mov x = do
  sz <- sizeof2 x.opnd1 x.opnd2;
  a <- write sz x.opnd1;
  b <- read sz x.opnd2;
  commit sz a b
end

val sem-movap x = do
  sz <- sizeof1 x.opnd1;
  dst <- write sz x.opnd1;
  src <- read sz x.opnd2;

  temp <- mktemp;
  mov sz temp src;

  commit sz dst (var temp)
end

val sem-vmovap x = do
  x <- case x of VA2 x: return x end;

  sz <- sizeof1 x.opnd1;
  dst <- write sz x.opnd1;
  src <- read sz x.opnd2;

  if sz === 128 then
    do
      dst-upper <- write-upper sz x.opnd1;
      commit sz dst-upper (imm 0)
    end
  else
    return void
  ;

  temp <- mktemp;
  mov sz temp src;
  commit sz dst (var temp)
end

val sem-movs x = do
  sz <- sizeof1 x.opnd1;
  src <- read sz x.opnd2;
  dst <- write sz x.opnd1;
  commit sz dst src
end

val sem-movsx x = do
  sz-dst <- sizeof1 x.opnd1;
  sz-src <- sizeof1 x.opnd2;
  dst <- write sz-dst x.opnd1;
  src <- read sz-src x.opnd2;

  temp <- mktemp;
  movsx sz-dst temp sz-src src;

  commit sz-dst dst (var temp)
end

val sem-movzx x = do
  sz-dst <- sizeof1 x.opnd1;
  sz-src <- sizeof1 x.opnd2;
  dst <- write sz-dst x.opnd1;
  src <- read sz-src x.opnd2;

  temp <- mktemp;
  movzx sz-dst temp sz-src src;

  commit sz-dst dst (var temp)
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
   | _: do
       high <- return (semantic-register-of (register-by-size low D sz));
       low <- return (semantic-register-of (register-by-size low A sz));

       mov sz high (var (at-offset product sz));
       mov sz low (var product)
   end
  end
end

## N>>

val sem-nop x = do
  return void
end

## O>>

val sem-or x = do
  sz <- sizeof2 x.opnd1 x.opnd2;
  dst <- write sz x.opnd1;
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

  commit sz dst (var temp)
end

## P>>

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
  dst <- write x.opnd-sz x.opnd1;
  temp-dest <- mktemp;
  ps-pop x.opnd-sz temp-dest;
  commit x.opnd-sz dst (var temp-dest)
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

  ps-push x.opnd-sz (var temp)
end

## Q>>
## R>>

val sem-rep-repe-repne size sem fc = do
  count-reg <- return (semantic-register-of (register-by-size low DI_ size));

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
     VA0 x: sem-ret-without-operand x
   | VA1 x:
       do
         release-from-stack x;
	 sem-ret-without-operand x
       end
  end

val sem-ret-far x =
  case x of
     VA0 x: sem-ret-far-without-operand x
   | VA1 x:
       do
         release-from-stack x;
         sem-ret-far-without-operand x
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
  address <- pop-ip x.opnd-sz;
  ret address
end

val sem-ret-far-without-operand x = do
  address <- pop-ip x.opnd-sz;

  temp-cs <- mktemp;
  ps-pop x.opnd-sz temp-cs;
  
  sec-reg <- return CS;
  sec-reg-sem <- return (semantic-register-of sec-reg);
  reg-size <- sizeof1 (REG sec-reg);

  mov reg-size sec-reg-sem (var temp-cs);

  ret address
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

val sem-sahf x = do
  ah <- return (semantic-register-of AH);
  flags <- rflags;

  move-to-rflags ah.size (var ah)
end

val sem-sal-shl x = do
  sz <- sizeof1 x.opnd1;
  szOp2 <- sizeof1 x.opnd2;
  dst <- write sz x.opnd1;
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

  commit sz dst (var tdst)

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
#  commit sz a (var t2);
#  label nop;
#  cmpeq sz eq b zer0
end

val sem-sar x = do
  sz <- sizeof1 x.opnd1;
  szOp2 <- sizeof1 x.opnd2;
  dst <- write sz x.opnd1;
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

  commit sz dst (var tdst)
end

val sem-sbb x = do
  sz <- sizeof2 x.opnd1 x.opnd2;
  difference <- write sz x.opnd1;
  minuend <- read sz x.opnd1;
  subtrahend <- read sz x.opnd2;

  t <- mktemp;
  cf <- fCF;
  movzx sz t 1 (var cf);
  add sz t (var t) subtrahend;
  sub sz t minuend subtrahend;

  emit-sub-sbb-flags sz (var t) minuend subtrahend (var cf) '1';
  commit sz difference (var t)
end

val sem-setcc x cond = do
  dst-sz <- sizeof1 x.opnd1;
  dst <- write dst-sz x.opnd1;

  cond <- cond;
  temp <- mktemp;
  movzx dst-sz temp 1 cond;

  commit dst-sz dst (var temp)
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
  dst <- write sz x.opnd1;
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

  commit sz dst (var tdst)
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
  difference <- write sz x.opnd1;
  minuend <- read sz x.opnd1;
  subtrahend <- read sz x.opnd2;

  t <- mktemp;
  sub sz t minuend subtrahend;

  emit-sub-sbb-flags sz (var t) minuend subtrahend (imm 0) '1';
  commit sz difference (var t)
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
  dst0 <- write size x.opnd1;
  dst1 <- write size x.opnd2;

  sum <- mktemp;
  add size sum src0 src1;

  emit-add-adc-flags size (var sum) src0 src1 (imm 0) '1';

  commit size dst0 (var sum);
  commit size dst1 src0
end

val sem-xchg x = do
  sz <- sizeof1 x.opnd1;
  a-r <- read sz x.opnd1;
  b-r <- read sz x.opnd2;
  a-w <- write sz x.opnd1;
  b-w <- write sz x.opnd2;

  temp <- mktemp;
  
  mov sz temp a-r;
  commit sz a-w b-r;
  commit sz b-w (var temp)
end

val sem-xor x = do
  sz <- sizeof2 x.opnd1 x.opnd2;
  dst <- write sz x.opnd1;
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

  commit sz dst (var temp)
end

## Y>>
## Z>>

val semantics insn =
  case insn of
     AAA x: sem-undef-arity0 x
   | AAD x: sem-undef-arity1 x
   | AAM x: sem-undef-arity1 x
   | AAS x: sem-undef-arity0 x
   | ADC x: sem-adc x
   | ADD x: sem-add x
   | ADDPD x: sem-undef-arity2 x
   | ADDPS x: sem-undef-arity2 x
   | ADDSD x: sem-undef-arity2 x
   | ADDSS x: sem-undef-arity2 x
   | ADDSUBPD x: sem-undef-arity2 x
   | ADDSUBPS x: sem-undef-arity2 x
   | AESDEC x: sem-undef-arity2 x
   | AESDECLAST x: sem-undef-arity2 x
   | AESENC x: sem-undef-arity2 x
   | AESENCLAST x: sem-undef-arity2 x
   | AESIMC x: sem-undef-arity2 x
   | AESKEYGENASSIST x: sem-undef-arity3 x
   | AND x: sem-undef-arity2 x
   | ANDNPD x: sem-andpd x
   | ANDNPS x: sem-undef-arity2 x
   | ANDPD x: sem-undef-arity2 x
   | ANDPS x: sem-undef-arity2 x
   | ARPL x: sem-undef-arity2 x
   | BLENDPD x: sem-undef-arity3 x
   | BLENDPS x: sem-undef-arity3 x
   | BLENDVPD x: sem-undef-arity3 x
   | BLENDVPS x: sem-undef-arity3 x
   | BOUND x: sem-undef-arity2 x
   | BSF x: sem-bsf x
   | BSR x: sem-bsr x
   | BSWAP x: sem-bswap x
   | BT x: sem-bt x sem-bt-none
   | BTC x: sem-bt x sem-bt-complement
   | BTR x: sem-bt x sem-bt-reset
   | BTS x: sem-bt x sem-bt-set
   | CALL x: sem-call x
   | CBW x: sem-convert 8
   | CDQ x: sem-cwd-cdq-cqo x
   | CDQE x: sem-convert 32
   | CLC x: sem-undef-arity0 x
   | CLD x: sem-undef-arity0 x
   | CLFLUSH x: sem-undef-arity1 x
   | CLI x: sem-undef-arity0 x
   | CLTS x: sem-undef-arity0 x
   | CMC x: sem-cmc
   | CMOVA x: sem-a sem-cmovcc x
   | CMOVAE x: sem-ae sem-cmovcc x
   | CMOVB x: sem-b sem-cmovcc x
   | CMOVBE x: sem-be sem-cmovcc x
   | CMOVC x: sem-c sem-cmovcc x
   | CMOVE x: sem-e sem-cmovcc x
   | CMOVG x: sem-g sem-cmovcc x
   | CMOVGE x: sem-ge sem-cmovcc x
   | CMOVL x: sem-l sem-cmovcc x
   | CMOVLE x: sem-le sem-cmovcc x
   | CMOVNA x: sem-na sem-cmovcc x
   | CMOVNAE x: sem-nae sem-cmovcc x
   | CMOVNB x: sem-nb sem-cmovcc x
   | CMOVNBE x: sem-nbe sem-cmovcc x
   | CMOVNC x: sem-nc sem-cmovcc x
   | CMOVNE x: sem-ne sem-cmovcc x
   | CMOVNG x: sem-ng sem-cmovcc x
   | CMOVNGE x: sem-nge sem-cmovcc x
   | CMOVNL x: sem-nl sem-cmovcc x
   | CMOVNLE x: sem-nle sem-cmovcc x
   | CMOVNO x: sem-no sem-cmovcc x
   | CMOVNP x: sem-np sem-cmovcc x
   | CMOVNS x: sem-ns sem-cmovcc x
   | CMOVNZ x: sem-nz sem-cmovcc x
   | CMOVO x: sem-o sem-cmovcc x
   | CMOVP x: sem-p sem-cmovcc x
   | CMOVPE x: sem-pe sem-cmovcc x
   | CMOVPO x: sem-po sem-cmovcc x
   | CMOVS x: sem-s sem-cmovcc x
   | CMOVZ x: sem-z sem-cmovcc x
   | CMP x: sem-cmp x
   | CMPPD x: sem-undef-arity3 x
   | CMPPS x: sem-undef-arity3 x
   | CMPS x: sem-repe-repne-insn x sem-cmps
   | CMPSD x: sem-undef-arity3 x
#   | CMPSD x:
#       case x of
#         VA0: sem-cmpsd
#       | _ x: sem-undef-arity0 x
#      end
#   | CMPSQ x: sem-undef-arity0 x
   | CMPSS x: sem-undef-arity3 x
   | CMPXCHG x: sem-cmpxchg x
   | CMPXCHG16B x: sem-cmpxchg16b-cmpxchg8b x
   | CMPXCHG8B x: sem-cmpxchg16b-cmpxchg8b x
   | COMISD x: sem-undef-arity2 x
   | COMISS x: sem-undef-arity2 x
   | CPUID x: sem-cpuid x
   | CQO x: sem-cwd-cdq-cqo x
   | CRC32 x: sem-undef-arity2 x
   | CVTDQ2PD x: sem-undef-arity2 x
   | CVTDQ2PS x: sem-undef-arity2 x
   | CVTPD2DQ x: sem-undef-arity2 x
   | CVTPD2PI x: sem-undef-arity2 x
   | CVTPD2PS x: sem-undef-arity2 x
   | CVTPI2PD x: sem-undef-arity2 x
   | CVTPI2PS x: sem-undef-arity2 x
   | CVTPS2DQ x: sem-undef-arity2 x
   | CVTPS2PD x: sem-undef-arity2 x
   | CVTPS2PI x: sem-undef-arity2 x
   | CVTSD2SI x: sem-undef-arity2 x
   | CVTSD2SS x: sem-undef-arity2 x
   | CVTSI2SD x: sem-undef-arity2 x
   | CVTSI2SS x: sem-undef-arity2 x
   | CVTSS2SD x: sem-undef-arity2 x
   | CVTSS2SI x: sem-undef-arity2 x
   | CVTTPD2DQ x: sem-undef-arity2 x
   | CVTTPD2PI x: sem-undef-arity2 x
   | CVTTPS2DQ x: sem-undef-arity2 x
   | CVTTPS2PI x: sem-undef-arity2 x
   | CVTTSD2SI x: sem-undef-arity2 x
   | CVTTSS2SI x: sem-undef-arity2 x
   | CWD x: sem-cwd-cdq-cqo x
   | CWDE x: sem-convert 16
   | DAA x: sem-undef-arity0 x
   | DAS x: sem-undef-arity0 x
   | DEC x: sem-dec x
   | DIV x: sem-div Unsigned x
   | DIVPD x: sem-undef-arity2 x
   | DIVPS x: sem-undef-arity2 x
   | DIVSD x: sem-undef-arity2 x
   | DIVSS x: sem-undef-arity2 x
   | DPPD x: sem-undef-arity3 x
   | DPPS x: sem-undef-arity3 x
   | EMMS x: sem-undef-arity0 x
   | ENTER x: sem-undef-arity2 x
   | EXTRACTPS x: sem-undef-arity3 x
   | F2XM1 x: sem-undef-arity0 x
   | FABS x: sem-undef-arity0 x
   | FADD x: sem-undef-arity2 x
   | FADDP x: sem-undef-arity2 x
   | FBLD x: sem-undef-arity1 x
   | FBSTP x: sem-undef-arity1 x
   | FCHS x: sem-undef-arity0 x
   | FCLEX x: sem-undef-arity0 x
   | FCMOVB x: sem-undef-arity2 x
   | FCMOVBE x: sem-undef-arity2 x
   | FCMOVE x: sem-undef-arity2 x
   | FCMOVNB x: sem-undef-arity2 x
   | FCMOVNBE x: sem-undef-arity2 x
   | FCMOVNE x: sem-undef-arity2 x
   | FCMOVNU x: sem-undef-arity2 x
   | FCMOVU x: sem-undef-arity2 x
   | FCOM x: sem-undef-arity1 x
   | FCOMI x: sem-undef-arity2 x
   | FCOMIP x: sem-undef-arity2 x
   | FCOMP x: sem-undef-arity1 x
   | FCOMPP x: sem-undef-arity0 x
   | FCOS x: sem-undef-arity0 x
   | FDECSTP x: sem-undef-arity0 x
   | FDIV x: sem-undef-arity2 x
   | FDIVP x: sem-undef-arity2 x
   | FDIVR x: sem-undef-arity2 x
   | FDIVRP x: sem-undef-arity2 x
   | FFREE x: sem-undef-arity1 x
   | FIADD x: sem-undef-arity1 x
   | FICOM x: sem-undef-arity1 x
   | FICOMP x: sem-undef-arity1 x
   | FIDIV x: sem-undef-arity2 x
   | FIDIVR x: sem-undef-arity1 x
   | FILD x: sem-undef-arity1 x
   | FIMUL x: sem-undef-arity1 x
   | FINCSTP x: sem-undef-arity0 x
   | FINIT x: sem-undef-arity0 x
   | FIST x: sem-undef-arity1 x
   | FISTP x: sem-undef-arity1 x
   | FISTTP x: sem-undef-arity1 x
   | FISUB x: sem-undef-arity1 x
   | FISUBR x: sem-undef-arity1 x
   | FLD x: sem-undef-arity1 x
   | FLD1 x: sem-undef-arity0 x
   | FLDCW x: sem-undef-arity1 x
   | FLDENV x: sem-undef-arity1 x
   | FLDL2E x: sem-undef-arity0 x
   | FLDL2T x: sem-undef-arity0 x
   | FLDLG2 x: sem-undef-arity0 x
   | FLDLN2 x: sem-undef-arity0 x
   | FLDPI x: sem-undef-arity0 x
   | FLDZ x: sem-undef-arity0 x
   | FMUL x: sem-undef-arity2 x
   | FMULP x: sem-undef-arity2 x
   | FNCLEX x: sem-undef-arity0 x
   | FNINIT x: sem-undef-arity0 x
   | FNOP x: sem-undef-arity0 x
   | FNSAVE x: sem-undef-arity1 x
   | FNSTCW x: sem-undef-arity1 x
   | FNSTENV x: sem-undef-arity1 x
   | FNSTSW x: sem-undef-arity1 x
   | FPATAN x: sem-undef-arity0 x
   | FPREM1 x: sem-undef-arity0 x
   | FPREM x: sem-undef-arity0 x
   | FPTAN x: sem-undef-arity0 x
   | FRNDINT x: sem-undef-arity0 x
   | FRSTOR x: sem-undef-arity1 x
   | FSAVE x: sem-undef-arity1 x
   | FSCALE x: sem-undef-arity0 x
   | FSIN x: sem-undef-arity0 x
   | FSINCOS x: sem-undef-arity0 x
   | FSQRT x: sem-undef-arity0 x
   | FST x: sem-undef-arity1 x
   | FSTCW x: sem-undef-arity1 x
   | FSTENV x: sem-undef-arity1 x
   | FSTP x: sem-undef-arity1 x
   | FSTSW x: sem-undef-arity1 x
   | FSUB x: sem-undef-arity2 x
   | FSUBP x: sem-undef-arity2 x
   | FSUBR x: sem-undef-arity2 x
   | FSUBRP x: sem-undef-arity2 x
   | FTST x: sem-undef-arity0 x
   | FUCOM x: sem-undef-arity1 x
   | FUCOMI x: sem-undef-arity1 x
   | FUCOMIP x: sem-undef-arity1 x
   | FUCOMP x: sem-undef-arity1 x
   | FUCOMPP x: sem-undef-arity0 x
   | FXAM x: sem-undef-arity0 x
   | FXCH x: sem-undef-arity1 x
   | FXRSTOR x: sem-undef-arity1 x
   | FXRSTOR64 x: sem-undef-arity1 x
   | FXSAVE x: sem-undef-arity1 x
   | FXSAVE64 x: sem-undef-arity1 x
   | FXTRACT x: sem-undef-arity0 x
   | FYL2X x: sem-undef-arity0 x
   | FYL2XP1 x: sem-undef-arity0 x
   | HADDPD x: sem-undef-arity2 x
   | HADDPS x: sem-undef-arity2 x
   | HLT x: sem-undef-arity0 x
   | HSUBPD x: sem-undef-arity2 x
   | HSUBPS x: sem-undef-arity2 x
   | IDIV x: sem-idiv x
   | IMUL v:
       case v of
          VA1 x: sem-imul-1 x
        | VA2 x: sem-imul-2 x
        | VA3 x: sem-imul-3 x
       end
   | IN x: sem-undef-arity2 x
   | INC x: sem-inc x
   | INSB x: sem-undef-arity0 x
   | INSD x: sem-undef-arity0 x
   | INSERTPS x: sem-undef-arity3 x
   | INSW x: sem-undef-arity0 x
   | INT x: sem-undef-arity1 x
   | INT0 x: sem-undef-arity0 x
   | INT3 x: sem-undef-arity0 x
   | INVD x: sem-invd
   | INVLPG x: sem-undef-arity1 x
   | INVPCID x: sem-undef-arity2 x
   | IRET x: sem-undef-arity0 x
   | IRETD x: sem-undef-arity0 x
   | IRETQ x: sem-undef-arity0 x
   | JA x: sem-a sem-jcc x
   | JAE x: sem-ae sem-jcc x
   | JB x: sem-b sem-jcc x
   | JBE x: sem-be sem-jcc x
   | JC x: sem-c sem-jcc x
   | JCXZ x: sem-jcxz x
   | JE x: sem-e sem-jcc x
   | JECXZ x: sem-jecxz x
   | JG x: sem-g sem-jcc x
   | JGE x: sem-ge sem-jcc x
   | JL x: sem-l sem-jcc x
   | JLE x: sem-le sem-jcc x
   | JMP x: sem-jmp x
   | JNA x: sem-na sem-jcc x
   | JNAE x: sem-nae sem-jcc x
   | JNB x: sem-nb sem-jcc x
   | JNBE x: sem-nbe sem-jcc x
   | JNC x: sem-nc sem-jcc x
   | JNE x: sem-ne sem-jcc x
   | JNG x: sem-ng sem-jcc x
   | JNGE x: sem-nge sem-jcc x
   | JNL x: sem-nl sem-jcc x
   | JNLE x: sem-nle sem-jcc x
   | JNO x: sem-no sem-jcc x
   | JNP x: sem-np sem-jcc x
   | JNS x: sem-ns sem-jcc x
   | JNZ x: sem-nz sem-jcc x
   | JO x: sem-o sem-jcc x
   | JP x: sem-p sem-jcc x
   | JPE x: sem-pe sem-jcc x
   | JPO x: sem-po sem-jcc x
   | JRCXZ x: sem-jrcxz x
   | JS x: sem-s sem-jcc x
   | JZ x: sem-z sem-jcc x
   | LAHF x: sem-lahf
   | LAR x: sem-undef-arity2 x
   | LDDQU x: sem-undef-arity2 x
   | LDMXCSR x: sem-undef-arity1 x
   | LDS x: sem-undef-arity2 x
   | LEA x: sem-lea x
   | LEAVE x: sem-undef-arity0 x
   | LES x: sem-undef-arity2 x
   | LFENCE x: sem-undef-arity0 x
   | LFS x: sem-undef-arity2 x
   | LGDT x: sem-undef-arity1 x
   | LGS x: sem-undef-arity2 x
   | LIDT x: sem-undef-arity1 x
   | LLDT x: sem-undef-arity1 x
   | LMSW x: sem-undef-arity1 x
   | LODS x: sem-rep-insn x sem-lods
   | LOOP x: sem-loop x
   | LOOPE x: sem-loope x
   | LOOPNE x: sem-loopne x
   | LSL x: sem-undef-arity2 x
   | LSS x: sem-undef-arity2 x
   | LTR x: sem-undef-arity1 x
   | MASKMOVDQU x: sem-undef-arity2 x
   | MASKMOVQ x: sem-undef-arity2 x
   | MAXPD x: sem-undef-arity2 x
   | MAXPS x: sem-undef-arity2 x
   | MAXSD x: sem-undef-arity2 x
   | MAXSS x: sem-undef-arity2 x
   | MFENCE x: sem-undef-arity0 x
   | MINPD x: sem-undef-arity2 x
   | MINPS x: sem-undef-arity2 x
   | MINSD x: sem-undef-arity2 x
   | MINSS x: sem-undef-arity2 x
   | MONITOR x: sem-undef-arity0 x
   | MOV x: sem-mov x
   | MOVAPD x: sem-movap x
   | MOVAPS x: sem-movap x
   | MOVBE x: sem-undef-arity2 x
   | MOVD x: sem-undef-arity2 x
   | MOVDDUP x: sem-undef-arity2 x
   | MOVDQ2Q x: sem-undef-arity2 x
   | MOVDQA x: sem-undef-arity2 x
   | MOVDQU x: sem-undef-arity2 x
   | MOVHLPS x: sem-undef-arity2 x
   | MOVHPD x: sem-undef-arity2 x
   | MOVHPS x: sem-undef-arity2 x
   | MOVLHPS x: sem-undef-arity2 x
   | MOVLPD x: sem-undef-arity2 x
   | MOVLPS x: sem-undef-arity2 x
   | MOVMSKPD x: sem-undef-arity2 x
   | MOVMSKPS x: sem-undef-arity2 x
   | MOVNTDQ x: sem-undef-arity2 x
   | MOVNTDQA x: sem-undef-arity2 x
   | MOVNTI x: sem-undef-arity2 x
   | MOVNTPD x: sem-undef-arity2 x
   | MOVNTPS x: sem-undef-arity2 x
   | MOVNTQ x: sem-undef-arity2 x
   | MOVQ x: sem-undef-arity2 x
   | MOVQ2DQ x: sem-undef-arity2 x
   | MOVS x: sem-rep-insn x sem-movs
   | MOVSD x: sem-undef-arity2 x
   | MOVSHDUP x: sem-undef-arity2 x
   | MOVSLDUP x: sem-undef-arity2 x
   | MOVSS x: sem-undef-arity2 x
   | MOVSW x: sem-undef-arity2 x
   | MOVSX x: sem-movsx x
   | MOVSXD x: sem-movsx x
   | MOVUPD x: sem-undef-arity2 x
   | MOVUPS x: sem-undef-arity2 x
   | MOVZX x: sem-movzx x
   | MPSADBW x: sem-undef-arity3 x
   | MUL x: sem-mul Unsigned x
   | MULPD x: sem-undef-arity2 x
   | MULPS x: sem-undef-arity2 x
   | MULSD x: sem-undef-arity2 x
   | MULSS x: sem-undef-arity2 x
   | MWAIT x: sem-undef-arity0 x
   | NEG x: sem-undef-arity1 x
   | NOP x: sem-nop x
   | NOT x: sem-undef-arity1 x
   | OR x: sem-or x
   | ORPD x: sem-undef-arity2 x
   | ORPS x: sem-undef-arity2 x
   | OUT x: sem-undef-arity2 x
   | OUTS x: sem-undef-arity0 x
   | OUTSB x: sem-undef-arity0 x
   | OUTSD x: sem-undef-arity0 x
   | OUTSW x: sem-undef-arity0 x
   | PABSB x: sem-undef-arity2 x
   | PABSD x: sem-undef-arity2 x
   | PABSW x: sem-undef-arity2 x
   | PACKSSDW x: sem-undef-arity2 x
   | PACKSSWB x: sem-undef-arity2 x
   | PACKUSDW x: sem-undef-arity2 x
   | PACKUSWB x: sem-undef-arity2 x
   | PADDB x: sem-undef-arity2 x
   | PADDD x: sem-undef-arity2 x
   | PADDQ x: sem-undef-arity2 x
   | PADDSB x: sem-undef-arity2 x
   | PADDSW x: sem-undef-arity2 x
   | PADDUSB x: sem-undef-arity2 x
   | PADDUSW x: sem-undef-arity2 x
   | PADDW x: sem-undef-arity2 x
   | PALIGNR x: sem-undef-arity3 x
   | PAND x: sem-undef-arity2 x
   | PANDN x: sem-undef-arity2 x
   | PAUSE x: sem-undef-arity0 x
   | PAVGB x: sem-undef-arity2 x
   | PAVGW x: sem-undef-arity2 x
   | PBLENDVB x: sem-undef-arity2 x
   | PBLENDW x: sem-undef-arity3 x
   | PCLMULQDQ x: sem-undef-arity3 x
   | PCMPEQB x: sem-undef-arity2 x
   | PCMPEQD x: sem-undef-arity2 x
   | PCMPEQQ x: sem-undef-arity2 x
   | PCMPEQW x: sem-undef-arity2 x
   | PCMPESTRI x: sem-undef-arity3 x
   | PCMPESTRM x: sem-undef-arity3 x
   | PCMPGRD x: sem-undef-arity2 x
   | PCMPGTB x: sem-undef-arity2 x
   | PCMPGTD x: sem-undef-arity2 x
   | PCMPGTQ x: sem-undef-arity2 x
   | PCMPGTW x: sem-undef-arity2 x
   | PCMPISTRI x: sem-undef-arity3 x
   | PCMPISTRM x: sem-undef-arity3 x
   | PEXTRB x: sem-undef-arity3 x
   | PEXTRD x: sem-undef-arity3 x
   | PEXTRQ x: sem-undef-arity3 x
   | PEXTRW x: sem-undef-arity3 x
   | PHADDD x: sem-undef-arity2 x
   | PHADDSW x: sem-undef-arity2 x
   | PHADDW x: sem-undef-arity2 x
   | PHMINPOSUW x: sem-undef-arity2 x
   | PHSUBD x: sem-undef-arity2 x
   | PHSUBSW x: sem-undef-arity2 x
   | PHSUBW x: sem-undef-arity2 x
   | PINSRB x: sem-undef-arity3 x
   | PINSRD x: sem-undef-arity3 x
   | PINSRQ x: sem-undef-arity3 x
   | PINSRW x: sem-undef-arity3 x
   | PMADDUBSW x: sem-undef-arity2 x
   | PMADDWD x: sem-undef-arity2 x
   | PMAXSB x: sem-undef-arity2 x
   | PMAXSD x: sem-undef-arity2 x
   | PMAXSW x: sem-undef-arity2 x
   | PMAXUB x: sem-undef-arity2 x
   | PMAXUD x: sem-undef-arity2 x
   | PMAXUW x: sem-undef-arity2 x
   | PMINSB x: sem-undef-arity2 x
   | PMINSD x: sem-undef-arity2 x
   | PMINSW x: sem-undef-arity2 x
   | PMINUB x: sem-undef-arity2 x
   | PMINUD x: sem-undef-arity2 x
   | PMINUW x: sem-undef-arity2 x
   | PMOVMSKB x: sem-undef-arity2 x
   | PMOVSXBD x: sem-undef-arity2 x
   | PMOVSXBQ x: sem-undef-arity2 x
   | PMOVSXBW x: sem-undef-arity2 x
   | PMOVSXDQ x: sem-undef-arity2 x
   | PMOVSXWD x: sem-undef-arity2 x
   | PMOVSXWQ x: sem-undef-arity2 x
   | PMOVZXBD x: sem-undef-arity2 x
   | PMOVZXBQ x: sem-undef-arity2 x
   | PMOVZXBW x: sem-undef-arity2 x
   | PMOVZXDQ x: sem-undef-arity2 x
   | PMOVZXWD x: sem-undef-arity2 x
   | PMOVZXWQ x: sem-undef-arity2 x
   | PMULDQ x: sem-undef-arity2 x
   | PMULHRSW x: sem-undef-arity2 x
   | PMULHUW x: sem-undef-arity2 x
   | PMULHW x: sem-undef-arity2 x
   | PMULLD x: sem-undef-arity2 x
   | PMULLW x: sem-undef-arity2 x
   | PMULUDQ x: sem-undef-arity2 x
   | POP x: sem-pop x
   | POPA x: sem-undef-arity0 x
   | POPAD x: sem-undef-arity0 x
   | POPCNT x: sem-undef-arity2 x
   | POPF x: sem-popf x
   | POPFD x: sem-popf x
   | POPFQ x: sem-popf x
   | POR x: sem-undef-arity2 x
   | PREFETCHNTA x: sem-undef-arity1 x
   | PREFETCHT0 x: sem-undef-arity1 x
   | PREFETCHT1 x: sem-undef-arity1 x
   | PREFETCHT2 x: sem-undef-arity1 x
   | PREFETCHW x: sem-undef-arity1 x
   | PSADBW x: sem-undef-arity2 x
   | PSHUFB x: sem-undef-arity2 x
   | PSHUFD x: sem-undef-arity3 x
   | PSHUFHW x: sem-undef-arity3 x
   | PSHUFLW x: sem-undef-arity3 x
   | PSHUFW x: sem-undef-arity3 x
   | PSIGNB x: sem-undef-arity2 x
   | PSIGND x: sem-undef-arity2 x
   | PSIGNW x: sem-undef-arity2 x
   | PSLLD x: sem-undef-arity2 x
   | PSLLDQ x: sem-undef-arity2 x
   | PSLLQ x: sem-undef-arity2 x
   | PSLLW x: sem-undef-arity2 x
   | PSRAD x: sem-undef-arity2 x
   | PSRAW x: sem-undef-arity2 x
   | PSRLD x: sem-undef-arity2 x
   | PSRLDQ x: sem-undef-arity2 x
   | PSRLQ x: sem-undef-arity2 x
   | PSRLW x: sem-undef-arity2 x
   | PSUBB x: sem-undef-arity2 x
   | PSUBD x: sem-undef-arity2 x
   | PSUBQ x: sem-undef-arity2 x
   | PSUBSB x: sem-undef-arity2 x
   | PSUBSW x: sem-undef-arity2 x
   | PSUBUSB x: sem-undef-arity2 x
   | PSUBUSW x: sem-undef-arity2 x
   | PSUBW x: sem-undef-arity2 x
   | PTEST x: sem-undef-arity2 x
   | PUNPCKHBW x: sem-undef-arity2 x
   | PUNPCKHDQ x: sem-undef-arity2 x
   | PUNPCKHQDQ x: sem-undef-arity2 x
   | PUNPCKHWD x: sem-undef-arity2 x
   | PUNPCKLBW x: sem-undef-arity2 x
   | PUNPCKLDQ x: sem-undef-arity2 x
   | PUNPCKLQDQ x: sem-undef-arity2 x
   | PUNPCKLWD x: sem-undef-arity2 x
   | PUSH x: sem-push x
   | PUSHA x: sem-undef-arity0 x
   | PUSHAD x: sem-undef-arity0 x
   | PUSHF x: sem-pushf x
   | PUSHFD x: sem-pushf x
   | PUSHFQ x: sem-pushf x
   | PXOR x: sem-undef-arity2 x
   | RCL x: sem-undef-arity2 x
   | RCPPS x: sem-undef-arity2 x
   | RCPSS x: sem-undef-arity2 x
   | RCR x: sem-undef-arity2 x
   | RDFSBASE x: sem-undef-arity1 x
   | RDGSBASE x: sem-undef-arity1 x
   | RDMSR x: sem-undef-arity0 x
   | RDPMC x: sem-undef-arity0 x
   | RDRAND x: sem-undef-arity1 x
   | RDTSC x: sem-undef-arity0 x
   | RDTSCP x: sem-undef-arity0 x
   | RET x: sem-ret x
   | RET_FAR x: sem-ret-far x
   | ROL x: sem-undef-arity2 x
   | ROR x: sem-undef-arity2 x
   | ROUNDPD x: sem-undef-arity3 x
   | ROUNDPS x: sem-undef-arity3 x
   | ROUNDSD x: sem-undef-arity3 x
   | ROUNDSS x: sem-undef-arity3 x
   | RSM x: sem-undef-arity0 x
   | RSQRTPS x: sem-undef-arity2 x
   | RSQRTSS x: sem-undef-arity2 x
   | SAHF x: sem-sahf x
   | SAL x: sem-sal-shl x
   | SAR x: sem-sar x
   | SBB x: sem-sbb x
   | SCASB x: sem-scas 8 x
   | SCASD x: sem-scas 32 x
   | SCASQ x: sem-scas 64 x
   | SCASW x: sem-scas 16 x
   | SETA x: sem-a sem-setcc x
   | SETAE x: sem-ae sem-setcc x
   | SETB x: sem-b sem-setcc x
   | SETBE x: sem-be sem-setcc x
   | SETC x: sem-c sem-setcc x
   | SETE x: sem-e sem-setcc x
   | SETG x: sem-g sem-setcc x
   | SETGE x: sem-ge sem-setcc x
   | SETL x: sem-l sem-setcc x
   | SETLE x: sem-le sem-setcc x
   | SETNA x: sem-na sem-setcc x
   | SETNAE x: sem-nae sem-setcc x
   | SETNB x: sem-nb sem-setcc x
   | SETNBE x: sem-nbe sem-setcc x
   | SETNC x: sem-nc sem-setcc x
   | SETNE x: sem-ne sem-setcc x
   | SETNG x: sem-ng sem-setcc x
   | SETNGE x: sem-nge sem-setcc x
   | SETNL x: sem-nl sem-setcc x
   | SETNLE x: sem-nle sem-setcc x
   | SETNO x: sem-no sem-setcc x
   | SETNP x: sem-np sem-setcc x
   | SETNS x: sem-ns sem-setcc x
   | SETNZ x: sem-nz sem-setcc x
   | SETO x: sem-o sem-setcc x
   | SETP x: sem-p sem-setcc x
   | SETPE x: sem-pe sem-setcc x
   | SETPO x: sem-po sem-setcc x
   | SETS x: sem-s sem-setcc x
   | SETZ x: sem-z sem-setcc x
   | SFENCE x: sem-undef-arity0 x
   | SGDT x: sem-undef-arity1 x
   | SHL x: sem-sal-shl x
   | SHLD x: sem-undef-arity3 x
   | SHR x: sem-shr x
   | SHRD x: sem-undef-arity3 x
   | SHUFPD x: sem-undef-arity3 x
   | SHUFPS x: sem-undef-arity3 x
   | SIDT x: sem-undef-arity1 x
   | SLDT x: sem-undef-arity1 x
   | SMSW x: sem-undef-arity1 x
   | SQRTPD x: sem-undef-arity2 x
   | SQRTPS x: sem-undef-arity2 x
   | SQRTSD x: sem-undef-arity2 x
   | SQRTSS x: sem-undef-arity2 x
   | STC x: sem-stc
   | STD x: sem-std
   | STI x: sem-undef-arity0 x
   | STMXCSR x: sem-undef-arity1 x
   | STOSB x: sem-stos 8 x
   | STOSD x: sem-stos 32 x
   | STOSQ x: sem-stos 64 x
   | STOSW x: sem-stos 16 x
   | STR x: sem-undef-arity1 x
   | SUB x: sem-sub x
   | SUBPD x: sem-undef-arity2 x
   | SUBPS x: sem-undef-arity2 x
   | SUBSD x: sem-undef-arity2 x
   | SUBSS x: sem-undef-arity2 x
   | SWAPGS x: sem-undef-arity0 x
   | SYSCALL x: sem-undef-arity0 x
   | SYSENTER x: sem-undef-arity0 x
   | SYSEXIT x: sem-undef-arity0 x
   | SYSRET x: sem-undef-arity0 x
   | TEST x: sem-test x
   | UCOMISD x: sem-undef-arity2 x
   | UCOMISS x: sem-undef-arity2 x
   | UD2 x: sem-undef-arity0 x
   | UNPCKHPD x: sem-undef-arity2 x
   | UNPCKHPS x: sem-undef-arity2 x
   | UNPCKLPD x: sem-undef-arity2 x
   | UNPCKLPS x: sem-undef-arity2 x
   | VADDPD x: sem-undef-varity x
   | VADDPS x: sem-undef-varity x
   | VADDSD x: sem-undef-varity x
   | VADDSS x: sem-undef-varity x
   | VADDSUBPD x: sem-undef-varity x
   | VADDSUBPS x: sem-undef-varity x
   | VAESDEC x: sem-undef-varity x
   | VAESDECLAST x: sem-undef-varity x
   | VAESENC x: sem-undef-varity x
   | VAESENCLAST x: sem-undef-varity x
   | VAESIMC x: sem-undef-varity x
   | VAESKEYGENASSIST x: sem-undef-varity x
   | VANDNPD v: sem-undef-varity v
   | VANDNPS x: sem-undef-varity x
   | VANDPD v:
       case v of
          VA3 x: sem-vandpd x
       end
   | VANDPS x: sem-undef-varity x
   | VBLENDPD x: sem-undef-varity x
   | VBLENDPS x: sem-undef-varity x
   | VBLENDVPD x: sem-undef-varity x
   | VBLENDVPS x: sem-undef-varity x
   | VBROADCASTF128 x: sem-undef-varity x
   | VBROADCASTSD x: sem-undef-varity x
   | VBROADCASTSS x: sem-undef-varity x
   | VCMPEQB x: sem-undef-varity x
   | VCMPEQD x: sem-undef-varity x
   | VCMPEQW x: sem-undef-varity x
   | VCMPPD x: sem-undef-varity x
   | VCMPPS x: sem-undef-varity x
   | VCMPSD x: sem-undef-varity x
   | VCMPSS x: sem-undef-varity x
   | VCOMISD x: sem-undef-varity x
   | VCOMISS x: sem-undef-varity x
   | VCVTDQ2PD x: sem-undef-varity x
   | VCVTDQ2PS x: sem-undef-varity x
   | VCVTPD2DQ x: sem-undef-varity x
   | VCVTPD2PS x: sem-undef-varity x
   | VCVTPH2PS x: sem-undef-varity x
   | VCVTPS2DQ x: sem-undef-varity x
   | VCVTPS2PD x: sem-undef-varity x
   | VCVTPS2PH x: sem-undef-varity x
   | VCVTSD2SI x: sem-undef-varity x
   | VCVTSD2SS x: sem-undef-varity x
   | VCVTSI2SD x: sem-undef-varity x
   | VCVTSI2SS x: sem-undef-varity x
   | VCVTSS2SD x: sem-undef-varity x
   | VCVTSS2SI x: sem-undef-varity x
   | VCVTTPD2DQ x: sem-undef-varity x
   | VCVTTPS2DQ x: sem-undef-varity x
   | VCVTTSD2SI x: sem-undef-varity x
   | VCVTTSS2SI x: sem-undef-varity x
   | VDIVPD x: sem-undef-varity x
   | VDIVPS x: sem-undef-varity x
   | VDIVSD x: sem-undef-varity x
   | VDIVSS x: sem-undef-varity x
   | VDPPD x: sem-undef-varity x
   | VDPPS x: sem-undef-varity x
   | VERR x: sem-undef-arity1 x
   | VERW x: sem-undef-arity1 x
   | VEXTRACTF128 x: sem-undef-varity x
   | VEXTRACTPS x: sem-undef-varity x
   | VHADDPD x: sem-undef-varity x
   | VHADDPS x: sem-undef-varity x
   | VHSUBPD x: sem-undef-varity x
   | VHSUBPS x: sem-undef-varity x
   | VINSERTF128 x: sem-undef-varity x
   | VINSERTPS x: sem-undef-varity x
   | VLDDQU x: sem-undef-varity x
   | VLDMXCSR x: sem-undef-varity x
   | VMASKMOVDQU x: sem-undef-varity x
   | VMASKMOVPD x: sem-undef-varity x
   | VMASKMOVPS x: sem-undef-varity x
   | VMAXPD x: sem-undef-varity x
   | VMAXPS x: sem-undef-varity x
   | VMAXSD x: sem-undef-varity x
   | VMAXSS x: sem-undef-varity x
   | VMINPD x: sem-undef-varity x
   | VMINPS x: sem-undef-varity x
   | VMINSD x: sem-undef-varity x
   | VMINSS x: sem-undef-varity x
   | VMOVAPD x: sem-vmovap x
   | VMOVAPS x: sem-vmovap x
   | VMOVD x: sem-undef-varity x
   | VMOVDDUP x: sem-undef-varity x
   | VMOVDQA x: sem-undef-varity x
   | VMOVDQU x: sem-undef-varity x
   | VMOVHLPS x: sem-undef-varity x
   | VMOVHPD x: sem-undef-varity x
   | VMOVHPS x: sem-undef-varity x
   | VMOVLHPS x: sem-undef-varity x
   | VMOVLPD x: sem-undef-varity x
   | VMOVLPS x: sem-undef-varity x
   | VMOVMSKPD x: sem-undef-varity x
   | VMOVMSKPS x: sem-undef-varity x
   | VMOVNTDQ x: sem-undef-varity x
   | VMOVNTDQA x: sem-undef-varity x
   | VMOVNTPD x: sem-undef-varity x
   | VMOVNTPS x: sem-undef-varity x
   | VMOVQ x: sem-undef-varity x
   | VMOVSD x: sem-undef-varity x
   | VMOVSHDUP x: sem-undef-varity x
   | VMOVSLDUP x: sem-undef-varity x
   | VMOVSS x: sem-undef-varity x
   | VMOVUPD x: sem-undef-varity x
   | VMOVUPS x: sem-undef-varity x
   | VMPSADBW x: sem-undef-varity x
   | VMULPD x: sem-undef-varity x
   | VMULPS x: sem-undef-varity x
   | VMULSD x: sem-undef-varity x
   | VMULSS x: sem-undef-varity x
   | VORPD x: sem-undef-varity x
   | VORPS x: sem-undef-varity x
   | VPABSB x: sem-undef-varity x
   | VPABSD x: sem-undef-varity x
   | VPABSW x: sem-undef-varity x
   | VPACKSSDW x: sem-undef-varity x
   | VPACKSSWB x: sem-undef-varity x
   | VPACKUSDW x: sem-undef-varity x
   | VPACKUSWB x: sem-undef-varity x
   | VPADDB x: sem-undef-varity x
   | VPADDD x: sem-undef-varity x
   | VPADDQ x: sem-undef-varity x
   | VPADDSB x: sem-undef-varity x
   | VPADDSW x: sem-undef-varity x
   | VPADDUSB x: sem-undef-varity x
   | VPADDUSW x: sem-undef-varity x
   | VPADDW x: sem-undef-varity x
   | VPALIGNR x: sem-undef-varity x
   | VPAND x: sem-undef-varity x
   | VPANDN x: sem-undef-varity x
   | VPAVGB x: sem-undef-varity x
   | VPAVGW x: sem-undef-varity x
   | VPBLENDVB x: sem-undef-varity x
   | VPBLENDW x: sem-undef-varity x
   | VPCLMULQDQ x: sem-undef-varity x
   | VPCMPEQB x: sem-undef-varity x
   | VPCMPEQD x: sem-undef-varity x
   | VPCMPEQQ x: sem-undef-varity x
   | VPCMPEQW x: sem-undef-varity x
   | VPCMPESTRI x: sem-undef-varity x
   | VPCMPESTRM x: sem-undef-varity x
   | VPCMPGTB x: sem-undef-varity x
   | VPCMPGTD x: sem-undef-varity x
   | VPCMPGTQ x: sem-undef-varity x
   | VPCMPGTW x: sem-undef-varity x
   | VPCMPISTRI x: sem-undef-varity x
   | VPCMPISTRM x: sem-undef-varity x
   | VPERM2F128 x: sem-undef-varity x
   | VPERMILPD x: sem-undef-varity x
   | VPERMILPS x: sem-undef-varity x
   | VPEXTRB x: sem-undef-varity x
   | VPEXTRD x: sem-undef-varity x
   | VPEXTRQ x: sem-undef-varity x
   | VPEXTRW x: sem-undef-varity x
   | VPHADDD x: sem-undef-varity x
   | VPHADDSW x: sem-undef-varity x
   | VPHADDW x: sem-undef-varity x
   | VPHMINPOSUW x: sem-undef-varity x
   | VPHSUBD x: sem-undef-varity x
   | VPHSUBSW x: sem-undef-varity x
   | VPHSUBW x: sem-undef-varity x
   | VPINSRB x: sem-undef-varity x
   | VPINSRD x: sem-undef-varity x
   | VPINSRQ x: sem-undef-varity x
   | VPINSRW x: sem-undef-varity x
   | VPMADDUBSW x: sem-undef-varity x
   | VPMADDWD x: sem-undef-varity x
   | VPMAXSB x: sem-undef-varity x
   | VPMAXSD x: sem-undef-varity x
   | VPMAXSW x: sem-undef-varity x
   | VPMAXUB x: sem-undef-varity x
   | VPMAXUD x: sem-undef-varity x
   | VPMAXUW x: sem-undef-varity x
   | VPMINSB x: sem-undef-varity x
   | VPMINSD x: sem-undef-varity x
   | VPMINSW x: sem-undef-varity x
   | VPMINUB x: sem-undef-varity x
   | VPMINUD x: sem-undef-varity x
   | VPMINUW x: sem-undef-varity x
   | VPMOVMSKB x: sem-undef-varity x
   | VPMOVSXBD x: sem-undef-varity x
   | VPMOVSXBQ x: sem-undef-varity x
   | VPMOVSXBW x: sem-undef-varity x
   | VPMOVSXDQ x: sem-undef-varity x
   | VPMOVSXWD x: sem-undef-varity x
   | VPMOVSXWQ x: sem-undef-varity x
   | VPMOVZXBD x: sem-undef-varity x
   | VPMOVZXBQ x: sem-undef-varity x
   | VPMOVZXBW x: sem-undef-varity x
   | VPMOVZXDQ x: sem-undef-varity x
   | VPMOVZXWD x: sem-undef-varity x
   | VPMOVZXWQ x: sem-undef-varity x
   | VPMULDQ x: sem-undef-varity x
   | VPMULHRSW x: sem-undef-varity x
   | VPMULHUW x: sem-undef-varity x
   | VPMULHW x: sem-undef-varity x
   | VPMULLD x: sem-undef-varity x
   | VPMULLW x: sem-undef-varity x
   | VPMULUDQ x: sem-undef-varity x
   | VPOR x: sem-undef-varity x
   | VPSADBW x: sem-undef-varity x
   | VPSHUFB x: sem-undef-varity x
   | VPSHUFD x: sem-undef-varity x
   | VPSHUFHW x: sem-undef-varity x
   | VPSHUFLW x: sem-undef-varity x
   | VPSIGNB x: sem-undef-varity x
   | VPSIGND x: sem-undef-varity x
   | VPSIGNW x: sem-undef-varity x
   | VPSLLD x: sem-undef-varity x
   | VPSLLDQ x: sem-undef-varity x
   | VPSLLQ x: sem-undef-varity x
   | VPSLLW x: sem-undef-varity x
   | VPSRAD x: sem-undef-varity x
   | VPSRAW x: sem-undef-varity x
   | VPSRLD x: sem-undef-varity x
   | VPSRLDQ x: sem-undef-varity x
   | VPSRLQ x: sem-undef-varity x
   | VPSRLW x: sem-undef-varity x
   | VPSUBB x: sem-undef-varity x
   | VPSUBD x: sem-undef-varity x
   | VPSUBQ x: sem-undef-varity x
   | VPSUBSB x: sem-undef-varity x
   | VPSUBSW x: sem-undef-varity x
   | VPSUBUSB x: sem-undef-varity x
   | VPSUBUSW x: sem-undef-varity x
   | VPSUBW x: sem-undef-varity x
   | VPTEST x: sem-undef-varity x
   | VPUNPCKHBW x: sem-undef-varity x
   | VPUNPCKHDQ x: sem-undef-varity x
   | VPUNPCKHQDQ x: sem-undef-varity x
   | VPUNPCKHWD x: sem-undef-varity x
   | VPUNPCKLBW x: sem-undef-varity x
   | VPUNPCKLDQ x: sem-undef-varity x
   | VPUNPCKLQDQ x: sem-undef-varity x
   | VPUNPCKLWD x: sem-undef-varity x
   | VPXOR x: sem-undef-varity x
   | VRCPPS x: sem-undef-varity x
   | VRCPSS x: sem-undef-varity x
   | VROUNDPD x: sem-undef-varity x
   | VROUNDPS x: sem-undef-varity x
   | VROUNDSD x: sem-undef-varity x
   | VROUNDSS x: sem-undef-varity x
   | VRSQRTPS x: sem-undef-varity x
   | VRSQRTSS x: sem-undef-varity x
   | VSHUFPD x: sem-undef-varity x
   | VSHUFPS x: sem-undef-varity x
   | VSQRTPD x: sem-undef-varity x
   | VSQRTPS x: sem-undef-varity x
   | VSQRTSD x: sem-undef-varity x
   | VSQRTSS x: sem-undef-varity x
   | VSTMXCSR x: sem-undef-varity x
   | VSUBPD x: sem-undef-varity x
   | VSUBPS x: sem-undef-varity x
   | VSUBSD x: sem-undef-varity x
   | VSUBSS x: sem-undef-varity x
   | VTESTPD x: sem-undef-varity x
   | VTESTPS x: sem-undef-varity x
   | VUCOMISD x: sem-undef-varity x
   | VUCOMISS x: sem-undef-varity x
   | VUNPCKHPD x: sem-undef-varity x
   | VUNPCKHPS x: sem-undef-varity x
   | VUNPCKLPD x: sem-undef-varity x
   | VUNPCKLPS x: sem-undef-varity x
   | VXORPS x: sem-undef-varity x
   | VZEROALL x: sem-undef-varity x
   | VZEROUPPER x: sem-undef-varity x
   | WAIT x: sem-undef-arity0 x
   | WBINVD x: sem-undef-arity0 x
   | WRFSBASE x: sem-undef-arity1 x
   | WRGSBASE x: sem-undef-arity1 x
   | WRMSR x: sem-undef-arity0 x
   | XADD x: sem-xadd x
   | XCHG x: sem-xchg x
   | XGETBV x: sem-undef-arity0 x
   | XLAT x: sem-undef-arity0 x
   | XLATB x: sem-undef-arity0 x
   | XOR x: sem-xor x
   | XORPD x: sem-undef-arity2 x
   | XORPS x: sem-undef-arity2 x
   | XRSTOR x: sem-undef-arity1 x
   | XRSTOR64 x: sem-undef-arity1 x
   | XSAVE x: sem-undef-arity1 x
   | XSAVE64 x: sem-undef-arity1 x
   | XSAVEOPT x: sem-undef-arity1 x
   | XSAVEOPT64 x: sem-undef-arity1 x
   | XSETBV x: sem-undef-arity0 x
  end
#s/^ | \([^\s]*\) of \(arity\|flow\)\(.\)\s*/ | \1 x: sem-undef-\2\3 x/g
#s/^ | \([^\s]*\) of varity\s*/ | \1 x: sem-undef-varity x/g
#s/^ | \(\S*\)\s*$/ | \1: sem-undef-arity0/g
#s/\(.*\)| \(\S*\):.*/\1| \2 x: sem-undef-arity0 x/g

val translate insn =
   do update@{stack=SEM_NIL,tmp=0,lab=0,mode64='1'};
      semantics insn;
      stack <- query $stack;
      return (rreil-stmts-rev stack)
   end

val translate-bottom-up insn =
   do update@{stack=SEM_NIL,tmp=0,lab=0};
      semantics insn;
      stack <- query $stack;
      return stack
   end

val transInstr = do
   ic <- query $ins_count;
   update@{tmp=0,ins_count=ic+1};
   insn <- decode;
   semantics insn
end

val transBlock = do
   update@{stack=SEM_NIL,foundJump='0'};
   transInstr;
   jmp <- query $foundJump;
   ic <- query $ins_count;
   if jmp or ic>10 then query $stack else transBlock
end

val translateBlock = do
   update @{ins_count=0,mode64='1'};
   # the type checker is seriously broken when it comes to infinite recursion,
   # I cannot as of yet reproduce this bug
   update @{ptrsz=0, reg/opcode='000', rm='000', mod='00', vexm='00001', vexv='0000', vexl='0', vexw='0'};
   transBlock
end
