package gdsl.asm.boundary;

public class SizeOffsetBoundary extends Boundary {
  private long size;
  
  public long getSize() {
    return size;
  }
  
  private long offset;
  
  public long getOffset() {
    return offset;
  }

  /**
   * @param size
   * @param offset
   */
  public SizeOffsetBoundary (long size, long offset) {
    super();
    this.size = size;
    this.offset = offset;
  }
}
