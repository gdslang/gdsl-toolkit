package rreil.id;

public class VirtualTemporaryId extends Id {
	private long id;

	public long getId() {
		return id;
	}

	public VirtualTemporaryId(long id) {
		this.id = id;
	}
}
