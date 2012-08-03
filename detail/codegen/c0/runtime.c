/* vim:ts=2:sw=2:expandtab */

#include "dis.h"

__unwrapped_obj heap[__RT_HEAP_SIZE] __attribute__((aligned(8)));
__objref hp = &heap[__RT_HEAP_SIZE];

@fieldnames@

@tagnames@

@prototypes@

struct __unwrapped_immediate __unwrapped_UNIT =
   {.header.tag = __NIL};
struct __unwrapped_bv __unwrapped_TRUE =
   {.header.tag = __BV,
    .sz = 1,
    .vec = 1};
struct __unwrapped_bv __unwrapped_FALSE =
   {.header.tag = __BV,
    .sz = 1,
    .vec = 0};

__obj __UNIT = __WRAP(&__unwrapped_UNIT);
__obj __TRUE = __WRAP(&__unwrapped_TRUE);
__obj __FALSE = __WRAP(&__unwrapped_FALSE);

void __fatal (char *fmt, ...) {
  va_list ap;
  va_start(ap,fmt);
  fprintf(stderr,"[FATAL:");
  vfprintf(stderr,fmt,ap);
  fprintf(stderr,"]\n");
  va_end(ap);
  abort();
}

__obj __and (__obj A, __obj B) {
  __word a = A->bv.vec;
  __word b = B->bv.vec;
  __word sz = A->bv.sz;
  __LOCAL0(c);
    __BV_BEGIN(c,sz);
    __BV_INIT(a & b)
    __BV_END(c,sz);
  return (c);
}

__obj __or (__obj A, __obj B) {
  __word a = A->bv.vec;
  __word b = B->bv.vec;
  __word sz = A->bv.sz;
  __LOCAL0(c);
    __BV_BEGIN(c,sz);
    __BV_INIT(a | b);
    __BV_END(c,sz);
  return (c);
}

/** ## Operations on integers */

__obj __addi (__obj A, __obj B) {
  __int a = A->z.value;
  __int b = B->z.value;
  __LOCAL0(x);
    __INT_BEGIN(x);
    __INT_INIT(a + b);
    __INT_END(x);
  return (x);
}

__obj __subi (__obj A, __obj B) {
  __int a = A->z.value;
  __int b = B->z.value;
  __LOCAL0(x);
    __INT_BEGIN(x);
    __INT_INIT(a - b);
    __INT_END(x);
  return (x);
}

__obj __muli (__obj A, __obj B) {
  __int a = A->z.value;
  __int b = B->z.value;
  __LOCAL0(x);
    __INT_BEGIN(x);
    __INT_INIT(a * b);
    __INT_END(x);
  return (x);
}

__obj __eqi (__obj A, __obj B) {
  __int a = A->z.value;
  __int b = B->z.value;
  return (a==b?__TRUE:__FALSE);
}

__obj __lti (__obj A, __obj B) {
  __int a = A->z.value;
  __int b = B->z.value;
  return (a<b?__TRUE:__FALSE);
}

__obj __lei (__obj A, __obj B) {
  __int a = A->z.value;
  __int b = B->z.value;
  return (a<=b?__TRUE:__FALSE);
}

/* FIXME */
__obj __sx (__obj x) {
  __LOCAL0(y);
    __INT_BEGIN(y);
    __INT_INIT(x->bv.vec);
    __INT_END(y);
  return (y);
}

/* FIXME */
__obj __zx (__obj x) {
  __LOCAL0(y);
    __INT_BEGIN(y);
    __INT_INIT(x->bv.vec);
    __INT_END(y);
  return (y);
}

__obj __concat (__obj A, __obj B) {
  __word a = A->bv.vec;
  __word b = B->bv.vec;
  __word szOfA = A->bv.sz;
  __word szOfB = B->bv.sz;
  __word sz = szOfA + szOfB;
  __LOCAL0(x);
    __BV_BEGIN(x,sz);
    __BV_INIT((a << szOfB) | b);
    __BV_END(x,sz);
  return (x);
}

