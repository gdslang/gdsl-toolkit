package rreil.operation;

public abstract class Operation {
	private long size;

	public long getSize() {
		return size;
	}

	public Operation(long size) {
		this.size = size;
	}
}
