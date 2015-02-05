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
val propagate-values stmts = subst-stmt-list-initial stmts


export subst-stmt-list-initial : (sem_stmt_list)-> S sem_stmt_list  <{} => {}>
val subst-stmt-list-initial stmts = do
	l <- subst-stmt-list-m substmap-initial stmts;
	#println "--------------------------";
	return l
	end


export subst-stmt-list-m : (subst-map, sem_stmt_list) -> S sem_stmt_list <{} => {}>
val subst-stmt-list-m state stmts = case stmts of
		SEM_CONS s : do
				new-stmt <- subst-stmt-m state s.hd;
				new-state <- return (update-with-stmt state new-stmt);
				#println "old stmt:";
				#println (rreil-show-stmt s.hd);
				#println "new stmt:";
				#println (rreil-show-stmt new-stmt);			
				#println "head of new state:";
				#println (show-substmap new-state);			
				#println ".";
				continued <- subst-stmt-list-m new-state s.tl;
				return (SEM_CONS {hd=new-stmt, tl=continued})
				end
	|	SEM_NIL    : return SEM_NIL
	end 
	

export update-with-stmt: (subst-map, sem_stmt) -> subst-map
val update-with-stmt state stmt = case stmt of
    SEM_ASSIGN  s  : update-bind-expr state s.size s.lhs s.rhs
  | SEM_LOAD    s  : update-mark-var-overwritten state s.lhs.offset s.size s.lhs.id
  | SEM_STORE   s  : state
  | SEM_ITE     s  : substmap-initial # no join of branches, so we "approximate"
  | SEM_WHILE   s  : substmap-initial # no fixpoint calculation, so we "approximate"
  | SEM_CBRANCH s  : state
  | SEM_BRANCH  s  : state
  | SEM_FLOP    s  : update-mark-varl-overwritten state s.lhs
  | SEM_PRIM    s  : update-mark-varl-list-overwritten state s.lhs
  | SEM_THROW   s  : state
	end 


# only bind linear expressions
export update-bind-expr : (subst-map, int, sem_var, sem_expr) -> subst-map
val update-bind-expr state size var expr = case expr of
    SEM_SEXPR sexpr : update-bind-sexpr state size var sexpr
  | x               : update-mark-var-overwritten state var.offset size var.id
    end
  
export update-bind-sexpr : (subst-map, int, sem_var, sem_sexpr) -> subst-map	
val update-bind-sexpr state size var sexpr 
	=	if sexpr-does-not-ref-to-var sexpr size var 
			then update-bind-linear state var.offset size var.id sexpr
			else update-mark-var-overwritten state var.offset size var.id


export sexpr-does-not-ref-to-var : (sem_sexpr, int, sem_var) -> |1|
val sexpr-does-not-ref-to-var linear size var = case linear of
	SEM_SEXPR_LIN l  : linear-does-not-ref-to-var l size var
  | SEM_SEXPR_CMP x  : expr-cmp-does-not-ref-to-var x.cmp x.size var
  | SEM_SEXPR_ARB    : '1'
  end

export expr-cmp-does-not-ref-to-var : (sem_expr_cmp, int, sem_var) -> |1|
val expr-cmp-does-not-ref-to-var expr size var = case expr of
   SEM_CMPEQ s    : linear-does-not-ref-to-var s.opnd1 size var and linear-does-not-ref-to-var s.opnd2 size var
 | SEM_CMPNEQ s    : linear-does-not-ref-to-var s.opnd1 size var and linear-does-not-ref-to-var s.opnd2 size var
 | SEM_CMPLES s    : linear-does-not-ref-to-var s.opnd1 size var and linear-does-not-ref-to-var s.opnd2 size var
 | SEM_CMPLEU s    : linear-does-not-ref-to-var s.opnd1 size var and linear-does-not-ref-to-var s.opnd2 size var
 | SEM_CMPLTS s    : linear-does-not-ref-to-var s.opnd1 size var and linear-does-not-ref-to-var s.opnd2 size var
 | SEM_CMPLTU s    : linear-does-not-ref-to-var s.opnd1 size var and linear-does-not-ref-to-var s.opnd2 size var
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
val vars-do-not-overlap size var1 var2 =
	if id-eq? var1.id var2.id
	then ranges-do-not-overlap size var1.offset var2.offset
   	else '1'


export id-eq? : (sem_id, sem_id) -> |1|
val id-eq? id1 id2 = case id1 of
  	VIRT_T v1 : case id2 of
        VIRT_T v2 : v1 === v2
      | _ : '0'
      	end 
  | _ : index id1 === index id2
    end


export ranges-do-not-overlap : (int,int,int) -> |1|
val ranges-do-not-overlap size o1 o2 = o1+size <= o2 or o2+size <= o1


export update-mark-varl-list-overwritten : (subst-map, sem_varl_list) -> subst-map
val update-mark-varl-list-overwritten state varl = case varl of
    SEM_VARLS_CONS s : update-mark-varl-list-overwritten (update-mark-varl-overwritten state s.hd) s.tl
  | SEM_VARLS_NIL    : state
	end


export update-mark-varl-overwritten : (subst-map, sem_varl) -> subst-map
val update-mark-varl-overwritten state varl = update-mark-var-overwritten state varl.offset varl.size varl.id 


export update-bind-linear : (subst-map, int, int, sem_id, sem_sexpr) -> subst-map
val update-bind-linear state offset size var linear = substmap-bind-sexpr state offset size var linear 


export update-mark-var-overwritten : (subst-map, int, int, sem_id) -> subst-map
val update-mark-var-overwritten state offset size var = substmap-mark-overwritten state offset size var

