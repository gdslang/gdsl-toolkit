package gdsl.rreil.exception;

import gdsl.rreil.exception.IException;

public class GenericArchException implements IException {
  private String ex;

  public GenericArchException (String ex) {
    this.ex = ex;
  }

  @Override public String toString () {
    return "[Arch Exception " + ex + "]";
  }
}
