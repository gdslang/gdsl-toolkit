module gdsl.rreil.id.id;

abstract class Id {
  public abstract opCast(T: string)() const;
}