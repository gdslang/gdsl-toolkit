package rreil.operation;

public abstract class Operation {
	protected long size;

	public long getSize() {
		return size;
	}

	public Operation(long size) {
		this.size = size;
	}
}
