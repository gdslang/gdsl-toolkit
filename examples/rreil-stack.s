
export = translate

type sem_id =
   ARCH_RAX
 | ARCH_RBX
 | ARCH_RCX
 | VIRT_EQ
 | VIRT_LES
 | VIRT_LEU
 | VIRT_LTS
 | VIRT_LTU
 | VIRT_T of int

type sem_arity1 = {size: int, opnd1: sem_linear}
type sem_arity2 = {size: int, opnd1: sem_linear, opnd2: sem_linear}

type sem_address = {size: int, address: sem_linear}
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
 | SEM_BSWAP of sem_arity1 
 | SEM_CMPEQ of sem_arity2
 | SEM_CMPLES of sem_arity2
 | SEM_CMPLEU of sem_arity2
 | SEM_CMPLTS of sem_arity2
 | SEM_CMPLTU of sem_arity2


type sem_stmt = 
   SEM_ASSIGN of {lhs: sem_var, rhs: sem_op}
 | SEM_LOAD of {lhs: sem_var, size: int, address: sem_address}
 | SEM_STORE of {address: sem_address, size: int, rhs: sem_linear}
 | SEM_LABEL of {id: int}
 | SEM_BRANCH_TO_LABEL of {target: int}
 | SEM_BRANCH of {cond: sem_linear, size:int, target: sem_address}
 | SEM_CALL of {cond: sem_linear, size:int, target: sem_address}
 | SEM_RETURN of {cond: sem_linear, size:int, target: sem_address}

type sem_stmts = 
   SEM_CONS of {hd:sem_stmt, tl:sem_stmts}
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

val semanticRegisterOf r = 
   case r of
      RAX: {id=ARCH_RAX,offset=0,size=64}
    | RBX: {id=ARCH_RBX,offset=0,size=64}
   end

val guessSizeOf dst/src1 src2 = 
   case dst/src1 of
      REG r: return ($size (semanticRegisterOf r))
    # ...
   end

val var//0 x = SEM_LIN_VAR{id=x,offset=0}

val temp = do
   t <- query $tmp;
   t' <- return (t + 1);
   update @{tmp=t'};
   return {id=VIRT_T t,offset=0}
end

val /ASSIGN a b = SEM_ASSIGN{lhs=a,rhs=b}
val /LOAD sz a b = SEM_LOAD{lhs=a,size=sz,address=b}
val /ADD a b = SEM_LIN_ADD{opnd1=a,opnd2=b}

val push insn = do
   tl <- query $stack;
   update @{stack=SEM_CONS{hd=insn,tl=tl}}
end

val mov sz a b = push (/ASSIGN a (SEM_LIN{size=sz,opnd1=b}))
val load sz a psz b = push (/LOAD sz a {size=psz,address=b})
val add sz a b c = push (/ASSIGN a (SEM_LIN{size=sz,opnd1= /ADD b c}))

#val // a offs =
#   case a of
#      SEM_VAR x: @{offset = $offset x + offs} x
#   end

val commit sz a t = mov sz ({id=ARCH_RAX,offset=0}) t
val write sz x = read sz x

val convWith conv sz x = 
   let
      val convImm conv x = return (SEM_LIN_IMM{imm=conv x})
      
      val convReg x = return (SEM_LIN_VAR(semanticRegisterOf x))

      val convSum conv sz x = 
         do op1 <- convWith conv sz ($a x);
            op2 <- convWith conv sz ($b x);
            return
               (SEM_LIN_ADD
                  {opnd1=op1,
                   opnd2=op2})
         end

      val convScale conv sz x =
         do op <- convWith conv sz ($opnd x);
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

      val convMem x = convWith sx ($psz x) ($opnd x)
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
            do t <- temp;
               address <- convMem x;
               load sz t ($psz x) address
            end
      end
   end

val read sz x = convWith zx sz x

val semantics insn =
  case insn of
      ADD x:
         do sz <- guessSizeOf ($opnd1 x) ($opnd2 x);
            a <- write sz ($opnd1 x);
            b <- read sz ($opnd1 x);
            c <- read sz ($opnd2 x);
            t <- temp;
            add sz t b c

            # addFlags sz t a b;
            #commit sz a (SEM_LIN_VAR t)
         end
    | SUB x:
         do sz <- guessSizeOf ($opnd1 x) ($opnd2 x);
            a <- write sz ($opnd1 x);
            b <- read sz ($opnd1 x);
            c <- read sz ($opnd2 x);
            t <- temp;
            add sz t b c

            # addFlags sz t a b;
            #commit sz a (SEM_LIN_VAR t)
         end
    | MOV x:   
         do sz <- guessSizeOf ($opnd1 x) ($opnd2 x);
            a <- write sz ($opnd1 x);
            b <- read sz ($opnd1 x);
            mov sz a b
            # addFlags sz t a b;
            #commit sz a (SEM_LIN_VAR t)
         end
   end

val translate insn = 
   do update@{stack=SEM_NIL};
      semantics insn;
      stack <- query $stack;
      return stack
   end

# vim:filetype=sml
# vim:ts=3
# vim:sw=3
# vim:expandtab
