/* vim:ts=2:sw=2:expandtab */
#include <stdio.h>
#include <stdint.h>
#include <stdarg.h>
#include <stddef.h>
#include <string.h>
#include <setjmp.h>
#include <avcall.h>
#include <gdslrt.h>

void alloc_heap(state_t s, char* prev_page) {
  unsigned int size = 1024*4096;
  s->heap_base = malloc(size);
  if (s->heap_base==NULL) {
    s->err_str = "GDSL runtime: out of memory";
    longjmp(s->err_tgt,2);
  };
  s->heap = s->heap_base+sizeof(char*);
  /* store a pointer to the previous page in the first bytes of this page */
  *((char**) s->heap_base) = prev_page;
  s->heap_limit = s->heap_base+size;
}

void gdsl_reset_heap(state_t s) {
  char* heap = s->heap_base;
  while (heap!=NULL) {
    char* prev = *((char**) heap);
    free (heap);
    heap = prev;
  }
  s->heap = 0;
  s->heap_base = 0;
  s->heap_limit = 0;
  s->state = 0;
}

/* Returns a pointer to a record in which the given fields are removed.
  This operation copies all fields of the record except for those that
  are to be removed. The function returns the tail of the old record if
  all given fields could be removed before the end of the record was
  reached.
*/
obj_t del_fields(state_t s, field_tag_t tags[], int tags_size, obj_t rec) {
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

jmp_buf* gdsl_err_tgt(state_t s) {
  return &(s->err_tgt);
}

char* gdsl_get_error_message(state_t s) {
  return s->err_str;
}

int_t vec_to_signed(state_t s, vec_t v) {
  unsigned int bit_size = sizeof(int_t)*8;
  if (v.size>bit_size) {
    s->err_str = "GDSL runtime: signed applied to very long vector";
    longjmp(s->err_tgt,2);
  };
  int bits_to_fill = bit_size-v.size;
  return (((int_t) v.data) << bits_to_fill) >> bits_to_fill;
}

int_t vec_to_unsigned(state_t s, vec_t v) {
  unsigned int int_bitsize = sizeof(int_t)*8;
  if (v.size>int_bitsize) {
    s->err_str = "GDSL runtime: unsigned applied to very long vector";
    longjmp(s->err_tgt,2);
  };
  return (int_t) v.data;
}

obj_t vec_to_string(state_t s, vec_t v) {
  char* str = alloc(s, v.size+1);
  char* idx = str;
  vec_data_t mask;
  for (mask = 1<<(v.size-1); mask!=0; mask>>=1)
    *(idx++) = (v.data & mask ? '1' : '0');
  *idx = 0;
  return alloc_string(s,str);
}

int64_t gdsl_seek(state_t s, int64_t i) {
  size_t size = (size_t)(s->ip_limit - s->ip_base);
	if(i >= size || i < 0)
	  return 1;
	s->ip = s->ip_base + i;
	return 0;
}

int64_t gdsl_rseek(state_t s, int64_t i) {
  char *new_ip = s->ip + i;
	if(new_ip >= s->ip_limit || new_ip < s->ip_base)
	  return 1;
	s->ip = new_ip;
	return 0;
}

// static string_t invoke(state_t s, obj_t func, obj_t args) {
//   func = x86_string__payload(s, func);  
// 
//  av_alist arg_list;
//  string_t result;
//  av_start_ptr(arg_list, func, string_t, &result);
// 
//  obj_t next = args;
//  while(1) {
//    if(x86_con_index(s, next) == CON_P_NIL)
//      break;
//    obj_t unwrapped = x86_p_cons_unwrap(s, next);
// 
//    obj_t parameter = x86_select_hd(s, unwrapped);
//    if(x86_p_is_int(s, parameter))
//      av_long(arg_list, *(int64_t*)x86_p_unwrap_i(s, parameter));
//    else
//      av_ptr(arg_list, string_t, x86_p_unwrap_o(s, parameter));
// 
//    next = x86_select_tl(s, unwrapped);
//  }
// 
//  av_call(arg_list);
// 
//  return result;
// //  obj_t (*f)(void) = (obj_t (*)(void))func;
// //  return (string_t)f();
// }
// 
// static obj_t invoke_int(state_t s, obj_t func, int64_t i) {
//   obj_t (*f)(int64_t) = (obj_t (*)(int64_t))func;
//   return f(i);
// }

state_t gdsl_init() {
  state_t s = calloc(1,sizeof(struct state));
  return s;
}

void gdsl_set_code(state_t s, char* buf, size_t buf_len, uint64_t base) {
  s->ip = buf;
  s->ip_limit = buf+buf_len;
  s->ip_base = buf-base;
}

uint64_t gdsl_get_ip_offset(state_t s) {
  return s->ip - s->ip_base;
}

void gdsl_destroy(state_t s) {
  gdsl_reset_heap(s);
  free(s);
}

