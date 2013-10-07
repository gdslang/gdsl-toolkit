package rreil.expression;

import rreil.linear.LinearExpression;

public class CompareLessUnsigned extends Compare {

	public CompareLessUnsigned(LinearExpression operand1,
			LinearExpression operand2) {
		super(operand1, operand2);
	}
	
	public String toString() {
		return operand1 + " <u " + operand2;
	}
}
