/*
 * x86.h
 *
 *  Created on: Mar 10, 2013
 *      Author: jucs
 */

#ifndef X86_CALLBACKS_H_
#define X86_CALLBACKS_H_

#include <gdrr_types.h>

struct gdrr_sem_id_x86_callbacks {
	gdrr_sem_id_t *(*sem_ip)(void *closure);
	gdrr_sem_id_t *(*sem_flags)(void *closure);
	gdrr_sem_id_t *(*sem_mxcsr)(void *closure);
	gdrr_sem_id_t *(*sem_ax)(void *closure);
	gdrr_sem_id_t *(*sem_bx)(void *closure);
	gdrr_sem_id_t *(*sem_cx)(void *closure);
	gdrr_sem_id_t *(*sem_dx)(void *closure);
	gdrr_sem_id_t *(*sem_si)(void *closure);
	gdrr_sem_id_t *(*sem_di)(void *closure);
	gdrr_sem_id_t *(*sem_sp)(void *closure);
	gdrr_sem_id_t *(*sem_bp)(void *closure);
	gdrr_sem_id_t *(*sem_r8)(void *closure);
	gdrr_sem_id_t *(*sem_r9)(void *closure);
	gdrr_sem_id_t *(*sem_r10)(void *closure);
	gdrr_sem_id_t *(*sem_r11)(void *closure);
	gdrr_sem_id_t *(*sem_r12)(void *closure);
	gdrr_sem_id_t *(*sem_r13)(void *closure);
	gdrr_sem_id_t *(*sem_r14)(void *closure);
	gdrr_sem_id_t *(*sem_r15)(void *closure);
	gdrr_sem_id_t *(*sem_cs)(void *closure);
	gdrr_sem_id_t *(*sem_ds)(void *closure);
	gdrr_sem_id_t *(*sem_ss)(void *closure);
	gdrr_sem_id_t *(*sem_es)(void *closure);
	gdrr_sem_id_t *(*sem_fs)(void *closure);
	gdrr_sem_id_t *(*sem_gs)(void *closure);
	gdrr_sem_id_t *(*sem_st0)(void *closure);
	gdrr_sem_id_t *(*sem_st1)(void *closure);
	gdrr_sem_id_t *(*sem_st2)(void *closure);
	gdrr_sem_id_t *(*sem_st3)(void *closure);
	gdrr_sem_id_t *(*sem_st4)(void *closure);
	gdrr_sem_id_t *(*sem_st5)(void *closure);
	gdrr_sem_id_t *(*sem_st6)(void *closure);
	gdrr_sem_id_t *(*sem_st7)(void *closure);
	gdrr_sem_id_t *(*sem_mm0)(void *closure);
	gdrr_sem_id_t *(*sem_mm1)(void *closure);
	gdrr_sem_id_t *(*sem_mm2)(void *closure);
	gdrr_sem_id_t *(*sem_mm3)(void *closure);
	gdrr_sem_id_t *(*sem_mm4)(void *closure);
	gdrr_sem_id_t *(*sem_mm5)(void *closure);
	gdrr_sem_id_t *(*sem_mm6)(void *closure);
	gdrr_sem_id_t *(*sem_mm7)(void *closure);
	gdrr_sem_id_t *(*sem_xmm0)(void *closure);
	gdrr_sem_id_t *(*sem_xmm1)(void *closure);
	gdrr_sem_id_t *(*sem_xmm2)(void *closure);
	gdrr_sem_id_t *(*sem_xmm3)(void *closure);
	gdrr_sem_id_t *(*sem_xmm4)(void *closure);
	gdrr_sem_id_t *(*sem_xmm5)(void *closure);
	gdrr_sem_id_t *(*sem_xmm6)(void *closure);
	gdrr_sem_id_t *(*sem_xmm7)(void *closure);
	gdrr_sem_id_t *(*sem_xmm8)(void *closure);
	gdrr_sem_id_t *(*sem_xmm9)(void *closure);
	gdrr_sem_id_t *(*sem_xmm10)(void *closure);
	gdrr_sem_id_t *(*sem_xmm11)(void *closure);
	gdrr_sem_id_t *(*sem_xmm12)(void *closure);
	gdrr_sem_id_t *(*sem_xmm13)(void *closure);
	gdrr_sem_id_t *(*sem_xmm14)(void *closure);
	gdrr_sem_id_t *(*sem_xmm15)(void *closure);
};

struct gdrr_x86_callbacks {
	struct gdrr_sem_id_x86_callbacks sem_id;
};

#endif /* X86_CALLBACKS_H_ */
