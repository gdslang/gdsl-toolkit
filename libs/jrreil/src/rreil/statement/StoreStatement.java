package rreil.statement;

import rreil.Address;
import rreil.expression.Expression;

public class StoreStatement extends Statement {
	protected long size;
	
	public long getSize() {
		return size;
	}
	
	protected Address address;

	public Address getAddress() {
		return address;
	}

	protected Expression rhs;

	public Expression getRhs() {
		return rhs;
	}

	public StoreStatement(long size, Address address, Expression rhs) {
		this.size = size;
		this.address = address;
		this.rhs = rhs;
	}
	
	@Override
	public String toString() {
		return "*" + address + " =:" + size + " " + rhs;
	}
}
