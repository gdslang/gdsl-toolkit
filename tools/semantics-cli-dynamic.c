/*
 * dectran-cli-generic.c
 *
 *  Created on: Sep 11, 2013
 *      Author: jucs
 */

#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <readhex.h>
#include <gdsl_multiplex.h>

int main(int argc, char** argv) {
  char retval = 0;

  struct frontend_desc *frontends;
  size_t frontends_count = gdsl_multiplex_frontends_list(&frontends);

  size_t frontend_ind = 0;
  if(!frontends_count) {
    fprintf(stderr, "No frontends available.\n");
    return 1;
  }
  if(frontends_count > 1) {
    printf("Available frontends:\n");
    for(size_t i = 0; i < frontends_count; ++i)
      printf("\t[%zu] %s\n", i, frontends[i].name);
    printf("Your choice? ");
    if(scanf("%zu", &frontend_ind) <= 0) frontend_ind = 0;
  }

  if(frontend_ind >= frontends_count) {
    fprintf(stderr, "Frontend %zu is invalid.\n", frontend_ind);
    return 1;
  }

  printf("Using frontend %s...\n", frontends[frontend_ind].name);

//	__fpurge(stdin);

  uint8_t *buffer;
  size_t size = readhex_hex_read(stdin, &buffer);

  struct frontend frontend;
  if(gdsl_multiplex_frontend_get_by_desc(&frontend, frontends[frontend_ind])) {
    fprintf(stderr, "Unable to open frontend.\n");
    return 1;
  }

  state_t state = frontend.generic.init();
  frontend.generic.set_code(state, (char*)buffer, size, 0);

  if(setjmp(*frontend.generic.err_tgt(state))) {
    fprintf(stderr, "decode failed: %s\n", frontend.generic.get_error_message(state));
    retval = 1;
    goto cleanup;
  }
  obj_t insn = frontend.decoder.decode(state, frontend.decoder.config_default(state));

  printf("[");
  size_t decoded = frontend.generic.get_ip_offset(state);
  for(size_t i = 0; i < decoded; ++i) {
    if(i) printf(" ");
    printf("%02x", buffer[i]);
  }
  printf("] ");

  string_t fmt = frontend.generic.merge_rope(state, frontend.decoder.pretty(state, insn));
  puts(fmt);

  //printf("Mnemonic: %s\n", frontend.generic.merge_rope(state, frontend.decoder.pretty_mnemonic(state, insn)));
  //int_t operands = frontend.decoder.operands(state, insn);
  //printf("Number of operands: %lld\n", operands);
  //for(int_t i = 0; i < operands; ++i) {
  //  printf("Operand %lld (type: %lld): %s\n", i, frontend.decoder.typeof_opnd(state, insn, i),
  //      frontend.generic.merge_rope(state, frontend.decoder.pretty_operand(state, insn, i)));
  //}

  printf("---------------------------\n");

  if(setjmp(*frontend.generic.err_tgt(state))) {
    fprintf(stderr, "translate failed: %s\n", frontend.generic.get_error_message(state));
    retval = 1;
    goto cleanup;
  }

  obj_t rreil = frontend.translator.translate(state, insn);

  fmt = frontend.generic.merge_rope(state, frontend.translator.pretty(state, rreil));
  puts(fmt);

  cleanup:

  frontend.generic.destroy(state);
  free(buffer);

  gdsl_multiplex_descs_free(frontends, frontends_count);
  gdsl_multiplex_frontend_close(&frontend);

  return retval;
}

