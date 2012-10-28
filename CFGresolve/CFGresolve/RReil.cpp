//
//  RReil.cpp
//  CFGresolve
//
//  Created by Axel Simon on 20.10.12.
//  Copyright (c) 2012 Axel Simon. All rights reserved.
//

#include "RReil.h"

#include <assert.h>

extern "C" {
#include "../../dis.h"
}

RReilBB* translateRReilBB(__obj list);
static Stmt* translateStmt(__obj instr);
static Var* translateVar(__obj var);
static Op* translateOp(__obj op);
static Lin* translateLin(__obj lin);
static Address* translateAddr(__obj addr);


RReilBB* translate(RReilAddress start, RReilAddress limit) {
  __obj semantics;
  __resetHeap();
  __word read = __decode(__translateBlock__, (__char*) start, (__word) (limit-start), &semantics);
  if (read==0) return NULL;
  return translateRReilBB(semantics);
};

inline Var* Var::temp(int i, int offset) { return new Var(i+ __NTAGS, offset); };
inline Var* Var::build(int i, int offset) { return new Var(i, offset); };

/* translation of other constructs */

RReilBB* translateRReilBB(__obj list) {
  RReilBB* bb = new RReilBB();
  while (__CASETAGCON(list)==__SEM_CONS) {
    __obj rec = __DECON(list);
    __obj instr = __RECORD_SELECT(rec, ___hd);
    list = __RECORD_SELECT(rec, ___tl);
    Stmt* s = translateStmt(instr);
    bb->push_back(s);
  };
  assert(__CASETAGCON(list)==__SEM_NIL);
  return bb;
};

static Stmt* translateStmt(__obj instr) {
  __obj rec = __DECON(instr);
  switch (__CASETAGCON(instr)) {
    case __SEM_ASSIGN: {
      __obj lhs = __RECORD_SELECT(rec, ___lhs);
      __obj rhs = __RECORD_SELECT(rec, ___rhs);
      return Assign::build(translateVar(lhs), translateOp(rhs));
    };
    case __SEM_LOAD: {
      __obj lhs = __RECORD_SELECT(rec, ___lhs);
      __obj size = __RECORD_SELECT(rec, ___size);
      __obj address = __RECORD_SELECT(rec, ___address);
      return Load::build(translateVar(lhs), (int) __CASETAGINT(size), translateAddr(address));
    };
    case __SEM_STORE: {
      __obj address = __RECORD_SELECT(rec, ___address);
      __obj rhs = __RECORD_SELECT(rec, ___rhs);
      return Store::build(translateAddr(address), translateOp(rhs));
    };
    case __SEM_ITE: {
      __obj cond = __RECORD_SELECT(rec, ___cond);
      __obj thenBranch = __RECORD_SELECT(rec, ___then_branch);
      __obj elseBranch = __RECORD_SELECT(rec, ___else_branch);
      return IfThenElse::build(translateLin(cond), translateRReilBB(thenBranch), translateRReilBB(elseBranch));
    };
    case __SEM_CBRANCH: {
      __obj cond = __RECORD_SELECT(rec, ___cond);
      __obj trueAddr = __RECORD_SELECT(rec, ___target_true);
      __obj falseAddr = __RECORD_SELECT(rec, ___target_false);
      return CBranch::build(translateLin(cond), translateAddr(trueAddr), translateAddr(falseAddr));
    };
    case __SEM_BRANCH: {
      BranchHint h;
      __obj hint = __RECORD_SELECT(rec, ___hint);
      switch (__CASETAGCON(hint)) {
        case __HINT_JUMP: h = HintJump; break;
        case __HINT_CALL: h = HintCall; break;
        case __HINT_RET: h = HintRet; break;
        default: assert(false);
      };
      __obj target = __RECORD_SELECT(rec, ___target);
      return Branch::build(h, translateAddr(target));
    };
  }
  assert(false);
};

static Var* translateVar(__obj var) {
  __obj rec = __DECON(var);
  __obj id = __RECORD_SELECT(rec, ___id);
  __obj offset = __RECORD_SELECT(rec, ___offset);
  if (__CASETAGINT(id) != __VIRT_T)
    return Var::build((int) __CASETAGINT(id), (int) __CASETAGINT(offset));
  __obj tmp = __DECON(id);
  return Var::temp((int) __CASETAGINT(tmp), (int) __CASETAGINT(offset));
};

static Op* translateBinary(__obj rec, BinOp op) {
  __obj size = __RECORD_SELECT(rec, ___size);
  __obj lhs = __RECORD_SELECT(rec, ___opnd1);
  __obj rhs = __RECORD_SELECT(rec, ___opnd2);
  return Binary::build((int) __CASETAGINT(size), translateLin(lhs), op, translateLin(rhs));
};

