package rnati;

import rreil.IAddress;
import rreil.IBranchHint;
import rreil.IFlop;
import rreil.ILimitedVariable;
import rreil.IRReilBuilder;
import rreil.IRReilCollection;
import rreil.IVariable;
import rreil.expression.ICompare;
import rreil.expression.IExpression;
import rreil.id.IId;
import rreil.linear.ILinearExpression;
import rreil.sexpression.ISimpleExpression;
import rreil.statement.IStatement;

public class NativeInterface {
	private IRReilBuilder builder;

	private boolean backendSet = false;

	public NativeInterface(IRReilBuilder builder) {
		System.loadLibrary("jrreil");

		this.builder = builder;
	}

	@SuppressWarnings("unchecked")
	public IRReilCollection<IStatement> decodeAndTranslate(byte[] bytes) {
		if (!backendSet)
			throw new RuntimeException("Backend not set");
		return (IRReilCollection<IStatement>) decodeAndTranslateNative(bytes);
	}

	public String[] getBackends() {
		return getBackendsNative();
	}

	public void useBackend(String backend) {
		if (backendSet)
			throw new RuntimeException("Backend already set");
		useBackendNative(backend);
		backendSet = true;
	}

	public void closeBackend() {
		if (!backendSet)
			throw new RuntimeException("Backend not set");
		closeBackendNative();
		backendSet = false;
	}

	/*
	 * sem_id
	 */
	private Object shared_floating_flags() {
		return builder.shared_floating_flags();
	}

	// private Object virt_eq() {
	// return builder.virt_eq();
	// }
	//
	// private Object virt_neq() {
	// return builder.virt_neq();
	// }

	private Object virt_les() {
		return builder.virt_les();
	}

	private Object virt_leu() {
		return builder.virt_leu();
	}

	private Object virt_lts() {
		return builder.virt_lts();
	}

	// private Object virt_ltu() {
	// return builder.virt_ltu();
	// }

	private Object virt_t(Object t) {
		return builder.virt_t((Long) t);
	}

	private Object sem_ip() {
		return builder.sem_ip();
	}

	private Object sem_flags() {
		return builder.sem_flags();
	}

	private Object sem_mxcsr() {
		return builder.sem_mxcsr();
	}

	private Object sem_ax() {
		return builder.sem_ax();
	}

	private Object sem_bx() {
		return builder.sem_bx();
	}

	private Object sem_cx() {
		return builder.sem_cx();
	}

	private Object sem_dx() {
		return builder.sem_dx();
	}

	private Object sem_si() {
		return builder.sem_si();
	}

	private Object sem_di() {
		return builder.sem_di();
	}

	private Object sem_sp() {
		return builder.sem_sp();
	}

	private Object sem_bp() {
		return builder.sem_bp();
	}

	private Object sem_r8() {
		return builder.sem_r8();
	}

	private Object sem_r9() {
		return builder.sem_r9();
	}

	private Object sem_r10() {
		return builder.sem_r10();
	}

	private Object sem_r11() {
		return builder.sem_r11();
	}

	private Object sem_r12() {
		return builder.sem_r12();
	}

	private Object sem_r13() {
		return builder.sem_r13();
	}

	private Object sem_r14() {
		return builder.sem_r14();
	}

	private Object sem_r15() {
		return builder.sem_r15();
	}

	private Object sem_cs() {
		return builder.sem_cs();
	}

	private Object sem_ds() {
		return builder.sem_ds();
	}

	private Object sem_ss() {
		return builder.sem_ss();
	}

	private Object sem_es() {
		return builder.sem_es();
	}

	private Object sem_fs() {
		return builder.sem_fs();
	}

	private Object sem_gs() {
		return builder.sem_gs();
	}

	private Object sem_st0() {
		return builder.sem_st0();
	}

	private Object sem_st1() {
		return builder.sem_st1();
	}

	private Object sem_st2() {
		return builder.sem_st2();
	}

	private Object sem_st3() {
		return builder.sem_st3();
	}

	private Object sem_st4() {
		return builder.sem_st4();
	}

	private Object sem_st5() {
		return builder.sem_st5();
	}

	private Object sem_st6() {
		return builder.sem_st6();
	}

	private Object sem_st7() {
		return builder.sem_st7();
	}

	private Object sem_mm0() {
		return builder.sem_mm0();
	}

	private Object sem_mm1() {
		return builder.sem_mm1();
	}

	private Object sem_mm2() {
		return builder.sem_mm2();
	}

	private Object sem_mm3() {
		return builder.sem_mm3();
	}

	private Object sem_mm4() {
		return builder.sem_mm4();
	}

	private Object sem_mm5() {
		return builder.sem_mm5();
	}

	private Object sem_mm6() {
		return builder.sem_mm6();
	}

	private Object sem_mm7() {
		return builder.sem_mm7();
	}

	private Object sem_xmm0() {
		return builder.sem_xmm0();
	}

	private Object sem_xmm1() {
		return builder.sem_xmm1();
	}

