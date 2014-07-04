package gdsl.asm.boundary;

public class SizeOffsetBoundary extends Boundary {
  private int size;
  
  public int getSize() {
    return size;
  }
  
  private int offset;
  
  public int getOffset() {
    return offset;
  }

  /**
   * @param size
   * @param offset
   */
  public SizeOffsetBoundary (int size, int offset) {
    super();
    this.size = size;
    this.offset = offset;
  }
}
