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
############################################
#### DOCUMENTARY
############################################
# IF: Statement is a linear assignment
# STEP ONE: dump all linears from the state whose lval location is overlapping but not the same as the LVAL of the assignment
# IDEA:	1) if the lvals are equal, they can be easily updated/replaced and thus, the code optimized. So they are kept in state.
# 	2) if the lvals are not overlapping, they can be simply kept in state.
#	3) if the lvals are overlapping, updating would get complex, so they are emitted from the state and the new linear just added. This means: not optimization for this case right now
# STEP TWO: dump all linears from the state whose lval location is overlapping but not the same as the RVALs of the assignment 
# IDEA:	1) if the lvals are equal, they can be easily substituted and thus, the code optimized. So they are kept in state.
# 	2) if the lvals are not overlapping, they can be kept in state.
#	3) if the lvals are overlapping, substitution would get complex, so they are emitted from the state. This means: not optimization for this case right now
# STEP THREE: substitute the rvalues in the linear assignment with linears from the state. (Right now there should not be any overlapping values, so this is trivial)
# STEP FOUR: update the linear in the state with the substituted assignment. In case it is not there just add it to the state
#
# ELSE:
# STEP ONE: dump all linears from the state whose lval location is overlapping with the RVALs of the assignment
# STEP TWO: dump all linears from the state whose lval location is overlapping with the LVAL of the assignment
############################################
# EMITTING STATEMENTS:
# STEP ONE: remove linear from the state
# STEP TWO: emit (recursively) all linears from the state whose location is used by removed linears right hand side (RVALs)
############################################

export propagate-values : (sem_stmt_list)-> S sem_stmt_list <{} => {}>
val propagate-values stmts = subst-stmt-list-initial stmts


export subst-stmt-list-initial : (sem_stmt_list)-> S sem_stmt_list  <{} => {}>
val subst-stmt-list-initial stmts = do
	l <- subst-stmt-list-m substmap-initial stmts;
	println "==========================";
	println (rreil-show-stmts stmts);
	println "--------------------------";
	return l
	end


export subst-stmt-list-m : (subst-map, sem_stmt_list) -> S sem_stmt_list <{} => {}>
val subst-stmt-list-m state stmts = subst-stmt-list-m-helpy state stmts

# how to handle ifs (maybe also loops): check the body for variables in the state that are acccessed -> dump them beforehand
# -> do not optimize the- body, jump over it
val subst-stmt-list-m-helpy state stmts = case stmts of
		SEM_CONS s : if is-linear-assignment s.hd then do
				# emit all colliding (overlapping but equal locations from the state)
				new-state <- emit-all-required-computations-from-state (is-overlapping-but-not-equal) s.hd {temp=SEM_NIL, assign=SEM_NIL, state=state};
				# substitute the statement with computations from the state
#				emizzle <- emit-lvalue-when-its-a-sem-lin state s.hd {temp=SEM_NIL, assign=SEM_NIL, state=state};
 				new-stmt <- subst-stmt-m state s.hd;
#				new-state <- update-linear-assignment state new-stmt;
				println "removed stmt:";
				println (rreil-show-stmt s.hd);
				println "  new state:";
				println (show-substmap new-state);		
				println ".";
				continued <- subst-stmt-list-m-helpy new-state s.tl;
				return continued
				end
                              else do
				# emit statements from the state
				# check for lvalues; then for rvalues; emit; add to statements; take new state;
				update @{tmpass=0};
				new-stmts <- emit-all-required-computations-from-state (is-overlapping) s.hd {temp=SEM_NIL, assign=SEM_NIL, state=state};
				upd-stmt <- optimize-stmt s.hd new-stmts.state;
				println "> new stmts:";
				println (rreil-show-stmts new-stmts.temp);
				println (rreil-show-stmts new-stmts.assign);
				println ("> base stmt:" +++ (rreil-show-stmt s.hd));
				println ("> new  stmt:" +++ (rreil-show-stmt upd-stmt.stmt));
				println "  > new state:";
				println (show-substmap upd-stmt.state);			
				println "..";
				continued <- subst-stmt-list-m-helpy upd-stmt.state s.tl;
				return (append-stmt-list (append-stmt-list (append-stmt-list new-stmts.temp new-stmts.assign) (SEM_CONS {hd=upd-stmt.stmt, tl=SEM_NIL})) continued)
				end
	|	SEM_NIL    : return SEM_NIL