static Op* translateCmp(__obj rec, CmpOp op) {
  __obj size = __RECORD_SELECT(rec, ___size);
  __obj lhs = __RECORD_SELECT(rec, ___opnd1);
  __obj rhs = __RECORD_SELECT(rec, ___opnd2);
  return Cmp::build((int) __CASETAGINT(size), translateLin(lhs), op, translateLin(rhs));
};

static Op* translateOp(__obj op) {
  __obj rec = __DECON(op);
  switch (__CASETAGCON(op)) {
    case __SEM_LIN: {
      __obj size = __RECORD_SELECT(rec, ___size);
      __obj lin = __RECORD_SELECT(rec, ___opnd1);
      return Linear::build((int) __CASETAGINT(size), translateLin(lin));
    };
    case __SEM_MUL: return translateBinary(rec, Mul);
    case __SEM_DIV: return translateBinary(rec, Div);
    case __SEM_DIVS: return translateBinary(rec, DivS);
    case __SEM_MOD: return translateBinary(rec, Mod);
    case __SEM_SHL: return translateBinary(rec, Shl);
    case __SEM_SHR: return translateBinary(rec, Shr);
    case __SEM_SHRS: return translateBinary(rec, ShrS);
    case __SEM_AND: return translateBinary(rec, And);
    case __SEM_OR: return translateBinary(rec, Or);
    case __SEM_XOR: return translateBinary(rec, Xor);
    case __SEM_SX: {
      __obj size = __RECORD_SELECT(rec, ___size);
      __obj fromSize = __RECORD_SELECT(rec, ___fromsize);
      __obj lin = __RECORD_SELECT(rec, ___opnd1);
      return SignExtend::build((int) __CASETAGINT(fromSize), (int) __CASETAGINT(size), translateLin(lin));
    };
    case __SEM_ZX: {
      __obj size = __RECORD_SELECT(rec, ___size);
      __obj fromSize = __RECORD_SELECT(rec, ___fromsize);
      __obj lin = __RECORD_SELECT(rec, ___opnd1);
      return ZeroExtend::build((int) __CASETAGINT(fromSize), (int) __CASETAGINT(size), translateLin(lin));
    };
    case __SEM_CMPEQ: return translateCmp(rec, Eq);
    case __SEM_CMPNEQ: return translateCmp(rec, Neq);
    case __SEM_CMPLES: return translateCmp(rec, LeS);
    case __SEM_CMPLEU: return translateCmp(rec, LeU);
    case __SEM_CMPLTS: return translateCmp(rec, LtS);
    case __SEM_CMPLTU: return translateCmp(rec, LtU);
    case __SEM_ARB: {
      __obj size = __RECORD_SELECT(rec, ___size);
      return Arbitrary::build((int) __CASETAGINT(size));
    };
  };
  assert(false);
};

static Lin* translateLin(__obj lin) {
  __obj rec = __DECON(lin);
  switch (__CASETAGCON(lin)) {
    case __SEM_LIN_VAR: return LinVar::build(translateVar(rec));
    case __SEM_LIN_IMM: {
      __obj imm = __RECORD_SELECT(rec, ___imm);
      return LinImm::build(__CASETAGINT(imm));
    };
    case __SEM_LIN_ADD: {
      __obj lhs = __RECORD_SELECT(rec, ___opnd1);
      __obj rhs = __RECORD_SELECT(rec, ___opnd2);
      return LinAdd::build(translateLin(lhs), translateLin(rhs));
    };
    case __SEM_LIN_SUB: {
      __obj lhs = __RECORD_SELECT(rec, ___opnd1);
      __obj rhs = __RECORD_SELECT(rec, ___opnd2);
      return LinSub::build(translateLin(lhs), translateLin(rhs));
    };
    case __SEM_LIN_SCALE: {
      __obj imm = __RECORD_SELECT(rec, ___imm);
      __obj lin = __RECORD_SELECT(rec, ___opnd);
      return LinScale::build(__CASETAGINT(imm), translateLin(lin));
    };
  };
  assert(false);
};

static Address* translateAddr(__obj addr) {
  __obj rec = __DECON(addr);
  __obj size = __RECORD_SELECT(rec, ___size);
  __obj lin = __RECORD_SELECT(rec, ___address);
  return Address::build((int) __CASETAGINT(size), translateLin(lin));
};

/* printing */

std::ostream& operator<<(std::ostream& o, const RReilBB& s) {
  RReilBB::const_iterator iter = s.end();
  while (iter!=s.begin()) o << *(*(--iter));
  return o;
};

