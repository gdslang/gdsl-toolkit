module gdsl.rreil.id.id;

abstract class Id {
  public abstract override string toString() const;
}

unittest {
  import gdsl.rreil.id.virt_id;
  
  Id id = new VirtId(42);
  assert(id.toString == "t42");
}