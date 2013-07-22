/*
 * igdrr.c
 *
 *  Created on: 22.07.2013
 *      Author: jucs
 */

#include <stdlib.h>
#include <stdio.h>
#include <dis.h>

struct rreil_statements *statements_get(__obj rreil) {
		struct gdrr_config *config = rreil_gdrr_builder_config_get();
		struct rreil_statements *statements = (struct rreil_statements*)gdrr_convert(
				rreil, config);
		free(config);
		return statements;
}
