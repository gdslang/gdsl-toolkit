package rreil;

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
import rreil.operation.AndOperation;
import rreil.operation.ArbitraryOperation;
import rreil.operation.CompareEqualOperation;
import rreil.operation.CompareLessOrEqualSignedOperation;
import rreil.operation.CompareLessOrEqualUnsignedOperation;
import rreil.operation.CompareLessSignedOperation;
import rreil.operation.CompareLessUnsignedOperation;
import rreil.operation.CompareNotEqualOperation;
import rreil.operation.CompareOperation;
import rreil.operation.DivisionOperation;
import rreil.operation.ICompareOperation;
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
import rreil.sexpression.ISimpleExpression;
import rreil.sexpression.SimpleCompareExpression;
import rreil.sexpression.SimpleExpression;
import rreil.sexpression.SimpleLinearExpression;
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
	public IId sem_cs() {
		return new X86RegisterId(X86Register.CS);
	}

	@Override
	public IId sem_ds() {
		return new X86RegisterId(X86Register.DS);
	}

	@Override
	public IId sem_ss() {
		return new X86RegisterId(X86Register.SS);
	}

	@Override
	public IId sem_es() {
		return new X86RegisterId(X86Register.ES);
	}

	@Override
	public IId sem_fs() {
		return new X86RegisterId(X86Register.FS);
	}

	@Override
	public IId sem_gs() {
		return new X86RegisterId(X86Register.GS);
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
		return new SimpleLinearExpression((LinearExpression)_this);
	}
	@Override
	public SimpleCompareExpression sem_sexpr_cmp(ICompareOperation _this) {
		return new SimpleCompareExpression((CompareOperation)_this);
	}
	
	/*
	 * sem_op_cmp
	 */
	
	@Override
	public CompareOperation sem_cmpeq(long size, ILinearExpression opnd1,
			ILinearExpression opnd2) {
		return new CompareEqualOperation(size, (LinearExpression) opnd1,
				(LinearExpression) opnd2);
	}

	@Override
	public CompareOperation sem_cmpneq(long size, ILinearExpression opnd1,
			ILinearExpression opnd2) {
		return new CompareNotEqualOperation(size, (LinearExpression) opnd1,
				(LinearExpression) opnd2);
	}

	@Override
	public CompareOperation sem_cmples(long size, ILinearExpression opnd1,
			ILinearExpression opnd2) {
		return new CompareLessOrEqualSignedOperation(size,
				(LinearExpression) opnd1, (LinearExpression) opnd2);
	}

	@Override
	public CompareOperation sem_cmpleu(long size, ILinearExpression opnd1,
			ILinearExpression opnd2) {
		return new CompareLessOrEqualUnsignedOperation(size,
				(LinearExpression) opnd1, (LinearExpression) opnd2);
	}

	@Override
	public CompareOperation sem_cmplts(long size, ILinearExpression opnd1,
			ILinearExpression opnd2) {
		return new CompareLessSignedOperation(size, (LinearExpression) opnd1,
				(LinearExpression) opnd2);
	}

	@Override
	public CompareOperation sem_cmpltu(long size, ILinearExpression opnd1,
			ILinearExpression opnd2) {
		return new CompareLessUnsignedOperation(size, (LinearExpression) opnd1,
				(LinearExpression) opnd2);
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
	public Operation sem_cmp(ICompareOperation _this) {
		return (Operation)_this;
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
	public Statement sem_ite(ISimpleExpression cond,
			IRReilCollection then_branch, IRReilCollection else_branch) {
		return new IfThenElseStatement((SimpleExpression) cond,
				(DefaultRReilCollection) then_branch,
				(DefaultRReilCollection) else_branch);
	}

	@Override
	public Statement sem_while(ISimpleExpression cond, IRReilCollection body) {
		return new WhileStatement((SimpleExpression) cond,
				(DefaultRReilCollection) body);
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
