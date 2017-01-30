#
# procedure propagate-values takes a sem_stmt_list and return a sem_stmt_list
# with inlined linear expressions (whose value can depend on itself)
#
# most simple implementation (no optimization though):
#
#   val propagate-values stmts = return stmts  
#
# what it will do:
# => fuse sequences like {ip=ip+n;...;ip=i+m} to {...;ip=ip+(n+m)}  
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
#### ALGORITHM DOCUMENTARY
############################################
# IF: Statement is a linear assignment
# STEP ONE: dump all linears from the state whose lval location is overlapping but not the same as the LVAL of the assignment
# IDEA: 1) if the lvals are equal, they can be easily updated/replaced and thus, the code optimized. So they are kept in state.
#   2) if the lvals are not overlapping, they can be simply kept in state.
# 3) if the lvals are overlapping, updating would get complex, so they are emitted from the state and the new linear just added. This means: no optimization for this case right now
# STEP TWO: dump all linears from the state whose lval location is overlapping but not a superset of the RVALs of the assignment 
# IDEA: 1) if an lval is a superset, it can be easily substituted into the right hand side of the statement and thus, the code optimized. So they are kept in state.
#   2) if an lval is not overlapping, it can simply be kept in state.
# 3) if an lval is overlapping, substitution would get complex, but they cannot be kept in state => emitting from state. This means: no optimization right now
# STEP THREE: substitute the rvalues in the linear assignment with linears (definitions) from the state. (At this point there should not be any overlapping values => trivial substitution)
# STEP FOUR: update the linear in the state with the substituted definition. In case it is not already there, add it to the state
#
# ELSE:
# STEP ONE: dump all linears from the state whose right hand side accesses the lval of the assignment or load
# IDEA: 1) if rhs overlaps, this linear must be emitted from the state, since a value of its rhs changes.
# IDEA: 2) if rhs doesn't overlap, this linear can be kept in state, since it's not dependant on the overwritten variable.
# STEP TWO: dump all linears from the state whose lval location is overlapping but a superset of the RVALs of the assignment 
# IDEA: 1) if an lval is a superset, it can be easily substituted into the right hand side of the statement and thus, the code optimized. So they are kept in state.
#   2) if an lval is not overlapping, it can simply be kept in state.
# 3) if an lval is overlapping, substitution would get complex, but they cannot be kept in state => emitting from state. This means: no optimization right now
# STEP THREE: substitute the rvalues in the statement with linears (definitions) from the state. (At this point there should not be any overlapping values => trivial substitution)
# STEP FOUR: remove the lvalue of the statement (in case it's an assignment or load) from the state, since it's value gets overwritten
############################################
# HANDLING WHILES: dump everything that is accessed in any way directly before the loop
# IF-THEN_ELSES: dump everything that is accessed in any way directly before the ifte
# PRIMITIVES & FLOPS: dump every location that is accessed, but only remove lvalues from state when they use the exact location as the state linear
############################################
# EMITTING LINEARS AS STATEMENTS:
# STEP ONE: remove linear from the state
# STEP TWO: Transform linear to an assignment statement and emit it
# STEP THREE: emit (recursively) all linears from the state that use the emitted linear in their right hand side (RVALs)
############################################



export delayed-fsubst-propagate-values : (sem_stmt_list)-> S sem_stmt_list <{} => {}>
val delayed-fsubst-propagate-values stmts = do update @{tmpass=0}; delayed-fsubst-stmt-list-initial stmts end


val delayed-fsubst-stmt-list-initial stmts = do
  l <- delayed-substitute-stmt-list df-substmap-initial stmts;
  #println "==========================";
  #println (rreil-show-stmts stmts);
  #println "--------------------------";
  return l
  end

