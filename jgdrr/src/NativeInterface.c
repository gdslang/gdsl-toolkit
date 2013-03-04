#include <jni.h>
#include <stdio.h>
#include <stdlib.h>
#include <dis.h>
#include <gdrr.h>

//gcc -std=c99 -fPIC -shared -Wl,-soname,libjgdrr.so -I/usr/lib/jvm/java-6-openjdk-amd64/include -I../.. -I../../include ../../dis.o -o ../bin/libjgdrr.so NativeInterface.c ../../gdrr/Debug/libgdrr.a
//echo "48 83 ec 08" | java -Djava.library.path=. Program

struct closure {
	JNIEnv *env;
	jobject obj;
};

static jobject java_method_call(void *closure, char *name, int numargs, ...) {
	if(numargs > 3)
		return NULL; //Todo: Handle error

	struct closure *cls = (struct closure*)closure;

	jclass class = (*cls->env)->GetObjectClass(cls->env, cls->obj);

	char *signature;
	switch(numargs) {
		case 0: {
			signature = "()Ljava/lang/Object;";
			break;
		}
		case 1: {
			signature = "(Ljava/lang/Object;)Ljava/lang/Object;";
			break;
		}
		case 2: {
			signature = "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;";
			break;
		}
		case 3: {
			signature =
					"(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;";
			break;
		}
	}
	jmethodID mid = (*cls->env)->GetMethodID(cls->env, class, name, signature);

	jobject args[numargs];

	va_list list;
	va_start(list, numargs);
	for(int i = 0; i < numargs; ++i)
		args[i] = va_arg(list, jobject);
	va_end(list);

	jobject ret;
	switch(numargs) {
		case 0: {
			ret = (*cls->env)->CallObjectMethod(cls->env, cls->obj, mid);
			break;
		}
		case 1: {
			ret = (*cls->env)->CallObjectMethod(cls->env, cls->obj, mid, args[0]);
			break;
		}
		case 2: {
			ret = (*cls->env)->CallObjectMethod(cls->env, cls->obj, mid, args[0],
					args[1]);
			break;
		}
		case 3: {
			ret = (*cls->env)->CallObjectMethod(cls->env, cls->obj, mid, args[0],
					args[1], args[2]);
			break;
		}
	}

	return ret;
}

// sem_id
static gdrr_sem_id_t *virt_eq(void *closure) {
	printf("=> virt_eq\n");
	return NULL;
}
static gdrr_sem_id_t *virt_neq(void *closure) {
	printf("=> virt_neq\n");
	return NULL;
}
static gdrr_sem_id_t *virt_les(void *closure) {
	printf("=> virt_les\n");
	return NULL;
}
static gdrr_sem_id_t *virt_leu(void *closure) {
	printf("=> virt_leu\n");
	return NULL;
}
static gdrr_sem_id_t *virt_lts(void *closure) {
	printf("=> virt_lts\n");
	return NULL;
}
static gdrr_sem_id_t *virt_ltu(void *closure) {
	printf("=> virt_ltu\n");
	return NULL;
}
static gdrr_sem_id_t *virt_t(void *closure, __word t) {
	printf("=> id {t=%lu}\n", t);
	return NULL;
}

// sem_address
static gdrr_sem_address_t *sem_address(void *closure, __word size,
		gdrr_sem_linear_t *address) {
	printf("==> sem_address {size=%lu}\n", size);
	return NULL;
}

// sem_var
static gdrr_sem_var_t *sem_var(void *closure, gdrr_sem_id_t *id, __word offset) {
	printf("==> var {offset=%lu}\n", offset);
	return NULL;
}

