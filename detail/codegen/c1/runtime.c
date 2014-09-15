/* vim:set ts=2:set sw=2:set expandtab: */
@I-am-a-template-so-edit-me@

#define GDSL_SPECIFIC

@include-prefix@
#include <string.h>
#include <stdio.h>
#include <limits.h>
#ifdef _MSC_VER
  #include <crtdefs.h>
#endif

/* generated declarations for records with fixed fields */
@records@


struct state {
  void* userdata;      /* a pointer to arbitrary data */
  char* heap_base;    /* the beginning of the heap */
  char* heap_limit;   /* first byte beyond the heap buffer */
  char* heap;         /* current top of the heap */
@state_type@
;      /* the current monadic state */
  unsigned char* ip_start;     /* beginning of code buffer */
  size_t ip_base;     /* base address of code */
  unsigned char* ip_limit;     /* first byte beyond the code buffer */
  unsigned char* ip;           /* current pointer into the buffer */
  int_t token_addr_inv;
  char* err_str;      /* a string describing the fatal error that occurred */
  jmp_buf err_tgt;    /* the position of the exception handler */
  FILE* handle;       /* the file that the puts primitve uses */
  char* const_heap_base;
  /* the following fields contain the values of constant GDSL expressions */
  @gdsl_constants@

};

typedef unsigned int field_tag_t;

@field_delete_arrays@


#define CHUNK_SIZE (4*1024)

#if defined(__CLANG__)
#define INLINE_ATTR inline
#elif defined(__GNUC__)
#define INLINE_ATTR inline
#elif defined(_MSC_VER)
#define INLINE_ATTR __inline
#else
#define INLINE_ATTR inline
#endif

#if defined(__CLANG__)
#define NO_INLINE_ATTR __attribute__((noinline))
#elif defined(__GNUC__)
#define NO_INLINE_ATTR __attribute__((noinline))
#elif defined(_MSC_VER)
#define NO_INLINE_ATTR __declspec(noinline)
#else
#define NO_INLINE_ATTR
#endif

#if defined(__CLANG__)
#define MALLOC_ATTR __attribute__((malloc))
#elif defined(__GNUC__)
#define MALLOC_ATTR __attribute__((malloc))
#elif defined(_MSC_VER)
#define MALLOC_ATTR __declspec(restrict)
#else
#define MALLOC_ATTR
#endif


static NO_INLINE_ATTR void alloc_heap(state_t s, char* prev_page, size_t size) {
  if (size<CHUNK_SIZE) size = CHUNK_SIZE; else size = CHUNK_SIZE*((size/CHUNK_SIZE)+1);
  s->heap_base = (char*) malloc(size);
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
  memset(&(s->mon_state), 0, sizeof(s->mon_state));
};

size_t
@heap_residency@
(state_t s) {
  char* heap = s->heap_base;
  size_t res;
  if (heap==NULL) return 0;
  res = s->heap - s->heap_base;
  while (1) {
    char* prev = *((char**) heap);
    if (prev==NULL) break;
    res += CHUNK_SIZE;
    heap = prev;
  }
  return res;
};

static INLINE_ATTR MALLOC_ATTR void* alloc(state_t s, size_t bytes) {
  bytes = ((bytes+7)>>3)<<3;    /* align to multiple of 8 */
  if (s->heap+bytes >= s->heap_limit) alloc_heap(s, s->heap_base, bytes);
  char* res = s->heap;
  s->heap = s->heap+bytes;
  return res;
};

#define GEN_ALLOC(type) \
static INLINE_ATTR type ## _t* alloc_ ## type (state_t s, type ## _t v) { \
  type ## _t* res = (type ## _t*) alloc(s, sizeof(type ## _t));\
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
  field_ ## type ## _t* res = (field_ ## type ## _t*)     \
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
    v = (field_ ## type ## _t*) v->next;                                          \
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
  field_obj_t* current = (field_obj_t*) rec;
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
      field_obj_t* copy = (field_obj_t*) alloc(s, current->size);
      memcpy(copy,current,current->size);
      *last_next = copy;
      last_next = &copy->next;
    };
    current = (field_obj_t*) current->next;
  };
  *last_next = current;
  return res;
}


/* Functions to allocate values, constructors and record fields on the heap. */
@alloc_funcs@

#define slice(vec_data,ofs,sz) ((vec_data >> ofs) & ((1ul << sz)-1))

static INLINE_ATTR vec_t gen_vec(unsigned int vec_sz,vec_data_t vec_data) {
  vec_t res;
  res.size=vec_sz;
  res.data=vec_data;
  return res;
}

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


static INLINE_ATTR int_t consume(state_t s, int_t size) {
  if(s->ip + size > s->ip_limit) {
    s->err_str = "GDSL runtime: end of code input stream";
    longjmp(s->err_tgt, 1);
  };
  int_t result = 0;
  while (size)
    result |= s->ip_start[(s->ip++ - s->ip_start) ^ s->token_addr_inv] << (--size*8);
  return result;
}

