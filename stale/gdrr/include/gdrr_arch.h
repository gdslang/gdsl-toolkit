/*
 * gdrr_arch.h
 *
 *  Created on: Mar 10, 2013
 *      Author: jucs
 */

#ifndef GDRR_ARCH_H_
#define GDRR_ARCH_H_

#include "gdrr.h"

gdrr_sem_id_t *gdrr_convert_sem_id_arch(obj_t sem_id_obj,
		struct gdrr_config *config);

#endif /* GDRR_ARCH_H_ */
