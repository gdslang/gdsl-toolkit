package gdsl.translator;

import gdsl.Gdsl;
import gdsl.decoder.Instruction;
import gdsl.rreil.BuilderBackend;
import gdsl.rreil.IRReilBuilder;
import gdsl.rreil.IRReilCollection;
import gdsl.rreil.statement.IStatement;

public class Translator {
  private Gdsl gdsl;
  private BuilderBackend backend;

  public Translator (Gdsl gdsl, IRReilBuilder builder) {
    this.gdsl = gdsl;
    this.backend = new BuilderBackend(builder);
  }

  public IRReilCollection<IStatement> translate (Instruction insn) {
    return backend.translate(gdsl.getFrontendPtr(), gdsl.getGdslStatePtr(), insn.getInsnPtr());
  }

  public IRReilCollection<IStatement> translateOptimizeBlock (long limit, SemPres preservation) {
    return backend.translateOptimizeBlock(gdsl.getFrontendPtr(), gdsl.getGdslStatePtr(), limit, preservation.getId());
  }
}
