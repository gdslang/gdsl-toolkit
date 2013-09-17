package rreil;

import java.util.ArrayList;

import rreil.statement.IStatement;
import rreil.statement.Statement;

public class DefaultStatementCollection implements IRReilCollection<IStatement> {
	ArrayList<Statement> statements = new ArrayList<Statement>();
	
	public void add(IStatement s) {
		statements.add((Statement)s);
	}
	
	public Statement get(int i) {
		return statements.get(i);
	}
	
	public int size() {
		return statements.size();
	}
}
