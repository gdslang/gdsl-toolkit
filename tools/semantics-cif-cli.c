/* vim:cindent:ts=2:sw=2:expandtab */

#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <readhex.h>
#include <gdsl.h>
#include <gdsl_generic.h>

static obj_t indent_unary(obj_t a) {
  size_t me = (size_t)a + 1;
  for(size_t i = 0; i < me; ++i)
    printf("=");
  return (obj_t)me;
}

static obj_t indent_binary(obj_t a, obj_t b) {
  size_t ai = (size_t)a;
  size_t bi = (size_t)b;
  return indent_unary(bi > ai ? b : a);
}

static obj_t indent_ternary(obj_t a, obj_t b, obj_t c) {
  size_t ai = (size_t)a;
  size_t bi = (size_t)b;
  return indent_binary(bi > ai ? b : a, c);
}

static obj_t indent_quaternary(obj_t a, obj_t b, obj_t c, obj_t d) {
  size_t ai = (size_t)a;
  size_t bi = (size_t)b;
  return indent_ternary(bi > ai ? b : a, c, d);
}

// Generic ASM

static obj_t asm_insn(state_t state, int_t length, string_t mnemonic, obj_t annotations, obj_t opnds) {
  obj_t indent = indent_binary(annotations, opnds);
  printf("> insn {length=%lld, mnemonic=%s}\n\n", length, mnemonic);
  return indent;
}

// operand list

static obj_t asm_opnds_next(state_t state, obj_t next, obj_t list) {
  obj_t indent = indent_unary(next);
  printf("> next operand\n");
  return indent;
}

static obj_t asm_opnds_init(state_t state, obj_t next) {
  printf("> init operands\n");
  return (state_t)0;
}

// operand

static obj_t asm_register(state_t state, string_t mnemonic) {
  printf("> register {mnemonic=%s}\n", mnemonic);
  return (state_t)0;
}

static obj_t asm_memory(state_t state, obj_t _this) {
  obj_t indent = indent_unary(_this);
  printf("> memory\n");
  return indent;
}

static obj_t asm_imm(state_t state, obj_t _this) {
  obj_t indent = indent_unary(_this);
  printf("> immediate\n");
  return indent;
}

static obj_t asm_post_op(state_t state, obj_t expr, obj_t opnd) {
  obj_t indent = indent_binary(expr, opnd);
  printf("> post_op\n");
  return indent;
}

static obj_t asm_pre_op(state_t state, obj_t expr, obj_t opnd) {
  obj_t indent = indent_binary(expr, opnd);
  printf("> pre_op\n");
  return indent;
}

static obj_t asm_rel(state_t state, obj_t _this) {
  obj_t indent = indent_unary(_this);
  printf("> rel\n");
  return indent;
}

static obj_t asm_annotation(state_t state, obj_t ann, obj_t opnd) {
  obj_t indent = indent_binary(ann, opnd);
  printf("> annotation\n");
  return indent;
}

static obj_t asm_sum(state_t state, obj_t lhs, obj_t rhs) {
  obj_t indent = indent_binary(lhs, rhs);
  printf("> sum\n");
  return indent;
}

static obj_t asm_scale(state_t state, int_t factor, obj_t rhs) {
  obj_t indent = indent_unary(rhs);
  printf("> scale {factor=%lld}\n", factor);
  return indent;
}

static obj_t asm_bounded(state_t state, obj_t ann, obj_t opnd) {
  obj_t indent = indent_binary(ann, opnd);
  printf("> bounded\n");
  return indent;
}

// boundary

static obj_t asm_sz(state_t state, int_t sz) {
  printf("> boundary {size=%lld}\n", sz);
  return (state_t)0;
}

static obj_t asm_sz_o(state_t state, int_t sz, int_t o) {
  printf("> boundary {size=%lld, offset=%lld}\n", sz, o);
  return (state_t)0;
}

// annotation list

static obj_t asm_annotations_next(state_t state, obj_t next, obj_t list) {
  obj_t indent = indent_unary(next);
  printf("> next annotation\n");
  return indent;
}

static obj_t asm_annotations_init(state_t state, obj_t next) {
  printf("> init annotations\n");
  return (state_t)0;
}

// annotation

static obj_t asm_annotation_string(state_t state, string_t _this) {
  printf("> annotation {%s}\n", _this);
  return (state_t)0;
}

