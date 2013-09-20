package rreil.expression;

import rreil.linear.LinearExpression;

public class SignedDivision extends Binary {

	public SignedDivision(long size, LinearExpression operand1,
			LinearExpression operand2) {
		super(size, operand1, operand2);
	}
	
	@Override
	public String toString() {
		return operand1 + " /s:" + size + " " + operand2;
	}
}
