#ifndef PYGDSL_FUNCS_H
#define PYGDSL_FUNCS_H

void semantics_instr(char* input, unsigned int in_size, char** output, unsigned int* out_size);
void semantics_multi_opt(char* input, unsigned int in_size, char** output, unsigned int* out_size, long preservation);
void semantics_multi(char* input, unsigned int in_size, char** output, unsigned int* out_size);

#endif
