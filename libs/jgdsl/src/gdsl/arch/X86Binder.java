package gdsl.arch;

import gdsl.Frontend;

public class X86Binder extends ArchBinder {
  public X86Binder (Frontend[] frontends) {
    super(specific(frontends, ArchId.X86));
    
    setConfigFlag(X86ConfigFlag.MODE64);
    setConfigFlag(X86ConfigFlag.DefaultOpndSz32);
  }
}
