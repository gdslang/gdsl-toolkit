package rreil.operation;

import rreil.linear.LinearExpression;

public abstract class CompareOperation extends BinaryOperation implements ICompareOperation {

	public CompareOperation(long size, LinearExpression operand1,
			LinearExpression operand2) {
		super(size, operand1, operand2);
	}

}
