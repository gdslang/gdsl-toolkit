package gdsl.rreil.linear;

import gdsl.rreil.linear.LinearBinaryExpression;
import gdsl.rreil.linear.LinearExpression;

public class LinearAdditionExpression extends LinearBinaryExpression {

	public LinearAdditionExpression(LinearExpression operand1,
			LinearExpression operand2) {
		super(operand1, operand2);
	}

	@Override
	protected String getOperatorString() {
		return "+";
	}
}
