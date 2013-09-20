# vim:filetype=sml:ts=3:sw=3:expandtab
export =

type sem_id =
   FLOATING_FLAGS
 | VIRT_T of int

type sem_arity1 = {size:int, opnd1:sem_linear}
type sem_arity2 = {size:int, opnd1:sem_linear, opnd2:sem_linear}
type sem_cmp = {size:int, opnd1:sem_linear, opnd2:sem_linear}

type sem_address = {size:int, address: sem_linear}
type sem_var = {id:sem_id, offset:int}

type sem_linear =
   SEM_LIN_VAR of sem_var
 | SEM_LIN_IMM of {const:int}
 | SEM_LIN_ADD of {opnd1:sem_linear, opnd2:sem_linear}
 | SEM_LIN_SUB of {opnd1:sem_linear, opnd2:sem_linear}
 | SEM_LIN_SCALE of {const:int, opnd:sem_linear}

 type sem_sexpr =
   SEM_SEXPR_LIN of sem_linear
 | SEM_SEXPR_CMP of sem_op_cmp

type sem_op_cmp =
   SEM_CMPEQ of sem_cmp
 | SEM_CMPNEQ of sem_cmp
 | SEM_CMPLES of sem_cmp
 | SEM_CMPLEU of sem_cmp
 | SEM_CMPLTS of sem_cmp
 | SEM_CMPLTU of sem_cmp

type sem_expr =
   SEM_SEXPR of {size:int, opnd1:sem_sexpr}
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
 | SEM_SX of {size:int, fromsize:int, opnd1:sem_linear}
 | SEM_ZX of {size:int, fromsize:int, opnd1:sem_linear}
 | SEM_ARB of {size:int}

type sem_varl = {id:sem_id, offset:int, size:int}

type sem_varls =
   SEM_VARLS_CONS of {hd:sem_varl, tl:sem_varls}
 | SEM_VARLS_NIL

type sem_flop =
   SEM_FADD
 | SEM_FSUB
 | SEM_FMUL

type sem_stmt =
   SEM_ASSIGN of {lhs:sem_var, rhs:sem_expr}
 | SEM_LOAD of {lhs:sem_var, size:int, address:sem_address}
 | SEM_STORE of {address:sem_address, rhs:sem_expr}
 | SEM_ITE of {cond:sem_sexpr, then_branch:sem_stmts, else_branch:sem_stmts}
 | SEM_WHILE of {cond:sem_sexpr, body:sem_stmts}
 | SEM_CBRANCH of {cond:sem_sexpr, target-true:sem_address, target-false:sem_address}
 | SEM_BRANCH of {hint:branch_hint, target:sem_address}
 | SEM_FLOP of {op:sem_flop, flags:sem_var, lhs:sem_varl, rhs:sem_varls}
 | SEM_PRIM of {op:string, lhs:sem_varls, rhs:sem_varls}

type branch_hint =
    HINT_JUMP
  | HINT_CALL
  | HINT_RET

type sem_stmts =
   SEM_CONS of {hd:sem_stmt, tl:sem_stmts}
 | SEM_NIL

val rreil-sizeOf op =
   case op of
      SEM_SEXPR x: x.size
    | SEM_MUL x: x.size
    | SEM_DIV x: x.size
    | SEM_DIVS x: x.size
    | SEM_MOD x: x.size
    | SEM_SHL x: x.size
    | SEM_SHR x: x.size
    | SEM_SHRS x: x.size
    | SEM_AND x: x.size
    | SEM_OR x: x.size
    | SEM_XOR x: x.size
    | SEM_SX x: x.size
    | SEM_ZX x: x.size
    | SEM_ARB x: x.size
   end

val rreil-stmts-rev stmts =
   let
      val lp stmt acc =
         case stmt of
            SEM_NIL: acc
          | SEM_CONS x: lp x.tl (SEM_CONS{hd=x.hd, tl=acc})
         end
   in
      lp stmts SEM_NIL
   end

val _var x = {id=x,offset=0}
val _var x _offset o = {id=x, offset=o}
val at-offset v o = @{offset=o} v
val var x = SEM_LIN_VAR x
val lin-sum x y = SEM_LIN_ADD {opnd1=x, opnd2=y}
val lin sz l = SEM_SEXPR {size=sz, opnd1=SEM_SEXPR_LIN l}
val address sz addr = {size=sz, address=addr}

val varl-from-var sz v = @{size=sz}v

val varls-one v = SEM_VARLS_CONS {hd=v, tl=SEM_VARLS_NIL}
val varls-more v tl = SEM_VARLS_CONS {hd=v, tl=tl}

type temp_list =
   TLIST_CONS of {hd:sem_var, tl:temp_list}
 | TLIST_NIL

val temp_id x =
  case x of
     VIRT_T v: v
  end

