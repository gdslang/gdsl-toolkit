
#include <bfd.h>
#include <dis.h>
#include <pretty.h>

void hexlify (unsigned char* in, size_t len, char* out) {
  int i;
  for (i=0;i<len;i++) {
    sprintf(out,"%02x",in[i]&0xff);
    out+=2;
  }
}

int main (int argc, char** argv) {
  if (argc < 2)
    exit(1);
  const char* fn=argv[1];
  fprintf(stderr,"file is %s\n",fn);

  bfd_init();
  bfd* bfd = bfd_openr(fn, NULL);
  if (bfd==NULL)
    exit(1);
  if (!bfd_check_format(bfd,bfd_object))
    exit(1);
  asection* s = bfd_get_section_by_name(bfd,".text");
  if (s==NULL)
    exit(1);
  unsigned char* blob;
  bfd_size_type sz = s->size;

  fprintf(stderr,".text is %zu bytes\n",sz);

  if(!bfd_malloc_and_get_section(bfd,s,&blob))
    exit(1);

  __word len;
  unsigned char* blobb = blob;
  unsigned int invalid = 0;
  unsigned int n = 0;
  __obj insn;
  do {
    len = __decode(__decode__,blobb,sz,&insn);
    if (___isNil(insn)) {
      invalid++;
      len = 1;
    } else {
      //prettyln(insn);
      __resetHeap();
    }
    blobb += len;
    sz -= len;
    n++;
  } while(len > 0 && sz > 0);
  fprintf(stderr,"decoded %u opcode sequences (%u invalid/unknown)\n", n, invalid);
  return (0);
}

/* vim:cindent
 * vim:ts=2
 * vim:sw=2
 * vim:expandtab */
