/* vim:cindent:ts=2:sw=2:expandtab */

#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <readhex.h>
#include <gdsl.h>

// sem_id
//static gdrr_sem_id_t *virt_na(state_t state, int_t con) {
//	printf("=> virt#%ld\n", con);
//	return NULL ;
//}
static obj_t shared(state_t state, int_t con) {
	switch(con) {
		case CON_FLOATING_FLAGS: {
			printf("FLOATING_FLAGS\n");
			break;
		}
	}
	return NULL;
}
static obj_t virt_t(state_t state, int_t t) {
	printf("=> t%ld\n", t);
	return NULL ;
}
static obj_t arch(state_t state, int_t con) {
	printf("=> arch#%ld\n", con);
	return NULL ;
}

//static gdrr_sem_id_t virt_eq(state_t state) {
//	printf("=> virt_eq\n");
//	return NULL;
//}
//static gdrr_sem_id_t virt_neq(state_t state) {
//	printf("=> virt_neq\n");
//	return NULL;
//}
//static gdrr_sem_id_t virt_les(state_t state) {
//	printf("=> virt_les\n");
//	return NULL;
//}
//static gdrr_sem_id_t virt_leu(state_t state) {
//	printf("=> virt_leu\n");
//	return NULL;
//}
//static gdrr_sem_id_t virt_lts(state_t state) {
//	printf("=> virt_lts\n");
//	return NULL;
//}
//static gdrr_sem_id_t virt_ltu(state_t state) {
//	printf("=> virt_ltu\n");
//	return NULL;
//}
//static gdrr_sem_id_t virt_t(state_t state, int_t t) {
//	printf("=> id {t=%lu}\n", t);
//	return NULL;
//}
//static gdrr_sem_id_t sem_ip(state_t state) {
//	printf("=> sem_ip\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_flags(state_t state) {
//	printf("=> sem_flags\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_mxcsr(state_t state) {
//	printf("=> sem_mxcsr\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_ax(state_t state) {
//	printf("=> sem_ax\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_bx(state_t state) {
//	printf("=> sem_bx\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_cx(state_t state) {
//	printf("=> sem_cx\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_dx(state_t state) {
//	printf("=> sem_dx\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_si(state_t state) {
//	printf("=> sem_si\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_di(state_t state) {
//	printf("=> sem_di\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_sp(state_t state) {
//	printf("=> sem_sp\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_bp(state_t state) {
//	printf("=> sem_bp\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_r8(state_t state) {
//	printf("=> sem_r8\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_r9(state_t state) {
//	printf("=> sem_r9\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_r10(state_t state) {
//	printf("=> sem_r10\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_r11(state_t state) {
//	printf("=> sem_r11\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_r12(state_t state) {
//	printf("=> sem_r12\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_r13(state_t state) {
//	printf("=> sem_r13\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_r14(state_t state) {
//	printf("=> sem_r14\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_r15(state_t state) {
//	printf("=> sem_r15\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_cs(state_t state) {
//	printf("=> sem_cs\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_ds(state_t state) {
//	printf("=> sem_ds\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_ss(state_t state) {return NULL;
//	printf("=> sem_ss\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_es(state_t state) {
//	printf("=> sem_es\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_fs(state_t state) {
//	printf("=> sem_fs\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_gs(state_t state) {
//	printf("=> sem_gs\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_st0(state_t state) {
//	printf("=> sem_st0\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_st1(state_t state) {
//	printf("=> sem_st1\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_st2(state_t state) {
//	printf("=> sem_st2\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_st3(state_t state) {
//	printf("=> sem_st3\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_st4(state_t state) {
//	printf("=> sem_st4\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_st5(state_t state) {
//	printf("=> sem_st5\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_st6(state_t state) {
//	printf("=> sem_st6\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_st7(state_t state) {
//	printf("=> sem_st7\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_mm0(state_t state) {
//	printf("=> sem_mm0\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_mm1(state_t state) {
//	printf("=> sem_mm1\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_mm2(state_t state) {
//	printf("=> sem_mm2\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_mm3(state_t state) {
//	printf("=> sem_mm3\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_mm4(state_t state) {
//	printf("=> sem_mm4\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_mm5(state_t state) {
//	printf("=> sem_mm5\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_mm6(state_t state) {
//	printf("=> sem_mm6\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_mm7(state_t state) {
//	printf("=> sem_mm7\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_xmm0(state_t state) {
//	printf("=> sem_xmm0\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_xmm1(state_t state) {
//	printf("=> sem_xmm1\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_xmm2(state_t state) {
//	printf("=> sem_xmm2\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_xmm3(state_t state) {
//	printf("=> sem_xmm3\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_xmm4(state_t state) {
//	printf("=> sem_xmm4\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_xmm5(state_t state) {
//	printf("=> sem_xmm5\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_xmm6(state_t state) {
//	printf("=> sem_xmm6\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_xmm7(state_t state) {
//	printf("=> sem_xmm7\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_xmm8(state_t state) {
//	printf("=> sem_xmm8\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_xmm9(state_t state) {
//	printf("=> sem_xmm9\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_xmm10(state_t state) {
//	printf("=> sem_xmm10\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_xmm11(state_t state) {
//	printf("=> sem_xmm11\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_xmm12(state_t state) {
//	printf("=> sem_xmm12\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_xmm13(state_t state) {
//	printf("=> sem_xmm13\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_xmm14(state_t state) {
//	printf("=> sem_xmm14\n");
//	return NULL;
//}
//static gdrr_sem_id_t sem_xmm15(state_t state) {
//	printf("=> sem_xmm15\n");
//	return NULL;
//}

