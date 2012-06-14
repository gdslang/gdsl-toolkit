
#include "pretty.h"

static char* append (char* buf, __word sz, const char* str) {
  return (strncat(buf,str,sz));
}

static char* prettyMem (__obj mem, char* buf, __word sz) {
  __int psz = __RECORD_SELECT(mem,___sz)->z.value;
  __obj segment = __RECORD_SELECT(mem,___segment);
  __obj opnd = __RECORD_SELECT(mem,___opnd);
  switch (psz) {
    case 8:
      buf = append(buf,sz,"BYTE PTR ");
      break;
    case 16:
      buf = append(buf,sz,"WORD PTR ");
      break;
    case 32:
      buf = append(buf,sz,"DWORD PTR ");
      break;
    case 64:
      buf = append(buf,sz,"QWORD PTR ");
      break;
    case 128:
      buf = append(buf,sz,"XMMWORD PTR ");
      break;
    case 256:
      buf = append(buf,sz,"YMMWORD PTR ");
      break;
    default: {
      __word l = strlen(buf);
      snprintf(buf+l,sz-l,"PTR(%ld) ",psz);
      break;
    }
  }
  if (segment->tagged.tag == __DS) {
    buf = append(buf,sz,"[");
  } else {
    buf = prettyOpnd(segment,buf,sz);
    buf = append(buf,sz,":[");
  }
  buf = prettyOpnd(opnd,buf,sz);
  buf = append(buf,sz,"]");
  return (buf);
}

static char* prettySum (__obj sum, char* buf, __word sz) {
  __obj a = __RECORD_SELECT(sum,___a);
  __obj b = __RECORD_SELECT(sum,___b);
  buf = prettyOpnd(a,buf,sz);
  buf = append(buf,sz,"+");
  buf = prettyOpnd(b,buf,sz);
  return (buf);
}

static char* prettyFac (__obj imm, char* buf, __word sz) {
  switch (__CASETAG(imm)) {
    case 0: buf = append(buf,sz,"1*");break;
    case 1: buf = append(buf,sz,"2*");break;
    case 2: buf = append(buf,sz,"4*");break;
    case 3: buf = append(buf,sz,"8*");break;
    default: __fatal("Invalid scaling factor");
  }
  return (buf);
}

static char* prettyScale (__obj scale, char* buf, __word sz) {
  __obj imm = __RECORD_SELECT(scale,___imm);
  __obj op = __RECORD_SELECT(scale,___opnd);
  buf = prettyFac(imm,buf,sz);
  buf = prettyOpnd(op,buf,sz);
  return (buf);
}

char* prettyOpnd (__obj opnd, char* buf, __word sz) {
  char* s = buf;
  switch (__TAG(opnd)) {
    case __TAGGED: {
      __word tag = opnd->tagged.tag;
      __obj payload = opnd->tagged.payload;
      switch (tag) {
        case __MEM:
          s = prettyMem(payload,buf,sz);
          break;
        case __REG:
          s = prettyOpnd(payload,buf,sz);
          break;
        case __SUM:
          s = prettySum(payload,buf,sz);
          break;
        case __SCALE:
          s = prettyScale(payload,buf,sz);
          break;
        case __NEARABS:
          //s = append(buf,sz,"NEAR ");
          s = prettyOpnd(payload,buf,sz);
          break;
        case __FARABS: 
          //s = append(buf,sz,"FAR ");
          s = prettyOpnd(payload,buf,sz);
          break;
        case __REL8:
        case __REL16:
        case __REL32:
        case __REL64:
          //s = append(buf,sz,"RELATIVE ");
          s = prettyOpnd(payload,buf,sz);
          break;
        case __IMM8:
        case __IMM16:
        case __IMM32:
        case __IMM64:
          s = prettyOpnd(payload,buf,sz);
          break;
        default: {
          s = append(buf,sz,(const char*)__tagName(tag));
          if (!___isNil(payload))
            s = prettyOpnd(payload,buf,sz);
          break;
        }
      }
      break;
    }
    case __BV: {
      __word l = strlen(buf);
      snprintf(buf+l,sz-l,"0x%zx",opnd->bv.vec);
      s = buf;
      break;
    }
    case __INT: {
      __word l = strlen(buf);
      snprintf(buf+l,sz-l,"%ld",opnd->z.value);
      s = buf;
      break;
    }
    default:
       __fatal("Invalid operand");
  }
  return (s);
}

