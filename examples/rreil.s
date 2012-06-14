
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
   SEM_X of {var:sem_var, scale:int, offset:int, tail:sem_linear}
 | SEM_I of {c:int}

type sem_arity1 = {opnd1:sem_linear}
type sem_arity2 = {opnd1:sem_linear, opnd2:sem_linear}

datatype sem_op =
   SEM_MUL of sem_arity2
 | SEM_DIV of sem_arity2
 | SEM_BSWAP of sem_arity1 

datatype sem_rhs =
   SEM_LIN of {linear:sem_linear}
 | SEM_OP of {op:sem_op}

datatype sem_stmt = 
   SEM_ASSIGN of {lhs:sem_var, size:int, rhs:sem_rhs}
 | SEM_LOAD of {lhs:sem_var, size:int, addressSize:int, address:sem_rhs}
 | SEM_STORE of {address:sem_linear, addressSize:int, size:int, rhs:sem_linear}
 | SEM_LABEL of {id:int}
 | SEM_BRANCH_TO_LABEL of {target:int}
 | SEM_BRANCH of {cond:sem_id, target:sem_id}
 | SEM_CALL of {target:sem_id}

val toSemanticRegister r =
   case r of
      RAX: SEM_REG {r:ARCH_RAX,offset=0,size=64}
    | RBX: SEM_REG {r:ARCH_RBX,offset=0,size=64}
   end

val loadOperand p = 
val loadRegister r = return (toSemanticRegister r)

val mov a b = return (SEM_MOV {lhs=a,rhs=b})
val mul a b c = return (SEM_MUL {lhs=a, opnd1=b, opnd2=c})

val toSemantic insn = do
   case insn of
      MOV x:
         case x of 
            {opnd1=REG x, opnd2=REG y}:
               do o1 <- loadRegister x;
                  o2 <- loadOperand y;
                  mov o1 o2 #writeBack
               end
          | {opnd1=REG x, opnd2=MEM ptr}:
               do o1 <- loadOperand ptr;
                  o2 <- loadRegister ptr;
                  load o1 o2 #writeBack
               end
          | {opnd1=MEM ptr, opnd2=REG x}:
               do o1 <- loadOperand ptr;
                  o2 <- loadRegister x;
                  store o1 o2
               end
      
