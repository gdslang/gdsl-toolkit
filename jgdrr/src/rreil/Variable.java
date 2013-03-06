package rreil;

import rreil.id.Id;

public class Variable {
	private Id id;

	public Id getId() {
		return id;
	}
	
	private long offset;
	
	public long getOffset() {
		return offset;
	}
	
	public Variable(Id id, long offset) {
		this.id = id;
		this.offset = offset;
	}
}
