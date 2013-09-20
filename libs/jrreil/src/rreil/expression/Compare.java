package rreil.expression;

import rreil.linear.LinearExpression;

public abstract class Compare extends Binary implements ICompare {

	public Compare(long size, LinearExpression operand1,
			LinearExpression operand2) {
		super(size, operand1, operand2);
	}

}
