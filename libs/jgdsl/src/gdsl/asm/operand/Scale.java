package gdsl.asm.operand;

public class Scale extends Operand {
  private long factor;
  
  public long getFactor() {
    return factor;
  }
  
  private Operand rhs;
  
  public Operand getRhs() {
    return rhs;
  }

  /**
   * @param lhs
   * @param rhs
   */
  public Scale (long factor, Operand rhs) {
    super();
    this.factor = factor;
    this.rhs = rhs;
  }
}
