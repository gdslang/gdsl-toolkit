/*
 * x86.c
 *
 *  Created on: Mar 10, 2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <dis.h>
#include <gdrr_config.h>
#include <x86.h>

gdrr_sem_id_t *gdrr_convert_sem_id_x86(__obj sem_id_obj,
		struct gdrr_config *config) {
	gdrr_sem_id_t *sem_id = NULL;

		switch(__CASETAGCON(sem_id_obj)) {
			case __Sem_IP: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_ip(config->closure);
				break;
			}
			case __Sem_FLAGS: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_flags(config->closure);
				break;
			}
			case __Sem_MXCSR: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_mxcsr(config->closure);
				break;
			}
			case __Sem_AX: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_ax(config->closure);
				break;
			}
			case __Sem_BX: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_bx(config->closure);
				break;
			}
			case __Sem_CX: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_cx(config->closure);
				break;
			}
			case __Sem_DX: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_dx(config->closure);
				break;
			}
			case __Sem_SI: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_si(config->closure);
				break;
			}
			case __Sem_DI: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_di(config->closure);
				break;
			}
			case __Sem_SP: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_sp(config->closure);
				break;
			}
			case __Sem_BP: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_bp(config->closure);
				break;
			}
			case __Sem_R8: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_r8(config->closure);
				break;
			}
			case __Sem_R9: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_r9(config->closure);
				break;
			}
			case __Sem_R10: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_r10(config->closure);
				break;
			}
			case __Sem_R11: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_r11(config->closure);
				break;
			}
			case __Sem_R12: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_r12(config->closure);
				break;
			}
			case __Sem_R13: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_r13(config->closure);
				break;
			}
			case __Sem_R14: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_r14(config->closure);
				break;
			}
			case __Sem_R15: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_r15(config->closure);
				break;
			}
			case __Sem_CS: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_cs(config->closure);
				break;
			}
			case __Sem_DS: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_ds(config->closure);
				break;
			}
			case __Sem_SS: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_ss(config->closure);
				break;
			}
			case __Sem_ES: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_es(config->closure);
				break;
			}
			case __Sem_FS: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_fs(config->closure);
				break;
			}
			case __Sem_GS: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_gs(config->closure);
				break;
			}
			case __Sem_ST0: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_st0(config->closure);
				break;
			}
			case __Sem_ST1: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_st1(config->closure);
				break;
			}
			case __Sem_ST2: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_st2(config->closure);
				break;
			}
			case __Sem_ST3: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_st3(config->closure);
				break;
			}
			case __Sem_ST4: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_st4(config->closure);
				break;
			}
			case __Sem_ST5: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_st5(config->closure);
				break;
			}
			case __Sem_ST6: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_st6(config->closure);
				break;
			}
			case __Sem_ST7: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_st7(config->closure);
				break;
			}
			case __Sem_MM0: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_mm0(config->closure);
				break;
			}
			case __Sem_MM1: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_mm1(config->closure);
				break;
			}
			case __Sem_MM2: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_mm2(config->closure);
				break;
			}
			case __Sem_MM3: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_mm3(config->closure);
				break;
			}
			case __Sem_MM4: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_mm4(config->closure);
				break;
			}
			case __Sem_MM5: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_mm5(config->closure);
				break;
			}
			case __Sem_MM6: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_mm6(config->closure);
				break;
			}
			case __Sem_MM7: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_mm7(config->closure);
				break;
			}
			case __Sem_XMM0: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_xmm0(config->closure);
				break;
			}
			case __Sem_XMM1: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_xmm1(config->closure);
				break;
			}
			case __Sem_XMM2: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_xmm2(config->closure);
				break;
			}
			case __Sem_XMM3: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_xmm3(config->closure);
				break;
			}
			case __Sem_XMM4: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_xmm4(config->closure);
				break;
			}
			case __Sem_XMM5: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_xmm5(config->closure);
				break;
			}
			case __Sem_XMM6: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_xmm6(config->closure);
				break;
			}
			case __Sem_XMM7: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_xmm7(config->closure);
				break;
			}
			case __Sem_XMM8: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_xmm8(config->closure);
				break;
			}
			case __Sem_XMM9: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_xmm9(config->closure);
				break;
			}
			case __Sem_XMM10: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_xmm10(config->closure);
				break;
			}
			case __Sem_XMM11: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_xmm11(config->closure);
				break;
			}
			case __Sem_XMM12: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_xmm12(config->closure);
				break;
			}
			case __Sem_XMM13: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_xmm13(config->closure);
				break;
			}
			case __Sem_XMM14: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_xmm14(config->closure);
				break;
			}
			case __Sem_XMM15: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_xmm15(config->closure);
				break;
			}
		}

		return sem_id;
}
