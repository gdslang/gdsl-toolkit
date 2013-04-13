
/* vim:cindent:ts=2:sw=2:expandtab */

#include <stdio.h>
#include <stdint.h>
#include <stdlib.h>
#include <dis.h>
#include <sys/resource.h>

int main (int argc, char** argv) {
    const rlim_t kStackSize = 512L * 1024L * 1024L;   // min stack size = 64 Mb
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
	char *fmt = (char*)malloc(size);

  if(argc != 2) {
    printf("Usage: liveness-sweep file\n");
    return 1;
  }

  FILE *f = fopen(argv[1], "r");
  if(!f) {
    printf("Unable to open file.\n");
    return 1;
  }

  size_t buffer_size = 128;
  unsigned char *buffer = NULL;
	size_t buffer_length = 0;
	do {
		buffer_size *= 2;
		buffer = (unsigned char*)realloc(buffer, buffer_size);
  	buffer_length += fread(buffer + buffer_length, 1, buffer_size - buffer_length, f);
	} while(!feof(f));

	fclose(f);

  __obj state = __createState(buffer, buffer_length, 0, 0);

  __obj rreil_instructions = __runMonadicNoArg(__translateBlock__, &state);

	if(!__isNil(rreil_instructions)) {
    __fatal("TranslateBlock failed");
		goto end;
	}
  
  __obj greedy_state = __runMonadicOneArg(__liveness__, &state, rreil_instructions);
	if(!__isNil(greedy_state)) {
    __fatal("Liveness failed");
		goto end;
	}

  __obj rreil_instructions_greedy = __RECORD_SELECT(state, ___live);
	if(!__isNil(rreil_instructions_greedy)) {
    __fatal("Liveness failed (no greedy instructions)");
		goto end;
	}

	printf("Liveness greedy state:\n");
	__pretty(__lv_pretty__,greedy_state,fmt,size);
  puts(fmt);
	printf("\n");
  
	printf("Initial RREIL instructions:\n");
	__pretty(__rreil_pretty__,rreil_instructions,fmt,size);
  puts(fmt);
	printf("\n");

	size_t lines = 0;
	for(size_t i = 0; fmt[i]; i++)
		if(fmt[i] == '\n')
			lines++;
  
	printf("RREIL instructions after LV (greedy):\n");
	__pretty(__rreil_pretty__,rreil_instructions_greedy,fmt,size);
  puts(fmt);
	printf("\n");

	size_t lines_greedy = 0;
	for(size_t i = 0; fmt[i]; i++)
		if(fmt[i] == '\n')
			lines_greedy++;

	printf("Statistics:\n");
	printf("Number of lines without LV analysis: %zu\n", lines);
	printf("Number of lines with LV analysis: %zu\n", lines_greedy);
	
	double reduction = 1 - (lines_greedy/(double)lines);

	printf("Reduction: %lf%%\n", 100*reduction);

	end:
	free(buffer);
	free(fmt);

  
  return (1);
}

