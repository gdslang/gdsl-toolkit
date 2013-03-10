package rreil.statement;

import rreil.Address;
import rreil.BranchHint;

public class BranchStatement extends Statement {
	protected BranchHint hint;

	public BranchHint getHint() {
		return hint;
	}

	protected Address target;

	public Address getTarget() {
		return target;
	}

	public BranchStatement(BranchHint hint, Address target) {
		this.hint = hint;
		this.target = target;
	}
	
	@Override
	public String toString() {
		return "goto[" + hint + "] " + target + ";";
	}
}
