package gdsl.arch;

/**
 * This class implements the IConfigFlag interface for
 * the X86 architecture.
 * 
 * @author Julian Kranz
 */
public enum X86ConfigFlag implements IConfigFlag {
  MODE32(1),
  DefaultOpndSz16(2);

  private long flag;

  @Override public long getFlag () {
    return flag;
  }

  private X86ConfigFlag (long flag) {
    this.flag = flag;
  }
}