__obj __concatstring (__obj A, __obj B) {
  __LOCAL0(R);
    __ROPE_BEGIN(R);
    __ROPE_CONCAT(A,B);
    __ROPE_END(R);
  return (R);
}

__obj __flattenstring(__obj o, char* buf, __word sz) {
  switch (__TAG(o)) {
    case __ROPELEAF: {
      __word l = strlen(buf);
      sz = sz - l;
      if (sz == 0) return (__UNIT);
      __word szz = o->ropeleaf.sz;
      __word len = szz >= sz ? sz-1 : szz;
      memcpy(buf+l,o->ropeleaf.blob,len);
      buf[l+len] = '\0';
      return (__UNIT);
      break;
    }
    case __ROPEBRANCH: {
      __flattenstring(o->ropebranch.left,buf,sz);
      __flattenstring(o->ropebranch.right,buf,sz);
      return (__UNIT);
      break;
    }
    default:
      __fatal("Object not of type {ROPE}");
  };
}

__obj __equal (__obj A, __obj B) {
  __word a = A->bv.vec;
  __word b = B->bv.vec;
  __word szOfA = A->bv.sz;
  __word szOfB = B->bv.sz;
  __LOCAL(x, (a == b && szOfA == szOfB) ? __TRUE : __FALSE); 
  return (x);
}

__obj __not (__obj A) {
  __word a = A->bv.vec;
  __word sz = A->bv.sz;
  __LOCAL0(x);
    __BV_BEGIN(x,sz);
    __BV_INIT(~a & ((1 << sz)-1));
    __BV_END(x,sz);
  return (x);
}

__obj __raise (__obj o) {
  printf("raising: ");
  __println(o);
  __fatal("Unhandled exception");
  return (o);
}

__obj __consume8 (__obj s) {
  __LOCAL(blob, __RECORD_SELECT(s,___blob));
  __char* buf = blob->blob.blob;
  __word sz = blob->blob.sz;
  if (sz == 0)
    __fatal("end-of-blob");
  __char x = *buf;
  __LOCAL0(v);
    __BV_BEGIN(v,8);
    __BV_INIT(x);
    __BV_END(v,8);
  __LOCAL0(blobb);
    __BLOB_BEGIN(blobb);
    __BLOB_INIT(buf+1,sz-1);
    __BLOB_END(blobb);
  __LOCAL0(ss);
    __RECORD_BEGIN_UPDATE(ss,s);
    __RECORD_UPDATE(___blob,blobb);
    __RECORD_END_UPDATE(ss);
  __LOCAL0(a);
    __RECORD_BEGIN(a,2);
    __RECORD_ADD(___1,v);
    __RECORD_ADD(___2,ss);
    __RECORD_END(a,2);
  return (a);
}

__obj __unconsume8 (__obj s) {
  __LOCAL(blob, __RECORD_SELECT(s,___blob));
  __char* buf = blob->blob.blob;
  __word sz = blob->blob.sz;
  __LOCAL0(blobb);
    __BLOB_BEGIN(blobb);
    __BLOB_INIT(buf-1,sz+1);
    __BLOB_END(blobb);
  __LOCAL0(ss);
    __RECORD_BEGIN_UPDATE(ss,s);
    __RECORD_UPDATE(___blob,blobb);
    __RECORD_END_UPDATE(ss);
  __LOCAL0(a);
    __RECORD_BEGIN(a,2);
    __RECORD_ADD(___1,__UNIT);
    __RECORD_ADD(___2,ss);
    __RECORD_END(a,2);
  return (a);
}

