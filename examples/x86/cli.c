
#include <dis.h>
#include <pretty.h>

int main (int argc, char** argv) {
  __char blob[15];
  char fmt[128];
  __word sz = 15;
  __obj insn,semantics;
  int i,c;
  for (i=0;i<sz;i++) {
     int x = fscanf(stdin,"%x",&c);
     switch (x) {
        case EOF:
           break;
        case 0:
           __fatal("invalid input; should be in hex form: '0f 0b ..'");
     }
     blob[i] = c & 0xff;
  }
  __decode(__decode__,blob,i,&insn);
  if (___isNil(insn))
    __fatal("decode failed");
  else {
    prettyln(insn,fmt,128);
    puts(fmt);
    semantics = __translate(__translate__,insn);
    __println(semantics);
  }
  return (1);
}

/* vim:cindent
 * vim:ts=2
 * vim:sw=2
 * vim:expandtab */
