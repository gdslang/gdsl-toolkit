/*
 * The file contains an implementation of the Visitor Pattern for
 * RReil expressions.
 */

#pragma once
#include <functional>

namespace gdsl {
namespace rreil {

class expr;
class expr_binop;
class expr_ext;
class expr_sexpr;

class expr_visitor {
 private:
  std::function<void(expr_binop const*)> expr_binop_callback = nullptr;
  std::function<void(expr_ext const*)> expr_ext_callback = nullptr;
  std::function<void(expr_sexpr const*)> expr_sexpr_callback = nullptr;
  std::function<void(expr const*)> default_callback = nullptr;

 public:
  virtual ~expr_visitor() = default;

  virtual void visit(expr_binop const* a);
  virtual void visit(expr_ext const* a);
  virtual void visit(expr_sexpr const* a);
  virtual void _default(expr const* e);

  void _(std::function<void(expr_binop const*)> c) {
    expr_binop_callback = std::move(c);
  }
  void _(std::function<void(expr_ext const*)> c) {
    expr_ext_callback = std::move(c);
  }
  void _(std::function<void(expr_sexpr const*)> c) {
    expr_sexpr_callback = std::move(c);
  }
  void _default(std::function<void(expr const*)> c) {
    default_callback = std::move(c);
  }
};

}  // namespace rreil
}  // namespace gdsl
