package gdsl.rreil.id;

import gdsl.rreil.id.Id;

public class VirtualTemporaryId extends Id {
	protected long id;

	public long getId() {
		return id;
	}

	public VirtualTemporaryId(long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "t" + id;
	}
}
