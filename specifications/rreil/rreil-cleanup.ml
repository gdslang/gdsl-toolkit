export cleanup: (sem_stmt_list) -> S sem_stmt_list <{} => {}>

type stmt_option =
   STO_MORE of sem_stmt_list
 | STO_SOME of sem_stmt
 | STO_NONE

val stmts-concat a b =
  case a of
	   SEM_CONS x: SEM_CONS {hd=x.hd, tl=(stmts-concat x.tl b)}
	 | SEM_NIL: b
	end

val ite-cleanup-trivial i = let
  val def i = STO_SOME (SEM_ITE i)
in
  case i.cond of
	   SEM_SEXPR_LIN l:
		   case l of
			    SEM_LIN_IMM z:
					  case z.const of
						   1: STO_MORE (i.then_branch)
						 | 0:	STO_MORE (i.else_branch)
						 | _: def i
						end
			  | _: def i
			 end
	 | _: def i
	end
end

val ite-cleanup-empty i = let
  val def i = STO_SOME (SEM_ITE i)
in
  case i.then_branch of
	   SEM_NIL:
		   case i.else_branch of
			    SEM_NIL: STO_NONE
			  | _: def i
			 end
	 | _: def i
  end
end

val ite-cleanup i hd tl = let
  val ic-eval fun rest =
	  case rest of
	     STO_MORE m: STO_MORE m
		 | STO_SOME s: (fun i) #Exactly one statement => if unaltered, keep optimizing
		 | STO_NONE: STO_NONE
		end
in
  case (ic-eval ite-cleanup-trivial (ite-cleanup-empty i)) of
	   STO_MORE m: stmts-concat m tl
	 | STO_SOME s: SEM_CONS {hd=s, tl=tl}
	 | STO_NONE: tl
	end
end
  
						  
val my-cleanup stmts =
  case stmts of
     SEM_CONS x:
  	   case x.hd of
  		    SEM_ITE i: ite-cleanup i x.hd (my-cleanup x.tl)
  		  | _: SEM_CONS {hd=x.hd, tl=(my-cleanup x.tl)}
  		 end
   | SEM_NIL: SEM_NIL
  end

val cleanup stmts = do
  return (my-cleanup stmts)
end
