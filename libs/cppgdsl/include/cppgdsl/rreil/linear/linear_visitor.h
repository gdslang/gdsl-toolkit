/*
 * The file contains an implementation of the Visitor Pattern for
 * RReil linear expressions.
 */

#pragma once
#include <functional>

namespace gdsl {
namespace rreil {

class lin_binop;
class lin_imm;
class lin_scale;
class lin_var;

class linear_visitor {
 private:
  std::function<void(lin_binop const*)> lin_binop_callback = nullptr;
  std::function<void(lin_imm const*)> lin_imm_callback = nullptr;
  std::function<void(lin_scale const*)> lin_scale_callback = nullptr;
  std::function<void(lin_var const*)> lin_var_callback = nullptr;

 public:
  virtual ~linear_visitor() = default;

  virtual void visit(lin_binop const* a) {
    if (lin_binop_callback != nullptr) lin_binop_callback(a);
    _default();
  }
  virtual void visit(lin_imm const* a) {
    if (lin_imm_callback != nullptr) lin_imm_callback(a);
    _default();
  }
  virtual void visit(lin_scale const* a) {
    if (lin_scale_callback != nullptr) lin_scale_callback(a);
    _default();
  }
  virtual void visit(lin_var const* a) {
    if (lin_var_callback != nullptr) lin_var_callback(a);
    _default();
  }

  virtual void _default() {}

  void _(std::function<void(lin_binop const*)> c) {
    lin_binop_callback = std::move(c);
  }
  void _(std::function<void(lin_imm const*)> c) {
    lin_imm_callback = std::move(c);
  }
  void _(std::function<void(lin_scale const*)> c) {
    lin_scale_callback = std::move(c);
  }
  void _(std::function<void(lin_var const*)> c) {
    lin_var_callback = std::move(c);
  }
};

}  // namespace rreil
}  // namespace gdsl
