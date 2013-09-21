package rreil.expression;

import rreil.linear.LinearExpression;

public class And extends Binary {

	public And(LinearExpression operand1,
			LinearExpression operand2) {
		super(operand1, operand2);
	}
	
	@Override
	public String toString() {
		return operand1 + " & " + operand2;
	}
}
