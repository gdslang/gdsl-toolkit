module gdsl.reference_manager;

public import gdsl.ireferable;

class ReferenceManager {
  private ulong _references = 0;
  private IReferable referable;
  
  @property public ulong references() {
    return _references;
  }
  
  this(IReferable referable) {
    this.referable = referable;
  }
  
  this(IReferable referable, ulong references) {
    this(referable);
    this._references = references;
  }
  
  public void reference() {
    _references++;
  }
  
  public void unreference() {
    _references--;
    checkRef();
  }
  
  public void checkRef() {
    if(_references == 0)
      referable.free();
  }
}