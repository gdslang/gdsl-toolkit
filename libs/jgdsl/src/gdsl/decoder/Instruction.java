package gdsl.decoder;

import gdsl.Gdsl;

public class Instruction {
  private long insnPtr = 0;
  private Gdsl gdsl;
  private long size;

  public long getInsnPtr () {
    if (insnPtr == 0)
      throw new NullPointerException();
    return insnPtr;
  }

  public long getSize () {
    return size;
  }
  
  public Gdsl getGdsl () {
    return gdsl;
  }

  public Instruction (Gdsl gdsl, long insnPtr, long size) {
    this.gdsl = gdsl;
    this.insnPtr = insnPtr;
    this.size = size;
  }

  @Override public String toString () {
    return pretty(gdsl.getFrontendPtr(), gdsl.getGdslStatePtr(), getInsnPtr());
  }

  private native String pretty (long frontendPtr, long gdslStatePtr, long insnPtr);

  public int operands () {
    return operands(gdsl.getFrontendPtr(), gdsl.getGdslStatePtr(), getInsnPtr());
  }

  private native int operands (long frontendPtr, long gdslStatePtr, long insnPtr);

  public String operandToString (int operand) {
    return prettyOperand(gdsl.getFrontendPtr(), gdsl.getGdslStatePtr(), getInsnPtr(), operand);
  }

  private native String prettyOperand (long frontendPtr, long gdslStatePtr, long insnPtr, int operand);

  public String mnemonic () {
    return mnemonic(gdsl.getFrontendPtr(), gdsl.getGdslStatePtr(), getInsnPtr());
  }

  private native String mnemonic (long frontendPtr, long gdslStatePtr, long insnPtr);
}
