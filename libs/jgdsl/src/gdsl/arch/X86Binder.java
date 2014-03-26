package gdsl.arch;

import gdsl.BareFrontend;
import gdsl.Frontend;

/**
 * The AVRBinder class is the binder used
 * for the X86 architecture.
 * 
 * @author Julian Kranz
 */
public class X86Binder extends ArchBinder {
  /**
   * This constructor of the X86Binder class automatically
   * searches the correct frontend from the list of
   * available frontends and initializes the binder. It also
   * sets a default configuration.
   * 
   * @param frontends the list of available frontends
   */
  public X86Binder (Frontend[] frontends) {
    super(specific(frontends, ArchId.X86));

    setConfigFlag(X86ConfigFlag.MODE64);
    setConfigFlag(X86ConfigFlag.DefaultOpndSz32);
  }

  public X86Binder (BareFrontend frontend) {
    super(frontend);
    
    if (!checkFrontend(ArchId.X86, frontend))
      throw new IllegalArgumentException();

    setConfigFlag(X86ConfigFlag.MODE64);
    setConfigFlag(X86ConfigFlag.DefaultOpndSz32);
  }
}
