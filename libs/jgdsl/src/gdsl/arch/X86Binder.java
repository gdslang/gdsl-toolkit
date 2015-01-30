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

    setConfigFlag(X86ConfigFlag.DefaultOpndSz32);
  }

  /**
   * This constructor uses a {@link BareFrontend} as
   * frontend and uses the string representation of the
   * {@link ArchId} item of the X86 architecture
   * to determine the name of the corresponding Gdsl library.
   */
  public X86Binder () {
    super(new BareFrontend(ArchId.X86));
    
    if (!checkFrontend(ArchId.X86, getFrontend()))
      throw new IllegalArgumentException();

    setConfigFlag(X86ConfigFlag.DefaultOpndSz32);
  }
}
