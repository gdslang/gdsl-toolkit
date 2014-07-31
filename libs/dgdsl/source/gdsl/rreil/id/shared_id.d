module gdsl.rreil.id.shared_id;

import gdsl.rreil.id.id;

enum SharedIdType : string {
  FloatingFlags = "FloatingFlags"
}

class SharedId : Id {
  private SharedIdType _inner;
  
  @property public SharedIdType inner() {
    return _inner;
  }
  
  public this(SharedIdType _inner) {
    this._inner = _inner;
  }
  
  public override string toString() const {
    return cast(string)_inner;
  }
}

unittest {
  SharedId sid = new SharedId(SharedIdType.FloatingFlags);
  assert(sid.toString == "FloatingFlags");
}