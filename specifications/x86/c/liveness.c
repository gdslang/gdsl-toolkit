
/* vim:ts=2:sw=2:expandtab */

#include <dis.h>

void sweep (__char* blob, __word sz) {
  char fmt[4096];
  __obj state = __eval(__lv_sweep_and_collect_upto_native_flow__,blob,sz);
  __obj stmts = __RECORD_SELECT(state,___1);
  __pretty(__rreil_pretty_rev__,stmts,fmt,4096);
  puts(fmt);
}

void liveness (__char* blob, __word sz) {
  char fmtlive[4096];
  char fmtmaybelive[4096];
  __obj result = __eval(__lv_analyze__,blob,sz);
  __obj state = __RECORD_SELECT(result,___2);
  __obj live = __RECORD_SELECT(state,___live);
  __obj maybelive = __RECORD_SELECT(state,___maybelive);
  __pretty(__rreil_pretty__,live,fmtlive,4096);
  __pretty(__rreil_pretty__,maybelive,fmtmaybelive,4096);
  puts("live:"); puts(fmtlive);
  puts("maybelive:"); puts(fmtmaybelive);
}

int main (int argc, char** argv) {
  __char blob[1024];
  __word sz = 1024;
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
  sweep(blob,i);
  liveness(blob,i);
  return (1);
}

