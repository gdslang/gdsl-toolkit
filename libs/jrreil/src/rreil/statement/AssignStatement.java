package rreil.statement;

import rreil.Variable;
import rreil.operation.Operation;

public class AssignStatement extends Statement {
	protected Variable lhs;

	public Variable getLhs() {
		return lhs;
	}

	protected Operation rhs;

	public Operation getRhs() {
		return rhs;
	}

	public AssignStatement(Variable lhs, Operation rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	@Override
	public String toString() {
		return lhs + " = " + rhs;
	}
}
