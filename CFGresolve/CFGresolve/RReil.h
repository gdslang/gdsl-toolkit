//
//  RReil.h
//  CFGresolve
//
//  Created by Axel Simon on 20.10.12.
//  Copyright (c) 2012 Axel Simon. All rights reserved.
//

#ifndef CFGresolve_RReil_h
#define CFGresolve_RReil_h

#include <iostream>
#include <vector>

class RReilBB;
typedef char* RReilAddress;

class Stmt;

enum BranchHint {
  HintJump,
  HintCall,
  HintRet
};

class Assign;
class Load;
class Store;
class IfThenElse;
class While;
class CBranch;
class Branch;

class Var;

class Op;

class Linear;
class Binary;
class SignExtend;
class ZeroExtend;
class Cmp;
class Arbitrary;

enum BinOp {
  Mul,
  Div,
  DivS,
  Mod,
  Shl,
  Shr,
  ShrS,
  And,
  Or,
  Xor
};

enum CmpOp {
  Eq,
  Neq,
  LeS,
  LeU,
  LtS,
  LtU
};

class Lin;

class LinVar;
class LinImm;
class LinAdd;
class LinSub;
class LinScale;

class Address;

/**
 * Disassemble starting from the given address and stop when the limit is reached or a complete basic block
 * has been decoded. Translate decoded instructions to RReil and return this semantic block. Returns NULL
 * if the address contains an illegal instruction or the limit is reached.
 */
RReilBB* translate(RReilAddress start, RReilAddress limit);

class RReilBB : public std::vector<Stmt*> {
protected:
  std::vector<RReilAddress> pred;
  std::vector<RReilAddress> succ;
public:
  std::vector<RReilAddress>::const_iterator pred_iter() {
    return pred.begin();
  };
  std::vector<RReilAddress>::const_iterator succ_iter() {
    return succ.begin();
  };
  void addPred(RReilAddress addr) {
    std::vector<RReilAddress>::iterator iter = std::find(pred.begin(), pred.end(), addr);
    if (iter==pred.end()) pred.push_back(addr);
  };
  void addSucc(RReilAddress addr) {
    std::vector<RReilAddress>::iterator iter = std::find(succ.begin(), succ.end(), addr);
    if (iter==succ.end()) succ.push_back(addr);
  };
  friend std::ostream& operator<<(std::ostream& o, const RReilBB& s);
};

class StmtVisitor {
public:
  virtual void accept(const Assign& s) = 0;
  virtual void accept(const Load& s) = 0;
  virtual void accept(const Store& s) = 0;
  virtual void accept(const IfThenElse& s) = 0;
  virtual void accept(const While& s) = 0;
  virtual void accept(const CBranch& s) = 0;
  virtual void accept(const Branch& s) = 0;
};

class Stmt {
public:
  virtual void visit(StmtVisitor& v) const = 0;  
  friend std::ostream& operator<<(std::ostream& o, const Stmt& s);
};

class Assign : public Stmt {
  const Var* lhs;
  const Op* rhs;
  Assign(Var* l, Op* r) : lhs(l), rhs(r) {};
public:
  static Assign* build(Var* lhs, Op* rhs) { return new Assign(lhs, rhs); };
  void visit(StmtVisitor& v) const { v.accept(*this); };
};

class Load : public Stmt {
  int bitSize;
  Var* lhs;
  Address* rhs;
  Load(int bitSize, Var* lhs, Address* rhs) : bitSize(bitSize), lhs(lhs), rhs(rhs) {};
public:
  static Load* build(int bitSize, Var* lhs, Address* rhs) { return new Load(bitSize, lhs, rhs); };
  void visit(StmtVisitor& v) const { v.accept(*this); };
};

class Store : public Stmt {
  Address* lhs;
  Op* rhs;
  Store(Address* lhs, Op* rhs) : lhs(lhs), rhs(rhs) {};
public:
  static Store* build(Address* lhs, Op* rhs) { return new Store(lhs, rhs); };
  void visit(StmtVisitor& v) const { v.accept(*this); };
};

class IfThenElse : public Stmt {
  Lin* cond;
  RReilBB* thenBranch;
  RReilBB* elseBranch;
  IfThenElse(Lin* cond, RReilBB* thenBranch, RReilBB* elseBranch) :
  cond(cond), thenBranch(thenBranch), elseBranch(elseBranch) {};
public:
  static IfThenElse* build(Lin* cond, RReilBB* thenBranch, RReilBB* elseBranch) {
    return new IfThenElse(cond, thenBranch, elseBranch);
  };
  void visit(StmtVisitor& v) const { v.accept(*this); };
};

