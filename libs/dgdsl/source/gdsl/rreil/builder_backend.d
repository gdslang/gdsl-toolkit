module gdsl.rreil.builder_backend;

class BuilderBackend {
  
   /*
   * sem_id
   */
  extern (C) Object shared_floating_flags () {
//    return builder.shared_floating_flags();
    return null;
  }

  /*
   * sem_exception
   */
  extern (C) Object exception_shared_division_by_zero () {
//    return builder.exception_shared_division_by_zero();
    return null;
  }

  extern (C) Object exception_arch (Object t) {
//    return builder.exception_arch((String) t);
    return null;
  }

  extern (C) Object virt_t (Object t) {
//    return builder.virt_t((Long) t);
    return null;
  }

  extern (C) Object arch (Object name) {
//    return builder.arch((String)name);
    return null;
  }

  /*
   * sem_address
   */

  extern (C) Object sem_address (Object size, Object address) {
//    return builder.sem_address((Long) size, (ILinearExpression) address);
    return null;
  }

  /*
   * sem_var
   */

  extern (C) Object sem_var (Object id, Object offset) {
//    return builder.sem_var((IId) id, (Long) offset);
    return null;
  }

  /*
   * sem_linear
   */

  extern (C) Object sem_lin_var (Object _this) {
//    return builder.sem_lin_var((IVariable) _this);
    return null;
  }

  extern (C) Object sem_lin_imm (Object imm) {
//    return builder.sem_lin_imm((Long) imm);
    return null;
  }

  extern (C) Object sem_lin_add (Object opnd1, Object opnd2) {
//    return builder.sem_lin_add((ILinearExpression) opnd1,
//        (ILinearExpression) opnd2);
    return null;
  }

  extern (C) Object sem_lin_sub (Object opnd1, Object opnd2) {
//    return builder.sem_lin_sub((ILinearExpression) opnd1,
//        (ILinearExpression) opnd2);
    return null;
  }

  extern (C) Object sem_lin_scale (Object imm, Object opnd) {
//    return builder.sem_lin_scale((Long) imm, (ILinearExpression) opnd);
    return null;
  }

  /*
   * sem_sexpr
   */

  extern (C) Object sem_sexpr_lin (Object _this) {
//    return builder.sem_sexpr_lin((ILinearExpression) _this);
    return null;
  }

  extern (C) Object sem_sexpr_cmp (Object _this) {
//    return builder.sem_sexpr_cmp((ICompare) _this);
    return null;
  }

  extern (C) Object sem_sexpr_arb () {
//    return builder.sem_sexpr_arb();
    return null;
  }

  /*
   * sem_op_cmp
   */

  extern (C) Object sem_cmpeq (Object opnd1, Object opnd2) {
//    return builder.sem_cmpeq((ILinearExpression) opnd1,
//        (ILinearExpression) opnd2);
    return null;
  }

  extern (C) Object sem_cmpneq (Object opnd1, Object opnd2) {
//    return builder.sem_cmpneq((ILinearExpression) opnd1,
//        (ILinearExpression) opnd2);
    return null;
  }

  extern (C) Object sem_cmples (Object opnd1, Object opnd2) {
//    return builder.sem_cmples((ILinearExpression) opnd1,
//        (ILinearExpression) opnd2);
    return null;
  }

  extern (C) Object sem_cmpleu (Object opnd1, Object opnd2) {
//    return builder.sem_cmpleu((ILinearExpression) opnd1,
//        (ILinearExpression) opnd2);
    return null;
  }

  extern (C) Object sem_cmplts (Object opnd1, Object opnd2) {
//    return builder.sem_cmplts((ILinearExpression) opnd1,
//        (ILinearExpression) opnd2);
    return null;
  }

  extern (C) Object sem_cmpltu (Object opnd1, Object opnd2) {
//    return builder.sem_cmpltu((ILinearExpression) opnd1,
//        (ILinearExpression) opnd2);
    return null;
  }

  /*
   * sem_expr
   */

  extern (C) Object sem_sexpr (Object opnd1) {
//    return builder.sem_sexpr((ISimpleExpression) opnd1);
    return null;
  }

  extern (C) Object sem_mul (Object opnd1, Object opnd2) {
//    return builder.sem_mul((ILinearExpression) opnd1,
//        (ILinearExpression) opnd2);
    return null;
  }

  extern (C) Object sem_div (Object opnd1, Object opnd2) {
//    return builder.sem_div((ILinearExpression) opnd1,
//        (ILinearExpression) opnd2);
    return null;
  }

  extern (C) Object sem_divs (Object opnd1, Object opnd2) {
//    return builder.sem_divs((ILinearExpression) opnd1,
//        (ILinearExpression) opnd2);
    return null;
  }

  extern (C) Object sem_mod (Object opnd1, Object opnd2) {
//    return builder.sem_mod((ILinearExpression) opnd1,
//        (ILinearExpression) opnd2);
    return null;
  }

  extern (C) Object sem_shl (Object opnd1, Object opnd2) {
//    return builder.sem_shl((ILinearExpression) opnd1,
//        (ILinearExpression) opnd2);
    return null;
  }

