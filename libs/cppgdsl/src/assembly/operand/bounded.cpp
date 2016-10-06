#include "cppgdsl/assembly/operand/bounded.h"
#include "cppgdsl/assembly/operand/operand_visitor.h"
#include "cppgdsl/assembly/boundary/boundary.h"
#include "cppgdsl/assembly/boundary/offset_boundary.h"

namespace gdsl {
namespace assembly {

void bounded::put(std::ostream& out) const {
  out << *operand_ << "[" << *boundary_ << "]";
}

void bounded::accept(operand_visitor& ov) const { ov.visit(this); }

bool bounded::operator==(const operand& o) const {
  bool equals = false;
  operand_visitor v(true);
  v._([&](bounded const* o) {
    equals =
        *this->boundary_ == *o->boundary_ && *this->operand_ == *o->operand_;
  });
  o.accept(v);
  return equals;
}

std::unique_ptr<operand> make_bounded(std::unique_ptr<operand> operand_arg,
                                      int_t size, int_t offset) {
  if (offset != 0)
    return make_bounded(make_boundary(size, offset), std::move(operand_arg));
  else
    return make_bounded(make_boundary(size), std::move(operand_arg));
}

}  // namespace assembly
}  // namespace gdsl
