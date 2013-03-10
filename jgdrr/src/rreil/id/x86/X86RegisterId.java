package rreil.id.x86;

import rreil.id.Id;

public class X86RegisterId extends Id {
	private X86Register register;
	
	public X86Register getRegister() {
		return register;
	}
	
	public X86RegisterId(X86Register register) {
		this.register = register;
	}
	
	@Override
	public String toString() {
		return register.toString();
	}
}
