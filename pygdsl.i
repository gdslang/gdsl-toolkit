%include "exception.i"
%include "cstring.i"

#%feature("autodoc","1")
%module pygdsl

%{
#include "pygdsl_error.h"
#include "pygdsl_funcs.h"
%}

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
}

%cstring_output_allocate(char** output, free(*$1));
%apply (char *STRING, int LENGTH) { (char *input, int in_size) };
void semantics_instr(char* input, int in_size, char** output);
