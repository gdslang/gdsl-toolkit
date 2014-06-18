module gdsl.rreil.exception.shared_exception;

import gdsl.rreil.exception.exception;

enum SharedExceptionType : string {
  DivisionByZero = "DivisionByZero"
}

class SharedException : Exception_ {
  private SharedExceptionType _inner;
  
  @property public SharedExceptionType inner() {
    return _inner;
  }
  
  public this(SharedExceptionType inner) {
    this._inner = inner;
  }
  
  public override string toString() {
    return "Exception: " ~ cast(string)_inner;
  }
}

unittest {
  SharedException se = new SharedException(SharedExceptionType.DivisionByZero);
  assert(se.toString == "Exception: DivisionByZero");
}