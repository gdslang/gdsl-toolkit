export = rreil-cif-userdata-set rreil-cif-userdata-get rreil-callbacks-sem-id rreil-callbacks-sem-address rreil-callbacks-sem-var rreil-callbacks-sem-linear rreil-callbacks-sem-sexpr rreil-callbacks-sem-op-cmp rreil-callbacks-sem-op rreil-callbacks-sem-stmt rreil-callbacks-branch-hint rreil-callbacks-sem-stmts rreil-callbacks rreil-convert-sem-stmts rreil-convert-sem-stmts-list

#type callbacks =
#   SEM_ID_CBS of {virt_na:string_, virt_t:string_}

val rreil-cif-userdata-set userdata = update@{userdata=userdata}
val rreil-cif-userdata-get = query $userdata

val rreil-callbacks-sem-id virt_t x86 = {virt_t=virt_t, x86=x86}
val rreil-callbacks-sem-address sem_address = {sem_address_=sem_address}
val rreil-callbacks-sem-var sem_var = {sem_var_=sem_var}
val rreil-callbacks-sem-linear sem_lin_var sem_lin_imm sem_lin_add sem_lin_sub sem_lin_scale = {sem_lin_var=sem_lin_var, sem_lin_imm=sem_lin_imm, sem_lin_add=sem_lin_add, sem_lin_sub=sem_lin_sub, sem_lin_scale=sem_lin_scale}
val rreil-callbacks-sem-sexpr sem_sexpr_lin sem_sexpr_cmp = {sem_sexpr_lin=sem_sexpr_lin, sem_sexpr_cmp=sem_sexpr_cmp}
val rreil-callbacks-sem-op-cmp sem_cmpeq sem_cmpneq sem_cmples sem_cmpleu sem_cmplts sem_cmpltu = {sem_cmpeq=sem_cmpeq, sem_cmpneq=sem_cmpneq, sem_cmples=sem_cmples, sem_cmpleu=sem_cmpleu, sem_cmplts=sem_cmplts, sem_cmpltu=sem_cmpltu}
val rreil-callbacks-sem-op sem_lin sem_mul sem_div sem_divs sem_mod sem_shl sem_shr sem_shrs sem_and sem_or sem_xor sem_sx sem_zx sem_cmp sem_arb = {sem_lin=sem_lin, sem_mul=sem_mul, sem_div=sem_div, sem_divs=sem_divs, sem_mod=sem_mod, sem_shl=sem_shl, sem_shr=sem_shr, sem_shrs=sem_shrs, sem_and=sem_and, sem_or=sem_or, sem_xor=sem_xor, sem_sx=sem_sx, sem_zx=sem_zx, sem_cmp=sem_cmp, sem_arb=sem_arb}
val rreil-callbacks-sem-stmt sem_assign sem_load sem_store sem_ite sem_while sem_cbranch sem_branch = {sem_assign=sem_assign, sem_load=sem_load, sem_store=sem_store, sem_ite=sem_ite, sem_while=sem_while, sem_cbranch=sem_cbranch, sem_branch=sem_branch}
val rreil-callbacks-branch-hint branch_hint = {branch_hint_=branch_hint}
val rreil-callbacks-sem-stmts sem_cons sem_nil = {sem_cons=sem_cons, sem_nil=sem_nil}
val rreil-callbacks-sem-stmts-list list_next list_init = {list_next=list_next, list_init=list_init}

val rreil-callbacks sem_id sem_address sem_var sem_linear sem_sexpr sem_op_cmp sem_op sem_stmt branch_hint sem_stmts sem_stmts_list = {sem_id=sem_id, sem_address=sem_address, sem_var=sem_var, sem_linear=sem_linear, sem_sexpr=sem_sexpr, sem_op_cmp=sem_op_cmp, sem_op=sem_op, sem_stmt=sem_stmt, branch_hint=branch_hint, sem_stmts=sem_stmts, sem_stmts_list=sem_stmts_list}

val rreil-convert-sem-id cbs id = case id of
#   VIRT_EQ: cbs.sem_id.virt_na (index id)
# | VIRT_NEQ: cbs.sem_id.virt_na (index id)
# | VIRT_LES: cbs.sem_id.virt_na (index id)
# | VIRT_LEU: cbs.sem_id.virt_na (index id)
# | VIRT_LTS: cbs.sem_id.virt_na (index id)
# | VIRT_LTU: cbs.sem_id.virt_na (index id)
   VIRT_T t: cbs.sem_id.virt_t t
 | _: cbs.sem_id.x86 (index id)
