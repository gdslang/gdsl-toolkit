package rreil.exception;

public class GenericArchException implements IException {
	private long con;
	
	public GenericArchException(long con) {
		this.con = con;
	}
	
	@Override
	public String toString() {
		return "[Arch Exception " + con + "]";
	}
}
