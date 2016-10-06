/*
 * decoder_config.h
 *
 *  Created on: Jul 17, 2014
 *      Author: Julian Kranz
 */

#pragma once

#include <gdsl_generic.h>

struct config_handlers {
  obj_t (*decoder_config)(state_t state);
  int_t (*has_conf)(state_t state, obj_t config);
  obj_t (*conf_next)(state_t state, obj_t config);
  string_t (*conf_short)(state_t state, obj_t config);
  string_t (*conf_long)(state_t state, obj_t config);
  int_t (*conf_data)(state_t state, obj_t config);
};

extern int_t decoder_config_from_args(char* success, state_t s,
                                      struct config_handlers handlers, int argc,
                                      char** argv);
extern void decoder_config_print_options(state_t s,
                                         struct config_handlers handlers);