val delayed-substitute-stmt-list state stmts = case stmts of
    SEM_CONS s : if is-linear-assignment s.hd then do
        # emit all colliding (overlapping but not equal locations from the state)
        cleaned_state <- emit-all-required-computations-from-state (lval-is-overlapping-but-not-equal) (lval-is-overlapping-but-no-superset) s.hd {temp=SEM_NIL, assign=SEM_NIL, state=state};
        # replace the statement's expression with definitions from the state
        new-stmt <- substitute-stmt-with-state-definitions cleaned_state.state s.hd;
        # push the new statement to the state
        #println "< current state:";
        #println (df-show-substmap cleaned_state.state);    
        new-state <- update-state-with-statement cleaned_state.state new-stmt;

        #println ("< rem stmt: " +++ (rreil-show-stmt s.hd) +++ "   substitutedXXX to   " +++ (rreil-show-stmt new-stmt));
        #println " > emitted stmts:";
        #println (rreil-show-stmts cleaned_state.temp);
        #println (rreil-show-stmts cleaned_state.assign);
        #println "< new state:";
        #println (df-show-substmap new-state);    
        #println ".......................";

        # concatenate the emitted statements list with the recursive optimized list
        continued <- delayed-substitute-stmt-list new-state s.tl;
        return (append-stmt-list (append-stmt-list cleaned_state.temp cleaned_state.assign) continued)
        end
                              else do
        cleaned_state <- emit-all-required-computations-from-state (lval-is-overlapping-but-not-equal-or-rvals-are-overlapping) (lval-is-overlapping-but-no-superset) s.hd {temp=SEM_NIL, assign=SEM_NIL, state=state};
        # substitute all expressions with definitions from the state
        new-stmt <- substitute-stmt-with-state-definitions cleaned_state.state s.hd;
        # remove lval from state since it's overwritten
        new-state <- remove-overwritten-definition-from-state cleaned_state.state s.hd;

        #println ("> org stmt: " +++ (rreil-show-stmt s.hd) +++ "   substituted to   " +++ (rreil-show-stmt new-stmt));
        #println " > emitted stmts:";
        #println (rreil-show-stmts cleaned_state.temp);
        #println (rreil-show-stmts cleaned_state.assign);
        #println " > new state:";
        #println (df-show-substmap new-state);      
        #println ".......................";

        
        # concatenate the emitted statements list with the recursive optimized list and the updated statement
        continued <- delayed-substitute-stmt-list new-state s.tl;
        return (append-stmt-list (append-stmt-list (append-stmt-list cleaned_state.temp cleaned_state.assign) (SEM_CONS {hd=new-stmt, tl=SEM_NIL})) continued)
        end
  | SEM_NIL    : do
        new-stmts <- emit-whole-state {temp=SEM_NIL, assign=SEM_NIL, state=state};
        return (append-stmt-list new-stmts.temp new-stmts.assign)
           end    
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

# removes (in case there is one) existing definition from the state and pushes the new one
val update-state-with-statement state stmt = 
 case stmt of
    SEM_ASSIGN s :
       case s.rhs of
          SEM_SEXPR sexpr : return (df-substmap-update-linear state s.lhs.offset s.size s.lhs.id (SEM_SEXPR (simplify-sem-sexpr sexpr)))
       end
 end

# removes (in case there is one) existing definition from the state
val remove-overwritten-definition-from-state state stmt = 
 case stmt of
    SEM_ASSIGN s : return (df-substmap-remove-linear state s.lhs.offset s.size s.lhs.id)
  | SEM_LOAD s : return (df-substmap-remove-linear state s.lhs.offset s.size s.lhs.id)
  | SEM_FLOP s : return (df-substmap-remove-linear state s.lhs.offset s.lhs.size s.lhs.id)
  | SEM_PRIM s : remove-overwritten-varl-list-from-state state s.lhs 
  | _ : return state
 end

# removes all varls of the list from the state
val remove-overwritten-varl-list-from-state state list = 
 case list of
    SEM_VARLS_NIL : return state
  | SEM_VARLS_CONS v : remove-overwritten-varl-list-from-state (df-substmap-remove-linear state v.hd.offset v.hd.size v.hd.id) v.tl
 end
    

# return tuple for an optimization step; the emitted statements and the new state
type emitted-stmts-list = {temp:sem_stmt_list, assign:sem_stmt_list, state:df-subst-map}

# emits every location from the state that is accessed in any way
val emit-all-accesses-in-stmt-list-from-state stmt-list emitted-stmts = 
 case stmt-list of
    SEM_CONS x : do
    it <- emit-all-required-computations-from-state (anything-is-overlapping) (anything-is-overlapping) x.hd emitted-stmts;
    emit-all-accesses-in-stmt-list-from-state x.tl it
  end
  | SEM_NIL : return emitted-stmts
 end

