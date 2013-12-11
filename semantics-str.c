/* vim:cindent:ts=2:sw=2:expandtab */

#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <string.h>
#include <unistd.h>
#include <getopt.h>
#include <gdsl.h>

#ifdef GDSL_X86
struct options {
    char mode64;
    char default_opnd_sz_32;
};

static char options_init(struct options *options) {
    options->mode64 = 1;
    options->default_opnd_sz_32 = 1;

    return 0;
}
#endif

void semantics_str(char* buffer, size_t buffer_length, char* resultString, size_t resultStringSize, size_t* decoded, int* errorState) {
    errorState = 0;
#ifdef GDSL_X86
    struct options options;
    options_init(&options);
#endif

    state_t state = gdsl_init();
    gdsl_set_code(state, buffer, buffer_length, 0);

    if(setjmp(*gdsl_err_tgt(state))) {
        snprintf(resultString, resultStringSize, "\n#decode failed: %s\n", gdsl_get_error_message(state));
        *errorState = 1;
        goto cleanup;
    }

#ifdef GDSL_X86
    int_t config = 0;
    config |= gdsl_config_mode64(state)*options.mode64;
    config |= gdsl_config_default_opnd_sz_32(state)*options.default_opnd_sz_32;

    obj_t insn = gdsl_decode(state, config);
#else
    obj_t insn = gdsl_decode(state, gdsl_config_default(state));
#endif

    *decoded = gdsl_get_ip_offset(state);

    string_t fmt = gdsl_merge_rope(state, gdsl_pretty(state, insn)); /* string_t is a typedef for char* */
    /* strcat(resultString, fmt); */

    if(setjmp(*gdsl_err_tgt(state))) {
        snprintf(resultString, resultStringSize, "translate failed: %s\n", gdsl_get_error_message(state));
        *errorState = 1;
        goto cleanup;
    }

    obj_t rreil = gdsl_translate(state, insn);

    fmt = gdsl_merge_rope(state, gdsl_rreil_pretty(state, rreil));
    strncat(resultString, fmt, resultStringSize);

    cleanup:

    gdsl_reset_heap(state);

    gdsl_destroy(state);

    return;
}

void semantics_instr(char* input, unsigned int in_size, char** output) {
    char* outBuffer;
    size_t outBufferSize = 1000000;
    *output = (char*) malloc(outBufferSize);
    (*output)[0] = '\0';
    int errorStatus = 0;
    size_t decoded = 0;
    semantics_str(input, in_size, *output, outBufferSize, &decoded, &errorStatus);
    return;
}
