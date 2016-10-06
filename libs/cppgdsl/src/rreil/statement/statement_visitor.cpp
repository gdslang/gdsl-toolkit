#include "cppgdsl/rreil/statement/statement_visitor.h"
#include "cppgdsl/rreil/rreil.h"

using namespace gdsl::rreil;

void statement_visitor::visit(assign const* a) {
  if (assign_callback != nullptr)
    assign_callback(a);
  else
    _default(a);
}
void statement_visitor::visit(load const* a) {
  if (load_callback != nullptr)
    load_callback(a);
  else
    _default(a);
}
void statement_visitor::visit(store const* a) {
  if (store_callback != nullptr)
    store_callback(a);
  else
    _default(a);
}
void statement_visitor::visit(ite const* a) {
  if (ite_callback != nullptr)
    ite_callback(a);
  else
    _default(a);
}
void statement_visitor::visit(_while const* a) {
  if (_while_callback != nullptr)
    _while_callback(a);
  else
    _default(a);
}
void statement_visitor::visit(cbranch const* a) {
  if (cbranch_callback != nullptr)
    cbranch_callback(a);
  else
    _default(a);
}
void statement_visitor::visit(branch const* a) {
  if (branch_callback != nullptr)
    branch_callback(a);
  else
    _default(a);
}
void statement_visitor::visit(floating const* a) {
  if (floating_callback != nullptr)
    floating_callback(a);
  else
    _default(a);
}
void statement_visitor::visit(prim const* a) {
  if (prim_callback != nullptr)
    prim_callback(a);
  else
    _default(a);
}
void statement_visitor::visit(_throw const* a) {
  if (_throw_callback != nullptr)
    _throw_callback(a);
  else
    _default(a);
}
void statement_visitor::_default(statement const* s) {
  if (default_callback != nullptr) default_callback(s);
}
