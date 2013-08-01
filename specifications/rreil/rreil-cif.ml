export = rreil-callbacks-sem-id rreil-callbacks-sem-address rreil-callbacks-sem-var rreil-callbacks-sem-linear rreil-callbacks-sem-sexpr rreil-callbacks-sem-op-cmp rreil-callbacks-sem-op rreil-callbacks-sem-stmt rreil-callbacks-branch-hint rreil-callbacks-sem-stmts rreil-callbacks rreil-convert-sem-stmts

type string_ = STRING of string

type callbacks =
   SEM_ID_CBS of {virt_na:string_, virt_t:string_}

val rreil-callbacks-sem-id virt_na virt_t x86 = {virt_na=STRING virt_na, virt_t=STRING virt_t, x86=STRING x86}
val rreil-callbacks-sem-address sem_address = {sem_address=STRING sem_address}
val rreil-callbacks-sem-var sem_var = {sem_var=STRING sem_var}
val rreil-callbacks-sem-linear sem_lin_var sem_lin_imm sem_lin_add sem_lin_sub sem_lin_scale = {sem_lin_var=STRING sem_lin_var, sem_lin_imm=STRING sem_lin_imm, sem_lin_add=STRING sem_lin_add, sem_lin_sub=STRING sem_lin_sub, sem_lin_scale=STRING sem_lin_scale}
val rreil-callbacks-sem-sexpr sem_sexpr_lin sem_sexpr_cmp = {sem_sexpr_lin=STRING sem_sexpr_lin, sem_sexpr_cmp=STRING sem_sexpr_cmp}
val rreil-callbacks-sem-op-cmp sem_cmpeq sem_cmpneq sem_cmples sem_cmpleu sem_cmplts sem_cmpltu = {sem_cmpeq=STRING sem_cmpeq, sem_cmpneq=STRING sem_cmpneq, sem_cmples=STRING sem_cmples, sem_cmpleu=STRING sem_cmpleu, sem_cmplts=STRING sem_cmplts, sem_cmpltu=STRING sem_cmpltu}
val rreil-callbacks-sem-op sem_lin sem_mul sem_div sem_divs sem_mod sem_shl sem_shr sem_shrs sem_and sem_or sem_xor sem_sx sem_zx sem_cmp sem_arb = {sem_lin=STRING sem_lin, sem_mul=STRING sem_mul, sem_div=STRING sem_div, sem_divs=STRING sem_divs, sem_mod=STRING sem_mod, sem_shl=STRING sem_shl, sem_shr=STRING sem_shr, sem_shrs=STRING sem_shrs, sem_and=STRING sem_and, sem_or=STRING sem_or, sem_xor=STRING sem_xor, sem_sx=STRING sem_sx, sem_zx=STRING sem_zx, sem_cmp=STRING sem_cmp, sem_arb=STRING sem_arb}
val rreil-callbacks-sem-stmt sem_assign sem_load sem_store sem_ite sem_while sem_cbranch sem_branch = {sem_assign=STRING sem_assign, sem_load=STRING sem_load, sem_store=STRING sem_store, sem_ite=STRING sem_ite, sem_while=STRING sem_while, sem_cbranch=STRING sem_cbranch, sem_branch=STRING sem_branch}
val rreil-callbacks-branch-hint branch_hint = {branch_hint=STRING branch_hint}
val rreil-callbacks-sem-stmts sem_cons sem_nil = {sem_cons=STRING sem_cons, sem_nil=STRING sem_nil}
val rreil-callbacks-sem-stmts-list list_next list_init = {list_next=STRING list_next, list_init=STRING list_init}

val rreil-callbacks sem_id sem_address sem_var sem_linear sem_sexpr sem_op_cmp sem_op sem_stmt branch_hint sem_stmts sem_stmts_list = {sem_id=sem_id, sem_address=sem_address, sem_var=sem_var, sem_linear=sem_linear, sem_sexpr=sem_sexpr, sem_op_cmp=sem_op_cmp, sem_op=sem_op, sem_stmt=sem_stmt, branch_hint=branch_hint, sem_stmts=sem_stmts, sem_stmts_list=sem_stmts_list}

val rreil-convert-sem-id cbs closure id = "..."

val rreil-convert-sem-address cbs closure address = "..."

val rreil-convert-sem-var cbs closure var = "..."

val rreil-convert-sem-linear cbs closure linear = "..."

val rreil-convert-sem-sexpr cbs closure sexpr = "..."

val rreil-convert-sem-op-cmp cbs closure op-cmp = "..."