class While : public Stmt {
  Lin* cond;
  RReilBB* body;
  While(Lin* cond, RReilBB* body) : cond(cond), body(body) {};
public:
  static While* build(Lin* cond, RReilBB* body) { return new While(cond, body); };
  void visit(StmtVisitor& v) const { v.accept(*this); };
};

class CBranch : public Stmt {
  Lin* cond;
  Address* targetT;
  Address* targetF;
  CBranch(Lin* cond, Address* targetT, Address* targetF) : cond(cond), targetT(targetT), targetF(targetF) {};
public:
  static CBranch* build(Lin* cond, Address* targetT, Address* targetF) { return new CBranch(cond, targetT, targetF); };
  void visit(StmtVisitor& v) const { v.accept(*this); };
};

class Branch : public Stmt {
  BranchHint hint;
  Address* target;
  Branch(BranchHint hint, Address* target) : hint(hint), target(target) {};
public:
  static Branch* build(BranchHint hint, Address* target) { return new Branch(hint, target); };
  void visit(StmtVisitor& v) const { v.accept(*this); };
};

/* variables */
class Var {
  int variable;
  int bitsize;
private:
  Var(int i, int s) : variable(i), bitsize(s) {};
public:
  static Var* temp(int i, int s);
  static Var* build(int i, int s);
};

/* operators */

class OpVisitor {
public:
  virtual void accept(const Linear& op) = 0;
  virtual void accept(const Binary& op) = 0;
  virtual void accept(const SignExtend& op) = 0;
  virtual void accept(const ZeroExtend& op) = 0;
  virtual void accept(const Cmp& op) = 0;
  virtual void accept(const Arbitrary& op) = 0;
};

class Op {
public:
  virtual void visit(OpVisitor& v) const = 0;
  friend std::ostream& operator<<(std::ostream& o, const Op& s);
};

class Linear : public Op {
  int bitSize;
  Lin* lin;
  Linear(int bitSize, Lin* l) : bitSize(bitSize), lin(l) {};
public:
  Linear* build(int bitSize, Lin* l) { return new Linear(bitSize, l); }
  void visit(OpVisitor& v) const { v.accept(*this); };
};

class Binary : public Op {
  int bitSize;
  Lin* lhs;
  BinOp op;
  Lin* rhs;
  Binary(int bitSize, Lin* lhs, BinOp op, Lin* rhs) : bitSize(bitSize), lhs(lhs), op(op), rhs(rhs) {};
public:
  Binary* build(int bitSize, Lin* lhs, BinOp op, Lin* rhs) { return new Binary(bitSize, lhs, op, rhs); };
  void visit(OpVisitor& v) const { v.accept(*this); };
};

class SignExtend : public Op {
  int fromSize;
  int toSize;
  Lin* arg;
  SignExtend(int fromSize, int toSize, Lin* arg) : fromSize(fromSize),
  toSize(toSize), arg(arg) {};
public:
  SignExtend* build(int fromSize, int toSize, Lin* arg) {
    return new SignExtend(fromSize, toSize, arg);
  };
  void visit(OpVisitor& v) const { v.accept(*this); };
};

class ZeroExtend : public Op {
  int fromSize;
  int toSize;
  Lin* arg;
  ZeroExtend(int fromSize, int toSize, Lin* arg) : fromSize(fromSize),
  toSize(toSize), arg(arg) {};
public:
  ZeroExtend* build(int fromSize, int toSize, Lin* arg) {
    return new ZeroExtend(fromSize, toSize, arg);
  };
  void visit(OpVisitor& v) const { v.accept(*this); };
};

class Cmp : public Op {
  int bitSize;
  Lin* lhs;
  CmpOp op;
  Lin* rhs;
  Cmp(int bitSize, Lin* lhs, CmpOp op, Lin* rhs) : bitSize(bitSize), lhs(lhs), op(op), rhs(rhs) {};
public:
  Cmp* build(int bitSize, Lin* lhs, CmpOp op, Lin* rhs) { return new Cmp(bitSize, lhs, op, rhs); };
  void visit(OpVisitor& v) const { v.accept(*this); };
};

class Arbitrary : public Op {
  int bitSize;
  Arbitrary(int bitSize) : bitSize(bitSize) {};
public:
  Arbitrary* build(int bitSize) { return new Arbitrary(bitSize); };
  void visit(OpVisitor& v) const { v.accept(*this); };
};


#endif
