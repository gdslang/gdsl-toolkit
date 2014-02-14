package gdsl.decoder;

import gdsl.Gdsl;

public class Decoder {
  private Gdsl gdsl;

  public Decoder (Gdsl gdsl) {
    this.gdsl = gdsl;
  }

  public Instruction decodeOne () {
    long offset_before = gdsl.getIpOffset();
    long insnPtr = gdsl.decodeOne();
    long offset_after = gdsl.getIpOffset();

    return new Instruction(gdsl, insnPtr, offset_after - offset_before);
  }
}
