/* vim:cindent:ts=2:sw=2:expandtab */

#include <stdio.h>
#include <stdlib.h>
#include <gdsl-x86.h>
#include <gdrr.h>

// sem_id
static gdrr_sem_id_t *virt_na(void *closure, int_t con) {
	printf("=> virt#%ld\n", con);
	return NULL ;
}

static gdrr_sem_id_t *virt_t(void *closure, int_t t) {
	printf("=> t%ld\n", t);
	return NULL ;
}

static gdrr_sem_id_t *x86(void *closure, int_t con) {
	printf("=> x86#%ld\n", con);
	return NULL ;
}

//static gdrr_sem_id_t *virt_eq(void *closure) {
//	printf("=> virt_eq\n");
//	return NULL;
//}
//static gdrr_sem_id_t *virt_neq(void *closure) {
//	printf("=> virt_neq\n");
//	return NULL;
//}
//static gdrr_sem_id_t *virt_les(void *closure) {
//	printf("=> virt_les\n");
//	return NULL;
//}
//static gdrr_sem_id_t *virt_leu(void *closure) {
//	printf("=> virt_leu\n");
//	return NULL;
//}
//static gdrr_sem_id_t *virt_lts(void *closure) {
//	printf("=> virt_lts\n");
//	return NULL;
//}
//static gdrr_sem_id_t *virt_ltu(void *closure) {
//	printf("=> virt_ltu\n");
//	return NULL;
//}
//static gdrr_sem_id_t *virt_t(void *closure, int_t t) {
//	printf("=> id {t=%lu}\n", t);
//	return NULL;
//}
//static gdrr_sem_id_t *sem_ip(void *closure) {
//	printf("=> sem_ip\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_flags(void *closure) {
//	printf("=> sem_flags\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_mxcsr(void *closure) {
//	printf("=> sem_mxcsr\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_ax(void *closure) {
//	printf("=> sem_ax\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_bx(void *closure) {
//	printf("=> sem_bx\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_cx(void *closure) {
//	printf("=> sem_cx\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_dx(void *closure) {
//	printf("=> sem_dx\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_si(void *closure) {
//	printf("=> sem_si\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_di(void *closure) {
//	printf("=> sem_di\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_sp(void *closure) {
//	printf("=> sem_sp\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_bp(void *closure) {
//	printf("=> sem_bp\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_r8(void *closure) {
//	printf("=> sem_r8\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_r9(void *closure) {
//	printf("=> sem_r9\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_r10(void *closure) {
//	printf("=> sem_r10\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_r11(void *closure) {
//	printf("=> sem_r11\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_r12(void *closure) {
//	printf("=> sem_r12\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_r13(void *closure) {
//	printf("=> sem_r13\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_r14(void *closure) {
//	printf("=> sem_r14\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_r15(void *closure) {
//	printf("=> sem_r15\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_cs(void *closure) {
//	printf("=> sem_cs\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_ds(void *closure) {
//	printf("=> sem_ds\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_ss(void *closure) {return NULL;
//	printf("=> sem_ss\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_es(void *closure) {
//	printf("=> sem_es\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_fs(void *closure) {
//	printf("=> sem_fs\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_gs(void *closure) {
//	printf("=> sem_gs\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_st0(void *closure) {
//	printf("=> sem_st0\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_st1(void *closure) {
//	printf("=> sem_st1\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_st2(void *closure) {
//	printf("=> sem_st2\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_st3(void *closure) {
//	printf("=> sem_st3\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_st4(void *closure) {
//	printf("=> sem_st4\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_st5(void *closure) {
//	printf("=> sem_st5\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_st6(void *closure) {
//	printf("=> sem_st6\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_st7(void *closure) {
//	printf("=> sem_st7\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_mm0(void *closure) {
//	printf("=> sem_mm0\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_mm1(void *closure) {
//	printf("=> sem_mm1\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_mm2(void *closure) {
//	printf("=> sem_mm2\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_mm3(void *closure) {
//	printf("=> sem_mm3\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_mm4(void *closure) {
//	printf("=> sem_mm4\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_mm5(void *closure) {
//	printf("=> sem_mm5\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_mm6(void *closure) {
//	printf("=> sem_mm6\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_mm7(void *closure) {
//	printf("=> sem_mm7\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_xmm0(void *closure) {
//	printf("=> sem_xmm0\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_xmm1(void *closure) {
//	printf("=> sem_xmm1\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_xmm2(void *closure) {
//	printf("=> sem_xmm2\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_xmm3(void *closure) {
//	printf("=> sem_xmm3\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_xmm4(void *closure) {
//	printf("=> sem_xmm4\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_xmm5(void *closure) {
//	printf("=> sem_xmm5\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_xmm6(void *closure) {
//	printf("=> sem_xmm6\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_xmm7(void *closure) {
//	printf("=> sem_xmm7\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_xmm8(void *closure) {
//	printf("=> sem_xmm8\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_xmm9(void *closure) {
//	printf("=> sem_xmm9\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_xmm10(void *closure) {
//	printf("=> sem_xmm10\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_xmm11(void *closure) {
//	printf("=> sem_xmm11\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_xmm12(void *closure) {
//	printf("=> sem_xmm12\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_xmm13(void *closure) {
//	printf("=> sem_xmm13\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_xmm14(void *closure) {
//	printf("=> sem_xmm14\n");
//	return NULL;
//}
//static gdrr_sem_id_t *sem_xmm15(void *closure) {
//	printf("=> sem_xmm15\n");
//	return NULL;
//}

