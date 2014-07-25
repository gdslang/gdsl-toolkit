/*
 * decoder_config.c
 *
 *  Created on: Jul 17, 2014
 *      Author: Julian Kranz
 */

#include <decoder_config.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int_t decoder_config_from_args(char *success, state_t s, struct config_handlers handlers, int argc, char **argv) {
  int_t options = 0;
  for(size_t i = 0; i < argc; ++i) {
    *success = 0;
    char *arg = argv[i];
    for(obj_t config = handlers.decoder_config(s); handlers.has_conf(s, config); config = handlers.conf_next(s, config)) {
      if(strlen(arg) > 2 && arg[0] == '-' && arg[1] == '-')
        arg += 2;
      if(strcmp(arg, handlers.conf_short(s, config)) == 0) {
        options |= handlers.conf_data(s, config);
        *success = 1;
        break;
      }
    }
  }
  return options;
}

void decoder_config_print_options(state_t s, struct config_handlers handlers) {
  for(obj_t config = handlers.decoder_config(s); handlers.has_conf(s, config); config = handlers.conf_next(s, config))
    fprintf(stderr, "\t--%s\t\t%s\n", handlers.conf_short(s, config), handlers.conf_long(s, config));
}
