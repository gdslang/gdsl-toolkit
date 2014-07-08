package gdsl.asm.operand;

import gdsl.asm.boundary.Boundary;

public class Bounded extends Operand {
  private Boundary boundary;
  
  public Boundary getBoundary() {
    return boundary;
  }
  
  private Operand operand;
  
  public Operand getOpnd() {
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
}
