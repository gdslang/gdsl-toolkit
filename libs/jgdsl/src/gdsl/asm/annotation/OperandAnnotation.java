package gdsl.asm.annotation;

import gdsl.asm.Visitor;
import gdsl.asm.operand.Operand;

public class OperandAnnotation extends Annotation {
  private String name;
  
  public String getName() {
    return name;
  }
  
  private Operand operand;
  
  public Operand getOperand() {
    return operand;
  }

  /**
   * @param name
   * @param operand
   */
  public OperandAnnotation (String name, Operand operand) {
    super();
    this.name = name;
    this.operand = operand;
  }

  @Override public String toString () {
    return "{Annotation " + name + " " + operand + "}";
  }

  @Override public void accept (Visitor v) {
    v.visit(this);
  }
}
