## M>>

val sem-maskmov-opnd element-size dst src mask = do
  size <- sizeof1 mask;
  src <- rval size src;
  mask <- rval size mask;

  src-temp <- mktemp;
  mov size src-temp src;

  mask-temp <- mktemp;
  mov size mask-temp mask;

  is-store <- return (
    case dst of
       MEM m: '0'
     | REG r: '1'
    end
  );

  offset-factor <- return (
    if is-store then
      element-size
    else
      /z element-size 8
  );

  let
    val m i =
      let
        val write-dst value = do
          dst <- lval-offset element-size dst (OFFSET_CONST (i*offset-factor));
          write element-size dst value
        end
      in do
        offset <- return (element-size*i);
        _if (/d (var (at-offset mask-temp ((i + 1)*element-size - 1)))) _then
          write-dst (var (at-offset src-temp offset))
        _else
          if is-store then
  	        write-dst (imm 0)
          else
            return void
      end end
  in
    vector-apply size element-size m
  end;

  if is-store and size === 128 then do
    dst <- lval-offset size dst (OFFSET_CONST size);
    write size dst (imm 0)
  end else
    return void
end

val sem-maskmovdqu-vmaskmovdqu x = sem-maskmov-opnd 8 x.opnd1 x.opnd2 x.opnd3

val sem-maskmovq x = sem-maskmov-opnd 8 x.opnd1 x.opnd2 x.opnd3

val sem-mov avx-encoded x = do
  sz <- sizeof1 x.opnd1;
  a <- lval sz x.opnd1;
  b <- rval sz x.opnd2;
  write-extend avx-encoded sz a b
end

#val sem-movap x = do
#  sz <- sizeof1 x.opnd1;
#  dst <- lval sz x.opnd1;
#  src <- rval sz x.opnd2;
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
#  src <- rval sz x.opnd2;
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
  src <- rval x.opnd-sz x.opnd2;
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
#  src <- rval src-size x.opnd2;
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
#  src <- rval size x.opnd2;
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
#  src <- rval size x.opnd2;
#  dst <- lval size x.opnd1;
#
#  write size dst src
#end

val sem-movq x = do
  sz-dst <- sizeof1 x.opnd1;
  sz-src <- return 64;
  dst <- lval sz-dst x.opnd1;
  src <- rval sz-src x.opnd2;

  t <- mktemp;
  if sz-dst > sz-src then
    mov (sz-dst - sz-src) (at-offset t sz-src) (imm 0)
  else
    return void
  ;
  mov sz-src t src;

  write-extend '0' sz-dst dst (var t)
end

val sem-movs x = do
  sz <- sizeof1 x.opnd1;
  src <- rval sz x.opnd2;
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
  src <- rval sz-src x.opnd2;

  temp <- mktemp;
  movsx sz-dst temp sz-src src;

  write sz-dst dst (var temp)
end

val sem-movzx avx-encoded x = do
  sz-dst <- sizeof1 x.opnd1;
  sz-src <- sizeof1 x.opnd2;
  dst <- lval sz-dst x.opnd1;
  src <- rval sz-src x.opnd2;

  temp <- mktemp;
  movzx sz-dst temp sz-src src;

  write-extend avx-encoded sz-dst dst (var temp)
end

val sem-mul conv x = do
  sz <- sizeof1 x.opnd1;

  factor0-sem <- return (semantic-register-of (register-by-size low A sz));

  factor0 <- expand mktemp conv (var factor0-sem) sz (sz + sz);

  factor1 <- rvals conv (sz + sz) x.opnd1;

  product <- mktemp;
  mul (sz + sz) product factor0 factor1;

  emit-mul-flags conv sz product;

  case sz of
     8: do
       ax <- return (semantic-register-of AX);
       write-extend-reg '0' (sz + sz) ax (var product)
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
  src <- rval size x.opnd1;
  dst <- lval size x.opnd1;

  temp <- mktemp;
  sub size temp (imm 0) src;

  cf <- fCF;
  ov <- fOF;
  sf <- fSF;
  zf <- fZF;

  cmpneq size cf src (imm 0);

  src-temp <- mktemp;
  cmplts size sf (var temp) (imm 0);
  cmpeq size zf (var temp) (imm 0);
  #mov size src-temp src;
  #cmpeq 1 ov (var (at-offset temp (size - 1))) (var (at-offset src-temp (size - 1)));
  cmpeq size ov (var temp) src;
  xorb 1 ov (var ov) (var zf);

  emit-parity-flag (var temp);
  emit-arithmetic-adjust-flag size (var temp) (imm 0) src; #Todo: Correct?
  emit-virt-flags;

  write size dst (var temp)
end

val sem-nop = do
  return void
end

val sem-not x = do
  size <- sizeof1 x.opnd1;
  src <- rval size x.opnd1;
  dst <- lval size x.opnd1;

  temp <- mktemp;
  xorb size temp src (imm (0-1));

  write size dst (var temp)
end

## O>>

val sem-or x = do
  sz <- sizeof2 x.opnd1 x.opnd2;
  dst <- lval sz x.opnd1;
  src0 <- rval sz x.opnd1;
  src1 <- rvals Signed sz x.opnd2;
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
  emit-virt-flags;

  write sz dst (var temp)
end

## P>>

val sem-pabs avx-encoded element-size x = do
  size <- sizeof1 x.opnd1;
  src <- rval size x.opnd2;
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

  write-extend avx-encoded size dst (var temp-dst)
end

val sem-packsswb-packssdw-opnd avx-encoded dst-element-size opnd1 opnd2 opnd3 = do
  size <- sizeof1 opnd1;
  src1 <- rval size opnd2;
  src2 <- rval size opnd3;
  dst <- lval size opnd1;

  temp-src <- mktemp;
  mov size temp-src src1;
  mov size (at-offset temp-src size) src2;

  temp-dst <- mktemp;

  element-size <- return (2*dst-element-size);

  upper <- return (
    if dst-element-size === 8 then
      0x7f
    else
      0x7fff
  );
  lower <- return (
    if dst-element-size === 8 then
      (0-0x80)
    else
      (0-0x8000)
  );

  let
    val m i = do
      src-offset <- return (element-size*i);
      dst-offset <- return (dst-element-size*i);

      _if (/gts element-size (var (at-offset temp-src src-offset)) (imm upper)) _then (
        mov dst-element-size (at-offset temp-dst dst-offset) (imm upper)
      ) _else ( _if (/lts element-size (var (at-offset temp-src src-offset)) (imm lower)) _then
        mov dst-element-size (at-offset temp-dst dst-offset) (imm lower)
      _else
        mov dst-element-size (at-offset temp-dst dst-offset) (var (at-offset temp-src src-offset))
      )
    end
  in
    vector-apply (2*size) element-size m
  end;

  write-extend avx-encoded size dst (var temp-dst)
end

val sem-packsswb-packssdw dst-element-size x = sem-packsswb-packssdw-opnd '0' dst-element-size x.opnd1 x.opnd1 x.opnd2
val sem-vpacksswb-vpackssdw dst-element-size x = sem-packsswb-packssdw-opnd '1' dst-element-size x.opnd1 x.opnd2 x.opnd3

val sem-packuswb-packusdw-opnd avx-encoded dst-element-size opnd1 opnd2 opnd3 = do
  size <- sizeof1 opnd1;
  src1 <- rval size opnd2;
  src2 <- rval size opnd3;
  dst <- lval size opnd1;

  temp-src <- mktemp;
  mov size temp-src src1;
  mov size (at-offset temp-src size) src2;

  temp-dst <- mktemp;

  element-size <- return (2*dst-element-size);

  upper <- return (
    if dst-element-size === 8 then
      0xff
    else
      0xffff
  );

  let
    val m i = do
      src-offset <- return (element-size*i);
      dst-offset <- return (dst-element-size*i);

      _if (/gts element-size (var (at-offset temp-src src-offset)) (imm upper)) _then (
       mov dst-element-size (at-offset temp-dst dst-offset) (imm upper)
     ) _else (_if (/lts element-size (var (at-offset temp-src src-offset)) (imm 0)) _then (
       mov dst-element-size (at-offset temp-dst dst-offset) (imm 0)
		 ) _else (
       mov dst-element-size (at-offset temp-dst dst-offset) (var (at-offset temp-src src-offset))
     ))
    end
  in
    vector-apply (2*size) element-size m
  end;

  write-extend avx-encoded size dst (var temp-dst)
end

val sem-packuswb-packusdw dst-element-size x = sem-packuswb-packusdw-opnd '0' dst-element-size x.opnd1 x.opnd1 x.opnd2
val sem-vpackuswb-vpackusdw dst-element-size x = sem-packuswb-packusdw-opnd '1' dst-element-size x.opnd1 x.opnd2 x.opnd3

val sem-pbinop-opnd avx-encoded element-size operator opnd1 opnd2 opnd3 = do
  size <- sizeof1 opnd1;
  src1 <- rval size opnd2;
  src2 <- rval size opnd3;
  dst <- lval size opnd1;

  temp-src1 <- mktemp;
  mov size temp-src1 src1;
  temp-src2 <- mktemp;
  mov size temp-src2 src2;

  temp-dst <- mktemp;
  let
    val m i = do
      offset <- return (element-size*i);

      operator element-size (at-offset temp-dst offset) (var (at-offset temp-src1 offset)) (var (at-offset temp-src2 offset))
    end
  in
    vector-apply size element-size m
  end;

  write-extend avx-encoded size dst (var temp-dst)
end

val sem-padd element-size x = sem-pbinop-opnd '0' element-size add x.opnd1 x.opnd1 x.opnd2
val sem-vpadd element-size x = sem-pbinop-opnd '1' element-size add x.opnd1 x.opnd2 x.opnd3

val sem-padds element-size x = sem-pbinop-opnd '0' element-size add-signed-saturating x.opnd1 x.opnd1 x.opnd2
val sem-vpadds element-size x = sem-pbinop-opnd '1' element-size add-signed-saturating x.opnd1 x.opnd2 x.opnd3

