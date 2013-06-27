/* vim:ts=2:sw=2:expandtab */
@I-am-a-template-so-edit-me@

@include-prefix@
#include <stdio.h>
#include <stdint.h>
#include <stdarg.h>
#include <stddef.h>
#include <string.h>
#include <setjmp.h>

struct state {
  char* heap_base;    /* the beginning of the heap */
  char* heap_limit;   /* first byte beyond the heap buffer */
  char* heap;         /* current top of the heap */
  obj_t state;      /* a heap pointer to the current monadic state */
  char* ip_base;      /* beginning of code buffer */
  char* ip_limit;     /* first byte beyond the code buffer */
  char* ip;           /* current pointer into the buffer */
  char* err_str;      /* a string describing the fatal error that occurred */
  jmp_buf err_tgt;    /* the position of the exception handler */
};

static void alloc_heap(state_t s, char* prev_page) {
  unsigned int size = 4096;
  s->heap_base = malloc(size);
  if (s->heap_base==NULL) {
    s->err_str = "GDSL runtime: out of memory";
    longjmp(s->err_tgt,1);
  };
  s->heap = s->heap_base+sizeof(char*);
  /* store a pointer to the previous page in the first bytes of this page */
  *((char**) s->heap_base) = prev_page;
  s->heap_limit = s->heap_base+size;
};

void gdsl_reset_heap(state_t s) {
  char* heap = s->heap_base;
  while (heap!=NULL) {
    char* prev = *((char**) heap);
    free (heap);
    heap = prev;
  }
};

static inline void* alloc(state_t s, size_t bytes) {
  bytes = ((bytes+7)>>3)<<3;    /* align to multiple of 8 */
  if (s->heap+bytes >= s->heap_limit) alloc_heap(s, s->heap_base);
  char* res = s->heap;
  s->heap = s->heap+bytes;
  return res; 
};

#define GEN_ALLOC(type) \
static inline type ## _t* alloc_ ## type (state_t s, type ## _t v) { \
  type ## _t* res = alloc(s, sizeof(type ## _t));\
  *res = v;\
  return res;\
}

typedef int64_t int_t;

GEN_ALLOC(int);

typedef char* string_t;

#define alloc_string(s,str) str

typedef uint64_t vec_data_t;

struct vec {
  unsigned int size;
  vec_data_t data;
};

typedef struct vec vec_t;

GEN_ALLOC(vec);

typedef unsigned int con_tag_t;

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
static inline obj_t add_field_ ## type                    \
  (state_t s,field_tag_t tag, type ## _t v, obj_t rec) {  \
  field_ ## type ## _t* res =                             \
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

/* Returns a pointer to a record in which the given fields are removed.
  This operation copies all fields that lie on the way to the list suffix
  that only contains fields that do not need to be removed.
*/
static obj_t del_fields(state_t s, field_tag_t tags[], int tags_size, obj_t rec) {
  field_tag_t del_tags[tags_size];
  int last_del_tag = 0;
  /* copy those entries form tags that actually occur in the record; computing
     this information first makes it possible to share a common tail, even if
     the record does not contain all fields that should be deleted
  */
  field_obj_t* current = rec;
  int idx;
  while (current) {
    field_tag_t tag = current->tag;
    for (idx = 0; idx<tags_size; idx++) if (tags[idx]==tag) {
      del_tags[last_del_tag++] = tag;
      /* reduce the size of the tags array */
      tags[idx]=tags[--tags_size];
    }
    current = current->next;
  }
  current = rec;
  idx = 0;
  obj_t res = NULL;
  obj_t* last_next = &res;
  while (current && (idx<last_del_tag)) {
    if (current->tag == del_tags[idx]) {
      /* delete this field by doing nothing */
      idx++;
    } else {
      /* this field is not supposed to be deleted, copy it */
      field_obj_t* copy = alloc(s, current->size);
      memcpy(copy,current,current->size);
      *last_next = copy;
      last_next = &copy->next;
    };
    current = current->next;
  };
  *last_next = current;
  return res;
}

#define slice(vec_data,ofs,sz) ((vec_data >> sz) & ((1ul << ofs)-1))
#define gen_vec(vec_sz,vec_data) (vec_t){vec_sz, vec_data}


static int_t eos(state_t s) {
  s->err_str = "GDSL runtime: end of code input stream";
  longjmp(s->err_tgt,0);
  return 0;
};

#define GEN_CONSUME(size)                                 \
static inline int_t consume ## size(state_t s) {          \
  uint ## size ## _t* ptr = (uint ## size ## _t*) s->ip;  \
  int_t res = (unsigned) *ptr;                            \
  s->ip+=size >> 3;                                       \
  return res;                                             \
}

