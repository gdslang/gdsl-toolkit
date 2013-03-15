# vim:filetype=sml:ts=3:sw=3:expandtab

type sem_id =
   VIRT_EQ  # ==
 | VIRT_NEQ # /=
 | VIRT_LES # <=s
 | VIRT_LEU # <=u
 | VIRT_LTS # <s
 | VIRT_LTU # <u
 | VIRT_T of int

type sem_arity1 = {size:int, opnd1:sem_linear}
type sem_arity2 = {size:int, opnd1:sem_linear, opnd2:sem_linear}
type sem_cmp = {size:int, opnd1:sem_linear, opnd2:sem_linear}

type sem_address = {size:int, address: sem_linear}
type sem_var = {id:sem_id, offset:int}

type sem_linear =
   SEM_LIN_VAR of sem_var
 | SEM_LIN_IMM of {imm:int}
 | SEM_LIN_ADD of {opnd1:sem_linear, opnd2:sem_linear}
 | SEM_LIN_SUB of {opnd1:sem_linear, opnd2:sem_linear}
 | SEM_LIN_SCALE of {imm:int, opnd:sem_linear}

type sem_op =
   SEM_LIN of sem_arity1
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
 | SEM_CMPEQ of sem_cmp
 | SEM_CMPNEQ of sem_cmp
 | SEM_CMPLES of sem_cmp
 | SEM_CMPLEU of sem_cmp
 | SEM_CMPLTS of sem_cmp
 | SEM_CMPLTU of sem_cmp
 | SEM_ARB of {size:int}

type sem_stmt =
   SEM_ASSIGN of {lhs:sem_var, rhs:sem_op}
 | SEM_LOAD of {lhs:sem_var, size:int, address:sem_address}
 | SEM_STORE of {address:sem_address, rhs:sem_op}
 | SEM_ITE of {cond:sem_linear, then_branch:sem_stmts, else_branch:sem_stmts}
 | SEM_WHILE of {cond:sem_linear, body:sem_stmts}
 | SEM_CBRANCH of {cond:sem_linear, target-true:sem_address, target-false:sem_address}
 | SEM_BRANCH of {hint:branch_hint, target:sem_address}

type branch_hint =
    HINT_JUMP
  | HINT_CALL
  | HINT_RET

type sem_stmts =
   SEM_CONS of {hd:sem_stmt, tl:sem_stmts}
 | SEM_NIL

type sem_writeback =
   SEM_WRITE_VAR of {size:int, id:sem_var}
 | SEM_WRITE_MEM of {size:int, address:sem_linear, segment:seg_override}

val rreil-sizeOf op =
   case op of
      SEM_LIN x: x.size
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
    | SEM_CMPEQ x: 1
    | SEM_CMPNEQ x: 1
    | SEM_CMPLES x: 1
    | SEM_CMPLEU x: 1
    | SEM_CMPLTS x: 1
    | SEM_CMPLTU x: 1
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
val lin sz l = SEM_LIN {size=sz, opnd1=l}
val address sz addr = {size=sz, address=addr}

type temp_list =
   TLIST_CONS of {hd:sem_var, tl:temp_list}
 | TLIST_NIL

val temp_id x =
  case x of
     VIRT_T v: v
  end

val mktemp = do
  #t <- query $tmp;
  #t' <- return (t + 1);
  #update @{tmp=t'};
  #return {id=VIRT_T t,offset=0}
  l <- query $tmp;
  t' <- return (
    case l of
       TLIST_CONS x: _var (VIRT_T ((temp_id x.hd.id) + 1))
     | TLIST_NIL: _var (VIRT_T 0)
    end
  );
  l' <- return (TLIST_CONS {hd=t', tl=l});
  update @{tmp=l'};
  return t'
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
val modulo sz a b c = push (/ASSIGN a (SEM_MOD{size=sz,opnd1=b,opnd2=c}))
val movsx szA a szB b = push (/ASSIGN a (SEM_SX{size=szA,fromsize=szB,opnd1=b}))
val movzx szA a szB b = push (/ASSIGN a (SEM_ZX{size=szA,fromsize=szB,opnd1=b}))
val convert szA a szB b = push (/ASSIGN a (SEM_ZX{size=szA,fromsize=szB,opnd1=b}))
val cmpeq sz f a b = push (/ASSIGN f (SEM_CMPEQ{size=sz,opnd1=a,opnd2=b}))
val cmpneq sz f a b = push (/ASSIGN f (SEM_CMPNEQ{size=sz,opnd1=a,opnd2=b}))
val cmples sz f a b = push (/ASSIGN f (SEM_CMPLES{size=sz,opnd1=a,opnd2=b}))
val cmpleu sz f a b = push (/ASSIGN f (SEM_CMPLEU{size=sz,opnd1=a,opnd2=b}))
val cmplts sz f a b = push (/ASSIGN f (SEM_CMPLTS{size=sz,opnd1=a,opnd2=b}))
val cmpltu sz f a b = push (/ASSIGN f (SEM_CMPLTU{size=sz,opnd1=a,opnd2=b}))
val ite c t e = push (/ITE c t e)
val while c b = push (/WHILE c b)
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
   push (/CBRANCH cond target-true target-false)
end

val const i = return (SEM_LIN_IMM{imm=i})
val imm i = SEM_LIN_IMM{imm=i}

val /+ x offs = @{offset=offs} x
val /++ x offs = @{offset= $offset x + offs} x
