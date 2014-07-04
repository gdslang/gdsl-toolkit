package gdsl.decoder;

import gdsl.Gdsl;

/**
 * This class represents the decoder interface of Gdsl.
 * 
 * @author Julian Kranz
 */
public class Decoder {
  private Gdsl gdsl;

  public Decoder (Gdsl gdsl) {
    this.gdsl = gdsl;
  }

  /**
   * Decode one instruction
   * 
   * @return the decoded instruction
   */
  public NativeInstruction decodeOne () {
    long insnPtr = gdsl.decodeOne();

    return new NativeInstruction(gdsl, insnPtr);
  }
}