val integer-max a b = if a > b then a else b
val integer-min a b = if a < b then a else b
val intervals-intersect a-offset a-size b-offset b-size = if ((integer-max a-offset b-offset) <= (integer-min (a-offset + a-size) (b-offset + b-size))) then '1' else '0'

# CRITERION: checks if this subst linears lvalue overlaps but is no superset of the given var
val lval-is-overlapping-but-no-superset lin var-id var-offset size = (id-eq? lin.id var-id) and ((lin.offset > var-offset) or (lin.offset + lin.size < var-offset + size)) and ((lin.offset + lin.size > var-offset) and (var-offset + size > lin.offset))

# CRITERION: checks if this subst linears lvalue overlaps but not equals the given var
val lval-is-overlapping-but-not-equal lin var-id var-offset size = (id-eq? lin.id var-id) and ((not (lin.offset === var-offset)) or (not (lin.size === size))) and (intervals-intersect lin.offset lin.offset var-offset size)

# CRITERION: checks if this subst linears lvalue overlaps the given var
val lval-is-overlapping lin var-id var-offset size = (id-eq? lin.id var-id) and (intervals-intersect lin.offset lin.size var-offset size)

# CRITERION: checks if this subst linears rvalues access any bit of the given var
val lval-is-overlapping-but-not-equal-or-rvals-are-overlapping lin var-id var-offset size = (lval-is-overlapping-but-not-equal lin var-id var-offset size) or (df-expr-uses-location var-offset size var-id size lin.rhs)

# CRITERION: checks if this subst linear accesses any bit of the given var
val anything-is-overlapping lin var-id var-offset size = ((id-eq? lin.id var-id) and (intervals-intersect lin.offset lin.size var-offset size)) or (df-expr-uses-location var-offset size var-id size lin.rhs)

# CRITERION: checks if this subst linear accesses anything from of the given location id
val id-is-overlapping lin var-id var-offset size = (id-eq? lin.id var-id) or (df-expr-uses-id var-id lin.rhs)


# emit everything from the state that cannot be simply substituted in the given stmt
# criterion-lhs is for all left hand side values and criterion.rhs for right hand side values
val emit-all-required-computations-from-state criterion-lhs criterion-rhs stmt emitted-stmts =
 case stmt of
    SEM_ASSIGN s : do
       it <- emit-var-from-state criterion-lhs emitted-stmts.state s.lhs s.size emitted-stmts;
       emit-all-vars-of-expr criterion-rhs s.rhs s.size it
     end
  | SEM_LOAD s : do
       it <- emit-var-from-state criterion-lhs emitted-stmts.state s.lhs s.size emitted-stmts;
       emit-all-vars-of-sem-linear criterion-rhs s.address.address s.address.size it
     end
  | SEM_STORE s : do
       it <- emit-all-vars-of-sem-linear criterion-rhs s.rhs s.size emitted-stmts;
       emit-all-vars-of-sem-linear (lval-is-overlapping-but-not-equal) s.address.address s.address.size it
     end
  | SEM_ITE s : do
       it <- emit-all-vars-of-expr criterion-rhs (SEM_SEXPR s.cond) 1 emitted-stmts;
       it_then <- emit-all-accesses-in-stmt-list-from-state s.then_branch it;
       emit-all-accesses-in-stmt-list-from-state s.else_branch it_then
     end
  | SEM_WHILE s : do
       it <- emit-all-vars-of-expr (anything-is-overlapping) (SEM_SEXPR s.cond) 1 emitted-stmts;
       emit-all-accesses-in-stmt-list-from-state s.body it
     end
  | SEM_CBRANCH s : emit-whole-state emitted-stmts
  | SEM_BRANCH s : emit-whole-state emitted-stmts
  | SEM_FLOP s : do
       it1 <- emit-id-from-state emitted-stmts.state s.flags emitted-stmts;
       it2 <- emit-var-from-state criterion-lhs emitted-stmts.state s.lhs s.lhs.size it1;
       emit-all-vars-of-varl-list (lval-is-overlapping) s.rhs it2
     end
  | SEM_PRIM s : do
       it <- emit-all-vars-of-varl-list criterion-lhs s.lhs emitted-stmts;
       emit-all-vars-of-varl-list (lval-is-overlapping) s.rhs it
     end
  | SEM_THROW s : return emitted-stmts
 end

