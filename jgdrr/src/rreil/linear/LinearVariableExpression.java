package rreil.linear;

import rreil.Variable;

public class LinearVariableExpression extends LinearExpression {
	private Variable variable;
	
	public Variable getVariable() {
		return variable;
	}
	
	public LinearVariableExpression(Variable variable) {
		this.variable = variable;
	}
}
