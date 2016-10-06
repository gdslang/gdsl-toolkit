#include "cppgdsl/rreil/id/shared_id.h"

namespace gdsl {
namespace rreil {

std::string shared_id_type_to_string(shared_id_type t) {
  switch (t) {
    case TYPE_FLOATING_FLAGS: {
      return "floating_flags";
    }
  }
}

void shared_id::put(std::ostream& out) const {
  out << shared_id_type_to_string(this->inner);
}

size_t shared_id::subclass_counter = id::subclass_counter++;

shared_id::shared_id(shared_id_type _id) { this->inner = _id; }

size_t shared_id::get_subclass_counter() const { return subclass_counter; }

bool shared_id::operator==(id const& other) const {
  bool equals = false;
  id_visitor iv;
  iv._((std::function<void(shared_id const*)>)([&](shared_id const* aid) {
    equals = this->inner == aid->inner;
  }));
  other.accept(iv);
  return equals;
}

bool shared_id::operator<(id const& other) const {
  size_t scc_me = subclass_counter;
  size_t scc_other = other.get_subclass_counter();
  if (scc_me == scc_other) {
    shared_id const& other_casted = dynamic_cast<shared_id const&>(other);
    return inner < other_casted.inner;
  } else
    return scc_me < scc_other;
}

std::unique_ptr<id> shared_id::copy() const {
  return std::unique_ptr<id>(new shared_id(*this));
}

void shared_id::accept(id_visitor& v) const { v.visit(this); }

}  // namespace rreil
}  // namespace gdsl
