# vim:filetype=sml:ts=3:sw=3:expandtab

export = translate

type sem_id =
   ARCH_R of int
 | VIRT_EQ  # ==
 | VIRT_NEQ # /=
 | VIRT_LES # <=s
 | VIRT_LEU # <=u
 | VIRT_LTS # <s
 | VIRT_LTU # <u
 | VIRT_T of int

type sem_arity1 = {size: int, opnd1: sem_linear}
type sem_arity2 = {size: int, opnd1: sem_linear, opnd2: sem_linear}
type sem_cmp = {size: int, opnd1: sem_linear, opnd2: sem_linear}

type sem_address = {size: int, address: sem_linear}
type sem_var = {id:sem_id, offset:int}

type sem_linear =
   SEM_LIN_VAR of sem_var
 | SEM_LIN_IMM of {imm:int}
 | SEM_LIN_ADD of {opnd1: sem_linear, opnd2: sem_linear}
 | SEM_LIN_SUB of {opnd1: sem_linear, opnd2: sem_linear}
 | SEM_LIN_SCALE of {imm:int, opnd:sem_linear}

type sem_op =
   SEM_LIN of sem_arity1
 | SEM_BSWAP of sem_arity1 
 | SEM_MUL of sem_arity2
 | SEM_DIV of sem_arity2
 | SEM_DIVS of sem_arity2
 | SEM_MOD of sem_arity2
 | SEM_SHL of sem_arity2
 | SEM_SHR of sem_arity2
 | SEM_SHRS of sem_arity2
 | SEM_AND of sem_arity2
 | SEM_OR of sem_arity2
 | SEM_XOR of sem_arity2
 | SEM_SX of {size: int, fromsize: int, opnd1: sem_linear}
 | SEM_ZX of {size: int, fromsize: int, opnd1: sem_linear}
 | SEM_CMPEQ of sem_cmp
 | SEM_CMPNEQ of sem_cmp
 | SEM_CMPLES of sem_cmp
 | SEM_CMPLEU of sem_cmp
 | SEM_CMPLTS of sem_cmp
 | SEM_CMPLTU of sem_cmp
 | SEM_ARB of {size: int}

type sem_stmt = 
   SEM_ASSIGN of {lhs: sem_var, rhs: sem_op}
 | SEM_LOAD of {lhs: sem_var, size: int, address: sem_address}
 | SEM_STORE of {address: sem_address, rhs: sem_op}
 | SEM_LABEL of {id: int}
 | SEM_IF_GOTO_LABEL of {cond:sem_linear, label: int}
 | SEM_IF_GOTO of {cond: sem_linear, size:int, target: sem_address}
 | SEM_CALL of {cond: sem_linear, size:int, target: sem_address}
 | SEM_RETURN of {cond: sem_linear, size:int, target: sem_address}

type sem_stmts = 
   SEM_CONS of {hd:sem_stmt, tl:sem_stmts}
 | SEM_NIL

type sem_writeback =
   SEM_WRITE_VAR of {size: int, id: sem_var}
 | SEM_WRITE_MEM of {size: int, address: sem_linear}

val revSeq stmts =
   let
      val lp stmt acc =
         case stmt of
            SEM_NIL: acc
          | SEM_CONS x: lp x.tl (SEM_CONS{hd=x.hd, tl=acc})
         end
   in
      lp stmts SEM_NIL
   end

val resultSize op =
   case op of
      SEM_CMPLES x : 1
    | SEM_MUL x : x.size
   end

val operandSize op =
   case op of
      SEM_CMPLES x : x.size
    | x : resultSize op
   end

val guessSizeOf dst/src1 src2 = 
   case dst/src1 of
      REG r: return ($size (semanticRegisterOf r))
    | MEM x: return x.sz
    | _:
         case src2 of
            REG r: return ($size (semanticRegisterOf r))
          | MEM x: return x.sz
         end
   end

val sizeOf op =
   case op of
      REG r: return ($size (semanticRegisterOf r))
    | MEM x: return x.sz
    | IMM8 i: return (8)
    | IMM16 i: return (16)
    | IMM32 i: return (32)
    | IMM64 i: return (64)
   end

