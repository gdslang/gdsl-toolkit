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


export update-substmap: (subst-map, sem_stmt) -> subst-map
val update-substmap state stmt = case stmt of
    SEM_ASSIGN  s  : substmap-bind-expr state s.size s.lhs s.rhs
  | SEM_LOAD    s  : substmap-mark-var-overwritten state s.lhs.offset s.size s.lhs.id
  | SEM_STORE   s  : state
  | SEM_ITE     s  : subst-map-initial # no join of branches, so we "approximate"
  | SEM_WHILE   s  : subst-map-initial # no fixpoint calculation, so we "approximate"
  | SEM_CBRANCH s  : state
  | SEM_BRANCH  s  : state
  | SEM_FLOP    s  : substmap-mark-varl-overwritten state s.lhs
  | SEM_PRIM    s  : substmap-mark-varl-list-overwritten state s.lhs
  | SEM_THROW   s  : state
	end 


# only bind linear expressions
export substmap-bind-expr : (subst-map, int, sem_var, sem_expr) -> subst-map
val substmap-bind-expr state size var expr = case expr of
    SEM_SEXPR sexpr : substmap-bind-sexpr state size var sexpr
  | x               : substmap-mark-var-overwritten state var.offset size var.id
    end
  
export substmap-bind-sexpr : (subst-map, int, sem_var, sem_sexpr) -> subst-map
val substmap-bind-sexpr state size var sexpr 
	=	case sexpr of
    	    SEM_SEXPR_LIN linear :
    	    	if linear-does-not-ref-to-var linear size var 
				then substmap-bind-linear state var.offset size var.id linear
				else substmap-mark-var-overwritten state var.offset size var.id
    	  | x : substmap-mark-var-overwritten state var.offset size var.id
    end


export linear-does-not-ref-to-var : (sem_linear, int, sem_var) -> |1|
val linear-does-not-ref-to-var linear size var = case linear of
	SEM_LIN_VAR var2 : vars-do-not-overlap size var var2
  | SEM_LIN_IMM s    : '1'
  | SEM_LIN_ADD s    : linear-does-not-ref-to-var s.opnd1 size var and linear-does-not-ref-to-var s.opnd2 size var 
  | SEM_LIN_SUB s    : linear-does-not-ref-to-var s.opnd1 size var and linear-does-not-ref-to-var s.opnd2 size var
  | SEM_LIN_SCALE s  : linear-does-not-ref-to-var s.opnd size var 
  end


export vars-do-not-overlap : (int, sem_var, sem_var) -> |1|
val vars-do-not-overlap size var1 var2 = case var1.id of
  	VIRT_T v1 : case var2.id of
        VIRT_T v2 : if v1 === v2 
  	  				then ranges-do-not-overlap size var1.offset var2.offset
  	  				else '1'
  	  | _ : '1'
  	  	end
  | _ : if index var1.id === index var2.id # we hope that noone defines a sem_id with fields... 
    	then ranges-do-not-overlap size var1.offset var2.offset
    	else '1' 
    end

#TODO
export ranges-do-not-overlap : (int,int,int) -> |1|
val ranges-do-not-overlap size o1 o2 = '0'


export substmap-mark-varl-list-overwritten : (subst-map, sem_varl_list) -> subst-map
val substmap-mark-varl-list-overwritten state varl = case varl of
    SEM_VARLS_CONS s : substmap-mark-varl-list-overwritten (substmap-mark-varl-overwritten state s.hd) s.tl
  | SEM_VARLS_NIL    : state
	end


export substmap-mark-varl-overwritten : (subst-map, sem_varl) -> subst-map
val substmap-mark-varl-overwritten state varl = substmap-mark-var-overwritten state varl.offset varl.size varl.id 


#TODO
export substmap-bind-linear : (subst-map, int, int, sem_id, sem_linear) -> subst-map
val substmap-bind-linear state offset size var linear = state 

#TODO
export substmap-mark-var-overwritten : (subst-map, int, int, sem_id) -> subst-map
val substmap-mark-var-overwritten state offset size var = state

