public class NativeInterface {
	public NativeInterface() {
		System.loadLibrary("jgdrr");
	}

	public RReilStatement[] decodeAndTranslate(byte[] bytes) {
		return (RReilStatement[]) decodeAndTranslateNative(bytes);
	}

	/*
	 * sem_linear
	 */

	private Object sem_lin_var(Object _this) {
		System.out.println("(j) sem_lin_var");
		return null;
	}

	private Object sem_lin_imm(Object imm) {
		System.out.println("(j) sem_lin_imm");
		return null;
	}

	private Object sem_lin_add(Object opnd1, Object opnd2) {
		System.out.println("(j) sem_lin_add");
		return null;
	}

	private Object sem_lin_sub(Object opnd1, Object opnd2) {
		System.out.println("(j) sem_lin_sub");
		return null;
	}

	private Object sem_lin_scale(Object imm, Object opnd) {
		System.out.println("(j) sem_lin_scale");
		return null;
	}

	/*
	 * sem_op
	 */

	private Object sem_lin(Object size, Object opnd1) {
		Long longSize = (Long) size;
		System.out.println("(j) sem_lin {size=" + longSize + "}");
		return null;
	}

	private Object sem_mul(Object size, Object opnd1, Object opnd2) {
		Long longSize = (Long) size;
		System.out.println("(j) sem_mul {size=" + longSize + "}");
		return null;
	}

	private Object sem_div(Object size, Object opnd1, Object opnd2) {
		Long longSize = (Long) size;
		System.out.println("(j) sem_div {size=" + longSize + "}");
		return null;
	}

	private Object sem_divs(Object size, Object opnd1, Object opnd2) {
		Long longSize = (Long) size;
		System.out.println("(j) sem_divs {size=" + longSize + "}");
		return null;
	}

	private Object sem_mod(Object size, Object opnd1, Object opnd2) {
		Long longSize = (Long) size;
		System.out.println("(j) sem_mod {size=" + longSize + "}");
		return null;
	}

	private Object sem_shl(Object size, Object opnd1, Object opnd2) {
		Long longSize = (Long) size;
		System.out.println("(j) sem_shl {size=" + longSize + "}");
		return null;
	}

	private Object sem_shr(Object size, Object opnd1, Object opnd2) {
		Long longSize = (Long) size;
		System.out.println("(j) sem_shr {size=" + longSize + "}");
		return null;
	}

	private Object sem_shrs(Object size, Object opnd1, Object opnd2) {
		Long longSize = (Long) size;
		System.out.println("(j) sem_shrs {size=" + longSize + "}");
		return null;
	}

	private Object sem_and(Object size, Object opnd1, Object opnd2) {
		Long longSize = (Long) size;
		System.out.println("(j) sem_and {size=" + longSize + "}");
		return null;
	}

	private Object sem_or(Object size, Object opnd1, Object opnd2) {
		Long longSize = (Long) size;
		System.out.println("(j) sem_or {size=" + longSize + "}");
		return null;
	}

	private Object sem_xor(Object size, Object opnd1, Object opnd2) {
		Long longSize = (Long) size;
		System.out.println("(j) sem_xor {size=" + longSize + "}");
		return null;
	}

	private Object sem_sx(Object size, Object fromsize, Object opnd1) {
		Long longSize = (Long) size;
		System.out.println("(j) sem_sx {size=" + longSize + "}");
		return null;
	}

	private Object sem_zx(Object size, Object fromsize, Object opnd1) {
		Long longSize = (Long) size;
		System.out.println("(j) sem_zx {size=" + longSize + "}");
		return null;
	}

	private Object sem_cmpeq(Object size, Object opnd1, Object opnd2) {
		Long longSize = (Long) size;
		System.out.println("(j) sem_cmpeq {size=" + longSize + "}");
		return null;
	}

	private Object sem_cmpneq(Object size, Object opnd1, Object opnd2) {
		Long longSize = (Long) size;
		System.out.println("(j) sem_cmpneq {size=" + longSize + "}");
		return null;
	}

	private Object sem_cmples(Object size, Object opnd1, Object opnd2) {
		Long longSize = (Long) size;
		System.out.println("(j) sem_cmples {size=" + longSize + "}");
		return null;
	}

	private Object sem_cmpleu(Object size, Object opnd1, Object opnd2) {
		Long longSize = (Long) size;
		System.out.println("(j) sem_cmpleu {size=" + longSize + "}");
		return null;
	}

	private Object sem_cmplts(Object size, Object opnd1, Object opnd2) {
		Long longSize = (Long) size;
		System.out.println("(j) sem_cmplts {size=" + longSize + "}");
		return null;
	}

	private Object sem_cmpltu(Object size, Object opnd1, Object opnd2) {
		Long longSize = (Long) size;
		System.out.println("(j) sem_cmpltu {size=" + longSize + "}");
		return null;
	}

	private Object sem_arb(Object size) {
		Long longSize = (Long) size;
		System.out.println("(j) sem_arb {size=" + longSize + "}");
		return null;
	}

	/*
	 * sem_branch_hint
	 */

	private Object hint_jump() {
		System.out.println("(j) hint_jump");
		return null;
	}

	private Object hint_call() {
		System.out.println("(j) hint_call");
		return null;
	}

	private Object hint_ret() {
		System.out.println("(j) hint_ret");
		return null;
	}

	/*
	 * sem_stmt
	 */

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

	private Object sem_cbranch(Object cond, Object target_true,
			Object target_false) {
		System.out.println("(j) sem_cbranch");
		return null;
	}

	private Object sem_branch(Object branch_hint, Object target) {
		System.out.println("(j) sem_branch");
		return null;
	}

	private native Object decodeAndTranslateNative(byte[] bytes);
}
