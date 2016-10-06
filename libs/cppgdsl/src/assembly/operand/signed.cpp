#include "cppgdsl/assembly/operand/signed.h"
#include "cppgdsl/assembly/operand/operand_visitor.h"

namespace gdsl {
namespace assembly {

void signed_::put(std::ostream& out) const {
  switch (signedness_) {
    case signedness::SIGNED: {
      out << "SIGNED";
      break;
    }
    case signedness::UNSIGNED: {
      out << "UNSIGNED";
      break;
    }
  }
}

void signed_::accept(operand_visitor& ov) const { ov.visit(this); }

bool signed_::operator==(operand const& o) const {
  bool equals = false;
  operand_visitor v(true);
  v._([&](signed_ const* o) {
    equals =
        this->signedness_ == o->signedness_ && *this->operand_ == *o->operand_;
  });
  o.accept(v);
  return equals;
}

}  // namespace assembly
}  // namespace gdsl
