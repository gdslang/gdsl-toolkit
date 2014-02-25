package gdsl.arch;

import gdsl.Frontend;
import gdsl.IFrontendConfig;

/**
 * The ArchBinder class can be used to bind a GDSL instance to a specific
 * architecture. The class also offers methods to configure the architecture.
 * 
 * In order to bind to an architecture, instantiate the respective subclass.
 * 
 * @author Julian Kranz
 *
 */
public abstract class ArchBinder implements IFrontendConfig {
  private Frontend frontend;

  /**
   * Get the Gdsl frontend that corresponds to the given
   * architecture
   * 
   * @return the respective Gdsl frontend
   */
  public Frontend getFrontend () {
    return frontend;
  }
  
  private long configVector = 0;

  protected ArchBinder (Frontend frontend) {
    this.frontend = frontend;
    this.frontend.setConfig(this);
  }
  
  protected static Frontend specific(Frontend[] frontends, ArchId id) {
    for (Frontend frontend : frontends) {
      if(frontend.getName().equalsIgnoreCase(id.toString()))
        return frontend;
    }
    throw new IllegalArgumentException("Unable to find frontend " + id.toString() + "...");
  }
  
  /**
   * Set one architecture-specific configuration
   * flag.
   * 
   * @param flag the configuration flag to set
   * @return the callee object
   */
  public ArchBinder setConfigFlag(IConfigFlag flag) {
    this.configVector |= flag.getFlag();
    return this;
  }
  
  /**
   * Reset one architecture-specific configuration
   * flag.
   * 
   * @param flag the configuration flag to reset
   * @return the callee object
   */
  public ArchBinder resetConfigFlag(IConfigFlag flag) {
    this.configVector &= ~flag.getFlag();
    return this;
  }
  
  @Override public long vector () {
    return configVector; 
  }
}
