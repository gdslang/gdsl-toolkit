#include "cppgdsl/assembly/instruction.h"
#include "cppgdsl/compare.h"

namespace gdsl {
namespace assembly {

bool instruction::operator==(instruction const& o) const {
  return this->length == o.length && this->mnemonic == o.mnemonic &&
         equals(this->annotations, o.annotations) &&
         equals(this->operands, o.operands);
}

std::ostream& operator<<(std::ostream& out, const instruction& _this) {
  out << _this.get_mnemonic() << " (" << _this.get_length() << "b) ";
  bool first = true;
  for (auto const& opnd : _this.get_operands()) {
    if (first)
      first = false;
    else
      out << " ";
    out << opnd;
  }

  auto const& anns = _this.get_annotations();
  if (anns.size() > 0) {
    out << " [";
    first = true;
    for (auto const& ann : anns) {
      if (first)
        first = false;
      else
        out << ", ";
      out << ann;
    }
    out << "]";
  }

  return out;
}

}  // namespace assembly
}  // namespace gds
