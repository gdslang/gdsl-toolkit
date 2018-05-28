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
	  	  SEM_ITE t : get-fusable c (append fusable t) s.tl
		| _			: fusable
	| SEM_NIL    : fusable
end

val fuse-bodies-ite-list head tail = case tail of
	  SEM_CONS tt : case tt.hd of
		SEM_ITE t : case head of
			SEM_ITE h : fuse-bodies-ite-list (SEM_ITE {cond=t.cond,
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