package gdsl.asm.boundary;

public class SizeBoundary extends Boundary {
  private long size;
  
  public long getSize() {
    return size;
  }

  /**
   * @param size
   */
  public SizeBoundary (long size) {
    super();
    this.size = size;
  }
}
