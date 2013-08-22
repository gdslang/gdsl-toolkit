/* vim:ts=2:sw=2:expandtab */
#ifndef __GDSLRT_H
#define __GDSLRT_H

#include <stdlib.h>
#include <string.h>
#include <inttypes.h>
#include <setjmp.h>

/* data types used in decoder programs */
typedef void* obj_t;


struct state {
  char* heap_base;    /* the beginning of the heap */
  char* heap_limit;   /* first byte beyond the heap buffer */
  char* heap;         /* current top of the heap */
  obj_t state;        /* a heap pointer to the current monadic state */
  char* ip_base;      /* beginning of code buffer */
  char* ip_limit;     /* first byte beyond the code buffer */
  char* ip;           /* current pointer into the buffer */
  char* err_str;      /* a string describing the fatal error that occurred */
  jmp_buf err_tgt;    /* the position of the exception handler */
};


typedef struct state* state_t;
typedef int64_t int_t;
typedef char* string_t;
typedef uint64_t vec_data_t;

struct vec {
  unsigned int size;
  vec_data_t data;
};

void alloc_heap(state_t s, char* prev_page);

inline void* alloc(state_t s, size_t bytes) {
  bytes = ((bytes+7)>>3)<<3;    /* align to multiple of 8 */
  if (s->heap+bytes >= s->heap_limit) alloc_heap(s, s->heap_base);
  char* res = s->heap;
  s->heap = s->heap+bytes;
  return res; 
};

typedef struct vec vec_t;
typedef int_t con_tag_t;

#define GEN_ALLOC(type) \
inline type ## _t* alloc_ ## type (state_t s, type ## _t v) { \
  type ## _t* res = (type ## _t*) alloc(s, sizeof(type ## _t));\
  *res = v;\
  return res;\
}

GEN_ALLOC(int);

#define alloc_string(s,str) str

GEN_ALLOC(vec);

#define GEN_CON_STRUCT(type)  \
struct con_ ## type {         \
  con_tag_t tag;              \
  type ## _t payload;         \
};                            \
                              \
typedef struct con_ ## type  con_ ## type ## _t

GEN_CON_STRUCT(obj);
GEN_ALLOC(con_obj);
GEN_CON_STRUCT(int);
GEN_ALLOC(con_int);
GEN_CON_STRUCT(vec);
GEN_ALLOC(con_vec);
GEN_CON_STRUCT(string);
GEN_ALLOC(con_string);

typedef unsigned int field_tag_t;

#define GEN_REC_STRUCT(type)  \
struct field_ ## type {       \
  field_tag_t tag;            \
  unsigned int size;          \
  obj_t next;                 \
  type ## _t payload;         \
};                            \
                              \
typedef struct field_ ## type  field_ ## type ## _t

#define GEN_ADD_FIELD(type)                               \
inline obj_t add_field_ ## type                           \
  (state_t s,field_tag_t tag, type ## _t v, obj_t rec) {  \
  field_ ## type ## _t* res = (field_ ## type ## _t *)    \
    alloc(s, sizeof(field_ ## type ## _t));               \
  res->tag = tag;                                         \
  res->size = sizeof(field_ ## type ## _t);               \
  res->next = rec;                                        \
  res->payload = v;                                       \
  return res;                                             \
}

GEN_REC_STRUCT(obj);
GEN_ADD_FIELD(obj);
GEN_REC_STRUCT(int);
GEN_ADD_FIELD(int);
GEN_REC_STRUCT(vec);
GEN_ADD_FIELD(vec);
GEN_REC_STRUCT(string);
GEN_ADD_FIELD(string);

obj_t del_fields(state_t s, field_tag_t tags[], int tags_size, obj_t rec);

#define slice(vec_data,ofs,sz) ((vec_data >> ofs) & ((1ul << sz)-1))
#define gen_vec(vec_sz,vec_data) (vec_t){vec_sz, vec_data}

#define GEN_CONSUME(size)                                        \
inline int_t consume ## size(state_t s) {                        \
  if (s->ip+( size >>3)>s->ip_limit) {                           \
    s->err_str = (char*)"GDSL runtime: end of code input stream";\
    longjmp(s->err_tgt,1);                                       \
  };                                                             \
  uint ## size ## _t* ptr = (uint ## size ## _t*) s->ip;         \
  int_t res = (unsigned) *ptr;                                   \
  s->ip+= size >> 3;                                             \
  return res;                                                    \
}

GEN_CONSUME(8);
GEN_CONSUME(16);
GEN_CONSUME(32);

int_t vec_to_signed(state_t s, vec_t v);
int_t vec_to_unsigned(state_t s, vec_t v);

inline vec_t vec_not(state_t s, vec_t v) {
  vec_data_t mask = (1<<((vec_data_t) v.size))-1;
  return (vec_t){ v.size, v.data ^ mask };
}

inline vec_data_t vec_eq(state_t s, vec_data_t d1, vec_data_t d2) {
  return (d1==d2 ? 1 : 0);
}

inline vec_t vec_concat(state_t s, vec_t v1, vec_t v2) {
  return (vec_t){ v1.size+v2.size, v1.data << v2.size | v2.data };
}

inline string_t int_to_string(state_t s, int_t v) {
  int negate = v<0;
  char* str = (char*)alloc(s, 24)+23;
  int_t r;
  *str = 0;
  if (negate) {
    v = -v;
    *--str = ')';
  };
  do {
    r = v % 10;
    v = v / 10;
    *--str = '0'+(unsigned char) r;
  } while (v!=0);
  if (negate) {
    *--str = '-';
    *--str = '(';
  };
  return alloc_string(s,str);
};

obj_t vec_to_string(state_t s, vec_t v);

inline string_t string_concat(state_t s, string_t s1, string_t s2) {
  char* str1 = s1;
  char* str2 = s2;
  int len = strlen(s1)+strlen(s2);
  char* res = (char*)alloc(s, len+1);
  strcpy(res,str1);
  strcat(res,str2);
  return alloc_string(s,res);
}

jmp_buf* gdsl_err_tgt(state_t s);
char* gdsl_get_error_message(state_t s);

int64_t gdsl_seek(state_t s, int64_t i);
int64_t gdsl_rseek(state_t s, int64_t i);

/* Create a new decoder state. Should be destroyed by gdsl_destroy(). */
state_t gdsl_init(void);

/* Set the code buffer. The parameter base denotes the address that ip_get
   in GDSL returns when no bytes have been consumed. */
void gdsl_set_code(state_t s, char* buf, size_t buf_len, uint64_t base);

/* Query the offset of the current IP relative to base. */
uint64_t gdsl_get_ip_offset(state_t s);

/* An exception handler must be installed by calling setjmp with the argument
 * returned by this function.
 * If an exception occurs, control will return from setjmp with
 * value 1 if there are no more bytes in the input buffer or with
 * value 2 if there has been an error (e.g. pattern match failure). In
 * both cases, an error message can be retrieved using get_error_message().
 */
jmp_buf* gdsl_err_tgt(state_t s);

/* Retrieve the error message after an exception has been raised. */
char* gdsl_get_error_message(state_t s);

/* Reset the heap. Objects returned by exported function are no longer valid
   after a call to this funciton. */
void gdsl_reset_heap(state_t s);

/* Frees the heap and the decoder state. */
void gdsl_destroy(state_t s);

#endif /* __GDSLRT_H */

