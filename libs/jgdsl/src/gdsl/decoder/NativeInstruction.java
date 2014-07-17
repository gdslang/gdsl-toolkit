package gdsl.decoder;

import gdsl.Gdsl;
import gdsl.HeapExpiredException;
import gdsl.asm.Instruction;
import gdsl.asm.GeneralizerBackend;
import gdsl.asm.Visitor;
import gdsl.asm.operand.Immediate;
import gdsl.asm.operand.Memory;
import gdsl.asm.operand.Register;
import gdsl.asm.operand.Relative;
import gdsl.asm.operand.Scale;
import gdsl.asm.operand.Sum;

/**
 * This class represents a decoded instruction.
 * 
 * @author Julian Kranz
 */
public class NativeInstruction {
  private long insnPtr = 0;
  private Gdsl gdsl;
  
  private long heapRevision;

  /**
   * Get the address of the associated native instruction object;
   * 
   * Warning: This pointer is only valid as long as this {@link NativeInstruction} object
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
  @Deprecated
  public long getSize () {
    return generalize().getLength();
  }
  
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
  public NativeInstruction (Gdsl gdsl, long insnPtr) {
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
  @Deprecated
  public int operands () {
    return generalize().getOperands().length;
  }

  /**
   * Print an operand
   * 
   * @param operand the operand to print
   * @return the string representation of the operand
   */
  @Deprecated
  public String operandToString (int operand) {
    return generalize().getOperands()[operand].toString();
  }
  
  /**
   * Get the {@link OperandType} of an operand
   * 
   * @param operand the index of the respective operand
   * @return the {@link OperandType} object
   */
  @Deprecated
  public OperandType operandType(int operand) {
    OperandTypeVisitor otv = new OperandTypeVisitor();
    generalize().accept(otv);
    
    if(!otv.getVisited())
      throw new RuntimeException("Unable to determine the operand type");
    
    return otv.getOperandType();
  }
  
  /**
   * Get the mnemonic of the instruction
   * 
   * @return the mnemonic of the instruction
   */
  @Deprecated
  public String mnemonic () {
    return generalize().getMnemonic();
  }

  @Override protected void finalize () throws Throwable {
    /*
     * Todo: finally
     */
    gdsl.heapManager.unref();
    super.finalize();
  }
  
  public Instruction generalize() {
    return new GeneralizerBackend().generalize(gdsl.getFrontendPtr(), gdsl.getGdslStatePtr(), getInsnPtr());
  }
}
