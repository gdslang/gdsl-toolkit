# vim: filetype=sml:ts=3:sw=3:expandtab
export translate: (insndata) -> S sem_stmt_list <{} => {}>

type sem_writeback =
   SEM_WRITE_VAR of {size:int, id:sem_var}
 | SEM_WRITE_MEM of {size:int, address:sem_linear, segment:seg_override}

#Todo: fix
val runtime-stack-address-size = do
  mode64 <- query mode64?;
  if mode64 then
    return 64
  else
    return 32
end

val ip-get = do
  return (semantic-register-of RIP)
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

val rflags = do
  flags <- return {id=Sem_FLAGS,offset=0,size=64};

  #Set missing bits according to manual
  mov 1 (at-offset flags 1) (imm 1);
  mov 1 (at-offset flags 3) (imm 0);
  mov 1 (at-offset flags 5) (imm 0);

  return flags
end

#IA-32e => 64 bit real addresses
val real-addr-sz = return 64

val segmented-lin lin sz segment = do
  real-addr-sz <- real-addr-sz;
  mode64 <- query mode64?;

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
       | X86_SUM x: conv-sum conv sz x
       | X86_SCALE x: conv-scale conv sz x
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
  mode64 <- query mode64?;
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
   segmented-store sz x b x.segment
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
val sem-nae sem-cc x = sem-b sem-cc x

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

val sem-default-arity0-generic avx-encoded insn = prim-generic (show/mnemonic insn) varls-none varls-none
val sem-default-arity0 insn = sem-default-arity0-generic '0' insn

val sem-default-arity1-ro-generic avx-encoded insn x = do
  src1-sz <- sizeof1 x.opnd1;

  src1 <- rval src1-sz x.opnd1;

  src1-up <- unpack-lin src1-sz src1;

  prim-generic (show/mnemonic insn) varls-none (varls-one (varl src1-sz src1-up))
end
val sem-default-arity1-ro insn x = sem-default-arity1-ro-generic '0' insn x

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

val sem-default-arity2-ro-generic avx-encoded insn x = do
  src1-sz <- sizeof1 x.opnd1;
  src2-sz <- sizeof1 x.opnd2;

  src1 <- rval src1-sz x.opnd1;
  src2 <- rval src2-sz x.opnd2;

  src1-up <- unpack-lin src1-sz src1;
  src2-up <- unpack-lin src2-sz src2;

  prim-generic (show/mnemonic insn) varls-none (varls-more (varl src1-sz src1-up) (varls-one (varl src2-sz src2-up)))
end
val sem-default-arity2-ro insn x = sem-default-arity2-ro-generic '0' insn x

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

val sem-default-varity va insn = do
  case va of
     VA0: sem-default-arity0-generic '1' insn
   | VA1 v: sem-default-arity1-generic '1' insn v
   | VA2 v: sem-default-arity2-generic '1' insn v
   | VA3 v: sem-default-arity3-generic '1' insn v
   | VA4 v: sem-default-arity4-generic '1' insn v
  end
end

val sem-undef-flow1 x = do
  return void
end

val emit-parity-flag r = do
  pf <- fPF;
  low-byte <- mktemp;
  xorb 4 low-byte (var r) (var (at-offset r 4));
  xorb 2 low-byte (var low-byte) (var (at-offset low-byte 2));
  xorb 1 pf (var low-byte) (var (at-offset low-byte 1))
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
    sf <- fSF;
    ov <- fOF;
    zf <- fZF;
    cf <- fCF;
    af <- fAF;
    t1 <- mktemp;
    t2 <- mktemp;
    t3 <- mktemp;
  
    xorb sz t1 (var sum) s0;
    xorb sz t2 (var sum) s1;
    andb sz t3 (var t1) (var t2);
    cmplts sz ov (var t3) (imm 0);
    cmplts sz sf (var sum) (imm 0);
    cmpeq sz zf (var sum) (imm 0);
  
    # Hacker's Delight - Unsigned Add/Subtract
    if set-carry then (
      _if (/d carry) _then do
        cmpleu 4 af (var sum) s0;
        cmpleu sz cf (var sum) s0
      end _else do
        cmpltu 4 af (var sum) s0;
        cmpltu sz cf (var sum) s0
      end
    ) else (
      _if (/d carry) _then do
        cmpleu 4 af (var sum) s0
      end _else do
        cmpltu 4 af (var sum) s0
      end
    );

    emit-parity-flag sum;
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
    af <- fAF;
    z <- fZF;
    t1 <- mktemp;
    t2 <- mktemp;
    t3 <- mktemp;

    cmplts sz sf (var difference) (imm 0);

    # Hacker's Delight - Unsigned Add/Subtract
    _if (/d carry) _then do
      add sz t1 subtrahend (imm 1);
      cmpeq sz z minuend (var t1);

      cmples sz ov minuend subtrahend;
      xorb 1 ov (var ov) (var sf);

      if set-carry then
        cmpleu sz cf minuend subtrahend
      else
        return void
      ;
      cmpleu 4 af minuend subtrahend;
      emit-virt-flags
    end _else do
      cmpeq sz z minuend subtrahend;

      if set-carry then do
        cmpltu sz cf minuend subtrahend;
        leu <- fLEU;
        cmpleu sz leu minuend subtrahend
      end else
        emit-virt-leu
      ;
      les <- fLES;
      lts <- fLTS;
      cmplts sz lts minuend subtrahend;
      xorb 1 ov (var lts) (var sf);
      cmples sz les minuend subtrahend;
      cmpltu 4 af minuend subtrahend
    end;
  
    emit-parity-flag difference
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

val emit-virt-leu = do
  leu <- fLEU;

  cf <- fCF;
  zf <- fZF;

  #LEU := C | Z
  orb 1 leu (var cf) (var zf)
end

val emit-virt-flags = do
  lts <- fLTS;
  les <- fLES;

  zf <- fZF;
  sf <- fSF;
  ov <- fOF;

  emit-virt-leu;

  #LTS := S != O
  cmpneq 1 lts (var sf) (var ov);

  #LES := S != O | Z
  orb 1 les (var lts) (var zf)
end

val move-to-rflags size lin = let
  val emit = do
    flags <- rflags;
  
    mask <- return 0x0000000000240cd5;

    tud <- mktemp;
    undef size tud;
    andb size tud (var tud) (imm (0xffffffffffffffff - mask));
  
    undef size flags;
    xorb size flags (var tud) lin
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

val semantics insn = let
  val comb x = @{features=insn.features,opnd-sz=insn.opnd-sz,addr-sz=insn.addr-sz,rep=insn.rep,repne=insn.repne,lock=insn.lock} x
