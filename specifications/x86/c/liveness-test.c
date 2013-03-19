
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

  __obj state = __createState(NULL, 0, 0, 0);

  __obj r = __runMonadicNoArg(__tinsng__, &state);

  size_t size = 256*1024;
  char fmt[size];
  __pretty(__rreil_pretty__,r,fmt,size);
  puts(fmt);
  
  return 1;
}