val sem-paddus element-size x = sem-pbinop-opnd '0' element-size add-unsigned-saturating x.opnd1 x.opnd1 x.opnd2
val sem-vpaddus element-size x = sem-pbinop-opnd '1' element-size add-unsigned-saturating x.opnd1 x.opnd2 x.opnd3

val sem-palignr-vpalignr-opnd avx-encoded opnd1 opnd2 opnd3 opnd4 = do
  size <- sizeof1 opnd1;
  dst <- lval size opnd1;
  src1 <- rval size opnd2;
  src2 <- rval size opnd3;
  imm8 <- rval 8 opnd4;

  shift-amount <- mktemp;
  movzx (2*size) shift-amount 8 imm8;
  shl (2*size) shift-amount (var shift-amount) (imm 3);

  concatenated <- mktemp;
  mov size concatenated src2;
  mov size (at-offset concatenated size) src1;

  shr (2*size) concatenated (var concatenated) (var shift-amount);

  write-extend avx-encoded size dst (var concatenated)
end

val sem-palignr x = sem-palignr-vpalignr-opnd '0' x.opnd1 x.opnd1 x.opnd2 x.opnd3
val sem-vpalignr x = sem-palignr-vpalignr-opnd '1' x.opnd1 x.opnd2 x.opnd3 x.opnd4

val sem-pand-vpand-opnd avx-encoded opnd1 opnd2 opnd3 = do
  size <- sizeof1 opnd1;
  dst <- lval size opnd1;
  src1 <- rval size opnd2;
  src2 <- rval size opnd3;

  temp <- mktemp;
  andb size temp src1 src2;

  write-extend avx-encoded size dst (var temp)
end

val sem-pand x = sem-pand-vpand-opnd '0' x.opnd1 x.opnd1 x.opnd2
val sem-vpand x = sem-pand-vpand-opnd '1' x.opnd1 x.opnd2 x.opnd3

val sem-pandn-vpandn-opnd avx-encoded opnd1 opnd2 opnd3 = do
  size <- sizeof1 opnd1;
  dst <- lval size opnd1;
  src1 <- rval size opnd2;
  src2 <- rval size opnd3;

  temp <- mktemp;
  xorb size temp src1 (imm (0-1));
  andb size temp (var temp) src2;

  write-extend avx-encoded size dst (var temp)
end

val sem-pandn x = sem-pandn-vpandn-opnd '0' x.opnd1 x.opnd1 x.opnd2
val sem-vpandn x = sem-pandn-vpandn-opnd '1' x.opnd1 x.opnd2 x.opnd3

val sem-pavg-vpavg-opnd avx-encoded element-size opnd1 opnd2 opnd3 = do
  size <- sizeof1 opnd1;
  src1 <- rval size opnd2;
  src2 <- rval size opnd3;
  dst <- lval size opnd1;

  temp-src1 <- mktemp;
  mov size temp-src1 src1;
  temp-src2 <- mktemp;
  mov size temp-src2 src2;

  temp-dst <- mktemp;

  src1-ex <- mktemp;
  src2-ex <- mktemp;

  let
    val m i = do
      offset <- return (element-size*i);

      movzx (element-size + 1) src1-ex element-size (var (at-offset temp-src1 offset));
      movzx (element-size + 1) src2-ex element-size (var (at-offset temp-src2 offset));

      add (element-size + 1) src1-ex (var src1-ex) (var src2-ex);
      add (element-size + 1) src1-ex (var src1-ex) (imm 1);
      shr (element-size + 1) src1-ex (var src1-ex) (imm 1);

      mov element-size (at-offset temp-dst offset) (var src1-ex)
    end
  in
    vector-apply size element-size m
  end;

  write-extend avx-encoded size dst (var temp-dst)
end

val sem-pavg element-size x = sem-pavg-vpavg-opnd '0' element-size x.opnd1 x.opnd1 x.opnd2
val sem-vpavg element-size x = sem-pavg-vpavg-opnd '1' element-size x.opnd1 x.opnd2 x.opnd3

val blend-bit-selector-register element-size index mask = do
  offset <- return (element-size*index);
  return (at-offset mask (offset + element-size - 1))
end

val blend-bit-selector-immediate element-size index mask = return (at-offset mask index)

val sem-pblend-vpblend-opnd bit-selector avx-encoded element-size opnd1 opnd2 opnd3 opnd4 = do
  size <- sizeof1 opnd1;
  src1 <- rval size opnd2;
  src2 <- rval size opnd3;
  dst <- lval size opnd1;
  mask <- rval size opnd4;

  temp-src1 <- mktemp;
#  if avx-encoded then do
    mov size temp-src1 src1;
#  end else
#    return void
#  ;
  temp-src2 <- mktemp;
  mov size temp-src2 src2;
  temp-mask <- mktemp;
  mov size temp-mask mask;

  temp-dst <- mktemp;
#  mov size temp-dst (imm 0);
  mov size temp-dst src1;

  let
    val m i = do
      offset <- return (element-size*i);

      test-bit <- bit-selector element-size i temp-mask;
      _if (/d (var test-bit)) _then
        mov element-size (at-offset temp-dst offset) (var (at-offset temp-src2 offset))
      _else
#        if avx-encoded then
#          mov element-size (at-offset temp-dst offset) (var (at-offset temp-src1 offset))
#      	else
	        return void
    end
  in
    vector-apply size element-size m
  end;

  write-extend avx-encoded size dst (var temp-dst)
end

val sem-pblendvb x = sem-pblend-vpblend-opnd blend-bit-selector-register '0' 8 x.opnd1 x.opnd1 x.opnd2 (REG XMM0)
val sem-vpblendvb x = sem-pblend-vpblend-opnd blend-bit-selector-register '1' 8 x.opnd1 x.opnd2 x.opnd3 x.opnd4

val sem-pblendw x = sem-pblend-vpblend-opnd blend-bit-selector-immediate '0' 16 x.opnd1 x.opnd1 x.opnd2 x.opnd3
val sem-vpblendw x = sem-pblend-vpblend-opnd blend-bit-selector-immediate '1' 16 x.opnd1 x.opnd2 x.opnd3 x.opnd4

val sem-pclmulqdq-vpclmulqdq-opnd avx-encoded opnd1 opnd2 opnd3 opnd4 = do
  size <- sizeof1 opnd1;
  dst <- lval size opnd1;
  src1 <- rval size opnd2;
  src2 <- rval size opnd3;
  imm_ <- rval 8 opnd4;

  temp-imm <- mktemp;
  mov 8 temp-imm imm_;

  temp-src1 <- mktemp;
  mov size temp-src1 src1;
  temp-src2 <- mktemp;
  mov size temp-src2 src2;

  part-size <- return 64;

  temp1 <- mktemp;
  _if (/not (var temp-imm)) _then
    mov part-size temp1 (var (at-offset temp-src1 0))
  _else
    mov part-size temp1 (var (at-offset temp-src1 part-size))
  ;
  mov part-size (at-offset temp1 part-size) (imm 0);

  temp2 <- mktemp;
  _if (/not (var (at-offset temp-imm 4))) _then
    mov part-size temp2 (var (at-offset temp-src2 0))
  _else
    mov part-size temp2 (var (at-offset temp-src2 part-size))
  ;
  mov part-size (at-offset temp2 part-size) (imm 0);

  temp-dst <- mktemp;
  mov part-size temp-dst (imm 0);

  counter <- mktemp;
  mov 7 counter (imm 0);
  _while (/ltu 7 (var counter) (imm 64)) __ do
    _if (/d (var temp1)) _then
      xorb (2*part-size) temp-dst (var temp-dst) (var temp2)
    ;

    shr (2*part-size) temp1 (var temp1) (imm 1);
    shl (2*part-size) temp2 (var temp2) (imm 1);

    add 7 counter (var counter) (imm 1)
  end;

  #tmpB <- mktemp;
  #temp-bit <- mktemp;
  #let
  #  val f i = do
  #    andb 1 (at-offset tmpB i) (var (at-offset temp1 0)) (var (at-offset temp2 i));

  #    let
  #      val g j =
  #        if (j <= i) then do
  #          andb 1 temp-bit (var (at-offset temp1 j)) (var (at-offset temp2 (i - j)));
  #          xorb 1 (at-offset tmpB i) (var (at-offset tmpB i)) (var temp-bit);

  #          g (j + 1)
  #        end else
  #          return void
  #    in
  #      g 1
  #    end;

  #    mov 1 (at-offset temp-dst i) (var (at-offset tmpB i));

  #    if (i < 63) then
  #      f (i + 1)
  #    else
  #      return void
  #  end
  #in
  #  f 0
  #end;

  #let
  #  val f i = do
  #    mov 1 (at-offset tmpB i) (imm 0);

  #    let
  #      val g j = do
  #        andb 1 temp-bit (var (at-offset temp1 j)) (var (at-offset temp2 (i - j)));
  #        xorb 1 (at-offset tmpB i) (var (at-offset tmpB i)) (var temp-bit);
  #
  #        if (j < 63) then
  #          g (j + 1)
  #        else
  #          return void
  #      end
  #    in
  #      g (i - 63)
  #    end;

  #    mov 1 (at-offset temp-dst i) (var (at-offset tmpB i));

  #    if (i < 126) then
  #      f (i + 1)
  #    else
  #      return void
  #  end
  #in
  #  f 64
  #end;

  #mov 1 (at-offset temp-dst (size - 1)) (imm 0);

  write-extend avx-encoded size dst (var temp-dst)
end

val sem-pclmulqdq x = sem-pclmulqdq-vpclmulqdq-opnd '0' x.opnd1 x.opnd1 x.opnd2 x.opnd3
val sem-vpclmulqdq x = sem-pclmulqdq-vpclmulqdq-opnd '1' x.opnd1 x.opnd2 x.opnd3 x.opnd4

