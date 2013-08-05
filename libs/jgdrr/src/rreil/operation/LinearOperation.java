package rreil.operation;

import rreil.linear.LinearExpression;

public class LinearOperation extends UnaryOperation {

	public LinearOperation(long size, LinearExpression operand1) {
		super(size, operand1);
	}
	
	@Override
	public String toString() {
		return "lin:" + size + " " + operand1;
	}
}