val mktemp = do
  t <- query $tmp;
  t' <- return (t + 1);
  update @{tmp=t'};
  return {id=VIRT_T t,offset=0}
  #l <- query $tmp;
  #t' <- return (
  #  case l of
  #     TLIST_CONS x: _var (VIRT_T ((temp_id x.hd.id) + 1))
  #   | TLIST_NIL: _var (VIRT_T 0)
  #  end
  #);
  #l' <- return (TLIST_CONS {hd=t', tl=l});
  #update @{tmp=l'};
  #return t'
end

val with-subscope m = do
  l <- query $tmp;
  ret <- m;
  update @{tmp=l};
  return ret
end

val mklabel = do
   l <- query $lab;
   l' <- return (l + 1);
   update @{lab=l'};
   return l
end

val /ASSIGN a b = SEM_ASSIGN{lhs=a,rhs=b}
val /LOAD sz a b = SEM_LOAD{lhs=a,size=sz,address=b}
val /STORE a b = SEM_STORE{address=a,rhs=b}
val /ADD a b = SEM_LIN_ADD{opnd1=a,opnd2=b}
val /SUB a b = SEM_LIN_SUB{opnd1=a,opnd2=b}
val /ITE c t e = SEM_ITE{cond=c,then_branch=t,else_branch=e}
val /WHILE c b = SEM_WHILE{cond=c,body=b}
val /BRANCH hint address =SEM_BRANCH{hint=hint,target=address}
val /CBRANCH cond target-true target-false = SEM_CBRANCH{cond=cond,target-true=target-true,target-false=target-false}
val /BFLOP sz op r a b = SEM_FLOP{op=op,flags=_var FLOATING_FLAGS,lhs=varl-from-var sz r,rhs=varls-more (varl-from-var sz a) (varls-one (varl-from-var sz b))}

val push insn = do
   tl <- query $stack;
   update @{stack=SEM_CONS{hd=insn,tl=tl}}
end

val pop-all = do
  head <- query $stack;
  update @{stack=SEM_NIL};
  return head
end

#val connect-tail stmt tail =
#  case stmt of
#     SEM_NIL: tail
#   | SEM_CONS x: SEM_CONS{hd=x.hd,tl=(connect-tail x.tl tail)}
#  end

#val concat stmt = do
#  tail <- query $stack;
#  update @{stack=(connect-tail stmt tail)}
#end

val stack-set stmt = do
   update @{stack=stmt}
end

val mov sz a b = push (/ASSIGN a (SEM_SEXPR {size=sz, opnd1=(SEM_SEXPR_LIN b)}))
val undef sz a = push (/ASSIGN a (SEM_ARB{size=sz}))
val load sz a psz b = push (/LOAD sz a {size=psz,address=b})
val store a b = push (/STORE a b)
val add sz a b c = push (/ASSIGN a (SEM_SEXPR {size=sz, opnd1=SEM_SEXPR_LIN (/ADD b c)}))
val sub sz a b c = push (/ASSIGN a (SEM_SEXPR {size=sz, opnd1=SEM_SEXPR_LIN (/SUB b c)}))
val andb sz a b c = push (/ASSIGN a (SEM_AND{size=sz,opnd1=b,opnd2=c}))
val orb sz a b c = push (/ASSIGN a (SEM_OR{size=sz,opnd1=b,opnd2=c}))
val xorb sz a b c = push (/ASSIGN a (SEM_XOR{size=sz,opnd1=b,opnd2=c}))
val mul sz a b c = push (/ASSIGN a (SEM_MUL{size=sz,opnd1=b,opnd2=c}))
val div sz a b c = push (/ASSIGN a (SEM_DIV{size=sz,opnd1=b,opnd2=c}))
val divs sz a b c = push (/ASSIGN a (SEM_DIVS{size=sz,opnd1=b,opnd2=c}))
val shl sz a b c = push (/ASSIGN a (SEM_SHL{size=sz,opnd1=b,opnd2=c}))
val shr sz a b c = push (/ASSIGN a (SEM_SHR{size=sz,opnd1=b,opnd2=c}))
val shrs sz a b c = push (/ASSIGN a (SEM_SHRS{size=sz,opnd1=b,opnd2=c}))
val modulo sz a b c = push (/ASSIGN a (SEM_MOD{size=sz,opnd1=b,opnd2=c}))
val movsx szA a szB b = push (/ASSIGN a (SEM_SX{size=szA,fromsize=szB,opnd1=b}))
val movzx szA a szB b = push (/ASSIGN a (SEM_ZX{size=szA,fromsize=szB,opnd1=b}))
val convert szA a szB b = push (/ASSIGN a (SEM_ZX{size=szA,fromsize=szB,opnd1=b}))
val cmpeq sz f a b = push (/ASSIGN f (SEM_SEXPR {size=sz, opnd1=(SEM_SEXPR_CMP (SEM_CMPEQ{size=sz,opnd1=a,opnd2=b}))}))
val cmpneq sz f a b = push (/ASSIGN f (SEM_SEXPR {size=sz, opnd1=(SEM_SEXPR_CMP (SEM_CMPNEQ{size=sz,opnd1=a,opnd2=b}))}))
val cmples sz f a b = push (/ASSIGN f (SEM_SEXPR {size=sz, opnd1=(SEM_SEXPR_CMP (SEM_CMPLES{size=sz,opnd1=a,opnd2=b}))}))
val cmpleu sz f a b = push (/ASSIGN f (SEM_SEXPR {size=sz, opnd1=(SEM_SEXPR_CMP (SEM_CMPLEU{size=sz,opnd1=a,opnd2=b}))}))
val cmplts sz f a b = push (/ASSIGN f (SEM_SEXPR {size=sz, opnd1=(SEM_SEXPR_CMP (SEM_CMPLTS{size=sz,opnd1=a,opnd2=b}))}))
val cmpltu sz f a b = push (/ASSIGN f (SEM_SEXPR {size=sz, opnd1=(SEM_SEXPR_CMP (SEM_CMPLTU{size=sz,opnd1=a,opnd2=b}))}))
val ite c t e = push (/ITE (SEM_SEXPR_LIN c) t e)
val while c b = push (/WHILE (SEM_SEXPR_LIN c) b)
val jump address = do
   update @{foundJump = '1'};
   push (/BRANCH HINT_JUMP address)
end
val call address = do
   update @{foundJump = '1'};
   push (/BRANCH HINT_CALL address)
end
val ret address = do
   update @{foundJump = '1'};
   push (/BRANCH HINT_RET address)
end
val cbranch cond target-true target-false = do
   update @{foundJump = '1'};
   push (/CBRANCH (SEM_SEXPR_LIN cond) target-true target-false)
end
val bflop sz op r a b = let
  val unpack o = case o of
     SEM_LIN_VAR v: return v
   | _: do
       t <- mktemp;
       mov sz t a;
       return t
     end
  end
  
  val bflop-inner = do
    a <- unpack a;
    b <- unpack b;

    push (/BFLOP sz op r a b)
  end
in
  with-subscope bflop-inner
end

val _if c _then a _else b = do
  c <- with-subscope c;
  case (int-from-linear c) of
     IO_NONE: do
       stack <- pop-all;
       with-subscope a;
       t <- pop-all;
       t <- return (rreil-stmts-rev t);
       with-subscope b;
       e <- pop-all;
       e <- return (rreil-stmts-rev e);
       stack-set stack;
       ite c t e
     end
   | IO_SOME i: case i of
        0: with-subscope b
      | _: with-subscope a
     end
  end
end

val _if c _then a = do
  _if c _then a _else (return void)
end

val _while c __ b = let
  val eval-cond ct = do
    cc <- c;
    mov 1 ct cc
  end
in do
  ct <- mktemp;
  with-subscope (eval-cond ct);
  stack <- pop-all;
  
  with-subscope b;

  with-subscope (eval-cond ct);
  body <- pop-all;
  body <- return (rreil-stmts-rev body);

  stack-set stack;
  while (var ct) body
end end

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

val /gts sz a b = do
  t <- mktemp;
  cmples sz t a b;
  xorb 1 t (var t) (imm 1);
  return (var t)
end

val /geu sz a b = do
  t <- mktemp;
  cmpltu sz t a b;
  xorb 1 t (var t) (imm 1);
  return (var t)
end

val /lts sz a b = do
  t <- mktemp;
  cmplts sz t a b;
  return (var t)
end

val /ltu sz a b = do
  t <- mktemp;
  cmpltu sz t a b;
  return (var t)
end

val /leu sz a b = do
  t <- mktemp;
  cmpleu sz t a b;
  return (var t)
end

val const i = return (SEM_LIN_IMM{const=i})
val imm i = SEM_LIN_IMM{const=i}

val /+ x offs = @{offset=offs} x
val /++ x offs = @{offset= $offset x + offs} x

val int-from-linear lin =
  case lin of
     SEM_LIN_VAR x: IO_NONE
   | SEM_LIN_IMM x: IO_SOME x.const
   | SEM_LIN_ADD x: io-binop addi (int-from-linear x.opnd1) (int-from-linear x.opnd2)
   | SEM_LIN_SUB x: io-binop subi (int-from-linear x.opnd1) (int-from-linear x.opnd2)
   | SEM_LIN_SCALE x: io-binop muli (IO_SOME x.const) (int-from-linear x.opnd)
  end

val int-from-sexpr sex =
  case sex of
     SEM_SEXPR_LIN lin: int-from-linear lin
   | SEM_SEXPR_CMP cmp: IO_NONE
  end
