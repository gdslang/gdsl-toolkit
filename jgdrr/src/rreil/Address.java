package rreil;

import rreil.linear.LinearExpression;

public class Address implements IAddress {
	protected long size;

	public long getSize() {
		return size;
	}

	protected LinearExpression address;

	public LinearExpression getAddress() {
		return address;
	}

	public Address(long size, LinearExpression address) {
		this.size = size;
		this.address = address;
	}
	
	@Override
	public String toString() {
		return address + ":" + size;
	}
}
