package gdsl.asm.operand;

public class PostOperation extends Operand {
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
  public PostOperation (Operand expression, Operand operand) {
    super();
    this.expression = expression;
    this.operand = operand;
  }

  @Override public String toString () {
    return "(" + operand + " [" + operand + " := " + expression + "])";
  }
}
