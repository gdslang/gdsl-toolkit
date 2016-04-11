export rreil-convert-sem-stmt-list : (callbacks, sem_stmt_list) -> sem_stmt_list_obj

type sem_id_callbacks = {
  shared: (int) -> sem_id_obj,
  virt_t: (int) -> sem_id_obj,
  virt_o: (int) -> sem_id_obj,
  arch: (string) -> sem_id_obj
}
type sem_address_callbacks = {
  sem_address_: (int, sem_linear_obj) -> sem_address_obj
}
type sem_var_callbacks = {
  sem_var_: (sem_id_obj, int) -> sem_var_obj
}
type sem_linear_callbacks = {
  sem_lin_var: (sem_var_obj) -> sem_linear_obj,
  sem_lin_imm: (int) -> sem_linear_obj,
  sem_lin_add: (sem_linear_obj, sem_linear_obj) -> sem_linear_obj,
  sem_lin_sub: (sem_linear_obj, sem_linear_obj) -> sem_linear_obj,
  sem_lin_scale: (int, sem_linear_obj) -> sem_linear_obj
}
type sem_sexpr_callbacks = {
  sem_sexpr_lin: (sem_linear_obj) -> sem_sexpr_obj,
  sem_sexpr_cmp: (int, sem_expr_cmp_obj) -> sem_sexpr_obj,
  sem_sexpr_arb: () -> sem_sexpr_obj
}
type sem_expr_cmp_callbacks = {
  sem_cmpeq: (sem_linear_obj, sem_linear_obj) -> sem_expr_cmp_obj,
  sem_cmpneq: (sem_linear_obj, sem_linear_obj) -> sem_expr_cmp_obj,
  sem_cmples: (sem_linear_obj, sem_linear_obj) -> sem_expr_cmp_obj,
  sem_cmpleu: (sem_linear_obj, sem_linear_obj) -> sem_expr_cmp_obj,
  sem_cmplts: (sem_linear_obj, sem_linear_obj) -> sem_expr_cmp_obj,
  sem_cmpltu: (sem_linear_obj, sem_linear_obj) -> sem_expr_cmp_obj
}
type sem_expr_callbacks = {
  sem_sexpr: (sem_sexpr_obj) -> sem_expr_obj,
  sem_mul: (sem_linear_obj, sem_linear_obj) -> sem_expr_obj,
  sem_div: (sem_linear_obj, sem_linear_obj) -> sem_expr_obj,
  sem_divs: (sem_linear_obj, sem_linear_obj) -> sem_expr_obj,
  sem_mod: (sem_linear_obj, sem_linear_obj) -> sem_expr_obj,
  sem_mods: (sem_linear_obj, sem_linear_obj) -> sem_expr_obj,
  sem_shl: (sem_linear_obj, sem_linear_obj) -> sem_expr_obj,
  sem_shr: (sem_linear_obj, sem_linear_obj) -> sem_expr_obj,
  sem_shrs: (sem_linear_obj, sem_linear_obj) -> sem_expr_obj,
  sem_and: (sem_linear_obj, sem_linear_obj) -> sem_expr_obj,
  sem_or: (sem_linear_obj, sem_linear_obj) -> sem_expr_obj,
  sem_xor: (sem_linear_obj, sem_linear_obj) -> sem_expr_obj,
  sem_sx: (int, sem_linear_obj) -> sem_expr_obj,
  sem_zx: (int, sem_linear_obj) -> sem_expr_obj
}
type sem_varl_callbacks = {
  sem_varl_: (sem_id_obj, int, int) -> sem_varl_obj
}
type sem_varl_list_callbacks = {
  sem_varl_list_next: (sem_varl_obj, sem_varl_list_obj) -> sem_varl_list_obj,
  sem_varl_list_init: () -> sem_varl_list_obj
}
type sem_flop_callbacks = {
  sem_flop_: (int) -> sem_flop_obj
}
type sem_stmt_callbacks = {
  sem_assign: (int, sem_var_obj, sem_expr_obj) -> sem_stmt_obj,
  sem_load: (int, sem_var_obj, sem_address_obj) -> sem_stmt_obj,
  sem_store: (int, sem_address_obj, sem_linear_obj) -> sem_stmt_obj,
  sem_ite: (sem_sexpr_obj, sem_stmt_list_obj, sem_stmt_list_obj) -> sem_stmt_obj,
  sem_while: (sem_sexpr_obj, sem_stmt_list_obj) -> sem_stmt_obj,
  sem_cbranch: (sem_sexpr_obj, sem_address_obj, sem_address_obj) -> sem_stmt_obj,
  sem_branch: (branch_hint_obj, sem_address_obj) -> sem_stmt_obj,
  sem_flop: (sem_flop_obj, sem_var_obj, sem_varl_obj, sem_varl_list_obj) -> sem_stmt_obj,
  sem_prim: (string, sem_varl_list_obj, sem_varl_list_obj) -> sem_stmt_obj,
  sem_throw: (sem_exception_obj) -> sem_stmt_obj
}
type branch_hint_callbacks = {
  branch_hint_: (int) -> branch_hint_obj
}
type sem_exception_callbacks = {
  shared: (int) -> sem_exception_obj,
  arch: (string) -> sem_exception_obj
}
type sem_stmt_list_callbacks = {
  sem_stmt_list_next: (sem_stmt_obj, sem_stmt_list_obj) -> sem_stmt_list_obj,
  sem_stmt_list_init: () -> sem_stmt_list_obj
}