# emits all remaining subst-linears from the state as stmts
val emit-whole-state emitted-stmts = 
 case emitted-stmts.state of
    SUBSTMAP_EMPTY : return emitted-stmts
  | SUBSTMAP_LINEAR linear: do
  tempvar <- mktemp-var;
  temp_assignment <- return (SEM_CONS {hd=(SEM_ASSIGN {size=linear.size, lhs=tempvar, rhs=linear.rhs}), tl=emitted-stmts.temp});
  real_assignment <- return (SEM_CONS {hd=(SEM_ASSIGN {size=linear.size, lhs={id=linear.id, offset=linear.offset}, rhs=(SEM_SEXPR (SEM_SEXPR_LIN (SEM_LIN_VAR tempvar)))}), tl=emitted-stmts.assign});
  emit-whole-state {temp=temp_assignment, assign=real_assignment, state=linear.cont}
    end
 end

# dump all linears whose lval/rvals overlap (based on the criterion) with the given var
val emit-var-from-state criterion state var size emitted-stmts =
 case state of
    SUBSTMAP_EMPTY : return emitted-stmts
  | SUBSTMAP_LINEAR x : do
  result <- emit-subst-linear-from-state-as-stmt criterion x var size emitted-stmts;
  emit-var-from-state criterion x.cont var size result
    end
 end

val emit-all-vars-of-varl-list criterion list emitted-stmts = 
 case list of
    SEM_VARLS_NIL : return emitted-stmts
  | SEM_VARLS_CONS v : do
        it <- emit-var-from-state criterion emitted-stmts.state v.hd v.hd.size emitted-stmts;
        emit-all-vars-of-varl-list criterion  v.tl it
    end
 end

# emit everything that uses this location id
val emit-id-from-state state var emitted-stmts =
 case state of
    SUBSTMAP_EMPTY : return emitted-stmts
  | SUBSTMAP_LINEAR x : do
  result <- emit-subst-linear-from-state-as-stmt (id-is-overlapping) x var 1 emitted-stmts;
  emit-id-from-state x.cont var result
    end
 end


