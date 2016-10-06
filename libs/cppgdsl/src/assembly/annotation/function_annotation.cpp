#include "cppgdsl/assembly/annotation/function_annotation.h"
#include "cppgdsl/assembly/annotation/annotation_visitor.h"
#include "cppgdsl/compare.h"

namespace gdsl {
namespace assembly {

void function_annotation::put(std::ostream& out) const {
  out << name << "(";
  bool first = true;
  for (auto const& arg : args) {
    if (first)
      first = false;
    else
      out << ", ";
    out << *arg;
  }
  out << ")";
}

bool function_annotation::operator==(annotation const& o) const {
  bool is_equal = false;
  annotation_visitor av(true);
  av._([&](function_annotation const* fa) {
    is_equal = (this->name == fa->name) && equals(this->args, fa->args);
  });
  o.accept(av);
  return is_equal;
}

}  // namespace assembly
}  // namespace gdsl
