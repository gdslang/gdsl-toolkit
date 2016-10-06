#include "cppgdsl/assembly/annotation/string_annotation.h"
#include "cppgdsl/assembly/operand/annotated.h"
#include "cppgdsl/assembly/operand/operand_visitor.h"

namespace gdsl {
namespace assembly {

void annotated::put(std::ostream& out) const {
  out << "(" << *annotation_ << "| " << *operand_ << ")";
}

void annotated::accept(operand_visitor& ov) const { ov.visit(this); }

bool annotated::operator==(const operand& o) const {
  bool equals = false;
  operand_visitor v(true);
  v._([&](annotated const* o) {
    equals = *this->annotation_ == *o->annotation_ &&
             *this->operand_ == *o->operand_;
  });
  o.accept(v);
  return equals;
}

std::unique_ptr<operand> make_annotated(std::string annotation_arg,
                                        std::unique_ptr<operand> operand_arg) {
  return make_annotated(make_string_annotation(std::move(annotation_arg)),
                        std::move(operand_arg));
}

}  // namespace assembly
}  // namespace gdsl
