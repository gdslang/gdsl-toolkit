
#include <stdlib.h>
#include <bfd.h>
#include <udis86.h>

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

  ud_t udisObj;
  ud_t* udis = &udisObj;
  ud_init(udis);
  ud_set_mode(udis,64);
  ud_set_syntax(udis,UD_SYN_INTEL);
  ud_set_input_buffer(udis,blob,sz);
  /*ud_set_pc(udis,pc)*/

  unsigned int len;
  unsigned char* blobb = blob;
  unsigned int invalid = 0;
  unsigned int n = 0;
  do {
    len = ud_disassemble(udis);
    if (udis->mnemonic==UD_Iinvalid)
       invalid++;
    //printf("%-27s\n",ud_insn_asm(udis));
    blobb += len;
    sz-=len;
    n++;
  } while(len > 0 && sz > 0);
  fprintf(stderr,"decoded %u opcode sequences (%u invalid/unknown)\n", n, invalid);
  return (0);
}
