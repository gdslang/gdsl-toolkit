package rreil.expression;

import rreil.linear.LinearExpression;

public class CompareLessOrEqualSigned extends Compare {

	public CompareLessOrEqualSigned(LinearExpression operand1,
			LinearExpression operand2) {
		super(operand1, operand2);
	}

	public String toString() {
		return operand1 + " <=s " + operand2;
	}
}
