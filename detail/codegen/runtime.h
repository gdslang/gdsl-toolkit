
#ifndef __RUNTIME_H
#define __RUNTIME_H

#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <stdarg.h>
#include <string.h>

#define __RT_HEAP_SIZE 10000

#define __ALLOC1() --hp /* TODO: check for heap-overflow */
#define __ALLOC0() hp /* TODO: check for heap-overflow */
#define __ALLOCN(n) hp-=n /* TODO: check for heap-overflow */

#define __INVOKE1(o, closure)\
   ((__obj (*)(__obj))(o->label.f))(closure)

#define __INVOKE2(o, closure, x)\
   ((__obj (*)(__obj,__obj))(o->label.f))(closure, x)

#define __INVOKE3(o, closure, x, y)\
   ((__obj (*)(__obj,__obj,__obj))(o->label.f))(closure, x, y)

#define __INVOKE4(o, closure, x, y, z)\
   ((__obj (*)(__obj,__obj,__obj,__obj))(o->label.f))(closure, x, y, z)

/** ## Integers */

#define __INT_BEGIN(Cname)\
  {__objref p = __ALLOC1();\
   p->z.header.tag = __INT

#define __INT_INIT(val)\
   p->z.value = val
   
#define __INT_END(Cname)\
   Cname = __WRAP(p);}

/** ## Labels */

#define __LABEL_BEGIN(Cname)\
  {__objref p = __ALLOC1();\
   p->label.header.tag = __LABEL

#define __LABEL_INIT(val)\
   p->label.f = (__obj (*)(void)) val
   
#define __LABEL_END(Cname)\
   Cname = __WRAP(p);}

/** ## Closures */

#define __CLOSURE_BEGIN(Cname, n)\
  {__objref p = __ALLOC1();\
   p->closure.header.tag = __CLOSURE;\
   p->closure.sz = n;\
   p->closure.env = p + 1

#define __CLOSURE_ADD(value)\
   {__objref v = __ALLOC1();\
    *v = *(__UNWRAP(value));}

#define __CLOSURE_END(Cname, n)\
   Cname = __WRAP(p);}

#define __CLOSURE_REF(Cname, n) (__WRAP(&(Cname->closure.env[n])))

/** ## Records */

#define __RECORD_BEGIN(Cname, n)\
  {__objref p = ALLOC1();\
   p->record.header.tag = __RECORD;\
   p->record.sz = n;\
   p->record.fields = p + 1

#define __RECORD_ADD(tag, value)\
  {__objrev f = ALLOC1();\
   f.tagged.tag = tag;\
   f.tagged.payload = value;}

#define __RECORD_END(Cname, n)\
   Cname = __WRAP(p);}

#define __RECORD_BEGIN_UPDATE(Cdst, Csrc)
#define __RECORD_UPDATE(tag, value)
#define __RECORD_END_UPDATE(Cdst)

#define __RECORD_SELECT(Cname, field)\
  __recordLookup(((struct __record*)Cname), field)->tagged.payload
   
/** ## Bitvectors */

#define __BV_BEGIN(Cname, n)
#define __BV_INIT(value)
#define __BV_END(Cname, n)

/** ## Tagged values (datatypes) */

#define __TAGGED_BEGIN(Cname)
#define __TAGGED_INIT(tag, value)
#define __TAGGED_END(Cname)

#define __LOCAL0(Cname) __obj Cname
#define __LOCAL(Cname, body) __obj Cname = body

typedef union __header __header;
typedef union __unwrapped_obj __unwrapped_obj;
typedef union __wrapped_obj __wrapped_obj;
typedef __unwrapped_obj* __objref;
typedef __wrapped_obj* __obj;
typedef uint64_t __word;
typedef int64_t __int;

enum __tag {
  __CLOSURE,
  __BV,
  __INT,
  __TAGGED,
  __RECORD,
  __LABEL
};

union __header {
  enum __tag tag;
  __obj ignored;
} __attribute__((packed,aligned(8)));

union __unwrapped_obj {
  struct __unwrapped_immediate {
    __header header;
  } object;
  struct __unwrapped_tagged {
    __header header;
    __word tag;
    __obj payload;
  } tagged;
  struct __unwrapped_closure {
    __header header;
    __word sz;
    __objref env;
  } closure;
  struct __unwrapped_record {
    __header header;
    __word sz;
    __objref fields;
  } record;
  struct __unwrapped_bv {
    __header header;
    __word sz;
    __word vec;
  } bv;
  struct __unwrapped_label {
    __header header;
    __obj (*f)(void);
  } label;
  struct __unwrapped_int {
    __header header;
    __int value;
  } z;
} __attribute__((packed,aligned(8)));

union __wrapped_obj {
  struct __tagged {
    __word tag;
    __obj payload;
  } tagged;
  struct __closure {
    __word sz;
    __objref env;
  } closure;
  struct __record {
    __word sz;
    __objref fields;
  } record;
  struct __bv {
    __word sz;
    __word vec;
  } bv;
  struct __label {
    __obj (*f)(void);
  } label;
  struct __int {
    __int value;
  } z;
} __attribute__((packed,aligned(8)));

#define __WRAP(x) ((__obj)(((__header*)x)+1))
#define __UNWRAP(x) ((__objref)(((__header*)x)-1))
#define __TAG(x) ((__UNWRAP((__obj)x))->object.header.tag)

extern void __fatal(char*,...) __attribute__((noreturn));
extern __unwrapped_obj heap[__RT_HEAP_SIZE] __attribute__((aligned(8)));
extern __objref hp;
extern __obj __UNIT;

static inline __objref __recordLookup (struct __record* record, __word field) {
  __word i, sz = record->sz;
  __objref fields = record->fields;
  for (i = 0; i < sz; i++) {
    __objref o = &fields[i];
    if (o->tagged.tag == field)
       return o;
  }
  __fatal("record-field '%lz' not found", field);
}

static inline __objref __recordCloneFields (struct __record* record) {
  __word sz = record->sz;
  __objref fields = __ALLOCN(sz);
  memcpy(fields, record->fields, sz*sizeof(__unwrapped_obj));
  return fields;
}

#endif
