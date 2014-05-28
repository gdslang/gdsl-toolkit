/*
 * statement_visitor.h
 *
 *  Created on: May 23, 2014
 *      Author: Julian Kranz
 */

#pragma once

namespace gdsl {
namespace rreil {

class assign;
class load;
class store;
class ite;
class _while;
class cbranch;
class branch;
class floating;
class prim;
class _throw;

class statement_visitor {
public:
  virtual ~statement_visitor() {
  }

  virtual void visit(assign *a) {
    _default();
  }
  virtual void visit(load *a) {
    _default();
  }
  virtual void visit(store *a) {
    _default();
  }
  virtual void visit(ite *a) {
    _default();
  }
  virtual void visit(_while *a) {
    _default();
  }
  virtual void visit(cbranch *a) {
    _default();
  }
  virtual void visit(branch *a) {
    _default();
  }
  virtual void visit(floating *a) {
    _default();
  }
  virtual void visit(prim *a) {
    _default();
  }
  virtual void visit(_throw *a) {
    _default();
  }
  virtual void _default() {
  }
};

}
}
