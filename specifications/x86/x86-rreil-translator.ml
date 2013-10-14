# vim: filetype=sml:ts=3:sw=3:expandtab

export = translate translateBlock translateSingle translateSuperBlock succ_pretty

type sem_exception =
   SEM_DIVISION_OVERFLOW

type sem_writeback =
   SEM_WRITE_VAR of {size:int, id:sem_var}
 | SEM_WRITE_MEM of {size:int, address:sem_linear, segment:seg_override}

#Todo: fix
val runtime-stack-address-size = do
  mode64 <- mode64?;
  if mode64 then
    return 64
  else
    return 32
end

val ip-get = do
  return (var (semantic-register-of RIP))
#  k <- ipget;
#  return (imm k)
end

val segment-register? x =
  case x of
     CS: '1'
   | SS: '1'
   | DS: '1'
   | ES: '1'
   | FS: '1'
   | GS: '1'
   | _ : '0'
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
   | PTR16/16 x: return 32
   | PTR16/32 x: return 48
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

val expand dst-getter conv lin from-sz to-sz =
  if from-sz === to-sz then
    return lin
  else do
    expanded <- dst-getter;
    case conv of
       Signed: movsx to-sz expanded from-sz lin
     | Unsigned: movzx to-sz expanded from-sz lin
    end;
    return (var expanded)
  end

val segment-add mode64 address segment = let
  val seg-sem seg-reg = SEM_LIN_VAR(semantic-register-of-mr '1' seg-reg)
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

  expanded <- expand mktemp Unsigned lin sz real-addr-sz;
  return (segment-add mode64 expanded segment)
end
val segmented-reg reg segment = segmented-lin (var reg) reg.size segment

val segmented-load dst-sz dst addr-sz address segment = do
  address-segmented <- segmented-lin address addr-sz segment;
  addr-sz <- real-addr-sz;
  load dst-sz dst addr-sz address-segmented
end

val segmented-store sz addr rhs segment = do
  address-segmented <- segmented-lin addr.address addr.size segment;
  addr-sz <- real-addr-sz;
  store sz (address addr-sz address-segmented) rhs
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

type offset-option =
   OFFSET_NONE
 | OFFSET_LIN of sem_linear
 | OFFSET_CONST of int

val conv-with is-mem ptro conv sz x =
   let
      val conv-imm conv x = case conv of
      	  Signed: return (SEM_LIN_IMM{const=sx x})
	| Unsigned: return (SEM_LIN_IMM{const=zx x})
      end

      val conv-reg conv sz r = do
        reg <- return (semantic-register-of-mr is-mem r);
	expanded <- expand mktemp conv (var reg) reg.size sz;
	return expanded
      end

      val conv-sum conv sz x =
         do op1 <- conv-with is-mem ptro conv sz x.a;
            op2 <- conv-with is-mem ptro conv sz x.b;
            return
               (SEM_LIN_ADD
                  {opnd1=op1,
                   opnd2=op2})
         end

      val conv-scale conv sz x =
         do op <- conv-with is-mem ptro conv sz x.opnd;
            return
               (SEM_LIN_SCALE
                  {opnd=op,
                   const=
                     case $imm x of
                        '00': 1
                      | '01': 2
                      | '10': 4
                      | '11': 8
                     end})
         end

      val conv-mem x = case ptro of
         OFFSET_NONE: conv-with '1' ptro Signed x.psz x.opnd
       | OFFSET_LIN o: do
           opnd2 <- conv-with '1' ptro Signed x.psz x.opnd;
           return (SEM_LIN_ADD {opnd1=o, opnd2=opnd2})
         end
       | OFFSET_CONST o: do
           opnd2 <- conv-with '1' ptro Signed x.psz x.opnd;
           return (SEM_LIN_ADD {opnd1=SEM_LIN_IMM {const=o}, opnd2=opnd2})
         end
      end

   in
      case x of
         IMM8 x: conv-imm conv x.imm
       | IMM16 x: conv-imm conv x.imm
       | IMM32 x: conv-imm conv x.imm
       | IMM64 x: conv-imm conv x.imm
       | REG x: conv-reg conv sz x
       | SUM x: conv-sum conv sz x
       | SCALE x: conv-scale conv sz x
       | MEM x:
         let
            val m expanded = do
              address <- conv-mem x;
              segmented-load x.sz expanded x.psz address x.segment;
              expand (return expanded) conv (var expanded) x.sz sz
            end
         in do
            expanded <- mktemp;
            with-subscope (m expanded)
            end
         end
      end
   end

val rval sz x = conv-with '0' OFFSET_NONE Unsigned sz x
val rvals conv sz x = conv-with '0' OFFSET_NONE conv sz x
val rval-ptroff sz offset x = conv-with '0' (OFFSET_LIN offset) Unsigned sz x

val extract-imm-unsigned imm =
  case imm of
     IMM8 x: zx x.imm
   | IMM16 x: zx x.imm
   | IMM32 x: zx x.imm
   | IMM64 x: zx x.imm
 end

val read-addr-reg x =
  case x of
     MEM m:
       case m.opnd of
          REG r: r
       end
  end

val read-flow sz x =
   let
      val conv-bv v = return (SEM_LIN_IMM{const=sx v})
   in
      case x of
         REL8 x: conv-bv x
       | REL16 x: conv-bv x
       | REL32 x: conv-bv x
       | REL64 x: conv-bv x
       | PTR16/16 x: conv-bv x
       | PTR16/32 x: conv-bv x
       | NEARABS x: rval sz x
       | FARABS x: rval sz x
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

#Todo: MEM => byte offset, REG => bit offset... confusing (division?)
val lval-offset-volatile sz x offset volatile = case x of
   MEM x: do
     #Offset for memory operands? => Add offset to pointer
     address <- conv-with '1' OFFSET_NONE Signed x.psz x.opnd;
     address <- if volatile then do
       t <- mktemp;
       mov x.psz t address;
       return (var t)
     end else
       return address
     ;
     combined <- return (case offset of
        OFFSET_NONE: address
      | OFFSET_LIN l: SEM_LIN_ADD{opnd1=address,opnd2=l}
      | OFFSET_CONST c: SEM_LIN_ADD{opnd1=address,opnd2=SEM_LIN_IMM {const=c}}
     end);
     return (SEM_WRITE_MEM{size=x.psz,address=combined,segment=x.segment})
   end
 | REG r: do 
     id <- return (semantic-register-of-operand-with-size x sz);
     combined <- return (case offset of
        OFFSET_NONE: id
      | OFFSET_CONST c: @{offset=id.offset + c} id
     end);
     return (SEM_WRITE_VAR{size= $size id,id=combined})
   end
end

val lval-offset sz x offset = lval-offset-volatile sz x offset '0'

val lval sz x = lval-offset sz x OFFSET_NONE
val lval-volatile sz x = lval-offset-volatile sz x OFFSET_NONE '1'
val lval-upper sz x = lval-offset sz x (OFFSET_CONST sz)
val lval-ptroff sz offset x = lval-offset sz x (OFFSET_LIN offset)

val register? x =
  case x of
      REG: '1'
    | _: '0'
  end

val postproc-reg avx-encoded sz id = do
  mode64 <- mode64?;
  if (mode64 and (not (is-avx-sse id.id)) and sz === 32) then
    #Todo: Only if sz == 32? - Yes (tested)!
    #Todo: Only for a subset of all registers?
         mov (64 - sz) (at-offset id sz) (imm 0)
  else if (avx-encoded and (is-avx-sse id.id) and sz < 256) then
    mov (256 - sz) (at-offset id sz) (imm 0)
  else
    return void
end

val write-extend-reg avx-encoded sz a b = do
  mov sz a b;
  postproc-reg avx-encoded sz a
end

val write-extend avx-encoded sz a b =
   case a of
      SEM_WRITE_MEM x:
         #store x (SEM_LIN{size=sz,opnd1=b})
	 segmented-store sz x (SEM_SEXPR (SEM_SEXPR_LIN b)) x.segment
    | SEM_WRITE_VAR x: do
        #if mode64 then
	#  mov 32 (semantic-register-of EAX) (imm 100)
	#else
	#  return void
	#;
        #if (is-avx-sse x.id.id) then
	#  mov 32 (semantic-register-of EAX) (imm 101)
	#else
	#  return void
	#;
        #if (avx-encoded) then
	#  mov 32 (semantic-register-of EAX) (imm 102)
	#else
	#  return void
	#;
	#mov 32 (semantic-register-of EAX) (imm (500 + sz));

	mov sz x.id b;

   postproc-reg avx-encoded sz x.id

#        case sz of
#           32:
#              case x.id.offset of
#                 0:
#                    do mov 32 x.id b;
#                       # Zero the upper half of the given register/variable
#                       mov 32 (@{offset=32} x.id) (SEM_LIN_IMM {imm=0})
#                    end
#               | _: mov sz x.id b
#              end
#         | _: mov sz x.id b
#        end
        end
   end

val write sz a b = write-extend '0' sz a b

val combine high low = do
  high <- return (semantic-register-of high);
  low <- return (semantic-register-of low);
 
  sz <- return high.size;
 
  combined <- mktemp;
  mov sz (at-offset combined sz) (var high);
  mov sz combined (var low);
 
  return combined
end

val move-combined size dst-high dst-low src = do
  dst-high <- return (semantic-register-of dst-high);
  dst-low <- return (semantic-register-of dst-low);
 
  write-extend-reg '0' size dst-high (var (at-offset src size));
  write-extend-reg '0' size dst-low (var (at-offset src 0))
end

