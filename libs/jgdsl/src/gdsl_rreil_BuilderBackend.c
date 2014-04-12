#include <jni.h>
#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <string.h>
#include <gdsl.h>
#include <gdsl_multiplex.h>
#include "gdsl_rreil_BuilderBackend.h"
#include "util.h"

struct userdata {
	JNIEnv *env;
	jobject obj;
};

/*
 * Todo: Horrible hack
 */
void *(*rreil_cif_userdata_get)(state_t state);

static jobject java_method_call(state_t state, char *name, int numargs, ...) {
	if (numargs > 4)
		return NULL; //Todo: Handle error

	struct userdata *ud = (struct userdata*) rreil_cif_userdata_get(state);

	jclass class = (*ud->env)->GetObjectClass(ud->env, ud->obj);

	char *signature;
	switch (numargs) {
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
	case 4: {
		signature =
				"(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;";
		break;
	}
	}
	jmethodID mid = (*ud->env)->GetMethodID(ud->env, class, name, signature);

	jobject args[numargs];

	va_list list;
	va_start(list, numargs);
	for (int i = 0; i < numargs; ++i)
		args[i] = va_arg(list, jobject);
	va_end(list);

	jobject ret;
	switch (numargs) {
	case 0: {
		ret = (*ud->env)->CallObjectMethod(ud->env, ud->obj, mid);
		break;
	}
	case 1: {
		ret = (*ud->env)->CallObjectMethod(ud->env, ud->obj, mid, args[0]);
		break;
	}
	case 2: {
		ret = (*ud->env)->CallObjectMethod(ud->env, ud->obj, mid, args[0],
				args[1]);
		break;
	}
	case 3: {
		ret = (*ud->env)->CallObjectMethod(ud->env, ud->obj, mid, args[0],
				args[1], args[2]);
		break;
	}
	case 4: {
		ret = (*ud->env)->CallObjectMethod(ud->env, ud->obj, mid, args[0],
				args[1], args[2], args[3]);
		break;
	}
	}

	return ret;
}

static jobject java_long_create(state_t state, long int x) {
	struct userdata *ud = (struct userdata*) rreil_cif_userdata_get(state);

	jclass class = (*ud->env)->FindClass(ud->env, "java/lang/Long");
	jmethodID method_id = (*ud->env)->GetMethodID(ud->env, class, "<init>",
			"(J)V");
	jobject a = (*ud->env)->NewObject(ud->env, class, method_id, x);

	return a;
}

