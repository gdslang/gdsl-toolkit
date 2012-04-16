
#include "runtime.h"

__unwrapped_obj heap[__RT_HEAP_SIZE];
__objref hp = &heap[__RT_HEAP_SIZE];

__obj __print (__obj obj) {
  switch (__TAG(obj)) {
    case __CLOSURE:
      printf("<#closure>\n");
      break;
    case __INT:
      printf("<#int: %d>\n", obj->z.value);
      break;
    case __TUPLE:
      printf("<#tuple>\n");
      break;
    case __LABEL:
      printf("<#label>\n");
      break;
    default:
      printf("<#unknown>\n");
   }
   return NULL;
}

__obj print (__obj env) {
  __LOCAL(x, __CLOSURE_REF(env, 1));
  return __print(x);
}


int main (int argc, char** argv) {

  printf("hp: %p size: %zu\n", hp, sizeof(__unwrapped_obj));

  __LOCAL0(x);
    __INT_BEGIN(x);
    __INT_INIT(argc);
    __INT_END(x);
  printf("x: %p argc: %d\n", hp, argc);
  __print(x);

  __LOCAL0(s);
    __LABEL_BEGIN(s);
    __LABEL_INIT(print);
    __LABEL_END(s);

  __LOCAL0(c);
    __CLOSURE_BEGIN(c, 0);
    __CLOSURE_ADD(s);
    __CLOSURE_ADD(x);
    __CLOSURE_END(c, 0);

  __INVOKE0(s, c);
  return -1; 
}
