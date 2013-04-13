
/* vim:cindent:ts=2:sw=2:expandtab */

#include <stdio.h>
#include <stdint.h>
#include <stdlib.h>
#include <dis.h>
#include <sys/resource.h>

int main (int argc, char** argv) {
    const rlim_t kStackSize = 64L * 1024L * 1024L;   // min stack size = 64 Mb
    struct rlimit rl;
    int result;

    result = getrlimit(RLIMIT_STACK, &rl);
    if (result == 0)
    {
        if (rl.rlim_cur < kStackSize)
        {
            rl.rlim_cur = kStackSize;
            result = setrlimit(RLIMIT_STACK, &rl);
            if (result != 0)
            {
                fprintf(stderr, "setrlimit returned result = %d\n", result);
            }
        }
    }

  size_t size = 16*1024*1024;
  char fmt[size];
  char fmt_state[size];
  __obj insn;

  if(argc != 4) {
    printf("Usage: sweep file offset length\n");
    return 1;
  }

  size_t offset;
  sscanf(argv[2], "%zu", &offset);
  size_t length;
  sscanf(argv[3], "%zu", &length);

  FILE *f = fopen(argv[1], "r");
  if(!f) {
    printf("Unable to open file.\n");
    return 1;
  }
  fseek(f, offset, SEEK_SET);

  size_t buffer_size = 16*length + 15;
  unsigned char *buffer = (unsigned char*)malloc(buffer_size);
  size_t buffer_length = fread(buffer, 1, buffer_size, f);

  __obj state = __createState(buffer, buffer_length, 0, 0);

  //uint64_t consumed = 0;
  __obj stack = __runMonadicNoArg(__translateBlock__, &state);
  
  //consumed += __decode(__decode__,buffer+consumed,buffer_length - consumed,&insn);
  //printf("Consumed: %lu\n", consumed);
  if (___isNil(stack))
    __fatal("Translate failed");
  else {
    __obj greedy = __runMonadicOneArg(__liveness__, &state, stack);
  __obj insns = __RECORD_SELECT(state, ___live);
    //__obj r = __translate(__translate__,insn);
    if(___isNil(greedy))
      __fatal("Translate failed");
    else {
			__pretty(__lv_pretty__,greedy,fmt_state,size);
      __pretty(__rreil_pretty__,stack,fmt,size);
      puts(fmt_state);
      puts(fmt);
    }
  }

  
  return (1);
}

