#include <stdio.h>
#include <stdlib.h>

void _exit() {
	exit(0);
}

int main(void) {
	FILE *f = fopen("example_a.bin", "w");
	if(!f)
		return 1;
	
	for(void *i = &&start; i < &&end; i++)
		fwrite(i, 1, 1, f);

	fclose(f);

	_exit();

	start:
	asm ("mov $999, %rax\n"
"add $42, %rax\n"
"mov $62, %ah\n"
"jmp %rax\n");
	end:;

	return 0;
}
