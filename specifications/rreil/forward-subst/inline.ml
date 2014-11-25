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

val prop-worker state stmts = case stmts of
		SEM_CONS s : let val new-stmt = s.hd
						 val new-state = state
					 in SEM_CONS {hd=new-stmt, tl=prop-worker new-state s.tl}
					 end
	|	SEM_NIL    : SEM_NIL
	end 

#type sem_stmt_list =
#   SEM_CONS of {hd:sem_stmt, tl:sem_stmt_list}
# | SEM_NIL