val sem-a sem-cc x = do
  leu <- fLEU;
  sem-cc x (/not (var leu))
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
  leu <- fLEU;
  sem-cc x (/d (var leu))
end
val sem-na sem-cc x = sem-be sem-cc x

val sem-e sem-cc x = do
  zf <- fZF;
  sem-cc x (/d (var zf))
end
val sem-z sem-cc x = sem-e sem-cc x

val sem-g sem-cc x = do
  les <- fLES;
  sem-cc x (/not (var les))
end
val sem-nle sem-cc x = sem-g sem-cc x

val sem-ge sem-cc x = do
  lts <- fLTS;
  sem-cc x (/not (var lts))
end
val sem-nl sem-cc x = sem-ge sem-cc x

val sem-l sem-cc x = do
  lts <- fLTS;
  sem-cc x (/d (var lts))
end
val sem-nge sem-cc x = sem-l sem-cc x

val sem-le sem-cc x = do
  les <- fLES;
  sem-cc x (/d (var les))
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
  a <- lval sz opnd;
  t <- mktemp;
	undef sz t;
  write sz a (var t)
end

val sem-undef-arity-ge1 x = do
  case x.opnd1 of
     REG r: undef-opnd x.opnd1
   | MEM m: return void
   | _: return void
  end
end

val sem-default-arity0-generic avx-encoded insn x = prim-generic (show/mnemonic insn) varls-none varls-none
val sem-default-arity0 insn x = sem-default-arity0-generic '0' insn x

val sem-default-arity1-generic avx-encoded insn x = do
  dst-sz <- sizeof1 x.opnd1;
  src1-sz <- return dst-sz;

  dst <- lval dst-sz x.opnd1;
  src1 <- rval src1-sz x.opnd1;

  temp-dst <- mktemp;
  src1-up <- unpack-lin src1-sz src1;

  prim-generic (show/mnemonic insn) (varls-one (varl dst-sz temp-dst)) (varls-one (varl src1-sz src1-up));

  write-extend avx-encoded dst-sz dst (var temp-dst)
end
val sem-default-arity1 insn x = sem-default-arity1-generic '0' insn x

val sem-default-arity2-generic avx-encoded insn x = do
  dst-sz <- sizeof1 x.opnd1;
  src1-sz <- return dst-sz;
  src2-sz <- sizeof1 x.opnd2;

  dst <- lval dst-sz x.opnd1;
  src1 <- rval src1-sz x.opnd1;
  src2 <- rval src2-sz x.opnd2;

  temp-dst <- mktemp;
  src1-up <- unpack-lin src1-sz src1;
  src2-up <- unpack-lin src2-sz src2;

  prim-generic (show/mnemonic insn) (varls-one (varl dst-sz temp-dst)) (varls-more (varl src1-sz src1-up) (varls-one (varl src2-sz src2-up)));

  write-extend avx-encoded dst-sz dst (var temp-dst)
end
val sem-default-arity2 insn x = sem-default-arity2-generic '0' insn x

val sem-default-arity3-generic avx-encoded insn x = do
  dst-sz <- sizeof1 x.opnd1;
  src1-sz <- return dst-sz;
  src2-sz <- sizeof1 x.opnd2;
  src3-sz <- sizeof1 x.opnd3;

  dst <- lval dst-sz x.opnd1;
  src1 <- rval src1-sz x.opnd1;
  src2 <- rval src2-sz x.opnd2;
  src3 <- rval src3-sz x.opnd3;

  temp-dst <- mktemp;
  src1-up <- unpack-lin src1-sz src1;
  src2-up <- unpack-lin src2-sz src2;
  src3-up <- unpack-lin src3-sz src3;

  prim-generic (show/mnemonic insn) (varls-one (varl dst-sz temp-dst)) (varls-more (varl src1-sz src1-up) (varls-more (varl src2-sz src2-up) (varls-one (varl src3-sz src3-up))));

  write-extend avx-encoded dst-sz dst (var temp-dst)
end
val sem-default-arity3 insn x = sem-default-arity3-generic '0' insn x

val sem-default-arity4-generic avx-encoded insn x = do
  dst-sz <- sizeof1 x.opnd1;
  src1-sz <- return dst-sz;
  src2-sz <- sizeof1 x.opnd2;
  src3-sz <- sizeof1 x.opnd3;
  src4-sz <- sizeof1 x.opnd4;

  dst <- lval dst-sz x.opnd1;
  src1 <- rval src1-sz x.opnd1;
  src2 <- rval src2-sz x.opnd2;
  src3 <- rval src3-sz x.opnd3;
  src4 <- rval src4-sz x.opnd4;

  temp-dst <- mktemp;
  src1-up <- unpack-lin src1-sz src1;
  src2-up <- unpack-lin src2-sz src2;
  src3-up <- unpack-lin src3-sz src3;
  src4-up <- unpack-lin src4-sz src4;

  prim-generic (show/mnemonic insn) (varls-one (varl dst-sz temp-dst)) (varls-more (varl src1-sz src1-up) (varls-more (varl src2-sz src2-up) (varls-more (varl src3-sz src3-up)  (varls-one (varl src4-sz src4-up)))));

  write-extend avx-encoded dst-sz dst (var temp-dst)
end
val sem-default-arity4 insn x = sem-default-arity4-generic '0' insn x

val sem-default-varity insn x = do
  case x of
     VA0 x: sem-default-arity0-generic '1' insn x
   | VA1 x: sem-default-arity1-generic '1' insn x
   | VA2 x: sem-default-arity2-generic '1' insn x
   | VA3 x: sem-default-arity3-generic '1' insn x
   | VA4 x: sem-default-arity4-generic '1' insn x
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

val emit-add-adc-flags sz sum s0 s1 carry set-carry = let
  val emit = do
#    eq <- fEQ;
#    les <- fLES;
#    leu <- fLEU;
#    lts <- fLTS;
#    ltu <- fLTU;
    sf <- fSF;
    ov <- fOF;
    zf <- fZF;
    cf <- fCF;
    t1 <- mktemp;
    t2 <- mktemp;
    t3 <- mktemp;
  
#    cmpltu sz ltu s0 s1;
    xorb sz t1 sum s0;
    xorb sz t2 sum s1;
    andb sz t3 (var t1) (var t2);
    cmplts sz ov (var t3) (imm 0);
    cmplts sz sf sum (imm 0);
#   cmpeq sz eq sum (imm 0);
#    xorb 1 lts (var sf) (var ov);
#   orb 1 leu (var ltu) (var eq);
#   orb 1 les (var lts) (var eq);
    cmpeq sz zf sum (imm 0);
  
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
    emit-arithmetic-adjust-flag sz sum s0 s1;
    emit-virt-flags
  end
in
  with-subscope emit
end

val emit-sub-sbb-flags sz difference minuend subtrahend carry set-carry = let
  val emit = do
    sf <- fSF;
    ov <- fOF;
    cf <- fCF;
    z <- fZF;
    t1 <- mktemp;
    t2 <- mktemp;
    t3 <- mktemp;

    cmplts sz sf difference (imm 0);
    cmpeq sz z difference (imm 0);

    #xorb 1 ov (var tlts) (var sf);
    #t <- mktemp;
    #xorb sz t difference minuend;
    #xorb sz t (var t) subtrahend;
    #cmplts sz ov (var t) (imm 0);

    tlts <- mktemp;
    add sz tlts subtrahend carry;
    cmplts sz tlts minuend (var tlts);
    xorb 1 ov (var tlts) (var sf);

    # Hacker's Delight - Unsigned Add/Subtract
    _if (/d carry) _then do
      if set-carry then
        cmpleu sz cf minuend subtrahend
      else
        return void
      ;
      emit-virt-flags
    end _else do
      if set-carry then
        cmpltu sz cf minuend subtrahend
      else
        return void
      ;
#     eq <- fEQ;
      les <- fLES;
      leu <- fLEU;
#     ltu <- fLTU;
      lts <- fLTS;
#     cmpltu sz ltu minuend subtrahend;
      cmpleu sz leu minuend subtrahend;
      mov 1 lts (var tlts);
      cmples sz les minuend subtrahend
 #    cmpeq sz eq minuend subtrahend
    end;
  
    emit-parity-flag difference;
    emit-arithmetic-adjust-flag sz difference minuend subtrahend
  end
in
  with-subscope emit
end

val emit-mul-flags signedness sz product = let
  val emit = do
    ov <- fOF;
    cf <- fCF;
    sf <- fSF;
    zf <- fZF;
    af <- fAF;
    pf <- fPF;
    #xorb 1 sgn-ext (var (at-offset factor0 (sz - 1))) (var (at-offset factor1 (sz - 1)));
    #sa <- mktemp;
    #sb <- mktemp;
    #cmplts sz sa factor0 (imm 0);
    #cmplts sz sb factor1 (imm 0);
    #xorb 1 sgn-ext (var sa) (var sb);
    #sub sz sgn-ext (imm 0) (var sgn-ext);
  
    case signedness of
       Signed: do
         sgn-ext <- mktemp;
         movsx (sz + 1) sgn-ext 1 (var (at-offset product (sz + sz - 1)));
         cmpneq (sz + 1) ov (var (at-offset product (sz - 1))) (var sgn-ext)
       end
     | Unsigned: do
         cmpneq sz ov (var (at-offset product sz)) (imm 0)
       end
    end;

    mov 1 cf (var ov);
  
    undef 1 sf;
    undef 1 zf;
    undef 1 af;
    undef 1 pf;

    emit-virt-flags
  end
in
  with-subscope emit
end

