package gdsl.rreil;

import gdsl.rreil.Address;
import gdsl.rreil.BranchHint;
import gdsl.rreil.DefaultLimitedVariableCollection;
import gdsl.rreil.DefaultStatementCollection;
import gdsl.rreil.Flop;
import gdsl.rreil.IAddress;
import gdsl.rreil.IBranchHint;
import gdsl.rreil.IFlop;
import gdsl.rreil.ILimitedVariable;
import gdsl.rreil.IRReilBuilder;
import gdsl.rreil.IRReilCollection;
import gdsl.rreil.IVariable;
import gdsl.rreil.LimitedVariable;
import gdsl.rreil.Variable;
import gdsl.rreil.exception.GenericArchException;
import gdsl.rreil.exception.IException;
import gdsl.rreil.exception.x86.X86Exception;
import gdsl.rreil.expression.And;
import gdsl.rreil.expression.Compare;
import gdsl.rreil.expression.CompareEqual;
import gdsl.rreil.expression.CompareLessOrEqualSigned;
import gdsl.rreil.expression.CompareLessOrEqualUnsigned;
import gdsl.rreil.expression.CompareLessSigned;
import gdsl.rreil.expression.CompareLessUnsigned;
import gdsl.rreil.expression.CompareNotEqual;
import gdsl.rreil.expression.Division;
import gdsl.rreil.expression.Expression;
import gdsl.rreil.expression.ICompare;
import gdsl.rreil.expression.IExpression;
import gdsl.rreil.expression.Modulo;
import gdsl.rreil.expression.Multiplication;
import gdsl.rreil.expression.Or;
import gdsl.rreil.expression.ShiftLeft;
import gdsl.rreil.expression.ShiftRight;
import gdsl.rreil.expression.ShiftRightSigned;
import gdsl.rreil.expression.SignExtend;
import gdsl.rreil.expression.SignedDivision;
import gdsl.rreil.expression.SignedModulo;
import gdsl.rreil.expression.Simple;
import gdsl.rreil.expression.Xor;
import gdsl.rreil.expression.ZeroExtend;
import gdsl.rreil.id.ArchRegister;
import gdsl.rreil.id.FloatingFlags;
import gdsl.rreil.id.IId;
import gdsl.rreil.id.Id;
import gdsl.rreil.id.VirtualLessOrEqualSignedId;
import gdsl.rreil.id.VirtualLessOrEqualUnsignedId;
import gdsl.rreil.id.VirtualLessSignedId;
import gdsl.rreil.id.VirtualTemporaryId;
import gdsl.rreil.linear.ILinearExpression;
import gdsl.rreil.linear.LinearAdditionExpression;
import gdsl.rreil.linear.LinearExpression;
import gdsl.rreil.linear.LinearImmediateExpression;
import gdsl.rreil.linear.LinearScaleExpression;
import gdsl.rreil.linear.LinearSubtractionExpression;
import gdsl.rreil.linear.LinearVariableExpression;
import gdsl.rreil.sexpression.Arbitrary;
import gdsl.rreil.sexpression.ISimpleExpression;
import gdsl.rreil.sexpression.SimpleCompareExpression;
import gdsl.rreil.sexpression.SimpleExpression;
import gdsl.rreil.sexpression.SimpleLinearExpression;
import gdsl.rreil.statement.AssignStatement;
import gdsl.rreil.statement.BranchStatement;
import gdsl.rreil.statement.ConditionalBranchStatement;
import gdsl.rreil.statement.FlopStatement;
import gdsl.rreil.statement.IStatement;
import gdsl.rreil.statement.IfThenElseStatement;
import gdsl.rreil.statement.LoadStatement;
import gdsl.rreil.statement.PrimitiveStatement;
import gdsl.rreil.statement.Statement;
import gdsl.rreil.statement.StoreStatement;
import gdsl.rreil.statement.WhileStatement;

public class DefaultRReilBuilder implements IRReilBuilder {

  /*
   * sem_id
   */

  @Override public IId shared_floating_flags () {
    return new FloatingFlags();
  }

  @Override public Id virt_t (long t) {
    return new VirtualTemporaryId(t);
  }

  @Override public IId arch (String name) {
    return new ArchRegister(name);
  }

  /*
   * sem_exception
   */

  @Override public IException exception_shared_division_by_zero () {
    return gdsl.rreil.exception.Exception.DIVISION_BY_ZERO;
  }

  @Override public IException exception_arch (String ex) {
    return new GenericArchException(ex);
  }

  /*
   * sem_address
   */

  @Override public Address sem_address (long size, ILinearExpression address) {
    return new Address(size, (LinearExpression) address);
  }