type callbacks = {
  sem_id:sem_id_callbacks,
  sem_address:sem_address_callbacks,
  sem_var:sem_var_callbacks,
  sem_linear:sem_linear_callbacks,
  sem_sexpr:sem_sexpr_callbacks,
  sem_expr_cmp:sem_expr_cmp_callbacks,
  sem_expr:sem_expr_callbacks,
  sem_varl:sem_varl_callbacks,
  sem_varl_list:sem_varl_list_callbacks,
  sem_flop:sem_flop_callbacks,
  sem_stmt:sem_stmt_callbacks,
  branch_hint:branch_hint_callbacks,
  sem_exception:sem_exception_callbacks,
  sem_stmt_list:sem_stmt_list_callbacks
}

type sem_id_obj = SEM_ID_OBJ
type sem_address_obj = SEM_ADDRESS_OBJ
type sem_var_obj = SEM_VAR_OBJ
type sem_linear_obj = SEM_LINEAR_OBJ
type sem_sexpr_obj = SEM_SEXPR_OBJ
type sem_expr_cmp_obj = SEM_EXPR_CMP_OBJ
type sem_expr_obj = SEM_EXPR_OBJ
type sem_varl_obj = SEM_VARL_OBJ
type sem_varl_list_obj = SEM_VARL_LIST_OBJ
type sem_flop_obj = SEM_FLOP_OBJ
type sem_stmt_obj = SEM_STMT_OBJ
type sem_stmt_list_obj = SEM_STMT_LIST_OBJ
type branch_hint_obj = BRANCH_OBJ
type sem_exception_obj = SEM_EXCEPTION_OBJ

val id_shared_enum s = case s of
   FLOATING_FLAGS: 0
end

val rreil-convert-sem-id cbs id = case id of
   FLOATING_FLAGS: cbs.sem_id.shared ((id_shared_enum id) + 0)
 | VIRT_T t: cbs.sem_id.virt_t (t + 0)
 | VIRT_O t: cbs.sem_id.virt_o (t + 0)
 | _: cbs.sem_id.arch (string-from-rope (pretty-arch-id id))
end

val rreil-convert-sem-address cbs address = cbs.sem_address.sem_address_ (address.size + 0) (rreil-convert-sem-linear cbs address.address)

val rreil-convert-sem-var cbs var = cbs.sem_var.sem_var_ (rreil-convert-sem-id cbs var.id) (var.offset + 0)

