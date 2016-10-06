#include "cppgdsl/rreil/expr/expr_ext.h"

#include <iostream>

namespace gdsl {
namespace rreil {

std::string ext_op_to_string(ext_op op) {
  switch (op) {
    case EXT_ZX: {
      return "z";
    }
    case EXT_SX: {
      return "s";
    }
  }
}

void expr_ext::put(std::ostream& out) const {
  out << "[" << ext_op_to_string(op) << "->" << fromsize << "]" << *operand_;
}

expr_ext::expr_ext(ext_op op, int_t fromsize,
                   std::unique_ptr<linear> operand_arg)
    : op(op), fromsize(fromsize), operand_(move(operand_arg)) {}

std::unique_ptr<expr> expr_ext::copy() const {
  return std::unique_ptr<expr>(new expr_ext(*this));
}

void expr_ext::accept(expr_visitor& v) const { v.visit(this); }

bool expr_ext::operator==(expr const& o) const {
  bool is_equal = false;
  expr_visitor v;
  v._([&](expr_ext const* o) {
    is_equal = this->op == o->op && this->fromsize == o->fromsize &&
               *this->operand_ == *o->operand_;
  });
  o.accept(v);
  return is_equal;
}

}  // namespace rreil
}  // namespace gdsl
