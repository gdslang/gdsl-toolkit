package rreil.expression;

import rreil.linear.LinearExpression;

public class ZeroExtend extends Extend {

	public ZeroExtend(long size, long fromsize,
			LinearExpression operand1) {
		super(size, fromsize, operand1);
	}

	@Override
	public String getSignedUnsignedString() {
		return "z";
	}
}
