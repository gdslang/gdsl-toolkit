package gdsl.rreil.linear;

import gdsl.rreil.linear.LinearExpression;

public class LinearImmediateExpression extends LinearExpression {
	protected long immediate;
	
	public long getImmediate() {
		return immediate;
	}
	
	public LinearImmediateExpression(long immediate) {
		this.immediate = immediate;
	}
	
	@Override
	public String toString() {
		return Long.toString(immediate);
	}
}
