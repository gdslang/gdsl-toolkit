#include "cppgdsl/assembly/operand/immediate.h"
#include "cppgdsl/assembly/operand/operand_visitor.h"

namespace gdsl {
namespace assembly {

void immediate::put(std::ostream& out) const { out << imm; }

void immediate::accept(operand_visitor& ov) const { ov.visit(this); }

bool immediate::operator==(operand const& o) const {
  bool equals = false;
  operand_visitor v(true);
  v._([&](immediate const* o) { equals = this->imm == o->imm; });
  o.accept(v);
  return equals;
}

}  // namespace assembly
}  // namespace gdsl
