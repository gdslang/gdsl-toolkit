package rreil.statement;

import rreil.Variable;
import rreil.expression.Expression;

public class AssignStatement extends Statement {
	protected Variable lhs;

	public Variable getLhs() {
		return lhs;
	}

	protected Expression rhs;

	public Expression getRhs() {
		return rhs;
	}

	public AssignStatement(Variable lhs, Expression rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	@Override
	public String toString() {
		return lhs + " = " + rhs;
	}
}
