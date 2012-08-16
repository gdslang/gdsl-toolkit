# vim:filetype=sml:ts=3:sw=3:expandtab

export = translate

val guess-sizeof dst/src1 src2 = 
   case dst/src1 of
      REG r: return ($size (semantic-register-of r))
    | MEM x: return x.sz
    | _:
         case src2 of
            REG r: return ($size (semantic-register-of r))
          | MEM x: return x.sz
         end
   end

val guess-sizeof-flow target = return 64

val guess-sizeof1 op =
   case op of
      REG r: return (semantic-register-of r).size
    | MEM x: return x.sz
    | IMM8 i: return 8
    | IMM16 i: return 16
    | IMM32 i: return 32
    | IMM64 i: return 64
   end

val conv-with conv sz x = 
   let
      val conv-imm conv x = return (SEM_LIN_IMM{imm=conv x})
     
      val conv-reg r = return (SEM_LIN_VAR (semantic-register-of r))

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

      val conv-mem x = conv-with sx x.psz x.opnd
   in
      case x of
         IMM8 x: conv-imm conv x
       | IMM16 x: conv-imm conv x
       | IMM32 x: conv-imm conv x
       | IMM64 x: conv-imm conv x
       | REG x: conv-reg x
       | SUM x: conv-sum conv sz x
       | SCALE x: conv-scale conv sz x
       | MEM x:
            do t <- mktemp;
               address <- conv-mem x;
               load sz t x.psz address;
               return (var t)
            end
      end
   end

val read sz x = conv-with zx sz x
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

val write sz x =
   case x of
      MEM x:
         do address <- conv-with sx x.psz x.opnd;
            return
               (SEM_WRITE_MEM
                  {size= x.psz,
                   address=address})
         end
    | REG x:
         do id <- return (semantic-register-of x);
            return
               (SEM_WRITE_VAR
                  {size= $size id,
                   id=id})
         end
   end

val commit sz a b =
   case a of
      SEM_WRITE_MEM x:
         store x (SEM_LIN{size=sz,opnd1=b})
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

