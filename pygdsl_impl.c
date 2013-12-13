/* vim:cindent:ts=2:sw=2:expandtab */

#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <string.h>
#include <unistd.h>
#include <getopt.h>
#include <gdsl.h>

#include "pygdsl_error.h"
#include "pygdsl_funcs.h"

static char error_message[MAX_ERROR_LENGTH];
static int error_status = 0;

void throw_exception(char *msg) {
    strncpy(error_message,msg,sizeof(error_message));
    error_status = 1;
}

void set_exception(void) {
    error_status = 1;
}

void clear_exception(void) {
    error_message[0] = '\0';
    error_status = 0;
}

int check_exception(void) {
    return error_status;
}

void copy_error(char* buffer, size_t buffer_size) {
    buffer[0] = '\0';
    strncpy(buffer, error_message, buffer_size);
}

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

void semantics_instr(char* input, unsigned int in_size, char** output) {
    clear_exception();
#ifdef GDSL_X86
    struct options options;
    options_init(&options);
#endif

    state_t state = gdsl_init();
    gdsl_set_code(state, input, in_size, 0);

    if(setjmp(*gdsl_err_tgt(state))) {
        snprintf(error_message, sizeof(error_message), "decode failed: %s", gdsl_get_error_message(state));
        set_exception();
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

    gdsl_get_ip_offset(state);

    string_t fmt = gdsl_merge_rope(state, gdsl_pretty(state, insn)); /* string_t is a typedef for char* */

    if(setjmp(*gdsl_err_tgt(state))) {
        snprintf(error_message, sizeof(error_message), "translate failed: %s", gdsl_get_error_message(state));
        set_exception();
        goto cleanup;
    }

    obj_t rreil = gdsl_translate(state, insn);

    fmt = gdsl_merge_rope(state, gdsl_rreil_pretty(state, rreil));
    size_t outputSize = strlen(fmt)+1;
    *output = malloc(outputSize);
    strncpy(*output, fmt, outputSize);

    cleanup:

    gdsl_reset_heap(state);

    gdsl_destroy(state);

}
