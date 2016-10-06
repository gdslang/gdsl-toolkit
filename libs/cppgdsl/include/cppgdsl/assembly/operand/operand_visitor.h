/*
 * The file contains an implementation of the Visitor Pattern for
 * ASM operands.
 */

#pragma once

#include <functional>
#include <string>

namespace gdsl {
namespace assembly {

class operand;
class annotated;
class bounded;
class composite;
class immediate;
class memory;
class post_op;
class pre_op;
class register_;
class rel;
class scale;
class signed_;
class sum;

class operand_visitor {
 public:
  using default_callback_t = std::function<void(void)>;
  using annotated_callback_t = std::function<void(annotated const*)>;
  using bounded_callback_t = std::function<void(bounded const*)>;
  using composite_callback_t = std::function<void(composite const*)>;
  using immediate_callback_t = std::function<void(immediate const*)>;
  using memory_callback_t = std::function<void(memory const*)>;
  using post_op_callback_t = std::function<void(post_op const*)>;
  using pre_op_callback_t = std::function<void(pre_op const*)>;
  using register__callback_t = std::function<void(register_ const*)>;
  using rel_callback_t = std::function<void(rel const*)>;
  using scale_callback_t = std::function<void(scale const*)>;
  using signed__callback_t = std::function<void(signed_ const*)>;
  using sum_callback_t = std::function<void(sum const*)>;

  operand_visitor(bool ignore_default = false)
      : ignore_default(ignore_default) {}
  virtual ~operand_visitor() = default;

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

  _VISITOR_MEMBERS(annotated)
  _VISITOR_MEMBERS(bounded)
  _VISITOR_MEMBERS(composite)
  _VISITOR_MEMBERS(immediate)
  _VISITOR_MEMBERS(memory)
  _VISITOR_MEMBERS(post_op)
  _VISITOR_MEMBERS(pre_op)
  _VISITOR_MEMBERS(register_)
  _VISITOR_MEMBERS(rel)
  _VISITOR_MEMBERS(scale)
  _VISITOR_MEMBERS(signed_)
  _VISITOR_MEMBERS(sum)

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
  annotated_callback_t annotated_callback = nullptr;
  bounded_callback_t bounded_callback = nullptr;
  composite_callback_t composite_callback = nullptr;
  immediate_callback_t immediate_callback = nullptr;
  memory_callback_t memory_callback = nullptr;
  post_op_callback_t post_op_callback = nullptr;
  pre_op_callback_t pre_op_callback = nullptr;
  register__callback_t register__callback = nullptr;
  rel_callback_t rel_callback = nullptr;
  scale_callback_t scale_callback = nullptr;
  signed__callback_t signed__callback = nullptr;
  sum_callback_t sum_callback = nullptr;
};

}  // namespace assembly
}  // namespace gdsl
