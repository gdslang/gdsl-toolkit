package rreil.operation;

import rreil.linear.LinearExpression;

public abstract class BinaryOperation extends Operation {
	private LinearExpression operand1;

	public LinearExpression getOperand1() {
		return operand1;
	}

	private LinearExpression operand2;

	public LinearExpression getOperand2() {
		return operand2;
	}

	public BinaryOperation(long size, LinearExpression operand1,
			LinearExpression operand2) {
		super(size);

		this.operand1 = operand1;
		this.operand2 = operand2;
	}
}
