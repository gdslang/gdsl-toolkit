package rreil.sexpression;

import rreil.linear.LinearExpression;

public class SimpleLinearExpression extends SimpleExpression {
	protected LinearExpression _this;

	public LinearExpression getThis() {
		return _this;
	}

	public SimpleLinearExpression(LinearExpression _this) {
		this._this = _this;
	}
	
	@Override
	public String toString() {
		return _this.toString();
	}
}
