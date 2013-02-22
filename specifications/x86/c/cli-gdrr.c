
/* vim:cindent:ts=2:sw=2:expandtab */

#include <stdio.h>
#include <stdlib.h>
#include <dis.h>
#include <gdrr.h>

int main (int argc, char** argv) {
  __char blob[15];
  char fmt[1024];
  __word sz = 15;
  __obj insn;
  int i,c;
  for (i=0;i<sz;i++) {
     int x = fscanf(stdin,"%x",&c);
     switch (x) {
        case EOF:
           goto done;
        case 0:
           __fatal("invalid input; should be in hex form: '0f 0b ..'");
     }
     blob[i] = c & 0xff;
  }
done:
  __decode(__decode__,blob,i,&insn);
  if (___isNil(insn))
    __fatal("decode failed");
  else {
    __pretty(__pretty__,insn,fmt,1024);
    puts(fmt);

    printf("---------------------------\n");
   
    __obj r = __translate(__translate__,insn);
    if(___isNil(r))
      __fatal("translate failed");
    else {
      __pretty(__rreil_pretty__,r,fmt,1024);
      puts(fmt);
      
      test(r);
    }
  }

  
  return (1);
}

