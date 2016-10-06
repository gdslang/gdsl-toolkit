#include "cppgdsl/rreil/id/arch_id.h"

#include <string>

#include "cppgdsl/rreil/id/id_visitor.h"

using namespace std;

namespace gdsl {
namespace rreil {

void arch_id::put(std::ostream& out) const { out << name; }

size_t arch_id::subclass_counter = id::subclass_counter++;

arch_id::arch_id(std::string name) { this->name = std::move(name); }

size_t arch_id::get_subclass_counter() const { return subclass_counter; }

bool arch_id::operator==(id const& other) const {
  bool equals = false;
  id_visitor iv;
  iv._((std::function<void(arch_id const*)>)([&](arch_id const* aid) {
    equals = this->name == aid->name;
  }));
  other.accept(iv);
  return equals;
}

bool arch_id::operator<(id const& other) const {
  size_t scc_me = subclass_counter;
  size_t scc_other = other.get_subclass_counter();
  if (scc_me == scc_other) {
    arch_id const& other_casted = dynamic_cast<arch_id const&>(other);
    return name.compare(other_casted.name) < 0;
  } else
    return scc_me < scc_other;
}

void arch_id::accept(id_visitor& v) const { v.visit(this); }

std::unique_ptr<id> arch_id::copy() const {
  return std::unique_ptr<id>(new arch_id(*this));
}

}  // namespace rreil
}  // namespace gdsl
