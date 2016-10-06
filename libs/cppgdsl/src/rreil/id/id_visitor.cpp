#include "cppgdsl/rreil/id/id_visitor.h"
#include "cppgdsl/rreil/id/arch_id.h"
#include "cppgdsl/rreil/id/shared_id.h"
#include "cppgdsl/rreil/id/virtual.h"

namespace gdsl {
namespace rreil {

void id_visitor::visit(arch_id const* a) {
  if (arch_id_callback != nullptr)
    arch_id_callback(a);
  else
    _default(a);
}
void id_visitor::visit(shared_id const* a) {
  if (shared_id_callback != nullptr)
    shared_id_callback(a);
  else
    _default(a);
}
void id_visitor::visit(_virtual const* a) {
  if (_virtual_callback != nullptr)
    _virtual_callback(a);
  else
    _default(a);
}

void gdsl::rreil::id_visitor::_default(id const* i) {
  if (default_callback != nullptr) default_callback(i);
}

}  // namespace rreil
}  // namespace gdsl
