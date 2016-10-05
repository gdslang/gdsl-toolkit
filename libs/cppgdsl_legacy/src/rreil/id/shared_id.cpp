/*
 * shared_id.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/id/shared_id.h>

using namespace gdsl::rreil;

std::string gdsl::rreil::shared_id_type_to_string(shared_id_type t) {
  switch(t) {
    case TYPE_FLOATING_FLAGS: {
      return "floating_flags";
    }
  }
}

void gdsl::rreil::shared_id::put(std::ostream &out) {
  out << shared_id_type_to_string(this->inner);
}

size_t gdsl::rreil::shared_id::subclass_counter = id::subclass_counter++;

gdsl::rreil::shared_id::shared_id(shared_id_type _id) {
  this->inner = _id;
}

size_t gdsl::rreil::shared_id::get_subclass_counter() const {
  return subclass_counter;
}

bool gdsl::rreil::shared_id::operator==(id &other) const {
  bool equals = false;
  id_visitor iv;
  iv._((std::function<void(shared_id *)>)[&](shared_id * aid) { equals = this->inner == aid->inner; });
  other.accept(iv);
  return equals;
}

bool gdsl::rreil::shared_id::operator<(const id &other) const {
  size_t scc_me = subclass_counter;
  size_t scc_other = other.get_subclass_counter();
  if(scc_me == scc_other) {
    shared_id const &other_casted = dynamic_cast<shared_id const&>(other);
    return inner < other_casted.inner;
  } else
    return scc_me < scc_other;
}

void gdsl::rreil::shared_id::accept(id_visitor &v) {
  v.visit(this);
}
