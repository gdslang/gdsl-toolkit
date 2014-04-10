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

}
