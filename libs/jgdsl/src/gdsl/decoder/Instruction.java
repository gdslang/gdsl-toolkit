package gdsl.decoder;

import gdsl.Gdsl;
import gdsl.HeapExpiredException;

/**
 * This class represents a decoded instruction.
 * 
 * @author Julian Kranz
 */
public class Instruction {
  private long insnPtr = 0;
  private Gdsl gdsl;
  
  private long heapRevision;

  /**
   * Get the address of the associated native instruction object;
   * 
   * Warning: This pointer is only valid as long as this {@link Instruction} object
   * is reachable. This method should only be used by the jgdsl library.
   * 
   * @return the value of the pointer
   */
  public long getInsnPtr () {
    if (heapRevision != gdsl.getHeapRevision())
      throw new HeapExpiredException();
    if (insnPtr == 0)
      throw new NullPointerException();
    return insnPtr;
  }

  /**
   * Get the size of the instruction
   * 
   * @return the size of the instruction
   */
  public long getSize () {
    return size(gdsl.getFrontendPtr(), gdsl.getGdslStatePtr(), getInsnPtr());
  }
  
  private native long size(long frontendPtr, long gdslStatePtr, long insnPtr);
  
  /**
   * Get the associated {@link Gdsl} object
   * 
   * @return the associated {@link Gdsl} object
   */
  public Gdsl getGdsl () {
    return gdsl;
  }

  /**
   * Construct an instruction object
   * 
   * @param gdsl the associated {@link Gdsl} object
   * @param insnPtr the address of the native instruction object
   * @param size the size of the instruction
   */
  public Instruction (Gdsl gdsl, long insnPtr) {
    this.gdsl = gdsl;
    this.heapRevision = gdsl.getHeapRevision();
    gdsl.heapManager.ref();
    this.insnPtr = insnPtr;
  }

  @Override public String toString () {
    return pretty(gdsl.getFrontendPtr(), gdsl.getGdslStatePtr(), getInsnPtr());
  }

  private native String pretty (long frontendPtr, long gdslStatePtr, long insnPtr);

  /**
   * Get the number of operands
   * 
   * @return the number of operands
   */
  public int operands () {
    return operands(gdsl.getFrontendPtr(), gdsl.getGdslStatePtr(), getInsnPtr());
  }

  private native int operands (long frontendPtr, long gdslStatePtr, long insnPtr);

  /**
   * Print an operand
   * 
   * @param operand the operand to print
   * @return the string representation of the operand
   */
  public String operandToString (int operand) {
    return prettyOperand(gdsl.getFrontendPtr(), gdsl.getGdslStatePtr(), getInsnPtr(), operand);
  }

  private native String prettyOperand (long frontendPtr, long gdslStatePtr, long insnPtr, int operand);
  
  /**
   * Get the {@link OperandType} of an operand
   * 
   * @param operand the index of the respective operand
   * @return the {@link OperandType} object
   */
  public OperandType operandType(int operand) {
    return OperandType.fromGdslId(operandType(gdsl.getFrontendPtr(), gdsl.getGdslStatePtr(), getInsnPtr(), operand));
  }
  
  private native int operandType(long frontendPtr, long gdslStatePtr, long insnPtr, int operand);

  /**
   * Get the mnemonic of the instruction
   * 
   * @return the mnemonic of the instruction
   */
  public String mnemonic () {
    return mnemonic(gdsl.getFrontendPtr(), gdsl.getGdslStatePtr(), getInsnPtr());
  }

  private native String mnemonic (long frontendPtr, long gdslStatePtr, long insnPtr);
  
  @Override protected void finalize () throws Throwable {
    /*
     * Todo: finally
     */
    gdsl.heapManager.unref();
    super.finalize();
  }
}
