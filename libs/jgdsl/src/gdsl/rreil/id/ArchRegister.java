package gdsl.rreil.id;

public class ArchRegister extends Id {
  private String name;
  
  public String getName () {
    return name;
  }
  
  public ArchRegister (String name) {
    this.name = name;
  }
  
  @Override public String toString () {
    return name;
  }
}