  /*
   * sem_var
   */

  @Override public Variable sem_var (IId id, long offset) {
    return new Variable((Id) id, offset);
  }

  /*
   * sem_linear
   */

  @Override public LinearExpression sem_lin_var (IVariable _this) {
    return new LinearVariableExpression((Variable) _this);
  }

  @Override public LinearExpression sem_lin_imm (long imm) {
    return new LinearImmediateExpression(imm);
  }

  @Override public LinearExpression sem_lin_add (ILinearExpression opnd1,
      ILinearExpression opnd2) {
    return new LinearAdditionExpression((LinearExpression) opnd1,
      (LinearExpression) opnd2);
  }

  @Override public LinearExpression sem_lin_sub (ILinearExpression opnd1,
      ILinearExpression opnd2) {
    return new LinearSubtractionExpression((LinearExpression) opnd1,
      (LinearExpression) opnd2);
  }

  @Override public LinearExpression sem_lin_scale (long imm, ILinearExpression opnd) {
    return new LinearScaleExpression(imm, (LinearExpression) opnd);
  }

  /*
   * sem_sexpr
   */

  @Override public SimpleLinearExpression sem_sexpr_lin (ILinearExpression _this) {
    return new SimpleLinearExpression((LinearExpression) _this);
  }

  @Override public SimpleCompareExpression sem_sexpr_cmp (ICompare _this) {
    return new SimpleCompareExpression((Compare) _this);
  }

  @Override public SimpleExpression sem_sexpr_arb () {
    return new Arbitrary();
  }

  /*
   * sem_op_cmp
   */

  @Override public Compare sem_cmpeq (ILinearExpression opnd1, ILinearExpression opnd2) {
    return new CompareEqual((LinearExpression) opnd1,
      (LinearExpression) opnd2);
  }

  @Override public Compare sem_cmpneq (ILinearExpression opnd1, ILinearExpression opnd2) {
    return new CompareNotEqual((LinearExpression) opnd1,
      (LinearExpression) opnd2);
  }

  @Override public Compare sem_cmples (ILinearExpression opnd1, ILinearExpression opnd2) {
    return new CompareLessOrEqualSigned((LinearExpression) opnd1,
      (LinearExpression) opnd2);
  }

  @Override public Compare sem_cmpleu (ILinearExpression opnd1, ILinearExpression opnd2) {
    return new CompareLessOrEqualUnsigned((LinearExpression) opnd1,
      (LinearExpression) opnd2);
  }

  @Override public Compare sem_cmplts (ILinearExpression opnd1, ILinearExpression opnd2) {
    return new CompareLessSigned((LinearExpression) opnd1,
      (LinearExpression) opnd2);
  }

  @Override public Compare sem_cmpltu (ILinearExpression opnd1, ILinearExpression opnd2) {
    return new CompareLessUnsigned((LinearExpression) opnd1,
      (LinearExpression) opnd2);
  }

  /*
   * sem_expr
   */

  @Override public Expression sem_sexpr (ISimpleExpression opnd1) {
    return new Simple((SimpleExpression) opnd1);
  }

  @Override public Expression sem_mul (ILinearExpression opnd1, ILinearExpression opnd2) {
    return new Multiplication((LinearExpression) opnd1,
      (LinearExpression) opnd2);
  }

  @Override public Expression sem_div (ILinearExpression opnd1, ILinearExpression opnd2) {
    return new Division((LinearExpression) opnd1, (LinearExpression) opnd2);
  }

  @Override public Expression sem_divs (ILinearExpression opnd1, ILinearExpression opnd2) {
    return new SignedDivision((LinearExpression) opnd1,
      (LinearExpression) opnd2);
  }

  @Override public Expression sem_mod (ILinearExpression opnd1, ILinearExpression opnd2) {
    return new Modulo((LinearExpression) opnd1, (LinearExpression) opnd2);
  }

  @Override public Expression sem_mods (ILinearExpression opnd1, ILinearExpression opnd2) {
    return new SignedModulo((LinearExpression) opnd1, (LinearExpression) opnd2);
  }


  @Override public Expression sem_shl (ILinearExpression opnd1, ILinearExpression opnd2) {
    return new ShiftLeft((LinearExpression) opnd1, (LinearExpression) opnd2);
  }

  @Override public Expression sem_shr (ILinearExpression opnd1, ILinearExpression opnd2) {
    return new ShiftRight((LinearExpression) opnd1,
      (LinearExpression) opnd2);
  }

  @Override public Expression sem_shrs (ILinearExpression opnd1, ILinearExpression opnd2) {
    return new ShiftRightSigned((LinearExpression) opnd1,
      (LinearExpression) opnd2);
  }

