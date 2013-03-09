package rreil.linear;

public abstract class LinearBinaryExpression extends LinearExpression {
	protected LinearExpression operand1;
	
	public LinearExpression getOperand1() {
		return operand1;
	}
	
	protected LinearExpression operand2;
	
	public LinearExpression getOperand2() {
		return operand2;
	}
	
	public LinearBinaryExpression(LinearExpression operand1, LinearExpression operand2) {
		this.operand1 = operand1;
		this.operand2 = operand2;
	}
	
	protected abstract String getOperatorString();
	
	@Override
	public String toString() {
		return "(" + operand1 + " " + getOperatorString() + " " + ")";
	}
}
