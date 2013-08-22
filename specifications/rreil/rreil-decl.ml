# vim:filetype=sml:ts=3:sw=3:expandtab
export = rreil-stmts-rev

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
 | SEM_CMP of sem_op_cmp
 | SEM_ARB of {size:int}

type sem_stmt =
   SEM_ASSIGN of {lhs:sem_var, rhs:sem_op}
 | SEM_LOAD of {lhs:sem_var, size:int, address:sem_address}
 | SEM_STORE of {address:sem_address, rhs:sem_op}
 | SEM_ITE of {cond:sem_sexpr, then_branch:sem_stmts, else_branch:sem_stmts}
 | SEM_WHILE of {cond:sem_sexpr, body:sem_stmts}
 | SEM_CBRANCH of {cond:sem_sexpr, target-true:sem_address, target-false:sem_address}
 | SEM_BRANCH of {hint:branch_hint, target:sem_address}

type branch_hint =
    HINT_JUMP
  | HINT_CALL
  | HINT_RET

type sem_stmts =
   SEM_CONS of {hd:sem_stmt, tl:sem_stmts}
 | SEM_NIL

