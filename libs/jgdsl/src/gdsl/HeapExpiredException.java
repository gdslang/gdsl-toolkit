package gdsl;

public class HeapExpiredException extends RuntimeException {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public HeapExpiredException () {
    super("Heap Expired");
  }

  public HeapExpiredException (String message) {
    super(message);
  }

  public HeapExpiredException (Throwable cause) {
    super(cause);
  }

  public HeapExpiredException (String message, Throwable cause) {
    super(message, cause);
  }
}
