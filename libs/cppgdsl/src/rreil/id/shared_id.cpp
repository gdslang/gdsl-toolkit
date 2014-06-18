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

gdsl::rreil::shared_id::shared_id(shared_id_type _id) {
  this->inner = _id;
}

void gdsl::rreil::shared_id::accept(id_visitor &v) {
  v.visit(this);
}
