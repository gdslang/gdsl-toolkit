package rreil;

import rreil.statement.IStatement;

public interface IRReilCollection {
	void add(IStatement s);
	
	IStatement get(int i);
	
	int size();
}
