package gdsl;

/**
 * This class is used to manage references to objects; after the reference
 * count drops to zero, certain resources can be free.
 * 
 * @author Julian Kranz
 */
public class ReferenceManager {
  private long references = 0;
  
  private IReferable referable;
  
  /**
   * Create a new object of type {@link ReferenceManager}.
   * 
   * @param referable the object that is managed by the reference
   * manager, i.e. the object that is notified whenever the
   * number of references drops to zero.
   */
  public ReferenceManager (IReferable referable) {
    this.referable = referable;
  }
  
  /**
   * Create a new object of type {@link ReferenceManager} and
   * initialize it with a given reference count
   * 
   * @param referable the managed object; see other constructor
   * @param references the initial reference count
   */
  public ReferenceManager (IReferable referable, long references) {
    this.referable = referable;
    this.references = references;
  }
  
  /**
   * Notify the reference manager of a new to reference to the
   * managed object.
   */
  public void ref() {
    this.references++;
  }
  
  /**
   * Notify the reference manager of a released reference to the managed
   * object; if this results a reference count of zero, the managed object
   * is notified.
   */
  public void unref() {
    this.references--;
    checkRef();
  }
  
  /**
   * Check the amount of references and notify the managed object it is
   * equal to zero; this method can be used to make sure that resources
   * are also released in the even that they are never referenced; in that
   * case the reference count never drops to zero but stays zero.
   */
  public void checkRef() {
    if(this.references == 0)
      referable.free();
  }
}
