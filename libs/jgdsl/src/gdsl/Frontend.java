package gdsl;

public class Frontend {
  private final String name;
  private final String ext;

  public String getName () {
    return name;
  }

  public String getExt () {
    return ext;
  }

  public Frontend (String name, String ext) {
    super();
    this.name = name;
    this.ext = ext;
  }

  @Override public String toString () {
    return name + "|" + ext;
  }

  @Override public boolean equals (Object obj) {
    if (!(obj instanceof Frontend))
      return false;
    Frontend other = (Frontend) obj;
    return name.equals(other.name) && ext.equals(other.ext);
  }
}
