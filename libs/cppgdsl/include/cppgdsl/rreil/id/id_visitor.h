/*
 * The file contains an implementation of the Visitor Pattern for
 * RReil IDs.
 */

#pragma once
#include <functional>

namespace gdsl {
namespace rreil {

class arch_id;
class shared_id;
class _virtual;
class id;

class id_visitor {
 private:
  std::function<void(arch_id const*)> arch_id_callback;
  std::function<void(shared_id const*)> shared_id_callback;
  std::function<void(_virtual const*)> _virtual_callback;
  std::function<void(id const*)> default_callback;

 public:
  virtual ~id_visitor() = default;

  virtual void visit(arch_id const* a);
  virtual void visit(shared_id const* a);
  virtual void visit(_virtual const* a);
  virtual void _default(id const* s);

  void _(std::function<void(arch_id const*)> c) {
    arch_id_callback = std::move(c);
  }
  void _(std::function<void(shared_id const*)> c) {
    shared_id_callback = std::move(c);
  }
  void _(std::function<void(_virtual const*)> c) {
    _virtual_callback = std::move(c);
  }
  void _default(std::function<void(id const*)> c) {
    default_callback = std::move(c);
  }
};

}  // namespace rreil
}  // namespace gdsl
