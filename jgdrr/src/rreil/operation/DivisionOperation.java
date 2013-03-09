package rreil.operation;

import rreil.linear.LinearExpression;

public class DivisionOperation extends BinaryOperation {

	public DivisionOperation(long size, LinearExpression operand1,
			LinearExpression operand2) {
		super(size, operand1, operand2);
	}
	
	public String toString() {
		return operand1 + " /u:" + size + " + operand2";
	}
}
