

# substitute defs of state in right hand side of stmt
#
# SEM_WHILE and SEM_ITE use the top-level function for a rough approximation
#
export subst-stmt : (subst-map, sem_stmt) -> sem_stmt
val subst-stmt state stmt = case stmt of
	SEM_ASSIGN s  : SEM_ASSIGN{lhs=s.lhs, size=s.size, rhs = subst-expr state s.size s.rhs}
  | SEM_LOAD   s  : SEM_LOAD {size=s.size, lhs=s.lhs, address= subst-address state s.address} 
  | SEM_STORE  s  : SEM_STORE {size=s.size, address= subst-address state s.address, rhs=subst-linear state s.size s.rhs} 
  | SEM_ITE    s  : SEM_ITE {cond= subst-sexpr state 1 s.cond, then_branch= subst-stmt-list state s.then_branch, else_branch= subst-stmt-list state s.else_branch}
  | SEM_WHILE  s  : SEM_WHILE {cond= subst-sexpr state 1 s.cond, body= subst-stmt-list-initial s.body}
  | SEM_CBRANCH s : SEM_CBRANCH {cond= subst-sexpr state 1 s.cond, target-true= subst-address state s.target-true, target-false= subst-address state s.target-false}
  | SEM_BRANCH s  : SEM_BRANCH {hint=s.hint, target= subst-address state s.target}
  | SEM_FLOP   s  : SEM_FLOP {op=s.op, flags= s.flags, lhs=s.lhs, rhs= subst-varl-list state s.rhs}
  | SEM_PRIM   s  : SEM_PRIM {op=s.op, lhs = s.lhs, rhs= subst-varl-list state s.rhs}
  | SEM_THROW  e  : SEM_THROW e
	end


export subst-expr : (subst-map, int, sem_expr) -> sem_expr
val subst-expr state size expr = case expr of
    SEM_SEXPR sexpr : SEM_SEXPR (subst-sexpr state size sexpr)
  | SEM_MUL  s  : SEM_MUL  (subst-arity2 state size s)
  | SEM_DIV  s  : SEM_DIV  (subst-arity2 state size s)
  | SEM_DIVS s  : SEM_DIVS (subst-arity2 state size s)
  | SEM_MOD  s  : SEM_MOD  (subst-arity2 state size s)
  | SEM_MODS s  : SEM_MODS (subst-arity2 state size s)
  | SEM_SHL  s  : SEM_SHL  (subst-arity2 state size s)
  | SEM_SHR  s  : SEM_SHR  (subst-arity2 state size s)
  | SEM_SHRS s  : SEM_SHRS (subst-arity2 state size s)
  | SEM_AND  s  : SEM_AND  (subst-arity2 state size s)
  | SEM_OR   s  : SEM_OR   (subst-arity2 state size s)
  | SEM_XOR  s  : SEM_XOR  (subst-arity2 state size s)
  | SEM_SX   s  : SEM_SX {fromsize=s.fromsize, opnd1= subst-linear state s.fromsize s.opnd1}
  | SEM_ZX   s  : SEM_ZX {fromsize=s.fromsize, opnd1= subst-linear state s.fromsize s.opnd1}
    end


export subst-sexpr: (subst-map, int, sem_sexpr) -> sem_sexpr
val subst-sexpr state size sexpr = case sexpr of
    SEM_SEXPR_LIN linear : SEM_SEXPR_LIN (subst-linear state size linear)
  | SEM_SEXPR_CMP s      : SEM_SEXPR_CMP {size=s.size, cmp=subst-expr-cmp state s.size s.cmp}
  | SEM_SEXPR_ARB        : sexpr
	end


export subst-address: (subst-map, sem_address) -> sem_address
val subst-address state s = {size=s.size, address= subst-linear state s.size s.address}


export subst-expr-cmp: (subst-map, int, sem_expr_cmp) -> sem_expr_cmp
val subst-expr-cmp state size cmp = case cmp of
    SEM_CMPEQ s  : SEM_CMPEQ  (subst-arity2 state size s)
  | SEM_CMPNEQ s : SEM_CMPNEQ (subst-arity2 state size s)
  | SEM_CMPLES s : SEM_CMPLES (subst-arity2 state size s)
  | SEM_CMPLEU s : SEM_CMPLEU (subst-arity2 state size s)
  | SEM_CMPLTS s : SEM_CMPLTS (subst-arity2 state size s)
  | SEM_CMPLTU s : SEM_CMPLTU (subst-arity2 state size s)
	end


export subst-arity2: (subst-map, int, sem_arity2) -> sem_arity2
val subst-arity2 state size s = {opnd1= subst-linear state size s.opnd1, opnd2= subst-linear state size s.opnd2 }


export subst-linear: (subst-map, int, sem_linear) -> sem_linear
val subst-linear state size linear = case linear of
    SEM_LIN_VAR var : subst-var-to-lin state size var
  | SEM_LIN_IMM s   : linear
  | SEM_LIN_ADD s   : simplify-lin-add (subst-linear state size s.opnd1) (subst-linear state size s.opnd2)
  | SEM_LIN_SUB s   : SEM_LIN_SUB (subst-arity2 state size s)
  | SEM_LIN_SCALE s : SEM_LIN_SCALE {const=s.const, opnd=subst-linear state size s.opnd}
	end


export subst-varl-list: (subst-map, sem_varl_list) -> sem_varl_list
val subst-varl-list state varlist = case varlist of
    SEM_VARLS_CONS s : SEM_VARLS_CONS {hd=subst-varl-to-varl state s.hd, tl=subst-varl-list state s.tl}
  | SEM_VARLS_NIL    : varlist
    end


export subst-varl-to-varl: (subst-map, sem_varl) -> sem_varl
val subst-varl-to-varl state varl = case substmap-var-to-lin state varl.offset varl.size varl.id of
    SEM_LIN_VAR v : {id=v.id, offset=v.offset, size=varl.size}
  | _ : varl
	end  

# 
export subst-var-to-lin: (subst-map, int, sem_var) -> sem_linear
val subst-var-to-lin state size var = substmap-var-to-lin state var.offset size var.id 