static obj_t asm_annotation_function(state_t state, string_t name, obj_t args) {
  obj_t indent = indent_unary(args);
  printf("> annotation {name=%s}\n", name);
  return indent;
}

static obj_t asm_annotation_opnd(state_t state, string_t name, obj_t opnd) {
  obj_t indent = indent_unary(opnd);
  printf("> annotation {name=%s}\n", name);
  return indent;
}

// immediate

static obj_t asm_immediate(state_t state, int_t _this) {
  printf("> immediate {%lld}\n", _this);
  return (state_t)0;
}

static obj_t asm_immediate_unknown_signedness(state_t state, int_t value, int_t size) {
  printf("> immediate {value=%lld, size=%lld}\n", value, size);
  return (state_t)0;
}

// RReil

// sem_id
//static gdrr_sem_id_t *virt_na(state_t state, int_t con) {
//	printf("=> virt#%ld\n", con);
//	return NULL ;
//}
static obj_t shared(state_t state, int_t con) {
  switch(con) {
    case FLOATING_FLAGS: {
      printf("> FLOATING_FLAGS\n");
      break;
    }
  }
  return (obj_t)0;
}
static obj_t virt_t(state_t state, int_t t) {
  printf("> t%lld\n", t);
  return (obj_t)0;
}
static obj_t arch(state_t state, obj_t id) {
  printf("> %s\n", gdsl_merge_rope(state, gdsl_pretty_arch_id(state, id)));
  return (obj_t)0;
}

