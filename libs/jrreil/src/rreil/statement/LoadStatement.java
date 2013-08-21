package rreil.statement;

import rreil.Address;
import rreil.Variable;

public class LoadStatement extends Statement {
	protected Variable lhs;

	public Variable getLhs() {
		return lhs;
	}

	protected long size;

	public long getSize() {
		return size;
	}

	protected Address address;

	public Address getAddress() {
		return address;
	}

	public LoadStatement(Variable lhs, long size, Address address) {
		this.lhs = lhs;
		this.size = size;
		this.address = address;
	}

	@Override
	public String toString() {
		return lhs + " =:" + size + " *" + address;
	}
}
