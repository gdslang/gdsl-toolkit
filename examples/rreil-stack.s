
datatype sem_id =
   ARCH_RAX
 | ARCH_RBX
 | ARCH_RCX
 | VIRT_T0
 | VIRT_T1
 | VIRT_T2
 | VIRT_T3
 | VIRT_T4
 | VIRT_T5
 | VIRT_T6
 | VIRT_T7
 | VIRT_EQ
 | VIRT_LES
 | VIRT_LEU
 | VIRT_LTS
 | VIRT_LTU

datatype sem_var =
   SEM_VAR of {id:sem_id, offset:int}

datatype sem_linear =
   SEM_X of {var:sem_var, scale:int, tail:sem_linear}
 | SEM_I of {c:int}

type sem_lin = {size:int, opnd1:sem_linear}
type sem_arity1 = {size:int, opnd1:sem_linear}
type sem_arity2 = {size:int, opnd1:sem_linear, opnd2:sem_linear}

datatype sem_op =
   SEM_MUL of sem_arity2
 | SEM_DIV of sem_arity2
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

val translateRegister r = SEM_REG (toSemanticRegister r)

val toSemanticRegister r = 
   case r of
      RAX: {r:ARCH_RAX,offset=0,size=64}
    | RBX: {r:ARCH_RBX,offset=0,size=64}
   end

val sizeOf x = 
   case x of
      REG r: return ($size (toSemanticRegister r))
    # ...
   end

val lin1/0 x = SEM_X{scale=1, var=x, tail=SEM_I{c=0}}
val lin1 x tl = SEM_X{scale=1, var=x, tail=tl}
val lin2 x y tl = lin1 x (lin1 y tl)

val var//0 x = SEM_VAR{id:x,offset=0}
val t0 = return (var//0 VIRT_T0)
val t1 = return (var//0 VIRT_T1)
val t2 = return (var//0 VIRT_T2)
val t3 = return (var//0 VIRT_T3)
val t4 = return (var//0 VIRT_T4)
val t5 = return (var//0 VIRT_T5)
val t6 = return (var//0 VIRT_T6)
val t7 = return (var//0 VIRT_T6)

val /ASSIGN a b = SEM_ASSIGN{lhs=a,rhs=b}
val /ADD sz a b = SEM_ADD{size=sz,opnd1=a,opnd2=b}

val /mov a b = push (/ASSIGN a b)
val /add a b c = push (/ASSIGN a (/ADD sz (lin1/0 b) (lin1/0 c)))

val // a offs =
   case s of
      SEM_VAR x: @{offset=$offset x + offs} x

val read x = x
val write x = x
val intro t = t

val translate insn = do
   case insn of
      ADD x:
         do a <- write ($opnd1 x);
            b <- read ($opnd1 x);
            c <- read ($opnd2 x);
            sz <- sizeOf ($opnd2 x);
            t <- intro t0;
            /add sz t b c;

            # addFlags sz t a b;
            writeBack a t
         end
   end