// sem_address
static obj_t sem_address(state_t state, int_t size,
		obj_t address) {
	printf("==> sem_address {size=%lu}\n", size);
	return NULL ;
}

// sem_var
static obj_t sem_var(state_t state, obj_t id, int_t offset) {
	printf("==> var {offset=%lu}\n", offset);
	return NULL ;
}

// sem_linear
static obj_t sem_lin_var(state_t state, obj_t this) {
	printf("==> sem_lin_var\n");
	return NULL ;
}
static obj_t sem_lin_imm(state_t state, int_t imm) {
	printf("==> sem_lin_imm {imm=%lu}\n", imm);
	return NULL ;
}
static obj_t sem_lin_add(state_t state, obj_t opnd1,
		obj_t opnd2) {
	printf("==> sem_lin_add\n");
	return NULL ;
}
static obj_t sem_lin_sub(state_t state, obj_t opnd1,
		obj_t opnd2) {
	printf("==> sem_lin_sub\n");
	return NULL ;
}
static obj_t sem_lin_scale(state_t state, int_t imm,
		obj_t opnd) {
	printf("==> sem_lin_scale {imm=%lu}\n", imm);
	return NULL ;
}

// sem_sexpr
static obj_t sem_sexpr_lin(state_t state, obj_t this) {
	printf("=> sem_sexpr_lin\n");
	return NULL ;
}
static obj_t sem_sexpr_cmp(state_t state, obj_t this) {
	printf("=> sem_sexpr_cmp\n");
	return NULL ;
}

// sem_op_cmp
static obj_t sem_cmpeq(state_t state, int_t size,
		obj_t opnd1, obj_t opnd2) {
	printf("=> cmpeq {size=%lu}\n", size);
	return NULL ;
}
static obj_t sem_cmpneq(state_t state, int_t size,
		obj_t opnd1, obj_t opnd2) {
	printf("=> cmpneq {size=%lu}\n", size);
	return NULL ;
}
static obj_t sem_cmples(state_t state, int_t size,
		obj_t opnd1, obj_t opnd2) {
	printf("=> cmples {size=%lu}\n", size);
	return NULL ;
}
static obj_t sem_cmpleu(state_t state, int_t size,
		obj_t opnd1, obj_t opnd2) {
	printf("=> cmpleu {size=%lu}\n", size);
	return NULL ;
}
static obj_t sem_cmplts(state_t state, int_t size,
		obj_t opnd1, obj_t opnd2) {
	printf("=> cmplts {size=%lu}\n", size);
	return NULL ;
}
static obj_t sem_cmpltu(state_t state, int_t size,
		obj_t opnd1, obj_t opnd2) {
	printf("=> cmpltu {size=%lu}\n", size);
	return NULL ;
}

