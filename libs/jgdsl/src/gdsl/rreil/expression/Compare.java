package gdsl.rreil.expression;

import gdsl.rreil.linear.LinearExpression;
import gdsl.rreil.expression.Binary;
import gdsl.rreil.expression.ICompare;

public abstract class Compare extends Binary implements ICompare {

  public Compare (LinearExpression operand1,
      LinearExpression operand2) {
    super(operand1, operand2);
  }
}
