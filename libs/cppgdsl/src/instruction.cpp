#include "cppgdsl/instruction.h"

#include <iostream>
#include <memory>
#include <sstream>

namespace gdsl {

instruction::instruction(gdsl* g, obj_t native) {
  this->g = g;
  this->native = native;
}

std::string instruction::to_string() {
  std::stringstream s;
  s << *this;
  return s.str();
}

assembly::instruction instruction::generic_assembly() {
  return g->generic_assembly(native);
}

rreil::statements_t instruction::translate() {
  return g->translate(native);
}

std::ostream& operator<<(std::ostream& out, instruction& _this) {
  out << _this.g->pretty_instruction(_this.native);
  return out;
}

}  // namespace gdsl
