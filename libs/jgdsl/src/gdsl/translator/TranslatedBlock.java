package gdsl.translator;

import gdsl.decoder.Instruction;
import gdsl.rreil.IRReilCollection;
import gdsl.rreil.statement.IStatement;

public class TranslatedBlock {
  private Instruction[] instructions;
  private IRReilCollection<IStatement> rreil;
  
  public Instruction[] getInstructions () {
    return instructions;
  }
  
  public IRReilCollection<IStatement> getRreil () {
    return rreil;
  }

  public TranslatedBlock (Instruction[] instructions, IRReilCollection<IStatement> rreil) {
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