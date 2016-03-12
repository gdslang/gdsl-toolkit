

# substitute defs of state in right hand side of stmt
#
# SEM_WHILE and SEM_ITE use the top-level function for a rough approximation
#
val substitute-stmt-with-state-definitions state stmt = case stmt of
    SEM_ASSIGN s  : return (SEM_ASSIGN{lhs=s.lhs, size=s.size, rhs = df-subst-expr state s.size s.rhs})
  | SEM_LOAD   s  : return (SEM_LOAD {size=s.size, lhs=s.lhs, address= df-subst-address state s.address})
  | SEM_STORE  s  : return (SEM_STORE {size=s.size, address= df-subst-address state s.address, rhs=df-subst-linear state s.size s.rhs}) 
  | SEM_ITE    s  : do
  		newCond <- df-subst-cond state s.cond;
  		case newCond of
  		  NOTHING_SEXPR : do
  			#println "subst-cond-ite-nothing";
  			return (SEM_ITE {cond= s.cond, then_branch= s.then_branch, else_branch= s.else_branch})
  			end
  		| JUST_SEXPR se : do
  			#println "subst-cond-ite-insert";
  			return (SEM_ITE {cond= se, then_branch= s.then_branch, else_branch= s.else_branch})
  			end
  		end
  		end
  | SEM_WHILE  s  : return stmt
  | SEM_CBRANCH s : do
  		newCond <- df-subst-cond state s.cond;
  		case newCond of
   		  NOTHING_SEXPR : do
  			#println "subst-cond-cbranch-nothing"; 			
  			return (SEM_CBRANCH {cond= s.cond, target-true= df-subst-address state s.target-true, target-false= df-subst-address state s.target-false})
  			end
  		| JUST_SEXPR se : do
  			#println "subst-cond-cbranch-insert";
  			return (SEM_CBRANCH {cond= se, target-true= df-subst-address state s.target-true, target-false= df-subst-address state s.target-false})
  			end
  		end
  		end
  | SEM_BRANCH s  : return (SEM_BRANCH {hint=s.hint, target= df-subst-address state s.target})
  | SEM_FLOP   s  : return (SEM_FLOP {op=s.op, flags= s.flags, lhs=s.lhs, rhs= df-subst-varl-list state s.rhs})
  | SEM_PRIM   s  : return (SEM_PRIM {op=s.op, lhs = s.lhs, rhs= df-subst-varl-list state s.rhs})
  | SEM_THROW  e  : return stmt
	end


val df-subst-cond state c = case c of
    SEM_SEXPR_LIN linear : return (df-subst-linear-to-cond state linear)
  | SEM_SEXPR_CMP s      : return (JUST_SEXPR (SEM_SEXPR_CMP {size=s.size, cmp=df-subst-expr-cmp state s.size s.cmp}))
  | SEM_SEXPR_ARB        : return (JUST_SEXPR c)
	end

val df-subst-linear-to-cond state linear =
	case linear of
    SEM_LIN_VAR var : df-substmap-lookup-var-to-cond state var.offset var.id
  | SEM_LIN_IMM s   : JUST_SEXPR (SEM_SEXPR_LIN linear)
  | SEM_LIN_ADD s   : JUST_SEXPR (SEM_SEXPR_LIN (df-simplify-lin-add (df-subst-linear state 1 s.opnd1) (df-subst-linear state 1 s.opnd2)))
  | SEM_LIN_SUB s   : JUST_SEXPR (SEM_SEXPR_LIN (SEM_LIN_SUB (df-subst-arity2 state 1 s)))
  | SEM_LIN_SCALE s : JUST_SEXPR (SEM_SEXPR_LIN (SEM_LIN_SCALE {const=s.const, opnd=df-subst-linear state 1 s.opnd}))
	end

val df-subst-expr state size expr = case expr of
    SEM_SEXPR sexpr : SEM_SEXPR (df-subst-sexpr state size sexpr)
  | SEM_MUL  s  : SEM_MUL  (df-subst-arity2 state size s)
  | SEM_DIV  s  : SEM_DIV  (df-subst-arity2 state size s)
  | SEM_DIVS s  : SEM_DIVS (df-subst-arity2 state size s)
  | SEM_MOD  s  : SEM_MOD  (df-subst-arity2 state size s)
  | SEM_MODS s  : SEM_MODS (df-subst-arity2 state size s)
  | SEM_SHL  s  : SEM_SHL  (df-subst-arity2 state size s)
  | SEM_SHR  s  : SEM_SHR  (df-subst-arity2 state size s)
  | SEM_SHRS s  : SEM_SHRS (df-subst-arity2 state size s)
  | SEM_AND  s  : SEM_AND  (df-subst-arity2 state size s)
  | SEM_OR   s  : SEM_OR   (df-subst-arity2 state size s)
  | SEM_XOR  s  : SEM_XOR  (df-subst-arity2 state size s)
  | SEM_SX   s  : SEM_SX {fromsize=s.fromsize, opnd1= df-subst-linear state s.fromsize s.opnd1}
  | SEM_ZX   s  : SEM_ZX {fromsize=s.fromsize, opnd1= df-subst-linear state s.fromsize s.opnd1}
    end



