package gdsl.asm.operand;

public class PostOperation extends Operand {
  private Operand expression;
  
  public Operand getExpression() {
    return expression;
  }
  
  public Operand opnd;
  
  public Operand getOpnd() {
    return opnd;
  }

  /**
   * @param expression
   * @param opnd
   */
  public PostOperation (Operand expression, Operand opnd) {
    super();
    this.expression = expression;
    this.opnd = opnd;
  }
}