// sem_address
static gdrr_sem_address_t *sem_address(void *closure, int_t size,
		gdrr_sem_linear_t *address) {
	printf("==> sem_address {size=%lu}\n", size);
	return NULL ;
}

// sem_var
static gdrr_sem_var_t *sem_var(void *closure, gdrr_sem_id_t *id, int_t offset) {
	printf("==> var {offset=%lu}\n", offset);
	return NULL ;
}

// sem_linear
static gdrr_sem_linear_t *sem_lin_var(void *closure, gdrr_sem_var_t *this) {
	printf("==> sem_lin_var\n");
	return NULL ;
}
static gdrr_sem_linear_t *sem_lin_imm(void *closure, int_t imm) {
	printf("==> sem_lin_imm {imm=%lu}\n", imm);
	return NULL ;
}
static gdrr_sem_linear_t *sem_lin_add(void *closure, gdrr_sem_linear_t *opnd1,
		gdrr_sem_linear_t *opnd2) {
	printf("==> sem_lin_add\n");
	return NULL ;
}
static gdrr_sem_linear_t *sem_lin_sub(void *closure, gdrr_sem_linear_t *opnd1,
		gdrr_sem_linear_t *opnd2) {
	printf("==> sem_lin_sub\n");
	return NULL ;
}
static gdrr_sem_linear_t *sem_lin_scale(void *closure, int_t imm,
		gdrr_sem_linear_t *opnd) {
	printf("==> sem_lin_scale {imm=%lu}\n", imm);
	return NULL ;
}

// sem_sexpr
static gdrr_sem_sexpr_t *sem_sexpr_lin(void *closure, gdrr_sem_linear_t *this) {
	printf("=> sem_sexpr_lin\n");
	return NULL ;
}
static gdrr_sem_sexpr_t *sem_sexpr_cmp(void *closure, gdrr_sem_op_cmp_t *this) {
	printf("=> sem_sexpr_cmp\n");
	return NULL ;
}

// sem_op_cmp
static gdrr_sem_op_cmp_t *sem_cmpeq(void *closure, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	printf("=> cmpeq {size=%lu}\n", size);
	return NULL ;
}
static gdrr_sem_op_cmp_t *sem_cmpneq(void *closure, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	printf("=> cmpneq {size=%lu}\n", size);
	return NULL ;
}
static gdrr_sem_op_cmp_t *sem_cmples(void *closure, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	printf("=> cmples {size=%lu}\n", size);
	return NULL ;
}
static gdrr_sem_op_cmp_t *sem_cmpleu(void *closure, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	printf("=> cmpleu {size=%lu}\n", size);
	return NULL ;
}
static gdrr_sem_op_cmp_t *sem_cmplts(void *closure, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	printf("=> cmplts {size=%lu}\n", size);
	return NULL ;
}
static gdrr_sem_op_cmp_t *sem_cmpltu(void *closure, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	printf("=> cmpltu {size=%lu}\n", size);
	return NULL ;
}

