module gdsl.reference_manager;

public import gdsl.ireferable;
import core.memory;

class ReferenceManager {
  private ulong _references = 0;
  private IReferable referable;
  private bool manageGC = true;
  
  @property public ulong references() {
    return _references;
  }
  
  this(IReferable referable) {
    this.referable = referable;
    if(manageGC && references)
      GC.addRoot(cast(void*)this);
  }
  
  this(IReferable referable, bool manageGC) {
    this.manageGC = manageGC;
    this(referable);
  }
  
  public void reference() {
    _references++;
    if(manageGC && _references == 1)
      GC.addRoot(cast(void*)this);
  }
  
  public void unreference() {
    _references--;
    checkRef();
    if(manageGC && !_references)
      GC.removeRoot(cast(void*)this);
  }
  
  public void checkRef() {
    if(!_references)
      referable.free();
  }
}