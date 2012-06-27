
export = translate

datatype sem_id =
   ARCH_RAX
 | ARCH_RBX
 | ARCH_RCX
 | VIRT_EQ
 | VIRT_LES
 | VIRT_LEU
 | VIRT_LTS
 | VIRT_LTU
 | VIRT_T of 8

datatype sem_var = SEM_VAR of {id:sem_id, offset:int}

datatype sem_linear =
   SEM_LIN_VAR of {var:sem_var, scale:int, tail:sem_linear}
 | SEM_LIN_IMM of {c:int, tail:sem_linear}
 | SEM_LIN_NIL

type sem_lin = {size:int, opnd1:sem_linear}
type sem_arity1 = {size:int, opnd1:sem_linear}
type sem_arity2 = {size:int, opnd1:sem_linear, opnd2:sem_linear}

datatype sem_op =
   SEM_MUL of sem_arity2
 | SEM_DIV of sem_arity2
 | SEM_ADD of sem_arity2
 | SEM_BSWAP of sem_arity1 
 | SEM_CMPEQ of sem_arity2
 | SEM_CMPLES of sem_arity2
 | SEM_CMPLEU of sem_arity2
 | SEM_CMPLTS of sem_arity2
 | SEM_CMPLTU of sem_arity2

datatype sem_rhs =
   SEM_LIN of {op:sem_lin}
 | SEM_OP of {op:sem_op}

datatype sem_stmt = 
   SEM_ASSIGN of {lhs:sem_var, rhs:sem_rhs}
 | SEM_LOAD of {lhs:sem_var, size:int, address:sem_rhs}
 | SEM_STORE of {address:sem_linear, size:int, rhs:sem_linear}
 | SEM_LABEL of {id:int}
 | SEM_BRANCH_TO_LABEL of {target:int}
 | SEM_BRANCH of {cond:sem_lin, target:sem_lin}
 | SEM_CALL of {target:sem_lin}
 | SEM_RETURN of {target:sem_lin}

datatype sem_stmts = 
   SEM_CONS of {stmt:sem_stmt, tail:sem_stmts}
 | SEM_NIL

val resultSize op =
   case op of
      SEM_CMPLES x : 1
    | SEM_MUL x : $size x
   end

val operandSize op =
   case op of
      SEM_CMPLES x : $size x
    | x : resultSize op
   end

val translateRegister r = SEM_VAR (semanticRegisterOf r)

val semanticRegisterOf r = 
   case r of
      RAX: {r=ARCH_RAX,offset=0,size=64}
    | RBX: {r=ARCH_RBX,offset=0,size=64}
   end

val guessSizeOf dst/src1 src2 = 
   case dst/src1 of
      REG r: return ($size (semanticRegisterOf r))
    # ...
   end

val lin1/0 x = SEM_X{scale=1, var=x, tail=SEM_I{c=0}}
val lin1 x tl = SEM_X{scale=1, var=x, tail=tl}
val lin2 x y tl = lin1 x (lin1 y tl)

val var//0 x = SEM_VAR{id=x,offset=0}

val temp = do
   t <- query $tmp;
   t' <- return (t ++ '00000001');
   update @{tmp=t'};
   return (SEM_VAR{id=VIRT_T t,offset=0})
end

val /ASSIGN a b = SEM_ASSIGN{lhs=a,rhs=b}
val /ADD sz a b = SEM_OP{op=SEM_ADD{size=sz,opnd1=a,opnd2=b}}
val /LIN sz a = SEM_LIN{op={size=sz, op=a}}

val push insn = do
   tail <- query $stack;
   update @{stack=SEM_CONS{stmt=insn,tail=tail}}
end

val mov sz a b = push (/ASSIGN a (/LIN sz (lin1/0 b)))
val add sz a b c = push (/ASSIGN a (/ADD sz (lin1/0 b) (lin1/0 c)))

val // a offs =
   case a of
      SEM_VAR x: @{offset = $offset x + offs} x
   end

val commit sz a t = mov sz a t
val read x = x
val write x = x

val read x = 
   let
      val readImmSx sz szImm x =
         if sz == szImm
            then 
   in
      case x of
         IMM8 x: 
   end

val translate insn =
   case insn of
      ADD x:
         do a <- write ($opnd1 x);
            b <- read ($opnd1 x);
            c <- read ($opnd2 x);
            sz <- guessSizeOf ($opnd1 x) ($opnd2 x);
            t <- temp;
            add sz t b c;

            # addFlags sz t a b;
            commit sz a t
         end
   end

# vim:filetype=sml
# vim:ts=3
# vim:sw=3
# vim:expandtab
