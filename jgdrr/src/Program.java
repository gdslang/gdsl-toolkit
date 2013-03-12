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

		IRReilCollection c = n.decodeAndTranslate(new byte[] { 0x66, 0x0f, 0x38, 0x04, (byte)0xd1 });
//		IRReilCollection c = n.decodeAndTranslate(new byte[] { 0x66 });
//		IRReilCollection c = n.decodeAndTranslate(null);
		
		for (int i = 0; i < c.size(); i++) {
			System.out.println(c.get(i));
		}
	}
}