in
  case insn.insn of
     AAA: sem-default-arity0 insn.insn
   | AAD x: sem-default-arity1 insn.insn (comb x)
   | AAM x: sem-default-arity1 insn.insn (comb x)
   | AAS: sem-default-arity0 insn.insn
   | ADC x: sem-adc (comb x)
   | ADD x: sem-add (comb x)
   | ADDPD x: sem-default-arity2 insn.insn (comb x)
   | ADDPS x: sem-default-arity2 insn.insn (comb x)
   | ADDSD x: sem-default-arity2 insn.insn (comb x)
   | ADDSS x: sem-default-arity2 insn.insn (comb x)
   | ADDSUBPD x: sem-default-arity2 insn.insn (comb x)
   | ADDSUBPS x: sem-default-arity2 insn.insn (comb x)
   | AESDEC x: sem-aesdec (comb x)
   | AESDECLAST x: sem-default-arity2 insn.insn (comb x)
   | AESENC x: sem-default-arity2 insn.insn (comb x)
   | AESENCLAST x: sem-default-arity2 insn.insn (comb x)
   | AESIMC x: sem-default-arity2 insn.insn (comb x)
   | AESKEYGENASSIST x: sem-default-arity3 insn.insn (comb x)
   | AND x: sem-and (comb x)
   | ANDNPD x: sem-default-arity2 insn.insn (comb x)
   | ANDNPS x: sem-default-arity2 insn.insn (comb x)
   | ANDPD x: sem-andpd (comb x)
   | ANDPS x: sem-default-arity2 insn.insn (comb x)
   | ARPL x: sem-default-arity2 insn.insn (comb x)
   | BLENDPD x: sem-default-arity3 insn.insn (comb x)
   | BLENDPS x: sem-default-arity3 insn.insn (comb x)
   | BLENDVPD x: sem-default-arity3 insn.insn (comb x)
   | BLENDVPS x: sem-default-arity3 insn.insn (comb x)
   | BOUND x: sem-default-arity2 insn.insn (comb x)
   | BSF x: sem-bsf (comb x)
   | BSR x: sem-bsr (comb x)
   | BSWAP x: sem-bswap (comb x)
   | BT x: sem-bt (comb x) sem-bt-none
   | BTC x: sem-bt (comb x) sem-bt-complement
   | BTR x: sem-bt (comb x) sem-bt-reset
   | BTS x: sem-bt (comb x) sem-bt-set
   | CALL x: sem-call (comb x)
   | CBW: sem-convert 8
   | CDQ: sem-cwd-cdq-cqo (comb {})
   | CDQE: sem-convert 32
   | CLC: sem-default-arity0 insn.insn
   | CLD: sem-default-arity0 insn.insn
   | CLFLUSH x: sem-default-arity1 insn.insn (comb x)
   | CLI: sem-default-arity0 insn.insn
   | CLTS: sem-default-arity0 insn.insn
   | CMC: sem-cmc
   | CMOVA x: sem-a sem-cmovcc (comb x)
   | CMOVAE x: sem-ae sem-cmovcc (comb x)
   | CMOVB x: sem-b sem-cmovcc (comb x)
   | CMOVBE x: sem-be sem-cmovcc (comb x)
   | CMOVC x: sem-c sem-cmovcc (comb x)
   | CMOVE x: sem-e sem-cmovcc (comb x)
   | CMOVG x: sem-g sem-cmovcc (comb x)
   | CMOVGE x: sem-ge sem-cmovcc (comb x)
   | CMOVL x: sem-l sem-cmovcc (comb x)
   | CMOVLE x: sem-le sem-cmovcc (comb x)
   | CMOVNA x: sem-na sem-cmovcc (comb x)
   | CMOVNAE x: sem-nae sem-cmovcc (comb x)
   | CMOVNB x: sem-nb sem-cmovcc (comb x)
   | CMOVNBE x: sem-nbe sem-cmovcc (comb x)
   | CMOVNC x: sem-nc sem-cmovcc (comb x)
   | CMOVNE x: sem-ne sem-cmovcc (comb x)
   | CMOVNG x: sem-ng sem-cmovcc (comb x)
   | CMOVNGE x: sem-nge sem-cmovcc (comb x)
   | CMOVNL x: sem-nl sem-cmovcc (comb x)
   | CMOVNLE x: sem-nle sem-cmovcc (comb x)
   | CMOVNO x: sem-no sem-cmovcc (comb x)
   | CMOVNP x: sem-np sem-cmovcc (comb x)
   | CMOVNS x: sem-ns sem-cmovcc (comb x)
   | CMOVNZ x: sem-nz sem-cmovcc (comb x)
   | CMOVO x: sem-o sem-cmovcc (comb x)
   | CMOVP x: sem-p sem-cmovcc (comb x)
   | CMOVPE x: sem-pe sem-cmovcc (comb x)
   | CMOVPO x: sem-po sem-cmovcc (comb x)
   | CMOVS x: sem-s sem-cmovcc (comb x)
   | CMOVZ x: sem-z sem-cmovcc (comb x)
   | CMP x: sem-cmp (comb x)
   | CMPPD x: sem-default-arity3 insn.insn (comb x)
   | CMPPS x: sem-default-arity3 insn.insn (comb x) 
   | CMPS x: sem-repe-repne-insn (comb x) sem-cmps
   | CMPSD x: sem-default-arity3 insn.insn (comb x)
