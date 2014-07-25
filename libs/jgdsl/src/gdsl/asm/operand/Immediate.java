package gdsl.asm.operand;

import gdsl.asm.Visitor;

public class Immediate extends Operand {
  private long value;
  
  public long getValue() {
    return value;
  }

  /**
   * @param value
   */
  public Immediate (long value) {
    super();
    this.value = value;
  }

  @Override public String toString () {
    return Long.toString(value);
  }

  @Override public void accept (Visitor v) {
    v.visit(this);
  }
}
