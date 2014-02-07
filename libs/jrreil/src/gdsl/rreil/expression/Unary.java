package gdsl.rreil.expression;

import gdsl.rreil.linear.LinearExpression;
import gdsl.rreil.expression.Expression;

public abstract class Unary extends Expression {
	protected LinearExpression operand1;

	public LinearExpression getOperand1() {
		return operand1;
	}

	public Unary(LinearExpression operand1) {
		this.operand1 = operand1;
	}
}
