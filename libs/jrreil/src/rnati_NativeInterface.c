#include <jni.h>
#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <gdsl.h>
#include <gdsl_multiplex.h>
#include "rnati_NativeInterface.h"

//gcc -std=c99 -fPIC -shared -Wl,-soname,libjgdrr.so -I/usr/lib/jvm/java-6-openjdk-amd64/include -I/usr/lib/jvm/java-7-openjdk-amd64/include -I../.. -I../../include -o ../bin/libjgdrr.so rnati_NativeInterface.c ../../gdrr/Debug/libgdrr.a -L../../lib -lgdsl-x86 -lavcall
//echo "48 83 ec 08" | java -ss134217728 -Djava.library.path=. Program

struct userdata {
	JNIEnv *env;
	jobject obj;
};

static jobject java_method_call(state_t state, char *name, int numargs, ...) {
	if(numargs > 4)
		return NULL; //Todo: Handle error

	struct userdata *ud = (struct userdata*)gdsl_rreil_cif_userdata_get(state);

	jclass class = (*ud->env)->GetObjectClass(ud->env, ud->obj);

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
			signature = "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;";
			break;
		}
		case 4: {
			signature = "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;";
			break;
		}
	}
	jmethodID mid = (*ud->env)->GetMethodID(ud->env, class, name, signature);

	jobject args[numargs];

	va_list list;
	va_start(list, numargs);
	for(int i = 0; i < numargs; ++i)
		args[i] = va_arg(list, jobject);
	va_end(list);

	jobject ret;
	switch(numargs) {
		case 0: {
			ret = (*ud->env)->CallObjectMethod(ud->env, ud->obj, mid);
			break;
		}
		case 1: {
			ret = (*ud->env)->CallObjectMethod(ud->env, ud->obj, mid, args[0]);
			break;
		}
		case 2: {
			ret = (*ud->env)->CallObjectMethod(ud->env, ud->obj, mid, args[0], args[1]);
			break;
		}
		case 3: {
			ret = (*ud->env)->CallObjectMethod(ud->env, ud->obj, mid, args[0], args[1], args[2]);
			break;
		}
		case 4: {
			ret = (*ud->env)->CallObjectMethod(ud->env, ud->obj, mid, args[0], args[1], args[2], args[3]);
			break;
		}
	}

	return ret;
}

static jobject java_long_create(state_t state, long int x) {
	struct userdata *ud = (struct userdata*)gdsl_rreil_cif_userdata_get(state);

	jclass class = (*ud->env)->FindClass(ud->env, "java/lang/Long");
	jmethodID method_id = (*ud->env)->GetMethodID(ud->env, class, "<init>", "(J)V");
	jobject a = (*ud->env)->NewObject(ud->env, class, method_id, x);

	return a;
}

static jstring java_string_create(state_t state, char *x) {
	struct userdata *ud = (struct userdata*)gdsl_rreil_cif_userdata_get(state);
	jstring str = (*ud->env)->NewStringUTF(ud->env, x);
	return str;
}

// sem_id
static obj_t shared(state_t state, int_t con) {
	jobject ret = NULL;
	switch (con) {
		case CON_FLOATING_FLAGS: {
			ret = java_method_call(state, "shared_floating_flags", 0);
			break;
		}
	}
	return (obj_t)ret;
}

//static obj_t virt_na(state_t state, int_t con) {
//	jobject ret;
//	switch(con) {
//		case CON_VIRT_EQ: {
//			ret = java_method_call(state, "virt_eq", 0);
//			break;
//		}
//		case CON_VIRT_NEQ: {
//			ret = java_method_call(state, "virt_neq", 0);
//			break;
//		}
//		case CON_VIRT_LES: {
//			ret = java_method_call(state, "virt_les", 0);
//			break;
//		}
//		case CON_VIRT_LEU: {
//			ret = java_method_call(state, "virt_leu", 0);
//			break;
//		}
//		case CON_VIRT_LTS: {
//			ret = java_method_call(state, "virt_lts", 0);
//			break;
//		}
//		case CON_VIRT_LTU: {
//			ret = java_method_call(state, "virt_ltu", 0);
//			break;
//		}
//	}
//	return (obj_t)ret;
//}
static obj_t virt_t(state_t state, int_t t) {
	jobject ret = java_method_call(state, "virt_t", 1, java_long_create(state, (long int)t));
	return (obj_t)ret;
}

