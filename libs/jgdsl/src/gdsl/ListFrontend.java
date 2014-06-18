package gdsl;

/**
 * The ListFrontend class represents Gdsl {@link Frontend} objects
 * that have been found by a directory listing of the respective
 * Gdsl frontend directory.
 * 
 * @author Julian Kranz
 */
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
    
    initializeNative();
  }

  /**
   * Checks whether this object identifies the other object. A
   * list frontend object identifies another object if it also is an
   * object of type {@link ListFrontend} and has got the same name
   * and file extension.
   * 
   * @param obj the object to check
   * @return a boolean indicating the result
   */
  @Deprecated public boolean identifies (Object obj) {
    if (!(obj instanceof ListFrontend))
      return false;
    ListFrontend other = (ListFrontend) obj;
    return getName().equals(other.getName()) && ext.equals(other.ext);
  }

  private void initializeNative () {
    setPointer(getFrontendPtrByDesc());
  }

  private native long getFrontendPtrByDesc ();

  @Override public String toString () {
    return getName() + "|" + ext;
  }
}
