
#include <bfd.h>
#include <xed-interface.h>
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
  char opcodestr[128];
  unsigned int len;
  unsigned char* blobb = blob;
  unsigned int invalid = 0;
  unsigned int n = 0;
  xed_error_enum_t r;
  __obj decoded;
  do {
    xed_decoded_inst_zero_set_mode(insn, &state);
    xed_decoded_inst_set_input_chip(insn, XED_CHIP_INVALID);
    r = xed_decode(insn, blobb, sz);
    if (r==XED_ERROR_NONE) {
      len = xed_decoded_inst_get_length(insn);
      xed_decoded_inst_dump_intel_format(insn,insnstr,128,0);
      hexlify(blobb,len,opcodestr);
      printf("%-30s %-33s: ",opcodestr,insnstr); fflush(stdout);
      __decode(__decode__,blobb,sz,&decoded);
      if(___isNil(decoded))
         printf("\n");
      else
         prettyln(decoded);
      __resetHeap();
    } else {
      invalid++;
      len = 1;
    }
    blobb += len;
    sz-=len;
    n++;
  } while(len > 0 && sz > 0);

  return (1);
}

/* vim:cindent
 * vim:ts=2
 * vim:sw=2
 * vim:expandtab */
