package gdsl;

/**
 * The Frontend class represents a GDSL frontend,
 * i.e. a decoder, translator and optimizer for some specific
 * architecture.
 * 
 * @author Julian Kranz
 */
public class Frontend {
  private final String name;
  private final String ext;

  private IFrontendConfig config;
  private boolean configured = false;

  private long pointer;

  /**
   * Get the name of the frontend
   * 
   * @return the name of the frontend
   */
  public String getName () {
    return name;
  }

  /**
   * Get the file extension of the frontend's library
   * 
   * @return the corresponding file extension
   */
  public String getExt () {
    return ext;
  }

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

  public boolean isConfigured () {
    return configured;
  }

  void setPointer (long pointer) {
    this.pointer = pointer;
  }

  public long getPointer () {
    if (pointer == 0)
      throw new RuntimeException("Pointer to native frontend object missing");
    return pointer;
  }

  public Frontend (String name, String ext) {
    super();
    this.name = name;
    this.ext = ext;
  }

  @Override public String toString () {
    return name + "|" + ext;
  }

  public boolean identifies (Object obj) {
    if (!(obj instanceof Frontend))
      return false;
    Frontend other = (Frontend) obj;
    return name.equals(other.name) && ext.equals(other.ext);
  }
}