val df-subst-sexpr state size sexpr = case sexpr of
    SEM_SEXPR_LIN linear : df-subst-linear-to-sexpr state size linear
  | SEM_SEXPR_CMP s      : SEM_SEXPR_CMP {size=s.size, cmp=df-subst-expr-cmp state s.size s.cmp}
  | SEM_SEXPR_ARB        : sexpr
	end


val df-subst-address state s = {size=s.size, address= df-subst-linear state s.size s.address}


val df-subst-expr-cmp state size cmp = case cmp of
    SEM_CMPEQ s  : SEM_CMPEQ  (df-subst-arity2 state size s)
  | SEM_CMPNEQ s : SEM_CMPNEQ (df-subst-arity2 state size s)
  | SEM_CMPLES s : SEM_CMPLES (df-subst-arity2 state size s)
  | SEM_CMPLEU s : SEM_CMPLEU (df-subst-arity2 state size s)
  | SEM_CMPLTS s : SEM_CMPLTS (df-subst-arity2 state size s)
  | SEM_CMPLTU s : SEM_CMPLTU (df-subst-arity2 state size s)
	end


val df-subst-arity2 state size s = {opnd1= df-subst-linear state size s.opnd1, opnd2= df-subst-linear state size s.opnd2 }


val df-subst-linear-to-sexpr state size linear = case linear of
    SEM_LIN_VAR var : df-subst-var-to-sexpr state size var
  | SEM_LIN_IMM s   : SEM_SEXPR_LIN linear
  | SEM_LIN_ADD s   : SEM_SEXPR_LIN (df-simplify-lin-add (df-subst-linear state size s.opnd1) (df-subst-linear state size s.opnd2))
  | SEM_LIN_SUB s   : SEM_SEXPR_LIN (SEM_LIN_SUB (df-subst-arity2 state size s))
  | SEM_LIN_SCALE s : SEM_SEXPR_LIN (SEM_LIN_SCALE {const=s.const, opnd=df-subst-linear state size s.opnd})
	end

val df-subst-linear state size linear = case linear of
    SEM_LIN_VAR var : df-subst-var-to-lin state size var
  | SEM_LIN_IMM s   : linear
  | SEM_LIN_ADD s   : df-simplify-lin-add (df-subst-linear state size s.opnd1) (df-subst-linear state size s.opnd2)
  | SEM_LIN_SUB s   : SEM_LIN_SUB (df-subst-arity2 state size s)
  | SEM_LIN_SCALE s : SEM_LIN_SCALE {const=s.const, opnd=df-subst-linear state size s.opnd}
	end


val df-subst-varl-list state varlist = case varlist of
    SEM_VARLS_CONS s : SEM_VARLS_CONS {hd=df-subst-varl-to-varl state s.hd, tl=df-subst-varl-list state s.tl}
  | SEM_VARLS_NIL    : varlist
    end


val df-subst-varl-to-varl state varl = case df-substmap-var-to-lin state varl.offset varl.size varl.id of
    SEM_LIN_VAR v : {id=v.id, offset=v.offset, size=varl.size}
  | _ : varl
	end  


val df-subst-var-to-sexpr state size var = df-substmap-var-to-sexpr state var.offset size var.id 

val df-subst-var-to-lin state size var = df-substmap-var-to-lin state var.offset size var.id

val df-simplify-linear lin = case lin of
    SEM_LIN_VAR v : lin 
  | SEM_LIN_IMM v : lin
  | SEM_LIN_ADD v :
  		let val o1 = df-simplify-linear v.opnd1
  			val o2 = df-simplify-linear v.opnd2
  		in case o1 of
  			SEM_LIN_IMM v1 :
  				case o2 of
  	    			SEM_LIN_IMM v2 : SEM_LIN_IMM {const= v1.const + v2.const}
  	    		  | _ : SEM_LIN_ADD {opnd1= o1, opnd2=o2}
  	    			end
  	      | _ : SEM_LIN_ADD {opnd1= o1, opnd2=o2}
  	    	end
  		end
  	end 


val df-simplify-lin-add o1 o2 =
	case o1 of
  		SEM_LIN_IMM v1 :
  			case o2 of
  	    		SEM_LIN_IMM v2 : SEM_LIN_IMM {const= v1.const + v2.const}
  	    	  | _ : SEM_LIN_ADD {opnd1= o1, opnd2=o2}
  	    		end
	  | _ : SEM_LIN_ADD {opnd1= o1, opnd2=o2}
  	    	end
