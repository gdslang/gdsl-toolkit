package rreil.expression;

public class Arbitrary extends Expression {

	public Arbitrary(long size) {
		super(size);
	}
	
	@Override
	public String toString() {
		return "arbitrary:" + size;
	}
}
