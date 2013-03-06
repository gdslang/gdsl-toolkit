package rreil.linear;

public class LinearImmediateExpression extends LinearExpression {
	private long immediate;
	
	public long getImmediate() {
		return immediate;
	}
	
	public LinearImmediateExpression(long immediate) {
		this.immediate = immediate;
	}
}
