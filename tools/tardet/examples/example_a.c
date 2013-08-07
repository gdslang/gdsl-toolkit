#include <stdio.h>
#include <stdlib.h>

int main(void) {
	goto end;
	start:
	__asm__ ("mov $999, %rax\n"
"add $42, %rax\n"
"mov $62, %ah\n"
"jmp %rax\n");
	end:;

	FILE *f = fopen("example_a.bin", "w");
	if(!f)
		return 1;
	
	for(void *i = &&start; i < &&end; i++)
		fwrite(i, 1, 1, f);

	fclose(f);

	return 0;
}
