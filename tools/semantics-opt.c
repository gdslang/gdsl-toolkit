/* vim:cindent:ts=2:sw=2:expandtab */

#include <stdlib.h>
#include <stdint.h>
#include <stdio.h>
#include <gdsl.h>
#include <sys/resource.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>
#include <time.h>
#include <getopt.h>

#include <err.h>
#include <fcntl.h>
#include <string.h>
#include <sysexits.h>

#include <gdsl_elf.h>

#define NANOS 1000000000LL

struct options {
  long preservation;
  char elf;
  char *file;
  size_t offset;
  size_t length;
};

enum p_option {
  OPTION_ELF, OPTION_FILE, OPTION_OFFSET, OPTION_LENGTH, OPTION_PRESERVATION
};

static char args_parse(int argc, char **argv, struct options *options) {
  options->elf = 0;
  options->file = NULL;
  options->preservation = CON_SEM_PRESERVATION_EVERYWHERE;
  options->offset = 0;
  options->length = 0;

  struct option long_options[] = {{"elf", no_argument, NULL, OPTION_ELF},
      {"file", required_argument, NULL, OPTION_FILE}, {"offset", required_argument, NULL, OPTION_FILE}, {"length",
      required_argument, NULL, OPTION_LENGTH}, {"preserve", required_argument, NULL, OPTION_PRESERVATION}, {NULL, 0,
          NULL, 0}};

  while(1) {
    int result = getopt_long(argc, argv, "", long_options, NULL);
    if(result == -1) break;
    switch(result) {
      case OPTION_ELF: {
        options->elf = 1;
        break;
      }
      case OPTION_FILE: {
        options->file = optarg;
        break;
      }
      case OPTION_OFFSET: {
        sscanf(optarg, "%lu", &options->offset);
        break;
      }
      case OPTION_LENGTH: {
        sscanf(optarg, "%lu", &options->length);
        break;
      }
      case OPTION_PRESERVATION: {
        if(!strcmp("everywhere", optarg)) {
          options->preservation = CON_SEM_PRESERVATION_EVERYWHERE;
          break;
        }
        if(!strcmp("block", optarg)) {
          options->preservation = CON_SEM_PRESERVATION_BLOCK;
          break;
        }
        if(!strcmp("context", optarg)) {
          options->preservation = CON_SEM_PRESERVATION_CONTEXT;
          break;
        }
        return 2;
      }
      case '?':
        return 1;
      case ':':
        return 1;
    }
  }

  if(options->file == NULL) return 3;

  return 0;
}

int main(int argc, char** argv) {
  //const rlim_t kStackSize = 64L * 1024L * 1024L; // min stack size = 64 Mb

  struct options options;
  if(args_parse(argc, argv, &options)) {
    printf(
        "Usage: semantics-opt [--elf] [--offset offset] [--length length] --file file [--preserve everywhere|block|context]\n");
    return 1;
  }

  if(options.elf) {
    if(elf_section_boundary_get(options.file, &options.offset, &options.length)) {
      printf("cannot read section boundary\n");
      exit(1);
    }
  } else if(!options.length) {
    struct stat buf;
    stat(options.file, &buf);
    options.length = buf.st_size;
  }

  FILE *f = fopen(options.file, "r");
  if(!f) {
    printf("Unable to open file.\n");
    return 2;
  }
  if(fseek(f, options.offset, SEEK_SET)) {
    printf("Unable to seek to given offset.");
    return 3;
  }

  size_t buffer_size = options.length + 15;
  char *buffer = (char*)malloc(buffer_size);
  size_t buffer_length = fread(buffer, 1, buffer_size, f);

  fclose(f);

  state_t state = gdsl_init();
  gdsl_set_code(state, buffer, buffer_length, 0);

  if(setjmp(*gdsl_err_tgt(state))) {
    fprintf(stderr, "Gdsl error: %s\n", gdsl_get_error_message(state));
    exit(4);
  }

  size_t last_offset = 0;
  while(last_offset < options.length) {
    obj_t rreil = gdsl_decode_translate_block_optimized(state, gdsl_config_default(state), gdsl_int_max(state),
        options.preservation);

    string_t fmt = gdsl_merge_rope(state, gdsl_rreil_pretty(state, rreil));
    puts(fmt);

    gdsl_reset_heap(state);

    last_offset = gdsl_get_ip_offset(state);
  }

  gdsl_destroy(state);
  free(buffer);

  return 0;
}

