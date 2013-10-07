package rreil;

import rreil.expression.And;
import rreil.expression.CompareEqual;
import rreil.expression.CompareLessOrEqualSigned;
import rreil.expression.CompareLessOrEqualUnsigned;
import rreil.expression.CompareLessSigned;
import rreil.expression.CompareLessUnsigned;
import rreil.expression.CompareNotEqual;
import rreil.expression.Compare;
import rreil.expression.Division;
import rreil.expression.ICompare;
import rreil.expression.IExpression;
import rreil.expression.Simple;
import rreil.expression.Modulo;
import rreil.expression.Multiplication;
import rreil.expression.Expression;
import rreil.expression.Or;
import rreil.expression.ShiftLeft;
import rreil.expression.ShiftRight;
import rreil.expression.ShiftRightSigned;
import rreil.expression.SignExtend;
import rreil.expression.SignedDivision;
import rreil.expression.Xor;
import rreil.expression.ZeroExtend;
import rreil.id.FloatingFlags;
import rreil.id.GenericArchRegister;
import rreil.id.IId;
import rreil.id.Id;
import rreil.id.VirtualEqualsId;
import rreil.id.VirtualEqualsNotId;
import rreil.id.VirtualLessOrEqualSignedId;
import rreil.id.VirtualLessOrEqualUnsignedId;
import rreil.id.VirtualLessSignedId;
import rreil.id.VirtualLessUnsignedId;
import rreil.id.VirtualTemporaryId;
import rreil.id.x86.X86Register;
import rreil.id.x86.X86RegisterId;
import rreil.linear.ILinearExpression;
import rreil.linear.LinearAdditionExpression;
import rreil.linear.LinearExpression;
import rreil.linear.LinearImmediateExpression;
import rreil.linear.LinearScaleExpression;
import rreil.linear.LinearSubtractionExpression;
import rreil.linear.LinearVariableExpression;
import rreil.sexpression.Arbitrary;
import rreil.sexpression.ISimpleExpression;
import rreil.sexpression.SimpleCompareExpression;
import rreil.sexpression.SimpleExpression;
import rreil.sexpression.SimpleLinearExpression;
import rreil.statement.AssignStatement;
import rreil.statement.BranchStatement;
import rreil.statement.ConditionalBranchStatement;
import rreil.statement.FlopStatement;
import rreil.statement.IStatement;
import rreil.statement.IfThenElseStatement;
import rreil.statement.LoadStatement;
import rreil.statement.PrimitiveStatement;
import rreil.statement.Statement;
import rreil.statement.StoreStatement;
import rreil.statement.WhileStatement;

public class DefaultRReilBuilder implements IRReilBuilder {

	/*
	 * sem_id
	 */

	@Override
	public IId shared_floating_flags() {
		return new FloatingFlags();
	}

	// @Override
	// public Id virt_eq() {
	// return new VirtualEqualsId();
	// }
	//
	// @Override
	// public Id virt_neq() {
	// return new VirtualEqualsNotId();
	// }

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

	// @Override
	// public Id virt_ltu() {
	// return new VirtualLessUnsignedId();
	// }

	@Override
	public Id virt_t(long t) {
		return new VirtualTemporaryId(t);
	}

	@Override
	public IId sem_ip() {
		return new X86RegisterId(X86Register.IP);
	}

	@Override
	public IId sem_flags() {
		return new X86RegisterId(X86Register.FLAGS);
	}

	@Override
	public IId sem_mxcsr() {
		return new X86RegisterId(X86Register.MXCSR);
	}

	@Override
	public IId sem_ax() {
		return new X86RegisterId(X86Register.AX);
	}

	@Override
	public IId sem_bx() {
		return new X86RegisterId(X86Register.BX);
	}

	@Override
	public IId sem_cx() {
		return new X86RegisterId(X86Register.CX);
	}

	@Override
	public IId sem_dx() {
		return new X86RegisterId(X86Register.DX);
	}

	@Override
	public IId sem_si() {
		return new X86RegisterId(X86Register.SI);
	}

	@Override
	public IId sem_di() {
		return new X86RegisterId(X86Register.DI);
	}

	@Override
	public IId sem_sp() {
		return new X86RegisterId(X86Register.SP);
	}

	@Override
	public IId sem_bp() {
		return new X86RegisterId(X86Register.BP);
	}

