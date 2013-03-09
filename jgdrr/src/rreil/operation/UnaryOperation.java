package rreil.operation;

import rreil.linear.LinearExpression;

public abstract class UnaryOperation extends Operation {
	private LinearExpression operand1;

	public LinearExpression getOperand1() {
		return operand1;
	}

	public UnaryOperation(long size, LinearExpression operand1) {
		super(size);

		this.operand1 = operand1;
	}
}