val emit-virt-flags = do
  leu <- fLEU;
  lts <- fLTS;
  les <- fLES;

  cf <- fCF;
  zf <- fZF;
  sf <- fSF;
  ov <- fOF;

  #LEU := C | Z
  orb 1 leu (var cf) (var zf);

  #LTS := S != O
  cmpneq 1 lts (var sf) (var ov);

  #LES := S != O | Z
  orb 1 les (var lts) (var zf)
end

val move-to-rflags size lin = let
  val emit = do
    flags <- rflags;
  
    in-mask <- return 0x0000000000245fd5;
    out-mask <- return 0xffffffffffc3a02a;
  
    temp <- mktemp;
    andb size temp lin (imm in-mask);
    andb size flags (var flags) (imm out-mask);
    orb size flags (var flags) (var temp)
  end
in
  with-subscope emit
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
  ;

  postproc-reg '0' reg-size reg-sem
end

val exp base e =
  case e of
     0: 1
   | x: base * (exp base (e - 1))
  end

val vector-apply size element-size monad = do
  limit <- return (/z size element-size);

  let
    val f i = do
      with-subscope (monad i);

      if (i < (limit - 1)) then
        f (i + 1)
      else
        return void
    end
  in
    f 0
  end
end

#val avx-expand-dst x sem = do
#  sem;
# 
#  size <- sizeof1 x.opnd1;
#  out-size <- return
#    (case x.opnd1 of
#        REG r: 256
#      | _: size
#    end)
#  ;
#
#  if out-size > size then do
#    rest-size <- return (out-size - size);
#    
#    src <- read size x.opnd1;
#    dst <- lval out-size x.opnd1;
#
#    temp <- mktemp;
#    movzx out-size temp size src;
#
#    write out-size dst (var temp)
#  end else
#    return void
#end

val binop-signed-saturating operator size dst src1 src2 = do
  dst-ex <- mktemp;
  src1-ex <- mktemp;
  src2-ex <- mktemp;

  upper <- return (
    case size of
       8: 0x7f
     | 16: 0x7fff
    end
  );
  lower <- return (
    case size of
       8: (0-0x80)
     | 16: (0-0x8000)
    end
  );

  movsx (size + 1) src1-ex size src1;
  movsx (size + 1) src2-ex size src2;
  operator (size + 1) dst-ex (var src1-ex) (var src2-ex);
  
  _if (/gts (size + 1) (var dst-ex) (imm upper)) _then (
    mov size dst (imm upper)
  ) _else ( _if (/lts (size + 1) (var dst-ex) (imm lower)) _then
    mov size dst (imm lower)
  _else
    mov size dst (var dst-ex)
  )
end

val add-signed-saturating size dst src1 src2 = binop-signed-saturating add size dst src1 src2
val sub-signed-saturating size dst src1 src2 = binop-signed-saturating sub size dst src1 src2

val binop-unsigned-saturating operator comparer limit size dst src1 src2 = do
  operator size dst src1 src2;
 
  _if (comparer size (var dst) src1) _then (
    mov size dst (imm limit)
  )
end

val add-unsigned-saturating size dst src1 src2 = do
  limit <- return (
    case size of
       8: 0xff
     | 16: 0xffff
    end
  );
  binop-unsigned-saturating add /ltu limit size dst src1 src2
end

val sub-unsigned-saturating size dst src1 src2 = binop-unsigned-saturating sub /gtu 0 size dst src1 src2

val semantics insn =
  case insn of
     AAA x: sem-default-arity0 insn x
   | AAD x: sem-default-arity1 insn x
   | AAM x: sem-default-arity1 insn x
   | AAS x: sem-default-arity0 insn x
   | ADC x: sem-adc x
   | ADD x: sem-add x
   | ADDPD x: sem-default-arity2 insn x
   | ADDPS x: sem-default-arity2 insn x
   | ADDSD x: sem-default-arity2 insn x
   | ADDSS x: sem-default-arity2 insn x
   | ADDSUBPD x: sem-default-arity2 insn x
   | ADDSUBPS x: sem-default-arity2 insn x
   | AESDEC x: sem-aesdec x
   | AESDECLAST x: sem-default-arity2 insn x
   | AESENC x: sem-default-arity2 insn x
   | AESENCLAST x: sem-default-arity2 insn x
   | AESIMC x: sem-default-arity2 insn x
   | AESKEYGENASSIST x: sem-default-arity3 insn x
   | AND x: sem-and x
   | ANDNPD x: sem-default-arity2 insn x
   | ANDNPS x: sem-default-arity2 insn x
   | ANDPD x: sem-andpd x
   | ANDPS x: sem-default-arity2 insn x
   | ARPL x: sem-default-arity2 insn x
   | BLENDPD x: sem-default-arity3 insn x
   | BLENDPS x: sem-default-arity3 insn x
   | BLENDVPD x: sem-default-arity3 insn x
   | BLENDVPS x: sem-default-arity3 insn x
   | BOUND x: sem-default-arity2 insn x
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
   | CLC x: sem-default-arity0 insn x
   | CLD x: sem-default-arity0 insn x
   | CLFLUSH x: sem-default-arity1 insn x
   | CLI x: sem-default-arity0 insn x
   | CLTS x: sem-default-arity0 insn x
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
   | CMPPD x: sem-default-arity3 insn x
   | CMPPS x: sem-default-arity3 insn x
   | CMPS x: sem-repe-repne-insn x sem-cmps
   | CMPSD x: sem-default-arity3 insn x
