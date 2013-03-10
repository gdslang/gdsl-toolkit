package rnati;

import rreil.IAddress;
import rreil.IBranchHint;
import rreil.IRReilBuilder;
import rreil.IRReilCollection;
import rreil.IVariable;
import rreil.id.IId;
import rreil.linear.ILinearExpression;
import rreil.operation.IOperation;
import rreil.statement.IStatement;

public class NativeInterface {
	private IRReilBuilder builder;

	public NativeInterface(IRReilBuilder builder) {
		System.loadLibrary("jgdrr");

		this.builder = builder;
	}

	public IRReilCollection decodeAndTranslate(byte[] bytes) {
		return (IRReilCollection)decodeAndTranslateNative(bytes);
	}

	/*
	 * sem_id
	 */

	private Object virt_eq() {
		return builder.virt_eq();
	}

	private Object virt_neq() {
		return builder.virt_neq();
	}

	private Object virt_les() {
		return builder.virt_les();
	}

	private Object virt_leu() {
		return builder.virt_leu();
	}

	private Object virt_lts() {
		return builder.virt_lts();
	}

	private Object virt_ltu() {
		return builder.virt_ltu();
	}

	private Object virt_t(Object t) {
		return builder.virt_t((Long) t);
	}
	
	private Object sem_sp() {
		return builder.sem_sp();
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
	 * sem_op
	 */

	private Object sem_lin(Object size, Object opnd1) {
		return builder.sem_lin((Long) size, (ILinearExpression) opnd1);
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

	private Object sem_arb(Object size) {
		return builder.sem_arb((Long) size);
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
	 * sem_stmt
	 */

	private Object sem_assign(Object lhs, Object rhs) {
		return builder.sem_assign((IVariable) lhs, (IOperation) rhs);
	}

	private Object sem_load(Object lhs, Object size, Object address) {
		return builder.sem_load((IVariable) lhs, (Long) size,
				(IAddress) address);
	}

	private Object sem_store(Object lhs, Object rhs) {
		return builder.sem_store((IAddress) lhs, (IOperation) rhs);
	}

	private Object sem_ite(Object cond, Object then_branch, Object else_branch) {
		return builder.sem_ite((ILinearExpression) cond,
				(IRReilCollection) then_branch, (IRReilCollection) else_branch);
	}

	private Object sem_while(Object cond, Object body) {
		return builder.sem_while((ILinearExpression) cond,
				(IRReilCollection) body);
	}

	private Object sem_cbranch(Object cond, Object target_true,
			Object target_false) {
		return builder.sem_cbranch((ILinearExpression) cond,
				(IAddress) target_true, (IAddress) target_false);
	}

	private Object sem_branch(Object branch_hint, Object target) {
		return builder.sem_branch((IBranchHint) branch_hint, (IAddress) target);
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
}
