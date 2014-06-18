package gdsl;

/**
 * This interface specifies the methods required by object
 * to managed by a {@link ReferenceManager}.
 * 
 * @author Julian Kranz
 */
public interface IReferable {
  /**
   * Acknowledge a reference count of zero
   */
  public void free();
}
