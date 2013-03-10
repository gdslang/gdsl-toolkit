package rreil;

import rreil.id.IId;
import rreil.linear.ILinearExpression;
import rreil.operation.IOperation;
import rreil.statement.IStatement;

public interface IRReilBuilder {
	/*
	 * sem_id
	 */

	IId virt_eq();

	IId virt_neq();

	IId virt_les();

	IId virt_leu();

	IId virt_lts();

	IId virt_ltu();

	IId virt_t(long t);
	
	IId sem_sp();

	/*
	 * sem_address
	 */

	IAddress sem_address(long size, ILinearExpression address);

	/*
	 * sem_var
	 */

	IVariable sem_var(IId id, long offset);

	/*
	 * sem_linear
	 */

	ILinearExpression sem_lin_var(IVariable _this);

	ILinearExpression sem_lin_imm(long imm);

	ILinearExpression sem_lin_add(ILinearExpression opnd1,
			ILinearExpression opnd2);

	ILinearExpression sem_lin_sub(ILinearExpression opnd1,
			ILinearExpression opnd2);

	ILinearExpression sem_lin_scale(long imm, ILinearExpression opnd);

	/*
	 * sem_op
	 */

	IOperation sem_lin(long size, ILinearExpression opnd1);

	IOperation sem_mul(long size, ILinearExpression opnd1,
			ILinearExpression opnd2);

	IOperation sem_div(long size, ILinearExpression opnd1,
			ILinearExpression opnd2);

	IOperation sem_divs(long size, ILinearExpression opnd1,
			ILinearExpression opnd2);

	IOperation sem_mod(long size, ILinearExpression opnd1,
			ILinearExpression opnd2);

	IOperation sem_shl(long size, ILinearExpression opnd1,
			ILinearExpression opnd2);

	IOperation sem_shr(long size, ILinearExpression opnd1,
			ILinearExpression opnd2);

	IOperation sem_shrs(long size, ILinearExpression opnd1,
			ILinearExpression opnd2);

	IOperation sem_and(long size, ILinearExpression opnd1,
			ILinearExpression opnd2);

	IOperation sem_or(long size, ILinearExpression opnd1,
			ILinearExpression opnd2);

	IOperation sem_xor(long size, ILinearExpression opnd1,
			ILinearExpression opnd2);

	IOperation sem_sx(long size, long fromsize, ILinearExpression opnd1);

	IOperation sem_zx(long size, long fromsize, ILinearExpression opnd1);

	IOperation sem_cmpeq(long size, ILinearExpression opnd1,
			ILinearExpression opnd2);

	IOperation sem_cmpneq(long size, ILinearExpression opnd1,
			ILinearExpression opnd2);

	IOperation sem_cmples(long size, ILinearExpression opnd1,
			ILinearExpression opnd2);

	IOperation sem_cmpleu(long size, ILinearExpression opnd1,
			ILinearExpression opnd2);

	IOperation sem_cmplts(long size, ILinearExpression opnd1,
			ILinearExpression opnd2);

	IOperation sem_cmpltu(long size, ILinearExpression opnd1,
			ILinearExpression opnd2);

	IOperation sem_arb(long size);

	/*
	 * sem_branch_hint
	 */

	IBranchHint hint_jump();

	IBranchHint hint_call();

	IBranchHint hint_ret();

	/*
	 * sem_stmt
	 */

	IStatement sem_assign(IVariable lhs, IOperation rhs);

	IStatement sem_load(IVariable lhs, long size, IAddress address);

	IStatement sem_store(IAddress lhs, IOperation rhs);

	IStatement sem_ite(ILinearExpression cond, IRReilCollection then_branch,
			IRReilCollection else_branch);

	IStatement sem_while(ILinearExpression cond, IRReilCollection body);

	IStatement sem_cbranch(ILinearExpression cond, IAddress target_true,
			IAddress target_false);

	IStatement sem_branch(IBranchHint branch_hint, IAddress target);
	
	/*
	 * sem_stmts
	 */
	
	IRReilCollection list_next(IStatement next, IRReilCollection list);
	
	IRReilCollection list_init();
}