#   | CMPSD x:
#       case x of
#         VA0: sem-cmpsd
#       | _ x: sem-default-arity0 insn x
#      end
#   | CMPSQ x: sem-default-arity0 insn x
   | CMPSS x: sem-default-arity3 insn x
   | CMPXCHG x: sem-cmpxchg x
   | CMPXCHG16B x: sem-cmpxchg16b-cmpxchg8b x
   | CMPXCHG8B x: sem-cmpxchg16b-cmpxchg8b x
   | COMISD x: sem-default-arity2 insn x
   | COMISS x: sem-default-arity2 insn x
   | CPUID x: sem-cpuid x
   | CQO x: sem-cwd-cdq-cqo x
   | CRC32 x: sem-default-arity2 insn x
   | CVTDQ2PD x: sem-default-arity2 insn x
   | CVTDQ2PS x: sem-default-arity2 insn x
   | CVTPD2DQ x: sem-default-arity2 insn x
   | CVTPD2PI x: sem-default-arity2 insn x
   | CVTPD2PS x: sem-default-arity2 insn x
   | CVTPI2PD x: sem-default-arity2 insn x
   | CVTPI2PS x: sem-default-arity2 insn x
   | CVTPS2DQ x: sem-default-arity2 insn x
   | CVTPS2PD x: sem-default-arity2 insn x
   | CVTPS2PI x: sem-default-arity2 insn x
   | CVTSD2SI x: sem-default-arity2 insn x
   | CVTSD2SS x: sem-default-arity2 insn x
   | CVTSI2SD x: sem-default-arity2 insn x
   | CVTSI2SS x: sem-default-arity2 insn x
   | CVTSS2SD x: sem-default-arity2 insn x
   | CVTSS2SI x: sem-default-arity2 insn x
   | CVTTPD2DQ x: sem-default-arity2 insn x
   | CVTTPD2PI x: sem-default-arity2 insn x
   | CVTTPS2DQ x: sem-default-arity2 insn x
   | CVTTPS2PI x: sem-default-arity2 insn x
   | CVTTSD2SI x: sem-default-arity2 insn x
   | CVTTSS2SI x: sem-default-arity2 insn x
   | CWD x: sem-cwd-cdq-cqo x
   | CWDE x: sem-convert 16
   | DAA x: sem-default-arity0 insn x
   | DAS x: sem-default-arity0 insn x
   | DEC x: sem-dec x
   | DIV x: sem-div Unsigned x
   | DIVPD x: sem-default-arity2 insn x
   | DIVPS x: sem-default-arity2 insn x
   | DIVSD x: sem-default-arity2 insn x
   | DIVSS x: sem-default-arity2 insn x
   | DPPD x: sem-default-arity3 insn x
   | DPPS x: sem-default-arity3 insn x
   | EMMS x: sem-default-arity0 insn x
   | ENTER x: sem-default-arity2 insn x
   | EXTRACTPS x: sem-default-arity3 insn x
   | F2XM1 x: sem-default-arity0 insn x
   | FABS x: sem-default-arity0 insn x
   | FADD x: sem-fadd x
   | FADDP x: sem-default-arity2 insn x
   | FBLD x: sem-default-arity1 insn x
   | FBSTP x: sem-default-arity1 insn x
   | FCHS x: sem-default-arity0 insn x
   | FCLEX x: sem-default-arity0 insn x
   | FCMOVB x: sem-default-arity2 insn x
   | FCMOVBE x: sem-default-arity2 insn x
   | FCMOVE x: sem-default-arity2 insn x
   | FCMOVNB x: sem-default-arity2 insn x
   | FCMOVNBE x: sem-default-arity2 insn x
   | FCMOVNE x: sem-default-arity2 insn x
   | FCMOVNU x: sem-default-arity2 insn x
   | FCMOVU x: sem-default-arity2 insn x
   | FCOM x: sem-default-arity1 insn x
   | FCOMI x: sem-default-arity2 insn x
   | FCOMIP x: sem-default-arity2 insn x
   | FCOMP x: sem-default-arity1 insn x
   | FCOMPP x: sem-default-arity0 insn x
   | FCOS x: sem-default-arity0 insn x
   | FDECSTP x: sem-default-arity0 insn x
   | FDIV x: sem-default-arity2 insn x
   | FDIVP x: sem-default-arity2 insn x
   | FDIVR x: sem-default-arity2 insn x
   | FDIVRP x: sem-default-arity2 insn x
   | FFREE x: sem-default-arity1 insn x
   | FIADD x: sem-default-arity1 insn x
   | FICOM x: sem-default-arity1 insn x
   | FICOMP x: sem-default-arity1 insn x
   | FIDIV x: sem-default-arity2 insn x
   | FIDIVR x: sem-default-arity1 insn x
   | FILD x: sem-default-arity1 insn x
   | FIMUL x: sem-default-arity1 insn x
   | FINCSTP x: sem-default-arity0 insn x
   | FINIT x: sem-default-arity0 insn x
   | FIST x: sem-default-arity1 insn x
   | FISTP x: sem-default-arity1 insn x
   | FISTTP x: sem-default-arity1 insn x
   | FISUB x: sem-default-arity1 insn x
   | FISUBR x: sem-default-arity1 insn x
   | FLD x: sem-default-arity1 insn x
   | FLD1 x: sem-default-arity0 insn x
   | FLDCW x: sem-default-arity1 insn x
   | FLDENV x: sem-default-arity1 insn x
   | FLDL2E x: sem-default-arity0 insn x
   | FLDL2T x: sem-default-arity0 insn x
   | FLDLG2 x: sem-default-arity0 insn x
   | FLDLN2 x: sem-default-arity0 insn x
   | FLDPI x: sem-default-arity0 insn x
   | FLDZ x: sem-default-arity0 insn x
   | FMUL x: sem-default-arity2 insn x
   | FMULP x: sem-default-arity2 insn x
   | FNCLEX x: sem-default-arity0 insn x
   | FNINIT x: sem-default-arity0 insn x
   | FNOP x: sem-default-arity0 insn x
   | FNSAVE x: sem-default-arity1 insn x
   | FNSTCW x: sem-default-arity1 insn x
   | FNSTENV x: sem-default-arity1 insn x
   | FNSTSW x: sem-default-arity1 insn x
   | FPATAN x: sem-default-arity0 insn x
   | FPREM1 x: sem-default-arity0 insn x
   | FPREM x: sem-default-arity0 insn x
   | FPTAN x: sem-default-arity0 insn x
   | FRNDINT x: sem-default-arity0 insn x
   | FRSTOR x: sem-default-arity1 insn x
   | FSAVE x: sem-default-arity1 insn x
   | FSCALE x: sem-default-arity0 insn x
   | FSIN x: sem-default-arity0 insn x
   | FSINCOS x: sem-default-arity0 insn x
   | FSQRT x: sem-default-arity0 insn x
   | FST x: sem-default-arity1 insn x
   | FSTCW x: sem-default-arity1 insn x
   | FSTENV x: sem-default-arity1 insn x
   | FSTP x: sem-default-arity1 insn x
   | FSTSW x: sem-default-arity1 insn x
   | FSUB x: sem-default-arity2 insn x
   | FSUBP x: sem-default-arity2 insn x
   | FSUBR x: sem-default-arity2 insn x
   | FSUBRP x: sem-default-arity2 insn x
   | FTST x: sem-default-arity0 insn x
   | FUCOM x: sem-default-arity1 insn x
   | FUCOMI x: sem-default-arity1 insn x
   | FUCOMIP x: sem-default-arity1 insn x
   | FUCOMP x: sem-default-arity1 insn x
   | FUCOMPP x: sem-default-arity0 insn x
   | FXAM x: sem-default-arity0 insn x
   | FXCH x: sem-default-arity1 insn x
   | FXRSTOR x: sem-default-arity1 insn x
   | FXRSTOR64 x: sem-default-arity1 insn x
   | FXSAVE x: sem-default-arity1 insn x
   | FXSAVE64 x: sem-default-arity1 insn x
   | FXTRACT x: sem-default-arity0 insn x
   | FYL2X x: sem-default-arity0 insn x
   | FYL2XP1 x: sem-default-arity0 insn x
   | HADDPD x: sem-default-arity2 insn x
   | HADDPS x: sem-default-arity2 insn x
   | HLT x: sem-default-arity0 insn x
   | HSUBPD x: sem-default-arity2 insn x
   | HSUBPS x: sem-default-arity2 insn x
   | IDIV x: sem-idiv x
   | IMUL v:
       case v of
          VA1 x: sem-imul-1 x
        | VA2 x: sem-imul-2 x
        | VA3 x: sem-imul-3 x
       end
   | IN x: sem-default-arity2 insn x
   | INC x: sem-inc x
   | INSB x: sem-default-arity0 insn x
   | INSD x: sem-default-arity0 insn x
   | INSERTPS x: sem-default-arity3 insn x
   | INSW x: sem-default-arity0 insn x
   | INT x: sem-default-arity1 insn x
   | INT0 x: sem-default-arity0 insn x
   | INT3 x: sem-default-arity0 insn x
   | INVD x: sem-invd
   | INVLPG x: sem-default-arity1 insn x
   | INVPCID x: sem-default-arity2 insn x
   | IRET x: sem-default-arity0 insn x
   | IRETD x: sem-default-arity0 insn x
   | IRETQ x: sem-default-arity0 insn x
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
   | LAR x: sem-lar insn x
   | LDDQU x: sem-mov '0' x
   | LDMXCSR x: sem-default-arity1 insn x
   | LDS x: sem-lds-les-lfs-lgs-lss x DS
   | LEA x: sem-lea x
   | LEAVE x: sem-default-arity0 insn x
   | LES x: sem-lds-les-lfs-lgs-lss x ES
   | LFENCE x: sem-default-arity0 insn x
   | LFS x: sem-lds-les-lfs-lgs-lss x FS
   | LGDT x: sem-default-arity1 insn x
   | LGS x: sem-lds-les-lfs-lgs-lss x GS
   | LIDT x: sem-default-arity1 insn x
   | LLDT x: sem-default-arity1 insn x
   | LMSW x: sem-default-arity1 insn x
   | LODS x: sem-rep-insn x sem-lods
   | LOOP x: sem-loop x
   | LOOPE x: sem-loope x
   | LOOPNE x: sem-loopne x
   | LSL x: sem-default-arity2 insn x
   | LSS x: sem-lds-les-lfs-lgs-lss x SS
   | LTR x: sem-default-arity1 insn x
   | MASKMOVDQU x: sem-maskmovdqu-vmaskmovdqu x
   | MASKMOVQ x: sem-maskmovq x
   | MAXPD x: sem-default-arity2 insn x
   | MAXPS x: sem-default-arity2 insn x
   | MAXSD x: sem-default-arity2 insn x
   | MAXSS x: sem-default-arity2 insn x
   | MFENCE x: sem-default-arity0 insn x
   | MINPD x: sem-default-arity2 insn x
   | MINPS x: sem-default-arity2 insn x
   | MINSD x: sem-default-arity2 insn x
   | MINSS x: sem-default-arity2 insn x
   | MONITOR x: sem-default-arity0 insn x
   | MOV x: sem-mov '0' x
   | MOVAPD x: sem-mov '0' x
   | MOVAPS x: sem-mov '0' x
   | MOVBE x: sem-movbe x
   | MOVD x: sem-movzx '0' x
   | MOVDDUP x: sem-default-arity2 insn x
   | MOVDQ2Q x: sem-mov '0' x
   | MOVDQA x: sem-mov '0' x
   | MOVDQU x: sem-mov '0' x
   | MOVHLPS x: sem-default-arity2 insn x
   | MOVHPD x: sem-default-arity2 insn x
   | MOVHPS x: sem-default-arity2 insn x
   | MOVLHPS x: sem-default-arity2 insn x
   | MOVLPD x: sem-default-arity2 insn x
   | MOVLPS x: sem-default-arity2 insn x
   | MOVMSKPD x: sem-default-arity2 insn x
   | MOVMSKPS x: sem-default-arity2 insn x
   | MOVNTDQ x: sem-mov '0' x
   | MOVNTDQA x: sem-mov '0' x
   | MOVNTI x: sem-mov '0' x
   | MOVNTPD x: sem-default-arity2 insn x
   | MOVNTPS x: sem-default-arity2 insn x
   | MOVNTQ x: sem-mov '0' x
   | MOVQ x: sem-movq x
   | MOVQ2DQ x: sem-movzx '0' x
   | MOVS x: sem-rep-insn x sem-movs
   | MOVSD x: sem-default-arity2 insn x
   | MOVSHDUP x: sem-default-arity2 insn x
   | MOVSLDUP x: sem-default-arity2 insn x
   | MOVSS x: sem-default-arity2 insn x
   | MOVSW x: sem-default-arity2 insn x
   | MOVSX x: sem-movsx x
   | MOVSXD x: sem-movsx x
   | MOVUPD x: sem-default-arity2 insn x
   | MOVUPS x: sem-default-arity2 insn x
   | MOVZX x: sem-movzx '0' x
   | MPSADBW x: sem-default-arity3 insn x
   | MUL x: sem-mul Unsigned x
   | MULPD x: sem-default-arity2 insn x
   | MULPS x: sem-default-arity2 insn x
   | MULSD x: sem-default-arity2 insn x
   | MULSS x: sem-default-arity2 insn x
   | MWAIT x: sem-nop
   | NEG x: sem-neg x
   | NOP x: sem-nop
   | NOT x: sem-not x
   | OR x: sem-or x
   | ORPD x: sem-default-arity2 insn x
   | ORPS x: sem-default-arity2 insn x
   | OUT x: sem-default-arity2 insn x
   | OUTS x: sem-default-arity0 insn x
   | OUTSB x: sem-default-arity0 insn x
   | OUTSD x: sem-default-arity0 insn x
   | OUTSW x: sem-default-arity0 insn x
   | PABSB x: sem-pabs '0' 8 x
   | PABSD x: sem-pabs '0' 32 x
   | PABSW x: sem-pabs '0' 16 x
   | PACKSSDW x: sem-packsswb-packssdw 16 x
   | PACKSSWB x: sem-packsswb-packssdw 8 x
   | PACKUSDW x: sem-packuswb-packusdw 16 x
   | PACKUSWB x: sem-packuswb-packusdw 8 x
   | PADDB x: sem-padd 8 x
   | PADDD x: sem-padd 32 x
   | PADDQ x: sem-padd 64 x
   | PADDSB x: sem-padds 8 x
   | PADDSW x: sem-padds 16 x
   | PADDUSB x: sem-paddus 8 x
   | PADDUSW x: sem-paddus 16 x
   | PADDW x: sem-padd 16 x
   | PALIGNR x: sem-palignr x
   | PAND x: sem-pand x
   | PANDN x: sem-pandn x
   | PAUSE x: sem-default-arity0 insn x
   | PAVGB x: sem-pavg 8 x
   | PAVGW x: sem-pavg 16 x
   | PBLENDVB x: sem-pblendvb x
   | PBLENDW x: sem-pblendw x
   | PCLMULQDQ x: sem-pclmulqdq x
   | PCMPEQB x: sem-pcmpeq 8 x
   | PCMPEQD x: sem-pcmpeq 32 x
   | PCMPEQQ x: sem-pcmpeq 64 x
   | PCMPEQW x: sem-pcmpeq 16 x
   | PCMPESTRI x: sem-default-arity3 insn x
   | PCMPESTRM x: sem-default-arity3 insn x
   | PCMPGRD x: sem-default-arity2 insn x
   | PCMPGTB x: sem-pcmpgt 8 x
   | PCMPGTD x: sem-pcmpgt 32 x 
   | PCMPGTQ x: sem-pcmpgt 64 x
   | PCMPGTW x: sem-pcmpgt 16 x
   | PCMPISTRI x: sem-default-arity3 insn x
   | PCMPISTRM x: sem-default-arity3 insn x
   | PEXTRB x: sem-pextr-vpextr 8 x
   | PEXTRD x: sem-pextr-vpextr 32 x
   | PEXTRQ x: sem-pextr-vpextr 64 x
   | PEXTRW x: sem-pextr-vpextr 16 x
   | PHADDD x: sem-phadd 32 x
   | PHADDSW x: sem-phaddsw x
   | PHADDW x: sem-phadd 16 x
   | PHMINPOSUW x: sem-phminposuw-vphminposuw '0' x
   | PHSUBD x: sem-phsub 32 x
   | PHSUBSW x: sem-phsubsw x
   | PHSUBW x: sem-phsub 16 x
   | PINSRB x: sem-pinsr 8 x
   | PINSRD x: sem-pinsr 32 x
   | PINSRQ x: sem-pinsr 64 x
   | PINSRW x: sem-pinsr 16 x
   | PMADDUBSW x: sem-pmaddubsw x
   | PMADDWD x: sem-pmaddwd x
   | PMAXSB x: sem-pmaxs 8 x
   | PMAXSD x: sem-pmaxs 32 x
   | PMAXSW x: sem-pmaxs 16 x
   | PMAXUB x: sem-pmaxu 8 x
   | PMAXUD x: sem-pmaxu 32 x
   | PMAXUW x: sem-pmaxu 16 x
   | PMINSB x: sem-pmins 8 x
   | PMINSD x: sem-pmins 32 x
   | PMINSW x: sem-pmins 16 x
   | PMINUB x: sem-pminu 8 x
   | PMINUD x: sem-pminu 32 x
   | PMINUW x: sem-pminu 16 x
   | PMOVMSKB x: sem-pmovmskb-vpmovmskb '0' x
   | PMOVSXBD x: sem-pmovsx-vpmovsx '0' 8 32 x
   | PMOVSXBQ x: sem-pmovsx-vpmovsx '0' 8 64 x
   | PMOVSXBW x: sem-pmovsx-vpmovsx '0' 8 16 x
   | PMOVSXDQ x: sem-pmovsx-vpmovsx '0' 32 64 x
   | PMOVSXWD x: sem-pmovsx-vpmovsx '0' 16 32 x
   | PMOVSXWQ x: sem-pmovsx-vpmovsx '0' 16 64 x
   | PMOVZXBD x: sem-pmovzx-vpmovzx '0' 8 32 x
   | PMOVZXBQ x: sem-pmovzx-vpmovzx '0' 8 64 x
   | PMOVZXBW x: sem-pmovzx-vpmovzx '0' 8 16 x
   | PMOVZXDQ x: sem-pmovzx-vpmovzx '0' 32 64 x
   | PMOVZXWD x: sem-pmovzx-vpmovzx '0' 16 32 x
   | PMOVZXWQ x: sem-pmovzx-vpmovzx '0' 16 64 x
   | PMULDQ x: sem-pmuldq x
   | PMULHRSW x: sem-pmulhrsw x
   | PMULHUW x: sem-pmulhuw x
   | PMULHW x: sem-pmulhw x
   | PMULLD x: sem-pmull 32 x
   | PMULLW x: sem-pmull 16 x
   | PMULUDQ x: sem-pmuludq x
   | POP x: sem-pop x
   | POPA x: sem-popa-popad x
   | POPAD x: sem-popa-popad x
   | POPCNT x: sem-popcnt x
   | POPF x: sem-popf x
   | POPFD x: sem-popf x
   | POPFQ x: sem-popf x
   | POR x: sem-por x
   | PREFETCHNTA x: sem-default-arity1 insn x
   | PREFETCHT0 x: sem-default-arity1 insn x
   | PREFETCHT1 x: sem-default-arity1 insn x
   | PREFETCHT2 x: sem-default-arity1 insn x
   | PREFETCHW x: sem-default-arity1 insn x
   | PSADBW x: sem-psadbw x
   | PSHUFB x: sem-pshufb x
   | PSHUFD x: sem-pshufd-vpshufd '0' x
   | PSHUFHW x: sem-pshufhw-vpshufhw '0' x
   | PSHUFLW x: sem-pshuflw-vpshuflw '0' x
   | PSHUFW x: sem-pshufw x
   | PSIGNB x: sem-psign 8 x
   | PSIGND x: sem-psign 32 x
   | PSIGNW x: sem-psign 16 x
   | PSLLD x: sem-psll 32 x
   | PSLLDQ x: sem-pslldq x
   | PSLLQ x: sem-psll 64 x
   | PSLLW x: sem-psll 16 x
   | PSRAD x: sem-psra 32 x
   | PSRAW x: sem-psra 16 x
   | PSRLD x: sem-psrl 32 x
   | PSRLDQ x: sem-psrldq x
   | PSRLQ x: sem-psrl 64 x
   | PSRLW x: sem-psrl 16 x
   | PSUBB x: sem-psub 8 x
   | PSUBD x: sem-psub 32 x
   | PSUBQ x: sem-psub 64 x
   | PSUBSB x: sem-psubs 8 x
   | PSUBSW x: sem-psubs 16 x
   | PSUBUSB x: sem-psubus 8 x
   | PSUBUSW x: sem-psubus 16 x
   | PSUBW x: sem-psub 16 x
   | PTEST x: sem-ptest-vptest x
   | PUNPCKHBW x: sem-punpckh 8 x
   | PUNPCKHDQ x: sem-punpckh 32 x
   | PUNPCKHQDQ x: sem-punpckh 64 x
   | PUNPCKHWD x: sem-punpckh 16 x
   | PUNPCKLBW x: sem-punpckl 8 x
   | PUNPCKLDQ x: sem-punpckl 32 x
   | PUNPCKLQDQ x: sem-punpckl 64 x
   | PUNPCKLWD x: sem-punpckl 16 x
   | PUSH x: sem-push x
   | PUSHA x: sem-pusha-pushad x
   | PUSHAD x: sem-pusha-pushad x
   | PUSHF x: sem-pushf x
   | PUSHFD x: sem-pushf x
   | PUSHFQ x: sem-pushf x
   | PXOR x: sem-pxor x
   | RCL x: sem-rcl x
   | RCPPS x: sem-default-arity2 insn x
   | RCPSS x: sem-default-arity2 insn x
   | RCR x: sem-rcr x
   | RDFSBASE x: sem-default-arity1 insn x
   | RDGSBASE x: sem-default-arity1 insn x
   | RDMSR x: sem-default-arity0 insn x
   | RDPMC x: sem-default-arity0 insn x
   | RDRAND x: sem-default-arity1 insn x
   | RDTSC x: sem-default-arity0 insn x
   | RDTSCP x: sem-default-arity0 insn x
   | RET x: sem-ret x
   | RET_FAR x: sem-ret-far x
   | ROL x: sem-rol x
   | ROR x: sem-ror x
   | ROUNDPD x: sem-default-arity3 insn x
   | ROUNDPS x: sem-default-arity3 insn x
   | ROUNDSD x: sem-default-arity3 insn x
   | ROUNDSS x: sem-default-arity3 insn x
   | RSM x: sem-default-arity0 insn x
   | RSQRTPS x: sem-default-arity2 insn x
   | RSQRTSS x: sem-default-arity2 insn x
   | SAHF x: sem-sahf x
   | SAL x: sem-sal-shl x
   | SAR x: sem-shr-sar x '1'
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
   | SFENCE x: sem-default-arity0 insn x
   | SGDT x: sem-default-arity1 insn x
   | SHL x: sem-sal-shl x
   | SHLD x: sem-shld x
   | SHR x: sem-shr-sar x '0'
   | SHRD x: sem-shrd x
   | SHUFPD x: sem-default-arity3 insn x
   | SHUFPS x: sem-default-arity3 insn x
   | SIDT x: sem-default-arity1 insn x
   | SLDT x: sem-default-arity1 insn x
   | SMSW x: sem-default-arity1 insn x
   | SQRTPD x: sem-default-arity2 insn x
   | SQRTPS x: sem-default-arity2 insn x
   | SQRTSD x: sem-default-arity2 insn x
   | SQRTSS x: sem-default-arity2 insn x
   | STC x: sem-stc
   | STD x: sem-std
   | STI x: sem-default-arity0 insn x
   | STMXCSR x: sem-default-arity1 insn x
   | STOSB x: sem-stos 8 x
   | STOSD x: sem-stos 32 x
   | STOSQ x: sem-stos 64 x
   | STOSW x: sem-stos 16 x
   | STR x: sem-default-arity1 insn x
   | SUB x: sem-sub x
   | SUBPD x: sem-default-arity2 insn x
   | SUBPS x: sem-default-arity2 insn x
   | SUBSD x: sem-default-arity2 insn x
   | SUBSS x: sem-default-arity2 insn x
   | SWAPGS x: sem-default-arity0 insn x
   | SYSCALL x: sem-default-arity0 insn x
   | SYSENTER x: sem-default-arity0 insn x
   | SYSEXIT x: sem-default-arity0 insn x
   | SYSRET x: sem-default-arity0 insn x
   | TEST x: sem-test x
   | UCOMISD x: sem-default-arity2 insn x
   | UCOMISS x: sem-default-arity2 insn x
   | UD2 x: sem-default-arity0 insn x
   | UNPCKHPD x: sem-default-arity2 insn x
   | UNPCKHPS x: sem-default-arity2 insn x
   | UNPCKLPD x: sem-default-arity2 insn x
   | UNPCKLPS x: sem-default-arity2 insn x
   | VADDPD x: sem-default-varity insn x
   | VADDPS x: sem-default-varity insn x
   | VADDSD x: sem-default-varity insn x
   | VADDSS x: sem-default-varity insn x
   | VADDSUBPD x: sem-default-varity insn x
   | VADDSUBPS x: sem-default-varity insn x
   | VAESDEC v:
       case v of
          VA3 x: sem-vaesdec x
       end
   | VAESDECLAST x: sem-default-varity insn x
   | VAESENC x: sem-default-varity insn x
   | VAESENCLAST x: sem-default-varity insn x
   | VAESIMC x: sem-default-varity insn x
   | VAESKEYGENASSIST x: sem-default-varity insn x
   | VANDNPD v: sem-default-varity insn v
   | VANDNPS x: sem-default-varity insn x
   | VANDPD v:
       case v of
          VA3 x: sem-vandpd x
       end
   | VANDPS x: sem-default-varity insn x
   | VBLENDPD x: sem-default-varity insn x
   | VBLENDPS x: sem-default-varity insn x
   | VBLENDVPD x: sem-default-varity insn x
   | VBLENDVPS x: sem-default-varity insn x
   | VBROADCASTF128 v: sem-vbroadcast v
   | VBROADCASTSD v: sem-vbroadcast v
   | VBROADCASTSS v: sem-vbroadcast v
   | VCMPEQB x: sem-default-varity insn x
   | VCMPEQD x: sem-default-varity insn x
   | VCMPEQW x: sem-default-varity insn x
   | VCMPPD x: sem-default-varity insn x
   | VCMPPS x: sem-default-varity insn x
   | VCMPSD x: sem-default-varity insn x
   | VCMPSS x: sem-default-varity insn x
   | VCOMISD x: sem-default-varity insn x
   | VCOMISS x: sem-default-varity insn x
   | VCVTDQ2PD x: sem-default-varity insn x
   | VCVTDQ2PS x: sem-default-varity insn x
   | VCVTPD2DQ x: sem-default-varity insn x
   | VCVTPD2PS x: sem-default-varity insn x
   | VCVTPH2PS x: sem-default-varity insn x
   | VCVTPS2DQ x: sem-default-varity insn x
   | VCVTPS2PD x: sem-default-varity insn x
   | VCVTPS2PH x: sem-default-varity insn x
   | VCVTSD2SI x: sem-default-varity insn x
   | VCVTSD2SS x: sem-default-varity insn x
   | VCVTSI2SD x: sem-default-varity insn x
   | VCVTSI2SS x: sem-default-varity insn x
   | VCVTSS2SD x: sem-default-varity insn x
   | VCVTSS2SI x: sem-default-varity insn x
   | VCVTTPD2DQ x: sem-default-varity insn x
   | VCVTTPS2DQ x: sem-default-varity insn x
   | VCVTTSD2SI x: sem-default-varity insn x
   | VCVTTSS2SI x: sem-default-varity insn x
   | VDIVPD x: sem-default-varity insn x
   | VDIVPS x: sem-default-varity insn x
   | VDIVSD x: sem-default-varity insn x
   | VDIVSS x: sem-default-varity insn x
   | VDPPD x: sem-default-varity insn x
   | VDPPS x: sem-default-varity insn x
   | VERR x: sem-default-arity1 insn x
   | VERW x: sem-default-arity1 insn x
   | VEXTRACTF128 x: sem-default-varity insn x
   | VEXTRACTPS x: sem-default-varity insn x
   | VHADDPD x: sem-default-varity insn x
   | VHADDPS x: sem-default-varity insn x
   | VHSUBPD x: sem-default-varity insn x
   | VHSUBPS x: sem-default-varity insn x
   | VINSERTF128 x: sem-default-varity insn x
   | VINSERTPS x: sem-default-varity insn x
   | VLDDQU v:
       case v of
         VA2 x: sem-mov '1' x
       end
   | VLDMXCSR x: sem-default-varity insn x
   | VMASKMOVDQU v:
       case v of
          VA3 x: sem-maskmovdqu-vmaskmovdqu x
       end
   | VMASKMOVPD x: sem-vmaskmovp 64 x
   | VMASKMOVPS x: sem-vmaskmovp 32 x
   | VMAXPD x: sem-default-varity insn x
   | VMAXPS x: sem-default-varity insn x
   | VMAXSD x: sem-default-varity insn x
   | VMAXSS x: sem-default-varity insn x
   | VMINPD x: sem-default-varity insn x
   | VMINPS x: sem-default-varity insn x
   | VMINSD x: sem-default-varity insn x
   | VMINSS x: sem-default-varity insn x
   | VMOVAPD v:
       case v of
          VA2 x: sem-mov '1' x
       end
   | VMOVAPS v:
       case v of
          VA2 x: sem-mov '1' x
       end
   | VMOVD v:
       case v of
          VA2 x: sem-movzx '1' x
       end
   | VMOVDDUP x: sem-default-varity insn x
   | VMOVDQA v:
       case v of
          VA2 x: sem-mov '1' x
       end
   | VMOVDQU v:
       case v of
          VA2 x: sem-mov '1' x
       end
   | VMOVHLPS x: sem-default-varity insn x
   | VMOVHPD x: sem-default-varity insn x
   | VMOVHPS x: sem-default-varity insn x
   | VMOVLHPS x: sem-default-varity insn x
   | VMOVLPD x: sem-default-varity insn x
   | VMOVLPS x: sem-default-varity insn x
   | VMOVMSKPD x: sem-default-varity insn x
   | VMOVMSKPS x: sem-default-varity insn x
   | VMOVNTDQ v:
       case v of
          VA2 x: sem-mov '1' x
       end
   | VMOVNTDQA v:
       case v of
          VA2 x: sem-mov '1' x
       end
   | VMOVNTPD x: sem-default-varity insn x
   | VMOVNTPS x: sem-default-varity insn x
   | VMOVQ v:
       case v of
          VA2 x: sem-movzx '1' x
       end
   | VMOVSD x: sem-default-varity insn x
   | VMOVSHDUP x: sem-default-varity insn x
   | VMOVSLDUP x: sem-default-varity insn x
   | VMOVSS x: sem-default-varity insn x
   | VMOVUPD x: sem-default-varity insn x
   | VMOVUPS x: sem-default-varity insn x
   | VMPSADBW x: sem-default-varity insn x
   | VMULPD x: sem-default-varity insn x
   | VMULPS x: sem-default-varity insn x
   | VMULSD x: sem-default-varity insn x
   | VMULSS x: sem-default-varity insn x
   | VORPD x: sem-default-varity insn x
   | VORPS x: sem-default-varity insn x
   | VPABSB v:
       case v of
          VA2 x: sem-pabs '1' 8 x
       end
   | VPABSD v:
       case v of
          VA2 x: sem-pabs '1' 32 x
       end
   | VPABSW v:
       case v of
          VA2 x: sem-pabs '1' 16 x
       end
   | VPACKSSDW v:
       case v of
          VA3 x: sem-vpacksswb-vpackssdw 16 x
       end
   | VPACKSSWB v:
       case v of
          VA3 x: sem-vpacksswb-vpackssdw 8 x
       end
   | VPACKUSDW v:
       case v of
          VA3 x: sem-vpackuswb-vpackusdw 16 x
       end
   | VPACKUSWB v:
       case v of
          VA3 x: sem-vpackuswb-vpackusdw 8 x
       end
   | VPADDB v:
       case v of
          VA3 x: sem-vpadd 8 x
       end
   | VPADDD v:
       case v of
          VA3 x: sem-vpadd 32 x
       end
   | VPADDQ v:
       case v of
          VA3 x: sem-vpadd 64 x
       end
   | VPADDSB v:
       case v of
          VA3 x: sem-vpadds 8 x
       end
   | VPADDSW v:
       case v of
          VA3 x: sem-vpadds 16 x
       end
   | VPADDUSB v:
       case v of
          VA3 x: sem-vpaddus 8 x
       end
   | VPADDUSW v:
       case v of
          VA3 x: sem-vpaddus 16 x
       end
   | VPADDW v:
       case v of
          VA3 x: sem-vpadd 16 x
       end
   | VPALIGNR v:
       case v of
          VA4 x: sem-vpalignr x
       end
   | VPAND v:
       case v of
          VA3 x: sem-vpand x
       end
   | VPANDN v:
       case v of
          VA3 x: sem-vpandn x
       end
   | VPAVGB v:
       case v of
          VA3 x: sem-vpavg 8 x
       end
   | VPAVGW v:
       case v of
          VA3 x: sem-vpavg 16 x
       end
   | VPBLENDVB v:
       case v of
          VA4 x: sem-vpblendvb x
       end
   | VPBLENDW v:
       case v of
          VA4 x: sem-vpblendw x
       end
   | VPCLMULQDQ v:
       case v of
          VA4 x: sem-vpclmulqdq x
       end
   | VPCMPEQB v:
       case v of
          VA3 x: sem-vpcmpeq 8 x
       end
   | VPCMPEQD v:
       case v of
          VA3 x: sem-vpcmpeq 32 x
       end
   | VPCMPEQQ v:
       case v of
          VA3 x: sem-vpcmpeq 64 x
       end
   | VPCMPEQW v:
       case v of
          VA3 x: sem-vpcmpeq 16 x
       end
   | VPCMPESTRI x: sem-default-varity insn x
   | VPCMPESTRM x: sem-default-varity insn x
   | VPCMPGTB v:
       case v of
          VA3 x: sem-vpcmpgt 8 x
       end
   | VPCMPGTD v:
       case v of
          VA3 x: sem-vpcmpgt 32 x
       end
   | VPCMPGTQ v:
       case v of
          VA3 x: sem-vpcmpgt 64 x
       end
   | VPCMPGTW v:
       case v of
          VA3 x: sem-vpcmpgt 16 x
       end
   | VPCMPISTRI x: sem-default-varity insn x
   | VPCMPISTRM x: sem-default-varity insn x
   | VPERM2F128 x: sem-default-varity insn x
   | VPERMILPD x: sem-default-varity insn x
   | VPERMILPS x: sem-default-varity insn x
   | VPEXTRB v:
       case v of
          VA3 x: sem-pextr-vpextr 8 x
       end
   | VPEXTRD v:
       case v of
          VA3 x: sem-pextr-vpextr 32 x
       end
   | VPEXTRQ v:
       case v of
          VA3 x: sem-pextr-vpextr 64 x
       end
   | VPEXTRW v:
       case v of
          VA3 x: sem-pextr-vpextr 16 x
       end
   | VPHADDD v:
       case v of
          VA3 x: sem-vphadd 32 x
       end
   | VPHADDSW v:
       case v of
          VA3 x: sem-vphaddsw x
       end
   | VPHADDW v:
       case v of
          VA3 x: sem-vphadd 16 x
       end
   | VPHMINPOSUW v:
       case v of
          VA2 x: sem-phminposuw-vphminposuw '1' x
       end
   | VPHSUBD v:
       case v of
          VA3 x: sem-vphsub 32 x 
       end
   | VPHSUBSW v:
       case v of
          VA3 x: sem-vphsubsw x 
       end
   | VPHSUBW v:
       case v of
          VA3 x: sem-vphsub 16 x 
       end
   | VPINSRB v:
       case v of
          VA4 x: sem-vpinsr 8 x 
       end
   | VPINSRD v:
       case v of
          VA4 x: sem-vpinsr 32 x 
       end
   | VPINSRQ v:
       case v of
          VA4 x: sem-vpinsr 64 x 
       end
   | VPINSRW v:
       case v of
          VA4 x: sem-vpinsr 16 x 
       end
   | VPMADDUBSW v:
       case v of
          VA3 x: sem-vpmaddubsw x 
       end
   | VPMADDWD v:
       case v of
          VA3 x: sem-vpmaddwd x 
       end
   | VPMAXSB v:
       case v of
          VA3 x: sem-vpmaxs 8 x 
       end
   | VPMAXSD v:
       case v of
          VA3 x: sem-vpmaxs 32 x 
       end
   | VPMAXSW v:
       case v of
          VA3 x: sem-vpmaxs 16 x 
       end
   | VPMAXUB v:
       case v of
          VA3 x: sem-vpmaxu 8 x 
       end
   | VPMAXUD v:
       case v of
          VA3 x: sem-vpmaxu 32 x 
       end
   | VPMAXUW v:
       case v of
          VA3 x: sem-vpmaxu 16 x 
       end
   | VPMINSB v:
       case v of
          VA3 x: sem-vpmins 8 x 
       end
   | VPMINSD v:
       case v of
          VA3 x: sem-vpmins 32 x 
       end
   | VPMINSW v:
       case v of
          VA3 x: sem-vpmins 16 x 
       end
   | VPMINUB v:
       case v of
          VA3 x: sem-vpminu 8 x 
       end
   | VPMINUD v:
       case v of
          VA3 x: sem-vpminu 32 x 
       end
   | VPMINUW v:
       case v of
          VA3 x: sem-vpminu 16 x 
       end
   | VPMOVMSKB v:
       case v of
          VA2 x: sem-pmovmskb-vpmovmskb '1' x
       end
   | VPMOVSXBD v:
       case v of
          VA2 x: sem-pmovsx-vpmovsx '1' 8 32 x
       end
   | VPMOVSXBQ v:
       case v of
          VA2 x: sem-pmovsx-vpmovsx '1' 8 64 x
       end
   | VPMOVSXBW v:
       case v of
          VA2 x: sem-pmovsx-vpmovsx '1' 8 16 x
       end
   | VPMOVSXDQ v:
       case v of
          VA2 x: sem-pmovsx-vpmovsx '1' 32 64 x
       end
   | VPMOVSXWD v:
       case v of
          VA2 x: sem-pmovsx-vpmovsx '1' 16 32 x
       end
   | VPMOVSXWQ v:
       case v of
          VA2 x: sem-pmovsx-vpmovsx '1' 16 64 x
       end
   | VPMOVZXBD v:
       case v of
          VA2 x: sem-pmovzx-vpmovzx '1' 8 32 x
       end
   | VPMOVZXBQ v:
       case v of
          VA2 x: sem-pmovzx-vpmovzx '1' 8 64 x
       end
   | VPMOVZXBW v:
       case v of
          VA2 x: sem-pmovzx-vpmovzx '1' 8 16 x
       end
   | VPMOVZXDQ v:
       case v of
          VA2 x: sem-pmovzx-vpmovzx '1' 32 64 x
       end
   | VPMOVZXWD v:
       case v of
          VA2 x: sem-pmovzx-vpmovzx '1' 16 32 x
       end
   | VPMOVZXWQ v:
       case v of
          VA2 x: sem-pmovzx-vpmovzx '1' 16 64 x
       end
   | VPMULDQ v:
       case v of
          VA3 x: sem-vpmuldq x
       end
   | VPMULHRSW v:
       case v of
          VA3 x: sem-vpmulhrsw x
       end
   | VPMULHUW v:
       case v of
          VA3 x: sem-vpmulhuw x
       end
   | VPMULHW v:
       case v of
          VA3 x: sem-vpmulhw x
       end
   | VPMULLD v:
       case v of
          VA3 x: sem-vpmull 32 x
       end
   | VPMULLW v:
       case v of
          VA3 x: sem-vpmull 16 x
       end
   | VPMULUDQ v:
       case v of
          VA3 x: sem-vpmuludq x
       end
   | VPOR v:
       case v of
          VA3 x: sem-vpor x
       end
   | VPSADBW v:
       case v of
          VA3 x: sem-vpsadbw x
       end
   | VPSHUFB v:
       case v of
          VA3 x: sem-vpshufb x
       end
   | VPSHUFD v:
       case v of
          VA3 x: sem-pshufd-vpshufd '1' x
       end
   | VPSHUFHW v:
       case v of
          VA3 x: sem-pshufhw-vpshufhw '1' x
       end
   | VPSHUFLW v:
       case v of
          VA3 x: sem-pshuflw-vpshuflw '1' x
       end
   | VPSIGNB v:
       case v of
          VA3 x: sem-vpsign 8 x
       end
   | VPSIGND v:
       case v of
          VA3 x: sem-vpsign 32 x
       end
   | VPSIGNW v:
       case v of
          VA3 x: sem-vpsign 16 x
       end
   | VPSLLD v:
       case v of
          VA3 x: sem-vpsll 32 x
       end
   | VPSLLDQ v:
       case v of
          VA3 x: sem-vpslldq x
       end
   | VPSLLQ v:
       case v of
          VA3 x: sem-vpsll 64 x
       end
   | VPSLLW v:
       case v of
          VA3 x: sem-vpsll 16 x
       end
   | VPSRAD v:
       case v of
          VA3 x: sem-vpsra 32 x
       end
   | VPSRAW v:
       case v of
          VA3 x: sem-vpsra 16 x
       end
   | VPSRLD v:
       case v of
          VA3 x: sem-vpsrl 32 x
       end
   | VPSRLDQ v:
       case v of
          VA3 x: sem-vpsrldq x
       end
   | VPSRLQ v:
       case v of
          VA3 x: sem-vpsrl 64 x
       end
   | VPSRLW v:
       case v of
          VA3 x: sem-vpsrl 16 x
       end
   | VPSUBB v:
       case v of
          VA3 x: sem-vpsub 8 x
       end
   | VPSUBD v:
       case v of
          VA3 x: sem-vpsub 32 x
       end
   | VPSUBQ v:
       case v of
          VA3 x: sem-vpsub 64 x
       end
   | VPSUBSB v:
       case v of
          VA3 x: sem-vpsubs 8 x
       end
   | VPSUBSW v:
       case v of
          VA3 x: sem-vpsubs 16 x
       end
   | VPSUBUSB v:
       case v of
          VA3 x: sem-vpsubus 8 x
       end
   | VPSUBUSW v:
       case v of
          VA3 x: sem-vpsubus 16 x
       end
   | VPSUBW v:
       case v of
          VA3 x: sem-vpsub 16 x
       end
   | VPTEST v:
       case v of
          VA2 x: sem-ptest-vptest x
       end
   | VPUNPCKHBW v:
       case v of
          VA3 x: sem-vpunpckh 8 x
       end
   | VPUNPCKHDQ v:
       case v of
          VA3 x: sem-vpunpckh 32 x
       end
   | VPUNPCKHQDQ v:
       case v of
          VA3 x: sem-vpunpckh 64 x
       end
   | VPUNPCKHWD v:
       case v of
          VA3 x: sem-vpunpckh 16 x
       end
   | VPUNPCKLBW v:
       case v of
          VA3 x: sem-vpunpckl 8 x
       end
   | VPUNPCKLDQ v:
       case v of
          VA3 x: sem-vpunpckl 32 x
       end
   | VPUNPCKLQDQ v:
       case v of
          VA3 x: sem-vpunpckl 64 x
       end
   | VPUNPCKLWD v:
       case v of
          VA3 x: sem-vpunpckl 16 x
       end
   | VPXOR v:
       case v of
          VA3 x: sem-vpxor x
       end
   | VRCPPS x: sem-default-varity insn x
   | VRCPSS x: sem-default-varity insn x
   | VROUNDPD x: sem-default-varity insn x
   | VROUNDPS x: sem-default-varity insn x
   | VROUNDSD x: sem-default-varity insn x
   | VROUNDSS x: sem-default-varity insn x
   | VRSQRTPS x: sem-default-varity insn x
   | VRSQRTSS x: sem-default-varity insn x
   | VSHUFPD x: sem-default-varity insn x
   | VSHUFPS x: sem-default-varity insn x
   | VSQRTPD x: sem-default-varity insn x
   | VSQRTPS x: sem-default-varity insn x
   | VSQRTSD x: sem-default-varity insn x
   | VSQRTSS x: sem-default-varity insn x
   | VSTMXCSR x: sem-default-varity insn x
   | VSUBPD x: sem-default-varity insn x
   | VSUBPS x: sem-default-varity insn x
   | VSUBSD x: sem-default-varity insn x
   | VSUBSS x: sem-default-varity insn x
   | VTESTPD x: sem-default-varity insn x
   | VTESTPS x: sem-default-varity insn x
   | VUCOMISD x: sem-default-varity insn x
   | VUCOMISS x: sem-default-varity insn x
   | VUNPCKHPD x: sem-default-varity insn x
   | VUNPCKHPS x: sem-default-varity insn x
   | VUNPCKLPD x: sem-default-varity insn x
   | VUNPCKLPS x: sem-default-varity insn x
   | VXORPD x: sem-default-varity insn x
   | VXORPS x: sem-default-varity insn x
   | VZEROALL v: sem-vzeroall
   | VZEROUPPER v: sem-vzeroupper
   | WAIT x: sem-default-arity0 insn x
   | WBINVD x: sem-default-arity0 insn x
   | WRFSBASE x: sem-default-arity1 insn x
   | WRGSBASE x: sem-default-arity1 insn x
   | WRMSR x: sem-default-arity0 insn x
   | XADD x: sem-xadd x
   | XCHG x: sem-xchg x
   | XGETBV x: sem-default-arity0 insn x
   | XLATB x: sem-default-arity0 insn x
   | XOR x: sem-xor x
   | XORPD x: sem-default-arity2 insn x
   | XORPS x: sem-default-arity2 insn x
   | XRSTOR x: sem-default-arity1 insn x
   | XRSTOR64 x: sem-default-arity1 insn x
   | XSAVE x: sem-default-arity1 insn x
   | XSAVE64 x: sem-default-arity1 insn x
   | XSAVEOPT x: sem-default-arity1 insn x
   | XSAVEOPT64 x: sem-default-arity1 insn x
   | XSETBV x: sem-default-arity0 insn x
  end