val sem-pcmp-vpcmp-opnd avx-encoded element-size comparer opnd1 opnd2 opnd3 = do
  size <- sizeof1 opnd1;
  src1 <- rval size opnd2;
  src2 <- rval size opnd3;
  dst <- lval size opnd1;

  temp-src1 <- mktemp;
  mov size temp-src1 src1;
  temp-src2 <- mktemp;
  mov size temp-src2 src2;

  temp-dst <- mktemp;

  let
    val m i = do
      offset <- return (element-size*i);

      _if (comparer element-size (var (at-offset temp-src1 offset)) (var (at-offset temp-src2 offset))) _then
        mov element-size (at-offset temp-dst offset) (imm (0-1))
      _else
        mov element-size (at-offset temp-dst offset) (imm 0)
    end
  in
    vector-apply size element-size m
  end;

  write-extend avx-encoded size dst (var temp-dst)
end

val sem-pcmpeq element-size x = sem-pcmp-vpcmp-opnd '0' element-size /eq x.opnd1 x.opnd1 x.opnd2
val sem-vpcmpeq element-size x = sem-pcmp-vpcmp-opnd '1' element-size /eq x.opnd1 x.opnd2 x.opnd3

val sem-pcmpgt element-size x = sem-pcmp-vpcmp-opnd '0' element-size /gts x.opnd1 x.opnd1 x.opnd2
val sem-vpcmpgt element-size x = sem-pcmp-vpcmp-opnd '1' element-size /gts x.opnd1 x.opnd2 x.opnd3

val sem-pextr-vpextr element-size x = do
  dst-size <- sizeof1 x.opnd1;
  src-size <- sizeof1 x.opnd2;
  offset-size <- return 8;

  src <- rval src-size x.opnd2;
  dst <- lval dst-size x.opnd1;

  offset <- rval offset-size x.opnd3;
  offset-mask <- return ((/m src-size element-size) - 1);

  temp <- mktemp;
  movzx src-size temp offset-size offset;
  andb offset-size temp (var temp) (imm offset-mask);
  mul offset-size temp (var temp) (imm element-size);
  shr src-size temp src (var temp);

  if dst-size > element-size then
    mov (dst-size - element-size) (at-offset temp element-size) (imm 0)
  else
    return void
  ;

  write dst-size dst (var temp)
end

val sem-phbinop-vphbinop-opnd avx-encoded element-size operator opnd1 opnd2 opnd3 = do
  size <- sizeof1 opnd1;
  src1 <- rval size opnd2;
  src2 <- rval size opnd3;
  dst <- lval size opnd1;

  temp-src <- mktemp;
  mov size temp-src src1;
  mov size (at-offset temp-src size) src2;

  temp-dst <- mktemp;
  let
    val m i = do
      dst-offset <- return (element-size*i);
      src-offset <- return (2*dst-offset);

      operator element-size (at-offset temp-dst dst-offset) (var (at-offset temp-src src-offset)) (var (at-offset temp-src (src-offset + element-size)))
    end
  in
    vector-apply size element-size m
  end;

  write-extend avx-encoded size dst (var temp-dst)
end

val sem-phadd element-size x = sem-phbinop-vphbinop-opnd '0' element-size add x.opnd1 x.opnd1 x.opnd2
val sem-vphadd element-size x = sem-phbinop-vphbinop-opnd '1' element-size add x.opnd1 x.opnd2 x.opnd3

val sem-phaddsw x = sem-phbinop-vphbinop-opnd '0' 16 add-signed-saturating x.opnd1 x.opnd1 x.opnd2
val sem-vphaddsw x = sem-phbinop-vphbinop-opnd '1' 16 add-signed-saturating x.opnd1 x.opnd2 x.opnd3

val sem-phminposuw-vphminposuw avx-encoded x = do
  element-size <- return 16;
  size <- sizeof1 x.opnd1;
  src1 <- rval size x.opnd2;
  dst <- lval size x.opnd1;

  temp-src <- mktemp;
  mov size temp-src src1;

  temp-dst <- mktemp;
  mov element-size temp-dst (var temp-src);
  mov (size - element-size) (at-offset temp-dst element-size) (imm 0);

  let
    val m i = do
      offset <- return (element-size*i);

      _if (/leu element-size (var (at-offset temp-src offset)) (var temp-dst)) _then do
        mov element-size temp-dst (var (at-offset temp-src offset));
        mov element-size (at-offset temp-dst element-size) (imm i)
      end
    end
  in
    vector-apply size element-size m
  end;

  write-extend avx-encoded size dst (var temp-dst)
end

val sem-phsub element-size x = sem-phbinop-vphbinop-opnd '0' element-size sub x.opnd1 x.opnd1 x.opnd2
val sem-vphsub element-size x = sem-phbinop-vphbinop-opnd '1' element-size sub x.opnd1 x.opnd2 x.opnd3

val sem-phsubsw x = sem-phbinop-vphbinop-opnd '0' 16 sub-signed-saturating x.opnd1 x.opnd1 x.opnd2
val sem-vphsubsw x = sem-phbinop-vphbinop-opnd '1' 16 sub-signed-saturating x.opnd1 x.opnd2 x.opnd3

val sem-pinsr-vpinsr-opnd avx-encoded element-size opnd1 opnd2 opnd3 opnd4 = do
  dst-size <- sizeof1 opnd1;
  dst <- lval dst-size opnd1;

  offset <- return (
    case opnd4 of
      IMM8 x: x.imm
    end
  );
  offset-mask <- return (
    case (/m dst-size element-size) of
       1: '00000000'
     | 2: '00000001'
     | 4: '00000011'
     | 8: '00000111'
     | 16: '00001111'
     | 32: '00011111'
     | 64: '00111111'
     | 128: '01111111'
     | 256: '11111111'
    end
  );
  offset-masked <- return (offset and offset-mask);
  index <- return ((zx offset-masked) * element-size);

  src-size <- sizeof1 opnd3;
  src1 <- rval dst-size opnd2;
  src2 <- rval src-size opnd3;

  temp <- mktemp;
  mov dst-size temp src1;

  mov element-size (at-offset temp index) src2;

  write-extend avx-encoded dst-size dst (var temp)
end

val sem-pinsr element-size x = sem-pinsr-vpinsr-opnd '0' element-size x.opnd1 x.opnd1 x.opnd2 x.opnd3
val sem-vpinsr element-size x = sem-pinsr-vpinsr-opnd '1' element-size x.opnd1 x.opnd2 x.opnd3 x.opnd4

val sem-pmcombine-opnd avx-encoded element-size combiner mover1 mover2 opnd1 opnd2 opnd3 = do
  size <- sizeof1 opnd1;
  src1 <- rval size opnd2;
  src2 <- rval size opnd3;
  dst <- lval size opnd1;

  temp-src1 <- mktemp;
  mov size temp-src1 src1;
  temp-src2 <- mktemp;
  mov size temp-src2 src2;

  temp-dst <- mktemp;

  local-src1 <- mktemp;
  local-src2 <- mktemp;
  local-dst1 <- mktemp;
  local-dst2 <- mktemp;
  let
    val m i = do
      offset <- return (2*element-size*i);

      mover1 (2*element-size) local-src1 element-size (var (at-offset temp-src1 offset));
      mover2 (2*element-size) local-src2 element-size (var (at-offset temp-src2 offset));

      mul (2*element-size) local-dst1 (var local-src1) (var local-src2);

      mover1 (2*element-size) local-src1 element-size (var (at-offset temp-src1 (offset + element-size)));
      mover2 (2*element-size) local-src2 element-size (var (at-offset temp-src2 (offset + element-size)));

      mul (2*element-size) local-dst2 (var local-src1) (var local-src2);

      combiner (2*element-size) (at-offset temp-dst offset) (var local-dst1) (var local-dst2)
    end
  in
    vector-apply size (2*element-size) m
  end;

  write-extend avx-encoded size dst (var temp-dst)
end

val sem-pmaddubsw-vpmaddubsw-opnd avx-encoded opnd1 opnd2 opnd3 = sem-pmcombine-opnd avx-encoded 8 add-signed-saturating movzx movsx opnd1 opnd2 opnd3
val sem-pmaddubsw x = sem-pmaddubsw-vpmaddubsw-opnd '0' x.opnd1 x.opnd1 x.opnd2
val sem-vpmaddubsw x = sem-pmaddubsw-vpmaddubsw-opnd '1' x.opnd1 x.opnd2 x.opnd3

val sem-pmaddwd-vpmaddwd-opnd avx-encoded opnd1 opnd2 opnd3 = sem-pmcombine-opnd avx-encoded 16 add movsx movsx opnd1 opnd2 opnd3
val sem-pmaddwd x = sem-pmaddwd-vpmaddwd-opnd '0' x.opnd1 x.opnd1 x.opnd2
val sem-vpmaddwd x = sem-pmaddwd-vpmaddwd-opnd '1' x.opnd1 x.opnd2 x.opnd3

val sem-pcomp-opnd avx-encoded comparer element-size opnd1 opnd2 opnd3 = do
  size <- sizeof1 opnd1;
  src1 <- rval size opnd2;
  src2 <- rval size opnd3;
  dst <- lval size opnd1;

  temp-src1 <- mktemp;
  mov size temp-src1 src1;
  temp-src2 <- mktemp;
  mov size temp-src2 src2;

  temp-dst <- mktemp;
  let
    val m i = do
      offset <- return (element-size*i);

      _if (comparer element-size (var (at-offset temp-src1 offset)) (var (at-offset temp-src2 offset))) _then
        mov element-size (at-offset temp-dst offset) (var (at-offset temp-src1 offset))
      _else
        mov element-size (at-offset temp-dst offset) (var (at-offset temp-src2 offset))
    end
  in
    vector-apply size element-size m
  end;

  write-extend avx-encoded size dst (var temp-dst)
end

