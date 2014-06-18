module gdsl.rreil.exception.arch_exception;

import gdsl.rreil.exception.exception;

class ArchException : Exception_ {
  private string _name;
  
  @property public string name() {
    return _name;
  }
  
  public this(string name) {
    this._name = name;
  }
  
  public override string toString() {
    return "Exception: " ~ name;
  }
}

unittest {
  ArchException ae = new ArchException("SomeVeryBadThingHappened");
  assert(ae.toString == "Exception: SomeVeryBadThingHappened");
}