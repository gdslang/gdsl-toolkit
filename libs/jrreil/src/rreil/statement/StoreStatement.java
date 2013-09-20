package rreil.statement;

import rreil.Address;
import rreil.expression.Expression;

public class StoreStatement extends Statement {
	protected Address address;

	public Address getAddress() {
		return address;
	}

	protected Expression rhs;

	public Expression getRhs() {
		return rhs;
	}

	public StoreStatement(Address address, Expression rhs) {
		this.address = address;
		this.rhs = rhs;
	}
	
	@Override
	public String toString() {
		return "*" + address + " = " + rhs;
	}
}
