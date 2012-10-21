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

std::ostream& operator<<(std::ostream& o, const RReilBB& s) {
  return o << "basic block of size " << s.size();
};

std::ostream& operator<<(std::ostream& o, const Stmt& s) {
  return o ;
};

std::ostream& operator<<(std::ostream& o, const Op& s) {
  return o ;
};


RReilBB* translateRReilBB(__obj list);
Stmt* translateStmt(__obj instr);

RReilBB* translate(RReilAddress start, RReilAddress limit) {
  __obj semantics;
  __resetHeap();
  __word read = __decode(__translateBlock__, (__char*) start, (__word) (limit-start), &semantics);
  if (read==0) return NULL;
  return translateRReilBB(semantics);
};

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

Stmt* translateStmt(__obj instr) {
  Stmt* s = NULL;
  switch (__CASETAGCON(instr)) {
    case __SEM_ASSIGN: {
      __obj rec = __DECON(instr);
      //s = Assign.build();
    }; break;
  }
  return s;
};

Var* Var::temp(int i, int s) { return new Var(i+ __NTAGS, s); };
Var* Var::build(int i, int s) { return new Var(i, s); };

