#include "cppgdsl/assembly/boundary/offset_boundary.h"

namespace gdsl {
namespace assembly {

void offset_boundary::put(std::ostream& out) const {
  out << get_offset() << "/" << get_size();
}

bool offset_boundary::operator==(boundary const& o) const {
  bool equals = false;
  boundary_visitor v;
  v._([&](offset_boundary const* b) {
    equals = get_size() == b->get_size() && this->offset == b->offset;});
  v._((std::function<void(boundary const*)>) ([&](boundary const* b) {
    equals = get_size() == b->get_size() && offset == 0;}));
  o.accept(v);
  return equals && boundary::operator==(o);
}

}  // namespace assembly
}  // namespace gdsl
