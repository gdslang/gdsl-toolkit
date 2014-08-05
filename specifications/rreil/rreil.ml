# vim:ai:filetype=sml:ts=3:sw=3:expandtab
export rreil-stmts-count : (sem_stmt_list) -> int

type sem_id =
   FLOATING_FLAGS
 | VIRT_T of int

val sizeof-id id = case id of
   FLOATING_FLAGS: 64
end

type sem_exception =
   SEM_DIVISION_BY_ZERO

type sem_arity1 = {opnd1:sem_linear}
type sem_arity2 = {opnd1:sem_linear, opnd2:sem_linear}

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
 | SEM_SEXPR_CMP of sem_expr_cmp
 | SEM_SEXPR_ARB

type sem_expr_cmp =
   SEM_CMPEQ of sem_arity2
 | SEM_CMPNEQ of sem_arity2
 | SEM_CMPLES of sem_arity2
 | SEM_CMPLEU of sem_arity2
 | SEM_CMPLTS of sem_arity2
 | SEM_CMPLTU of sem_arity2

type sem_expr =
   SEM_SEXPR of sem_sexpr
 | SEM_MUL of sem_arity2
 | SEM_DIV of sem_arity2
 | SEM_DIVS of sem_arity2
 | SEM_MOD of sem_arity2
 | SEM_MODS of sem_arity2
 | SEM_SHL of sem_arity2
 | SEM_SHR of sem_arity2
 | SEM_SHRS of sem_arity2
 | SEM_AND of sem_arity2
 | SEM_OR of sem_arity2
 | SEM_XOR of sem_arity2
 | SEM_SX of {fromsize:int, opnd1:sem_linear}
 | SEM_ZX of {fromsize:int, opnd1:sem_linear}

type sem_varl = {id:sem_id, offset:int, size:int}

type sem_varl_list =
   SEM_VARLS_CONS of {hd:sem_varl, tl:sem_varl_list}
 | SEM_VARLS_NIL

type sem_flop =
   SEM_FADD
 | SEM_FSUB
 | SEM_FMUL

type sem_stmt =
   SEM_ASSIGN of {size:int, lhs:sem_var, rhs:sem_expr} #size denotes the size of right-hand side operands
 | SEM_LOAD of {size:int, lhs:sem_var, address:sem_address}
 | SEM_STORE of {size:int, address:sem_address, rhs:sem_linear}
 | SEM_ITE of {cond:sem_sexpr, then_branch:sem_stmt_list, else_branch:sem_stmt_list}
 | SEM_WHILE of {cond:sem_sexpr, body:sem_stmt_list}
 | SEM_CBRANCH of {cond:sem_sexpr, target-true:sem_address, target-false:sem_address}
 | SEM_BRANCH of {hint:branch_hint, target:sem_address}
 | SEM_FLOP of {op:sem_flop, flags:sem_var, lhs:sem_varl, rhs:sem_varl_list}
 | SEM_PRIM of {op:string, lhs:sem_varl_list, rhs:sem_varl_list}
 | SEM_THROW of sem_exception

type branch_hint =
    HINT_JUMP
  | HINT_CALL
  | HINT_RET

type sem_stmt_list =
   SEM_CONS of {hd:sem_stmt, tl:sem_stmt_list}
 | SEM_NIL

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

val at-offset v o = @{offset=o} v
val var x = SEM_LIN_VAR x
val varl sz x = @{size=sz}x
val lin-sum x y = SEM_LIN_ADD {opnd1=x, opnd2=y}
val address sz addr = {size=sz, address=addr}

val varl-from-var sz v = @{size=sz}v

val varls-none = SEM_VARLS_NIL
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

val /ASSIGN sz a b = SEM_ASSIGN{size=sz,lhs=a,rhs=b}
val /LOAD sz a b = SEM_LOAD{size=sz,lhs=a,address=b}
val /STORE sz a b = SEM_STORE{size=sz,address=a,rhs=b}
val /ADD a b = SEM_LIN_ADD{opnd1=a,opnd2=b}
val /SUB a b = SEM_LIN_SUB{opnd1=a,opnd2=b}
val /ITE c t e = SEM_ITE{cond=c,then_branch=t,else_branch=e}
val /WHILE c b = SEM_WHILE{cond=c,body=b}
val /BRANCH hint address = SEM_BRANCH{hint=hint,target=address}
val /CBRANCH cond target-true target-false = SEM_CBRANCH{cond=cond,target-true=target-true,target-false=target-false}
val /BFLOP sz op r a b = SEM_FLOP{op=op,flags={id=FLOATING_FLAGS, offset=0},lhs=varl-from-var sz r,rhs=varls-more (varl-from-var sz a) (varls-one (varl-from-var sz b))}
val /PRIM op lhs rhs = SEM_PRIM{op=op,lhs=lhs,rhs=rhs}
val /THROW exception = SEM_THROW exception

val push insn = let
  val push-inner insn = do
    tl <- query $stack;
    update @{stack=SEM_CONS{hd=insn,tl=tl}}
  end
in
  case insn of
     SEM_ASSIGN s: if s.size > 0 then
         push-inner insn
       else
         return void
   | _: push-inner insn
  end
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

