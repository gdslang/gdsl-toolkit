#include "cppgdsl/assembly/boundary/boundary.h"

namespace gdsl {
namespace assembly {

void boundary::put(std::ostream& out) const { out << get_size(); }

bool boundary::operator==(boundary const& o) const {
  boundary_visitor bv;
  bool is_boundary = false;
  bv._((std::function<void(boundary const*)>) ([&](boundary const* b) {
    is_boundary = true;}));
  o.accept(bv);
  return is_boundary ? size == o.size : o == *this;
}

std::ostream& operator<<(std::ostream& out, const boundary& _this) {
  _this.put(out);
  return out;
}

}  // namespace assembly
}  // namespace gdsl