val rreil-convert-sem-linear cbs linear = case linear of
   SEM_LIN_VAR v: cbs.sem_linear.sem_lin_var (rreil-convert-sem-var cbs v)
 | SEM_LIN_IMM i: cbs.sem_linear.sem_lin_imm (i.const + 0)
 | SEM_LIN_ADD a: cbs.sem_linear.sem_lin_add (rreil-convert-sem-linear cbs a.opnd1) (rreil-convert-sem-linear cbs a.opnd2)
 | SEM_LIN_SUB s: cbs.sem_linear.sem_lin_sub (rreil-convert-sem-linear cbs s.opnd1) (rreil-convert-sem-linear cbs s.opnd2)
 | SEM_LIN_SCALE s: cbs.sem_linear.sem_lin_scale (s.const + 0) (rreil-convert-sem-linear cbs s.opnd)
end

val rreil-convert-sem-sexpr cbs sexpr = case sexpr of
   SEM_SEXPR_LIN l: cbs.sem_sexpr.sem_sexpr_lin (rreil-convert-sem-linear cbs l)
 | SEM_SEXPR_CMP c: cbs.sem_sexpr.sem_sexpr_cmp c.size (rreil-convert-sem-expr-cmp cbs c.cmp)
 | SEM_SEXPR_ARB: cbs.sem_sexpr.sem_sexpr_arb () #Note: init is a function and, hence, has to be called by applying it to an argument
end

val rreil-convert-sem-expr-cmp cbs expr-cmp = case expr-cmp of
   SEM_CMPEQ c: cbs.sem_expr_cmp.sem_cmpeq (rreil-convert-sem-linear cbs c.opnd1) (rreil-convert-sem-linear cbs c.opnd2)
 | SEM_CMPNEQ c: cbs.sem_expr_cmp.sem_cmpneq (rreil-convert-sem-linear cbs c.opnd1) (rreil-convert-sem-linear cbs c.opnd2)
 | SEM_CMPLES c: cbs.sem_expr_cmp.sem_cmples (rreil-convert-sem-linear cbs c.opnd1) (rreil-convert-sem-linear cbs c.opnd2)
 | SEM_CMPLEU c: cbs.sem_expr_cmp.sem_cmpleu (rreil-convert-sem-linear cbs c.opnd1) (rreil-convert-sem-linear cbs c.opnd2)
 | SEM_CMPLTS c: cbs.sem_expr_cmp.sem_cmplts (rreil-convert-sem-linear cbs c.opnd1) (rreil-convert-sem-linear cbs c.opnd2)
 | SEM_CMPLTU c: cbs.sem_expr_cmp.sem_cmpltu (rreil-convert-sem-linear cbs c.opnd1) (rreil-convert-sem-linear cbs c.opnd2)
end

val rreil-convert-sem-expr cbs expr = case expr of
   SEM_SEXPR s: cbs.sem_expr.sem_sexpr (rreil-convert-sem-sexpr cbs s)
 | SEM_MUL m: cbs.sem_expr.sem_mul (rreil-convert-sem-linear cbs m.opnd1) (rreil-convert-sem-linear cbs m.opnd2)
 | SEM_DIV d: cbs.sem_expr.sem_div (rreil-convert-sem-linear cbs d.opnd1) (rreil-convert-sem-linear cbs d.opnd2)
 | SEM_DIVS d: cbs.sem_expr.sem_divs (rreil-convert-sem-linear cbs d.opnd1) (rreil-convert-sem-linear cbs d.opnd2)
 | SEM_MOD m: cbs.sem_expr.sem_mod (rreil-convert-sem-linear cbs m.opnd1) (rreil-convert-sem-linear cbs m.opnd2)
 | SEM_MODS m: cbs.sem_expr.sem_mods (rreil-convert-sem-linear cbs m.opnd1) (rreil-convert-sem-linear cbs m.opnd2)
 | SEM_SHL s: cbs.sem_expr.sem_shl (rreil-convert-sem-linear cbs s.opnd1) (rreil-convert-sem-linear cbs s.opnd2)
 | SEM_SHR s: cbs.sem_expr.sem_shr (rreil-convert-sem-linear cbs s.opnd1) (rreil-convert-sem-linear cbs s.opnd2)
 | SEM_SHRS s: cbs.sem_expr.sem_shrs (rreil-convert-sem-linear cbs s.opnd1) (rreil-convert-sem-linear cbs s.opnd2)
 | SEM_AND a: cbs.sem_expr.sem_and (rreil-convert-sem-linear cbs a.opnd1) (rreil-convert-sem-linear cbs a.opnd2)
 | SEM_OR o: cbs.sem_expr.sem_or (rreil-convert-sem-linear cbs o.opnd1) (rreil-convert-sem-linear cbs o.opnd2)
 | SEM_XOR x: cbs.sem_expr.sem_xor (rreil-convert-sem-linear cbs x.opnd1) (rreil-convert-sem-linear cbs x.opnd2)
 | SEM_SX s: cbs.sem_expr.sem_sx (s.fromsize + 0) (rreil-convert-sem-linear cbs s.opnd1)
 | SEM_ZX s: cbs.sem_expr.sem_zx (s.fromsize + 0) (rreil-convert-sem-linear cbs s.opnd1)
