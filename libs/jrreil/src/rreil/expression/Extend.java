package rreil.expression;

import rreil.linear.LinearExpression;

public abstract class Extend extends Expression {
	protected long fromsize;

	public long getfromsize() {
		return fromsize;
	}

	protected LinearExpression operand1;

	public LinearExpression getOperand1() {
		return operand1;
	}

	public Extend(long size, long fromsize, LinearExpression operand1) {
		super(size);

		this.fromsize = fromsize;
		this.operand1 = operand1;
	}
	
	public abstract String getSignedUnsignedString();
	
	public String toString() {
		return getSignedUnsignedString() + "x:[" + fromsize + "=>" + size + "] " + operand1;
	}
}
