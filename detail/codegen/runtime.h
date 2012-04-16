
#ifndef __RUNTIME_H
#define __RUNTIME_H

#include <stdlib.h>
#include <stdio.h>

#define __RT_HEAP_SIZE 10000

#define __RECORD_BEGIN(Cname, n)
#define __RECORD_INIT(field, value)
#define __RECORD_END(Cname, n)
#define __RECORD_BEGIN_UPDATE()
#define __RECORD_END_UPDATE()
#define __RECORD_SELECT(Cname, idx)
#define __RECORD_BIND_FIELD(Cname, field, value)

#define __TUPLE_BEGIN(Cname)
#define __TUPLE_INIT_FST(value)
#define __TUPLE_INIT_SND(value)
#define __TUPLE_END(Cname)

#define __ALLOC1() --hp /* TODO: check for heap-overflow */
#define __ALLOC0() hp /* TODO: check for heap-overflow */
  
#define __INVOKE0(o, closure)\
   ((__obj (*)(__obj))(o->label.f))(closure)

#define __INT_BEGIN(Cname)\
  {__objref p = __ALLOC1()

#define __INT_INIT(val)\
   p->z.header.tag = __INT;\
   p->z.value = val
   
#define __INT_END(Cname)\
   Cname = __WRAP(p);}

#define __LABEL_BEGIN(Cname)\
  {__objref p = __ALLOC1()

#define __LABEL_INIT(val)\
   p->label.header.tag = __LABEL;\
   p->label.f = (__obj (*)(void)) val
   
#define __LABEL_END(Cname)\
   Cname = __WRAP(p);}

#define __CLOSURE_BEGIN(Cname, n)\
  {__objref p = __ALLOC1();\
   p->closure.header.tag = __CLOSURE;\
   p->closure.env = p + 1

#define __CLOSURE_ADD(value)\
   {__objref v = __ALLOC1();\
    *v = *(__UNWRAP(value));}

#define __CLOSURE_END(Cname, n)\
   Cname = __WRAP(p);}

#define __CLOSURE_REF(Cname, n) (__WRAP(&(Cname->closure.env[n])))

#define __BEGIN_JUMP()
#define __END_JUMP()

#define __LOCAL0(Cname) __obj Cname
#define __LOCAL(Cname, body) __obj Cname = body

typedef union __unwrapped_obj __unwrapped_obj;
typedef union __wrapped_obj __wrapped_obj;
typedef __unwrapped_obj* __objref;
typedef __wrapped_obj* __obj;

enum __tag {
  __CLOSURE,
  __BV,
  __INT,
  __TUPLE,
  __LABEL
};

union __header {
  enum __tag tag;
  __obj ignored;
} __attribute__((packed));

union __unwrapped_obj {
  struct __unwrapped_immediate {
    union __header header;
  } object;
  struct __unwrapped_tuple {
    union __header header;
    __obj fst;
    __obj snd;
  } tuple;
  struct __unwrapped_closure {
    union __header header;
    __objref env;
  } closure;
  struct __unwrapped_label {
     union __header header;
     __obj (*f)(void);
  } label;
  struct __unwrapped_int {
     union __header header;
     int value;
  } z;
} __attribute__((packed));

union __wrapped_obj {
  struct __tuple {
    __obj fst;
    __obj snd;
  } tuple;
  struct __closure {
    __objref env;
  } closure;
  struct __label {
     __obj (*f)(void);
  } label;
  struct __int {
     int value;
  } z;
} __attribute__((packed));

#define __WRAP(x) ((__obj)(((union __header*)x)+1))
#define __UNWRAP(x) ((__objref)(((union __header*)x)-1))
#define __TAG(x) ((__UNWRAP((__obj)x))->object.header.tag)

#endif
