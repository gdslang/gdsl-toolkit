
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

  size_t size = 256*1024;
  char fmt[size];
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

  size_t buffer_size = length + 15;
  unsigned char *buffer = (unsigned char*)malloc(buffer_size);
  size_t buffer_length = fread(buffer, 1, buffer_size, f);

  uint64_t consumed = 0;
  while(consumed + 15 < buffer_length) {
    printf("++++++++++++ DECODING NEXT INSTRUCTION ++++++++++++\n");
    consumed += __decode(__decode__,buffer+consumed,buffer_length - consumed,&insn);
    printf("Consumed: %lu\n", consumed);
    if (___isNil(insn))
      __fatal("Decode failed");
    else {
      __pretty(__pretty__,insn,fmt,size);
      puts(fmt);
  
      printf("---------------------------\n");
     
      __obj r = __translate(__translate__,insn);
      if(___isNil(r))
        __fatal("Translate failed");
      else {
        __pretty(__rreil_pretty__,r,fmt,size);
        puts(fmt);
      }
    }
  }

  
  return (1);
}