static INLINE_ATTR void unconsume(state_t s, int_t size) {
  s->ip -= size;
}

void
@endianness@
(state_t s, int_t le, int_t size) {
  if ((size != 1) && (size != 2) && (size != 4) && (size != 8)) {
    s->err_str = "GDSL runtime: endianness(); invalid token size";
    longjmp(s->err_tgt, 100);
  };
  if ((le != 0) && (le != 1)) {
    s->err_str = "GDSL runtime: endianness(); invalid kind";
    longjmp(s->err_tgt, 101);
  };
  s->token_addr_inv = le * (size - 1);
}

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

static INLINE_ATTR vec_t vec_not(state_t s, vec_t v) {
  vec_data_t mask = (1<<((vec_data_t) v.size))-1;
  vec_t res;
  res.size = v.size;
  res.data = v.data ^ mask;
  return res;
}

static INLINE_ATTR vec_data_t vec_eq(state_t s, vec_data_t d1, vec_data_t d2) {
  return (d1==d2 ? 1 : 0);
}

static INLINE_ATTR vec_t vec_concat(state_t s, vec_t v1, vec_t v2) {
  vec_t res;
  res.size = v1.size+v2.size;
  res.data = v1.data << v2.size | v2.data;
  return res;
}

static string_t int_to_string(state_t s, int_t v) {
  char *str = (char*) alloc(s, 23)+22;
  int negate = v<0;
  int r;
  *str = 0;
  do {
    r = v % 10;
    v = v / 10;
    *--str = "9876543210123456789"[r+9];
  } while (v!=0);
  if (negate) {
    *--str = '-';
  }
  return alloc_string(s,str);
};

