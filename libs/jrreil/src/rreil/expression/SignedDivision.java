package rreil.expression;

import rreil.linear.LinearExpression;

public class SignedDivision extends Binary {

	public SignedDivision(LinearExpression operand1,
			LinearExpression operand2) {
		super(operand1, operand2);
	}
	
	@Override
	public String toString() {
		return operand1 + " /s " + operand2;
	}
}
