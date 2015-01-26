package gdsl.translator;

import gdsl.Frontend;
import gdsl.Gdsl;
import gdsl.decoder.NativeInstruction;
import gdsl.rreil.BuilderBackend;
import gdsl.rreil.IRReilBuilder;
import gdsl.rreil.IRReilCollection;
import gdsl.rreil.statement.IStatement;

/**
 * This class represents the translator interface of Gdsl.
 * 
 * @author Julian Kranz
 */
public class Translator {
  private Gdsl gdsl;
  private BuilderBackend backend;

  /**
   * Construct the Translator
   * 
   * @param gdsl the corresponding {@link Gdsl} object
   * @param builder the {@link IRReilBuilder} object that builds the RReil AST using callback methods
   */
  public Translator (Gdsl gdsl, IRReilBuilder builder) {
    this.gdsl = gdsl;
    this.backend = new BuilderBackend(builder);
  }

  /**
   * Translate one instruction object
   * 
   * @param insn the instruction to translate
   * @return a collection of RReil statements built by the associated RReil builder
   */
  public IRReilCollection<IStatement> translate (NativeInstruction insn) {
    return backend.translate(gdsl.getFrontendPtr(), gdsl.getGdslStatePtr(), insn.getInsnPtr());
  }

  /**
   * Decode and translate one basic block
   * 
   * @param limit the maximal number of bytes to read from the input stream
   * @param preservation the required semantics preservation
   * 
   * @return a collection of RReil statements built by the associated RReil builder
   */
  public TranslatedBlock translateOptimizeBlock (long limit, OptimizationConfig preservation) {
    gdsl.heapManager.ref();
    Frontend frontend = gdsl.getFrontend();
    TranslatedBlockRaw blockRaw;
    if (frontend.isConfigured())
      blockRaw = backend.translateOptimizeBlockWithConfig(frontend.getPointer(), gdsl.getGdslStatePtr(), frontend
          .getConfig().vector(), limit, preservation.getId());
    else {
      blockRaw = backend.translateOptimizeBlock(frontend.getPointer(), gdsl.getGdslStatePtr(), limit, preservation.getId());
    }
    long[] instructionPointers = blockRaw.getInstructions();
    NativeInstruction[] instructions = new NativeInstruction[instructionPointers.length];
    for (int i = 0; i < instructions.length; i++)
      instructions[i] = new NativeInstruction(gdsl, instructionPointers[i]);
    gdsl.heapManager.unref();
    return new TranslatedBlock(instructions, blockRaw.getRreil());
  }
}
