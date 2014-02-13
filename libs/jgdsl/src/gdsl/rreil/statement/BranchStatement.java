package gdsl.rreil.statement;

import gdsl.rreil.Address;
import gdsl.rreil.BranchHint;
import gdsl.rreil.statement.Statement;

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
		return "goto[" + hint + "] " + target;
	}
}
