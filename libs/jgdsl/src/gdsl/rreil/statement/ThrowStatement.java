package gdsl.rreil.statement;

import gdsl.rreil.exception.IException;
import gdsl.rreil.statement.Statement;

public class ThrowStatement extends Statement {
	private gdsl.rreil.exception.IException exception;
	
	public gdsl.rreil.exception.IException getException() {
		return exception;
	}
	
	public ThrowStatement(IException exception) {
		this.exception = exception;
	}
	
	@Override
	public String toString() {
		return "throw " + exception;
	}
}
