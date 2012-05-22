
#include "pretty.h"

static __obj prettyOpnds(__obj);

static __obj prettyMem (__obj mem) {
  __int sz = __RECORD_SELECT(mem,___sz)->z.value;
  __obj segment = __RECORD_SELECT(mem,___segment);
  __obj opnd = __RECORD_SELECT(mem,___opnd);
  switch (sz) {
    case 8:
      printf("BYTE PTR ");
      break;
    case 16:
      printf("WORD PTR ");
      break;
    case 32:
      printf("DWORD PTR ");
      break;
    case 64:
      printf("QWORD PTR ");
      break;
    case 128:
      printf("DQWORD PTR ");
      break;
    default:
      printf("PTR(%ld) ", sz);
      break;
  }
  prettyOpnds(segment);
  printf(":[");
  prettyOpnds(opnd);
  printf("]");
  return (__UNIT);
}

static __obj prettySum (__obj sum) {
  __obj a = __RECORD_SELECT(sum,___a);
  __obj b = __RECORD_SELECT(sum,___b);
  prettyOpnds(a);
  printf("+");
  return (prettyOpnds(b));
}

static __obj prettyFac (__obj imm) {
  switch (__CASETAG(imm)) {
    case 0: break;
    case 1: printf("2*");break;
    case 2: printf("4*");break;
    case 3: printf("8*");break;
    default: __fatal("invalid scaling factor");
  }
  return (__UNIT);
}

static __obj prettyScale (__obj scale) {
  __obj imm = __RECORD_SELECT(scale,___imm);
  __obj op = __RECORD_SELECT(scale,___opnd);
  prettyFac(imm);
  return (prettyOpnds(op));
}

static __obj prettyOpnds (__obj opnds) {
  switch (__TAG(opnds)) {
    case __TAGGED: {
      __word tag = opnds->tagged.tag;
      __obj payload = opnds->tagged.payload;
      switch (tag) {
        case __MEM:
          return (prettyMem(payload));
        case __REG:
          return (prettyOpnds(payload));
        case __SUM:
          return (prettySum(payload));
        case __SCALE:
          return (prettyScale(payload));
        case __NEARABS:
          printf("NEAR ");
          return (prettyOpnds(payload));
        case __FARABS:
          printf("FAR ");
          return (prettyOpnds(payload));
        case __REL8:
        case __REL16:
        case __REL32:
        case __REL64:
          printf("RELATIVE ");
          return (prettyOpnds(payload));
        case __IMM8:
        case __IMM16:
        case __IMM32:
        case __IMM64:
          return (prettyOpnds(payload));
        default:
          printf("%s", __tagName(tag));
          if (!___isNil(payload)) {
            printf(",");
            return (prettyOpnds(payload));
          }
          return (__UNIT);
      }
    }
    case __RECORD: {
      switch (opnds->record.sz) {
        case 1: {
          __obj op1 = __RECORD_SELECT(opnds,___opnd1);
          return (prettyOpnds(op1));
        }
        case 2: {
          __obj op1 = __RECORD_SELECT(opnds,___opnd1);
          return (prettyOpnds(op1));
        }
        case 3: {
          __obj op1 = __RECORD_SELECT(opnds,___opnd1);
          __obj op2 = __RECORD_SELECT(opnds,___opnd2);
          prettyOpnds(op1);
          printf(",");
          return (prettyOpnds(op2));
        }
        case 4: {
          __obj op1 = __RECORD_SELECT(opnds,___opnd1);
          __obj op2 = __RECORD_SELECT(opnds,___opnd2);
          __obj op3 = __RECORD_SELECT(opnds,___opnd3);
          prettyOpnds(op1);
          printf(",");
          prettyOpnds(op2);
          printf(",");
          return (prettyOpnds(op3));
        }
        case 5: {
          __obj op1 = __RECORD_SELECT(opnds,___opnd1);
          __obj op2 = __RECORD_SELECT(opnds,___opnd2);
          __obj op3 = __RECORD_SELECT(opnds,___opnd3);
          __obj op4 = __RECORD_SELECT(opnds,___opnd4);
          prettyOpnds(op1);
          printf(",");
          prettyOpnds(op2);
          printf(",");
          prettyOpnds(op3);
          printf(",");
          return (prettyOpnds(op4));
        }
        default:
          __fatal("unsupported amount of operands");
      }
    }
    case __BV:
      printf("0x%zx",opnds->bv.vec);
      return (__UNIT);
    case __INT:
      printf("%ld",opnds->z.value);
      return (__UNIT);
    default:
       __fatal("invalid operand");
  }
}

__obj pretty (__obj insn) {
  switch (__TAG(insn)) {
    case __TAGGED: {
      __obj payload = insn->tagged.payload;
      __word tag = __CASETAG(__RECORD_SELECT(payload,___tag));
      switch (__CASETAG(insn)) {
         case __ARITY0:
            printf("%s",__tagName(tag));
            return (__UNIT);
         default:
            printf("%s ",__tagName(tag));
            return (prettyOpnds(payload));
      }
    }
    default:
      __fatal("invalid instruction object");
  }
}

__obj prettyln (__obj insn) {
  pretty(insn);
  printf("\n");
  return (__UNIT);
}

/* vim:cindent
 * vim:ts=2
 * vim:sw=2
 * vim:expandtab */
