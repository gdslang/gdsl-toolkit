/*
 * The file contains an implementation of the Visitor Pattern for
 * RReil simple expressions.
 */

#pragma once
#include <functional>

namespace gdsl {
namespace rreil {

class sexpr;
class arbitrary;
class sexpr_cmp;
class sexpr_lin;

class sexpr_visitor {
 private:
  std::function<void(arbitrary const*)> arbitrary_callback = nullptr;
  std::function<void(sexpr_cmp const*)> sexpr_cmp_callback = nullptr;
  std::function<void(sexpr_lin const*)> sexpr_lin_callback = nullptr;
  std::function<void(sexpr const*)> default_callback = nullptr;

 public:
  virtual ~sexpr_visitor() = default;

  virtual void visit(arbitrary const* a);
  virtual void visit(sexpr_cmp const* a);
  virtual void visit(sexpr_lin const* a);
  virtual void _default(sexpr const* s);

  void _(std::function<void(arbitrary const*)> c) {
    arbitrary_callback = std::move(c);
  }
  void _(std::function<void(sexpr_cmp const*)> c) {
    sexpr_cmp_callback = std::move(c);
  }
  void _(std::function<void(sexpr_lin const*)> c) {
    sexpr_lin_callback = std::move(c);
  }
  void _default(std::function<void(sexpr const*)> c) {
    default_callback = std::move(c);
  }
};

}  // namespace rreil
}  // namespace gdsl