#s/^ | \([^\s]*\) of \(arity\|flow\)\(.\)\s*/ | \1 x: sem-undef-\2\3 x/g
#s/^ | \([^\s]*\) of varity\s*/ | \1 x: sem-default-varity insn x/g
#s/^ | \(\S*\)\s*$/ | \1: sem-default-arity0 insn/g
#s/\(.*\)| \(\S*\):.*/\1| \2 x: sem-default-arity0 insn x/g

val translate insn =
   do update@{stack=SEM_NIL,tmp=0,lab=0,mode64='1'};
#case 0 of 1: return 0 end;
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

val transInstr config = do
   ic <- query $ins_count;
   update@{tmp=0,ins_count=ic+1};
   insn <- decode config;
   semantics insn
end

val transBlock config limit = do
   transInstr config;
   jmp <- query $foundJump;
   idx <- idxget;
   if jmp or (idx >= limit) then query $stack else transBlock config limit
end

val translateBlock config limit = do
   update @{ins_count=0};
   update@{stack=SEM_NIL,foundJump='0'};
   # the type checker is does not instanitate types of decoders; what seemed to be
   # a fine specialization turns out to be a bad idea since records need to be
   # newly instantiated
   update @{ptrsz=0, reg/opcode='000', rm='000', mod='00', vexm='00001', vexv='0000', vexl='0', vexw='0'};
	 stmts <- transBlock config limit;
   return (rreil-stmts-rev stmts)
