package gdsl.translator;

import gdsl.GdslException;

/**
 * This exception class is used for Gdsl errors during the semantic translation
 * of instructions.
 * 
 * @author Julian Kranz
 */
public class RReilTranslateException extends GdslException {

  private static final long serialVersionUID = 1L;

  public RReilTranslateException () {
  }

  public RReilTranslateException (String message) {
    super(message);
  }

  public RReilTranslateException (Throwable cause) {
    super(cause);
  }

  public RReilTranslateException (String message, Throwable cause) {
    super(message, cause);
  }
}