#				do
#				new-stmts <- emit-whole-state {temp=SEM_NIL, assign=SEM_NIL, state=state};
#				return (append-stmt-list new-stmts.temp new-stmts.assign)
#			     end		
	end 
	
# concatenates two stmt-lists
val append-stmt-list first second =
 case first of
    SEM_NIL : second
  | SEM_CONS x : (SEM_CONS {hd=x.hd, tl=(append-stmt-list x.tl second)})
 end

# true when the statement is a linear assignment
val is-linear-assignment stmt =
   case stmt of
      SEM_ASSIGN s :
         case s.rhs of
            SEM_SEXPR sexpr :
               case sexpr of
                  SEM_SEXPR_LIN l : '1'
                | _ : '0'
               end
          | _ : '0'
         end
    | _ : '0'
   end

# return tuple for an optimization step
type emitted-stmts-list = {temp:sem_stmt_list, assign:sem_stmt_list, state:subst-map}
type emitted-stmt-state = {stmt:sem_stmt, state:subst-map}

# recursively enters sub-stmt lists like for example in a ITE
val optimize-stmt stmt state = 
 case stmt of
    SEM_ITE s : do
	  then_b <- subst-stmt-list-m-helpy state s.then_branch; 
	  else_b <- subst-stmt-list-m-helpy state s.else_branch;
	  return {stmt=(SEM_ITE {cond=s.cond, then_branch=then_b, else_branch=else_b}), state=Substmap-empty}
	end
  | _ : return {stmt=stmt, state=state}
 end

# CRITERION: checks if this subst linears lvalue overlaps but equals the given var
val is-overlapping-but-not-equal lin var-id var-offset size = ((id-eq? lin.id var-id) and (not (lin.offset === var-offset and lin.size === size) and (not (lin.offset + lin.size <= var-offset or lin.offset >= var-offset + size))))

# CRITERION: checks if this subst linear accesses any bit of the given var
val is-overlapping lin var-id var-offset size = ((id-eq? lin.id var-id) and (not (lin.offset + lin.size <= var-offset or lin.offset >= var-offset + size))) or (sexpr-uses-location var-offset size var-id size lin.rhs)

# when a stmt uses a location whose computation is stored in the state, the computation is emitted as a statement
# in case the statement is a linear assignment, it is added to the state
# the criterion specifies if assignments are emitted that overlap or overlap-but-not-identical
# TODO: many commands are still missing
# TODO: dump all assignemnt at the end of a block? jump etc
# TODO: how to handle branches(atm dumping whole state)/if(cond, then branch, then dump all at last statement)/loops
# TODO: how to handle Prims?
val emit-all-required-computations-from-state criterion stmt emitted-stmts =
 case stmt of
    SEM_ASSIGN s : do
       it <- emit-all-vars-of-expr criterion s.rhs s.size emitted-stmts;
       emit-var-from-state criterion it.state s.lhs s.size it
     end
  | SEM_LOAD s : do
       it <- emit-all-vars-of-sem-linear (is-overlapping) s.address.address s.address.size emitted-stmts;
       emit-var-from-state (is-overlapping) it.state s.lhs s.size it
     end
  | SEM_STORE s : do
       it <- emit-all-vars-of-sem-linear (is-overlapping) s.rhs s.size emitted-stmts;
       emit-all-vars-of-sem-linear (is-overlapping) s.address.address s.address.size it
     end
  | SEM_ITE s : emit-all-vars-of-sexpr (is-overlapping) s.cond 1 emitted-stmts
  | SEM_CBRANCH s : emit-whole-state emitted-stmts
  | SEM_BRANCH s : emit-whole-state emitted-stmts
  | SEM_PRIM s : return emitted-stmts
  | SEM_THROW s : return emitted-stmts
  | _ : return emitted-stmts
 end

# emits all remaining subst-linears from the state as stmts
val emit-whole-state emitted-stmts = 
 case emitted-stmts.state of
    Substmap-empty : return emitted-stmts
  | Substmap-bind-linear linear: do
	tempvar <- mktemp-var;
	temp_assignment <- return (SEM_CONS {hd=(SEM_ASSIGN {size=linear.size, lhs=tempvar, rhs=(SEM_SEXPR linear.rhs)}), tl=emitted-stmts.temp});
	real_assignment <- return (SEM_CONS {hd=(SEM_ASSIGN {size=linear.size, lhs={id=linear.id, offset=linear.offset}, rhs=(SEM_SEXPR (SEM_SEXPR_LIN (SEM_LIN_VAR tempvar)))}), tl=emitted-stmts.assign});
	emit-whole-state {temp=temp_assignment, assign=real_assignment, state=linear.cont}
    end
  | Substmap-mark-overwritten x : emit-whole-state {temp=emitted-stmts.temp, assign=emitted-stmts.assign, state=x.cont}
 end

