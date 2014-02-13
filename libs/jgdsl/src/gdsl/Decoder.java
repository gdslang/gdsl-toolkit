package gdsl;

public class Decoder {
  private Gdsl gdsl;

  public Decoder (Gdsl gdsl) {
    this.gdsl = gdsl;
    
    gdsl.init();
  }

  public Instruction decodeOne() {
    return null;
  }
}
