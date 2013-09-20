package rreil.expression;

import rreil.linear.LinearExpression;

public class SignExtend extends Extend {

	public SignExtend(long size, long fromsize,
			LinearExpression operand1) {
		super(size, fromsize, operand1);
	}

	@Override
	public String getSignedUnsignedString() {
		return "s";
	}
}
