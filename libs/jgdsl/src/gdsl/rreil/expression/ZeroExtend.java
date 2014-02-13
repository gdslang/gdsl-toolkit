package gdsl.rreil.expression;

import gdsl.rreil.linear.LinearExpression;
import gdsl.rreil.expression.Extend;

public class ZeroExtend extends Extend {

	public ZeroExtend(long fromsize,
			LinearExpression operand1) {
		super(fromsize, operand1);
	}

	@Override
	public String getSignedUnsignedString() {
		return "z";
	}
}
