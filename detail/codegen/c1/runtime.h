/* vim:set ts=2:set sw=2:set expandtab: */
@I-am-a-template-so-edit-me@
#ifndef __GDSL_RUNTIME_H
#define __GDSL_RUNTIME_H

#include <stdlib.h>
#include <stdint.h>
#include <setjmp.h>

/* data types used in decoder programs */
typedef void* obj_t;
typedef struct state* state_t;
typedef long long int int_t;
typedef char* string_t;
typedef uint64_t vec_data_t;

struct vec {
  unsigned int size;
  vec_data_t data;
};

typedef struct vec vec_t;
typedef int_t con_tag_t;

#endif /* __GDSL_RUNTIME_H */

/* The following declarations are individual for each decoder. */
@if-guard-prefix@

/* Create a new decoder state. Should be destroyed by
@destroy@
(). */
state_t
@init@
(void);

/* Set the code buffer. The parameter base denotes the address that ip_get
   in GDSL returns when no bytes have been consumed. */
void
@set_code@
(state_t s, const unsigned char* buf, size_t buf_len, uint64_t base);

/* Query the offset of the current IP relative to base. */
uint64_t
@get_ip@
(state_t s);

/* Set the current code position to this address. */
int_t
@seek@
(state_t s, uint64_t i);

/* An exception handler must be installed by calling setjmp with the argument
 * returned by this function.
 * If an exception occurs, control will return from setjmp with
 * value 1 if there are no more bytes in the input buffer or with
 * value 2 if there has been an error (e.g. pattern match failure). In
 * both cases, an error message can be retrieved using get_error_message().
 */
jmp_buf*
@err_tgt@
(state_t s);

/* Retrieve the error message after an exception has been raised. */
char*
@get_error_message@
(state_t s);

/* Reset the heap. Objects returned by exported function are no longer valid
   after a call to this funciton. This function does not necessarily
   deallocate all of the heap. */
void
@reset_heap@
(state_t s);

/* Query the no of bytes currently allocated on the heap. */
uint64_t
@heap_residency@
(state_t s);

/* Allocate a buffer on the heap and emit the given rope into it.
   Returns a pointer to the buffer on the heap. */
string_t
@merge_rope@
(state_t s, obj_t rope);

/* Frees the heap and the decoder state. */
void
@destroy@
(state_t s);

/* Records that are represented as C structs. */
@records@

/* Exported functions. */
@exports@

#ifdef WITHMAIN
  #define GDSL_NO_PREFIX
#endif

#ifdef GDSL_NO_PREFIX
#define gdsl_init \
@init@

#define gdsl_set_code \
@set_code@

#define gdsl_get_ip \
@get_ip@

#define gdsl_seek \
@seek@

#define gdsl_err_tgt \
@err_tgt@

#define gdsl_get_error_message \
@get_error_message@

#define gdsl_reset_heap \
@reset_heap@

#define gdsl_heap_residency \
@heap_residency@

#define gdsl_merge_rope \
@merge_rope@

#define gdsl_destroy \
@destroy@

@renamings@

#endif

@end-guard-prefix@

/* The following defines are accumulative. */

/* Exported tags of constructors. */
@tagnames@

