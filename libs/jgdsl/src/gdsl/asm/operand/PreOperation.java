package gdsl.asm.operand;

public class PreOperation extends Operand {
  private Operand expression;
  
  public Operand getExpression() {
    return expression;
  }
  
  public Operand operand;
  
  public Operand getOpnd() {
    return operand;
  }

  /**
   * @param expression
   * @param operand
   */
  public PreOperation (Operand expression, Operand operand) {
    super();
    this.expression = expression;
    this.operand = operand;
  }
  
  @Override public String toString () {
    return "([" + operand + " := " + expression + "] " + operand + ")";
  }
}