	@Override
	public IId sem_r8() {
		return new X86RegisterId(X86Register.R8);
	}

	@Override
	public IId sem_r9() {
		return new X86RegisterId(X86Register.R9);
	}

	@Override
	public IId sem_r10() {
		return new X86RegisterId(X86Register.R10);
	}

	@Override
	public IId sem_r11() {
		return new X86RegisterId(X86Register.R11);
	}

	@Override
	public IId sem_r12() {
		return new X86RegisterId(X86Register.R12);
	}

	@Override
	public IId sem_r13() {
		return new X86RegisterId(X86Register.R13);
	}

	@Override
	public IId sem_r14() {
		return new X86RegisterId(X86Register.R14);
	}

	@Override
	public IId sem_r15() {
		return new X86RegisterId(X86Register.R15);
	}

	@Override
	public IId sem_cs_base() {
		return new X86RegisterId(X86Register.CS_Base);
	}

	@Override
	public IId sem_ds_base() {
		return new X86RegisterId(X86Register.DS_Base);
	}

	@Override
	public IId sem_ss_base() {
		return new X86RegisterId(X86Register.SS_Base);
	}

	@Override
	public IId sem_es_base() {
		return new X86RegisterId(X86Register.ES_Base);
	}

	@Override
	public IId sem_fs_base() {
		return new X86RegisterId(X86Register.FS_Base);
	}

	@Override
	public IId sem_gs_base() {
		return new X86RegisterId(X86Register.GS_Base);
	}

	@Override
	public IId sem_st0() {
		return new X86RegisterId(X86Register.ST0);
	}

	@Override
	public IId sem_st1() {
		return new X86RegisterId(X86Register.ST1);
	}

	@Override
	public IId sem_st2() {
		return new X86RegisterId(X86Register.ST2);
	}

	@Override
	public IId sem_st3() {
		return new X86RegisterId(X86Register.ST3);
	}

	@Override
	public IId sem_st4() {
		return new X86RegisterId(X86Register.ST4);
	}

	@Override
	public IId sem_st5() {
		return new X86RegisterId(X86Register.ST5);
	}

	@Override
	public IId sem_st6() {
		return new X86RegisterId(X86Register.ST6);
	}

	@Override
	public IId sem_st7() {
		return new X86RegisterId(X86Register.ST7);
	}

	@Override
	public IId sem_mm0() {
		return new X86RegisterId(X86Register.MM0);
	}

	@Override
	public IId sem_mm1() {
		return new X86RegisterId(X86Register.MM1);
	}

	@Override
	public IId sem_mm2() {
		return new X86RegisterId(X86Register.MM2);
	}

	@Override
	public IId sem_mm3() {
		return new X86RegisterId(X86Register.MM3);
	}

	@Override
	public IId sem_mm4() {
		return new X86RegisterId(X86Register.MM4);
	}

	@Override
	public IId sem_mm5() {
		return new X86RegisterId(X86Register.MM5);
	}

	@Override
	public IId sem_mm6() {
		return new X86RegisterId(X86Register.MM6);
	}

	@Override
	public IId sem_mm7() {
		return new X86RegisterId(X86Register.MM7);
	}

	@Override
	public IId sem_xmm0() {
		return new X86RegisterId(X86Register.XMM0);
	}

	@Override
	public IId sem_xmm1() {
		return new X86RegisterId(X86Register.XMM1);
	}

	@Override
	public IId sem_xmm2() {
		return new X86RegisterId(X86Register.XMM2);
	}

	@Override
	public IId sem_xmm3() {
		return new X86RegisterId(X86Register.XMM3);
	}

	@Override
	public IId sem_xmm4() {
		return new X86RegisterId(X86Register.XMM4);
	}

	@Override
	public IId sem_xmm5() {
		return new X86RegisterId(X86Register.XMM5);
	}

	@Override
	public IId sem_xmm6() {
		return new X86RegisterId(X86Register.XMM6);
	}

	@Override
	public IId sem_xmm7() {
		return new X86RegisterId(X86Register.XMM7);
	}

	@Override
	public IId sem_xmm8() {
		return new X86RegisterId(X86Register.XMM8);
	}

	@Override
	public IId sem_xmm9() {
		return new X86RegisterId(X86Register.XMM9);
	}

