package gdsl.asm.operand;

import gdsl.asm.boundary.Boundary;

public class Bounded extends Operand {
  private Boundary boundary;
  
  public Boundary getBoundary() {
    return boundary;
  }
  
  private Operand opnd;
  
  public Operand getOpnd() {
    return opnd;
  }

  /**
   * @param boundary
   * @param opnd
   */
  public Bounded (Boundary boundary, Operand opnd) {
    super();
    this.boundary = boundary;
    this.opnd = opnd;
  }
}
