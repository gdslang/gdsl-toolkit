package rreil.expression;

import rreil.linear.LinearExpression;

public class CompareLessSigned extends Compare {

	public CompareLessSigned(LinearExpression operand1,
			LinearExpression operand2) {
		super(operand1, operand2);
	}
	
	public String toString() {
		return operand1 + " <s " + operand2;
	}
}
