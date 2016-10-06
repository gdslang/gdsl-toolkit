#include "cppgdsl/assembly/operand/register.h"
#include "cppgdsl/assembly/operand/operand_visitor.h"

namespace gdsl {
namespace assembly {

void register_::put(std::ostream& out) const { out << name; }

void register_::accept(operand_visitor& ov) const { ov.visit(this); }

bool register_::operator==(operand const& o) const {
  bool equals = false;
  operand_visitor v(true);
  v._([&](register_ const* o) { equals = this->name == o->name; });
  o.accept(v);
  return equals;
}

}  // namespace assembly
}  // namespace gdsl
