package gdsl;

/**
 * The Frontend class represents a GDSL frontend,
 * i.e. a decoder, translator and optimizer for some specific
 * architecture.
 * 
 * @author Julian Kranz
 */
public abstract class Frontend implements IReferable {
  private long pointer;
  
  public final ReferenceManager referenceManager = new ReferenceManager(this, 1);
  
  /**
   * Get the address of the corresponding native object.
   * 
   * @return the value of the pointer
   */
  public long getPointer () {
    if (pointer == 0)
      throw new ResourceUnavailableException("Pointer to native frontend object missing");
    else if(pointer < 0)
      throw new ResourceUnavailableException("Frontend destroyed");
    return pointer;
  }
  
  protected void setPointer (long pointer) {
    if(pointer == 0)
      throw new RuntimeException("Invalid pointer");
    this.pointer = pointer;
  }
  
  private IFrontendConfig config;
  private boolean configured = false;
  
  /**
   * Get the configurator for the frontend; it is used to configure
   * the frontend - for instance, the configurator might set the default
   * operand size to be used by the decoder.
   * 
   * @return the frontend configurator
   */
  public IFrontendConfig getConfig () {
    if (!configured)
      throw new UnsupportedOperationException();
    return config;
  }
  
  /**
   * Set the configurator for the frontend; it is used to configure
   * the frontend - for instance, the configurator might set the default
   * operand size to be used by the decoder.
   * 
   * @param config the frontend configurator
   */
  public void setConfig (IFrontendConfig config) {
    this.config = config;
    this.configured = true;
  }
  
  private final String name;
  
  /**
   * Get the name of the frontend
   * 
   * @return the name of the frontend
   */
  public String getName () {
    return name;
  }
  
  protected Frontend(String name) {
    this.name = name;
  }
  
  /**
   * Check whether the frontends has been configured using a IFrontendConfig
   * configurator.
   */
  public boolean isConfigured () {
    return configured;
  }
  
  @Override protected void finalize () throws Throwable {
    /*
     * Todo: finally
     */
    referenceManager.unref();
    super.finalize();
  }
  
  public void free() {
    if(pointer != 0) {
      destroy(getPointer());
      pointer = -1;
    }
  }
  
  private native void destroy (long frontendPtr);
}
