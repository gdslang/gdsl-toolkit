package rreil.expression;

import rreil.linear.LinearExpression;

public abstract class Unary extends Expression {
	protected LinearExpression operand1;

	public LinearExpression getOperand1() {
		return operand1;
	}

	public Unary(LinearExpression operand1) {
		this.operand1 = operand1;
	}
}
