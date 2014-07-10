package gdsl.asm.operand;

public class Composite extends Operand {
  private Operand[] operands;
  
  public Operand[] getOperands() {
    return operands;
  }
  
  public Composite (Operand[] operands) {
    this.operands = operands;
  }

  @Override public String toString () {
    StringBuilder sB = new StringBuilder();
    for (int i = 0; i < operands.length; i++) {
      if(i > 0)
        sB.append(":");
      sB.append(operands[i]);
    }
    return sB.toString();
  }

}
