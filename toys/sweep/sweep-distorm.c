
#include <stdlib.h>
#include <stdio.h>
#include <bfd.h>
#include <distorm.h>

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

  _DecodeResult r;
  _DecodedInst insn;
  _OffsetType offset = 0;

  unsigned int len;
  unsigned char* blobb = blob;
  unsigned int invalid = 0;
  unsigned int n = 0;
  do {
    r = distorm_decode(offset, blobb, sz, Decode64Bits, &insn, 1, &len);
    if (len==1) {
       len = insn.size;
    } else {
       invalid++;
       len = 1;
    }
    printf("%s%s%s\n", (char*)insn.mnemonic.p, insn.operands.length != 0 ? " " : "", insn.operands.p);
    blobb += len;
    sz-=len;
    offset += len;
    n++;
  } while(len > 0 && sz > 0);
  fprintf(stderr,"decoded %u opcode sequences (%u invalid/unknown)\n", n, invalid);
  return (0);
}
