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

val propagate-values stmts = return stmts