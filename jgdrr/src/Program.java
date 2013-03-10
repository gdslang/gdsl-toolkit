import rnati.*;
import rreil.DefaultRReilBuilder;
import rreil.IRReilCollection;

public class Program {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DefaultRReilBuilder builder = new DefaultRReilBuilder();
		
		NativeInterface n = new NativeInterface(builder);

		IRReilCollection c = n.decodeAndTranslate(null);
		
		for (int i = 0; i < c.size(); i++) {
			System.out.println(c.get(i));
		}
	}
}