// sem_linear
static gdrr_sem_linear_t *sem_lin_var(void *closure, gdrr_sem_var_t *this) {
	printf("==> sem_lin_var\n");
	return NULL;
}
static gdrr_sem_linear_t *sem_lin_imm(void *closure, __word imm) {
	printf("==> sem_lin_imm {imm=%lu}\n", imm);
	return NULL;
}
static gdrr_sem_linear_t *sem_lin_add(void *closure, gdrr_sem_linear_t *opnd1,
		gdrr_sem_linear_t *opnd2) {
	printf("==> sem_lin_add\n");
	return NULL;
}
static gdrr_sem_linear_t *sem_lin_sub(void *closure, gdrr_sem_linear_t *opnd1,
		gdrr_sem_linear_t *opnd2) {
	printf("==> sem_lin_sub\n");
	return NULL;
}
static gdrr_sem_linear_t *sem_lin_scale(void *closure, __word imm,
		gdrr_sem_linear_t *opnd) {
	printf("==> sem_lin_scale {imm=%lu}\n", imm);
	return NULL;
}

// sem_op
static gdrr_sem_op_t *sem_lin(void *closure, __word size,
		gdrr_sem_linear_t *opnd1) {
	printf("=> lin {size=%lu}\n", size);
	return NULL;
}
static gdrr_sem_op_t *sem_mul(void *closure, __word size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	printf("=> mul {size=%lu}\n", size);
	return NULL;
}
static gdrr_sem_op_t *sem_div(void *closure, __word size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	printf("=> div {size=%lu}\n", size);
	return NULL;
}
static gdrr_sem_op_t *sem_divs(void *closure, __word size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	printf("=> divs {size=%lu}\n", size);
	return NULL;
}
static gdrr_sem_op_t *sem_mod(void *closure, __word size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	printf("=> mod {size=%lu}\n", size);
	return NULL;
}
static gdrr_sem_op_t *sem_shl(void *closure, __word size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	printf("=> shl {size=%lu}\n", size);
	return NULL;
}
static gdrr_sem_op_t *sem_shr(void *closure, __word size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	printf("=> shr {size=%lu}\n", size);
	return NULL;
}
static gdrr_sem_op_t *sem_shrs(void *closure, __word size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	printf("=> shrs {size=%lu}\n", size);
	return NULL;
}
static gdrr_sem_op_t *sem_and(void *closure, __word size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	printf("=> and {size=%lu}\n", size);
	return NULL;
}
static gdrr_sem_op_t *sem_or(void *closure, __word size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	printf("=> or {size=%lu}\n", size);
	return NULL;
}
static gdrr_sem_op_t *sem_xor(void *closure, __word size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	printf("=> xor {size=%lu}\n", size);
	return NULL;
}
static gdrr_sem_op_t *sem_sx(void *closure, __word size, __word fromsize,
		gdrr_sem_linear_t *opnd1) {
	printf("=> sx {size=%lu, fromsize=%lu}\n", size, fromsize);
	return NULL;
}
static gdrr_sem_op_t *sem_zx(void *closure, __word size, __word fromsize,
		gdrr_sem_linear_t *opnd1) {
	printf("=> zx {size=%lu, fromsize=%lu}\n", size, fromsize);
	return NULL;
}
static gdrr_sem_op_t *sem_cmpeq(void *closure, __word size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	printf("=> cmpeq {size=%lu}\n", size);
	return NULL;
}
static gdrr_sem_op_t *sem_cmpneq(void *closure, __word size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	printf("=> cmpneq {size=%lu}\n", size);
	return NULL;
}
static gdrr_sem_op_t *sem_cmples(void *closure, __word size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	printf("=> cmples {size=%lu}\n", size);
	return NULL;
}
static gdrr_sem_op_t *sem_cmpleu(void *closure, __word size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	printf("=> cmpleu {size=%lu}\n", size);
	return NULL;
}
static gdrr_sem_op_t *sem_cmplts(void *closure, __word size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	printf("=> cmplts {size=%lu}\n", size);
	return NULL;
}
static gdrr_sem_op_t *sem_cmpltu(void *closure, __word size,
		gdrr_sem_linear_t *opnd1, gdrr_sem_linear_t *opnd2) {
	printf("=> cmpltu {size=%lu}\n", size);
	return NULL;
}
static gdrr_sem_op_t *sem_arb(void *closure, __word size) {
	printf("=> arb {size=%lu}\n", size);
	return NULL;
}