GEN_CONSUME(8);
GEN_CONSUME(16);
GEN_CONSUME(32);

static int_t vec_to_signed(state_t s, vec_t v) {
  int bit_size = sizeof(int_t)*8;
  if (v.size>bit_size-1) {
    s->err_str = "GDSL runtime: signed applied to very long vector";
    longjmp(s->err_tgt,1);
  };
  int bits_to_fill = bit_size-v.size;
  return (((int_t) v.data) << bits_to_fill) >> bits_to_fill;
}

static int_t vec_to_unsigned(state_t s, vec_t v) {
  int int_bitsize = sizeof(int_t)*8;
  if (v.size>int_bitsize-1) {
    s->err_str = "GDSL runtime: unsigned applied to very long vector";
    longjmp(s->err_tgt,1);
  };
  return (int_t) v.data;
}

static inline vec_t vec_not(state_t s, vec_t v) {
  vec_data_t mask = (1<<((vec_data_t) v.size))-1;
  return (vec_t){ v.size, v.data ^ mask };
}

static inline vec_data_t vec_eq(state_t s, vec_data_t d1, vec_data_t d2) {
  return (d1=d2 ? 1 : 0);
}

static inline vec_t vec_concat(state_t s, vec_t v1, vec_t v2) {
  return (vec_t){ v1.size+v2.size, v1.data << v2.size | v2.data };
}

static inline string_t int_to_string(state_t s, int_t v) {
  char* str = alloc(s, 24)+23;
  int_t r;
  *str = 0;
  while (v!=0) {
    r = v % 10;
    v = v / 10;
    *--str = '0'+(unsigned char) r;
  }
  return alloc_string(s,str);
};

static obj_t vec_to_string(state_t s, vec_t v) {
  char* str = alloc(s, v.size+1);
  char* idx = str;
  vec_data_t mask;
  for (mask = 1<<(v.size-1); mask!=0; mask>>=1)
    *(idx++) = (v.data & mask ? '1' : '0');
  *idx = 0;
  return alloc_string(s,str);
}

static inline string_t string_concat(state_t s, string_t s1, string_t s2) {
  char* str1 = s1;
  char* str2 = s2;
  int len = strlen(s1)+strlen(s2);
  char* res = alloc(s, len+1);
  strcpy(res,str1);
  strcat(res,str2);
  return alloc_string(s,res);
}

state_t gdsl_init() {
  state_t s = calloc(1,sizeof(state_t));
  alloc_heap(s,NULL);
  return s;
}

void gdsl_set_code(state_t s, char* buf, size_t buf_len, uint64_t base) {
  s->ip = buf;
  s->ip_limit = buf+buf_len;
  s->ip_base = s->ip-base;
}

void gdsl_destroy(state_t s) {
  gdsl_reset_heap(s);
  free(s);
}

@prototypes@

#ifdef WITHMAIN

int main (int argc, char** argv) {
  __char blob001[15] = {0x67,0xF3,0x45,0x0F,0x7E,0xD1};
  __char blob002[15] = {0xF3,0x67,0x45,0x0F,0x7E,0xD1};
  __char blob003[15] = {0x67,0x45,0xF3,0x0F,0x7E,0xD1};
  __char blob004[15] = {0xF3,0x45,0x67,0x0F,0x7E,0xD1};
  //__char blob005[15] = {67C4E1F97EC8};
  //__char blob006[15] = {C4E1F9677EC8};
  __char blob007[15] = {0x67,0x45,0xF3,0x0F,0x7E,0x11};
  //__char blob008[15] = {C4E1F97EC8};
  __word sz = 15;

  decode(blob001, sz);
  decode(blob002, sz);
  decode(blob003, sz);
  decode(blob004, sz);
  decode(blob007, sz);

  return (1); 
}

#endif

@functions@

