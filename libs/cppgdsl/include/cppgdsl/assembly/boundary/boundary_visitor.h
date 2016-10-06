/*
 * The file contains an implementation of the Visitor Pattern for
 * ASM boundaries.
 */

#pragma once

#include <functional>
#include <string>

namespace gdsl {
namespace assembly {

class boundary;
class offset_boundary;

class boundary_visitor {
 public:
  using boundary_callback_t = std::function<void(boundary const*)>;
  using offset_boundary_callback_t =
      std::function<void(offset_boundary const*)>;

  boundary_visitor() = default;
  virtual ~boundary_visitor() = default;

#define _VISIT(TYPE)                                    \
  virtual void visit(TYPE const* v) {                   \
    if (TYPE##_callback != nullptr) TYPE##_callback(v); \
  }

#define SET_CALLBACK(TYPE) \
  void _(TYPE##_callback_t c) { TYPE##_callback = std::move(c); }

#define _VISITOR_MEMBERS(TYPE) \
  _VISIT(TYPE)                 \
  SET_CALLBACK(TYPE)

  _VISITOR_MEMBERS(boundary)
  _VISITOR_MEMBERS(offset_boundary)

#undef _VISIT
#undef SET_CALLBACK
#undef _VISITOR_MEMBERS

 private:
  boundary_callback_t boundary_callback = nullptr;
  offset_boundary_callback_t offset_boundary_callback = nullptr;
};

}  // namespace assembly
}  // namespace gdsl