val fEQ = return (var//0 VIRT_EQ)
val fNEQ = return (var//0 VIRT_NEQ)
val fLES = return (var//0 VIRT_LES)
val fLEU = return (var//0 VIRT_LEU)
val fLTS = return (var//0 VIRT_LTS)
val fCF = return (var//0 VIRT_LTU)

val fOF = return (var//0 (ARCH_R ~1)) # OF
val fSF = return (var//0 (ARCH_R ~2)) # SF
val fAF = return (var//0 (ARCH_R ~3)) # AF

val zero = return (SEM_LIN_IMM{imm=0})

val emit-add-flags sz a b c =
   do eq <- fEQ;
      les <- fLES;
      leu <- fLEU;
      lts <- fLTS;
      ltu <- fCF;
      sf <- fSF;
      ov <- fOF;
      t1 <- mktemp;
      t2 <- mktemp;
      t3 <- mktemp;
      zer0 <- zero;
      # HACKERS-DELIGHT p27 
      # TODO: Compute {ltu} flag
      undef 1 ltu;
      xorb sz t1 a b;
      xorb sz t2 a c;
      andb sz t3 (var t1) (var t2);
      cmplts sz ov (var t3) zer0;
      cmplts sz sf a zer0;
      cmpeq sz eq a zer0;
      xorb 1 lts (var sf) (var ov);
      orb 1 leu (var ltu) (var eq);
      orb 1 les (var lts) (var eq)
   end

val emit-sub-flags sz a b c = 
   do eq <- fEQ;
      les <- fLES;
      leu <- fLEU;
      lts <- fLTS;
      ltu <- fCF;
      sf <- fSF;
      ov <- fOF;
      t1 <- mktemp;
      t2 <- mktemp;
      t3 <- mktemp;
      zer0 <- zero;
      cmpltu sz ltu b c;
      cmpleu sz leu b c;
      cmplts sz lts b c;
      cmples sz les b c;
      cmpeq sz eq b c;
      cmplts sz sf a zer0;
      xorb 1 ov (var lts) (var sf)
   end

val semantics insn =
  case insn of
      ADD x:
         do sz <- guess-sizeof x.opnd1 x.opnd2;
            a <- write sz x.opnd1;
            b <- read sz x.opnd1;
            c <- read sz x.opnd2;
            t <- mktemp;
            add sz t b c;
            emit-add-flags sz (var t) b c;
            commit sz a (var t)
         end

    | CMP x:
         do sz <- guess-sizeof x.opnd1 x.opnd2;
            a <- write sz x.opnd1;
            b <- read sz x.opnd1;
            c <- read sz x.opnd2;
            t <- mktemp;
            sub sz t b c;
            emit-sub-flags sz (var t) b c
         end

    | MOV x:   
         do sz <- guess-sizeof x.opnd1 x.opnd2;
            a <- write sz x.opnd1;
            b <- read sz x.opnd1;
            commit sz a b
         end

    | SHL x:
         do sz <- guess-sizeof1 x.opnd1;
            szOp2 <- guess-sizeof1 x.opnd2;
            a <- write sz x.opnd1;
            b <- read sz x.opnd1;
            c <- read szOp2 x.opnd2;

            ## Temporary variables:
            t1 <- mktemp;
            t2 <- mktemp;
            cnt <- mktemp;
            cntIsZero <- mktemp;
            cntIsOne <- mktemp;
            af <- fAF;
            ov <- fOF;
            cf <- fCF;
            eq <- fEQ;
            mask <- const
               (case sz of
                   8: 31
                 | 16: 31
                 | 32: 31
                 | 64: 63
                end);
            zer0 <- const 0;
            one <- const 1;

            ## Instruction semantics:
            setflag <- mklabel;
            exit <- mklabel;
            nop <- mklabel;
            convert sz cnt szOp2 c;
            andb sz cnt (var cnt) mask;
            cmpeq sz cntIsZero (var cnt) zer0;
            ifgotolabel (var cntIsZero) nop; 
            shl sz t1 b (/SUB (var cnt) one);
            mov 1 cf (var (t1 /+ (sz - 1)));
            shl sz t2 b (var cnt);
            cmpeq sz cntIsOne (var cnt) one;
            ifgotolabel (var cntIsOne) setflag;
            undef 1 ov; 
            gotolabel exit;
            label setflag;
            xorb 1 ov (var cf) (var (t2 /+ (sz - 1)));
            label exit;
            undef 1 af;
            commit sz a (var t2);
            label nop;
            cmpeq sz eq b zer0
         end

    | SUB x:
         do sz <- guess-sizeof x.opnd1 x.opnd2;
            a <- write sz x.opnd1;
            b <- read sz x.opnd1;
            c <- read sz x.opnd2;
            t <- mktemp;
            sub sz t b c;
            emit-sub-flags sz (var t) b c;
            commit sz a (var t)
         end

    | JE x:
         do sz <- guess-sizeof-flow x.opnd1;
            target <- read-flow sz x.opnd1;
            eq <- fEQ;
            ifgoto (var eq) sz target 
         end

    | JB x:
         do sz <- guess-sizeof-flow x.opnd1;
            target <- read-flow sz x.opnd1;
            cf <- fCF;
            ifgoto (var cf) sz target
         end

    | JC x:
         do sz <- guess-sizeof-flow x.opnd1;
            target <- read-flow sz x.opnd1;
            cf <- fCF;
            ifgoto (var cf) sz target
         end

    | JMP x:
         do sz <- guess-sizeof-flow x.opnd1;
            target <- read-flow sz x.opnd1;
            on3 <- const 1;
            ifgoto on3 sz target
         end

    | CDQE x:
          do a <- return (semantic-register-of RAX);
             movsx 64 a 32 (var a)
          end

    | PUSH x:
          #FIXME: This ignores many details of {PUSH}
          do sz <- guess-sizeof1 x.opnd1;
             a <- read sz x.opnd1;
             sp <- return (semantic-register-of RSP);
             eight <- const 8;
             sub 64 sp (var sp) eight;
             store {size=64,address=var sp} a
          end

   end

val translate insn = 
   do update@{stack=SEM_NIL,tmp=0,lab=0};
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
