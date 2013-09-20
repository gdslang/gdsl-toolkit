export = rreil-sem-stmts-head rreil-sem-stmts-tail rreil-sem-stmts-has-more
   rreil-sem-varls-head rreil-sem-varls-tail rreil-sem-varls-has-more
   rreil-cif-userdata-set rreil-cif-userdata-get{userdata}
   rreil-convert-sem-varl{sem_varl, sem_id, offset, size, id}
   rreil-convert-sem-stmt-manual{branch_hint, sem_stmt, sem_flop, sem_varl, sem_expr, sem_op_cmp, sem_sexpr, sem_linear, sem_var, sem_address, sem_id, sem_prim}
   rreil-convert-sem-stmts{sem_stmts, branch_hint, sem_stmt, sem_flop, sem_varls, sem_varl, sem_expr, sem_op_cmp, sem_sexpr, sem_linear, sem_var, sem_address, sem_id, sem_prim}

#type callbacks =
#   SEM_ID_CBS of {virt_na:string_, virt_t:string_}

type sem_id_callbacks = {shared:int, virt_t:int, arch:int}
type sem_address_callbacks = {sem_address_:int}
type sem_var_callbacks = {sem_var_:int}
type sem_linear_callbacks = {sem_lin_var:int, sem_lin_imm:int, sem_lin_add:int, sem_lin_sub:int, sem_lin_scale:int}
type sem_sexpr_callbacks = {sem_sexpr_lin:int, sem_sexpr_cmp:int, sem_sexpr_arb:int}
type sem_op_cmp_callbacks = {sem_cmpeq:int, sem_cmpneq:int, sem_cmples:int, sem_cmpleu:int, sem_cmplts:int, sem_cmpltu:int}
type sem_expr_callbacks = {sem_sexpr:int, sem_mul:int, sem_div:int, sem_divs:int, sem_mod:int, sem_shl:int, sem_shr:int, sem_shrs:int, sem_and:int, sem_or:int, sem_xor:int, sem_sx:int, sem_zx:int}
type sem_varl_callbacks = {sem_varl_:int}
type sem_varls_callbacks = {sem_varls_next:int, sem_varls_init:int}
type sem_flop_callbacks = {sem_flop_:int}
type sem_stmt_callbacks = {sem_assign:int, sem_load:int, sem_store:int, sem_ite:int, sem_while:int, sem_cbranch:int, sem_branch:int, sem_flop:int, sem_prim:int}
type branch_hint_callbacks = {branch_hint_:int}
type sem_stmts_callbacks = {next:int, init:int}
#type sem_stmts_list_callbacks = {list_next:int, list_init:int}

type callbacks = {
  sem_id:sem_id_callbacks,
  sem_address:sem_address_callbacks,
  sem_var:sem_var_callbacks,
  sem_linear:sem_linear_callbacks,
  sem_sexpr:sem_sexpr_callbacks,
  sem_op_cmp:sem_op_cmp_callbacks,
  sem_expr:sem_expr_callbacks,
  sem_varl:sem_varl_callbacks,
  sem_varls:sem_varls_callbacks,
  sem_flop:sem_flop_callbacks,
  sem_stmt:sem_stmt_callbacks,
  branch_hint:branch_hint_callbacks,
  sem_stmts:sem_stmts_callbacks
}

val rreil-cif-userdata-set userdata = update@{userdata=userdata}
val rreil-cif-userdata-get = query $userdata