#ifdef GDSL_X86
static obj_t arch(state_t state, int_t con) {
	jobject ret;
	switch(con) {
		case CON_Sem_IP: {
			ret = java_method_call(state, "sem_ip", 0);
			break;
		}
		case CON_Sem_FLAGS: {
			ret = java_method_call(state, "sem_flags", 0);
			break;
		}
		case CON_Sem_MXCSR: {
			ret = java_method_call(state, "sem_mxcsr", 0);
			break;
		}
		case CON_Sem_AX: {
			ret = java_method_call(state, "sem_ax", 0);
			break;
		}
		case CON_Sem_BX: {
			ret = java_method_call(state, "sem_bx", 0);
			break;
		}
		case CON_Sem_CX: {
			ret = java_method_call(state, "sem_cx", 0);
			break;
		}
		case CON_Sem_DX: {
			ret = java_method_call(state, "sem_dx", 0);
			break;
		}
		case CON_Sem_SI: {
			ret = java_method_call(state, "sem_si", 0);
			break;
		}
		case CON_Sem_DI: {
			ret = java_method_call(state, "sem_di", 0);
			break;
		}
		case CON_Sem_SP: {
			ret = java_method_call(state, "sem_sp", 0);
			break;
		}
		case CON_Sem_BP: {
			ret = java_method_call(state, "sem_bp", 0);
			break;
		}
		case CON_Sem_R8: {
			ret = java_method_call(state, "sem_r8", 0);
			break;
		}
		case CON_Sem_R9: {
			ret = java_method_call(state, "sem_r9", 0);
			break;
		}
		case CON_Sem_R10: {
			ret = java_method_call(state, "sem_r10", 0);
			break;
		}
		case CON_Sem_R11: {
			ret = java_method_call(state, "sem_r11", 0);
			break;
		}
		case CON_Sem_R12: {
			ret = java_method_call(state, "sem_r12", 0);
			break;
		}
		case CON_Sem_R13: {
			ret = java_method_call(state, "sem_r13", 0);
			break;
		}
		case CON_Sem_R14: {
			ret = java_method_call(state, "sem_r14", 0);
			break;
		}
		case CON_Sem_R15: {
			ret = java_method_call(state, "sem_r15", 0);
			break;
		}
		case CON_Sem_CS: {
			ret = java_method_call(state, "sem_cs", 0);
			break;
		}
		case CON_Sem_DS: {
			ret = java_method_call(state, "sem_ds", 0);
			break;
		}
		case CON_Sem_SS: {
			ret = java_method_call(state, "sem_ss", 0);
			break;
		}
		case CON_Sem_ES: {
			ret = java_method_call(state, "sem_es", 0);
			break;
		}
		case CON_Sem_FS: {
			ret = java_method_call(state, "sem_fs", 0);
			break;
		}
		case CON_Sem_GS: {
			ret = java_method_call(state, "sem_gs", 0);
			break;
		}
		case CON_Sem_ST0: {
			ret = java_method_call(state, "sem_st0", 0);
			break;
		}
		case CON_Sem_ST1: {
			ret = java_method_call(state, "sem_st1", 0);
			break;
		}
		case CON_Sem_ST2: {
			ret = java_method_call(state, "sem_st2", 0);
			break;
		}
		case CON_Sem_ST3: {
			ret = java_method_call(state, "sem_st3", 0);
			break;
		}
		case CON_Sem_ST4: {
			ret = java_method_call(state, "sem_st4", 0);
			break;
		}
		case CON_Sem_ST5: {
			ret = java_method_call(state, "sem_st5", 0);
			break;
		}
		case CON_Sem_ST6: {
			ret = java_method_call(state, "sem_st6", 0);
			break;
		}
		case CON_Sem_ST7: {
			ret = java_method_call(state, "sem_st7", 0);
			break;
		}
		case CON_Sem_MM0: {
			ret = java_method_call(state, "sem_mm0", 0);
			break;
		}
		case CON_Sem_MM1: {
			ret = java_method_call(state, "sem_mm1", 0);
			break;
		}
		case CON_Sem_MM2: {
			ret = java_method_call(state, "sem_mm2", 0);
			break;
		}
		case CON_Sem_MM3: {
			ret = java_method_call(state, "sem_mm3", 0);
			break;
		}
		case CON_Sem_MM4: {
			ret = java_method_call(state, "sem_mm4", 0);
			break;
		}
		case CON_Sem_MM5: {
			ret = java_method_call(state, "sem_mm5", 0);
			break;
		}
		case CON_Sem_MM6: {
			ret = java_method_call(state, "sem_mm6", 0);
			break;
		}
		case CON_Sem_MM7: {
			ret = java_method_call(state, "sem_mm7", 0);
			break;
		}
		case CON_Sem_XMM0: {
			ret = java_method_call(state, "sem_xmm0", 0);
			break;
		}
		case CON_Sem_XMM1: {
			ret = java_method_call(state, "sem_xmm1", 0);
			break;
		}
		case CON_Sem_XMM2: {
			ret = java_method_call(state, "sem_xmm2", 0);
			break;
		}
		case CON_Sem_XMM3: {
			ret = java_method_call(state, "sem_xmm3", 0);
			break;
		}
		case CON_Sem_XMM4: {
			ret = java_method_call(state, "sem_xmm4", 0);
			break;
		}
		case CON_Sem_XMM5: {
			ret = java_method_call(state, "sem_xmm5", 0);
			break;
		}
		case CON_Sem_XMM6: {
			ret = java_method_call(state, "sem_xmm6", 0);
			break;
		}
		case CON_Sem_XMM7: {
			ret = java_method_call(state, "sem_xmm7", 0);
			break;
		}
		case CON_Sem_XMM8: {
			ret = java_method_call(state, "sem_xmm8", 0);
			break;
		}
		case CON_Sem_XMM9: {
			ret = java_method_call(state, "sem_xmm9", 0);
			break;
		}
		case CON_Sem_XMM10: {
			ret = java_method_call(state, "sem_xmm10", 0);
			break;
		}
		case CON_Sem_XMM11: {
			ret = java_method_call(state, "sem_xmm11", 0);
			break;
		}
		case CON_Sem_XMM12: {
			ret = java_method_call(state, "sem_xmm12", 0);
			break;
		}
		case CON_Sem_XMM13: {
			ret = java_method_call(state, "sem_xmm13", 0);
			break;
		}
		case CON_Sem_XMM14: {
			ret = java_method_call(state, "sem_xmm14", 0);
			break;
		}
		case CON_Sem_XMM15: {
			ret = java_method_call(state, "sem_xmm15", 0);
			break;
		}
		case CON_VIRT_LES: {
			ret = java_method_call(state, "virt_les", 0);
			break;
		}
		case CON_VIRT_LEU: {
			ret = java_method_call(state, "virt_leu", 0);
			break;
		}
		case CON_VIRT_LTS: {
			ret = java_method_call(state, "virt_lts", 0);
			break;
		}
	}
	return (obj_t)ret;
}
#else
static obj_t arch(state_t state, int_t con) {
	jobject ret = java_method_call(state, "id_arch", 1, java_long_create(state, (long int)con));
	return (obj_t)ret;
}
#endif

