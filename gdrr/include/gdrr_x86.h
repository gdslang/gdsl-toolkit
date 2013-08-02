/*
 * x86.h
 *
 *  Created on: Mar 10, 2013
 *      Author: jucs
 */

#ifndef GDRR_X86_H_
#define GDRR_X86_H_

#include "gdrr.h"

gdrr_sem_id_t *gdrr_convert_sem_id_x86(obj_t sem_id_obj,
		struct gdrr_config *config);

#endif /* GDRR_X86_H_ */
