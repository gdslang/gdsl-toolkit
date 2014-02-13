package gdsl.rreil.statement;

import gdsl.rreil.DefaultStatementCollection;
import gdsl.rreil.sexpression.SimpleExpression;
import gdsl.rreil.statement.Statement;

public class IfThenElseStatement extends Statement {
	protected SimpleExpression condition;

	public SimpleExpression getCondition() {
		return condition;
	}

	protected DefaultStatementCollection thenBranch;

	public DefaultStatementCollection getThenBranch() {
		return thenBranch;
	}

	protected DefaultStatementCollection elseBranch;

	public DefaultStatementCollection getElseBranch() {
		return elseBranch;
	}

	public IfThenElseStatement(SimpleExpression condition,
			DefaultStatementCollection thenBranch, DefaultStatementCollection elseBranch) {
		this.condition = condition;
		this.thenBranch = thenBranch;
		this.elseBranch = elseBranch;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("if(" + condition + ") {\n");
		for (int i = 0; i < thenBranch.size(); i++)
			builder.append(thenBranch.get(i) + "\n");
		builder.append("} else {\n");
		for (int i = 0; i < elseBranch.size(); i++)
			builder.append(elseBranch.get(i) + "\n");
		builder.append("}");
		return builder.toString();
	}
}