	@Override
	public IId sem_xmm10() {
		return new X86RegisterId(X86Register.XMM10);
	}

	@Override
	public IId sem_xmm11() {
		return new X86RegisterId(X86Register.XMM11);
	}

	@Override
	public IId sem_xmm12() {
		return new X86RegisterId(X86Register.XMM12);
	}

	@Override
	public IId sem_xmm13() {
		return new X86RegisterId(X86Register.XMM13);
	}

	@Override
	public IId sem_xmm14() {
		return new X86RegisterId(X86Register.XMM14);
	}

	@Override
	public IId sem_xmm15() {
		return new X86RegisterId(X86Register.XMM15);
	}

	@Override
	public IId id_arch(long id) {
		return new GenericArchRegister(id);
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
	 * sem_sexpr
	 */

	@Override
	public SimpleLinearExpression sem_sexpr_lin(ILinearExpression _this) {
		return new SimpleLinearExpression((LinearExpression) _this);
	}

	@Override
	public SimpleCompareExpression sem_sexpr_cmp(ICompare _this) {
		return new SimpleCompareExpression((Compare) _this);
	}

	@Override
	public SimpleExpression sem_sexpr_arb() {
		return new Arbitrary();
	}

	/*
	 * sem_op_cmp
	 */

	@Override
	public Compare sem_cmpeq(ILinearExpression opnd1, ILinearExpression opnd2) {
		return new CompareEqual((LinearExpression) opnd1,
				(LinearExpression) opnd2);
	}

	@Override
	public Compare sem_cmpneq(ILinearExpression opnd1, ILinearExpression opnd2) {
		return new CompareNotEqual((LinearExpression) opnd1,
				(LinearExpression) opnd2);
	}

	@Override
	public Compare sem_cmples(ILinearExpression opnd1, ILinearExpression opnd2) {
		return new CompareLessOrEqualSigned((LinearExpression) opnd1,
				(LinearExpression) opnd2);
	}

	@Override
	public Compare sem_cmpleu(ILinearExpression opnd1, ILinearExpression opnd2) {
		return new CompareLessOrEqualUnsigned((LinearExpression) opnd1,
				(LinearExpression) opnd2);
	}

	@Override
	public Compare sem_cmplts(ILinearExpression opnd1, ILinearExpression opnd2) {
		return new CompareLessSigned((LinearExpression) opnd1,
				(LinearExpression) opnd2);
	}

	@Override
	public Compare sem_cmpltu(ILinearExpression opnd1, ILinearExpression opnd2) {
		return new CompareLessUnsigned((LinearExpression) opnd1,
				(LinearExpression) opnd2);
	}

	/*
	 * sem_expr
	 */

	@Override
	public Expression sem_sexpr(ISimpleExpression opnd1) {
		return new Simple((SimpleExpression) opnd1);
	}

	@Override
	public Expression sem_mul(ILinearExpression opnd1, ILinearExpression opnd2) {
		return new Multiplication((LinearExpression) opnd1,
				(LinearExpression) opnd2);
	}

	@Override
	public Expression sem_div(ILinearExpression opnd1, ILinearExpression opnd2) {
		return new Division((LinearExpression) opnd1, (LinearExpression) opnd2);
	}

	@Override
	public Expression sem_divs(ILinearExpression opnd1, ILinearExpression opnd2) {
		return new SignedDivision((LinearExpression) opnd1,
				(LinearExpression) opnd2);
	}

	@Override
	public Expression sem_mod(ILinearExpression opnd1, ILinearExpression opnd2) {
		return new Modulo((LinearExpression) opnd1, (LinearExpression) opnd2);
	}

	@Override
	public Expression sem_shl(ILinearExpression opnd1, ILinearExpression opnd2) {
		return new ShiftLeft((LinearExpression) opnd1, (LinearExpression) opnd2);
	}

	@Override
	public Expression sem_shr(ILinearExpression opnd1, ILinearExpression opnd2) {
		return new ShiftRight((LinearExpression) opnd1,
				(LinearExpression) opnd2);
	}

	@Override
	public Expression sem_shrs(ILinearExpression opnd1, ILinearExpression opnd2) {
		return new ShiftRightSigned((LinearExpression) opnd1,
				(LinearExpression) opnd2);
	}

	@Override
	public Expression sem_and(ILinearExpression opnd1, ILinearExpression opnd2) {
		return new And((LinearExpression) opnd1, (LinearExpression) opnd2);
	}

	@Override
	public Expression sem_or(ILinearExpression opnd1, ILinearExpression opnd2) {
		return new Or((LinearExpression) opnd1, (LinearExpression) opnd2);
	}

	@Override
	public Expression sem_xor(ILinearExpression opnd1, ILinearExpression opnd2) {
		return new Xor((LinearExpression) opnd1, (LinearExpression) opnd2);
	}

	@Override
	public Expression sem_sx(long fromsize, ILinearExpression opnd1) {
		return new SignExtend(fromsize, (LinearExpression) opnd1);
	}

	@Override
	public Expression sem_zx(long fromsize, ILinearExpression opnd1) {
		return new ZeroExtend(fromsize, (LinearExpression) opnd1);
	}

	/*
	 * sem_varl
	 */

	@Override
	public ILimitedVariable sem_varl(IId id, long offset, long size) {
		return new LimitedVariable((Id) id, offset, size);
	}

	/*
	 * sem_varls
	 */

	@Override
	public IRReilCollection<ILimitedVariable> sem_varls_next(
			ILimitedVariable next, IRReilCollection<ILimitedVariable> list) {
		list.add(next);
		return list;
	}

	@Override
	public IRReilCollection<ILimitedVariable> sem_varls_init() {
		return new DefaultLimitedVariableCollection();
	}

	/*
	 * sem_flop
	 */

	@Override
	public IFlop sem_flop_fadd() {
		return Flop.FADD;
	}

	@Override
	public IFlop sem_flop_fsub() {
		return Flop.FSUB;
	}

	@Override
	public IFlop sem_flop_fmul() {
		return Flop.FMUL;
	}

	/*
	 * sem_stmt
	 */

	@Override
	public Statement sem_assign(long size, IVariable lhs, IExpression rhs) {
		return new AssignStatement(size, (Variable) lhs, (Expression) rhs);
	}

	@Override
	public Statement sem_load(long size, IVariable lhs, IAddress address) {
		return new LoadStatement(size, (Variable) lhs, (Address) address);
	}

	@Override
	public Statement sem_store(long size, IAddress lhs, IExpression rhs) {
		return new StoreStatement(size, (Address) lhs, (Expression) rhs);
	}

	@Override
	public Statement sem_ite(ISimpleExpression cond,
			IRReilCollection<IStatement> then_branch,
			IRReilCollection<IStatement> else_branch) {
		return new IfThenElseStatement((SimpleExpression) cond,
				(DefaultStatementCollection) then_branch,
				(DefaultStatementCollection) else_branch);
	}

	@Override
	public Statement sem_while(ISimpleExpression cond,
			IRReilCollection<IStatement> body) {
		return new WhileStatement((SimpleExpression) cond,
				(DefaultStatementCollection) body);
	}

	@Override
	public Statement sem_cbranch(ISimpleExpression cond, IAddress target_true,
			IAddress target_false) {
		return new ConditionalBranchStatement((SimpleExpression) cond,
				(Address) target_true, (Address) target_false);
	}

	@Override
	public Statement sem_branch(IBranchHint branch_hint, IAddress target) {
		return new BranchStatement((BranchHint) branch_hint, (Address) target);
	}

	@Override
	public Statement sem_flop_stmt(IFlop op, IVariable flags,
			ILimitedVariable lhs, IRReilCollection<ILimitedVariable> rhs) {
		return new FlopStatement((Flop) op, (Variable) flags,
				(LimitedVariable) lhs, (DefaultLimitedVariableCollection) rhs);
	}

	@Override
	public Statement sem_prim(String op,
			IRReilCollection<ILimitedVariable> lhs,
			IRReilCollection<ILimitedVariable> rhs) {
		return new PrimitiveStatement(op,
				(DefaultLimitedVariableCollection) lhs,
				(DefaultLimitedVariableCollection) rhs);
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
	 * sem_stmts
	 */

	@Override
	public IRReilCollection<IStatement> sem_stmts_next(IStatement next,
			IRReilCollection<IStatement> list) {
		list.add(next);
		return list;
	}

	@Override
	public IRReilCollection<IStatement> sem_stmts_init() {
		return new DefaultStatementCollection();
	}
}
