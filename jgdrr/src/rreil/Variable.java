package rreil;

import rreil.id.Id;

public class Variable implements IVariable {
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
		if(offset > 0)
			return id + "@" + offset;
		else
			return id.toString();
	}
}