end

val rreil-convert-sem-address cbs address = cbs.sem_address.sem_address_ address.size (rreil-convert-sem-linear cbs address.address)

val rreil-convert-sem-var cbs var = cbs.sem_var.sem_var_ (rreil-convert-sem-id cbs var.id) var.offset

val rreil-convert-sem-linear cbs linear = case linear of
   SEM_LIN_VAR v: cbs.sem_linear.sem_lin_var (rreil-convert-sem-var cbs v)
 | SEM_LIN_IMM i: cbs.sem_linear.sem_lin_imm i.const
 | SEM_LIN_ADD a: cbs.sem_linear.sem_lin_add (rreil-convert-sem-linear cbs a.opnd1) (rreil-convert-sem-linear cbs a.opnd2)
 | SEM_LIN_SUB s: cbs.sem_linear.sem_lin_sub (rreil-convert-sem-linear cbs s.opnd1) (rreil-convert-sem-linear cbs s.opnd2)
 | SEM_LIN_SCALE s: cbs.sem_linear.sem_lin_scale s.const (rreil-convert-sem-linear cbs s.opnd)
end

val rreil-convert-sem-sexpr cbs sexpr = case sexpr of
   SEM_SEXPR_LIN l: cbs.sem_sexpr.sem_sexpr_lin (rreil-convert-sem-linear cbs l)
 | SEM_SEXPR_CMP c: cbs.sem_sexpr.sem_sexpr_cmp (rreil-convert-sem-op-cmp cbs c)
end

val rreil-convert-sem-op-cmp cbs op-cmp = case op-cmp of
   SEM_CMPEQ c: cbs.sem_op_cmp.sem_cmpeq c.size (rreil-convert-sem-linear cbs c.opnd1) (rreil-convert-sem-linear cbs c.opnd2)
 | SEM_CMPNEQ c: cbs.sem_op_cmp.sem_cmpneq c.size (rreil-convert-sem-linear cbs c.opnd1) (rreil-convert-sem-linear cbs c.opnd2)
 | SEM_CMPLES c: cbs.sem_op_cmp.sem_cmples c.size (rreil-convert-sem-linear cbs c.opnd1) (rreil-convert-sem-linear cbs c.opnd2)
 | SEM_CMPLEU c: cbs.sem_op_cmp.sem_cmpleu c.size (rreil-convert-sem-linear cbs c.opnd1) (rreil-convert-sem-linear cbs c.opnd2)
 | SEM_CMPLTS c: cbs.sem_op_cmp.sem_cmplts c.size (rreil-convert-sem-linear cbs c.opnd1) (rreil-convert-sem-linear cbs c.opnd2)
 | SEM_CMPLTU c: cbs.sem_op_cmp.sem_cmpltu c.size (rreil-convert-sem-linear cbs c.opnd1) (rreil-convert-sem-linear cbs c.opnd2)
end

val rreil-convert-sem-op cbs op = case op of
   SEM_LIN l: cbs.sem_op.sem_lin l.size (rreil-convert-sem-linear cbs l.opnd1)
 | SEM_MUL m: cbs.sem_op.sem_mul m.size (rreil-convert-sem-linear cbs m.opnd1) (rreil-convert-sem-linear cbs m.opnd2)
 | SEM_DIV d: cbs.sem_op.sem_div d.size (rreil-convert-sem-linear cbs d.opnd1) (rreil-convert-sem-linear cbs d.opnd2)
 | SEM_DIVS d: cbs.sem_op.sem_divs d.size (rreil-convert-sem-linear cbs d.opnd1) (rreil-convert-sem-linear cbs d.opnd2)
 | SEM_MOD m: cbs.sem_op.sem_mod m.size (rreil-convert-sem-linear cbs m.opnd1) (rreil-convert-sem-linear cbs m.opnd2)
 | SEM_SHL s: cbs.sem_op.sem_shl s.size (rreil-convert-sem-linear cbs s.opnd1) (rreil-convert-sem-linear cbs s.opnd2)
 | SEM_SHR s: cbs.sem_op.sem_shr s.size (rreil-convert-sem-linear cbs s.opnd1) (rreil-convert-sem-linear cbs s.opnd2)
 | SEM_SHRS s: cbs.sem_op.sem_shrs s.size (rreil-convert-sem-linear cbs s.opnd1) (rreil-convert-sem-linear cbs s.opnd2)
 | SEM_AND a: cbs.sem_op.sem_and a.size (rreil-convert-sem-linear cbs a.opnd1) (rreil-convert-sem-linear cbs a.opnd2)
 | SEM_OR o: cbs.sem_op.sem_or o.size (rreil-convert-sem-linear cbs o.opnd1) (rreil-convert-sem-linear cbs o.opnd2)
 | SEM_XOR x: cbs.sem_op.sem_xor x.size (rreil-convert-sem-linear cbs x.opnd1) (rreil-convert-sem-linear cbs x.opnd2)
 | SEM_SX s: cbs.sem_op.sem_sx s.size s.fromsize (rreil-convert-sem-linear cbs s.opnd1)
 | SEM_ZX s: cbs.sem_op.sem_zx s.size s.fromsize (rreil-convert-sem-linear cbs s.opnd1)
 | SEM_CMP c: cbs.sem_op.sem_cmp (rreil-convert-sem-op-cmp cbs c)
 | SEM_ARB a: cbs.sem_op.sem_arb a.size
