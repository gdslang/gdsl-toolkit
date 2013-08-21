#define _GNU_SOURCE
#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>

int main(void) {
	char *text;
	size_t text_length;
	FILE *text_stream = open_memstream(&text, &text_length);

	FILE *input_stream = fopen("opcodes", "r");
	while(!feof(input_stream))
		fputc(fgetc(input_stream), text_stream);
	fclose(input_stream);

	fputc(0, text_stream);
	fclose(text_stream);

//	printf("%s", text);

	char found = 0;

	void add_offset() {
		if(found)
			printf("util_array_generic_add((void**)&table->offsets, &opcodes_offset, sizeof(opcodes_size), &table->offsets_length, &offsets_size);\n");
	}

	for (size_t i = 0; i < text_length - 3; ++i) {
		if(text[i] == '0' && text[i + 1] == 'x') {
			printf("opcodes_offset = util_byte_append(&table->opcodes, opcodes_offset, &opcodes_size, 0x%c%c);\n", text[i + 2], text[i + 3]);
			found = 1;
		} else if(text[i] == '\n')
			add_offset();
	}
	add_offset();

	free(text);

	return 0;
}
