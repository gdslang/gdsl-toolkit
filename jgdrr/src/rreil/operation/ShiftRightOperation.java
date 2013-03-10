package rreil.operation;

import rreil.linear.LinearExpression;

public class ShiftRightOperation extends BinaryOperation {

	public ShiftRightOperation(long size, LinearExpression operand1,
			LinearExpression operand2) {
		super(size, operand1, operand2);
	}
	
	@Override
	public String toString() {
		return operand1 + " >>u:" + size + " " + operand2;
	}
}