val sem-pmaxs-vpmaxs-opnd avx-encoded element-size opnd1 opnd2 opnd3 = sem-pcomp-opnd avx-encoded /gts element-size opnd1 opnd2 opnd3
val sem-pmaxs element-size x = sem-pmaxs-vpmaxs-opnd '0' element-size x.opnd1 x.opnd1 x.opnd2
val sem-vpmaxs element-size x = sem-pmaxs-vpmaxs-opnd '1' element-size x.opnd1 x.opnd2 x.opnd3

val sem-pmaxu-vpmaxu-opnd avx-encoded element-size opnd1 opnd2 opnd3 = sem-pcomp-opnd avx-encoded /gtu element-size opnd1 opnd2 opnd3
val sem-pmaxu element-size x = sem-pmaxu-vpmaxu-opnd '0' element-size x.opnd1 x.opnd1 x.opnd2
val sem-vpmaxu element-size x = sem-pmaxu-vpmaxu-opnd '1' element-size x.opnd1 x.opnd2 x.opnd3

val sem-pmins-vpmins-opnd avx-encoded element-size opnd1 opnd2 opnd3 = sem-pcomp-opnd avx-encoded /lts element-size opnd1 opnd2 opnd3
val sem-pmins element-size x = sem-pmins-vpmins-opnd '0' element-size x.opnd1 x.opnd1 x.opnd2
val sem-vpmins element-size x = sem-pmins-vpmins-opnd '1' element-size x.opnd1 x.opnd2 x.opnd3

val sem-pminu-vpminu-opnd avx-encoded element-size opnd1 opnd2 opnd3 = sem-pcomp-opnd avx-encoded /ltu element-size opnd1 opnd2 opnd3
val sem-pminu element-size x = sem-pminu-vpminu-opnd '0' element-size x.opnd1 x.opnd1 x.opnd2
val sem-vpminu element-size x = sem-pminu-vpminu-opnd '1' element-size x.opnd1 x.opnd2 x.opnd3

val sem-pmovmskb-vpmovmskb avx-encoded x = do
  element-size <- return 8;

  src-size <- sizeof1 x.opnd2;
  src <- rval src-size x.opnd2;
  dst-size <- sizeof1 x.opnd1;
  dst <- lval dst-size x.opnd1;

  temp-src <- mktemp;
  mov src-size temp-src src;

  temp-dst <- mktemp;
  mov dst-size temp-dst (imm 0);

  let
    val m i = do
      offset <- return (element-size*(i + 1));

      mov 1 (at-offset temp-dst i) (var (at-offset temp-src (offset - 1)))
    end
  in
    vector-apply src-size element-size m
  end;

  write-extend avx-encoded dst-size dst (var temp-dst)
end

val sem-pmovex-vpmovex avx-encoded mover from-size to-size x = do
  src-size <- sizeof1 x.opnd2;
  src <- rval src-size x.opnd2;
  dst-size <- sizeof1 x.opnd1;
  dst <- lval dst-size x.opnd1;

  temp-src <- mktemp;
  mov src-size temp-src src;

  temp-dst <- mktemp;
  let
    val m i = do
      src-offset <- return (from-size*i);
      dst-offset <- return (to-size*i);

      mover to-size (at-offset temp-dst dst-offset) from-size (var (at-offset temp-src src-offset))
    end
  in
    vector-apply dst-size to-size m
  end;

  write-extend avx-encoded dst-size dst (var temp-dst)
end

val sem-pmovsx-vpmovsx avx-encoded from-size to-size x = sem-pmovex-vpmovex avx-encoded movsx from-size to-size x
val sem-pmovzx-vpmovzx avx-encoded from-size to-size x = sem-pmovex-vpmovex avx-encoded movzx from-size to-size x

val sem-pmuldq-vpmuldq-opnd avx-encoded opnd1 opnd2 opnd3 = do
  size <- return 128;
  element-size <- return 32;

  src1 <- rval size opnd2;
  src2 <- rval size opnd3;
  dst <- lval size opnd1;

  temp-src1 <- mktemp;
  mov size temp-src1 src1;
  temp-src2 <- mktemp;
  mov size temp-src2 src2;

  temp-dst <- mktemp;
  let
    val m offset = do
      movsx (2*element-size) temp-src1 element-size (var (at-offset temp-src1 offset));
      movsx (2*element-size) temp-src2 element-size (var (at-offset temp-src2 offset));
      mul (2*element-size) (at-offset temp-dst offset) (var temp-src1) (var temp-src2)
    end
  in do
    m 0;
    m 64
  end end;

  write-extend avx-encoded size dst (var temp-dst)
end

val sem-pmuldq x = sem-pmuldq-vpmuldq-opnd '0' x.opnd1 x.opnd1 x.opnd2
val sem-vpmuldq x = sem-pmuldq-vpmuldq-opnd '1' x.opnd1 x.opnd2 x.opnd3

val sem-pmulhrsw-vpmulhrsw-opnd avx-encoded opnd1 opnd2 opnd3 = do
  element-size <- return 16;

  size <- sizeof1 opnd1;
  src1 <- rval size opnd2;
  src2 <- rval size opnd3;
  dst <- lval size opnd1;

  temp-src1 <- mktemp;
  mov size temp-src1 src1;
  temp-src2 <- mktemp;
  mov size temp-src2 src2;

  temp-dst <- mktemp;

  src1-ex <- mktemp;
  src2-ex <- mktemp;
  ex-size <- return (2*element-size);
  let
    val m i = do
      offset <- return (element-size*i);

      movsx ex-size src1-ex element-size (var (at-offset temp-src1 offset));
      movsx ex-size src2-ex element-size (var (at-offset temp-src2 offset));
      mul ex-size src1-ex (var src1-ex) (var src2-ex);
      shr ex-size src1-ex (var src1-ex) (imm 14);
      add ex-size src1-ex (var src1-ex) (imm 1);

      mov element-size (at-offset temp-dst offset) (var (at-offset src1-ex 1))
    end
  in
    vector-apply size element-size m
  end;

  write-extend avx-encoded size dst (var temp-dst)
end

val sem-pmulhrsw x = sem-pmulhrsw-vpmulhrsw-opnd '0' x.opnd1 x.opnd1 x.opnd2
val sem-vpmulhrsw x = sem-pmulhrsw-vpmulhrsw-opnd '1' x.opnd1 x.opnd2 x.opnd3

val sem-pmulhxw-vpmulhxw-opnd avx-encoded mover opnd1 opnd2 opnd3 = do
  element-size <- return 16;

  size <- sizeof1 opnd1;
  src1 <- rval size opnd2;
  src2 <- rval size opnd3;
  dst <- lval size opnd1;

  temp-src1 <- mktemp;
  mov size temp-src1 src1;
  temp-src2 <- mktemp;
  mov size temp-src2 src2;

  temp-dst <- mktemp;

  sd-ex <- mktemp;
  s2-ex <- mktemp;
  ex-size <- return (2*element-size);
  let
    val m i = do
      offset <- return (element-size*i);

      mover ex-size sd-ex element-size (var (at-offset temp-src1 offset));
      mover ex-size s2-ex element-size (var (at-offset temp-src2 offset));

      mul ex-size sd-ex (var sd-ex) (var s2-ex);

      mov element-size (at-offset temp-dst offset) (var (at-offset sd-ex element-size))
    end
  in
    vector-apply size element-size m
  end;

  write-extend avx-encoded size dst (var temp-dst)
end

val sem-pmulhuw x = sem-pmulhxw-vpmulhxw-opnd '0' movzx x.opnd1 x.opnd1 x.opnd2
val sem-vpmulhuw x = sem-pmulhxw-vpmulhxw-opnd '1' movzx x.opnd1 x.opnd2 x.opnd3

val sem-pmulhw x = sem-pmulhxw-vpmulhxw-opnd '0' movsx x.opnd1 x.opnd1 x.opnd2
val sem-vpmulhw x = sem-pmulhxw-vpmulhxw-opnd '1' movsx x.opnd1 x.opnd2 x.opnd3

val sem-pmull-vpmull-opnd avx-encoded element-size opnd1 opnd2 opnd3 = do
  size <- sizeof1 opnd1;
  src1 <- rval size opnd2;
  src2 <- rval size opnd3;
  dst <- lval size opnd1;

  temp-src1 <- mktemp;
  mov size temp-src1 src1;
  temp-src2 <- mktemp;
  mov size temp-src2 src2;

  temp-dst <- mktemp;

  let
    val m i = do
      offset <- return (element-size*i);

      mul element-size (at-offset temp-dst offset) (var (at-offset temp-src1 offset)) (var (at-offset temp-src2 offset))
    end
  in
    vector-apply size element-size m
  end;

  write-extend avx-encoded size dst (var temp-dst)
end

val sem-pmull element-size x = sem-pmull-vpmull-opnd '0' element-size x.opnd1 x.opnd1 x.opnd2
val sem-vpmull element-size x = sem-pmull-vpmull-opnd '1' element-size x.opnd1 x.opnd2 x.opnd3

val sem-pmuludq-vpmuludq-opnd avx-encoded opnd1 opnd2 opnd3 = do
  element-size <- return 64;

  size <- sizeof1 opnd1;
  src1 <- rval size opnd2;
  src2 <- rval size opnd3;
  dst <- lval size opnd1;

  temp-src1 <- mktemp;
  mov size temp-src1 src1;
  temp-src2 <- mktemp;
  mov size temp-src2 src2;

  temp-dst <- mktemp;

  s1-ex <- mktemp;
  s2-ex <- mktemp;

  part-size <- return (/z element-size 2);
  let
    val m i = do
      offset <- return (element-size*i);

      movzx element-size s1-ex part-size (var (at-offset temp-src1 offset));
      movzx element-size s2-ex part-size (var (at-offset temp-src2 offset));

      mul element-size (at-offset temp-dst offset) (var s1-ex) (var s2-ex)
    end
  in
    vector-apply size element-size m
  end;

  write-extend avx-encoded size dst (var temp-dst)
end

