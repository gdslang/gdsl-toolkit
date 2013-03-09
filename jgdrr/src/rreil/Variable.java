package rreil;

import rreil.id.Id;

public class Variable {
	protected Id id;

	public Id getId() {
		return id;
	}
	
	protected long offset;
	
	public long getOffset() {
		return offset;
	}
	
	public Variable(Id id, long offset) {
		this.id = id;
		this.offset = offset;
	}
	
	@Override
	public String toString() {
		return id + "@" + offset;
	}
}
