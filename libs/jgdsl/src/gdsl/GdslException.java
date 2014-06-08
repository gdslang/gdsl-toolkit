package gdsl;

/**
 * The GdslException class is the base class for all Gdsl specific
 * exceptions.
 * 
 * @author Julian Kranz
 * 
 */
public class GdslException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public GdslException () {
  }

  public GdslException (String message) {
    super(message);
  }

  public GdslException (Throwable cause) {
    super(cause);
  }

  public GdslException (String message, Throwable cause) {
    super(message, cause);
  }

}
