package gdsl.rreil.id.x86;

import gdsl.rreil.id.Id;
import gdsl.rreil.id.x86.X86Register;

public class X86RegisterId extends Id {
  private X86Register register;

  public X86Register getRegister () {
    return register;
  }

  public X86RegisterId (X86Register register) {
    this.register = register;
  }

  @Override public String toString () {
    return register.toString();
  }
}
