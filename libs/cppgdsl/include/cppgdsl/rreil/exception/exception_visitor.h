/*
 * The file contains an implementation of the Visitor Pattern for
 * RReil exceptions.
 */

#pragma once
#include <functional>

namespace gdsl {
namespace rreil {

class arch_exception;
class shared_exception;

class exception_visitor {
 private:
  std::function<void(arch_exception const*)> arch_exception_callback = nullptr;
  std::function<void(shared_exception const*)> shared_exception_callback =
      nullptr;

 public:
  virtual ~exception_visitor() = default;

  virtual void visit(arch_exception const* a) {
    if (arch_exception_callback != nullptr) arch_exception_callback(a);
    _default();
  }
  virtual void visit(shared_exception const* a) {
    if (shared_exception_callback != nullptr) shared_exception_callback(a);
    _default();
  }

  virtual void _default() {}

  void _(std::function<void(arch_exception const*)> c) {
    arch_exception_callback = std::move(c);
  }
  void _(std::function<void(shared_exception const*)> c) {
    shared_exception_callback = std::move(c);
  }
};

}  // namespace rreil
}  // namespace gdsl