// sem_op
static gdrr_sem_op_t *sem_lin(void *closure, int_t size,
		gdrr_sem_linear_t *opnd1) {
	printf("=> lin {size=%lu}\n", size);
	return NULL ;
}
static gdrr_sem_op_t *sem_mul(void *closure, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	printf("=> mul {size=%lu}\n", size);
	return NULL ;
}
static gdrr_sem_op_t *sem_div(void *closure, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	printf("=> div {size=%lu}\n", size);
	return NULL ;
}
static gdrr_sem_op_t *sem_divs(void *closure, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	printf("=> divs {size=%lu}\n", size);
	return NULL ;
}
static gdrr_sem_op_t *sem_mod(void *closure, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	printf("=> mod {size=%lu}\n", size);
	return NULL ;
}
static gdrr_sem_op_t *sem_shl(void *closure, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	printf("=> shl {size=%lu}\n", size);
	return NULL ;
}
static gdrr_sem_op_t *sem_shr(void *closure, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	printf("=> shr {size=%lu}\n", size);
	return NULL ;
}
static gdrr_sem_op_t *sem_shrs(void *closure, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	printf("=> shrs {size=%lu}\n", size);
	return NULL ;
}
static gdrr_sem_op_t *sem_and(void *closure, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	printf("=> and {size=%lu}\n", size);
	return NULL ;
}
static gdrr_sem_op_t *sem_or(void *closure, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	printf("=> or {size=%lu}\n", size);
	return NULL ;
}
static gdrr_sem_op_t *sem_xor(void *closure, int_t size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	printf("=> xor {size=%lu}\n", size);
	return NULL ;
}
static gdrr_sem_op_t *sem_sx(void *closure, int_t size, int_t fromsize,
		gdrr_sem_linear_t *opnd1) {
	printf("=> sx {size=%lu, fromsize=%lu}\n", size, fromsize);
	return NULL ;
}
static gdrr_sem_op_t *sem_zx(void *closure, int_t size, int_t fromsize,
		gdrr_sem_linear_t *opnd1) {
	printf("=> zx {size=%lu, fromsize=%lu}\n", size, fromsize);
	return NULL ;
}
static gdrr_sem_op_t *sem_cmp(void *closure, gdrr_sem_op_cmp_t *this) {
	return NULL ;
}
static gdrr_sem_op_t *sem_arb(void *closure, int_t size) {
	printf("=> arb {size=%lu}\n", size);
	return NULL ;
}

// branch_hint
static gdrr_branch_hint_t *branch_hint(void *closure, int_t con) {
	printf("==> branch_hint#%lu\n", con);
	return NULL ;
}

//static gdrr_sem_branch_hint_t *hint_jump(void *closure) {
//	printf("==> branch_hint_jump\n");
//	return NULL;
//}
//static gdrr_sem_branch_hint_t *hint_call(void *closure) {
//	printf("==> branch_hint_call\n");
//	return NULL;
//}
//static gdrr_sem_branch_hint_t *hint_ret(void *closure) {
//	printf("==> branch_hint_ret\n");
//	return NULL;
//}

// sem_stmt
static gdrr_sem_stmt_t *sem_assign(void *closure, gdrr_sem_var_t *lhs,
		gdrr_sem_op_t *rhs) {
	printf("assign\n");
	return NULL ;
}
static gdrr_sem_stmt_t *sem_load(void *closure, gdrr_sem_var_t *lhs, int_t size,
		gdrr_sem_address_t *address) {
	printf("load\n");
	return NULL ;
}
static gdrr_sem_stmt_t *sem_store(void *closure, gdrr_sem_address_t *address,
		gdrr_sem_op_t *rhs) {
	printf("store\n");
	return NULL ;
}
static gdrr_sem_stmt_t *sem_ite(void *closure, gdrr_sem_sexpr_t *cond,
		gdrr_sem_stmts_t *then_branch, gdrr_sem_stmts_t *else_branch) {
	printf("ite\n");
	return NULL ;
}
static gdrr_sem_stmt_t *sem_while(void *closure, gdrr_sem_sexpr_t *cond,
		gdrr_sem_stmts_t *body) {
	printf("while\n");
	return NULL ;
}
static gdrr_sem_stmt_t *sem_cbranch(void *closure, gdrr_sem_sexpr_t *cond,
		gdrr_sem_address_t *target_true, gdrr_sem_address_t *target_false) {
	printf("cbranch\n");
	return NULL ;
}
static gdrr_sem_stmt_t *sem_branch(void *closure,
		gdrr_branch_hint_t *branch_hint, gdrr_sem_address_t *target) {
	printf("branch\n");
	return NULL ;
}

// sem_stmts
//static gdrr_sem_stmts_t *sem_cons(void *closure, gdrr_sem_stmt_t *hd,
//		gdrr_sem_stmts_t *tl) {
//	printf("sem_cons\n\n");
//	return NULL ;
//}
//static gdrr_sem_stmts_t *sem_nil(void *closure) {
//	printf("sem_nil\n");
//	return NULL ;
//}

// sem_stmts
static gdrr_sem_stmts_t *list_next(void *closure, gdrr_sem_stmt_t *next,
		gdrr_sem_stmts_t *list) {
	printf("next statement\n\n");
	return NULL ;
}
static gdrr_sem_stmts_t *list_init(void *closure) {
	printf("init\n");
	return NULL ;
}

