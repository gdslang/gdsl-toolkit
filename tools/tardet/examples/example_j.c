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
"mov $0x207, %rcx\n"
//"mov $99, %rdx\n"
"cmp $99, %rdx\n"
"jne elseb\n"
"add $0x99, %rcx\n"
"jmp afterb\n"
"elseb:\n"
"sub $0x77, %rcx\n"
"afterb:\n"
"shl $2, %rcx\n"
//"add $2, %rcx\n"

"mov $0x207, %rbx\n"
//"mov $99, %rax\n"
"cmp $99, %rax\n"
"jne else\n"
"add $0x99, %rbx\n"
"jmp after\n"
"else:\n"
"sub $0x77, %rbx\n"
"after:\n"
"shl $2, %rbx\n"
//"add $2, %rbx\n"
"add %rcx, %rbx\n"
"jmp %rbx\n"
);
	end:;

	return 0;
}
