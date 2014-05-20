/* vim:set ts=2:set sw=2:set expandtab: */
/* Auto-generated file. DO NOT EDIT. */
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
#ifndef __GDSL_H
#define __GDSL_H

/* Create a new decoder state. Should be destroyed by 
gdsl_destroy(). */
state_t 
gdsl_init(void);

/* Set the code buffer. The parameter base denotes the address that ip_get
   in GDSL returns when no bytes have been consumed. */
void 
gdsl_set_code(state_t s, char* buf, size_t buf_len, size_t base);

/* Query the offset of the current IP relative to base. */
size_t 
gdsl_get_ip_offset(state_t s);

/* Set the current code position to this address. */
int_t
gdsl_seek(state_t s, size_t i);

/* Adjust the current code position by this offset.
int_t
(state_t s, int_t i);
*/

/* An exception handler must be installed by calling setjmp with the argument
 * returned by this function.
 * If an exception occurs, control will return from setjmp with
 * value 1 if there are no more bytes in the input buffer or with
 * value 2 if there has been an error (e.g. pattern match failure). In
 * both cases, an error message can be retrieved using get_error_message().
 */
jmp_buf* 
gdsl_err_tgt(state_t s);

/* Retrieve the error message after an exception has been raised. */
char* 
gdsl_get_error_message(state_t s);

/* Reset the heap. Objects returned by exported function are no longer valid
   after a call to this funciton. This function does not necessarily
   deallocate all of the heap. */
void 
gdsl_reset_heap(state_t s);

/* Query the no of bytes currently allocated on the heap. */
size_t 
gdsl_heap_residency(state_t s);

/* Allocate a buffer on the heap and emit the given rope into it.
   Returns a pointer to the buffer on the heap. */
string_t
gdsl_merge_rope(state_t s, obj_t rope);

/* Frees the heap and the decoder state. */
void 
gdsl_destroy(state_t s);

/* Records that are represented as C structs. */

/* Exported functions. */

#ifdef GDSL_NO_PREFIX
#define gdsl_init \
gdsl_init
#define gdsl_set_code \
gdsl_set_code
#define gdsl_get_ip_offset \
gdsl_get_ip_offset
#define gdsl_seek \
gdsl_seek
#define gdsl_err_tgt \
gdsl_err_tgt
#define gdsl_get_error_message \
gdsl_get_error_message
#define gdsl_reset_heap \
gdsl_reset_heap
#define gdsl_heap_residency \
gdsl_heap_residency
#define gdsl_merge_rope \
gdsl_merge_rope
#define gdsl_destroy \
gdsl_destroy

#endif

#endif /* __GDSL_H */

/* The following defines are accumulative. */

/* Exported tags of constructors. */
#ifdef CON_Lf
  #if (CON_Lf!=1)
    #error "merging GDSL libraries with incompatible definition for CON_Lf."
  #endif
#else
  #define CON_Lf 1
#endif