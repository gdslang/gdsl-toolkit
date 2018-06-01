#
# procedure fuse-bodies takes a sem_stmt_list and returns a sem_stmt_list
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

# do a fusion of ITEs on a list of statements
#
# Parameter:
#    list of statements
# 
# Returns:
#    list of statements with inlined right hand sides
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
		| _		  : do
			continued <- return (fuse-bodies-stmt-list s.tl);
			return (SEM_CONS {hd=s.hd, tl=continued})
		end
	  end
	| SEM_NIL    : return SEM_NIL
end

val get-fusable c fusable stmts = case stmts of
	  SEM_CONS s : case s.hd of
	  	  SEM_ITE t : if (equal t.cond c) then get-fusable c (append fusable t) s.tl else fusable
		| _			: fusable
	  end
	| SEM_NIL    : fusable
end

val fuse-bodies-ite-list head tail = case tail of
	  SEM_CONS tt : case tt.hd of
		SEM_ITE t : case head of
			SEM_ITE h : fuse-bodies-ite-list (SEM_ITE {cond=h.cond,
													   then_branch=(append h.then_branch t.then_branch),
													   else_branch=(append h.else_branch t.else_branch)}) tt.tl
		end
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
		  end
		| SEM_NIL	 : a
	  end
	| SEM_NIL	 : b
end

val equal a b = case a of
	  SEM_SEXPR_LIN l  : case l of
	  	  SEM_LIN_VAR v : case b of
		  	  SEM_SEXPR_LIN ll : case ll of
				  SEM_LIN_VAR vv : case v.id of
					  VIRT_T vt	   : case vv.id of
						  VIRT_T vtvt : if vt === vtvt then v.offset === vv.offset else '0'
						| _			  : '0'
					  end
					| VIRT_O vo	   : case vv.id of
						  VIRT_O vovo : if vo === vovo then v.offset === vv.offset else '0'
						| _			  : '0'
					  end
					| _			   : case vv.id of
						  VIRT_T vtvt : '0'
						| VIRT_O vovo : '0'
						| _			  : if (index v.id) === (index vv.id) then v.offset === vv.offset else '0'
					  end
				  end
				| _				 : '0'
			  end
		  end
		| SEM_LIN_IMM i : case b of
			  SEM_SEXPR_LIN ll : case ll of
			  	  SEM_LIN_IMM ii : i.const === ii.const
				| _			   : '0'
			  end
			| _				   : '0'
		  end
	  end
	| SEM_SEXPR_CMP cm : case b of
		  SEM_SEXPR_CMP cmcm : (cm.size === cmcm.size) and (cm.cmp === cmcm.cmp) 
		| _					 : '0'
	  end
	| SEM_SEXPR_ARB    : case b of
		  SEM_SEXPR_ARB : '1'
		| _				: '0'
	  end
end