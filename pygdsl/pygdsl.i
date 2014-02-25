%include "exception.i"
%include "cstring.i"

%module pygdsl
%feature("autodoc","3");

%define DOCSTRING
"This is a simple Python wrapper library for GDSL."
%enddef


%{
#include <gdsl.h>
#include "pygdsl_error.h"
#include "pygdsl_funcs.h"
%}

%constant long GDSL_SEM_PRESERVATION_EVERYWHERE = CON_SEM_PRESERVATION_EVERYWHERE;
%constant long GDSL_SEM_PRESERVATION_BLOCK = CON_SEM_PRESERVATION_BLOCK;
%constant long GDSL_SEM_PRESERVATION_CONTEXT = CON_SEM_PRESERVATION_CONTEXT;


%exception {
    size_t err_size = MAX_ERROR_LENGTH+1;
    char* err = malloc(err_size);
    clear_exception();
    $action
    if (check_exception()) {
        copy_error(err, err_size);
        clear_exception();
        SWIG_exception(SWIG_RuntimeError, err);
    }
    free(err);
}

%feature("autodoc", "semantics_instr(bin_string) -> readable_rreil_instrs");
%cstring_output_allocate_size(char** output, unsigned int* out_size, free(*$1));
%apply (char *STRING, int LENGTH) { (char *input, unsigned int in_size) };
void semantics_instr(char* input, unsigned int in_size, char** output, unsigned int* out_size);

%feature("autodoc", "semantics_multi_opt(bin_string, preservation) -> readable_rreil_instrs");
%cstring_output_allocate_size(char** output, unsigned int* out_size, free(*$1));
%apply (char *STRING, int LENGTH) { (char *input, unsigned int in_size) };
void semantics_multi_opt(char* input, unsigned int in_size, char** output, unsigned int* out_size, long preservation);

%feature("autodoc", "semantics_multi(bin_string) -> readable_rreil_instrs");
%cstring_output_allocate_size(char** output, unsigned int* out_size, free(*$1));
%apply (char *STRING, int LENGTH) { (char *input, unsigned int in_size) };
void semantics_multi(char* input, unsigned int in_size, char** output, unsigned int* out_size);