end

val translateSingle config = do
   update @{ins_count=0,mode64='1'};
   update@{stack=SEM_NIL,foundJump='0'};
   # the type checker is seriously broken when it comes to infinite recursion,
   # I cannot as of yet reproduce this bug
   update @{ptrsz=0, reg/opcode='000', rm='000', mod='00', vexm='00001', vexv='0000', vexl='0', vexw='0'};

   transInstr config;
   jmp <- query $foundJump;
   stmts <- query $stack;

   return (rreil-stmts-rev stmts)
end

val io a b = {a=a,b=b}
val io-to a = {a=a,b=IO_NONE}
val io-tw a = {a=a,b=a}

val relative-next stmts = let
  val raddress addr =
	  case addr.address of
		   SEM_LIN_ADD s:
			   case s.opnd1 of
				    SEM_LIN_VAR v:
						  case v.id of
							   Sem_IP:
								   case s.opnd2 of
									    SEM_LIN_IMM i: IO_SOME i.const
									  | _: IO_NONE
									 end
							 | _: IO_NONE
							end
				  | SEM_LIN_IMM i:
					    case s.opnd2 of
							   SEM_LIN_VAR v:
								   case v.id of
									    Sem_IP: IO_SOME i.const
									  | _: IO_NONE
									 end
							 | _: IO_NONE
							end
				 end
		 | SEM_LIN_VAR v:
		     case v.id of
				    Sem_IP: IO_SOME 0
				  | _: IO_NONE
				 end
		 | _: IO_NONE
		end