// sem_address
static obj_t sem_address(state_t state, int_t size, obj_t address) {
	jobject ret = java_method_call(state, "sem_address", 2, java_long_create(state, (long int)size), (jobject)address);
	return (obj_t)ret;
}

// sem_var
static obj_t sem_var(state_t state, obj_t id, int_t offset) {
	jobject ret = java_method_call(state, "sem_var", 2, (jobject)id, java_long_create(state, (long int)offset));
	return (obj_t)ret;
}

// sem_linear
static obj_t sem_lin_var(state_t state, obj_t this) {
	jobject ret = java_method_call(state, "sem_lin_var", 1, (jobject)this);
	return (obj_t)ret;
}
static obj_t sem_lin_imm(state_t state, int_t imm) {
	jobject ret = java_method_call(state, "sem_lin_imm", 1, java_long_create(state, (long int)imm));
	return (obj_t)ret;
}
static obj_t sem_lin_add(state_t state, obj_t opnd1, obj_t opnd2) {
	jobject ret = java_method_call(state, "sem_lin_add", 2, (jobject)opnd1, (jobject)opnd2);
	return (obj_t)ret;
}
static obj_t sem_lin_sub(state_t state, obj_t opnd1, obj_t opnd2) {
	jobject ret = java_method_call(state, "sem_lin_sub", 2, (jobject)opnd1, (jobject)opnd2);
	return (obj_t)ret;
}
static obj_t sem_lin_scale(state_t state, int_t imm, obj_t opnd) {
	jobject ret = java_method_call(state, "sem_lin_scale", 2, java_long_create(state, (long int)imm), (jobject)opnd);
	return (obj_t)ret;
}