# dump all linears that have this var as an lvalue
val emit-var-from-state criterion state var size emitted-stmts =
 case state of
    Substmap-empty : return emitted-stmts
  | Substmap-bind-linear x : do
	result <- emit-subst-linear-from-state-as-stmt criterion x var size emitted-stmts;
	emit-var-from-state criterion x.cont var size result
    end
  | Substmap-mark-overwritten x : emit-var-from-state criterion x.cont var size emitted-stmts
 end

# create temporary variable
val mktemp-var = do
  o <- query $tmpass;
  o' <- return (o + 1);
  update @{tmpass=o'};
  return {id=VIRT_O o,offset=0}
end

# when the subst linear uses the given variable, it is removed from the state and emitted as an statement
val emit-subst-linear-from-state-as-stmt criterion linear var size emitted-stmts =
	if (criterion linear var.id var.offset size)
           then do # build statements list
		tempvar <- mktemp-var;
		temp_assignment <- return (SEM_CONS {hd=(SEM_ASSIGN {size=linear.size, lhs=tempvar, rhs=(SEM_SEXPR linear.rhs)}), tl=emitted-stmts.temp});
		real_assignment <- return (SEM_CONS {hd=(SEM_ASSIGN {size=linear.size, lhs={id=linear.id, offset=linear.offset}, rhs=(SEM_SEXPR (SEM_SEXPR_LIN (SEM_LIN_VAR tempvar)))}), tl=emitted-stmts.assign});
			println ("  >> state first: " +++ rreil-show-id var.id);
			println (show-substmap emitted-stmts.state);			
			println "  >> and then:";
			println (show-substmap (substmap-remove-linear emitted-stmts.state linear.offset linear.size linear.id));

		# emit also all vars that are used by this expression; otherwise their values are incorrect
		emit-all-vars-of-sexpr (is-overlapping) linear.rhs linear.size {temp=temp_assignment, assign=real_assignment, state=(substmap-remove-linear emitted-stmts.state linear.offset linear.size linear.id)}
	   end
           else return emitted-stmts

# checks if a subst linear uses any bit of the given var
val is-subst-linear-using-this-var lin var size = ((id-eq? lin.id var.id) and (not (lin.offset + lin.size <= var.offset or lin.offset >= var.offset + size))) or (sexpr-uses-location var.offset size var.id size lin.rhs)

val emit-all-vars-of-expr criterion expr size emitted-stmts =
       case expr of
	  SEM_SEXPR sexpr : emit-all-vars-of-sexpr criterion sexpr size emitted-stmts
	| SEM_MUL a2 : emit-all-vars-of-arity2 criterion a2 size emitted-stmts
	| SEM_DIV a2 : emit-all-vars-of-arity2 criterion a2 size emitted-stmts
	| SEM_DIVS a2 : emit-all-vars-of-arity2 criterion a2 size emitted-stmts
	| SEM_MOD a2 : emit-all-vars-of-arity2 criterion a2 size emitted-stmts
	| SEM_MODS a2 : emit-all-vars-of-arity2 criterion a2 size emitted-stmts
	| SEM_SHL a2 : emit-all-vars-of-arity2 criterion a2 size emitted-stmts
	| SEM_SHR a2 : emit-all-vars-of-arity2 criterion a2 size emitted-stmts
	| SEM_SHRS a2 : emit-all-vars-of-arity2 criterion a2 size emitted-stmts
	| SEM_AND a2 : emit-all-vars-of-arity2 criterion a2 size emitted-stmts
	| SEM_OR a2 : emit-all-vars-of-arity2 criterion a2 size emitted-stmts
	| SEM_XOR a2 : emit-all-vars-of-arity2 criterion a2 size emitted-stmts
	| SEM_SX x : emit-all-vars-of-sem-linear criterion x.opnd1 size emitted-stmts
	| SEM_ZX x : emit-all-vars-of-sem-linear criterion x.opnd1 size emitted-stmts
       end
      
val emit-all-vars-of-arity2 criterion a2 size emitted-stmts = do
	it <- emit-all-vars-of-sem-linear criterion a2.opnd1 size emitted-stmts;
	emit-all-vars-of-sem-linear criterion a2.opnd2 size it
 end

# iterate recursively through a sexpr and emit all used variables from the state
val emit-all-vars-of-sexpr criterion sexpr size emitted-stmts = 
 case sexpr of
    SEM_SEXPR_LIN linear : emit-all-vars-of-sem-linear criterion linear size emitted-stmts
  | SEM_SEXPR_CMP cmp :
       case cmp.cmp of
          SEM_CMPEQ a2 : emit-all-vars-of-arity2 criterion a2 cmp.size emitted-stmts
        | SEM_CMPNEQ a2 : emit-all-vars-of-arity2 criterion a2 cmp.size emitted-stmts
        | SEM_CMPLES a2 : emit-all-vars-of-arity2 criterion a2 cmp.size emitted-stmts
        | SEM_CMPLEU a2 : emit-all-vars-of-arity2 criterion a2 cmp.size emitted-stmts
        | SEM_CMPLTS a2 : emit-all-vars-of-arity2 criterion a2 cmp.size emitted-stmts
        | SEM_CMPLTU a2 : emit-all-vars-of-arity2 criterion a2 cmp.size emitted-stmts
       end
  | SEM_SEXPR_ARB : return emitted-stmts
 end
       
val emit-all-vars-of-sem-linear criterion linear size emitted-stmts =
 case linear of
    SEM_LIN_VAR var : emit-var-from-state criterion emitted-stmts.state var size emitted-stmts
  | SEM_LIN_IMM x : return emitted-stmts
  | SEM_LIN_ADD a2 : emit-all-vars-of-arity2 criterion a2 size emitted-stmts
  | SEM_LIN_SUB a2 : emit-all-vars-of-arity2 criterion a2 size emitted-stmts
  | SEM_LIN_SCALE s : emit-all-vars-of-sem-linear criterion s.opnd size emitted-stmts
 end







export update-with-stmt: (subst-map, sem_stmt) -> S subst-map  <{} => {}>
val update-with-stmt state stmt = case stmt of
    SEM_ASSIGN  s  : update-bind-expr state s.size s.lhs s.rhs
  | SEM_LOAD    s  : return (update-mark-var-overwritten state s.lhs.offset s.size s.lhs.id)
  | SEM_STORE   s  : return state
  | SEM_ITE     s  : return substmap-initial # no join of branches, so we "approximate"
  | SEM_WHILE   s  : return substmap-initial # no fixpoint calculation, so we "approximate"
  | SEM_CBRANCH s  : return state
  | SEM_BRANCH  s  : return state
  | SEM_FLOP    s  : return (update-mark-varl-overwritten state s.lhs)
  | SEM_PRIM    s  : return (update-mark-varl-list-overwritten state s.lhs)
  | SEM_THROW   s  : return state
	end


export update-bind-expr : (subst-map, int, sem_var, sem_expr) -> S subst-map  <{} => {}>
val update-bind-expr state size var expr = case expr of
    SEM_SEXPR sexpr : return (update-bind-sexpr state size var sexpr)
  | SEM_XOR a2      : do #println ("checking "+++rreil-show-expr expr);
  						if size === 1 and is-inverting-xor a2.opnd1 a2.opnd2
  						then do #println ("checking inv "+++rreil-show-expr expr);
  						case subst-linear-to-cond state a2.opnd1 of
  							  Nothing-sexpr :
  									return (update-bind-sexpr-inverted state size var (SEM_SEXPR_LIN a2.opnd1))
  							| Just-sexpr o1 :
  									return (update-bind-sexpr-inverted state size var o1) 
  							| Just-sexpr-inverted o1 :
  									return (update-bind-sexpr state size var o1) 
  							#TODO
  							end
  							end
  						else return (update-mark-var-overwritten state var.offset size var.id)
  						end
  | x               : return (update-mark-var-overwritten state var.offset size var.id)
    end
  
val is-inverting-xor opnd1 opnd2 = case opnd2 of
	SEM_LIN_IMM l : l.const === 1
	| x : '0'
	end
	  
export update-bind-sexpr : (subst-map, int, sem_var, sem_sexpr) -> subst-map	
val update-bind-sexpr state size var sexpr 
	=	if sexpr-does-not-ref-to-var sexpr size var 
			then update-bind-linear state var.offset size var.id sexpr
			else update-mark-var-overwritten state var.offset size var.id

export update-bind-sexpr-inverted : (subst-map, int, sem_var, sem_sexpr) -> subst-map	
val update-bind-sexpr-inverted state size var sexpr 
	=	if sexpr-does-not-ref-to-var sexpr size var 
			then update-bind-linear-inverted state var.offset size var.id sexpr
			else update-mark-var-overwritten state var.offset size var.id


export sexpr-does-not-ref-to-var : (sem_sexpr, int, sem_var) -> |1|
val sexpr-does-not-ref-to-var linear size var = case linear of
	SEM_SEXPR_LIN l  : linear-does-not-ref-to-var l size var
  | SEM_SEXPR_CMP x  : expr-cmp-does-not-ref-to-var x.cmp x.size var
  | SEM_SEXPR_ARB    : '0' # quick hack to avoid the insertion of 'arbitrary'
  end

export expr-cmp-does-not-ref-to-var : (sem_expr_cmp, int, sem_var) -> |1|
val expr-cmp-does-not-ref-to-var expr size var = case expr of
   SEM_CMPEQ s    : linear-does-not-ref-to-var s.opnd1 size var and linear-does-not-ref-to-var s.opnd2 size var
 | SEM_CMPNEQ s    : linear-does-not-ref-to-var s.opnd1 size var and linear-does-not-ref-to-var s.opnd2 size var
 | SEM_CMPLES s    : linear-does-not-ref-to-var s.opnd1 size var and linear-does-not-ref-to-var s.opnd2 size var
 | SEM_CMPLEU s    : linear-does-not-ref-to-var s.opnd1 size var and linear-does-not-ref-to-var s.opnd2 size var
 | SEM_CMPLTS s    : linear-does-not-ref-to-var s.opnd1 size var and linear-does-not-ref-to-var s.opnd2 size var
 | SEM_CMPLTU s    : linear-does-not-ref-to-var s.opnd1 size var and linear-does-not-ref-to-var s.opnd2 size var
  end


export linear-does-not-ref-to-var : (sem_linear, int, sem_var) -> |1|
val linear-does-not-ref-to-var linear size var = case linear of
	SEM_LIN_VAR var2 : vars-do-not-overlap size var var2
  | SEM_LIN_IMM s    : '1'
  | SEM_LIN_ADD s    : linear-does-not-ref-to-var s.opnd1 size var and linear-does-not-ref-to-var s.opnd2 size var 
  | SEM_LIN_SUB s    : linear-does-not-ref-to-var s.opnd1 size var and linear-does-not-ref-to-var s.opnd2 size var
  | SEM_LIN_SCALE s  : linear-does-not-ref-to-var s.opnd size var 
  end


export vars-do-not-overlap : (int, sem_var, sem_var) -> |1|
val vars-do-not-overlap size var1 var2 =
	if id-eq? var1.id var2.id
	then ranges-do-not-overlap size var1.offset var2.offset
   	else '1'


export id-eq? : (sem_id, sem_id) -> |1|
val id-eq? id1 id2 = case id1 of
  	VIRT_T v1 : case id2 of
        VIRT_T v2 : v1 === v2
      | _ : '0'
      	end 
  | _ : index id1 === index id2
    end


export ranges-do-not-overlap : (int,int,int) -> |1|
val ranges-do-not-overlap size o1 o2 = o1+size <= o2 or o2+size <= o1


export update-mark-varl-list-overwritten : (subst-map, sem_varl_list) -> subst-map
val update-mark-varl-list-overwritten state varl = case varl of
    SEM_VARLS_CONS s : update-mark-varl-list-overwritten (update-mark-varl-overwritten state s.hd) s.tl
  | SEM_VARLS_NIL    : state
	end


export update-mark-varl-overwritten : (subst-map, sem_varl) -> subst-map
val update-mark-varl-overwritten state varl = update-mark-var-overwritten state varl.offset varl.size varl.id 


export update-bind-linear : (subst-map, int, int, sem_id, sem_sexpr) -> subst-map
val update-bind-linear state offset size var linear = substmap-bind-sexpr state offset size var linear 

export update-bind-linear-inverted : (subst-map, int, int, sem_id, sem_sexpr) -> subst-map
val update-bind-linear-inverted state offset size var linear = substmap-bind-sexpr-inverted state offset size var linear 


export update-mark-var-overwritten : (subst-map, int, int, sem_id) -> subst-map
val update-mark-var-overwritten state offset size var = substmap-mark-overwritten state offset size var

