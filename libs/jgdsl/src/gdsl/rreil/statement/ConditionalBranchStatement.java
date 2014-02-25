package gdsl.rreil.statement;

import gdsl.rreil.Address;
import gdsl.rreil.sexpression.SimpleExpression;
import gdsl.rreil.statement.Statement;

public class ConditionalBranchStatement extends Statement {
	protected SimpleExpression condition;

	public SimpleExpression getCondition() {
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

	public ConditionalBranchStatement(SimpleExpression condition,
			Address targetTrue, Address targetFalse) {
		this.condition = condition;
		this.targetTrue = targetTrue;
		this.targetFalse = targetFalse;
	}

	@Override
	public String toString() {
		return "if(" + condition + ") goto " + targetTrue + "; else goto "
				+ targetFalse + ";";
	}
}
