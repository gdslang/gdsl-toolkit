package rreil;

import rreil.expression.ICompare;
import rreil.expression.IExpression;
import rreil.id.IId;
import rreil.linear.ILinearExpression;
import rreil.sexpression.ISimpleExpression;
import rreil.statement.IStatement;

public interface IRReilBuilder {
	/*
	 * sem_id
	 */

	IId shared_floating_flags();
	
//	IId virt_eq();
//
//	IId virt_neq();

	IId virt_les();

	IId virt_leu();

	IId virt_lts();

//	IId virt_ltu();

	IId virt_t(long t);

	IId sem_ip();

	IId sem_flags();

	IId sem_mxcsr();

	IId sem_ax();

	IId sem_bx();

	IId sem_cx();

	IId sem_dx();

	IId sem_si();

	IId sem_di();

	IId sem_sp();

	IId sem_bp();

	IId sem_r8();

	IId sem_r9();

	IId sem_r10();

	IId sem_r11();

	IId sem_r12();

	IId sem_r13();

	IId sem_r14();

	IId sem_r15();

	IId sem_cs();

	IId sem_ds();

	IId sem_ss();

	IId sem_es();

	IId sem_fs();

	IId sem_gs();

	IId sem_st0();

	IId sem_st1();

	IId sem_st2();

	IId sem_st3();

	IId sem_st4();

	IId sem_st5();

	IId sem_st6();

	IId sem_st7();

	IId sem_mm0();

	IId sem_mm1();

	IId sem_mm2();

	IId sem_mm3();

	IId sem_mm4();

	IId sem_mm5();

	IId sem_mm6();

	IId sem_mm7();

	IId sem_xmm0();

	IId sem_xmm1();

	IId sem_xmm2();

	IId sem_xmm3();

	IId sem_xmm4();

	IId sem_xmm5();

	IId sem_xmm6();

	IId sem_xmm7();

	IId sem_xmm8();

	IId sem_xmm9();

	IId sem_xmm10();

	IId sem_xmm11();

	IId sem_xmm12();

	IId sem_xmm13();

	IId sem_xmm14();

	IId sem_xmm15();
	
	IId id_arch(long id);

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
	 * sem_sexpr
	 */
	
	ISimpleExpression sem_sexpr_lin(ILinearExpression _this);
	
	ISimpleExpression sem_sexpr_cmp(ICompare _this);
	
	/*
	 * sem_op_cmp
	 */
	
	ICompare sem_cmpeq(long size, ILinearExpression opnd1,
			ILinearExpression opnd2);

	ICompare sem_cmpneq(long size, ILinearExpression opnd1,
			ILinearExpression opnd2);

	ICompare sem_cmples(long size, ILinearExpression opnd1,
			ILinearExpression opnd2);

	ICompare sem_cmpleu(long size, ILinearExpression opnd1,
			ILinearExpression opnd2);

	ICompare sem_cmplts(long size, ILinearExpression opnd1,
			ILinearExpression opnd2);

	ICompare sem_cmpltu(long size, ILinearExpression opnd1,
			ILinearExpression opnd2);

	/*
	 * sem_expr
	 */

	IExpression sem_sexpr(long size, ISimpleExpression opnd1);

	IExpression sem_mul(long size, ILinearExpression opnd1,
			ILinearExpression opnd2);

	IExpression sem_div(long size, ILinearExpression opnd1,
			ILinearExpression opnd2);

	IExpression sem_divs(long size, ILinearExpression opnd1,
			ILinearExpression opnd2);

	IExpression sem_mod(long size, ILinearExpression opnd1,
			ILinearExpression opnd2);

	IExpression sem_shl(long size, ILinearExpression opnd1,
			ILinearExpression opnd2);

	IExpression sem_shr(long size, ILinearExpression opnd1,
			ILinearExpression opnd2);

	IExpression sem_shrs(long size, ILinearExpression opnd1,
			ILinearExpression opnd2);

	IExpression sem_and(long size, ILinearExpression opnd1,
			ILinearExpression opnd2);

	IExpression sem_or(long size, ILinearExpression opnd1,
			ILinearExpression opnd2);

	IExpression sem_xor(long size, ILinearExpression opnd1,
			ILinearExpression opnd2);

	IExpression sem_sx(long size, long fromsize, ILinearExpression opnd1);

	IExpression sem_zx(long size, long fromsize, ILinearExpression opnd1);
	
	IExpression sem_arb(long size);
	
	/*
	 * sem_varl
	 */
	
	ILimitedVariable sem_varl(IId id, long offset, long size);
	
	/*
	 * sem_varls
	 */
	
	IRReilCollection<ILimitedVariable> sem_varls_next(ILimitedVariable next, IRReilCollection<ILimitedVariable> list);

	IRReilCollection<ILimitedVariable> sem_varls_init();
	
	/*
	 * sem_flop
	 */
	
	IFlop sem_flop_fadd();
	
	IFlop sem_flop_fsub();
	
	IFlop sem_flop_fmul();
	
	/*
	 * sem_stmt
	 */

	IStatement sem_assign(IVariable lhs, IExpression rhs);

	IStatement sem_load(IVariable lhs, long size, IAddress address);

	IStatement sem_store(IAddress address, IExpression rhs);

	IStatement sem_ite(ISimpleExpression cond, IRReilCollection<IStatement> then_branch,
			IRReilCollection<IStatement> else_branch);

	IStatement sem_while(ISimpleExpression cond, IRReilCollection<IStatement> body);

	IStatement sem_cbranch(ISimpleExpression cond, IAddress target_true,
			IAddress target_false);

	IStatement sem_branch(IBranchHint branch_hint, IAddress target);
	
	IStatement sem_flop_stmt(IFlop op, IVariable flags, ILimitedVariable lhs, IRReilCollection<ILimitedVariable> rhs);
	
	IStatement sem_prim(String op, IRReilCollection<ILimitedVariable> lhs, IRReilCollection<ILimitedVariable> rhs);
	
	/*
	 * sem_branch_hint
	 */

	IBranchHint hint_jump();

	IBranchHint hint_call();

	IBranchHint hint_ret();

	/*
	 * sem_stmts
	 */

	IRReilCollection<IStatement> list_next(IStatement next, IRReilCollection<IStatement> list);

	IRReilCollection<IStatement> list_init();
}
