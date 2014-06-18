package gdsl.rreil.statement;

import gdsl.rreil.Address;
import gdsl.rreil.Variable;
import gdsl.rreil.statement.Statement;

public class LoadStatement extends Statement {
	protected long size;

	public long getSize() {
		return size;
	}
	
	protected Variable lhs;

	public Variable getLhs() {
		return lhs;
	}

	protected Address address;

	public Address getAddress() {
		return address;
	}

	public LoadStatement(long size, Variable lhs, Address address) {
		this.size = size;
		this.lhs = lhs;
		this.address = address;
	}

	@Override
	public String toString() {
		return lhs + " =:" + size + " *" + address;
	}
}
