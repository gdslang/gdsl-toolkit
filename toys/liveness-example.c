#include <stdio.h>
#include <stdlib.h>

int main(void) {
	int a;
	int b;
	int c;
	int d;

	start:
	a = 12;
	b = 55;
	c = 99;
	a = b*c + 66;
	b = a - c;
	c = (a + b)*(c - b);
	a = 3 + 77*c;
	d = 7*a + 2*(c - 3*b);
	c = b + 2*a - 3*d - 99*(a - 27*c);
	b = 66*(a + b + c + d);
	__asm__ ("jmp label\nlabel:\n");
	end:;

	FILE *f = fopen("liveness-example.bin", "w");
	if(!f)
		return 1;
	
	for(void *i = &&start; i < &&end; i++)
		fwrite(i, 1, 1, f);

	fclose(f);

	return 0;
}
