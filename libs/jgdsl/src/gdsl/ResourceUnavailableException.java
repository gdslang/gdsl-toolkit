package gdsl;

public class ResourceUnavailableException extends RuntimeException {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public ResourceUnavailableException () {
    super("Resource Destroyed");
  }

  public ResourceUnavailableException (String message) {
    super(message);
  }

  public ResourceUnavailableException (Throwable cause) {
    super(cause);
  }

  public ResourceUnavailableException (String message, Throwable cause) {
    super(message, cause);
  }

  public ResourceUnavailableException (String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

}
