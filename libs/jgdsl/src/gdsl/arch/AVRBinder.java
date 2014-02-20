package gdsl.arch;

import gdsl.Frontend;

public class AVRBinder extends ArchBinder {
  public AVRBinder (Frontend[] frontends) {
    super(specific(frontends, ArchId.AVR));
  }
}
