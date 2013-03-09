package rreil.operation;

import rreil.linear.LinearExpression;

public abstract class ExtendOperation extends Operation {
	private long fromsize;

	public long getfromsize() {
		return fromsize;
	}

	private LinearExpression operand1;

	public LinearExpression getOperand1() {
		return operand1;
	}

	public ExtendOperation(long size, long fromsize, LinearExpression operand1) {
		super(size);

		this.fromsize = fromsize;
		this.operand1 = operand1;
	}
}
