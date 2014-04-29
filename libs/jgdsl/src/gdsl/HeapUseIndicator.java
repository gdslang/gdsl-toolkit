package gdsl;
import gdsl.Gdsl;


public class HeapUseIndicator {
  private Gdsl gdsl;
  
  protected HeapUseIndicator(Gdsl gdsl) {
    this.gdsl = gdsl;
    gdsl.heapManager.ref();
  }
  
  @Override protected void finalize () throws Throwable {
    free();
    super.finalize();
  }
  
  public void free() {
    if(gdsl != null)
      gdsl.heapManager.unref();
  }
}
