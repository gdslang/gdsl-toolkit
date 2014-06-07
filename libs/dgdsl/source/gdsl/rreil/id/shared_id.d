module gdsl.rreil.id.shared_id;

import gdsl.rreil.id.id;

enum SharedIdType {
  FLOATING_FLAGS
}

class SharedId : Id {
  private SharedIdType _inner;
  
  @property public SharedIdType inner() {
    return _inner;
  }
  
  public this(SharedIdType _inner) {
    this._inner = _inner;
  }
  
  public override string opCast(T : string)() const {
    return _inner.stringof;
  }
}