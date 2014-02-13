package gdsl.rreil.expression;

import gdsl.rreil.linear.LinearExpression;
import gdsl.rreil.expression.Binary;

public class Division extends Binary {

	public Division(LinearExpression operand1,
			LinearExpression operand2) {
		super(operand1, operand2);
	}
	
	public String toString() {
		return operand1 + " /u " + operand2;
	}
}
