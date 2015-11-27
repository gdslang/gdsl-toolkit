

# substitute defs of state in right hand side of stmt
#
# SEM_WHILE and SEM_ITE use the top-level function for a rough approximation
#
val substitute-stmt-with-state-definitions state stmt = case stmt of
    SEM_ASSIGN s  : return (SEM_ASSIGN{lhs=s.lhs, size=s.size, rhs = subst-expr state s.size s.rhs})
  | SEM_LOAD   s  : return (SEM_LOAD {size=s.size, lhs=s.lhs, address= subst-address state s.address})
  | SEM_STORE  s  : return (SEM_STORE {size=s.size, address= subst-address state s.address, rhs=subst-linear state s.size s.rhs}) 
  | SEM_ITE    s  : do
  		newCond <- subst-cond state s.cond;
  		case newCond of
  		  Nothing-sexpr : do
  			#println "subst-cond-ite-nothing";
  			return (SEM_ITE {cond= s.cond, then_branch= s.then_branch, else_branch= s.else_branch})
  			end
  		| Just-sexpr se : do
  			#println "subst-cond-ite-insert";
  			return (SEM_ITE {cond= se, then_branch= s.then_branch, else_branch= s.else_branch})
  			end
  		| Just-sexpr-inverted se : do
  			#println "subst-cond-ite-insert-inverted";
  			return (SEM_ITE {cond= se, then_branch= s.then_branch, else_branch= s.else_branch})
  			end
  		end
  		end
  | SEM_WHILE  s  : return stmt
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
  | SEM_THROW  e  : return stmt
	end

