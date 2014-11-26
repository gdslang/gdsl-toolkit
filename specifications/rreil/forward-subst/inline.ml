#
# procedure propagate-values takes a sem_stmt_list and return a sem_stmt_list
# with inlined right hand sides.
#
# most simple implementation:
#
#   val propagate-values stmts = return stmts  
#
# suggested milestones:
# 1) inline all constants
# 2) inline linear expressions where possible
# 3) fuse sequences like {ip=ip+n;...;ip=i+m} to {...;ip=ip+(n+m)}  
#



# do a forward propagation on a list of statements
#
# Parameter:
#    list of statements
# 
# Returns:
#    list of statements with inlined right hand sides
#
export propagate-values : (sem_stmt_list)-> S sem_stmt_list <{} => {}>
val propagate-values stmts = return (prop-worker subst-map-initial stmts )


# substitute defs of state in statement list
export prop-worker : (subst-map, sem_stmt_list) -> sem_stmt_list
val prop-worker state stmts = case stmts of
		SEM_CONS s : let val new-stmt = subst-stmt state s.hd
						 val new-state = state
					 in SEM_CONS {hd=new-stmt, tl=prop-worker new-state s.tl}
					 end
	|	SEM_NIL    : SEM_NIL
	end 


# substitute defs of state in right hand side of stmt
export subst-stmt : (subst-map, sem_stmt) -> sem_stmt
val subst-stmt state stmt = case stmt of
	SEM_ASSIGN s  : SEM_ASSIGN{lhs=s.lhs, size=s.size, rhs = subst-expr state s.size s.rhs}
  | SEM_LOAD   s  : SEM_LOAD {size=s.size, lhs=s.lhs, address= subst-address state s.address} 
  | SEM_STORE  s  : SEM_STORE {size=s.size, address= subst-address state s.address, rhs=subst-linear state s.size s.rhs} 
  | SEM_ITE    s  : SEM_ITE {cond= subst-sexpr state 1 s.cond, then_branch= prop-worker state s.then_branch, else_branch= prop-worker state s.else_branch}
  | SEM_WHILE  s  : SEM_WHILE {cond= subst-sexpr state 1 s.cond, body= prop-worker subst-map-initial s.body}
  | SEM_CBRANCH s : SEM_CBRANCH {cond= subst-sexpr state 1 s.cond, target-true= subst-address state s.target-true, target-false= subst-address state s.target-false}
  | SEM_BRANCH s  : SEM_BRANCH {hint=s.hint, target= subst-address state s.target}
  | SEM_FLOP   s  : SEM_FLOP {op=s.op, flags= subst-var state s.flags, lhs=s.lhs, rhs= subst-varl-list state s.rhs}
  | SEM_PRIM   s  : SEM_PRIM {op=s.op, lhs = subst-varl-list state s.lhs, rhs= subst-varl-list state s.rhs}
  | SEM_THROW  e  : SEM_THROW e
	end

# TODO
export subst-sexpr: (subst-map, int, sem_sexpr) -> sem_sexpr
val subst-sexpr state size sexpr = case sexpr of
    SEM_SEXPR_LIN linear : SEM_SEXPR_LIN (subst-linear state size linear)
  | SEM_SEXPR_CMP s      : SEM_SEXPR_CMP {size=s.size, cmp=subst-expr-cmp state s.size s.cmp}
  | SEM_SEXPR_ARB        : sexpr
	end

# type sem_sexpr =
# | SEM_SEXPR_CMP of 
# | SEM_SEXPR_ARB

# TODO
export subst-address: (subst-map, sem_address) -> sem_address
val subst-address state address = address

# TODO
export subst-expr-cmp: (subst-map, int, sem_expr_cmp) -> sem_expr_cmp
val subst-expr-cmp state size cmp = cmp


# TODO
export subst-linear: (subst-map, int, sem_linear) -> sem_linear
val subst-linear state size linear = linear

# TODO
export subst-var: (subst-map, sem_var) -> sem_var
val subst-var state var = var

# TODO
export subst-varl-list: (subst-map, sem_varl_list) -> sem_varl_list
val subst-varl-list state varlist = varlist

