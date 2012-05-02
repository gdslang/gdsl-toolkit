
#include "dis.h"

__unwrapped_obj heap[__RT_HEAP_SIZE] __attribute((aligned(8)));
__objref hp = &heap[__RT_HEAP_SIZE];

@prototypes@

struct __unwrapped_immediate __unwrapped_UNIT = {.header.tag = __NIL};
__obj __UNIT = __WRAP(&__unwrapped_UNIT);

void __fatal (char *fmt, ...) {
  va_list ap;
  va_start(ap, fmt);
  vfprintf(stderr, fmt, ap);
  fprintf(stderr, "\n");
  va_end(ap);
  abort();
}

__obj __consume (__obj s) {
  __LOCAL0(x);
    __BV_BEGIN(x,8);
    __BV_INIT(0x01);
    __BV_END(x,8);
  __LOCAL0(r);
    __RECORD_BEGIN(r,2);
    __RECORD_ADD(14,x);
    __RECORD_ADD(15,s);
    __RECORD_END(r,2);
  return r;
}

__obj __slice (__obj tok_, __obj offs_, __obj sz_, __obj s) {
  __word tok = tok_->bv.vec;
  __int offs = offs_->z.value;
  __int sz = sz_->z.value;
  __word x = ((tok >> offs) & ((1 << sz)-1));
  __LOCAL0(slice);
    __BV_BEGIN(slice,sz);
    __BV_INIT(x);
    __BV_END(slice,sz);
  __LOCAL0(r);
    __RECORD_BEGIN(r,2);
    __RECORD_ADD(14,slice);
    __RECORD_ADD(15,s);
    __RECORD_END(r,2);
  return r;
}

__obj __print (__obj o) {
  switch (__TAG(o)) {
    case __CLOSURE:
      printf("{type=__CLOSURE,...}\n");
      break;
    case __INT:
      printf("{type=__INT,value=%ld}\n", o->z.value);
      break;
    case __TAGGED:
      printf("{type=__TAGGED,...}\n");
      break;
    case __RECORD:
      printf("{type=__RECORD,...}\n");
      break;
    case __LABEL:
      printf("{type=__LABEL,...}\n");
      break;
    case __BLOB:
      printf("{type=__BLOB,...}\n");
      break;
    case __BV:
      printf("{type=__BV,...}\n");
      break;
    case __NIL:
      printf("{type=__NIL}\n");
      break;
    default:
      printf("{type=<unknown>}\n");
   }
   return __UNIT;
}

__obj print (__obj env) {
  __LOCAL(x, __CLOSURE_REF(env, 1));
  __LOCAL(y, __CLOSURE_REF(env, 2));
  __LOCAL(z, __CLOSURE_REF(env, 3));
  __print(x);
  __print(y);
  __print(z);
  return __UNIT;
}

__obj kont (__obj env, __obj o) {
   printf("kont\n");
   __print(o);
   return o;
};

extern __obj main_31 (__obj,__obj,__obj);

__obj test () {
  __LOCAL0(k);
    __LABEL_BEGIN(k);
    __LABEL_INIT(kont);
    __LABEL_END(k);
  __LOCAL0(envK);
    __CLOSURE_BEGIN(envK,1)
    __CLOSURE_ADD(k);
    __CLOSURE_END(envK,1);
  __LOCAL0(m);
    __LABEL_BEGIN(m);
    __LABEL_INIT(main_31);
    __LABEL_END(m);
  __LOCAL0(envM);
    __CLOSURE_BEGIN(envM,1)
    __CLOSURE_ADD(m);
    __CLOSURE_END(envM,1);
  __LOCAL0(s);
    __RECORD_BEGIN(s,0);
    __RECORD_END(s,0);
  return __INVOKE3(m,envM,envK,s);
}

@functions@

int main (int argc, char** argv) {

  printf("hp: %p size: %zu\n", hp, sizeof(__unwrapped_obj));
  printf("argc: %d\n", argc);
  __obj o = test();
  __print(o);
  return -1; 
}
