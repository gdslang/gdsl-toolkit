package gdsl.asm.boundary;

import gdsl.asm.Visitor;

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

  @Override public String toString () {
    return "/" + size;
  }

  @Override public void accept (Visitor v) {
    v.visit(this);
  }
}
