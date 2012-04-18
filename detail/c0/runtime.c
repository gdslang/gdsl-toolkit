
#include "runtime.h"

__unwrapped_obj heap[__RT_HEAP_SIZE] __attribute((aligned(8)));
__objref hp = &heap[__RT_HEAP_SIZE];
struct __unwrapped_immediate __unwrapped_UNIT =
  {.header.tag = __NIL};
__obj __UNIT = __WRAP(&__unwrapped_UNIT);

void __fatal (char *fmt, ...) {
  va_list ap;
  va_start(ap, fmt);
  vfprintf(stderr, fmt, ap);
  va_end(ap);
  abort();
}

__obj __print (__obj obj) {
  switch (__TAG(obj)) {
    case __CLOSURE:
      printf("<#closure>\n");
      break;
    case __INT:
      printf("<#int: %ld>\n", obj->z.value);
      break;
    case __TAGGED:
      printf("<#tagged>\n");
      break;
    case __LABEL:
      printf("<#label>\n");
      break;
    default:
      printf("<#unknown>\n");
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


int main (int argc, char** argv) {

  printf("hp: %p size: %zu\n", hp, sizeof(__unwrapped_obj));
  printf("argc: %d\n", argc);

  __LOCAL0(x);
    __INT_BEGIN(x);
    __INT_INIT(argc);
    __INT_END(x);

  __LOCAL0(y);
    __INT_BEGIN(y);
    __INT_INIT(13);
    __INT_END(y);

  __LOCAL0(z);
    __INT_BEGIN(z);
    __INT_INIT(14);
    __INT_END(z);


  __LOCAL0(s);
    __LABEL_BEGIN(s);
    __LABEL_INIT(print);
    __LABEL_END(s);

  __LOCAL0(c);
    __CLOSURE_BEGIN(c, 4);
    __CLOSURE_ADD(z);
    __CLOSURE_ADD(y);
    __CLOSURE_ADD(x);
    __CLOSURE_ADD(s);
    __CLOSURE_END(c, 4);

  __INVOKE1(s, c);
  return -1; 
}
