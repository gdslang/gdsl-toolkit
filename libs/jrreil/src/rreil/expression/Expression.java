package rreil.expression;

public abstract class Expression implements IExpression {
	protected long size;

	public long getSize() {
		return size;
	}

	public Expression(long size) {
		this.size = size;
	}
}
