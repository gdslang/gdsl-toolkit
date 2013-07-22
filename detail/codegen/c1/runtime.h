/* vim:ts=2:sw=2:expandtab */
@I-am-a-template-so-edit-me@
#ifndef __GDSL_H
#define __GDSL_H

#include <stdlib.h>
#include <inttypes.h>

/* data types used in decoder programs */
typedef void* obj_t;
typedef struct state* state_t;
typedef int64_t int_t;
typedef char* string_t;
typedef uint64_t vec_data_t;

struct vec {
  unsigned int size;
  vec_data_t data;
};

typedef struct vec vec_t;
typedef unsigned int con_tag_t;

/* Create a new decoder state. Should be destroyed by gdsl_destroy(). */
state_t gdsl_init(void);

/* Set the code buffer. The parameter base denotes the address that ip_get
   in GDSL returns when no bytes have been consumed. */
void gdsl_set_code(state_t s, char* buf, size_t buf_len, uint64_t base);

/* Install an exception handler. Saves the calling context and returns 0.
 * If an exception occurs, control will return from this function with
 * value 1 if there are no more bytes in the input buffer or with
 * value 2 if there has been an error (e.g. pattern match failure). In
 * both cases, an error message can be retrieved using get_error_message().
 */
int gdsl_install_handler(state_t s);

/* Retrieve the error message after an exception has been raised. */
char* gdsl_get_error_message(state_t s);

/* Reset the heap. Objects returned by exported function are no longer valid
   after a call to this funciton. */
void gdsl_reset_heap(state_t s);

/* Frees the heap and the decoder state. */
void gdsl_destroy(state_t s);

#endif /* __GDSL_H */

/* The following declarations are individual for each decoder. */
@if-guard-prefix@

/* Exported functions. */
@exports@

@end-guard-prefix@

/* The following defines are accumulative. */

/* Exported tags of constructors without arguments. */
@tagnames@