// sem_sexpr
static obj_t sem_sexpr_lin(state_t state, obj_t this) {
	jobject ret = java_method_call(state, "sem_sexpr_lin", 1, (jobject)this);
	return (obj_t)ret;
}
static obj_t sem_sexpr_cmp(state_t state, obj_t this) {
	jobject ret = java_method_call(state, "sem_sexpr_cmp", 1, (jobject)this);
	return (obj_t)ret;
}

// sem_op_cmp
static obj_t sem_cmpeq(state_t state, int_t size, obj_t opnd1, obj_t opnd2) {
	jobject ret = java_method_call(state, "sem_cmpeq", 3, java_long_create(state, (long int)size), (jobject)opnd1,
			(jobject)opnd2);
	return (obj_t)ret;
}
static obj_t sem_cmpneq(state_t state, int_t size, obj_t opnd1, obj_t opnd2) {
	jobject ret = java_method_call(state, "sem_cmpneq", 3, java_long_create(state, (long int)size), (jobject)opnd1,
			(jobject)opnd2);
	return (obj_t)ret;
}
static obj_t sem_cmples(state_t state, int_t size, obj_t opnd1, obj_t opnd2) {
	jobject ret = java_method_call(state, "sem_cmples", 3, java_long_create(state, (long int)size), (jobject)opnd1,
			(jobject)opnd2);
	return (obj_t)ret;
}
static obj_t sem_cmpleu(state_t state, int_t size, obj_t opnd1, obj_t opnd2) {
	jobject ret = java_method_call(state, "sem_cmpleu", 3, java_long_create(state, (long int)size), (jobject)opnd1,
			(jobject)opnd2);
	return (obj_t)ret;
}
static obj_t sem_cmplts(state_t state, int_t size, obj_t opnd1, obj_t opnd2) {
	jobject ret = java_method_call(state, "sem_cmplts", 3, java_long_create(state, (long int)size), (jobject)opnd1,
			(jobject)opnd2);
	return (obj_t)ret;
}
static obj_t sem_cmpltu(state_t state, int_t size, obj_t opnd1, obj_t opnd2) {
	jobject ret = java_method_call(state, "sem_cmpltu", 3, java_long_create(state, (long int)size), (jobject)opnd1,
			(jobject)opnd2);
	return (obj_t)ret;
}

