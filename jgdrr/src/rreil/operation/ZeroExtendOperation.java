package rreil.operation;

import rreil.linear.LinearExpression;

public class ZeroExtendOperation extends ExtendOperation {

	public ZeroExtendOperation(long size, long fromsize,
			LinearExpression operand1) {
		super(size, fromsize, operand1);
	}
}