	private Object sem_xmm2() {
		return builder.sem_xmm2();
	}

	private Object sem_xmm3() {
		return builder.sem_xmm3();
	}

	private Object sem_xmm4() {
		return builder.sem_xmm4();
	}

	private Object sem_xmm5() {
		return builder.sem_xmm5();
	}

	private Object sem_xmm6() {
		return builder.sem_xmm6();
	}

	private Object sem_xmm7() {
		return builder.sem_xmm7();
	}

	private Object sem_xmm8() {
		return builder.sem_xmm8();
	}

	private Object sem_xmm9() {
		return builder.sem_xmm9();
	}

	private Object sem_xmm10() {
		return builder.sem_xmm10();
	}

	private Object sem_xmm11() {
		return builder.sem_xmm11();
	}

	private Object sem_xmm12() {
		return builder.sem_xmm12();
	}

	private Object sem_xmm13() {
		return builder.sem_xmm13();
	}

	private Object sem_xmm14() {
		return builder.sem_xmm14();
	}

	private Object sem_xmm16() {
		return builder.sem_xmm15();
	}

	private Object id_arch(Object con) {
		return builder.id_arch((Long) con);
	}

	/*
	 * sem_address
	 */

	private Object sem_address(Object size, Object address) {
		return builder.sem_address((Long) size, (ILinearExpression) address);
	}

	/*
	 * sem_var
	 */

	private Object sem_var(Object id, Object offset) {
		return builder.sem_var((IId) id, (Long) offset);
	}

	/*
	 * sem_linear
	 */

	private Object sem_lin_var(Object _this) {
		return builder.sem_lin_var((IVariable) _this);
	}

	private Object sem_lin_imm(Object imm) {
		return builder.sem_lin_imm((Long) imm);
	}

	private Object sem_lin_add(Object opnd1, Object opnd2) {
		return builder.sem_lin_add((ILinearExpression) opnd1,
				(ILinearExpression) opnd2);
	}

	private Object sem_lin_sub(Object opnd1, Object opnd2) {
		return builder.sem_lin_sub((ILinearExpression) opnd1,
				(ILinearExpression) opnd2);
	}

	private Object sem_lin_scale(Object imm, Object opnd) {
		return builder.sem_lin_scale((Long) imm, (ILinearExpression) opnd);
	}

	/*
	 * sem_sexpr
	 */

	private Object sem_sexpr_lin(Object _this) {
		return builder.sem_sexpr_lin((ILinearExpression) _this);
	}

	private Object sem_sexpr_cmp(Object _this) {
		return builder.sem_sexpr_cmp((ICompare) _this);
	}

	/*
	 * sem_op_cmp
	 */

	private Object sem_cmpeq(Object size, Object opnd1, Object opnd2) {
		return builder.sem_cmpeq((Long) size, (ILinearExpression) opnd1,
				(ILinearExpression) opnd2);
	}

	private Object sem_cmpneq(Object size, Object opnd1, Object opnd2) {
		return builder.sem_cmpneq((Long) size, (ILinearExpression) opnd1,
				(ILinearExpression) opnd2);
	}

	private Object sem_cmples(Object size, Object opnd1, Object opnd2) {
		return builder.sem_cmples((Long) size, (ILinearExpression) opnd1,
				(ILinearExpression) opnd2);
	}

	private Object sem_cmpleu(Object size, Object opnd1, Object opnd2) {
		return builder.sem_cmpleu((Long) size, (ILinearExpression) opnd1,
				(ILinearExpression) opnd2);
	}

	private Object sem_cmplts(Object size, Object opnd1, Object opnd2) {
		return builder.sem_cmplts((Long) size, (ILinearExpression) opnd1,
				(ILinearExpression) opnd2);
	}

	private Object sem_cmpltu(Object size, Object opnd1, Object opnd2) {
		return builder.sem_cmpltu((Long) size, (ILinearExpression) opnd1,
				(ILinearExpression) opnd2);
	}

	/*
	 * sem_expr
	 */

	private Object sem_sexpr(Object size, Object opnd1) {
		return builder.sem_sexpr((Long) size, (ISimpleExpression) opnd1);
	}

	private Object sem_mul(Object size, Object opnd1, Object opnd2) {
		return builder.sem_mul((Long) size, (ILinearExpression) opnd1,
				(ILinearExpression) opnd2);
	}

	private Object sem_div(Object size, Object opnd1, Object opnd2) {
		return builder.sem_div((Long) size, (ILinearExpression) opnd1,
				(ILinearExpression) opnd2);
	}

	private Object sem_divs(Object size, Object opnd1, Object opnd2) {
		return builder.sem_divs((Long) size, (ILinearExpression) opnd1,
				(ILinearExpression) opnd2);
	}

	private Object sem_mod(Object size, Object opnd1, Object opnd2) {
		return builder.sem_mod((Long) size, (ILinearExpression) opnd1,
				(ILinearExpression) opnd2);
	}

	private Object sem_shl(Object size, Object opnd1, Object opnd2) {
		return builder.sem_shl((Long) size, (ILinearExpression) opnd1,
				(ILinearExpression) opnd2);
	}

