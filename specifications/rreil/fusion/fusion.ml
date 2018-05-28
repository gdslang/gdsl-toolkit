#
# procedure pfuse-bodies takes a sem_stmt_list and returns a sem_stmt_list
# with fused bodies of conditions.
#
# most simple implementation
#
#	val fuse-bodies stmts = return stmts
#
# simple example:
#
#   if a then b else c;
#   if a then d else e;
#
#   --> if a then do b; d; end else do c; e; end
#
export fuse-bodies : (sem_stmt_list)-> S sem_stmt_list <{} => {}>
val fuse-bodies stmts = fuse-bodies-stmt-list-initial stmts

val fuse-bodies-stmt-list-initial stmts = return (fuse-bodies-stmt-list stmts)

val fuse-bodies-stmt-list stmts = case stmts of
	  SEM_CONS s : case s.hd of
	  	SEM_ITE t : do
			fusable <- return (SEM_CONS {hd=t, tl=SEM_NIL});
			fusable <- return (get-fusable s.cond fusable stmts);
			head <- return (fuse-bodies-ite-list t fusable);
			tail <- return (get-remainder fusable stmts);
			continued <- return (fuse-bodies-stmt-list tail);
			return (SEM_CONS {hd=head, tl=continued})
		end
		_		  : do
			continued <- return (fuse-ite-stmt-list s.tl);
			return (SEM_CONS {hd=s.hd, tl=continued})
		end
	| SEM_NIL    : return SEM_NIL
end

val get-fusable c fusable stmts = case stmts of
	  SEM_CONS s : case s.hd of
	  	  SEM_ITE t : if (equal t.cond c) then get-fusable c (append fusable t) s.tl else fusable
		| _			: fusable
	| SEM_NIL    : fusable
end

val fuse-bodies-ite-list head tail = case tail of
	  SEM_CONS tt : case tt.hd of
		SEM_ITE t : case head of
			SEM_ITE h : fuse-bodies-ite-list (SEM_ITE {cond=h.cond,
													   then_branch=(append h.then_branch t.then_branch),
													   else_branch=(append h.else_branch t.else_branch)}) tt.tl
		end
	| SEM_NIL	  : head
end

val get-remainder fusable stmts = case fusable of
	  SEM_CONS f : case stmts of
	  	  SEM_CONS s : get-remainder f.tl s.tl
		| SEM_NIL    : stmts
	  end
	| SEM_NIL	 : stmts
end

val append a b = case a of
	  SEM_CONS s : case b of
	  	  SEM_CONS t : case s.tl of
		  	  SEM_CONS u : SEM_CONS {hd=s.hd, tl=(append u b)} 
			| SEM_NIL	 : SEM_CONS {hd=s.hd, tl=b}
		| SEM_NIL	 : a
	| SEM_NIL	 : b
end

val equal a b = case a of
	  SEM_SEXPR_LIN l  : case l of
	  	  SEM_LIN_VAR v : case v of
		  	{id, off}: case b of
				  SEM_SEXPR_LIN ll : case ll of
				  	  SEM_LIN_VAR vv : case vv of
					  	{idid, offoff} : case id of
							  ### add additional sem_ids here
							    FLOATING_FLAGS : case idid of
									  FLOATING_FLAGS : (off == offoff)
									| _				 : '0'
								end
							  | VIRT_T vt	   : case idid of
							  		  VIRT_T vtvt : if vt == vtvt then (off == offoff) else '0'
									| _			  : '0'
							    end
							  | VIRT_O vo	   : case idid of
							  		  VIRT_O vovo : if vo == vovo then (off == offoff) else '0'
									| _			  : '0'
							    end
						end
					  end
					| _				 : '0'
				  end
				| _				   : '0'
			end
		  end
		| SEM_LIN_IMM i : case i of
			{con} : case b of
				  SEM_LIN_IMM ii : case ii of
					{concon} : (con == concon)
				  end
				| _			   : '0'
			end
		  end
	  end
	| SEM_SEXPR_CMP cm : case cm of
		{sz, comp} : case b of
			  SEM_SEXPR_CMP cmcm : case cmcm of
			  	{szsz, compcomp} : case comp of
					  SEM_CMPEQ  : case compcomp of
					  	  SEM_CMPEQ : (sz == szsz)
						| _			: '0'
					  end
					| SEM_CMPNEQ : case compcomp of
					  	  SEM_CMPNEQ : (sz == szsz)
						| _			 : '0'
					  end
					| SEM_CMPLES : case compcomp of
					  	  SEM_CMPLES : (sz == szsz)
						| _			 : '0'
					  end
					| SEM_CMPLEU : case compcomp of
					  	  SEM_CMPLEU : (sz == szsz)
						| _			 : '0'
					  end
					| SEM_CMPLTS : case compcomp of
					  	  SEM_CMPLTS : (sz == szsz)
						| _			 : '0'
					  end
					| SEM_CMPLTU : case compcomp of
					  	  SEM_CMPLTU : (sz == szsz)
						| _			 : '0'
					  end
				end
			  end
			| _					 : '0'
		end
	  end
	| SEM_SEXPR_ARB    : case b of
		  SEM_SEXPR_ARB : '1'
		| _				: '0'
	  end
end