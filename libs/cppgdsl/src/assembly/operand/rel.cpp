#include "cppgdsl/assembly/operand/rel.h"
#include "cppgdsl/assembly/operand/operand_visitor.h"

namespace gdsl {
namespace assembly {

void rel::put(std::ostream& out) const { out << "(IP + " << *operand_ << ")"; }

void rel::accept(operand_visitor& ov) const { ov.visit(this); }

bool rel::operator==(operand const& o) const {
  bool equals = false;
  operand_visitor v(true);
  v._([&](rel const* o) { equals = *this->operand_ == *o->operand_; });
  o.accept(v);
  return equals;
}

}  // namespace assembly
}  // namespace gdsl