  @Override public Expression sem_and (ILinearExpression opnd1, ILinearExpression opnd2) {
    return new And((LinearExpression) opnd1, (LinearExpression) opnd2);
  }

  @Override public Expression sem_or (ILinearExpression opnd1, ILinearExpression opnd2) {
    return new Or((LinearExpression) opnd1, (LinearExpression) opnd2);
  }

  @Override public Expression sem_xor (ILinearExpression opnd1, ILinearExpression opnd2) {
    return new Xor((LinearExpression) opnd1, (LinearExpression) opnd2);
  }

  @Override public Expression sem_sx (long fromsize, ILinearExpression opnd1) {
    return new SignExtend(fromsize, (LinearExpression) opnd1);
  }

  @Override public Expression sem_zx (long fromsize, ILinearExpression opnd1) {
    return new ZeroExtend(fromsize, (LinearExpression) opnd1);
  }

  /*
   * sem_varl
   */

  @Override public ILimitedVariable sem_varl (IId id, long offset, long size) {
    return new LimitedVariable((Id) id, offset, size);
  }

  /*
   * sem_varls
   */

  @Override public IRReilCollection<ILimitedVariable> sem_varls_next (
      ILimitedVariable next, IRReilCollection<ILimitedVariable> list) {
    list.add(next);
    return list;
  }

  @Override public IRReilCollection<ILimitedVariable> sem_varls_init () {
    return new DefaultLimitedVariableCollection();
  }

  /*
   * sem_flop
   */

  @Override public IFlop sem_flop_fadd () {
    return Flop.FADD;
  }

  @Override public IFlop sem_flop_fsub () {
    return Flop.FSUB;
  }

  @Override public IFlop sem_flop_fmul () {
    return Flop.FMUL;
  }

  /*
   * sem_stmt
   */

  @Override public Statement sem_assign (long size, IVariable lhs, IExpression rhs) {
    return new AssignStatement(size, (Variable) lhs, (Expression) rhs);
  }

  @Override public Statement sem_load (long size, IVariable lhs, IAddress address) {
    return new LoadStatement(size, (Variable) lhs, (Address) address);
  }

  @Override public Statement sem_store (long size, IAddress lhs, ILinearExpression rhs) {
    return new StoreStatement(size, (Address) lhs, (LinearExpression) rhs);
  }

  @Override public Statement sem_ite (ISimpleExpression cond,
      IRReilCollection<IStatement> then_branch,
      IRReilCollection<IStatement> else_branch) {
    return new IfThenElseStatement((SimpleExpression) cond,
      (DefaultStatementCollection) then_branch,
      (DefaultStatementCollection) else_branch);
  }

  @Override public Statement sem_while (ISimpleExpression cond,
      IRReilCollection<IStatement> body) {
    return new WhileStatement((SimpleExpression) cond,
      (DefaultStatementCollection) body);
  }

  @Override public Statement sem_cbranch (ISimpleExpression cond, IAddress target_true,
      IAddress target_false) {
    return new ConditionalBranchStatement((SimpleExpression) cond,
      (Address) target_true, (Address) target_false);
  }

  @Override public Statement sem_branch (IBranchHint branch_hint, IAddress target) {
    return new BranchStatement((BranchHint) branch_hint, (Address) target);
  }

  @Override public Statement sem_flop_stmt (IFlop op, IVariable flags,
      ILimitedVariable lhs, IRReilCollection<ILimitedVariable> rhs) {
    return new FlopStatement((Flop) op, (Variable) flags,
      (LimitedVariable) lhs, (DefaultLimitedVariableCollection) rhs);
  }

  @Override public Statement sem_prim (String op,
      IRReilCollection<ILimitedVariable> lhs,
      IRReilCollection<ILimitedVariable> rhs) {
    return new PrimitiveStatement(op,
      (DefaultLimitedVariableCollection) lhs,
      (DefaultLimitedVariableCollection) rhs);
  }

  @Override public Statement sem_throw (IException exception) {
    return new gdsl.rreil.statement.ThrowStatement(exception);
  }

  /*
   * branch_hint
   */

  @Override public BranchHint hint_jump () {
    return BranchHint.JUMP;
  }

  @Override public BranchHint hint_call () {
    return BranchHint.CALL;
  }

  @Override public BranchHint hint_ret () {
    return BranchHint.RET;
  }

  /*
   * sem_stmts
   */

  @Override public IRReilCollection<IStatement> sem_stmts_next (IStatement next,
      IRReilCollection<IStatement> list) {
    list.add(next);
    return list;
  }

  @Override public IRReilCollection<IStatement> sem_stmts_init () {
    return new DefaultStatementCollection();
  }
}
