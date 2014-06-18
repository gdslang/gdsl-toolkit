package gdsl.rreil;

import gdsl.rreil.exception.IException;
import gdsl.rreil.expression.ICompare;
import gdsl.rreil.expression.IExpression;
import gdsl.rreil.id.IId;
import gdsl.rreil.linear.ILinearExpression;
import gdsl.rreil.sexpression.ISimpleExpression;
import gdsl.rreil.statement.IStatement;
import gdsl.translator.SemPres;
import gdsl.translator.TranslatedBlockRaw;

public class BuilderBackend {
  private IRReilBuilder builder;

  public BuilderBackend (IRReilBuilder builder) {
    this.builder = builder;
  }

//	@SuppressWarnings("unchecked")
//	public IRReilCollection<IStatement> decodeAndTranslate(byte[] bytes) {
//		if (!backendSet)
//			throw new RuntimeException("Frontend not set");
//		return (IRReilCollection<IStatement>) decodeAndTranslateNative(bytes);
//	}

  /*
   * sem_id
   */
  private Object shared_floating_flags () {
    return builder.shared_floating_flags();
  }

  /*
   * sem_exception
   */
  private Object exception_shared_division_by_zero () {
    return builder.exception_shared_division_by_zero();
  }

  private Object exception_arch (Object t) {
    return builder.exception_arch((String) t);
  }

  private Object virt_t (Object t) {
    return builder.virt_t((Long) t);
  }

  private Object arch (Object name) {
    return builder.arch((String)name);
  }

  /*
   * sem_address
   */

  private Object sem_address (Object size, Object address) {
    return builder.sem_address((Long) size, (ILinearExpression) address);
  }

  /*
   * sem_var
   */

  private Object sem_var (Object id, Object offset) {
    return builder.sem_var((IId) id, (Long) offset);
  }

  /*
   * sem_linear
   */

  private Object sem_lin_var (Object _this) {
    return builder.sem_lin_var((IVariable) _this);
  }

  private Object sem_lin_imm (Object imm) {
    return builder.sem_lin_imm((Long) imm);
  }

  private Object sem_lin_add (Object opnd1, Object opnd2) {
    return builder.sem_lin_add((ILinearExpression) opnd1,
        (ILinearExpression) opnd2);
  }

  private Object sem_lin_sub (Object opnd1, Object opnd2) {
    return builder.sem_lin_sub((ILinearExpression) opnd1,
        (ILinearExpression) opnd2);
  }

  private Object sem_lin_scale (Object imm, Object opnd) {
    return builder.sem_lin_scale((Long) imm, (ILinearExpression) opnd);
  }

  /*
   * sem_sexpr
   */

  private Object sem_sexpr_lin (Object _this) {
    return builder.sem_sexpr_lin((ILinearExpression) _this);
  }

  private Object sem_sexpr_cmp (Object _this) {
    return builder.sem_sexpr_cmp((ICompare) _this);
  }

  private Object sem_sexpr_arb () {
    return builder.sem_sexpr_arb();
  }

  /*
   * sem_op_cmp
   */

  private Object sem_cmpeq (Object opnd1, Object opnd2) {
    return builder.sem_cmpeq((ILinearExpression) opnd1,
        (ILinearExpression) opnd2);
  }

  private Object sem_cmpneq (Object opnd1, Object opnd2) {
    return builder.sem_cmpneq((ILinearExpression) opnd1,
        (ILinearExpression) opnd2);
  }

  private Object sem_cmples (Object opnd1, Object opnd2) {
    return builder.sem_cmples((ILinearExpression) opnd1,
        (ILinearExpression) opnd2);
  }

  private Object sem_cmpleu (Object opnd1, Object opnd2) {
    return builder.sem_cmpleu((ILinearExpression) opnd1,
        (ILinearExpression) opnd2);
  }

  private Object sem_cmplts (Object opnd1, Object opnd2) {
    return builder.sem_cmplts((ILinearExpression) opnd1,
        (ILinearExpression) opnd2);
  }

  private Object sem_cmpltu (Object opnd1, Object opnd2) {
    return builder.sem_cmpltu((ILinearExpression) opnd1,
        (ILinearExpression) opnd2);
  }

  /*
   * sem_expr
   */

  private Object sem_sexpr (Object opnd1) {
    return builder.sem_sexpr((ISimpleExpression) opnd1);
  }

  private Object sem_mul (Object opnd1, Object opnd2) {
    return builder.sem_mul((ILinearExpression) opnd1,
        (ILinearExpression) opnd2);
  }

  private Object sem_div (Object opnd1, Object opnd2) {
    return builder.sem_div((ILinearExpression) opnd1,
        (ILinearExpression) opnd2);
  }

  private Object sem_divs (Object opnd1, Object opnd2) {
    return builder.sem_divs((ILinearExpression) opnd1,
        (ILinearExpression) opnd2);
  }

  private Object sem_mod (Object opnd1, Object opnd2) {
    return builder.sem_mod((ILinearExpression) opnd1,
        (ILinearExpression) opnd2);
  }

  private Object sem_shl (Object opnd1, Object opnd2) {
    return builder.sem_shl((ILinearExpression) opnd1,
        (ILinearExpression) opnd2);
  }

