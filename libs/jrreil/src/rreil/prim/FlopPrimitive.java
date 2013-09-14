package rreil.prim;

import rreil.DefaultLimitedVariableCollection;
import rreil.Flop;
import rreil.LimitedVariable;
import rreil.Variable;

public class FlopPrimitive implements IPrim {
	private Flop flop;

	public Flop getFlop() {
		return flop;
	}

	private Variable flags;

	public Variable getFlags() {
		return flags;
	}

	private LimitedVariable res;

	public LimitedVariable getRes() {
		return res;
	}

	private DefaultLimitedVariableCollection args;

	public DefaultLimitedVariableCollection getArgs() {
		return args;
	}

	public FlopPrimitive(Flop flop, Variable flags, LimitedVariable res,
			DefaultLimitedVariableCollection args) {
		this.flop = flop;
		this.flags = flags;
		this.res = res;
		this.args = args;
	}

	@Override
	public String toString() {
		return res + " = $" + flop + " " + args + " [flags:" + flags + "]";
	}
}
