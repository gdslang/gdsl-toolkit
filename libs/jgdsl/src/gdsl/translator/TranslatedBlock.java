package gdsl.translator;

import gdsl.decoder.Instruction;
import gdsl.rreil.IRReilCollection;
import gdsl.rreil.statement.IStatement;

/**
 * This class represents all information associated with a decoded and
 * translated basic block; it contains the resulting RReil statements and
 * the individual native instructions.
 * 
 * @author Julian Kranz
 */
public class TranslatedBlock {
  private Instruction[] instructions;
  private IRReilCollection<IStatement> rreil;
  
  /**
   * Get the native instructions
   * 
   * @return an array consisting of the native instructions
   */
  public Instruction[] getInstructions () {
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

  TranslatedBlock (Instruction[] instructions, IRReilCollection<IStatement> rreil) {
    this.instructions = instructions;
    this.rreil = rreil;
  }

  @Override public String toString () {
    StringBuilder s = new StringBuilder();
    for (int i = 0; i < instructions.length; i++)
      s.append(instructions[i] + "\n");
    s.append("---------------------\n");
    s.append(rreil + "\n");
    return s.toString();
  }
}