static jstring java_string_create(state_t state, char *x) {
	struct userdata *ud = (struct userdata*) rreil_cif_userdata_get(state);
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
	return (obj_t) ret;
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
	jobject ret = java_method_call(state, "virt_t", 1,
			java_long_create(state, (long int) t));
	return (obj_t) ret;
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
		case CON_Sem_A: {
			ret = java_method_call(state, "sem_a", 0);
			break;
		}
		case CON_Sem_B: {
			ret = java_method_call(state, "sem_b", 0);
			break;
		}
		case CON_Sem_C: {
			ret = java_method_call(state, "sem_c", 0);
			break;
		}
		case CON_Sem_D: {
			ret = java_method_call(state, "sem_d", 0);
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
		case CON_Sem_CS_Base: {
			ret = java_method_call(state, "sem_cs_base", 0);
			break;
		}
		case CON_Sem_DS_Base: {
			ret = java_method_call(state, "sem_ds_base", 0);
			break;
		}
		case CON_Sem_SS_Base: {
			ret = java_method_call(state, "sem_ss_base", 0);
			break;
		}
		case CON_Sem_ES_Base: {
			ret = java_method_call(state, "sem_es_base", 0);
			break;
		}
		case CON_Sem_FS_Base: {
			ret = java_method_call(state, "sem_fs_base", 0);
			break;
		}
		case CON_Sem_GS_Base: {
			ret = java_method_call(state, "sem_gs_base", 0);
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
	jobject ret = java_method_call(state, "id_arch", 1,
			java_long_create(state, (long int) con));
	return (obj_t) ret;
}
#endif

// sem_exception
static obj_t exception_shared(state_t state, int_t con) {
	jobject ret = NULL;
	switch (con) {
	case CON_SEM_DIVISION_BY_ZERO: {
		ret = java_method_call(state, "exception_shared_division_by_zero", 0);
		break;
	}
	}
	return (obj_t) ret;
}
#ifdef GDSL_X86
static obj_t exception_arch(state_t state, int_t con) {
	jobject ret;
	switch(con) {
		case CON_SEM_DIVISION_OVERFLOW: {
			ret = java_method_call(state, "exception_x86_division_overflow", 0);
			break;
		}
	}
	return (obj_t)ret;
}
#else
static obj_t exception_arch(state_t state, int_t con) {
	jobject ret = java_method_call(state, "exception_arch", 1,
			java_long_create(state, (long int) con));
	return (obj_t) ret;
}
#endif

// sem_address
static obj_t sem_address(state_t state, int_t size, obj_t address) {
	jobject ret = java_method_call(state, "sem_address", 2,
			java_long_create(state, (long int) size), (jobject) address);
	return (obj_t) ret;
}

// sem_var
static obj_t sem_var(state_t state, obj_t id, int_t offset) {
	jobject ret = java_method_call(state, "sem_var", 2, (jobject) id,
			java_long_create(state, (long int) offset));
	return (obj_t) ret;
}

// sem_linear
static obj_t sem_lin_var(state_t state, obj_t this) {
	jobject ret = java_method_call(state, "sem_lin_var", 1, (jobject) this);
	return (obj_t) ret;
}
static obj_t sem_lin_imm(state_t state, int_t imm) {
	jobject ret = java_method_call(state, "sem_lin_imm", 1,
			java_long_create(state, (long int) imm));
	return (obj_t) ret;
}
static obj_t sem_lin_add(state_t state, obj_t opnd1, obj_t opnd2) {
	jobject ret = java_method_call(state, "sem_lin_add", 2, (jobject) opnd1,
			(jobject) opnd2);
	return (obj_t) ret;
}
static obj_t sem_lin_sub(state_t state, obj_t opnd1, obj_t opnd2) {
	jobject ret = java_method_call(state, "sem_lin_sub", 2, (jobject) opnd1,
			(jobject) opnd2);
	return (obj_t) ret;
}
static obj_t sem_lin_scale(state_t state, int_t imm, obj_t opnd) {
	jobject ret = java_method_call(state, "sem_lin_scale", 2,
			java_long_create(state, (long int) imm), (jobject) opnd);
	return (obj_t) ret;
}

// sem_sexpr
static obj_t sem_sexpr_lin(state_t state, obj_t this) {
	jobject ret = java_method_call(state, "sem_sexpr_lin", 1, (jobject) this);
	return (obj_t) ret;
}
static obj_t sem_sexpr_cmp(state_t state, obj_t this) {
	jobject ret = java_method_call(state, "sem_sexpr_cmp", 1, (jobject) this);
	return (obj_t) ret;
}
static obj_t sem_sexpr_arb(state_t state, obj_t nothing) {
	jobject ret = java_method_call(state, "sem_sexpr_arb", 0);
	return (obj_t) ret;
}

// sem_expr_cmp
static obj_t sem_cmpeq(state_t state, obj_t opnd1, obj_t opnd2) {
	jobject ret = java_method_call(state, "sem_cmpeq", 2, (jobject) opnd1,
			(jobject) opnd2);
	return (obj_t) ret;
}
static obj_t sem_cmpneq(state_t state, obj_t opnd1, obj_t opnd2) {
	jobject ret = java_method_call(state, "sem_cmpneq", 2, (jobject) opnd1,
			(jobject) opnd2);
	return (obj_t) ret;
}
static obj_t sem_cmples(state_t state, obj_t opnd1, obj_t opnd2) {
	jobject ret = java_method_call(state, "sem_cmples", 2, (jobject) opnd1,
			(jobject) opnd2);
	return (obj_t) ret;
}
static obj_t sem_cmpleu(state_t state, obj_t opnd1, obj_t opnd2) {
	jobject ret = java_method_call(state, "sem_cmpleu", 2, (jobject) opnd1,
			(jobject) opnd2);
	return (obj_t) ret;
}
static obj_t sem_cmplts(state_t state, obj_t opnd1, obj_t opnd2) {
	jobject ret = java_method_call(state, "sem_cmplts", 2, (jobject) opnd1,
			(jobject) opnd2);
	return (obj_t) ret;
}
static obj_t sem_cmpltu(state_t state, obj_t opnd1, obj_t opnd2) {
	jobject ret = java_method_call(state, "sem_cmpltu", 2, (jobject) opnd1,
			(jobject) opnd2);
	return (obj_t) ret;
}

// sem_expr
static obj_t sem_sexpr(state_t state, obj_t opnd1) {
	jobject ret = java_method_call(state, "sem_sexpr", 1, (jobject) opnd1);
	return (obj_t) ret;
}
static obj_t sem_mul(state_t state, obj_t opnd1, obj_t opnd2) {
	jobject ret = java_method_call(state, "sem_mul", 2, (jobject) opnd1,
			(jobject) opnd2);
	return (obj_t) ret;
}
static obj_t sem_div(state_t state, obj_t opnd1, obj_t opnd2) {
	jobject ret = java_method_call(state, "sem_div", 2, (jobject) opnd1,
			(jobject) opnd2);
	return (obj_t) ret;
}
static obj_t sem_divs(state_t state, obj_t opnd1, obj_t opnd2) {
	jobject ret = java_method_call(state, "sem_divs", 2, (jobject) opnd1,
			(jobject) opnd2);
	return (obj_t) ret;
}
static obj_t sem_mod(state_t state, obj_t opnd1, obj_t opnd2) {
	jobject ret = java_method_call(state, "sem_mod", 2, (jobject) opnd1,
			(jobject) opnd2);
	return (obj_t) ret;
}
static obj_t sem_mods(state_t state, obj_t opnd1, obj_t opnd2) {
	jobject ret = java_method_call(state, "sem_mod", 2, (jobject) opnd1,
			(jobject) opnd2);
	return (obj_t) ret;
}
static obj_t sem_shl(state_t state, obj_t opnd1, obj_t opnd2) {
	jobject ret = java_method_call(state, "sem_shl", 2, (jobject) opnd1,
			(jobject) opnd2);
	return (obj_t) ret;
}
static obj_t sem_shr(state_t state, obj_t opnd1, obj_t opnd2) {
	jobject ret = java_method_call(state, "sem_shr", 2, (jobject) opnd1,
			(jobject) opnd2);
	return (obj_t) ret;
}
static obj_t sem_shrs(state_t state, obj_t opnd1, obj_t opnd2) {
	jobject ret = java_method_call(state, "sem_shrs", 2, (jobject) opnd1,
			(jobject) opnd2);
	return (obj_t) ret;
}
static obj_t sem_and(state_t state, obj_t opnd1, obj_t opnd2) {
	jobject ret = java_method_call(state, "sem_and", 2, (jobject) opnd1,
			(jobject) opnd2);
	return (obj_t) ret;
}
static obj_t sem_or(state_t state, obj_t opnd1, obj_t opnd2) {
	jobject ret = java_method_call(state, "sem_or", 2, (jobject) opnd1,
			(jobject) opnd2);
	return (obj_t) ret;
}
static obj_t sem_xor(state_t state, obj_t opnd1, obj_t opnd2) {
	jobject ret = java_method_call(state, "sem_xor", 2, (jobject) opnd1,
			(jobject) opnd2);
	return (obj_t) ret;
}
static obj_t sem_sx(state_t state, int_t fromsize, obj_t opnd1) {
	jobject ret = java_method_call(state, "sem_sx", 2,
			java_long_create(state, (long int) fromsize), (jobject) opnd1);
	return (obj_t) ret;
}
static obj_t sem_zx(state_t state, int_t fromsize, obj_t opnd1) {
	jobject ret = java_method_call(state, "sem_zx", 2,
			java_long_create(state, (long int) fromsize), (jobject) opnd1);
	return (obj_t) ret;
}
static obj_t sem_throw(state_t state, obj_t exception) {
	jobject ret = java_method_call(state, "sem_throw", 1, (jobject) exception);
	return (obj_t) ret;
}

// sem_varl
static obj_t sem_varl(state_t state, obj_t id, int_t offset, int_t size) {
	jobject ret = java_method_call(state, "sem_varl", 3, (jobject) id,
			java_long_create(state, (long int) offset),
			java_long_create(state, (long int) size));
	return (obj_t) ret;
}

// sem_varls
static obj_t sem_varls_next(state_t state, obj_t next, obj_t list) {
	jobject ret = java_method_call(state, "sem_varls_next", 2, (jobject) next,
			(jobject) list);
	return (obj_t) ret;
}
static obj_t sem_varls_init(state_t state, obj_t nothing) {
	jobject ret = java_method_call(state, "sem_varls_init", 0);
	return (obj_t) ret;
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
	return (obj_t) ret;
}

// sem_stmt
static obj_t sem_assign(state_t state, int_t size, obj_t lhs, obj_t rhs) {
	jobject ret = java_method_call(state, "sem_assign", 3,
			java_long_create(state, (long) size), (jobject) lhs, (jobject) rhs);
	return (obj_t) ret;
}
static obj_t sem_load(state_t state, int_t size, obj_t lhs, obj_t address) {
	jobject ret = java_method_call(state, "sem_load", 3,
			java_long_create(state, (long) size), (jobject) lhs,
			(jobject) address);
	return (obj_t) ret;
}
static obj_t sem_store(state_t state, int_t size, obj_t address, obj_t rhs) {
	jobject ret = java_method_call(state, "sem_store", 3,
			java_long_create(state, (long) size), (jobject) address,
			(jobject) rhs);
	return (obj_t) ret;
}
static obj_t sem_ite(state_t state, obj_t cond, obj_t then_branch,
		obj_t else_branch) {
	jobject ret = java_method_call(state, "sem_ite", 3, (jobject) cond,
			(jobject) then_branch, (jobject) else_branch);
	return (obj_t) ret;
}
static obj_t sem_while(state_t state, obj_t cond, obj_t body) {
	jobject ret = java_method_call(state, "sem_while", 2, (jobject) cond,
			(jobject) body);
	return (obj_t) ret;
}
static obj_t sem_cbranch(state_t state, obj_t cond, obj_t target_true,
		obj_t target_false) {
	jobject ret = java_method_call(state, "sem_cbranch", 3, (jobject) cond,
			(jobject) target_true, (jobject) target_false);
	return (obj_t) ret;
}
static obj_t sem_branch(state_t state, obj_t branch_hint, obj_t target) {
	jobject ret = java_method_call(state, "sem_branch", 2,
			(jobject) branch_hint, (jobject) target);
	return (obj_t) ret;
}
static obj_t sem_flop_stmt(state_t state, obj_t op, obj_t flags, obj_t lhs,
		obj_t rhs) {
	jobject ret = java_method_call(state, "sem_flop_stmt", 4, (jobject) op,
			(jobject) flags, (jobject) lhs, (jobject) rhs);
	return (obj_t) ret;
}
static obj_t sem_prim(state_t state, obj_t op, obj_t lhs, obj_t rhs) {
	jobject ret = java_method_call(state, "sem_prim", 3,
			java_string_create(state, (char*) op), (jobject) lhs,
			(jobject) rhs);
	return (obj_t) ret;
}

// branch_hint
static obj_t branch_hint(state_t state, int_t con) {
	char *func_n;
	switch (con) {
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
	return (obj_t) ret;
}

// sem_stmts
static obj_t sem_stmts_next(state_t state, obj_t next, obj_t list) {
	jobject ret = java_method_call(state, "sem_stmts_next", 2, (jobject) next,
			(jobject) list);
	return (obj_t) ret;
}
static obj_t sem_stmts_init(state_t state, obj_t nothing) {
	jobject ret = java_method_call(state, "sem_stmts_init", 0);
	return (obj_t) ret;
}

#define BUILD_CALLBACKS \
		unboxed_sem_id_callbacks_t sem_id_callbacks = { .shared = &shared, .virt_t = &virt_t, .arch = &arch };\
		unboxed_sem_exception_callbacks_t sem_exception_callbacks = { .shared = &exception_shared, .arch = &exception_arch };\
		unboxed_sem_address_callbacks_t sem_address_callbacks = { .sem_address_ = &sem_address };\
		unboxed_sem_var_callbacks_t sem_var_callbacks = { .sem_var_ = &sem_var };\
		unboxed_sem_linear_callbacks_t sem_linear_callbacks = { .sem_lin_var = &sem_lin_var, .sem_lin_imm = &sem_lin_imm,\
				.sem_lin_add = &sem_lin_add, .sem_lin_sub = &sem_lin_sub, .sem_lin_scale = &sem_lin_scale };\
		unboxed_sem_sexpr_callbacks_t sem_sexpr_callbacks = { .sem_sexpr_lin = &sem_sexpr_lin,\
				.sem_sexpr_cmp = &sem_sexpr_cmp, .sem_sexpr_arb = &sem_sexpr_arb };\
		unboxed_sem_expr_cmp_callbacks_t sem_expr_cmp_callbacks = { .sem_cmpeq = &sem_cmpeq, .sem_cmpneq = &sem_cmpneq,\
				.sem_cmples = &sem_cmples, .sem_cmpleu = &sem_cmpleu, .sem_cmplts = &sem_cmplts, .sem_cmpltu = &sem_cmpltu };\
		unboxed_sem_expr_callbacks_t sem_expr_callbacks = { .sem_sexpr = &sem_sexpr, .sem_mul = &sem_mul, .sem_div = &sem_div,\
				.sem_divs = &sem_divs, .sem_mod = &sem_mod, .sem_mods = &sem_mods, .sem_shl = &sem_shl, .sem_shr = &sem_shr,\
				.sem_shrs = &sem_shrs, .sem_and = &sem_and, .sem_or = &sem_or, .sem_xor = &sem_xor, .sem_sx = &sem_sx, .sem_zx =\
						&sem_zx, };\
		unboxed_sem_varl_callbacks_t sem_varl_callbacks = { .sem_varl_ = &sem_varl };\
		unboxed_sem_varls_callbacks_t sem_varls_callbacks = { .sem_varls_next = &sem_varls_next, .sem_varls_init =\
				&sem_varls_init };\
		unboxed_sem_flop_callbacks_t sem_flop_callbacks = { .sem_flop_ = &sem_flop };\
		unboxed_sem_stmt_callbacks_t sem_stmt_callbacks = { .sem_assign = &sem_assign, .sem_load = &sem_load, .sem_store =\
				&sem_store, .sem_ite = &sem_ite, .sem_while = &sem_while, .sem_cbranch = &sem_cbranch, .sem_branch = &sem_branch,\
				.sem_flop = &sem_flop_stmt, .sem_prim = &sem_prim, .sem_throw = &sem_throw };\
		unboxed_branch_hint_callbacks_t branch_hint_callbacks = { .branch_hint_ = &branch_hint };\
		unboxed_sem_stmts_callbacks_t sem_stmts_callbacks = { .sem_stmts_next = &sem_stmts_next, .sem_stmts_init =\
				&sem_stmts_init };\
		unboxed_callbacks_t callbacks = { .sem_id = &sem_id_callbacks, .sem_address = &sem_address_callbacks, .sem_var =\
				&sem_var_callbacks, .sem_linear = &sem_linear_callbacks, .sem_sexpr = &sem_sexpr_callbacks, .sem_expr_cmp =\
				&sem_expr_cmp_callbacks, .sem_expr = &sem_expr_callbacks, .sem_varl = &sem_varl_callbacks, .sem_varls =\
				&sem_varls_callbacks, .sem_flop = &sem_flop_callbacks, .sem_stmt = &sem_stmt_callbacks, .branch_hint =\
				&branch_hint_callbacks, .sem_exception = &sem_exception_callbacks, .sem_stmts = &sem_stmts_callbacks };\

JNIEXPORT jobject JNICALL Java_gdsl_rreil_BuilderBackend_translate(JNIEnv *env,
		jobject this, jlong frontendPtr, jlong gdslStatePtr, jlong insnPtr) {
	struct frontend *frontend = (struct frontend*) frontendPtr;
	state_t state = (state_t) gdslStatePtr;
	obj_t insn = (obj_t) insnPtr;

//	size_t length = (*env)->GetArrayLength(env, input);
//	char *bytes = (char*)(*env)->GetByteArrayElements(env, input, 0);

//	if(setjmp(*frontend.generic.err_tgt(state))) {
//		jclass exp = (*env)->FindClass(env, "rnati/GdslDecodeException");
//		(*env)->ThrowNew(env, exp, "Decode failed.");
//		return NULL;
//	}
//	obj_t insn = frontend.decoder.decode(state, frontend.decoder.config_default(state));

	if (setjmp(*frontend->generic.err_tgt(state))) {
		jclass exp = (*env)->FindClass(env,
				"gdsl/translator/RReilTranslateException");
		(*env)->ThrowNew(env, exp, "Translate failed");
		return NULL;
	}
	obj_t rreil = frontend->translator.translate(state, insn);

//			__pretty(__rreil_pretty__, r, fmt, 2048);
//			printf("---------------------------\n");
//			puts(fmt);

	struct userdata ud;
	ud.env = env;
	ud.obj = this;

	frontend->translator.rreil_cif_userdata_set(state, &ud);
	rreil_cif_userdata_get = frontend->translator.rreil_cif_userdata_get;

//	char *fmt = frontend->generic.merge_rope(state, frontend->translator.pretty(state, rreil));
//	puts(fmt);
//	return NULL;

	BUILD_CALLBACKS
	return frontend->translator.rreil_convert_sem_stmts(state, &callbacks,
			rreil);
}

struct insn_collection {
	obj_t **insns;
	size_t length;
	size_t size;
};

static obj_t insn_cb(state_t state, obj_t insns, obj_t insn) {
	struct insn_collection *coll = (struct insn_collection*) insns;
	if (coll->length + 1 > coll->size) {
		coll->size = coll->size ? coll->size * 2 : 8;
		coll->insns = (obj_t**) realloc(coll->insns, coll->size);
	}
	coll->insns[coll->length++] = insn;
	return insns;
}

jobject translate_block_optimized_with_config(JNIEnv *env, jobject this,
		jlong frontendPtr, jlong gdslStatePtr, int_t config, jlong limit,
		jint preservation) {
	struct frontend *frontend = (struct frontend*) frontendPtr;
	state_t state = (state_t) gdslStatePtr;

	if (setjmp(*frontend->generic.err_tgt(state))) {
		jclass exp = (*env)->FindClass(env, "gdsl/GdslException");
		printf("%s\n", frontend->generic.get_error_message(state));
		(*env)->ThrowNew(env, exp, "TranslateOptimizeBlock failed");
		return NULL;
	}

	struct insn_collection coll;
	coll.insns = NULL;
	coll.length = 0;
	coll.size = 0;

	opt_result_t opt_result =
			frontend->translator.decode_translate_block_optimized_int(state,
					config, limit, preservation, &coll, &insn_cb);

	jlongArray instructions = (*env)->NewLongArray(env, coll.length);
	(*env)->SetLongArrayRegion(env, instructions, 0, coll.length,
			(jlong*) coll.insns);

	free(coll.insns);

	obj_t rreil = opt_result->rreil;

	struct userdata ud;
	ud.env = env;
	ud.obj = this;

	frontend->translator.rreil_cif_userdata_set(state, &ud);
	rreil_cif_userdata_get = frontend->translator.rreil_cif_userdata_get;

	BUILD_CALLBACKS
	jobject converted_rreil = frontend->translator.rreil_convert_sem_stmts(
			state, &callbacks, rreil);

	jclass TranslatedBlock = (*env)->FindClass(env,
			"gdsl/translator/TranslatedBlockRaw");
	jmethodID TranslatedBlock_ctor = (*env)->GetMethodID(env, TranslatedBlock,
			"<init>", "([JLgdsl/rreil/IRReilCollection;)V");

	return (*env)->NewObject(env, TranslatedBlock, TranslatedBlock_ctor,
			instructions, converted_rreil);
}

JNIEXPORT jobject JNICALL Java_gdsl_rreil_BuilderBackend_translateOptimizeBlock(
		JNIEnv *env, jobject this, jlong frontendPtr, jlong gdslStatePtr,
		jlong limit, jint preservation) {
	struct frontend *frontend = (struct frontend*) frontendPtr;
	state_t state = (state_t) gdslStatePtr;

	return translate_block_optimized_with_config(env, this, frontendPtr,
			gdslStatePtr, frontend->decoder.config_default(state), limit,
			preservation);
}

JNIEXPORT jobject JNICALL Java_gdsl_rreil_BuilderBackend_translateOptimizeBlockWithConfig(
		JNIEnv *env, jobject this, jlong frontendPtr, jlong gdslStatePtr,
		jlong config, jlong limit, jint preservation) {
	return translate_block_optimized_with_config(env, this, frontendPtr,
			gdslStatePtr, config, limit, preservation);
}

//JNIEXPORT
//void
//JNICALL Java_gdsl_NativeInterface_closeFrontendNative(JNIEnv *env, jobject obj) {
//	gdsl_multiplex_frontend_close(&frontend);
//}