# create temporary variable
val mktemp-var = do
  o <- query $tmpass;
  o' <- return (o + 1);
  update @{tmpass=o'};
  return {id=VIRT_O o,offset=0}
end

# when the subst linear's lval overlaps with the location of the given var, the linear is removed from the state and emitted as an statement
val emit-subst-linear-from-state-as-stmt criterion linear var size emitted-stmts =
  if (criterion linear var.id var.offset size)
           then do # build statements list
    tempvar <- mktemp-var;
    temp_assignment <- return (SEM_CONS {hd=(SEM_ASSIGN {size=linear.size, lhs=tempvar, rhs=linear.rhs}), tl=emitted-stmts.temp});
    real_assignment <- return (SEM_CONS {hd=(SEM_ASSIGN {size=linear.size, lhs={id=linear.id, offset=linear.offset}, rhs=(SEM_SEXPR (SEM_SEXPR_LIN (SEM_LIN_VAR tempvar)))}), tl=emitted-stmts.assign});
      #println ("  >> state first: " +++ rreil-show-id var.id);

#     println (" 1) " +++ (if (lval-is-overlapping-but-no-superset linear var.id var.offset size) then "Y" else "N"));
#     println (" 2) " +++ (if (lval-is-overlapping-but-not-equal-or-rvals-are-overlapping linear var.id var.offset size) then "Y" else "N"));
#     println (" 3) " +++ (if (anything-is-overlapping linear var.id var.offset size) then "Y" else "N"));
#     println (" 4) " +++ (if (id-is-overlapping linear var.id var.offset size) then "Y" else "N"));
#     println (" 5) " +++ (if (partaa linear var.id var.offset size) then "Y" else "N"));
#     println (" 6) " +++ (if (partbb linear var.id var.offset size) then "Y" else "N"));

      #println (df-show-substmap emitted-stmts.state);      
      #println "  >> and then:";
      #println (df-show-substmap (df-substmap-remove-linear emitted-stmts.state linear.offset linear.size linear.id));

    upd-state <- return {temp=temp_assignment, assign=real_assignment, state=(df-substmap-remove-linear emitted-stmts.state linear.offset linear.size linear.id)};
    # emit also all linears that use this expression; otherwise their values will be incorrect
    emit-all-definitions-that-use-this-var upd-state.state var linear.size upd-state 
     end
           else return emitted-stmts

val emit-all-definitions-that-use-this-var state var size emitted-stmts = 
 case state of
    SUBSTMAP_EMPTY : return emitted-stmts
  | SUBSTMAP_LINEAR x : do
  if (df-expr-uses-location var.offset size var.id size x.rhs)
     then do # dump this linear
    result <- emit-var-from-state (anything-is-overlapping) emitted-stmts.state {id=x.id, offset=x.offset} size emitted-stmts;
    emit-all-definitions-that-use-this-var x.cont var size result
     end
           else emit-all-definitions-that-use-this-var x.cont var size emitted-stmts
    end
 end


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

val simplify-sem-sexpr sexpr =
 case sexpr of
    SEM_SEXPR_LIN linear : SEM_SEXPR_LIN (simplify-sem-lin linear 0)
  | SEM_SEXPR_CMP cmp :
       case cmp.cmp of
          SEM_CMPEQ a2 : SEM_SEXPR_CMP {size=cmp.size, cmp=(SEM_CMPEQ {opnd1=(simplify-sem-lin a2.opnd1 0), opnd2=(simplify-sem-lin a2.opnd2 0)})}
        | SEM_CMPNEQ a2 : SEM_SEXPR_CMP {size=cmp.size, cmp=(SEM_CMPNEQ {opnd1=(simplify-sem-lin a2.opnd1 0), opnd2=(simplify-sem-lin a2.opnd2 0)})}
        | SEM_CMPLES a2 : SEM_SEXPR_CMP {size=cmp.size, cmp=(SEM_CMPLES {opnd1=(simplify-sem-lin a2.opnd1 0), opnd2=(simplify-sem-lin a2.opnd2 0)})}
        | SEM_CMPLEU a2 : SEM_SEXPR_CMP {size=cmp.size, cmp=(SEM_CMPLEU {opnd1=(simplify-sem-lin a2.opnd1 0), opnd2=(simplify-sem-lin a2.opnd2 0)})}
        | SEM_CMPLTS a2 : SEM_SEXPR_CMP {size=cmp.size, cmp=(SEM_CMPLTS {opnd1=(simplify-sem-lin a2.opnd1 0), opnd2=(simplify-sem-lin a2.opnd2 0)})}
        | SEM_CMPLTU a2 : SEM_SEXPR_CMP {size=cmp.size, cmp=(SEM_CMPLTU {opnd1=(simplify-sem-lin a2.opnd1 0), opnd2=(simplify-sem-lin a2.opnd2 0)})}
       end
  | SEM_SEXPR_ARB : SEM_SEXPR_ARB
 end

val simplify-sem-lin lin imm = 
 let
    val f l = if (imm === 0) then l else if (imm < 0) then SEM_LIN_SUB {opnd1=l, opnd2=(SEM_LIN_IMM {const=(0 - imm)})} else SEM_LIN_ADD {opnd1=l, opnd2=(SEM_LIN_IMM {const=imm})} 
 in
 case lin of
    SEM_LIN_VAR v: f lin
  | SEM_LIN_IMM i: SEM_LIN_IMM {const=(imm + i.const)}
  | SEM_LIN_ADD a:
       case a.opnd1 of
          SEM_LIN_IMM x : simplify-sem-lin a.opnd2 (imm + x.const)
  | _ : case a.opnd2 of
     SEM_LIN_IMM x : simplify-sem-lin a.opnd1 (imm + x.const)
               | _ : f (SEM_LIN_ADD {opnd1=(simplify-sem-lin a.opnd1 0), opnd2=(simplify-sem-lin a.opnd2 0)})
        end 
       end
  | SEM_LIN_SUB a:
       case a.opnd1 of
          SEM_LIN_IMM x : simplify-sem-lin a.opnd2 (imm - x.const)
  | _ : case a.opnd2 of
     SEM_LIN_IMM x : simplify-sem-lin a.opnd1 (imm - x.const)
               | _ : f (SEM_LIN_SUB {opnd1=(simplify-sem-lin a.opnd1 0), opnd2=(simplify-sem-lin a.opnd2 0)})
        end
       end
  | SEM_LIN_SCALE s :
       case s.opnd of
          SEM_LIN_IMM x : SEM_LIN_IMM {const=(x.const * s.const)}
        | _ : SEM_LIN_SCALE {const=s.const, opnd=(simplify-sem-lin s.opnd 0)}
       end
 end
end
