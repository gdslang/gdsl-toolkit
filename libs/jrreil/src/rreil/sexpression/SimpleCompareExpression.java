package rreil.sexpression;

import rreil.operation.CompareOperation;

public class SimpleCompareExpression extends SimpleExpression {
	protected CompareOperation _this;

	public CompareOperation getThis() {
		return _this;
	}

	public SimpleCompareExpression(CompareOperation _this) {
		this._this = _this;
	}
	
	@Override
	public String toString() {
		return _this.toString();
	}
}
