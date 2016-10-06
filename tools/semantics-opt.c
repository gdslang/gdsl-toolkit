/* vim:cindent:ts=2:sw=2:expandtab */

#include <gdsl.h>
#include <gdsl_generic.h>
#include <getopt.h>
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/resource.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <time.h>
#include <unistd.h>

#include <err.h>
#include <fcntl.h>
#include <string.h>
#include <sysexits.h>

#include <gdsl_elf.h>

#define NANOS 1000000000LL

struct options {
  enum optimization_configuration opt_config;
  char elf;
  char* file;
  size_t offset;
  size_t length;
  char _continue;
};

enum p_option {
  OPTION_ELF,
  OPTION_FILE,
  OPTION_OFFSET,
  OPTION_LENGTH,
  OPTION_PRESERVATION,
  OPTION_LIVENESS,
  OPTION_FSUBST,
  OPTION_DELAYED_FSUBST,
  OPTION_CONTINUE
};

static char args_parse(int argc, char** argv, struct options* options) {
  options->elf = 0;
  options->file = NULL;
  options->opt_config = PRESERVATION_EVERYWHERE;
  options->offset = 0;
  options->length = 0;
  options->_continue = 0;

  struct option long_options[] = {
      {"elf", no_argument, NULL, OPTION_ELF},
      {"file", required_argument, NULL, OPTION_FILE},
      {"offset", required_argument, NULL, OPTION_FILE},
      {"length", required_argument, NULL, OPTION_LENGTH},
      {"preserve", required_argument, NULL, OPTION_PRESERVATION},
      {"liveness", no_argument, NULL, OPTION_LIVENESS},
      {"fsubst", no_argument, NULL, OPTION_FSUBST},
      {"delayed-fsubst", no_argument, NULL, OPTION_DELAYED_FSUBST},
      {"continue", no_argument, NULL, OPTION_CONTINUE},
      {NULL, 0, NULL, 0}};

  while (1) {
    int result = getopt_long(argc, argv, "", long_options, NULL);
    if (result == -1) break;
    switch (result) {
      case OPTION_ELF: {
        options->elf = 1;
        break;
      }
      case OPTION_FILE: {
        options->file = optarg;
        break;
      }
      case OPTION_OFFSET: {
        sscanf(optarg, "%zu", &options->offset);
        break;
      }
      case OPTION_LENGTH: {
        sscanf(optarg, "%zu", &options->length);
        break;
      }
      case OPTION_PRESERVATION: {
        if (!strcmp("everywhere", optarg)) {
          options->opt_config =
              (options->opt_config & 0xFFFFFFF8) | PRESERVATION_EVERYWHERE;
          break;
        }
        if (!strcmp("block", optarg)) {
          options->opt_config =
              (options->opt_config & 0xFFFFFFF8) | PRESERVATION_BLOCK;
          break;
        }
        if (!strcmp("context", optarg)) {
          options->opt_config =
              (options->opt_config & 0xFFFFFFF8) | PRESERVATION_CONTEXT;
          break;
        }
        return 2;
      }
      case OPTION_LIVENESS: {
        options->opt_config |= OC_LIVENESS;
        break;
      }
      case OPTION_FSUBST: {
        options->opt_config |= OC_FSUBST;
        break;
      }
      case OPTION_DELAYED_FSUBST: {
        options->opt_config |= OC_DELAYED_FSUBST;
        break;
      }
      case OPTION_CONTINUE: {
        options->_continue = 1;
        break;
      }
      case '?':
        return 1;
      case ':':
        return 1;
    }
  }

  if (options->file == NULL) return 3;

  return 0;
}

int main(int argc, char** argv) {
  // const rlim_t kStackSize = 64L * 1024L * 1024L; // min stack size = 64 Mb

  struct options options;
  if (args_parse(argc, argv, &options)) {
    printf(
        "Usage: semantics-opt [--elf] [--offset offset] [--length length] "
        "--file file [--preserve everywhere|block|context] [--liveness] "
        "[--fsubst] [--delayed-fsubst] [--continue]\n");
    return 1;
  }

  if (options.elf) {
    if (elf_section_boundary_get(options.file, &options.offset,
                                 &options.length)) {
      printf("cannot read section boundary\n");
      exit(1);
    }
  } else if (!options.length) {
    struct stat buf;
    stat(options.file, &buf);
    options.length = buf.st_size;
  }

  FILE* f = fopen(options.file, "r");
  if (!f) {
    printf("Unable to open file.\n");
    return 2;
  }
  if (fseek(f, options.offset, SEEK_SET)) {
    printf("Unable to seek to given offset.");
    return 3;
  }

  size_t buffer_size = options.length + 15;
  unsigned char* buffer = (unsigned char*)malloc(buffer_size);
  size_t buffer_length = fread(buffer, 1, buffer_size, f);

  fclose(f);

  state_t state = gdsl_init();
  gdsl_set_code(state, buffer, buffer_length, 0);

  size_t last_offset_ptr = 0;
  while (last_offset_ptr < options.length) {
    if (setjmp(*gdsl_err_tgt(state))) {
      fprintf(stderr, "Gdsl error: %s\n", gdsl_get_error_message(state));
      if (options._continue) {
        gdsl_seek(state, last_offset_ptr + 1);
      } else
        exit(4);
    }

    opt_result_t opt_result = gdsl_decode_translate_block_optimized(
        state, gdsl_config_default(state),
        //        gdsl_config_mode32(state),
        gdsl_int_max(state), options.opt_config);

    gdsl_rreil_pretty(state, opt_result->rreil);
    string_t fmt =
        gdsl_merge_rope(state, gdsl_rreil_pretty(state, opt_result->rreil));
    puts(fmt);

    last_offset_ptr = gdsl_get_ip(state);
    gdsl_reset_heap(state);
  }

  gdsl_destroy(state);
  free(buffer);

  return 0;
}