val var//0 x = {id=x,offset=0}
val var x = SEM_LIN_VAR x

val mktemp = do
   t <- query $tmp;
   t' <- return (t + 1);
   update @{tmp=t'};
   return {id=VIRT_T t,offset=0}
end

val mklabel = do
   l <- query $lab;
   l' <- return (l + 1);
   update @{lab=l'};
   return (l)
end

val /ASSIGN a b = SEM_ASSIGN{lhs=a,rhs=b}
val /LOAD sz a b = SEM_LOAD{lhs=a,size=sz,address=b}
val /STORE a b = SEM_STORE{address=a,rhs=b}
val /ADD a b = SEM_LIN_ADD{opnd1=a,opnd2=b}
val /SUB a b = SEM_LIN_SUB{opnd1=a,opnd2=b}
val /LABEL l = SEM_LABEL{id=l}
val /IFGOTOLABEL c l = SEM_IF_GOTO_LABEL{cond=c,label=l}
val /GOTOLABEL l = SEM_IF_GOTO_LABEL{cond=SEM_LIN_IMM{imm=1},label=l}

val push insn = do
   tl <- query $stack;
   update @{stack=SEM_CONS{hd=insn,tl=tl}}
end

val mov sz a b = push (/ASSIGN a (SEM_LIN{size=sz,opnd1=b}))
val undef sz a = push (/ASSIGN a (SEM_ARB{size=sz}))
val load sz a psz b = push (/LOAD sz a {size=psz,address=b})
val store a b = push (/STORE a b)
val add sz a b c = push (/ASSIGN a (SEM_LIN{size=sz,opnd1= /ADD b c}))
val sub sz a b c = push (/ASSIGN a (SEM_LIN{size=sz,opnd1= /SUB b c}))
val andb sz a b c = push (/ASSIGN a (SEM_AND{size=sz,opnd1=b,opnd2=c}))
val orb sz a b c = push (/ASSIGN a (SEM_OR{size=sz,opnd1=b,opnd2=c}))
val xorb sz a b c = push (/ASSIGN a (SEM_XOR{size=sz,opnd1=b,opnd2=c}))
val mul sz a b c = push (/ASSIGN a (SEM_MUL{size=sz,opnd1=b,opnd2=c}))
val div sz a b c = push (/ASSIGN a (SEM_DIV{size=sz,opnd1=b,opnd2=c}))
val divs sz a b c = push (/ASSIGN a (SEM_DIVS{size=sz,opnd1=b,opnd2=c}))
val shl sz a b c = push (/ASSIGN a (SEM_SHL{size=sz,opnd1=b,opnd2=c}))
val shr sz a b c = push (/ASSIGN a (SEM_SHR{size=sz,opnd1=b,opnd2=c}))
val shrs sz a b c = push (/ASSIGN a (SEM_SHRS{size=sz,opnd1=b,opnd2=c}))
val bswap sz a b = push (/ASSIGN a (SEM_BSWAP{size=sz,opnd1=b}))
val movsx szA a szB b = push (/ASSIGN a (SEM_SX{size=szA,fromsize=szB,opnd1=b}))
val movzx szA a szB b = push (/ASSIGN a (SEM_ZX{size=szA,fromsize=szB,opnd1=b}))
val convert szA a szB b = push (/ASSIGN a (SEM_ZX{size=szA,fromsize=szB,opnd1=b}))
val cmpeq sz f a b = push (/ASSIGN f (SEM_CMPEQ{size=sz,opnd1=a,opnd2=b}))
val cmpneq sz f a b = push (/ASSIGN f (SEM_CMPNEQ{size=sz,opnd1=a,opnd2=b}))
val cmples sz f a b = push (/ASSIGN f (SEM_CMPLES{size=sz,opnd1=a,opnd2=b}))
val cmpleu sz f a b = push (/ASSIGN f (SEM_CMPLEU{size=sz,opnd1=a,opnd2=b}))
val cmplts sz f a b = push (/ASSIGN f (SEM_CMPLTS{size=sz,opnd1=a,opnd2=b}))
val cmpltu sz f a b = push (/ASSIGN f (SEM_CMPLTU{size=sz,opnd1=a,opnd2=b}))
val label l = push (/LABEL l)
val ifgotolabel c l = push (/IFGOTOLABEL c l)
val gotolabel l = push (/GOTOLABEL l)

val const i = return (SEM_LIN_IMM{imm=i})

val /+ x offs = @{offset=offs} x
val /++ x offs = @{offset= $offset x + offs} x

val convWith conv sz x = 
   let
      val convImm conv x = return (SEM_LIN_IMM{imm=conv x})
      
      val convReg x = return (SEM_LIN_VAR(semanticRegisterOf x))

      val convSum conv sz x = 
         do op1 <- convWith conv sz x.a;
            op2 <- convWith conv sz x.b;
            return
               (SEM_LIN_ADD
                  {opnd1=op1,
                   opnd2=op2})
         end

      val convScale conv sz x =
         do op <- convWith conv sz x.opnd;
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

      val convMem x = convWith sx x.psz x.opnd
   in
      case x of
         IMM8 x: convImm conv x
       | IMM16 x: convImm conv x
       | IMM32 x: convImm conv x
       | IMM64 x: convImm conv x
       | REG x: convReg x
       | SUM x: convSum conv sz x
       | SCALE x: convScale conv sz x
       | MEM x:
            do t <- mktemp;
               address <- convMem x;
               load sz t x.psz address;
               return (var t)
            end
      end
   end

val read sz x = convWith zx sz x

val write sz x =
   case x of
      MEM x:
         do address <- convWith sx x.psz x.opnd;
            return
               (SEM_WRITE_MEM
                  {size= x.psz,
                   address=address})
         end
    | REG x:
         do id <- return (semanticRegisterOf x);
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

val fOF = return (var//0 ARCH_R ~1) # OF
val fSF = return (var//0 ARCH_R ~2) # SF
val fAF = return (var//0 ARCH_R ~3) # AF

val zero = return (SEM_LIN_IMM{imm=0})

val emitAddFlags sz a b c =
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

val emitSubFlags sz a b c = 
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
         do sz <- guessSizeOf x.opnd1 x.opnd2;
            a <- write sz x.opnd1;
            b <- read sz x.opnd1;
            c <- read sz x.opnd2;
            t <- mktemp;
            add sz t b c;
            emitAddFlags sz (var t) b c;
            commit sz a (var t)
         end

    | CMP x:
         do sz <- guessSizeOf x.opnd1 x.opnd2;
            a <- write sz x.opnd1;
            b <- read sz x.opnd1;
            c <- read sz x.opnd2;
            t <- mktemp;
            sub sz t b c;
            emitSubFlags sz (var t) b c
         end

    | MOV x:   
         do sz <- guessSizeOf x.opnd1 x.opnd2;
            a <- write sz x.opnd1;
            b <- read sz x.opnd1;
            commit sz a b
         end

    | SHL x:
         do sz <- sizeOf x.opnd1;
            szOp2 <- sizeOf x.opnd2;
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
            exit <- mklabel;
            setflag <- mklabel;
            convert sz cnt szOp2 c;
            andb sz cnt (var cnt) mask;
            cmpeq sz cntIsZero (var cnt) zer0;
            ifgotolabel (var cntIsZero) exit; 
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
            commit sz a (var t2)
         end

    | SUB x:
         do sz <- guessSizeOf x.opnd1 x.opnd2;
            a <- write sz x.opnd1;
            b <- read sz x.opnd1;
            c <- read sz x.opnd2;
            t <- mktemp;
            sub sz t b c;
            emitSubFlags sz (var t) b c;
            commit sz a (var t)
         end
   end

val translate insn = 
   do update@{stack=SEM_NIL,tmp=0,lab=0};
      semantics insn;
      stack <- query $stack;
      return (revSeq stack)
   end

