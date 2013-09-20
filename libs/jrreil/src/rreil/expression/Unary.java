package rreil.expression;

import rreil.linear.LinearExpression;

public abstract class Unary extends Expression {
	protected LinearExpression operand1;

	public LinearExpression getOperand1() {
		return operand1;
	}

	public Unary(long size, LinearExpression operand1) {
		super(size);

		this.operand1 = operand1;
	}
}
