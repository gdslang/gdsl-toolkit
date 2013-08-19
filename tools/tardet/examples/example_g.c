#include <stdio.h>
#include <stdlib.h>

void __exit() {
	exit(0);
}

int main(void) {
	FILE *f = fopen("example.bin", "w");
	if(!f)
		return 1;
	
	for(void *i = &&start; i < &&end; i++)
		fwrite(i, 1, 1, f);

	fclose(f);

	__exit();

	start:
	asm (
//"mov $99, %rax\n"
"cmp $99, %rax\n"
"jne else\n"
"mov $999, %rbx\n"
"jmp after\n"
"else:\n"
"mov $777, %rbx\n"
"after:\n"
"jmp %rbx\n"
);
	end:;

	return 0;
}
