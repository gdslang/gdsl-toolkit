package rreil.statement;

import rreil.prim.IPrim;

public class PrimitiveStatement extends Statement implements IPrim {
	private IPrim primitive;
	
	public IPrim getPrimitive() {
		return primitive;
	}
	
	public PrimitiveStatement(IPrim primitive) {
		this.primitive = primitive;
	}
	
	@Override
	public String toString() {
		return primitive.toString();
	}
}
