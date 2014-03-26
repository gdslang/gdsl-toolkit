package gdsl;

import gdsl.arch.ArchId;

public class BareFrontend extends Frontend {
  public BareFrontend (String name) {
    super(name);
  }
  
  public BareFrontend (ArchId id) {
    super(id.toString().toLowerCase());
  }

  @Override public String toString () {
    return getName();
  }
  
  @Override protected void initializeNative () {
    setPointer(getFrontendPtrByLibName(getName()));
  }
  
  private native long getFrontendPtrByLibName (String name);
}
