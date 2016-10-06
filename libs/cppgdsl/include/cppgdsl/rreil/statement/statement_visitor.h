/*
 * The file contains an implementation of the Visitor Pattern for
 * RReil statements.
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
  std::function<void(assign const*)> assign_callback = nullptr;
  std::function<void(load const*)> load_callback = nullptr;
  std::function<void(store const*)> store_callback = nullptr;
  std::function<void(ite const*)> ite_callback = nullptr;
  std::function<void(_while const*)> _while_callback = nullptr;
  std::function<void(cbranch const*)> cbranch_callback = nullptr;
  std::function<void(branch const*)> branch_callback = nullptr;
  std::function<void(floating const*)> floating_callback = nullptr;
  std::function<void(prim const*)> prim_callback = nullptr;
  std::function<void(_throw const*)> _throw_callback = nullptr;
  std::function<void(statement const*)> default_callback = nullptr;

 public:
  virtual ~statement_visitor() = default;

  virtual void visit(assign const* a);
  virtual void visit(load const* a);
  virtual void visit(store const* a);
  virtual void visit(ite const* a);
  virtual void visit(_while const* a);
  virtual void visit(cbranch const* a);
  virtual void visit(branch const* a);
  virtual void visit(floating const* a);
  virtual void visit(prim const* a);
  virtual void visit(_throw const* a);
  virtual void _default(statement const* s);

  void _(std::function<void(assign const*)> assign_callback) {
    this->assign_callback = std::move(assign_callback);
  }
  void _(std::function<void(load const*)> load_callback) {
    this->load_callback = std::move(load_callback);
  }
  void _(std::function<void(store const*)> store_callback) {
    this->store_callback = std::move(store_callback);
  }
  void _(std::function<void(ite const*)> ite_callback) {
    this->ite_callback = std::move(ite_callback);
  }
  void _(std::function<void(_while const*)> _while_callback) {
    this->_while_callback = std::move(_while_callback);
  }
  void _(std::function<void(cbranch const*)> cbranch_callback) {
    this->cbranch_callback = std::move(cbranch_callback);
  }
  void _(std::function<void(branch const*)> branch_callback) {
    this->branch_callback = std::move(branch_callback);
  }
  void _(std::function<void(floating const*)> floating_callback) {
    this->floating_callback = std::move(floating_callback);
  }
  void _(std::function<void(prim const*)> prim_callback) {
    this->prim_callback = std::move(prim_callback);
  }
  void _(std::function<void(_throw const*)> _throw_callback) {
    this->_throw_callback = std::move(_throw_callback);
  }
  void _default(std::function<void(statement const*)> default_callback) {
    this->default_callback = std::move(default_callback);
  }
};

}  // namespace rreil
}  // namespace gdsl
