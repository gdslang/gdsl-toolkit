package gdsl.asm.boundary;

public class SizeBoundary extends Boundary {
  private int size;
  
  public int getSize() {
    return size;
  }

  /**
   * @param size
   */
  public SizeBoundary (int size) {
    super();
    this.size = size;
  }
}
