
public class NativeInterface {
	public NativeInterface() {
		System.loadLibrary("jgdrr");
	}
	
	public RReilStatement[] decodeAndTranslate(byte[] bytes) {
		return (RReilStatement[])decodeAndTranslateNative(bytes);
	}
	
	private Object assign(Object p) {
		System.out.println("assign - but in Java :-)");
		
		return null;
	}
	
	private native Object decodeAndTranslateNative(byte[] bytes);
}