val rreil-convert-sem-op cbs closure op = case op of
   SEM_LIN l: invoke-oio cbs.sem_op.sem_lin closure l.size (rreil-convert-sem-linear cbs closure l.opnd1)
 | SEM_MUL m: invoke-oioo cbs.sem_op.sem_mul closure m.size (rreil-convert-sem-linear cbs closure m.opnd1) (rreil-convert-sem-linear cbs closure m.opnd2)
 | SEM_DIV d: invoke-oioo cbs.sem_op.sem_div closure d.size (rreil-convert-sem-linear cbs closure d.opnd1) (rreil-convert-sem-linear cbs closure d.opnd2)
 | SEM_DIVS d: invoke-oioo cbs.sem_op.sem_divs closure d.size (rreil-convert-sem-linear cbs closure d.opnd1) (rreil-convert-sem-linear cbs closure d.opnd2)
 | SEM_MOD m: invoke-oioo cbs.sem_op.sem_mod closure m.size (rreil-convert-sem-linear cbs closure m.opnd1) (rreil-convert-sem-linear cbs closure m.opnd2)
 | SEM_SHL s: invoke-oioo cbs.sem_op.sem_shl closure s.size (rreil-convert-sem-linear cbs closure s.opnd1) (rreil-convert-sem-linear cbs closure s.opnd2)
 | SEM_SHR s: invoke-oioo cbs.sem_op.sem_shr closure s.size (rreil-convert-sem-linear cbs closure s.opnd1) (rreil-convert-sem-linear cbs closure s.opnd2)
 | SEM_SHRS s: invoke-oioo cbs.sem_op.sem_shrs closure s.size (rreil-convert-sem-linear cbs closure s.opnd1) (rreil-convert-sem-linear cbs closure s.opnd2)
 | SEM_AND a: invoke-oioo cbs.sem_op.sem_and closure a.size (rreil-convert-sem-linear cbs closure a.opnd1) (rreil-convert-sem-linear cbs closure a.opnd2)
 | SEM_OR o: invoke-oioo cbs.sem_op.sem_or closure o.size (rreil-convert-sem-linear cbs closure o.opnd1) (rreil-convert-sem-linear cbs closure o.opnd2)
 | SEM_XOR x: invoke-oioo cbs.sem_op.sem_xor closure x.size (rreil-convert-sem-linear cbs closure x.opnd1) (rreil-convert-sem-linear cbs closure x.opnd2)
 | SEM_SX s: invoke-oiio cbs.sem_op.sem_sx closure s.size s.fromsize (rreil-convert-sem-linear cbs closure s.opnd1)
 | SEM_ZX s: invoke-oiio cbs.sem_op.sem_zx closure s.size s.fromsize (rreil-convert-sem-linear cbs closure s.opnd1)
 | SEM_CMP c: invoke-oo cbs.sem_op.sem_cmp closure (rreil-convert-sem-op-cmp cbs closure c)
 | SEM_ARB a: invoke-oi cbs.sem_op.sem_arb closure a.size
end

val rreil-convert-branch-hint cbs closure hint = invoke-oi cbs.branch_hint.branch_hint closure (index hint)

val rreil-convert-sem-stmt cbs closure stmt = case stmt of
   SEM_ASSIGN s: invoke-ooo cbs.sem_stmt.sem_assign closure (rreil-convert-sem-var cbs closure s.lhs) (rreil-convert-sem-op cbs closure s.rhs)
 | SEM_LOAD l: invoke-ooio cbs.sem_stmt.sem_load closure (rreil-convert-sem-var cbs closure l.lhs) l.size (rreil-convert-sem-address cbs closure l.address)
 | SEM_STORE s: invoke-ooo cbs.sem_stmt.sem_store closure (rreil-convert-sem-address cbs closure s.address) (rreil-convert-sem-op cbs closure s.rhs)
 | SEM_ITE i: invoke-oooo cbs.sem_stmt.sem_ite closure (rreil-convert-sem-sexpr cbs closure i.cond) (rreil-convert-sem-stmts cbs closure i.then_branch) (rreil-convert-sem-stmts cbs closure i.else_branch)
 | SEM_WHILE w: invoke-ooo cbs.sem_stmt.sem_while closure (rreil-convert-sem-sexpr cbs closure w.cond) (rreil-convert-sem-stmts cbs closure w.body)
 | SEM_CBRANCH c: invoke-oooo cbs.sem_stmt.sem_cbranch closure (rreil-convert-sem-sexpr cbs closure c.cond) (rreil-convert-sem-address cbs closure c.target-true) (rreil-convert-sem-address cbs closure c.target-false)
 | SEM_BRANCH b: invoke-ooo cbs.sem_stmt.sem_branch closure (rreil-convert-branch-hint cbs closure b.hint) (rreil-convert-sem-address cbs closure b.target)
end

val rreil-convert-sem-stmts cbs closure stmts = case stmts of
   SEM_CONS x: invoke-ooo cbs.sem_stmts.sem_cons closure (rreil-convert-sem-stmt cbs closure x.hd) (rreil-convert-sem-stmts cbs closure x.tl)
 | SEM_NIL: invoke-o cbs.sem_stmts.sem_nil closure
end
