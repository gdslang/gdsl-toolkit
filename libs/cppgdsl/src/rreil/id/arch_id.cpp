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

size_t gdsl::rreil::arch_id::get_subclass_counter() {
  return subclass_counter;
}

bool gdsl::rreil::arch_id::operator ==(id &other) const {
  bool equals = false;
  id_visitor iv;
  iv._((std::function<void(arch_id*)>)[&](arch_id *aid) {
    equals = this->name == aid->name;
  });
  other.accept(iv);
  return equals;
}

void gdsl::rreil::arch_id::accept(id_visitor &v) {
  v.visit(this);
}
