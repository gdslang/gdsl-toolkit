package rreil.statement;

import rreil.DefaultLimitedVariableCollection;
import rreil.Flop;
import rreil.LimitedVariable;
import rreil.Variable;

public class FlopStatement extends Statement {
	private Flop flop;

	public Flop getFlop() {
		return flop;
	}

	private Variable flags;

	public Variable getFlags() {
		return flags;
	}

	private LimitedVariable lhs;

	public LimitedVariable getRes() {
		return lhs;
	}

	private DefaultLimitedVariableCollection rhs;

	public DefaultLimitedVariableCollection getArgs() {
		return rhs;
	}

	public FlopStatement(Flop flop, Variable flags, LimitedVariable lhs,
			DefaultLimitedVariableCollection rhs) {
		this.flop = flop;
		this.flags = flags;
		this.lhs = lhs;
		this.rhs = rhs;
	}

	@Override
	public String toString() {
		return lhs + " = $" + flop + " " + rhs + " [flags:" + flags + "]";
	}
}
