#include "cppgdsl/assembly/operand/memory.h"
#include "cppgdsl/assembly/operand/operand_visitor.h"

namespace gdsl {
namespace assembly {

void memory::put(std::ostream& out) const { out << "*{" << *operand_ << "}"; }

void memory::accept(operand_visitor& ov) const { ov.visit(this); }

bool memory::operator==(operand const& o) const {
  bool equals = false;
  operand_visitor v(true);
  v._([&](memory const* o) { equals = *this->operand_ == *o->operand_; });
  o.accept(v);
  return equals;
}

}  // namespace assembly
}  // namespace gdsl
