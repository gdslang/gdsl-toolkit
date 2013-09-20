package rreil.expression;

import rreil.linear.LinearExpression;

public class Division extends Binary {

	public Division(long size, LinearExpression operand1,
			LinearExpression operand2) {
		super(size, operand1, operand2);
	}
	
	public String toString() {
		return operand1 + " /u:" + size + " " + operand2;
	}
}