class PrintStmtVisitor : public StmtVisitor {
  std::ostream& o;
public:
  PrintStmtVisitor(std::ostream& o) : o(o) {};
  void accept(const Assign& s) {
    o << s.getLhs() << " := " << s.getRhs() << std::endl;
  };
  void accept(const Load& s) {
    o << s.getLhs() << " := " << s.getRhs() << std::endl;
  };
  void accept(const Store& s) {
    o << s.getLhs() << " := " << s.getRhs() << std::endl;
  };
  void accept(const IfThenElse& s) {
    o << "if " << s.getCond() << " then" << std::endl;
    o << s.getThenBranch();
    o << "else" << std::endl;
    o << s.getElseBranch();
    o << "fi" << std::endl;
  };
  void accept(const While& s) {
    o << "while " << s.getCond() << " do" << std::endl;
    o << s.getBody();
    o << "end" << std::endl;
  };
  void accept(const CBranch& s) {
    o << "branch (" << s.getCond() << " ? " << s.getTargetT() << " : " << s.getTargetF() << ")" << std::endl;
  };
  void accept(const Branch& s) {
    switch (s.getBranchHint()) {
      case HintCall: o << "call "; break;
      case HintJump: o << "jump "; break;
      case HintRet: o << "return "; break;
      default : assert(false);
    };
    o << s.getTarget() << std::endl;
  };
};

std::ostream& operator<<(std::ostream& o, const Stmt& s) {
  PrintStmtVisitor v = PrintStmtVisitor(o);
  s.visit(v);
  return o;
};

std::ostream& operator<<(std::ostream& o, const Var& v) {
  if (v.variable< __NTAGS) o << __tagName(v.variable); else o << "tmp" << (v.variable-__NTAGS);
  if (v.offset>0) o << "." << v.offset;
  return o;
};

class PrintOpVistor : public OpVisitor {
  std::ostream& o;
public:
  PrintOpVistor(std::ostream& o) : o(o) {};
  void accept(const Linear& op) {
    o << "(" << op.getBitSize() << ")" << op.getLin();
  };
  void accept(const Binary& op) {
    const std::string opNames[] = {
      "*",
      "/u",
      "/s",
      "%",
      "<<",
      ">>u",
      ">>s",
      "&",
      "|",
      "^"
    };
    o << op.getLhs() << " " << opNames[op.getOp()] << " " << op.getRhs();
  };
  void accept(const SignExtend& op) {
    o << "(" << op.getToSize() << ") (signed " << op.getFromSize() << ") " << op.getLin();
  };
  void accept(const ZeroExtend& op) {
    o << "(" << op.getToSize() << ") (unsigned " << op.getFromSize() << ") " << op.getLin();
  };
  void accept(const Cmp& op) {
    const std::string opNames[] = {
      "==",
      "!=",
      "<=s",
      "<=u",
      "<s",
      "<u"
    };
    o << op.getLhs() << " " << opNames[op.getOp()] << " " << op.getRhs();
  };
  void accept(const Arbitrary& op) {
    o << "(" << op.getBitSize() << ") [-oo,oo]";
  };
  
};

std::ostream& operator<<(std::ostream& o, const Op& s) {
  PrintOpVistor v = PrintOpVistor(o);
  s.visit(v);
  return o;
};

class PrintLinVisitor : public LinVisitor {
  std::ostream& o;
  int comp;
public:
  PrintLinVisitor(std::ostream& o) : o(o), comp(0) {};
  void accept(const LinVar& l) {
    o << l.getVar();
  };
  void accept(const LinImm& l) {
    o << l.getImm();
  };
  void accept(const LinAdd& l) {
    int curComp = comp;
    comp = 1;
    if (curComp) o << "(";
    o << l.getLhs() << "+" << l.getRhs();
    if (curComp) o << ")";
  };
  void accept(const LinSub& l) {
    int curComp = comp;
    comp = 1;
    if (curComp) o << "(";
    o << l.getLhs() << "-" << l.getRhs();
    if (curComp) o << ")";
  };
  void accept(const LinScale& l) {
    int curComp = comp;
    comp = 1;
    if (curComp) o << "(";
    o << l.getFac() << "*" << l.getLin();
    if (curComp) o << ")";
  };
  void accept(const Address& a) {
    o << "[(" << a.getBitSize() << ") " << a.getLin() << "]";
  };
};

std::ostream& operator<<(std::ostream& o, const Lin& s) {
  PrintLinVisitor v = PrintLinVisitor(o);
  s.visit(v);
  return o;
};

std::ostream& operator<<(std::ostream& o, const Address& s) {
  PrintLinVisitor v = PrintLinVisitor(o);
  s.visit(v);
  return o;
};


