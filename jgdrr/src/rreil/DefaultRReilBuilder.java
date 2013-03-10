package rreil;

import rreil.id.IId;
import rreil.id.Id;
import rreil.id.VirtualEqualsId;
import rreil.id.VirtualEqualsNotId;
import rreil.id.VirtualLessOrEqualSignedId;
import rreil.id.VirtualLessOrEqualUnsignedId;
import rreil.id.VirtualLessSignedId;
import rreil.id.VirtualLessUnsignedId;
import rreil.id.VirtualTemporaryId;
import rreil.linear.ILinearExpression;
import rreil.linear.LinearAdditionExpression;
import rreil.linear.LinearExpression;
import rreil.linear.LinearImmediateExpression;
import rreil.linear.LinearScaleExpression;
import rreil.linear.LinearSubtractionExpression;
import rreil.linear.LinearVariableExpression;
import rreil.operation.AndOperation;
import rreil.operation.ArbitraryOperation;
import rreil.operation.CompareEqualOperation;
import rreil.operation.CompareLessOrEqualSignedOperation;
import rreil.operation.CompareLessOrEqualUnsignedOperation;
import rreil.operation.CompareLessSignedOperation;
import rreil.operation.CompareLessUnsignedOperation;
import rreil.operation.CompareNotEqualOperation;
import rreil.operation.DivisionOperation;
import rreil.operation.IOperation;
import rreil.operation.LinearOperation;
import rreil.operation.ModuloOperation;
import rreil.operation.MultiplicationOperation;
import rreil.operation.Operation;
import rreil.operation.OrOperation;
import rreil.operation.ShiftLeftOperation;
import rreil.operation.ShiftRightOperation;
import rreil.operation.ShiftRightSignedOperation;
import rreil.operation.SignExtendOperation;
import rreil.operation.SignedDivisionOperation;
import rreil.operation.XorOperation;
import rreil.operation.ZeroExtendOperation;
import rreil.statement.AssignStatement;
import rreil.statement.BranchStatement;
import rreil.statement.ConditionalBranchStatement;
import rreil.statement.IStatement;
import rreil.statement.IfThenElseStatement;
import rreil.statement.LoadStatement;
import rreil.statement.Statement;
import rreil.statement.StoreStatement;
import rreil.statement.WhileStatement;

public class DefaultRReilBuilder implements IRReilBuilder {

	/*
	 * sem_id
	 */

	@Override
	public Id virt_eq() {
		return new VirtualEqualsId();
	}

	@Override
	public Id virt_neq() {
		return new VirtualEqualsNotId();
	}

	@Override
	public Id virt_les() {
		return new VirtualLessOrEqualSignedId();
	}

	@Override
	public Id virt_leu() {
		return new VirtualLessOrEqualUnsignedId();
	}

	@Override
	public Id virt_lts() {
		return new VirtualLessSignedId();
	}

	@Override
	public Id virt_ltu() {
		return new VirtualLessUnsignedId();
	}

	@Override
	public Id virt_t(long t) {
		return new VirtualTemporaryId(t);
	}

	/*
	 * sem_address
	 */

	@Override
	public Address sem_address(long size, ILinearExpression address) {
		return new Address(size, (LinearExpression) address);
	}

	/*
	 * sem_var
	 */

	@Override
	public Variable sem_var(IId id, long offset) {
		return new Variable((Id) id, offset);
	}

	/*
	 * sem_linear
	 */

	@Override
	public LinearExpression sem_lin_var(IVariable _this) {
		return new LinearVariableExpression((Variable) _this);
	}

	@Override
	public LinearExpression sem_lin_imm(long imm) {
		return new LinearImmediateExpression(imm);
	}

	@Override
	public LinearExpression sem_lin_add(ILinearExpression opnd1,
			ILinearExpression opnd2) {
		return new LinearAdditionExpression((LinearExpression) opnd1,
				(LinearExpression) opnd2);
	}

	@Override
	public LinearExpression sem_lin_sub(ILinearExpression opnd1,
			ILinearExpression opnd2) {
		return new LinearSubtractionExpression((LinearExpression) opnd1,
				(LinearExpression) opnd2);
	}

	@Override
	public LinearExpression sem_lin_scale(long imm, ILinearExpression opnd) {
		return new LinearScaleExpression(imm, (LinearExpression) opnd);
	}

	/*
	 * sem_op
	 */

	@Override
	public Operation sem_lin(long size, ILinearExpression opnd1) {
		return new LinearOperation(size, (LinearExpression) opnd1);
	}

	@Override
	public Operation sem_mul(long size, ILinearExpression opnd1,
			ILinearExpression opnd2) {
		return new MultiplicationOperation(size, (LinearExpression) opnd1,
				(LinearExpression) opnd2);
	}

	@Override
	public Operation sem_div(long size, ILinearExpression opnd1,
			ILinearExpression opnd2) {
		return new DivisionOperation(size, (LinearExpression) opnd1,
				(LinearExpression) opnd2);
	}

	@Override
	public Operation sem_divs(long size, ILinearExpression opnd1,
			ILinearExpression opnd2) {
		return new SignedDivisionOperation(size, (LinearExpression) opnd1,
				(LinearExpression) opnd2);
	}

	@Override
	public Operation sem_mod(long size, ILinearExpression opnd1,
			ILinearExpression opnd2) {
		return new ModuloOperation(size, (LinearExpression) opnd1,
				(LinearExpression) opnd2);
	}

