package gdsl.arch;

public enum X86ConfigFlag implements IConfigFlag {
  MODE64(1),
  DefaultOpndSz32(2);

  private long flag;

  public long getFlag () {
    return flag;
  }

  private X86ConfigFlag (long flag) {
    this.flag = flag;
  }
}