// sem_op
static obj_t sem_lin(state_t state, int_t size, obj_t opnd1) {
	jobject ret = java_method_call(state, "sem_lin", 2, java_long_create(state, (long int)size), (jobject)opnd1);
	return (obj_t)ret;
}
static obj_t sem_mul(state_t state, int_t size, obj_t opnd1, obj_t opnd2) {
	jobject ret = java_method_call(state, "sem_mul", 3, java_long_create(state, (long int)size), (jobject)opnd1,
			(jobject)opnd2);
	return (obj_t)ret;
}
static obj_t sem_div(state_t state, int_t size, obj_t opnd1, obj_t opnd2) {
	jobject ret = java_method_call(state, "sem_div", 3, java_long_create(state, (long int)size), (jobject)opnd1,
			(jobject)opnd2);
	return (obj_t)ret;
}
static obj_t sem_divs(state_t state, int_t size, obj_t opnd1, obj_t opnd2) {
	jobject ret = java_method_call(state, "sem_divs", 3, java_long_create(state, (long int)size), (jobject)opnd1,
			(jobject)opnd2);
	return (obj_t)ret;
}
static obj_t sem_mod(state_t state, int_t size, obj_t opnd1, obj_t opnd2) {
	jobject ret = java_method_call(state, "sem_mod", 3, java_long_create(state, (long int)size), (jobject)opnd1,
			(jobject)opnd2);
	return (obj_t)ret;
}
static obj_t sem_shl(state_t state, int_t size, obj_t opnd1, obj_t opnd2) {
	jobject ret = java_method_call(state, "sem_shl", 3, java_long_create(state, (long int)size), (jobject)opnd1,
			(jobject)opnd2);
	return (obj_t)ret;
}
static obj_t sem_shr(state_t state, int_t size, obj_t opnd1, obj_t opnd2) {
	jobject ret = java_method_call(state, "sem_shr", 3, java_long_create(state, (long int)size), (jobject)opnd1,
			(jobject)opnd2);
	return (obj_t)ret;
}
static obj_t sem_shrs(state_t state, int_t size, obj_t opnd1, obj_t opnd2) {
	jobject ret = java_method_call(state, "sem_shrs", 3, java_long_create(state, (long int)size), (jobject)opnd1,
			(jobject)opnd2);
	return (obj_t)ret;
}
static obj_t sem_and(state_t state, int_t size, obj_t opnd1, obj_t opnd2) {
	jobject ret = java_method_call(state, "sem_and", 3, java_long_create(state, (long int)size), (jobject)opnd1,
			(jobject)opnd2);
	return (obj_t)ret;
}
static obj_t sem_or(state_t state, int_t size, obj_t opnd1, obj_t opnd2) {
	jobject ret = java_method_call(state, "sem_or", 3, java_long_create(state, (long int)size), (jobject)opnd1,
			(jobject)opnd2);
	return (obj_t)ret;
}
static obj_t sem_xor(state_t state, int_t size, obj_t opnd1, obj_t opnd2) {
	jobject ret = java_method_call(state, "sem_xor", 3, java_long_create(state, (long int)size), (jobject)opnd1,
			(jobject)opnd2);
	return (obj_t)ret;
}
static obj_t sem_sx(state_t state, int_t size, int_t fromsize, obj_t opnd1) {
	jobject ret = java_method_call(state, "sem_sx", 3, java_long_create(state, (long int)size),
			java_long_create(state, (long int)fromsize), (jobject)opnd1);
	return (obj_t)ret;
}
static obj_t sem_zx(state_t state, int_t size, int_t fromsize, obj_t opnd1) {
	jobject ret = java_method_call(state, "sem_zx", 3, java_long_create(state, (long int)size),
			java_long_create(state, (long int)fromsize), (jobject)opnd1);
	return (obj_t)ret;
}
static obj_t sem_cmp(state_t state, obj_t this) {
	jobject ret = java_method_call(state, "sem_cmp", 1, (jobject)this);
	return (obj_t)ret;
}
static obj_t sem_arb(state_t state, int_t size) {
	jobject ret = java_method_call(state, "sem_arb", 1, java_long_create(state, (long int)size));
	return (obj_t)ret;
}

// sem_varl
static obj_t sem_varl(state_t state, obj_t id, int_t offset, int_t size) {
	jobject ret = java_method_call(state, "sem_varl", 3, (jobject)id,
			java_long_create(state, (long int)offset), java_long_create(state, (long int)size));
	return (obj_t)ret;
}

// sem_varls
static obj_t sem_varls_next(state_t state, obj_t next, obj_t list) {
	jobject ret = java_method_call(state, "sem_varls_next", 2, (jobject)next, (jobject)list);
	return (obj_t)ret;
}
static obj_t sem_varls_init(state_t state, obj_t nothing) {
	jobject ret = java_method_call(state, "sem_varls_init", 0);
	return (obj_t)ret;
}

