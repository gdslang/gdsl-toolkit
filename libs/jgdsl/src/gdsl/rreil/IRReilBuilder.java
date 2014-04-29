package gdsl.rreil;

import gdsl.rreil.IAddress;
import gdsl.rreil.IBranchHint;
import gdsl.rreil.IFlop;
import gdsl.rreil.ILimitedVariable;
import gdsl.rreil.IRReilCollection;
import gdsl.rreil.IVariable;
import gdsl.rreil.exception.IException;
import gdsl.rreil.expression.ICompare;
import gdsl.rreil.expression.IExpression;
import gdsl.rreil.id.IId;
import gdsl.rreil.linear.ILinearExpression;
import gdsl.rreil.sexpression.ISimpleExpression;
import gdsl.rreil.statement.IStatement;

public interface IRReilBuilder {
  /*
   * sem_id
   */

  IId shared_floating_flags ();

  IId virt_t (long t);

  IId arch (String name);

  /*
   * sem_exception
   */

  IException exception_shared_division_by_zero ();

  IException exception_x86_division_overflow ();

  IException exception_arch (long con);

  /*
   * sem_address
   */

  IAddress sem_address (long size, ILinearExpression address);

  /*
   * sem_var
   */

  IVariable sem_var (IId id, long offset);

  /*
   * sem_linear
   */

  ILinearExpression sem_lin_var (IVariable _this);

  ILinearExpression sem_lin_imm (long imm);

  ILinearExpression sem_lin_add (ILinearExpression opnd1,
      ILinearExpression opnd2);

  ILinearExpression sem_lin_sub (ILinearExpression opnd1,
      ILinearExpression opnd2);

  ILinearExpression sem_lin_scale (long imm, ILinearExpression opnd);

  /*
   * sem_sexpr
   */

  ISimpleExpression sem_sexpr_lin (ILinearExpression _this);

  ISimpleExpression sem_sexpr_cmp (ICompare _this);

  ISimpleExpression sem_sexpr_arb ();

  /*
   * sem_op_cmp
   */

  ICompare sem_cmpeq (ILinearExpression opnd1,
      ILinearExpression opnd2);

  ICompare sem_cmpneq (ILinearExpression opnd1,
      ILinearExpression opnd2);

  ICompare sem_cmples (ILinearExpression opnd1,
      ILinearExpression opnd2);

  ICompare sem_cmpleu (ILinearExpression opnd1,
      ILinearExpression opnd2);

  ICompare sem_cmplts (ILinearExpression opnd1,
      ILinearExpression opnd2);

  ICompare sem_cmpltu (ILinearExpression opnd1,
      ILinearExpression opnd2);

  /*
   * sem_expr
   */

  IExpression sem_sexpr (ISimpleExpression opnd1);

  IExpression sem_mul (ILinearExpression opnd1,
      ILinearExpression opnd2);

  IExpression sem_div (ILinearExpression opnd1,
      ILinearExpression opnd2);

  IExpression sem_divs (ILinearExpression opnd1,
      ILinearExpression opnd2);

  IExpression sem_mod (ILinearExpression opnd1,
      ILinearExpression opnd2);

  IExpression sem_mods (ILinearExpression opnd1,
      ILinearExpression opnd2);

  IExpression sem_shl (ILinearExpression opnd1,
      ILinearExpression opnd2);

  IExpression sem_shr (ILinearExpression opnd1,
      ILinearExpression opnd2);

  IExpression sem_shrs (ILinearExpression opnd1,
      ILinearExpression opnd2);

  IExpression sem_and (ILinearExpression opnd1,
      ILinearExpression opnd2);

  IExpression sem_or (ILinearExpression opnd1,
      ILinearExpression opnd2);

  IExpression sem_xor (ILinearExpression opnd1,
      ILinearExpression opnd2);

  IExpression sem_sx (long fromsize, ILinearExpression opnd1);

  IExpression sem_zx (long fromsize, ILinearExpression opnd1);

  /*
   * sem_varl
   */

  ILimitedVariable sem_varl (IId id, long offset, long size);

  /*
   * sem_varls
   */

  IRReilCollection<ILimitedVariable> sem_varls_next (ILimitedVariable next, IRReilCollection<ILimitedVariable> list);

  IRReilCollection<ILimitedVariable> sem_varls_init ();

  /*
   * sem_flop
   */

  IFlop sem_flop_fadd ();

  IFlop sem_flop_fsub ();

  IFlop sem_flop_fmul ();

  /*
   * sem_stmt
   */

  IStatement sem_assign (long size, IVariable lhs, IExpression rhs);

  IStatement sem_load (long size, IVariable lhs, IAddress address);

  IStatement sem_store (long size, IAddress address, ILinearExpression rhs);

  IStatement sem_ite (ISimpleExpression cond, IRReilCollection<IStatement> then_branch,
      IRReilCollection<IStatement> else_branch);

  IStatement sem_while (ISimpleExpression cond, IRReilCollection<IStatement> body);

  IStatement sem_cbranch (ISimpleExpression cond, IAddress target_true,
      IAddress target_false);

  IStatement sem_branch (IBranchHint branch_hint, IAddress target);

  IStatement sem_flop_stmt (IFlop op, IVariable flags, ILimitedVariable lhs, IRReilCollection<ILimitedVariable> rhs);

  IStatement sem_prim (String op, IRReilCollection<ILimitedVariable> lhs, IRReilCollection<ILimitedVariable> rhs);

  IStatement sem_throw (IException exception);

  /*
   * sem_branch_hint
   */

  IBranchHint hint_jump ();

  IBranchHint hint_call ();

  IBranchHint hint_ret ();

  /*
   * sem_stmts
   */

  IRReilCollection<IStatement> sem_stmts_next (IStatement next, IRReilCollection<IStatement> list);

  IRReilCollection<IStatement> sem_stmts_init ();
}