__obj __consume16 (__obj s) {
  __LOCAL(blob, __RECORD_SELECT(s,___blob));
  __char* buf = blob->blob.blob;
  __word sz = blob->blob.sz;
  if (sz < 2)
    __fatal("end-of-blob");
  uint16_t x1 = buf[0];
  uint16_t x2 = buf[1]<<8;
  __LOCAL0(v);
    __BV_BEGIN(v,16);
    __BV_INIT((x1|x2)&0xffff);
    __BV_END(v,16);
  __LOCAL0(blobb);
    __BLOB_BEGIN(blobb);
    __BLOB_INIT(buf+2,sz-2);
    __BLOB_END(blobb);
  __LOCAL0(ss);
    __RECORD_BEGIN_UPDATE(ss,s);
    __RECORD_UPDATE(___blob,blobb);
    __RECORD_END_UPDATE(ss);
  __LOCAL0(a);
    __RECORD_BEGIN(a,2);
    __RECORD_ADD(___1,v);
    __RECORD_ADD(___2,ss);
    __RECORD_END(a,2);
  return (a);
}

__obj __unconsume16 (__obj s) {
  __LOCAL(blob, __RECORD_SELECT(s,___blob));
  __char* buf = blob->blob.blob;
  __word sz = blob->blob.sz;
  __LOCAL0(blobb);
    __BLOB_BEGIN(blobb);
    __BLOB_INIT(buf-2,sz+2);
    __BLOB_END(blobb);
  __LOCAL0(ss);
    __RECORD_BEGIN_UPDATE(ss,s);
    __RECORD_UPDATE(___blob,blobb);
    __RECORD_END_UPDATE(ss);
  __LOCAL0(a);
    __RECORD_BEGIN(a,2);
    __RECORD_ADD(___1,__UNIT);
    __RECORD_ADD(___2,ss);
    __RECORD_END(a,2);
  return (a);
}

__obj __consume32 (__obj s) {
  __LOCAL(blob, __RECORD_SELECT(s,___blob));
  __char* buf = blob->blob.blob;
  __word sz = blob->blob.sz;
  if (sz < 4)
    __fatal("end-of-blob");
  uint32_t x1 = buf[0];
  uint32_t x2 = buf[1]<<8;
  uint32_t x3 = buf[2]<<16;
  uint32_t x4 = buf[3]<<24;
  __LOCAL0(v);
    __BV_BEGIN(v,32);
    __BV_INIT((x1|x2|x3|x4)&0xffffffff);
    __BV_END(v,32);
  __LOCAL0(blobb);
    __BLOB_BEGIN(blobb);
    __BLOB_INIT(buf+2,sz-2);
    __BLOB_END(blobb);
  __LOCAL0(ss);
    __RECORD_BEGIN_UPDATE(ss,s);
    __RECORD_UPDATE(___blob,blobb);
    __RECORD_END_UPDATE(ss);
  __LOCAL0(a);
    __RECORD_BEGIN(a,2);
    __RECORD_ADD(___1,v);
    __RECORD_ADD(___2,ss);
    __RECORD_END(a,2);
  return (a);
}

__obj __unconsume32 (__obj s) {
  __LOCAL(blob, __RECORD_SELECT(s,___blob));
  __char* buf = blob->blob.blob;
  __word sz = blob->blob.sz;
  __LOCAL0(blobb);
    __BLOB_BEGIN(blobb);
    __BLOB_INIT(buf-4,sz+4);
    __BLOB_END(blobb);
  __LOCAL0(ss);
    __RECORD_BEGIN_UPDATE(ss,s);
    __RECORD_UPDATE(___blob,blobb);
    __RECORD_END_UPDATE(ss);
  __LOCAL0(a);
    __RECORD_BEGIN(a,2);
    __RECORD_ADD(___1,__UNIT);
    __RECORD_ADD(___2,ss);
    __RECORD_END(a,2);
  return (a);
}

__obj __slice (__obj tok_, __obj offs_, __obj sz_) {
  __word tok = tok_->bv.vec;
  __int offs = offs_->z.value;
  __int sz = sz_->z.value;
  __word x = ((tok >> offs) & ((1 << sz)-1));
  __LOCAL0(slice);
    __BV_BEGIN(slice,sz);
    __BV_INIT(x);
    __BV_END(slice,sz);
  return (slice);
}

