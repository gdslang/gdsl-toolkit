package rreil.operation;

import rreil.linear.LinearExpression;

public abstract class ExtendOperation extends Operation {
	protected long fromsize;

	public long getfromsize() {
		return fromsize;
	}

	protected LinearExpression operand1;

	public LinearExpression getOperand1() {
		return operand1;
	}

	public ExtendOperation(long size, long fromsize, LinearExpression operand1) {
		super(size);

		this.fromsize = fromsize;
		this.operand1 = operand1;
	}
	
	public abstract String getSignedUnsignedString();
	
	public String toString() {
		return getSignedUnsignedString() + "x:[" + fromsize + "=>" + size + "] " + operand1;
	}
}
