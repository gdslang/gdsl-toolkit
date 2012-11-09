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
#include <inttypes.h>

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
  Var* lhs;
  Op* rhs;
  Assign(Var* l, Op* r) : lhs(l), rhs(r) {};
public:
  static Assign* build(Var* lhs, Op* rhs) { return new Assign(lhs, rhs); };
  Var& getLhs() const { return *lhs; };
  Op& getRhs() const { return *rhs; };
  void visit(StmtVisitor& v) const { v.accept(*this); };
};

class Load : public Stmt {
  Var* lhs;
  int bitSize;
  Address* rhs;
  Load(Var* lhs, int bitSize, Address* rhs) : lhs(lhs),  bitSize(bitSize),rhs(rhs) {};
public:
  static Load* build(Var* lhs, int bitSize, Address* rhs) { return new Load(lhs, bitSize, rhs); };
  Var& getLhs() const { return *lhs; };
  int getBitSize() const { return bitSize; };
  Address& getRhs() const { return *rhs; };
  void visit(StmtVisitor& v) const { v.accept(*this); };
};

class Store : public Stmt {
  Address* lhs;
  Op* rhs;
  Store(Address* lhs, Op* rhs) : lhs(lhs), rhs(rhs) {};
public:
  static Store* build(Address* lhs, Op* rhs) { return new Store(lhs, rhs); };
  Address& getLhs() const { return *lhs; };
  Op& getRhs() const { return *rhs; };
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
  Lin& getCond() const { return *cond; };
  RReilBB& getThenBranch() const { return *thenBranch; };
  RReilBB& getElseBranch() const { return *elseBranch; };
  void visit(StmtVisitor& v) const { v.accept(*this); };
};

class While : public Stmt {
  Lin* cond;
  RReilBB* body;
  While(Lin* cond, RReilBB* body) : cond(cond), body(body) {};
public:
  static While* build(Lin* cond, RReilBB* body) { return new While(cond, body); };
  Lin& getCond() const { return *cond; };
  RReilBB& getBody() const { return *body; };
  void visit(StmtVisitor& v) const { v.accept(*this); };
};

class CBranch : public Stmt {
  Lin* cond;
  Address* targetT;
  Address* targetF;
  CBranch(Lin* cond, Address* targetT, Address* targetF) : cond(cond), targetT(targetT), targetF(targetF) {};
public:
  static CBranch* build(Lin* cond, Address* targetT, Address* targetF) { return new CBranch(cond, targetT, targetF); };
  Lin& getCond() const { return *cond; };
  Address& getTargetT() const { return *targetT; };
  Address& getTargetF() const { return *targetF; };
  void visit(StmtVisitor& v) const { v.accept(*this); };
};

class Branch : public Stmt {
  BranchHint hint;
  Address* target;
  Branch(BranchHint hint, Address* target) : hint(hint), target(target) {};
public:
  static Branch* build(BranchHint hint, Address* target) { return new Branch(hint, target); };
  BranchHint getBranchHint() const { return hint; };
  Address& getTarget() const { return *target; };
  void visit(StmtVisitor& v) const { v.accept(*this); };
};

/* variables */
class Var {
  int variable;
  int offset;
private:
  Var(int i, int o) : variable(i), offset(o) {};
public:
  inline static Var* temp(int i, int offset);
  inline static Var* build(int i, int offset);
  int getOffset() const { return offset; };
  friend std::ostream& operator<<(std::ostream& o, const Var& v);
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
  static Linear* build(int bitSize, Lin* l) { return new Linear(bitSize, l); };
  int getBitSize() const { return bitSize; };
  Lin& getLin() const { return *lin; };
  void visit(OpVisitor& v) const { v.accept(*this); };
};

class Binary : public Op {
  int bitSize;
  Lin* lhs;
  BinOp op;
  Lin* rhs;
  Binary(int bitSize, Lin* lhs, BinOp op, Lin* rhs) : bitSize(bitSize), lhs(lhs), op(op), rhs(rhs) {};
public:
  static Binary* build(int bitSize, Lin* lhs, BinOp op, Lin* rhs) { return new Binary(bitSize, lhs, op, rhs); };
  Lin& getLhs() const { return *lhs; };
  BinOp getOp() const { return op; };
  Lin& getRhs() const { return *rhs; };
  void visit(OpVisitor& v) const { v.accept(*this); };
};

class SignExtend : public Op {
  int fromSize;
  int toSize;
  Lin* lin;
  SignExtend(int fromSize, int toSize, Lin* lin) : fromSize(fromSize),
  toSize(toSize), lin(lin) {};
public:
  static SignExtend* build(int fromSize, int toSize, Lin* lin) {
    return new SignExtend(fromSize, toSize, lin);
  };
  int getFromSize() const { return fromSize; };
  int getToSize() const { return toSize; };
  Lin& getLin() const { return *lin; };
  void visit(OpVisitor& v) const { v.accept(*this); };
};

