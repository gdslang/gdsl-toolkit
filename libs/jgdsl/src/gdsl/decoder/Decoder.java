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
    
    gdsl.init();
    gdsl.setCode(buffer, 0);
  }

  public Instruction decodeOne() {
    return new Instruction(gdsl, gdsl.decodeOne());
  }
}
