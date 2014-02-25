package gdsl.rreil;

import gdsl.rreil.ILimitedVariable;
import gdsl.rreil.id.Id;

public class LimitedVariable implements ILimitedVariable {
	protected Id id;

	public Id getId() {
		return id;
	}

	protected long offset;

	public long getOffset() {
		return offset;
	}
	
	protected long size;
	
	public long getSize() {
		return size;
	}

	public LimitedVariable(Id id, long offset, long size) {		
		this.id = id;
		this.offset = offset;
		this.size = size;
	}

	@Override
	public String toString() {
		if(offset > 0)
			return id + "@" + offset + ":" + size;
		else
			return id + ":" + size;
	}
}
