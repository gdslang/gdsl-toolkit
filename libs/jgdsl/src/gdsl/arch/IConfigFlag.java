package gdsl.arch;

/**
 * This interfaces defines the interface for configuration
 * flags.
 * 
 * @author Julian Kranz
 * 
 */
public interface IConfigFlag {
  /**
   * The configuration of an architecture is represented by
   * an integer consisting of flags. This method returns an
   * integer with only the bit set that represents this
   * specific configuration flag.
   * 
   * @return the discussed integer
   */
  public long getFlag ();
}
