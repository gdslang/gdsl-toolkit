package gdsl.decoder;

import java.nio.ByteBuffer;

import gdsl.Gdsl;

public class Decoder {
  private Gdsl gdsl;
  private ByteBuffer buffer;

  public ByteBuffer getBuffer () {
    return buffer;
  }

  public Decoder (Gdsl gdsl, ByteBuffer buffer) {
    this.gdsl = gdsl;
    this.buffer = buffer;

    gdsl.setCode(buffer, 0);
  }

  public Instruction decodeOne () {
    long offset_before = gdsl.getIpOffset();
    long insnPtr = gdsl.decodeOne();
    long offset_after = gdsl.getIpOffset();

    return new Instruction(gdsl, insnPtr, offset_after - offset_before);
  }
}
