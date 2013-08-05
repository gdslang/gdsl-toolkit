/*
 * igdrr.c
 *
 *  Created on: 22.07.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <gdsl-x86.h>
#include <rreil/gdrr_builder.h>
#include <gdrr.h>

struct rreil_statements *statements_get(state_t state, obj_t rreil) {
		struct gdrr_config *config = rreil_gdrr_builder_config_get(state);
		struct rreil_statements *statements = (struct rreil_statements*)gdrr_convert(
				rreil, config);
		free(config);
		return statements;
}