val sem-pmuludq x = sem-pmuludq-vpmuludq-opnd '0' x.opnd1 x.opnd1 x.opnd2
val sem-vpmuludq x = sem-pmuludq-vpmuludq-opnd '1' x.opnd1 x.opnd2 x.opnd3

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

val sem-popa-popad x = do
  reg-di <- return (register-by-size low DI_ x.opnd-sz);
  reg-di-sem <- return (semantic-register-of reg-di);
  ps-pop x.opnd-sz reg-di-sem;
  reg-si <- return (register-by-size low SI_ x.opnd-sz);
  reg-si-sem <- return (semantic-register-of reg-si);
  ps-pop x.opnd-sz reg-si-sem;
  reg-bp <- return (register-by-size low BP_ x.opnd-sz);
  reg-bp-sem <- return (semantic-register-of reg-bp);
  ps-pop x.opnd-sz reg-bp-sem;

  reg-sp <- return ESP;
  reg-sp-size <- sizeof1 (REG reg-sp);
  reg-sp-sem <- return (semantic-register-of reg-sp);
  add reg-sp-size reg-sp-sem (var reg-sp-sem) (imm ((/z x.opnd-sz 16)*2));

  reg-b <- return (register-by-size low B x.opnd-sz);
  reg-b-sem <- return (semantic-register-of reg-b);
  ps-pop x.opnd-sz reg-b-sem;
  reg-d <- return (register-by-size low D x.opnd-sz);
  reg-d-sem <- return (semantic-register-of reg-d);
  ps-pop x.opnd-sz reg-d-sem;
  reg-c <- return (register-by-size low C x.opnd-sz);
  reg-c-sem <- return (semantic-register-of reg-c);
  ps-pop x.opnd-sz reg-c-sem;
  reg-a <- return (register-by-size low A x.opnd-sz);
  reg-a-sem <- return (semantic-register-of reg-a);
  ps-pop x.opnd-sz reg-a-sem
end

val sem-popcnt x = do
  src <- rval x.opnd-sz x.opnd2;
  dst <- lval x.opnd-sz x.opnd1;

  temp-src <- mktemp;
  mov x.opnd-sz temp-src src;

  counter <- mktemp;
  mov x.opnd-sz counter (imm 0);
  #i <- mktemp;
  #mov 7 i (imm 0);
  #_while (/ltu 7 (var i) (imm x.opnd-sz)) __ (
  #  _if (/d (var (at-offset temp-src i))) _then
  #    add x.opnd-sz counter (var counter) (imm 1)
  #);
  let
    val m i =
      _if (/d (var (at-offset temp-src i))) _then
        add x.opnd-sz counter (var counter) (imm 1)
  in
    vector-apply x.opnd-sz 1 m
  end;

  ov <- fOF;
  mov 1 ov (imm 0);
  sf <- fSF;
  mov 1 sf (imm 0);
  af <- fAF;
  mov 1 af (imm 0);
  cf <- fCF;
  mov 1 cf (imm 0);
  pf <- fPF;
  mov 1 pf (imm 0);
  zf <- fZF;
  cmpeq x.opnd-sz zf src (imm 0);
  emit-virt-flags;

  write x.opnd-sz dst (var counter)
end

val sem-popf x = do
  popped <- mktemp;
  ps-pop x.opnd-sz popped;

  move-to-rflags x.opnd-sz (var popped)
end

val sem-por-vpor-opnd avx-encoded opnd1 opnd2 opnd3 = do
  size <- sizeof1 opnd1;
  src1 <- rval size opnd2;
  src2 <- rval size opnd3;
  dst <- lval size opnd1;

  temp <- mktemp;
  orb size temp src1 src2;

  write-extend avx-encoded size dst (var temp)
end

val sem-por x = sem-por-vpor-opnd '0' x.opnd1 x.opnd1 x.opnd2
val sem-vpor x = sem-por-vpor-opnd '1' x.opnd1 x.opnd2 x.opnd3

val sem-psadbw-vpsadbw-opnd avx-encoded opnd1 opnd2 opnd3 = do
  size <- sizeof1 opnd1;
  src1 <- rval size opnd2;
  src2 <- rval size opnd3;
  dst <- lval size opnd1;

  temp-src1 <- mktemp;
  mov size temp-src1 src1;
  temp-src2 <- mktemp;
  mov size temp-src2 src2;

  temp-dst <- mktemp;
  diff-element-size <- return 8;
  let
    val m i = do
      offset <- return (diff-element-size*i);

      _if (/gtu diff-element-size (var (at-offset temp-src1 offset)) (var (at-offset temp-src2 offset))) _then
        sub diff-element-size (at-offset temp-dst offset) (var (at-offset temp-src1 offset)) (var (at-offset temp-src2 offset))
      _else
        sub diff-element-size (at-offset temp-dst offset) (var (at-offset temp-src2 offset)) (var (at-offset temp-src1 offset))
    end
  in
    vector-apply size diff-element-size m
  end;

  sum-element-size <- return 64;
  temp-sum <- mktemp;
  temp-sum-ex <- mktemp;
  ex-size <- return 16;
  let
    val m i = do
      offset <- return (sum-element-size*i);

      movzx ex-size temp-sum diff-element-size (var (at-offset temp-dst offset));
      let
        val n i = do
          movzx ex-size temp-sum-ex diff-element-size (var (at-offset temp-dst (offset + ((i + 1)*diff-element-size))));
          add ex-size temp-sum (var temp-sum) (var temp-sum-ex)
	end
      in
        vector-apply 7 1 n
      end;

      mov sum-element-size (at-offset temp-dst offset) (var temp-sum)
    end
  in
    vector-apply size sum-element-size m
  end;

  write-extend avx-encoded size dst (var temp-dst)
end

val sem-psadbw x = sem-psadbw-vpsadbw-opnd '0' x.opnd1 x.opnd1 x.opnd2
val sem-vpsadbw x = sem-psadbw-vpsadbw-opnd '1' x.opnd1 x.opnd2 x.opnd3

val sem-pshufb-vpshufb-opnd avx-encoded opnd1 opnd2 opnd3 = do
  element-size <- return 8;

  size <- sizeof1 opnd1;
  src <- rval size opnd2;
  shuffle-control-mask <- rval size opnd3;
  dst <- lval size opnd1;

  temp-scm <- mktemp;
  mov size temp-scm shuffle-control-mask;
  index <- mktemp;

  temp-dst <- mktemp;
  temp <- mktemp;
  let
    val m i = do
      offset <- return (element-size*i);

      _if (/d (var (at-offset temp-scm (offset + 7)))) _then
        mov element-size (at-offset temp-dst offset) (imm 0)
      _else do
        movzx size index (logb (/z size element-size)) (var (at-offset temp-scm offset));
	mul size index (var index) (imm element-size);
        shr size temp src (var index);
	mov element-size (at-offset temp-dst offset) (var temp)
      end
    end
  in
    vector-apply size element-size m
  end;

  write-extend avx-encoded size dst (var temp-dst)
end

val sem-pshufb x = sem-pshufb-vpshufb-opnd '0' x.opnd1 x.opnd1 x.opnd2
val sem-vpshufb x = sem-pshufb-vpshufb-opnd '1' x.opnd1 x.opnd2 x.opnd3

val sem-pshuf-vdhwlw avx-encoded element-size low-size high-size x = do
  size <- sizeof1 x.opnd1;
  src <- rval size x.opnd2;
  dst <- lval size x.opnd1;

  temp-src <- mktemp;
  mov size temp-src src;

  indices <- return (
    case x.opnd3 of
      IMM8 x: x.imm
    end
  );

  temp-dst <- mktemp;
  if low-size > 0 then
    mov low-size temp-dst (var temp-src)
  else
    return void
  ;

  temp <- mktemp;
  let
    val m i = do
      offset <- return (element-size*i + low-size);

      mask <- return (
        case i of
	   0: '00000011'
	 | 1: '00001100'
	 | 2: '00110000'
	 | 3: '11000000'
	end
      );

      index <- return (element-size*(
        case i of
	   0:
	     case (indices and mask) of
	        '00000000': 0
	      | '00000001': 1
	      | '00000010': 2
	      | '00000011': 3
	     end
	 | 1:
	     case (indices and mask) of
	        '00000000': 0
	      | '00000100': 1
	      | '00001000': 2
	      | '00001100': 3
	     end
	 | 2:
	     case (indices and mask) of
	        '00000000': 0
	      | '00010000': 1
	      | '00100000': 2
	      | '00110000': 3
	     end
	 | 3:
	     case (indices and mask) of
	        '00000000': 0
	      | '01000000': 1
	      | '10000000': 2
	      | '11000000': 3
	     end
        end
      ));

      #mov 42 temp (imm index);
      #mov 42 temp (imm (zx mask));
      #mov 42 temp (imm (zx indices));
      #mov 42 temp (imm element-size);
      #mov 42 temp (imm i);

      mov element-size (at-offset temp-dst offset) (var (at-offset temp-src (index + low-size)))
    end
  in
    vector-apply (size - low-size - high-size) element-size m
  end;

  if high-size > 0 then
    mov high-size (at-offset temp-dst (size - high-size)) (var (at-offset temp-src (size - high-size)))
  else
    return void
  ;

  write-extend avx-encoded size dst (var temp-dst)
end

val sem-pshufd-vpshufd avx-encoded x = sem-pshuf-vdhwlw avx-encoded 32 0 0 x
val sem-pshufhw-vpshufhw avx-encoded x = sem-pshuf-vdhwlw avx-encoded 16 64 0 x
val sem-pshuflw-vpshuflw avx-encoded x = sem-pshuf-vdhwlw avx-encoded 16 0 64 x
val sem-pshufw x = sem-pshuf-vdhwlw '0' 16 0 0 x

