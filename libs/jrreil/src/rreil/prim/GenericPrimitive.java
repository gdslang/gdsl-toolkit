package rreil.prim;

import rreil.DefaultLimitedVariableCollection;

public class GenericPrimitive implements IPrim {
	private String op;
	
	public String getOp() {
		return op;
	}
	
	private DefaultLimitedVariableCollection res;
	
	public DefaultLimitedVariableCollection getRes() {
		return res;
	}
	
	private DefaultLimitedVariableCollection args;
	
	public DefaultLimitedVariableCollection getArgs() {
		return args;
	}
	
	public GenericPrimitive(String op, DefaultLimitedVariableCollection res, DefaultLimitedVariableCollection args) {
		this.op = op;
		this.res = res;
		this.args = args;
	}
	
	@Override
	public String toString() {
		return res + " = $" + op + " " + args;
	}
}
