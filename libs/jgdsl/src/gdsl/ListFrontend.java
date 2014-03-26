package gdsl;

public class ListFrontend extends Frontend {
  private final String ext;

  /**
   * Get the file extension of the frontend's library
   * 
   * @return the corresponding file extension
   */
  public String getExt () {
    return ext;
  }

  /**
   * Construct a new Frontend object
   * 
   * @param name the name of the frontend, i.e. the architecture name
   * @param ext the file extension of the frontend
   */
  public ListFrontend (String name, String ext) {
    super(name);
    this.ext = ext;
  }
  
  @Override public String toString () {
    return getName() + "|" + ext;
  }
  
  /**
   * Checks whether this object identifies the other object. A
   * frontend object identifies another object if it also is an
   * object of type Frontend and has got the same name and file
   * extension.
   * 
   * @param obj the object to check
   * @return a boolean indicating the result
   */
  public boolean identifies (Object obj) {
    if (!(obj instanceof ListFrontend))
      return false;
    ListFrontend other = (ListFrontend) obj;
    return getName().equals(other.getName()) && ext.equals(other.ext);
  }
  
  @Override protected void initializeNative () {
    setPointer(getFrontendPtrByDesc(this));
  }
  
  /*
   * TODO: Remove parameter
   */
  private native long getFrontendPtrByDesc (ListFrontend frontend);
}