#val rreil-callbacks-sem-id virt_t arch = {virt_t=virt_t, arch=arch}
#val rreil-callbacks-sem-address sem_address = {sem_address_=sem_address}
#val rreil-callbacks-sem-var sem_var = {sem_var_=sem_var}
#val rreil-callbacks-sem-linear sem_lin_var sem_lin_imm sem_lin_add sem_lin_sub sem_lin_scale = {sem_lin_var=sem_lin_var, sem_lin_imm=sem_lin_imm, sem_lin_add=sem_lin_add, sem_lin_sub=sem_lin_sub, sem_lin_scale=sem_lin_scale}
#val rreil-callbacks-sem-sexpr sem_sexpr_lin sem_sexpr_cmp = {sem_sexpr_lin=sem_sexpr_lin, sem_sexpr_cmp=sem_sexpr_cmp}
#val rreil-callbacks-sem-op-cmp sem_cmpeq sem_cmpneq sem_cmples sem_cmpleu sem_cmplts sem_cmpltu = {sem_cmpeq=sem_cmpeq, sem_cmpneq=sem_cmpneq, sem_cmples=sem_cmples, sem_cmpleu=sem_cmpleu, sem_cmplts=sem_cmplts, sem_cmpltu=sem_cmpltu}
#val rreil-callbacks-sem-op sem_lin sem_mul sem_div sem_divs sem_mod sem_shl sem_shr sem_shrs sem_and sem_or sem_xor sem_sx sem_zx sem_cmp sem_arb = {sem_lin=sem_lin, sem_mul=sem_mul, sem_div=sem_div, sem_divs=sem_divs, sem_mod=sem_mod, sem_shl=sem_shl, sem_shr=sem_shr, sem_shrs=sem_shrs, sem_and=sem_and, sem_or=sem_or, sem_xor=sem_xor, sem_sx=sem_sx, sem_zx=sem_zx, sem_cmp=sem_cmp, sem_arb=sem_arb}
#val rreil-callbacks-sem-stmt sem_assign sem_load sem_store sem_ite sem_while sem_cbranch sem_branch = {sem_assign=sem_assign, sem_load=sem_load, sem_store=sem_store, sem_ite=sem_ite, sem_while=sem_while, sem_cbranch=sem_cbranch, sem_branch=sem_branch}
#val rreil-callbacks-branch-hint branch_hint = {branch_hint_=branch_hint}
#val rreil-callbacks-sem-stmts sem_cons sem_nil = {sem_cons=sem_cons, sem_nil=sem_nil}
#val rreil-callbacks-sem-stmts-list list_next list_init = {list_next=list_next, list_init=list_init}
#val rreil-callbacks sem_id sem_address sem_var sem_linear sem_sexpr sem_op_cmp sem_expr sem_stmt branch_hint sem_stmts sem_stmts_list = {sem_id=sem_id, sem_address=sem_address, sem_var=sem_var, sem_linear=sem_linear, sem_sexpr=sem_sexpr, sem_op_cmp=sem_op_cmp, sem_expr=sem_expr, sem_stmt=sem_stmt, branch_hint=branch_hint, sem_stmts=sem_stmts, sem_stmts_list=sem_stmts_list}

val rreil-convert-sem-id cbs id = case id of
#   VIRT_EQ: cbs.sem_id.virt_na (index id)
# | VIRT_NEQ: cbs.sem_id.virt_na (index id)
# | VIRT_LES: cbs.sem_id.virt_na (index id)
# | VIRT_LEU: cbs.sem_id.virt_na (index id)
# | VIRT_LTS: cbs.sem_id.virt_na (index id)
# | VIRT_LTU: cbs.sem_id.virt_na (index id)
   FLOATING_FLAGS: cbs.sem_id.shared (index id)
 | VIRT_T t: cbs.sem_id.virt_t t
 | _: cbs.sem_id.arch (index id)
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
 | SEM_SEXPR_ARB: cbs.sem_sexpr.sem_sexpr_arb void #Note: init is a function and, hence, has to be called by applying it to an argument
end

val rreil-convert-sem-op-cmp cbs op-cmp = case op-cmp of
   SEM_CMPEQ c: cbs.sem_op_cmp.sem_cmpeq c.size (rreil-convert-sem-linear cbs c.opnd1) (rreil-convert-sem-linear cbs c.opnd2)
 | SEM_CMPNEQ c: cbs.sem_op_cmp.sem_cmpneq c.size (rreil-convert-sem-linear cbs c.opnd1) (rreil-convert-sem-linear cbs c.opnd2)
 | SEM_CMPLES c: cbs.sem_op_cmp.sem_cmples c.size (rreil-convert-sem-linear cbs c.opnd1) (rreil-convert-sem-linear cbs c.opnd2)
 | SEM_CMPLEU c: cbs.sem_op_cmp.sem_cmpleu c.size (rreil-convert-sem-linear cbs c.opnd1) (rreil-convert-sem-linear cbs c.opnd2)
 | SEM_CMPLTS c: cbs.sem_op_cmp.sem_cmplts c.size (rreil-convert-sem-linear cbs c.opnd1) (rreil-convert-sem-linear cbs c.opnd2)
 | SEM_CMPLTU c: cbs.sem_op_cmp.sem_cmpltu c.size (rreil-convert-sem-linear cbs c.opnd1) (rreil-convert-sem-linear cbs c.opnd2)
