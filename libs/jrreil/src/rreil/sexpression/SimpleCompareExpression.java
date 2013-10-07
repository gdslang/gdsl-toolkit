package rreil.sexpression;

import rreil.expression.Compare;

public class SimpleCompareExpression extends SimpleExpression {
	protected Compare _this;

	public Compare getThis() {
		return _this;
	}

	public SimpleCompareExpression(Compare _this) {
		this._this = _this;
	}
	
	@Override
	public String toString() {
		return _this.toString();
	}
}
