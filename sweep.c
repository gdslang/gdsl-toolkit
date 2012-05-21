
#include <bfd.h>
#include <udis86.h>
#include "dis.h"

int main (int argc, char** argv) {
  if (argc < 2)
    __fatal("args");

  const char* fn=argv[1];

  printf("fn: %s\n",fn);
  bfd_init();

  const char **targets = bfd_target_list();
  int i;
  for (i=0;targets[i]!=NULL;i++) {
    printf("target: %s\n", targets[i]);
  }

  bfd* bfd = bfd_openr(fn, NULL);
  if (bfd==NULL)
    __fatal("bfd_openr");

  if (!bfd_check_format(bfd,bfd_object))
    __fatal("bfd_check_format");

  asection* s = bfd_get_section_by_name(bfd, ".text");
  if (s==NULL)
    __fatal("bfd_get_section_by_name");

  __char* blob;
  bfd_size_type sz = s->size;
  printf(".text is %zu bytes\n",sz);

  if(!bfd_malloc_and_get_section(bfd,s,&blob))
    __fatal("bfd_malloc_and_get_section");

  ud_t udisObj;
  ud_t* udis = &udisObj;
  ud_init(udis);
  ud_set_mode(udis,64);
  ud_set_syntax(udis,UD_SYN_INTEL);
  ud_set_input_buffer(udis,blob,sz);
  /*ud_set_pc(udis,pc)*/

  unsigned int len;
  __char* blobb = blob;
  do {
    len = ud_disassemble(udis);
    char* hex1;
    hex1 = ud_insn_hex(udis);
    printf("%-30s %-27s",hex1,ud_insn_asm(udis));
    printf(": ");
    fflush(stdout);
    decode(blobb,sz);
    blobb += len;
    sz-=len;
  } while(len > 0 && sz > 0);

  return (1);
}