end

val rreil-convert-sem-expr cbs op = case op of
   SEM_SEXPR s: cbs.sem_expr.sem_sexpr s.size (rreil-convert-sem-sexpr cbs s.opnd1)
 | SEM_MUL m: cbs.sem_expr.sem_mul m.size (rreil-convert-sem-linear cbs m.opnd1) (rreil-convert-sem-linear cbs m.opnd2)
 | SEM_DIV d: cbs.sem_expr.sem_div d.size (rreil-convert-sem-linear cbs d.opnd1) (rreil-convert-sem-linear cbs d.opnd2)
 | SEM_DIVS d: cbs.sem_expr.sem_divs d.size (rreil-convert-sem-linear cbs d.opnd1) (rreil-convert-sem-linear cbs d.opnd2)
 | SEM_MOD m: cbs.sem_expr.sem_mod m.size (rreil-convert-sem-linear cbs m.opnd1) (rreil-convert-sem-linear cbs m.opnd2)
 | SEM_SHL s: cbs.sem_expr.sem_shl s.size (rreil-convert-sem-linear cbs s.opnd1) (rreil-convert-sem-linear cbs s.opnd2)
 | SEM_SHR s: cbs.sem_expr.sem_shr s.size (rreil-convert-sem-linear cbs s.opnd1) (rreil-convert-sem-linear cbs s.opnd2)
 | SEM_SHRS s: cbs.sem_expr.sem_shrs s.size (rreil-convert-sem-linear cbs s.opnd1) (rreil-convert-sem-linear cbs s.opnd2)
 | SEM_AND a: cbs.sem_expr.sem_and a.size (rreil-convert-sem-linear cbs a.opnd1) (rreil-convert-sem-linear cbs a.opnd2)
 | SEM_OR o: cbs.sem_expr.sem_or o.size (rreil-convert-sem-linear cbs o.opnd1) (rreil-convert-sem-linear cbs o.opnd2)
 | SEM_XOR x: cbs.sem_expr.sem_xor x.size (rreil-convert-sem-linear cbs x.opnd1) (rreil-convert-sem-linear cbs x.opnd2)
 | SEM_SX s: cbs.sem_expr.sem_sx s.size s.fromsize (rreil-convert-sem-linear cbs s.opnd1)
 | SEM_ZX s: cbs.sem_expr.sem_zx s.size s.fromsize (rreil-convert-sem-linear cbs s.opnd1)
end

val rreil-convert-branch-hint cbs hint = cbs.branch_hint.branch_hint_ (index hint)

val rreil-convert-sem-varl cbs varl = cbs.sem_varl.sem_varl_ (rreil-convert-sem-id cbs varl.id) varl.offset varl.size

val rreil-convert-sem-varls cbs varls = let
  val convert-inner cbs list varls = case varls of
     SEM_VARLS_CONS s: convert-inner cbs (cbs.sem_varls.sem_varls_next (rreil-convert-sem-varl cbs s.hd) list) s.tl
   | SEM_VARLS_NIL: list
  end
in
  convert-inner cbs (cbs.sem_varls.sem_varls_init void) varls #Note: init is a function and, hence, has to be called by applying it to an argument
end

val rreil-sem-varls-head stmts = case stmts of
   SEM_VARLS_CONS s: s.hd
end

val rreil-sem-varls-tail stmts = case stmts of
   SEM_VARLS_CONS s: s.tl
end

val rreil-sem-varls-has-more varls = case varls of
   SEM_VARLS_CONS s: '1'
 | SEM_VARLS_NIL: '0'
end

val rreil-convert-sem-flop cbs flop = cbs.sem_flop.sem_flop_ (index flop)

