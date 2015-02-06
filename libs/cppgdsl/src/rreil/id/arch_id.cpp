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

arch_id::arch_id(string name) {
  this->name = name;
}

bool gdsl::rreil::arch_id::operator ==(id &other) {
  bool equals = false;
  id_visitor iv;
  iv._([&](arch_id *aid) {
    equals = this->name == aid->name;
  });
  other.accept(iv);
  return equals;
}

void gdsl::rreil::arch_id::accept(id_visitor &v) {
  v.visit(this);
}
