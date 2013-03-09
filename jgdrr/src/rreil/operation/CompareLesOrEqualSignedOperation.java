package rreil.operation;

import rreil.linear.LinearExpression;

public class CompareLesOrEqualSignedOperation extends BinaryOperation {

	public CompareLesOrEqualSignedOperation(long size,
			LinearExpression operand1, LinearExpression operand2) {
		super(size, operand1, operand2);
	}
	
	public String toString() {
		return operand1 + " <=s:" + size + " + operand2";
	}
}
