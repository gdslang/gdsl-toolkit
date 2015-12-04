/*
 * arch.cpp
 *
 *  Created on: May 21, 2014
 *      Author: Julian Kranz
 */

#include <cppgdsl/rreil/id/arch_id.h>
#include <cppgdsl/rreil/id/id_visitor.h>
#include <string>

using namespace gdsl::rreil;
using namespace std;

void gdsl::rreil::arch_id::put(std::ostream &out) {
  out << name;
}

size_t gdsl::rreil::arch_id::subclass_counter = id::subclass_counter++;

arch_id::arch_id(string name) {
  this->name = name;
}

size_t gdsl::rreil::arch_id::get_subclass_counter() const {
  return subclass_counter;
}

bool gdsl::rreil::arch_id::operator==(id &other) const {
  bool equals = false;
  id_visitor iv;
  iv._((std::function<void(arch_id *)>)[&](arch_id * aid) { equals = this->name == aid->name; });
  other.accept(iv);
  return equals;
}

bool gdsl::rreil::arch_id::operator<(const id &other) const {
  size_t scc_me = subclass_counter;
  size_t scc_other = other.get_subclass_counter();
  if(scc_me == scc_other) {
    arch_id const &other_casted = dynamic_cast<arch_id const &>(other);
    return name.compare(other_casted.name) < 0;
  } else
    return scc_me < scc_other;
}

void gdsl::rreil::arch_id::accept(id_visitor &v) {
  v.visit(this);
}
