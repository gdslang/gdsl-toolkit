package rreil.statement;

import rreil.exception.IException;

public class ThrowStatement extends Statement {
	private rreil.exception.IException exception;
	
	public rreil.exception.IException getException() {
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