	private Object sem_shr(Object size, Object opnd1, Object opnd2) {
		return builder.sem_shr((Long) size, (ILinearExpression) opnd1,
				(ILinearExpression) opnd2);
	}

	private Object sem_shrs(Object size, Object opnd1, Object opnd2) {
		return builder.sem_shrs((Long) size, (ILinearExpression) opnd1,
				(ILinearExpression) opnd2);
	}

	private Object sem_and(Object size, Object opnd1, Object opnd2) {
		return builder.sem_and((Long) size, (ILinearExpression) opnd1,
				(ILinearExpression) opnd2);
	}

	private Object sem_or(Object size, Object opnd1, Object opnd2) {
		return builder.sem_or((Long) size, (ILinearExpression) opnd1,
				(ILinearExpression) opnd2);
	}

	private Object sem_xor(Object size, Object opnd1, Object opnd2) {
		return builder.sem_xor((Long) size, (ILinearExpression) opnd1,
				(ILinearExpression) opnd2);
	}

	private Object sem_sx(Object size, Object fromsize, Object opnd1) {
		return builder.sem_sx((Long) size, (Long) fromsize,
				(ILinearExpression) opnd1);
	}

	private Object sem_zx(Object size, Object fromsize, Object opnd1) {
		return builder.sem_zx((Long) size, (Long) fromsize,
				(ILinearExpression) opnd1);
	}

	private Object sem_arb(Object size) {
		return builder.sem_arb((Long) size);
	}

	/*
	 * sem_varl
	 */

	private Object sem_varl(Object id, Object offset, Object size) {
		return builder.sem_varl((IId) id, (Long) offset, (Long) size);
	}

	/*
	 * sem_varls
	 */

	@SuppressWarnings("unchecked")
	private Object sem_varls_next(Object next, Object list) {
		return builder.sem_varls_next((ILimitedVariable) next,
				(IRReilCollection<ILimitedVariable>) list);
	}

	private Object sem_varls_init() {
		return builder.sem_varls_init();
	}

	/*
	 * sem_flop
	 */

	private Object sem_flop_fadd() {
		return builder.sem_flop_fadd();
	}

	private Object sem_flop_fsub() {
		return builder.sem_flop_fsub();
	}

	private Object sem_flop_fmul() {
		return builder.sem_flop_fmul();
	}

	/*
	 * sem_stmt
	 */

	private Object sem_assign(Object lhs, Object rhs) {
		return builder.sem_assign((IVariable) lhs, (IExpression) rhs);
	}

	private Object sem_load(Object lhs, Object size, Object address) {
		return builder.sem_load((IVariable) lhs, (Long) size,
				(IAddress) address);
	}

	private Object sem_store(Object address, Object rhs) {
		return builder.sem_store((IAddress) address, (IExpression) rhs);
	}

	@SuppressWarnings("unchecked")
	private Object sem_ite(Object cond, Object then_branch, Object else_branch) {
		return builder.sem_ite((ISimpleExpression) cond,
				(IRReilCollection<IStatement>) then_branch, (IRReilCollection<IStatement>) else_branch);
	}

	@SuppressWarnings("unchecked")
	private Object sem_while(Object cond, Object body) {
		return builder.sem_while((ISimpleExpression) cond,
				(IRReilCollection<IStatement>) body);
	}

	private Object sem_cbranch(Object cond, Object target_true,
			Object target_false) {
		return builder.sem_cbranch((ISimpleExpression) cond,
				(IAddress) target_true, (IAddress) target_false);
	}

	private Object sem_branch(Object branch_hint, Object target) {
		return builder.sem_branch((IBranchHint) branch_hint, (IAddress) target);
	}

	@SuppressWarnings("unchecked")
	private Object sem_flop_stmt(Object op, Object flags, Object lhs,
			Object rhs) {
		return builder.sem_flop_stmt((IFlop) op, (IVariable) flags,
				(ILimitedVariable) lhs,
				(IRReilCollection<ILimitedVariable>) rhs);
	}
	
	@SuppressWarnings("unchecked")
	private Object sem_prim(String op, Object lhs, Object rhs) {
		return builder.sem_prim(op,
				(IRReilCollection<ILimitedVariable>) lhs,
				(IRReilCollection<ILimitedVariable>) rhs);
	}

	/*
	 * sem_branch_hint
	 */

	private Object hint_jump() {
		return builder.hint_jump();
	}

	private Object hint_call() {
		return builder.hint_call();
	}

	private Object hint_ret() {
		return builder.hint_ret();
	}

	/*
	 * sem_stmts
	 */

	private Object list_next(Object next, Object list) {
		return builder.list_next((IStatement) next, (IRReilCollection) list);
	}

	private Object list_init() {
		return builder.list_init();
	}

	private native Object decodeAndTranslateNative(byte[] bytes);

	private native String[] getBackendsNative();

	private native void useBackendNative(String backend);

	private native void closeBackendNative();
}
