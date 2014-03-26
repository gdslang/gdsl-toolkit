package gdsl;

import gdsl.arch.ArchId;

/**
 * The BareFrontend class represents represents Gdsl {@link Frontend}
 * objects that are directly configured with the name of the Gdsl
 * library to use. Finding the library is left to the dl library.
 * 
 * @author Julian Kranz
 */
public class BareFrontend extends Frontend {
  /**
   * Construct a BareFrontend object
   * 
   * @param name the identifying part of the name of the Gdsl library (libgdsl-name)
   * to use
   */
  public BareFrontend (String name) {
    super(name);
  }
  
  /**
   * Construct a BareFrontend object
   * 
   * @param id the {@link ArchId} representing the architecture to
   * use; the Gdsl library name is built from its string representation
   */
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
