package rreil.operation;

import rreil.linear.LinearExpression;

public class SignExtendOperation extends ExtendOperation {

	public SignExtendOperation(long size, long fromsize,
			LinearExpression operand1) {
		super(size, fromsize, operand1);
	}
}
