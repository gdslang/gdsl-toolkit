package rreil.operation;

public class ArbitraryOperation extends Operation {

	public ArbitraryOperation(long size) {
		super(size);
	}
	
	@Override
	public String toString() {
		return "arbitrary:" + size;
	}
}
