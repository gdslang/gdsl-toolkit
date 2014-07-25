package gdsl.asm.operand;

import gdsl.asm.Visitor;
import gdsl.asm.boundary.Boundary;

public class Bounded extends Operand {
  private Boundary boundary;
  
  public Boundary getBoundary() {
    return boundary;
  }
  
  private Operand operand;
  
  public Operand getOperand() {
    return operand;
  }

  /**
   * @param boundary
   * @param operand
   */
  public Bounded (Boundary boundary, Operand operand) {
    super();
    this.boundary = boundary;
    this.operand = operand;
  }

  @Override public String toString () {
    return operand + boundary.toString();
  }

  @Override public void accept (Visitor v) {
    v.visit(this);
  }
}
