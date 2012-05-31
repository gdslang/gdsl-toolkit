
#include <stdlib.h>
#include <bfd.h>
#include <dis-asm.h>

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

  struct disassemble_info diObj;
  struct disassemble_info* di = &diObj;
  disassembler_ftype dis = disassembler(bfd);
  if (dis == NULL) exit(1);
  init_disassemble_info(di, stdout, (fprintf_ftype)fprintf);
  //di->print_address_func = override_print_address;
  di->arch = bfd_get_arch(bfd);
  di->mach = bfd_get_mach(bfd);
  di->buffer_vma = s->vma;
  di->buffer_length = s->size;
  di->buffer = blob; 

  unsigned int len;
  unsigned char* blobb = blob;
  unsigned int invalid = 0;
  unsigned int n = 0;
  unsigned int pc = s->vma;
  do {
    len = dis(pc,di);
    printf("\n");
    //if (udis->mnemonic==UD_Iinvalid)
    //   invalid++;
    blobb += len;
    sz-=len;
    n++;
    pc+=len;
  } while(len > 0 && sz > 0);
  fprintf(stderr,"decoded %u opcode sequences (%u invalid/unknown)\n", n, invalid);
  return (0);
}
