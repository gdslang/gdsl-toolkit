
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <bfd.h>
#include <beaengine/BeaEngine.h>

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

  DISASM disObj;
  DISASM* dis = &disObj;
  memset(dis,0,sizeof(DISASM));

  unsigned int len;
  unsigned char* blobb = blob;
  unsigned int invalid = 0;
  unsigned int n = 0;
  dis->Archi = 64;
  do {
    dis->EIP = (UIntPtr)blobb;
    dis->SecurityBlock = sz; 
    len = Disasm(dis);
    if (len==OUT_OF_BLOCK) {
      fprintf(stderr,"out-of-block-error");
      exit(1);
    } else if (len==UNKNOWN_OPCODE) {
      invalid++;
      len = 1;
    } //else {
      //puts(dis->CompleteInstr);
    //}
    blobb += len;
    sz-=len;
    n++;
  } while(len > 0 && sz > 0);
  fprintf(stderr,"decoded %u opcode sequences (%u invalid/unknown)\n", n, invalid);
  return (0);
}
