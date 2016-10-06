#include "cppgdsl/assembly/operand/composite.h"
#include "cppgdsl/assembly/operand/operand_visitor.h"
#include "cppgdsl/compare.h"

namespace gdsl {
namespace assembly {

void composite::put(std::ostream& out) const {
  out << "[";
  bool first = true;
  for (auto const& opnd : operands) {
    if (first)
      first = false;
    else
      out << ", ";
    out << *opnd;
  }
  out << "]";
}

void composite::accept(operand_visitor& ov) const { ov.visit(this); }

bool composite::operator==(operand const& o) const {
  bool is_equal = false;
  operand_visitor v(true);
  v._([&](composite const* o) {
    is_equal = equals(this->operands, o->operands);
  });
  o.accept(v);
  return is_equal;
}

}  // namespace assembly
}  // namespace gdsl
