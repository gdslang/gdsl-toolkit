package gdsl.decoder;

/**
 * This enum represents different type of native
 * instruction operands.
 * 
 * @author Julian Kranz
 */
public enum OperandType {
  /**
   * This enumerate item represents
   * immediate values.
   */
  Immediate(0),
  
  /**
   * This enumerate item represents
   * registers.
   */
  Register(1),
  
  /**
   * This enumerate item represents
   * memory operands.
   */
  Memory(2),
  
  /**
   * This enumerate item represents
   * linear expressions consisting of
   * registers and constants.
   */
  Linear(3),
  
  /**
   * This enumerate item represents
   * flow operands (the arguments
   * of branch instructions).
   */
  Flow(4);
  
  private int gdslId;
  
  /**
   * Get the gdslId of the operand type; see
   * the respective GDSL specifications for more details.
   * 
   * @return the GDSL identification number
   */
  @Deprecated
  public int getGdslId () {
    return gdslId;
  }
  
  @Deprecated
  private OperandType(int gdslId) {
    this.gdslId = gdslId;
  }
  
  /**
   * Get the {@link OperandType} object that corresponds
   * to a given GDSL indentification number
   * 
   * @param gdslId the GDSL indentification number
   * @return the {@link OperandType} object
   */
  @Deprecated
  public static OperandType fromGdslId(int gdslId) {
    if(gdslId == Immediate.gdslId)
      return Immediate;
    if(gdslId == Register.gdslId)
      return Register;
    if(gdslId == Memory.gdslId)
      return Memory;
    if(gdslId == Linear.gdslId)
      return Linear;
    if(gdslId == Flow.gdslId)
      return Flow;
    throw new RuntimeException("Invalid GDSL id");
  }
}
