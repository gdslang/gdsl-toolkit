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
export fsubst-propagate-values : (sem_stmt_list)-> S sem_stmt_list <{} => {}>
val fsubst-propagate-values stmts = fsubst-stmt-list-initial stmts


val fsubst-stmt-list-initial stmts = do
	l <- subst-stmt-list-m substmap-initial stmts;
	#println "--------------------------";
	return l
	end


val subst-stmt-list-m state stmts = case stmts of
		SEM_CONS s : do
				new-stmt <- subst-stmt-m state s.hd;
				new-state <- update-with-stmt state new-stmt;
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
	

val update-with-stmt state stmt = case stmt of
    SEM_ASSIGN  s  : update-bind-expr state s.size s.lhs s.rhs
  | SEM_LOAD    s  : return (update-mark-var-overwritten state s.lhs.offset s.size s.lhs.id)
  | SEM_STORE   s  : return state
  | SEM_ITE     s  : return substmap-initial # no join of branches, so we "approximate"
  | SEM_WHILE   s  : return substmap-initial # no fixpoint calculation, so we "approximate"
  | SEM_CBRANCH s  : return state
  | SEM_BRANCH  s  : return state
  | SEM_FLOP    s  : return (update-mark-varl-overwritten state s.lhs)
  | SEM_PRIM    s  : return (update-mark-varl-list-overwritten state s.lhs)
  | SEM_THROW   s  : return state
	end


val update-bind-expr state size var expr = case expr of
    SEM_SEXPR sexpr : return (update-bind-sexpr state size var sexpr)
  | SEM_XOR a2      : do #println ("checking "+++rreil-show-expr expr);
  						if size === 1 and is-inverting-xor a2.opnd1 a2.opnd2
  						then do #println ("checking inv "+++rreil-show-expr expr);
  						case subst-linear-to-cond state a2.opnd1 of
  							  Nothing-sexpr :
  									return (update-bind-sexpr-inverted state size var (SEM_SEXPR_LIN a2.opnd1))
  							| Just-sexpr o1 :
  									return (update-bind-sexpr-inverted state size var o1) 
  							| Just-sexpr-inverted o1 :
  									return (update-bind-sexpr state size var o1) 
  							#TODO
  							end
  							end
  						else return (update-mark-var-overwritten state var.offset size var.id)
  						end
  | x               : return (update-mark-var-overwritten state var.offset size var.id)
    end
  
val is-inverting-xor opnd1 opnd2 = case opnd2 of
	SEM_LIN_IMM l : l.const === 1
	| x : '0'
	end
	  
val update-bind-sexpr state size var sexpr 
	=	if sexpr-does-not-ref-to-var sexpr size var 
			then update-bind-linear state var.offset size var.id sexpr
			else update-mark-var-overwritten state var.offset size var.id

val update-bind-sexpr-inverted state size var sexpr 
	=	if sexpr-does-not-ref-to-var sexpr size var 
			then update-bind-linear-inverted state var.offset size var.id sexpr
			else update-mark-var-overwritten state var.offset size var.id


val sexpr-does-not-ref-to-var linear size var = case linear of
	SEM_SEXPR_LIN l  : linear-does-not-ref-to-var l size var
  | SEM_SEXPR_CMP x  : expr-cmp-does-not-ref-to-var x.cmp x.size var
  | SEM_SEXPR_ARB    : '0' # quick hack to avoid the insertion of 'arbitrary'
  end

val expr-cmp-does-not-ref-to-var expr size var = case expr of
   SEM_CMPEQ s    : linear-does-not-ref-to-var s.opnd1 size var and linear-does-not-ref-to-var s.opnd2 size var
 | SEM_CMPNEQ s    : linear-does-not-ref-to-var s.opnd1 size var and linear-does-not-ref-to-var s.opnd2 size var
 | SEM_CMPLES s    : linear-does-not-ref-to-var s.opnd1 size var and linear-does-not-ref-to-var s.opnd2 size var
 | SEM_CMPLEU s    : linear-does-not-ref-to-var s.opnd1 size var and linear-does-not-ref-to-var s.opnd2 size var
 | SEM_CMPLTS s    : linear-does-not-ref-to-var s.opnd1 size var and linear-does-not-ref-to-var s.opnd2 size var
 | SEM_CMPLTU s    : linear-does-not-ref-to-var s.opnd1 size var and linear-does-not-ref-to-var s.opnd2 size var
  end


val linear-does-not-ref-to-var linear size var = case linear of
	SEM_LIN_VAR var2 : vars-do-not-overlap size var var2
  | SEM_LIN_IMM s    : '1'
  | SEM_LIN_ADD s    : linear-does-not-ref-to-var s.opnd1 size var and linear-does-not-ref-to-var s.opnd2 size var 
  | SEM_LIN_SUB s    : linear-does-not-ref-to-var s.opnd1 size var and linear-does-not-ref-to-var s.opnd2 size var
  | SEM_LIN_SCALE s  : linear-does-not-ref-to-var s.opnd size var 
  end


val vars-do-not-overlap size var1 var2 =
	if id-eq? var1.id var2.id
	then ranges-do-not-overlap size var1.offset var2.offset
   	else '1'


val ranges-do-not-overlap size o1 o2 = o1+size <= o2 or o2+size <= o1


val update-mark-varl-list-overwritten state varl = case varl of
    SEM_VARLS_CONS s : update-mark-varl-list-overwritten (update-mark-varl-overwritten state s.hd) s.tl
  | SEM_VARLS_NIL    : state
	end


val update-mark-varl-overwritten state varl = update-mark-var-overwritten state varl.offset varl.size varl.id 


val update-bind-linear state offset size var linear = substmap-bind-sexpr state offset size var linear 

val update-bind-linear-inverted state offset size var linear = substmap-bind-sexpr-inverted state offset size var linear 


val update-mark-var-overwritten state offset size var = substmap-mark-overwritten state offset size var