val sem-psign-vpsign-opnd avx-encoded element-size opnd1 opnd2 opnd3 = do
  size <- sizeof1 opnd1;
  src1 <- rval size opnd2;
  src2 <- rval size opnd3;
  dst <- lval size opnd1;

  temp-src1 <- mktemp;
  mov size temp-src1 src1;
  temp-src2 <- mktemp;
  mov size temp-src2 src2;

  temp-dst <- mktemp;
  temp <- mktemp;
  let
    val m i = do
      offset <- return (element-size*i);
      high-bit-position <- return (offset + element-size - 1);

      #movsx element-size temp 1 (var (at-offset temp-src2 high-bit-position));
      #mul element-size (at-offset temp-dst offset) (var (at-offset temp-src1 offset)) (var temp)

      _if (/d  (var (at-offset temp-src2 high-bit-position))) _then
        mul element-size (at-offset temp-dst offset) (var (at-offset temp-src1 offset)) (imm (0-1))
      _else (_if (/neq element-size (var (at-offset temp-src2 offset)) (imm 0)) _then
        mov element-size (at-offset temp-dst offset) (var (at-offset temp-src1 offset))
      _else
        mov element-size (at-offset temp-dst offset) (imm 0)
      )
    end
  in
    vector-apply size element-size m
  end;

  write-extend avx-encoded size dst (var temp-dst)
end

val sem-psign element-size x = sem-psign-vpsign-opnd '0' element-size x.opnd1 x.opnd1 x.opnd2
val sem-vpsign element-size x = sem-psign-vpsign-opnd '1' element-size x.opnd1 x.opnd2 x.opnd3

val sem-psxldq-vpsxldq-opnd avx-encoded shifter opnd1 opnd2 opnd3 = do
  size <- sizeof1 opnd1;
  src <- rval size opnd2;
  dst <- lval size opnd1;

  amount <- return (zx (
    case opnd3 of
      IMM8 x: x.imm
    end
  ));
  amount <- return (
    if (amount > 15) then
      (16*8)
    else
      (amount*8)
  );

  temp <- mktemp;
  shifter size temp src (imm amount);

  write-extend avx-encoded size dst (var temp)
end

val sem-pslldq x = sem-psxldq-vpsxldq-opnd '0' shl x.opnd1 x.opnd1 x.opnd2
val sem-vpslldq x = sem-psxldq-vpsxldq-opnd '1' shl x.opnd1 x.opnd2 x.opnd3

val sem-ps-vps-opnd avx-encoded element-size shifter opnd1 opnd2 opnd3 = do
  size <- sizeof1 opnd1;
  src <- rval size opnd2;
  count-size <- sizeof1 opnd3;
  count <- rval count-size opnd3;
  dst <- lval size opnd1;

  _if (/ltu count-size count (imm element-size)) _then do
    temp-src <- mktemp;
    mov size temp-src src;

    temp-dst <- mktemp;
    let
      val m i = do
        offset <- return (element-size*i);

        shifter element-size (at-offset temp-dst offset) (var (at-offset temp-src offset)) count
      end
    in
      vector-apply size element-size m
    end;

    write-extend avx-encoded size dst (var temp-dst)
  end _else
    write-extend avx-encoded size dst (imm 0)
end

val sem-psll element-size x = sem-ps-vps-opnd '0' element-size shl x.opnd1 x.opnd1 x.opnd2
val sem-vpsll element-size x = sem-ps-vps-opnd '1' element-size shl x.opnd1 x.opnd2 x.opnd3

val sem-psra-vpsra-opnd avx-encoded element-size opnd1 opnd2 opnd3 = do
  size <- sizeof1 opnd1;
  src <- rval size opnd2;
  count-size <- sizeof1 opnd3;
  count <- rval count-size opnd3;
  dst <- lval size opnd1;

  temp-src <- mktemp;
  mov size temp-src src;

  temp-dst <- mktemp;
  let
    val shift i = do
      offset <- return (element-size*i);
      shrs element-size (at-offset temp-dst offset) (var (at-offset temp-src offset)) count
    end

    val overflow i = do
      offset <- return (element-size*i);
      movsx element-size (at-offset temp-dst offset) 1 (var (at-offset temp-src (offset + element-size - 1)))
    end
  in
    _if (/ltu count-size count (imm element-size)) _then
      vector-apply size element-size shift
    _else
      vector-apply size element-size overflow
  end;

  write-extend avx-encoded size dst (var temp-dst)
end

val sem-psra element-size x = sem-psra-vpsra-opnd '0' element-size x.opnd1 x.opnd1 x.opnd2
val sem-vpsra element-size x = sem-psra-vpsra-opnd '1' element-size x.opnd1 x.opnd2 x.opnd3

val sem-psrldq x = sem-psxldq-vpsxldq-opnd '0' shr x.opnd1 x.opnd1 x.opnd2
val sem-vpsrldq x = sem-psxldq-vpsxldq-opnd '1' shr x.opnd1 x.opnd2 x.opnd3

val sem-psrl element-size x = sem-ps-vps-opnd '0' element-size shr x.opnd1 x.opnd1 x.opnd2
val sem-vpsrl element-size x = sem-ps-vps-opnd '1' element-size shr x.opnd1 x.opnd2 x.opnd3

val sem-psub element-size x = sem-pbinop-opnd '0' element-size sub x.opnd1 x.opnd1 x.opnd2
val sem-vpsub element-size x = sem-pbinop-opnd '1' element-size sub x.opnd1 x.opnd2 x.opnd3

val sem-psubs element-size x = sem-pbinop-opnd '0' element-size sub-signed-saturating x.opnd1 x.opnd1 x.opnd2
val sem-vpsubs element-size x = sem-pbinop-opnd '1' element-size sub-signed-saturating x.opnd1 x.opnd2 x.opnd3

val sem-psubus element-size x = sem-pbinop-opnd '0' element-size sub-unsigned-saturating x.opnd1 x.opnd1 x.opnd2
val sem-vpsubus element-size x = sem-pbinop-opnd '1' element-size sub-unsigned-saturating x.opnd1 x.opnd2 x.opnd3

val sem-ptest-vptest x = do
  size <- sizeof1 x.opnd1;
  src1 <- rval size x.opnd1;
  src2 <- rval size x.opnd2;

  temp <- mktemp;

  andb size temp src1 src2;
  zf <- fZF;
  cmpeq size zf (var temp) (imm 0);

  xorb size temp src1 (imm (0-1));
  andb size temp (var temp) src2;
  cf <- fCF;
  cmpeq size cf (var temp) (imm 0);

  af <- fAF;
  mov 1 af (imm 0);
  ov <- fOF;
  mov 1 ov (imm 0);
  pf <- fPF;
  mov 1 pf (imm 0);
  sf <- fSF;
  mov 1 sf (imm 0);
  emit-virt-flags
end

val sem-punpck-vpunpck-opnd avx-encoded use-high element-size opnd1 opnd2 opnd3 = do
  size <- sizeof1 opnd1;
  src1 <- rval size opnd2;
  src2 <- rval size opnd3;
  dst <- lval size opnd1;

  temp-src1 <- mktemp;
  mov size temp-src1 src1;
  temp-src2 <- mktemp;
  mov size temp-src2 src2;

  source-position <- return ((/z size 2)*use-high);

  temp-dst <- mktemp;
  let
    val m i = do
      dst-offset <- return (2*element-size*i);
      src-offset <- return (element-size*i + source-position);

      mov element-size (at-offset temp-dst dst-offset) (var (at-offset temp-src1 src-offset));
      mov element-size (at-offset temp-dst (dst-offset + element-size)) (var (at-offset temp-src2 src-offset))
    end
  in
    vector-apply size (2*element-size) m
  end;

  write-extend avx-encoded size dst (var temp-dst)
end

val sem-punpckh element-size x = sem-punpck-vpunpck-opnd '0' 1 element-size x.opnd1 x.opnd1 x.opnd2
val sem-vpunpckh element-size x = sem-punpck-vpunpck-opnd '1' 1 element-size x.opnd1 x.opnd2 x.opnd3

val sem-punpckl element-size x = sem-punpck-vpunpck-opnd '0' 0 element-size x.opnd1 x.opnd1 x.opnd2
val sem-vpunpckl element-size x = sem-punpck-vpunpck-opnd '1' 0 element-size x.opnd1 x.opnd2 x.opnd3

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

  segmented-store opnd-sz (address sp.size (var sp)) (lin opnd) (SEG_OVERRIDE SS)

  #store (address sp.size (segment-add (var sp) segment)) (lin opnd-sz opnd)
end

val sem-push x = do
  src-size <- sizeof1 x.opnd1;
  src <- rvals Signed src-size x.opnd1;

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

val sem-pusha-pushad x = do
  temp <- mktemp;
  reg-sp <- return (register-by-size low SP_ x.opnd-sz);
  reg-sp-sem <- return (semantic-register-of reg-sp);
  mov x.opnd-sz temp (var reg-sp-sem);

  reg-a <- return (register-by-size low A x.opnd-sz);
  reg-a-sem <- return (semantic-register-of reg-a);
  ps-push x.opnd-sz (var reg-a-sem);
  reg-c <- return (register-by-size low C x.opnd-sz);
  reg-c-sem <- return (semantic-register-of reg-c);
  ps-push x.opnd-sz (var reg-c-sem);
  reg-d <- return (register-by-size low D x.opnd-sz);
  reg-d-sem <- return (semantic-register-of reg-d);
  ps-push x.opnd-sz (var reg-d-sem);
  reg-b <- return (register-by-size low B x.opnd-sz);
  reg-b-sem <- return (semantic-register-of reg-b);
  ps-push x.opnd-sz (var reg-b-sem);

  ps-push x.opnd-sz (var temp);

  reg-bp <- return (register-by-size low BP_ x.opnd-sz);
  reg-bp-sem <- return (semantic-register-of reg-bp);
  ps-push x.opnd-sz (var reg-bp-sem);
  reg-si <- return (register-by-size low SI_ x.opnd-sz);
  reg-si-sem <- return (semantic-register-of reg-si);
  ps-push x.opnd-sz (var reg-si-sem);
  reg-di <- return (register-by-size low DI_ x.opnd-sz);
  reg-di-sem <- return (semantic-register-of reg-di);
  ps-push x.opnd-sz (var reg-di-sem)
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

