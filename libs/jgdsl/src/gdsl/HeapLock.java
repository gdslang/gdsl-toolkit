package gdsl;
import gdsl.Gdsl;


public class HeapLock {
  private Gdsl gdsl;
  
  protected HeapLock(Gdsl gdsl) {
    this.gdsl = gdsl;
    gdsl.lockHeap();
  }
  
  @Override protected void finalize () throws Throwable {
    gdsl.unlockHeap();
    super.finalize();
  }
}
