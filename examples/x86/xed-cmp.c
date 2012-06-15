
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

struct insn {
  #define MAXFIELDS 7
  #define MAXSTRINGLENGTH 128
  __word nfields;
  char fields[MAXFIELDS][MAXSTRINGLENGTH];
};

__word getNumberOfOperands(__obj di) {
  __obj payload = di->tagged.payload;
  int n;
  if (___isNil(payload)) {
      n = 0;
  } else if (__TAG(payload) == __TAGGED) {
    switch (__CASETAG(payload)) {
      case __VA0: n = 0;break;
      case __VA1: n = 1;break;
      case __VA2: n = 2;break;
      case __VA3: n = 3;break;
      case __VA4: n = 4;break;
      default: __fatal("getNumberOfOperands: invalid instruction object");
    }
  } else {
    n = payload->record.sz;
  }
  return (n);
}

void fmtOperand(__obj di, __word field, char* buf, __word sz) {
  __obj payload = di->tagged.payload;
  buf[0] = '\0'; 
  switch (__TAG(payload)) {
    case __TAGGED:
      prettyOpnd(__RECORD_SELECT(payload->tagged.payload,field),buf,sz);
      break;
    case __RECORD:
      prettyOpnd(__RECORD_SELECT(payload,field),buf,sz);
      break;
    default:
      __fatal("fmtOperand: Invalid instruction object");
  }
}

void fmtMnemonic(__obj di, char* buf, __word sz) {
  buf[0] = '\0'; 
  prettyMnemonic(di,buf,sz);
}

void explode (__obj di, struct insn* i) {
  int n = getNumberOfOperands(di);
  i->nfields = n+1;
  fmtMnemonic(di,i->fields[0],MAXSTRINGLENGTH);
  switch (n) {
    case 4: fmtOperand(di,___opnd4,i->fields[4],MAXSTRINGLENGTH);
    case 3: fmtOperand(di,___opnd3,i->fields[3],MAXSTRINGLENGTH);
    case 2: fmtOperand(di,___opnd2,i->fields[2],MAXSTRINGLENGTH);
    case 1: fmtOperand(di,___opnd1,i->fields[1],MAXSTRINGLENGTH);
    case 0: break;
    default: {
      char s[128];
      pretty(di,s,128);
      __fatal("explode: Invalid number of operands: %d: %s",n,s);
    }
  }
}

void explodeXed (xed_decoded_inst_t* xi, struct insn* i) {
  char str[128];
  char* tok;
  char* p = str;
  xed_decoded_inst_dump_intel_format(xi,str,128,0);
  tok = strsep(&p," ");
  strncpy(i->fields[0],tok,MAXSTRINGLENGTH);
  int t = 0;
  while (1) {
    tok = strsep(&p,",");
    if (tok[0] != '\0') {
      for (; *tok == ' '; tok++);
      strncpy(i->fields[t+1],tok,MAXSTRINGLENGTH);
      t++;
    }
    if (p == NULL) break;
  }
  i->nfields = t+1;
}

int compare (struct insn* a, struct insn* b) {
  if (a->nfields != b->nfields) return (0);
  int i;
  for (i = 0; i < a->nfields; i++) {
    if (strcasecmp(a->fields[i],b->fields[i]) != 0)
      return (0);
  }
  return (1);
}

int match (xed_decoded_inst_t* xi, __obj di) {
  struct insn xii;
  struct insn dii;
  explode(di,&dii);
  explodeXed(xi,&xii);
  return (compare(&xii,&dii));
}

int main (int argc, char** argv) {
  if (argc < 2)
    __fatal("args");
  const char* fn=argv[1];
  printf("file: %s\n",fn);

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
  char insnstr[128];
  char decodedinsnstr[128];
  char opcodestr[128];
  unsigned int len;
  unsigned char* blobb = blob;
  unsigned int invalid = 0;
  unsigned int n = 0;
  xed_error_enum_t r;
  __obj decoded;
  do {
    xed_decoded_inst_zero_set_mode(insn,&state);
    xed_decoded_inst_set_input_chip(insn,XED_CHIP_INVALID);
    r = xed_decode(insn,blobb,sz);
    if (r == XED_ERROR_NONE) {
      len = xed_decoded_inst_get_length(insn);
      xed_decoded_inst_dump_intel_format(insn,insnstr,128,0);
      hexlify(blobb,len,opcodestr);
      __word decodedlen = __decode(__decode__,blobb,sz,&decoded);
      if (match(insn,decoded) && len == decodedlen) {
        printf("%-30s: %-42s: ok\n",opcodestr,insnstr);
      } else {
        printf("%-30s: %-42s: failed\n",opcodestr,"");
        printf("  should be: %s\n",insnstr);
        if (___isNil(decoded)) {
          printf("  is:        decode error\n");
        } else {
          pretty(decoded,decodedinsnstr,128);
          printf("  is:        %s\n",decodedinsnstr);
        }
      }
    } else {
      invalid++;
      len = 1;
    }
    __resetHeap();
    blobb += len;
    sz -= len;
    n++;
  } while(len > 0 && sz > 0);

  return (1);
}

/* vim:cindent
 * vim:ts=2
 * vim:sw=2
 * vim:expandtab */