val sem-pxor-vpxor-opnd avx-encoded opnd1 opnd2 opnd3 = do
  size <- sizeof1 opnd1;
  src1 <- rval size opnd2;
  src2 <- rval size opnd3;
  dst <- lval size opnd1;

  temp <- mktemp;
  xorb size temp src1 src2;

  write-extend avx-encoded size dst (var temp)
end

val sem-pxor x = sem-pxor-vpxor-opnd '0' x.opnd1 x.opnd1 x.opnd2
val sem-vpxor x = sem-pxor-vpxor-opnd '1' x.opnd1 x.opnd2 x.opnd3

## Q>>
## R>>

val sem-rcl x = do
  size <- sizeof1 x.opnd1;
  src <- rval size x.opnd1;
  dst <- lval size x.opnd1;
  count <- rval (2*size) x.opnd2;

  temp-count <- mktemp;
  case size of
     8: do
       andb (2*size) temp-count count (imm 0x1f);
       mod (2*size) temp-count (var temp-count) (imm 9)
     end
   | 16: do
       andb (2*size) temp-count count (imm 0x1f);
       mod (2*size) temp-count (var temp-count) (imm 17)
     end
   | 32: andb (2*size) temp-count count (imm 0x1f)
   | 64: andb (2*size) temp-count count (imm 0x3f)
  end;

  cf <- fCF;
  temp-dst <- mktemp;
  _if (/gtu size (var temp-count) (imm 0)) _then do
    movzx (2*size) temp-dst size src;
    shl (size + 1) temp-dst (var temp-dst) (imm 1);
    mov 1 temp-dst (var cf);
    sub (2*size) temp-count (var temp-count) (imm 1);
    shl (2*size) temp-dst (var temp-dst) (var temp-count);
    orb (size - 1) temp-dst (var (at-offset temp-dst (size + 1))) (var temp-dst);
    mov 1 cf (var (at-offset temp-dst size))
  end _else
    mov size temp-dst src
  ;
  
  ov <- fOF;
  _if (/eq size count (imm 1)) _then
    xorb 1 ov (var (at-offset temp-dst (size - 1))) (var cf)
  _else
    undef 1 ov
  ;

  emit-virt-flags;
  write size dst (var temp-dst)
end

val sem-rcr x = do
  size <- sizeof1 x.opnd1;
  src <- rval size x.opnd1;
  dst <- lval size x.opnd1;
  count <- rval (2*size + 1) x.opnd2;

  temp-count <- mktemp;
  case size of
     8: do
       andb (2*size + 1) temp-count count (imm 0x1f);
       mod (2*size + 1) temp-count (var temp-count) (imm 9)
     end
   | 16: do
       andb (2*size + 1) temp-count count (imm 0x1f);
       mod (2*size + 1) temp-count (var temp-count) (imm 17)
     end
   | 32: andb (2*size + 1) temp-count count (imm 0x1f)
   | 64: andb (2*size + 1) temp-count count (imm 0x3f)
  end;

  temp-dst <- mktemp;
  mov size temp-dst src;

  cf <- fCF;
  ov <- fOF;
  _if (/eq size count (imm 1)) _then
    xorb 1 ov (var (at-offset temp-dst (size - 1))) (var cf)
  _else
    undef 1 ov
  ;

  _if (/gtu size (var temp-count) (imm 0)) _then do
    mov 1 (at-offset temp-dst (2*size)) (var cf);
    mov size (at-offset temp-dst size) src;
    mov size temp-dst (imm 0);
    sub (2*size + 1) temp-count (var temp-count) (imm 1);
    shr (2*size + 1) temp-dst (var temp-dst) (var temp-count);
    orb size temp-dst (var (at-offset temp-dst (size + 1))) (var temp-dst);
    mov 1 cf (var (at-offset temp-dst size))
  end;

  emit-virt-flags;
  write size dst (var temp-dst)
end

val sem-rol x = do
  size <- sizeof1 x.opnd1;
  src <- rval size x.opnd1;
  dst <- lval size x.opnd1;
  count <- rval (2*size) x.opnd2;

  count-mask <- return (
    if x.opnd-sz === 64 then
      0x3f
    else
      0x1f
  );

  count-mask-full <- return (
    case size of
       64: 0x3f
     | 32: 0x1f
     | 16: 0x0f
     | 8: 0x07
    end
  );

  temp-count <- mktemp;
  andb (2*size) temp-count count (imm count-mask-full);
  
  temp-dst <- mktemp;
  movzx (2*size) temp-dst size src;
  
  shl (2*size) temp-dst (var temp-dst) (var temp-count);
  orb size temp-dst (var (at-offset temp-dst size)) (var temp-dst);

  temp <- mktemp;
  #sub size temp (imm size) (var temp-count);
  #shr size temp src (var temp);

  cf <- fCF;
  mov 1 cf (var temp-dst);

  ov <- fOF;
  andb size temp count (imm count-mask);
  _if (/eq size (var temp) (imm 1)) _then
    xorb 1 ov (var (at-offset temp-dst (size - 1))) (var cf)
  _else
    undef 1 ov
  ;

  emit-virt-flags;

  write size dst (var temp-dst)
end

val sem-ror x = do
  size <- sizeof1 x.opnd1;
  src <- rval size x.opnd1;
  dst <- lval size x.opnd1;
  count <- rval (2*size) x.opnd2;

  count-mask <- return (
    if x.opnd-sz === 64 then
      0x3f
    else
      0x1f
  );

  count-mask-full <- return (
    case size of
       64: 0x3f
     | 32: 0x1f
     | 16: 0x0f
     | 8: 0x07
    end
  );

  temp-count <- mktemp;
  andb (2*size) temp-count count (imm count-mask-full);
  
  temp-dst <- mktemp;
  mov size (at-offset temp-dst size) src;
  mov size temp-dst (imm 0);
  
  shr (2*size) temp-dst (var temp-dst) (var temp-count);
  orb size temp-dst (var (at-offset temp-dst size)) (var temp-dst);

  temp <- mktemp;

  cf <- fCF;
  _if (/gtu (2*size) (var temp-count) (imm 0)) _then
    mov 1 cf (var (at-offset temp-dst (size - 1)))
  _else
    undef 1 cf
  ;

  ov <- fOF;
  andb size temp count (imm count-mask);
  _if (/eq size (var temp) (imm 1)) _then
    xorb 1 ov (var (at-offset temp-dst (size - 1))) (var (at-offset temp-dst (size - 2)))
  _else
    undef 1 ov
  ;

  emit-virt-flags;

  write size dst (var temp-dst)
end

val sem-rep-repe-repne size sem fc = let
  val count-reg = semantic-register-of (register-by-size low C size)
  val cond-creg = /neq size (var count-reg) (imm 0)
in do
  cond <- mktemp;
  c <- cond-creg;
  mov 1 cond c;
  _while (/d (var cond)) __ do
    with-subscope sem;

    t <- mktemp;
    sub size t (var count-reg) (imm 1);
    write-extend-reg '0' size count-reg (var t);

    c <- /and cond-creg fc;
    mov 1 cond c
  end
end end

val sem-rep size sem = sem-rep-repe-repne size sem (return (imm 1))

val sem-repe size sem = let
  val fc = do
    zf <- fZF;
    /d (var zf)
  end
in
  sem-rep-repe-repne size sem fc
end

val sem-repne size sem = let
  val fc = do
    zf <- fZF;
    /not (var zf)
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

val sem-ret x = do
  case x of
     VA0 x:
       do
         address <- sem-ret-without-operand x;
         ret address
       end
   | VA1 x:
       do
	       address <- sem-ret-without-operand x;
         release-from-stack x;
         ret address
       end
  end;
  update @{foundJump='1'}
end

val sem-ret-far x = do
  case x of
     VA0 x:
       do
         address <- sem-ret-far-without-operand x;
         ret address
       end
   | VA1 x:
       do
         address <- sem-ret-far-without-operand x;
         release-from-stack x;
         ret address
       end
  end;
  update @{foundJump='1'}
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
  src <- rval x-sz x.opnd1;

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

  move-to-rflags ah.size (var ah)
end

val sem-sal-shl x = do
  sz <- sizeof1 x.opnd1;
  dst <- lval sz x.opnd1;
  src <- rval sz x.opnd1;
  count-size <- sizeof1 x.opnd2;
  count <- rval count-size x.opnd2;

  af <- fAF;
  _if (/neq sz count (imm 0)) _then
    undef 1 af
  ;

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

    _if (/geu count-size (imm sz) count) _then do
      temp-c <- mktemp;
      sub sz temp-c (imm sz) (var temp-count);
      shr sz temp-c src (var temp-c);
      mov 1 cf (var temp-c)
    end _else
      undef 1 cf
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
  emit-virt-flags;

  write sz dst (var tdst)
end

val sem-shr-sar x signed = do
  sz <- sizeof1 x.opnd1;
  dst <- lval sz x.opnd1;
  src <- rval sz x.opnd1;
  count-size <- sizeof1 x.opnd2;
  count <- rval count-size x.opnd2;

  af <- fAF;
  _if (/neq sz count (imm 0)) _then
    undef 1 af
  ;

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

  shifter <- return (
    if signed then
      shrs
    else
      shr
  );

  _if (/gtu sz (var temp-count) (imm 0)) _then do
    temp <- mktemp;
    sub sz temp (var temp-count) (imm 1);
    shifter sz tdst src (var temp);

    _if (/geu count-size (imm sz) count) _then
      mov 1 cf (var tdst)
    _else
      undef 1 cf
    ;

    shifter sz tdst (var tdst) (imm 1)
  end;

  ov <- fOF;
  _if (/eq sz (var temp-count) (imm 1)) _then
    if signed then
      mov 1 ov (imm 0)
    else do
      t <- mktemp;
      mov sz t src;
      mov 1 ov (var (at-offset t (sz - 1)))
    end
  _else (_if (/neq sz (var temp-count) (imm 0)) _then
    undef 1 ov)
  ;

  sf <- fSF;
  cmplts sz sf (var tdst) (imm 0);

  zf <- fZF;
  cmpeq sz zf (var tdst) (imm 0);

  emit-parity-flag (var tdst);
  emit-virt-flags;

  write sz dst (var tdst)
