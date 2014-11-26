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
export propagate-values : (sem_stmt_list)-> sem_stmt_list
val propagate-values stmts = subst-stmt-list-initial stmts


export subst-stmt-list-initial : (sem_stmt_list)-> sem_stmt_list
val subst-stmt-list-initial stmts = subst-stmt-list subst-map-initial stmts


export subst-stmt-list : (subst-map, sem_stmt_list) -> sem_stmt_list
val subst-stmt-list state stmts = case stmts of
		SEM_CONS s : let val new-stmt = subst-stmt state s.hd
						 val new-state = update-substmap state new-stmt
					 in SEM_CONS {hd=new-stmt, tl=subst-stmt-list new-state s.tl}
					 end
	|	SEM_NIL    : SEM_NIL
	end 


#TODO
export update-substmap: (subst-map, sem_stmt) -> subst-map
val update-substmap state stmt = case stmt of
    SEM_ASSIGN s : substmap-bind-expr state s.size s.lhs s.rhs
  | SEM_LOAD   s : substmap-mark-overwritten state s.size s.lhs
  | SEM_STORE  s : state
	end 

#type sem_stmt =
#   SEM_ASSIGN of {size:int, lhs:sem_var, rhs:sem_expr} #size denotes the size of right-hand side operands
# | SEM_LOAD of {size:int, lhs:sem_var, address:sem_address}
# | SEM_STORE of {size:int, address:sem_address, rhs:sem_linear}
# | SEM_ITE of {cond:sem_sexpr, then_branch:sem_stmt_list, else_branch:sem_stmt_list}
# | SEM_WHILE of {cond:sem_sexpr, body:sem_stmt_list}
# | SEM_CBRANCH of {cond:sem_sexpr, target-true:sem_address, target-false:sem_address}
# | SEM_BRANCH of {hint:branch_hint, target:sem_address}
# | SEM_FLOP of {op:sem_flop, flags:sem_var, lhs:sem_varl, rhs:sem_varl_list}
# | SEM_PRIM of {op:string, lhs:sem_varl_list, rhs:sem_varl_list}
# | SEM_THROW of sem_exception
 
#TODO
export substmap-bind-expr : (subst-map, int, sem_var, sem_expr) -> subst-map
val substmap-bind-expr state size var expr = state
 
#TODO
export substmap-mark-overwritten : (subst-map, int, sem_var) -> subst-map
val substmap-mark-overwritten state size var = state
 