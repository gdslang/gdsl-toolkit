#include "cppgdsl/assembly/annotation/string_annotation.h"

namespace gdsl {
namespace assembly {

void gdsl::assembly::string_annotation::put(std::ostream& out) const {
  out << "(ann:" << annotation_ << ")";
}

bool gdsl::assembly::string_annotation::operator==(const annotation& o) const {
  bool equals = false;
  annotation_visitor av(true);
  av._([&](string_annotation const* a) {
    equals = this->annotation_ == a->annotation_;
  });
  o.accept(av);
  return equals;
}

}  // namespace assembly
}  // namespace gdsl
