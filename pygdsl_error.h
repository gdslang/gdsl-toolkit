#ifndef PYGDSL_ERROR_H
#define PYGDSL_ERROR_H

#define MAX_ERROR_LENGTH 1024


void throw_exception(char* msg);
void clear_exception(void);
int check_exception(void);
void copy_error(char* buffer, size_t buffer_size);

#endif
