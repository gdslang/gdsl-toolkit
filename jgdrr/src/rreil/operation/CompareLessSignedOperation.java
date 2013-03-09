package rreil.operation;

import rreil.linear.LinearExpression;

public class CompareLessSignedOperation extends BinaryOperation {

	public CompareLessSignedOperation(long size, LinearExpression operand1,
			LinearExpression operand2) {
		super(size, operand1, operand2);
	}
}
