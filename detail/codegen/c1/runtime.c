/* vim:set ts=2:set sw=2:set expandtab: */
@I-am-a-template-so-edit-me@

#define GDSL_SPECIFIC

@include-prefix@
#include <string.h>
#include <stdio.h>
#include <limits.h>

/* generated declarations for records with fixed fields */
@records@


struct state {
  char* heap_base;    /* the beginning of the heap */
  char* heap_limit;   /* first byte beyond the heap buffer */
  char* heap;         /* current top of the heap */
@state_type@
;      /* the current monadic state */
  char* ip_start;     /* beginning of code buffer */
  size_t ip_base;     /* base address of code */
  char* ip_limit;     /* first byte beyond the code buffer */
  char* ip;           /* current pointer into the buffer */
  char* err_str;      /* a string describing the fatal error that occurred */
  jmp_buf err_tgt;    /* the position of the exception handler */
  FILE* handle;       /* the file that the puts primitve uses */
  char* const_heap_base;
  /* the following fields contain the values of constant GDSL expressions */
  @gdsl_constants@

};

#define CHUNK_SIZE (4*1024)

#ifdef __CLANG__
#define NO_INLINE_ATTR __attribute__((noinline))
#elif __GNUC__
#define NO_INLINE_ATTR __attribute__((noinline))
#else
#define NO_INLINE_ATTR
#endif

#ifdef __CLANG__
#define MALLOC_ATTR __attribute__((malloc))
#elif __GNUC__
#define MALLOC_ATTR __attribute__((malloc))
#else
#define MALLOC_ATTR
#endif


static void NO_INLINE_ATTR alloc_heap(state_t s, char* prev_page, size_t size) {
  if (size<CHUNK_SIZE) size = CHUNK_SIZE; else size = CHUNK_SIZE*((size/CHUNK_SIZE)+1);
  s->heap_base = malloc(size);
  if (s->heap_base==NULL) {
    s->err_str = "GDSL runtime: out of memory";
    longjmp(s->err_tgt,2);
  };
  s->heap = s->heap_base+sizeof(char*);
  /* store a pointer to the previous page in the first bytes of this page */
  *((char**) s->heap_base) = prev_page;
  s->heap_limit = s->heap_base+size;
};


void 
@reset_heap@
(state_t s) {
  char* heap = s->heap_base;
  if (heap==NULL) return;
  while (1) {
    char* prev = *((char**) heap);
    if (prev==NULL) break;
    free (heap);
    heap = prev;
  }
  s->heap_base = heap;
  s->heap = heap+sizeof(char*);
  s->heap_limit = heap+CHUNK_SIZE;
  memset(&s->state, 0, sizeof(s->state));
};

size_t 
@heap_residency@
(state_t s) {
  char* heap = s->heap_base;
  if (heap==NULL) return 0;
  size_t res = s->heap - s->heap_base;
  while (1) {
    char* prev = *((char**) heap);
    if (prev==NULL) break;
    res += CHUNK_SIZE;
    heap = prev;
  }
  return res;
};

static inline void* MALLOC_ATTR alloc(state_t s, size_t bytes) {
  bytes = ((bytes+7)>>3)<<3;    /* align to multiple of 8 */
  if (s->heap+bytes >= s->heap_limit) alloc_heap(s, s->heap_base, bytes);
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

#define alloc_string(s,str) str

#define GEN_CON_STRUCT(type)  \
struct con_ ## type {         \
  con_tag_t tag;              \
  type ## _t payload;         \
};                            \
                              \
typedef struct con_ ## type  con_ ## type ## _t

typedef unsigned int field_tag_t;

#define GEN_REC_STRUCT(type)  \
struct field_ ## type {       \
  field_tag_t tag;            \
  obj_t next;                 \
  unsigned int size;          \
  type ## _t payload;         \
};                            \
                              \
typedef struct field_ ## type  field_ ## type ## _t

