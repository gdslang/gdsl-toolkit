package gdsl.rreil.sexpression;

import gdsl.rreil.expression.Compare;
import gdsl.rreil.sexpression.SimpleExpression;

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
