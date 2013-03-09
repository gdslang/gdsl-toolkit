package rreil.linear;

import rreil.Variable;

public class LinearVariableExpression extends LinearExpression {
	protected Variable variable;
	
	public Variable getVariable() {
		return variable;
	}
	
	public LinearVariableExpression(Variable variable) {
		this.variable = variable;
	}
	
	@Override
	public String toString() {
		return variable.toString();
	}
}
