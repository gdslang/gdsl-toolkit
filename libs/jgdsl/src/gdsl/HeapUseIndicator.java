package gdsl;

import gdsl.Gdsl;

/**
 * This class is used to indicate usage of the Gdsl heap; such an indicator is usful to make sure
 * that the GDSL heap is always reset as early as possible: If no reference
 * to the heap is ever created, the reference count will never drop to zero
 * (because it stays zero) and therefore the heap will never be reset (it will,
 * however, be freed once the GDSL object itself is destructed). The heap
 * usage indicator will initiate the resetting of the heap when its
 * destructor is called and no other references exist.
 * 
 * @author Julian Kranz
 */
public class HeapUseIndicator {
  private Gdsl gdsl;

  protected HeapUseIndicator (Gdsl gdsl) {
    this.gdsl = gdsl;
    gdsl.heapManager.ref();
  }

  @Override protected void finalize () throws Throwable {
    free();
    super.finalize();
  }

  private void free () {
    if (gdsl != null)
      gdsl.heapManager.unref();
  }
}