// sem_branch_hint
static gdrr_sem_branch_hint *hint_jump(void *closure) {
	printf("==> branch_hint_jump\n");
	return NULL;
}
static gdrr_sem_branch_hint *hint_call(void *closure) {
	printf("==> branch_hint_call\n");
	return NULL;
}
static gdrr_sem_branch_hint *hint_ret(void *closure) {
	printf("==> branch_hint_ret\n");
	return NULL;
}

// sem_stmt
static gdrr_sem_stmt_t *sem_assign(void *closure, gdrr_sem_var_t *lhs,
		gdrr_sem_op_t *rhs) {
	jobject ret = java_method_call(closure, "sem_assign", 2, (jobject)lhs,
			(jobject)rhs);
	return (gdrr_sem_stmt_t*)ret;
}
static gdrr_sem_stmt_t *sem_load(void *closure, gdrr_sem_var_t *lhs,
		__word size, gdrr_sem_address_t *address) {
	jobject ret = java_method_call(closure, "sem_load", 3, (jobject)lhs,
			(jobject)size, (jobject)address);
	return (gdrr_sem_stmt_t*)ret;
}
static gdrr_sem_stmt_t *sem_store(void *closure, gdrr_sem_var_t *lhs,
		gdrr_sem_op_t *rhs) {
	jobject ret = java_method_call(closure, "sem_store", 2, (jobject)lhs,
			(jobject)rhs);
	return (gdrr_sem_stmt_t*)ret;
}
static gdrr_sem_stmt_t *sem_ite(void *closure, gdrr_sem_linear_t *cond,
		gdrr_sem_stmts_t *then_branch, gdrr_sem_stmts_t *else_branch) {
	jobject ret = java_method_call(closure, "sem_ite", 3, (jobject)cond,
			(jobject)then_branch, (jobject)else_branch);
	return (gdrr_sem_stmt_t*)ret;
}
static gdrr_sem_stmt_t *sem_while(void *closure, gdrr_sem_linear_t *cond,
		gdrr_sem_stmts_t *body) {
	jobject ret = java_method_call(closure, "sem_while", 2, (jobject)cond,
			(jobject)body);
	return (gdrr_sem_stmt_t*)ret;
}
static gdrr_sem_stmt_t *sem_cbranch(void *closure, gdrr_sem_linear_t *cond,
		gdrr_sem_address_t *target_true, gdrr_sem_address_t *target_false) {
	jobject ret = java_method_call(closure, "sem_cbranch", 3, (jobject)cond,
			(jobject)target_true, (jobject)target_false);
	return (gdrr_sem_stmt_t*)ret;
}
static gdrr_sem_stmt_t *sem_branch(void *closure,
		gdrr_sem_branch_hint *branch_hint, gdrr_sem_address_t *target) {
	jobject ret = java_method_call(closure, "sem_branch", 2, (jobject)branch_hint,
			(jobject)target);
	return (gdrr_sem_stmt_t*)ret;
}

// sem_stmts
static gdrr_sem_stmts_t *list_next(void *closure, gdrr_sem_stmt_t *next,
		gdrr_sem_stmts_t *list) {
	printf("next statement\n\n");
	return NULL;
}
static gdrr_sem_stmts_t *list_init(void *closure) {
	printf("init\n");
	return NULL;
}