// sem_flop
static obj_t sem_flop(state_t state, int_t con) {
	jobject ret;
	switch (con) {
		case CON_SEM_FADD: {
			ret = java_method_call(state, "sem_flop_fadd", 0);
			break;
		}
		case CON_SEM_FSUB: {
			ret = java_method_call(state, "sem_flop_fsub", 0);
			break;
		}
		case CON_SEM_FMUL: {
			ret = java_method_call(state, "sem_flop_fmul", 0);
			break;
		}
	}
	return (obj_t)ret;
}

// sem_prim
static obj_t sem_prim_generic(state_t state, obj_t op, obj_t res, obj_t args) {
	jobject ret = java_method_call(state, "sem_prim_generic", 3, java_string_create(state, (char*)op), (jobject)res, (jobject)args);
	return (obj_t)ret;
}
static obj_t sem_prim_flop(state_t state, obj_t op, obj_t flags, obj_t res, obj_t args) {
	jobject ret = java_method_call(state, "sem_prim_flop", 4, (jobject)op, (jobject)flags, (jobject)res, (jobject)args);
	return (obj_t)ret;
}

// sem_stmt
static obj_t sem_assign(state_t state, obj_t lhs, obj_t rhs) {
	jobject ret = java_method_call(state, "sem_assign", 2, (jobject)lhs, (jobject)rhs);
	return (obj_t)ret;
}
static obj_t sem_load(state_t state, obj_t lhs, int_t size, obj_t address) {
	jobject ret = java_method_call(state, "sem_load", 3, (jobject)lhs, java_long_create(state, (long)size),
			(jobject)address);
	return (obj_t)ret;
}
static obj_t sem_store(state_t state, obj_t address, obj_t rhs) {
	jobject ret = java_method_call(state, "sem_store", 2, (jobject)address, (jobject)rhs);
	return (obj_t)ret;
}
static obj_t sem_ite(state_t state, obj_t cond, obj_t then_branch,
		obj_t else_branch) {
	jobject ret = java_method_call(state, "sem_ite", 3, (jobject)cond, (jobject)then_branch, (jobject)else_branch);
	return (obj_t)ret;
}
static obj_t sem_while(state_t state, obj_t cond, obj_t body) {
	jobject ret = java_method_call(state, "sem_while", 2, (jobject)cond, (jobject)body);
	return (obj_t)ret;
}
static obj_t sem_cbranch(state_t state, obj_t cond, obj_t target_true,
		obj_t target_false) {
	jobject ret = java_method_call(state, "sem_cbranch", 3, (jobject)cond, (jobject)target_true, (jobject)target_false);
	return (obj_t)ret;
}
static obj_t sem_branch(state_t state, obj_t branch_hint, obj_t target) {
	jobject ret = java_method_call(state, "sem_branch", 2, (jobject)branch_hint, (jobject)target);
	return (obj_t)ret;
}
static obj_t sem_prim(state_t state, obj_t prim) {
	jobject ret = java_method_call(state, "sem_prim", 1, (jobject)prim);
	return (obj_t)ret;
}

// branch_hint
static obj_t branch_hint(state_t state, int_t con) {
	char *func_n;
	switch(con) {
		case CON_HINT_JUMP: {
			func_n = "hint_jump";
			break;
		}
		case CON_HINT_CALL: {
			func_n = "hint_call";
			break;
		}
		case CON_HINT_RET: {
			func_n = "hint_ret";
			break;
		}
	}
	jobject ret = java_method_call(state, func_n, 0);
	return (obj_t)ret;
}

// sem_stmts
static obj_t list_next(state_t state, obj_t next, obj_t list) {
	jobject ret = java_method_call(state, "list_next", 2, (jobject)next, (jobject)list);
	return (obj_t)ret;
}
static obj_t list_init(state_t state, obj_t nothing) {
	jobject ret = java_method_call(state, "list_init", 0);
	return (obj_t)ret;
}

struct backend backend;

