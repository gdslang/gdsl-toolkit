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

enum p_option {
  OPTION_ELF, OPTION_FILE, OPTION_OFFSET, OPTION_LENGTH, OPTION_RREIL
};

enum mode {
  MODE_BIN, MODE_ELF
};

struct options {
  enum mode mode;
  char *file;
  size_t offset;
  size_t length;
  char translate;
};

static char args_parse(int argc, char **argv, struct options *options) {
  options->mode = MODE_BIN;
  options->file = NULL;
  options->offset = 0;
  options->length = 0;
  options->translate = 0;

  struct option long_options[] = { { "elf", no_argument, NULL, OPTION_ELF }, { "offset", required_argument, NULL,
      OPTION_OFFSET }, { "length", required_argument, NULL, OPTION_LENGTH }, { "file", required_argument,
  NULL, OPTION_FILE }, { "translate", no_argument, NULL, OPTION_RREIL }, { NULL, 0, NULL, 0 } };

  while(1) {
    int result = getopt_long(argc, argv, "", long_options, NULL);
    if(result < 0) break;
    switch(result) {
      case OPTION_ELF: {
        options->mode = MODE_ELF;
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
      case OPTION_FILE: {
        options->file = optarg;
        break;
      }
      case OPTION_RREIL: {
        options->translate = 1;
        break;
      }
      case '?':
        return 2;
    }
  }

  return 0;
}

int main(int argc, char** argv) {
  const rlim_t kStackSize = 64L * 1024L * 1024L; // min stack size = 64 Mb
  struct rlimit rl;
  int result;

  result = getrlimit(RLIMIT_STACK, &rl);
  if(result == 0) {
    if(rl.rlim_cur < kStackSize) {
      rl.rlim_cur = kStackSize;
      result = setrlimit(RLIMIT_STACK, &rl);
      if(result != 0) {
        fprintf(stderr, "setrlimit returned result = %d\n", result);
      }
    }
  }

  struct options options;
  if(args_parse(argc, argv, &options)) {
    printf("Usage: sweep [--elf] [--offset o] [--length l] [--translate] --file f\n");
    return 1;
  }

  if(!options.file) {
    printf("No file :/\n");
    printf("Usage: sweep [--elf] [--offset o] [--length l] [--translate] --file f\n");
    return 2;
  }

//  if(options.mode == MODE_ELF && (options.offset || options.length)) {
//    printf("ELF files neither like the offset nor the length option :-(\n");
//    printf("Usage: sweep [--elf] [--offset o] [--length l] [--translate] --file f\n");
//    return 3;
//  }

  if(options.mode == MODE_BIN && !options.length) {
    struct stat buf;
    stat(options.file, &buf);
    if(options.offset < buf.st_size) {
      options.length = buf.st_size - options.offset;
    }
  } else if(options.mode == MODE_ELF) {
    size_t offset;
    size_t length;
    char e = elf_section_boundary_get(options.file, &offset, &length);
    if(e) {
      printf("elf_section_boundary_get() does not like this file :/\n");
      return 4;
    }
    if(!options.length || options.length > length) options.length = length;
    options.offset += offset;
  }

  FILE *f = fopen(options.file, "r");
  if(!f) {
    printf("Unable to open file.\n");
    return 5;
  }
  fseek(f, options.offset, SEEK_SET);

  size_t buffer_size = options.length + 15;
  char *buffer = (char*) malloc(buffer_size);
  size_t buffer_length = fread(buffer, 1, buffer_size, f);

  fclose(f);

  state_t state = gdsl_init();
  gdsl_set_code(state, buffer, buffer_length, 0);

  struct timespec start;
  struct timespec end;

  size_t memory_dec = 0;
  size_t memory_dec_tran = 0;

  size_t memory_dec_max = 0;
  size_t memory_dec_tran_max = 0;

  size_t instructions = 0;

  clock_gettime(CLOCK_REALTIME, &start);

  size_t last_offset = 0;
  while(last_offset < options.length) {
//		printf("++++++++++++ DECODING NEXT INSTRUCTION ++++++++++++\n");

    if(setjmp(*gdsl_err_tgt(state))) {
      fprintf(stderr, "decode failed: %s\n", gdsl_get_error_message(state));
      break;
    }
    obj_t insn = gdsl_decode(state, gdsl_config_default(state));

    printf("[");
    size_t decoded = gdsl_get_ip_offset(state) - last_offset;
    for(size_t i = 0; i < decoded; ++i) {
      if(i) printf(" ");
      printf("%02x", ((uint8_t*) buffer)[last_offset + i]);
    }
    printf("] ");

    string_t fmt = gdsl_merge_rope(state, gdsl_pretty(state, insn));
    puts(fmt);

    size_t residency = gdsl_heap_residency(state);
    memory_dec += residency;
    if(residency > memory_dec_max) memory_dec_max = residency;

    if(options.translate) {
      printf("---------------------------\n");

      if(setjmp(*gdsl_err_tgt(state))) {
        fprintf(stderr, "translate failed: %s\n", gdsl_get_error_message(state));
        break;
      }
      obj_t rreil = gdsl_translate(state, insn);

      fmt = gdsl_merge_rope(state, gdsl_rreil_pretty(state, rreil));
      puts(fmt);
    }

    residency = gdsl_heap_residency(state);
    memory_dec_tran += residency;
    if(residency > memory_dec_tran_max) memory_dec_tran_max = residency;

    gdsl_reset_heap(state);

    instructions++;
    last_offset = gdsl_get_ip_offset(state);
  }

  clock_gettime(CLOCK_REALTIME, &end);
  long time = end.tv_sec * NANOS + end.tv_nsec - start.tv_nsec - start.tv_sec * NANOS;

  gdsl_destroy(state);
  free(buffer);

  fprintf(stderr, "---------------------------\n");
  fprintf(stderr, "Statistics\n");
  fprintf(stderr, "Instruction count: %zu\n", instructions);
  fprintf(stderr, "Decoder: Total memoy: %zu, maximal memoy: %zu\n", memory_dec, memory_dec_max);
  fprintf(stderr, "Decoder + Translator: Total memoy: %zu, maximal memoy: %zu\n", memory_dec_tran, memory_dec_tran_max);
  fprintf(stderr, "time: %lf seconds\n", time / (double) (1000000000));

  return 0;
}