JNIEXPORT jobject JNICALL Java_NativeInterface_decodeAndTranslateNative(
		JNIEnv *env, jobject obj, jbyteArray input) {
	__char blob[15];
	char fmt[1024];
	__word sz = 15;
	__obj insn;
	int i, c;
	for(i = 0; i < sz; i++) {
		int x = fscanf(stdin, "%x", &c);
		switch(x) {
			case EOF:
				goto done;
			case 0:
				__fatal("invalid input; should be in hex form: '0f 0b ..'");
		}
		blob[i] = c & 0xff;
	}
	done: __decode(__decode__, blob, i, &insn);
	if(___isNil(insn))
		__fatal("decode failed");
	else {
		__pretty(__pretty__, insn, fmt, 1024);
		puts(fmt);

		printf("---------------------------\n");

		__obj r = __translate(__translate__, insn);
		if(___isNil(r))
			__fatal("translate failed");
		else {
			__pretty(__rreil_pretty__, r, fmt, 1024);
			puts(fmt);

			struct gdrr_config config;

			config.callbacks.sem_id.virt_eq = &virt_eq;
			config.callbacks.sem_id.virt_neq = &virt_neq;
			config.callbacks.sem_id.virt_les = &virt_les;
			config.callbacks.sem_id.virt_leu = &virt_leu;
			config.callbacks.sem_id.virt_lts = &virt_lts;
			config.callbacks.sem_id.virt_ltu = &virt_ltu;
			config.callbacks.sem_id.virt_t = &virt_t;

			config.callbacks.sem_address.sem_address = &sem_address;

			config.callbacks.sem_var.sem_var = &sem_var;

			config.callbacks.sem_linear.sem_lin_var = &sem_lin_var;
			config.callbacks.sem_linear.sem_lin_imm = &sem_lin_imm;
			config.callbacks.sem_linear.sem_lin_add = &sem_lin_add;
			config.callbacks.sem_linear.sem_lin_sub = &sem_lin_sub;
			config.callbacks.sem_linear.sem_lin_scale = &sem_lin_scale;

			config.callbacks.sem_op.sem_lin = &sem_lin;
			config.callbacks.sem_op.sem_mul = &sem_mul;
			config.callbacks.sem_op.sem_div = &sem_div;
			config.callbacks.sem_op.sem_divs = &sem_divs;
			config.callbacks.sem_op.sem_mod = &sem_mod;
			config.callbacks.sem_op.sem_shl = &sem_shl;
			config.callbacks.sem_op.sem_shr = &sem_shr;
			config.callbacks.sem_op.sem_shrs = &sem_shrs;
			config.callbacks.sem_op.sem_and = &sem_and;
			config.callbacks.sem_op.sem_or = &sem_or;
			config.callbacks.sem_op.sem_xor = &sem_xor;
			config.callbacks.sem_op.sem_sx = &sem_sx;
			config.callbacks.sem_op.sem_zx = &sem_zx;
			config.callbacks.sem_op.sem_cmpeq = &sem_cmpeq;
			config.callbacks.sem_op.sem_cmpneq = &sem_cmpneq;
			config.callbacks.sem_op.sem_cmples = &sem_cmples;
			config.callbacks.sem_op.sem_cmpleu = &sem_cmpleu;
			config.callbacks.sem_op.sem_cmplts = &sem_cmplts;
			config.callbacks.sem_op.sem_cmpltu = &sem_cmpltu;
			config.callbacks.sem_op.sem_arb = &sem_arb;

			config.callbacks.sem_branch_hint.hint_jump = &hint_jump;
			config.callbacks.sem_branch_hint.hint_call = &hint_call;
			config.callbacks.sem_branch_hint.hint_ret = &hint_ret;

			config.callbacks.sem_stmt.sem_assign = &sem_assign;
			config.callbacks.sem_stmt.sem_load = &sem_load;
			config.callbacks.sem_stmt.sem_store = &sem_store;
			config.callbacks.sem_stmt.sem_ite = &sem_ite;
			config.callbacks.sem_stmt.sem_while = &sem_while;
			config.callbacks.sem_stmt.sem_cbranch = &sem_cbranch;
			config.callbacks.sem_stmt.sem_branch = &sem_branch;

			config.callbacks.sem_stmts_list.list_init = &list_init;
			config.callbacks.sem_stmts_list.list_next = &list_next;
			config.gdrr_config_stmts_handling = GDRR_CONFIG_STMTS_HANDLING_LIST;

			struct closure cls;
			cls.env = env;
			cls.obj = obj;
			config.closure = &cls;

			gdrr_convert(r, &config);
		}
	}

}
