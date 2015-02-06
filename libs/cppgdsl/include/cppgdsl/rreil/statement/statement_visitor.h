/*
 * statement_visitor.h
 *
 *  Created on: May 23, 2014
 *      Author: Julian Kranz
 */

#pragma once
#include <functional>

namespace gdsl {
namespace rreil {

class statement;
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
private:
  std::function<void(assign*)> assign_callback = NULL;
  std::function<void(load*)> load_callback = NULL;
  std::function<void(store*)> store_callback = NULL;
  std::function<void(ite*)> ite_callback = NULL;
  std::function<void(_while*)> _while_callback = NULL;
  std::function<void(cbranch*)> cbranch_callback = NULL;
  std::function<void(branch*)> branch_callback = NULL;
  std::function<void(floating*)> floating_callback = NULL;
  std::function<void(prim*)> prim_callback = NULL;
  std::function<void(_throw*)> _throw_callback = NULL;
  std::function<void(statement*)> default_callback = NULL;

public:
  virtual ~statement_visitor() {
  }

  virtual void visit(assign *a);
  virtual void visit(load *a);
  virtual void visit(store *a);
  virtual void visit(ite *a);
  virtual void visit(_while *a);
  virtual void visit(cbranch *a);
  virtual void visit(branch *a);
  virtual void visit(floating *a);
  virtual void visit(prim *a);
  virtual void visit(_throw *a);
  virtual void _default(statement *s);

  void _(std::function<void(assign*)> assign_callback) {
    this->assign_callback = assign_callback;
  }
  void _(std::function<void(load*)> load_callback) {
    this->load_callback = load_callback;
  }
  void _(std::function<void(store*)> store_callback) {
    this->store_callback = store_callback;
  }
  void _(std::function<void(ite*)> ite_callback) {
    this->ite_callback = ite_callback;
  }
  void _(std::function<void(_while*)> _while_callback) {
    this->_while_callback = _while_callback;
  }
  void _(std::function<void(cbranch*)> cbranch_callback) {
    this->cbranch_callback = cbranch_callback;
  }
  void _(std::function<void(branch*)> branch_callback) {
    this->branch_callback = branch_callback;
  }
  void _(std::function<void(floating*)> floating_callback) {
    this->floating_callback = floating_callback;
  }
  void _(std::function<void(prim*)> prim_callback) {
    this->prim_callback = prim_callback;
  }
  void _(std::function<void(_throw*)> _throw_callback) {
    this->_throw_callback = _throw_callback;
  }
  void _default(std::function<void(statement*)> default_callback) {
    this->default_callback = default_callback;
  }
};

}
}
