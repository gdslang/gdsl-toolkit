package gdsl.translator;

import gdsl.rreil.IRReilCollection;
import gdsl.rreil.statement.IStatement;

/**
 * This class represents all information associated with a decoded and
 * translated basic block; it contains the resulting RReil statements and
 * the individual native instructions. An object of this class is created
 * by the native part of the jgdsl library; user code should not use it.
 *  
 * @author Julian Kranz
 */
public class TranslatedBlockRaw {
  private long[] instructions;
  private IRReilCollection<IStatement> rreil;
  
  /**
   * Get the pointer values into the Gdsl heap of the native instructions
   * 
   * @return an array consisting of the pointers to native instructions
   */
  public long[] getInstructions () {
    return instructions;
  }
  
  /**
   * Get the RReil statments
   * 
   * @return the RReil statements
   */
  public IRReilCollection<IStatement> getRreil () {
    return rreil;
  }

  public TranslatedBlockRaw (long[] instructions, IRReilCollection<IStatement> rreil) {
    this.instructions = instructions;
    this.rreil = rreil;
  }
}