	@Override
	public Operation sem_shl(long size, ILinearExpression opnd1,
			ILinearExpression opnd2) {
		return new ShiftLeftOperation(size, (LinearExpression) opnd1,
				(LinearExpression) opnd2);
	}

	@Override
	public Operation sem_shr(long size, ILinearExpression opnd1,
			ILinearExpression opnd2) {
		return new ShiftRightOperation(size, (LinearExpression) opnd1,
				(LinearExpression) opnd2);
	}

	@Override
	public Operation sem_shrs(long size, ILinearExpression opnd1,
			ILinearExpression opnd2) {
		return new ShiftRightSignedOperation(size, (LinearExpression) opnd1,
				(LinearExpression) opnd2);
	}

	@Override
	public Operation sem_and(long size, ILinearExpression opnd1,
			ILinearExpression opnd2) {
		return new AndOperation(size, (LinearExpression) opnd1,
				(LinearExpression) opnd2);
	}

	@Override
	public Operation sem_or(long size, ILinearExpression opnd1,
			ILinearExpression opnd2) {
		return new OrOperation(size, (LinearExpression) opnd1,
				(LinearExpression) opnd2);
	}

	@Override
	public Operation sem_xor(long size, ILinearExpression opnd1,
			ILinearExpression opnd2) {
		return new XorOperation(size, (LinearExpression) opnd1,
				(LinearExpression) opnd2);
	}

	@Override
	public Operation sem_sx(long size, long fromsize, ILinearExpression opnd1) {
		return new SignExtendOperation(size, fromsize, (LinearExpression) opnd1);
	}

	@Override
	public Operation sem_zx(long size, long fromsize, ILinearExpression opnd1) {
		return new ZeroExtendOperation(size, fromsize, (LinearExpression) opnd1);
	}

	@Override
	public Operation sem_cmpeq(long size, ILinearExpression opnd1,
			ILinearExpression opnd2) {
		return new CompareEqualOperation(size, (LinearExpression) opnd1,
				(LinearExpression) opnd2);
	}

	@Override
	public Operation sem_cmpneq(long size, ILinearExpression opnd1,
			ILinearExpression opnd2) {
		return new CompareNotEqualOperation(size, (LinearExpression) opnd1,
				(LinearExpression) opnd2);
	}

	@Override
	public Operation sem_cmples(long size, ILinearExpression opnd1,
			ILinearExpression opnd2) {
		return new CompareLessOrEqualSignedOperation(size,
				(LinearExpression) opnd1, (LinearExpression) opnd2);
	}

	@Override
	public Operation sem_cmpleu(long size, ILinearExpression opnd1,
			ILinearExpression opnd2) {
		return new CompareLessOrEqualUnsignedOperation(size,
				(LinearExpression) opnd1, (LinearExpression) opnd2);
	}

	@Override
	public Operation sem_cmplts(long size, ILinearExpression opnd1,
			ILinearExpression opnd2) {
		return new CompareLessSignedOperation(size, (LinearExpression) opnd1,
				(LinearExpression) opnd2);
	}

	@Override
	public Operation sem_cmpltu(long size, ILinearExpression opnd1,
			ILinearExpression opnd2) {
		return new CompareLessUnsignedOperation(size, (LinearExpression) opnd1,
				(LinearExpression) opnd2);
	}

	@Override
	public Operation sem_arb(long size) {
		return new ArbitraryOperation(size);
	}

	/*
	 * sem_branch_hint
	 */

	@Override
	public BranchHint hint_jump() {
		return BranchHint.JUMP;
	}

	@Override
	public BranchHint hint_call() {
		return BranchHint.CALL;
	}

	@Override
	public BranchHint hint_ret() {
		return BranchHint.RET;
	}

	/*
	 * sem_stmt
	 */

	@Override
	public Statement sem_assign(IVariable lhs, IOperation rhs) {
		return new AssignStatement((Variable) lhs, (Operation) rhs);
	}

	@Override
	public Statement sem_load(IVariable lhs, long size, IAddress address) {
		return new LoadStatement((Variable) lhs, size, (Address) address);
	}

	@Override
	public Statement sem_store(IAddress lhs, IOperation rhs) {
		return new StoreStatement((Address) lhs, (Operation) rhs);
	}

	@Override
	public Statement sem_ite(ILinearExpression cond,
			IRReilCollection then_branch, IRReilCollection else_branch) {
		return new IfThenElseStatement((LinearExpression) cond,
				(DefaultRReilCollection) then_branch,
				(DefaultRReilCollection) else_branch);
	}

	@Override
	public Statement sem_while(ILinearExpression cond, IRReilCollection body) {
		return new WhileStatement((LinearExpression) cond,
				(DefaultRReilCollection) body);
	}

	@Override
	public Statement sem_cbranch(ILinearExpression cond, IAddress target_true,
			IAddress target_false) {
		return new ConditionalBranchStatement((LinearExpression) cond,
				(Address) target_true, (Address) target_false);
	}

	@Override
	public Statement sem_branch(IBranchHint branch_hint, IAddress target) {
		return new BranchStatement((BranchHint) branch_hint, (Address) target);
	}

	/*
	 * sem_stmts
	 */

	@Override
	public IRReilCollection list_next(IStatement next, IRReilCollection list) {
		list.add(next);
		return list;
	}

	@Override
	public IRReilCollection list_init() {
		return new DefaultRReilCollection();
	}

}
