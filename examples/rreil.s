
datatype sem_id =
   ARCH_RAX
 | ARCH_RBX
 | ARCH_RCX
 | VIRT_T0
 | VIRT_T1
 | VIRT_T2
 | VIRT_T4
 | VIRT_T5
 | VIRT_T6
 | VIRT_T7
 | VIRT_T8
 | VIRT_T9
 | VIRT_EQ
 | VIRT_LES
 | VIRT_LEU
 | VIRT_LTS
 | VIRT_LTU

datatype sem_var =
   SEM_REG of {id:sem_id, offset:int}

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
 | SEM_CMPLES of sem_arity2

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

val mov = do
   opnd1 <- query$opnd1;
   opnd3 <- query$opnd3;
   sz <- query$size;
   push (SEM_ASSIGN {lhs=opnd1,rhs=SEM_LIN {op={size=sz,opnd1=opnd3}}})
end

val lin1 x tl = SEM_X{scale=1, var=x, tail=tl}
val lin2 x y tl = lin1 x (lin1 y tl)

val /assign a b = SEM_ASSIGN{lhs=a,rhs=b}
val /add sz a b = SEM_ADD{size=sz,opnd1=a,opnd2=b}

val add = do
   opnd1 <- query$opnd1;
   opnd3 <- query$opnd3;
   sz <- query$size;
   t0 <- temp;
   udpate@{opnd3=t0};
   push (/assign t0 (/add sz opnd1 opnd3));
   mov
end

val translate insn = do
   case insn of
      MOV x: 
         translateArity2 x {onAssign=mov}
    | ADD x:
         translateArity2 x
            {onAssign=
               do
                  opnd1 <- query$opnd1;
                  opnd3 <- query$opnd3;
                  sz <- query$size;
                  t0 <- temp;
                  update@{writeBack=t0};
                  push (/assign t0 (/add sz opnd1 opnd3));
               end}
   end
