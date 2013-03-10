package rreil.statement;

import java.util.ArrayList;

import rreil.linear.LinearExpression;

public class WhileStatement extends Statement {
	protected LinearExpression condition;

	public LinearExpression getCondition() {
		return condition;
	}

	protected ArrayList<Statement> body;

	public ArrayList<Statement> getBody() {
		return body;
	}

	public WhileStatement(LinearExpression condition, ArrayList<Statement> body) {
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
