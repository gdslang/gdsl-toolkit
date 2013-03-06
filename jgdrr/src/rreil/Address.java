package rreil;

import rreil.linear.LinearExpression;

public class Address {
	private long size;

	public long getSize() {
		return size;
	}

	private LinearExpression address;

	public LinearExpression getAddress() {
		return address;
	}

	public Address(long size, LinearExpression address) {
		this.size = size;
		this.address = address;
	}
}