void
@set_code@
(state_t s, unsigned char* buf, size_t buf_len, size_t base) {
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
  string_t buf,end;
  int_t len =
@rope_length@
(s,rope);
  if (len<0) return ""; /* make MSVC happy */
  buf = (string_t) alloc(s,(size_t) len);
  end =
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
  char* heap;
  free(s->heap_base);
  /* free heap of GDSL constants */
  heap = s->const_heap_base;
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
(void) {
  state_t s = calloc(1,sizeof(struct state));
  s->handle = stdout;
  /* compute all constant expressions */
@gdsl_init_constants@

  /* keep the heap of constant expressions separate */
  s->const_heap_base = s->heap_base;
  s->heap_base = NULL;
  s->heap_limit = NULL;
  s->heap = NULL;

  @endianness@
  (s, 0, 1);

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
static unsigned char blob[BUF_SIZE];

int readNum(char* str, size_t* res) {
  size_t mult = 10;
  *res = 0;
  while (*str) {
    char c = *str;
    if (c=='x') mult=16; else
      if ((c>='0') && (c<='9')) *res=*res*mult+(size_t) (c-'0'); else
        if ((c>='a') && (c<='f')) *res=*res*mult+10+(size_t) (c-'a'); else
          if ((c>='A') && (c<='F')) *res=*res*mult+10+(size_t) (c-'A'); else
            return 1;
    str++;
  }
  return 0;
}

int main (int argc, char** argv) {
  size_t buf_size = BUF_SIZE;
  FILE* file = NULL;
  int_t decode_options =
#if defined(gdsl_default_config)
    gdsl_default_config;
#else
    0;
#endif
  int_t rreil_options;
  int_t run_translate = 0;
  int_t translate_options = 0;
  size_t base_address = 0;
  size_t start_address = 0;
  int print_addr = 0;
  obj_t config;
  state_t s = gdsl_init();
  long long alloc_size,alloc_no,alloc_max;
  
  /* read command line parameters */
  int i;
  for(i=1; i<argc; i++) {
    char* arg = argv[i];
    if (strncmp(arg,"--",2)) {
#ifdef _MSC_VER
      fopen_s(&file,arg,"r");
#else
      file = fopen(arg,"r");
#endif
      if (file==NULL) {
        printf("file '%s' not found, please run %s --help for usage\n", arg, argv[0]);
        return 1;
      }
    } else {
      int negated = 0;
      arg+=2;
      if (strcmp(arg,"no-")==0) { negated = 1; arg+=3; };
#if defined(gdsl_decoder_config)
      for (config = gdsl_decoder_config(s); gdsl_has_conf(s,config);
        config = gdsl_conf_next(s,config))
        if (strcmp(arg,gdsl_conf_short(s,config))==0) {
          if (negated)
            decode_options &= ~gdsl_conf_data(s,config);
          else
            decode_options |= gdsl_conf_data(s,config);
          break;
        }
      if (gdsl_has_conf(s,config)) continue;
#endif
#if defined(gdsl_rreil_config)
      for (config = gdsl_rreil_config(s); gdsl_has_conf(s,config);
        config = gdsl_conf_next(s,config))
        if (strcmp(arg,gdsl_conf_short(s,config))==0) {
          if (negated)
            rreil_options &= ~gdsl_conf_data(s,config);
          else
            rreil_options |= gdsl_conf_data(s,config);
          break;
        }
      if (gdsl_has_conf(s,config)) continue;
#endif
      if (strncmp(arg,"base=",5)==0) {
        int res=readNum(arg+5,&base_address);
        print_addr=1;
        if (res==0) continue;
      }
      if (strncmp(arg,"start=",6)==0) {
        int res=readNum(arg+6,&start_address);
        if (res==0) continue;
      }
      if (strcmp(arg,"trans")==0) {
        run_translate = 1;
        continue;
      }
      fprintf(stderr,
        "usage: %s [options] filename\nwhere\n"
        "  --trans               translate to semantics\n"
        "  --base=addr           print addresses relative to addr\n"
        "  --start=addr          decode starting from addr\n", argv[0]);
#if defined(gdsl_decoder_config)
      for (config = gdsl_decoder_config(s); gdsl_has_conf(s,config);
        config = gdsl_conf_next(s,config))
        fprintf(stderr,"  --%s\t\t%s%s\n  --no-%s%s\t\tnegated option\n",
          gdsl_conf_short(s,config),
          gdsl_conf_data(s,config) & decode_options ? "*" : "",
          gdsl_conf_long(s,config),
          gdsl_conf_short(s,config),
          gdsl_conf_data(s,config) & decode_options ? "" : "*");
#endif
#if defined(gdsl_rreil_config)
      for (config = gdsl_rreil_config(s); gdsl_has_conf(s,config);
        config = gdsl_conf_next(s,config))
        fprintf(stderr,"  --%s\t\t%s%s\n  --no-%s%s\t\tnegated option\n",
          gdsl_conf_short(s,config),
          gdsl_conf_data(s,config) & rreil_options ? "*" : "",
          gdsl_conf_long(s,config),
          gdsl_conf_short(s,config),
          gdsl_conf_data(s,config) & rreil_options ? "" : "*");
#endif
      fprintf(stderr,"The default is denoted by *.\n");
      return 1;
    }
  }
  /* fill the buffer, either in binary from file or as sequence
     of hex bytes separated by space or newlines */
  if (file) {
    size_t bytes_read = fread(blob, 1, BUF_SIZE, file);
    if (bytes_read == 0) return 1;
    buf_size = bytes_read;
  } else {
    size_t i=0;
    int num=0;
    int digit=0;
    while (i<buf_size) {
      int x = getchar();
      if (x==EOF) buf_size = i; else
      if ((x>='0') && (x<='9')) { num=num*16+(x-'0'); digit++; } else
      if ((x>='a') && (x<='f')) { num=num*16+(10+x-'a'); digit++; } else
      if ((x>='A') && (x<='F')) { num=num*16+(10+x-'A'); digit++; } else
      if (x>' ') {
        fprintf(stderr, "invalid input; should be in hex form: '0f 0b ..'.\n");
        return 1;
      }
      if (digit==2) { blob[i] = num & 0xff; i+=1; digit=0; };
    }
  }  
  /* initialize the GDSL program */
  gdsl_set_code(s, blob, buf_size, base_address);
  gdsl_seek(s, start_address);

  alloc_size = 0;
  alloc_no = 0;
  alloc_max = 0;

  while (gdsl_get_ip_offset(s)<buf_size) {
    size_t size;
    size_t address=0;
    if (setjmp(*gdsl_err_tgt(s))==0) {
      if (run_translate) {
#ifdef HAVE_TRANS
        address = gdsl_get_ip_offset(s);
        obj_t rreil = gdsl_decode_translate_block_optimized(s,
          decode_options,
          gdsl_int_max(s),
          rreil_options);
        obj_t res = gdsl_rreil_pretty(s,rreil);
        string_t str = gdsl_merge_rope(s,res);
        if (print_addr) printf("0x%016lx:\n",address);
        fputs(str,stdout);
#else
        fputs("GDSL modules contain no semantic translation\n",stdout);
        return 1;
#endif
      } else {
#ifdef HAVE_DECODE
        address = gdsl_get_ip_offset(s);
        obj_t instr = gdsl_decode(s, decode_options);
        obj_t res = gdsl_pretty(s,instr);
        string_t str = gdsl_merge_rope(s,res);
        if (print_addr) printf("%016lx ",address);
        fputs(str,stdout);
#else
        fputs("GDSL modules contain no decoder function\n",stdout);
        return 1;
#endif
      }
    } else {
      fprintf(stdout,"exception at address 0x%lx: %s", address, gdsl_get_error_message(s));
      size_t step = (s->token_addr_inv>0 ? (size_t) s->token_addr_inv+1 : 1u);
      gdsl_seek(s,address+step);
    }
    fputs("\n",stdout);
    size = gdsl_heap_residency(s);
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