// sem_op
static obj_t sem_lin(state_t state, int_t size,
		obj_t opnd1) {
	printf("=> lin {size=%lu}\n", size);
	return NULL ;
}
static obj_t sem_mul(state_t state, int_t size,
		obj_t opnd1, obj_t opnd2) {
	printf("=> mul {size=%lu}\n", size);
	return NULL ;
}
static obj_t sem_div(state_t state, int_t size,
		obj_t opnd1, obj_t opnd2) {
	printf("=> div {size=%lu}\n", size);
	return NULL ;
}
static obj_t sem_divs(state_t state, int_t size,
		obj_t opnd1, obj_t opnd2) {
	printf("=> divs {size=%lu}\n", size);
	return NULL ;
}
static obj_t sem_mod(state_t state, int_t size,
		obj_t opnd1, obj_t opnd2) {
	printf("=> mod {size=%lu}\n", size);
	return NULL ;
}
static obj_t sem_shl(state_t state, int_t size,
		obj_t opnd1, obj_t opnd2) {
	printf("=> shl {size=%lu}\n", size);
	return NULL ;
}
static obj_t sem_shr(state_t state, int_t size,
		obj_t opnd1, obj_t opnd2) {
	printf("=> shr {size=%lu}\n", size);
	return NULL ;
}
static obj_t sem_shrs(state_t state, int_t size,
		obj_t opnd1, obj_t opnd2) {
	printf("=> shrs {size=%lu}\n", size);
	return NULL ;
}
static obj_t sem_and(state_t state, int_t size,
		obj_t opnd1, obj_t opnd2) {
	printf("=> and {size=%lu}\n", size);
	return NULL ;
}
static obj_t sem_or(state_t state, int_t size,
		obj_t opnd1, obj_t opnd2) {
	printf("=> or {size=%lu}\n", size);
	return NULL ;
}
static obj_t sem_xor(state_t state, int_t size,
		obj_t opnd1, obj_t opnd2) {
	printf("=> xor {size=%lu}\n", size);
	return NULL ;
}
static obj_t sem_sx(state_t state, int_t size, int_t fromsize,
		obj_t opnd1) {
	printf("=> sx {size=%lu, fromsize=%lu}\n", size, fromsize);
	return NULL ;
}
static obj_t sem_zx(state_t state, int_t size, int_t fromsize,
		obj_t opnd1) {
	printf("=> zx {size=%lu, fromsize=%lu}\n", size, fromsize);
	return NULL ;
}
static obj_t sem_cmp(state_t state, obj_t this) {
	return NULL ;
}
static obj_t sem_arb(state_t state, int_t size) {
	printf("=> arb {size=%lu}\n", size);
	return NULL ;
}

// sem_varl
static obj_t sem_varl(state_t state, obj_t id, int_t offset, int_t size) {
	printf("=> sem_varl {id=..., offset=%ld, size=%ld}\n", offset, size);
	return NULL;
}

// sem_varls
static obj_t sem_varls_next(state_t state, obj_t next, obj_t list) {
	printf("=> sem_varls_next\n");
	return NULL;
}
static obj_t sem_varls_init(state_t state) {
	printf("=> sem_varls_init\n");
	return NULL;
}

// sem_flop
static obj_t sem_flop(state_t state, int_t con) {
	printf("=> sem_flop %ld\n", con);
	return NULL;
}

// sem_prim
static obj_t sem_prim_generic(state_t state, obj_t op, obj_t res, obj_t args) {
	printf("=> sem_prim_generic %s\n", (string_t)op);
	return NULL;
}
static obj_t sem_prim_flop(state_t state, obj_t op, obj_t flags, obj_t res, obj_t args) {
	printf("=> sem_prim_flop\n");
	return NULL;
}