__obj __halt (__obj env, __obj o) {
  return (o);
}

__obj __runWithState (__obj (*f)(__obj,__obj), __obj s) {
  __LOCAL0(k);
    __LABEL_BEGIN(k);
    __LABEL_INIT(__halt);
    __LABEL_END(k);
  __LOCAL0(envK);
    __CLOSURE_BEGIN(envK,1)
    __CLOSURE_ADD(k);
    __CLOSURE_END(envK,1);
  return (__FCALL(f,envK,s));
}

__obj __eval (__obj (*f)(__obj,__obj), __char* blob, __word sz) {
  __LOCAL0(b);
    __BLOB_BEGIN(b);
    __BLOB_INIT(blob,sz);
    __BLOB_END(b);
  __LOCAL0(s);
    __RECORD_BEGIN(s,1);
    __RECORD_ADD(___blob,b);
    __RECORD_END(s,1);
  return (__runWithState(f,s));
}

__obj __evalPure (__obj (*f)(__obj,__obj), __obj x) {
  return (__runWithState(f,x));
}

__obj __pretty (__obj (*f)(__obj,__obj), __obj insn, char* buf, __word sz) {
  __obj str = __evalPure(f,insn);
  if (___isNil(str) || sz == 0) {
    return (str);
  } else {
    buf[0] = '\0';
    __flattenstring(str,buf,sz);
    return (str);
  }
}

/* Caller needs to reset the heap with `__resetHeap()` */
__word __decode (__obj (*f)(__obj,__obj), __char* blob, __word sz, __obj* insn) {
  __obj o = __eval(f,blob,sz);
  if (___isNil(o)) {
    *insn = o;
    return (0);
  } else {
    __obj i = __RECORD_SELECT(o,___1);
    __obj s = __RECORD_SELECT(o,___2);
    __obj blobb = __RECORD_SELECT(s,___blob);
    __word consumed = sz - blobb->blob.sz;
    *insn = i;
    return (consumed);
  }
}

__obj __cont (__obj env, __obj f) {
  __LOCAL(s,__CLOSURE_REF(env,1));
  __LOCAL0(k);
    __LABEL_BEGIN(k);
    __LABEL_INIT(__halt);
    __LABEL_END(k);
  __LOCAL0(envK);
    __CLOSURE_BEGIN(envK,1)
    __CLOSURE_ADD(k);
    __CLOSURE_END(envK,1);
  __LOCAL(ff,__CLOSURE_REF(f,0));
  return (__INVOKE3(ff,f,envK,s));
}

__obj __translate (__obj (*f)(__obj,__obj), __obj insn) {
  __LOCAL0(s);
    __RECORD_BEGIN(s,0);
    __RECORD_END(s,0);
  __LOCAL0(k);
    __LABEL_BEGIN(k);
    __LABEL_INIT(__cont);
    __LABEL_END(k);
  __LOCAL0(envK);
    __CLOSURE_BEGIN(envK,2)
    __CLOSURE_ADD(s);
    __CLOSURE_ADD(k);
    __CLOSURE_END(envK,2);
  __LOCAL(ss, __FCALL(f,envK,insn));
  return (__RECORD_SELECT(ss,___1));
}

const __char* __fieldName (__word i) {
  static __char* unknown = (__char*)"<unknown>";
  if (i < __NFIELDS)
     return ((const __char*)__fieldNames[i]);
  return (unknown);
}

const __char* __tagName (__word i) {
  static __char* unknown = (__char*)"<unknown>";
  if (i < __NTAGS)
     return ((const __char*)__tagNames[i]);
  return (unknown);
}

