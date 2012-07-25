# vim:filetype=sml:ts=3:sw=3:expandtab

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
 | SEM_IF_GOTO of {cond: sem_linear, size:int, target: sem_linear}
 | SEM_CALL of {cond: sem_linear, size:int, target: sem_address}
 | SEM_RETURN of {cond: sem_linear, size:int, target: sem_address}

type sem_stmts = 
   SEM_CONS of {hd:sem_stmt, tl:sem_stmts}
 | SEM_NIL

type sem_writeback =
   SEM_WRITE_VAR of {size: int, id: sem_var}
 | SEM_WRITE_MEM of {size: int, address: sem_linear}

val rreil-sizeOf op =
   case op of
      SEM_LIN x: x.size
    | SEM_BSWAP x: x.size 
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
   return l
end

val /ASSIGN a b = SEM_ASSIGN{lhs=a,rhs=b}
val /LOAD sz a b = SEM_LOAD{lhs=a,size=sz,address=b}
val /STORE a b = SEM_STORE{address=a,rhs=b}
val /ADD a b = SEM_LIN_ADD{opnd1=a,opnd2=b}
val /SUB a b = SEM_LIN_SUB{opnd1=a,opnd2=b}
val /LABEL l = SEM_LABEL{id=l}
val /IFGOTOLABEL c l = SEM_IF_GOTO_LABEL{cond=c,label=l}
val /IFGOTO c sz t = SEM_IF_GOTO{cond=c,size=sz,target=t}
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
val ifgoto c sz addr = push (/IFGOTO c sz addr)

val const i = return (SEM_LIN_IMM{imm=i})

val /+ x offs = @{offset=offs} x
val /++ x offs = @{offset= $offset x + offs} x
