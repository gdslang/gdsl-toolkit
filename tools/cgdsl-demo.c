/*
 * cgdsl-demo.c
 *
 *  Created on: Jun 12, 2015
 *      Author: Julian Kranz
 */

#include <gdsl.h>
#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <gdsl_multiplex.h>
#include <rreil/gdrr_builder.h>
#include <rreil/rreil.h>

/*
 * Translate an opaque pointer to rreil instructions to a list of cgdsl statements
 */
static void cgdsl_rreil_print(state_t state, struct frontend *frontend, obj_t rreil) {
  callbacks_t callbacks = rreil_gdrr_builder_callbacks_get(state);
  struct rreil_statements *statements = (struct rreil_statements*)frontend->translator.rreil_convert_sem_stmt_list(state,
      callbacks, rreil);
  free(callbacks);

  rreil_statements_print(stdout, statements);
  rreil_statements_free(statements);
}

/**
 * Decode and translate a single x86 instruction
 */
static char single(obj_t *rreil, state_t state, struct frontend *frontend) {
  uint8_t insn_x86[] = { 0x00, 0x00, 0x00, 0x00 };

  /*
   * We set the input stream for the frontend.
   */
  frontend->generic.set_code(state, insn_x86, sizeof(insn_x86), 0);

  /*
   * The following block is used to catch exceptions occurring during decoding.
   */
  if(setjmp(*frontend->generic.err_tgt(state))) {
    fprintf(stderr, "decode failed: %s\n", frontend->generic.get_error_message(state));
    return 1;
  }

  obj_t insn = frontend->decoder.decode(state, frontend->decoder.config_default(state));

  /*
   * The following block is used to catch exceptions occurring during translation.
   */
  if(setjmp(*frontend->generic.err_tgt(state))) {
    fprintf(stderr, "translate failed: %s\n", frontend->generic.get_error_message(state));
    return 1;
  }

  *rreil = frontend->translator.translate(state, insn);

  return 0;
}

/*
 * Decode, translate and optimize a basic block of x86 instructions
 */
static char optimized_block(obj_t *rreil, state_t state, struct frontend *frontend) {
  uint8_t add_add_ret[] = { 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0xc3 };

  frontend->generic.set_code(state, add_add_ret, sizeof(add_add_ret), 0);

  /*
   * The following block is used to catch exceptions occurring during decoding/translation/optimization.
   */
  if(setjmp(*frontend->generic.err_tgt(state))) {
    fprintf(stderr, "decode_translate_block_optimized failed: %s\n", frontend->generic.get_error_message(state));
    return 1;
  }

  /*
   * We decode x86, translate it to RReil and optimize the RReil code. We use the highest possible optimization level.
   */
  opt_result_t opt_result = frontend->translator.decode_translate_block_optimized(state,
      frontend->decoder.config_default(state), INT64_MAX, PRESERVATION_CONTEXT | OC_LIVENESS | OC_LIVENESS);

  /*
   * Native instructions
   */
//  obj_t insns = opt_result->insns;

  *rreil = opt_result->rreil;

  return 0;
}

int main() {
  char retval = 0;

  struct frontend_desc *frontends;

  /*
   * Get the list of frontends...
   */
  size_t frontends_count = gdsl_multiplex_frontends_list(&frontends);

  /*
   * We let the user choose a frontend. Since this example program is for
   * x86 only, he should choose the x86 frontend.
   */

  size_t frontend_ind = 0;
  if(!frontends_count) {
    fprintf(stderr, "No frontends available.\n");
    return 1;
  }
  if(frontends_count > 1) {
    printf("Available frontends:\n");
    for(size_t i = 0; i < frontends_count; ++i)
      printf("\t[%zu] %s\n", i, frontends[i].name);
    printf("Your choice (please choose the x86-rreil frontend!)? ");
    if(scanf("%zu", &frontend_ind) <= 0) frontend_ind = 0;
  }

  if(frontend_ind >= frontends_count) {
    fprintf(stderr, "Frontend %zu is invalid.\n", frontend_ind);
    return 1;
  }

  printf("Using frontend %s...\n", frontends[frontend_ind].name);

  /*
   * We open the frontend...
   */
  struct frontend frontend;
  if(gdsl_multiplex_frontend_get_by_desc(&frontend, frontends[frontend_ind])) {
    fprintf(stderr, "Unable to open frontend.\n");
    return 1;
  }

  /*
   * We create the GDSL state
   */
  state_t state = frontend.generic.init();

  obj_t rreil;

  /*
   * We decode one x86 instruction.
   */
  if(single(&rreil, state, &frontend)) {
    retval = 1;
    goto cleanup;
  }
  /*
   * We do something with the RReil statements...
   */
  cgdsl_rreil_print(state, &frontend, rreil);

  printf("###################################\n");

  /*
   * We decode one basic block x86 instructions.
   */
  if(optimized_block(&rreil, state, &frontend)) {
    retval = 1;
    goto cleanup;
  }
  /*
   * We do something with the RReil statements...
   */
  cgdsl_rreil_print(state, &frontend, rreil);

  cleanup:
  frontend.generic.destroy(state);
  gdsl_multiplex_descs_free(frontends, frontends_count);
  gdsl_multiplex_frontend_close(&frontend);

  return retval;
}
