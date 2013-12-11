%include "exception.i"
%include "cstring.i"
#%feature("autodoc","1")
%module pygdsl

%cstring_output_allocate(char** output, free(*$1));
%apply (char *STRING, int LENGTH) { (char *input, int in_size) };
void semantics_instr(char* input, int in_size, char** output);