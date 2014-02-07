package gdsl.rreil.statement;

import gdsl.rreil.DefaultStatementCollection;
import gdsl.rreil.sexpression.SimpleExpression;
import gdsl.rreil.statement.Statement;

public class WhileStatement extends Statement {
	protected SimpleExpression condition;

	public SimpleExpression getCondition() {
		return condition;
	}

	protected DefaultStatementCollection body;

	public DefaultStatementCollection getBody() {
		return body;
	}

	public WhileStatement(SimpleExpression condition,
			DefaultStatementCollection body) {
		this.condition = condition;
		this.body = body;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("while(" + condition + ") {\n");
		for (int i = 0; i < body.size(); i++)
			builder.append(body.get(i) + "\n");
		builder.append("}");
		return builder.toString();
	}
}
