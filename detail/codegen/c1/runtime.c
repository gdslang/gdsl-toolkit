/* vim:ts=2:sw=2:expandtab */

#include "dis.h"
#include <setjmp.h>

@fieldnames@

@tagnames@

@prototypes@

struct state {
  char* heap_base;    /* the beginning of the heap */
  char* heap_limit;   /* first byte beyond the heap buffer */
  char* heap;         /* current top of the heap */
  obj_ptr state;      /* a heap pointer to the current monadic state */
  char* ip_base;      /* beginning of code buffer */
  char* ip_limit;     /* first byte beyond the code buffer */
  char* ip;           /* current pointer into the buffer */
  char* err_str;      /* a string describing the fatal error that occurred */
  jmp_buf err_tgt;    /* the position of the exception handler */
};


typedef struct state state_t;

static void alloc_heap(state_t* s, char* prev_page) {
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

static void free_heap(state_t* s) {
  char* heap = s->heap_base;
  while (heap!=NULL) {
    char* prev = *((char**) heap->base);
    free (heap);
    heap = prev;
  }
};

static void* inline alloc(state_t* s, unsigned int bytes) {
  bytes = ((bytes+7)>>3)<<3;    /* align to multiple of 8 */
  if (s->heap+bytes >= s->heap_limit) alloc_heap(s, s->heap_base);
  char* res = s->heap;
  s->heap = s->heap+bytes;
  return res; 
};

typedef uint64_t vec_data_t;

struct vec {
  unsigned int size;
  vec_data_t data;
};

typedef struct vec vec_t;

typedef unsigned int con_tag_t;

struct con {
  con_tag_t tag;
  char* payload;
};

typedef struct con con_t;

static int signed(state_t* s, vec_t v) {
  int int_bitsize = sizeof(int)*4;
  if (v.size>int_bitsize-1) {
    s->err_str = "GDSL runtime: signed applied to very long vector";
    longjmp(s->err_tgt,1);
  };
  int bits_to_fill = int_bit_size-v.size;
  return (((int) v.data) << bits_to_fill) >> bits_to_fill;
}

static int unsigned(state_t* s, vec_t v) {
  int int_bitsize = sizeof(int)*4;
  if (v.size>int_bitsize-1) {
    s->err_str = "GDSL runtime: unsigned applied to very long vector";
    longjmp(s->err_tgt,1);
  };
  return (int) v.data;
}

static inline vec_t vec_not(state_t* s, vec_t v) {
  vec_data_t mask = (1<<v.size)-1;
  return (vec_t){ v.size, v.data ^ mask };
}

static inline vec_data_t vec_eq(state_t* s, vec_data_t d1, vec_data_t d2) {
  return (d1=d2 ? 1 : 0)
}

static inline vec_t vec_concat(state_t* s, vec_t v1, vec_t v2) {
  return (vec_t){ v1.size+v2.size, v1.data << v2.size | v2.data };
}

static inline obj_ptr int_to_string(state_t* s, int v) {
  char* str = alloc(s, 16);
  sprintf(str,"%d",v);
  return str;
};

static obj_ptr vec_to_string(state_t* s, vec_t v) {
  char* str = alloc(s, v.size+1);
  char* idx = str;
  for (vec_data_t mask = 1<<(v.size-1); mask!=0; mask>>=1)
    *(idx++) = (v.data & mask ? '1' : '0');
  *idx = 0;
  return res;
}

static inline string_concat(state_t* s, obj_ptr s1, obj_ptr s2) {
  char* str1 = s1;
  char* str2 = s2;
  int len = strlen(s1)+strlen(s2);
  char* res = alloc(s, len+1);
  strcpy(res,str1);
  strcat(res,str2);
  return res;
}


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

