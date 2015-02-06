package gdsl.rreil.expression;

import gdsl.rreil.linear.LinearExpression;
import gdsl.rreil.expression.Expression;

public abstract class Binary extends Expression {
  protected LinearExpression operand1;

  public LinearExpression getOperand1 () {
    return operand1;
  }

  protected LinearExpression operand2;

  public LinearExpression getOperand2 () {
    return operand2;
  }

  public Binary (LinearExpression operand1,
      LinearExpression operand2) {
    this.operand1 = operand1;
    this.operand2 = operand2;
  }
}
