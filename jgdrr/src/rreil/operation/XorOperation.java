package rreil.operation;

import rreil.linear.LinearExpression;

public class XorOperation extends BinaryOperation {

	public XorOperation(long size, LinearExpression operand1,
			LinearExpression operand2) {
		super(size, operand1, operand2);
	}
}
