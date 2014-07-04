package gdsl.asm;

import gdsl.asm.annotation.Annotation;
import gdsl.asm.operand.Operand;

public class Instruction {
  private long length;

  public long getLength () {
    return length;
  }

  private String mnemonic;

  public String getMnemonic () {
    return mnemonic;
  }

  private Annotation[] annotations;

  public Annotation[] getAnnotations () {
    return annotations;
  }

  private Operand[] operands;

  public Operand[] getOperands () {
    return operands;
  }

  public Instruction (long length, String mnemonic, Annotation[] annotations, Operand[] operands) {
    super();
    this.length = length;
    this.mnemonic = mnemonic;
    this.annotations = annotations;
    this.operands = operands;
  }
}
