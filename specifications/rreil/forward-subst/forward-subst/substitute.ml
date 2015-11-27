

# substitute defs of state in right hand side of stmt
#
# SEM_WHILE and SEM_ITE use the top-level function for a rough approximation
#
val subst-stmt-m state stmt = case stmt of
	SEM_ASSIGN s  : return (SEM_ASSIGN{lhs=s.lhs, size=s.size, rhs = subst-expr state s.size s.rhs})
  | SEM_LOAD   s  : return (SEM_LOAD {size=s.size, lhs=s.lhs, address= subst-address state s.address})
  | SEM_STORE  s  : return (SEM_STORE {size=s.size, address= subst-address state s.address, rhs=subst-linear state s.size s.rhs}) 
  | SEM_ITE    s  : do
  		tb <- subst-stmt-list-m state s.then_branch;
  		eb <- subst-stmt-list-m state s.else_branch;
  		newCond <- subst-cond state s.cond;
  		case newCond of
  		  Nothing-sexpr : do
  			#println "subst-cond-ite-nothing";
  			return (SEM_ITE {cond= s.cond, then_branch= tb, else_branch= eb})
  			end
  		| Just-sexpr se : do
  			#println "subst-cond-ite-insert";
  			return (SEM_ITE {cond= se, then_branch= tb, else_branch= eb})
  			end
  		| Just-sexpr-inverted se : do
  			#println "subst-cond-ite-insert-inverted";
  			return (SEM_ITE {cond= se, then_branch= eb, else_branch= tb})
  			end
  		end
  		end
  | SEM_WHILE  s  : do
  		newBody <- subst-stmt-list-m substmap-initial s.body;
		return (SEM_WHILE {cond= s.cond, body= newBody})
  		end
  | SEM_CBRANCH s : do
  		newCond <- subst-cond state s.cond;
  		case newCond of
   		  Nothing-sexpr : do
  			#println "subst-cond-cbranch-nothing"; 			
  			return (SEM_CBRANCH {cond= s.cond, target-true= subst-address state s.target-true, target-false= subst-address state s.target-false})
  			end
  		| Just-sexpr se : do
  			#println "subst-cond-cbranch-insert";
  			return (SEM_CBRANCH {cond= se, target-true= subst-address state s.target-true, target-false= subst-address state s.target-false})
  			end
  		| Just-sexpr-inverted se : do
  			#println "subst-cond-cbranch-insert-inverted";
  			return (SEM_CBRANCH {cond= se, target-true= subst-address state s.target-false, target-false= subst-address state s.target-true})
  			end
  		end
  		end
  | SEM_BRANCH s  : return (SEM_BRANCH {hint=s.hint, target= subst-address state s.target})
  | SEM_FLOP   s  : return (SEM_FLOP {op=s.op, flags= s.flags, lhs=s.lhs, rhs= subst-varl-list state s.rhs})
  | SEM_PRIM   s  : return (SEM_PRIM {op=s.op, lhs = s.lhs, rhs= subst-varl-list state s.rhs})
  | SEM_THROW  e  : return (SEM_THROW e)
	end

