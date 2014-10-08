/* vim:cindent:ts=2:sw=2:expandtab */

#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <string.h>
#include <unistd.h>
#include <getopt.h>
#include <readhex.h>
#include <gdsl.h>
#include <decoder_config.h>

void print_help(state_t state, struct config_handlers handlers) {
  printf("Usage: decoder-cli --help (for help)\n");
  printf("Usage: decoder-cli (using default decoder options)\n");
  printf("Usage: decoder-cli [-- decoder-options] (explicit decoder configuration)\n");
  printf("Available decoder options:\n");
  decoder_config_print_options(state, handlers);
}

int main(int argc, char** argv) {
  char retval = 0;

  state_t state = gdsl_init();

  struct config_handlers handlers = { &gdsl_decoder_config, &gdsl_has_conf, &gdsl_conf_next, &gdsl_conf_short,
      &gdsl_conf_long, &gdsl_conf_data };
  int_t config = gdsl_config_default(state);
  for(size_t i = 1; i < argc; ++i) {
    if(!strcmp(argv[i], "--help")) {
      print_help(state, handlers);
      return 1;
    } else if(!strcmp(argv[i], "--")) {
      char success;
      config = decoder_config_from_args(&success, state, handlers, argc - i - 1, argv + i + 1);
      if(!success) {
        print_help(state, handlers);
        return 2;
      }
      break;
    } else {
      print_help(state, handlers);
      return 3;
    }
  }

  uint8_t *buffer;
  size_t size = readhex_hex_read(stdin, &buffer);

  gdsl_set_code(state, buffer, size, 0);

  if(setjmp(*gdsl_err_tgt(state))) {
    fprintf(stderr, "decode failed: %s\n", gdsl_get_error_message(state));
    retval = 1;
    goto cleanup;
  }

  size_t decoded_acc = 0;
  while(decoded_acc < size) {
    obj_t insn = gdsl_decode(state, config);

    size_t decoded = gdsl_get_ip(state);
    printf("[");
    for(size_t i = decoded_acc; i < decoded; ++i) {
      if(i != decoded_acc) printf(" ");
      printf("%02x", buffer[i]);
    }
    printf("] ");

    string_t fmt = gdsl_merge_rope(state, gdsl_pretty(state, insn));
    puts(fmt);

//    obj_t insn_asm = gdsl_generalize(state, insn);
//    string_t asm_gen_str = gdsl_merge_rope(state, gdsl_asm_pretty(state, insn_asm));
//    puts(asm_gen_str);

    decoded_acc = decoded;
  }

  cleanup:

  gdsl_destroy(state);
  free(buffer);

  return retval;
}

