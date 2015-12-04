/*
 * gdsl_multiplex.c
 *
 *  Created on: Sep 11, 2013
 *      Author: jucs
 */

//#define __USE_XOPEN2K8
#define _POSIX_C_SOURCE 200809L
#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <string.h>

#include <gdsl.h>
#include <gdsl_multiplex.h>

static char frontend_get(struct frontend_desc *desc, char *file) {
  desc->name = "dummy";
  desc->ext = "so";
  return 0;
}

size_t gdsl_multiplex_frontends_list_with_base(struct frontend_desc **descs, char const *base) {
  *descs = (struct frontend_desc*) malloc(sizeof(struct frontend_desc) * 1);

  struct frontend_desc desc;
  frontend_get(&desc, NULL);
  (*descs)[0] = desc;

  return 1;
}

size_t gdsl_multiplex_frontends_list(struct frontend_desc **descs) {
  return gdsl_multiplex_frontends_list_with_base(descs, NULL);
}

#define ADD_FUNCTION_GENERIC(CAT, FUNC, NAME) frontend->CAT.FUNC = &NAME;
#define ADD_FUNCTION(CAT, FUNC) ADD_FUNCTION_GENERIC(CAT, FUNC, gdsl_##FUNC)

static char gdsl_multiplex_frontend_get(struct frontend *frontend, void *dl) {
  ADD_FUNCTION(generic, init)
  ADD_FUNCTION(generic, set_code)
  ADD_FUNCTION(generic, seek)
  ADD_FUNCTION(generic, err_tgt)
  ADD_FUNCTION(generic, get_error_message)
  ADD_FUNCTION(generic, reset_heap)
  ADD_FUNCTION(generic, destroy)
  ADD_FUNCTION(generic, get_ip)
  ADD_FUNCTION(generic, merge_rope)
  ADD_FUNCTION(decoder, config_default)
  ADD_FUNCTION(decoder, decoder_config)
  ADD_FUNCTION(decoder, has_conf)
  ADD_FUNCTION(decoder, conf_next)
  ADD_FUNCTION(decoder, conf_short)
  ADD_FUNCTION(decoder, conf_long)
  ADD_FUNCTION(decoder, conf_data)
  ADD_FUNCTION(decoder, decode)
  ADD_FUNCTION(decoder, generalize)
  ADD_FUNCTION(decoder, asm_convert_insn)
  ADD_FUNCTION(decoder, pretty)
  ADD_FUNCTION(translator, translate)
  ADD_FUNCTION_GENERIC(translator, pretty, "gdsl_rreil_pretty")
  ADD_FUNCTION(translator, pretty_arch_id)
  ADD_FUNCTION(translator, pretty_arch_exception)
  ADD_FUNCTION(translator, rreil_convert_sem_stmt_list)
  ADD_FUNCTION(translator, optimization_config)
  ADD_FUNCTION(translator, decode_translate_block_optimized)
  ADD_FUNCTION(translator, traverse_insn_list)

  frontend->dl = NULL;

  return GDSL_MULTIPLEX_ERROR_NONE;
}

static char gdsl_multiplex_frontend_library_open_desc(void **dl, struct frontend_desc desc) {
  *dl = NULL;
  return 0;
}

char gdsl_multiplex_frontend_get_by_desc(struct frontend *frontend, struct frontend_desc desc) {
  void *dl;
  char error = gdsl_multiplex_frontend_library_open_desc(&dl, desc);
  if(error) return error;

  return gdsl_multiplex_frontend_get(frontend, dl);
}

char gdsl_multiplex_frontend_get_by_lib_name(struct frontend *frontend, char const *name) {
  void *dl = NULL;
  return gdsl_multiplex_frontend_get(frontend, dl);
}

void gdsl_multiplex_descs_free(struct frontend_desc *descs, size_t descs_length) {
  free(descs);
}

void gdsl_multiplex_frontend_close(struct frontend *backend) {
}
