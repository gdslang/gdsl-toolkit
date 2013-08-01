export = rreil-callbacks-sem-id rreil-callbacks-sem-address rreil-callbacks-sem-var rreil-callbacks-sem-linear rreil-callbacks-sem-sexpr rreil-callbacks-sem-op-cmp rreil-callbacks-sem-op rreil-callbacks-sem-stmt rreil-callbacks-sem-branch-hint

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
val rreil-callbacks-sem-branch-hint sem_branch_hint = {sem_branch_hint=STRING sem_branch_hint}
val rreil-callbacks-sem-stmts sem_cons sem_nil = {sem_cons=STRING sem_cons, sem_nil=STRING sem_nil}
val rreil-callbacks-sem-stmts-list list_next list_init = {list_next=STRING list_next, list_init=STRING list_init}

val rreil-callbacks sem_id sem_address sem_var sem_linear sem_sexpr sem_op_cmp sem_op sem_stmt sem_branch_hint sem_stmts sem_stmts_list = {sem_id=sem_id, sem_address=sem_address, sem_var=sem_var, sem_linear=sem_linear, sem_sexpr=sem_sexpr, sem_op_cmp=sem_op_cmp, sem_op=sem_op, sem_stmt=sem_stmt, sem_branch_hint=sem_branch_hint, sem_stmts=sem_stmts, sem_stmts_list=sem_stmts_list}

val rreil-convert-sem-stmt cbs stmt = "hallo"

val rreil-convert cbs stmts = case stmts of
   SEM_CONS: cbs.stmts
