/* vim:cindent:ts=2:sw=2:expandtab */

#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <string.h>
#include <unistd.h>
#include <getopt.h>

#include <sys/resource.h>

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

void semantics_instr(char* input, unsigned int in_size, char** output, unsigned int* out_size) {
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
    *out_size = outputSize - 1; // Python expects size without null...
    cleanup:

    gdsl_reset_heap(state);

    gdsl_destroy(state);

}

void semantics_multi_opt(char* input, unsigned int in_size, char** output, unsigned int* out_size, long preservation) {
    const rlim_t kStackSize = 64L * 1024L * 1024L; // min stack size = 64 Mb
    struct rlimit rl;
    int result;

    result = getrlimit(RLIMIT_STACK, &rl);
    if(result == 0) {
        if(rl.rlim_cur < kStackSize) {
            rl.rlim_cur = kStackSize;
            result = setrlimit(RLIMIT_STACK, &rl);
            if(result != 0) {
                fprintf(stderr, "setrlimit returned result = %d\n", result);
            }
        }
    }

    state_t state = gdsl_init();
    gdsl_set_code(state, input, in_size, 0);

    if(setjmp(*gdsl_err_tgt(state))) {
        snprintf(error_message, sizeof(error_message), "failure: %s", gdsl_get_error_message(state));
        set_exception();
        goto cleanup;
    }

    unsigned int size_increment = 100000;
    size_t reallocated_times = 0;
    size_t last_offset = 0;
    size_t out_max_size = 1000;

    *output = malloc(out_max_size);
    **output = '\0';
    *out_size = 1;

    while(last_offset < in_size) {
        obj_t rreil = gdsl_decode_translate_block_optimized(state, gdsl_config_default(state), gdsl_int_max(state),
                preservation);
        string_t fmt = gdsl_merge_rope(state, gdsl_rreil_pretty(state, rreil));

        while(strlen(fmt) > out_max_size - *out_size) {
            reallocated_times++;
            char* tmp = realloc(*output, out_max_size + size_increment);
            if(tmp == NULL) {
                snprintf(error_message, sizeof(error_message), "unable to resize output buffer: oldsize=%u,newsize = %u",
                    *out_size, (*out_size) + size_increment);
                set_exception();
                goto cleanup;
            }
            else {
                out_max_size = *out_size + size_increment;
                *output = tmp;
            }
        }

        *out_size = *out_size + strlen(fmt);
        strncat(*output, fmt, strlen(fmt));
        gdsl_reset_heap(state);
        last_offset = gdsl_get_ip_offset(state);
    }

    cleanup:
    *out_size = *out_size - 1;
    gdsl_destroy(state);
}

void semantics_multi(char* input, unsigned int in_size, char** output, unsigned int* out_size) {
    const rlim_t kStackSize = 64L * 1024L * 1024L; // min stack size = 64 Mb
    struct rlimit rl;
    int result;

    result = getrlimit(RLIMIT_STACK, &rl);
    if(result == 0) {
        if(rl.rlim_cur < kStackSize) {
            rl.rlim_cur = kStackSize;
            result = setrlimit(RLIMIT_STACK, &rl);
            if(result != 0) {
                fprintf(stderr, "setrlimit returned result = %d\n", result);
            }
        }
    }

    state_t state = gdsl_init();
    gdsl_set_code(state, input, in_size, 0);

    if(setjmp(*gdsl_err_tgt(state))) {
        snprintf(error_message, sizeof(error_message), "failure: %s", gdsl_get_error_message(state));
        set_exception();
        goto cleanup;
    }

    unsigned int size_increment = 100000;
    size_t reallocated_times = 0;
    size_t last_offset = 0;
    size_t out_max_size = 1000;

    *output = malloc(out_max_size);
    **output = '\0';
    *out_size = 1;

    while(last_offset < in_size) {
        obj_t rreil = gdsl_decode_translate_block(state, gdsl_config_default(state), gdsl_int_max(state));
        string_t fmt = gdsl_merge_rope(state, gdsl_rreil_pretty(state, rreil));

        while(strlen(fmt) > out_max_size - *out_size) {
            reallocated_times++;
            char* tmp = realloc(*output, out_max_size + size_increment);
            if(tmp == NULL) {
                snprintf(error_message, sizeof(error_message), "unable to resize output buffer: oldsize=%u,newsize = %u",
                    *out_size, (*out_size) + size_increment);
                set_exception();
                goto cleanup;
            }
            else {
                out_max_size = *out_size + size_increment;
                *output = tmp;
            }
        }

        *out_size = *out_size + strlen(fmt);
        strncat(*output, fmt, strlen(fmt));
        gdsl_reset_heap(state);
        last_offset = gdsl_get_ip_offset(state);
    }

    cleanup:
    *out_size = *out_size - 1;
    gdsl_destroy(state);
}
