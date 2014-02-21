package gdsl;

public class Frontend {
  private final String name;
  private final String ext;
  
  private IFrontendConfig config;
  private boolean configured = false;
  
  private long pointer;
  
  public String getName () {
    return name;
  }

  public String getExt () {
    return ext;
  }
  
  public IFrontendConfig getConfig () {
    if(!configured)
      throw new UnsupportedOperationException();
    return config;
  }
  
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
    if(pointer == 0)
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
