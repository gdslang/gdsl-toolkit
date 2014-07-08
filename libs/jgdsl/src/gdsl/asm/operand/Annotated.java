package gdsl.asm.operand;

import gdsl.asm.annotation.Annotation;

public class Annotated extends Operand {
  private gdsl.asm.annotation.Annotation annotation;
  
  public gdsl.asm.annotation.Annotation getAnnotation() {
    return annotation;
  }

  private Operand operand;
  
  public Operand getOperand() {
    return operand;
  }

  /**
   * @param annotation
   * @param operand
   */
  public Annotated (Annotation annotation, Operand operand) {
    super();
    this.annotation = annotation;
    this.operand = operand;
  }

  @Override public String toString () {
    return "(" + annotation + ":" + operand + ")";
  }
}
