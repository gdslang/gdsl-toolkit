
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
  __word tag = __CASETAG(b);
  if (!(tag == __IMM8 || tag == __IMM16 || tag == __IMM32 || tag == __IMM64))
    buf = append(buf,sz,"+");
  buf = prettyOpnd(b,buf,sz);
  return (buf);
}

static char* prettyFac (__obj imm, char* buf, __word sz) {
  switch (__CASETAG(imm)) {
    case 0: buf = append(buf,sz,"*1");break;
    case 1: buf = append(buf,sz,"*2");break;
    case 2: buf = append(buf,sz,"*4");break;
    case 3: buf = append(buf,sz,"*8");break;
    default: __fatal("Invalid scaling factor");
  }
  return (buf);
}

static char* prettyScale (__obj scale, char* buf, __word sz) {
  __obj imm = __RECORD_SELECT(scale,___imm);
  __obj op = __RECORD_SELECT(scale,___opnd);
  buf = prettyOpnd(op,buf,sz);
  buf = prettyFac(imm,buf,sz);
  return (buf);
}

char* prettyImm(__obj imm, __word immSz, char* buf, __word sz) {
  //if (index(buf,'[') == NULL) //FIXME: Need to count `[` and `]`
  //  return (prettyOpnd(imm,buf,sz));
  __word l = strlen(buf);
  __int x;
  switch (immSz) {
    case 8:
      x = ((int8_t)imm->bv.vec);
      break;  
    case 16:
      x = ((int16_t)imm->bv.vec);
      break;  
    case 32:
      x = ((int32_t)imm->bv.vec);
      break;  
    case 64:
      x = ((int64_t)imm->bv.vec);
      break;  
    default:
      __fatal("Invalid immidate size");
  }
  if (x < 0)
    snprintf(buf+l,sz-l,"-0x%zx",-x);
  else
    snprintf(buf+l,sz-l,"+0x%zx",x);
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
          s = prettyImm(payload,payload->bv.sz,buf,sz);
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
        default: __fatal("Not a variable-arity payload");
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

char* prettySemArity1 (__obj x, char* buf, __word sz) {
  return (buf);
}

char* prettySemArity2 (__obj x, char* buf, __word sz) {
  return (buf);
}

char* prettySemInt (__obj i, char* buf, __word sz) {
  int l = strlen(buf);
  snprintf(buf+l,sz-l,"%ld",i->z.value);
  return (buf);  
}

char* prettySemId (__obj x, char* buf, __word sz) {
  __obj payload = x->tagged.payload;
  __word tag = x->tagged.tag;
  switch (tag) {
    case __VIRT_T: {
      strncat(buf,"t",sz);
      prettySemInt(payload,buf,sz);
      break;
    }
    default:
      strncat(buf,(const char*)__tagName(tag),sz);
  }
  return (buf);
}

char* prettySemVar (__obj x, char* buf, __word sz) {
  __obj id = __RECORD_SELECT(x,___id);
  __obj offs = __RECORD_SELECT(x,___offset);
  prettySemId(id,buf,sz);
  if (offs->z.value != 0) {
    strncat(buf,"/",sz); 
    prettySemInt(offs,buf,sz);
  }
  return (buf);
}

char* prettySemLin (__obj lin, char* buf, __word sz) {
  __obj payload = lin->tagged.payload;
  __word tag = lin->tagged.tag;
  switch (tag) {
    case __SEM_LIN_VAR: {
      prettySemVar(payload,buf,sz);
      break;
    }
    case __SEM_LIN_IMM: {
      __obj imm = __RECORD_SELECT(payload,___imm);
      prettySemInt(imm,buf,sz);
      break;
    }
    case __SEM_LIN_ADD: {
      __obj op1 = __RECORD_SELECT(payload,___opnd1);
      __obj op2 = __RECORD_SELECT(payload,___opnd2);
      prettySemLin(op1,buf,sz);
      strncat(buf,"+",sz);
      prettySemLin(op2,buf,sz);
      break;
    }
    case __SEM_LIN_SUB: {
      __obj op1 = __RECORD_SELECT(payload,___opnd1);
      __obj op2 = __RECORD_SELECT(payload,___opnd2);
      prettySemLin(op1,buf,sz);
      strncat(buf,"-",sz);
      prettySemLin(op2,buf,sz);
      break;
    }
    case __SEM_LIN_SCALE: {
      __obj imm = __RECORD_SELECT(payload,___imm);
      __obj op = __RECORD_SELECT(payload,___opnd1);
      prettySemInt(imm,buf,sz);
      strncat(buf,"*(",sz);
      prettySemLin(op,buf,sz);
      strncat(buf,")",sz);
      break;
    }
    default:
      __fatal("Object not of {sem_linear} type");
  }
  return (buf);
}

char* prettySemOp (__obj x, char* buf, __word sz) {
  __obj payload = x->tagged.payload;
  __word tag = x->tagged.tag;
  __obj size = __RECORD_SELECT(payload,___size);
  switch (tag) {
    case __SEM_LIN: {
      prettySemInt(size,buf,sz);
      strncat(buf,":",sz);
      // strncat(buf,"(",sz);
      prettySemLin(__RECORD_SELECT(payload,___opnd1),buf,sz);
      // strncat(buf,")",sz);
      break;
    }
    case __SEM_MUL: {
      prettySemInt(size,buf,sz);
      strncat(buf,":mul",sz);
      strncat(buf,"(",sz);
      prettySemLin(__RECORD_SELECT(payload,___opnd1),buf,sz);
      strncat(buf,",",sz);
      prettySemLin(__RECORD_SELECT(payload,___opnd2),buf,sz);
      strncat(buf,")",sz);
      break;
    }
    case __SEM_DIV: {
      prettySemInt(size,buf,sz);
      strncat(buf,":div",sz);
      strncat(buf,"(",sz);
      prettySemLin(__RECORD_SELECT(payload,___opnd1),buf,sz);
      strncat(buf,",",sz);
      prettySemLin(__RECORD_SELECT(payload,___opnd2),buf,sz);
      strncat(buf,")",sz);
      break;
    }
    case __SEM_DIVS: {
      prettySemInt(size,buf,sz);
      strncat(buf,":divs",sz);
      strncat(buf,"(",sz);
      prettySemLin(__RECORD_SELECT(payload,___opnd1),buf,sz);
      strncat(buf,",",sz);
      prettySemLin(__RECORD_SELECT(payload,___opnd2),buf,sz);
      strncat(buf,")",sz);
      break;
    }
    case __SEM_MOD: {
      prettySemInt(size,buf,sz);
      strncat(buf,":mod",sz);
      strncat(buf,"(",sz);
      prettySemLin(__RECORD_SELECT(payload,___opnd1),buf,sz);
      strncat(buf,",",sz);
      prettySemLin(__RECORD_SELECT(payload,___opnd2),buf,sz);
      strncat(buf,")",sz);
      break;
    }
    case __SEM_SHL: {
      prettySemInt(size,buf,sz);
      strncat(buf,":shl",sz);
      strncat(buf,"(",sz);
      prettySemLin(__RECORD_SELECT(payload,___opnd1),buf,sz);
      strncat(buf,",",sz);
      prettySemLin(__RECORD_SELECT(payload,___opnd2),buf,sz);
      strncat(buf,")",sz);
      break;
    }
    case __SEM_SHR: {
      prettySemInt(size,buf,sz);
      strncat(buf,":shr",sz);
      strncat(buf,"(",sz);
      prettySemLin(__RECORD_SELECT(payload,___opnd1),buf,sz);
      strncat(buf,",",sz);
      prettySemLin(__RECORD_SELECT(payload,___opnd2),buf,sz);
      strncat(buf,")",sz);
      break;
    }
    case __SEM_SHRS: {
      prettySemInt(size,buf,sz);
      strncat(buf,":shrs",sz);
      strncat(buf,"(",sz);
      prettySemLin(__RECORD_SELECT(payload,___opnd1),buf,sz);
      strncat(buf,",",sz);
      prettySemLin(__RECORD_SELECT(payload,___opnd2),buf,sz);
      strncat(buf,")",sz);
      break;
    }
    case __SEM_AND: {
      prettySemInt(size,buf,sz);
      strncat(buf,":and",sz);
      strncat(buf,"(",sz);
      prettySemLin(__RECORD_SELECT(payload,___opnd1),buf,sz);
      strncat(buf,",",sz);
      prettySemLin(__RECORD_SELECT(payload,___opnd2),buf,sz);
      strncat(buf,")",sz);
      break;
    }
    case __SEM_OR: {
      prettySemInt(size,buf,sz);
      strncat(buf,":or",sz);
      strncat(buf,"(",sz);
      prettySemLin(__RECORD_SELECT(payload,___opnd1),buf,sz);
      strncat(buf,",",sz);
      prettySemLin(__RECORD_SELECT(payload,___opnd2),buf,sz);
      strncat(buf,")",sz);
      break;
    }
    case __SEM_XOR: {
      prettySemInt(size,buf,sz);
      strncat(buf,":xor",sz);
      strncat(buf,"(",sz);
      prettySemLin(__RECORD_SELECT(payload,___opnd1),buf,sz);
      strncat(buf,",",sz);
      prettySemLin(__RECORD_SELECT(payload,___opnd2),buf,sz);
      strncat(buf,")",sz);
      break;
    }
    case __SEM_SX: {
      __obj fromsize = __RECORD_SELECT(payload,___fromsize);
      prettySemInt(size,buf,sz);
      strncat(buf,":",sz);
      strncat(buf,"sign-extend",sz);
      prettySemInt(fromsize,buf,sz);
      strncat(buf,"(",sz);
      prettySemLin(__RECORD_SELECT(payload,___opnd1),buf,sz);
      strncat(buf,")",sz);
      break;
    }
    case __SEM_ZX: {
      __obj fromsize = __RECORD_SELECT(payload,___fromsize);
      prettySemInt(size,buf,sz);
      strncat(buf,":",sz);
      strncat(buf,"zero-extend",sz);
      prettySemInt(fromsize,buf,sz);
      strncat(buf,"(",sz);
      prettySemLin(__RECORD_SELECT(payload,___opnd1),buf,sz);
      strncat(buf,")",sz);
      break;
    }
    case __SEM_ARB: {
      prettySemInt(size,buf,sz);
      strncat(buf,":arbitrary",sz); 
      break;
    }
    case __SEM_CMPEQ: {
      strncat(buf,"1:",sz);
      strncat(buf,"==",sz);
      prettySemInt(size,buf,sz);
      strncat(buf,"(",sz);
      prettySemLin(__RECORD_SELECT(payload,___opnd1),buf,sz);
      strncat(buf,",",sz);
      prettySemLin(__RECORD_SELECT(payload,___opnd2),buf,sz);
      strncat(buf,")",sz);
      break;
    }
    case __SEM_CMPNEQ: {
      strncat(buf,"1:",sz);
      strncat(buf,"/=",sz);
      prettySemInt(size,buf,sz);
      strncat(buf,"(",sz);
      prettySemLin(__RECORD_SELECT(payload,___opnd1),buf,sz);
      strncat(buf,",",sz);
      prettySemLin(__RECORD_SELECT(payload,___opnd2),buf,sz);
      strncat(buf,")",sz);
      break;
    }
    case __SEM_CMPLES: {
      strncat(buf,"1:",sz);
      strncat(buf,"<=s",sz);
      prettySemInt(size,buf,sz);
      strncat(buf,"(",sz);
      prettySemLin(__RECORD_SELECT(payload,___opnd1),buf,sz);
      strncat(buf,",",sz);
      prettySemLin(__RECORD_SELECT(payload,___opnd2),buf,sz);
      strncat(buf,")",sz);
      break;
    }
    case __SEM_CMPLEU: {
      strncat(buf,"1:",sz);
      strncat(buf,"<=u",sz);
      prettySemInt(size,buf,sz);
      strncat(buf,"(",sz);
      prettySemLin(__RECORD_SELECT(payload,___opnd1),buf,sz);
      strncat(buf,",",sz);
      prettySemLin(__RECORD_SELECT(payload,___opnd2),buf,sz);
      strncat(buf,")",sz);
      break;
    }
    case __SEM_CMPLTS: {
      strncat(buf,"1:",sz);
      strncat(buf,"<s",sz);
      prettySemInt(size,buf,sz);
      strncat(buf,"(",sz);
      prettySemLin(__RECORD_SELECT(payload,___opnd1),buf,sz);
      strncat(buf,",",sz);
      prettySemLin(__RECORD_SELECT(payload,___opnd2),buf,sz);
      strncat(buf,")",sz);
      break;
    }
    case __SEM_CMPLTU: {
      strncat(buf,"1:",sz);
      strncat(buf,"<u",sz);
      prettySemInt(size,buf,sz);
      strncat(buf,"(",sz);
      prettySemLin(__RECORD_SELECT(payload,___opnd1),buf,sz);
      strncat(buf,",",sz);
      prettySemLin(__RECORD_SELECT(payload,___opnd2),buf,sz);
      strncat(buf,")",sz);
      break;
    }
    default:
      __fatal("Object not of {sem_op} type");
  }
  return (buf);
}

char* prettySemStmt (__obj x, char* buf, __word sz) {
  __obj payload = x->tagged.payload;
  __word tag = x->tagged.tag;
  switch (tag) {
    case __SEM_ASSIGN: {
      __obj lhs = __RECORD_SELECT(payload,___lhs);
      __obj rhs = __RECORD_SELECT(payload,___rhs);
      prettySemVar(lhs,buf,sz);
      strncat(buf," = ",sz);
      prettySemOp(rhs,buf,sz);
      break;
    }
    case __SEM_LOAD: {
      __obj lhs = __RECORD_SELECT(payload,___lhs);
      __obj size = __RECORD_SELECT(payload,___size);
      __obj a = __RECORD_SELECT(payload,___address);
      __obj addressSize = __RECORD_SELECT(a,___size);
      __obj address = __RECORD_SELECT(a,___address);
      prettySemVar(lhs,buf,sz);
      strncat(buf," = ",sz);
      prettySemInt(size,buf,sz);
      strncat(buf,":*",sz);
      prettySemInt(addressSize,buf,sz);
      strncat(buf,"(",sz);
      prettySemLin(address,buf,sz);
      strncat(buf,")",sz);
      break;
    }
    case __SEM_STORE: {
      __obj a = __RECORD_SELECT(payload,___address);
      __obj addressSize = __RECORD_SELECT(a,___size);
      __obj address = __RECORD_SELECT(a,___address);
      __obj rhs = __RECORD_SELECT(payload,___rhs);
      strncat(buf,"*",sz);
      prettySemInt(addressSize,buf,sz);
      strncat(buf,"(",sz);
      prettySemLin(address,buf,sz);
      strncat(buf,") = ",sz);
      prettySemOp(rhs,buf,sz);
      break;
    }
    case __SEM_LABEL: {
      __obj id = __RECORD_SELECT(payload,___id);
      strncat(buf,"l",sz);
      prettySemInt(id,buf,sz);
      strncat(buf,":",sz);
      break;
    }
    case __SEM_IF_GOTO_LABEL: {
      __obj cond = __RECORD_SELECT(payload,___cond);
      __obj label = __RECORD_SELECT(payload,___label);
      strncat(buf,"if (",sz);
      prettySemLin(cond,buf,sz);
      strncat(buf,") goto label l",sz);
      prettySemInt(label,buf,sz);
      break;
    }
    case __SEM_IF_GOTO:
      break;
    case __SEM_CALL:
      break;
    case __SEM_RETURN:
      break;
    default:
      __fatal("Invalid RREIL statement");
  }
  return (buf);
}

char* prettySemantics (__obj x, char* buf, __word sz) {
  __obj payload = x->tagged.payload;
  __word tag = x->tagged.tag;
  switch (tag) {
    case __SEM_CONS: {
      __obj hd = __RECORD_SELECT(payload,___hd);
      __obj tl = __RECORD_SELECT(payload,___tl);
      prettySemStmt(hd,buf,sz);
      strncat(buf,"\n",sz);
      prettySemantics(tl,buf,sz);
      break;
    }
    case __SEM_NIL: break;
    default: __fatal("Invalid RREIL statemtent sequence");
  }
  return (buf);
}

char* pretty (__obj insn, char* buf, __word sz) {
  buf[0] = '\0';
  switch (__TAG(insn)) {
    case __TAGGED: {
      __obj payload = insn->tagged.payload;
      __word tag = __CASETAG(insn);
      if (tag == __SEM_CONS || tag == __SEM_NIL) {
        prettySemantics(insn,buf,sz);
        return (buf);
      } else if (___isNil(payload)) {
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
