package gdsl.rreil.sexpression;

import gdsl.rreil.expression.Compare;
import gdsl.rreil.sexpression.SimpleExpression;

public class SimpleCompareExpression extends SimpleExpression {
  
  protected long size;
  
  public long getSize() {
    return size;
  }
  
  protected Compare _this;

  public Compare getThis () {
    return _this;
  }

  public SimpleCompareExpression (long size, Compare _this) {
    this.size = size;
    this._this = _this;
  }

  @Override public String toString () {
    return "[" + _this.toString() + "]:" + size;
  }
}