val rreil-convert-sem-stmt cbs stmt = case stmt of
   SEM_ASSIGN s: cbs.sem_stmt.sem_assign (rreil-convert-sem-var cbs s.lhs) (rreil-convert-sem-expr cbs s.rhs)
 | SEM_LOAD l: cbs.sem_stmt.sem_load (rreil-convert-sem-var cbs l.lhs) l.size (rreil-convert-sem-address cbs l.address)
 | SEM_STORE s: cbs.sem_stmt.sem_store (rreil-convert-sem-address cbs s.address) (rreil-convert-sem-expr cbs s.rhs)
 | SEM_ITE i: cbs.sem_stmt.sem_ite (rreil-convert-sem-sexpr cbs i.cond) (rreil-convert-sem-stmts cbs i.then_branch) (rreil-convert-sem-stmts cbs i.else_branch)
 | SEM_WHILE w: cbs.sem_stmt.sem_while (rreil-convert-sem-sexpr cbs w.cond) (rreil-convert-sem-stmts cbs w.body)
 | SEM_CBRANCH c: cbs.sem_stmt.sem_cbranch (rreil-convert-sem-sexpr cbs c.cond) (rreil-convert-sem-address cbs c.target-true) (rreil-convert-sem-address cbs c.target-false)
 | SEM_BRANCH b: cbs.sem_stmt.sem_branch (rreil-convert-branch-hint cbs b.hint) (rreil-convert-sem-address cbs b.target)
 | SEM_FLOP f: cbs.sem_stmt.sem_flop (rreil-convert-sem-flop cbs f.op) (rreil-convert-sem-var cbs f.flags) (rreil-convert-sem-varl cbs f.lhs) (rreil-convert-sem-varls cbs f.rhs)
 | SEM_PRIM p: cbs.sem_stmt.sem_prim p.op (rreil-convert-sem-varls cbs p.lhs) (rreil-convert-sem-varls cbs p.rhs)
end

val rreil-convert-sem-stmt-manual cbs stmt = case stmt of
   SEM_ASSIGN s: cbs.sem_stmt.sem_assign (rreil-convert-sem-var cbs s.lhs) (rreil-convert-sem-expr cbs s.rhs)
 | SEM_LOAD l: cbs.sem_stmt.sem_load (rreil-convert-sem-var cbs l.lhs) l.size (rreil-convert-sem-address cbs l.address)
 | SEM_STORE s: cbs.sem_stmt.sem_store (rreil-convert-sem-address cbs s.address) (rreil-convert-sem-expr cbs s.rhs)
 | SEM_ITE i: cbs.sem_stmt.sem_ite (rreil-convert-sem-sexpr cbs i.cond) i.then_branch i.else_branch
 | SEM_WHILE w: cbs.sem_stmt.sem_while (rreil-convert-sem-sexpr cbs w.cond) w.body
 | SEM_CBRANCH c: cbs.sem_stmt.sem_cbranch (rreil-convert-sem-sexpr cbs c.cond) (rreil-convert-sem-address cbs c.target-true) (rreil-convert-sem-address cbs c.target-false)
 | SEM_BRANCH b: cbs.sem_stmt.sem_branch (rreil-convert-branch-hint cbs b.hint) (rreil-convert-sem-address cbs b.target)
 | SEM_FLOP f: cbs.sem_stmt.sem_flop (rreil-convert-sem-flop cbs f.op) (rreil-convert-sem-var cbs f.flags) (rreil-convert-sem-varl cbs f.lhs) f.rhs
 | SEM_PRIM p: cbs.sem_stmt.sem_prim p.op p.lhs p.rhs
end

val rreil-convert-sem-stmts cbs stmts = let
  val convert-inner cbs list stmts = case stmts of
     SEM_CONS s: convert-inner cbs (cbs.sem_stmts.next (rreil-convert-sem-stmt cbs s.hd) list) s.tl
   | SEM_NIL: list
  end
in
  convert-inner cbs (cbs.sem_stmts.init void) stmts #Note: init is a function and, hence, has to be called by applying it to an argument
end

val rreil-sem-stmts-has-more stmts = case stmts of
   SEM_CONS s: '1'
 | SEM_NIL: '0'
end

val rreil-sem-stmts-head stmts = case stmts of
   SEM_CONS s: s.hd
end

val rreil-sem-stmts-tail stmts = case stmts of
   SEM_CONS s: s.tl
end

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

