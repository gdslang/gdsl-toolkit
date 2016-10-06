#include "cppgdsl/assembly/operand/post_op.h"
#include "cppgdsl/assembly/operand/operand_visitor.h"

namespace gdsl {
namespace assembly {

void post_op::put(std::ostream& out) const {
  out << "(" << *operand_ << "; " << *expr << ")";
}

void post_op::accept(operand_visitor& ov) const { ov.visit(this); }

bool post_op::operator==(operand const& o) const {
  bool equals = false;
  operand_visitor v(true);
  v._([&](post_op const* o) {
    equals = *this->expr == *o->expr && *this->operand_ == *o->operand_;
  });
  o.accept(v);
  return equals;
}

}  // namespace assembly
}  // namespace gdsl
