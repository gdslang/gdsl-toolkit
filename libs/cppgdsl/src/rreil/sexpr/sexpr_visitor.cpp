#include "cppgdsl/rreil/sexpr/sexpr_visitor.h"
#include "cppgdsl/rreil/sexpr/arbitrary.h"
#include "cppgdsl/rreil/sexpr/sexpr.h"
#include "cppgdsl/rreil/sexpr/sexpr_cmp.h"
#include "cppgdsl/rreil/sexpr/sexpr_lin.h"

namespace gdsl {
namespace rreil {

void sexpr_visitor::visit(arbitrary const* a) {
  if (arbitrary_callback != nullptr)
    arbitrary_callback(a);
  else
    _default(a);
}
void sexpr_visitor::visit(sexpr_cmp const* a) {
  if (sexpr_cmp_callback != nullptr)
    sexpr_cmp_callback(a);
  else
    _default(a);
}
void sexpr_visitor::visit(sexpr_lin const* a) {
  if (sexpr_lin_callback != nullptr)
    sexpr_lin_callback(a);
  else
    _default(a);
}

void gdsl::rreil::sexpr_visitor::_default(sexpr const* s) {
  if (default_callback != nullptr) default_callback(s);
}

}  // namespace rreil
}  // namespace gdsl
