package gdsl.asm.operand;

import gdsl.asm.Visitor;

public class Memory extends Operand {
  private Operand pointer;
  
  public Operand getPointer() {
    return pointer;
  }

  /**
   * @param pointer
   */
  public Memory (Operand pointer) {
    super();
    this.pointer = pointer;
  }

  @Override public String toString () {
    return "*(" + pointer + ")";
  }

  @Override public void accept (Visitor v) {
    v.visit(this);
  }
}
