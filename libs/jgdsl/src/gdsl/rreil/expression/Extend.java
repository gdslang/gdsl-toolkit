package gdsl.rreil.expression;

import gdsl.rreil.linear.LinearExpression;
import gdsl.rreil.expression.Expression;

public abstract class Extend extends Expression {
	protected long fromsize;

	public long getfromsize() {
		return fromsize;
	}

	protected LinearExpression operand1;

	public LinearExpression getOperand1() {
		return operand1;
	}

	public Extend(long fromsize, LinearExpression operand1) {
		this.fromsize = fromsize;
		this.operand1 = operand1;
	}
	
	public abstract String getSignedUnsignedString();
	
	public String toString() {
		return getSignedUnsignedString() + "x:[" + fromsize + "=>*] " + operand1;
	}
}
