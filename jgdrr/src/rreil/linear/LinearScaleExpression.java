package rreil.linear;

public class LinearScaleExpression extends LinearExpression {
	private long immediate;
	
	public long getImmediate() {
		return immediate;
	}
	
	private LinearExpression operand;
	
	public LinearExpression getOperand1() {
		return operand;
	}
	
	public LinearScaleExpression(long immediate, LinearExpression operand) {
		this.immediate = immediate;
		this.operand = operand;
	}
}