end

val rreil-convert-branch-hint cbs hint = cbs.branch_hint.branch_hint_ (index hint)

val rreil-convert-sem-stmt lr cbs stmt = case stmt of
   SEM_ASSIGN s: cbs.sem_stmt.sem_assign (rreil-convert-sem-var cbs s.lhs) (rreil-convert-sem-op cbs s.rhs)
 | SEM_LOAD l: cbs.sem_stmt.sem_load (rreil-convert-sem-var cbs l.lhs) l.size (rreil-convert-sem-address cbs l.address)
 | SEM_STORE s: cbs.sem_stmt.sem_store (rreil-convert-sem-address cbs s.address) (rreil-convert-sem-op cbs s.rhs)
 | SEM_ITE i: cbs.sem_stmt.sem_ite (rreil-convert-sem-sexpr cbs i.cond) (rreil-convert-sem-stmts-lr lr cbs i.then_branch) (rreil-convert-sem-stmts-lr lr cbs i.else_branch)
 | SEM_WHILE w: cbs.sem_stmt.sem_while (rreil-convert-sem-sexpr cbs w.cond) (rreil-convert-sem-stmts-lr lr cbs w.body)
 | SEM_CBRANCH c: cbs.sem_stmt.sem_cbranch (rreil-convert-sem-sexpr cbs c.cond) (rreil-convert-sem-address cbs c.target-true) (rreil-convert-sem-address cbs c.target-false)
 | SEM_BRANCH b: cbs.sem_stmt.sem_branch (rreil-convert-branch-hint cbs b.hint) (rreil-convert-sem-address cbs b.target)
end

val rreil-convert-sem-stmts-inner lr cbs stmts = case stmts of
   SEM_CONS x: cbs.sem_stmts.sem_cons (rreil-convert-sem-stmt lr cbs x.hd) (rreil-convert-sem-stmts-inner lr cbs x.tl)
 | SEM_NIL: cbs.sem_stmts.sem_nil 42
end

val rreil-convert-sem-stmts-list-inner lr cbs stmts = case stmts of
   SEM_CONS x: cbs.sem_stmts_list.list_next (rreil-convert-sem-stmt lr cbs x.hd) (rreil-convert-sem-stmts cbs x.tl)
 | SEM_NIL: cbs.sem_stmts_list.list_init 42
end

val just-return x = x
val rreil-convert-sem-stmts cbs stmts = rreil-convert-sem-stmts-lr just-return cbs stmts

#Todo: Fix
val rreil-convert-sem-stmts-list cbs stmts = rreil-convert-sem-stmts-lr rreil-stmts-rev cbs stmts

val rreil-convert-sem-stmts-lr lr cbs stmts = rreil-convert-sem-stmts-inner lr cbs (lr stmts)

#val rreil-convert-sem-stmts-list cbs stmts = let
#  val inner list next =
#	  case next of
#		   SEM_CONS c: do
#			   list <- return (cbs.sem_stmts_list.list_next (rreil-convert-sem-stmt just-return cbs c.hd) list);
#		 	  	return (inner list c.tl)
#			 end
#		 | SEM_NIL: return list
#	  end
#in do
#  list <- return (cbs.sem_stmts_list.list_init);
#	return (inner list stmts)
#end end

