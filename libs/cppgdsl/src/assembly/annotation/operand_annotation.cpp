#include "cppgdsl/assembly/annotation/operand_annotation.h"
#include "cppgdsl/compare.h"

namespace gdsl {
namespace assembly {

void operand_annotation::put(std::ostream& out) const {
  out << name << "<";
  bool first = true;
  for (auto const& opnd : operands) {
    if (first)
      first = false;
    else
      out << ", ";
    out << *opnd;
  }
  out << ">";
}

bool operand_annotation::operator==(const annotation& o) const {
  bool is_equal = false;
  annotation_visitor av(true);
  av._([&](operand_annotation const* oa) {
    is_equal = (this->name == oa->name) && equals(this->operands, oa->operands);
  });
  o.accept(av);
  return is_equal;
}

}  // namespace assembly
}  // namespace gdsl
