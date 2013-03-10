package rreil.statement;

import java.util.ArrayList;

import rreil.linear.LinearExpression;

public class IfThenElseStatement extends Statement {
	protected LinearExpression condition;

	public LinearExpression getCondition() {
		return condition;
	}

	protected ArrayList<Statement> thenBranch;

	public ArrayList<Statement> getThenBranch() {
		return thenBranch;
	}

	protected ArrayList<Statement> elseBranch;

	public ArrayList<Statement> getElseBranch() {
		return elseBranch;
	}

	public IfThenElseStatement(LinearExpression condition,
			ArrayList<Statement> thenBranch, ArrayList<Statement> elseBranch) {
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