JNIEXPORT
jobject
JNICALL Java_rnati_NativeInterface_decodeAndTranslateNative(JNIEnv *env, jobject obj, jbyteArray input) {
	if(input == NULL) {
		jclass exp = (*env)->FindClass(env, "java/lang/IllegalArgumentException");
		(*env)->ThrowNew(env, exp, "Input must not be null.");
		return NULL;

	}

	size_t length = (*env)->GetArrayLength(env, input);
	char *bytes = (char*)(*env)->GetByteArrayElements(env, input, 0);

	state_t state = backend.generic.init();
	backend.generic.set_code(state, bytes, length, 0);

	if(setjmp(*backend.generic.err_tgt(state))) {
		jclass exp = (*env)->FindClass(env, "rnati/GdslDecodeException");
		(*env)->ThrowNew(env, exp, "Decode failed.");
		return NULL;
	}
	obj_t insn = backend.decoder.decode(state, backend.decoder.config_default(state));

	if(setjmp(*backend.generic.err_tgt(state))) {
		jclass exp = (*env)->FindClass(env, "rnati/RReilTranslateException");
		(*env)->ThrowNew(env, exp, "Translate failed.");
		return NULL;
	}
	obj_t rreil = backend.translator.translate(state, insn);

//			__pretty(__rreil_pretty__, r, fmt, 2048);
//			printf("---------------------------\n");
//			puts(fmt);


	//%s/obj_t .(.\(.*\))(void .closure);/config.callbacks.arch.x86.sem_id.\1 = \&\1;/g

	unboxed_sem_id_callbacks_t sem_id_callbacks = {
			.shared = &shared,
			.virt_t = &virt_t,
			.arch = &arch
	};

	unboxed_sem_address_callbacks_t sem_address_callbacks = {
			.sem_address_ = &sem_address
	};

	unboxed_sem_var_callbacks_t sem_var_callbacks = {
			.sem_var_ = &sem_var
	};

	unboxed_sem_linear_callbacks_t sem_linear_callbacks = {
			.sem_lin_var = &sem_lin_var,
			.sem_lin_imm = &sem_lin_imm,
			.sem_lin_add = &sem_lin_add,
			.sem_lin_sub = &sem_lin_sub,
			.sem_lin_scale = &sem_lin_scale
	};

	unboxed_sem_sexpr_callbacks_t sem_sexpr_callbacks = {
			.sem_sexpr_lin = &sem_sexpr_lin,
			.sem_sexpr_cmp = &sem_sexpr_cmp
	};

	unboxed_sem_op_cmp_callbacks_t sem_op_cmp_callbacks = {
			.sem_cmpeq = &sem_cmpeq,
			.sem_cmpneq = &sem_cmpneq,
			.sem_cmples = &sem_cmples,
			.sem_cmpleu = &sem_cmpleu,
			.sem_cmplts = &sem_cmplts,
			.sem_cmpltu = &sem_cmpltu
	};

	unboxed_sem_op_callbacks_t sem_op_callbacks = {
			.sem_lin = &sem_lin,
			.sem_mul = &sem_mul,
			.sem_div = &sem_div,
			.sem_divs = &sem_divs,
			.sem_mod = &sem_mod,
			.sem_shl = &sem_shl,
			.sem_shr = &sem_shr,
			.sem_shrs = &sem_shrs,
			.sem_and = &sem_and,
			.sem_or = &sem_or,
			.sem_xor = &sem_xor,
			.sem_sx = &sem_sx,
			.sem_zx = &sem_zx,
			.sem_cmp = &sem_cmp,
			.sem_arb = &sem_arb
	};

	unboxed_sem_varl_callbacks_t sem_varl_callbacks = {
			.sem_varl_ = &sem_varl
	};

	unboxed_sem_varls_callbacks_t sem_varls_callbacks = {
			.sem_varls_next = &sem_varls_next,
			.sem_varls_init = &sem_varls_init
	};

	unboxed_sem_flop_callbacks_t sem_flop_callbacks = {
			.sem_flop_ = &sem_flop
	};

	unboxed_sem_prim_callbacks_t sem_prim_callbacks = {
			.sem_prim_generic = &sem_prim_generic,
			.sem_prim_flop = &sem_prim_flop
	};

	unboxed_sem_stmt_callbacks_t sem_stmt_callbacks = {
			.sem_assign = &sem_assign,
			.sem_load = &sem_load,
			.sem_store = &sem_store,
			.sem_ite = &sem_ite,
			.sem_while = &sem_while,
			.sem_cbranch = &sem_cbranch,
			.sem_branch = &sem_branch,
			.sem_prim = &sem_prim
	};

	unboxed_branch_hint_callbacks_t branch_hint_callbacks = {
			.branch_hint_ = &branch_hint
	};

//	unboxed_sem_stmts_list_callbacks_t sem_stmts_list_callbacks = {
//			.list_init = &list_init,
//			.list_next = &list_next
//	};

	unboxed_sem_stmts_callbacks_t sem_stmts_callbacks = {
			.init = &list_init,
			.next = &list_next
	};

	unboxed_callbacks_t callbacks = {
			.sem_id = &sem_id_callbacks,
			.sem_address = &sem_address_callbacks,
			.sem_var = &sem_var_callbacks,
			.sem_linear = &sem_linear_callbacks,
			.sem_sexpr = &sem_sexpr_callbacks,
			.sem_op_cmp = &sem_op_cmp_callbacks,
			.sem_op = &sem_op_callbacks,
			.sem_varl = &sem_varl_callbacks,
			.sem_varls = &sem_varls_callbacks,
			.sem_flop = &sem_flop_callbacks,
			.sem_prim = &sem_prim_callbacks,
			.sem_stmt = &sem_stmt_callbacks,
			.branch_hint = &branch_hint_callbacks,
			.sem_stmts = &sem_stmts_callbacks
	};

//		config.callbacks.sem_stmts.sem_cons = &sem_cons;
//		config.callbacks.sem_stmts.sem_nil = &sem_nil;
//		config.gdrr_config_stmts_handling = GDRR_CONFIG_STMTS_HANDLING_RECURSIVE;

	struct userdata ud;
	ud.env = env;
	ud.obj = obj;

	backend.translator.rreil_cif_userdata_set(state, &ud);

	return backend.translator.rreil_convert_sem_stmts(state, &callbacks, rreil);
}

