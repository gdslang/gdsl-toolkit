package gdsl.rreil.id;

import gdsl.rreil.id.Id;

public class VirtualTemporaryId extends Id {
  protected long id;
  
  protected boolean opt;

  public long getId () {
    return id;
  }
  
  public boolean getOpt () {
    return opt;
  }

  public VirtualTemporaryId (long id, boolean opt) {
    this.id = id;
    this.opt = opt;
  }

  @Override public String toString () {
    return (opt ? "o" : "t") + id;
  }
}
