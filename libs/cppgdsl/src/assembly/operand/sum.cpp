#include "cppgdsl/assembly/operand/sum.h"
#include "cppgdsl/assembly/operand/operand_visitor.h"

namespace gdsl {
namespace assembly {

void sum::put(std::ostream& out) const {
  out << "(" << *lhs << " + " << *rhs << ")";
}

void sum::accept(operand_visitor& ov) const { ov.visit(this); }

bool sum::operator==(operand const& o) const {
  bool equals = false;
  operand_visitor v(true);
  v._([&](sum const* o) {
    equals = *this->lhs == *o->lhs && *this->rhs == *o->rhs;
  });
  o.accept(v);
  return equals;
}

}  // namespace assembly
}  // namespace gdsl