//static gdrr_sem_branch_hint_t hint_jump(state_t state) {
//	printf("==> branch_hint_jump\n");
//	return NULL;
//}
//static gdrr_sem_branch_hint_t hint_call(state_t state) {
//	printf("==> branch_hint_call\n");
//	return NULL;
//}
//static gdrr_sem_branch_hint_t hint_ret(state_t state) {
//	printf("==> branch_hint_ret\n");
//	return NULL;
//}

// sem_stmt
static obj_t sem_assign(state_t state, obj_t lhs,
		obj_t rhs) {
	printf("assign\n");
	return NULL ;
}
static obj_t sem_load(state_t state, obj_t lhs, int_t size,
		obj_t address) {
	printf("load\n");
	return NULL ;
}
static obj_t sem_store(state_t state, obj_t address,
		obj_t rhs) {
	printf("store\n");
	return NULL ;
}
static obj_t sem_ite(state_t state, obj_t cond,
		obj_t then_branch, obj_t else_branch) {
	printf("ite\n");
	return NULL ;
}
static obj_t sem_while(state_t state, obj_t cond,
		obj_t body) {
	printf("while\n");
	return NULL ;
}
static obj_t sem_cbranch(state_t state, obj_t cond,
		obj_t target_true, obj_t target_false) {
	printf("cbranch\n");
	return NULL ;
}
static obj_t sem_branch(state_t state,
		obj_t branch_hint, obj_t target) {
	printf("branch\n");
	return NULL ;
}
static obj_t sem_prim(state_t state,
		obj_t prim) {
	printf("prim\n");
	return NULL ;
}

// branch_hint
static obj_t branch_hint(state_t state, int_t con) {
	printf("==> branch_hint#%lu\n", con);
	return NULL ;
}

// sem_stmts
//static gdrr_sem_stmts_t sem_cons(state_t state, gdrr_sem_stmt_t hd,
//		gdrr_sem_stmts_t tl) {
//	printf("sem_cons\n\n");
//	return NULL ;
//}
//static gdrr_sem_stmts_t sem_nil(state_t state) {
//	printf("sem_nil\n");
//	return NULL ;
//}

// sem_stmts
static obj_t list_next(state_t state, obj_t next,
		obj_t list) {
	printf("next statement\n\n");
	return NULL ;
}
static obj_t list_init(state_t state) {
	printf("init\n");
	return NULL ;
}

