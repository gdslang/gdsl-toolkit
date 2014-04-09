package gdsl.arch;

import gdsl.Frontend;

/**
 * The MIPSBinder class is the binder used
 * for the MIPS architecture.
 * 
 * @author Julian Kranz
 */
public class MIPSBinder extends ArchBinder {
  /**
   * This constructor of the MIPSBinder class automatically
   * searches the correct frontend from the list of
   * available frontends and initializes the binder. It also
   * sets a default configuration.
   * 
   * @param frontends the list of available frontends
   */
  public MIPSBinder (Frontend[] frontends) {
    super(specific(frontends, ArchId.MIPS));
  }
}