  extern (C) Object sem_shr (Object opnd1, Object opnd2) {
//    return builder.sem_shr((ILinearExpression) opnd1,
//        (ILinearExpression) opnd2);
    return null;
  }

  extern (C) Object sem_shrs (Object opnd1, Object opnd2) {
//    return builder.sem_shrs((ILinearExpression) opnd1,
//        (ILinearExpression) opnd2);
    return null;
  }

  extern (C) Object sem_and (Object opnd1, Object opnd2) {
//    return builder.sem_and((ILinearExpression) opnd1,
//        (ILinearExpression) opnd2);
    return null;
  }

  extern (C) Object sem_or (Object opnd1, Object opnd2) {
//    return builder.sem_or((ILinearExpression) opnd1,
//        (ILinearExpression) opnd2);
    return null;
  }

  extern (C) Object sem_xor (Object opnd1, Object opnd2) {
//    return builder.sem_xor((ILinearExpression) opnd1,
//        (ILinearExpression) opnd2);
    return null;
  }

  extern (C) Object sem_sx (Object fromsize, Object opnd1) {
//    return builder.sem_sx((Long) fromsize, (ILinearExpression) opnd1);
    return null;
  }

  extern (C) Object sem_zx (Object fromsize, Object opnd1) {
//    return builder.sem_zx((Long) fromsize, (ILinearExpression) opnd1);
    return null;
  }

  /*
   * sem_varl
   */

  extern (C) Object sem_varl (Object id, Object offset, Object size) {
//    return builder.sem_varl((IId) id, (Long) offset, (Long) size);
    return null;
  }

  /*
   * sem_varls
   */

  extern (C) Object sem_varls_next (Object next, Object list) {
//    return builder.sem_varls_next((ILimitedVariable) next,
//        (IRReilCollection<ILimitedVariable>) list);
    return null;
  }

  extern (C) Object sem_varls_init () {
//    return builder.sem_varls_init();
    return null;
  }

  /*
   * sem_flop
   */

  extern (C) Object sem_flop_fadd () {
//    return builder.sem_flop_fadd();
    return null;
  }

  extern (C) Object sem_flop_fsub () {
//    return builder.sem_flop_fsub();
    return null;
  }

  extern (C) Object sem_flop_fmul () {
//    return builder.sem_flop_fmul();
    return null;
  }

  /*
   * sem_stmt
   */

  extern (C) Object sem_assign (Object size, Object lhs, Object rhs) {
//    return builder.sem_assign((Long) size, (IVariable) lhs,
//        (IExpression) rhs);
    return null;
  }

  extern (C) Object sem_load (Object size, Object lhs, Object address) {
//    return builder.sem_load((Long) size, (IVariable) lhs,
//        (IAddress) address);
    return null;
  }

  extern (C) Object sem_store (Object size, Object address, Object rhs) {
//    return builder.sem_store((Long) size, (IAddress) address,
//        (ILinearExpression) rhs);
    return null;
  }

  extern (C) Object sem_ite (Object cond, Object then_branch, Object else_branch) {
//    return builder.sem_ite((ISimpleExpression) cond,
//        (IRReilCollection<IStatement>) then_branch,
//        (IRReilCollection<IStatement>) else_branch);
    return null;
  }

  extern (C) Object sem_while (Object cond, Object _body) {
//    return builder.sem_while((ISimpleExpression) cond,
//        (IRReilCollection<IStatement>) body);
    return null;
  }

  extern (C) Object sem_cbranch (Object cond, Object target_true,
      Object target_false) {
//    return builder.sem_cbranch((ISimpleExpression) cond,
//        (IAddress) target_true, (IAddress) target_false);
      return null;
  }

  extern (C) Object sem_branch (Object branch_hint, Object target) {
//    return builder.sem_branch((IBranchHint) branch_hint, (IAddress) target);
    return null;
  }

  extern (C) Object sem_flop_stmt (Object op, Object flags, Object lhs, Object rhs) {
//    return builder.sem_flop_stmt((IFlop) op, (IVariable) flags,
//        (ILimitedVariable) lhs,
//        (IRReilCollection<ILimitedVariable>) rhs);
    return null;
  }

  extern (C) Object sem_prim (Object op, Object lhs, Object rhs) {
//    return builder.sem_prim((String) op, (IRReilCollection<ILimitedVariable>) lhs,
//        (IRReilCollection<ILimitedVariable>) rhs);
    return null;
  }

  extern (C) Object sem_throw (Object exception) {
//    return builder.sem_throw((IException) exception);
    return null;
  }

  /*
   * sem_branch_hint
   */

  extern (C) Object hint_jump () {
//    return builder.hint_jump();
    return null;
  }

  extern (C) Object hint_call () {
//    return builder.hint_call();
    return null;
  }

  extern (C) Object hint_ret () {
//    return builder.hint_ret();
    return null;
  }

  /*
   * sem_stmts
   */

  extern (C) Object sem_stmts_next (Object next, Object list) {
//    return builder.sem_stmts_next((IStatement) next,
//        (IRReilCollection<IStatement>) list);
    return null;
  }

  extern (C) Object sem_stmts_init () {
//    return builder.sem_stmts_init();
    return null;
  }
}