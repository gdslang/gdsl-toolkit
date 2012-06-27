/*
 * readhex.c
 *
 *  Created on: May 28, 2012
 *      Author: jucs
 */

#include <stdlib.h>
#include <readhex.h>

size_t readhex_hex_read(FILE *f, char **buffer) {
	size_t size = 32;
	size_t length = 0;
	*buffer = (char*)malloc(size);

	while(1) {
		size_t size_str = 2;
		size_t length_str = 0;
		char target[size_str];
		while(1) {
			if(feof(f))
				goto end_read;
			char next = getc(f);
			if(next == '\n')
				goto end_read;
			if(length_str && !target[length_str - 1] && next == 'x') {
				length_str--;
				continue;
			}
			if(next >= '0' && next <= '9')
				target[length_str++] = next - '0';
			if(next >= 'a' && next <= 'f')
				target[length_str++] = next - 'a' + 10;
			if(length_str == size_str)
				break;
		}
		if(size_str + 1 > size) {
			size *= 2;
			*buffer = (char*)realloc(*buffer, size);
		}
		(*buffer)[length++] = target[0] << 4 | target[1];
	}
	end_read: ;

	return length;
}