#   | CMPSD x:
#       case x of
#         VA0: sem-cmpsd
#       | _ x: sem-default-arity0 insn.insn (comb x)
#      end
#   | CMPSQ x: sem-default-arity0 insn.insn (comb x)
   | CMPSS x: sem-default-arity3 insn.insn (comb x)
   | CMPXCHG x: sem-cmpxchg (comb x)
   | CMPXCHG16B x: sem-cmpxchg16b-cmpxchg8b (comb x)
   | CMPXCHG8B x: sem-cmpxchg16b-cmpxchg8b (comb x)
   | COMISD x: sem-default-arity2 insn.insn (comb x)
   | COMISS x: sem-default-arity2 insn.insn (comb x)
   | CPUID: sem-cpuid (comb {})
   | CQO: sem-cwd-cdq-cqo (comb {})
   | CRC32 x: sem-default-arity2 insn.insn (comb x)
   | CVTDQ2PD x: sem-default-arity2 insn.insn (comb x)
   | CVTDQ2PS x: sem-default-arity2 insn.insn (comb x)
   | CVTPD2DQ x: sem-default-arity2 insn.insn (comb x)
   | CVTPD2PI x: sem-default-arity2 insn.insn (comb x)
   | CVTPD2PS x: sem-default-arity2 insn.insn (comb x)
   | CVTPI2PD x: sem-default-arity2 insn.insn (comb x)
   | CVTPI2PS x: sem-default-arity2 insn.insn (comb x)
   | CVTPS2DQ x: sem-default-arity2 insn.insn (comb x)
   | CVTPS2PD x: sem-default-arity2 insn.insn (comb x)
   | CVTPS2PI x: sem-default-arity2 insn.insn (comb x)
   | CVTSD2SI x: sem-default-arity2 insn.insn (comb x)
   | CVTSD2SS x: sem-default-arity2 insn.insn (comb x)
   | CVTSI2SD x: sem-default-arity2 insn.insn (comb x)
   | CVTSI2SS x: sem-default-arity2 insn.insn (comb x)
   | CVTSS2SD x: sem-default-arity2 insn.insn (comb x)
   | CVTSS2SI x: sem-default-arity2 insn.insn (comb x)
   | CVTTPD2DQ x: sem-default-arity2 insn.insn (comb x)
   | CVTTPD2PI x: sem-default-arity2 insn.insn (comb x)
   | CVTTPS2DQ x: sem-default-arity2 insn.insn (comb x)
   | CVTTPS2PI x: sem-default-arity2 insn.insn (comb x)
   | CVTTSD2SI x: sem-default-arity2 insn.insn (comb x)
   | CVTTSS2SI x: sem-default-arity2 insn.insn (comb x)
   | CWD: sem-cwd-cdq-cqo (comb {})
   | CWDE: sem-convert 16
   | DAA: sem-default-arity0 insn.insn
   | DAS: sem-default-arity0 insn.insn
   | DEC x: sem-dec (comb x)
   | DIV x: sem-div Unsigned (comb x)
   | DIVPD x: sem-default-arity2 insn.insn (comb x)
   | DIVPS x: sem-default-arity2 insn.insn (comb x)
   | DIVSD x: sem-default-arity2 insn.insn (comb x)
   | DIVSS x: sem-default-arity2 insn.insn (comb x)
   | DPPD x: sem-default-arity3 insn.insn (comb x)
   | DPPS x: sem-default-arity3 insn.insn (comb x)
   | EMMS: sem-default-arity0 insn.insn
   | ENTER x: sem-default-arity2-ro insn.insn (comb x)
   | EXTRACTPS x: sem-default-arity3 insn.insn (comb x)
   | F2XM1: sem-default-arity0 insn.insn
   | FABS: sem-default-arity0 insn.insn
   | FADD x: sem-fadd (comb x)
   | FADDP x: sem-default-arity2 insn.insn (comb x)
   | FBLD x: sem-default-arity1 insn.insn (comb x)
   | FBSTP x: sem-default-arity1 insn.insn (comb x)
   | FCHS: sem-default-arity0 insn.insn
   | FCLEX: sem-default-arity0 insn.insn
   | FCMOVB x: sem-default-arity2 insn.insn (comb x)
   | FCMOVBE x: sem-default-arity2 insn.insn (comb x)
   | FCMOVE x: sem-default-arity2 insn.insn (comb x)
   | FCMOVNB x: sem-default-arity2 insn.insn (comb x)
   | FCMOVNBE x: sem-default-arity2 insn.insn (comb x)
   | FCMOVNE x: sem-default-arity2 insn.insn (comb x)
   | FCMOVNU x: sem-default-arity2 insn.insn (comb x)
   | FCMOVU x: sem-default-arity2 insn.insn (comb x)
   | FCOM x: sem-default-arity1 insn.insn (comb x)
   | FCOMI x: sem-default-arity2 insn.insn (comb x)
   | FCOMIP x: sem-default-arity2 insn.insn (comb x)
   | FCOMP x: sem-default-arity1 insn.insn (comb x)
   | FCOMPP: sem-default-arity0 insn.insn
   | FCOS: sem-default-arity0 insn.insn
   | FDECSTP: sem-default-arity0 insn.insn
   | FDIV x: sem-default-arity2 insn.insn (comb x)
   | FDIVP x: sem-default-arity2 insn.insn (comb x)
   | FDIVR x: sem-default-arity2 insn.insn (comb x)
   | FDIVRP x: sem-default-arity2 insn.insn (comb x)
   | FFREE x: sem-default-arity1 insn.insn (comb x)
   | FIADD x: sem-default-arity1 insn.insn (comb x)
   | FICOM x: sem-default-arity1 insn.insn (comb x)
   | FICOMP x: sem-default-arity1 insn.insn (comb x)
   | FIDIV x: sem-default-arity2 insn.insn (comb x)
   | FIDIVR x: sem-default-arity1 insn.insn (comb x)
   | FILD x: sem-default-arity1 insn.insn (comb x)
   | FIMUL x: sem-default-arity1 insn.insn (comb x)
   | FINCSTP: sem-default-arity0 insn.insn
   | FINIT: sem-default-arity0 insn.insn
   | FIST x: sem-default-arity1 insn.insn (comb x)
   | FISTP x: sem-default-arity1 insn.insn (comb x)
   | FISTTP x: sem-default-arity1 insn.insn (comb x)
   | FISUB x: sem-default-arity1 insn.insn (comb x)
   | FISUBR x: sem-default-arity1 insn.insn (comb x)
   | FLD x: sem-default-arity1 insn.insn (comb x)
   | FLD1: sem-default-arity0 insn.insn
   | FLDCW x: sem-default-arity1 insn.insn (comb x)
   | FLDENV x: sem-default-arity1 insn.insn (comb x)
   | FLDL2E: sem-default-arity0 insn.insn
   | FLDL2T: sem-default-arity0 insn.insn
   | FLDLG2: sem-default-arity0 insn.insn
   | FLDLN2: sem-default-arity0 insn.insn
   | FLDPI: sem-default-arity0 insn.insn
   | FLDZ: sem-default-arity0 insn.insn
   | FMUL x: sem-default-arity2 insn.insn (comb x)
   | FMULP x: sem-default-arity2 insn.insn (comb x)
   | FNCLEX: sem-default-arity0 insn.insn
   | FNINIT: sem-default-arity0 insn.insn
   | FNOP: sem-default-arity0 insn.insn
   | FNSAVE x: sem-default-arity1 insn.insn (comb x)
   | FNSTCW x: sem-default-arity1 insn.insn (comb x)
   | FNSTENV x: sem-default-arity1 insn.insn (comb x)
   | FNSTSW x: sem-default-arity1 insn.insn (comb x)
   | FPATAN: sem-default-arity0 insn.insn
   | FPREM1: sem-default-arity0 insn.insn
   | FPREM: sem-default-arity0 insn.insn
   | FPTAN: sem-default-arity0 insn.insn
   | FRNDINT: sem-default-arity0 insn.insn
   | FRSTOR x: sem-default-arity1 insn.insn (comb x)
   | FSAVE x: sem-default-arity1 insn.insn (comb x)
   | FSCALE: sem-default-arity0 insn.insn
   | FSIN: sem-default-arity0 insn.insn
   | FSINCOS: sem-default-arity0 insn.insn
   | FSQRT: sem-default-arity0 insn.insn
   | FST x: sem-default-arity1 insn.insn (comb x)
   | FSTCW x: sem-default-arity1 insn.insn (comb x)
   | FSTENV x: sem-default-arity1 insn.insn (comb x)
   | FSTP x: sem-default-arity1 insn.insn (comb x)
   | FSTSW x: sem-default-arity1 insn.insn (comb x)
   | FSUB x: sem-default-arity2 insn.insn (comb x)
   | FSUBP x: sem-default-arity2 insn.insn (comb x)
   | FSUBR x: sem-default-arity2 insn.insn (comb x)
   | FSUBRP x: sem-default-arity2 insn.insn (comb x)
   | FTST: sem-default-arity0 insn.insn
   | FUCOM x: sem-default-arity1 insn.insn (comb x)
   | FUCOMI x: sem-default-arity1 insn.insn (comb x)
   | FUCOMIP x: sem-default-arity1 insn.insn (comb x)
   | FUCOMP x: sem-default-arity1 insn.insn (comb x)
   | FUCOMPP: sem-default-arity0 insn.insn
   | FXAM: sem-default-arity0 insn.insn
   | FXCH x: sem-default-arity1 insn.insn (comb x)
   | FXRSTOR x: sem-default-arity1 insn.insn (comb x)
   | FXRSTOR64 x: sem-default-arity1 insn.insn (comb x)
   | FXSAVE x: sem-default-arity1 insn.insn (comb x)
   | FXSAVE64 x: sem-default-arity1 insn.insn (comb x)
   | FXTRACT: sem-default-arity0 insn.insn
   | FYL2X: sem-default-arity0 insn.insn
   | FYL2XP1: sem-default-arity0 insn.insn
   | HADDPD x: sem-default-arity2 insn.insn (comb x)
   | HADDPS x: sem-default-arity2 insn.insn (comb x)
   | HLT: sem-default-arity0 insn.insn
   | HSUBPD x: sem-default-arity2 insn.insn (comb x)
   | HSUBPS x: sem-default-arity2 insn.insn (comb x)
   | IDIV x: sem-idiv (comb x)
   | IMUL v:
       case v of
          VA1 x: sem-imul-1 (comb x)
        | VA2 x: sem-imul-2 (comb x)
        | VA3 x: sem-imul-3 (comb x)
       end
   | IN x: sem-default-arity2 insn.insn (comb x)
   | INC x: sem-inc (comb x)
   | INSB: sem-default-arity0 insn.insn
   | INSD: sem-default-arity0 insn.insn
   | INSERTPS x: sem-default-arity3 insn.insn (comb x)
   | INSW: sem-default-arity0 insn.insn
   | INT x: sem-default-arity1-ro insn.insn (comb x)
   | INT0: sem-default-arity0 insn.insn
   | INT3: sem-default-arity0 insn.insn
   | INVD: sem-invd
   | INVLPG x: sem-default-arity1 insn.insn (comb x)
   | INVPCID x: sem-default-arity2 insn.insn (comb x)
   | IRET: sem-default-arity0 insn.insn
   | IRETD: sem-default-arity0 insn.insn
   | IRETQ: sem-default-arity0 insn.insn
   | JA x: sem-a sem-jcc (comb x)
   | JAE x: sem-ae sem-jcc (comb x)
   | JB x: sem-b sem-jcc (comb x)
   | JBE x: sem-be sem-jcc (comb x)
   | JC x: sem-c sem-jcc (comb x)
   | JCXZ x: sem-jcxz (comb x)
   | JE x: sem-e sem-jcc (comb x)
   | JECXZ x: sem-jecxz (comb x)
   | JG x: sem-g sem-jcc (comb x)
   | JGE x: sem-ge sem-jcc (comb x)
   | JL x: sem-l sem-jcc (comb x)
   | JLE x: sem-le sem-jcc (comb x)
   | JMP x: sem-jmp (comb x)
   | JNA x: sem-na sem-jcc (comb x)
   | JNAE x: sem-nae sem-jcc (comb x)
   | JNB x: sem-nb sem-jcc (comb x)
   | JNBE x: sem-nbe sem-jcc (comb x)
   | JNC x: sem-nc sem-jcc (comb x)
   | JNE x: sem-ne sem-jcc (comb x)
   | JNG x: sem-ng sem-jcc (comb x)
   | JNGE x: sem-nge sem-jcc (comb x)
   | JNL x: sem-nl sem-jcc (comb x)
   | JNLE x: sem-nle sem-jcc (comb x)
   | JNO x: sem-no sem-jcc (comb x)
   | JNP x: sem-np sem-jcc (comb x)
   | JNS x: sem-ns sem-jcc (comb x)
   | JNZ x: sem-nz sem-jcc (comb x)
   | JO x: sem-o sem-jcc (comb x)
   | JP x: sem-p sem-jcc (comb x)
   | JPE x: sem-pe sem-jcc (comb x)
   | JPO x: sem-po sem-jcc (comb x)
   | JRCXZ x: sem-jrcxz (comb x)
   | JS x: sem-s sem-jcc (comb x)
   | JZ x: sem-z sem-jcc (comb x)
   | LAHF: sem-lahf
   | LAR x: sem-lar insn.insn (comb x)
   | LDDQU x: sem-mov '0' (comb x)
   | LDMXCSR x: sem-default-arity1 insn.insn (comb x)
   | LDS x: sem-lds-les-lfs-lgs-lss (comb x) DS
   | LEA x: sem-lea (comb x)
   | LEAVE: sem-leave insn
   | LES x: sem-lds-les-lfs-lgs-lss (comb x) ES
   | LFENCE: sem-default-arity0 insn.insn
   | LFS x: sem-lds-les-lfs-lgs-lss (comb x) FS
   | LGDT x: sem-default-arity1 insn.insn (comb x)
   | LGS x: sem-lds-les-lfs-lgs-lss (comb x) GS
   | LIDT x: sem-default-arity1 insn.insn (comb x)
   | LLDT x: sem-default-arity1 insn.insn (comb x)
   | LMSW x: sem-default-arity1 insn.insn (comb x)
   | LODS x: sem-rep-insn (comb x) sem-lods
   | LOOP x: sem-loop (comb x)
   | LOOPE x: sem-loope (comb x)
   | LOOPNE x: sem-loopne (comb x)
   | LSL x: sem-default-arity2 insn.insn (comb x)
   | LSS x: sem-lds-les-lfs-lgs-lss (comb x) SS
   | LTR x: sem-default-arity1 insn.insn (comb x)
   | MASKMOVDQU x: sem-maskmovdqu-vmaskmovdqu (comb x)
   | MASKMOVQ x: sem-maskmovq (comb x)
   | MAXPD x: sem-default-arity2 insn.insn (comb x)
   | MAXPS x: sem-default-arity2 insn.insn (comb x)
   | MAXSD x: sem-default-arity2 insn.insn (comb x)
   | MAXSS x: sem-default-arity2 insn.insn (comb x)
   | MFENCE: sem-default-arity0 insn.insn
   | MINPD x: sem-default-arity2 insn.insn (comb x)
   | MINPS x: sem-default-arity2 insn.insn (comb x)
   | MINSD x: sem-default-arity2 insn.insn (comb x)
   | MINSS x: sem-default-arity2 insn.insn (comb x)
   | MONITOR: sem-default-arity0 insn.insn
   | MOV x: sem-mov '0' (comb x)
   | MOVAPD x: sem-mov '0' (comb x)
   | MOVAPS x: sem-mov '0' (comb x)
   | MOVBE x: sem-movbe (comb x)
   | MOVD x: sem-movzx '0' (comb x)
   | MOVDDUP x: sem-default-arity2 insn.insn (comb x)
   | MOVDQ2Q x: sem-mov '0' (comb x)
   | MOVDQA x: sem-mov '0' (comb x)
   | MOVDQU x: sem-mov '0' (comb x)
   | MOVHLPS x: sem-default-arity2 insn.insn (comb x)
   | MOVHPD x: sem-default-arity2 insn.insn (comb x)
   | MOVHPS x: sem-default-arity2 insn.insn (comb x)
   | MOVLHPS x: sem-default-arity2 insn.insn (comb x)
   | MOVLPD x: sem-default-arity2 insn.insn (comb x)
   | MOVLPS x: sem-default-arity2 insn.insn (comb x)
   | MOVMSKPD x: sem-default-arity2 insn.insn (comb x)
   | MOVMSKPS x: sem-default-arity2 insn.insn (comb x)
   | MOVNTDQ x: sem-mov '0' (comb x)
   | MOVNTDQA x: sem-mov '0' (comb x)
   | MOVNTI x: sem-mov '0' (comb x)
   | MOVNTPD x: sem-default-arity2 insn.insn (comb x)
   | MOVNTPS x: sem-default-arity2 insn.insn (comb x)
   | MOVNTQ x: sem-mov '0' (comb x)
   | MOVQ x: sem-movq (comb x)
   | MOVQ2DQ x: sem-movzx '0' (comb x)
   | MOVS x: sem-rep-insn (comb x) sem-movs
   | MOVSD x: sem-default-arity2 insn.insn (comb x)
   | MOVSHDUP x: sem-default-arity2 insn.insn (comb x)
   | MOVSLDUP x: sem-default-arity2 insn.insn (comb x)
   | MOVSS x: sem-default-arity2 insn.insn (comb x)
   | MOVSW x: sem-default-arity2 insn.insn (comb x)
   | MOVSX x: sem-movsx (comb x)
   | MOVSXD x: sem-movsx (comb x)
   | MOVUPD x: sem-default-arity2 insn.insn (comb x)
   | MOVUPS x: sem-default-arity2 insn.insn (comb x)
   | MOVZX x: sem-movzx '0' (comb x)
   | MPSADBW x: sem-default-arity3 insn.insn (comb x)
   | MUL x: sem-mul Unsigned (comb x)
   | MULPD x: sem-default-arity2 insn.insn (comb x)
   | MULPS x: sem-default-arity2 insn.insn (comb x)
   | MULSD x: sem-default-arity2 insn.insn (comb x)
   | MULSS x: sem-default-arity2 insn.insn (comb x)
   | MWAIT: sem-nop
   | NEG x: sem-neg (comb x)
   | NOP x: sem-nop
   | NOT x: sem-not (comb x)
   | OR x: sem-or (comb x)
   | ORPD x: sem-default-arity2 insn.insn (comb x)
   | ORPS x: sem-default-arity2 insn.insn (comb x)
   | OUT x: sem-default-arity2-ro insn.insn (comb x)
   | OUTS: sem-default-arity0 insn.insn
   | OUTSB: sem-default-arity0 insn.insn
   | OUTSD: sem-default-arity0 insn.insn
   | OUTSW: sem-default-arity0 insn.insn
   | PABSB x: sem-pabs '0' 8 (comb x)
   | PABSD x: sem-pabs '0' 32 (comb x)
   | PABSW x: sem-pabs '0' 16 (comb x)
   | PACKSSDW x: sem-packsswb-packssdw 16 (comb x)
   | PACKSSWB x: sem-packsswb-packssdw 8 (comb x)
   | PACKUSDW x: sem-packuswb-packusdw 16 (comb x)
   | PACKUSWB x: sem-packuswb-packusdw 8 (comb x)
   | PADDB x: sem-padd 8 (comb x)
   | PADDD x: sem-padd 32 (comb x)
   | PADDQ x: sem-padd 64 (comb x)
   | PADDSB x: sem-padds 8 (comb x)
   | PADDSW x: sem-padds 16 (comb x)
   | PADDUSB x: sem-paddus 8 (comb x)
   | PADDUSW x: sem-paddus 16 (comb x)
   | PADDW x: sem-padd 16 (comb x)
   | PALIGNR x: sem-palignr (comb x)
   | PAND x: sem-pand (comb x)
   | PANDN x: sem-pandn (comb x)
   | PAUSE: sem-default-arity0 insn.insn
   | PAVGB x: sem-pavg 8 (comb x)
   | PAVGW x: sem-pavg 16 (comb x)
   | PBLENDVB x: sem-pblendvb (comb x)
   | PBLENDW x: sem-pblendw (comb x)
   | PCLMULQDQ x: sem-pclmulqdq (comb x)
   | PCMPEQB x: sem-pcmpeq 8 (comb x)
   | PCMPEQD x: sem-pcmpeq 32 (comb x)
   | PCMPEQQ x: sem-pcmpeq 64 (comb x)
   | PCMPEQW x: sem-pcmpeq 16 (comb x)
   | PCMPESTRI x: sem-default-arity3 insn.insn (comb x)
   | PCMPESTRM x: sem-default-arity3 insn.insn (comb x)
   | PCMPGRD x: sem-default-arity2 insn.insn (comb x)
   | PCMPGTB x: sem-pcmpgt 8 (comb x)
   | PCMPGTD x: sem-pcmpgt 32 (comb x) 
   | PCMPGTQ x: sem-pcmpgt 64 (comb x)
   | PCMPGTW x: sem-pcmpgt 16 (comb x)
   | PCMPISTRI x: sem-default-arity3 insn.insn (comb x)
   | PCMPISTRM x: sem-default-arity3 insn.insn (comb x)
   | PEXTRB x: sem-pextr-vpextr 8 (comb x)
   | PEXTRD x: sem-pextr-vpextr 32 (comb x)
   | PEXTRQ x: sem-pextr-vpextr 64 (comb x)
   | PEXTRW x: sem-pextr-vpextr 16 (comb x)
   | PHADDD x: sem-phadd 32 (comb x)
   | PHADDSW x: sem-phaddsw (comb x)
   | PHADDW x: sem-phadd 16 (comb x)
   | PHMINPOSUW x: sem-phminposuw-vphminposuw '0' (comb x)
   | PHSUBD x: sem-phsub 32 (comb x)
   | PHSUBSW x: sem-phsubsw (comb x)
   | PHSUBW x: sem-phsub 16 (comb x)
   | PINSRB x: sem-pinsr 8 (comb x)
   | PINSRD x: sem-pinsr 32 (comb x)
   | PINSRQ x: sem-pinsr 64 (comb x)
   | PINSRW x: sem-pinsr 16 (comb x)
   | PMADDUBSW x: sem-pmaddubsw (comb x)
   | PMADDWD x: sem-pmaddwd (comb x)
   | PMAXSB x: sem-pmaxs 8 (comb x)
   | PMAXSD x: sem-pmaxs 32 (comb x)
   | PMAXSW x: sem-pmaxs 16 (comb x)
   | PMAXUB x: sem-pmaxu 8 (comb x)
   | PMAXUD x: sem-pmaxu 32 (comb x)
   | PMAXUW x: sem-pmaxu 16 (comb x)
   | PMINSB x: sem-pmins 8 (comb x)
   | PMINSD x: sem-pmins 32 (comb x)
   | PMINSW x: sem-pmins 16 (comb x)
   | PMINUB x: sem-pminu 8 (comb x)
   | PMINUD x: sem-pminu 32 (comb x)
   | PMINUW x: sem-pminu 16 (comb x)
   | PMOVMSKB x: sem-pmovmskb-vpmovmskb '0' (comb x)
   | PMOVSXBD x: sem-pmovsx-vpmovsx '0' 8 32 (comb x)
   | PMOVSXBQ x: sem-pmovsx-vpmovsx '0' 8 64 (comb x)
   | PMOVSXBW x: sem-pmovsx-vpmovsx '0' 8 16 (comb x)
   | PMOVSXDQ x: sem-pmovsx-vpmovsx '0' 32 64 (comb x)
   | PMOVSXWD x: sem-pmovsx-vpmovsx '0' 16 32 (comb x)
   | PMOVSXWQ x: sem-pmovsx-vpmovsx '0' 16 64 (comb x)
   | PMOVZXBD x: sem-pmovzx-vpmovzx '0' 8 32 (comb x)
   | PMOVZXBQ x: sem-pmovzx-vpmovzx '0' 8 64 (comb x)
   | PMOVZXBW x: sem-pmovzx-vpmovzx '0' 8 16 (comb x)
   | PMOVZXDQ x: sem-pmovzx-vpmovzx '0' 32 64 (comb x)
   | PMOVZXWD x: sem-pmovzx-vpmovzx '0' 16 32 (comb x)
   | PMOVZXWQ x: sem-pmovzx-vpmovzx '0' 16 64 (comb x)
   | PMULDQ x: sem-pmuldq (comb x)
   | PMULHRSW x: sem-pmulhrsw (comb x)
   | PMULHUW x: sem-pmulhuw (comb x)
   | PMULHW x: sem-pmulhw (comb x)
   | PMULLD x: sem-pmull 32 (comb x)
   | PMULLW x: sem-pmull 16 (comb x)
   | PMULUDQ x: sem-pmuludq (comb x)
   | POP x: sem-pop (comb x)
   | POPA: sem-popa-popad (comb {})
   | POPAD: sem-popa-popad (comb {})
   | POPCNT x: sem-popcnt (comb x)
   | POPF: sem-popf (comb {})
   | POPFD: sem-popf (comb {})
   | POPFQ: sem-popf (comb {})
   | POR x: sem-por (comb x)
   | PREFETCHNTA x: sem-default-arity1 insn.insn (comb x)
   | PREFETCHT0 x: sem-default-arity1 insn.insn (comb x)
   | PREFETCHT1 x: sem-default-arity1 insn.insn (comb x)
   | PREFETCHT2 x: sem-default-arity1 insn.insn (comb x)
   | PREFETCHW x: sem-default-arity1 insn.insn (comb x)
   | PSADBW x: sem-psadbw (comb x)
   | PSHUFB x: sem-pshufb (comb x)
   | PSHUFD x: sem-pshufd-vpshufd '0' (comb x)
   | PSHUFHW x: sem-pshufhw-vpshufhw '0' (comb x)
   | PSHUFLW x: sem-pshuflw-vpshuflw '0' (comb x)
   | PSHUFW x: sem-pshufw (comb x)
   | PSIGNB x: sem-psign 8 (comb x)
   | PSIGND x: sem-psign 32 (comb x)
   | PSIGNW x: sem-psign 16 (comb x)
   | PSLLD x: sem-psll 32 (comb x)
   | PSLLDQ x: sem-pslldq (comb x)
   | PSLLQ x: sem-psll 64 (comb x)
   | PSLLW x: sem-psll 16 (comb x)
   | PSRAD x: sem-psra 32 (comb x)
   | PSRAW x: sem-psra 16 (comb x)
   | PSRLD x: sem-psrl 32 (comb x)
   | PSRLDQ x: sem-psrldq (comb x)
   | PSRLQ x: sem-psrl 64 (comb x)
   | PSRLW x: sem-psrl 16 (comb x)
   | PSUBB x: sem-psub 8 (comb x)
   | PSUBD x: sem-psub 32 (comb x)
   | PSUBQ x: sem-psub 64 (comb x)
   | PSUBSB x: sem-psubs 8 (comb x)
   | PSUBSW x: sem-psubs 16 (comb x)
   | PSUBUSB x: sem-psubus 8 (comb x)
   | PSUBUSW x: sem-psubus 16 (comb x)
   | PSUBW x: sem-psub 16 (comb x)
   | PTEST x: sem-ptest-vptest (comb x)
   | PUNPCKHBW x: sem-punpckh 8 (comb x)
   | PUNPCKHDQ x: sem-punpckh 32 (comb x)
   | PUNPCKHQDQ x: sem-punpckh 64 (comb x)
   | PUNPCKHWD x: sem-punpckh 16 (comb x)
   | PUNPCKLBW x: sem-punpckl 8 (comb x)
   | PUNPCKLDQ x: sem-punpckl 32 (comb x)
   | PUNPCKLQDQ x: sem-punpckl 64 (comb x)
   | PUNPCKLWD x: sem-punpckl 16 (comb x)
   | PUSH x: sem-push (comb x)
   | PUSHA: sem-pusha-pushad (comb {})
   | PUSHAD: sem-pusha-pushad (comb {})
   | PUSHF: sem-pushf (comb {})
   | PUSHFD: sem-pushf (comb {})
   | PUSHFQ: sem-pushf (comb {})
   | PXOR x: sem-pxor (comb x)
   | RCL x: sem-rcl (comb x)
   | RCPPS x: sem-default-arity2 insn.insn (comb x)
   | RCPSS x: sem-default-arity2 insn.insn (comb x)
   | RCR x: sem-rcr (comb x)
   | RDFSBASE x: sem-default-arity1 insn.insn (comb x)
   | RDGSBASE x: sem-default-arity1 insn.insn (comb x)
   | RDMSR: sem-default-arity0 insn.insn
   | RDPMC: sem-default-arity0 insn.insn
   | RDRAND x: sem-default-arity1 insn.insn (comb x)
   | RDTSC: sem-default-arity0 insn.insn
   | RDTSCP: sem-default-arity0 insn.insn
   | RET x: sem-ret x insn
   | RET_FAR x: sem-ret-far x insn
   | ROL x: sem-rol (comb x)
   | ROR x: sem-ror (comb x)
   | ROUNDPD x: sem-default-arity3 insn.insn (comb x)
   | ROUNDPS x: sem-default-arity3 insn.insn (comb x)
   | ROUNDSD x: sem-default-arity3 insn.insn (comb x)
   | ROUNDSS x: sem-default-arity3 insn.insn (comb x)
   | RSM: sem-default-arity0 insn.insn
   | RSQRTPS x: sem-default-arity2 insn.insn (comb x)
   | RSQRTSS x: sem-default-arity2 insn.insn (comb x)
   | SAHF: sem-sahf (comb {})
   | SAL x: sem-sal-shl (comb x)
   | SALC: sem-salc (comb {})
   | SAR x: sem-shr-sar (comb x) '1'
   | SBB x: sem-sbb (comb x)
   | SCASB: sem-scas 8 (comb {})
   | SCASD: sem-scas 32 (comb {})
   | SCASQ: sem-scas 64 (comb {})
   | SCASW: sem-scas 16 (comb {})
   | SETA x: sem-a sem-setcc (comb x)
   | SETAE x: sem-ae sem-setcc (comb x)
   | SETB x: sem-b sem-setcc (comb x)
   | SETBE x: sem-be sem-setcc (comb x)
   | SETC x: sem-c sem-setcc (comb x)
   | SETE x: sem-e sem-setcc (comb x)
   | SETG x: sem-g sem-setcc (comb x)
   | SETGE x: sem-ge sem-setcc (comb x)
   | SETL x: sem-l sem-setcc (comb x)
   | SETLE x: sem-le sem-setcc (comb x)
   | SETNA x: sem-na sem-setcc (comb x)
   | SETNAE x: sem-nae sem-setcc (comb x)
   | SETNB x: sem-nb sem-setcc (comb x)
   | SETNBE x: sem-nbe sem-setcc (comb x)
   | SETNC x: sem-nc sem-setcc (comb x)
   | SETNE x: sem-ne sem-setcc (comb x)
   | SETNG x: sem-ng sem-setcc (comb x)
   | SETNGE x: sem-nge sem-setcc (comb x)
   | SETNL x: sem-nl sem-setcc (comb x)
   | SETNLE x: sem-nle sem-setcc (comb x)
   | SETNO x: sem-no sem-setcc (comb x)
   | SETNP x: sem-np sem-setcc (comb x)
   | SETNS x: sem-ns sem-setcc (comb x)
   | SETNZ x: sem-nz sem-setcc (comb x)
   | SETO x: sem-o sem-setcc (comb x)
   | SETP x: sem-p sem-setcc (comb x)
   | SETPE x: sem-pe sem-setcc (comb x)
   | SETPO x: sem-po sem-setcc (comb x)
   | SETS x: sem-s sem-setcc (comb x)
   | SETZ x: sem-z sem-setcc (comb x)
   | SFENCE: sem-default-arity0 insn.insn
   | SGDT x: sem-default-arity1 insn.insn (comb x)
   | SHL x: sem-sal-shl (comb x)
   | SHLD x: sem-shld (comb x)
   | SHR x: sem-shr-sar (comb x) '0'
   | SHRD x: sem-shrd (comb x)
   | SHUFPD x: sem-default-arity3 insn.insn (comb x)
   | SHUFPS x: sem-default-arity3 insn.insn (comb x)
   | SIDT x: sem-default-arity1 insn.insn (comb x)
   | SLDT x: sem-default-arity1 insn.insn (comb x)
   | SMSW x: sem-default-arity1 insn.insn (comb x)
   | SQRTPD x: sem-default-arity2 insn.insn (comb x)
   | SQRTPS x: sem-default-arity2 insn.insn (comb x)
   | SQRTSD x: sem-default-arity2 insn.insn (comb x)
   | SQRTSS x: sem-default-arity2 insn.insn (comb x)
   | STC: sem-stc
   | STD: sem-std
   | STI: sem-default-arity0 insn.insn
   | STMXCSR x: sem-default-arity1 insn.insn (comb x)
   | STOSB: sem-stos 8 (comb {})
   | STOSD: sem-stos 32 (comb {})
   | STOSQ: sem-stos 64 (comb {})
   | STOSW: sem-stos 16 (comb {})
   | STR x: sem-default-arity1 insn.insn (comb x)
   | SUB x: sem-sub (comb x)
   | SUBPD x: sem-default-arity2 insn.insn (comb x)
   | SUBPS x: sem-default-arity2 insn.insn (comb x)
   | SUBSD x: sem-default-arity2 insn.insn (comb x)
   | SUBSS x: sem-default-arity2 insn.insn (comb x)
   | SWAPGS: sem-default-arity0 insn.insn
   | SYSCALL: sem-default-arity0 insn.insn
   | SYSENTER: sem-default-arity0 insn.insn
   | SYSEXIT: sem-default-arity0 insn.insn
   | SYSRET: sem-default-arity0 insn.insn
   | TEST x: sem-test (comb x)
   | UCOMISD x: sem-default-arity2 insn.insn (comb x)
   | UCOMISS x: sem-default-arity2 insn.insn (comb x)
   | UD2: sem-default-arity0 insn.insn
   | UNPCKHPD x: sem-default-arity2 insn.insn (comb x)
   | UNPCKHPS x: sem-default-arity2 insn.insn (comb x)
   | UNPCKLPD x: sem-default-arity2 insn.insn (comb x)
   | UNPCKLPS x: sem-default-arity2 insn.insn (comb x)
   | VADDPD x: sem-default-varity x insn.insn
   | VADDPS x: sem-default-varity x insn.insn
   | VADDSD x: sem-default-varity x insn.insn
   | VADDSS x: sem-default-varity x insn.insn
   | VADDSUBPD x: sem-default-varity x insn.insn
   | VADDSUBPS x: sem-default-varity x insn.insn
   | VAESDEC v:
       case v of
          VA3 x: sem-vaesdec (comb x)
       end
   | VAESDECLAST x: sem-default-varity x insn.insn
   | VAESENC x: sem-default-varity x insn.insn
   | VAESENCLAST x: sem-default-varity x insn.insn
   | VAESIMC x: sem-default-varity x insn.insn
   | VAESKEYGENASSIST x: sem-default-varity x insn.insn
   | VANDNPD v: sem-default-varity v insn.insn
   | VANDNPS x: sem-default-varity x insn.insn
   | VANDPD v:
       case v of
          VA3 x: sem-vandpd (comb x)
       end
   | VANDPS x: sem-default-varity x insn.insn
   | VBLENDPD x: sem-default-varity x insn.insn
   | VBLENDPS x: sem-default-varity x insn.insn
   | VBLENDVPD x: sem-default-varity x insn.insn
   | VBLENDVPS x: sem-default-varity x insn.insn
   | VBROADCASTF128 v: sem-vbroadcast v
   | VBROADCASTSD v: sem-vbroadcast v
   | VBROADCASTSS v: sem-vbroadcast v
   | VCMPPD x: sem-default-varity x insn.insn
   | VCMPPS x: sem-default-varity x insn.insn
   | VCMPSD x: sem-default-varity x insn.insn
   | VCMPSS x: sem-default-varity x insn.insn
   | VCOMISD x: sem-default-varity x insn.insn
   | VCOMISS x: sem-default-varity x insn.insn
   | VCVTDQ2PD x: sem-default-varity x insn.insn
   | VCVTDQ2PS x: sem-default-varity x insn.insn
   | VCVTPD2DQ x: sem-default-varity x insn.insn
   | VCVTPD2PS x: sem-default-varity x insn.insn
   | VCVTPH2PS x: sem-default-varity x insn.insn
   | VCVTPS2DQ x: sem-default-varity x insn.insn
   | VCVTPS2PD x: sem-default-varity x insn.insn
   | VCVTPS2PH x: sem-default-varity x insn.insn
   | VCVTSD2SI x: sem-default-varity x insn.insn
   | VCVTSD2SS x: sem-default-varity x insn.insn
   | VCVTSI2SD x: sem-default-varity x insn.insn
   | VCVTSI2SS x: sem-default-varity x insn.insn
   | VCVTSS2SD x: sem-default-varity x insn.insn
   | VCVTSS2SI x: sem-default-varity x insn.insn
   | VCVTTPD2DQ x: sem-default-varity x insn.insn
   | VCVTTPS2DQ x: sem-default-varity x insn.insn
   | VCVTTSD2SI x: sem-default-varity x insn.insn
   | VCVTTSS2SI x: sem-default-varity x insn.insn
   | VDIVPD x: sem-default-varity x insn.insn
   | VDIVPS x: sem-default-varity x insn.insn
   | VDIVSD x: sem-default-varity x insn.insn
   | VDIVSS x: sem-default-varity x insn.insn
   | VDPPD x: sem-default-varity x insn.insn
   | VDPPS x: sem-default-varity x insn.insn
   | VERR x: sem-default-arity1 insn.insn (comb x)
   | VERW x: sem-default-arity1 insn.insn (comb x)
   | VEXTRACTF128 x: sem-default-varity x insn.insn
   | VEXTRACTPS x: sem-default-varity x insn.insn
   | VHADDPD x: sem-default-varity x insn.insn
   | VHADDPS x: sem-default-varity x insn.insn
   | VHSUBPD x: sem-default-varity x insn.insn
   | VHSUBPS x: sem-default-varity x insn.insn
   | VINSERTF128 x: sem-default-varity x insn.insn
   | VINSERTPS x: sem-default-varity x insn.insn
   | VLDDQU v:
       case v of
         VA2 x: sem-mov '1' (comb x)
       end
   | VLDMXCSR x: sem-default-varity x insn.insn
   | VMASKMOVDQU v:
       case v of
          VA3 x: sem-maskmovdqu-vmaskmovdqu (comb x)
       end
   | VMASKMOVPD x: sem-vmaskmovp 64 x
   | VMASKMOVPS x: sem-vmaskmovp 32 x
   | VMAXPD x: sem-default-varity x insn.insn
   | VMAXPS x: sem-default-varity x insn.insn
   | VMAXSD x: sem-default-varity x insn.insn
   | VMAXSS x: sem-default-varity x insn.insn
   | VMINPD x: sem-default-varity x insn.insn
   | VMINPS x: sem-default-varity x insn.insn
   | VMINSD x: sem-default-varity x insn.insn
   | VMINSS x: sem-default-varity x insn.insn
   | VMOVAPD v:
       case v of
          VA2 x: sem-mov '1' (comb x)
       end
   | VMOVAPS v:
       case v of
          VA2 x: sem-mov '1' (comb x)
       end
   | VMOVD v:
       case v of
          VA2 x: sem-movzx '1' (comb x)
       end
   | VMOVDDUP x: sem-default-varity x insn.insn
   | VMOVDQA v:
       case v of
          VA2 x: sem-mov '1' (comb x)
       end
   | VMOVDQU v:
       case v of
          VA2 x: sem-mov '1' (comb x)
       end
   | VMOVHLPS x: sem-default-varity x insn.insn
   | VMOVHPD x: sem-default-varity x insn.insn
   | VMOVHPS x: sem-default-varity x insn.insn
   | VMOVLHPS x: sem-default-varity x insn.insn
   | VMOVLPD x: sem-default-varity x insn.insn
   | VMOVLPS x: sem-default-varity x insn.insn
   | VMOVMSKPD x: sem-default-varity x insn.insn
   | VMOVMSKPS x: sem-default-varity x insn.insn
   | VMOVNTDQ v:
       case v of
          VA2 x: sem-mov '1' (comb x)
       end
   | VMOVNTDQA v:
       case v of
          VA2 x: sem-mov '1' (comb x)
       end
   | VMOVNTPD x: sem-default-varity x insn.insn
   | VMOVNTPS x: sem-default-varity x insn.insn
   | VMOVQ v:
       case v of
          VA2 x: sem-movzx '1' (comb x)
       end
   | VMOVSD x: sem-default-varity x insn.insn
   | VMOVSHDUP x: sem-default-varity x insn.insn
   | VMOVSLDUP x: sem-default-varity x insn.insn
   | VMOVSS x: sem-default-varity x insn.insn
   | VMOVUPD x: sem-default-varity x insn.insn
   | VMOVUPS x: sem-default-varity x insn.insn
   | VMPSADBW x: sem-default-varity x insn.insn
   | VMULPD x: sem-default-varity x insn.insn
   | VMULPS x: sem-default-varity x insn.insn
   | VMULSD x: sem-default-varity x insn.insn
   | VMULSS x: sem-default-varity x insn.insn
   | VORPD x: sem-default-varity x insn.insn
   | VORPS x: sem-default-varity x insn.insn
   | VPABSB v:
       case v of
          VA2 x: sem-pabs '1' 8 (comb x)
       end
   | VPABSD v:
       case v of
          VA2 x: sem-pabs '1' 32 (comb x)
       end
   | VPABSW v:
       case v of
          VA2 x: sem-pabs '1' 16 (comb x)
       end
   | VPACKSSDW v:
       case v of
          VA3 x: sem-vpacksswb-vpackssdw 16 (comb x)
       end
   | VPACKSSWB v:
       case v of
          VA3 x: sem-vpacksswb-vpackssdw 8 (comb x)
       end
   | VPACKUSDW v:
       case v of
          VA3 x: sem-vpackuswb-vpackusdw 16 (comb x)
       end
   | VPACKUSWB v:
       case v of
          VA3 x: sem-vpackuswb-vpackusdw 8 (comb x)
       end
   | VPADDB v:
       case v of
          VA3 x: sem-vpadd 8 (comb x)
       end
   | VPADDD v:
       case v of
          VA3 x: sem-vpadd 32 (comb x)
       end
   | VPADDQ v:
       case v of
          VA3 x: sem-vpadd 64 (comb x)
       end
   | VPADDSB v:
       case v of
          VA3 x: sem-vpadds 8 (comb x)
       end
   | VPADDSW v:
       case v of
          VA3 x: sem-vpadds 16 (comb x)
       end
   | VPADDUSB v:
       case v of
          VA3 x: sem-vpaddus 8 (comb x)
       end
   | VPADDUSW v:
       case v of
          VA3 x: sem-vpaddus 16 (comb x)
       end
   | VPADDW v:
       case v of
          VA3 x: sem-vpadd 16 (comb x)
       end
   | VPALIGNR v:
       case v of
          VA4 x: sem-vpalignr (comb x)
       end
   | VPAND v:
       case v of
          VA3 x: sem-vpand (comb x)
       end
   | VPANDN v:
       case v of
          VA3 x: sem-vpandn (comb x)
       end
   | VPAVGB v:
       case v of
          VA3 x: sem-vpavg 8 (comb x)
       end
   | VPAVGW v:
       case v of
          VA3 x: sem-vpavg 16 (comb x)
       end
   | VPBLENDVB v:
       case v of
          VA4 x: sem-vpblendvb (comb x)
       end
   | VPBLENDW v:
       case v of
          VA4 x: sem-vpblendw (comb x)
       end
   | VPCLMULQDQ v:
       case v of
          VA4 x: sem-vpclmulqdq (comb x)
       end
   | VPCMPEQB v:
       case v of
          VA3 x: sem-vpcmpeq 8 (comb x)
       end
   | VPCMPEQD v:
       case v of
          VA3 x: sem-vpcmpeq 32 (comb x)
       end
   | VPCMPEQQ v:
       case v of
          VA3 x: sem-vpcmpeq 64 (comb x)
       end
   | VPCMPEQW v:
       case v of
          VA3 x: sem-vpcmpeq 16 (comb x)
       end
   | VPCMPESTRI x: sem-default-varity x insn.insn
   | VPCMPESTRM x: sem-default-varity x insn.insn
   | VPCMPGTB v:
       case v of
          VA3 x: sem-vpcmpgt 8 (comb x)
       end
   | VPCMPGTD v:
       case v of
          VA3 x: sem-vpcmpgt 32 (comb x)
       end
   | VPCMPGTQ v:
       case v of
          VA3 x: sem-vpcmpgt 64 (comb x)
       end
   | VPCMPGTW v:
       case v of
          VA3 x: sem-vpcmpgt 16 (comb x)
       end
   | VPCMPISTRI x: sem-default-varity x insn.insn
   | VPCMPISTRM x: sem-default-varity x insn.insn
   | VPERM2F128 x: sem-default-varity x insn.insn
   | VPERMILPD x: sem-default-varity x insn.insn
   | VPERMILPS x: sem-default-varity x insn.insn
   | VPEXTRB v:
       case v of
          VA3 x: sem-pextr-vpextr 8 (comb x)
       end
   | VPEXTRD v:
       case v of
          VA3 x: sem-pextr-vpextr 32 (comb x)
       end
   | VPEXTRQ v:
       case v of
          VA3 x: sem-pextr-vpextr 64 (comb x)
       end
   | VPEXTRW v:
       case v of
          VA3 x: sem-pextr-vpextr 16 (comb x)
       end
   | VPHADDD v:
       case v of
          VA3 x: sem-vphadd 32 (comb x)
       end
   | VPHADDSW v:
       case v of
          VA3 x: sem-vphaddsw (comb x)
       end
   | VPHADDW v:
       case v of
          VA3 x: sem-vphadd 16 (comb x)
       end
   | VPHMINPOSUW v:
       case v of
          VA2 x: sem-phminposuw-vphminposuw '1' (comb x)
       end
   | VPHSUBD v:
       case v of
          VA3 x: sem-vphsub 32 (comb x)
       end
   | VPHSUBSW v:
       case v of
          VA3 x: sem-vphsubsw (comb x)
       end
   | VPHSUBW v:
       case v of
          VA3 x: sem-vphsub 16 (comb x)
       end
   | VPINSRB v:
       case v of
          VA4 x: sem-vpinsr 8 (comb x)
       end
   | VPINSRD v:
       case v of
          VA4 x: sem-vpinsr 32 (comb x)
       end
   | VPINSRQ v:
       case v of
          VA4 x: sem-vpinsr 64 (comb x)
       end
   | VPINSRW v:
       case v of
          VA4 x: sem-vpinsr 16 (comb x)
       end
   | VPMADDUBSW v:
       case v of
          VA3 x: sem-vpmaddubsw (comb x)
       end
   | VPMADDWD v:
       case v of
          VA3 x: sem-vpmaddwd (comb x)
       end
   | VPMAXSB v:
       case v of
          VA3 x: sem-vpmaxs 8 (comb x)
       end
   | VPMAXSD v:
       case v of
          VA3 x: sem-vpmaxs 32 (comb x)
       end
   | VPMAXSW v:
       case v of
          VA3 x: sem-vpmaxs 16 (comb x)
       end
   | VPMAXUB v:
       case v of
          VA3 x: sem-vpmaxu 8 (comb x)
       end
   | VPMAXUD v:
       case v of
          VA3 x: sem-vpmaxu 32 (comb x)
       end
   | VPMAXUW v:
       case v of
          VA3 x: sem-vpmaxu 16 (comb x)
       end
   | VPMINSB v:
       case v of
          VA3 x: sem-vpmins 8 (comb x)
       end
   | VPMINSD v:
       case v of
          VA3 x: sem-vpmins 32 (comb x)
       end
   | VPMINSW v:
       case v of
          VA3 x: sem-vpmins 16 (comb x)
       end
   | VPMINUB v:
       case v of
          VA3 x: sem-vpminu 8 (comb x)
       end
   | VPMINUD v:
       case v of
          VA3 x: sem-vpminu 32 (comb x)
       end
   | VPMINUW v:
       case v of
          VA3 x: sem-vpminu 16 (comb x)
       end
   | VPMOVMSKB v:
       case v of
          VA2 x: sem-pmovmskb-vpmovmskb '1' (comb x)
       end
   | VPMOVSXBD v:
       case v of
          VA2 x: sem-pmovsx-vpmovsx '1' 8 32 (comb x)
       end
   | VPMOVSXBQ v:
       case v of
          VA2 x: sem-pmovsx-vpmovsx '1' 8 64 (comb x)
       end
   | VPMOVSXBW v:
       case v of
          VA2 x: sem-pmovsx-vpmovsx '1' 8 16 (comb x)
       end
   | VPMOVSXDQ v:
       case v of
          VA2 x: sem-pmovsx-vpmovsx '1' 32 64 (comb x)
       end
   | VPMOVSXWD v:
       case v of
          VA2 x: sem-pmovsx-vpmovsx '1' 16 32 (comb x)
       end
   | VPMOVSXWQ v:
       case v of
          VA2 x: sem-pmovsx-vpmovsx '1' 16 64 (comb x)
       end
   | VPMOVZXBD v:
       case v of
          VA2 x: sem-pmovzx-vpmovzx '1' 8 32 (comb x)
       end
   | VPMOVZXBQ v:
       case v of
          VA2 x: sem-pmovzx-vpmovzx '1' 8 64 (comb x)
       end
   | VPMOVZXBW v:
       case v of
          VA2 x: sem-pmovzx-vpmovzx '1' 8 16 (comb x)
       end
   | VPMOVZXDQ v:
       case v of
          VA2 x: sem-pmovzx-vpmovzx '1' 32 64 (comb x)
       end
   | VPMOVZXWD v:
       case v of
          VA2 x: sem-pmovzx-vpmovzx '1' 16 32 (comb x)
       end
   | VPMOVZXWQ v:
       case v of
          VA2 x: sem-pmovzx-vpmovzx '1' 16 64 (comb x)
       end
   | VPMULDQ v:
       case v of
          VA3 x: sem-vpmuldq (comb x)
       end
   | VPMULHRSW v:
       case v of
          VA3 x: sem-vpmulhrsw (comb x)
       end
   | VPMULHUW v:
       case v of
          VA3 x: sem-vpmulhuw (comb x)
       end
   | VPMULHW v:
       case v of
          VA3 x: sem-vpmulhw (comb x)
       end
   | VPMULLD v:
       case v of
          VA3 x: sem-vpmull 32 (comb x)
       end
   | VPMULLW v:
       case v of
          VA3 x: sem-vpmull 16 (comb x)
       end
   | VPMULUDQ v:
       case v of
          VA3 x: sem-vpmuludq (comb x)
       end
   | VPOR v:
       case v of
          VA3 x: sem-vpor (comb x)
       end
   | VPSADBW v:
       case v of
          VA3 x: sem-vpsadbw (comb x)
       end
   | VPSHUFB v:
       case v of
          VA3 x: sem-vpshufb (comb x)
       end
   | VPSHUFD v:
       case v of
          VA3 x: sem-pshufd-vpshufd '1' (comb x)
       end
   | VPSHUFHW v:
       case v of
          VA3 x: sem-pshufhw-vpshufhw '1' (comb x)
       end
   | VPSHUFLW v:
       case v of
          VA3 x: sem-pshuflw-vpshuflw '1' (comb x)
       end
   | VPSIGNB v:
       case v of
          VA3 x: sem-vpsign 8 (comb x)
       end
   | VPSIGND v:
       case v of
          VA3 x: sem-vpsign 32 (comb x)
       end
   | VPSIGNW v:
       case v of
          VA3 x: sem-vpsign 16 (comb x)
       end
   | VPSLLD v:
       case v of
          VA3 x: sem-vpsll 32 (comb x)
       end
   | VPSLLDQ v:
       case v of
          VA3 x: sem-vpslldq (comb x)
       end
   | VPSLLQ v:
       case v of
          VA3 x: sem-vpsll 64 (comb x)
       end
   | VPSLLW v:
       case v of
          VA3 x: sem-vpsll 16 (comb x)
       end
   | VPSRAD v:
       case v of
          VA3 x: sem-vpsra 32 (comb x)
       end
   | VPSRAW v:
       case v of
          VA3 x: sem-vpsra 16 (comb x)
       end
   | VPSRLD v:
       case v of
          VA3 x: sem-vpsrl 32 (comb x)
       end
   | VPSRLDQ v:
       case v of
          VA3 x: sem-vpsrldq (comb x)
       end
   | VPSRLQ v:
       case v of
          VA3 x: sem-vpsrl 64 (comb x)
       end
   | VPSRLW v:
       case v of
          VA3 x: sem-vpsrl 16 (comb x)
       end
   | VPSUBB v:
       case v of
          VA3 x: sem-vpsub 8 (comb x)
       end
   | VPSUBD v:
       case v of
          VA3 x: sem-vpsub 32 (comb x)
       end
   | VPSUBQ v:
       case v of
          VA3 x: sem-vpsub 64 (comb x)
       end
   | VPSUBSB v:
       case v of
          VA3 x: sem-vpsubs 8 (comb x)
       end
   | VPSUBSW v:
       case v of
          VA3 x: sem-vpsubs 16 (comb x)
       end
   | VPSUBUSB v:
       case v of
          VA3 x: sem-vpsubus 8 (comb x)
       end
   | VPSUBUSW v:
       case v of
          VA3 x: sem-vpsubus 16 (comb x)
       end
   | VPSUBW v:
       case v of
          VA3 x: sem-vpsub 16 (comb x)
       end
   | VPTEST v:
       case v of
          VA2 x: sem-ptest-vptest (comb x)
       end
   | VPUNPCKHBW v:
       case v of
          VA3 x: sem-vpunpckh 8 (comb x)
       end
   | VPUNPCKHDQ v:
       case v of
          VA3 x: sem-vpunpckh 32 (comb x)
       end
   | VPUNPCKHQDQ v:
       case v of
          VA3 x: sem-vpunpckh 64 (comb x)
       end
   | VPUNPCKHWD v:
       case v of
          VA3 x: sem-vpunpckh 16 (comb x)
       end
   | VPUNPCKLBW v:
       case v of
          VA3 x: sem-vpunpckl 8 (comb x)
       end
   | VPUNPCKLDQ v:
       case v of
          VA3 x: sem-vpunpckl 32 (comb x)
       end
   | VPUNPCKLQDQ v:
       case v of
          VA3 x: sem-vpunpckl 64 (comb x)
       end
   | VPUNPCKLWD v:
       case v of
          VA3 x: sem-vpunpckl 16 (comb x)
       end
   | VPXOR v:
       case v of
          VA3 x: sem-vpxor (comb x)
       end
   | VRCPPS x: sem-default-varity x insn.insn
   | VRCPSS x: sem-default-varity x insn.insn
   | VROUNDPD x: sem-default-varity x insn.insn
   | VROUNDPS x: sem-default-varity x insn.insn
   | VROUNDSD x: sem-default-varity x insn.insn
   | VROUNDSS x: sem-default-varity x insn.insn
   | VRSQRTPS x: sem-default-varity x insn.insn
   | VRSQRTSS x: sem-default-varity x insn.insn
   | VSHUFPD x: sem-default-varity x insn.insn
   | VSHUFPS x: sem-default-varity x insn.insn
   | VSQRTPD x: sem-default-varity x insn.insn
   | VSQRTPS x: sem-default-varity x insn.insn
   | VSQRTSD x: sem-default-varity x insn.insn
   | VSQRTSS x: sem-default-varity x insn.insn
   | VSTMXCSR x: sem-default-varity x insn.insn
   | VSUBPD x: sem-default-varity x insn.insn
   | VSUBPS x: sem-default-varity x insn.insn
   | VSUBSD x: sem-default-varity x insn.insn
   | VSUBSS x: sem-default-varity x insn.insn
   | VTESTPD x: sem-default-varity x insn.insn
   | VTESTPS x: sem-default-varity x insn.insn
   | VUCOMISD x: sem-default-varity x insn.insn
   | VUCOMISS x: sem-default-varity x insn.insn
   | VUNPCKHPD x: sem-default-varity x insn.insn
   | VUNPCKHPS x: sem-default-varity x insn.insn
   | VUNPCKLPD x: sem-default-varity x insn.insn
   | VUNPCKLPS x: sem-default-varity x insn.insn
   | VXORPD x: sem-default-varity x insn.insn
   | VXORPS x: sem-default-varity x insn.insn
   | VZEROALL v: sem-vzeroall
   | VZEROUPPER v: sem-vzeroupper
   | WAIT: sem-default-arity0 insn.insn
   | WBINVD: sem-default-arity0 insn.insn
   | WRFSBASE x: sem-default-arity1 insn.insn (comb x)
   | WRGSBASE x: sem-default-arity1 insn.insn (comb x)
   | WRMSR: sem-default-arity0 insn.insn
   | XADD x: sem-xadd (comb x)
   | XCHG x: sem-xchg (comb x)
   | XGETBV: sem-default-arity0 insn.insn
   | XLATB: sem-default-arity0 insn.insn
   | XOR x: sem-xor (comb x)
   | XORPD x: sem-default-arity2 insn.insn (comb x)
   | XORPS x: sem-default-arity2 insn.insn (comb x)
   | XRSTOR x: sem-default-arity1 insn.insn (comb x)
   | XRSTOR64 x: sem-default-arity1 insn.insn (comb x)
   | XSAVE x: sem-default-arity1 insn.insn (comb x)
   | XSAVE64 x: sem-default-arity1 insn.insn (comb x)
   | XSAVEOPT x: sem-default-arity1 insn.insn (comb x)
   | XSAVEOPT64 x: sem-default-arity1 insn.insn (comb x)
   | XSETBV: sem-default-arity0 insn.insn
  end
