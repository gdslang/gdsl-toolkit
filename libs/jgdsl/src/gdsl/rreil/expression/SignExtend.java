package gdsl.rreil.expression;

import gdsl.rreil.linear.LinearExpression;
import gdsl.rreil.expression.Extend;

public class SignExtend extends Extend {

	public SignExtend(long fromsize,
			LinearExpression operand1) {
		super(fromsize, operand1);
	}

	@Override
	public String getSignedUnsignedString() {
		return "s";
	}
}
