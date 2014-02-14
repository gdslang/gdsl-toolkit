package gdsl.decoder;

import gdsl.GdslException;

public class GdslDecodeException extends GdslException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GdslDecodeException() {
	}

	public GdslDecodeException(String message) {
		super(message);
	}

	public GdslDecodeException(Throwable cause) {
		super(cause);
	}

	public GdslDecodeException(String message, Throwable cause) {
		super(message, cause);
	}

}