end

val branch_hint_enum hint = case hint of
   HINT_JUMP: 0
 | HINT_CALL: 1
 | HINT_RET: 2 
end

val rreil-convert-branch-hint cbs hint = cbs.branch_hint.branch_hint_ ((branch_hint_enum hint) + 0)

val rreil-convert-sem-varl cbs varl = cbs.sem_varl.sem_varl_ (rreil-convert-sem-id cbs varl.id) (varl.offset + 0) (varl.size + 0)

val rreil-convert-sem-varl-list cbs varls = let
  val convert-inner cbs list varls = case varls of
     SEM_VARLS_CONS s: convert-inner cbs (cbs.sem_varl_list.sem_varl_list_next (rreil-convert-sem-varl cbs s.hd) list) s.tl
   | SEM_VARLS_NIL: list
  end
in
  convert-inner cbs (cbs.sem_varl_list.sem_varl_list_init ()) varls #Note: init is a function and, hence, has to be called by applying it to an argument
end

val rreil-sem-varl-list-head stmts = case stmts of
   SEM_VARLS_CONS s: s.hd
end

val rreil-sem-varl-list-tail stmts = case stmts of
   SEM_VARLS_CONS s: s.tl
end

val rreil-sem-varl-list-has-more varls = case varls of
   SEM_VARLS_CONS s: '1'
 | SEM_VARLS_NIL: '0'
end

val flop_enum flop = case flop of
   SEM_FADD: 0
 | SEM_FSUB: 1
 | SEM_FMUL: 2 
end

val rreil-convert-sem-flop cbs flop = cbs.sem_flop.sem_flop_ ((flop_enum flop) + 0)

val exception_enum e = case e of
   SEM_DIVISION_BY_ZERO: 0
end

val rreil-convert-sem-exception cbs exception = case exception of
   SEM_DIVISION_BY_ZERO: cbs.sem_exception.shared ((exception_enum exception) + 0)
 | _: cbs.sem_exception.arch (string-from-rope (pretty-arch-exception exception))
end

