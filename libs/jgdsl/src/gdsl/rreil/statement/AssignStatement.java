package gdsl.rreil.statement;

import gdsl.rreil.Variable;
import gdsl.rreil.expression.Expression;
import gdsl.rreil.statement.Statement;

public class AssignStatement extends Statement {
  protected long size;

  public long getSize () {
    return size;
  }

  protected Variable lhs;

  public Variable getLhs () {
    return lhs;
  }

  protected Expression rhs;

  public Expression getRhs () {
    return rhs;
  }

  public AssignStatement (long size, Variable lhs, Expression rhs) {
    this.size = size;
    this.lhs = lhs;
    this.rhs = rhs;
  }

  @Override public String toString () {
    return lhs + " =:" + size + " " + rhs;
  }
}
