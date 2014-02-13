package gdsl.rreil.statement;

import gdsl.rreil.Address;
import gdsl.rreil.linear.LinearExpression;
import gdsl.rreil.statement.Statement;

public class StoreStatement extends Statement {
	protected long size;
	
	public long getSize() {
		return size;
	}
	
	protected Address address;

	public Address getAddress() {
		return address;
	}

	protected LinearExpression rhs;

	public LinearExpression getRhs() {
		return rhs;
	}

	public StoreStatement(long size, Address address, LinearExpression rhs) {
		this.size = size;
		this.address = address;
		this.rhs = rhs;
	}
	
	@Override
	public String toString() {
		return "*" + address + " =:" + size + " " + rhs;
	}
}
