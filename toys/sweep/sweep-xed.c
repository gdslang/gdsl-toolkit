
#include <stdlib.h>
#include <stdio.h>
#include <bfd.h>
#include <xed-interface.h>

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

  xed_state_t state;
  xed_decoded_inst_t insnObj;
  xed_decoded_inst_t* insn = &insnObj;
  xed_tables_init();
  xed_state_zero(&state);
  state.mmode = XED_MACHINE_MODE_LONG_64;
  state.stack_addr_width = XED_ADDRESS_WIDTH_32b;
  xed_decoded_inst_zero_set_mode(insn, &state);
  xed_decoded_inst_set_input_chip(insn, XED_CHIP_INVALID);
  char insnstr[128];
  unsigned int len;
  unsigned char* blobb = blob;
  unsigned int invalid = 0;
  unsigned int n = 0;
  xed_error_enum_t r;
  do {
    xed_decoded_inst_zero_set_mode(insn, &state);
    xed_decoded_inst_set_input_chip(insn, XED_CHIP_INVALID);
    r = xed_decode(insn, blobb, sz);
    if (r==XED_ERROR_NONE) {
       len = xed_decoded_inst_get_length(insn);
       xed_decoded_inst_dump_intel_format(insn,insnstr,128,0);
       printf("%-27s\n",insnstr);
    } else {
       invalid++;
       len = 1;
    }
    blobb += len;
    sz-=len;
    n++;
  } while(len > 0 && sz > 0);
  fprintf(stderr,"decoded %u opcode sequences (%u invalid/unknown)\n", n, invalid);
  return (0);
}
