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
  
  public AVRBinder (BareFrontend frontend) {
    super(frontend);
    
    if (!checkFrontend(ArchId.AVR, frontend))
      throw new IllegalArgumentException();
  }
}
