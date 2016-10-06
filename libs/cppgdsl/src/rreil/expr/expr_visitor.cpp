#include "cppgdsl/rreil/expr/expr_visitor.h"
#include "cppgdsl/rreil/expr/expr.h"
#include "cppgdsl/rreil/expr/expr_binop.h"
#include "cppgdsl/rreil/expr/expr_ext.h"
#include "cppgdsl/rreil/expr/expr_sexpr.h"

namespace gdsl {
namespace rreil {

void expr_visitor::visit(expr_binop const* a) {
  if (expr_binop_callback != nullptr)
    expr_binop_callback(a);
  else
    _default(a);
}

void expr_visitor::visit(expr_ext const* a) {
  if (expr_ext_callback != nullptr)
    expr_ext_callback(a);
  else
    _default(a);
}

void expr_visitor::visit(expr_sexpr const* a) {
  if (expr_sexpr_callback != nullptr)
    expr_sexpr_callback(a);
  else
    _default(a);
}

void expr_visitor::_default(expr const* e) {
  if (default_callback != nullptr) default_callback(e);
}
}
}
