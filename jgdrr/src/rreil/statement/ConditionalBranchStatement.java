package rreil.statement;

import rreil.Address;
import rreil.linear.LinearExpression;

public class ConditionalBranchStatement extends Statement {
	protected LinearExpression condition;

	public LinearExpression getCondition() {
		return condition;
	}

	protected Address targetTrue;

	public Address getTargetTrue() {
		return targetTrue;
	}

	protected Address targetFalse;

	public Address getTargetFalse() {
		return targetFalse;
	}

	public ConditionalBranchStatement(LinearExpression condition,
			Address targetTrue, Address targetFalse) {
		this.condition = condition;
		this.targetTrue = targetTrue;
		this.targetFalse = targetFalse;
	}
}