JNIEXPORT
jobjectArray
JNICALL Java_rnati_NativeInterface_getBackendsNative(JNIEnv *env, jobject obj) {
	char **backends;
	size_t backends_length = gdsl_multiplex_backends_list(&backends);

	jobjectArray jbackends = (*env)->NewObjectArray(env, backends_length, (*env)->FindClass(env, "java/lang/String"),
			(*env)->NewStringUTF(env, ""));

	for(size_t i = 0; i < backends_length; ++i) {
		jstring next = (*env)->NewStringUTF(env, backends[i]);
		free(backends[i]);
		(*env)->SetObjectArrayElement(env, jbackends, i, next);
	}
	if(backends_length)
		free(backends);

	return jbackends;
}

#define THROW_RUNTIME(MSG) {\
		jclass exp = (*env)->FindClass(env, "java/lang/RuntimeException");\
		(*env)->ThrowNew(env, exp, MSG);\
		return;\
}

JNIEXPORT
void
JNICALL Java_rnati_NativeInterface_useBackendNative(JNIEnv *env, jobject obj, jstring backend_str) {
  const char *backend_str_n = (*env)->GetStringUTFChars(env, backend_str, 0);

  switch(gdsl_multiplex_backend_get(&backend, backend_str_n)) {
  	case GDSL_MULTIPLEX_ERROR_BACKENDS_PATH_NOT_SET: THROW_RUNTIME("Unable to open backend: Path to backends not set")
  	case GDSL_MULTIPLEX_ERROR_UNABLE_TO_OPEN: THROW_RUNTIME("Unable to open backend: Unable to open backend library")
  	case GDSL_MULTIPLEX_ERROR_SYMBOL_NOT_FOUND: THROW_RUNTIME("Unable to open backend: Symbol not found")
  	case GDSL_MULTIPLEX_ERROR_NONE: break;
  }

  (*env)->ReleaseStringUTFChars(env, backend_str, backend_str_n);
}

JNIEXPORT
void
JNICALL Java_rnati_NativeInterface_closeBackendNative(JNIEnv *env, jobject obj) {
	gdsl_multiplex_backend_close(&backend);
}
