package rreil.linear;

public class LinearBinaryExpression extends LinearExpression {
	private LinearExpression operand1;
	
	public LinearExpression getOperand1() {
		return operand1;
	}
	
	private LinearExpression operand2;
	
	public LinearExpression getOperand2() {
		return operand2;
	}
	
	public LinearBinaryExpression(LinearExpression operand1, LinearExpression operand2) {
		this.operand1 = operand1;
		this.operand2 = operand2;
	}
}
