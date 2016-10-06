#include "cppgdsl/assembly/operand/scale.h"
#include "cppgdsl/assembly/operand/operand_visitor.h"

namespace gdsl {
namespace assembly {

void scale::put(std::ostream& out) const { out << factor << *operand_; }

void scale::accept(operand_visitor& ov) const { ov.visit(this); }

bool scale::operator==(operand const& o) const {
  bool equals = false;
  operand_visitor v(true);
  v._([&](scale const* o) {
    equals = this->factor == o->factor && *this->operand_ == *o->operand_;
  });
  o.accept(v);
  return equals;
}

}  // namespace assembly
}  // namespace gdsl
