

val simplify-linear lin = case lin of
    SEM_LIN_VAR v : lin 
  | SEM_LIN_IMM v : lin
  | SEM_LIN_ADD v :
  		let val o1 = simplify-linear v.opnd1
  			val o2 = simplify-linear v.opnd2
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


val simplify-lin-add o1 o2 =
	case o1 of
  		SEM_LIN_IMM v1 :
  			case o2 of
  	    		SEM_LIN_IMM v2 : SEM_LIN_IMM {const= v1.const + v2.const}
  	    	  | _ : SEM_LIN_ADD {opnd1= o1, opnd2=o2}
  	    		end
	  | _ : SEM_LIN_ADD {opnd1= o1, opnd2=o2}
  	    	end

#type sem_linear =
#   SEM_LIN_VAR of sem_var
# | SEM_LIN_IMM of {const:int}
# | SEM_LIN_ADD of sem_arity2
# | SEM_LIN_SUB of sem_arity2
# | SEM_LIN_SCALE of {const:int, opnd:sem_linear}
