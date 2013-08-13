package rreil.linear;

public class LinearScaleExpression extends LinearExpression {
	protected long immediate;
	
	public long getImmediate() {
		return immediate;
	}
	
	protected LinearExpression operand;
	
	public LinearExpression getOperand1() {
		return operand;
	}
	
	public LinearScaleExpression(long immediate, LinearExpression operand) {
		this.immediate = immediate;
		this.operand = operand;
	}
	
	@Override
	public String toString() {
		return immediate + "*" + operand;
	}
}
