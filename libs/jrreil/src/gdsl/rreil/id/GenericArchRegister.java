package gdsl.rreil.id;

import gdsl.rreil.id.Id;

public class GenericArchRegister extends Id {
	private long id;
	
	public GenericArchRegister(long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "[Arch " + id + "]";
	}
}
