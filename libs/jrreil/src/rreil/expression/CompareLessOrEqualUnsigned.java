package rreil.expression;

import rreil.linear.LinearExpression;

public class CompareLessOrEqualUnsigned extends Compare {

	public CompareLessOrEqualUnsigned(LinearExpression operand1, LinearExpression operand2) {
		super(operand1, operand2);
	}
	
	public String toString() {
		return operand1 + " <=u " + operand2;
	}
}
