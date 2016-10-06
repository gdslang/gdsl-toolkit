#include "cppgdsl/assembly/operand/pre_op.h"
#include "cppgdsl/assembly/operand/operand_visitor.h"

namespace gdsl {
namespace assembly {

void pre_op::put(std::ostream& out) const {
  out << "(" << *expr << "; " << *operand_ << ")";
}

void pre_op::accept(operand_visitor& ov) const { ov.visit(this); }

bool pre_op::operator==(operand const& o) const {
  bool equals = false;
  operand_visitor v(true);
  v._([&](pre_op const* o) {
    equals = *this->expr == *o->expr && *this->operand_ == *o->operand_;
  });
  o.accept(v);
  return equals;
}

}  // namespace assembly
}  // namespace gdsl