val rreil-convert-sem-stmt cbs stmt = case stmt of
   SEM_ASSIGN s: cbs.sem_stmt.sem_assign (s.size + 0) (rreil-convert-sem-var cbs s.lhs) (rreil-convert-sem-expr cbs s.rhs)
 | SEM_LOAD l: cbs.sem_stmt.sem_load (l.size + 0) (rreil-convert-sem-var cbs l.lhs) (rreil-convert-sem-address cbs l.address)
 | SEM_STORE s: cbs.sem_stmt.sem_store (s.size + 0) (rreil-convert-sem-address cbs s.address) (rreil-convert-sem-linear cbs s.rhs)
 | SEM_ITE i: cbs.sem_stmt.sem_ite (rreil-convert-sem-sexpr cbs i.cond) (rreil-convert-sem-stmt-list cbs i.then_branch) (rreil-convert-sem-stmt-list cbs i.else_branch)
 | SEM_WHILE w: cbs.sem_stmt.sem_while (rreil-convert-sem-sexpr cbs w.cond) (rreil-convert-sem-stmt-list cbs w.body)
 | SEM_CBRANCH c: cbs.sem_stmt.sem_cbranch (rreil-convert-sem-sexpr cbs c.cond) (rreil-convert-sem-address cbs c.target-true) (rreil-convert-sem-address cbs c.target-false)
 | SEM_BRANCH b: cbs.sem_stmt.sem_branch (rreil-convert-branch-hint cbs b.hint) (rreil-convert-sem-address cbs b.target)
 | SEM_FLOP f: cbs.sem_stmt.sem_flop (rreil-convert-sem-flop cbs f.op) (rreil-convert-sem-var cbs f.flags) (rreil-convert-sem-varl cbs f.lhs) (rreil-convert-sem-varl-list cbs f.rhs)
 | SEM_PRIM p: cbs.sem_stmt.sem_prim p.op (rreil-convert-sem-varl-list cbs p.lhs) (rreil-convert-sem-varl-list cbs p.rhs)
 | SEM_THROW p: cbs.sem_stmt.sem_throw (rreil-convert-sem-exception cbs p)
end

#val rreil-convert-sem-stmt-manual cbs stmt = case stmt of
#   SEM_ASSIGN s: cbs.sem_stmt.sem_assign s.size (rreil-convert-sem-var cbs s.lhs) (rreil-convert-sem-expr cbs s.rhs)
# | SEM_LOAD l: cbs.sem_stmt.sem_load l.size (rreil-convert-sem-var cbs l.lhs) (rreil-convert-sem-address cbs l.address)
# | SEM_STORE s: cbs.sem_stmt.sem_store s.size (rreil-convert-sem-address cbs s.address) (rreil-convert-sem-linear cbs s.rhs)
# | SEM_ITE i: cbs.sem_stmt.sem_ite (rreil-convert-sem-sexpr cbs i.cond) i.then_branch i.else_branch
# | SEM_WHILE w: cbs.sem_stmt.sem_while (rreil-convert-sem-sexpr cbs w.cond) w.body
# | SEM_CBRANCH c: cbs.sem_stmt.sem_cbranch (rreil-convert-sem-sexpr cbs c.cond) (rreil-convert-sem-address cbs c.target-true) (rreil-convert-sem-address cbs c.target-false)
# | SEM_BRANCH b: cbs.sem_stmt.sem_branch (rreil-convert-branch-hint cbs b.hint) (rreil-convert-sem-address cbs b.target)
# | SEM_FLOP f: cbs.sem_stmt.sem_flop (rreil-convert-sem-flop cbs f.op) (rreil-convert-sem-var cbs f.flags) (rreil-convert-sem-varl cbs f.lhs) f.rhs
# | SEM_PRIM p: cbs.sem_stmt.sem_prim p.op p.lhs p.rhs
# | SEM_THROW p: cbs.sem_stmt.sem_throw (rreil-convert-sem-exception cbs p)
#end

val rreil-convert-sem-stmt-list cbs stmts = let
  val convert-inner list stmts = case stmts of
     SEM_CONS s: convert-inner (cbs.sem_stmt_list.sem_stmt_list_next (rreil-convert-sem-stmt cbs s.hd) list) s.tl
   | SEM_NIL: list
  end
in
  convert-inner (cbs.sem_stmt_list.sem_stmt_list_init ()) stmts #Note: init is a function and, hence, has to be called by applying it to an argument
end

val rreil-sem-stmt-list-has-more stmts = case stmts of
   SEM_CONS s: '1'
 | SEM_NIL: '0'
end

val rreil-sem-stmt-list-head stmts = case stmts of
   SEM_CONS s: s.hd
end

val rreil-sem-stmt-list-tail stmts = case stmts of
   SEM_CONS s: s.tl
end
