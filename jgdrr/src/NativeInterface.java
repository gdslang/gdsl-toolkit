
public class NativeInterface {
	public NativeInterface() {
		System.loadLibrary("jgdrr");
	}
	
	public RReilStatement[] decodeAndTranslate(byte[] bytes) {
		return (RReilStatement[])decodeAndTranslateNative(bytes);
	}
	
	private Object sem_assign(Object lhs, Object rhs) {
		System.out.println("(j) sem_assign");
		return null;
	}
	
	private Object sem_load(Object lhs, Object size, Object address) {
		System.out.println("(j) sem_load");
		return null;
	}
	
	private Object sem_store(Object lhs, Object rhs) {
		System.out.println("(j) sem_store");
		return null;
	}
	
	private Object sem_ite(Object cond, Object then_branch, Object else_branch) {
		System.out.println("(j) sem_ite");
		return null;
	}
	
	private Object sem_while(Object cond, Object body) {
		System.out.println("(j) sem_while");
		return null;
	}
	
	private Object sem_cbranch(Object cond, Object target_true, Object target_false) {
		System.out.println("(j) sem_cbranch");
		return null;
	}
	
	private Object sem_branch(Object branch_hint, Object target) {
		System.out.println("(j) sem_branch");
		return null;
	}
	
	private native Object decodeAndTranslateNative(byte[] bytes);
}
