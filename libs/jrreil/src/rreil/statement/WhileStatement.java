package rreil.statement;

import rreil.DefaultRReilCollection;
import rreil.sexpression.SimpleExpression;

public class WhileStatement extends Statement {
	protected SimpleExpression condition;

	public SimpleExpression getCondition() {
		return condition;
	}

	protected DefaultRReilCollection body;

	public DefaultRReilCollection getBody() {
		return body;
	}

	public WhileStatement(SimpleExpression condition,
			DefaultRReilCollection body) {
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
