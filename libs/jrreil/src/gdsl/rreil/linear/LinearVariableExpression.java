package gdsl.rreil.linear;

import gdsl.rreil.Variable;
import gdsl.rreil.linear.LinearExpression;

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
