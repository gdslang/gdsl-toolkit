
#include "dis.h"

int main (int argc, char** argv) {
  __char blob[15];
  __word sz = 15;
  int i,c;
  for (i=0;i<sz;i++) {
     int x = fscanf(stdin,"%x",&c);
     switch (x) {
        case EOF:
           break;
        case 0:
           __fatal("invalid input, should be in hex form '0f 0b ..'");
     }
     blob[i] = c & 0xff;
  }
  decode(blob,i);
  return (1);
}