int main(int argc, char** argv) {
//	char blob[15];
//	int_t sz = 15;
//	int i, c;
//	for(i = 0; i < sz; i++) {
//		int x = fscanf(stdin, "%x", &c);
//		switch(x) {
//			case EOF:
//				goto done;
//			case 0:
//				printf("invalid input; should be in hex form: '0f 0b ..'");
//		}
//		blob[i] = c & 0xff;
//	}
//	done: ;
	char blob[] = { 0x48, 0x83, 0xc4, 0x38 };
	int i = sizeof(blob);

	state_t state = gdsl_init();
	gdsl_set_code(state, blob, i, 0);

	obj_t insn = x86_decode(state);
//	__obj state = __createState(blob, i, 0, 0);
//	__obj insn = __runMonadicNoArg(__decode__, &state);

	string_t fmt = x86_pretty(state, insn);
	puts(fmt);

	printf("---------------------------\n");

	obj_t rreil = x86_translate(state, insn);

	fmt = x86_rreil_pretty(state, rreil);
	puts(fmt);

	struct gdrr_config config;

	config.callbacks.sem_id.virt_na = &virt_na;
	config.callbacks.sem_id.virt_t = &virt_t;
	config.callbacks.arch.x86.sem_id.x86 = &x86;

	config.callbacks.sem_address.sem_address = &sem_address;

	config.callbacks.sem_var.sem_var = &sem_var;

	config.callbacks.sem_linear.sem_lin_var = &sem_lin_var;
	config.callbacks.sem_linear.sem_lin_imm = &sem_lin_imm;
	config.callbacks.sem_linear.sem_lin_add = &sem_lin_add;
	config.callbacks.sem_linear.sem_lin_sub = &sem_lin_sub;
	config.callbacks.sem_linear.sem_lin_scale = &sem_lin_scale;

	config.callbacks.sem_op_cmp.sem_cmpeq = &sem_cmpeq;
	config.callbacks.sem_op_cmp.sem_cmpneq = &sem_cmpneq;
	config.callbacks.sem_op_cmp.sem_cmples = &sem_cmples;
	config.callbacks.sem_op_cmp.sem_cmpleu = &sem_cmpleu;
	config.callbacks.sem_op_cmp.sem_cmplts = &sem_cmplts;
	config.callbacks.sem_op_cmp.sem_cmpltu = &sem_cmpltu;

	config.callbacks.sem_sexpr.sem_sexpr_lin = &sem_sexpr_lin;
	config.callbacks.sem_sexpr.sem_sexpr_cmp = &sem_sexpr_cmp;

	config.callbacks.sem_op.sem_lin = &sem_lin;
	config.callbacks.sem_op.sem_mul = &sem_mul;
	config.callbacks.sem_op.sem_div = &sem_div;
	config.callbacks.sem_op.sem_divs = &sem_divs;
	config.callbacks.sem_op.sem_mod = &sem_mod;
	config.callbacks.sem_op.sem_shl = &sem_shl;
	config.callbacks.sem_op.sem_shr = &sem_shr;
	config.callbacks.sem_op.sem_shrs = &sem_shrs;
	config.callbacks.sem_op.sem_and = &sem_and;
	config.callbacks.sem_op.sem_or = &sem_or;
	config.callbacks.sem_op.sem_xor = &sem_xor;
	config.callbacks.sem_op.sem_sx = &sem_sx;
	config.callbacks.sem_op.sem_zx = &sem_zx;
	config.callbacks.sem_op.sem_cmp = &sem_cmp;
	config.callbacks.sem_op.sem_arb = &sem_arb;

	config.callbacks.branch_hint.branch_hint = &branch_hint;

	config.callbacks.sem_stmt.sem_assign = &sem_assign;
	config.callbacks.sem_stmt.sem_load = &sem_load;
	config.callbacks.sem_stmt.sem_store = &sem_store;
	config.callbacks.sem_stmt.sem_ite = &sem_ite;
	config.callbacks.sem_stmt.sem_while = &sem_while;
	config.callbacks.sem_stmt.sem_cbranch = &sem_cbranch;
	config.callbacks.sem_stmt.sem_branch = &sem_branch;

	config.callbacks.sem_stmts_list.list_init = &list_init;
	config.callbacks.sem_stmts_list.list_next = &list_next;
	config.gdrr_config_stmts_handling = GDRR_CONFIG_STMTS_HANDLING_LIST;
//		config.callbacks.sem_stmts.sem_cons = &sem_cons;
//		config.callbacks.sem_stmts.sem_nil = &sem_nil;
//		config.gdrr_config_stmts_handling = GDRR_CONFIG_STMTS_HANDLING_RECURSIVE;

	config.state = state;

	gdrr_convert(rreil, &config);

	gdsl_destroy(state);

	return 0;
}

