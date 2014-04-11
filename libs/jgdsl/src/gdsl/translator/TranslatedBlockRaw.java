package gdsl.translator;

import gdsl.rreil.IRReilCollection;
import gdsl.rreil.statement.IStatement;

public class TranslatedBlockRaw {
  private long[] instructions;
  private IRReilCollection<IStatement> rreil;
  
  public long[] getInstructions () {
    return instructions;
  }
  
  public IRReilCollection<IStatement> getRreil () {
    return rreil;
  }

  public TranslatedBlockRaw (long[] instructions, IRReilCollection<IStatement> rreil) {
    this.instructions = instructions;
    this.rreil = rreil;
  }
}
