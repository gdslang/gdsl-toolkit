package gdsl.rreil;

public interface IRReilCollection<T> {
	void add(T s);
	
	T get(int i);
	
	int size();
}
