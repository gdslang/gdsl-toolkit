package rreil.expression;

import rreil.linear.LinearExpression;

public abstract class Compare extends Binary implements ICompare {

	public Compare(LinearExpression operand1,
			LinearExpression operand2) {
		super(operand1, operand2);
	}

}