int main(int argc, char** argv) {
	uint8_t *buffer;
	size_t size = readhex_hex_read(stdin, &buffer);

	state_t state = gdsl_init();
	gdsl_set_code(state, (char*)buffer, size, 0);

	obj_t insn = gdsl_decode(state, gdsl_config_default(state));
//	__obj state = __createState(blob, i, 0, 0);
//	__obj insn = __runMonadicNoArg(__decode__, &state);

	string_t fmt = gdsl_merge_rope(state, gdsl_pretty(state, insn));
	puts(fmt);

	printf("---------------------------\n");

	obj_t rreil = gdsl_translate(state, insn);

	fmt = gdsl_merge_rope(state, gdsl_rreil_pretty(state, rreil));
	puts(fmt);

	unboxed_sem_id_callbacks_t sem_id_callbacks = {
			.shared = &shared,
			.virt_t = &virt_t,
			.arch = &arch
	};

	unboxed_sem_address_callbacks_t sem_address_callbacks = {
			.sem_address_ = &sem_address
	};

	unboxed_sem_var_callbacks_t sem_var_callbacks = {
			.sem_var_ = &sem_var
	};

	unboxed_sem_linear_callbacks_t sem_linear_callbacks = {
			.sem_lin_var = &sem_lin_var,
			.sem_lin_imm = &sem_lin_imm,
			.sem_lin_add = &sem_lin_add,
			.sem_lin_sub = &sem_lin_sub,
			.sem_lin_scale = &sem_lin_scale
	};

	unboxed_sem_sexpr_callbacks_t sem_sexpr_callbacks = {
			.sem_sexpr_lin = &sem_sexpr_lin,
			.sem_sexpr_cmp = &sem_sexpr_cmp
	};

	unboxed_sem_op_cmp_callbacks_t sem_op_cmp_callbacks = {
			.sem_cmpeq = &sem_cmpeq,
			.sem_cmpneq = &sem_cmpneq,
			.sem_cmples = &sem_cmples,
			.sem_cmpleu = &sem_cmpleu,
			.sem_cmplts = &sem_cmplts,
			.sem_cmpltu = &sem_cmpltu
	};

	unboxed_sem_op_callbacks_t sem_op_callbacks = {
			.sem_lin = &sem_lin,
			.sem_mul = &sem_mul,
			.sem_div = &sem_div,
			.sem_divs = &sem_divs,
			.sem_mod = &sem_mod,
			.sem_shl = &sem_shl,
			.sem_shr = &sem_shr,
			.sem_shrs = &sem_shrs,
			.sem_and = &sem_and,
			.sem_or = &sem_or,
			.sem_xor = &sem_xor,
			.sem_sx = &sem_sx,
			.sem_zx = &sem_zx,
			.sem_cmp = &sem_cmp,
			.sem_arb = &sem_arb
	};

	unboxed_sem_varl_callbacks_t sem_varl_callbacks = {
			.sem_varl_ = &sem_varl
	};

	unboxed_sem_varls_callbacks_t sem_varls_callbacks = {
			.sem_varls_next = &sem_varls_next,
			.sem_varls_init = &sem_varls_init
	};

	unboxed_sem_flop_callbacks_t sem_flop_callbacks = {
			.sem_flop_ = &sem_flop
	};

	unboxed_sem_prim_callbacks_t sem_prim_callbacks = {
			.sem_prim_generic = &sem_prim_generic,
			.sem_prim_flop = &sem_prim_flop
	};

	unboxed_sem_stmt_callbacks_t sem_stmt_callbacks = {
			.sem_assign = &sem_assign,
			.sem_load = &sem_load,
			.sem_store = &sem_store,
			.sem_ite = &sem_ite,
			.sem_while = &sem_while,
			.sem_cbranch = &sem_cbranch,
			.sem_branch = &sem_branch,
			.sem_prim = &sem_prim
	};

	unboxed_branch_hint_callbacks_t branch_hint_callbacks = {
			.branch_hint_ = &branch_hint
	};

//	unboxed_sem_stmts_list_callbacks_t sem_stmts_list_callbacks = {
//			.list_init = &list_init,
//			.list_next = &list_next
//	};

	unboxed_sem_stmts_callbacks_t sem_stmts_callbacks = {
			.init = &list_init,
			.next = &list_next
	};

	unboxed_callbacks_t callbacks = {
			.sem_id = &sem_id_callbacks,
			.sem_address = &sem_address_callbacks,
			.sem_var = &sem_var_callbacks,
			.sem_linear = &sem_linear_callbacks,
			.sem_sexpr = &sem_sexpr_callbacks,
			.sem_op_cmp = &sem_op_cmp_callbacks,
			.sem_op = &sem_op_callbacks,
			.sem_varl = &sem_varl_callbacks,
			.sem_varls = &sem_varls_callbacks,
			.sem_flop = &sem_flop_callbacks,
			.sem_prim = &sem_prim_callbacks,
			.sem_stmt = &sem_stmt_callbacks,
			.branch_hint = &branch_hint_callbacks,
			.sem_stmts = &sem_stmts_callbacks
	};

//		config.callbacks.sem_stmts.sem_cons = &sem_cons;
//		config.callbacks.sem_stmts.sem_nil = &sem_nil;
//		config.gdrr_config_stmts_handling = GDRR_CONFIG_STMTS_HANDLING_RECURSIVE;

//	obj_t stmts_rest = rreil;
//	while(gdsl_rreil_sem_stmts_has_more(state, stmts_rest)) {
//		printf("~~~ (loop) next statement\n");
//		gdsl_rreil_convert_sem_stmt_manual(state, &callbacks, gdsl_rreil_sem_stmts_head(state, stmts_rest));
//		stmts_rest = gdsl_rreil_sem_stmts_tail(state, stmts_rest);
//	}

	gdsl_rreil_convert_sem_stmts(state, &callbacks, rreil);

	gdsl_destroy(state);
	free(buffer);

	return 0;
}