end

val sem-sbb x = do
  sz <- sizeof2 x.opnd1 x.opnd2;
  difference <- lval sz x.opnd1;
  minuend <- rval sz x.opnd1;
  subtrahend <- rvals Signed sz x.opnd2;

  t <- mktemp;
  cf <- fCF;
  movzx sz t 1 (var cf);
  add sz t (var t) subtrahend;
  sub sz t minuend (var t);

  emit-sub-sbb-flags sz (var t) minuend subtrahend (var cf) '1';

  write sz difference (var t)
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

val sem-setcc x cond = do
  dst-sz <- sizeof1 x.opnd1;
  dst <- lval dst-sz x.opnd1;

  cond <- cond;
  temp <- mktemp;
  movzx dst-sz temp 1 cond;

  write dst-sz dst (var temp)
end

val sem-shld-shrd s1-shifter s2-shifter x = do
  size <- sizeof1 x.opnd1;
  dst <- lval size x.opnd1;
  src1 <- rval size x.opnd1;
  src2 <- rval size x.opnd2;
  count <- rval size x.opnd3;
  
  mask <- return (
    if size === 64 then
      0x3f
    else
      0x1f
  );

  temp-count <- mktemp;
  andb size temp-count count (imm mask);

  cf <- fCF;
  ov <- fOF;
  sf <- fSF;
  zf <- fZF;
  af <- fAF;
  pf <- fPF;

  temp-dst <- mktemp;
  _if (/gtu size (var temp-count) (imm size)) _then do
    undef 1 cf;
    undef 1 ov;
    undef 1 sf;
    undef 1 zf;
    undef 1 af;
    undef 1 pf
  end _else do
    mov 1 (at-offset temp-dst (size + 1)) (imm 0);
    shl (size + 1) temp-dst src1 (imm 1);
  
    sign-prev <- mktemp;
    mov 1 sign-prev (var (at-offset temp-dst size));

    s1-shifter (size + 2) temp-dst (var temp-dst) (var temp-count);

    temp <- mktemp;
    sub size temp (imm size) (var temp-count);
    s2-shifter size temp src2 (var temp);

    orb size temp-dst (var (at-offset temp-dst 1)) (var temp);

    _if (/gtu size (var temp-count) (imm 0)) _then do
      orb 1 cf (var temp-dst) (var (at-offset temp-dst (size + 1)));
      mov 1 sf (var (at-offset temp-dst (size - 1)));
      cmpeq size zf (var temp-dst) (imm 0);
      emit-parity-flag (var temp-dst);
      undef 1 af;

      _if (/eq size (var temp-count) (imm 1)) _then
        xorb 1 ov (var sign-prev) (var (at-offset temp-dst (size - 1)))
      _else
        undef 1 ov
    end
  end;

  emit-virt-flags;
  
  write size dst (var temp-dst)
end

val sem-shld x = sem-shld-shrd shl shr x
val sem-shrd x = sem-shld-shrd shr shl x

val sem-stc = do
  cf <- fCF;
  mov 1 cf (imm 1);
  emit-virt-flags
end

val sem-std = do
  df <- fDF;
  mov 1 df (imm 1)
end

val sem-stos size x = let
  val sem x = do
    mem-sem <- return (semantic-register-of (register-by-size low DI_ x.addr-sz));
    a <- return (semantic-register-of (register-by-size low A size));

    segmented-store a.size (address x.addr-sz (var mem-sem)) (lin (var a)) (SEG_OVERRIDE ES);

    direction-adjust mem-sem.size mem-sem size
  end
in
  sem-rep-insn x sem
end

val sem-sub x = do
  sz <- sizeof2 x.opnd1 x.opnd2;
  difference <- lval sz x.opnd1;
  minuend <- rval sz x.opnd1;
  subtrahend <- rvals Signed sz x.opnd2;

  t <- mktemp;
  sub sz t minuend subtrahend;

  emit-sub-sbb-flags sz (var t) minuend subtrahend (imm 0) '1';
  write sz difference (var t)
end

## T>>

val sem-test x = do
  sz <- sizeof2 x.opnd1 x.opnd2;
  a <- rval sz x.opnd1;
  b <- rvals Signed sz x.opnd2;

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
  undef 1 af;

  emit-virt-flags
end

## U>>
## V>>

val sem-vbroadcast v = do
  x <- return (
    case v of
       VA2 x: x
    end
  );

  src-size <- sizeof1 x.opnd2;
  src <- rval src-size x.opnd2;
  dst-size <- sizeof1 x.opnd1;
  dst <- lval dst-size x.opnd1;
  
  temp-dst <- mktemp;
  let
    val m i = do
      offset <- return (src-size*i);
      mov src-size (at-offset temp-dst offset) src
    end
  in
    vector-apply dst-size src-size m
  end;

  write-extend '1' dst-size dst (var temp-dst)
end

val sem-vmaskmovp element-size v = do
  x <- return (
    case v of
       VA3 x: x
    end
  );
  sem-maskmov-opnd element-size x.opnd1 x.opnd3 x.opnd2
end

val sem-vzeroall = do
  size <- return 256;
  mode64 <- mode64?;

  xmm0 <- return (semantic-register-of XMM0);
  mov size xmm0 (imm 0);
  xmm1 <- return (semantic-register-of XMM1);
  mov size xmm1 (imm 0);
  xmm2 <- return (semantic-register-of XMM2);
  mov size xmm2 (imm 0);
  xmm3 <- return (semantic-register-of XMM3);
  mov size xmm3 (imm 0);
  xmm4 <- return (semantic-register-of XMM4);
  mov size xmm4 (imm 0);
  xmm5 <- return (semantic-register-of XMM5);
  mov size xmm5 (imm 0);
  xmm6 <- return (semantic-register-of XMM6);
  mov size xmm6 (imm 0);
  xmm7 <- return (semantic-register-of XMM7);
  mov size xmm7 (imm 0);
  if mode64 then do
    xmm8 <- return (semantic-register-of XMM8);
    mov size xmm8 (imm 0);
    xmm9 <- return (semantic-register-of XMM9);
    mov size xmm9 (imm 0);
    xmm10 <- return (semantic-register-of XMM10);
    mov size xmm10 (imm 0);
    xmm11 <- return (semantic-register-of XMM11);
    mov size xmm11 (imm 0);
    xmm12 <- return (semantic-register-of XMM12);
    mov size xmm12 (imm 0);
    xmm13 <- return (semantic-register-of XMM13);
    mov size xmm13 (imm 0);
    xmm14 <- return (semantic-register-of XMM14);
    mov size xmm14 (imm 0);
    xmm15 <- return (semantic-register-of XMM15);
    mov size xmm15 (imm 0)
  end else
    return void
end

val sem-vzeroupper = do
  size <- return 128;
  mode64 <- mode64?;

  xmm0 <- return (at-offset (semantic-register-of XMM0) size);
  mov size xmm0 (imm 0);
  xmm1 <- return (at-offset (semantic-register-of XMM1) size);
  mov size xmm1 (imm 0);
  xmm2 <- return (at-offset (semantic-register-of XMM2) size);
  mov size xmm2 (imm 0);
  xmm3 <- return (at-offset (semantic-register-of XMM3) size);
  mov size xmm3 (imm 0);
  xmm4 <- return (at-offset (semantic-register-of XMM4) size);
  mov size xmm4 (imm 0);
  xmm5 <- return (at-offset (semantic-register-of XMM5) size);
  mov size xmm5 (imm 0);
  xmm6 <- return (at-offset (semantic-register-of XMM6) size);
  mov size xmm6 (imm 0);
  xmm7 <- return (at-offset (semantic-register-of XMM7) size);
  mov size xmm7 (imm 0);
  if mode64 then do
    xmm8 <- return (at-offset (semantic-register-of XMM8) size);
    mov size xmm8 (imm 0);
    xmm9 <- return (at-offset (semantic-register-of XMM9) size);
    mov size xmm9 (imm 0);
    xmm10 <- return (at-offset (semantic-register-of XMM10) size);
    mov size xmm10 (imm 0);
    xmm11 <- return (at-offset (semantic-register-of XMM11) size);
    mov size xmm11 (imm 0);
    xmm12 <- return (at-offset (semantic-register-of XMM12) size);
    mov size xmm12 (imm 0);
    xmm13 <- return (at-offset (semantic-register-of XMM13) size);
    mov size xmm13 (imm 0);
    xmm14 <- return (at-offset (semantic-register-of XMM14) size);
    mov size xmm14 (imm 0);
    xmm15 <- return (at-offset (semantic-register-of XMM15) size);
    mov size xmm15 (imm 0)
  end else
    return void
end

## W>>
## X>>

val sem-xadd x = do
  size <- sizeof1 x.opnd1;
  src0 <- rval size x.opnd1;
  src1 <- rval size x.opnd2;
  dst0 <- lval-volatile size x.opnd1;
  dst1 <- lval-volatile size x.opnd2;

  sum <- mktemp;
  add size sum src0 src1;

  emit-add-adc-flags size (var sum) src0 src1 (imm 0) '1';

  t <- mktemp;
  mov size t src0;
  write size dst1 (var t);
  write size dst0 (var sum)
end

val sem-xchg x = do
  sz <- sizeof1 x.opnd1;
  a-r <- rval sz x.opnd1;
  b-r <- rval sz x.opnd2;
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
  src0 <- rval sz x.opnd1;
  src1 <- rvals Signed sz x.opnd2;

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

  emit-virt-flags;

  write sz dst (var temp)
end

## Y>>
## Z>>