__obj __showbitvec (__obj o) {
  char fmt[16];
  snprintf(fmt,16,"0x%zx",o->bv.vec);
  __LOCAL0(R);
    __ROPE_BEGIN(R);
    __ROPE_FROMCSTRING(fmt);
    __ROPE_END(R);
  return (R);
}

__obj __showint (__obj o) {
  char fmt[64];
  snprintf(fmt,64,"%ld",o->z.value);
  __LOCAL0(R);
    __ROPE_BEGIN(R);
    __ROPE_FROMCSTRING(fmt);
    __ROPE_END(R);
  return (R);
}

__obj __print (__obj o) {
  switch (__TAG(o)) {
    case __CLOSURE:
      printf("{tag=__CLOSURE,sz=%zu,env=..}",o->closure.sz);
      break;
    case __INT:
      printf("{tag=__INT,value=%ld}", o->z.value);
      break;
    case __TAGGED: {
      __word tag = o->tagged.tag;
      if (tag < __NTAGS)
        printf("{tag=%s,",__tagName(tag));
      else
        printf("{tag=<unknown:%lu>,",tag);
      printf("payload=");
      __print(o->tagged.payload);
      printf("}");
      break;
    }
    case __RECORD: {
      printf("{tag=__RECORD,sz=%lu,", o->record.sz);
      int i;
      for (i=0;i<o->record.sz;i++) {
        __objref tagged = &o->record.fields[i];
        __word tag = tagged->tagged.tag;
        __obj payload = tagged->tagged.payload;
        if (tag < __NFIELDS)
          printf("%s=",__fieldName(tag));
        else
          printf("<unknown:%lu>=",tag);
        __print(payload);
        if (i < o->record.sz-1)
          printf(",");
      }
      printf("}");
      break;
    }
    case __ROPELEAF: {
      char buf[7+1];
      __word sz = o->ropeleaf.sz;
      __word len = sz > 7 ? 7 : sz;
      memcpy(buf,o->ropeleaf.blob,len);
      buf[len] = '\0';
      printf("{tag=__ROPELEAF,sz=%lu,blob=%s..}",sz,buf);
      break;
    }
    case __ROPEBRANCH: {
      printf("{tag=__ROPEBRANCH,left=");
      __print(o->ropebranch.left);
      printf(",right=");
      __print(o->ropebranch.right);
      printf("}");
      break;
    }
    case __LABEL:
      printf("{tag=__LABEL,f=%p}",o->label.f);
      break;
    case __BLOB:
      printf("{tag=__BLOB,sz=%lu,blob=%p}",o->blob.sz, o->blob.blob);
      break;
    case __BV:
      printf("{tag=__BV,sz=%lu,vec=%zx}", o->bv.sz, o->bv.vec);
      break;
    case __NIL:
      printf("{tag=__NIL}");
      break;
    default:
      printf("{tag=<unknown>,..}");
   }
   return (__UNIT);
}

__obj __println (__obj o) {
  __print(o);
  printf("\n");
  return (__UNIT);
}

__obj __traceln (__obj (*f)(__obj,__obj), const char* s, __obj o) {
  char fmt[4096];
  __pretty(f,o,fmt,4096);
  printf("[%s:%s]\n",s,fmt);
  return (__UNIT);
}

__obj __isNil (__obj o) {
  switch (__TAG(o)) {
    case __NIL: return (__TRUE);
    default: return (__FALSE);
  }
}

int ___isNil (__obj o) {
  switch (__TAG(o)) {
    case __NIL: return (1);
    default: return (0);
  }
}

__obj __printState () {
  ptrdiff_t d = &heap[__RT_HEAP_SIZE] - hp;
  int n = d / sizeof(__unwrapped_obj);
  int used = n*100/__RT_HEAP_SIZE;
  printf("heap: %p, hp: %p, size: %u, used: %d (%d%%), obj-size: %zu\n",
    &heap[0], hp, __RT_HEAP_SIZE, n, used, sizeof(__unwrapped_obj));
  return (__UNIT);
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