  private Object sem_shr (Object opnd1, Object opnd2) {
    return builder.sem_shr((ILinearExpression) opnd1,
        (ILinearExpression) opnd2);
  }

  private Object sem_shrs (Object opnd1, Object opnd2) {
    return builder.sem_shrs((ILinearExpression) opnd1,
        (ILinearExpression) opnd2);
  }

  private Object sem_and (Object opnd1, Object opnd2) {
    return builder.sem_and((ILinearExpression) opnd1,
        (ILinearExpression) opnd2);
  }

  private Object sem_or (Object opnd1, Object opnd2) {
    return builder.sem_or((ILinearExpression) opnd1,
        (ILinearExpression) opnd2);
  }

  private Object sem_xor (Object opnd1, Object opnd2) {
    return builder.sem_xor((ILinearExpression) opnd1,
        (ILinearExpression) opnd2);
  }

  private Object sem_sx (Object fromsize, Object opnd1) {
    return builder.sem_sx((Long) fromsize, (ILinearExpression) opnd1);
  }

  private Object sem_zx (Object fromsize, Object opnd1) {
    return builder.sem_zx((Long) fromsize, (ILinearExpression) opnd1);
  }

  /*
   * sem_varl
   */

  private Object sem_varl (Object id, Object offset, Object size) {
    return builder.sem_varl((IId) id, (Long) offset, (Long) size);
  }

  /*
   * sem_varls
   */

  @SuppressWarnings("unchecked") private Object sem_varls_next (Object next, Object list) {
    return builder.sem_varls_next((ILimitedVariable) next,
        (IRReilCollection<ILimitedVariable>) list);
  }

  private Object sem_varls_init () {
    return builder.sem_varls_init();
  }

  /*
   * sem_flop
   */

  private Object sem_flop_fadd () {
    return builder.sem_flop_fadd();
  }

  private Object sem_flop_fsub () {
    return builder.sem_flop_fsub();
  }

  private Object sem_flop_fmul () {
    return builder.sem_flop_fmul();
  }

  /*
   * sem_stmt
   */

  private Object sem_assign (Object size, Object lhs, Object rhs) {
    return builder.sem_assign((Long) size, (IVariable) lhs,
        (IExpression) rhs);
  }

  private Object sem_load (Object size, Object lhs, Object address) {
    return builder.sem_load((Long) size, (IVariable) lhs,
        (IAddress) address);
  }

  private Object sem_store (Object size, Object address, Object rhs) {
    return builder.sem_store((Long) size, (IAddress) address,
        (ILinearExpression) rhs);
  }

  @SuppressWarnings("unchecked") private Object sem_ite (Object cond, Object then_branch, Object else_branch) {
    return builder.sem_ite((ISimpleExpression) cond,
        (IRReilCollection<IStatement>) then_branch,
        (IRReilCollection<IStatement>) else_branch);
  }

  @SuppressWarnings("unchecked") private Object sem_while (Object cond, Object body) {
    return builder.sem_while((ISimpleExpression) cond,
        (IRReilCollection<IStatement>) body);
  }

  private Object sem_cbranch (Object cond, Object target_true,
      Object target_false) {
    return builder.sem_cbranch((ISimpleExpression) cond,
        (IAddress) target_true, (IAddress) target_false);
  }

  private Object sem_branch (Object branch_hint, Object target) {
    return builder.sem_branch((IBranchHint) branch_hint, (IAddress) target);
  }

  @SuppressWarnings("unchecked") private Object sem_flop_stmt (Object op, Object flags, Object lhs, Object rhs) {
    return builder.sem_flop_stmt((IFlop) op, (IVariable) flags,
        (ILimitedVariable) lhs,
        (IRReilCollection<ILimitedVariable>) rhs);
  }

  @SuppressWarnings("unchecked") private Object sem_prim (Object op, Object lhs, Object rhs) {
    return builder.sem_prim((String) op, (IRReilCollection<ILimitedVariable>) lhs,
        (IRReilCollection<ILimitedVariable>) rhs);
  }

  private Object sem_throw (Object exception) {
    return builder.sem_throw((IException) exception);
  }

  /*
   * sem_branch_hint
   */

  private Object hint_jump () {
    return builder.hint_jump();
  }

  private Object hint_call () {
    return builder.hint_call();
  }

  private Object hint_ret () {
    return builder.hint_ret();
  }

  /*
   * sem_stmts
   */

  @SuppressWarnings("unchecked") private Object sem_stmts_next (Object next, Object list) {
    return builder.sem_stmts_next((IStatement) next,
        (IRReilCollection<IStatement>) list);
  }

  private Object sem_stmts_init () {
    return builder.sem_stmts_init();
  }

  public native IRReilCollection<IStatement> translate (long frontendPtr, long gdslStatePtr, long insnPtr);

  public native TranslatedBlockRaw translateOptimizeBlock (long frontendPtr, long gdslStatePtr, long limit,
      int preservation);

  public native TranslatedBlockRaw translateOptimizeBlockWithConfig (long frontendPtr, long gdslStatePtr,
      long config, long limit,
      int preservation);
}
