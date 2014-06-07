module gdsl.rreil.id.arch_id;

import gdsl.rreil.id.id;

class ArchId : Id {
  private string _id;
  
  @property public string id() {
    return _id;
  }
  
  public this(string _id) {
    this._id = _id;
  }
  
  public override string toString() const {
    return _id;
  }
}

unittest {
  ArchId aid = new ArchId("A");
  assert(aid.toString == "A");
}