class ZeroExtend : public Op {
  int fromSize;
  int toSize;
  Lin* lin;
  ZeroExtend(int fromSize, int toSize, Lin* lin) : fromSize(fromSize),
  toSize(toSize), lin(lin) {};
public:
  static ZeroExtend* build(int fromSize, int toSize, Lin* lin) {
    return new ZeroExtend(fromSize, toSize, lin);
  };
  int getFromSize() const { return fromSize; };
  int getToSize() const { return toSize; };
  Lin& getLin() const { return *lin; };
  void visit(OpVisitor& v) const { v.accept(*this); };
};

class Cmp : public Op {
  int bitSize;
  Lin* lhs;
  CmpOp op;
  Lin* rhs;
  Cmp(int bitSize, Lin* lhs, CmpOp op, Lin* rhs) : bitSize(bitSize), lhs(lhs), op(op), rhs(rhs) {};
public:
  static Cmp* build(int bitSize, Lin* lhs, CmpOp op, Lin* rhs) { return new Cmp(bitSize, lhs, op, rhs); };
  Lin& getLhs() const { return *lhs; };
  CmpOp getOp() const { return op; };
  Lin& getRhs() const { return *rhs; };
  void visit(OpVisitor& v) const { v.accept(*this); };
};

class Arbitrary : public Op {
  int bitSize;
  Arbitrary(int bitSize) : bitSize(bitSize) {};
public:
  static Arbitrary* build(int bitSize) { return new Arbitrary(bitSize); };
  int getBitSize() const { return bitSize; };
  void visit(OpVisitor& v) const { v.accept(*this); };
};

/* linear expressions */

class LinVisitor {
public:
  virtual void accept(const LinVar& l) = 0;
  virtual void accept(const LinImm& l) = 0;
  virtual void accept(const LinAdd& l) = 0;
  virtual void accept(const LinSub& l) = 0;
  virtual void accept(const LinScale& l) = 0;
  virtual void accept(const Address& a) = 0;
};

class Lin {
public:
  virtual void visit(LinVisitor& v) const = 0;
  friend std::ostream& operator<<(std::ostream& o, const Lin& s);
};

class LinVar : public Lin {
  Var* var;
  LinVar(Var* var) : var(var) {};
public:
  static LinVar* build(Var* var) { return new LinVar(var); };
  Var& getVar() const { return *var; };
  void visit(LinVisitor& v) const { v.accept(*this); };
};

class LinImm : public Lin  {
  int64_t imm;
  LinImm(int64_t imm) : imm(imm) {};
public:
  static LinImm* build(int64_t imm) { return new LinImm(imm); };
  int64_t getImm() const { return imm; };
  void visit(LinVisitor& v) const { v.accept(*this); };
};

class LinAdd : public Lin  {
  Lin* lhs;
  Lin* rhs;
  LinAdd(Lin* lhs, Lin* rhs) : lhs(lhs), rhs(rhs) {};
public:
  static LinAdd* build(Lin* lhs, Lin* rhs) { return new LinAdd(lhs, rhs); };
  Lin& getLhs() const { return *lhs; };
  Lin& getRhs() const { return *rhs; };
  void visit(LinVisitor& v) const { v.accept(*this); };
};

class LinSub : public Lin  {
  Lin* lhs;
  Lin* rhs;
  LinSub(Lin* lhs, Lin* rhs) : lhs(lhs), rhs(rhs) {};
public:
  static LinSub* build(Lin* lhs, Lin* rhs) { return new LinSub(lhs, rhs); };
  Lin& getLhs() const { return *lhs; };
  Lin& getRhs() const { return *rhs; };
  void visit(LinVisitor& v) const { v.accept(*this); };
};

class LinScale : public Lin  {
  int64_t fac;
  Lin* lin;
  LinScale(int64_t fac, Lin* lin) : fac(fac), lin(lin) {};
public:
  static LinScale* build(int64_t fac, Lin* lin) { return new LinScale(fac, lin); };
  int64_t getFac() const { return fac; };
  Lin& getLin() const { return *lin; };
  void visit(LinVisitor& v) const { v.accept(*this); };
};

/* addresses */

class Address {
  int bitSize;
  Lin* lin;
  Address(int bitSize, Lin* lin) : bitSize(bitSize), lin(lin) {};
public:
  static Address* build(int bitSize, Lin* lin) { return new Address(bitSize,lin); };
  int getBitSize() const { return bitSize; };
  void visit(LinVisitor& v) const { v.accept(*this); };
  Lin& getLin() const { return *lin; };
  friend std::ostream& operator<<(std::ostream& o, const Address& s);
};

#endif
