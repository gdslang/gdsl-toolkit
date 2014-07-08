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
  
  @Override public String toString () {
    StringBuilder sB = new StringBuilder("{Annotation: ");
    sB.append(name).append("(");
    for (int i = 0; i < arguments.length; i++) {
      if(i > 0)
        sB.append(", ");
      sB.append(arguments[i]);
    }
    return sB.append(")}").toString();
  }
}
