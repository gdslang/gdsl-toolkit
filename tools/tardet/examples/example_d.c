#include <stdio.h>
#include <stdlib.h>

void _exit() {
	exit(0);
}

int main(void) {
	FILE *f = fopen("example.bin", "w");
	if(!f)
		return 1;
	
	for(void *i = &&start; i < &&end; i++)
		fwrite(i, 1, 1, f);

	fclose(f);

	_exit();

	start:
	asm (
"mov $0x0000776655443322, %rax\n"
"mov $0x10, %rbx\n"
"lea (%rax, %rbx, 2), %rax\n"
"jmp %rax\n"
);
	end:;

	return 0;
}
