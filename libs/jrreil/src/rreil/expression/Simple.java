package rreil.expression;

import rreil.sexpression.SimpleExpression;

public class Simple extends Expression {
	SimpleExpression operand1;
	
	public SimpleExpression getSexpr() {
		return operand1;
	}
	
	public Simple(SimpleExpression operand1) {		
		this.operand1 = operand1;
	}
	
	@Override
	public String toString() {
		return operand1.toString();
	}
}
