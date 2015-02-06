package gdsl.arch;

/**
 * This enum lists all architectures currently supported
 * by Gdsl.
 * 
 * @author Julian Kranz
 */
public enum ArchId {
  X86, AVR, MIPS;

  private String name;

  private ArchId () {
    this.name = super.toString();
  }

  /**
   * Set the name of this architecture
   * 
   * @param name the new name of the architecture
   * @return this
   */
  public ArchId setName (String name) {
    this.name = name;

    return this;
  }

  /**
   * Get the name of the architecture
   * 
   * @return the name of the architecture
   */
  public String getName () {
    return name;
  }

  @Override public String toString () {
    return super.toString().toLowerCase();
  }
  
  public String libName() {
    return toString().toLowerCase() + "-rreil";
  }
}