#define GEN_ADD_FIELD(type)                               \
static obj_t add_field_ ## type                           \
(state_t s,field_tag_t tag, type ## _t v, obj_t rec) {    \
  field_ ## type ## _t* res =                             \
    alloc(s, sizeof(field_ ## type ## _t));               \
  res->tag = tag;                                         \
  res->size = sizeof(field_ ## type ## _t);               \
  res->next = rec;                                        \
  res->payload = v;                                       \
  return res;                                             \
}

#define GEN_SELECT_FIELD(type)                            \
static type ## _t select_  ## type                        \
(state_t s,field_tag_t field, obj_t rec) {                \
  field_ ## type ## _t* v = (field_ ## type ## _t*) rec;  \
  while (v) {                                             \
    if (v->tag==field) return v->payload;                 \
    v = v->next;                                          \
  };                                                      \
  s->err_str = "GDSL runtime: field not found in record"; \
  longjmp(s->err_tgt,1);                                  \
}                                                         \

GEN_REC_STRUCT(obj);

/* Returns a pointer to a record in which the given fields are removed.
  This operation copies all fields of the record except for those that
  are to be removed. The function returns the tail of the old record if
  all given fields could be removed before the end of the record was
  reached.
*/
static obj_t del_fields(state_t s, field_tag_t tags[], int tags_size, obj_t rec) {
  field_obj_t* current = rec;
  int idx;
  obj_t res = NULL;
  obj_t* last_next = &res;
  while (current && tags_size>0) {
    for (idx=0; idx<tags_size; idx++)
      if (current->tag == tags[idx]) break;
    if (idx<tags_size) {
      /* delete this field by doing nothing, but remove the index */
      tags[idx]=tags[--tags_size];
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


/* Functions to allocate values, constructors and record fields on the heap. */
@alloc_funcs@

#define slice(vec_data,ofs,sz) ((vec_data >> ofs) & ((1ul << sz)-1))
#define gen_vec(vec_sz,vec_data) (vec_t){vec_sz, vec_data}

jmp_buf* 
@err_tgt@
(state_t s) {
  return &(s->err_tgt);
};

char* 
@get_error_message@
(state_t s) {
  return s->err_str;
};

#define GEN_CONSUME(size)                                 \
static inline int_t consume ## size(state_t s) {          \
  if (s->ip+( size >>3)>s->ip_limit) {                    \
    s->err_str = "GDSL runtime: end of code input stream";\
    longjmp(s->err_tgt,1);                                \
  };                                                      \
  uint ## size ## _t* ptr = (uint ## size ## _t*) s->ip;  \
  int_t res = (unsigned) *ptr;                            \
  s->ip+= size >> 3;                                      \
  return res;                                             \
}

GEN_CONSUME(8);
GEN_CONSUME(16);
GEN_CONSUME(32);

static int_t vec_to_signed(state_t s, vec_t v) {
  unsigned int bit_size = sizeof(int_t)*8;
  if (v.size>bit_size) {
    s->err_str = "GDSL runtime: signed applied to very long vector";
    longjmp(s->err_tgt,2);
  };
  int bits_to_fill = bit_size-v.size;
  return (((int_t) v.data) << bits_to_fill) >> bits_to_fill;
}

static int_t vec_to_unsigned(state_t s, vec_t v) {
  unsigned int int_bitsize = sizeof(int_t)*8;
  if (v.size>int_bitsize) {
    s->err_str = "GDSL runtime: unsigned applied to very long vector";
    longjmp(s->err_tgt,2);
  };
  return (int_t) v.data;
}

static inline vec_t vec_not(state_t s, vec_t v) {
  vec_data_t mask = (1<<((vec_data_t) v.size))-1;
  return (vec_t){ v.size, v.data ^ mask };
}

static inline vec_data_t vec_eq(state_t s, vec_data_t d1, vec_data_t d2) {
  return (d1==d2 ? 1 : 0);
}

static inline vec_t vec_concat(state_t s, vec_t v1, vec_t v2) {
  return (vec_t){ v1.size+v2.size, v1.data << v2.size | v2.data };
}

static string_t int_to_string(state_t s, int_t v) {
  if(v == LLONG_MIN)
    return "(-9223372036854775807)";
  else {
    char *str = alloc(s, 23)+22;
    int negate = v<0;
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
    }
    return alloc_string(s,str);
  }
};

void 
@set_code@
(state_t s, char* buf, size_t buf_len, size_t base) {
  s->ip = buf;
  s->ip_limit = buf+buf_len;
  s->ip_start = buf;
  s->ip_base = base;
}

size_t 
@get_ip_offset@
(state_t s) {
  return s->ip_base + (s->ip - s->ip_start);
}

int_t 
@seek@
(state_t s, size_t i) {
  size_t size = (size_t)(s->ip_limit - s->ip_start);
  size_t start_offset = i - s->ip_base;
	if(start_offset >= size)
	  return 1;
	s->ip = s->ip_start + start_offset;
	return 0;
}

string_t
@merge_rope@
(state_t s, obj_t rope) {
  int_t len =
@rope_length@
(s,rope);
  string_t buf = alloc(s,len);
  string_t end =
@rope_to_string@
(s,rope,buf);
  *end = 0;
  return buf;
}

void 
@destroy@
(state_t s) {
@reset_heap@
(s);
  free(s->heap_base);
  /* free heap of GDSL constants */
  char* heap = s->const_heap_base;
  while (heap!=NULL) {
    char* prev = *((char**) heap);
    free (heap);
    heap = prev;
  }
  free(s);
}

@prototypes@


@functions@


state_t 
@init@
() {
  state_t s = calloc(1,sizeof(struct state));
  s->handle = stdout;
  /* compute all constant expressions */
@gdsl_init_constants@

  /* keep the heap of constant expressions separate */
  s->const_heap_base = s->heap_base;
  s->heap_base = NULL;
  s->heap_limit = NULL;
  s->heap = NULL;
  return s;
}


#ifdef WITHMAIN

#if defined(gdsl_decode_translate_block_optimized) && defined(gdsl_rreil_pretty)
  #define HAVE_TRANS
#endif
#if defined(gdsl_decode) && defined(gdsl_pretty)
  #define HAVE_DECODE
#endif

#define BUF_SIZE 32*1024*1024
static char blob[BUF_SIZE];

int main (int argc, char** argv) {
  uint64_t buf_size = BUF_SIZE;
  FILE* file = NULL;
  int_t decode_options = 0;
  int_t run_translate = 0;
  int_t translate_options = 0;
  int_t base_address = 0;
  int_t start_address = 0;
  unsigned int i,c;
  state_t s = gdsl_init();

  /* read command line parameters */
  for(i=1; i<argc; i++) {
    char* arg = argv[i];
    if (strncmp(arg,"--",2)) {
      file = fopen(arg,"r");
      if (file==NULL) {
        printf("file '%s' not found, please run %s --help for usage\n", arg, argv[0]);
        return 1;
      }
    } else {
      arg+=2;
#if defined(gdsl_decoder_config)
      obj_t config;
      for (config = gdsl_decoder_config(s); gdsl_has_conf(s,config);
        config = gdsl_conf_next(s,config))
        if (strcmp(arg,gdsl_conf_short(s,config))==0) {
          decode_options |= gdsl_conf_data(s,config);
          break;
        }
      if (gdsl_has_conf(s,config)) continue;
#endif
      if (strncmp(arg,"base=",5)==0) {
        scanf(arg+5,"%lli",&base_address);
        continue;
      }
      if (strncmp(arg,"start=",6)==0) {
        scanf(arg+6,"%lli",&start_address);
        continue;
      }
      if (strcmp(arg,"trans")==0) {
        run_translate = 1;
        continue;
      }
      fprintf(stderr,
        "usage: %s [options] filename\nwhere\n"
        "  --trans          translate to semantics\n"
        "  --base=addr      print addresses relative to addr\n"
        "  --start=addr     decode starting from addr\n", argv[0]);
#if defined(gdsl_decoder_config)
      for (obj_t config = gdsl_decoder_config(s); gdsl_has_conf(s,config);
        config = gdsl_conf_next(s,config))
        fprintf(stderr,"  --%s\t\t%s\n",
          gdsl_conf_short(s,config), gdsl_conf_long(s,config));
#endif
      return 1;
    }
  }
  /* fill the buffer, either in binary from file or as sequence
     of hex bytes separated by space or newlines */
  if (file) {
    ssize_t bytes_read = fread(blob, 1, BUF_SIZE, file);
    if (bytes_read<0) return 1;
    buf_size = bytes_read;
  } else {
    for (i=0;i<buf_size;i++) {
       int x = fscanf(stdin,"%x",&c);
       switch (x) {
          case EOF: {
            buf_size = i;
          }; break;
          case 0: {
             fprintf(stderr, "invalid input; should be in hex form: '0f 0b ..'");
             return 1;
          }
       }
       blob[i] = c & 0xff;
    }
  }  
  /* initialize the GDSL program */
  gdsl_set_code(s, blob, buf_size, base_address);
  gdsl_seek(s, start_address);
  
  int_t alloc_size = 0;
  int_t alloc_no = 0;
  int_t alloc_max = 0;

  while (gdsl_get_ip_offset(s)<buf_size) {
    if (setjmp(*gdsl_err_tgt(s))==0) {
      if (run_translate) {
#ifdef HAVE_TRANS
        int_t address = gdsl_get_ip_offset(s);
        obj_t rreil = gdsl_decode_translate_block_optimized(s,
          decode_options,
          gdsl_int_max(s),
          CON_SEM_PRESERVATION_CONTEXT);
        obj_t res = gdsl_rreil_pretty(s,rreil);
        string_t str = gdsl_merge_rope(s,res);
        printf("%llx:\n",address);
        fputs(str,stdout);
#else
        fputs("GDSL modules contain no semantic translation\n")
        return 1;
#endif
      } else {
#ifdef HAVE_DECODE
        obj_t instr = gdsl_decode(s, decode_options);
        obj_t res = gdsl_pretty(s,instr);
        string_t str = gdsl_merge_rope(s,res);
        fputs(str,stdout);
#else
        fputs("GDSL modules contain no decoder function\n")
        return 1;
#endif
      }
    } else {
      fputs("exception: ",stdout);
      fputs(gdsl_get_error_message(s),stdout);
      if (gdsl_seek(s,gdsl_get_ip_offset(s)+1)) break;
    }
    fputs("\n",stdout);
    int_t size = gdsl_heap_residency(s);
    alloc_size += size;
    alloc_no++;
    if (size>alloc_max) alloc_max = size;
    gdsl_reset_heap(s);
  }
  fprintf(stderr, "heap: no: %lli mem: %lli max: %lli\n", alloc_no, alloc_size, alloc_max);
  gdsl_destroy(s);
  return 0; 
}

#endif