val mov sz a b = push (/ASSIGN sz a (SEM_SEXPR (SEM_SEXPR_LIN b)))
val undef sz a = push (/ASSIGN sz a (SEM_SEXPR SEM_SEXPR_ARB))
val load sz a psz b = push (/LOAD sz a {size=psz,address=b})
val store sz a b = push (/STORE sz a b)
val add sz a b c = push (/ASSIGN sz a (SEM_SEXPR (SEM_SEXPR_LIN (/ADD b c))))
val sub sz a b c = push (/ASSIGN sz a (SEM_SEXPR (SEM_SEXPR_LIN (/SUB b c))))
val andb sz a b c = push (/ASSIGN sz a (SEM_AND{opnd1=b,opnd2=c}))
val orb sz a b c = push (/ASSIGN sz a (SEM_OR{opnd1=b,opnd2=c}))
val xorb sz a b c = push (/ASSIGN sz a (SEM_XOR{opnd1=b,opnd2=c}))
val mul sz a b c = push (/ASSIGN sz a (SEM_MUL{opnd1=b,opnd2=c}))
val div sz a b c = push (/ASSIGN sz a (SEM_DIV{opnd1=b,opnd2=c}))
val divs sz a b c = push (/ASSIGN sz a (SEM_DIVS{opnd1=b,opnd2=c}))
val shl sz a b c = push (/ASSIGN sz a (SEM_SHL{opnd1=b,opnd2=c}))
val shr sz a b c = push (/ASSIGN sz a (SEM_SHR{opnd1=b,opnd2=c}))
val shrs sz a b c = push (/ASSIGN sz a (SEM_SHRS{opnd1=b,opnd2=c}))
val mod sz a b c = push (/ASSIGN sz a (SEM_MOD{opnd1=b,opnd2=c}))
val mods sz a b c = push (/ASSIGN sz a (SEM_MODS{opnd1=b,opnd2=c}))
val movsx szA a szB b = push (/ASSIGN szA a (SEM_SX{fromsize=szB,opnd1=b}))
val movzx szA a szB b = push (/ASSIGN szA a (SEM_ZX{fromsize=szB,opnd1=b}))
val convert szA a szB b = push (/ASSIGN szA a (SEM_ZX{fromsize=szB,opnd1=b}))
val cmpeq sz f a b = push (/ASSIGN sz f (SEM_SEXPR (SEM_SEXPR_CMP (SEM_CMPEQ{opnd1=a,opnd2=b}))))
val cmpneq sz f a b = push (/ASSIGN sz f (SEM_SEXPR (SEM_SEXPR_CMP (SEM_CMPNEQ{opnd1=a,opnd2=b}))))
val cmples sz f a b = push (/ASSIGN sz f (SEM_SEXPR (SEM_SEXPR_CMP (SEM_CMPLES{opnd1=a,opnd2=b}))))
val cmpleu sz f a b = push (/ASSIGN sz f (SEM_SEXPR (SEM_SEXPR_CMP (SEM_CMPLEU{opnd1=a,opnd2=b}))))
val cmplts sz f a b = push (/ASSIGN sz f (SEM_SEXPR (SEM_SEXPR_CMP (SEM_CMPLTS{opnd1=a,opnd2=b}))))
val cmpltu sz f a b = push (/ASSIGN sz f (SEM_SEXPR (SEM_SEXPR_CMP (SEM_CMPLTU{opnd1=a,opnd2=b}))))
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
val throw exception = push (/THROW exception)

val unpack-lin sz o = case o of
   SEM_LIN_VAR v: return v
 | _: do
     t <- mktemp;
     mov sz t o;
     return t
   end
end

type sem_lins =
   SEM_LINS_CONS of {hd:sem_linear, tl:sem_lins}
 | SEM_LINS_NIL

val lins-none = SEM_LINS_NIL
val lins-one l = SEM_LINS_CONS {hd=l, tl=SEM_LINS_NIL}
val lins-more l lins = SEM_LINS_CONS {hd=l, tl=lins}

val bflop sz op r a b = let
  val bflop-inner = do
    a <- unpack-lin sz a;
    b <- unpack-lin sz b;

    push (/BFLOP sz op r a b)
  end
in
  with-subscope bflop-inner
end

val prim-generic op lhs rhs = push (/PRIM (string-from-rope-lit op) lhs rhs)

val prim sz op lhs rhs = let
  val unpack lins = case lins of
     SEM_LINS_CONS c: do
       hd <- unpack-lin sz c.hd;
       tl <- unpack c.tl;
       return (SEM_VARLS_CONS {hd=varl-from-var sz hd, tl=tl})
     end
   | SEM_LINS_NIL: return SEM_VARLS_NIL
  end
  
  val prim-inner = do
    lhs <- unpack lhs;
    rhs <- unpack rhs;

    push (/PRIM (string-from-rope-lit op) lhs rhs)
  end
in
  with-subscope prim-inner
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

val /ges sz a b = do
  t <- mktemp;
  cmplts sz t a b;
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

val /les sz a b = do
  t <- mktemp;
  cmples sz t a b;
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

val rreil-stmts-count stmts = let
  val count c stmts = case stmts of
    SEM_CONS x: count (1 + (case x.hd of
        SEM_ITE i: (count c i.then_branch) + (count 0 i.else_branch)
      | SEM_WHILE w: count c w.body
      | _: c
    end)) x.tl
   | SEM_NIL: c
  end
in
  count 0 stmts
end

val rreil-ltid? a b =
   let
      val ltf? a b =
         case b of
            VIRT_T x: '0'
          | _ : index a < index b
         end
   in
      case a of
         VIRT_T x:
            case b of
               VIRT_T y: x < y
             | _ : '1'
            end
       | _: ltf? a b
      end
   end

val rreil-ltvar? a b = if rreil-ltid? a.id b.id then
  true
else
  a.offset < b.offset

val rreil-ltvarl? a b = if rreil-ltvar? a b then
  true
else
  a.size < b.size
