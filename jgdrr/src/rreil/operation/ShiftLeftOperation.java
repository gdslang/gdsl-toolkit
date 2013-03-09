package rreil.operation;

import rreil.linear.LinearExpression;

public class ShiftLeftOperation extends BinaryOperation {

	public ShiftLeftOperation(long size, LinearExpression operand1,
			LinearExpression operand2) {
		super(size, operand1, operand2);
	}
}
