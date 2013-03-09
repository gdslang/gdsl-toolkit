package rreil.statement;

import rreil.Address;
import rreil.operation.Operation;

public class StoreStatement extends Statement {
	protected Address address;

	public Address getAddress() {
		return address;
	}

	protected Operation rhs;

	public Operation getRhs() {
		return rhs;
	}

	public StoreStatement(Address address, Operation rhs) {
		this.address = address;
		this.rhs = rhs;
	}
}