static char* prettyOpnds (__obj opnds, char* buf, __word sz) {
  switch (__TAG(opnds)) {
    case __RECORD: {
      switch (opnds->record.sz) {
        case 1: {
          __obj op1 = __RECORD_SELECT(opnds,___opnd1);
          return (prettyOpnd(op1,buf,sz));
        }
        case 2: {
          __obj op1 = __RECORD_SELECT(opnds,___opnd1);
          __obj op2 = __RECORD_SELECT(opnds,___opnd2);
          buf = prettyOpnd(op1,buf,sz);
          buf = append(buf,sz,",");
          buf = prettyOpnd(op2,buf,sz);
          return (buf);
        }
        case 3: {
          __obj op1 = __RECORD_SELECT(opnds,___opnd1);
          __obj op2 = __RECORD_SELECT(opnds,___opnd2);
          __obj op3 = __RECORD_SELECT(opnds,___opnd3);
          buf = prettyOpnd(op1,buf,sz);
          buf = append(buf,sz,",");
          buf = prettyOpnd(op2,buf,sz);
          buf = append(buf,sz,",");
          buf = prettyOpnd(op3,buf,sz);
          return (buf);
        }
        case 4: {
          __obj op1 = __RECORD_SELECT(opnds,___opnd1);
          __obj op2 = __RECORD_SELECT(opnds,___opnd2);
          __obj op3 = __RECORD_SELECT(opnds,___opnd3);
          __obj op4 = __RECORD_SELECT(opnds,___opnd4);
          buf = prettyOpnd(op1,buf,sz);
          buf = append(buf,sz,",");
          buf = prettyOpnd(op2,buf,sz);
          buf = append(buf,sz,",");
          buf = prettyOpnd(op3,buf,sz);
          buf = append(buf,sz,",");
          buf = prettyOpnd(op4,buf,sz);
          return (buf);
        }
        default:
          __fatal("Invalid number of operands");
      }
    }
    case __TAGGED: {
      __word tag = opnds->tagged.tag;
      __obj payload = opnds->tagged.payload;
      switch (tag) {
        case __VA0: return (buf);
        case __VA1:
        case __VA2:
        case __VA3:
        case __VA4: return (prettyOpnds(payload,buf,sz));
        default: __fatal("Variable-arity payload expected");
      }
    }
    default:
       __fatal("Wrong operand type");
  }
}

char* prettyMnemonic (__obj insn, char* buf, __word sz) {
  switch (__TAG(insn)) {
    case __TAGGED: {
      append(buf,sz,(char*)__tagName(__CASETAG(insn)));
      break;
    }
    default:
      __fatal("Invalid instruction object");
  }
  return (buf);
}

char* pretty (__obj insn, char* buf, __word sz) {
  buf[0] = '\0';
  switch (__TAG(insn)) {
    case __TAGGED: {
      __obj payload = insn->tagged.payload;
      __word tag = __CASETAG(insn);
      if (___isNil(payload)) {
            return (append(buf,sz,(char*)__tagName(tag)));
      } else {
          append(buf,sz,(char*)__tagName(tag));
          append(buf,sz," ");
          prettyOpnds(payload,buf,sz);
          return (buf);
      }
    }
    default:
      __fatal("Invalid instruction object");
  }
}

char* prettyln (__obj insn, char* buf, __word sz) {
  pretty(insn,buf,sz);
  append(buf,sz,"\n");
  return (buf);
}

/* vim:cindent
 * vim:ts=2
 * vim:sw=2
 * vim:expandtab */
