package gdsl.asm.annotation;

import gdsl.asm.operand.Operand;

public class FunctionAnnotation extends Annotation {
  private String name;
  
  public String getName() {
    return name;
  }
  
  public Operand[] arguments;
  
  public Operand[] getArguments() {
    return arguments;
  }

  /**
   * @param name
   * @param arguments
   */
  public FunctionAnnotation (String name, Operand[] arguments) {
    super();
    this.name = name;
    this.arguments = arguments;
  }
}
