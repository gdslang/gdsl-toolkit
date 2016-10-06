/*
 * The file contains an implementation of the Visitor Pattern for
 * ASM annotations.
 */

#pragma once

#include <algorithm>
#include <functional>
#include <string>

namespace gdsl {
namespace assembly {

class function_annotation;
class operand_annotation;
class string_annotation;

class annotation_visitor {
 public:
  using default_callback_t = std::function<void(void)>;
  using function_annotation_callback_t =
      std::function<void(function_annotation const*)>;
  using operand_annotation_callback_t =
      std::function<void(operand_annotation const*)>;
  using string_annotation_callback_t =
      std::function<void(string_annotation const*)>;

  annotation_visitor(bool ignore_default = false)
      : ignore_default(ignore_default) {}
  virtual ~annotation_visitor() = default;

#define _VISIT(TYPE)                  \
  virtual void visit(TYPE const* v) { \
    if (TYPE##_callback != nullptr)   \
      TYPE##_callback(v);             \
    else                              \
      _default();                     \
  }

#define SET_CALLBACK(TYPE) \
  void _(TYPE##_callback_t c) { TYPE##_callback = std::move(c); }

#define _VISITOR_MEMBERS(TYPE) \
  _VISIT(TYPE)                 \
  SET_CALLBACK(TYPE)

  _VISITOR_MEMBERS(function_annotation)
  _VISITOR_MEMBERS(operand_annotation)
  _VISITOR_MEMBERS(string_annotation)

  virtual void _default() {
    if (default_callback != nullptr)
      default_callback();
    else if (!ignore_default)
      throw std::runtime_error(
          "Expected default handler to be present, but none was set.");
  }

  SET_CALLBACK(default)

#undef _VISIT
#undef SET_CALLBACK
#undef _VISITOR_MEMBERS

 private:
  bool ignore_default;

  default_callback_t default_callback = nullptr;
  function_annotation_callback_t function_annotation_callback = nullptr;
  operand_annotation_callback_t operand_annotation_callback = nullptr;
  string_annotation_callback_t string_annotation_callback = nullptr;
};

}  // namespace assembly
}  // namespace gdsl