in
  case stmts of
	   SEM_CONS x:
		   case x.hd of
			    SEM_CBRANCH b: io (raddress b.target-true) (raddress b.target-false)
				| SEM_BRANCH b: io-to (raddress b.target)
				| SEM_ITE c: io (relative-next (rreil-stmts-rev c.then_branch)).a (relative-next (rreil-stmts-rev c.else_branch)).a
			  | _: io-tw IO_NONE
			 end
	 | SEM_NIL: (io-tw IO_NONE)
	end
end

type stmts_option =
   SO_SOME of sem_stmts
 | SO_NONE

type translate-result = {insns:int, succ_a:int, succ_b:int}

val translateSuperBlock config limit = let
  val translate-block-at idx = do
	  current <- idxget;
		#error <- rseek idx;
		error <- seek (current + idx);
		result <- if error === 0 then do
		  stmts <- translateBlock config int-max;
		  seek current;
			return (SO_SOME stmts)
		end else
		  return SO_NONE
		;
		return result
  end

  val seek-translate-block-at idx-opt = do
	  case idx-opt of
		   IO_SOME i: translate-block-at i
		 | IO_NONE: return SO_NONE
		end
	end
in do
   update @{ins_count=0,mode64='1'};
   update@{stack=SEM_NIL,foundJump='0'};
   # the type checker is seriously broken when it comes to infinite recursion,
   # I cannot as of yet reproduce this bug
   update @{ptrsz=0, reg/opcode='000', rm='000', mod='00', vexm='00001', vexv='0000', vexl='0', vexw='0'};
	 stmts <- transBlock config limit;

   ic <- query $ins_count;

   succs <- return (relative-next stmts);
   succ_a <- seek-translate-block-at succs.a;
   succ_b <- seek-translate-block-at succs.b;

   update@{ins_count=ic};

   return {insns=(rreil-stmts-rev stmts), succ_a=succ_a, succ_b=succ_b}
end end

val succ_pretty succ name =
  case succ of
	   SO_SOME i: "Succ " +++ (from-string-lit name) +++ ":\n" +++ (rreil-pretty i)
	 | SO_NONE: "Succ " +++ (from-string-lit name) +++ ": NONE :-("
	end
