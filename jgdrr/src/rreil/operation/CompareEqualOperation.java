package rreil.operation;

import rreil.linear.LinearExpression;

public class CompareEqualOperation extends BinaryOperation {

	public CompareEqualOperation(long size, LinearExpression operand1,
			LinearExpression operand2) {
		super(size, operand1, operand2);
	}
}
