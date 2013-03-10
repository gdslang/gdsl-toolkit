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
			case __Sem_SP: {
				sem_id = config->callbacks.arch.x86.sem_id.sem_sp(config->closure);
				break;
			}
		}

		return sem_id;
}