// sem_exception
static obj_t exception_shared(state_t state, int_t con) {
  switch(con) {
    case DIVISION_BY_ZERO: {
      printf("> DIVISION_BY_ZERO\n");
      break;
    }
  }
  return (obj_t)0;
}
static obj_t exception_arch(state_t state, obj_t ex) {
  printf("> exception_arch#%s\n", gdsl_merge_rope(state, gdsl_pretty_arch_exception(state, ex)));
  return (obj_t)0;
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
static obj_t sem_address(state_t state, int_t size, obj_t address) {
  obj_t indent = indent_unary(address);
  printf("> sem_address {size=%lld}\n", size);
  return indent;
}

// sem_var
static obj_t sem_var(state_t state, obj_t id, int_t offset) {
  obj_t indent = indent_unary(id);
  printf("> var {offset=%lld}\n", offset);
  return indent;
}

// sem_linear
static obj_t sem_lin_var(state_t state, obj_t this) {
  obj_t indent = indent_unary(this);
  printf("> sem_lin_var\n");
  return indent;
}
static obj_t sem_lin_imm(state_t state, int_t imm) {
  printf("> sem_lin_imm {imm=%lld}\n", imm);
  return (obj_t)0;
}
static obj_t sem_lin_add(state_t state, obj_t opnd1, obj_t opnd2) {
  obj_t indent = indent_binary(opnd1, opnd2);
  printf("> sem_lin_add\n");
  return indent;
}
static obj_t sem_lin_sub(state_t state, obj_t opnd1, obj_t opnd2) {
  obj_t indent = indent_binary(opnd1, opnd2);
  printf("> sem_lin_sub\n");
  return indent;
}
static obj_t sem_lin_scale(state_t state, int_t imm, obj_t opnd) {
  obj_t indent = indent_unary(opnd);
  printf("> sem_lin_scale {imm=%lld}\n", imm);
  return indent;
}

// sem_sexpr
static obj_t sem_sexpr_lin(state_t state, obj_t this) {
  obj_t indent = indent_unary(this);
  printf("> sem_sexpr_lin\n");
  return indent;
}
static obj_t sem_sexpr_cmp(state_t state, obj_t this) {
  obj_t indent = indent_unary(this);
  printf("> sem_sexpr_cmp\n");
  return indent;
}
static obj_t sem_sexpr_arb(state_t state, obj_t nothing) {
  printf("> sem_sexpr_arb\n");
  return (obj_t)0;
}

// sem_expr_cmp
static obj_t sem_cmpeq(state_t state, obj_t opnd1, obj_t opnd2) {
  obj_t indent = indent_binary(opnd1, opnd2);
  printf("> cmpeq\n");
  return indent;
}
static obj_t sem_cmpneq(state_t state, obj_t opnd1, obj_t opnd2) {
  obj_t indent = indent_binary(opnd1, opnd2);
  printf("> cmpneq\n");
  return indent;
}
static obj_t sem_cmples(state_t state, obj_t opnd1, obj_t opnd2) {
  obj_t indent = indent_binary(opnd1, opnd2);
  printf("> cmples\n");
  return indent;
}
static obj_t sem_cmpleu(state_t state, obj_t opnd1, obj_t opnd2) {
  obj_t indent = indent_binary(opnd1, opnd2);
  printf("> cmpleu\n");
  return indent;
}
static obj_t sem_cmplts(state_t state, obj_t opnd1, obj_t opnd2) {
  obj_t indent = indent_binary(opnd1, opnd2);
  printf("> cmplts\n");
  return indent;
}
static obj_t sem_cmpltu(state_t state, obj_t opnd1, obj_t opnd2) {
  obj_t indent = indent_binary(opnd1, opnd2);
  printf("> cmpltu\n");
  return indent;
}

// sem_expr
static obj_t sem_sexpr(state_t state, obj_t this) {
  obj_t indent = indent_unary(this);
  printf("> sem_sexpr\n");
  return indent;
}
static obj_t sem_mul(state_t state, obj_t opnd1, obj_t opnd2) {
  obj_t indent = indent_binary(opnd1, opnd2);
  printf("> mul");
  return indent;
}
static obj_t sem_div(state_t state, obj_t opnd1, obj_t opnd2) {
  obj_t indent = indent_binary(opnd1, opnd2);
  printf("> div");
  return indent;
}
static obj_t sem_divs(state_t state, obj_t opnd1, obj_t opnd2) {
  obj_t indent = indent_binary(opnd1, opnd2);
  printf("> divs");
  return indent;
}
static obj_t sem_mod(state_t state, obj_t opnd1, obj_t opnd2) {
  obj_t indent = indent_binary(opnd1, opnd2);
  printf("> mod");
  return indent;
}
static obj_t sem_mods(state_t state, obj_t opnd1, obj_t opnd2) {
  obj_t indent = indent_binary(opnd1, opnd2);
  printf("> mods");
  return indent;
}
static obj_t sem_shl(state_t state, obj_t opnd1, obj_t opnd2) {
  obj_t indent = indent_binary(opnd1, opnd2);
  printf("> shl");
  return indent;
}
static obj_t sem_shr(state_t state, obj_t opnd1, obj_t opnd2) {
  obj_t indent = indent_binary(opnd1, opnd2);
  printf("> shr");
  return indent;
}
static obj_t sem_shrs(state_t state, obj_t opnd1, obj_t opnd2) {
  obj_t indent = indent_binary(opnd1, opnd2);
  printf("> shrs");
  return indent;
}
static obj_t sem_and(state_t state, obj_t opnd1, obj_t opnd2) {
  obj_t indent = indent_binary(opnd1, opnd2);
  printf("> and");
  return indent;
}
static obj_t sem_or(state_t state, obj_t opnd1, obj_t opnd2) {
  obj_t indent = indent_binary(opnd1, opnd2);
  printf("> or");
  return indent;
}
static obj_t sem_xor(state_t state, obj_t opnd1, obj_t opnd2) {
  obj_t indent = indent_binary(opnd1, opnd2);
  printf("> xor");
  return indent;
}
static obj_t sem_sx(state_t state, int_t fromsize, obj_t opnd1) {
  obj_t indent = indent_unary(opnd1);
  printf("> sx {fromsize=%lld}\n", fromsize);
  return indent;
}
static obj_t sem_zx(state_t state, int_t fromsize, obj_t opnd1) {
  obj_t indent = indent_unary(opnd1);
  printf("> zx {fromsize=%lld}\n", fromsize);
  return indent;
}

// sem_varl
static obj_t sem_varl(state_t state, obj_t id, int_t offset, int_t size) {
  obj_t indent = indent_unary(id);
  printf("> sem_varl {offset=%lld, size=%lld}\n", offset, size);
  return indent;
}

// sem_varls
static obj_t sem_varls_next(state_t state, obj_t next, obj_t list) {
  obj_t indent = indent_unary(next);
  printf("> sem_varls_next\n");
  return indent;
}
static obj_t sem_varls_init(state_t state, obj_t nothing) {
  printf("> sem_varls_init\n");
  return (obj_t)0;
}

// sem_flop
static obj_t sem_flop(state_t state, int_t con) {
  printf("> sem_flop %lld\n", con);
  return (obj_t)0;
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
static obj_t sem_assign(state_t state, int_t size, obj_t lhs, obj_t rhs) {
  obj_t indent = indent_binary(lhs, rhs);
  printf("> assign {size=%lld}\n", size);
  return indent;
}
static obj_t sem_load(state_t state, int_t size, obj_t lhs, obj_t address) {
  obj_t indent = indent_binary(lhs, address);
  printf("> load {size=%lld}\n", size);
  return indent;
}
static obj_t sem_store(state_t state, int_t size, obj_t address, obj_t rhs) {
  obj_t indent = indent_binary(address, rhs);
  printf("> store {size=%lld}\n", size);
  return indent;
}
static obj_t sem_ite(state_t state, obj_t cond, obj_t then_branch, obj_t else_branch) {
  obj_t indent = indent_unary(cond);
  printf("> ite\n");
  return indent;
}
static obj_t sem_while(state_t state, obj_t cond, obj_t body) {
  obj_t indent = indent_unary(cond);
  printf("> while\n");
  return indent;
}
static obj_t sem_cbranch(state_t state, obj_t cond, obj_t target_true, obj_t target_false) {
  obj_t indent = indent_ternary(cond, target_true, target_false);
  printf("> cbranch\n");
  return indent;
}
static obj_t sem_branch(state_t state, obj_t branch_hint, obj_t target) {
  obj_t indent = indent_binary(branch_hint, target);
  printf("> branch\n");
  return indent;
}
static obj_t sem_flop_stmt(state_t state, obj_t op, obj_t flags, obj_t lhs, obj_t rhs) {
  obj_t indent = indent_quaternary(op, flags, lhs, rhs);
  printf("> sem_flop\n");
  return indent;
}
static obj_t sem_prim(state_t state, obj_t op, obj_t lhs, obj_t rhs) {
  obj_t indent = indent_binary(lhs, rhs);
  printf("> sem_prim %s\n", (string_t)op);
  return indent;
}
static obj_t sem_throw(state_t state, obj_t exception) {
  obj_t indent = indent_unary(exception);
  printf("> sem_throw\n");
  return indent;
}

// branch_hint
static obj_t branch_hint(state_t state, int_t con) {
  printf("> branch_hint#%lld\n", con);
  return (obj_t)0;
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
static obj_t sem_stmts_next(state_t state, obj_t next, obj_t list) {
  obj_t indent = indent_unary(next);
  printf("> next statement\n\n");
  return indent;
}
static obj_t sem_stmts_init(state_t state, obj_t nothing) {
  printf("> init\n");
  return (obj_t)0;
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

  printf("\n");

  unboxed_asm_opnds_callbacks_t asm_opnds_callbacks = {.opnds_next = &asm_opnds_next, .init = &asm_opnds_init};
  unboxed_asm_opnd_callbacks_t asm_opnd_callbacks = {.opnd_register = &asm_register, .memory = &asm_memory, .imm =
      &asm_imm, .post_op = &asm_post_op, .pre_op = &asm_pre_op, .rel = &asm_rel, .annotation = &asm_annotation, .sum =
      &asm_sum, .scale = &asm_scale, .bounded = &asm_bounded};
  unboxed_asm_boundary_callbacks_t asm_boundary_callbacks = {.sz = &asm_sz, .sz_o = &asm_sz_o};
  unboxed_asm_annotations_callbacks_t asm_annotations_callbacks = {.annotations_next = &asm_annotations_next, .init =
      &asm_annotations_init};
  unboxed_asm_annotation_callbacks_t asm_annotation_callbacks = {.ann_string = &asm_annotation_string, .function =
      &asm_annotation_function, .opnd = &asm_annotation_opnd};
  unboxed_asm_immediate_callbacks_t asm_immediate_callbacks = {.immediate = &asm_immediate, .unknown_signedness =
      &asm_immediate_unknown_signedness};

  unboxed_asm_callbacks_t asm_callbacks = {
      .insn = &asm_insn,
      .opnds = &asm_opnds_callbacks,
      .opnd = &asm_opnd_callbacks,
      .boundary = &asm_boundary_callbacks,
      .annotations = &asm_annotations_callbacks,
      .annotation = &asm_annotation_callbacks,
      .immediate = &asm_immediate_callbacks
  };

  obj_t generic_insn = gdsl_generalize(state, insn);

  obj_t ginsn_convert = gdsl_asm_convert_insn(state, &asm_callbacks, generic_insn);

  printf("---------------------------\n\n");

  obj_t rreil = gdsl_translate(state, insn);

  fmt = gdsl_merge_rope(state, gdsl_rreil_pretty(state, rreil));
  puts(fmt);

  unboxed_sem_id_callbacks_t sem_id_callbacks = {.shared = &shared, .virt_t = &virt_t, .arch = &arch};

  unboxed_sem_exception_callbacks_t sem_exception_callbacks = {.shared = &exception_shared, .arch = &exception_arch};

  unboxed_sem_address_callbacks_t sem_address_callbacks = {.sem_address_ = &sem_address};

  unboxed_sem_var_callbacks_t sem_var_callbacks = {.sem_var_ = &sem_var};

  unboxed_sem_linear_callbacks_t sem_linear_callbacks = {.sem_lin_var = &sem_lin_var, .sem_lin_imm = &sem_lin_imm,
      .sem_lin_add = &sem_lin_add, .sem_lin_sub = &sem_lin_sub, .sem_lin_scale = &sem_lin_scale};

  unboxed_sem_sexpr_callbacks_t sem_sexpr_callbacks = {.sem_sexpr_lin = &sem_sexpr_lin, .sem_sexpr_cmp = &sem_sexpr_cmp,
      .sem_sexpr_arb = &sem_sexpr_arb};

  unboxed_sem_expr_cmp_callbacks_t sem_expr_cmp_callbacks = {.sem_cmpeq = &sem_cmpeq, .sem_cmpneq = &sem_cmpneq,
      .sem_cmples = &sem_cmples, .sem_cmpleu = &sem_cmpleu, .sem_cmplts = &sem_cmplts, .sem_cmpltu = &sem_cmpltu};

  unboxed_sem_expr_callbacks_t sem_expr_callbacks = {.sem_sexpr = &sem_sexpr, .sem_mul = &sem_mul, .sem_div = &sem_div,
      .sem_divs = &sem_divs, .sem_mod = &sem_mod, .sem_mods = &sem_mods, .sem_shl = &sem_shl, .sem_shr = &sem_shr,
      .sem_shrs = &sem_shrs, .sem_and = &sem_and, .sem_or = &sem_or, .sem_xor = &sem_xor, .sem_sx = &sem_sx, .sem_zx =
          &sem_zx};

  unboxed_sem_varl_callbacks_t sem_varl_callbacks = {.sem_varl_ = &sem_varl};

  unboxed_sem_varls_callbacks_t sem_varls_callbacks = {.sem_varls_next = &sem_varls_next, .sem_varls_init =
      &sem_varls_init};

  unboxed_sem_flop_callbacks_t sem_flop_callbacks = {.sem_flop_ = &sem_flop};

  unboxed_sem_stmt_callbacks_t sem_stmt_callbacks = {.sem_assign = &sem_assign, .sem_load = &sem_load, .sem_store =
      &sem_store, .sem_ite = &sem_ite, .sem_while = &sem_while, .sem_cbranch = &sem_cbranch, .sem_branch = &sem_branch,
      .sem_flop = &sem_flop_stmt, .sem_prim = &sem_prim, .sem_throw = &sem_throw};

  unboxed_branch_hint_callbacks_t branch_hint_callbacks = {.branch_hint_ = &branch_hint};

//	unboxed_sem_stmts_list_callbacks_t sem_stmts_list_callbacks = {
//			.list_init = &list_init,
//			.list_next = &list_next
//	};

  unboxed_sem_stmts_callbacks_t sem_stmts_callbacks = {.sem_stmts_next = &sem_stmts_next, .sem_stmts_init =
      &sem_stmts_init};

  unboxed_callbacks_t callbacks = {.sem_id = &sem_id_callbacks, .sem_address = &sem_address_callbacks, .sem_var =
      &sem_var_callbacks, .sem_linear = &sem_linear_callbacks, .sem_sexpr = &sem_sexpr_callbacks, .sem_expr_cmp =
      &sem_expr_cmp_callbacks, .sem_expr = &sem_expr_callbacks, .sem_varl = &sem_varl_callbacks, .sem_varls =
      &sem_varls_callbacks, .sem_flop = &sem_flop_callbacks, .sem_stmt = &sem_stmt_callbacks, .branch_hint =
      &branch_hint_callbacks, .sem_exception = &sem_exception_callbacks, .sem_stmts = &sem_stmts_callbacks};

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

