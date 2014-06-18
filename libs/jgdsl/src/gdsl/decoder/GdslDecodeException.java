package gdsl.decoder;

import gdsl.GdslException;

/**
 * This exception class is used for Gdsl errors during the decoding
 * of instructions.
 * 
 * @author Julian Kranz
 */
public class GdslDecodeException extends GdslException {

  private static final long serialVersionUID = 1L;

  public GdslDecodeException () {
  }

  public GdslDecodeException (String message) {
    super(message);
  }

  public GdslDecodeException (Throwable cause) {
    super(cause);
  }

  public GdslDecodeException (String message, Throwable cause) {
    super(message, cause);
  }
}
