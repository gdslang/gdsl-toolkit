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
val fuse-bodies stmts = case stmts of
	  SEM_CONS s : case s.hd of
	  	  SEM_ITE t : do
			fusable <- return (SEM_CONS {hd=s.hd, tl=SEM_NIL});
			fusable <- return (get-fusable t.cond fusable s.tl);
			head <- return (fuse-ite-list fusable);
			tail <- return (get-remainder fusable stmts);
			continued <- fuse-bodies tail;
			return (SEM_CONS {hd=head, tl=continued})
		  end
		| _		  : do
			continued <- fuse-bodies s.tl;
			return (SEM_CONS {hd=s.hd, tl=continued})
		  end
	  end
	| SEM_NIL    : return SEM_NIL
end

val get-fusable c fusable stmts = case stmts of
	  SEM_CONS s : case s.hd of
		  	  SEM_ITE t : if (equal t.cond c) then get-fusable c (append fusable (SEM_CONS {hd=s.hd, tl=SEM_NIL})) s.tl else fusable
			| _			: fusable
		  end
	| SEM_NIL    : fusable
end

val fuse-ite-list fusable = case fusable of
	  SEM_CONS f : fuse-ite-list-ht f.hd f.tl
end

val fuse-ite-list-ht head tail = case tail of
	  SEM_CONS tt : case tt.hd of
		SEM_ITE t : case head of
			SEM_ITE h : fuse-ite-list-ht (SEM_ITE {cond=h.cond,
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
		  	  SEM_CONS u : SEM_CONS {hd=s.hd, tl=(append s.tl b)}
			| SEM_NIL	 : SEM_CONS {hd=s.hd, tl=b}
		  end
		| SEM_NIL	 : a
	  end
	| SEM_NIL	 : b
end

val equal a b = case a of
	  SEM_SEXPR_LIN l  : case b of
	  	  SEM_SEXPR_LIN ll : lin-eq? l ll
		| _				   : '0'
	  end
	| SEM_SEXPR_CMP cm : case b of
		  SEM_SEXPR_CMP cmcm : if cmp-eq? cm.cmp cmcm.cmp then cm.size === cmcm.size else '0'
		| _					 : '0'
	  end
	| SEM_SEXPR_ARB    : case b of
		  SEM_SEXPR_ARB : '1'
		| _				: '0'
	  end
end

val cmp-eq? cmp1 cmp2 = case cmp1 of
	  SEM_CMPEQ a  : case cmp2 of
	  	  SEM_CMPEQ b : if lin-eq? a.opnd1 b.opnd1 then lin-eq? a.opnd2 b.opnd2 else '0' 
		| _			  : '0'
	  end
	| SEM_CMPNEQ a : case cmp2 of
	  	  SEM_CMPNEQ b : if lin-eq? a.opnd1 b.opnd1 then lin-eq? a.opnd2 b.opnd2 else '0'
		| _			   : '0'
	  end
	| SEM_CMPLES a : case cmp2 of
	  	  SEM_CMPLES b : if lin-eq? a.opnd1 b.opnd1 then lin-eq? a.opnd2 b.opnd2 else '0'
		| _			   : '0'
	  end
	| SEM_CMPLEU a : case cmp2 of
	  	  SEM_CMPLEU b : if lin-eq? a.opnd1 b.opnd1 then lin-eq? a.opnd2 b.opnd2 else '0'
		| _			   : '0'
	  end
	| SEM_CMPLTS a : case cmp2 of
	  	  SEM_CMPLTS b : if lin-eq? a.opnd1 b.opnd1 then lin-eq? a.opnd2 b.opnd2 else '0'
		| _			   : '0'
	  end
	| SEM_CMPLTU a :case cmp2 of
	  	  SEM_CMPLTU b : if lin-eq? a.opnd1 b.opnd1 then lin-eq? a.opnd2 b.opnd2 else '0'
		| _			   : '0'
	  end
end

val lin-eq? lin1 lin2 = case lin1 of
	  SEM_LIN_VAR v : case lin2 of
	  	  SEM_LIN_VAR vv : if id-eq? v.id vv.id then v.offset === vv.offset else '0'
		| _				 : '0'
	  end
	| SEM_LIN_IMM i : case lin2 of
	  	  SEM_LIN_IMM ii : i.const === ii.const
		| _				 : '0'
	  end
end