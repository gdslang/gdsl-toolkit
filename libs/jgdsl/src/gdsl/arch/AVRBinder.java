package gdsl.arch;

import gdsl.BareFrontend;
import gdsl.Frontend;

/**
 * The AVRBinder class is the binder used
 * for the AVR architecture.
 * 
 * @author Julian Kranz
 */
public class AVRBinder extends ArchBinder {
  /**
   * This constructor of the AVRBinder class automatically
   * searches the correct frontend from the list of
   * available frontends and initializes the binder. It also
   * sets a default configuration.
   * 
   * @param frontends the list of available frontends
   */
  public AVRBinder (Frontend[] frontends) {
    super(specific(frontends, ArchId.AVR));
  }
  
  /**
   * This constructor uses a {@link BareFrontend} as
   * frontend and uses the string representation of the
   * {@link ArchId} item of the AVR architecture
   * to determine the name of the corresponding Gdsl library.
   */
  public AVRBinder () {
    super(new BareFrontend(ArchId.AVR));
    
    if (!checkFrontend(ArchId.AVR, getFrontend()))
      throw new IllegalArgumentException();
  }
}
