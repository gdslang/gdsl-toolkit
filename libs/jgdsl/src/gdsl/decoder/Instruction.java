package gdsl.decoder;

import gdsl.Gdsl;

public class Instruction {
  private long insnPtr = 0;
  private Gdsl gdsl;

  public long getInsnPtr () {
    if (insnPtr == 0)
      throw new NullPointerException();
    return insnPtr;
  }

  public Instruction (Gdsl gdsl, long insnPtr) {
    this.gdsl = gdsl;
    this.insnPtr = insnPtr;
  }

  @Override public String toString () {
    return pretty(gdsl.getFrontendPtr(), gdsl.getGdslStatePtr(), getInsnPtr());
  }

  public int operands () {
    return operands(gdsl.getFrontendPtr(), gdsl.getGdslStatePtr(), getInsnPtr());
  }

  public String OperandToString (int operand) {
    return prettyOperand(gdsl.getFrontendPtr(), gdsl.getGdslStatePtr(), getInsnPtr(), operand);
  }

  private native String pretty (long frontendPtr, long gdslStatePtr, long insnPtr);

  private native int operands (long frontendPtr, long gdslStatePtr, long insnPtr);

  private native String prettyOperand (long frontendPtr, long gdslStatePtr, long insnPtr, int operand);
}
