package gdsl.asm.operand;

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
}
