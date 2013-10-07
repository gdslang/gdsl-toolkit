package rreil.statement;

import rreil.DefaultLimitedVariableCollection;

public class PrimitiveStatement extends Statement {
	private String op;
	
	public String getOp() {
		return op;
	}
	
	private DefaultLimitedVariableCollection lhs;
	
	public DefaultLimitedVariableCollection getRes() {
		return lhs;
	}
	
	private DefaultLimitedVariableCollection rhs;
	
	public DefaultLimitedVariableCollection getArgs() {
		return rhs;
	}
	
	public PrimitiveStatement(String op, DefaultLimitedVariableCollection lhs, DefaultLimitedVariableCollection rhs) {
		this.op = op;
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	@Override
	public String toString() {
		return lhs + " = $" + op + " " + rhs;
	}
}