end
#s/^ | \([^\s]*\) of \(arity\|flow\)\(.\)\s*/ | \1 x: sem-undef-\2\3 x/g
#s/^ | \([^\s]*\) of varity\s*/ | \1 x: sem-default-varity insn x/g
#s/^ | \(\S*\)\s*$/ | \1: sem-default-arity0 insn/g
#s/\(.*\)| \(\S*\):.*/\1| \2 x: sem-default-arity0 insn x/g

val translate-x86 insn = do
#  update@{mode64='1'};
  update @{mode64=if test-opt config-mode32 insn.config then '0' else '1'};

  ip-sz <- runtime-stack-address-size;
  ip <- ip-get;
  add ip-sz ip (var ip) (imm insn.length);
  
#  ifl <- fIF;
#  mov 1 ifl (imm 1);

  semantics insn
end

#val translate insn = example_lin
val translate insn = do
  update@{stack=SEM_NIL,tmp=0,lab=0};
  
  translate-x86 insn;
  
  stack <- query $stack;
  return (rreil-stmts-rev stack)
end

val translate-block-single insn = do
   ic <- query $ins_count;
   update@{ins_count=ic+1};
   
   translate-x86 {features=insn.features,opnd-sz=insn.opnd-sz,addr-sz=insn.addr-sz,rep=insn.rep,repne=insn.repne,lock=insn.lock,insn=insn.insn,config=insn.config,length=insn.length}  
end

val relative-next stmts = let
  val is_sem_ip x = case x of
     Sem_IP: '1'
   | _: '0'
  end
in
  relative-next-generic is_sem_ip stmts
end
